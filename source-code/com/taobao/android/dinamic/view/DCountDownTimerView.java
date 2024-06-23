package com.taobao.android.dinamic.view;

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

/* compiled from: Taobao */
public class DCountDownTimerView extends RelativeLayout {
    private static final String TAG = "DCountDownTimerView";
    private TextView colonFirst;
    private TextView colonSecond;
    private View countDownTimerContainer;
    private long futureTime;
    private boolean hasRegisterReceiver;
    private TextView hour;
    private boolean isAttached;
    private boolean isNativeTime = true;
    private final BroadcastReceiver mReceiver = new BroadcastReceiver() {
        /* class com.taobao.android.dinamic.view.DCountDownTimerView.AnonymousClass2 */

        public void onReceive(Context context, Intent intent) {
            if (DCountDownTimerView.this.mTimer != null) {
                String action = intent.getAction();
                if ("android.intent.action.SCREEN_OFF".equals(action)) {
                    DCountDownTimerView.this.mTimer.stop();
                } else if (!"android.intent.action.USER_PRESENT".equals(action)) {
                } else {
                    if (!DCountDownTimerView.this.isShown() || DCountDownTimerView.this.futureTime <= 0) {
                        DCountDownTimerView.this.mTimer.stop();
                    } else {
                        DCountDownTimerView.this.mTimer.start();
                    }
                }
            }
        }
    };
    private HandlerTimer mTimer;
    private TextView minute;
    private long offset = 0;
    private TextView second;
    private TextView seeMoreView;

    public DCountDownTimerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R$layout.homepage_component_count_down_timer_view, this);
        this.hour = (TextView) findViewById(R$id.tv_hours);
        this.minute = (TextView) findViewById(R$id.tv_minutes);
        this.second = (TextView) findViewById(R$id.tv_seconds);
        this.colonFirst = (TextView) findViewById(R$id.tv_colon1);
        this.colonSecond = (TextView) findViewById(R$id.tv_colon2);
        this.countDownTimerContainer = findViewById(R$id.count_down_timer_view_container);
        this.seeMoreView = (TextView) findViewById(R$id.see_more_default);
    }

    public TextView getColonFirst() {
        return this.colonFirst;
    }

    public TextView getColonSecond() {
        return this.colonSecond;
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

    public TextView getMinute() {
        return this.minute;
    }

    public TextView getSecond() {
        return this.second;
    }

    public TextView getSeeMoreView() {
        return this.seeMoreView;
    }

    public HandlerTimer getTimer() {
        if (this.mTimer == null) {
            this.mTimer = new HandlerTimer(1000, new Runnable() {
                /* class com.taobao.android.dinamic.view.DCountDownTimerView.AnonymousClass1 */

                public void run() {
                    if (DCountDownTimerView.this.isAttached) {
                        DCountDownTimerView.this.updateCountDownViewTime();
                    }
                }
            });
        }
        return this.mTimer;
    }

    public void hideCountDown() {
        this.seeMoreView.setVisibility(0);
        this.countDownTimerContainer.setVisibility(8);
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

    public void showCountDown() {
        this.seeMoreView.setVisibility(8);
        this.countDownTimerContainer.setVisibility(0);
    }

    public void updateCountDownViewTime() {
        long j;
        long j2;
        long j3;
        if (this.countDownTimerContainer != null) {
            long lastTime = getLastTime();
            if (lastTime > 0) {
                long j4 = (long) 3600000;
                j2 = lastTime / j4;
                long j5 = lastTime - (j4 * j2);
                long j6 = (long) 60000;
                j = j5 / j6;
                j3 = (j5 - (j6 * j)) / ((long) 1000);
            } else {
                j3 = 0;
                j2 = 0;
                j = 0;
            }
            if (j2 > 99 || j > 60 || j3 > 60 || (j2 == 0 && j == 0 && j3 == 0)) {
                this.countDownTimerContainer.setVisibility(8);
                this.seeMoreView.setVisibility(0);
                return;
            }
            int i = (int) (j3 % 10);
            TextView textView = this.hour;
            textView.setText(((int) (j2 / 10)) + "" + ((int) (j2 % 10)));
            this.minute.setText(((int) (j / 10)) + "" + ((int) (j % 10)));
            this.second.setText(((int) (j3 / 10)) + "" + i);
            this.countDownTimerContainer.setVisibility(0);
            this.seeMoreView.setVisibility(8);
        }
    }

    public DCountDownTimerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public DCountDownTimerView(Context context) {
        super(context);
        init();
    }
}
