package com.amap.api.mapcore.util;

import android.graphics.Color;
import android.graphics.Rect;
import android.os.RemoteException;
import android.util.Log;
import com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point;
import com.amap.api.maps.model.LatLng;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.interfaces.IOverlay;
import com.autonavi.base.ae.gmap.gloverlay.GLOverlay;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.api.mapcore.overlays.INavigateArrowDelegate;
import com.autonavi.base.amap.mapcore.AMapNativeRenderer;
import com.autonavi.base.amap.mapcore.MapConfig;
import com.autonavi.base.amap.mapcore.Rectangle;
import com.taobao.weex.common.Constants;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/* compiled from: Taobao */
public class cw implements INavigateArrowDelegate {
    private boolean A = true;
    int[] a = null;
    int[] b = null;
    float c;
    float d;
    float e;
    float f;
    Rect g = null;
    boolean h = false;
    float[] i;
    int j = 0;
    private IAMapDelegate k;
    private float l = 10.0f;
    private int m = -16777216;
    private int n = -16777216;
    private float o = 0.0f;
    private boolean p = true;
    private String q;
    private List<IPoint> r = new Vector();
    private int s = 0;
    private boolean t = false;
    private boolean u = false;
    private boolean v = false;
    private boolean w = false;
    private Object x = new Object();
    private String y = null;
    private final int z = Color.argb(0, 0, 0, 0);

    public cw(IAMapDelegate iAMapDelegate) {
        this.k = iAMapDelegate;
        try {
            this.q = getId();
        } catch (RemoteException e2) {
            hd.c(e2, "NavigateArrowDelegateImp", "create");
            e2.printStackTrace();
        }
        this.h = false;
    }

    @Override // com.autonavi.base.amap.api.mapcore.overlays.IOverlayDelegate
    public boolean calMapFPoint() throws RemoteException {
        return true;
    }

