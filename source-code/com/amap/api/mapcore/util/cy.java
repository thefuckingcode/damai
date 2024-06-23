package com.amap.api.mapcore.util;

import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.Rect;
import android.opengl.GLES20;
import android.os.RemoteException;
import com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point;
import com.alimm.xadsdk.base.constant.AdConstants;
import com.amap.api.mapcore.util.de;
import com.amap.api.maps.model.AMapPara;
import com.amap.api.maps.model.BaseHoleOptions;
import com.amap.api.maps.model.CircleHoleOptions;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.PolygonHoleOptions;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.interfaces.IOverlay;
import com.autonavi.base.ae.gmap.GLMapState;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.api.mapcore.overlays.IPolygonDelegate;
import com.autonavi.base.amap.mapcore.FPoint;
import com.autonavi.base.amap.mapcore.MapConfig;
import com.autonavi.base.amap.mapcore.Rectangle;
import com.taobao.weex.common.Constants;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

/* compiled from: Taobao */
public class cy implements IPolygonDelegate {
    private static float A = 4.0075016E7f;
    private static int B = 256;
    private static int C = 20;
    private static double H = 1.0E10d;
    private int D;
    private int E;
    private FloatBuffer F;
    private FloatBuffer G;
    Rect a = null;
    private IAMapDelegate b;
    private float c = 0.0f;
    private boolean d = true;
    private boolean e;
    private String f;
    private float g;
    private int h;
    private int i;
    private List<LatLng> j;
    private List<LatLng> k;
    private List<IPoint> l = new Vector();
    private List<BaseHoleOptions> m = new Vector();
    private List<BaseHoleOptions> n;
    private FloatBuffer o;
    private FloatBuffer p;
    private int q = 0;
    private int r = 0;
    private boolean s = false;
    private float t = 0.0f;
    private Object u = new Object();
    private boolean v = false;
    private AMapPara.LineJoinType w = AMapPara.LineJoinType.LineJoinBevel;
    private AMapPara.LineCapType x = AMapPara.LineCapType.LineCapRound;
    private float y = 0.0f;
    private de.e z;

    public cy(IAMapDelegate iAMapDelegate) {
        this.b = iAMapDelegate;
        try {
            this.f = getId();
        } catch (RemoteException e2) {
            hd.c(e2, "PolygonDelegateImp", "create");
            e2.printStackTrace();
        }
    }

    private void a(List<LatLng> list) throws RemoteException {
        LatLngBounds.Builder builder = LatLngBounds.builder();
        if (this.a == null) {
            this.a = new Rect();
        }
        eq.a(this.a);
        this.l.clear();
        if (list != null) {
            Object obj = null;
            for (LatLng latLng : list) {
                if (!latLng.equals(obj)) {
                    IPoint obtain = IPoint.obtain();
                    this.b.latlon2Geo(latLng.latitude, latLng.longitude, obtain);
                    this.l.add(obtain);
                    eq.b(this.a, Point.getx(obtain), Point.gety(obtain));
                    builder.include(latLng);
                    obj = latLng;
                }
            }
            int size = this.l.size();
            if (size > 1) {
                IPoint iPoint = this.l.get(0);
                int i2 = size - 1;
                IPoint iPoint2 = this.l.get(i2);
                if (Point.getx(iPoint) == Point.getx(iPoint2) && Point.gety(iPoint) == Point.gety(iPoint2)) {
                    this.l.remove(i2);
                }
            }
        }
        this.a.sort();
        FloatBuffer floatBuffer = this.o;
        if (floatBuffer != null) {
            floatBuffer.clear();
        }
        FloatBuffer floatBuffer2 = this.p;
        if (floatBuffer2 != null) {
            floatBuffer2.clear();
        }
        List<IPoint> list2 = this.l;
        if (eq.a(list2, 0, list2.size())) {
            Collections.reverse(this.l);
        }
        this.q = 0;
        this.r = 0;
        this.b.setRunLowFrame(false);
    }

