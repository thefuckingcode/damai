package com.amap.api.mapcore.util;

import android.graphics.Rect;
import android.opengl.Matrix;
import android.os.RemoteException;
import com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.MultiPointItem;
import com.amap.api.maps.model.MultiPointOverlayOptions;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.MapProjection;
import com.autonavi.base.amap.mapcore.MapConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: Taobao */
public class aw implements av {
    private static int E;
    int A = -1;
    private String B;
    private float[] C = {-0.5f, -0.5f, 0.0f, 0.0f, 0.0f, 0.0f, -0.5f, 0.5f, 0.0f, 0.0f, 0.0f, 1.0f, 0.5f, 0.5f, 0.0f, 0.0f, 1.0f, 1.0f, 0.5f, -0.5f, 0.0f, 0.0f, 1.0f, 0.0f};
    private boolean D = true;
    private ExecutorService F = null;
    private List<String> G = new ArrayList();
    private float[] H = new float[(at.a * 3)];
    BitmapDescriptor a = BitmapDescriptorFactory.defaultMarker();
    BitmapDescriptor b = null;
    float c = 0.0f;
    float d = 0.0f;
    float e = 0.0f;
    float f = 0.5f;
    float g = 0.5f;
    List<MultiPointItem> h;
    ay i = null;
    au j = null;
    au k = new au(0, 1, 0, 1);
    List<MultiPointItem> l = new ArrayList();
    IPoint m;
    ax n;
    List<at> o = new ArrayList();
    float[] p = new float[16];
    float[] q = new float[4];
    float[] r = new float[4];
    Rect s = new Rect();
    au t = null;
    au u = null;
    int v = 0;
    int w = 0;
    float[] x = new float[12];
    String y = "precision highp float;\nattribute vec3 aVertex;//顶点数组,三维坐标\nuniform mat4 aMVPMatrix;//mvp矩阵\nvoid main(){\n  gl_Position = aMVPMatrix * vec4(aVertex, 1.0);\n}";
    String z = "//有颜色 没有纹理\nprecision highp float;\nvoid main(){\n  gl_FragColor = vec4(0,0,1,1.0);\n}";

    public aw(MultiPointOverlayOptions multiPointOverlayOptions, ax axVar) {
        this.n = axVar;
        a(multiPointOverlayOptions);
        at atVar = new at(a(), this);
        atVar.a(axVar.a());
        atVar.a(this.b);
        this.o.add(atVar);
    }

    private au b() {
        List<MultiPointItem> list = this.h;
        if (list == null || list.size() == 0) {
            return null;
        }
        Iterator<MultiPointItem> it = this.h.iterator();
        MultiPointItem next = it.next();
        int xVar = Point.getx(next.getIPoint());
        int xVar2 = Point.getx(next.getIPoint());
        int yVar = Point.gety(next.getIPoint());
        int yVar2 = Point.gety(next.getIPoint());
        while (it.hasNext()) {
            MultiPointItem next2 = it.next();
            int xVar3 = Point.getx(next2.getIPoint());
            int yVar3 = Point.gety(next2.getIPoint());
            if (xVar3 < xVar) {
                xVar = xVar3;
            }
            if (xVar3 > xVar2) {
                xVar2 = xVar3;
            }
            if (yVar3 < yVar) {
                yVar = yVar3;
            }
            if (yVar3 > yVar2) {
                yVar2 = yVar3;
            }
        }
        return new au(xVar, xVar2, yVar, yVar2);
    }

    private void c() {
        if (this.F == null) {
            this.F = new ThreadPoolExecutor(1, 2, (long) 1, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ed("MultiPointOverlay"), new ThreadPoolExecutor.AbortPolicy());
        }
        for (final at atVar : this.o) {
            if (atVar != null && !atVar.b()) {
                final String str = atVar.hashCode() + "";
                if (!this.G.contains(str)) {
                    this.G.add(str);
                    this.F.execute(new Runnable() {
                        /* class com.amap.api.mapcore.util.aw.AnonymousClass1 */

                        public void run() {
                            if (!atVar.b()) {
                                try {
                                    atVar.a();
                                    aw.this.G.remove(str);
                                } catch (Throwable unused) {
                                }
                            }
                        }
                    });
                }
            }
        }
    }

