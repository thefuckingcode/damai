package com.amap.api.mapcore.util;

import android.content.Context;
import android.graphics.Point;
import android.graphics.PointF;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.GestureDetector;
import android.view.MotionEvent;
import com.amap.api.mapcore.util.al;
import com.amap.api.mapcore.util.am;
import com.amap.api.mapcore.util.ao;
import com.amap.api.mapcore.util.ap;
import com.amap.api.maps.model.AMapGestureListener;
import com.autonavi.base.ae.gmap.gesture.EAMapPlatformGestureInfo;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.mapcore.message.HoverGestureMapMessage;
import com.autonavi.base.amap.mapcore.message.MoveGestureMapMessage;
import com.autonavi.base.amap.mapcore.message.RotateGestureMapMessage;
import com.autonavi.base.amap.mapcore.message.ScaleGestureMapMessage;

/* compiled from: Taobao */
public class p {
    IAMapDelegate a;
    Context b;
    GestureDetector c;
    public AMapGestureListener d;
    private ao e;
    private am f;
    private al g;
    private ap h;
    private boolean i = false;
    private int j = 0;
    private int k = 0;
    private int l = 0;
    private int m = 0;
    private int n = 0;
    private boolean o = false;
    private boolean p = false;
    private boolean q = true;
    private int r;
    private int s;
    private Handler t = new Handler(Looper.getMainLooper());

    /* compiled from: Taobao */
    private class a implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener {
        float a;
        long b;
        private int d;
        private EAMapPlatformGestureInfo e;

        private a() {
            this.d = 0;
            this.a = 0.0f;
            this.e = new EAMapPlatformGestureInfo();
            this.b = 0;
        }

        public boolean onDoubleTap(MotionEvent motionEvent) {
            p.this.c.setIsLongpressEnabled(false);
            this.d = motionEvent.getPointerCount();
            AMapGestureListener aMapGestureListener = p.this.d;
            if (aMapGestureListener != null) {
                aMapGestureListener.onDoubleTap(motionEvent.getX(), motionEvent.getY());
            }
            return false;
        }

        public boolean onDoubleTapEvent(MotionEvent motionEvent) {
            if (this.d < motionEvent.getPointerCount()) {
                this.d = motionEvent.getPointerCount();
            }
            int action = motionEvent.getAction() & 255;
            if (this.d != 1) {
                return false;
            }
            try {
                if (!p.this.a.getUiSettings().isZoomGesturesEnabled()) {
                    return false;
                }
            } catch (Throwable th) {
                hd.c(th, "GLMapGestrureDetector", "onDoubleTapEvent");
                th.printStackTrace();
            }
            if (action == 0) {
                EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.e;
                eAMapPlatformGestureInfo.mGestureState = 1;
                eAMapPlatformGestureInfo.mGestureType = 9;
                eAMapPlatformGestureInfo.mLocation = new float[]{motionEvent.getX(), motionEvent.getY()};
                int engineIDWithGestureInfo = p.this.a.getEngineIDWithGestureInfo(this.e);
                this.a = motionEvent.getY();
                p.this.a.addGestureMapMessage(engineIDWithGestureInfo, ScaleGestureMapMessage.obtain(100, 1.0f, 0, 0));
                this.b = SystemClock.uptimeMillis();
                return true;
            } else if (action == 2) {
                p.this.o = true;
                float y = this.a - motionEvent.getY();
                if (Math.abs(y) < ((float) 20)) {
                    return true;
                }
                EAMapPlatformGestureInfo eAMapPlatformGestureInfo2 = this.e;
                eAMapPlatformGestureInfo2.mGestureState = 2;
                eAMapPlatformGestureInfo2.mGestureType = 9;
                eAMapPlatformGestureInfo2.mLocation = new float[]{motionEvent.getX(), motionEvent.getY()};
                int engineIDWithGestureInfo2 = p.this.a.getEngineIDWithGestureInfo(this.e);
                float mapHeight = (4.0f * y) / ((float) p.this.a.getMapHeight());
                if (y > 0.0f) {
                    p.this.a.addGestureMapMessage(engineIDWithGestureInfo2, ScaleGestureMapMessage.obtain(101, mapHeight, 0, 0));
                } else {
                    p.this.a.addGestureMapMessage(engineIDWithGestureInfo2, ScaleGestureMapMessage.obtain(101, mapHeight, 0, 0));
                }
                this.a = motionEvent.getY();
                return true;
            } else {
                EAMapPlatformGestureInfo eAMapPlatformGestureInfo3 = this.e;
                eAMapPlatformGestureInfo3.mGestureState = 3;
                eAMapPlatformGestureInfo3.mGestureType = 9;
                eAMapPlatformGestureInfo3.mLocation = new float[]{motionEvent.getX(), motionEvent.getY()};
                int engineIDWithGestureInfo3 = p.this.a.getEngineIDWithGestureInfo(this.e);
                p.this.c.setIsLongpressEnabled(true);
                p.this.a.addGestureMapMessage(engineIDWithGestureInfo3, ScaleGestureMapMessage.obtain(102, 1.0f, 0, 0));
                if (action == 1) {
                    p.this.a.setGestureStatus(engineIDWithGestureInfo3, 3);
                    long uptimeMillis = SystemClock.uptimeMillis() - this.b;
                    if (!p.this.o || uptimeMillis < ((long) 200)) {
                        return p.this.a.onDoubleTap(engineIDWithGestureInfo3, motionEvent);
                    }
                    p.this.o = false;
                    return true;
                }
                p.this.o = false;
                return true;
            }
        }