    @Override // com.autonavi.base.amap.api.mapcore.overlays.IOverlayDelegate
    public boolean checkInBounds() {
        Rectangle geoRectangle;
        if (this.g == null || (geoRectangle = this.k.getMapConfig().getGeoRectangle()) == null || !geoRectangle.isOverlap(this.g)) {
            return false;
        }
        return true;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public void destroy() {
        try {
            remove();
            if (this.i != null) {
                this.i = null;
            }
        } catch (Throwable th) {
            hd.c(th, "NavigateArrowDelegateImp", Constants.Event.SLOT_LIFECYCLE.DESTORY);
            th.printStackTrace();
            Log.d("destroy erro", "NavigateArrowDelegateImp destroy");
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.overlays.IOverlayDelegate
    public void draw(MapConfig mapConfig) throws RemoteException {
        List<IPoint> list;
        if (!this.h && (list = this.r) != null && list.size() != 0 && this.l > 0.0f) {
            if (!this.u) {
                if (this.y != null && this.v) {
                    this.k.getGLMapEngine().updateNativeArrowOverlay(1, this.y, this.a, this.b, this.m, this.n, this.z, this.l, 111, 222, 333, false);
                    this.A = false;
                }
                a(this.k.getMapConfig());
                if (this.i != null && this.s > 0) {
                    AMapNativeRenderer.nativeDrawLineByTextureID(this.i, this.j, this.k.getMapProjection().getMapLenWithWin((int) this.l), this.k.getLineTextureID(), this.k.getLineTextureRatio(), this.d, this.e, this.f, this.c, 0.0f, false, true, true, this.k.getFinalMatrix(), 2, 0);
                    this.v = false;
                    this.w = false;
                }
            } else {
                IAMapDelegate iAMapDelegate = this.k;
                if (!(iAMapDelegate == null || iAMapDelegate.getGLMapEngine() == null)) {
                    if (this.y == null) {
                        this.y = this.k.getGLMapEngine().addNativeOverlay(1, GLOverlay.EAMapOverlayTpye.AMAPOVERLAY_ARROW.ordinal(), hashCode());
                    }
                    if (this.y != null && this.A) {
                        this.k.getGLMapEngine().updateNativeArrowOverlay(1, this.y, this.a, this.b, this.m, this.n, this.z, this.l, 111, 222, 333, this.p);
                        this.v = true;
                        this.w = this.p;
                        this.A = false;
                    }
                }
            }
            this.t = true;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public boolean equalsRemote(IOverlay iOverlay) throws RemoteException {
        return equals(iOverlay) || iOverlay.getId().equals(getId());
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public String getId() throws RemoteException {
        if (this.q == null) {
            this.q = this.k.createId("NavigateArrow");
        }
        return this.q;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.INavigateArrow
    public List<LatLng> getPoints() throws RemoteException {
        return a();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.INavigateArrow
    public int getSideColor() throws RemoteException {
        return this.n;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.INavigateArrow
    public int getTopColor() throws RemoteException {
        return this.m;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.INavigateArrow
    public float getWidth() throws RemoteException {
        return this.l;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public float getZIndex() throws RemoteException {
        return this.o;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public int hashCodeRemote() throws RemoteException {
        return super.hashCode();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.INavigateArrow
    public boolean is3DModel() {
        return this.u;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public boolean isAboveMaskLayer() {
        return false;
    }

    @Override // com.autonavi.base.amap.api.mapcore.overlays.IOverlayDelegate
    public boolean isDrawFinish() {
        return this.t;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public boolean isVisible() throws RemoteException {
        if (this.u) {
            return this.p || this.w;
        }
        return this.p;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public void remove() throws RemoteException {
        if (!this.h) {
            IAMapDelegate iAMapDelegate = this.k;
            if (!(iAMapDelegate == null || iAMapDelegate.getGLMapEngine() == null || this.y == null)) {
                this.k.queueEvent(new Runnable() {
                    /* class com.amap.api.mapcore.util.cw.AnonymousClass1 */

                    public void run() {
                        if (cw.this.k != null && cw.this.k.getGLMapEngine() != null) {
                            if (cw.this.y != null) {
                                cw.this.k.getGLMapEngine().removeNativeOverlay(1, cw.this.y);
                            }
                            cw.this.y = null;
                        }
                    }
                });
            }
            this.k.removeGLOverlay(getId());
            this.k.setRunLowFrame(false);
            this.h = true;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.INavigateArrow
    public void set3DModel(boolean z2) {
        this.u = z2;
        this.w = this.p;
        this.A = true;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public void setAboveMaskLayer(boolean z2) {
    }

    @Override // com.autonavi.amap.mapcore.interfaces.INavigateArrow
    public void setPoints(List<LatLng> list) throws RemoteException {
        a(list);
        this.A = true;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.INavigateArrow
    public void setSideColor(int i2) throws RemoteException {
        this.n = i2;
        this.k.setRunLowFrame(false);
        this.A = true;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.INavigateArrow
    public void setTopColor(int i2) throws RemoteException {
        this.m = i2;
        this.c = ((float) Color.alpha(i2)) / 255.0f;
        this.d = ((float) Color.red(i2)) / 255.0f;
        this.e = ((float) Color.green(i2)) / 255.0f;
        this.f = ((float) Color.blue(i2)) / 255.0f;
        this.k.setRunLowFrame(false);
        this.A = true;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public void setVisible(boolean z2) throws RemoteException {
        this.p = z2;
        this.k.setRunLowFrame(false);
        this.A = true;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.INavigateArrow
    public void setWidth(float f2) throws RemoteException {
        this.l = f2;
        this.k.setRunLowFrame(false);
        this.A = true;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public void setZIndex(float f2) throws RemoteException {
        this.o = f2;
        this.k.changeGLOverlayIndex();
        this.k.setRunLowFrame(false);
    }

    /* access modifiers changed from: package-private */
    public void a(List<LatLng> list) throws RemoteException {
        synchronized (this.x) {
            this.r.clear();
            if (this.g == null) {
                this.g = new Rect();
            }
            eq.a(this.g);
            if (list != null) {
                LatLng latLng = null;
                for (LatLng latLng2 : list) {
                    if (latLng2 != null) {
                        if (!latLng2.equals(latLng)) {
                            IPoint obtain = IPoint.obtain();
                            this.k.latlon2Geo(latLng2.latitude, latLng2.longitude, obtain);
                            this.r.add(obtain);
                            eq.b(this.g, Point.getx(obtain), Point.gety(obtain));
                            latLng = latLng2;
                        }
                    }
                }
            }
            this.s = 0;
            this.g.sort();
            int size = this.r.size();
            this.a = new int[size];
            this.b = new int[size];
            int i2 = 0;
            for (IPoint iPoint : this.r) {
                this.a[i2] = Point.getx(iPoint);
                this.b[i2] = Point.gety(iPoint);
                i2++;
            }
        }
        this.k.setRunLowFrame(false);
    }

    private List<LatLng> a() throws RemoteException {
        ArrayList arrayList;
        if (this.r == null) {
            return null;
        }
        synchronized (this.x) {
            arrayList = new ArrayList();
            for (IPoint iPoint : this.r) {
                if (iPoint != null) {
                    DPoint obtain = DPoint.obtain();
                    this.k.geo2Latlng(Point.getx(iPoint), Point.gety(iPoint), obtain);
                    arrayList.add(new LatLng(obtain.y, obtain.x));
                    obtain.recycle();
                }
            }
        }
        return arrayList;
    }

    public boolean a(MapConfig mapConfig) throws RemoteException {
        synchronized (this.x) {
            int sx = (int) mapConfig.getSX();
            int sy = (int) mapConfig.getSY();
            int i2 = 0;
            this.t = false;
            int size = this.r.size();
            float[] fArr = this.i;
            if (fArr == null || fArr.length < size * 3) {
                this.i = new float[(size * 3)];
            }
            this.j = size * 3;
            for (IPoint iPoint : this.r) {
                float[] fArr2 = this.i;
                int i3 = i2 * 3;
                fArr2[i3] = (float) (Point.getx(iPoint) - sx);
                fArr2[i3 + 1] = (float) (Point.gety(iPoint) - sy);
                fArr2[i3 + 2] = 0.0f;
                i2++;
            }
            this.s = this.r.size();
        }
        return true;
    }
}
