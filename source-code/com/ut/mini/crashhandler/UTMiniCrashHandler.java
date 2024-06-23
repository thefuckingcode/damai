package com.ut.mini.crashhandler;

import android.content.Context;
import android.os.Process;
import com.alibaba.analytics.utils.Logger;
import com.alibaba.motu.tbrest.rest.RestConstants;
import com.alipay.mobile.bqcscanservice.BQCCameraParam;
import com.ut.mini.UTAnalytics;
import com.ut.mini.UTTracker;
import com.ut.mini.crashhandler.UTExceptionParser;
import com.ut.mini.internal.UTOriginalCustomHitBuilder;
import java.lang.Thread;
import java.util.HashMap;
import java.util.Map;
import me.ele.altriax.launcher.real.time.data.biz.BizTime;

/* compiled from: Taobao */
public class UTMiniCrashHandler implements Thread.UncaughtExceptionHandler {
    private static final String TAG = "UTCrashHandler";
    private static volatile boolean mCrashing = false;
    private static UTMiniCrashHandler s_instance = new UTMiniCrashHandler();
    private Context mContext = null;
    private Thread.UncaughtExceptionHandler mDefaultHandler = null;
    private boolean mIsTurnOff = true;
    private IUTCrashCaughtListner mListener = null;

    private UTMiniCrashHandler() {
    }

    private void _initialize() {
        if (this.mIsTurnOff) {
            this.mDefaultHandler = Thread.getDefaultUncaughtExceptionHandler();
            Thread.setDefaultUncaughtExceptionHandler(this);
            this.mIsTurnOff = false;
        }
    }

    public static UTMiniCrashHandler getInstance() {
        return s_instance;
    }

    public boolean isTurnOff() {
        return this.mIsTurnOff;
    }

    public void setCrashCaughtListener(IUTCrashCaughtListner iUTCrashCaughtListner) {
        this.mListener = iUTCrashCaughtListner;
    }

    public void turnOff() {
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.mDefaultHandler;
        if (uncaughtExceptionHandler != null) {
            Thread.setDefaultUncaughtExceptionHandler(uncaughtExceptionHandler);
            this.mDefaultHandler = null;
        }
        this.mIsTurnOff = true;
    }

    public void turnOn(Context context) {
        _initialize();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x009e, code lost:
        if (r1 != null) goto L_0x00a9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00a7, code lost:
        if (r1 == null) goto L_0x00ad;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00a9, code lost:
        r1.uncaughtException(r12, r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00ad, code lost:
        android.os.Process.killProcess(android.os.Process.myPid());
        java.lang.System.exit(10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:?, code lost:
        return;
     */
    public void uncaughtException(Thread thread, Throwable th) {
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler;
        try {
            if (mCrashing) {
                Thread.UncaughtExceptionHandler uncaughtExceptionHandler2 = this.mDefaultHandler;
                if (uncaughtExceptionHandler2 != null) {
                    uncaughtExceptionHandler2.uncaughtException(thread, th);
                    return;
                }
                Process.killProcess(Process.myPid());
                System.exit(10);
                return;
            }
            mCrashing = true;
            if (th != null) {
                Logger.i("Caught Exception By UTCrashHandler.Please see log as follows!", new Object[0]);
                th.printStackTrace();
            }
            UTExceptionParser.UTExceptionItem parse = UTExceptionParser.parse(th);
            if (!(parse == null || parse.mCrashDetail == null || parse.getExpName() == null || parse.getMd5() == null)) {
                Map<String, String> map = null;
                IUTCrashCaughtListner iUTCrashCaughtListner = this.mListener;
                if (iUTCrashCaughtListner != null) {
                    try {
                        map = iUTCrashCaughtListner.onCrashCaught(thread, th);
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                    }
                }
                if (map == null) {
                    map = new HashMap<>();
                }
                map.put("StackTrace", parse.getCrashDetail());
                UTOriginalCustomHitBuilder uTOriginalCustomHitBuilder = new UTOriginalCustomHitBuilder(BizTime.UT, 1, parse.getMd5(), parse.getExpName(), null, map);
                uTOriginalCustomHitBuilder.setProperty(RestConstants.LogContentKeys.PRIORITY, "5");
                uTOriginalCustomHitBuilder.setProperty(RestConstants.PrivateLogFields.SEND_LOG_SYNC, BQCCameraParam.VALUE_YES);
                UTTracker defaultTracker = UTAnalytics.getInstance().getDefaultTracker();
                if (defaultTracker != null) {
                    defaultTracker.send(uTOriginalCustomHitBuilder.build());
                } else {
                    Logger.i("Record crash stacktrace error", "Fatal Error,must call setRequestAuthentication method first.");
                }
            }
            uncaughtExceptionHandler = this.mDefaultHandler;
        } catch (Throwable th3) {
            if (this.mDefaultHandler != null) {
                this.mDefaultHandler.uncaughtException(thread, th);
            } else {
                Process.killProcess(Process.myPid());
                System.exit(10);
            }
            throw th3;
        }
    }
}
