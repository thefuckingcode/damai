package com.taobao.android.purchase.core.dinamcX.view;

import android.content.Context;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;

/* compiled from: Taobao */
public class CountDownTextView extends AppCompatTextView {
    private long mBeginTime = -1;
    private a mCountDownTimer;
    private long mCountInterval = 1;
    private String mIdleText = "";
    private OnFinishListener mOnFinishListener;
    private long mTimeInFuture = 60;

    /* compiled from: Taobao */
    public interface OnFinishListener {
        void onFinish(CountDownTextView countDownTextView);
    }

    /* compiled from: Taobao */
    public class a extends CountDownTimer {
        public a(long j, long j2) {
            super(j, j2);
        }

        public void onFinish() {
            if (CountDownTextView.this.mOnFinishListener != null) {
                CountDownTextView.this.mOnFinishListener.onFinish(CountDownTextView.this);
            }
            CountDownTextView countDownTextView = CountDownTextView.this;
            countDownTextView.setText(countDownTextView.mIdleText);
            CountDownTextView.this.mCountDownTimer = null;
        }

        public void onTick(long j) {
            CountDownTextView.this.setText(String.valueOf(Math.round(((float) j) / 1000.0f)));
        }
    }

    public CountDownTextView(Context context) {
        super(context);
    }

    public boolean isCountDowning() {
        return this.mBeginTime > 0 && this.mCountDownTimer != null;
    }

    public void setCountInterval(long j) {
        this.mCountInterval = j;
    }

    public void setIdleText(String str) {
        this.mIdleText = str;
        if (this.mCountDownTimer == null && str != null) {
            setText(str);
        }
    }

    public void setOnFinishListener(OnFinishListener onFinishListener) {
        this.mOnFinishListener = onFinishListener;
    }

    public void setTimeInFuture(long j) {
        this.mTimeInFuture = j;
    }

    public void startCount(long j) {
        if (j != this.mBeginTime) {
            this.mBeginTime = j;
            startCount();
        }
    }

    private void startCount() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = this.mBeginTime;
        long j2 = currentTimeMillis - j;
        long j3 = this.mTimeInFuture;
        long j4 = (j3 * 1000) - j2;
        long j5 = this.mCountInterval;
        if (j3 > j5 && j5 > 0 && j > 0 && j2 / 1000 < j3) {
            a aVar = this.mCountDownTimer;
            if (aVar != null) {
                aVar.cancel();
                this.mCountDownTimer = null;
            }
            a aVar2 = new a(j4, this.mCountInterval * 1000);
            this.mCountDownTimer = aVar2;
            aVar2.start();
        }
    }

    public CountDownTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CountDownTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
