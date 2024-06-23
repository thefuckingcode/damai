package com.amap.api.mapcore.util;

import android.graphics.Color;
import android.graphics.PointF;
import android.os.RemoteException;
import android.util.Log;
import com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point;
import com.amap.api.maps.model.LatLng;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.interfaces.IOverlay;
import com.autonavi.base.ae.gmap.GLMapState;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.api.mapcore.overlays.IArcDelegate;
import com.autonavi.base.amap.mapcore.AMapNativeRenderer;
import com.autonavi.base.amap.mapcore.FPoint;
import com.autonavi.base.amap.mapcore.MapConfig;
import com.taobao.weex.common.Constants;

/* compiled from: Taobao */
public class co implements IArcDelegate {
    float a;
    float b;
    float c;
    float d;
    private LatLng e;
    private LatLng f;
    private LatLng g;
    private float h = 10.0f;
    private int i = -16777216;
    private float j = 0.0f;
    private boolean k = true;
    private String l;
    private IAMapDelegate m;
    private float[] n;
    private int o = 0;
    private boolean p = false;
    private double q = 0.0d;
    private double r = 0.0d;
    private double s = 0.0d;
    private double t = 0.0d;
    private double u = 0.0d;

    public co(IAMapDelegate iAMapDelegate) {
        this.m = iAMapDelegate;
        try {
            this.l = getId();
        } catch (RemoteException e2) {
            hd.c(e2, "ArcDelegateImp", "create");
            e2.printStackTrace();
        }
    }

    private FPoint a(GLMapState gLMapState, double d2, double d3, double d4) {
        int cos = (int) (d3 + (Math.cos(d2) * this.q));
        int i2 = (int) (d4 + ((-Math.sin(d2)) * this.q));
        FPoint obtain = FPoint.obtain();
        MapConfig mapConfig = this.m.getMapConfig();
        if (mapConfig != null) {
            ((PointF) obtain).x = (float) (cos - ((int) mapConfig.getSX()));
            ((PointF) obtain).y = (float) (i2 - ((int) mapConfig.getSY()));
        }
        return obtain;
    }

    private void b() {
        this.n = new float[9];
        FPoint obtain = FPoint.obtain();
        IAMapDelegate iAMapDelegate = this.m;
        LatLng latLng = this.e;
        iAMapDelegate.getLatLng2Map(latLng.latitude, latLng.longitude, obtain);
        FPoint obtain2 = FPoint.obtain();
        IAMapDelegate iAMapDelegate2 = this.m;
        LatLng latLng2 = this.f;
        iAMapDelegate2.getLatLng2Map(latLng2.latitude, latLng2.longitude, obtain2);
        FPoint obtain3 = FPoint.obtain();
        IAMapDelegate iAMapDelegate3 = this.m;
        LatLng latLng3 = this.g;
        iAMapDelegate3.getLatLng2Map(latLng3.latitude, latLng3.longitude, obtain3);
        FPoint[] fPointArr = {obtain, obtain2, obtain3};
        for (int i2 = 0; i2 < 3; i2++) {
            float[] fArr = this.n;
            int i3 = i2 * 3;
            fArr[i3] = ((PointF) fPointArr[i2]).x;
            fArr[i3 + 1] = ((PointF) fPointArr[i2]).y;
            fArr[i3 + 2] = 0.0f;
        }
        this.o = 3;
    }

