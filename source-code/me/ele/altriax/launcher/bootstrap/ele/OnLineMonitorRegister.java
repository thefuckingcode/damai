package me.ele.altriax.launcher.bootstrap.ele;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.taobao.android.task.Coordinator;
import com.taobao.application.common.Apm;
import com.taobao.application.common.b;
import com.youku.danmaku.engine.danmaku.model.android.DanmakuFactory;
import me.ele.altriax.launcher.bootstrap.ele.delegate.RegisterDelegate;

/* compiled from: Taobao */
public class OnLineMonitorRegister implements RegisterDelegate {
    private static final String CATEGORY_CALLBACK = "callback";
    private static final String CATEGORY_DELAY = "delay";
    private static final int DELAY_MSG_ACC_BOOT_FINISHED = 3500;
    private static final long DELAY_MSG_BOOT_FINISHED = 6000;
    private static final int MSG_ACCURATE_BOOT_FINISHED = 2;
    private static final int MSG_ACCURATE_BOOT_FINISHED_APM = 3;
    private static final int MSG_BOOT_FINISHED = 1;
    private static final String TAG = "OnLineMonitorRegister";
    private static final byte[] sLockAcurateBootFinish = new byte[0];
    private static final byte[] sLockBootFinish = new byte[0];
    private long durationAfterAccBootFinished = 0;
    @SuppressLint({"HandlerLeak"})
    private Handler mHandler = new Handler() {
        /* class me.ele.altriax.launcher.bootstrap.ele.OnLineMonitorRegister.AnonymousClass2 */

        public void handleMessage(Message message) {
            int i = message.what;
            final boolean z = true;
            if (i == 1) {
                if (OnLineMonitorRegister.this.mOnBootFinishedListener != null) {
                    Coordinator.postTask(new Coordinator.TaggedRunnable("OnBootFinished-HandleMessage") {
                        /* class me.ele.altriax.launcher.bootstrap.ele.OnLineMonitorRegister.AnonymousClass2.AnonymousClass1 */

                        public void run() {
                            synchronized (OnLineMonitorRegister.sLockBootFinish) {
                                if (!OnLineMonitorRegister.this.mIsBootFinished) {
                                    OnLineMonitorRegister.this.mIsBootFinished = true;
                                    OnLineMonitorRegister.this.mOnBootFinishedListener.onBootFinished(false);
                                }
                            }
                        }
                    });
                }
            } else if (i == 2 || i == 3) {
                if (i != 3) {
                    z = false;
                }
                if (OnLineMonitorRegister.this.mOnBootFinishedListener != null) {
                    Coordinator.postTask(new Coordinator.TaggedRunnable("OnAccurateBootFinished-HandleMessage") {
                        /* class me.ele.altriax.launcher.bootstrap.ele.OnLineMonitorRegister.AnonymousClass2.AnonymousClass2 */

                        public void run() {
                            OnLineMonitorRegister.this.scheduleIdle(OnLineMonitorRegister.CATEGORY_DELAY, z);
                        }
                    });
                }
            }
        }
    };
    private volatile boolean mIsAccurateBootFinished = false;
    volatile boolean mIsBootFinished = false;
    private Apm.OnAppLaunchListener mOnAppLaunchListener = new Apm.OnAppLaunchListener() {
        /* class me.ele.altriax.launcher.bootstrap.ele.OnLineMonitorRegister.AnonymousClass1 */

        @Override // com.taobao.application.common.IAppLaunchListener
        public void onLaunchChanged(int i, int i2) {
            String str = OnLineMonitorRegister.TAG;
            Log.e(str, "type:" + i + "  status:" + i2);
            if (i == 0 && i2 == 4) {
                OnLineMonitorRegister.this.scheduleIdle("callback", true);
            }
        }
    };
    public OnBootFinishedListener mOnBootFinishedListener;

    /* compiled from: Taobao */
    public interface OnBootFinishedListener {
        void onBootFinished(boolean z);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void scheduleIdle(String str, boolean z) {
        synchronized (sLockAcurateBootFinish) {
            if (!this.mIsAccurateBootFinished) {
                this.mIsAccurateBootFinished = true;
                String str2 = TAG;
                Log.e(str2, "scheduleIdle:" + str + ", isApm:" + z);
                this.mHandler.removeMessages(z ? 3 : 2);
                StringBuilder sb = new StringBuilder();
                sb.append("mOnBootFinishedListener != null:");
                sb.append(this.mOnBootFinishedListener != null);
                Log.e(str2, sb.toString());
                OnBootFinishedListener onBootFinishedListener = this.mOnBootFinishedListener;
                if (onBootFinishedListener != null) {
                    onBootFinishedListener.onBootFinished(true);
                    if (z) {
                        this.mHandler.sendEmptyMessageDelayed(1, this.durationAfterAccBootFinished);
                    }
                }
            }
        }
    }

    @Override // me.ele.altriax.launcher.bootstrap.ele.delegate.RegisterDelegate
    public void register() {
        boolean z = b.d().getBoolean("isApm", false);
        Log.e(TAG, "isApm:" + z);
        b.b(this.mOnAppLaunchListener);
        if (this.mHandler != null) {
            long j = DELAY_MSG_BOOT_FINISHED;
            long j2 = 3500;
            int i = b.d().getInt("oldDeviceScore", 60);
            if (i >= 75 && i < 90) {
                j2 = 5500;
                j = 6500;
            } else if (i < 75) {
                j = DanmakuFactory.DEFAULT_DANMAKU_DURATION;
                j2 = 6500;
            }
            this.durationAfterAccBootFinished = j - j2;
            if (!z) {
                this.mHandler.sendEmptyMessageDelayed(2, j2);
                this.mHandler.sendEmptyMessageDelayed(1, j);
                return;
            }
            this.mHandler.sendEmptyMessageDelayed(3, j2);
        }
    }
}
