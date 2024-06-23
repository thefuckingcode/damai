package com.amap.api.mapcore.util;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.Rect;
import android.opengl.GLES20;
import android.os.Build;
import android.os.RemoteException;
import android.util.Log;
import com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point;
import com.amap.api.maps.AMapUtils;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.PolylineOptions;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.interfaces.IOverlay;
import com.autonavi.base.amap.api.mapcore.overlays.IPolylineDelegate;
import com.autonavi.base.amap.mapcore.AMapNativePolyline;
import com.autonavi.base.amap.mapcore.AMapNativeRenderer;
import com.autonavi.base.amap.mapcore.FPoint;
import com.autonavi.base.amap.mapcore.FPoint3;
import com.autonavi.base.amap.mapcore.FPointBounds;
import com.autonavi.base.amap.mapcore.MapConfig;
import com.autonavi.base.amap.mapcore.Rectangle;
import com.taobao.weex.common.Constants;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* compiled from: Taobao */
public class cz implements IPolylineDelegate {
    private boolean A = true;
    private int B = 0;
    private int C = 0;
    private float D = 1.0f;
    private int E = -16777216;
    private int F = 0;
    private int G = 0;
    private float H = 10.0f;
    private float I = 0.0f;
    private float J = 0.0f;
    private float K;
    private float L;
    private float M;
    private float N;
    private float O = 1.0f;
    private float P = 0.0f;
    private float[] Q;
    private int[] R;
    private int[] S;
    private boolean T = false;
    private FPointBounds U = null;
    private PolylineOptions V;
    private int W = 0;
    private PolylineOptions.LineJoinType X = PolylineOptions.LineJoinType.LineJoinBevel;
    private PolylineOptions.LineCapType Y = PolylineOptions.LineCapType.LineCapRound;
    private de Z;
    Rect a = null;
    private long aa = 0;
    private boolean ab = false;
    private float ac = -1.0f;
    private float ad = -1.0f;
    private float ae = -1.0f;
    private int af = -1;
    private List<IPoint> ag = new ArrayList();
    private boolean ah = false;
    int b = 0;
    ArrayList<FPoint> c = new ArrayList<>();
    long d = 0;
    private r e;
    private String f;
    private List<IPoint> g = new ArrayList();
    private List<FPoint> h = new ArrayList();
    private List<LatLng> i = new ArrayList();
    private List<BitmapDescriptor> j = new ArrayList();
    private List<x> k = new ArrayList();
    private List<Integer> l = new ArrayList();
    private List<Integer> m = new ArrayList();
    private List<Integer> n = new ArrayList();
    private List<Integer> o = new ArrayList();
    private FloatBuffer p;
    private BitmapDescriptor q = null;
    private Object r = new Object();
    private boolean s = true;
    private boolean t = true;
    private boolean u = false;
    private boolean v = false;
    private boolean w = false;
    private boolean x = true;
    private boolean y = false;
    private boolean z = false;

    public cz(r rVar, PolylineOptions polylineOptions) {
        this.e = rVar;
        setOptions(polylineOptions);
        try {
            this.f = getId();
        } catch (RemoteException e2) {
            hd.c(e2, "PolylineDelegateImp", "create");
            e2.printStackTrace();
        }
    }

    private void c(List<FPoint> list) throws RemoteException {
        int i2;
        this.c.clear();
        int size = list.size();
        if (size >= 2) {
            int i3 = 0;
            FPoint fPoint = list.get(0);
            this.c.add(fPoint);
            int i4 = 1;
            while (true) {
                i2 = size - 1;
                if (i4 >= i2) {
                    break;
                }
                FPoint fPoint2 = list.get(i4);
                if (i4 == 1 || a(fPoint, fPoint2)) {
                    this.c.add(fPoint2);
                    fPoint = fPoint2;
                } else {
                    ArrayList<FPoint> arrayList = this.c;
                    arrayList.set(arrayList.size() - 1, fPoint2);
                }
                i4++;
            }
            this.c.add(list.get(i2));
            int size2 = this.c.size() * 3;
            this.b = size2;
            float[] fArr = this.Q;
            if (fArr == null || fArr.length < size2) {
                this.Q = new float[size2];
            }
            int i5 = this.B;
            if (i5 == 5 || i5 == 3 || i5 == 4) {
                int[] iArr = new int[this.c.size()];
                ArrayList arrayList2 = new ArrayList();
                int i6 = 0;
                int i7 = 0;
                for (int i8 = 0; i8 < size2 / 3; i8++) {
                    FPoint3 fPoint3 = (FPoint3) this.c.get(i8);
                    float[] fArr2 = this.Q;
                    int i9 = i8 * 3;
                    fArr2[i9] = ((PointF) fPoint3).x;
                    fArr2[i9 + 1] = ((PointF) fPoint3).y;
                    fArr2[i9 + 2] = 0.0f;
                    int i10 = fPoint3.colorIndex;
                    if (i8 == 0) {
                        arrayList2.add(Integer.valueOf(i10));
                        i6 = i10;
                    } else if (i10 != i6) {
                        if (i10 != -1) {
                            i6 = i10;
                        }
                        arrayList2.add(Integer.valueOf(i6));
                    }
                    iArr[i7] = i8;
                    i7++;
                }
                int[] iArr2 = new int[arrayList2.size()];
                this.R = iArr2;
                System.arraycopy(iArr, 0, iArr2, 0, iArr2.length);
                this.n = arrayList2;
                this.o = arrayList2;
                return;
            }
            Iterator<FPoint> it = this.c.iterator();
            while (it.hasNext()) {
                FPoint next = it.next();
                float[] fArr3 = this.Q;
                int i11 = i3 * 3;
                fArr3[i11] = ((PointF) next).x;
                fArr3[i11 + 1] = ((PointF) next).y;
                fArr3[i11 + 2] = 0.0f;
                i3++;
            }
        }
    }

    private void d(float f2, MapConfig mapConfig) {
        List<FPoint> a2;
        float[] fArr;
        int i2;
        if (!this.w) {
            synchronized (this) {
                try {
                    BitmapDescriptor bitmapDescriptor = this.q;
                    if (bitmapDescriptor != null) {
                        x a3 = a(Build.VERSION.SDK_INT >= 12, bitmapDescriptor, true);
                        if (a3 != null) {
                            i2 = a3.k();
                            this.D = a3.l();
                        } else {
                            i2 = 0;
                        }
                        this.C = i2;
                        this.w = true;
                    }
                } catch (Throwable th) {
                    hd.c(th, "MarkerDelegateImp", "loadtexture");
                    return;
                }
            }
        }
        try {
            if (mapConfig.getChangeRatio() == 1.0d && (fArr = this.Q) != null) {
                int i3 = this.W + 1;
                this.W = i3;
                if (i3 > 2) {
                    AMapNativeRenderer.nativeDrawLineByTextureID(fArr, this.b, f2, this.C, this.D, this.L, this.M, this.N, this.K, 1.0f - this.O, false, false, false, this.e.h(), this.Y.getTypeValue(), this.X.getTypeValue());
                    return;
                }
            }
            this.W = 0;
            FPoint[] clipMapRect = mapConfig.getGeoRectangle().getClipMapRect();
            List<FPoint> list = this.h;
            if (a(clipMapRect)) {
                synchronized (this.r) {
                    a2 = eq.a(clipMapRect, this.h, false);
                }
                list = a2;
            }
            if (list.size() >= 2) {
                c(list);
                AMapNativeRenderer.nativeDrawLineByTextureID(this.Q, this.b, f2, this.C, this.D, this.L, this.M, this.N, this.K, 1.0f - this.O, false, false, false, this.e.h(), this.Y.getTypeValue(), this.X.getTypeValue());
            }
        } catch (Throwable unused) {
        }
    }

