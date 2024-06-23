package com.amap.api.mapcore.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.amap.api.mapcore.util.fd;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class fh extends LinearLayout {
    private Bitmap a;
    private Bitmap b;
    private Bitmap c;
    private Bitmap d;
    private Bitmap e;
    private Bitmap f;
    private Bitmap g;
    private Bitmap h;
    private Bitmap i;
    private Bitmap j;
    private Bitmap k;
    private Bitmap l;
    private ImageView m;
    private ImageView n;
    private IAMapDelegate o;

    public fh(Context context, IAMapDelegate iAMapDelegate) {
        super(context);
        this.o = iAMapDelegate;
        try {
            Bitmap a2 = eq.a(context, "zoomin_selected.png");
            this.g = a2;
            this.a = eq.a(a2, m.a);
            Bitmap a3 = eq.a(context, "zoomin_unselected.png");
            this.h = a3;
            this.b = eq.a(a3, m.a);
            Bitmap a4 = eq.a(context, "zoomout_selected.png");
            this.i = a4;
            this.c = eq.a(a4, m.a);
            Bitmap a5 = eq.a(context, "zoomout_unselected.png");
            this.j = a5;
            this.d = eq.a(a5, m.a);
            Bitmap a6 = eq.a(context, "zoomin_pressed.png");
            this.k = a6;
            this.e = eq.a(a6, m.a);
            Bitmap a7 = eq.a(context, "zoomout_pressed.png");
            this.l = a7;
            this.f = eq.a(a7, m.a);
            ImageView imageView = new ImageView(context);
            this.m = imageView;
            imageView.setImageBitmap(this.a);
            this.m.setClickable(true);
            ImageView imageView2 = new ImageView(context);
            this.n = imageView2;
            imageView2.setImageBitmap(this.c);
            this.n.setClickable(true);
            this.m.setOnTouchListener(new View.OnTouchListener() {
                /* class com.amap.api.mapcore.util.fh.AnonymousClass1 */

                public boolean onTouch(View view, MotionEvent motionEvent) {
                    try {
                        if (fh.this.o.getZoomLevel() < fh.this.o.getMaxZoomLevel()) {
                            if (fh.this.o.isMaploaded()) {
                                if (motionEvent.getAction() == 0) {
                                    fh.this.m.setImageBitmap(fh.this.e);
                                } else if (motionEvent.getAction() == 1) {
                                    fh.this.m.setImageBitmap(fh.this.a);
                                    try {
                                        fh.this.o.animateCamera(ah.a());
                                    } catch (RemoteException e) {
                                        hd.c(e, "ZoomControllerView", "zoomin ontouch");
                                        e.printStackTrace();
                                    }
                                }
                                return false;
                            }
                        }
                        return false;
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
            this.n.setOnTouchListener(new View.OnTouchListener() {
                /* class com.amap.api.mapcore.util.fh.AnonymousClass2 */

                public boolean onTouch(View view, MotionEvent motionEvent) {
                    try {
                        if (fh.this.o.getZoomLevel() > fh.this.o.getMinZoomLevel()) {
                            if (fh.this.o.isMaploaded()) {
                                if (motionEvent.getAction() == 0) {
                                    fh.this.n.setImageBitmap(fh.this.f);
                                } else if (motionEvent.getAction() == 1) {
                                    fh.this.n.setImageBitmap(fh.this.c);
                                    fh.this.o.animateCamera(ah.b());
                                }
                                return false;
                            }
                        }
                        return false;
                    } catch (Throwable th) {
                        hd.c(th, "ZoomControllerView", "zoomout ontouch");
                        th.printStackTrace();
                    }
                }
            });
            this.m.setPadding(0, 0, 20, -2);
            this.n.setPadding(0, 0, 20, 20);
            setOrientation(1);
            addView(this.m);
            addView(this.n);
        } catch (Throwable th) {
            hd.c(th, "ZoomControllerView", "create");
            th.printStackTrace();
        }
    }

    public void a() {
        try {
            removeAllViews();
            eq.b(this.a);
            eq.b(this.b);
            eq.b(this.c);
            eq.b(this.d);
            eq.b(this.e);
            eq.b(this.f);
            this.a = null;
            this.b = null;
            this.c = null;
            this.d = null;
            this.e = null;
            this.f = null;
            Bitmap bitmap = this.g;
            if (bitmap != null) {
                eq.b(bitmap);
                this.g = null;
            }
            Bitmap bitmap2 = this.h;
            if (bitmap2 != null) {
                eq.b(bitmap2);
                this.h = null;
            }
            Bitmap bitmap3 = this.i;
            if (bitmap3 != null) {
                eq.b(bitmap3);
                this.i = null;
            }
            Bitmap bitmap4 = this.j;
            if (bitmap4 != null) {
                eq.b(bitmap4);
                this.g = null;
            }
            Bitmap bitmap5 = this.k;
            if (bitmap5 != null) {
                eq.b(bitmap5);
                this.k = null;
            }
            Bitmap bitmap6 = this.l;
            if (bitmap6 != null) {
                eq.b(bitmap6);
                this.l = null;
            }
            this.m = null;
            this.n = null;
        } catch (Throwable th) {
            hd.c(th, "ZoomControllerView", "destory");
            th.printStackTrace();
        }
    }

    public void a(float f2) {
        try {
            if (f2 < this.o.getMaxZoomLevel() && f2 > this.o.getMinZoomLevel()) {
                this.m.setImageBitmap(this.a);
                this.n.setImageBitmap(this.c);
            } else if (f2 == this.o.getMinZoomLevel()) {
                this.n.setImageBitmap(this.d);
                this.m.setImageBitmap(this.a);
            } else if (f2 == this.o.getMaxZoomLevel()) {
                this.m.setImageBitmap(this.b);
                this.n.setImageBitmap(this.c);
            }
        } catch (Throwable th) {
            hd.c(th, "ZoomControllerView", "setZoomBitmap");
            th.printStackTrace();
        }
    }

    public void a(int i2) {
        try {
            fd.a aVar = (fd.a) getLayoutParams();
            if (i2 == 1) {
                aVar.d = 16;
            } else if (i2 == 2) {
                aVar.d = 80;
            }
            setLayoutParams(aVar);
        } catch (Throwable th) {
            hd.c(th, "ZoomControllerView", "setZoomPosition");
            th.printStackTrace();
        }
    }

    public void a(boolean z) {
        if (z) {
            setVisibility(0);
        } else {
            setVisibility(8);
        }
    }
}
