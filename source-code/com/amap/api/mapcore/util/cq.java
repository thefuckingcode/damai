package com.amap.api.mapcore.util;

import android.graphics.PointF;
import android.opengl.GLES20;
import android.os.RemoteException;
import android.util.Log;
import com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point;
import com.alimm.xadsdk.base.constant.AdConstants;
import com.amap.api.mapcore.util.de;
import com.amap.api.maps.AMapUtils;
import com.amap.api.maps.model.BaseHoleOptions;
import com.amap.api.maps.model.CircleHoleOptions;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.PolygonHoleOptions;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.interfaces.IOverlay;
import com.autonavi.base.ae.gmap.GLMapState;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.api.mapcore.overlays.ICircleDelegate;
import com.autonavi.base.amap.mapcore.FPoint;
import com.autonavi.base.amap.mapcore.MapConfig;
import com.taobao.weex.common.Constants;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: Taobao */
public class cq implements ICircleDelegate {
    private static int A = 256;
    private static int B = 20;
    private static double C = 1.0E10d;
    private static Object v = new Object();
    private static float z = 4.0075016E7f;
    float a = 0.0f;
    private LatLng b = null;
    private double c = 0.0d;
    private float d = 10.0f;
    private int e = -16777216;
    private int f = 0;
    private float g = 0.0f;
    private boolean h = true;
    private String i;
    private IAMapDelegate j;
    private FloatBuffer k;
    private int l = 0;
    private boolean m = false;
    private IPoint n = IPoint.obtain();
    private FPoint o = FPoint.obtain();
    private List<BaseHoleOptions> p;
    private List<BaseHoleOptions> q;
    private int r;
    private int s;
    private FloatBuffer t;
    private FloatBuffer u;
    private int w = -1;
    private boolean x = false;
    private de.e y;

    public cq(IAMapDelegate iAMapDelegate) {
        this.j = iAMapDelegate;
        try {
            this.i = getId();
        } catch (RemoteException e2) {
            hd.c(e2, "CircleDelegateImp", "create");
            e2.printStackTrace();
        }
    }

    private void b() {
        IAMapDelegate iAMapDelegate = this.j;
        if (iAMapDelegate != null) {
            this.y = (de.e) iAMapDelegate.getGLShader(3);
        }
    }

    private void c() throws RemoteException {
        MapConfig mapConfig = this.j.getMapConfig();
        List<BaseHoleOptions> list = this.p;
        if (list != null && list.size() > 0) {
            GLES20.glClearStencil(0);
            GLES20.glStencilMask(255);
            GLES20.glClear(1024);
            GLES20.glFlush();
            GLES20.glEnable(2960);
            GLES20.glColorMask(false, false, false, false);
            GLES20.glStencilFunc(512, 1, 255);
            GLES20.glStencilOp(7681, 7680, 7680);
            for (int i2 = 0; i2 < this.p.size(); i2++) {
                BaseHoleOptions baseHoleOptions = this.p.get(i2);
                boolean z2 = baseHoleOptions instanceof PolygonHoleOptions;
                if (z2) {
                    a(a(((PolygonHoleOptions) baseHoleOptions).getPoints()), (int) mapConfig.getSX(), (int) mapConfig.getSY());
                } else if (baseHoleOptions instanceof CircleHoleOptions) {
                    this.j.changeGLOverlayIndex();
                    a((CircleHoleOptions) baseHoleOptions);
                }
                if (this.t != null && this.r > 0) {
                    de.e eVar = this.y;
                    if (eVar == null || eVar.c()) {
                        b();
                    }
                    if (z2) {
                        dy.a(this.y, -1, this.f, this.t, getStrokeWidth(), this.u, this.r, this.s, this.j.getFinalMatrix(), this.j.getLineTextureID(), this.j.getLineTextureRatio(), mapConfig.getMapPerPixelUnitLength(), 3, 0, this.x, false);
                    } else if (baseHoleOptions instanceof CircleHoleOptions) {
                        dy.a(this.y, -1, -1, this.t, 10.0f, this.r, this.j.getFinalMatrix(), mapConfig.getMapPerPixelUnitLength(), this.j.getLineTextureID(), this.j.getLineTextureRatio(), this.x, false);
                    }
                }
            }
            GLES20.glColorMask(true, true, true, true);
            GLES20.glStencilFunc(517, 1, 255);
            GLES20.glStencilMask(0);
        }
    }

