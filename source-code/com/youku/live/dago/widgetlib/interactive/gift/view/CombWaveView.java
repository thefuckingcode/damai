package com.youku.live.dago.widgetlib.interactive.gift.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: Taobao */
public class CombWaveView extends View {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<Circle> mCircleList = new ArrayList();
    private Runnable mCreateCircle = new Runnable() {
        /* class com.youku.live.dago.widgetlib.interactive.gift.view.CombWaveView.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        public void run() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "958703357")) {
                ipChange.ipc$dispatch("958703357", new Object[]{this});
            } else if (CombWaveView.this.mIsRunning) {
                CombWaveView.this.newCircle();
                CombWaveView combWaveView = CombWaveView.this;
                combWaveView.postDelayed(combWaveView.mCreateCircle, (long) CombWaveView.this.mSpeed);
            }
        }
    };
    private long mDuration = 2000;
    private float mInitialRadius;
    private Interpolator mInterpolator = new LinearInterpolator();
    private boolean mIsRunning;
    private long mLastCreateTime;
    private float mMaxRadius;
    private float mMaxRadiusRate = 0.85f;
    private boolean mMaxRadiusSet;
    private Paint mPaint = new Paint(1);
    private int mSpeed = 500;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public class Circle {
        private long mCreateTime = System.currentTimeMillis();

        Circle() {
        }

        /* access modifiers changed from: package-private */
        public int getAlpha() {
            return (int) (255.0f - (CombWaveView.this.mInterpolator.getInterpolation(((getCurrentRadius() - CombWaveView.this.mInitialRadius) / (CombWaveView.this.mMaxRadius - CombWaveView.this.mInitialRadius)) * 5.0f) * 255.0f));
        }

        /* access modifiers changed from: package-private */
        public float getCurrentRadius() {
            return CombWaveView.this.mInitialRadius + (CombWaveView.this.mInterpolator.getInterpolation((((float) (System.currentTimeMillis() - this.mCreateTime)) * 1.0f) / ((float) CombWaveView.this.mDuration)) * (CombWaveView.this.mMaxRadius - CombWaveView.this.mInitialRadius));
        }
    }

    public CombWaveView(Context context) {
        super(context);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void newCircle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1449134139")) {
            ipChange.ipc$dispatch("-1449134139", new Object[]{this});
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.mLastCreateTime >= ((long) this.mSpeed)) {
            this.mCircleList.add(new Circle());
            invalidate();
            this.mLastCreateTime = currentTimeMillis;
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1599506867")) {
            ipChange.ipc$dispatch("1599506867", new Object[]{this, canvas});
            return;
        }
        Iterator<Circle> it = this.mCircleList.iterator();
        while (it.hasNext()) {
            Circle next = it.next();
            float currentRadius = next.getCurrentRadius();
            if (System.currentTimeMillis() - next.mCreateTime < this.mDuration) {
                this.mPaint.setAlpha(next.getAlpha());
                canvas.drawCircle((float) (getWidth() / 2), (float) (getHeight() / 2), currentRadius, this.mPaint);
            } else {
                it.remove();
            }
        }
        if (this.mCircleList.size() > 0) {
            postInvalidateDelayed(10);
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1890620417")) {
            ipChange.ipc$dispatch("1890620417", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
        } else if (!this.mMaxRadiusSet) {
            this.mMaxRadius = (((float) Math.min(i, i2)) * this.mMaxRadiusRate) / 2.0f;
        }
    }

    public void setColor(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "969997999")) {
            ipChange.ipc$dispatch("969997999", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.mPaint.setColor(i);
    }

    public void setDuration(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-842641883")) {
            ipChange.ipc$dispatch("-842641883", new Object[]{this, Long.valueOf(j)});
            return;
        }
        this.mDuration = j;
    }

    public void setInitialRadius(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1262776703")) {
            ipChange.ipc$dispatch("1262776703", new Object[]{this, Float.valueOf(f)});
            return;
        }
        this.mInitialRadius = f;
    }

    public void setInterpolator(Interpolator interpolator) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1312688327")) {
            ipChange.ipc$dispatch("-1312688327", new Object[]{this, interpolator});
            return;
        }
        this.mInterpolator = interpolator;
        if (interpolator == null) {
            this.mInterpolator = new LinearInterpolator();
        }
    }

    public void setMaxRadius(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1427073377")) {
            ipChange.ipc$dispatch("-1427073377", new Object[]{this, Float.valueOf(f)});
            return;
        }
        this.mMaxRadius = f;
        this.mMaxRadiusSet = true;
    }

    public void setMaxRadiusRate(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "496098719")) {
            ipChange.ipc$dispatch("496098719", new Object[]{this, Float.valueOf(f)});
            return;
        }
        this.mMaxRadiusRate = f;
    }

    public void setPaintWidth(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1244907285")) {
            ipChange.ipc$dispatch("1244907285", new Object[]{this, Float.valueOf(f)});
            return;
        }
        this.mPaint.setStrokeWidth(f);
    }

    public void setSpeed(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1641528723")) {
            ipChange.ipc$dispatch("1641528723", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.mSpeed = i;
    }

    public void setStyle(Paint.Style style) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-47773042")) {
            ipChange.ipc$dispatch("-47773042", new Object[]{this, style});
            return;
        }
        this.mPaint.setStyle(style);
    }

    public void start() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-128904013")) {
            ipChange.ipc$dispatch("-128904013", new Object[]{this});
        } else if (!this.mIsRunning) {
            this.mIsRunning = true;
            this.mCreateCircle.run();
        }
    }

    public void stop() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-268456109")) {
            ipChange.ipc$dispatch("-268456109", new Object[]{this});
            return;
        }
        this.mIsRunning = false;
    }

    public void stopImmediately() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2067515591")) {
            ipChange.ipc$dispatch("-2067515591", new Object[]{this});
            return;
        }
        this.mIsRunning = false;
        this.mCircleList.clear();
        invalidate();
    }

    public CombWaveView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