    private void b() throws RemoteException {
        MapConfig mapConfig = this.b.getMapConfig();
        List<BaseHoleOptions> list = this.m;
        if (list != null && list.size() > 0) {
            GLES20.glClearStencil(0);
            GLES20.glStencilMask(255);
            GLES20.glClear(1024);
            GLES20.glFlush();
            GLES20.glEnable(2960);
            GLES20.glColorMask(false, false, false, false);
            GLES20.glStencilFunc(512, 1, 255);
            GLES20.glStencilOp(7681, 7680, 7680);
            for (int i2 = 0; i2 < this.m.size(); i2++) {
                BaseHoleOptions baseHoleOptions = this.m.get(i2);
                boolean z2 = baseHoleOptions instanceof PolygonHoleOptions;
                if (z2) {
                    a(b(((PolygonHoleOptions) baseHoleOptions).getPoints()), (int) mapConfig.getSX(), (int) mapConfig.getSY());
                } else if (baseHoleOptions instanceof CircleHoleOptions) {
                    this.b.changeGLOverlayIndex();
                    a((CircleHoleOptions) baseHoleOptions);
                }
                if (this.F != null && this.D > 0) {
                    de.e eVar = this.z;
                    if (eVar == null || eVar.c()) {
                        a();
                    }
                    if (z2) {
                        dy.a(this.z, -1, -16777216, this.F, this.g, this.G, this.D, this.E, this.b.getFinalMatrix(), this.b.getLineTextureID(), this.b.getLineTextureRatio(), mapConfig.getMapPerPixelUnitLength(), this.x.getTypeValue(), this.w.getTypeValue(), this.v, false);
                    } else if (baseHoleOptions instanceof CircleHoleOptions) {
                        dy.a(this.z, Color.argb(200, 80, 1, 1), Color.argb(200, 1, 1, 1), this.F, 5.0f, this.D, this.b.getFinalMatrix(), mapConfig.getMapPerPixelUnitLength(), this.b.getLineTextureID(), this.b.getLineTextureRatio(), this.v, false);
                    }
                }
            }
            GLES20.glColorMask(true, true, true, true);
            GLES20.glStencilFunc(517, 1, 255);
            GLES20.glStencilMask(0);
        }
    }

    private void c() throws RemoteException {
        GLES20.glClearStencil(0);
        GLES20.glClear(1024);
        GLES20.glDisable(2960);
        MapConfig mapConfig = this.b.getMapConfig();
        List<BaseHoleOptions> list = this.m;
        if (list != null && list.size() > 0) {
            for (int i2 = 0; i2 < this.m.size(); i2++) {
                BaseHoleOptions baseHoleOptions = this.m.get(i2);
                boolean z2 = baseHoleOptions instanceof PolygonHoleOptions;
                if (z2) {
                    a(b(((PolygonHoleOptions) baseHoleOptions).getPoints()), (int) mapConfig.getSX(), (int) mapConfig.getSY());
                } else if (baseHoleOptions instanceof CircleHoleOptions) {
                    this.b.changeGLOverlayIndex();
                    a((CircleHoleOptions) baseHoleOptions);
                }
                if (this.F != null && this.D > 0) {
                    de.e eVar = this.z;
                    if (eVar == null || eVar.c()) {
                        a();
                    }
                    if (z2) {
                        dy.a(this.z, 0, this.i, this.F, this.g, this.G, this.D, this.E, mapConfig.getMvpMatrix(), this.b.getLineTextureID(), this.b.getLineTextureRatio(), mapConfig.getMapPerPixelUnitLength(), this.x.getTypeValue(), this.w.getTypeValue(), this.v);
                    } else if (baseHoleOptions instanceof CircleHoleOptions) {
                        dy.a(this.z, 0, this.i, this.F, this.g, this.D, this.b.getFinalMatrix(), mapConfig.getMapPerPixelUnitLength(), this.b.getLineTextureID(), this.b.getLineTextureRatio(), this.v);
                    }
                }
            }
        }
    }