    private void d() throws RemoteException {
        GLES20.glClearStencil(0);
        GLES20.glClear(1024);
        GLES20.glDisable(2960);
        MapConfig mapConfig = this.j.getMapConfig();
        List<BaseHoleOptions> list = this.p;
        if (list != null && list.size() > 0) {
            for (int i2 = 0; i2 < this.p.size(); i2++) {
                BaseHoleOptions baseHoleOptions = this.p.get(i2);
                boolean z2 = baseHoleOptions instanceof PolygonHoleOptions;
                if (z2) {
                    a(a(((PolygonHoleOptions) baseHoleOptions).getPoints()), (int) mapConfig.getSX(), (int) mapConfig.getSY());
                } else if (baseHoleOptions instanceof CircleHoleOptions) {
                    this.j.changeGLOverlayIndex();
                    a((CircleHoleOptions) baseHoleOptions);
                }
                if (this.t != null && this.r > 0) {
                    de.e eVar = this.y;
                    if (eVar == null || eVar.c()) {
                        b();
                    }
                    if (z2) {
                        dy.a(this.y, 0, this.e, this.t, this.d, this.u, this.r, this.s, this.j.getFinalMatrix(), this.j.getLineTextureID(), this.j.getLineTextureRatio(), mapConfig.getMapPerPixelUnitLength(), 3, 0, this.x);
                    } else if (baseHoleOptions instanceof CircleHoleOptions) {
                        dy.a(this.y, 0, this.e, this.t, this.d, this.r, this.j.getFinalMatrix(), mapConfig.getMapPerPixelUnitLength(), this.j.getLineTextureID(), this.j.getLineTextureRatio(), this.x);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.l = 0;
        FloatBuffer floatBuffer = this.k;
        if (floatBuffer != null) {
            floatBuffer.clear();
        }
        this.j.setRunLowFrame(false);
        setHoleOptions(this.q);
    }

    @Override // com.autonavi.base.amap.api.mapcore.overlays.IOverlayDelegate
    public boolean calMapFPoint() throws RemoteException {
        synchronized (v) {
            int i2 = 0;
            this.m = false;
            LatLng latLng = this.b;
            if (latLng != null) {
                float[] fArr = new float[1086];
                double b2 = b(latLng.latitude) * this.c;
                this.j.getMapProjection();
                ((PointF) this.o).x = (float) (Point.getx(this.n) - ((int) this.j.getMapConfig().getSX()));
                ((PointF) this.o).y = (float) (Point.gety(this.n) - ((int) this.j.getMapConfig().getSY()));
                FPoint fPoint = this.o;
                fArr[0] = ((PointF) fPoint).x;
                fArr[1] = ((PointF) fPoint).y;
                fArr[2] = 0.0f;
                while (i2 < 361) {
                    double d2 = (((double) i2) * 3.141592653589793d) / 180.0d;
                    IPoint iPoint = this.n;
                    double xVar = (double) Point.getx(iPoint);
                    int yVar = (int) (((double) Point.gety(iPoint)) + (Math.cos(d2) * b2));
                    ((PointF) this.o).x = (float) (((int) (xVar + (Math.sin(d2) * b2))) - ((int) this.j.getMapConfig().getSX()));
                    ((PointF) this.o).y = (float) (yVar - ((int) this.j.getMapConfig().getSY()));
                    i2++;
                    int i3 = i2 * 3;
                    FPoint fPoint2 = this.o;
                    fArr[i3] = ((PointF) fPoint2).x;
                    fArr[i3 + 1] = ((PointF) fPoint2).y;
                    fArr[i3 + 2] = 0.0f;
                }
                this.l = AdConstants.TEMPLATE_VIDEO_TOP_VIEW;
                this.k = eq.a(fArr);
            }
        }
        return true;
    }

    @Override // com.autonavi.base.amap.api.mapcore.overlays.IOverlayDelegate
    public boolean checkInBounds() {
        return true;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.ICircle
    public boolean contains(LatLng latLng) throws RemoteException {
        List<BaseHoleOptions> list = this.p;
        if (list != null && list.size() > 0) {
            for (BaseHoleOptions baseHoleOptions : this.p) {
                if (eq.a(baseHoleOptions, latLng)) {
                    return false;
                }
            }
        }
        if (this.c >= ((double) AMapUtils.calculateLineDistance(this.b, latLng))) {
            return true;
        }
        return false;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public void destroy() {
        try {
            this.b = null;
            FloatBuffer floatBuffer = this.k;
            if (floatBuffer != null) {
                floatBuffer.clear();
                this.k = null;
            }
            FloatBuffer floatBuffer2 = this.t;
            if (floatBuffer2 != null) {
                floatBuffer2.clear();
                this.t = null;
            }
            FloatBuffer floatBuffer3 = this.u;
            if (floatBuffer3 != null) {
                floatBuffer3.clear();
                this.u = null;
            }
            List<BaseHoleOptions> list = this.p;
            if (list != null) {
                list.clear();
            }
            List<BaseHoleOptions> list2 = this.q;
            if (list2 != null) {
                list2.clear();
            }
            this.p = null;
            this.q = null;
        } catch (Throwable th) {
            hd.c(th, "CircleDelegateImp", Constants.Event.SLOT_LIFECYCLE.DESTORY);
            th.printStackTrace();
            Log.d("destroy erro", "CircleDelegateImp destroy");
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.overlays.IOverlayDelegate
    public void draw(MapConfig mapConfig) throws RemoteException {
        if (this.b != null && this.c > 0.0d && this.h) {
            calMapFPoint();
            c();
            if (this.k != null && this.l > 0) {
                de.e eVar = this.y;
                if (eVar == null || eVar.c()) {
                    b();
                }
                this.a = this.j.getMapConfig().getMapPerPixelUnitLength();
                int dottedLineTextureID = this.j.getDottedLineTextureID(this.w);
                if (dottedLineTextureID == -1) {
                    dottedLineTextureID = this.j.getLineTextureID();
                }
                dy.a(this.y, this.f, this.e, this.k, this.d, this.l, this.j.getFinalMatrix(), this.a, dottedLineTextureID, this.j.getLineTextureRatio(), this.x || (this.w != -1), true);
            }
            d();
            this.m = true;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public boolean equalsRemote(IOverlay iOverlay) throws RemoteException {
        return equals(iOverlay) || iOverlay.getId().equals(getId());
    }

    @Override // com.autonavi.amap.mapcore.interfaces.ICircle
    public LatLng getCenter() throws RemoteException {
        return this.b;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.ICircle
    public int getDottedLineType() {
        return this.w;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.ICircle
    public int getFillColor() throws RemoteException {
        return this.f;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.ICircle
    public List<BaseHoleOptions> getHoleOptions() throws RemoteException {
        return this.p;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public String getId() throws RemoteException {
        if (this.i == null) {
            this.i = this.j.createId("Circle");
        }
        return this.i;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.ICircle
    public double getRadius() throws RemoteException {
        return this.c;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.ICircle
    public int getStrokeColor() throws RemoteException {
        return this.e;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.ICircle
    public float getStrokeWidth() throws RemoteException {
        return this.d;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public float getZIndex() throws RemoteException {
        return this.g;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public int hashCodeRemote() throws RemoteException {
        return 0;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public boolean isAboveMaskLayer() {
        return false;
    }

    @Override // com.autonavi.base.amap.api.mapcore.overlays.IOverlayDelegate
    public boolean isDrawFinish() {
        return this.m;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public boolean isVisible() throws RemoteException {
        return this.h;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public void remove() throws RemoteException {
        this.j.removeGLOverlay(getId());
        this.j.setRunLowFrame(false);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public void setAboveMaskLayer(boolean z2) {
    }

    @Override // com.autonavi.amap.mapcore.interfaces.ICircle
    public void setCenter(LatLng latLng) throws RemoteException {
        synchronized (v) {
            if (latLng != null) {
                this.b = latLng;
                GLMapState.lonlat2Geo(latLng.longitude, latLng.latitude, this.n);
                a();
            }
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.ICircle
    public void setDottedLineType(int i2) {
        this.w = i2;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.ICircle
    public void setFillColor(int i2) throws RemoteException {
        this.f = i2;
        this.j.setRunLowFrame(false);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.ICircle
    public void setHoleOptions(List<BaseHoleOptions> list) {
        try {
            this.q = list;
            List<BaseHoleOptions> list2 = this.p;
            if (list2 == null) {
                this.p = new ArrayList();
            } else {
                list2.clear();
            }
            if (list != null) {
                for (int i2 = 0; i2 < list.size(); i2++) {
                    BaseHoleOptions baseHoleOptions = list.get(i2);
                    if (baseHoleOptions instanceof PolygonHoleOptions) {
                        PolygonHoleOptions polygonHoleOptions = (PolygonHoleOptions) baseHoleOptions;
                        if (a(polygonHoleOptions) && !eq.a(this.p, polygonHoleOptions)) {
                            this.p.add(polygonHoleOptions);
                        }
                    } else if (baseHoleOptions instanceof CircleHoleOptions) {
                        CircleHoleOptions circleHoleOptions = (CircleHoleOptions) baseHoleOptions;
                        if (b(circleHoleOptions) && !eq.a(this.p, circleHoleOptions)) {
                            this.p.add(circleHoleOptions);
                        }
                    }
                }
            }
        } catch (Throwable th) {
            hd.c(th, "PolygonDelegateImp", "setHoleOptions");
            th.printStackTrace();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.ICircle
    public void setRadius(double d2) throws RemoteException {
        this.c = d2;
        a();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.ICircle
    public void setStrokeColor(int i2) throws RemoteException {
        this.e = i2;
        this.j.setRunLowFrame(false);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.ICircle
    public void setStrokeWidth(float f2) throws RemoteException {
        this.d = f2;
        this.j.setRunLowFrame(false);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public void setVisible(boolean z2) throws RemoteException {
        this.h = z2;
        this.j.setRunLowFrame(false);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public void setZIndex(float f2) throws RemoteException {
        this.g = f2;
        this.j.changeGLOverlayIndex();
        this.j.setRunLowFrame(false);
    }

    private double b(double d2) {
        return 1.0d / ((double) a(d2));
    }

    private boolean b(CircleHoleOptions circleHoleOptions) {
        try {
            if (((double) AMapUtils.calculateLineDistance(circleHoleOptions.getCenter(), getCenter())) <= getRadius() - circleHoleOptions.getRadius()) {
                return true;
            }
            return false;
        } catch (Throwable th) {
            hd.c(th, "CircleDelegateImp", "isCircleInCircle");
            th.printStackTrace();
            return true;
        }
    }

    private float a(double d2) {
        return (float) ((Math.cos((d2 * 3.141592653589793d) / 180.0d) * ((double) z)) / ((double) (A << B)));
    }

    public void a(boolean z2) {
        this.x = z2;
    }

    private boolean a(PolygonHoleOptions polygonHoleOptions) {
        boolean z2 = true;
        try {
            List<LatLng> points = polygonHoleOptions.getPoints();
            int i2 = 0;
            while (i2 < points.size() && (z2 = contains(points.get(i2)))) {
                i2++;
            }
        } catch (Throwable th) {
            hd.c(th, "CircleDelegateImp", "isPolygonInCircle");
            th.printStackTrace();
        }
        return z2;
    }

    static IPoint[] a(IPoint[] iPointArr) {
        int length = iPointArr.length;
        double[] dArr = new double[(length * 2)];
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i2 * 2;
            double d2 = C;
            dArr[i3] = ((double) Point.getx(iPointArr[i2])) * d2;
            dArr[i3 + 1] = ((double) Point.gety(iPointArr[i2])) * d2;
        }
        em a2 = new dv().a(dArr);
        int i4 = a2.b;
        IPoint[] iPointArr2 = new IPoint[i4];
        for (int i5 = 0; i5 < i4; i5++) {
            iPointArr2[i5] = new IPoint();
            ((android.graphics.Point) iPointArr2[i5]).x = (int) (dArr[a2.a(i5) * 2] / C);
            ((android.graphics.Point) iPointArr2[i5]).y = (int) (dArr[(a2.a(i5) * 2) + 1] / C);
        }
        return iPointArr2;
    }

    private void a(List<IPoint> list, int i2, int i3) throws RemoteException {
        if (list.size() >= 2) {
            float[] fArr = new float[(list.size() * 3)];
            int size = list.size();
            IPoint[] iPointArr = new IPoint[size];
            int i4 = 0;
            for (IPoint iPoint : list) {
                int i5 = i4 * 3;
                fArr[i5] = (float) (Point.getx(iPoint) - i2);
                fArr[i5 + 1] = (float) (Point.gety(iPoint) - i3);
                fArr[i5 + 2] = 0.0f;
                iPointArr[i4] = iPoint;
                i4++;
            }
            IPoint[] a2 = a(iPointArr);
            if (a2.length == 0) {
                if (C == 1.0E10d) {
                    C = 1.0E8d;
                } else {
                    C = 1.0E10d;
                }
                a2 = a(iPointArr);
            }
            float[] fArr2 = new float[(a2.length * 3)];
            int i6 = 0;
            for (IPoint iPoint2 : a2) {
                int i7 = i6 * 3;
                fArr2[i7] = (float) (Point.getx(iPoint2) - i2);
                fArr2[i7 + 1] = (float) (Point.gety(iPoint2) - i3);
                fArr2[i7 + 2] = 0.0f;
                i6++;
            }
            this.r = size;
            this.s = a2.length;
            this.t = eq.a(fArr);
            this.u = eq.a(fArr2);
        }
    }

    private List<IPoint> a(List<LatLng> list) throws RemoteException {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            LatLng latLng = null;
            for (LatLng latLng2 : list) {
                if (!latLng2.equals(latLng)) {
                    IPoint obtain = IPoint.obtain();
                    this.j.latlon2Geo(latLng2.latitude, latLng2.longitude, obtain);
                    arrayList.add(obtain);
                    latLng = latLng2;
                }
            }
            int size = arrayList.size();
            if (size > 1) {
                IPoint iPoint = (IPoint) arrayList.get(0);
                int i2 = size - 1;
                IPoint iPoint2 = (IPoint) arrayList.get(i2);
                if (Point.getx(iPoint) == Point.getx(iPoint2) && Point.gety(iPoint) == Point.gety(iPoint2)) {
                    arrayList.remove(i2);
                }
            }
        }
        if (eq.a(arrayList, 0, arrayList.size())) {
            Collections.reverse(arrayList);
        }
        return arrayList;
    }

    public void a(CircleHoleOptions circleHoleOptions) throws RemoteException {
        if (circleHoleOptions.getCenter() != null) {
            IPoint obtain = IPoint.obtain();
            FPoint obtain2 = FPoint.obtain();
            GLMapState.lonlat2Geo(circleHoleOptions.getCenter().longitude, circleHoleOptions.getCenter().latitude, obtain);
            float[] fArr = new float[1086];
            double b2 = b(circleHoleOptions.getCenter().latitude) * circleHoleOptions.getRadius();
            ((PointF) obtain2).x = (float) (Point.getx(obtain) - ((int) this.j.getMapConfig().getSX()));
            float yVar = (float) (Point.gety(obtain) - ((int) this.j.getMapConfig().getSY()));
            ((PointF) obtain2).y = yVar;
            int i2 = 0;
            fArr[0] = ((PointF) obtain2).x;
            fArr[1] = yVar;
            fArr[2] = 0.0f;
            while (i2 < 361) {
                double d2 = (((double) i2) * 3.141592653589793d) / 180.0d;
                double xVar = (double) Point.getx(obtain);
                int yVar2 = (int) (((double) Point.gety(obtain)) + (Math.cos(d2) * b2));
                ((PointF) obtain2).x = (float) (((int) (xVar + (Math.sin(d2) * b2))) - ((int) this.j.getMapConfig().getSX()));
                float sy = (float) (yVar2 - ((int) this.j.getMapConfig().getSY()));
                ((PointF) obtain2).y = sy;
                i2++;
                int i3 = i2 * 3;
                fArr[i3] = ((PointF) obtain2).x;
                fArr[i3 + 1] = sy;
                fArr[i3 + 2] = 0.0f;
            }
            this.r = AdConstants.TEMPLATE_VIDEO_TOP_VIEW;
            this.t = eq.a(fArr);
            obtain.recycle();
            obtain2.recycle();
        }
    }
}