    @Override // com.autonavi.base.amap.api.mapcore.overlays.IOverlayDelegate
    public boolean calMapFPoint() throws RemoteException {
        int i2;
        int i3;
        FPoint[] fPointArr;
        int i4;
        if (this.e == null || this.f == null || this.g == null || !this.k) {
            return false;
        }
        try {
            this.p = false;
            GLMapState mapProjection = this.m.getMapProjection();
            if (!a()) {
                b();
                return true;
            }
            DPoint obtain = DPoint.obtain(this.t, this.u);
            int abs = (int) ((Math.abs(this.s - this.r) * 180.0d) / 3.141592653589793d);
            if (abs == 0) {
                b();
                return true;
            }
            double d2 = (this.s - this.r) / ((double) abs);
            int i5 = abs + 1;
            FPoint[] fPointArr2 = new FPoint[i5];
            this.n = new float[(i5 * 3)];
            int i6 = 0;
            while (i6 <= abs) {
                if (i6 == abs) {
                    FPoint obtain2 = FPoint.obtain();
                    IAMapDelegate iAMapDelegate = this.m;
                    LatLng latLng = this.g;
                    iAMapDelegate.getLatLng2Map(latLng.latitude, latLng.longitude, obtain2);
                    fPointArr2[i6] = obtain2;
                    i4 = i5;
                    fPointArr = fPointArr2;
                    i2 = abs;
                    i3 = i6;
                } else {
                    i2 = abs;
                    i3 = i6;
                    i4 = i5;
                    fPointArr = fPointArr2;
                    fPointArr[i3] = a(mapProjection, (((double) i6) * d2) + this.r, obtain.x, obtain.y);
                }
                fPointArr[i3] = a(mapProjection, (((double) i3) * d2) + this.r, obtain.x, obtain.y);
                float[] fArr = this.n;
                int i7 = i3 * 3;
                fArr[i7] = ((PointF) fPointArr[i3]).x;
                fArr[i7 + 1] = ((PointF) fPointArr[i3]).y;
                fArr[i7 + 2] = 0.0f;
                i6 = i3 + 1;
                i5 = i4;
                fPointArr2 = fPointArr;
                abs = i2;
            }
            obtain.recycle();
            this.o = i5;
            return true;
        } catch (Throwable th) {
            hd.c(th, "ArcDelegateImp", "calMapFPoint");
            th.printStackTrace();
            return false;
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.overlays.IOverlayDelegate
    public boolean checkInBounds() {
        return true;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public void destroy() {
        try {
            this.e = null;
            this.f = null;
            this.g = null;
        } catch (Throwable th) {
            hd.c(th, "ArcDelegateImp", Constants.Event.SLOT_LIFECYCLE.DESTORY);
            th.printStackTrace();
            Log.d("destroy erro", "ArcDelegateImp destroy");
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.overlays.IOverlayDelegate
    public void draw(MapConfig mapConfig) throws RemoteException {
        if (this.e != null && this.f != null && this.g != null && this.k) {
            calMapFPoint();
            if (this.n != null && this.o > 0) {
                float mapLenWithWin = this.m.getMapProjection().getMapLenWithWin((int) this.h);
                this.m.getMapProjection().getMapLenWithWin(1);
                float[] fArr = this.n;
                AMapNativeRenderer.nativeDrawLineByTextureID(fArr, fArr.length, mapLenWithWin, this.m.getLineTextureID(), this.m.getLineTextureRatio(), this.b, this.c, this.d, this.a, 0.0f, false, true, false, this.m.getFinalMatrix(), 3, 0);
            }
            this.p = true;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public boolean equalsRemote(IOverlay iOverlay) throws RemoteException {
        return equals(iOverlay) || iOverlay.getId().equals(getId());
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public String getId() throws RemoteException {
        if (this.l == null) {
            this.l = this.m.createId("Arc");
        }
        return this.l;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IArc
    public int getStrokeColor() throws RemoteException {
        return this.i;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IArc
    public float getStrokeWidth() throws RemoteException {
        return this.h;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public float getZIndex() throws RemoteException {
        return this.j;
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
        return this.p;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public boolean isVisible() throws RemoteException {
        return this.k;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public void remove() throws RemoteException {
        this.m.removeGLOverlay(getId());
        this.m.setRunLowFrame(false);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public void setAboveMaskLayer(boolean z) {
    }

    @Override // com.autonavi.base.amap.api.mapcore.overlays.IArcDelegate
    public void setEnd(LatLng latLng) {
        this.g = latLng;
    }

    @Override // com.autonavi.base.amap.api.mapcore.overlays.IArcDelegate
    public void setPassed(LatLng latLng) {
        this.f = latLng;
    }

    @Override // com.autonavi.base.amap.api.mapcore.overlays.IArcDelegate
    public void setStart(LatLng latLng) {
        this.e = latLng;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IArc
    public void setStrokeColor(int i2) throws RemoteException {
        this.i = i2;
        this.a = ((float) Color.alpha(i2)) / 255.0f;
        this.b = ((float) Color.red(i2)) / 255.0f;
        this.c = ((float) Color.green(i2)) / 255.0f;
        this.d = ((float) Color.blue(i2)) / 255.0f;
        this.m.setRunLowFrame(false);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IArc
    public void setStrokeWidth(float f2) throws RemoteException {
        this.h = f2;
        this.m.setRunLowFrame(false);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public void setVisible(boolean z) throws RemoteException {
        this.k = z;
        this.m.setRunLowFrame(false);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public void setZIndex(float f2) throws RemoteException {
        this.j = f2;
        this.m.changeGLOverlayIndex();
        this.m.setRunLowFrame(false);
    }

    private boolean a() {
        IPoint obtain = IPoint.obtain();
        IAMapDelegate iAMapDelegate = this.m;
        LatLng latLng = this.e;
        iAMapDelegate.latlon2Geo(latLng.latitude, latLng.longitude, obtain);
        IPoint obtain2 = IPoint.obtain();
        IAMapDelegate iAMapDelegate2 = this.m;
        LatLng latLng2 = this.f;
        iAMapDelegate2.latlon2Geo(latLng2.latitude, latLng2.longitude, obtain2);
        IPoint obtain3 = IPoint.obtain();
        IAMapDelegate iAMapDelegate3 = this.m;
        LatLng latLng3 = this.g;
        iAMapDelegate3.latlon2Geo(latLng3.latitude, latLng3.longitude, obtain3);
        double xVar = (double) Point.getx(obtain);
        double yVar = (double) Point.gety(obtain);
        double xVar2 = (double) Point.getx(obtain2);
        double yVar2 = (double) Point.gety(obtain2);
        double xVar3 = (double) Point.getx(obtain3);
        double yVar3 = (double) Point.gety(obtain3);
        double d2 = xVar2 - xVar;
        double d3 = yVar3 - yVar;
        double d4 = xVar3 - xVar;
        double d5 = yVar2 - yVar;
        double d6 = ((d2 * 2.0d) * d3) - ((d4 * 2.0d) * d5);
        double d7 = ((d5 * 2.0d) * d4) - ((2.0d * d3) * d2);
        if (d6 == 0.0d || d7 == 0.0d) {
            return false;
        }
        double d8 = yVar2 * yVar2;
        double d9 = yVar * yVar;
        double d10 = xVar2 * xVar2;
        double d11 = xVar * xVar;
        double d12 = yVar3 * yVar3;
        double d13 = xVar3 * xVar3;
        double d14 = ((d3 * (((d8 - d9) + d10) - d11)) + (d5 * (((d9 - d12) + d11) - d13))) / d6;
        this.t = d14;
        this.u = ((d4 * (((d10 - d11) + d8) - d9)) + (d2 * (((d11 - d13) + d9) - d12))) / d7;
        if (Double.isNaN(d14) || Double.isNaN(this.u) || Double.isInfinite(this.t) || Double.isInfinite(this.u)) {
            return false;
        }
        double d15 = this.t;
        double d16 = (xVar - d15) * (xVar - d15);
        double d17 = this.u;
        this.q = Math.sqrt(d16 + ((yVar - d17) * (yVar - d17)));
        this.r = a(this.t, this.u, xVar, yVar);
        double a2 = a(this.t, this.u, xVar2, yVar2);
        double a3 = a(this.t, this.u, xVar3, yVar3);
        this.s = a3;
        double d18 = this.r;
        if (d18 < a3) {
            if (a2 <= d18 || a2 >= a3) {
                this.s = a3 - 6.283185307179586d;
            }
        } else if (a2 <= a3 || a2 >= d18) {
            this.s = a3 + 6.283185307179586d;
        }
        obtain.recycle();
        obtain2.recycle();
        obtain3.recycle();
        return true;
    }

    private double a(double d2, double d3, double d4, double d5) {
        double d6 = (d3 - d5) / this.q;
        if (Math.abs(d6) > 1.0d) {
            d6 = Math.signum(d6);
        }
        double asin = Math.asin(d6);
        return asin >= 0.0d ? d4 < d2 ? 3.141592653589793d - Math.abs(asin) : asin : d4 < d2 ? 3.141592653589793d - asin : asin + 6.283185307179586d;
    }
}