    private void d() {
        float zoomLevel = this.b.getZoomLevel();
        if (this.l.size() <= 5000) {
            this.t = this.b.getMapProjection().getMapLenWithWin(2);
        } else if (zoomLevel <= ((float) 12)) {
            float f2 = (this.g / 2.0f) + (zoomLevel / 2.0f);
            if (f2 > 200.0f) {
                f2 = 200.0f;
            }
            this.t = this.b.getMapProjection().getMapLenWithWin((int) f2);
        } else {
            this.t = this.b.getMapProjection().getMapLenWithWin(10);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.overlays.IOverlayDelegate
    public boolean calMapFPoint() throws RemoteException {
        return false;
    }

    @Override // com.autonavi.base.amap.api.mapcore.overlays.IOverlayDelegate
    public boolean checkInBounds() {
        return this.b.getMapConfig().getGeoRectangle().isOverlap(this.a);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IPolygon
    public boolean contains(LatLng latLng) throws RemoteException {
        if (latLng == null) {
            return false;
        }
        try {
            List<BaseHoleOptions> list = this.m;
            if (list != null && list.size() > 0) {
                for (BaseHoleOptions baseHoleOptions : this.m) {
                    if (eq.a(baseHoleOptions, latLng)) {
                        return false;
                    }
                }
            }
            return eq.a(latLng, getPoints());
        } catch (Throwable th) {
            hd.c(th, "PolygonDelegateImp", "contains");
            th.printStackTrace();
            return false;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public void destroy() {
        try {
            FloatBuffer floatBuffer = this.o;
            if (floatBuffer != null) {
                floatBuffer.clear();
                this.o = null;
            }
            if (this.p != null) {
                this.p = null;
            }
            FloatBuffer floatBuffer2 = this.F;
            if (floatBuffer2 != null) {
                floatBuffer2.clear();
                this.F = null;
            }
            FloatBuffer floatBuffer3 = this.G;
            if (floatBuffer3 != null) {
                floatBuffer3.clear();
                this.G = null;
            }
            List<BaseHoleOptions> list = this.m;
            if (list != null) {
                list.clear();
            }
            List<BaseHoleOptions> list2 = this.n;
            if (list2 != null) {
                list2.clear();
            }
            this.m = null;
            this.n = null;
        } catch (Throwable th) {
            hd.c(th, "PolygonDelegateImp", Constants.Event.SLOT_LIFECYCLE.DESTORY);
            th.printStackTrace();
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.overlays.IOverlayDelegate
    public void draw(MapConfig mapConfig) throws RemoteException {
        List<IPoint> list = this.l;
        if (list != null && list.size() != 0) {
            Rectangle geoRectangle = mapConfig.getGeoRectangle();
            geoRectangle.getClipRect();
            List<IPoint> list2 = this.l;
            a(geoRectangle);
            b();
            if (list2.size() > 2) {
                b(list2, (int) mapConfig.getSX(), (int) mapConfig.getSY());
                if (this.o != null && this.p != null && this.q > 0 && this.r > 0) {
                    de.e eVar = this.z;
                    if (eVar == null || eVar.c()) {
                        a();
                    }
                    dy.a(this.z, this.h, this.i, this.o, this.g, this.p, this.q, this.r, this.b.getFinalMatrix(), this.b.getLineTextureID(), this.b.getLineTextureRatio(), mapConfig.getMapPerPixelUnitLength(), this.x.getTypeValue(), this.w.getTypeValue(), this.v, true);
                }
            }
            c();
            this.s = true;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public boolean equalsRemote(IOverlay iOverlay) throws RemoteException {
        return equals(iOverlay) || iOverlay.getId().equals(getId());
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IPolygon
    public int getFillColor() throws RemoteException {
        return this.h;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IPolygon
    public List<BaseHoleOptions> getHoleOptions() {
        return this.m;
    }

    @Override // com.autonavi.base.amap.api.mapcore.overlays.IPolygonDelegate
    public List<LatLng> getHoles() {
        return this.j;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public String getId() throws RemoteException {
        if (this.f == null) {
            this.f = this.b.createId("Polygon");
        }
        return this.f;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IPolygon
    public List<LatLng> getPoints() throws RemoteException {
        return this.k;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IPolygon
    public int getStrokeColor() throws RemoteException {
        return this.i;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IPolygon
    public float getStrokeWidth() throws RemoteException {
        return this.g;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public float getZIndex() throws RemoteException {
        return this.c;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public int hashCodeRemote() throws RemoteException {
        return super.hashCode();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public boolean isAboveMaskLayer() {
        return false;
    }

    @Override // com.autonavi.base.amap.api.mapcore.overlays.IOverlayDelegate
    public boolean isDrawFinish() {
        return this.s;
    }

    @Override // com.autonavi.base.amap.api.mapcore.overlays.IPolygonDelegate
    public boolean isGeodesic() {
        return this.e;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public boolean isVisible() throws RemoteException {
        return this.d;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public void remove() throws RemoteException {
        this.b.removeGLOverlay(getId());
        this.b.setRunLowFrame(false);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public void setAboveMaskLayer(boolean z2) {
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IPolygon
    public void setFillColor(int i2) throws RemoteException {
        this.h = i2;
        this.b.setRunLowFrame(false);
    }

    @Override // com.autonavi.base.amap.api.mapcore.overlays.IPolygonDelegate
    public void setGeodesic(boolean z2) {
        this.e = z2;
        this.b.setRunLowFrame(false);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IPolygon
    public void setHoleOptions(List<BaseHoleOptions> list) {
        try {
            this.n = list;
            List<BaseHoleOptions> list2 = this.m;
            if (list2 == null) {
                this.m = new ArrayList();
            } else {
                list2.clear();
            }
            if (list != null) {
                for (int i2 = 0; i2 < list.size(); i2++) {
                    BaseHoleOptions baseHoleOptions = list.get(i2);
                    if (baseHoleOptions instanceof PolygonHoleOptions) {
                        PolygonHoleOptions polygonHoleOptions = (PolygonHoleOptions) baseHoleOptions;
                        if (a(polygonHoleOptions) && !eq.a(this.m, polygonHoleOptions)) {
                            this.m.add(polygonHoleOptions);
                        }
                    } else if (baseHoleOptions instanceof CircleHoleOptions) {
                        CircleHoleOptions circleHoleOptions = (CircleHoleOptions) baseHoleOptions;
                        if (b(circleHoleOptions) && !eq.a(this.m, circleHoleOptions)) {
                            this.m.add(circleHoleOptions);
                        }
                    }
                }
            } else {
                this.m.clear();
            }
        } catch (Throwable th) {
            hd.c(th, "PolygonDelegateImp", "setHoleOptions");
            th.printStackTrace();
        }
        this.b.setRunLowFrame(false);
    }

    @Override // com.autonavi.base.amap.api.mapcore.overlays.IPolygonDelegate
    public void setHoles(List<LatLng> list) throws RemoteException {
        this.j = list;
        this.b.setRunLowFrame(false);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IPolygon
    public void setPoints(List<LatLng> list) throws RemoteException {
        synchronized (this.u) {
            this.k = list;
            a(list);
            this.b.setRunLowFrame(false);
            setHoleOptions(this.n);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IPolygon
    public void setStrokeColor(int i2) throws RemoteException {
        this.i = i2;
        this.b.setRunLowFrame(false);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IPolygon
    public void setStrokeWidth(float f2) throws RemoteException {
        this.g = f2;
        this.b.setRunLowFrame(false);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public void setVisible(boolean z2) throws RemoteException {
        this.d = z2;
        this.b.setRunLowFrame(false);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public void setZIndex(float f2) throws RemoteException {
        this.c = f2;
        this.b.changeGLOverlayIndex();
        this.b.setRunLowFrame(false);
    }

    private void a() {
        IAMapDelegate iAMapDelegate = this.b;
        if (iAMapDelegate != null) {
            this.z = (de.e) iAMapDelegate.getGLShader(3);
        }
    }

    private float a(double d2) {
        return (float) ((Math.cos((d2 * 3.141592653589793d) / 180.0d) * ((double) A)) / ((double) (B << C)));
    }

    public void a(CircleHoleOptions circleHoleOptions) throws RemoteException {
        if (circleHoleOptions.getCenter() != null) {
            IPoint obtain = IPoint.obtain();
            FPoint obtain2 = FPoint.obtain();
            GLMapState.lonlat2Geo(circleHoleOptions.getCenter().longitude, circleHoleOptions.getCenter().latitude, obtain);
            float[] fArr = new float[1086];
            double b2 = b(circleHoleOptions.getCenter().latitude) * circleHoleOptions.getRadius();
            int sx = (int) this.b.getMapConfig().getSX();
            int sy = (int) this.b.getMapConfig().getSY();
            float xVar = (float) (Point.getx(obtain) - sx);
            ((PointF) obtain2).x = xVar;
            float yVar = (float) (Point.gety(obtain) - sy);
            ((PointF) obtain2).y = yVar;
            int i2 = 0;
            fArr[0] = xVar;
            fArr[1] = yVar;
            fArr[2] = 0.0f;
            while (i2 < 361) {
                double d2 = (((double) i2) * 3.141592653589793d) / 180.0d;
                int xVar2 = (int) (((double) Point.getx(obtain)) + (Math.sin(d2) * b2));
                int yVar2 = (int) (((double) Point.gety(obtain)) + (Math.cos(d2) * b2));
                ((PointF) obtain2).x = (float) (xVar2 - sx);
                ((PointF) obtain2).y = (float) (yVar2 - sy);
                ((PointF) obtain2).x = (float) (xVar2 - ((int) this.b.getMapConfig().getSX()));
                float sy2 = (float) (yVar2 - ((int) this.b.getMapConfig().getSY()));
                ((PointF) obtain2).y = sy2;
                i2++;
                int i3 = i2 * 3;
                fArr[i3] = ((PointF) obtain2).x;
                fArr[i3 + 1] = sy2;
                fArr[i3 + 2] = 0.0f;
            }
            this.D = AdConstants.TEMPLATE_VIDEO_TOP_VIEW;
            this.F = eq.a(fArr);
            obtain.recycle();
            obtain2.recycle();
        }
    }

    private double b(double d2) {
        return 1.0d / ((double) a(d2));
    }

    private void b(List<IPoint> list, int i2, int i3) throws RemoteException {
        int i4;
        d();
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        if (size >= 2) {
            IPoint iPoint = list.get(0);
            arrayList.add(iPoint);
            int i5 = 1;
            while (true) {
                i4 = size - 1;
                if (i5 >= i4) {
                    break;
                }
                IPoint iPoint2 = list.get(i5);
                if (a(iPoint, iPoint2)) {
                    arrayList.add(iPoint2);
                    iPoint = iPoint2;
                }
                i5++;
            }
            arrayList.add(list.get(i4));
            float[] fArr = new float[(arrayList.size() * 3)];
            int size2 = arrayList.size();
            IPoint[] iPointArr = new IPoint[size2];
            Iterator it = arrayList.iterator();
            int i6 = 0;
            while (it.hasNext()) {
                IPoint iPoint3 = (IPoint) it.next();
                int i7 = i6 * 3;
                fArr[i7] = (float) (Point.getx(iPoint3) - i2);
                fArr[i7 + 1] = (float) (Point.gety(iPoint3) - i3);
                fArr[i7 + 2] = 0.0f;
                iPointArr[i6] = iPoint3;
                i6++;
            }
            IPoint[] a2 = a(iPointArr);
            if (a2.length == 0) {
                if (H == 1.0E10d) {
                    H = 1.0E8d;
                } else {
                    H = 1.0E10d;
                }
                a2 = a(iPointArr);
            }
            float[] fArr2 = new float[(a2.length * 3)];
            int i8 = 0;
            for (IPoint iPoint4 : a2) {
                int i9 = i8 * 3;
                fArr2[i9] = (float) (Point.getx(iPoint4) - i2);
                fArr2[i9 + 1] = (float) (Point.gety(iPoint4) - i3);
                fArr2[i9 + 2] = 0.0f;
                i8++;
            }
            this.q = size2;
            this.r = a2.length;
            this.o = eq.a(fArr);
            this.p = eq.a(fArr2);
        }
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
                if (H == 1.0E10d) {
                    H = 1.0E8d;
                } else {
                    H = 1.0E10d;
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
            this.D = size;
            this.E = a2.length;
            this.F = eq.a(fArr);
            this.G = eq.a(fArr2);
        }
    }

    private List<IPoint> b(List<LatLng> list) throws RemoteException {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            LatLng latLng = null;
            for (LatLng latLng2 : list) {
                if (!latLng2.equals(latLng)) {
                    IPoint obtain = IPoint.obtain();
                    this.b.latlon2Geo(latLng2.latitude, latLng2.longitude, obtain);
                    arrayList.add(obtain);
                    eq.b(this.a, Point.getx(obtain), Point.gety(obtain));
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

    private boolean a(Rectangle rectangle) {
        this.y = this.b.getZoomLevel();
        d();
        if (this.y > ((float) 10) && rectangle != null) {
            try {
                if (rectangle.contains(this.a)) {
                    return false;
                }
                return true;
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    private boolean b(CircleHoleOptions circleHoleOptions) {
        try {
            if (eq.b(getPoints(), circleHoleOptions) || !contains(circleHoleOptions.getCenter())) {
                return false;
            }
            return true;
        } catch (Throwable th) {
            hd.c(th, "PolygonDelegateImp", "isCircleInPolygon");
            th.printStackTrace();
            return false;
        }
    }

    private boolean a(IPoint iPoint, IPoint iPoint2) {
        int xVar = Point.getx(iPoint2);
        int xVar2 = Point.getx(iPoint);
        float f2 = this.t;
        if (((float) (xVar - xVar2)) < f2 && ((float) (xVar - xVar2)) > (-f2)) {
            int yVar = Point.gety(iPoint2);
            int yVar2 = Point.gety(iPoint);
            return ((float) (yVar - yVar2)) >= f2 || ((float) (yVar - yVar2)) <= (-f2);
        }
    }

    private boolean a(PolygonHoleOptions polygonHoleOptions) {
        boolean z2 = true;
        try {
            List<LatLng> points = polygonHoleOptions.getPoints();
            int i2 = 0;
            while (i2 < points.size() && (z2 = eq.a(points.get(i2), getPoints()))) {
                i2++;
            }
        } catch (Throwable th) {
            hd.c(th, "PolygonDelegateImp", "isPolygonInPolygon");
            th.printStackTrace();
        }
        return z2;
    }

    public static IPoint[] a(IPoint[] iPointArr) {
        int length = iPointArr.length;
        double[] dArr = new double[(length * 2)];
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i2 * 2;
            double d2 = H;
            dArr[i3] = ((double) Point.getx(iPointArr[i2])) * d2;
            dArr[i3 + 1] = ((double) Point.gety(iPointArr[i2])) * d2;
        }
        em a2 = new dv().a(dArr);
        int i4 = a2.b;
        IPoint[] iPointArr2 = new IPoint[i4];
        for (int i5 = 0; i5 < i4; i5++) {
            iPointArr2[i5] = new IPoint();
            ((android.graphics.Point) iPointArr2[i5]).x = (int) (dArr[a2.a(i5) * 2] / H);
            ((android.graphics.Point) iPointArr2[i5]).y = (int) (dArr[(a2.a(i5) * 2) + 1] / H);
        }
        return iPointArr2;
    }

    public void a(AMapPara.LineJoinType lineJoinType) {
        this.w = lineJoinType;
    }

    public void a(boolean z2) {
        this.v = z2;
    }
}
