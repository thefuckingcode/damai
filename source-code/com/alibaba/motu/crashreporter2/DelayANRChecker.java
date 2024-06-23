package com.alibaba.motu.crashreporter2;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.youku.danmaku.engine.danmaku.model.android.DanmakuFactory;
import java.util.List;

/* compiled from: Taobao */
public class DelayANRChecker {
    private static final int STATUS_EXCEPTION = -1;
    private static final int STATUS_MY = 1;
    private static final int STATUS_OTHER = 2;
    private static String lastLongMsg;

    /* compiled from: Taobao */
    public interface Callback {
        void onMyANRHappened();

        void onOtherANRHappened();
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class LoopChecker implements Runnable {
        final Callback callback;
        final Context context;
        int count;

        public LoopChecker(int i, Context context2, Callback callback2) {
            this.count = i;
            this.context = context2;
            this.callback = callback2;
        }

        public void run() {
            this.count--;
            if (DelayANRChecker.forceCheckStatus(this.context) == 1) {
                this.callback.onMyANRHappened();
            } else if (this.count > 0) {
                new Handler().postDelayed(this, 500);
            } else {
                this.callback.onOtherANRHappened();
            }
        }
    }

    private static void doInnerCheck(Context context, Callback callback) {
        new Handler().post(new LoopChecker(20, context, callback));
    }

    /* access modifiers changed from: private */
    public static int forceCheckStatus(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager == null) {
            return -1;
        }
        List<ActivityManager.ProcessErrorStateInfo> processesInErrorState = activityManager.getProcessesInErrorState();
        if (processesInErrorState != null) {
            for (ActivityManager.ProcessErrorStateInfo processErrorStateInfo : processesInErrorState) {
                if (processErrorStateInfo.pid == Process.myPid() && processErrorStateInfo.condition == 2 && !TextUtils.equals(lastLongMsg, processErrorStateInfo.longMsg)) {
                    lastLongMsg = processErrorStateInfo.longMsg;
                    return 1;
                }
            }
        }
        return 2;
    }

    private static boolean isMainThreadBlocked() {
        Message nextMessage = MessageMaker.nextMessage();
        if (nextMessage == null) {
            return false;
        }
        long when = nextMessage.getWhen();
        if (when >= 100 && SystemClock.uptimeMillis() - when >= DanmakuFactory.DEFAULT_DANMAKU_DURATION_V) {
            return true;
        }
        return false;
    }

    public static void performAnrCheck(Context context, Callback callback) {
        if (callback != null) {
            try {
                if (isMainThreadBlocked()) {
                    callback.onMyANRHappened();
                    return;
                }
                LastAnrStatusManager.instance().makeIdle();
                doInnerCheck(context, callback);
            } catch (Exception unused) {
            }
        }
    }
}