        public boolean onDown(MotionEvent motionEvent) {
            p.this.o = false;
            return true;
        }

        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            AMapGestureListener aMapGestureListener = p.this.d;
            if (aMapGestureListener != null) {
                aMapGestureListener.onFling(f, f2);
            }
            try {
                if (p.this.a.getUiSettings().isScrollGesturesEnabled() && p.this.m <= 0 && p.this.k <= 0 && p.this.l == 0 && !p.this.q) {
                    EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.e;
                    eAMapPlatformGestureInfo.mGestureState = 3;
                    eAMapPlatformGestureInfo.mGestureType = 3;
                    eAMapPlatformGestureInfo.mLocation = new float[]{motionEvent2.getX(), motionEvent2.getY()};
                    int engineIDWithGestureInfo = p.this.a.getEngineIDWithGestureInfo(this.e);
                    p.this.a.onFling();
                    p.this.a.getGLMapEngine().startMapSlidAnim(engineIDWithGestureInfo, new Point((int) motionEvent2.getX(), (int) motionEvent2.getY()), f, f2);
                }
                return true;
            } catch (Throwable th) {
                hd.c(th, "GLMapGestrureDetector", "onFling");
                th.printStackTrace();
                return true;
            }
        }

        public void onLongPress(MotionEvent motionEvent) {
            if (p.this.n == 1) {
                EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.e;
                eAMapPlatformGestureInfo.mGestureState = 3;
                eAMapPlatformGestureInfo.mGestureType = 7;
                eAMapPlatformGestureInfo.mLocation = new float[]{motionEvent.getX(), motionEvent.getY()};
                p.this.a.onLongPress(p.this.a.getEngineIDWithGestureInfo(this.e), motionEvent);
                AMapGestureListener aMapGestureListener = p.this.d;
                if (aMapGestureListener != null) {
                    aMapGestureListener.onLongPress(motionEvent.getX(), motionEvent.getY());
                }
            }
        }

        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            AMapGestureListener aMapGestureListener = p.this.d;
            if (aMapGestureListener == null) {
                return false;
            }
            aMapGestureListener.onScroll(f, f2);
            return false;
        }

        public void onShowPress(MotionEvent motionEvent) {
            try {
                EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.e;
                eAMapPlatformGestureInfo.mGestureState = 3;
                eAMapPlatformGestureInfo.mGestureType = 7;
                eAMapPlatformGestureInfo.mLocation = new float[]{motionEvent.getX(), motionEvent.getY()};
                p.this.a.getGLMapEngine().clearAnimations(p.this.a.getEngineIDWithGestureInfo(this.e), false);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (p.this.n != 1) {
                return false;
            }
            EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.e;
            eAMapPlatformGestureInfo.mGestureState = 3;
            eAMapPlatformGestureInfo.mGestureType = 8;
            eAMapPlatformGestureInfo.mLocation = new float[]{motionEvent.getX(), motionEvent.getY()};
            int engineIDWithGestureInfo = p.this.a.getEngineIDWithGestureInfo(this.e);
            AMapGestureListener aMapGestureListener = p.this.d;
            if (aMapGestureListener != null) {
                try {
                    aMapGestureListener.onSingleTap(motionEvent.getX(), motionEvent.getY());
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            return p.this.a.onSingleTapConfirmed(engineIDWithGestureInfo, motionEvent);
        }

        public boolean onSingleTapUp(MotionEvent motionEvent) {
            return false;
        }
    }

    /* compiled from: Taobao */
    private class b implements al.a {
        private EAMapPlatformGestureInfo b;

        private b() {
            this.b = new EAMapPlatformGestureInfo();
        }

        @Override // com.amap.api.mapcore.util.al.a
        public boolean a(al alVar) {
            EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.b;
            eAMapPlatformGestureInfo.mGestureState = 2;
            eAMapPlatformGestureInfo.mGestureType = 6;
            boolean z = false;
            eAMapPlatformGestureInfo.mLocation = new float[]{alVar.c().getX(), alVar.c().getY()};
            try {
                if (!p.this.a.getUiSettings().isTiltGesturesEnabled()) {
                    return true;
                }
                int engineIDWithGestureInfo = p.this.a.getEngineIDWithGestureInfo(this.b);
                if (p.this.a.isLockMapCameraDegree(engineIDWithGestureInfo) || p.this.l > 3) {
                    return false;
                }
                float f = alVar.d().x;
                float f2 = alVar.d().y;
                if (!p.this.i) {
                    PointF a2 = alVar.a(0);
                    PointF a3 = alVar.a(1);
                    float f3 = a2.y;
                    if ((f3 > 10.0f && a3.y > 10.0f) || (f3 < -10.0f && a3.y < -10.0f)) {
                        z = true;
                    }
                    if (z) {
                        float f4 = (float) 10;
                        if (Math.abs(f2) > f4 && Math.abs(f) < f4) {
                            p.this.i = true;
                        }
                    }
                }
                if (p.this.i) {
                    p.this.i = true;
                    float f5 = f2 / 6.0f;
                    if (Math.abs(f5) > 1.0f) {
                        p.this.a.addGestureMapMessage(engineIDWithGestureInfo, HoverGestureMapMessage.obtain(101, f5));
                        p.m(p.this);
                    }
                }
                return true;
            } catch (Throwable th) {
                hd.c(th, "GLMapGestrureDetector", "onHove");
                th.printStackTrace();
                return true;
            }
        }

        @Override // com.amap.api.mapcore.util.al.a
        public boolean b(al alVar) {
            EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.b;
            eAMapPlatformGestureInfo.mGestureState = 1;
            eAMapPlatformGestureInfo.mGestureType = 6;
            eAMapPlatformGestureInfo.mLocation = new float[]{alVar.c().getX(), alVar.c().getY()};
            try {
                if (!p.this.a.getUiSettings().isTiltGesturesEnabled()) {
                    return true;
                }
                int engineIDWithGestureInfo = p.this.a.getEngineIDWithGestureInfo(this.b);
                if (p.this.a.isLockMapCameraDegree(engineIDWithGestureInfo)) {
                    return false;
                }
                IAMapDelegate iAMapDelegate = p.this.a;
                iAMapDelegate.addGestureMapMessage(engineIDWithGestureInfo, HoverGestureMapMessage.obtain(100, iAMapDelegate.getCameraDegree(engineIDWithGestureInfo)));
                return true;
            } catch (Throwable th) {
                hd.c(th, "GLMapGestrureDetector", "onHoveBegin");
                th.printStackTrace();
                return true;
            }
        }

        @Override // com.amap.api.mapcore.util.al.a
        public void c(al alVar) {
            EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.b;
            eAMapPlatformGestureInfo.mGestureState = 3;
            eAMapPlatformGestureInfo.mGestureType = 6;
            eAMapPlatformGestureInfo.mLocation = new float[]{alVar.c().getX(), alVar.c().getY()};
            try {
                if (p.this.a.getUiSettings().isTiltGesturesEnabled()) {
                    int engineIDWithGestureInfo = p.this.a.getEngineIDWithGestureInfo(this.b);
                    if (!p.this.a.isLockMapCameraDegree(engineIDWithGestureInfo)) {
                        if (p.this.a.getCameraDegree(engineIDWithGestureInfo) >= 0.0f && p.this.m > 0) {
                            p.this.a.setGestureStatus(engineIDWithGestureInfo, 7);
                        }
                        p.this.i = false;
                        IAMapDelegate iAMapDelegate = p.this.a;
                        iAMapDelegate.addGestureMapMessage(engineIDWithGestureInfo, HoverGestureMapMessage.obtain(102, iAMapDelegate.getCameraDegree(engineIDWithGestureInfo)));
                    }
                }
            } catch (Throwable th) {
                hd.c(th, "GLMapGestrureDetector", "onHoveEnd");
                th.printStackTrace();
            }
        }
    }

    /* compiled from: Taobao */
    private class c implements am.a {
        private EAMapPlatformGestureInfo b;

        private c() {
            this.b = new EAMapPlatformGestureInfo();
        }

        @Override // com.amap.api.mapcore.util.am.a
        public boolean a(am amVar) {
            if (p.this.i) {
                return true;
            }
            try {
                if (p.this.a.getUiSettings().isScrollGesturesEnabled() && !p.this.p) {
                    EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.b;
                    eAMapPlatformGestureInfo.mGestureState = 2;
                    eAMapPlatformGestureInfo.mGestureType = 3;
                    eAMapPlatformGestureInfo.mLocation = new float[]{amVar.c().getX(), amVar.c().getY()};
                    int engineIDWithGestureInfo = p.this.a.getEngineIDWithGestureInfo(this.b);
                    PointF d = amVar.d();
                    float f = 1.0f;
                    if (p.this.j == 0) {
                        f = 4.0f;
                    }
                    if (Math.abs(d.x) <= f && Math.abs(d.y) <= f) {
                        return false;
                    }
                    if (p.this.j == 0) {
                        p.this.a.getGLMapEngine().clearAnimations(engineIDWithGestureInfo, false);
                    }
                    p.this.a.addGestureMapMessage(engineIDWithGestureInfo, MoveGestureMapMessage.obtain(101, d.x, d.y));
                    p.l(p.this);
                }
                return true;
            } catch (Throwable th) {
                hd.c(th, "GLMapGestrureDetector", "onMove");
                th.printStackTrace();
                return true;
            }
        }

        @Override // com.amap.api.mapcore.util.am.a
        public boolean b(am amVar) {
            try {
                if (!p.this.a.getUiSettings().isScrollGesturesEnabled()) {
                    return true;
                }
                EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.b;
                eAMapPlatformGestureInfo.mGestureState = 1;
                eAMapPlatformGestureInfo.mGestureType = 3;
                eAMapPlatformGestureInfo.mLocation = new float[]{amVar.c().getX(), amVar.c().getY()};
                p.this.a.addGestureMapMessage(p.this.a.getEngineIDWithGestureInfo(this.b), MoveGestureMapMessage.obtain(100, 0.0f, 0.0f));
                return true;
            } catch (Throwable th) {
                hd.c(th, "GLMapGestrureDetector", "onMoveBegin");
                th.printStackTrace();
                return true;
            }
        }

        @Override // com.amap.api.mapcore.util.am.a
        public void c(am amVar) {
            try {
                if (p.this.a.getUiSettings().isScrollGesturesEnabled()) {
                    EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.b;
                    eAMapPlatformGestureInfo.mGestureState = 3;
                    eAMapPlatformGestureInfo.mGestureType = 3;
                    eAMapPlatformGestureInfo.mLocation = new float[]{amVar.c().getX(), amVar.c().getY()};
                    int engineIDWithGestureInfo = p.this.a.getEngineIDWithGestureInfo(this.b);
                    if (p.this.j > 0) {
                        p.this.a.setGestureStatus(engineIDWithGestureInfo, 5);
                    }
                    p.this.a.addGestureMapMessage(engineIDWithGestureInfo, MoveGestureMapMessage.obtain(102, 0.0f, 0.0f));
                }
            } catch (Throwable th) {
                hd.c(th, "GLMapGestrureDetector", "onMoveEnd");
                th.printStackTrace();
            }
        }
    }

    /* compiled from: Taobao */
    private class d extends ao.a {
        private boolean b;
        private boolean c;
        private boolean d;
        private Point e;
        private float[] f;
        private float g;
        private float[] h;
        private float i;
        private EAMapPlatformGestureInfo j;

        private d() {
            this.b = false;
            this.c = false;
            this.d = false;
            this.e = new Point();
            this.f = new float[10];
            this.g = 0.0f;
            this.h = new float[10];
            this.i = 0.0f;
            this.j = new EAMapPlatformGestureInfo();
        }

        /* JADX WARNING: Removed duplicated region for block: B:29:0x00ca A[Catch:{ all -> 0x010a }] */
        /* JADX WARNING: Removed duplicated region for block: B:30:0x00cb A[Catch:{ all -> 0x010a }] */
        /* JADX WARNING: Removed duplicated region for block: B:62:0x015c A[Catch:{ all -> 0x01a1 }] */
        /* JADX WARNING: Removed duplicated region for block: B:69:0x016f A[Catch:{ all -> 0x01a1 }] */
        /* JADX WARNING: Removed duplicated region for block: B:70:0x0170 A[Catch:{ all -> 0x01a1 }] */
        @Override // com.amap.api.mapcore.util.ao.a
        public boolean a(ao aoVar) {
            boolean z;
            Throwable th;
            float l;
            Throwable th2;
            boolean z2;
            EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.j;
            eAMapPlatformGestureInfo.mGestureState = 2;
            eAMapPlatformGestureInfo.mGestureType = 4;
            boolean z3 = true;
            eAMapPlatformGestureInfo.mLocation = new float[]{aoVar.a().getX(), aoVar.a().getY()};
            int engineIDWithGestureInfo = p.this.a.getEngineIDWithGestureInfo(this.j);
            float j2 = aoVar.j();
            float k = (float) aoVar.k();
            int b2 = (int) aoVar.b();
            int c2 = (int) aoVar.c();
            float abs = (float) Math.abs(b2 - com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(this.e));
            float abs2 = (float) Math.abs(c2 - com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(this.e));
            Point point = this.e;
            point.x = b2;
            point.y = c2;
            float log = (float) Math.log((double) j2);
            if (p.this.k <= 0 && Math.abs(log) > 0.2f) {
                this.d = true;
            }
            try {
                if (p.this.a.getUiSettings().isZoomGesturesEnabled()) {
                    if (!this.b && 0.06f < Math.abs(log)) {
                        this.b = true;
                    }
                    if (this.b && 0.01f < Math.abs(log)) {
                        if (abs > 2.0f || abs2 > 2.0f) {
                            try {
                                if (Math.abs(log) < 0.02f) {
                                    z2 = true;
                                    if (z2) {
                                        if (k > 0.0f) {
                                            float f2 = log / k;
                                            this.g = f2;
                                            this.f[p.this.k % 10] = Math.abs(f2);
                                            p.g(p.this);
                                            p.this.a.addGestureMapMessage(engineIDWithGestureInfo, ScaleGestureMapMessage.obtain(101, log, b2, c2));
                                            if (log > 0.0f) {
                                                p.this.a.setGestureStatus(engineIDWithGestureInfo, 1);
                                            } else {
                                                p.this.a.setGestureStatus(engineIDWithGestureInfo, 2);
                                            }
                                        }
                                    }
                                    z = true;
                                    if (p.this.a.getUiSettings().isRotateGesturesEnabled() && !p.this.a.isLockMapAngle(engineIDWithGestureInfo) && !this.d) {
                                        l = aoVar.l();
                                        if (!this.c && Math.abs(l) >= 4.0f) {
                                            this.c = true;
                                        }
                                        if (this.c && 1.0f < Math.abs(l)) {
                                            if (!((abs <= 4.0f || abs2 > 4.0f) && Math.abs(l) < 2.0f)) {
                                                float f3 = l / k;
                                                this.i = f3;
                                                this.h[p.this.l % 10] = Math.abs(f3);
                                                p.h(p.this);
                                                p.this.a.addGestureMapMessage(engineIDWithGestureInfo, RotateGestureMapMessage.obtain(101, l, b2, c2));
                                                try {
                                                    p.this.a.setGestureStatus(engineIDWithGestureInfo, 6);
                                                    return true;
                                                } catch (Throwable th3) {
                                                    th = th3;
                                                }
                                            }
                                        }
                                    }
                                    return z;
                                }
                            } catch (Throwable th4) {
                                th2 = th4;
                                z = true;
                                hd.c(th2, "GLMapGestrureDetector", "onScaleRotate");
                                th2.printStackTrace();
                                l = aoVar.l();
                                this.c = true;
                                if (!((abs <= 4.0f || abs2 > 4.0f) && Math.abs(l) < 2.0f)) {
                                }
                            }
                        }
                        z2 = false;
                        if (z2) {
                        }
                        z = true;
                        l = aoVar.l();
                        this.c = true;
                        if (!((abs <= 4.0f || abs2 > 4.0f) && Math.abs(l) < 2.0f)) {
                        }
                    }
                }
                z = false;
            } catch (Throwable th5) {
                th2 = th5;
                z = false;
                hd.c(th2, "GLMapGestrureDetector", "onScaleRotate");
                th2.printStackTrace();
                l = aoVar.l();
                this.c = true;
                if (!((abs <= 4.0f || abs2 > 4.0f) && Math.abs(l) < 2.0f)) {
                }
            }
            try {
                l = aoVar.l();
                this.c = true;
                if (!((abs <= 4.0f || abs2 > 4.0f) && Math.abs(l) < 2.0f)) {
                }
            } catch (Throwable th6) {
                th = th6;
                z3 = z;
                hd.c(th, "GLMapGestrureDetector", "onScaleRotate");
                th.printStackTrace();
                return z3;
            }
        }

        @Override // com.amap.api.mapcore.util.ao.a
        public boolean b(ao aoVar) {
            EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.j;
            eAMapPlatformGestureInfo.mGestureState = 1;
            eAMapPlatformGestureInfo.mGestureType = 4;
            eAMapPlatformGestureInfo.mLocation = new float[]{aoVar.a().getX(), aoVar.a().getY()};
            int engineIDWithGestureInfo = p.this.a.getEngineIDWithGestureInfo(this.j);
            int b2 = (int) aoVar.b();
            int c2 = (int) aoVar.c();
            this.d = false;
            Point point = this.e;
            point.x = b2;
            point.y = c2;
            this.b = false;
            this.c = false;
            p.this.a.addGestureMapMessage(engineIDWithGestureInfo, ScaleGestureMapMessage.obtain(100, 1.0f, b2, c2));
            try {
                if (p.this.a.getUiSettings().isRotateGesturesEnabled() && !p.this.a.isLockMapAngle(engineIDWithGestureInfo)) {
                    IAMapDelegate iAMapDelegate = p.this.a;
                    iAMapDelegate.addGestureMapMessage(engineIDWithGestureInfo, RotateGestureMapMessage.obtain(100, iAMapDelegate.getMapAngle(engineIDWithGestureInfo), b2, c2));
                }
            } catch (Throwable th) {
                hd.c(th, "GLMapGestrureDetector", "onScaleRotateBegin");
                th.printStackTrace();
            }
            return true;
        }

        @Override // com.amap.api.mapcore.util.ao.a
        public void c(ao aoVar) {
            float f2;
            float f3;
            int i2;
            float f4;
            EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.j;
            eAMapPlatformGestureInfo.mGestureState = 3;
            eAMapPlatformGestureInfo.mGestureType = 4;
            boolean z = false;
            eAMapPlatformGestureInfo.mLocation = new float[]{aoVar.a().getX(), aoVar.a().getY()};
            int engineIDWithGestureInfo = p.this.a.getEngineIDWithGestureInfo(this.j);
            this.d = false;
            p.this.a.addGestureMapMessage(engineIDWithGestureInfo, ScaleGestureMapMessage.obtain(102, 1.0f, 0, 0));
            if (p.this.k > 0) {
                int i3 = p.this.k > 10 ? 10 : p.this.k;
                float f5 = 0.0f;
                for (int i4 = 0; i4 < 10; i4++) {
                    float[] fArr = this.f;
                    f5 += fArr[i4];
                    fArr[i4] = 0.0f;
                }
                float f6 = f5 / ((float) i3);
                if (0.004f <= f6) {
                    float f7 = f6 * 300.0f;
                    if (f7 >= 1.5f) {
                        f7 = 1.5f;
                    }
                    if (this.g < 0.0f) {
                        f7 = -f7;
                    }
                    f4 = p.this.a.getPreciseLevel(engineIDWithGestureInfo) + f7;
                } else {
                    f4 = -9999.0f;
                }
                this.g = 0.0f;
                f2 = f4;
            } else {
                f2 = -9999.0f;
            }
            if (!p.this.a.isLockMapAngle(engineIDWithGestureInfo)) {
                try {
                    if (p.this.a.getUiSettings().isRotateGesturesEnabled()) {
                        IAMapDelegate iAMapDelegate = p.this.a;
                        iAMapDelegate.addGestureMapMessage(engineIDWithGestureInfo, RotateGestureMapMessage.obtain(102, iAMapDelegate.getMapAngle(engineIDWithGestureInfo), 0, 0));
                    }
                } catch (Throwable th) {
                    hd.c(th, "GLMapGestrureDetector", "onScaleRotateEnd");
                    th.printStackTrace();
                }
                if (p.this.l > 0) {
                    p.this.a.setGestureStatus(engineIDWithGestureInfo, 6);
                    if (p.this.l > 10) {
                        i2 = 10;
                    } else {
                        i2 = p.this.l;
                    }
                    float f8 = 0.0f;
                    for (int i5 = 0; i5 < 10; i5++) {
                        float[] fArr2 = this.h;
                        f8 += fArr2[i5];
                        fArr2[i5] = 0.0f;
                    }
                    float f9 = f8 / ((float) i2);
                    if (0.1f <= f9) {
                        float f10 = f9 * 200.0f;
                        int mapAngle = ((int) p.this.a.getMapAngle(engineIDWithGestureInfo)) % 360;
                        if (f10 >= 60.0f) {
                            f10 = 60.0f;
                        }
                        if (this.i < 0.0f) {
                            f10 = -f10;
                        }
                        f3 = (float) (((int) (((float) mapAngle) + f10)) % 360);
                        this.g = 0.0f;
                    }
                }
                f3 = -9999.0f;
                this.g = 0.0f;
            } else {
                f3 = -9999.0f;
            }
            if (!(f2 == -9999.0f && f3 == -9999.0f)) {
                z = true;
            }
            if (z) {
                p.this.a.getGLMapEngine().startPivotZoomRotateAnim(engineIDWithGestureInfo, this.e, f2, (int) f3, 500);
            }
        }
    }

    /* compiled from: Taobao */
    private class e extends ap.b {
        EAMapPlatformGestureInfo a;

        private e() {
            this.a = new EAMapPlatformGestureInfo();
        }

        @Override // com.amap.api.mapcore.util.ap.b, com.amap.api.mapcore.util.ap.a
        public void a(ap apVar) {
            try {
                if (p.this.a.getUiSettings().isZoomGesturesEnabled()) {
                    float f = (float) 10;
                    if (Math.abs(apVar.d()) <= f && Math.abs(apVar.e()) <= f && apVar.b() < 200) {
                        p.this.q = true;
                        EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.a;
                        eAMapPlatformGestureInfo.mGestureState = 2;
                        eAMapPlatformGestureInfo.mGestureType = 2;
                        eAMapPlatformGestureInfo.mLocation = new float[]{apVar.c().getX(), apVar.c().getY()};
                        int engineIDWithGestureInfo = p.this.a.getEngineIDWithGestureInfo(this.a);
                        p.this.a.setGestureStatus(engineIDWithGestureInfo, 4);
                        p.this.a.zoomOut(engineIDWithGestureInfo);
                    }
                }
            } catch (Throwable th) {
                hd.c(th, "GLMapGestrureDetector", "onZoomOut");
                th.printStackTrace();
            }
        }
    }

    public p(IAMapDelegate iAMapDelegate) {
        this.b = iAMapDelegate.getContext();
        this.a = iAMapDelegate;
        a aVar = new a();
        GestureDetector gestureDetector = new GestureDetector(this.b, aVar, this.t);
        this.c = gestureDetector;
        gestureDetector.setOnDoubleTapListener(aVar);
        this.e = new ao(this.b, new d());
        this.f = new am(this.b, new c());
        this.g = new al(this.b, new b());
        this.h = new ap(this.b, new e());
    }

    static /* synthetic */ int g(p pVar) {
        int i2 = pVar.k;
        pVar.k = i2 + 1;
        return i2;
    }

    static /* synthetic */ int h(p pVar) {
        int i2 = pVar.l;
        pVar.l = i2 + 1;
        return i2;
    }

    static /* synthetic */ int l(p pVar) {
        int i2 = pVar.j;
        pVar.j = i2 + 1;
        return i2;
    }

    static /* synthetic */ int m(p pVar) {
        int i2 = pVar.m;
        pVar.m = i2 + 1;
        return i2;
    }

    public void d() {
        Handler handler = this.t;
        if (handler != null) {
            handler.removeCallbacks(null);
            this.t = null;
        }
    }

    public void a(AMapGestureListener aMapGestureListener) {
        this.d = aMapGestureListener;
    }

    public int b() {
        return this.r;
    }

    public int c() {
        return this.s;
    }

    public void a() {
        this.j = 0;
        this.l = 0;
        this.k = 0;
        this.m = 0;
        this.n = 0;
    }

    public void a(int i2, int i3) {
        this.r = i2;
        this.s = i3;
        ao aoVar = this.e;
        if (aoVar != null) {
            aoVar.a(i2, i3);
        }
        am amVar = this.f;
        if (amVar != null) {
            amVar.a(i2, i3);
        }
        al alVar = this.g;
        if (alVar != null) {
            alVar.a(i2, i3);
        }
        ap apVar = this.h;
        if (apVar != null) {
            apVar.a(i2, i3);
        }
    }

    public boolean a(MotionEvent motionEvent) {
        if (this.n < motionEvent.getPointerCount()) {
            this.n = motionEvent.getPointerCount();
        }
        if ((motionEvent.getAction() & 255) == 0) {
            this.p = false;
            this.q = false;
        }
        if (motionEvent.getAction() == 6 && motionEvent.getPointerCount() > 0) {
            this.p = true;
        }
        if (this.o && this.n >= 2) {
            this.o = false;
        }
        try {
            int[] iArr = {0, 0};
            IAMapDelegate iAMapDelegate = this.a;
            if (!(iAMapDelegate == null || iAMapDelegate.getGLMapView() == null)) {
                this.a.getGLMapView().getLocationOnScreen(iArr);
            }
            if (this.d != null) {
                if (motionEvent.getAction() == 0) {
                    this.d.onDown(motionEvent.getX(), motionEvent.getY());
                } else if (motionEvent.getAction() == 1) {
                    this.d.onUp(motionEvent.getX(), motionEvent.getY());
                }
            }
            this.c.onTouchEvent(motionEvent);
            boolean d2 = this.g.d(motionEvent, iArr[0], iArr[1]);
            if (this.i && this.m > 0) {
                return d2;
            }
            this.h.d(motionEvent, iArr[0], iArr[1]);
            if (this.o) {
                return d2;
            }
            this.e.a(motionEvent);
            return this.f.d(motionEvent, iArr[0], iArr[1]);
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }
}
