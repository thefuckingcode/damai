package com.taobao.android.dinamicx.view;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.taobao.android.dinamic.R$id;
import com.taobao.android.dinamic.R$layout;
import com.taobao.android.dinamic.log.DinamicLog;
import com.taobao.android.dinamic.view.HandlerTimer;

/* compiled from: Taobao */
public class DXNativeCountDownTimerView extends RelativeLayout {
    public static final int DX_DIGIT_COUNT_DOUBLE = 2;
    public static final int DX_DIGIT_COUNT_SINGLE = 1;
    private static final String TAG = "DCountDownTimerView";
    private TextView colonFirst;
    private TextView colonSecond;
    private TextView colonThird;
    private View countDownTimerContainer;
    private long futureTime;
    private boolean hasRegisterReceiver;
    private TextView hour;
    private int interval = 500;
    private boolean isAttached;
    private boolean isNativeTime = true;
    private final BroadcastReceiver mReceiver = new BroadcastReceiver() {
        /* class com.taobao.android.dinamicx.view.DXNativeCountDownTimerView.AnonymousClass2 */

        public void onReceive(Context context, Intent intent) {
            if (DXNativeCountDownTimerView.this.mTimer != null) {
                String action = intent.getAction();
                if ("android.intent.action.SCREEN_OFF".equals(action)) {
                    DXNativeCountDownTimerView.this.mTimer.stop();
                } else if (!"android.intent.action.USER_PRESENT".equals(action)) {
                } else {
                    if (!DXNativeCountDownTimerView.this.isShown() || DXNativeCountDownTimerView.this.futureTime <= 0) {
                        DXNativeCountDownTimerView.this.mTimer.stop();
                    } else {
                        DXNativeCountDownTimerView.this.mTimer.start();
                    }
                }
            }
        }
    };
    private HandlerTimer mTimer;
    private TextView milli;
    private int milliSecondDigitCount = 1;
    private TextView minute;
    private long offset = 0;
    private OnFinishListener onFinishListener;
    private TextView second;
    private TextView seeMoreView;
    private boolean showMilliSecond;
    private boolean showSeeMoreText;

    /* compiled from: Taobao */
    public interface OnFinishListener {
        void onFinish();
    }

