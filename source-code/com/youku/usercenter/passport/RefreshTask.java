package com.youku.usercenter.passport;

import android.content.Context;
import com.youku.usercenter.passport.util.Logger;
import java.util.Timer;
import java.util.TimerTask;

/* compiled from: Taobao */
public class RefreshTask {
    public static final long STOKEN_CHECK_INTERVAL = 1500000;
    private static final int STOKEN_REFRESH_INTERVAL = 20;
    private Context mContext;
    private TimerTask mRefreshTask = new TimerTask() {
        /* class com.youku.usercenter.passport.RefreshTask.AnonymousClass1 */

        public void run() {
            RefreshTask.this.refreshSToken();
        }
    };
    private Timer mTimer;

    public RefreshTask(Context context) {
    }

    public void refreshSToken() {
        Logger.d("refreshSToken task excute!");
        PassportManager.getInstance().getAccount().refreshSToken();
    }

    public void start() {
        Timer timer = this.mTimer;
        if (timer != null) {
            timer.cancel();
            this.mTimer.purge();
        }
        TimerTask timerTask = this.mRefreshTask;
        if (timerTask != null) {
            timerTask.cancel();
        }
        this.mTimer = new Timer();
        AnonymousClass2 r2 = new TimerTask() {
            /* class com.youku.usercenter.passport.RefreshTask.AnonymousClass2 */

            public void run() {
                RefreshTask.this.refreshSToken();
            }
        };
        this.mRefreshTask = r2;
        try {
            this.mTimer.schedule(r2, 1200000, 1200000);
        } catch (Throwable th) {
            Logger.printStackTrace(th);
        }
    }

    public void stop() {
        Timer timer = this.mTimer;
        if (timer != null) {
            timer.cancel();
            this.mTimer.purge();
        }
        TimerTask timerTask = this.mRefreshTask;
        if (timerTask != null) {
            timerTask.cancel();
        }
        this.mTimer = null;
        this.mRefreshTask = null;
    }
}
