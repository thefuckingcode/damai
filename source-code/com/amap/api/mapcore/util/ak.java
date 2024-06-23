package com.amap.api.mapcore.util;

import android.content.Context;
import android.graphics.PointF;
import android.os.Build;
import android.view.MotionEvent;

/* compiled from: Taobao */
public abstract class ak {
    protected final Context e;
    protected boolean f;
    protected MotionEvent g;
    protected MotionEvent h;
    protected float i;
    protected float j;
    protected long k;
    protected int l = 0;
    protected int m = 0;

    public ak(Context context) {
        this.e = context;
    }

    public void a(int i2, int i3) {
        this.l = i2;
        this.m = i3;
    }

    /* access modifiers changed from: protected */
    public abstract void a(int i2, MotionEvent motionEvent);

    /* access modifiers changed from: protected */
    public abstract void a(int i2, MotionEvent motionEvent, int i3, int i4);

    public long b() {
        return this.k;
    }

    public MotionEvent c() {
        return this.h;
    }

    public boolean d(MotionEvent motionEvent, int i2, int i3) {
        int action = motionEvent.getAction() & 255;
        if (!this.f) {
            a(action, motionEvent, i2, i3);
            return true;
        }
        a(action, motionEvent);
        return true;
    }

    public static PointF b(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        float f2 = 0.0f;
        float f3 = 0.0f;
        for (int i2 = 0; i2 < pointerCount; i2++) {
            f2 += motionEvent.getX(i2);
            f3 += motionEvent.getY(i2);
        }
        float f4 = (float) pointerCount;
        return new PointF(f2 / f4, f3 / f4);
    }

    /* access modifiers changed from: protected */
    public void a(MotionEvent motionEvent) {
        MotionEvent motionEvent2 = this.g;
        MotionEvent motionEvent3 = this.h;
        if (motionEvent3 != null) {
            motionEvent3.recycle();
            this.h = null;
        }
        this.h = MotionEvent.obtain(motionEvent);
        this.k = motionEvent.getEventTime() - motionEvent2.getEventTime();
        if (Build.VERSION.SDK_INT >= 8) {
            this.i = motionEvent.getPressure(motionEvent.getActionIndex());
            this.j = motionEvent2.getPressure(motionEvent2.getActionIndex());
            return;
        }
        this.i = motionEvent.getPressure(0);
        this.j = motionEvent2.getPressure(0);
    }

    /* access modifiers changed from: protected */
    public void a() {
        MotionEvent motionEvent = this.g;
        if (motionEvent != null) {
            motionEvent.recycle();
            this.g = null;
        }
        MotionEvent motionEvent2 = this.h;
        if (motionEvent2 != null) {
            motionEvent2.recycle();
            this.h = null;
        }
        this.f = false;
    }
}
