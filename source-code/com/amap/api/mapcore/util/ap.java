package com.amap.api.mapcore.util;

import android.content.Context;
import android.graphics.PointF;
import android.view.MotionEvent;

/* compiled from: Taobao */
public class ap extends aj {
    private static final PointF p = new PointF();
    private final a n;
    private boolean o;
    private PointF q;
    private PointF r;
    private PointF s = new PointF();
    private PointF t = new PointF();

    /* compiled from: Taobao */
    public interface a {
        void a(ap apVar);

        boolean b(ap apVar);
    }

    /* compiled from: Taobao */
    public static class b implements a {
        @Override // com.amap.api.mapcore.util.ap.a
        public void a(ap apVar) {
        }

        @Override // com.amap.api.mapcore.util.ap.a
        public boolean b(ap apVar) {
            return true;
        }
    }

    public ap(Context context, a aVar) {
        super(context);
        this.n = aVar;
    }

    /* access modifiers changed from: protected */
    @Override // com.amap.api.mapcore.util.ak
    public void a(int i, MotionEvent motionEvent, int i2, int i3) {
        if (i == 5) {
            a();
            this.g = MotionEvent.obtain(motionEvent);
            this.k = 0;
            a(motionEvent);
            boolean c = c(motionEvent, i2, i3);
            this.o = c;
            if (!c) {
                this.f = this.n.b(this);
            }
        }
    }

    public float d() {
        return this.s.x;
    }

    public float e() {
        return this.s.y;
    }

    /* access modifiers changed from: protected */
    @Override // com.amap.api.mapcore.util.ak
    public void a(int i, MotionEvent motionEvent) {
        if (i == 3) {
            a();
        } else if (i == 6) {
            a(motionEvent);
            if (!this.o) {
                this.n.a(this);
            }
            a();
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.amap.api.mapcore.util.ak
    public void a() {
        super.a();
        this.o = false;
        PointF pointF = this.s;
        pointF.x = 0.0f;
        PointF pointF2 = this.t;
        pointF2.x = 0.0f;
        pointF.y = 0.0f;
        pointF2.y = 0.0f;
    }

    /* access modifiers changed from: protected */
    @Override // com.amap.api.mapcore.util.ak, com.amap.api.mapcore.util.aj
    public void a(MotionEvent motionEvent) {
        PointF pointF;
        super.a(motionEvent);
        MotionEvent motionEvent2 = this.g;
        this.q = ak.b(motionEvent);
        this.r = ak.b(motionEvent2);
        if (this.g.getPointerCount() != motionEvent.getPointerCount()) {
            pointF = p;
        } else {
            PointF pointF2 = this.q;
            float f = pointF2.x;
            PointF pointF3 = this.r;
            pointF = new PointF(f - pointF3.x, pointF2.y - pointF3.y);
        }
        this.t = pointF;
        PointF pointF4 = this.s;
        pointF4.x += pointF.x;
        pointF4.y += pointF.y;
    }
}
