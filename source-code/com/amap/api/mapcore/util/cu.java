package com.amap.api.mapcore.util;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.os.Build;
import android.os.RemoteException;
import android.util.Log;
import android.view.animation.AnimationUtils;
import com.amap.api.maps.AMapException;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.animation.Animation;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.animation.GLAnimation;
import com.autonavi.amap.mapcore.animation.GLAnimationSet;
import com.autonavi.amap.mapcore.animation.GLTransformation;
import com.autonavi.amap.mapcore.animation.GLTranslateAnimation;
import com.autonavi.amap.mapcore.interfaces.IMarkerAction;
import com.autonavi.amap.mapcore.interfaces.IOverlayImage;
import com.autonavi.base.ae.gmap.GLMapState;
import com.autonavi.base.amap.api.mapcore.BaseOverlayImp;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.api.mapcore.overlays.IMarkerDelegate;
import com.autonavi.base.amap.api.mapcore.overlays.IOverlayImageDelegate;
import com.autonavi.base.amap.mapcore.FPoint;
import com.autonavi.base.amap.mapcore.Rectangle;
import com.autonavi.base.amap.mapcore.interfaces.IAnimation;
import com.taobao.weex.common.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: Taobao */
public class cu extends BaseOverlayImp implements IMarkerAction, IMarkerDelegate, IAnimation {
    private static int i;
    private float A = 1.0f;
    private float B = 1.0f;
    private float C = 1.0f;
    private MarkerOptions D;
    private boolean E = false;
    private boolean F = true;
    private int G = 5;
    private boolean H = true;
    private boolean I = true;
    private boolean J = false;
    private boolean K = false;
    private boolean L = false;
    private boolean M = true;
    private FPoint N = FPoint.obtain();
    private Point O = new Point();
    private float P;
    private float Q;
    private int R = 0;
    private int S = 0;
    private x T;
    private x[] U = null;
    private boolean V = false;
    private String W;
    private LatLng X;
    private LatLng Y;
    private String Z;
    float[] a;
    private String aa;
    private float ab = 0.5f;
    private float ac = 1.0f;
    private boolean ad = false;
    private boolean ae = true;
    private u af;
    private Object ag;
    private boolean ah = false;
    private List<BitmapDescriptor> ai = new CopyOnWriteArrayList();
    private boolean aj = false;
    private boolean ak = false;
    private boolean al = false;
    private boolean am = true;
    private int an = 0;
    private int ao = 20;
    private boolean ap = false;
    private int aq;
    private int ar;
    private long as = 0;
    private float at = Float.MAX_VALUE;
    private float au = Float.MIN_VALUE;
    private float av = Float.MIN_VALUE;
    private float aw = Float.MAX_VALUE;
    float[] b;
    Rect c = new Rect(0, 0, 0, 0);
    GLTransformation d = null;
    GLTransformation e = null;
    GLAnimation f;
    GLAnimation g;
    Object h = new Object();
    private boolean j;
    private float k;
    private boolean l = false;
    private boolean m = false;
    private boolean n = false;
    private float o = 0.0f;
    private float p = 0.0f;
    private boolean q = false;
    private int r = 0;
    private int s = 0;
    private int t = 0;
    private int u = 0;
    private int v;
    private int w;
    private FPoint x = FPoint.obtain();
    private float[] y = {-1.0f, -1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, -1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
    private float z = 0.0f;

    public cu(MarkerOptions markerOptions, u uVar) {
        this.af = uVar;
        setMarkerOptions(markerOptions);
    }

    private static String a(String str) {
        i++;
        return str + i;
    }

    private void c() {
        if (this.af.c() != null) {
            this.af.c().setRunLowFrame(false);
        }
    }

    private void d() {
        try {
            if (this.T.a()) {
                this.y[4] = this.T.d();
                this.y[5] = this.T.c();
                this.y[13] = this.T.b();
                this.y[14] = this.T.c();
                this.y[22] = this.T.b();
                this.y[23] = this.T.e();
                this.y[31] = this.T.d();
                this.y[32] = this.T.e();
                return;
            }
            this.y[4] = this.T.g();
            this.y[5] = this.T.i();
            this.y[13] = this.T.h();
            this.y[14] = this.T.i();
            this.y[22] = this.T.h();
            this.y[23] = this.T.f();
            this.y[31] = this.T.g();
            this.y[32] = this.T.f();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void e() {
        GLTransformation gLTransformation;
        GLAnimation gLAnimation;
        if (this.M || (gLAnimation = this.f) == null || gLAnimation.hasEnded()) {
            if (!(this.f == null || ((gLTransformation = this.d) == null && this.e == null))) {
                if (gLTransformation == null || Double.isNaN(gLTransformation.scaleX) || Double.isNaN(this.d.scaleY)) {
                    GLTransformation gLTransformation2 = this.e;
                    if (gLTransformation2 != null && !Double.isNaN(gLTransformation2.scaleX) && !Double.isNaN(this.e.scaleY)) {
                        double d2 = (double) this.A;
                        GLTransformation gLTransformation3 = this.e;
                        double d3 = gLTransformation3.scaleX;
                        if (!(d2 == d3 && ((double) this.B) == gLTransformation3.scaleY)) {
                            this.A = (float) d3;
                            this.B = (float) gLTransformation3.scaleY;
                        }
                    }
                } else {
                    GLTransformation gLTransformation4 = this.d;
                    this.A = (float) gLTransformation4.scaleX;
                    this.B = (float) gLTransformation4.scaleY;
                }
                GLTransformation gLTransformation5 = this.d;
                if (gLTransformation5 == null || Double.isNaN(gLTransformation5.rotate)) {
                    GLTransformation gLTransformation6 = this.e;
                    if (gLTransformation6 != null && !Double.isNaN(gLTransformation6.rotate)) {
                        double d4 = (double) this.o;
                        double d5 = this.e.rotate;
                        if (d4 != d5) {
                            setRotateAngle((float) d5);
                        }
                    }
                } else {
                    setRotateAngle((float) this.d.rotate);
                }
                GLTransformation gLTransformation7 = this.d;
                if (gLTransformation7 == null || Double.isNaN(gLTransformation7.x) || Double.isNaN(this.d.y)) {
                    GLTransformation gLTransformation8 = this.e;
                    if (gLTransformation8 != null && !Double.isNaN(gLTransformation8.x) && !Double.isNaN(this.e.y)) {
                        double d6 = (double) this.v;
                        GLTransformation gLTransformation9 = this.e;
                        double d7 = gLTransformation9.x;
                        if (!(d6 == d7 && ((double) this.w) == gLTransformation9.y)) {
                            a(d7, gLTransformation9.y);
                        }
                    }
                } else {
                    GLTransformation gLTransformation10 = this.d;
                    a(gLTransformation10.x, gLTransformation10.y);
                }
                GLTransformation gLTransformation11 = this.d;
                if (gLTransformation11 == null || Double.isNaN(gLTransformation11.alpha)) {
                    GLTransformation gLTransformation12 = this.e;
                    if (gLTransformation12 != null && !Double.isNaN(gLTransformation12.alpha)) {
                        double d8 = (double) this.C;
                        double d9 = this.e.alpha;
                        if (d8 != d9) {
                            this.C = (float) d9;
                        }
                    }
                } else {
                    this.C = (float) this.d.alpha;
                }
            }
            this.M = true;
            this.d = null;
            this.e = null;
            List<BitmapDescriptor> list = this.ai;
            if (list != null && list.size() == 1) {
                this.am = true;
                return;
            }
            return;
        }
        c();
        synchronized (this.h) {
            if (this.e == null || this.al) {
                GLTransformation gLTransformation13 = new GLTransformation();
                this.e = gLTransformation13;
                gLTransformation13.scaleX = (double) this.A;
                gLTransformation13.scaleY = (double) this.B;
                gLTransformation13.rotate = (double) this.o;
                gLTransformation13.y = (double) this.w;
                gLTransformation13.x = (double) this.v;
                gLTransformation13.alpha = (double) this.C;
                this.al = false;
            }
            if (this.d == null) {
                this.d = new GLTransformation();
            }
            this.d.clear();
            this.f.getTransformation(AnimationUtils.currentAnimationTimeMillis(), this.d);
            GLTransformation gLTransformation14 = this.d;
            if (gLTransformation14 != null) {
                if (!Double.isNaN(gLTransformation14.scaleX) && !Double.isNaN(this.d.scaleY)) {
                    GLTransformation gLTransformation15 = this.d;
                    this.A = (float) gLTransformation15.scaleX;
                    this.B = (float) gLTransformation15.scaleY;
                }
                if (!Double.isNaN(this.d.rotate)) {
                    setRotateAngle((float) this.d.rotate);
                }
                if (!Double.isNaN(this.d.x) && !Double.isNaN(this.d.y)) {
                    GLTransformation gLTransformation16 = this.d;
                    a(gLTransformation16.x, gLTransformation16.y);
                }
                if (!Double.isNaN(this.d.alpha)) {
                    this.C = (float) this.d.alpha;
                }
            }
        }
        this.n = true;
        this.am = false;
    }

    private int f() {
        int[] iArr = {0};
        GLES20.glGenTextures(1, iArr, 0);
        return iArr[0];
    }

    private void g() {
        if (this.af.c() != null && this.af.c().getMapConfig() != null) {
            this.P = this.af.c().getMapConfig().getMapPerPixelUnitLength() * ((float) getWidth());
            this.Q = this.af.c().getMapConfig().getMapPerPixelUnitLength() * ((float) getHeight());
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.overlays.IMarkerDelegate
    public FPoint anchorUVoff() {
        FPoint obtain = FPoint.obtain();
        List<BitmapDescriptor> list = this.ai;
        if (!(list == null || list.size() == 0)) {
            ((PointF) obtain).x = ((float) getWidth()) * this.ab;
            ((PointF) obtain).y = ((float) getHeight()) * this.ac;
        }
        return obtain;
    }

    public IPoint b() {
        if (this.X == null && !this.ap) {
            return null;
        }
        FPoint obtain = FPoint.obtain();
        this.af.c().getMapProjection().p20ToScreenPoint(this.v, this.w, obtain);
        return IPoint.obtain((int) ((PointF) obtain).x, (int) ((PointF) obtain).y);
    }

    @Override // com.autonavi.base.amap.api.mapcore.overlays.IOverlayImageDelegate
    public boolean calFPoint() {
        try {
            u uVar = this.af;
            if (uVar == null || uVar.c() == null) {
                return false;
            }
            if (this.af.c().getMapProjection() == null) {
                return false;
            }
            if (this.x == null) {
                this.x = FPoint.obtain();
            }
            if (this.ap) {
                IPoint obtain = IPoint.obtain();
                this.af.c().getPixel2Geo(this.aq, this.ar, obtain);
                this.v = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(obtain);
                this.w = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(obtain);
                obtain.recycle();
                this.af.c().geo2Map(this.v, this.w, this.x);
            } else {
                this.af.c().geo2Map(this.v, this.w, this.x);
            }
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.overlays.IOverlayImageDelegate, com.autonavi.base.amap.api.mapcore.InfoWindowCalculate
    public boolean checkInBounds() {
        if (this.ap) {
            return true;
        }
        try {
            if (this.x == null) {
                return false;
            }
            if (!this.M) {
                return true;
            }
            Point point = this.O;
            point.x = this.v;
            point.y = this.w;
            Rectangle geoRectangle = this.af.c().getMapConfig().getGeoRectangle();
            if (geoRectangle.contains(this.v, this.w)) {
                return true;
            }
            g();
            int i2 = (int) (this.A * this.P);
            int i3 = (int) (this.B * this.Q);
            int i4 = (int) (((float) this.v) - (((float) i2) * this.ab));
            int i5 = (int) (((float) this.w) - (((float) i3) * this.ac));
            if (!geoRectangle.contains(i4, i5) && !geoRectangle.isOverlap(i4, i5, i2, i3)) {
                return false;
            }
            return true;
        } catch (Throwable th) {
            hd.c(th, "MarkerDelegateImp", "checkInBounds");
            return false;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlayImage
    public void destroy(boolean z2) {
        try {
            this.V = true;
            if (z2) {
                remove();
            }
            int i2 = 0;
            if (this.af != null) {
                int i3 = 0;
                while (true) {
                    x[] xVarArr = this.U;
                    if (xVarArr == null || i3 >= xVarArr.length) {
                        break;
                    }
                    x xVar = xVarArr[i3];
                    if (xVar != null) {
                        this.af.a(xVar);
                        this.af.c().removeTextureItem(xVar.p());
                    }
                    i3++;
                }
            }
            while (true) {
                List<BitmapDescriptor> list = this.ai;
                if (list == null || i2 >= list.size()) {
                    this.X = null;
                    this.ag = null;
                    this.U = null;
                } else {
                    this.ai.get(i2).recycle();
                    i2++;
                }
            }
            this.X = null;
            this.ag = null;
            this.U = null;
        } catch (Throwable th) {
            hd.c(th, "MarkerDelegateImp", Constants.Event.SLOT_LIFECYCLE.DESTORY);
            th.printStackTrace();
            Log.d("destroy erro", "MarkerDelegateImp destroy");
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.overlays.IOverlayImageDelegate
    public void drawMarker(IAMapDelegate iAMapDelegate) {
    }

    @Override // com.autonavi.base.amap.api.mapcore.overlays.IOverlayImageDelegate
    public void drawMarker(IAMapDelegate iAMapDelegate, float[] fArr, int i2, float f2) {
        if (!(this.V || (this.X == null && !this.ap) || this.ai == null)) {
            try {
                if (!this.l) {
                    this.as = System.currentTimeMillis();
                    this.l = true;
                }
                if (this.ap && this.I) {
                    IPoint obtain = IPoint.obtain();
                    iAMapDelegate.getPixel2Geo(this.aq, this.ar, obtain);
                    this.v = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(obtain);
                    this.w = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(obtain);
                    obtain.recycle();
                }
                ((PointF) this.x).x = (float) (this.v - ((int) iAMapDelegate.getMapConfig().getSX()));
                FPoint fPoint = this.x;
                float f3 = ((PointF) fPoint).x;
                if (f3 > 1.34217728E8f) {
                    ((PointF) fPoint).x = f3 - 2.68435456E8f;
                } else if (f3 < -1.34217728E8f) {
                    ((PointF) fPoint).x = f3 + 2.68435456E8f;
                }
                ((PointF) fPoint).y = (float) (this.w - ((int) iAMapDelegate.getMapConfig().getSY()));
                int width = getWidth();
                int height = getHeight();
                e();
                a(iAMapDelegate, f2, width, height);
                if (!this.J || !this.am) {
                    d();
                    this.J = true;
                }
                a(fArr, i2);
                if (this.n && isInfoWindowShown()) {
                    this.af.c().redrawInfoWindow();
                    if (System.currentTimeMillis() - this.as > ((long) 1000)) {
                        this.n = false;
                    }
                }
            } catch (Throwable th) {
                hd.c(th, "MarkerDelegateImp", "drawMarker");
            }
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlayImage
    public boolean equalsRemote(IOverlayImage iOverlayImage) throws RemoteException {
        return equals(iOverlayImage) || iOverlayImage.getId().equals(getId());
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMarkerAction
    public float getAlpha() {
        return this.C;
    }

    @Override // com.autonavi.base.amap.api.mapcore.InfoWindowCalculate, com.autonavi.base.amap.api.mapcore.overlays.IMarkerDelegate
    public IPoint getAnchor() {
        IPoint b2 = b();
        if (b2 == null) {
            return null;
        }
        return b2;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlayImage
    public float getAnchorU() {
        return this.ab;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlayImage
    public float getAnchorV() {
        return this.ac;
    }

    @Override // com.autonavi.base.amap.api.mapcore.InfoWindowCalculate, com.autonavi.base.amap.api.mapcore.overlays.IMarkerDelegate
    public synchronized BitmapDescriptor getBitmapDescriptor() {
        try {
            List<BitmapDescriptor> list = this.ai;
            if (list == null) {
                return null;
            }
            if (list.size() == 0) {
                a();
                this.ai.add(BitmapDescriptorFactory.defaultMarker());
            } else if (this.ai.get(0) == null) {
                this.ai.clear();
                return getBitmapDescriptor();
            }
            return this.ai.get(0);
        } catch (Throwable th) {
            hd.c(th, "MarkerDelegateImp", "getBitmapDescriptor");
            th.printStackTrace();
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMarkerAction
    public int getDisplayLevel() {
        return this.G;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMarker
    public IPoint getGeoPoint() {
        IPoint obtain = IPoint.obtain();
        if (this.ap) {
            this.af.c().getPixel2Geo(this.aq, this.ar, obtain);
            return obtain;
        }
        obtain.set(this.v, this.w);
        return obtain;
    }

    @Override // com.autonavi.base.amap.api.mapcore.InfoWindowCalculate
    public FPoint getGeoPosition() {
        IPoint geoPoint = getGeoPoint();
        return FPoint.obtain((float) com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(geoPoint), (float) com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(geoPoint));
    }

    @Override // com.autonavi.base.amap.api.mapcore.InfoWindowCalculate, com.autonavi.base.amap.api.mapcore.overlays.IMarkerDelegate
    public int getHeight() {
        try {
            return this.S;
        } catch (Throwable unused) {
            return 0;
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.overlays.IOverlayImageDelegate
    public IAnimation getIAnimation() {
        return this;
    }

    @Override // com.autonavi.base.amap.api.mapcore.overlays.IOverlayImageDelegate, com.autonavi.amap.mapcore.interfaces.IMarker
    public IMarkerAction getIMarkerAction() {
        return this;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMarker
    public synchronized ArrayList<BitmapDescriptor> getIcons() {
        List<BitmapDescriptor> list = this.ai;
        if (list == null || list.size() <= 0) {
            return null;
        }
        ArrayList<BitmapDescriptor> arrayList = new ArrayList<>();
        for (BitmapDescriptor bitmapDescriptor : this.ai) {
            arrayList.add(bitmapDescriptor);
        }
        return arrayList;
    }

    @Override // com.autonavi.base.amap.api.mapcore.BaseOverlayImp, com.autonavi.amap.mapcore.interfaces.IOverlayImage
    public String getId() {
        if (this.W == null) {
            this.W = a("Marker");
        }
        return this.W;
    }

    @Override // com.autonavi.base.amap.api.mapcore.InfoWindowCalculate, com.autonavi.base.amap.api.mapcore.overlays.IMarkerDelegate
    public int getInfoWindowOffsetX() {
        return this.r;
    }

    @Override // com.autonavi.base.amap.api.mapcore.InfoWindowCalculate, com.autonavi.base.amap.api.mapcore.overlays.IMarkerDelegate
    public int getInfoWindowOffsetY() {
        return this.s;
    }

    @Override // com.autonavi.base.amap.api.mapcore.BaseOverlayImp, com.autonavi.amap.mapcore.interfaces.IOverlayImage
    public Object getObject() {
        return this.ag;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMarkerAction
    public MarkerOptions getOptions() {
        return this.D;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMarker
    public int getPeriod() {
        return this.ao;
    }

    @Override // com.autonavi.base.amap.api.mapcore.BaseOverlayImp, com.autonavi.amap.mapcore.interfaces.IOverlayImage
    public LatLng getPosition() {
        if (!this.ap || this.x == null) {
            return this.X;
        }
        DPoint obtain = DPoint.obtain();
        IPoint obtain2 = IPoint.obtain();
        calFPoint();
        if (this.af.c() == null) {
            return this.X;
        }
        IAMapDelegate c2 = this.af.c();
        FPoint fPoint = this.x;
        c2.map2Geo(((PointF) fPoint).x, ((PointF) fPoint).y, obtain2);
        GLMapState.geo2LonLat(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(obtain2), com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(obtain2), obtain);
        LatLng latLng = new LatLng(obtain.y, obtain.x);
        obtain2.recycle();
        obtain.recycle();
        return latLng;
    }

    @Override // com.autonavi.base.amap.api.mapcore.InfoWindowCalculate, com.autonavi.base.amap.api.mapcore.overlays.IMarkerDelegate
    public int getRealInfoWindowOffsetX() {
        return this.t;
    }

    @Override // com.autonavi.base.amap.api.mapcore.InfoWindowCalculate, com.autonavi.base.amap.api.mapcore.overlays.IMarkerDelegate
    public int getRealInfoWindowOffsetY() {
        return this.u;
    }

    @Override // com.autonavi.base.amap.api.mapcore.InfoWindowCalculate
    public LatLng getRealPosition() {
        try {
            if (!this.ap) {
                return this.aj ? this.Y : this.X;
            }
            DPoint obtain = DPoint.obtain();
            this.af.c().getPixel2LatLng(this.aq, this.ar, obtain);
            double d2 = obtain.y;
            LatLng latLng = new LatLng(d2, d2);
            obtain.recycle();
            return latLng;
        } catch (Throwable th) {
            hd.c(th, "MarkerDelegateImp", "getRealPosition");
            return null;
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.overlays.IOverlayImageDelegate, com.autonavi.base.amap.api.mapcore.InfoWindowCalculate
    public Rect getRect() {
        if (this.y == null) {
            this.c.set(0, 0, 0, 0);
            return this.c;
        }
        try {
            GLMapState mapProjection = this.af.c().getMapProjection();
            if (mapProjection == null) {
                return new Rect(0, 0, 0, 0);
            }
            int width = getWidth();
            int height = getHeight();
            FPoint obtain = FPoint.obtain();
            if (this.ap) {
                ((PointF) obtain).x = (float) this.aq;
                ((PointF) obtain).y = (float) this.ar;
            } else {
                mapProjection.p20ToScreenPoint(this.v, this.w, obtain);
            }
            Matrix.setIdentityM(this.a, 0);
            Matrix.rotateM(this.a, 0, -this.o, 0.0f, 0.0f, 1.0f);
            if (this.q) {
                Matrix.rotateM(this.a, 0, this.af.c().getMapConfig().getSC(), 1.0f, 0.0f, 0.0f);
                Matrix.rotateM(this.a, 0, this.af.c().getMapConfig().getSR(), 0.0f, 0.0f, 1.0f);
            }
            float[] fArr = new float[4];
            float[] fArr2 = this.b;
            float f2 = (float) (-width);
            fArr2[0] = this.ab * f2;
            float f3 = (float) height;
            fArr2[1] = this.ac * f3;
            fArr2[2] = 0.0f;
            fArr2[3] = 1.0f;
            Matrix.multiplyMV(fArr, 0, this.a, 0, fArr2, 0);
            Rect rect = this.c;
            float f4 = ((PointF) obtain).x;
            float f5 = ((PointF) obtain).y;
            rect.set((int) (fArr[0] + f4), (int) (f5 - fArr[1]), (int) (f4 + fArr[0]), (int) (f5 - fArr[1]));
            float[] fArr3 = this.b;
            float f6 = (float) width;
            fArr3[0] = (1.0f - this.ab) * f6;
            fArr3[1] = f3 * this.ac;
            fArr3[2] = 0.0f;
            fArr3[3] = 1.0f;
            Matrix.multiplyMV(fArr, 0, this.a, 0, fArr3, 0);
            this.c.union((int) (((PointF) obtain).x + fArr[0]), (int) (((PointF) obtain).y - fArr[1]));
            float[] fArr4 = this.b;
            fArr4[0] = f6 * (1.0f - this.ab);
            float f7 = (float) (-height);
            fArr4[1] = (1.0f - this.ac) * f7;
            fArr4[2] = 0.0f;
            fArr4[3] = 1.0f;
            Matrix.multiplyMV(fArr, 0, this.a, 0, fArr4, 0);
            this.c.union((int) (((PointF) obtain).x + fArr[0]), (int) (((PointF) obtain).y - fArr[1]));
            float[] fArr5 = this.b;
            fArr5[0] = f2 * this.ab;
            fArr5[1] = f7 * (1.0f - this.ac);
            fArr5[2] = 0.0f;
            fArr5[3] = 1.0f;
            Matrix.multiplyMV(fArr, 0, this.a, 0, fArr5, 0);
            this.c.union((int) (((PointF) obtain).x + fArr[0]), (int) (((PointF) obtain).y - fArr[1]));
            this.t = (int) (((float) this.c.centerX()) - ((PointF) obtain).x);
            this.u = (int) (((float) this.c.top) - ((PointF) obtain).y);
            obtain.recycle();
            return this.c;
        } catch (Throwable th) {
            hd.c(th, "MarkerDelegateImp", "getRect");
            th.printStackTrace();
            return new Rect(0, 0, 0, 0);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.BaseOverlayImp, com.autonavi.amap.mapcore.interfaces.IOverlayImage
    public float getRotateAngle() {
        c();
        return this.p;
    }

    @Override // com.autonavi.base.amap.api.mapcore.BaseOverlayImp, com.autonavi.amap.mapcore.interfaces.IMarker
    public String getSnippet() {
        return this.aa;
    }

    @Override // com.autonavi.base.amap.api.mapcore.overlays.IOverlayImageDelegate
    public int getTextureId() {
        try {
            List<BitmapDescriptor> list = this.ai;
            if (list == null) {
                return 0;
            }
            if (list.size() <= 0) {
                return 0;
            }
            return this.T.k();
        } catch (Throwable unused) {
            return 0;
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.BaseOverlayImp, com.autonavi.amap.mapcore.interfaces.IMarker
    public String getTitle() {
        return this.Z;
    }

    @Override // com.autonavi.base.amap.api.mapcore.InfoWindowCalculate, com.autonavi.base.amap.api.mapcore.overlays.IMarkerDelegate
    public int getWidth() {
        try {
            return this.R;
        } catch (Throwable unused) {
            return 0;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlayImage
    public float getZIndex() {
        return this.z;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlayImage
    public int hashCodeRemote() {
        return super.hashCode();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMarker
    public void hideInfoWindow() {
        if (isInfoWindowShown()) {
            this.af.b(this);
            c();
            this.m = false;
        }
        this.n = false;
    }

    @Override // com.autonavi.base.amap.api.mapcore.overlays.IOverlayImageDelegate
    public boolean isAllowLow() {
        return this.am;
    }

    @Override // com.autonavi.base.amap.api.mapcore.overlays.IOverlayImageDelegate
    public boolean isBelowMaskLayer() {
        return this.K;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMarkerAction
    public boolean isClickable() {
        return this.H;
    }

    @Override // com.autonavi.base.amap.api.mapcore.InfoWindowCalculate, com.autonavi.base.amap.api.mapcore.overlays.IMarkerDelegate
    public boolean isContains() {
        return this.af.c(this);
    }

    @Override // com.autonavi.base.amap.api.mapcore.InfoWindowCalculate, com.autonavi.base.amap.api.mapcore.overlays.IMarkerDelegate
    public boolean isDestory() {
        return this.V;
    }

    @Override // com.autonavi.base.amap.api.mapcore.BaseOverlayImp, com.autonavi.amap.mapcore.interfaces.IMarker
    public boolean isDraggable() {
        return this.ad;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMarker
    public boolean isFlat() {
        return this.q;
    }

    @Override // com.autonavi.base.amap.api.mapcore.BaseOverlayImp, com.autonavi.amap.mapcore.interfaces.IMarkerAction
    public boolean isInfoWindowAutoOverturn() {
        return this.E;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMarkerAction, com.autonavi.base.amap.api.mapcore.InfoWindowCalculate, com.autonavi.base.amap.api.mapcore.overlays.IMarkerDelegate
    public boolean isInfoWindowEnable() {
        return this.F;
    }

    @Override // com.autonavi.base.amap.api.mapcore.overlays.IOverlayImageDelegate, com.autonavi.amap.mapcore.interfaces.IMarker
    public boolean isInfoWindowShown() {
        return this.m;
    }

    @Override // com.autonavi.base.amap.api.mapcore.overlays.IOverlayImageDelegate
    public boolean isOnTap() {
        return this.L;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMarker
    public boolean isPerspective() {
        return this.ah;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMarker
    public boolean isRemoved() {
        try {
            return !this.af.c(this);
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.InfoWindowCalculate, com.autonavi.base.amap.api.mapcore.overlays.IMarkerDelegate
    public boolean isViewMode() {
        return this.ap;
    }

    @Override // com.autonavi.base.amap.api.mapcore.BaseOverlayImp, com.autonavi.amap.mapcore.interfaces.IOverlayImage
    public boolean isVisible() {
        return this.ae;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0057 A[Catch:{ all -> 0x00e7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0082 A[Catch:{ all -> 0x00e7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0092 A[Catch:{ all -> 0x00e7 }] */
    @Override // com.autonavi.base.amap.api.mapcore.overlays.IOverlayImageDelegate
    public void loadTexture(IAMapDelegate iAMapDelegate) {
        int i2;
        x xVar;
        Bitmap bitmap;
        int baseOverlayTextureID;
        if (!this.ak) {
            synchronized (this) {
                try {
                    x[] xVarArr = this.U;
                    if (xVarArr != null) {
                        for (x xVar2 : xVarArr) {
                            if (xVar2 != null) {
                                this.af.a(xVar2);
                            }
                        }
                    }
                    this.U = null;
                    List<BitmapDescriptor> list = this.ai;
                    if (list != null) {
                        this.U = new x[list.size()];
                        boolean z2 = Build.VERSION.SDK_INT >= 12;
                        int i3 = 0;
                        for (BitmapDescriptor bitmapDescriptor : this.ai) {
                            if (z2) {
                                xVar = iAMapDelegate.getTextureItem(bitmapDescriptor);
                                if (xVar != null) {
                                    i2 = xVar.k();
                                    if (xVar == null) {
                                        xVar = new x(bitmapDescriptor, i2);
                                    }
                                    if (i2 == 0 && (bitmap = bitmapDescriptor.getBitmap()) != null && !bitmap.isRecycled()) {
                                        this.R = bitmap.getWidth();
                                        this.S = bitmap.getHeight();
                                        baseOverlayTextureID = this.af.c().getBaseOverlayTextureID();
                                        if (baseOverlayTextureID != 0) {
                                            int f2 = f();
                                            xVar.a(f2);
                                            if (z2) {
                                                iAMapDelegate.addTextureItem(xVar);
                                            }
                                            eq.b(f2, bitmap, false);
                                        } else {
                                            if (this.af.a(bitmap, xVar)) {
                                                eq.a(baseOverlayTextureID, a(bitmap), (int) (xVar.g() * 512.0f), (int) (xVar.f() * 1024.0f));
                                                xVar.a(baseOverlayTextureID);
                                            } else {
                                                int f3 = f();
                                                eq.b(f3, bitmap, false);
                                                xVar.a(f3);
                                            }
                                            if (z2) {
                                                iAMapDelegate.addTextureItem(xVar);
                                            }
                                        }
                                    }
                                    xVar.m();
                                    this.U[i3] = xVar;
                                    i3++;
                                }
                            } else {
                                xVar = null;
                            }
                            i2 = 0;
                            if (xVar == null) {
                            }
                            this.R = bitmap.getWidth();
                            this.S = bitmap.getHeight();
                            baseOverlayTextureID = this.af.c().getBaseOverlayTextureID();
                            if (baseOverlayTextureID != 0) {
                            }
                            xVar.m();
                            this.U[i3] = xVar;
                            i3++;
                        }
                        if (this.ai.size() == 1) {
                            this.am = true;
                        } else {
                            this.am = false;
                        }
                        this.J = false;
                        this.ak = true;
                    }
                    calFPoint();
                } catch (Throwable th) {
                    hd.c(th, "MarkerDelegateImp", "loadtexture");
                }
            }
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.overlays.IOverlayImageDelegate
    public synchronized void reLoadTexture() {
        this.ak = false;
    }

    @Override // com.autonavi.base.amap.api.mapcore.BaseOverlayImp, com.autonavi.amap.mapcore.interfaces.IOverlayImage
    public boolean remove() {
        c();
        this.ae = false;
        u uVar = this.af;
        if (uVar != null) {
            return uVar.a((IOverlayImageDelegate) this);
        }
        return false;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMarker
    public void set2Top() {
        this.af.a((IMarkerDelegate) this);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMarkerAction
    public void setAlpha(float f2) {
        this.C = f2;
        this.D.alpha(f2);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlayImage
    public void setAnchor(float f2, float f3) {
        if (this.ab != f2 || this.ac != f3) {
            this.D.anchor(f2, f3);
            this.ab = f2;
            this.ac = f3;
            this.n = true;
            c();
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.BaseOverlayImp, com.autonavi.amap.mapcore.interfaces.IMarker
    public void setAnimation(Animation animation) {
        GLAnimation gLAnimation;
        IAnimation iAnimation = getIAnimation();
        if (iAnimation != null) {
            if (animation == null) {
                gLAnimation = null;
            } else {
                gLAnimation = animation.glAnimation;
            }
            iAnimation.setAnimation(gLAnimation);
        }
    }

    @Override // com.autonavi.base.amap.mapcore.interfaces.IAnimation, com.autonavi.amap.mapcore.interfaces.IMarker
    public void setAnimationListener(Animation.AnimationListener animationListener) {
        GLAnimation gLAnimation = this.g;
        if (gLAnimation != null) {
            gLAnimation.setAnimationListener(animationListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMarkerAction
    public void setAutoOverturnInfoWindow(boolean z2) {
        this.E = z2;
        this.D.autoOverturnInfoWindow(z2);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMarker
    public void setBelowMaskLayer(boolean z2) {
        this.K = z2;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMarkerAction
    public void setClickable(boolean z2) {
        this.H = z2;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMarkerAction
    public void setDisplayLevel(int i2) {
        this.G = i2;
        this.D.displayLevel(i2);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMarker
    public void setDraggable(boolean z2) {
        this.ad = z2;
        this.D.draggable(z2);
        c();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMarkerAction
    public void setFixingPointEnable(boolean z2) {
        this.I = z2;
        if (!z2) {
            boolean z3 = this.ap;
            LatLng position = getPosition();
            this.X = position;
            setPosition(position);
            if (z3) {
                this.ap = true;
            }
        } else if (this.ap && this.X != null) {
            FPoint obtain = FPoint.obtain();
            this.af.c().getMapProjection().p20ToScreenPoint(this.v, this.w, obtain);
            this.aq = (int) ((PointF) obtain).x;
            this.ar = (int) ((PointF) obtain).y;
            obtain.recycle();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMarker
    public void setFlat(boolean z2) throws RemoteException {
        this.q = z2;
        c();
        this.D.setFlat(z2);
    }

    @Override // com.autonavi.base.amap.api.mapcore.BaseOverlayImp, com.autonavi.amap.mapcore.interfaces.IMarker
    public void setGeoPoint(IPoint iPoint) {
        this.ap = false;
        a(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(iPoint), com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(iPoint));
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMarker
    public void setIcon(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor != null) {
            try {
                if (this.ai != null) {
                    synchronized (this) {
                        this.j = false;
                        this.ai.clear();
                        this.ai.add(bitmapDescriptor);
                        this.J = false;
                        this.ak = false;
                        this.l = false;
                        c();
                        this.n = true;
                        this.R = bitmapDescriptor.getWidth();
                        this.S = bitmapDescriptor.getHeight();
                    }
                }
            } catch (Throwable th) {
                hd.c(th, "MarkerDelegateImp", "setIcon");
                th.printStackTrace();
            }
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMarker
    public synchronized void setIcons(ArrayList<BitmapDescriptor> arrayList) {
        if (arrayList != null) {
            try {
                if (this.ai != null) {
                    this.j = false;
                    a(arrayList);
                    this.ak = false;
                    this.l = false;
                    this.J = false;
                    c();
                    this.n = true;
                    return;
                }
            } catch (Throwable th) {
                hd.c(th, "MarkerDelegateImp", "setIcons");
                th.printStackTrace();
            }
        }
        return;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMarkerAction
    public void setInfoWindowEnable(boolean z2) {
        this.F = z2;
        if (!z2) {
            hideInfoWindow();
        }
        this.D.infoWindowEnable(z2);
    }

    @Override // com.autonavi.base.amap.api.mapcore.InfoWindowCalculate, com.autonavi.base.amap.api.mapcore.overlays.IMarkerDelegate
    public void setInfoWindowOffset(int i2, int i3) throws RemoteException {
        this.r = i2;
        this.s = i3;
    }

    @Override // com.autonavi.base.amap.api.mapcore.InfoWindowCalculate, com.autonavi.base.amap.api.mapcore.overlays.IMarkerDelegate
    public void setInfoWindowShown(boolean z2) {
        this.m = z2;
        this.n = true;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMarkerAction
    public void setMarkerOptions(MarkerOptions markerOptions) {
        if (markerOptions != null) {
            this.D = markerOptions;
            this.X = markerOptions.getPosition();
            IPoint obtain = IPoint.obtain();
            this.aj = this.D.isGps();
            if (this.D.getPosition() != null) {
                if (this.aj) {
                    try {
                        double[] a2 = jq.a(this.D.getPosition().longitude, this.D.getPosition().latitude);
                        this.Y = new LatLng(a2[1], a2[0]);
                        GLMapState.lonlat2Geo(a2[0], a2[1], obtain);
                    } catch (Throwable th) {
                        hd.c(th, "MarkerDelegateImp", "create");
                        this.Y = this.D.getPosition();
                    }
                } else {
                    LatLng latLng = this.X;
                    GLMapState.lonlat2Geo(latLng.longitude, latLng.latitude, obtain);
                }
            }
            this.v = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(obtain);
            this.w = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(obtain);
            this.ab = this.D.getAnchorU();
            this.ac = this.D.getAnchorV();
            this.r = this.D.getInfoWindowOffsetX();
            this.s = this.D.getInfoWindowOffsetY();
            this.ao = this.D.getPeriod();
            this.z = this.D.getZIndex();
            this.K = this.D.isBelowMaskLayer();
            calFPoint();
            setIcons(this.D.getIcons());
            this.j = this.D.isRotatingMode();
            this.k = this.D.getAngleOffset();
            this.ae = this.D.isVisible();
            this.aa = this.D.getSnippet();
            this.Z = this.D.getTitle();
            this.ad = this.D.isDraggable();
            this.W = getId();
            this.ah = this.D.isPerspective();
            this.q = this.D.isFlat();
            this.K = this.D.isBelowMaskLayer();
            this.C = this.D.getAlpha();
            setRotateAngle(this.D.getRotateAngle());
            this.G = this.D.getDisplayLevel();
            this.E = this.D.isInfoWindowAutoOverturn();
            this.F = this.D.isInfoWindowEnable();
            this.a = new float[16];
            this.b = new float[4];
            obtain.recycle();
            ea.a().a(this.X, this.Z, this.aa);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.BaseOverlayImp, com.autonavi.amap.mapcore.interfaces.IOverlayImage
    public void setObject(Object obj) {
        this.ag = obj;
    }

    @Override // com.autonavi.base.amap.api.mapcore.overlays.IOverlayImageDelegate
    public void setOnTap(boolean z2) {
        this.L = z2;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMarker
    public void setPeriod(int i2) {
        if (i2 <= 1) {
            this.ao = 1;
        } else {
            this.ao = i2;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMarker
    public void setPerspective(boolean z2) {
        this.ah = z2;
    }

    @Override // com.autonavi.base.amap.api.mapcore.BaseOverlayImp, com.autonavi.amap.mapcore.interfaces.IOverlayImage
    public void setPosition(LatLng latLng) {
        if (latLng == null) {
            hd.c(new AMapException("非法坐标值 latlng is null"), "setPosition", "Marker");
            return;
        }
        this.X = latLng;
        IPoint obtain = IPoint.obtain();
        if (this.aj) {
            try {
                double[] a2 = jq.a(latLng.longitude, latLng.latitude);
                this.Y = new LatLng(a2[1], a2[0]);
                GLMapState.lonlat2Geo(a2[0], a2[1], obtain);
            } catch (Throwable unused) {
                this.Y = latLng;
            }
        } else {
            GLMapState.lonlat2Geo(latLng.longitude, latLng.latitude, obtain);
        }
        this.v = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(obtain);
        this.w = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(obtain);
        this.ap = false;
        calFPoint();
        c();
        this.n = true;
        obtain.recycle();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMarker
    public void setPositionByPixels(int i2, int i3) {
        this.aq = i2;
        this.ar = i3;
        this.ap = true;
        calFPoint();
        c();
        this.n = true;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMarkerAction
    public void setPositionNotUpdate(LatLng latLng) {
        setPosition(latLng);
    }

    @Override // com.autonavi.base.amap.api.mapcore.BaseOverlayImp, com.autonavi.amap.mapcore.interfaces.IOverlayImage
    public void setRotateAngle(float f2) {
        this.D.rotateAngle(f2);
        this.p = f2;
        this.o = (((-f2) % 360.0f) + 360.0f) % 360.0f;
        this.n = true;
        c();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMarkerAction
    public void setRotateAngleNotUpdate(float f2) {
    }

    @Override // com.autonavi.base.amap.api.mapcore.BaseOverlayImp, com.autonavi.amap.mapcore.interfaces.IMarkerAction, com.autonavi.amap.mapcore.interfaces.IMarker
    public void setSnippet(String str) {
        this.aa = str;
        c();
        this.D.snippet(str);
    }

    @Override // com.autonavi.base.amap.api.mapcore.BaseOverlayImp, com.autonavi.amap.mapcore.interfaces.IMarkerAction, com.autonavi.amap.mapcore.interfaces.IMarker
    public void setTitle(String str) {
        this.Z = str;
        c();
        this.D.title(str);
        ea.a().a(this.X, this.Z, this.aa);
    }

    @Override // com.autonavi.base.amap.api.mapcore.BaseOverlayImp, com.autonavi.amap.mapcore.interfaces.IOverlayImage
    public void setVisible(boolean z2) {
        if (this.ae != z2) {
            this.D.visible(z2);
            this.ae = z2;
            if (!z2) {
                this.L = false;
                if (isInfoWindowShown()) {
                    this.af.b(this);
                }
            }
            c();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlayImage
    public void setZIndex(float f2) {
        this.z = f2;
        this.D.zIndex(f2);
        if (this.L) {
            this.L = false;
            this.af.a();
        }
        this.af.f();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMarker
    public void showInfoWindow() {
        if (this.ae && isContains() && !isRemoved() && isInfoWindowEnable()) {
            this.af.a((BaseOverlayImp) this);
            c();
        }
    }

    @Override // com.autonavi.base.amap.mapcore.interfaces.IAnimation, com.autonavi.amap.mapcore.interfaces.IMarker
    public boolean startAnimation() {
        if (this.g != null) {
            synchronized (this.h) {
                GLAnimation gLAnimation = this.g;
                if (gLAnimation instanceof GLAnimationSet) {
                    GLAnimationSet gLAnimationSet = (GLAnimationSet) gLAnimation;
                    for (GLAnimation gLAnimation2 : gLAnimationSet.getAnimations()) {
                        a(gLAnimation2);
                        gLAnimation2.setDuration(gLAnimationSet.getDuration());
                    }
                } else {
                    a(gLAnimation);
                }
                this.M = false;
                GLAnimation gLAnimation3 = this.g;
                this.f = gLAnimation3;
                this.al = true;
                gLAnimation3.start();
            }
            c();
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public synchronized void a() {
        List<BitmapDescriptor> list = this.ai;
        if (list != null) {
            list.clear();
        }
    }

    @Override // com.autonavi.base.amap.mapcore.interfaces.IAnimation
    public void setAnimation(GLAnimation gLAnimation) {
        if (gLAnimation != null) {
            this.g = gLAnimation;
        }
    }

    public synchronized void a(ArrayList<BitmapDescriptor> arrayList) {
        BitmapDescriptor bitmapDescriptor;
        a();
        if (arrayList != null) {
            Iterator<BitmapDescriptor> it = arrayList.iterator();
            while (it.hasNext()) {
                BitmapDescriptor next = it.next();
                if (next != null) {
                    this.ai.add(next);
                }
            }
        }
        if (this.ai.size() == 0) {
            this.ai.add(BitmapDescriptorFactory.defaultMarker());
        }
        if (this.ai.size() > 0 && (bitmapDescriptor = this.ai.get(0)) != null) {
            this.R = bitmapDescriptor.getWidth();
            this.S = bitmapDescriptor.getHeight();
        }
    }

    private void a(IAMapDelegate iAMapDelegate, float f2, int i2, int i3) throws RemoteException {
        float f3 = ((float) ((int) (this.A * ((float) i2)))) * f2;
        float f4 = ((float) ((int) (this.B * ((float) i3)))) * f2;
        FPoint fPoint = this.x;
        float f5 = ((PointF) fPoint).x;
        float f6 = ((PointF) fPoint).y;
        float sc = iAMapDelegate.getMapConfig().getSC();
        float f7 = this.o;
        List<BitmapDescriptor> list = this.ai;
        if (list != null && list.size() > 0) {
            if (this.j) {
                x[] xVarArr = this.U;
                int length = xVarArr.length;
                float f8 = this.o;
                float f9 = this.k;
                int i4 = (int) (f8 / f9);
                if (i4 > length) {
                    i4 = 0;
                } else {
                    f7 = f8 % f9;
                }
                this.T = xVarArr[(i4 + length) % length];
            } else {
                this.an++;
                if (this.an >= this.ao * this.ai.size()) {
                    this.an = 0;
                }
                if (this.ao == 0) {
                    this.ao = 1;
                }
                this.T = this.U[this.an / this.ao];
                if (!this.am) {
                    c();
                }
            }
        }
        float f10 = 0.0f;
        if (this.q) {
            f7 -= iAMapDelegate.getMapConfig().getSR();
            sc = 0.0f;
        }
        float f11 = this.C;
        if (f11 >= 0.0f) {
            f10 = f11;
        }
        if (f10 > 1.0f) {
            f10 = 1.0f;
        }
        float[] fArr = this.y;
        float f12 = this.ab;
        fArr[0] = f5 - (f3 * f12);
        float f13 = this.ac;
        fArr[1] = ((1.0f - f13) * f4) + f6;
        fArr[2] = f5;
        fArr[3] = f6;
        fArr[6] = f7;
        fArr[7] = sc;
        fArr[8] = f10;
        fArr[9] = ((1.0f - f12) * f3) + f5;
        fArr[10] = ((1.0f - f13) * f4) + f6;
        fArr[11] = f5;
        fArr[12] = f6;
        fArr[15] = f7;
        fArr[16] = sc;
        fArr[17] = f10;
        fArr[18] = ((1.0f - f12) * f3) + f5;
        fArr[19] = f6 - (f4 * f13);
        fArr[20] = f5;
        fArr[21] = f6;
        fArr[24] = f7;
        fArr[25] = sc;
        fArr[26] = f10;
        fArr[27] = f5 - (f3 * f12);
        fArr[28] = f6 - (f4 * f13);
        fArr[29] = f5;
        fArr[30] = f6;
        fArr[33] = f7;
        fArr[34] = sc;
        fArr[35] = f10;
    }

    @Override // com.autonavi.base.amap.api.mapcore.BaseOverlayImp
    public void destroy() {
        destroy(true);
    }

    private void a(float[] fArr, int i2) {
        x[] xVarArr = this.U;
        if (xVarArr != null && xVarArr.length > 0) {
            float[] fArr2 = this.y;
            System.arraycopy(fArr2, 0, fArr, i2, fArr2.length);
        }
    }

    private void a(double d2, double d3) {
        if (this.ap) {
            IPoint obtain = IPoint.obtain();
            this.af.c().getPixel2Geo((int) d2, (int) d3, obtain);
            a(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(obtain), com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(obtain));
            obtain.recycle();
            this.ap = true;
            return;
        }
        a((int) d2, (int) d3);
    }

    private void a(int i2, int i3) {
        this.v = i2;
        this.w = i3;
        DPoint obtain = DPoint.obtain();
        GLMapState.geo2LonLat(this.v, this.w, obtain);
        this.X = new LatLng(obtain.y, obtain.x, false);
        u uVar = this.af;
        if (!(uVar == null || uVar.c() == null)) {
            ((PointF) this.x).x = (float) (this.v - ((int) this.af.c().getMapConfig().getSX()));
            ((PointF) this.x).y = (float) (this.w - ((int) this.af.c().getMapConfig().getSY()));
        }
        obtain.recycle();
        c();
    }

    private void a(GLAnimation gLAnimation) {
        if (gLAnimation instanceof GLTranslateAnimation) {
            if (this.ap) {
                LatLng position = getPosition();
                this.X = position;
                setPosition(position);
                this.ap = true;
            }
            if (this.ap) {
                GLTranslateAnimation gLTranslateAnimation = (GLTranslateAnimation) gLAnimation;
                gLTranslateAnimation.mFromXDelta = (double) this.aq;
                gLTranslateAnimation.mFromYDelta = (double) this.ar;
                IPoint obtain = IPoint.obtain();
                this.af.c().getLatLng2Pixel(gLTranslateAnimation.mToYDelta, gLTranslateAnimation.mToXDelta, obtain);
                gLTranslateAnimation.mToXDelta = (double) com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(obtain);
                gLTranslateAnimation.mToYDelta = (double) com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(obtain);
                obtain.recycle();
                return;
            }
            GLTranslateAnimation gLTranslateAnimation2 = (GLTranslateAnimation) gLAnimation;
            gLTranslateAnimation2.mFromXDelta = (double) this.v;
            gLTranslateAnimation2.mFromYDelta = (double) this.w;
            IPoint obtain2 = IPoint.obtain();
            GLMapState.lonlat2Geo(gLTranslateAnimation2.mToXDelta, gLTranslateAnimation2.mToYDelta, obtain2);
            gLTranslateAnimation2.mToXDelta = (double) com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(obtain2);
            gLTranslateAnimation2.mToYDelta = (double) com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(obtain2);
            obtain2.recycle();
        }
    }

    private Bitmap a(Bitmap bitmap) {
        Bitmap.Config config;
        return (bitmap == null || bitmap.getConfig() == (config = Bitmap.Config.ARGB_8888)) ? bitmap : bitmap.copy(config, true);
    }
}
