package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.ViewConfiguration;

/* compiled from: Taobao */
public class an {
    private int A = 0;
    private final Context a;
    private final a b;
    private boolean c;
    private MotionEvent d;
    private MotionEvent e;
    private float f;
    private float g;
    private float h;
    private float i;
    private float j;
    private float k;
    private float l;
    private float m;
    private float n;
    private float o;
    private float p;
    private long q;
    private final float r;
    private float s;
    private float t;
    private boolean u;
    private boolean v;
    private int w;
    private int x;
    private boolean y;
    private int z = 0;

    /* compiled from: Taobao */
    public interface a {
        boolean a(an anVar);

        boolean b(an anVar);

        void c(an anVar);
    }

    public an(Context context, a aVar) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.a = context;
        this.b = aVar;
        this.r = (float) viewConfiguration.getScaledEdgeSlop();
    }

    private static float b(MotionEvent motionEvent, int i2) {
        if (i2 < 0) {
            return Float.MIN_VALUE;
        }
        if (i2 == 0) {
            return motionEvent.getRawY();
        }
        return motionEvent.getY(i2) + (motionEvent.getRawY() - motionEvent.getY());
    }

    private void l() {
        MotionEvent motionEvent = this.d;
        if (motionEvent != null) {
            motionEvent.recycle();
            this.d = null;
        }
        MotionEvent motionEvent2 = this.e;
        if (motionEvent2 != null) {
            motionEvent2.recycle();
            this.e = null;
        }
        this.u = false;
        this.c = false;
        this.w = -1;
        this.x = -1;
        this.v = false;
    }

    public MotionEvent a() {
        return this.e;
    }

    public float c() {
        return this.g;
    }

    public float d() {
        if (this.l == -1.0f) {
            float f2 = this.j;
            float f3 = this.k;
            this.l = (float) Math.sqrt((double) ((f2 * f2) + (f3 * f3)));
        }
        return this.l;
    }

    public float e() {
        return this.j;
    }

    public float f() {
        return this.k;
    }

    public float g() {
        if (this.m == -1.0f) {
            float f2 = this.h;
            float f3 = this.i;
            this.m = (float) Math.sqrt((double) ((f2 * f2) + (f3 * f3)));
        }
        return this.m;
    }

    public float h() {
        return this.h;
    }

    public float i() {
        return this.i;
    }

    public float j() {
        if (this.n == -1.0f) {
            this.n = d() / g();
        }
        return this.n;
    }

    public long k() {
        return this.q;
    }

    public void a(int i2, int i3) {
        this.z = i2;
        this.A = i3;
    }

    private void b(MotionEvent motionEvent) {
        MotionEvent motionEvent2 = this.e;
        if (motionEvent2 != null) {
            motionEvent2.recycle();
        }
        this.e = MotionEvent.obtain(motionEvent);
        this.l = -1.0f;
        this.m = -1.0f;
        this.n = -1.0f;
        MotionEvent motionEvent3 = this.d;
        int findPointerIndex = motionEvent3.findPointerIndex(this.w);
        int findPointerIndex2 = motionEvent3.findPointerIndex(this.x);
        int findPointerIndex3 = motionEvent.findPointerIndex(this.w);
        int findPointerIndex4 = motionEvent.findPointerIndex(this.x);
        if (findPointerIndex < 0 || findPointerIndex2 < 0 || findPointerIndex3 < 0 || findPointerIndex4 < 0) {
            this.v = true;
            if (this.c) {
                this.b.c(this);
                return;
            }
            return;
        }
        float x2 = motionEvent3.getX(findPointerIndex);
        float y2 = motionEvent3.getY(findPointerIndex);
        float x3 = motionEvent3.getX(findPointerIndex2);
        float y3 = motionEvent3.getY(findPointerIndex2);
        float x4 = motionEvent.getX(findPointerIndex3);
        float y4 = motionEvent.getY(findPointerIndex3);
        float x5 = motionEvent.getX(findPointerIndex4) - x4;
        float y5 = motionEvent.getY(findPointerIndex4) - y4;
        this.h = x3 - x2;
        this.i = y3 - y2;
        this.j = x5;
        this.k = y5;
        this.f = x4 + (x5 * 0.5f);
        this.g = y4 + (y5 * 0.5f);
        this.q = motionEvent.getEventTime() - motionEvent3.getEventTime();
        this.o = motionEvent.getPressure(findPointerIndex3) + motionEvent.getPressure(findPointerIndex4);
        this.p = motionEvent3.getPressure(findPointerIndex) + motionEvent3.getPressure(findPointerIndex2);
    }

    public boolean a(MotionEvent motionEvent) {
        int a2;
        int a3;
        int i2;
        int i3;
        int i4;
        int a4;
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            l();
        }
        boolean z2 = false;
        if (this.v) {
            return false;
        }
        int i5 = -1;
        if (!this.c) {
            if (action == 0) {
                this.w = motionEvent.getPointerId(0);
                this.y = true;
            } else if (action == 1) {
                l();
            } else if (action != 2) {
                if (action == 5) {
                    int i6 = this.z;
                    if (i6 == 0 || (i4 = this.A) == 0) {
                        DisplayMetrics displayMetrics = this.a.getResources().getDisplayMetrics();
                        float f2 = this.r;
                        this.s = ((float) com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(displayMetrics)) - f2;
                        this.t = ((float) com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getheightPixels(displayMetrics)) - f2;
                    } else {
                        float f3 = this.r;
                        this.s = ((float) i6) - f3;
                        this.t = ((float) i4) - f3;
                    }
                    MotionEvent motionEvent2 = this.d;
                    if (motionEvent2 != null) {
                        motionEvent2.recycle();
                    }
                    this.d = MotionEvent.obtain(motionEvent);
                    this.q = 0;
                    if (Build.VERSION.SDK_INT >= 8) {
                        i3 = motionEvent.getActionIndex();
                        i2 = motionEvent.findPointerIndex(this.w);
                        int pointerId = motionEvent.getPointerId(i3);
                        this.x = pointerId;
                        if (i2 < 0 || i2 == i3) {
                            if (i2 != i3) {
                                i5 = pointerId;
                            }
                            i2 = a(motionEvent, i5, i2);
                            this.w = motionEvent.getPointerId(i2);
                        }
                    } else if (motionEvent.getPointerCount() > 0) {
                        i3 = motionEvent.findPointerIndex(1);
                        i2 = motionEvent.findPointerIndex(this.w);
                        this.x = motionEvent.getPointerId(i3);
                    } else {
                        i3 = 0;
                        i2 = 0;
                    }
                    this.y = false;
                    b(motionEvent);
                    float f4 = this.r;
                    float f5 = this.s;
                    float f6 = this.t;
                    float a5 = a(motionEvent, i2);
                    float b2 = b(motionEvent, i2);
                    float a6 = a(motionEvent, i3);
                    float b3 = b(motionEvent, i3);
                    boolean z3 = a5 < f4 || b2 < f4 || a5 > f5 || b2 > f6;
                    boolean z4 = a6 < f4 || b3 < f4 || a6 > f5 || b3 > f6;
                    if (z3 && z4) {
                        this.f = -1.0f;
                        this.g = -1.0f;
                        this.u = true;
                    } else if (z3) {
                        this.f = motionEvent.getX(i3);
                        this.g = motionEvent.getY(i3);
                        this.u = true;
                    } else if (z4) {
                        this.f = motionEvent.getX(i2);
                        this.g = motionEvent.getY(i2);
                        this.u = true;
                    } else {
                        this.u = false;
                        this.c = this.b.b(this);
                    }
                } else if (action == 6 && this.u) {
                    int pointerCount = motionEvent.getPointerCount();
                    int actionIndex = Build.VERSION.SDK_INT >= 8 ? motionEvent.getActionIndex() : 0;
                    int pointerId2 = motionEvent.getPointerId(actionIndex);
                    if (pointerCount > 2) {
                        int i7 = this.w;
                        if (pointerId2 == i7) {
                            int a7 = a(motionEvent, this.x, actionIndex);
                            if (a7 >= 0) {
                                this.w = motionEvent.getPointerId(a7);
                            }
                        } else if (pointerId2 == this.x && (a4 = a(motionEvent, i7, actionIndex)) >= 0) {
                            this.x = motionEvent.getPointerId(a4);
                        }
                    } else {
                        int i8 = this.w;
                        if (pointerId2 == i8) {
                            i8 = this.x;
                        }
                        int findPointerIndex = motionEvent.findPointerIndex(i8);
                        if (findPointerIndex < 0) {
                            this.v = true;
                            if (this.c) {
                                this.b.c(this);
                            }
                            return false;
                        }
                        this.w = motionEvent.getPointerId(findPointerIndex);
                        this.y = true;
                        this.x = -1;
                        this.f = motionEvent.getX(findPointerIndex);
                        this.g = motionEvent.getY(findPointerIndex);
                    }
                }
            } else if (this.u) {
                float f7 = this.r;
                float f8 = this.s;
                float f9 = this.t;
                int findPointerIndex2 = motionEvent.findPointerIndex(this.w);
                int findPointerIndex3 = motionEvent.findPointerIndex(this.x);
                float a8 = a(motionEvent, findPointerIndex2);
                float b4 = b(motionEvent, findPointerIndex2);
                float a9 = a(motionEvent, findPointerIndex3);
                float b5 = b(motionEvent, findPointerIndex3);
                boolean z5 = a8 < f7 || b4 < f7 || a8 > f8 || b4 > f9;
                boolean z6 = a9 < f7 || b5 < f7 || a9 > f8 || b5 > f9;
                if (z5 && (a3 = a(motionEvent, this.x, findPointerIndex2)) >= 0) {
                    this.w = motionEvent.getPointerId(a3);
                    a(motionEvent, a3);
                    b(motionEvent, a3);
                    findPointerIndex2 = a3;
                    z5 = false;
                }
                if (z6 && (a2 = a(motionEvent, this.w, findPointerIndex3)) >= 0) {
                    this.x = motionEvent.getPointerId(a2);
                    a(motionEvent, a2);
                    b(motionEvent, a2);
                    findPointerIndex3 = a2;
                    z6 = false;
                }
                if (z5 && z6) {
                    this.f = -1.0f;
                    this.g = -1.0f;
                } else if (z5) {
                    this.f = motionEvent.getX(findPointerIndex3);
                    this.g = motionEvent.getY(findPointerIndex3);
                } else if (z6) {
                    this.f = motionEvent.getX(findPointerIndex2);
                    this.g = motionEvent.getY(findPointerIndex2);
                } else {
                    this.u = false;
                    this.c = this.b.b(this);
                }
            }
        } else if (action == 1) {
            l();
        } else if (action == 2) {
            b(motionEvent);
            if (this.o / this.p > 0.67f && this.b.a(this)) {
                this.d.recycle();
                this.d = MotionEvent.obtain(motionEvent);
            }
        } else if (action == 3) {
            this.b.c(this);
            l();
        } else if (action == 5) {
            this.b.c(this);
            int i9 = this.w;
            int i10 = this.x;
            l();
            this.d = MotionEvent.obtain(motionEvent);
            if (!this.y) {
                i9 = i10;
            }
            this.w = i9;
            if (Build.VERSION.SDK_INT >= 8) {
                this.x = motionEvent.getPointerId(motionEvent.getActionIndex());
            } else {
                this.x = motionEvent.getPointerId(1);
            }
            this.y = false;
            int findPointerIndex4 = motionEvent.findPointerIndex(this.w);
            if (findPointerIndex4 < 0 || this.w == this.x) {
                int i11 = this.w;
                int i12 = this.x;
                if (i11 != i12) {
                    i5 = i12;
                }
                this.w = motionEvent.getPointerId(a(motionEvent, i5, findPointerIndex4));
            }
            b(motionEvent);
            this.c = this.b.b(this);
        } else if (action == 6) {
            int pointerCount2 = motionEvent.getPointerCount();
            int actionIndex2 = Build.VERSION.SDK_INT >= 8 ? motionEvent.getActionIndex() : 0;
            int pointerId3 = motionEvent.getPointerId(actionIndex2);
            if (pointerCount2 > 2) {
                int i13 = this.w;
                if (pointerId3 == i13) {
                    int a10 = a(motionEvent, this.x, actionIndex2);
                    if (a10 >= 0) {
                        this.b.c(this);
                        this.w = motionEvent.getPointerId(a10);
                        this.y = true;
                        this.d = MotionEvent.obtain(motionEvent);
                        b(motionEvent);
                        this.c = this.b.b(this);
                        this.d.recycle();
                        this.d = MotionEvent.obtain(motionEvent);
                        b(motionEvent);
                    }
                } else {
                    if (pointerId3 == this.x) {
                        int a11 = a(motionEvent, i13, actionIndex2);
                        if (a11 >= 0) {
                            this.b.c(this);
                            this.x = motionEvent.getPointerId(a11);
                            this.y = false;
                            this.d = MotionEvent.obtain(motionEvent);
                            b(motionEvent);
                            this.c = this.b.b(this);
                        }
                    }
                    this.d.recycle();
                    this.d = MotionEvent.obtain(motionEvent);
                    b(motionEvent);
                }
                z2 = true;
                this.d.recycle();
                this.d = MotionEvent.obtain(motionEvent);
                b(motionEvent);
            } else {
                z2 = true;
            }
            if (z2) {
                b(motionEvent);
                int i14 = this.w;
                if (pointerId3 == i14) {
                    i14 = this.x;
                }
                int findPointerIndex5 = motionEvent.findPointerIndex(i14);
                this.f = motionEvent.getX(findPointerIndex5);
                this.g = motionEvent.getY(findPointerIndex5);
                this.b.c(this);
                l();
                this.w = i14;
                this.y = true;
            }
        }
        return true;
    }

    public float b() {
        return this.f;
    }

    private int a(MotionEvent motionEvent, int i2, int i3) {
        int pointerCount = motionEvent.getPointerCount();
        int findPointerIndex = motionEvent.findPointerIndex(i2);
        for (int i4 = 0; i4 < pointerCount; i4++) {
            if (!(i4 == i3 || i4 == findPointerIndex)) {
                float f2 = this.r;
                float f3 = this.s;
                float f4 = this.t;
                float a2 = a(motionEvent, i4);
                float b2 = b(motionEvent, i4);
                if (a2 >= f2 && b2 >= f2 && a2 <= f3 && b2 <= f4) {
                    return i4;
                }
            }
        }
        return -1;
    }

    private static float a(MotionEvent motionEvent, int i2) {
        if (i2 < 0) {
            return Float.MIN_VALUE;
        }
        if (i2 == 0) {
            return motionEvent.getRawX();
        }
        return motionEvent.getX(i2) + (motionEvent.getRawX() - motionEvent.getX());
    }
}
