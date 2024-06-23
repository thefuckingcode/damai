package com.amap.api.mapcore.util;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.opengl.GLES20;
import com.amap.api.mapcore.util.de;
import com.amap.api.mapcore.util.dq;
import com.amap.api.mapcore.util.et;
import com.amap.api.mapcore.util.eu;
import com.amap.api.maps.MapsInitializer;
import com.amap.api.maps.model.TileOverlayOptions;
import com.amap.api.maps.model.TileProvider;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.interfaces.ITileOverlay;
import com.autonavi.base.ae.gmap.GLMapState;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.api.mapcore.overlays.ITileOverlayDelegate;
import com.autonavi.base.amap.mapcore.MapConfig;
import java.lang.ref.WeakReference;
import java.nio.Buffer;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: Taobao */
public class dc implements ITileOverlayDelegate {
    private static int h;
    de.g a;
    private ab b;
    private TileProvider c;
    private Float d;
    private boolean e;
    private boolean f = false;
    private IAMapDelegate g;
    private int i = 256;
    private int j = 256;
    private int k = -1;
    private er l;
    private List<a> m = new ArrayList();
    private boolean n = false;
    private b o = null;
    private String p = null;
    private FloatBuffer q = null;

    public dc(TileOverlayOptions tileOverlayOptions, ab abVar, boolean z) {
        eu.a aVar;
        this.b = abVar;
        TileProvider tileProvider = tileOverlayOptions.getTileProvider();
        this.c = tileProvider;
        this.i = tileProvider.getTileWidth();
        this.j = this.c.getTileHeight();
        this.q = eq.a(new float[]{0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f});
        this.d = Float.valueOf(tileOverlayOptions.getZIndex());
        this.e = tileOverlayOptions.isVisible();
        this.f = z;
        if (z) {
            this.p = "TileOverlay0";
        } else {
            this.p = getId();
        }
        this.g = this.b.a();
        this.k = Integer.parseInt(this.p.substring(11));
        if (z) {
            try {
                aVar = new eu.a(this.b.f(), this.p, abVar.a().getMapConfig().getMapLanguage());
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        } else {
            aVar = new eu.a(this.b.f(), this.p);
        }
        aVar.a(tileOverlayOptions.getMemoryCacheEnabled());
        if (this.f) {
            aVar.i = false;
        }
        aVar.b(tileOverlayOptions.getDiskCacheEnabled());
        aVar.a(tileOverlayOptions.getMemCacheSize());
        aVar.a(tileOverlayOptions.getDiskCacheSize());
        String diskCacheDir = tileOverlayOptions.getDiskCacheDir();
        if (diskCacheDir != null && !"".equals(diskCacheDir)) {
            aVar.a(diskCacheDir);
        }
        er erVar = new er(this.b.f(), this.i, this.j);
        this.l = erVar;
        erVar.a(this.c);
        this.l.a(aVar);
        this.l.a((et.c) new et.c() {
            /* class com.amap.api.mapcore.util.dc.AnonymousClass1 */

            @Override // com.amap.api.mapcore.util.et.c
            public void a() {
                dc.this.g.resetRenderTimeLongLong();
            }
        });
    }

    private static String b(String str) {
        h++;
        return str + h;
    }

    private void c() {
        ab abVar = this.b;
        if (abVar != null && abVar.a() != null) {
            this.a = (de.g) this.b.a().getGLShader(0);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.ITileOverlay
    public void clearTileCache() {
        er erVar = this.l;
        if (erVar != null) {
            erVar.f();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.ITileOverlay
    public void destroy(boolean z) {
        b();
        synchronized (this.m) {
            int size = this.m.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.m.get(i2).b();
            }
            this.m.clear();
        }
        er erVar = this.l;
        if (erVar != null) {
            erVar.d(z);
            this.l.b(true);
            this.l.a((TileProvider) null);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.overlays.ITileOverlayDelegate
    public void drawTiles() {
        List<a> list = this.m;
        if (list != null) {
            synchronized (list) {
                if (this.m.size() != 0) {
                    int size = this.m.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        a aVar = this.m.get(i2);
                        if (!aVar.g) {
                            try {
                                IPoint iPoint = aVar.e;
                                Bitmap bitmap = aVar.i;
                                if (!(bitmap == null || bitmap.isRecycled() || iPoint == null)) {
                                    int a2 = eq.a(aVar.i);
                                    aVar.f = a2;
                                    if (a2 != 0) {
                                        aVar.g = true;
                                    }
                                    aVar.i = null;
                                }
                            } catch (Throwable th) {
                                hd.c(th, "TileOverlayDelegateImp", "drawTiles");
                            }
                        }
                        if (aVar.g) {
                            a(aVar);
                            a(aVar.f, aVar.h, this.q);
                        }
                    }
                }
            }
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.ITileOverlay
    public boolean equalsRemote(ITileOverlay iTileOverlay) {
        return equals(iTileOverlay) || iTileOverlay.getId().equals(getId());
    }

    @Override // com.autonavi.amap.mapcore.interfaces.ITileOverlay
    public String getId() {
        if (this.p == null) {
            this.p = b("TileOverlay");
        }
        return this.p;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.ITileOverlay
    public float getZIndex() {
        return this.d.floatValue();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.ITileOverlay
    public int hashCodeRemote() {
        return super.hashCode();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.ITileOverlay
    public boolean isVisible() {
        return this.e;
    }

    @Override // com.autonavi.base.amap.api.mapcore.overlays.ITileOverlayDelegate
    public void onFling(boolean z) {
        if (this.n != z) {
            this.n = z;
            er erVar = this.l;
            if (erVar != null) {
                erVar.b(z);
            }
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.overlays.ITileOverlayDelegate
    public void onPause() {
        b();
        synchronized (this.m) {
            int size = this.m.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.m.get(i2).b();
            }
            this.m.clear();
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.overlays.ITileOverlayDelegate
    public void onResume() {
        er erVar = this.l;
        if (erVar != null) {
            erVar.a(false);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.overlays.ITileOverlayDelegate
    public void reLoadTexture() {
        List<a> list = this.m;
        if (list != null) {
            synchronized (list) {
                if (this.m.size() != 0) {
                    for (a aVar : this.m) {
                        aVar.g = false;
                        aVar.f = 0;
                    }
                }
            }
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.overlays.ITileOverlayDelegate
    public void refresh(boolean z) {
        if (!this.n) {
            b();
            a(z);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.ITileOverlay
    public void remove() {
        this.b.b(this);
        this.g.setRunLowFrame(false);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.ITileOverlay
    public void setVisible(boolean z) {
        this.e = z;
        this.g.setRunLowFrame(false);
        if (z) {
            refresh(true);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.ITileOverlay
    public void setZIndex(float f2) {
        this.d = Float.valueOf(f2);
        this.b.d();
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class b extends dq<Void, Void, List<a>> {
        private int d;
        private boolean e;
        private int f = 256;
        private int g = 256;
        private int h = 0;
        private WeakReference<IAMapDelegate> i;
        private List<a> j;
        private boolean k;
        private WeakReference<ab> l;
        private WeakReference<er> m;

        public b(boolean z, IAMapDelegate iAMapDelegate, int i2, int i3, int i4, List<a> list, boolean z2, ab abVar, er erVar) {
            this.e = z;
            this.i = new WeakReference<>(iAMapDelegate);
            this.f = i2;
            this.g = i3;
            this.h = i4;
            this.j = list;
            this.k = z2;
            this.l = new WeakReference<>(abVar);
            this.m = new WeakReference<>(erVar);
        }

        /* access modifiers changed from: protected */
        public List<a> a(Void... voidArr) {
            try {
                IAMapDelegate iAMapDelegate = this.i.get();
                if (iAMapDelegate == null) {
                    return null;
                }
                int mapWidth = iAMapDelegate.getMapWidth();
                int mapHeight = iAMapDelegate.getMapHeight();
                int zoomLevel = (int) iAMapDelegate.getZoomLevel();
                this.d = zoomLevel;
                if (mapWidth <= 0) {
                    return null;
                }
                if (mapHeight <= 0) {
                    return null;
                }
                return dc.b(iAMapDelegate, zoomLevel, this.f, this.g, this.h, this.l.get(), this.m.get());
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }

        /* access modifiers changed from: protected */
        public void a(List<a> list) {
            if (list != null) {
                try {
                    if (list.size() > 0) {
                        dc.b(this.i.get(), list, this.d, this.e, this.j, this.k, this.l.get(), this.m.get());
                        list.clear();
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x018b A[ADDED_TO_REGION] */
    public static ArrayList<a> b(IAMapDelegate iAMapDelegate, int i2, int i3, int i4, int i5, ab abVar, er erVar) {
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int yVar;
        int yVar2;
        int i11;
        int i12;
        int i13;
        int i14;
        boolean z;
        int i15;
        int i16;
        int xVar;
        int i17;
        boolean z2;
        int yVar3;
        boolean z3;
        GLMapState mapProjection = iAMapDelegate.getMapProjection();
        Rect rect = iAMapDelegate.getMapConfig().getGeoRectangle().getRect();
        IPoint obtain = IPoint.obtain();
        IPoint obtain2 = IPoint.obtain();
        int i18 = rect.left;
        ((Point) obtain).x = i18;
        ((Point) obtain).y = rect.top;
        int min = Math.min(Integer.MAX_VALUE, i18);
        int max = Math.max(0, com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(obtain));
        int min2 = Math.min(Integer.MAX_VALUE, com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(obtain));
        int max2 = Math.max(0, com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(obtain));
        int i19 = rect.right;
        ((Point) obtain).x = i19;
        ((Point) obtain).y = rect.top;
        int min3 = Math.min(min, i19);
        int max3 = Math.max(max, com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(obtain));
        int min4 = Math.min(min2, com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(obtain));
        int max4 = Math.max(max2, com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(obtain));
        int i20 = rect.left;
        ((Point) obtain).x = i20;
        ((Point) obtain).y = rect.bottom;
        int min5 = Math.min(min3, i20);
        int max5 = Math.max(max3, com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(obtain));
        int min6 = Math.min(min4, com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(obtain));
        int max6 = Math.max(max4, com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(obtain));
        int i21 = rect.right;
        ((Point) obtain).x = i21;
        ((Point) obtain).y = rect.bottom;
        int min7 = Math.min(min5, i21);
        int max7 = Math.max(max5, com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(obtain));
        int min8 = Math.min(min6, com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(obtain));
        int max8 = Math.max(max6, com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(obtain));
        int i22 = 20 - i2;
        int i23 = 1 << i22;
        int i24 = min7 - (i23 * i3);
        mapProjection.getMapGeoCenter(obtain2);
        int xVar2 = (com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(obtain2) >> i22) / i3;
        int yVar4 = (com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(obtain2) >> i22) / i4;
        int i25 = min8 - (i23 * i4);
        int i26 = max8;
        a aVar = new a(xVar2, yVar4, i2, i5, iAMapDelegate, abVar, erVar);
        aVar.e = IPoint.obtain((xVar2 << i22) * i3, (yVar4 << i22) * i4);
        obtain.recycle();
        obtain2.recycle();
        ArrayList<a> arrayList = new ArrayList<>();
        arrayList.add(aVar);
        int i27 = 1;
        while (true) {
            int i28 = xVar2 - i27;
            int i29 = i28;
            boolean z4 = false;
            while (true) {
                i6 = xVar2 + i27;
                if (i29 > i6) {
                    break;
                }
                int i30 = yVar4 + i27;
                int i31 = (i29 << i22) * i3;
                IPoint iPoint = new IPoint(i31, (i30 << i22) * i4);
                int xVar3 = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(iPoint);
                if (xVar3 >= max7 || xVar3 <= i24) {
                    i13 = i28;
                    i12 = i29;
                    i15 = i31;
                    i11 = i25;
                    i16 = i26;
                } else {
                    int yVar5 = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(iPoint);
                    if (yVar5 >= i26) {
                        i13 = i28;
                        i12 = i29;
                        i16 = i26;
                        i15 = i31;
                        i11 = i25;
                    } else if (yVar5 > i25) {
                        if (!z4) {
                            z4 = true;
                        }
                        i14 = xVar2;
                        i13 = i28;
                        i16 = i26;
                        i12 = i29;
                        i15 = i31;
                        i11 = i25;
                        a aVar2 = new a(i29, i30, i2, i5, iAMapDelegate, abVar, erVar);
                        aVar2.e = iPoint;
                        arrayList.add(aVar2);
                        z = z4;
                        int i32 = yVar4 - i27;
                        IPoint iPoint2 = new IPoint(i15, (i32 << i22) * i4);
                        xVar = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(iPoint2);
                        if (xVar < max7 || xVar <= i24 || (yVar3 = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(iPoint2)) >= i16) {
                            z2 = z;
                            i17 = i11;
                        } else if (yVar3 > i11) {
                            if (!z) {
                                z = true;
                            }
                            i17 = i11;
                            a aVar3 = new a(i12, i32, i2, i5, iAMapDelegate, abVar, erVar);
                            aVar3.e = iPoint2;
                            arrayList.add(aVar3);
                            z2 = z;
                        } else {
                            z2 = z;
                            i17 = i11;
                        }
                        i29 = i12 + 1;
                        i26 = i16;
                        i28 = i13;
                        z4 = z2;
                        xVar2 = i14;
                        i25 = i17;
                    } else {
                        i14 = xVar2;
                        i13 = i28;
                        i12 = i29;
                        z3 = z4;
                        i11 = i25;
                        i16 = i26;
                        i15 = i31;
                        z = z3;
                        int i322 = yVar4 - i27;
                        IPoint iPoint22 = new IPoint(i15, (i322 << i22) * i4);
                        xVar = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(iPoint22);
                        if (xVar < max7) {
                        }
                        z2 = z;
                        i17 = i11;
                        i29 = i12 + 1;
                        i26 = i16;
                        i28 = i13;
                        z4 = z2;
                        xVar2 = i14;
                        i25 = i17;
                    }
                }
                i14 = xVar2;
                z3 = z4;
                z = z3;
                int i3222 = yVar4 - i27;
                IPoint iPoint222 = new IPoint(i15, (i3222 << i22) * i4);
                xVar = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(iPoint222);
                if (xVar < max7) {
                }
                z2 = z;
                i17 = i11;
                i29 = i12 + 1;
                i26 = i16;
                i28 = i13;
                z4 = z2;
                xVar2 = i14;
                i25 = i17;
            }
            boolean z5 = z4;
            int i33 = (yVar4 + i27) - 1;
            while (i33 > yVar4 - i27) {
                int i34 = (i33 << i22) * i4;
                IPoint iPoint3 = new IPoint((i6 << i22) * i3, i34);
                int xVar4 = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(iPoint3);
                if (xVar4 >= max7 || xVar4 <= i24 || (yVar2 = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(iPoint3)) >= i26 || yVar2 <= i25) {
                    i9 = i27;
                    i8 = i33;
                    i10 = i34;
                    i7 = i6;
                } else {
                    if (!z5) {
                        z5 = true;
                    }
                    i9 = i27;
                    i10 = i34;
                    i8 = i33;
                    i7 = i6;
                    a aVar4 = new a(i6, i33, i2, i5, iAMapDelegate, abVar, erVar);
                    aVar4.e = iPoint3;
                    arrayList.add(aVar4);
                    z5 = z5;
                }
                IPoint iPoint4 = new IPoint((i28 << i22) * i3, i10);
                int xVar5 = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(iPoint4);
                if (xVar5 < max7 && xVar5 > i24 && (yVar = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(iPoint4)) < i26 && yVar > i25) {
                    if (!z5) {
                        z5 = true;
                    }
                    a aVar5 = new a(i28, i8, i2, i5, iAMapDelegate, abVar, erVar);
                    aVar5.e = iPoint4;
                    arrayList.add(aVar5);
                }
                i33 = i8 - 1;
                i27 = i9;
                i6 = i7;
            }
            if (!z5) {
                return arrayList;
            }
            i27++;
            i26 = i26;
            xVar2 = xVar2;
            i25 = i25;
        }
    }

    private boolean a(a aVar) {
        int i2 = this.i;
        int i3 = this.j;
        IPoint iPoint = aVar.e;
        int xVar = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(iPoint);
        int i4 = 1 << (20 - ((int) ((float) aVar.c)));
        int i5 = i3 * i4;
        int yVar = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(iPoint) + i5;
        MapConfig mapConfig = this.g.getMapConfig();
        double d2 = (double) xVar;
        double d3 = (double) yVar;
        double d4 = (double) (xVar + (i4 * i2));
        double d5 = (double) (yVar - i5);
        float[] fArr = {(float) (d2 - mapConfig.getSX()), (float) (d3 - mapConfig.getSY()), 0.0f, (float) (d4 - mapConfig.getSX()), (float) (d3 - mapConfig.getSY()), 0.0f, (float) (d4 - mapConfig.getSX()), (float) (d5 - mapConfig.getSY()), 0.0f, (float) (d2 - mapConfig.getSX()), (float) (d5 - mapConfig.getSY()), 0.0f};
        FloatBuffer floatBuffer = aVar.h;
        if (floatBuffer == null) {
            aVar.h = eq.a(fArr);
            return true;
        }
        aVar.h = eq.a(fArr, floatBuffer);
        return true;
    }

    /* compiled from: Taobao */
    public static class a implements Cloneable {
        public int a;
        public int b;
        public int c;
        public int d;
        public IPoint e;
        public int f = 0;
        public boolean g = false;
        public FloatBuffer h = null;
        public Bitmap i = null;
        public et.a j = null;
        public int k = 0;
        private IAMapDelegate l;
        private ab m;
        private er n;

        public a(int i2, int i3, int i4, int i5, IAMapDelegate iAMapDelegate, ab abVar, er erVar) {
            this.a = i2;
            this.b = i3;
            this.c = i4;
            this.d = i5;
            this.l = iAMapDelegate;
            this.m = abVar;
            this.n = erVar;
        }

        /* renamed from: a */
        public a clone() {
            try {
                a aVar = (a) super.clone();
                aVar.a = this.a;
                aVar.b = this.b;
                aVar.c = this.c;
                aVar.d = this.d;
                aVar.e = (IPoint) this.e.clone();
                aVar.h = this.h.asReadOnlyBuffer();
                this.k = 0;
            } catch (CloneNotSupportedException e2) {
                e2.printStackTrace();
            }
            return new a(this);
        }

        public void b() {
            try {
                et.a(this);
                if (this.g) {
                    this.m.a(this.f);
                }
                this.g = false;
                this.f = 0;
                Bitmap bitmap = this.i;
                if (bitmap != null && !bitmap.isRecycled()) {
                    eq.b(this.i);
                }
                this.i = null;
                FloatBuffer floatBuffer = this.h;
                if (floatBuffer != null) {
                    floatBuffer.clear();
                }
                this.h = null;
                this.j = null;
                this.k = 0;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (this.a == aVar.a && this.b == aVar.b && this.c == aVar.c && this.d == aVar.d) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.a * 7) + (this.b * 11) + (this.c * 13) + this.d;
        }

        public String toString() {
            return this.a + "-" + this.b + "-" + this.c + "-" + this.d;
        }

        public synchronized void a(Bitmap bitmap) {
            if (bitmap != null) {
                if (!bitmap.isRecycled()) {
                    try {
                        this.j = null;
                        this.i = bitmap;
                        this.l.setRunLowFrame(false);
                    } catch (Throwable th) {
                        hd.c(th, "TileOverlayDelegateImp", "setBitmap");
                        th.printStackTrace();
                        int i2 = this.k;
                        if (i2 < 3) {
                            this.k = i2 + 1;
                            er erVar = this.n;
                            if (erVar != null) {
                                erVar.a(true, this);
                            }
                        }
                    }
                }
            }
            int i3 = this.k;
            if (i3 < 3) {
                this.k = i3 + 1;
                er erVar2 = this.n;
                if (erVar2 != null) {
                    erVar2.a(true, this);
                }
            }
        }

        public a(a aVar) {
            this.a = aVar.a;
            this.b = aVar.b;
            this.c = aVar.c;
            this.d = aVar.d;
            this.e = aVar.e;
            this.h = aVar.h;
            this.k = 0;
            this.m = aVar.m;
            this.l = aVar.l;
            this.n = aVar.n;
        }
    }

    public void a() {
        List<a> list = this.m;
        if (list != null) {
            synchronized (list) {
                this.m.clear();
            }
        }
    }

    private void a(boolean z) {
        b bVar = new b(z, this.g, this.i, this.j, this.k, this.m, this.f, this.b, this.l);
        this.o = bVar;
        bVar.c((Object[]) new Void[0]);
    }

    public void a(String str) {
        b();
        a();
        er erVar = this.l;
        if (erVar != null) {
            erVar.b(true);
            this.l.a(str);
            this.l.b(false);
        }
        a(true);
    }

    private void a(int i2, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        if (floatBuffer != null && floatBuffer2 != null && i2 != 0) {
            de.g gVar = this.a;
            if (gVar == null || gVar.c()) {
                c();
            }
            this.a.a();
            GLES20.glEnable(3042);
            GLES20.glBlendFunc(1, 771);
            GLES20.glBlendColor(1.0f, 1.0f, 1.0f, 1.0f);
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, i2);
            GLES20.glEnableVertexAttribArray(this.a.b);
            GLES20.glVertexAttribPointer(this.a.b, 3, 5126, false, 12, (Buffer) floatBuffer);
            GLES20.glEnableVertexAttribArray(this.a.c);
            GLES20.glVertexAttribPointer(this.a.c, 2, 5126, false, 8, (Buffer) floatBuffer2);
            GLES20.glUniformMatrix4fv(this.a.a, 1, false, this.b.h(), 0);
            GLES20.glDrawArrays(6, 0, 4);
            GLES20.glDisableVertexAttribArray(this.a.b);
            GLES20.glDisableVertexAttribArray(this.a.c);
            GLES20.glBindTexture(3553, 0);
            GLES20.glUseProgram(0);
            GLES20.glDisable(3042);
        }
    }

    /* access modifiers changed from: private */
    public static boolean b(IAMapDelegate iAMapDelegate, List<a> list, int i2, boolean z, List<a> list2, boolean z2, ab abVar, er erVar) {
        int i3;
        boolean z3;
        if (list == null || list2 == null) {
            return false;
        }
        synchronized (list2) {
            Iterator<a> it = list2.iterator();
            while (true) {
                boolean z4 = true;
                if (!it.hasNext()) {
                    break;
                }
                a next = it.next();
                Iterator<a> it2 = list.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        z4 = false;
                        break;
                    }
                    a next2 = it2.next();
                    if (next.equals(next2) && (z3 = next.g)) {
                        next2.g = z3;
                        next2.f = next.f;
                        break;
                    }
                }
                if (!z4) {
                    next.b();
                }
            }
            list2.clear();
            if (i2 <= ((int) iAMapDelegate.getMaxZoomLevel())) {
                if (i2 >= ((int) iAMapDelegate.getMinZoomLevel())) {
                    int size = list.size();
                    if (size <= 0) {
                        return false;
                    }
                    for (int i4 = 0; i4 < size; i4++) {
                        a aVar = list.get(i4);
                        if (aVar != null) {
                            if (z2) {
                                if (abVar.a().getMapConfig().getMapLanguage().equals("zh_cn")) {
                                    if (MapsInitializer.isLoadWorldGridMap()) {
                                        int i5 = aVar.c;
                                        if (i5 >= 6) {
                                            if (ej.a(aVar.a, aVar.b, i5)) {
                                            }
                                        }
                                    }
                                } else if (!MapsInitializer.isLoadWorldGridMap() && (i3 = aVar.c) >= 6 && !ej.a(aVar.a, aVar.b, i3)) {
                                }
                            }
                            list2.add(aVar);
                            if (!aVar.g && erVar != null) {
                                erVar.a(z, aVar);
                            }
                        }
                    }
                    return true;
                }
            }
            return false;
        }
    }

    private void b() {
        b bVar = this.o;
        if (bVar != null && bVar.a() == dq.e.RUNNING) {
            this.o.a(true);
        }
    }
}
