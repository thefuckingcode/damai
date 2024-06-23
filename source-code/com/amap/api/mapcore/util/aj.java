package com.amap.api.mapcore.util;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.ViewConfiguration;

/* compiled from: Taobao */
public abstract class aj extends ak {
    protected float a;
    protected float b;
    protected float c;
    protected float d;
    private final float n;
    private float o;
    private float p;
    private float q;
    private float r;
    private float s = 0.0f;
    private float t = 0.0f;
    private float u = 0.0f;
    private float v = 0.0f;

    public aj(Context context) {
        super(context);
        this.n = (float) ViewConfiguration.get(context).getScaledEdgeSlop();
    }

    protected static float b(MotionEvent motionEvent, int i, int i2) {
        float y = (((float) i2) + motionEvent.getY()) - motionEvent.getRawY();
        if (i < motionEvent.getPointerCount()) {
            return motionEvent.getY(i) + y;
        }
        return 0.0f;
    }

    /* access modifiers changed from: protected */
    @Override // com.amap.api.mapcore.util.ak
    public void a(MotionEvent motionEvent) {
        super.a(motionEvent);
        MotionEvent motionEvent2 = this.g;
        int pointerCount = motionEvent2.getPointerCount();
        int pointerCount2 = motionEvent.getPointerCount();
        if (pointerCount2 == 2 && pointerCount2 == pointerCount) {
            this.q = -1.0f;
            this.r = -1.0f;
            float x = motionEvent2.getX(0);
            float y = motionEvent2.getY(0);
            float x2 = motionEvent2.getX(1);
            float y2 = motionEvent2.getY(1);
            this.a = x2 - x;
            this.b = y2 - y;
            float x3 = motionEvent.getX(0);
            float y3 = motionEvent.getY(0);
            float x4 = motionEvent.getX(1);
            float y4 = motionEvent.getY(1);
            this.c = x4 - x3;
            this.d = y4 - y3;
            this.s = x3 - x;
            this.t = y3 - y;
            this.u = x4 - x2;
            this.v = y4 - y2;
        }
    }

    /* access modifiers changed from: protected */
    public boolean c(MotionEvent motionEvent, int i, int i2) {
        int i3;
        int i4 = this.l;
        if (i4 == 0 || (i3 = this.m) == 0) {
            DisplayMetrics displayMetrics = this.e.getResources().getDisplayMetrics();
            float f = this.n;
            this.o = ((float) com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(displayMetrics)) - f;
            this.p = ((float) com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getheightPixels(displayMetrics)) - f;
        } else {
            float f2 = this.n;
            this.o = ((float) i4) - f2;
            this.p = ((float) i3) - f2;
        }
        float f3 = this.n;
        float f4 = this.o;
        float f5 = this.p;
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        float a2 = a(motionEvent, 1, i);
        float b2 = b(motionEvent, 1, i2);
        boolean z = rawX < f3 || rawY < f3 || rawX > f4 || rawY > f5;
        boolean z2 = a2 < f3 || b2 < f3 || a2 > f4 || b2 > f5;
        if ((!z || !z2) && !z && !z2) {
            return false;
        }
        return true;
    }

    public PointF a(int i) {
        if (i == 0) {
            return new PointF(this.s, this.t);
        }
        return new PointF(this.u, this.v);
    }

    protected static float a(MotionEvent motionEvent, int i, int i2) {
        float x = (((float) i2) + motionEvent.getX()) - motionEvent.getRawX();
        if (i < motionEvent.getPointerCount()) {
            return motionEvent.getX(i) + x;
        }
        return 0.0f;
    }
}