    public DXNativeCountDownTimerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R$layout.homepage_component_count_down_timer_view, this);
        this.hour = (TextView) findViewById(R$id.tv_hours);
        this.minute = (TextView) findViewById(R$id.tv_minutes);
        this.second = (TextView) findViewById(R$id.tv_seconds);
        this.milli = (TextView) findViewById(R$id.tv_milli);
        this.colonFirst = (TextView) findViewById(R$id.tv_colon1);
        this.colonSecond = (TextView) findViewById(R$id.tv_colon2);
        this.colonThird = (TextView) findViewById(R$id.tv_colon3);
        this.countDownTimerContainer = findViewById(R$id.count_down_timer_view_container);
        this.seeMoreView = (TextView) findViewById(R$id.see_more_default);
    }

    public TextView getColonFirst() {
        return this.colonFirst;
    }

    public TextView getColonSecond() {
        return this.colonSecond;
    }

    public TextView getColonThird() {
        return this.colonThird;
    }

    public View getCountDownTimerContainer() {
        return this.countDownTimerContainer;
    }

    public long getFutureTime() {
        return this.futureTime;
    }

    public TextView getHour() {
        return this.hour;
    }

    public long getLastTime() {
        long j;
        if (this.futureTime <= 0) {
            return -1;
        }
        if (this.isNativeTime) {
            j = System.currentTimeMillis();
        } else {
            j = SystemClock.elapsedRealtime() + this.offset;
        }
        return this.futureTime - j;
    }

    public TextView getMilli() {
        return this.milli;
    }

    public TextView getMinute() {
        return this.minute;
    }

    public long getOffset() {
        return this.offset;
    }

    public OnFinishListener getOnFinishListener() {
        return this.onFinishListener;
    }

    public TextView getSecond() {
        return this.second;
    }

    public TextView getSeeMoreView() {
        return this.seeMoreView;
    }

    public HandlerTimer getTimer() {
        int i = this.showMilliSecond ? 50 : 500;
        boolean z = false;
        if (this.interval != i) {
            z = true;
            this.interval = i;
        }
        if (this.mTimer == null || z) {
            this.mTimer = new HandlerTimer((long) this.interval, new Runnable() {
                /* class com.taobao.android.dinamicx.view.DXNativeCountDownTimerView.AnonymousClass1 */

                public void run() {
                    if (DXNativeCountDownTimerView.this.isAttached) {
                        DXNativeCountDownTimerView.this.updateCountView();
                    }
                }
            });
        }
        return this.mTimer;
    }

    public void hideCountDown() {
        if (this.showSeeMoreText) {
            this.seeMoreView.setVisibility(0);
            this.countDownTimerContainer.setVisibility(8);
            return;
        }
        showCountDown();
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.isAttached = true;
        HandlerTimer handlerTimer = this.mTimer;
        if (handlerTimer != null && this.futureTime > 0) {
            handlerTimer.start();
        }
        if (!this.hasRegisterReceiver) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            intentFilter.addAction("android.intent.action.USER_PRESENT");
            getContext().registerReceiver(this.mReceiver, intentFilter);
            this.hasRegisterReceiver = true;
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.isAttached = false;
        HandlerTimer handlerTimer = this.mTimer;
        if (handlerTimer != null) {
            handlerTimer.stop();
        }
        try {
            getContext().unregisterReceiver(this.mReceiver);
            this.hasRegisterReceiver = false;
        } catch (Exception e) {
            DinamicLog.c("DCountDownTimerView", e, new String[0]);
        }
    }

    /* access modifiers changed from: protected */
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        HandlerTimer handlerTimer = this.mTimer;
        if (handlerTimer != null) {
            if (i != 0 || this.futureTime <= 0) {
                handlerTimer.stop();
            } else {
                handlerTimer.start();
            }
        }
    }

    public void setCurrentTime(long j) {
        this.isNativeTime = false;
        this.offset = j - SystemClock.elapsedRealtime();
    }

    public void setFutureTime(long j) {
        this.futureTime = j;
    }

    public void setMilliSecondDigitCount(int i) {
        this.milliSecondDigitCount = i;
    }

    public void setOnFinishListener(OnFinishListener onFinishListener2) {
        this.onFinishListener = onFinishListener2;
    }

    public void setShowMilliSecond(boolean z) {
        this.showMilliSecond = z;
    }

    public void setShowSeeMoreText(boolean z) {
        this.showSeeMoreText = z;
    }

    public void showCountDown() {
        this.seeMoreView.setVisibility(8);
        this.countDownTimerContainer.setVisibility(0);
    }

    @SuppressLint({"SetTextI18n"})
    public void updateCountDownViewTime() {
        if (this.countDownTimerContainer != null) {
            long lastTime = getLastTime();
            if (lastTime > 0) {
                long j = (long) 3600000;
                long j2 = lastTime / j;
                long j3 = lastTime - (j * j2);
                long j4 = (long) 60000;
                long j5 = j3 / j4;
                long j6 = (j3 - (j4 * j5)) / ((long) 1000);
                if (j2 > 99 || j5 > 60 || j6 > 60) {
                    this.hour.setText("99");
                    this.minute.setText("59");
                    this.second.setText("59");
                } else {
                    int i = (int) (j2 / 10);
                    int i2 = (int) (j2 % 10);
                    int i3 = (int) (j6 % 10);
                    TextView textView = this.hour;
                    textView.setText(i + "" + i2);
                    TextView textView2 = this.minute;
                    textView2.setText(((int) (j5 / 10)) + "" + ((int) (j5 % 10)));
                    TextView textView3 = this.second;
                    textView3.setText(((int) (j6 / 10)) + "" + i3);
                }
                showCountDown();
                return;
            }
            hideCountDown();
            this.hour.setText("00");
            this.minute.setText("00");
            this.second.setText("00");
            HandlerTimer handlerTimer = this.mTimer;
            if (handlerTimer != null) {
                handlerTimer.stop();
                this.mTimer = null;
            }
            OnFinishListener onFinishListener2 = this.onFinishListener;
            if (onFinishListener2 != null) {
                onFinishListener2.onFinish();
            }
        }
    }

    @SuppressLint({"SetTextI18n"})
    public void updateCountDownViewTimeWithMilli() {
        if (this.countDownTimerContainer != null) {
            long lastTime = getLastTime();
            if (lastTime > 0) {
                long j = (long) 3600000;
                long j2 = lastTime / j;
                long j3 = lastTime - (j * j2);
                long j4 = (long) 60000;
                long j5 = j3 / j4;
                long j6 = j3 - (j4 * j5);
                long j7 = (long) 1000;
                long j8 = j6 / j7;
                long j9 = (j6 - (j7 * j8)) / ((long) 1);
                if (j2 > 99 || j5 > 60 || j8 > 60 || (j2 == 0 && j5 == 0 && j8 == 0 && j9 == 0)) {
                    this.hour.setText("99");
                    this.minute.setText("59");
                    this.second.setText("59");
                    int i = this.milliSecondDigitCount;
                    if (i == 1) {
                        this.milli.setText("9");
                    } else if (i == 2) {
                        this.milli.setText("99");
                    }
                } else {
                    int i2 = (int) (j2 / 10);
                    int i3 = (int) (j2 % 10);
                    int i4 = (int) (j9 / 100);
                    int i5 = (int) ((j9 % 100) / 10);
                    TextView textView = this.hour;
                    textView.setText(i2 + "" + i3);
                    TextView textView2 = this.minute;
                    textView2.setText(((int) (j5 / 10)) + "" + ((int) (j5 % 10)));
                    TextView textView3 = this.second;
                    textView3.setText(((int) (j8 / 10)) + "" + ((int) (j8 % 10)));
                    int i6 = this.milliSecondDigitCount;
                    if (i6 == 1) {
                        this.milli.setText(String.valueOf(i4));
                    } else if (i6 == 2) {
                        TextView textView4 = this.milli;
                        textView4.setText(i4 + "" + i5);
                    }
                }
                showCountDown();
                return;
            }
            hideCountDown();
            this.hour.setText("00");
            this.minute.setText("00");
            this.second.setText("00");
            int i7 = this.milliSecondDigitCount;
            if (i7 == 1) {
                this.milli.setText("0");
            } else if (i7 == 2) {
                this.milli.setText("00");
            }
            HandlerTimer handlerTimer = this.mTimer;
            if (handlerTimer != null) {
                handlerTimer.stop();
                this.mTimer = null;
            }
            OnFinishListener onFinishListener2 = this.onFinishListener;
            if (onFinishListener2 != null) {
                onFinishListener2.onFinish();
            }
        }
    }

    public void updateCountView() {
        if (this.showMilliSecond) {
            updateCountDownViewTimeWithMilli();
        } else {
            updateCountDownViewTime();
        }
    }

    public DXNativeCountDownTimerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public DXNativeCountDownTimerView(Context context) {
        super(context);
        init();
    }
}
