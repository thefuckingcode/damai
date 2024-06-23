package com.amap.api.mapcore.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.amap.api.mapcore.util.fb;
import com.amap.api.maps.MapsInitializer;
import com.amap.api.maps.model.BasePointOverlay;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.GL3DModel;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.base.ae.gmap.GLMapState;
import com.autonavi.base.ae.gmap.listener.AMapWidgetListener;
import com.autonavi.base.amap.api.mapcore.BaseOverlayImp;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.api.mapcore.IGLSurfaceView;
import com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction;
import com.autonavi.base.amap.mapcore.FPoint;
import com.autonavi.base.amap.mapcore.MapConfig;

/* compiled from: Taobao */
public class fd extends ViewGroup implements IInfoWindowAction {
    fe a;
    ar b;
    private IAMapDelegate c;
    private Context d;
    private fg e;
    private fc f;
    private fa g;
    private ff h;
    private ez i;
    private fb j;
    private fh k;
    private View l;
    private BaseOverlayImp m;
    private Drawable n = null;
    private boolean o;
    private View p;
    private boolean q;
    private boolean r;
    private boolean s;

    /* compiled from: Taobao */
    public static class a extends ViewGroup.LayoutParams {
        public FPoint a = null;
        public int b = 0;
        public int c = 0;
        public int d = 51;

        public a(int i, int i2, FPoint fPoint, int i3, int i4, int i5) {
            super(i, i2);
            this.a = fPoint;
            this.b = i3;
            this.c = i4;
            this.d = i5;
        }
    }

    public fd(Context context, IAMapDelegate iAMapDelegate) {
        super(context);
        int i2 = 1;
        this.o = true;
        this.r = true;
        this.s = true;
        try {
            this.c = iAMapDelegate;
            this.d = context;
            this.a = new fe();
            this.i = new ez(context);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            if (this.c.getGLMapView() != null) {
                addView(this.c.getGLMapView(), 0, layoutParams);
            } else {
                i2 = 0;
            }
            addView(this.i, i2, layoutParams);
            if (!this.r) {
                a(context);
            }
        } catch (Throwable th) {
            th.printStackTrace();
            eq.a(th);
        }
    }

    private void m() {
        ff ffVar = this.h;
        if (ffVar == null) {
            this.a.a(this, new Object[0]);
        } else if (ffVar != null && ffVar.getVisibility() == 0) {
            this.h.postInvalidate();
        }
    }

    public void f(Boolean bool) {
        fg fgVar = this.e;
        int i2 = 0;
        if (fgVar == null) {
            this.a.a(this, bool);
            return;
        }
        if (!bool.booleanValue()) {
            i2 = 8;
        }
        fgVar.setVisibility(i2);
    }

    public void g(Boolean bool) {
        fg fgVar = this.e;
        if (fgVar == null) {
            this.a.a(this, bool);
        } else if (fgVar == null || !bool.booleanValue()) {
            fg fgVar2 = this.e;
            if (fgVar2 != null) {
                fgVar2.a(false);
            }
        } else {
            this.e.a(true);
        }
    }

