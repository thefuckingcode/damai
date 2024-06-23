package com.amap.api.mapcore.util;

import android.animation.Animator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.location.Location;
import android.os.RemoteException;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.Circle;
import com.amap.api.maps.model.CircleOptions;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.MyLocationStyle;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.base.ae.gmap.GLMapState;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;

/* compiled from: Taobao */
public class cv {
    a a = null;
    ValueAnimator b;
    Animator.AnimatorListener c = new Animator.AnimatorListener() {
        /* class com.amap.api.mapcore.util.cv.AnonymousClass1 */

        public void onAnimationCancel(Animator animator) {
        }

        public void onAnimationEnd(Animator animator) {
            cv.this.j();
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationStart(Animator animator) {
        }
    };
    ValueAnimator.AnimatorUpdateListener d = new ValueAnimator.AnimatorUpdateListener() {
        /* class com.amap.api.mapcore.util.cv.AnonymousClass2 */

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            try {
                if (cv.this.g != null) {
                    LatLng latLng = (LatLng) valueAnimator.getAnimatedValue();
                    cv.this.g.setCenter(latLng);
                    cv.this.f.setPosition(latLng);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    };
    private IAMapDelegate e;
    private Marker f;
    private Circle g;
    private MyLocationStyle h = new MyLocationStyle();
    private LatLng i;
    private double j;
    private Context k;
    private aa l;
    private int m = 4;
    private boolean n = false;
    private boolean o = false;
    private boolean p = false;
    private boolean q = false;
    private boolean r = false;
    private boolean s = false;

    /* compiled from: Taobao */
    public static class a implements TypeEvaluator {
        @Override // android.animation.TypeEvaluator
        public Object evaluate(float f, Object obj, Object obj2) {
            LatLng latLng = (LatLng) obj;
            LatLng latLng2 = (LatLng) obj2;
            double d = latLng.latitude;
            double d2 = (double) f;
            double d3 = latLng.longitude;
            return new LatLng(d + ((latLng2.latitude - d) * d2), d3 + (d2 * (latLng2.longitude - d3)));
        }
    }

    public cv(IAMapDelegate iAMapDelegate, Context context) {
        Context applicationContext = context.getApplicationContext();
        this.k = applicationContext;
        this.e = iAMapDelegate;
        this.l = new aa(applicationContext, iAMapDelegate);
        a(4, true);
    }

    private void d(float f2) {
        if (this.q) {
            float f3 = f2 % 360.0f;
            if (f3 > 180.0f) {
                f3 -= 360.0f;
            } else if (f3 < -180.0f) {
                f3 += 360.0f;
            }
            Marker marker = this.f;
            if (marker != null) {
                marker.setRotateAngle(-f3);
            }
        }
    }

    private void g() {
        this.l.b();
    }

    private void h() {
        b(0.0f);
    }

    private void i() {
        c(0.0f);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void j() {
        if (this.i == null || !this.o) {
            return;
        }
        if (!this.p || !this.n) {
            this.n = true;
            try {
                IPoint obtain = IPoint.obtain();
                LatLng latLng = this.i;
                GLMapState.lonlat2Geo(latLng.longitude, latLng.latitude, obtain);
                this.e.animateCamera(ah.a(obtain));
            } catch (Throwable th) {
                hd.c(th, "MyLocationOverlay", "moveMapToLocation");
                th.printStackTrace();
            }
        }
    }

    private void k() {
        MyLocationStyle myLocationStyle = this.h;
        if (myLocationStyle == null) {
            MyLocationStyle myLocationStyle2 = new MyLocationStyle();
            this.h = myLocationStyle2;
            myLocationStyle2.myLocationIcon(BitmapDescriptorFactory.fromAsset("location_map_gps_locked.png"));
            m();
            return;
        }
        if (myLocationStyle.getMyLocationIcon() == null || this.h.getMyLocationIcon().getBitmap() == null) {
            this.h.myLocationIcon(BitmapDescriptorFactory.fromAsset("location_map_gps_locked.png"));
        }
        m();
    }

    private void l() {
        Circle circle = this.g;
        if (circle != null) {
            try {
                this.e.removeGLOverlay(circle.getId());
            } catch (Throwable th) {
                hd.c(th, "MyLocationOverlay", "locationIconRemove");
                th.printStackTrace();
            }
            this.g = null;
        }
        Marker marker = this.f;
        if (marker != null) {
            marker.remove();
            this.f = null;
            this.l.a((Marker) null);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x0115 A[Catch:{ all -> 0x012a }] */
    private void m() {
        LatLng latLng;
        try {
            if (this.g == null) {
                this.g = this.e.addCircle(new CircleOptions().zIndex(1.0f));
            }
            Circle circle = this.g;
            if (circle != null) {
                if (circle.getStrokeWidth() != this.h.getStrokeWidth()) {
                    this.g.setStrokeWidth(this.h.getStrokeWidth());
                }
                if (this.g.getFillColor() != this.h.getRadiusFillColor()) {
                    this.g.setFillColor(this.h.getRadiusFillColor());
                }
                if (this.g.getStrokeColor() != this.h.getStrokeColor()) {
                    this.g.setStrokeColor(this.h.getStrokeColor());
                }
                LatLng latLng2 = this.i;
                if (latLng2 != null) {
                    this.g.setCenter(latLng2);
                }
                this.g.setRadius(this.j);
                this.g.setVisible(true);
            }
            if (this.f == null) {
                this.f = this.e.addMarker(new MarkerOptions().visible(false));
            }
            Marker marker = this.f;
            if (marker != null) {
                if (!(marker.getAnchorU() == this.h.getAnchorU() && this.f.getAnchorV() == this.h.getAnchorV())) {
                    this.f.setAnchor(this.h.getAnchorU(), this.h.getAnchorV());
                }
                if (this.f.getIcons() != null) {
                    if (this.f.getIcons().size() != 0) {
                        if (this.h.getMyLocationIcon() != null && !this.f.getIcons().get(0).equals(this.h.getMyLocationIcon())) {
                            this.f.setIcon(this.h.getMyLocationIcon());
                        }
                        latLng = this.i;
                        if (latLng != null) {
                            this.f.setPosition(latLng);
                            this.f.setVisible(true);
                        }
                    }
                }
                this.f.setIcon(this.h.getMyLocationIcon());
                latLng = this.i;
                if (latLng != null) {
                }
            }
            j();
            this.l.a(this.f);
        } catch (Throwable th) {
            hd.c(th, "MyLocationOverlay", "myLocStyle");
            th.printStackTrace();
        }
    }

    public String e() throws RemoteException {
        Circle circle = this.g;
        if (circle != null) {
            return circle.getId();
        }
        return null;
    }

    public void f() {
        this.g = null;
        this.f = null;
    }

    private void c(float f2) {
        IAMapDelegate iAMapDelegate = this.e;
        if (iAMapDelegate != null) {
            try {
                iAMapDelegate.moveCamera(ah.d(f2));
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void a(MyLocationStyle myLocationStyle) {
        try {
            this.h = myLocationStyle;
            a(myLocationStyle.isMyLocationShowing());
            if (!this.h.isMyLocationShowing()) {
                this.l.a(false);
                this.m = this.h.getMyLocationType();
                return;
            }
            k();
            Marker marker = this.f;
            if (marker != null || this.g != null) {
                this.l.a(marker);
                a(this.h.getMyLocationType());
            }
        } catch (Throwable th) {
            hd.c(th, "MyLocationOverlay", "setMyLocationStyle");
            th.printStackTrace();
        }
    }

    public void b() {
        aa aaVar;
        if (this.m == 3 && (aaVar = this.l) != null) {
            aaVar.a();
        }
    }

    private void b(float f2) {
        IAMapDelegate iAMapDelegate = this.e;
        if (iAMapDelegate != null) {
            try {
                iAMapDelegate.moveCamera(ah.c(f2));
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public String d() {
        Marker marker = this.f;
        if (marker != null) {
            return marker.getId();
        }
        return null;
    }

    public void c() throws RemoteException {
        l();
        if (this.l != null) {
            g();
            this.l = null;
        }
    }

    public MyLocationStyle a() {
        return this.h;
    }

    public void a(int i2) {
        a(i2, false);
    }

    private void a(int i2, boolean z) {
        this.m = i2;
        this.n = false;
        this.p = false;
        this.o = false;
        this.r = false;
        this.s = false;
        if (i2 == 1) {
            this.o = true;
            this.p = true;
            this.q = true;
        } else if (i2 == 2) {
            this.o = true;
            this.q = true;
        } else if (i2 == 3) {
            this.o = true;
            this.s = true;
        } else if (i2 == 4) {
            this.o = true;
            this.r = true;
        } else if (i2 == 5) {
            this.r = true;
        } else if (i2 == 7) {
            this.s = true;
        }
        if (this.r || this.s) {
            if (this.s) {
                this.l.a(true);
                if (!z) {
                    try {
                        this.e.moveCamera(ah.a(17.0f));
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
                b(45.0f);
            } else {
                this.l.a(false);
            }
            this.l.a();
            Marker marker = this.f;
            if (marker != null) {
                marker.setFlat(true);
                return;
            }
            return;
        }
        Marker marker2 = this.f;
        if (marker2 != null) {
            marker2.setFlat(false);
        }
        i();
        h();
        g();
    }

    public void a(Location location) {
        if (location != null) {
            a(this.h.isMyLocationShowing());
            if (this.h.isMyLocationShowing()) {
                this.i = new LatLng(com.alibaba.wireless.security.aopsdk.replace.android.location.Location.getLatitude(location), com.alibaba.wireless.security.aopsdk.replace.android.location.Location.getLongitude(location));
                this.j = (double) location.getAccuracy();
                if (this.f == null && this.g == null) {
                    k();
                }
                Circle circle = this.g;
                if (circle != null) {
                    try {
                        double d2 = this.j;
                        if (d2 != -1.0d) {
                            circle.setRadius(d2);
                        }
                    } catch (Throwable th) {
                        hd.c(th, "MyLocationOverlay", "setCentAndRadius");
                        th.printStackTrace();
                    }
                }
                d(location.getBearing());
                if (!this.i.equals(this.f.getPosition())) {
                    a(this.i);
                } else {
                    j();
                }
            }
        }
    }

    public void a(boolean z) {
        Circle circle = this.g;
        if (!(circle == null || circle.isVisible() == z)) {
            this.g.setVisible(z);
        }
        Marker marker = this.f;
        if (marker != null && marker.isVisible() != z) {
            this.f.setVisible(z);
        }
    }

    public void a(float f2) {
        Marker marker = this.f;
        if (marker != null) {
            marker.setRotateAngle(f2);
        }
    }

    private void a(LatLng latLng) {
        LatLng position = this.f.getPosition();
        if (position == null) {
            position = new LatLng(0.0d, 0.0d);
        }
        if (this.a == null) {
            this.a = new a();
        }
        ValueAnimator valueAnimator = this.b;
        if (valueAnimator == null) {
            ValueAnimator ofObject = ValueAnimator.ofObject(new a(), position, latLng);
            this.b = ofObject;
            ofObject.addListener(this.c);
            this.b.addUpdateListener(this.d);
        } else {
            valueAnimator.setObjectValues(position, latLng);
            this.b.setEvaluator(this.a);
        }
        if (position.latitude == 0.0d && position.longitude == 0.0d) {
            this.b.setDuration(1L);
        } else {
            this.b.setDuration(1000L);
        }
        this.b.start();
    }
}
