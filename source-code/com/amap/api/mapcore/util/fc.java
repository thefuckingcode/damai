package com.amap.api.mapcore.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.location.Location;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.amap.api.maps.model.LatLng;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.taobao.weex.common.Constants;

/* compiled from: Taobao */
public class fc extends LinearLayout {
    Bitmap a;
    Bitmap b;
    Bitmap c;
    Bitmap d;
    Bitmap e;
    Bitmap f;
    ImageView g;
    IAMapDelegate h;
    boolean i = false;

    @SuppressLint({"ClickableViewAccessibility"})
    public fc(Context context, IAMapDelegate iAMapDelegate) {
        super(context);
        this.h = iAMapDelegate;
        try {
            Bitmap a2 = eq.a(context, "location_selected.png");
            this.d = a2;
            this.a = eq.a(a2, m.a);
            Bitmap a3 = eq.a(context, "location_pressed.png");
            this.e = a3;
            this.b = eq.a(a3, m.a);
            Bitmap a4 = eq.a(context, "location_unselected.png");
            this.f = a4;
            this.c = eq.a(a4, m.a);
            ImageView imageView = new ImageView(context);
            this.g = imageView;
            imageView.setImageBitmap(this.a);
            this.g.setClickable(true);
            this.g.setPadding(0, 20, 20, 0);
            this.g.setOnTouchListener(new View.OnTouchListener() {
                /* class com.amap.api.mapcore.util.fc.AnonymousClass1 */

                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (!fc.this.i) {
                        return false;
                    }
                    if (motionEvent.getAction() == 0) {
                        fc fcVar = fc.this;
                        fcVar.g.setImageBitmap(fcVar.b);
                    } else if (motionEvent.getAction() == 1) {
                        try {
                            fc fcVar2 = fc.this;
                            fcVar2.g.setImageBitmap(fcVar2.a);
                            fc.this.h.setMyLocationEnabled(true);
                            Location myLocation = fc.this.h.getMyLocation();
                            if (myLocation == null) {
                                return false;
                            }
                            LatLng latLng = new LatLng(com.alibaba.wireless.security.aopsdk.replace.android.location.Location.getLatitude(myLocation), com.alibaba.wireless.security.aopsdk.replace.android.location.Location.getLongitude(myLocation));
                            fc.this.h.showMyLocationOverlay(myLocation);
                            IAMapDelegate iAMapDelegate = fc.this.h;
                            iAMapDelegate.moveCamera(ah.a(latLng, iAMapDelegate.getZoomLevel()));
                        } catch (Throwable th) {
                            hd.c(th, "LocationView", "onTouch");
                            th.printStackTrace();
                        }
                    }
                    return false;
                }
            });
            addView(this.g);
        } catch (Throwable th) {
            hd.c(th, "LocationView", "create");
            th.printStackTrace();
        }
    }

    public void a() {
        try {
            removeAllViews();
            Bitmap bitmap = this.a;
            if (bitmap != null) {
                eq.b(bitmap);
            }
            Bitmap bitmap2 = this.b;
            if (bitmap2 != null) {
                eq.b(bitmap2);
            }
            if (this.b != null) {
                eq.b(this.c);
            }
            this.a = null;
            this.b = null;
            this.c = null;
            Bitmap bitmap3 = this.d;
            if (bitmap3 != null) {
                eq.b(bitmap3);
                this.d = null;
            }
            Bitmap bitmap4 = this.e;
            if (bitmap4 != null) {
                eq.b(bitmap4);
                this.e = null;
            }
            Bitmap bitmap5 = this.f;
            if (bitmap5 != null) {
                eq.b(bitmap5);
                this.f = null;
            }
        } catch (Throwable th) {
            hd.c(th, "LocationView", Constants.Event.SLOT_LIFECYCLE.DESTORY);
            th.printStackTrace();
        }
    }

    public void a(boolean z) {
        this.i = z;
        if (z) {
            try {
                this.g.setImageBitmap(this.a);
            } catch (Throwable th) {
                hd.c(th, "LocationView", "showSelect");
                th.printStackTrace();
                return;
            }
        } else {
            this.g.setImageBitmap(this.c);
        }
        this.g.invalidate();
    }
}