    private void d() {
        ax axVar = this.n;
        if (axVar != null) {
            axVar.d();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMultiPointOverlay
    public void addItem(MultiPointItem multiPointItem) {
        d();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMultiPointOverlay
    public void addItems(List<MultiPointItem> list) {
        ay ayVar;
        au b2;
        if (list != null) {
            try {
                if (list.size() != 0) {
                    synchronized (this) {
                        if (this.h == null) {
                            this.h = new ArrayList();
                        }
                        this.h.clear();
                        this.h.addAll(list);
                        int size = this.h.size();
                        for (int i2 = 0; i2 < size; i2++) {
                            List<MultiPointItem> list2 = this.h;
                            if (list2 != null) {
                                MultiPointItem multiPointItem = list2.get(i2);
                                if (!(multiPointItem == null || multiPointItem.getLatLng() == null || multiPointItem.getIPoint() != null)) {
                                    IPoint iPoint = new IPoint();
                                    MapProjection.lonlat2Geo(multiPointItem.getLatLng().longitude, multiPointItem.getLatLng().latitude, iPoint);
                                    multiPointItem.setIPoint(iPoint);
                                }
                            } else {
                                return;
                            }
                        }
                        if (this.i == null && (b2 = b()) != null) {
                            this.i = new ay(b2);
                        }
                        List<MultiPointItem> list3 = this.h;
                        if (list3 != null) {
                            int size2 = list3.size();
                            for (int i3 = 0; i3 < size2; i3++) {
                                MultiPointItem multiPointItem2 = this.h.get(i3);
                                if (!(multiPointItem2 == null || multiPointItem2.getIPoint() == null || (ayVar = this.i) == null)) {
                                    ayVar.a(multiPointItem2);
                                }
                            }
                        }
                        d();
                    }
                }
            } catch (Throwable th) {
                hd.c(th, "MultiPointOverlayDelegate", "addItems");
            }
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMultiPointOverlay
    public void destroy(boolean z2) {
        remove(z2);
        BitmapDescriptor bitmapDescriptor = this.b;
        if (bitmapDescriptor != null) {
            bitmapDescriptor.recycle();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMultiPointOverlay
    public String getId() throws RemoteException {
        if (this.B == null) {
            this.B = a("MultiPointOverlay");
        }
        return this.B;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMultiPointOverlay
    public MultiPointItem onClick(IPoint iPoint) {
        if (!this.D || this.i == null) {
            return null;
        }
        if (this.t == null) {
            this.t = new au(0, 1, 0, 1);
        }
        int i2 = (int) (this.c * 8.0f);
        au auVar = this.t;
        int xVar = Point.getx(iPoint);
        int yVar = Point.gety(iPoint);
        auVar.a(xVar - i2, xVar + i2, yVar - i2, yVar + i2);
        synchronized (this.l) {
            for (int size = this.l.size() - 1; size >= 0; size--) {
                MultiPointItem multiPointItem = this.l.get(size);
                IPoint iPoint2 = multiPointItem.getIPoint();
                if (iPoint2 != null) {
                    if (this.k == null) {
                        return null;
                    }
                    if (this.u == null) {
                        this.u = new au(0, 1, 0, 1);
                    }
                    au auVar2 = this.u;
                    int xVar2 = Point.getx(iPoint2);
                    au auVar3 = this.k;
                    int yVar2 = Point.gety(iPoint2);
                    auVar2.a(auVar3.a + xVar2, xVar2 + auVar3.c, auVar3.b + yVar2, yVar2 + auVar3.d);
                    if (this.u.a(this.t)) {
                        return multiPointItem;
                    }
                }
            }
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMultiPointOverlay
    public void remove(boolean z2) {
        ax axVar;
        this.D = false;
        try {
            this.v = 0;
            this.w = 0;
            BitmapDescriptor bitmapDescriptor = this.a;
            if (bitmapDescriptor != null) {
                bitmapDescriptor.recycle();
            }
            synchronized (this) {
                List<MultiPointItem> list = this.h;
                if (list != null) {
                    list.clear();
                    this.h = null;
                }
            }
            ay ayVar = this.i;
            if (ayVar != null) {
                ayVar.a();
                this.i = null;
            }
            List<MultiPointItem> list2 = this.l;
            if (list2 != null) {
                list2.clear();
            }
            ExecutorService executorService = this.F;
            if (executorService != null) {
                executorService.shutdownNow();
                this.F = null;
            }
            List<String> list3 = this.G;
            if (list3 != null) {
                list3.clear();
            }
            List<at> list4 = this.o;
            if (list4 != null) {
                for (at atVar : list4) {
                    if (atVar != null) {
                        atVar.c();
                    }
                }
                this.o.clear();
            }
            if (z2 && (axVar = this.n) != null) {
                axVar.a(this);
                this.n.d();
            }
            this.n = null;
            this.C = null;
        } catch (Throwable unused) {
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMultiPointOverlay
    public void setAnchor(float f2, float f3) {
        this.f = f2;
        this.g = f3;
        d();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMultiPointOverlay
    public void setVisible(boolean z2) {
        if (this.D != z2) {
            d();
        }
        this.D = z2;
    }

    private float[] a() {
        float[] fArr = this.C;
        if (fArr == null) {
            return null;
        }
        float[] fArr2 = (float[]) fArr.clone();
        float f2 = this.f - 0.5f;
        float f3 = this.g - 0.5f;
        fArr2[0] = fArr2[0] + f2;
        fArr2[1] = fArr2[1] - f3;
        fArr2[6] = fArr2[6] + f2;
        fArr2[7] = fArr2[7] - f3;
        fArr2[12] = fArr2[12] + f2;
        fArr2[13] = fArr2[13] - f3;
        fArr2[18] = fArr2[18] + f2;
        fArr2[19] = fArr2[19] - f3;
        return fArr2;
    }

    private static String a(String str) {
        E++;
        return str + E;
    }

    private void a(MultiPointOverlayOptions multiPointOverlayOptions) {
        if (multiPointOverlayOptions != null) {
            if (multiPointOverlayOptions.getIcon() == null || multiPointOverlayOptions.getIcon().getBitmap() == null || multiPointOverlayOptions.getIcon().getBitmap().isRecycled()) {
                this.b = this.a;
            } else {
                this.b = multiPointOverlayOptions.getIcon();
            }
            this.f = multiPointOverlayOptions.getAnchorU();
            this.g = multiPointOverlayOptions.getAnchorV();
        }
    }

    @Override // com.amap.api.mapcore.util.av
    public void a(MapConfig mapConfig, float[] fArr, float[] fArr2) {
        int i2;
        ax axVar;
        try {
            if (this.D) {
                c();
                if (!(this.o.size() < 1 || this.i == null || mapConfig == null)) {
                    float sr = mapConfig.getSR();
                    float sc = mapConfig.getSC();
                    if (mapConfig.getChangeRatio() != 1.0d || this.l.size() == 0) {
                        synchronized (this.l) {
                            a(mapConfig);
                            this.l.clear();
                            float mapPerPixelUnitLength = mapConfig.getMapPerPixelUnitLength();
                            this.c = mapPerPixelUnitLength;
                            this.d = mapPerPixelUnitLength * ((float) this.b.getWidth());
                            float height = this.c * ((float) this.b.getHeight());
                            this.e = height;
                            float f2 = this.d;
                            a(f2, height, sr, sc);
                            this.i.a(this.j, this.l, (double) (f2 * height * 16.0f));
                        }
                    }
                    if (this.m == null) {
                        this.m = new IPoint();
                    }
                    IPoint iPoint = this.m;
                    if (iPoint != null) {
                        ((android.graphics.Point) iPoint).x = (int) mapConfig.getSX();
                        ((android.graphics.Point) this.m).y = (int) mapConfig.getSY();
                    }
                    at atVar = this.o.get(0);
                    synchronized (this.l) {
                        loop0:
                        while (true) {
                            i2 = 0;
                            for (MultiPointItem multiPointItem : this.l) {
                                IPoint iPoint2 = multiPointItem.getIPoint();
                                if (iPoint2 != null) {
                                    int xVar = Point.getx(iPoint2);
                                    IPoint iPoint3 = this.m;
                                    int xVar2 = xVar - Point.getx(iPoint3);
                                    int yVar = Point.gety(iPoint2) - Point.gety(iPoint3);
                                    if (atVar != null && atVar.b()) {
                                        if (!atVar.d() && (axVar = this.n) != null) {
                                            atVar.a(axVar.a());
                                        }
                                        float[] fArr3 = this.H;
                                        int i3 = i2 * 3;
                                        fArr3[i3 + 0] = (float) xVar2;
                                        fArr3[i3 + 1] = (float) yVar;
                                        fArr3[i3 + 2] = 0.0f;
                                        i2++;
                                        if (i2 >= at.a) {
                                            atVar.a(fArr, fArr2, fArr3, this.d, this.e, sr, sc, i2);
                                        }
                                    }
                                }
                            }
                            break loop0;
                        }
                    }
                    if (i2 > 0) {
                        atVar.a(fArr, fArr2, this.H, this.d, this.e, sr, sc, i2);
                    }
                }
            }
        } catch (Throwable th) {
            hd.c(th, "MultiPointOverlayDelegate", "draw");
        }
    }

    private void a(MapConfig mapConfig) {
        if (mapConfig != null) {
            Rect rect = mapConfig.getGeoRectangle().getRect();
            au auVar = this.j;
            if (auVar == null) {
                this.j = new au(rect.left, rect.right, rect.top, rect.bottom);
            } else {
                auVar.a(rect.left, rect.right, rect.top, rect.bottom);
            }
        }
    }

    private void a(float f2, float f3, float f4, float f5) {
        if (this.k == null) {
            this.k = new au(0, 1, 0, 1);
        }
        this.s.set(0, 0, 0, 0);
        IPoint iPoint = new IPoint();
        float f6 = this.f;
        float f7 = this.g;
        Matrix.setIdentityM(this.p, 0);
        Matrix.rotateM(this.p, 0, -f4, 0.0f, 0.0f, 1.0f);
        float[] fArr = this.r;
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
        fArr[3] = 0.0f;
        float[] fArr2 = this.q;
        float f8 = (-f2) * f6;
        fArr2[0] = f8;
        float f9 = f3 * f7;
        fArr2[1] = f9;
        fArr2[2] = 0.0f;
        fArr2[3] = 1.0f;
        Matrix.multiplyMV(fArr, 0, this.p, 0, fArr2, 0);
        Rect rect = this.s;
        int xVar = Point.getx(iPoint);
        float[] fArr3 = this.r;
        int yVar = Point.gety(iPoint);
        rect.set((int) (((float) xVar) + fArr3[0]), (int) (((float) yVar) - fArr3[1]), (int) (((float) xVar) + fArr3[0]), (int) (((float) yVar) - fArr3[1]));
        float[] fArr4 = this.q;
        float f10 = f2 * (1.0f - f6);
        fArr4[0] = f10;
        fArr4[1] = f9;
        fArr4[2] = 0.0f;
        fArr4[3] = 1.0f;
        Matrix.multiplyMV(this.r, 0, this.p, 0, fArr4, 0);
        Rect rect2 = this.s;
        float[] fArr5 = this.r;
        rect2.union((int) (((float) Point.getx(iPoint)) + fArr5[0]), (int) (((float) Point.gety(iPoint)) - fArr5[1]));
        float[] fArr6 = this.q;
        fArr6[0] = f10;
        float f11 = (-f3) * (1.0f - f7);
        fArr6[1] = f11;
        fArr6[2] = 0.0f;
        fArr6[3] = 1.0f;
        Matrix.multiplyMV(this.r, 0, this.p, 0, fArr6, 0);
        Rect rect3 = this.s;
        float[] fArr7 = this.r;
        rect3.union((int) (((float) Point.getx(iPoint)) + fArr7[0]), (int) (((float) Point.gety(iPoint)) - fArr7[1]));
        float[] fArr8 = this.q;
        fArr8[0] = f8;
        fArr8[1] = f11;
        fArr8[2] = 0.0f;
        fArr8[3] = 1.0f;
        Matrix.multiplyMV(this.r, 0, this.p, 0, fArr8, 0);
        Rect rect4 = this.s;
        float[] fArr9 = this.r;
        rect4.union((int) (((float) Point.getx(iPoint)) + fArr9[0]), (int) (((float) Point.gety(iPoint)) - fArr9[1]));
        au auVar = this.k;
        Rect rect5 = this.s;
        auVar.a(rect5.left, rect5.right, rect5.top, rect5.bottom);
    }
}