    public void h() {
        fh fhVar = this.k;
        if (fhVar != null) {
            fhVar.a();
        }
        ff ffVar = this.h;
        if (ffVar != null) {
            ffVar.a();
        }
        fg fgVar = this.e;
        if (fgVar != null) {
            fgVar.a();
        }
        fc fcVar = this.f;
        if (fcVar != null) {
            fcVar.a();
        }
        fa faVar = this.g;
        if (faVar != null) {
            faVar.a();
        }
        fb fbVar = this.j;
        if (fbVar != null) {
            fbVar.b();
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction
    public void hideInfoWindow() {
        IAMapDelegate iAMapDelegate = this.c;
        if (iAMapDelegate != null && iAMapDelegate.getMainHandler() != null) {
            this.c.getMainHandler().post(new Runnable() {
                /* class com.amap.api.mapcore.util.fd.AnonymousClass2 */

                public void run() {
                    if (fd.this.l != null) {
                        fd.this.l.clearFocus();
                        fd fdVar = fd.this;
                        fdVar.removeView(fdVar.l);
                        eq.a(fd.this.l.getBackground());
                        eq.a(fd.this.n);
                        fd.this.l = null;
                    }
                }
            });
            BaseOverlayImp baseOverlayImp = this.m;
            if (baseOverlayImp != null) {
                baseOverlayImp.setInfoWindowShown(false);
            }
            this.m = null;
        }
    }

    public void i() {
        hideInfoWindow();
        eq.a(this.n);
        h();
        removeAllViews();
        this.p = null;
    }

    @Override // com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction
    public boolean isInfoWindowShown() {
        return false;
    }

    public void j() {
    }

    public void j(Boolean bool) {
        if (this.e == null) {
            this.a.a(this, bool);
            return;
        }
        bool.booleanValue();
        this.e.setVisibility(4);
    }

    public void k() {
        fa faVar = this.g;
        if (faVar == null) {
            this.a.a(this, new Object[0]);
        } else {
            faVar.b();
        }
    }

    public void l() {
        Context context;
        if (this.r && (context = this.d) != null) {
            a(context);
            fe feVar = this.a;
            if (feVar != null) {
                feVar.a();
            }
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction
    public boolean onInfoWindowTap(MotionEvent motionEvent) {
        if (this.l == null || this.m == null || !eq.a(new Rect(this.l.getLeft(), this.l.getTop(), this.l.getRight(), this.l.getBottom()), (int) motionEvent.getX(), (int) motionEvent.getY())) {
            return false;
        }
        return true;
    }

    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        try {
            int childCount = getChildCount();
            for (int i6 = 0; i6 < childCount; i6++) {
                View childAt = getChildAt(i6);
                if (childAt != null) {
                    if (childAt.getLayoutParams() instanceof a) {
                        a(childAt, (a) childAt.getLayoutParams());
                    } else {
                        a(childAt, childAt.getLayoutParams());
                    }
                }
            }
            fg fgVar = this.e;
            if (fgVar != null) {
                fgVar.d();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction
    public void redrawInfoWindow() {
        try {
            BaseOverlayImp baseOverlayImp = this.m;
            if (baseOverlayImp == null || !baseOverlayImp.checkInBounds()) {
                View view = this.l;
                if (view != null && view.getVisibility() == 0) {
                    this.l.setVisibility(8);
                }
            } else if (this.o) {
                int realInfoWindowOffsetX = this.m.getRealInfoWindowOffsetX() + this.m.getInfoWindowOffsetX();
                int realInfoWindowOffsetY = this.m.getRealInfoWindowOffsetY() + this.m.getInfoWindowOffsetY() + 2;
                View a2 = a(this.m);
                if (a2 != null) {
                    a(a2, realInfoWindowOffsetX, realInfoWindowOffsetY);
                    View view2 = this.l;
                    if (view2 != null) {
                        a aVar = (a) view2.getLayoutParams();
                        if (aVar != null) {
                            aVar.a = FPoint.obtain(((PointF) this.m.getGeoPosition()).x, ((PointF) this.m.getGeoPosition()).y);
                            aVar.b = realInfoWindowOffsetX;
                            aVar.c = realInfoWindowOffsetY;
                        }
                        onLayout(false, 0, 0, 0, 0);
                        if (this.b.a()) {
                            this.b.a(this.m.getTitle(), this.m.getSnippet());
                        }
                        if (this.l.getVisibility() == 8) {
                            this.l.setVisibility(0);
                        }
                    }
                }
            }
        } catch (Throwable th) {
            hd.c(th, "MapOverlayViewGroup", "redrawInfoWindow");
            th.printStackTrace();
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction
    public void setInfoWindowAdapterManager(ar arVar) {
        this.b = arVar;
    }

    @Override // com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction
    public void showInfoWindow(BaseOverlayImp baseOverlayImp) {
        if (baseOverlayImp != null) {
            try {
                ar arVar = this.b;
                if ((arVar == null || !arVar.a() || baseOverlayImp.getTitle() != null || baseOverlayImp.getSnippet() != null) && baseOverlayImp.isInfoWindowEnable()) {
                    BaseOverlayImp baseOverlayImp2 = this.m;
                    if (baseOverlayImp2 != null && !baseOverlayImp2.getId().equals(baseOverlayImp.getId())) {
                        hideInfoWindow();
                    }
                    if (this.b != null) {
                        this.m = baseOverlayImp;
                        baseOverlayImp.setInfoWindowShown(true);
                        this.q = true;
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    public void b(Boolean bool) {
        fh fhVar = this.k;
        if (fhVar == null) {
            this.a.a(this, bool);
            return;
        }
        fhVar.a(bool.booleanValue());
    }

    public void c(Boolean bool) {
        if (this.f == null) {
            this.a.a(this, bool);
        } else if (bool.booleanValue()) {
            this.f.setVisibility(0);
        } else {
            this.f.setVisibility(8);
        }
    }

    public void d(Boolean bool) {
        fa faVar = this.g;
        if (faVar == null) {
            this.a.a(this, bool);
            return;
        }
        faVar.a(bool.booleanValue());
    }

    public void e(Boolean bool) {
        ff ffVar = this.h;
        if (ffVar == null) {
            this.a.a(this, bool);
            return;
        }
        ffVar.a(bool.booleanValue());
    }

    private void a(Context context) {
        fg fgVar = new fg(context, this.c);
        this.e = fgVar;
        fgVar.c(this.s);
        this.h = new ff(context, this.c);
        this.j = new fb(context);
        this.k = new fh(context, this.c);
        this.f = new fc(context, this.c);
        this.g = new fa(context, this.c);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        addView(this.e, layoutParams);
        addView(this.h, layoutParams);
        addView(this.j, new ViewGroup.LayoutParams(-2, -2));
        addView(this.k, new a(-2, -2, new FPoint(0.0f, 0.0f), 0, 0, 83));
        addView(this.f, new a(-2, -2, FPoint.obtain(0.0f, 0.0f), 0, 0, 83));
        addView(this.g, new a(-2, -2, FPoint.obtain(0.0f, 0.0f), 0, 0, 51));
        this.g.setVisibility(8);
        this.c.setMapWidgetListener(new AMapWidgetListener() {
            /* class com.amap.api.mapcore.util.fd.AnonymousClass1 */

            @Override // com.autonavi.base.ae.gmap.listener.AMapWidgetListener
            public void invalidateCompassView() {
                if (fd.this.g != null) {
                    fd.this.g.post(new Runnable() {
                        /* class com.amap.api.mapcore.util.fd.AnonymousClass1.AnonymousClass2 */

                        public void run() {
                            fd.this.g.b();
                        }
                    });
                }
            }

            @Override // com.autonavi.base.ae.gmap.listener.AMapWidgetListener
            public void invalidateScaleView() {
                if (fd.this.h != null) {
                    fd.this.h.post(new Runnable() {
                        /* class com.amap.api.mapcore.util.fd.AnonymousClass1.AnonymousClass1 */

                        public void run() {
                            fd.this.h.b();
                        }
                    });
                }
            }

            @Override // com.autonavi.base.ae.gmap.listener.AMapWidgetListener
            public void invalidateZoomController(final float f) {
                if (fd.this.k != null) {
                    fd.this.k.post(new Runnable() {
                        /* class com.amap.api.mapcore.util.fd.AnonymousClass1.AnonymousClass3 */

                        public void run() {
                            fd.this.k.a(f);
                        }
                    });
                }
            }

            @Override // com.autonavi.base.ae.gmap.listener.AMapWidgetListener
            public void setFrontViewVisibility(boolean z) {
            }
        });
        try {
            if (!this.c.getUiSettings().isMyLocationButtonEnabled()) {
                this.f.setVisibility(8);
            }
        } catch (Throwable th) {
            hd.c(th, "AMapDelegateImpGLSurfaceView", "locationView gone");
            th.printStackTrace();
        }
    }

    public fc f() {
        return this.f;
    }

    public void b(Integer num) {
        fg fgVar = this.e;
        if (fgVar == null) {
            this.a.a(this, num);
        } else if (fgVar != null) {
            fgVar.a(num.intValue());
            this.e.postInvalidate();
            m();
        }
    }

    public void d(Integer num) {
        fg fgVar = this.e;
        if (fgVar == null) {
            this.a.a(this, num);
        } else if (fgVar != null) {
            fgVar.c(num.intValue());
            m();
        }
    }

    public fb e() {
        return this.j;
    }

    public void i(Boolean bool) {
        fb fbVar = this.j;
        if (fbVar == null) {
            this.a.a(this, bool);
            return;
        }
        fbVar.a(bool.booleanValue());
    }

    public void c(Integer num) {
        fg fgVar = this.e;
        if (fgVar == null) {
            this.a.a(this, num);
        } else if (fgVar != null) {
            fgVar.b(num.intValue());
            m();
        }
    }

    public fg g() {
        return this.e;
    }

    public ez d() {
        return this.i;
    }

    public boolean b() {
        fg fgVar = this.e;
        if (fgVar != null) {
            return fgVar.e();
        }
        return false;
    }

    public void c() {
        fg fgVar = this.e;
        if (fgVar == null) {
            this.a.a(this, new Object[0]);
        } else if (fgVar != null) {
            fgVar.d();
        }
    }

    public void h(Boolean bool) {
        fc fcVar = this.f;
        if (fcVar == null) {
            this.a.a(this, bool);
            return;
        }
        fcVar.a(bool.booleanValue());
    }

    public void a(Boolean bool) {
        fb fbVar = this.j;
        if (fbVar == null) {
            this.a.a(this, bool);
        } else if (fbVar != null && bool.booleanValue() && this.c.canShowIndoorSwitch()) {
            this.j.a(true);
        }
    }

    public void a(String str, Boolean bool, Integer num) {
        if (this.e == null) {
            this.a.a(this, str, bool, num);
        } else if (num.intValue() == 2) {
            this.e.b(bool.booleanValue());
        } else if (!TextUtils.isEmpty(str)) {
            this.e.a(str, num.intValue());
            this.e.d(bool.booleanValue());
        }
    }

    public void a(Float f2) {
        fh fhVar = this.k;
        if (fhVar == null) {
            this.a.a(this, f2);
        } else if (fhVar != null) {
            fhVar.a(f2.floatValue());
        }
    }

    public void a(Integer num) {
        fh fhVar = this.k;
        if (fhVar == null) {
            this.a.a(this, num);
        } else if (fhVar != null) {
            fhVar.a(num.intValue());
        }
    }

    public float a(int i2) {
        if (this.e == null) {
            return 0.0f;
        }
        m();
        return this.e.d(i2);
    }

    public void a(Integer num, Float f2) {
        fg fgVar = this.e;
        if (fgVar != null) {
            this.a.a(this, num, f2);
        } else if (fgVar != null) {
            fgVar.a(num.intValue(), f2.floatValue());
            m();
        }
    }

    public Point a() {
        fg fgVar = this.e;
        if (fgVar == null) {
            return null;
        }
        return fgVar.c();
    }

    public void a(CameraPosition cameraPosition) {
        if (this.e == null) {
            this.a.a(this, cameraPosition);
        } else if (this.c.getUiSettings().isLogoEnable()) {
            if (MapsInitializer.isLoadWorldGridMap() && cameraPosition.zoom >= 6.0f) {
                LatLng latLng = cameraPosition.target;
                if (!ej.a(latLng.latitude, latLng.longitude)) {
                    this.e.setVisibility(8);
                    return;
                }
            }
            if (this.c.getMaskLayerType() == -1) {
                this.e.setVisibility(0);
            }
        }
    }

    public void a(boolean z) {
        fg fgVar = this.e;
        if (fgVar != null) {
            fgVar.c(z);
        }
        this.s = z;
    }

    private void a(View view, ViewGroup.LayoutParams layoutParams) {
        int[] iArr = new int[2];
        a(view, layoutParams.width, layoutParams.height, iArr);
        if (view instanceof fb) {
            a(view, iArr[0], iArr[1], 20, (com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(this.c.getWaterMarkerPositon()) - 80) - iArr[1], 51);
        } else {
            a(view, iArr[0], iArr[1], 0, 0, 51);
        }
    }

    private void a(View view, a aVar) {
        int[] iArr = new int[2];
        a(view, ((ViewGroup.LayoutParams) aVar).width, ((ViewGroup.LayoutParams) aVar).height, iArr);
        if (view instanceof fh) {
            a(view, iArr[0], iArr[1], getWidth() - iArr[0], getHeight(), aVar.d);
        } else if (view instanceof fc) {
            a(view, iArr[0], iArr[1], getWidth() - iArr[0], iArr[1], aVar.d);
        } else if (view instanceof fa) {
            a(view, iArr[0], iArr[1], 0, 0, aVar.d);
        } else if (aVar.a != null) {
            IPoint obtain = IPoint.obtain();
            MapConfig mapConfig = this.c.getMapConfig();
            GLMapState mapProjection = this.c.getMapProjection();
            if (!(mapConfig == null || mapProjection == null)) {
                FPoint obtain2 = FPoint.obtain();
                FPoint fPoint = aVar.a;
                mapProjection.p20ToScreenPoint((int) ((PointF) fPoint).x, (int) ((PointF) fPoint).y, obtain2);
                ((Point) obtain).x = (int) ((PointF) obtain2).x;
                ((Point) obtain).y = (int) ((PointF) obtain2).y;
                obtain2.recycle();
            }
            int xVar = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(obtain) + aVar.b;
            ((Point) obtain).x = xVar;
            int yVar = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(obtain) + aVar.c;
            ((Point) obtain).y = yVar;
            a(view, iArr[0], iArr[1], xVar, yVar, aVar.d);
            obtain.recycle();
        }
    }

    private View a(BaseOverlayImp baseOverlayImp) throws RemoteException {
        Throwable th;
        View view;
        Throwable th2;
        View view2;
        View view3 = null;
        if (baseOverlayImp instanceof cu) {
            Marker marker = new Marker((cu) baseOverlayImp);
            try {
                if (this.n == null) {
                    this.n = ef.a(this.d, "infowindow_bg.9.png");
                }
            } catch (Throwable th3) {
                hd.c(th3, "MapOverlayViewGroup", "showInfoWindow decodeDrawableFromAsset");
                th3.printStackTrace();
            }
            try {
                if (this.q) {
                    view2 = this.b.a((BasePointOverlay) marker);
                    if (view2 == null) {
                        try {
                            view2 = this.b.b((BasePointOverlay) marker);
                        } catch (Throwable th4) {
                            th2 = th4;
                            view3 = view2;
                            hd.c(th2, "MapOverlayViewGroup", "getInfoWindow or getInfoContents");
                            th2.printStackTrace();
                            return view3;
                        }
                    }
                    this.p = view2;
                    this.q = false;
                } else {
                    view2 = this.p;
                }
                if (view2 == null) {
                    if (!this.b.a()) {
                        return null;
                    }
                    view2 = this.b.a((BasePointOverlay) marker);
                }
                view3 = view2;
                if (view3 != null && view3.getBackground() == null) {
                    view3.setBackground(this.n);
                }
            } catch (Throwable th5) {
                th2 = th5;
                hd.c(th2, "MapOverlayViewGroup", "getInfoWindow or getInfoContents");
                th2.printStackTrace();
                return view3;
            }
        } else {
            try {
                if (this.n == null) {
                    this.n = ef.a(this.d, "infowindow_bg.9.png");
                }
            } catch (Throwable th6) {
                hd.c(th6, "MapOverlayViewGroup", "showInfoWindow decodeDrawableFromAsset");
                th6.printStackTrace();
            }
            try {
                GL3DModel gL3DModel = new GL3DModel((cr) baseOverlayImp);
                if (this.q) {
                    view = this.b.a(gL3DModel);
                    if (view == null) {
                        try {
                            view = this.b.b(gL3DModel);
                        } catch (Throwable th7) {
                            th = th7;
                            view3 = view;
                            hd.c(th, "MapOverlayViewGroup", "getInfoWindow or getInfoContents");
                            th.printStackTrace();
                            return view3;
                        }
                    }
                    this.p = view;
                    this.q = false;
                } else {
                    view = this.p;
                }
                if (view == null) {
                    if (!this.b.a()) {
                        return null;
                    }
                    view = this.b.a(gL3DModel);
                }
                if (view.getBackground() == null) {
                    view.setBackground(this.n);
                }
                return view;
            } catch (Throwable th8) {
                th = th8;
                hd.c(th, "MapOverlayViewGroup", "getInfoWindow or getInfoContents");
                th.printStackTrace();
                return view3;
            }
        }
        return view3;
    }

    private void a(View view, int i2, int i3) throws RemoteException {
        int i4;
        int i5;
        if (view != null) {
            View view2 = this.l;
            if (view2 != null) {
                if (view != view2) {
                    view2.clearFocus();
                    removeView(this.l);
                } else {
                    return;
                }
            }
            this.l = view;
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            this.l.setDrawingCacheEnabled(true);
            this.l.setDrawingCacheQuality(0);
            this.m.getRect();
            if (layoutParams != null) {
                int i6 = layoutParams.width;
                i4 = layoutParams.height;
                i5 = i6;
            } else {
                i5 = -2;
                i4 = -2;
            }
            addView(this.l, new a(i5, i4, this.m.getGeoPosition(), i2, i3, 81));
        }
    }

    private void a(View view, int i2, int i3, int[] iArr) {
        View view2;
        if ((view instanceof ListView) && (view2 = (View) view.getParent()) != null) {
            iArr[0] = view2.getWidth();
            iArr[1] = view2.getHeight();
        }
        if (i2 <= 0 || i3 <= 0) {
            view.measure(0, 0);
        }
        if (i2 == -2) {
            iArr[0] = view.getMeasuredWidth();
        } else if (i2 == -1) {
            iArr[0] = getMeasuredWidth();
        } else {
            iArr[0] = i2;
        }
        if (i3 == -2) {
            iArr[1] = view.getMeasuredHeight();
        } else if (i3 == -1) {
            iArr[1] = getMeasuredHeight();
        } else {
            iArr[1] = i3;
        }
    }

    private void a(View view, int i2, int i3, int i4, int i5, int i6) {
        int i7;
        int i8 = i6 & 7;
        int i9 = i6 & 112;
        if (i8 == 5) {
            i4 -= i2;
        } else if (i8 == 1) {
            i4 -= i2 / 2;
        }
        if (i9 == 80) {
            i5 -= i3;
        } else {
            if (i9 == 17) {
                i7 = i3 / 2;
            } else if (i9 == 16) {
                i5 /= 2;
                i7 = i3 / 2;
            }
            i5 -= i7;
        }
        view.layout(i4, i5, i4 + i2, i5 + i3);
        if (view instanceof IGLSurfaceView) {
            this.c.changeSize(i2, i3);
        }
    }

    public void a(Canvas canvas) {
        Bitmap drawingCache;
        View view = this.l;
        if (view != null && this.m != null && (drawingCache = view.getDrawingCache(true)) != null) {
            canvas.drawBitmap(drawingCache, (float) this.l.getLeft(), (float) this.l.getTop(), new Paint());
        }
    }

    public void a(fb.a aVar) {
        fb fbVar = this.j;
        if (fbVar == null) {
            this.a.a(this, aVar);
            return;
        }
        fbVar.a(aVar);
        Log.d("MapOverlayViewGroup", "setOnIndoorFloorSwitchListener");
    }
}
