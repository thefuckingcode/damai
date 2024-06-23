package com.taomai.android.h5container.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ProgressBar;

/* compiled from: Taobao */
public class H5Progress extends ProgressBar {
    public static final int DEFAULT_DURATION = 1200;
    public static final int MIN_DURATION = 300;
    public static final String TAG = "H5Progress";
    private long curDuration;
    private boolean isRunnableWorking = false;
    private int lastProgress;
    private int lastTarget;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private UpdateRunnable mUpdateRunnable = new UpdateRunnable();
    private long minDuration;
    private int nextVisibility;
    private ProgressNotifier notifier;
    private long originTime;
    private long startTime;
    private int targetProgress;

    /* compiled from: Taobao */
    public interface ProgressNotifier {
        void onProgressBegin();

        void onProgressEnd();
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class UpdateRunnable implements Runnable {
        private int deltaProgress;
        private int period;

        UpdateRunnable() {
        }

        public void run() {
            H5Progress.this.isRunnableWorking = true;
            int max = H5Progress.this.getMax();
            if (max == 0) {
                H5Progress.this.mHandler.removeCallbacks(this);
                H5Progress.this.isRunnableWorking = false;
                return;
            }
            long currentTimeMillis = System.currentTimeMillis() - H5Progress.this.startTime;
            if ((H5Progress.this.curDuration * ((long) this.deltaProgress)) / ((long) max) == 0) {
                H5Progress.this.mHandler.removeCallbacks(this);
                H5Progress.this.isRunnableWorking = false;
                return;
            }
            int i = H5Progress.this.lastTarget + ((int) ((currentTimeMillis * ((long) this.deltaProgress)) / H5Progress.this.curDuration));
            if (i > H5Progress.this.targetProgress) {
                if (i > H5Progress.this.getMax() && H5Progress.this.notifier != null) {
                    H5Progress.this.notifier.onProgressEnd();
                }
                if (H5Progress.this.nextVisibility != -1) {
                    H5Progress h5Progress = H5Progress.this;
                    H5Progress.super.setVisibility(h5Progress.nextVisibility);
                    H5Progress.this.nextVisibility = -1;
                }
            } else {
                if (H5Progress.this.lastProgress == 0 && H5Progress.this.notifier != null) {
                    H5Progress.this.notifier.onProgressBegin();
                }
                H5Progress.this.setProgress(i);
                H5Progress.this.lastProgress = i;
            }
            if (i > H5Progress.this.targetProgress) {
                if (i > H5Progress.this.getMax()) {
                    H5Progress.this.reset();
                }
                H5Progress.this.mHandler.removeCallbacks(this);
                H5Progress.this.isRunnableWorking = false;
                return;
            }
            H5Progress.this.mHandler.postDelayed(this, (long) this.period);
        }

        public void setPeriodValue(int i) {
            this.period = i;
        }

        public void setdeltaProgressValue(int i) {
            this.deltaProgress = i;
        }
    }

    public H5Progress(Context context) {
        super(context);
        init();
    }

    private void init() {
        this.minDuration = 1200;
        setMax(100);
        this.nextVisibility = -1;
        reset();
    }

    private void linearProgress() {
        if (isIndeterminate()) {
            Log.d(TAG, "isIndeterminate");
            return;
        }
        this.curDuration = this.minDuration;
        if (this.targetProgress == getMax() && this.lastTarget > getMax() / 2) {
            this.curDuration = 300;
        }
        int i = this.targetProgress - this.lastTarget;
        if (i > 0) {
            long j = this.curDuration;
            if (j > 0) {
                int i2 = (int) (j / ((long) i));
                this.mHandler.removeCallbacks(this.mUpdateRunnable);
                this.mUpdateRunnable.setPeriodValue(i2);
                this.mUpdateRunnable.setdeltaProgressValue(i);
                this.mHandler.postDelayed(this.mUpdateRunnable, (long) i2);
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void reset() {
        this.originTime = 0;
        this.targetProgress = 0;
        this.lastTarget = 0;
        this.lastProgress = 0;
    }

    public void hideAndResetProgress() {
        hideProgress();
        reset();
    }

    public void hideProgress() {
        Log.d(TAG, "hideProgress");
        super.setVisibility(8);
    }

    public void setMinDuration(long j) {
        this.minDuration = j;
    }

    public void setNotifier(ProgressNotifier progressNotifier) {
        this.notifier = progressNotifier;
    }

    public void setVisibility(int i) {
        Log.d(TAG, "setVisibility:" + i);
        if (!this.isRunnableWorking || i == 0) {
            super.setVisibility(i);
        } else {
            this.nextVisibility = i;
        }
    }

    public void showProgress() {
        super.setVisibility(0);
    }

    public void updateProgress(int i) {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.originTime == 0) {
            this.originTime = currentTimeMillis;
        }
        int max = getMax();
        int i2 = (int) ((((double) i) * 0.25d) + (((double) max) * 0.75d));
        int i3 = this.lastProgress;
        if (i2 >= i3 && i2 <= max) {
            this.lastTarget = i3;
            this.startTime = currentTimeMillis;
            this.targetProgress = i2;
            linearProgress();
        }
    }

    public H5Progress(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public H5Progress(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }
}