    private void e(float f2, MapConfig mapConfig) {
        float[] fArr;
        int i2;
        if (!this.w) {
            synchronized (this) {
                try {
                    BitmapDescriptor bitmapDescriptor = this.q;
                    if (bitmapDescriptor != null) {
                        x a2 = a(Build.VERSION.SDK_INT >= 12, bitmapDescriptor, true);
                        if (a2 != null) {
                            i2 = a2.k();
                            this.D = a2.l();
                        } else {
                            i2 = 0;
                        }
                        this.C = i2;
                        this.w = true;
                    }
                } catch (Throwable th) {
                    hd.c(th, "MarkerDelegateImp", "loadtexture");
                    return;
                }
            }
        }
        try {
            List<FPoint> list = this.h;
            if (this.e.g() != null) {
                if (mapConfig.getChangeRatio() == 1.0d && (fArr = this.Q) != null) {
                    int i3 = this.W + 1;
                    this.W = i3;
                    if (i3 > 2) {
                        AMapNativeRenderer.nativeDrawLineByTextureID(fArr, this.b, f2, this.e.g().getDottedLineTextureID(this.G), this.e.g().getLineTextureRatio(), this.L, this.M, this.N, this.K, 0.0f, true, true, false, this.e.h(), this.Y.getTypeValue(), this.X.getTypeValue());
                        return;
                    }
                }
                this.W = 0;
                FPoint[] clipMapRect = mapConfig.getGeoRectangle().getClipMapRect();
                if (a(clipMapRect)) {
                    synchronized (this.r) {
                        list = eq.a(clipMapRect, this.h, false);
                    }
                }
                if (list.size() >= 2) {
                    c(list);
                    AMapNativeRenderer.nativeDrawLineByTextureID(this.Q, this.b, f2, this.e.g().getDottedLineTextureID(this.G), this.e.g().getLineTextureRatio(), this.L, this.M, this.N, this.K, 0.0f, true, true, false, this.e.h(), this.Y.getTypeValue(), this.X.getTypeValue());
                }
            }
        } catch (Throwable unused) {
        }
    }

