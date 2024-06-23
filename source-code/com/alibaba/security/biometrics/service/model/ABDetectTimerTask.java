package com.alibaba.security.biometrics.service.model;

import java.util.Timer;
import java.util.TimerTask;

/* compiled from: Taobao */
public class ABDetectTimerTask {
    private int mDelay = 1000;
    private int mInitTime;
    private int mInternal = 1000;
    private int mTimeout;
    private Timer mTimer;
    private TimerListener mTimerTaskListener;

    /* compiled from: Taobao */
    public interface TimerListener {
        void countdown(int i);
    }

    public ABDetectTimerTask(int i) {
        this.mInitTime = i;
        this.mTimeout = i;
    }

    static /* synthetic */ int access$010(ABDetectTimerTask aBDetectTimerTask) {
        int i = aBDetectTimerTask.mTimeout;
        aBDetectTimerTask.mTimeout = i - 1;
        return i;
    }

    public boolean isTimeOut() {
        return this.mTimeout == 0;
    }

    public void reset() {
        this.mTimeout = this.mInitTime;
    }

    public void setTimerTaskListener(TimerListener timerListener) {
        this.mTimerTaskListener = timerListener;
    }

    public void start() {
        int i = this.mInitTime;
        this.mTimeout = i;
        TimerListener timerListener = this.mTimerTaskListener;
        if (timerListener != null) {
            timerListener.countdown(i);
        }
        stop();
        Timer timer = new Timer();
        this.mTimer = timer;
        timer.schedule(new TimerTask() {
            /* class com.alibaba.security.biometrics.service.model.ABDetectTimerTask.AnonymousClass1 */

            public void run() {
                ABDetectTimerTask.access$010(ABDetectTimerTask.this);
                if (ABDetectTimerTask.this.mTimeout <= 0) {
                    ABDetectTimerTask.this.mTimeout = 0;
                    if (ABDetectTimerTask.this.mTimer != null) {
                        ABDetectTimerTask.this.mTimer.cancel();
                        ABDetectTimerTask.this.mTimer = null;
                    }
                }
                if (ABDetectTimerTask.this.mTimerTaskListener != null) {
                    ABDetectTimerTask.this.mTimerTaskListener.countdown(ABDetectTimerTask.this.mTimeout);
                }
            }
        }, (long) this.mDelay, (long) this.mInternal);
    }

    public void stop() {
        this.mTimeout = this.mInitTime;
        Timer timer = this.mTimer;
        if (timer != null) {
            timer.cancel();
            this.mTimer = null;
        }
    }
}
