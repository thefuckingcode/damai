package com.tencent.connect.avatar;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

/* compiled from: Taobao */
public class c extends ImageView {
    final String a = "TouchView";
    public boolean b = false;
    private Matrix c = new Matrix();
    private Matrix d = new Matrix();
    private int e = 0;
    private float f = 1.0f;
    private float g = 1.0f;
    private Bitmap h;
    private boolean i = false;
    private float j;
    private float k;
    private PointF l = new PointF();
    private PointF m = new PointF();
    private float n = 1.0f;
    private float o = 0.0f;
    private Rect p;

    public c(Context context) {
        super(context);
        Rect rect = new Rect();
        this.p = rect;
        getDrawingRect(rect);
        a();
    }

    private void a() {
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void b() {
        ScaleAnimation scaleAnimation;
        boolean z;
        if (this.h != null) {
            float width = (float) com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(this.p);
            float height = (float) com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(this.p);
            float[] fArr = new float[9];
            this.c.getValues(fArr);
            float f2 = fArr[2];
            float f3 = fArr[5];
            float f4 = fArr[0];
            float f5 = this.f;
            if (f4 > f5) {
                float f6 = f5 / f4;
                this.o = f6;
                Matrix matrix = this.c;
                PointF pointF = this.m;
                matrix.postScale(f6, f6, pointF.x, pointF.y);
                setImageMatrix(this.c);
                float f7 = this.o;
                float f8 = 1.0f / f7;
                float f9 = 1.0f / f7;
                PointF pointF2 = this.m;
                scaleAnimation = new ScaleAnimation(f8, 1.0f, f9, 1.0f, pointF2.x, pointF2.y);
            } else {
                float f10 = this.g;
                if (f4 < f10) {
                    float f11 = f10 / f4;
                    this.o = f11;
                    Matrix matrix2 = this.c;
                    PointF pointF3 = this.m;
                    matrix2.postScale(f11, f11, pointF3.x, pointF3.y);
                    float f12 = this.o;
                    PointF pointF4 = this.m;
                    scaleAnimation = new ScaleAnimation(1.0f, f12, 1.0f, f12, pointF4.x, pointF4.y);
                } else {
                    float width2 = ((float) this.h.getWidth()) * f4;
                    float height2 = ((float) this.h.getHeight()) * f4;
                    Rect rect = this.p;
                    int i2 = rect.left;
                    float f13 = ((float) i2) - f2;
                    int i3 = rect.top;
                    float f14 = ((float) i3) - f3;
                    if (f13 < 0.0f) {
                        f2 = (float) i2;
                        z = true;
                    } else {
                        z = false;
                    }
                    if (f14 < 0.0f) {
                        f3 = (float) i3;
                        z = true;
                    }
                    float f15 = height2 - f14;
                    if (width2 - f13 < width) {
                        f2 = ((float) i2) - (width2 - width);
                        z = true;
                    }
                    if (f15 < height) {
                        f3 = ((float) i3) - (height2 - height);
                        z = true;
                    }
                    if (z) {
                        fArr[2] = f2;
                        fArr[5] = f3;
                        this.c.setValues(fArr);
                        setImageMatrix(this.c);
                        scaleAnimation = new TranslateAnimation(fArr[2] - f2, 0.0f, fArr[5] - f3, 0.0f);
                    } else {
                        setImageMatrix(this.c);
                        scaleAnimation = null;
                    }
                }
            }
            if (scaleAnimation != null) {
                this.i = true;
                scaleAnimation.setDuration(300);
                startAnimation(scaleAnimation);
                new Thread(new Runnable() {
                    /* class com.tencent.connect.avatar.c.AnonymousClass1 */

                    public void run() {
                        try {
                            Thread.sleep(300);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        c.this.post(new Runnable() {
                            /* class com.tencent.connect.avatar.c.AnonymousClass1.AnonymousClass1 */

                            public void run() {
                                c.this.clearAnimation();
                                c.this.b();
                            }
                        });
                        c.this.i = false;
                    }
                }).start();
            }
        }
    }

    private void c() {
        if (this.h != null) {
            float[] fArr = new float[9];
            this.c.getValues(fArr);
            float max = Math.max(((float) com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(this.p)) / ((float) this.h.getWidth()), ((float) com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(this.p)) / ((float) this.h.getHeight()));
            this.j = ((float) this.p.left) - (((((float) this.h.getWidth()) * max) - ((float) com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(this.p))) / 2.0f);
            float height = ((float) this.p.top) - (((((float) this.h.getHeight()) * max) - ((float) com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(this.p))) / 2.0f);
            this.k = height;
            fArr[2] = this.j;
            fArr[5] = height;
            fArr[4] = max;
            fArr[0] = max;
            this.c.setValues(fArr);
            float min = Math.min(2048.0f / ((float) this.h.getWidth()), 2048.0f / ((float) this.h.getHeight()));
            this.f = min;
            this.g = max;
            if (min < max) {
                this.f = max;
            }
            setImageMatrix(this.c);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0019, code lost:
        if (r0 != 6) goto L_0x00af;
     */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.i) {
            return true;
        }
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    int i2 = this.e;
                    if (i2 == 1) {
                        this.c.set(this.d);
                        this.c.postTranslate(motionEvent.getX() - this.l.x, motionEvent.getY() - this.l.y);
                        setImageMatrix(this.c);
                    } else if (i2 == 2) {
                        Matrix matrix = this.c;
                        matrix.set(matrix);
                        float a2 = a(motionEvent);
                        if (a2 > 10.0f) {
                            this.c.set(this.d);
                            float f2 = a2 / this.n;
                            Matrix matrix2 = this.c;
                            PointF pointF = this.m;
                            matrix2.postScale(f2, f2, pointF.x, pointF.y);
                        }
                        setImageMatrix(this.c);
                    }
                } else if (action == 5) {
                    float a3 = a(motionEvent);
                    this.n = a3;
                    if (a3 > 10.0f) {
                        this.d.set(this.c);
                        a(this.m);
                        this.e = 2;
                    }
                }
            }
            b();
            this.e = 0;
        } else {
            this.c.set(getImageMatrix());
            this.d.set(this.c);
            this.l.set(motionEvent.getX(), motionEvent.getY());
            this.e = 1;
        }
        this.b = true;
        return true;
    }

    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        this.h = bitmap;
        if (bitmap != null) {
            this.h = bitmap;
        }
    }

    private float a(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() < 2) {
            return 0.0f;
        }
        float x = motionEvent.getX(0) - motionEvent.getX(1);
        float y = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((double) ((x * x) + (y * y)));
    }

    public void a(Rect rect) {
        this.p = rect;
        if (this.h != null) {
            c();
        }
    }

    private void a(PointF pointF) {
        if (this.h != null) {
            float[] fArr = new float[9];
            this.c.getValues(fArr);
            float f2 = fArr[2];
            float f3 = fArr[5];
            float f4 = fArr[0];
            float width = ((float) this.h.getWidth()) * f4;
            float height = ((float) this.h.getHeight()) * f4;
            Rect rect = this.p;
            float f5 = ((float) rect.left) - f2;
            float f6 = 1.0f;
            if (f5 <= 1.0f) {
                f5 = 1.0f;
            }
            float f7 = (f2 + width) - ((float) rect.right);
            if (f7 <= 1.0f) {
                f7 = 1.0f;
            }
            float width2 = (((float) com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(rect)) * f5) / (f7 + f5);
            Rect rect2 = this.p;
            float f8 = width2 + ((float) rect2.left);
            float f9 = ((float) rect2.top) - f3;
            float f10 = (f3 + height) - ((float) rect2.bottom);
            if (f9 <= 1.0f) {
                f9 = 1.0f;
            }
            if (f10 > 1.0f) {
                f6 = f10;
            }
            pointF.set(f8, ((((float) com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(rect2)) * f9) / (f6 + f9)) + ((float) this.p.top));
        }
    }
}