    private void f(float f2, MapConfig mapConfig) {
        float[] fArr;
        try {
            List<FPoint> list = this.h;
            if (this.e.g() != null) {
                if (mapConfig.getChangeRatio() == 1.0d && (fArr = this.Q) != null) {
                    int i2 = this.W + 1;
                    this.W = i2;
                    if (i2 > 2) {
                        long j2 = this.aa;
                        if (j2 == 0 || this.Z == null) {
                            AMapNativeRenderer.nativeDrawLineByTextureID(fArr, this.b, f2, this.e.g().getLineTextureID(), this.e.g().getLineTextureRatio(), this.L, this.M, this.N, this.K, 0.0f, false, true, false, this.e.h(), this.Y.getTypeValue(), this.X.getTypeValue());
                            return;
                        } else {
                            AMapNativePolyline.nativeDrawLineByTextureID(j2, fArr, this.b, f2, this.e.g().getLineTextureID(), this.L, this.M, this.N, this.K, 0.0f, false, true, false, this.e.h(), this.Y.getTypeValue(), this.X.getTypeValue());
                            return;
                        }
                    }
                }
                this.W = 0;
                FPoint[] clipMapRect = mapConfig.getGeoRectangle().getClipMapRect();
                if (a(clipMapRect)) {
                    synchronized (this.r) {
                        list = eq.a(clipMapRect, this.h, false);
                    }
                }
                if (list.size() >= 2) {
                    c(list);
                    long j3 = this.aa;
                    if (j3 == 0 || this.Z == null) {
                        AMapNativeRenderer.nativeDrawLineByTextureID(this.Q, this.b, f2, this.e.g().getLineTextureID(), this.e.g().getLineTextureRatio(), this.L, this.M, this.N, this.K, 0.0f, false, true, false, this.e.h(), this.Y.getTypeValue(), this.X.getTypeValue());
                    } else {
                        AMapNativePolyline.nativeDrawLineByTextureID(j3, this.Q, this.b, f2, this.e.g().getLineTextureID(), this.L, this.M, this.N, this.K, 0.0f, false, true, false, this.e.h(), this.Y.getTypeValue(), this.X.getTypeValue());
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    public void a(boolean z2) {
        this.A = z2;
        this.e.g().setRunLowFrame(false);
    }

    public boolean b(List<IPoint> list) {
        synchronized (this.r) {
            FPointBounds.Builder builder = new FPointBounds.Builder();
            this.h.clear();
            this.z = false;
            float[] fArr = new float[(list.size() * 3)];
            this.Q = fArr;
            this.b = fArr.length;
            Iterator<IPoint> it = list.iterator();
            int i2 = 0;
            while (true) {
                boolean z2 = true;
                if (it.hasNext()) {
                    IPoint next = it.next();
                    FPoint3 fPoint3 = new FPoint3();
                    this.e.g().geo2Map(Point.getx(next), Point.gety(next), fPoint3);
                    float[] fArr2 = this.Q;
                    int i3 = i2 * 3;
                    fArr2[i3] = ((PointF) fPoint3).x;
                    fArr2[i3 + 1] = ((PointF) fPoint3).y;
                    fArr2[i3 + 2] = 0.0f;
                    List<Integer> list2 = this.l;
                    if (list2 != null) {
                        synchronized (list2) {
                            List<Integer> list3 = this.l;
                            if (list3 == null || list3.size() <= i2) {
                                z2 = false;
                            } else {
                                int i4 = this.af;
                                if (i4 <= 0) {
                                    fPoint3.setColorIndex(this.l.get(i2).intValue());
                                } else if (i4 + i2 < this.l.size()) {
                                    fPoint3.setColorIndex(this.l.get(this.af + i2).intValue());
                                }
                            }
                        }
                        synchronized (this.m) {
                            if (!z2) {
                                List<Integer> list4 = this.m;
                                if (list4 != null && list4.size() > i2) {
                                    int i5 = this.af;
                                    if (i5 <= 0) {
                                        fPoint3.setColorIndex(this.m.get(i2).intValue());
                                    } else if (i5 + i2 < this.m.size()) {
                                        fPoint3.setColorIndex(this.m.get(this.af + i2).intValue());
                                    }
                                }
                            }
                        }
                    }
                    this.h.add(fPoint3);
                    builder.include(fPoint3);
                    i2++;
                } else {
                    this.U = builder.build();
                    if (!this.A) {
                        this.p = eq.a(this.Q);
                    }
                    this.F = list.size();
                    a();
                }
            }
        }
        return true;
    }

    @Override // com.autonavi.base.amap.api.mapcore.overlays.IOverlayDelegate
    public boolean calMapFPoint() throws RemoteException {
        if (this.ac == -1.0f && this.ad == -1.0f && this.ae == -1.0f) {
            b(this.g);
            return true;
        }
        b(this.ag);
        return true;
    }

    @Override // com.autonavi.base.amap.api.mapcore.overlays.IOverlayDelegate
    public boolean checkInBounds() {
        if (this.ab) {
            return true;
        }
        Rectangle geoRectangle = this.e.g().getMapConfig().getGeoRectangle();
        Rect rect = this.a;
        if (rect == null || geoRectangle == null || geoRectangle.isOverlap(rect)) {
            return true;
        }
        return false;
    }

    @Override // com.autonavi.base.amap.api.mapcore.overlays.IPolylineDelegate
    public boolean contains(LatLng latLng) {
        float[] fArr = this.Q;
        int length = fArr.length;
        System.arraycopy(fArr, 0, new float[length], 0, fArr.length);
        if (length / 3 < 2) {
            return false;
        }
        try {
            ArrayList<FPoint> d2 = d();
            if (d2 != null && d2.size() >= 1) {
                double mapLenWithWin = (double) this.e.g().getMapProjection().getMapLenWithWin(((int) this.H) / 4);
                double mapLenWithWin2 = (double) this.e.g().getMapProjection().getMapLenWithWin(5);
                FPoint a2 = a(latLng);
                FPoint fPoint = null;
                int i2 = 0;
                while (i2 < d2.size() - 1) {
                    if (i2 == 0) {
                        fPoint = d2.get(i2);
                    }
                    i2++;
                    FPoint fPoint2 = d2.get(i2);
                    if ((mapLenWithWin2 + mapLenWithWin) - a(a2, fPoint, fPoint2) >= 0.0d) {
                        d2.clear();
                        return true;
                    }
                    fPoint = fPoint2;
                }
                d2.clear();
            }
        } catch (Exception unused) {
        }
        return false;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public void destroy() {
        try {
            remove();
            List<x> list = this.k;
            if (list != null && list.size() > 0) {
                for (int i2 = 0; i2 < this.k.size(); i2++) {
                    x xVar = this.k.get(i2);
                    if (xVar != null) {
                        this.e.a(xVar);
                        this.e.g().removeTextureItem(xVar.p());
                    }
                }
                this.k.clear();
            }
            if (this.Q != null) {
                this.Q = null;
            }
            FloatBuffer floatBuffer = this.p;
            if (floatBuffer != null) {
                floatBuffer.clear();
                this.p = null;
            }
            List<BitmapDescriptor> list2 = this.j;
            if (list2 != null && list2.size() > 0) {
                for (BitmapDescriptor bitmapDescriptor : this.j) {
                    bitmapDescriptor.recycle();
                }
            }
            synchronized (this) {
                BitmapDescriptor bitmapDescriptor2 = this.q;
                if (bitmapDescriptor2 != null) {
                    bitmapDescriptor2.recycle();
                }
            }
            synchronized (this.m) {
                List<Integer> list3 = this.m;
                if (list3 != null) {
                    list3.clear();
                }
            }
            List<Integer> list4 = this.l;
            if (list4 != null) {
                synchronized (list4) {
                    this.l.clear();
                    this.l = null;
                }
            }
            List<LatLng> list5 = this.i;
            if (list5 != null) {
                list5.clear();
                this.i = null;
            }
            this.V = null;
            long j2 = this.aa;
            if (j2 != 0) {
                AMapNativePolyline.nativeDestroy(j2);
            }
        } catch (Throwable th) {
            hd.c(th, "PolylineDelegateImp", Constants.Event.SLOT_LIFECYCLE.DESTORY);
            th.printStackTrace();
            Log.d("destroy erro", "PolylineDelegateImp destroy");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:100:0x01b9, code lost:
        monitor-exit(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x01c3, code lost:
        if (r16.Q == null) goto L_0x01d6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x01c7, code lost:
        if (r16.F <= 0) goto L_0x01d6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x01c9, code lost:
        a(r16.e.g().getMapConfig());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x01d6, code lost:
        r16.z = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x01d9, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0152, code lost:
        if (r16.x == false) goto L_0x015b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0154, code lost:
        calMapFPoint();
        r16.x = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x015e, code lost:
        if (r16.y == false) goto L_0x01c1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x0160, code lost:
        r2 = r16.r;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0162, code lost:
        monitor-enter(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:?, code lost:
        r3 = r16.h.size();
        r4 = r16.l;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x016b, code lost:
        monitor-enter(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:?, code lost:
        r5 = r16.l.size();
        r11 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x0173, code lost:
        if (r11 >= r3) goto L_0x01b8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x0175, code lost:
        if (r5 <= r11) goto L_0x0193;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x0179, code lost:
        if (r16.af > 0) goto L_0x0193;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x017b, code lost:
        ((com.autonavi.base.amap.mapcore.FPoint3) r16.h.get(r11)).setColorIndex(r16.l.get(r11).intValue());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x0193, code lost:
        r0 = r16.af;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x0197, code lost:
        if (r5 <= (r0 + r11)) goto L_0x01b5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x0199, code lost:
        if (r0 <= 0) goto L_0x01b5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x019b, code lost:
        ((com.autonavi.base.amap.mapcore.FPoint3) r16.h.get(r11)).setColorIndex(r16.l.get(r16.af + r11).intValue());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x01b5, code lost:
        r11 = r11 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x01b8, code lost:
        monitor-exit(r4);
     */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0052  */
    @Override // com.autonavi.base.amap.api.mapcore.overlays.IOverlayDelegate
    public void draw(MapConfig mapConfig) throws RemoteException {
        List<IPoint> list;
        long j2;
        de deVar;
        if (!this.ah) {
            if (this.aa == 0) {
                long nativeCreate = AMapNativePolyline.nativeCreate();
                this.aa = nativeCreate;
                if (!(nativeCreate == 0 || (deVar = this.Z) == null)) {
                    AMapNativePolyline.nativeSetGLShaderManager(nativeCreate, deVar.a());
                }
            }
            synchronized (this.r) {
                if (this.ac == -1.0f && this.ad == -1.0f) {
                    if (this.ae == -1.0f) {
                        list = this.g;
                        if (!(list == null || list.size() == 0)) {
                            if (this.H <= 0.0f) {
                                if (this.e.g() != null) {
                                    int sx = (int) mapConfig.getSX();
                                    int sy = (int) mapConfig.getSY();
                                    int beyond180Mode = mapConfig.getGeoRectangle().getBeyond180Mode();
                                    int size = this.h.size();
                                    int size2 = list.size();
                                    if (size == size2) {
                                        for (int i2 = 0; i2 < size2; i2++) {
                                            IPoint iPoint = list.get(i2);
                                            FPoint fPoint = this.h.get(i2);
                                            ((PointF) fPoint).x = (float) (Point.getx(iPoint) - sx);
                                            ((PointF) fPoint).y = (float) (Point.gety(iPoint) - sy);
                                            if (this.ab && (beyond180Mode < 0 || mapConfig.getSX() < 1.34217728E8d)) {
                                                ((PointF) fPoint).x -= 2.68435456E8f;
                                            }
                                        }
                                    } else {
                                        this.h.clear();
                                        int i3 = 0;
                                        for (int i4 = 0; i4 < size2; i4++) {
                                            IPoint iPoint2 = list.get(i4);
                                            FPoint3 fPoint3 = new FPoint3();
                                            List<Integer> list2 = this.l;
                                            if (list2 != null) {
                                                synchronized (list2) {
                                                    if (this.af <= 0) {
                                                        List<Integer> list3 = this.l;
                                                        if (list3 != null && list3.size() > i3) {
                                                            fPoint3.setColorIndex(this.l.get(i3).intValue());
                                                        }
                                                    } else {
                                                        List<Integer> list4 = this.l;
                                                        if (list4 != null) {
                                                            int size3 = list4.size();
                                                            int i5 = this.af;
                                                            if (size3 > i3 + i5) {
                                                                fPoint3.setColorIndex(this.l.get(i5 + i3).intValue());
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                            ((PointF) fPoint3).x = (float) (Point.getx(iPoint2) - sx);
                                            ((PointF) fPoint3).y = (float) (Point.gety(iPoint2) - sy);
                                            if (this.ab) {
                                                if (beyond180Mode >= 0) {
                                                    j2 = 4728779608739020800L;
                                                    if (mapConfig.getSX() >= 1.34217728E8d) {
                                                    }
                                                } else {
                                                    j2 = 4728779608739020800L;
                                                }
                                                ((PointF) fPoint3).x -= 2.68435456E8f;
                                            } else {
                                                j2 = 4728779608739020800L;
                                            }
                                            this.h.add(fPoint3);
                                            i3++;
                                        }
                                    }
                                } else {
                                    return;
                                }
                            }
                        }
                        return;
                    }
                }
                list = this.ag;
                if (this.H <= 0.0f) {
                }
            }
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public boolean equalsRemote(IOverlay iOverlay) throws RemoteException {
        return equals(iOverlay) || iOverlay.getId().equals(getId());
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IPolyline
    public int getColor() throws RemoteException {
        return this.E;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public String getId() throws RemoteException {
        if (this.f == null) {
            this.f = this.e.a("Polyline");
        }
        return this.f;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IPolyline
    public LatLng getNearestLatLng(LatLng latLng) {
        List<LatLng> list;
        if (!(latLng == null || (list = this.i) == null || list.size() == 0)) {
            float f2 = 0.0f;
            int i2 = 0;
            for (int i3 = 0; i3 < this.i.size(); i3++) {
                try {
                    if (i3 == 0) {
                        f2 = AMapUtils.calculateLineDistance(latLng, this.i.get(i3));
                    } else {
                        float calculateLineDistance = AMapUtils.calculateLineDistance(latLng, this.i.get(i3));
                        if (f2 > calculateLineDistance) {
                            i2 = i3;
                            f2 = calculateLineDistance;
                        }
                    }
                } catch (Throwable th) {
                    hd.c(th, "PolylineDelegateImp", "getNearestLatLng");
                    th.printStackTrace();
                }
            }
            return this.i.get(i2);
        }
        return null;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IPolyline
    public PolylineOptions getOptions() {
        return this.V;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IPolyline
    public List<LatLng> getPoints() throws RemoteException {
        return this.i;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IPolyline
    public float getShownRatio() {
        return this.ac;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IPolyline
    public float getWidth() throws RemoteException {
        return this.H;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public float getZIndex() throws RemoteException {
        return this.I;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public int hashCodeRemote() throws RemoteException {
        return super.hashCode();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public boolean isAboveMaskLayer() {
        return this.T;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IPolyline
    public boolean isDottedLine() {
        return this.v;
    }

    @Override // com.autonavi.base.amap.api.mapcore.overlays.IOverlayDelegate
    public boolean isDrawFinish() {
        return this.z;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IPolyline
    public boolean isGeodesic() {
        return this.u;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public boolean isVisible() throws RemoteException {
        return this.s;
    }

    @Override // com.autonavi.base.amap.api.mapcore.overlays.IPolylineDelegate
    public void reLoadTexture() {
        this.w = false;
        this.C = 0;
        this.D = 1.0f;
        int[] iArr = this.S;
        if (iArr != null) {
            Arrays.fill(iArr, 0);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public void remove() throws RemoteException {
        this.ah = true;
        this.e.removeOverlay(getId());
        setVisible(false);
        this.e.g().setRunLowFrame(false);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public void setAboveMaskLayer(boolean z2) {
        this.T = z2;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IPolyline
    public void setColor(int i2) {
        int i3 = this.B;
        if (i3 == 0 || i3 == 2) {
            this.E = i2;
            this.K = ((float) Color.alpha(i2)) / 255.0f;
            this.L = ((float) Color.red(i2)) / 255.0f;
            this.M = ((float) Color.green(i2)) / 255.0f;
            this.N = ((float) Color.blue(i2)) / 255.0f;
            if (this.t) {
                if (this.v) {
                    this.B = 2;
                } else {
                    this.B = 0;
                }
            }
            this.e.g().setRunLowFrame(false);
        }
        this.V.color(i2);
    }

    @Override // com.autonavi.base.amap.api.mapcore.overlays.IPolylineDelegate
    public void setColorValues(List<Integer> list) {
        if (list != null && list.size() != 0) {
            try {
                synchronized (this.m) {
                    this.m.clear();
                    this.m.addAll(list);
                }
            } catch (Throwable unused) {
            }
            if (list.size() > 1) {
                this.t = false;
                this.o = e(list);
                this.B = 3;
                this.e.g().setRunLowFrame(false);
                return;
            }
            setColor(list.get(0).intValue());
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IPolyline
    public void setCustemTextureIndex(List<Integer> list) {
        if (list != null && list.size() != 0) {
            try {
                synchronized (this.l) {
                    this.l.clear();
                    this.l.addAll(list);
                    this.n = e(list);
                    this.y = true;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IPolyline
    public void setCustomTexture(BitmapDescriptor bitmapDescriptor) {
        long nanoTime = System.nanoTime();
        if (nanoTime - this.d >= ((long) 16)) {
            this.d = nanoTime;
            if (bitmapDescriptor != null) {
                synchronized (this) {
                    if (!bitmapDescriptor.equals(this.q)) {
                        this.t = false;
                        this.w = false;
                        this.B = 1;
                        this.q = bitmapDescriptor;
                        this.e.g().setRunLowFrame(false);
                        PolylineOptions polylineOptions = this.V;
                        if (polylineOptions != null) {
                            polylineOptions.setCustomTexture(bitmapDescriptor);
                        }
                    }
                }
            }
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.overlays.IPolylineDelegate, com.autonavi.amap.mapcore.interfaces.IPolyline
    public void setCustomTextureList(List<BitmapDescriptor> list) {
        d(list);
        setCustemTextureIndex(this.V.getCustomTextureIndex());
        reLoadTexture();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IPolyline
    public void setDottedLine(boolean z2) {
        int i2 = this.B;
        if (i2 == 2 || i2 == 0) {
            this.v = z2;
            if (z2 && this.t) {
                this.B = 2;
            } else if (!z2 && this.t) {
                this.B = 0;
            }
            this.e.g().setRunLowFrame(false);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IPolyline
    public void setGeodesic(boolean z2) throws RemoteException {
        this.u = z2;
        this.e.g().setRunLowFrame(false);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IPolyline
    public void setOptions(PolylineOptions polylineOptions) {
        if (polylineOptions != null) {
            this.V = polylineOptions;
            try {
                setColor(polylineOptions.getColor());
                setGeodesic(polylineOptions.isGeodesic());
                setDottedLine(polylineOptions.isDottedLine());
                a(polylineOptions.getDottedLineType());
                setAboveMaskLayer(polylineOptions.isAboveMaskLayer());
                setVisible(polylineOptions.isVisible());
                setWidth(polylineOptions.getWidth());
                setZIndex(polylineOptions.getZIndex());
                a(polylineOptions.isUseTexture());
                setTransparency(polylineOptions.getTransparency());
                a(polylineOptions.getLineCapType());
                a(polylineOptions.getLineJoinType());
                if (polylineOptions.getColorValues() != null) {
                    setColorValues(polylineOptions.getColorValues());
                    useGradient(polylineOptions.isUseGradient());
                }
                if (polylineOptions.getCustomTexture() != null) {
                    setCustomTexture(polylineOptions.getCustomTexture());
                    reLoadTexture();
                }
                if (polylineOptions.getCustomTextureList() != null) {
                    d(polylineOptions.getCustomTextureList());
                    setCustemTextureIndex(polylineOptions.getCustomTextureIndex());
                    reLoadTexture();
                }
                setPoints(polylineOptions.getPoints());
                setShownRatio(polylineOptions.getShownRatio());
                setShowRange(polylineOptions.getShownRangeBegin(), polylineOptions.getShownRangeEnd());
            } catch (RemoteException e2) {
                hd.c(e2, "PolylineDelegateImp", "setOptions");
                e2.printStackTrace();
            }
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IPolyline
    public void setPoints(List<LatLng> list) throws RemoteException {
        try {
            this.i = list;
            synchronized (this.r) {
                a(list);
            }
            this.x = true;
            this.e.g().setRunLowFrame(false);
            this.V.setPoints(list);
            setShownRatio(this.V.getShownRatio());
            setShowRange(this.V.getShownRangeBegin(), this.V.getShownRangeEnd());
        } catch (Throwable th) {
            hd.c(th, "PolylineDelegateImp", "setPoints");
            this.g.clear();
            th.printStackTrace();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0096  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0158  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0156 A[EDGE_INSN: B:66:0x0156->B:58:0x0156 ?: BREAK  , SYNTHETIC] */
    @Override // com.autonavi.amap.mapcore.interfaces.IPolyline
    public void setShowRange(float f2, float f3) {
        int floor;
        double d2;
        double d3;
        int i2;
        double d4;
        double d5;
        float f4 = f2;
        float f5 = f3;
        this.ad = f4;
        this.ae = f5;
        synchronized (this.r) {
            int size = this.g.size();
            if (size < 2) {
                this.ag.clear();
            } else if (f4 > f5) {
                this.ag.clear();
                Log.d("mapcore", "setShownRange return begin < end");
            } else {
                if (f4 >= 0.0f) {
                    if (!Float.isNaN(f2)) {
                        if (f4 >= ((float) size)) {
                            f4 = (float) (size - 1);
                        }
                        if (f5 >= 0.0f) {
                            f5 = 0.0f;
                        } else if (f5 >= ((float) size) || Float.isNaN(f3)) {
                            f5 = (float) (size - 1);
                        }
                        if (this.u) {
                            int size2 = this.i.size();
                            if (size2 < 2) {
                                Log.d("mapcore", "setShownRatio return m_polylineOptions.m_latLngPoints.size() < MIN_POLYLINE_COUNT");
                                return;
                            }
                            float f6 = (float) (size2 - 1);
                            float f7 = (float) (size - 1);
                            f4 = (f4 / f6) * f7;
                            f5 = (f5 / f6) * f7;
                        }
                        this.ag.clear();
                        floor = (int) Math.floor((double) f4);
                        int floor2 = (int) Math.floor((double) f5);
                        d2 = (double) (f4 - ((float) floor));
                        d3 = (double) (f5 - ((float) floor2));
                        IPoint iPoint = null;
                        IPoint iPoint2 = null;
                        i2 = floor;
                        while (true) {
                            if (i2 < size) {
                                break;
                            }
                            IPoint iPoint3 = this.g.get(i2);
                            if (floor >= i2) {
                                d5 = d2;
                                d4 = d3;
                                iPoint = iPoint3;
                                iPoint2 = iPoint;
                            } else {
                                if (floor >= i2 || floor != i2 - 1) {
                                    d5 = d2;
                                    d4 = d3;
                                    if (floor < i2 && floor2 >= i2) {
                                        this.ag.add(iPoint3);
                                    } else if (floor2 < i2) {
                                        IPoint iPoint4 = new IPoint();
                                        int xVar = Point.getx(iPoint2);
                                        ((android.graphics.Point) iPoint4).x = (int) (((double) xVar) + (((double) (Point.getx(iPoint3) - xVar)) * d4));
                                        int yVar = Point.gety(iPoint2);
                                        ((android.graphics.Point) iPoint4).y = (int) (((double) yVar) + (((double) (Point.gety(iPoint3) - yVar)) * d4));
                                        this.ag.add(iPoint4);
                                        break;
                                    }
                                } else {
                                    IPoint iPoint5 = new IPoint();
                                    int xVar2 = Point.getx(iPoint);
                                    d5 = d2;
                                    d4 = d3;
                                    ((android.graphics.Point) iPoint5).x = (int) (((double) xVar2) + (((double) (Point.getx(iPoint3) - xVar2)) * d5));
                                    int yVar2 = Point.gety(iPoint);
                                    ((android.graphics.Point) iPoint5).y = (int) (((double) yVar2) + (((double) (Point.gety(iPoint3) - yVar2)) * d5));
                                    this.ag.add(iPoint5);
                                    if (floor2 == floor) {
                                        IPoint iPoint6 = new IPoint();
                                        int xVar3 = Point.getx(iPoint);
                                        ((android.graphics.Point) iPoint6).x = (int) (((double) xVar3) + (((double) (Point.getx(iPoint3) - xVar3)) * d4));
                                        int yVar3 = Point.gety(iPoint);
                                        ((android.graphics.Point) iPoint6).y = (int) (((double) yVar3) + (((double) (Point.gety(iPoint3) - yVar3)) * d4));
                                        this.ag.add(iPoint6);
                                        break;
                                    }
                                    this.ag.add(iPoint3);
                                }
                                iPoint2 = iPoint3;
                            }
                            i2++;
                            d2 = d5;
                            d3 = d4;
                        }
                        if (floor >= 0) {
                            this.af = floor;
                        }
                        this.x = true;
                        this.e.g().setRunLowFrame(false);
                        this.V.setShownRange(this.ad, this.ae);
                    }
                }
                f4 = 0.0f;
                if (f5 >= 0.0f) {
                }
                if (this.u) {
                }
                this.ag.clear();
                floor = (int) Math.floor((double) f4);
                int floor22 = (int) Math.floor((double) f5);
                d2 = (double) (f4 - ((float) floor));
                d3 = (double) (f5 - ((float) floor22));
                IPoint iPoint7 = null;
                IPoint iPoint22 = null;
                i2 = floor;
                while (true) {
                    if (i2 < size) {
                    }
                    i2++;
                    d2 = d5;
                    d3 = d4;
                }
                if (floor >= 0) {
                }
                this.x = true;
                this.e.g().setRunLowFrame(false);
                this.V.setShownRange(this.ad, this.ae);
            }
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IPolyline
    public void setShownRatio(float f2) {
        this.ac = f2;
        synchronized (this.r) {
            int size = this.g.size();
            if (size < 2) {
                this.ag.clear();
                return;
            }
            float f3 = this.ac;
            if (f3 < 0.0f) {
                f3 = 0.0f;
            } else if (f3 >= ((float) size)) {
                f3 = (float) (size - 1);
            }
            if (this.u) {
                int size2 = this.i.size();
                if (size2 >= 2) {
                    f3 = (f3 / ((float) (size2 - 1))) * ((float) (size - 1));
                } else {
                    return;
                }
            }
            this.ag.clear();
            int floor = (int) Math.floor((double) f3);
            IPoint iPoint = null;
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    break;
                }
                IPoint iPoint2 = this.g.get(i2);
                if (i2 > floor) {
                    float f4 = f3 - ((float) floor);
                    if (f2 != 0.0f && iPoint != null) {
                        IPoint iPoint3 = new IPoint();
                        int xVar = Point.getx(iPoint);
                        ((android.graphics.Point) iPoint3).x = (int) (((float) xVar) + (((float) (Point.getx(iPoint2) - xVar)) * f4));
                        int yVar = Point.gety(iPoint);
                        ((android.graphics.Point) iPoint3).y = (int) (((float) yVar) + (((float) (Point.gety(iPoint2) - yVar)) * f4));
                        this.ag.add(iPoint3);
                    }
                } else {
                    this.ag.add(iPoint2);
                    i2++;
                    iPoint = iPoint2;
                }
            }
            this.x = true;
            this.e.g().setRunLowFrame(false);
            this.V.setShownRatio(f2);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IPolyline
    public void setTransparency(float f2) {
        this.O = (float) Math.min(1.0d, Math.max(0.0d, (double) f2));
        this.e.g().setRunLowFrame(false);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public void setVisible(boolean z2) throws RemoteException {
        this.s = z2;
        this.e.g().setRunLowFrame(false);
        PolylineOptions polylineOptions = this.V;
        if (polylineOptions != null) {
            polylineOptions.visible(z2);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IPolyline
    public void setWidth(float f2) throws RemoteException {
        this.H = f2;
        this.e.g().setRunLowFrame(false);
        this.V.width(f2);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public void setZIndex(float f2) throws RemoteException {
        this.I = f2;
        this.e.e();
        this.e.g().setRunLowFrame(false);
        PolylineOptions polylineOptions = this.V;
        if (polylineOptions != null) {
            polylineOptions.zIndex(f2);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.overlays.IPolylineDelegate
    public void useGradient(boolean z2) {
        List<Integer> list;
        if (z2 && (list = this.m) != null && list.size() > 1) {
            this.B = 4;
            this.e.g().setRunLowFrame(false);
        }
    }

    public void a(int i2) {
        this.G = i2;
    }

    /* access modifiers changed from: package-private */
    public void a(List<LatLng> list) throws RemoteException {
        boolean z2;
        ArrayList arrayList = new ArrayList();
        LatLngBounds.Builder builder = LatLngBounds.builder();
        if (list != null) {
            LatLng latLng = null;
            z2 = false;
            for (LatLng latLng2 : list) {
                if (!this.u) {
                    IPoint obtain = IPoint.obtain();
                    this.e.g().latlon2Geo(latLng2.latitude, latLng2.longitude, obtain);
                    arrayList.add(obtain);
                    builder.include(latLng2);
                } else if (latLng != null) {
                    if (Math.abs(latLng2.longitude - latLng.longitude) < 0.01d) {
                        IPoint obtain2 = IPoint.obtain();
                        this.e.g().latlon2Geo(latLng.latitude, latLng.longitude, obtain2);
                        arrayList.add(obtain2);
                        builder.include(latLng);
                        IPoint obtain3 = IPoint.obtain();
                        this.e.g().latlon2Geo(latLng2.latitude, latLng2.longitude, obtain3);
                        arrayList.add(obtain3);
                        builder.include(latLng2);
                    } else {
                        a(latLng, latLng2, arrayList, builder);
                    }
                }
                if (latLng2 != null) {
                    if (!z2 && latLng2.longitude < -180.0d) {
                        this.ab = true;
                        z2 = true;
                    }
                    if (!this.ab && latLng2.longitude > 180.0d) {
                        this.ab = true;
                    }
                }
                latLng = latLng2;
            }
        } else {
            z2 = false;
        }
        this.g = arrayList;
        this.F = 0;
        if (this.a == null) {
            this.a = new Rect();
        }
        eq.a(this.a);
        for (IPoint iPoint : this.g) {
            if (z2) {
                ((android.graphics.Point) iPoint).x = Point.getx(iPoint) + 268435456;
            }
            eq.b(this.a, Point.getx(iPoint), Point.gety(iPoint));
        }
        this.a.sort();
        this.e.g().setRunLowFrame(false);
    }

    private ArrayList<FPoint> d() {
        ArrayList<FPoint> arrayList = new ArrayList<>();
        int i2 = 0;
        while (true) {
            float[] fArr = this.Q;
            if (i2 >= fArr.length) {
                return arrayList;
            }
            float f2 = fArr[i2];
            int i3 = i2 + 1;
            arrayList.add(FPoint.obtain(f2, fArr[i3]));
            i2 = i3 + 1 + 1;
        }
    }

    private void c(float f2, MapConfig mapConfig) {
        boolean z2;
        List<FPoint> b2;
        synchronized (this.m) {
            int[] iArr = new int[this.m.size()];
            z2 = false;
            for (int i2 = 0; i2 < this.m.size(); i2++) {
                iArr[i2] = this.m.get(i2).intValue();
            }
        }
        FPoint[] clipMapRect = mapConfig.getGeoRectangle().getClipMapRect();
        try {
            List<FPoint> list = this.h;
            if (a(clipMapRect)) {
                synchronized (this.r) {
                    b2 = eq.b(clipMapRect, this.h, false);
                }
                list = b2;
            }
            if (list.size() >= 2) {
                c(list);
                int size = this.o.size();
                int[] iArr2 = new int[size];
                for (int i3 = 0; i3 < size; i3++) {
                    iArr2[i3] = this.o.get(i3).intValue();
                }
                if (this.R != null) {
                    z2 = true;
                }
                if (true && z2) {
                    float[] fArr = this.Q;
                    int i4 = this.b;
                    int lineTextureID = this.e.g().getLineTextureID();
                    int[] iArr3 = this.R;
                    AMapNativeRenderer.nativeDrawLineByMultiColor(fArr, i4, f2, lineTextureID, iArr2, size, iArr3, iArr3.length, this.e.h(), this.Y.getTypeValue(), this.X.getTypeValue());
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private List<Integer> e(List<Integer> list) {
        int[] iArr = new int[list.size()];
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            int intValue = list.get(i4).intValue();
            if (i4 == 0) {
                arrayList.add(Integer.valueOf(intValue));
            } else if (intValue != i2) {
                arrayList.add(Integer.valueOf(intValue));
            }
            iArr[i3] = i4;
            i3++;
            i2 = intValue;
        }
        int[] iArr2 = new int[arrayList.size()];
        this.R = iArr2;
        System.arraycopy(iArr, 0, iArr2, 0, iArr2.length);
        return arrayList;
    }

    private void b() {
        r rVar;
        List<x> list = this.k;
        if (list != null) {
            for (x xVar : list) {
                if (!(xVar == null || (rVar = this.e) == null)) {
                    rVar.a(xVar);
                }
            }
            this.k.clear();
        }
    }

    private void d(List<BitmapDescriptor> list) {
        if (list != null && list.size() != 0) {
            if (list.size() > 1) {
                this.t = false;
                this.B = 5;
                this.j = list;
                this.e.g().setRunLowFrame(false);
                return;
            }
            setCustomTexture(list.get(0));
        }
    }

    /* access modifiers changed from: package-private */
    public IPoint a(IPoint iPoint, IPoint iPoint2, IPoint iPoint3, double d2, int i2) {
        IPoint obtain = IPoint.obtain();
        double xVar = (double) (Point.getx(iPoint2) - Point.getx(iPoint));
        double yVar = (double) (Point.gety(iPoint2) - Point.gety(iPoint));
        int sqrt = (int) (((((double) i2) * d2) / Math.sqrt(((yVar * yVar) / (xVar * xVar)) + 1.0d)) + ((double) Point.gety(iPoint3)));
        ((android.graphics.Point) obtain).y = sqrt;
        ((android.graphics.Point) obtain).x = (int) (((((double) (Point.gety(iPoint3) - sqrt)) * yVar) / xVar) + ((double) Point.getx(iPoint3)));
        return obtain;
    }

    private void b(float f2, MapConfig mapConfig) {
        boolean z2;
        List<FPoint> b2;
        synchronized (this.m) {
            int[] iArr = new int[this.m.size()];
            z2 = false;
            for (int i2 = 0; i2 < this.m.size(); i2++) {
                iArr[i2] = this.m.get(i2).intValue();
            }
        }
        FPoint[] clipMapRect = mapConfig.getGeoRectangle().getClipMapRect();
        try {
            List<FPoint> list = this.h;
            if (a(clipMapRect)) {
                synchronized (this.r) {
                    b2 = eq.b(clipMapRect, this.h, false);
                }
                list = b2;
            }
            if (list.size() >= 2) {
                c(list);
                int size = this.o.size();
                int[] iArr2 = new int[size];
                for (int i3 = 0; i3 < size; i3++) {
                    iArr2[i3] = this.o.get(i3).intValue();
                }
                int[] iArr3 = this.R;
                if (iArr3 != null) {
                    z2 = true;
                }
                if (true && z2) {
                    AMapNativeRenderer.nativeDrawGradientColorLine(this.Q, this.b, f2, iArr2, size, iArr3, iArr3.length, this.e.g().getLineTextureID(), this.e.h(), this.Y.getTypeValue(), this.X.getTypeValue());
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* access modifiers changed from: package-private */
    public void a(List<IPoint> list, List<IPoint> list2, double d2) {
        if (list.size() == 3) {
            int i2 = 10;
            int i3 = 0;
            int i4 = 0;
            while (i4 <= i2) {
                float f2 = (float) i4;
                float f3 = f2 / 10.0f;
                IPoint obtain = IPoint.obtain();
                double d3 = 1.0d - ((double) f3);
                double d4 = d3 * d3;
                double d5 = ((double) (2.0f * f3)) * d3;
                float f4 = f3 * f3;
                double xVar = (((double) Point.getx(list.get(i3))) * d4) + (((double) Point.getx(list.get(1))) * d5 * d2) + ((double) (((float) Point.getx(list.get(2))) * f4));
                double yVar = (((double) Point.gety(list.get(i3))) * d4) + (((double) Point.gety(list.get(1))) * d5 * d2) + ((double) (((float) Point.gety(list.get(2))) * f4));
                double d6 = d4 + (d5 * d2) + ((double) f4);
                ((android.graphics.Point) obtain).x = (int) (xVar / d6);
                ((android.graphics.Point) obtain).y = (int) (yVar / d6);
                list2.add(obtain);
                i4 = (int) (f2 + 1.0f);
                i2 = 10;
                i3 = 0;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(LatLng latLng, LatLng latLng2, List<IPoint> list, LatLngBounds.Builder builder) {
        double abs = (Math.abs(latLng.longitude - latLng2.longitude) * 3.141592653589793d) / 180.0d;
        LatLng latLng3 = new LatLng((latLng2.latitude + latLng.latitude) / 2.0d, (latLng2.longitude + latLng.longitude) / 2.0d, false);
        builder.include(latLng).include(latLng3).include(latLng2);
        int i2 = latLng3.latitude > 0.0d ? -1 : 1;
        IPoint obtain = IPoint.obtain();
        this.e.g().latlon2Geo(latLng.latitude, latLng.longitude, obtain);
        IPoint obtain2 = IPoint.obtain();
        this.e.g().latlon2Geo(latLng2.latitude, latLng2.longitude, obtain2);
        IPoint obtain3 = IPoint.obtain();
        this.e.g().latlon2Geo(latLng3.latitude, latLng3.longitude, obtain3);
        double d2 = abs * 0.5d;
        double cos = Math.cos(d2);
        IPoint a2 = a(obtain, obtain2, obtain3, Math.hypot((double) (Point.getx(obtain) - Point.getx(obtain2)), (double) (Point.gety(obtain) - Point.gety(obtain2))) * 0.5d * Math.tan(d2), i2);
        ArrayList arrayList = new ArrayList();
        arrayList.add(obtain);
        arrayList.add(a2);
        arrayList.add(obtain2);
        a(arrayList, list, cos);
        obtain.recycle();
        a2.recycle();
        obtain2.recycle();
    }

    private int c() {
        int[] iArr = {0};
        GLES20.glGenTextures(1, iArr, 0);
        return iArr[0];
    }

    private void a() {
        float mapPerPixelUnitLength = this.e.g().getMapConfig().getMapPerPixelUnitLength();
        if (this.F > 5000) {
            float f2 = this.J;
            if (f2 <= ((float) 12)) {
                float f3 = (this.H / 2.0f) + (f2 / 2.0f);
                if (f3 > 200.0f) {
                    f3 = 200.0f;
                }
                this.P = mapPerPixelUnitLength * f3;
                return;
            }
            this.P = mapPerPixelUnitLength * 10.0f;
            return;
        }
        this.P = mapPerPixelUnitLength * 2.0f;
    }

    private boolean a(FPoint fPoint, FPoint fPoint2) {
        if ((!(fPoint instanceof FPoint3) || !(fPoint2 instanceof FPoint3) || ((FPoint3) fPoint).colorIndex == ((FPoint3) fPoint2).colorIndex) && Math.abs(((PointF) fPoint2).x - ((PointF) fPoint).x) < this.P && Math.abs(((PointF) fPoint2).y - ((PointF) fPoint).y) < this.P) {
            return false;
        }
        return true;
    }

    private void a(MapConfig mapConfig) {
        float mapLenWithWin = this.e.g().getMapProjection().getMapLenWithWin((int) this.H);
        int i2 = this.B;
        if (i2 == 0) {
            f(mapLenWithWin, mapConfig);
        } else if (i2 != 1) {
            if (i2 != 2) {
                if (i2 == 3) {
                    c(mapLenWithWin, mapConfig);
                } else if (i2 == 4) {
                    b(mapLenWithWin, mapConfig);
                } else if (i2 == 5) {
                    if (this.A) {
                        a(mapLenWithWin, mapConfig);
                    } else {
                        c(mapLenWithWin, mapConfig);
                    }
                }
            } else if (this.G == -1) {
                f(mapLenWithWin, mapConfig);
            } else {
                e(mapLenWithWin, mapConfig);
            }
        } else if (this.A) {
            d(mapLenWithWin, mapConfig);
        } else {
            f(mapLenWithWin, mapConfig);
        }
    }

    private void a(float f2, MapConfig mapConfig) {
        int size;
        int[] iArr;
        List<FPoint> b2;
        if (!this.ah) {
            boolean z2 = false;
            if (!this.w) {
                try {
                    List<BitmapDescriptor> list = this.j;
                    if (list != null) {
                        this.S = new int[list.size()];
                        boolean z3 = Build.VERSION.SDK_INT >= 12;
                        b();
                        int i2 = 0;
                        int i3 = 0;
                        for (BitmapDescriptor bitmapDescriptor : this.j) {
                            x a2 = a(z3, bitmapDescriptor, false);
                            if (a2 != null) {
                                i3 = a2.k();
                                this.D = a2.l();
                            }
                            this.S[i2] = i3;
                            i2++;
                        }
                        this.w = true;
                    }
                } catch (Throwable th) {
                    hd.c(th, "MarkerDelegateImp", "loadtexture");
                    return;
                }
            }
            FPoint[] clipMapRect = mapConfig.getGeoRectangle().getClipMapRect();
            try {
                List<FPoint> list2 = this.h;
                if (a(clipMapRect)) {
                    synchronized (this.r) {
                        b2 = eq.b(clipMapRect, this.h, false);
                    }
                    list2 = b2;
                }
                if (list2.size() >= 2) {
                    c(list2);
                    synchronized (this.n) {
                        size = this.n.size();
                        iArr = new int[size];
                        for (int i4 = 0; i4 < size; i4++) {
                            int intValue = this.n.get(i4).intValue();
                            if (intValue < 0) {
                                intValue = 0;
                            }
                            iArr[i4] = this.S[intValue];
                        }
                    }
                    int[] iArr2 = this.R;
                    if (iArr2 != null) {
                        z2 = true;
                    }
                    if (true && z2) {
                        AMapNativeRenderer.nativeDrawLineByMultiTextureID(this.Q, this.b, f2, iArr, this.D, size, iArr2, iArr2.length, 1.0f - this.O, this.e.h(), this.Y.getTypeValue(), this.X.getTypeValue());
                    }
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    private void a(x xVar) {
        if (xVar != null) {
            this.k.add(xVar);
            xVar.m();
        }
    }

    private x a(boolean z2, BitmapDescriptor bitmapDescriptor, boolean z3) {
        if (z3) {
            b();
        }
        x xVar = null;
        if (!z2 || (xVar = this.e.a(bitmapDescriptor)) == null || xVar.k() <= 0) {
            if (xVar == null) {
                xVar = new x(bitmapDescriptor, 0);
            }
            Bitmap bitmap = bitmapDescriptor.getBitmap();
            if (bitmap != null && !bitmap.isRecycled()) {
                int c2 = c();
                if (z2) {
                    xVar.a(c2);
                    this.e.g().addTextureItem(xVar);
                }
                a(xVar);
                eq.b(c2, bitmap, true);
            }
            return xVar;
        }
        xVar.k();
        a(xVar);
        return xVar;
    }

    private boolean a(FPoint[] fPointArr) {
        this.J = this.e.g().getZoomLevel();
        a();
        if (this.J <= ((float) (this.g.size() > 10000 ? 7 : 3))) {
            return false;
        }
        try {
            if (this.e.g() != null) {
                if (!eq.a(this.U.northeast, fPointArr) || !eq.a(this.U.southwest, fPointArr)) {
                    return true;
                }
                return false;
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    private double a(FPoint fPoint, FPoint fPoint2, FPoint fPoint3) {
        return a((double) ((PointF) fPoint).x, (double) ((PointF) fPoint).y, (double) ((PointF) fPoint2).x, (double) ((PointF) fPoint2).y, (double) ((PointF) fPoint3).x, (double) ((PointF) fPoint3).y);
    }

    private FPoint a(LatLng latLng) {
        IPoint obtain = IPoint.obtain();
        this.e.g().latlon2Geo(latLng.latitude, latLng.longitude, obtain);
        FPoint obtain2 = FPoint.obtain();
        this.e.g().geo2Map(Point.getx(obtain), Point.gety(obtain), obtain2);
        obtain.recycle();
        return obtain2;
    }

    private double a(double d2, double d3, double d4, double d5, double d6, double d7) {
        double d8 = d6 - d4;
        double d9 = d2 - d4;
        double d10 = d7 - d5;
        double d11 = d3 - d5;
        double d12 = (d8 * d9) + (d10 * d11);
        if (d12 <= 0.0d) {
            return Math.sqrt((d9 * d9) + (d11 * d11));
        }
        double d13 = (d8 * d8) + (d10 * d10);
        if (d12 >= d13) {
            double d14 = d2 - d6;
            double d15 = d3 - d7;
            return Math.sqrt((d14 * d14) + (d15 * d15));
        }
        double d16 = d12 / d13;
        double d17 = d2 - (d4 + (d8 * d16));
        double d18 = (d5 + (d10 * d16)) - d3;
        return Math.sqrt((d17 * d17) + (d18 * d18));
    }

    public void a(PolylineOptions.LineJoinType lineJoinType) {
        this.X = lineJoinType;
    }

    public void a(PolylineOptions.LineCapType lineCapType) {
        this.Y = lineCapType;
    }

    public void a(de deVar) {
        this.Z = deVar;
    }
}
