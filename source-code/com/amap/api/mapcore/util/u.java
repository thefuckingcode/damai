package com.amap.api.mapcore.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.RemoteException;
import android.util.Log;
import android.view.MotionEvent;
import com.amap.api.mapcore.util.de;
import com.amap.api.mapcore.util.ew;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.Text;
import com.amap.api.maps.model.TextOptions;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.interfaces.IMarker;
import com.autonavi.base.amap.api.mapcore.BaseOverlayImp;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.api.mapcore.overlays.IMarkerDelegate;
import com.autonavi.base.amap.api.mapcore.overlays.IOverlayImageDelegate;
import com.autonavi.base.amap.mapcore.MapConfig;
import com.taobao.weex.common.Constants;
import java.io.Serializable;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* compiled from: Taobao */
public final class u {
    IAMapDelegate a;
    float[] b = new float[180000];
    public de.d c;
    int d = 0;
    int e = 0;
    private List<IOverlayImageDelegate> f = new ArrayList(500);
    private List<x> g = new ArrayList();
    private List<IOverlayImageDelegate> h = new ArrayList();
    private a i = new a();
    private boolean j = true;
    private IPoint k;
    private BaseOverlayImp l;
    private IMarkerDelegate m;
    private ew n;
    private ee o;
    private FloatBuffer p;
    private HandlerThread q;
    private Handler r;
    private int[] s = new int[1];
    private Runnable t = new Runnable() {
        /* class com.amap.api.mapcore.util.u.AnonymousClass2 */

        public void run() {
            synchronized (u.this.f) {
                u.this.j();
            }
        }
    };

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class a implements Serializable, Comparator<Object> {
        a() {
        }

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            IOverlayImageDelegate iOverlayImageDelegate = (IOverlayImageDelegate) obj;
            IOverlayImageDelegate iOverlayImageDelegate2 = (IOverlayImageDelegate) obj2;
            if (iOverlayImageDelegate == null || iOverlayImageDelegate2 == null) {
                return 0;
            }
            try {
                return Float.compare(iOverlayImageDelegate.getZIndex(), iOverlayImageDelegate2.getZIndex());
            } catch (Throwable th) {
                hd.c(th, "MapOverlayImageView", "compare");
                th.printStackTrace();
                return 0;
            }
        }
    }

    public u(Context context, IAMapDelegate iAMapDelegate) {
        this.a = iAMapDelegate;
        this.n = new ew(512, 1024);
        this.o = new ee();
        HandlerThread handlerThread = new HandlerThread("AMapZindexSortThread");
        this.q = handlerThread;
        handlerThread.start();
        this.r = new Handler(this.q.getLooper());
    }

    private void d(IOverlayImageDelegate iOverlayImageDelegate) {
        try {
            this.f.add(iOverlayImageDelegate);
            f();
        } catch (Throwable th) {
            hd.c(th, "MapOverlayImageView", "addMarker");
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void j() {
        try {
            Collections.sort(this.f, this.i);
        } catch (Throwable th) {
            hd.c(th, "MapOverlayImageView", "changeOverlayIndex");
        }
    }

    private void k() {
        IAMapDelegate iAMapDelegate;
        if (this.c == null && (iAMapDelegate = this.a) != null) {
            this.c = (de.d) iAMapDelegate.getGLShader(1);
        }
    }

    public IAMapDelegate c() {
        return this.a;
    }

    public List<Marker> e() {
        ArrayList arrayList;
        synchronized (this.f) {
            arrayList = new ArrayList();
            try {
                for (IOverlayImageDelegate iOverlayImageDelegate : this.f) {
                    if ((iOverlayImageDelegate instanceof cu) && iOverlayImageDelegate.checkInBounds()) {
                        arrayList.add(new Marker((IMarker) iOverlayImageDelegate));
                    }
                }
            } catch (Throwable th) {
                hd.c(th, "MapOverlayImageView", "getMapScreenMarkers");
                th.printStackTrace();
            }
        }
        return arrayList;
    }

    public void f() {
        Handler handler = this.r;
        if (handler != null) {
            handler.removeCallbacks(this.t);
            this.r.postDelayed(this.t, 10);
        }
    }

    /* access modifiers changed from: protected */
    public int g() {
        int size;
        synchronized (this.f) {
            size = this.f.size();
        }
        return size;
    }

    public void h() {
        synchronized (this.g) {
            int baseOverlayTextureID = this.a.getBaseOverlayTextureID();
            for (int i2 = 0; i2 < this.g.size(); i2++) {
                x xVar = this.g.get(i2);
                if (xVar != null) {
                    xVar.n();
                    if (xVar.o() <= 0) {
                        if (xVar.k() == baseOverlayTextureID) {
                            this.n.a(xVar.p());
                        } else {
                            this.s[0] = xVar.k();
                            GLES20.glDeleteTextures(1, this.s, 0);
                            xVar.a(0);
                        }
                        IAMapDelegate iAMapDelegate = this.a;
                        if (iAMapDelegate != null) {
                            iAMapDelegate.removeTextureItem(xVar.p());
                        }
                    }
                }
            }
            this.g.clear();
        }
    }

    public void i() {
        try {
            for (IOverlayImageDelegate iOverlayImageDelegate : this.f) {
                if (iOverlayImageDelegate != null) {
                    iOverlayImageDelegate.destroy(false);
                }
            }
            b((String) null);
            HandlerThread handlerThread = this.q;
            if (handlerThread != null) {
                handlerThread.quit();
            }
            this.r = null;
            this.a = null;
        } catch (Throwable th) {
            hd.c(th, "MapOverlayImageView", Constants.Event.SLOT_LIFECYCLE.DESTORY);
            th.printStackTrace();
            Log.d("amapApi", "MapOverlayImageView clear erro" + th.getMessage());
        }
    }

    public Marker a(MarkerOptions markerOptions) throws RemoteException {
        Marker marker;
        if (markerOptions == null) {
            return null;
        }
        cu cuVar = new cu(markerOptions, this);
        synchronized (this.f) {
            d(cuVar);
            ea.a(this.f.size());
            marker = new Marker(cuVar);
        }
        return marker;
    }

    public void b(IOverlayImageDelegate iOverlayImageDelegate) {
        if (iOverlayImageDelegate != null) {
            try {
                if (iOverlayImageDelegate.isInfoWindowShown()) {
                    this.a.hideInfoWindow();
                    this.l = null;
                    return;
                }
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        }
        BaseOverlayImp baseOverlayImp = this.l;
        if (baseOverlayImp != null && baseOverlayImp.getId().equals(iOverlayImageDelegate.getId())) {
            this.l = null;
        }
    }

    public boolean c(IOverlayImageDelegate iOverlayImageDelegate) {
        boolean contains;
        synchronized (this.f) {
            contains = this.f.contains(iOverlayImageDelegate);
        }
        return contains;
    }

    public BaseOverlayImp d() {
        return this.l;
    }

    public ArrayList<Marker> a(ArrayList<MarkerOptions> arrayList, boolean z) throws RemoteException {
        MarkerOptions markerOptions;
        if (arrayList == null || arrayList.size() == 0) {
            return null;
        }
        ArrayList<Marker> arrayList2 = new ArrayList<>();
        try {
            if (arrayList.size() != 1 || (markerOptions = arrayList.get(0)) == null) {
                final LatLngBounds.Builder builder = LatLngBounds.builder();
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    MarkerOptions markerOptions2 = arrayList.get(i2);
                    if (arrayList.get(i2) != null) {
                        arrayList2.add(a(markerOptions2));
                        if (markerOptions2.getPosition() != null) {
                            builder.include(markerOptions2.getPosition());
                        }
                    }
                }
                if (z && arrayList2.size() > 0) {
                    this.a.getMainHandler().postDelayed(new Runnable() {
                        /* class com.amap.api.mapcore.util.u.AnonymousClass1 */

                        public void run() {
                            try {
                                u.this.a.moveCamera(ah.a(builder.build(), 50));
                            } catch (Throwable unused) {
                            }
                        }
                    }, 50);
                }
            } else {
                arrayList2.add(a(markerOptions));
                if (z && markerOptions.getPosition() != null) {
                    this.a.moveCamera(ah.a(markerOptions.getPosition(), 18.0f));
                }
            }
            return arrayList2;
        } catch (Throwable th) {
            hd.c(th, "AMapDelegateImpGLSurfaceView", "addMarkers");
            th.printStackTrace();
            return arrayList2;
        }
    }

    public float[] b() {
        IAMapDelegate iAMapDelegate = this.a;
        return iAMapDelegate != null ? iAMapDelegate.getFinalMatrix() : new float[16];
    }

    public boolean b(MotionEvent motionEvent) throws RemoteException {
        boolean z;
        Rect rect;
        boolean a2;
        synchronized (this.f) {
            z = false;
            int size = this.f.size() - 1;
            while (true) {
                if (size < 0) {
                    break;
                }
                IOverlayImageDelegate iOverlayImageDelegate = this.f.get(size);
                if ((iOverlayImageDelegate instanceof cu) && iOverlayImageDelegate.isVisible() && ((cu) iOverlayImageDelegate).isClickable() && (a2 = eq.a((rect = iOverlayImageDelegate.getRect()), (int) motionEvent.getX(), (int) motionEvent.getY()))) {
                    this.k = IPoint.obtain(rect.left + (com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(rect) / 2), rect.top);
                    this.l = (cu) iOverlayImageDelegate;
                    z = a2;
                    break;
                }
                size--;
            }
        }
        return z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x001d A[SYNTHETIC] */
    public void b(String str) {
        boolean z;
        int i2 = 0;
        if (str != null) {
            try {
                if (str.trim().length() != 0) {
                    z = false;
                    IMarkerDelegate iMarkerDelegate = null;
                    this.l = null;
                    this.k = null;
                    this.m = null;
                    synchronized (this.f) {
                        this.h.clear();
                        if (z) {
                            this.f.clear();
                        } else {
                            int size = this.f.size();
                            while (true) {
                                if (i2 >= size) {
                                    break;
                                }
                                IOverlayImageDelegate iOverlayImageDelegate = this.f.get(i2);
                                if (str.equals(iOverlayImageDelegate.getId())) {
                                    iMarkerDelegate = iOverlayImageDelegate;
                                    break;
                                }
                                i2++;
                            }
                            this.f.clear();
                            if (iMarkerDelegate != null) {
                                this.f.add(iMarkerDelegate);
                                if (iMarkerDelegate.isOnTap() && (iMarkerDelegate instanceof IMarkerDelegate)) {
                                    this.m = iMarkerDelegate;
                                }
                            }
                        }
                    }
                    return;
                }
            } catch (Throwable th) {
                hd.c(th, "MapOverlayImageView", com.youku.live.livesdk.wkit.component.Constants.TAG_CLEAR_STRING);
                th.printStackTrace();
                return;
            }
        }
        z = true;
        IMarkerDelegate iMarkerDelegate2 = null;
        this.l = null;
        this.k = null;
        this.m = null;
        synchronized (this.f) {
        }
    }

    public Text a(TextOptions textOptions) throws RemoteException {
        Text text;
        if (textOptions == null) {
            return null;
        }
        synchronized (this.f) {
            db dbVar = new db(textOptions, this);
            d(dbVar);
            text = new Text(dbVar);
        }
        return text;
    }

    public boolean a(IOverlayImageDelegate iOverlayImageDelegate) {
        boolean remove;
        synchronized (this.f) {
            try {
                IMarkerDelegate iMarkerDelegate = this.m;
                if (iMarkerDelegate != null && iMarkerDelegate.getId().equals(iOverlayImageDelegate.getId())) {
                    this.m = null;
                }
                b(iOverlayImageDelegate);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            remove = this.f.remove(iOverlayImageDelegate);
        }
        return remove;
    }

    public void a(IMarkerDelegate iMarkerDelegate) {
        try {
            if (this.m != null) {
                if (iMarkerDelegate == null || !iMarkerDelegate.getId().equals(this.m.getId())) {
                    this.m.setOnTap(false);
                } else {
                    return;
                }
            }
            if (this.f.contains(iMarkerDelegate)) {
                if (iMarkerDelegate != null) {
                    iMarkerDelegate.setOnTap(true);
                }
                this.m = iMarkerDelegate;
            }
        } catch (Throwable th) {
            hd.c(th, "MapOverlayImageView", "set2Top");
        }
    }

    public void a() {
        this.m = null;
    }

    public void a(BaseOverlayImp baseOverlayImp) {
        if (this.k == null) {
            this.k = IPoint.obtain();
        }
        Rect rect = baseOverlayImp.getRect();
        this.k = IPoint.obtain(rect.left + (com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(rect) / 2), rect.top);
        this.l = baseOverlayImp;
        try {
            this.a.showInfoWindow(baseOverlayImp);
        } catch (Throwable th) {
            hd.c(th, "MapOverlayImageView", "showInfoWindow");
            th.printStackTrace();
        }
    }

    public void a(boolean z) {
        try {
            IAMapDelegate iAMapDelegate = this.a;
            if (iAMapDelegate != null) {
                float mapPerPixelUnitLength = iAMapDelegate.getMapConfig().getMapPerPixelUnitLength();
                synchronized (this.f) {
                    h();
                    if (this.f.size() != 0) {
                        this.h.clear();
                        int size = this.f.size();
                        for (int i2 = 0; i2 < size; i2++) {
                            IOverlayImageDelegate iOverlayImageDelegate = this.f.get(i2);
                            if (!z) {
                                if (iOverlayImageDelegate.getZIndex() == 2.14748365E9f) {
                                }
                            } else if (iOverlayImageDelegate.getZIndex() != 2.14748365E9f) {
                            }
                            if (iOverlayImageDelegate.isVisible()) {
                                if (!iOverlayImageDelegate.isOnTap()) {
                                    this.j = iOverlayImageDelegate.isAllowLow();
                                    if (iOverlayImageDelegate.checkInBounds() || iOverlayImageDelegate.isInfoWindowShown()) {
                                        try {
                                            this.h.add(iOverlayImageDelegate);
                                        } catch (Throwable th) {
                                            th.printStackTrace();
                                        }
                                    }
                                }
                            }
                        }
                        IMarkerDelegate iMarkerDelegate = this.m;
                        if (iMarkerDelegate != null && iMarkerDelegate.isVisible()) {
                            this.h.add(this.m);
                        }
                        if (this.h.size() > 0) {
                            int size2 = this.h.size();
                            int i3 = 0;
                            int i4 = 0;
                            int i5 = 0;
                            int i6 = 0;
                            for (int i7 = 0; i7 < size2; i7++) {
                                IOverlayImageDelegate iOverlayImageDelegate2 = this.h.get(i7);
                                synchronized (iOverlayImageDelegate2) {
                                    iOverlayImageDelegate2.loadTexture(this.a);
                                    if (i7 == 0) {
                                        i4 = iOverlayImageDelegate2.getTextureId();
                                    } else {
                                        int textureId = iOverlayImageDelegate2.getTextureId();
                                        if (textureId != i4) {
                                            a(i4, i3, i5, i6);
                                            i4 = textureId;
                                            i3 = 0;
                                            i5 = 0;
                                            i6 = 0;
                                        }
                                    }
                                    iOverlayImageDelegate2.drawMarker(this.a, this.b, i6, mapPerPixelUnitLength);
                                    int textureId2 = iOverlayImageDelegate2.getTextureId();
                                    if (textureId2 != i4) {
                                        a(i4, i3, i5, i6);
                                        i5 = i6;
                                        i4 = textureId2;
                                        i3 = 0;
                                        i6 = 0;
                                    }
                                    i6 += 36;
                                    i3++;
                                    if (i3 == 5000) {
                                        a(i4, i3, i5, i6);
                                        i3 = 0;
                                        i5 = 0;
                                        i6 = 0;
                                    }
                                }
                            }
                            if (i3 > 0) {
                                a(i4, i3, i5, i6);
                            }
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    private void a(int i2, int i3, int i4, int i5) {
        if (i3 != 0 && i2 != 0) {
            FloatBuffer c2 = this.o.c(i3 * 36);
            this.p = c2;
            c2.put(this.b, i4, i5);
            this.p.flip();
            a(i3);
            a(i2, i5, i3, this.p, this.a.getMapConfig());
            this.o.a();
        }
    }

    private void a(int i2) {
        if (i2 > 5000) {
            i2 = 5000;
        }
        if (this.d == 0) {
            int[] iArr = new int[2];
            GLES20.glGenBuffers(2, iArr, 0);
            this.d = iArr[0];
            this.e = iArr[1];
            ShortBuffer b2 = this.o.b(30000);
            short[] sArr = new short[30000];
            for (int i3 = 0; i3 < 5000; i3++) {
                int i4 = i3 * 6;
                int i5 = i3 * 4;
                short s2 = (short) (i5 + 0);
                sArr[i4 + 0] = s2;
                sArr[i4 + 1] = (short) (i5 + 1);
                short s3 = (short) (i5 + 2);
                sArr[i4 + 2] = s3;
                sArr[i4 + 3] = s2;
                sArr[i4 + 4] = s3;
                sArr[i4 + 5] = (short) (i5 + 3);
            }
            b2.put(sArr);
            b2.flip();
            GLES20.glBindBuffer(34963, this.e);
            GLES20.glBufferData(34963, 60000, b2, 35044);
        }
        GLES20.glBindBuffer(34962, this.d);
        GLES20.glBufferData(34962, i2 * 36 * 4, this.p, 35044);
    }

    private void a(int i2, int i3, int i4, FloatBuffer floatBuffer, MapConfig mapConfig) {
        if (i2 != 0 && floatBuffer != null && i4 != 0) {
            de.d dVar = this.c;
            if (dVar == null || dVar.c()) {
                k();
            }
            de.d dVar2 = this.c;
            if (dVar2 != null && this.d != 0 && dVar2.c >= 0 && this.e != 0) {
                dVar2.a();
                GLES20.glUniform1f(this.c.h, mapConfig.getSR());
                GLES20.glEnableVertexAttribArray(this.c.b);
                GLES20.glBindBuffer(34962, this.d);
                GLES20.glVertexAttribPointer(this.c.b, 4, 5126, false, 36, 0);
                GLES20.glEnable(3042);
                GLES20.glBlendFunc(1, 771);
                GLES20.glActiveTexture(33984);
                GLES20.glBindTexture(3553, i2);
                GLES20.glEnableVertexAttribArray(this.c.c);
                GLES20.glBindBuffer(34962, this.d);
                GLES20.glVertexAttribPointer(this.c.c, 2, 5126, false, 36, 16);
                GLES20.glEnableVertexAttribArray(this.c.g);
                GLES20.glBindBuffer(34962, this.d);
                GLES20.glVertexAttribPointer(this.c.g, 3, 5126, false, 36, 24);
                GLES20.glUniformMatrix4fv(this.c.a, 1, false, b(), 0);
                GLES20.glBindBuffer(34963, this.e);
                GLES20.glDrawElements(4, i4 * 6, 5123, 0);
                GLES20.glBindBuffer(34962, 0);
                GLES20.glBindBuffer(34963, 0);
                GLES20.glBindTexture(3553, 0);
                GLES20.glDisableVertexAttribArray(this.c.b);
                GLES20.glDisableVertexAttribArray(this.c.c);
                GLES20.glDisable(3042);
                GLES20.glUseProgram(0);
            }
        }
    }

    public synchronized boolean a(Bitmap bitmap, x xVar) {
        ew.c a2 = this.n.a(bitmap.getWidth() + 1, bitmap.getHeight() + 1, xVar.p());
        if (a2 == null) {
            return false;
        }
        xVar.f(((float) a2.a) / ((float) this.n.a()));
        xVar.e(((float) a2.b) / ((float) this.n.b()));
        xVar.g(((float) ((a2.a + a2.c) - 1)) / ((float) this.n.a()));
        xVar.h(((float) ((a2.b + a2.d) - 1)) / ((float) this.n.b()));
        xVar.c((((float) a2.a) + 0.5f) / ((float) this.n.a()));
        xVar.d((((float) a2.b) + 0.5f) / ((float) this.n.b()));
        xVar.a((((float) ((a2.a + a2.c) - 1)) - 0.5f) / ((float) this.n.a()));
        xVar.b((((float) ((a2.b + a2.d) - 1)) - 0.5f) / ((float) this.n.b()));
        xVar.a(true);
        return true;
    }

    public IOverlayImageDelegate a(String str) throws RemoteException {
        synchronized (this.f) {
            int size = this.f.size();
            for (int i2 = 0; i2 < size; i2++) {
                IOverlayImageDelegate iOverlayImageDelegate = this.f.get(i2);
                if (iOverlayImageDelegate != null && iOverlayImageDelegate.getId().equals(str)) {
                    return iOverlayImageDelegate;
                }
            }
            return null;
        }
    }

    public BaseOverlayImp a(MotionEvent motionEvent) {
        synchronized (this.f) {
            for (int size = this.f.size() - 1; size >= 0; size--) {
                IOverlayImageDelegate iOverlayImageDelegate = this.f.get(size);
                if ((iOverlayImageDelegate instanceof cu) && eq.a(iOverlayImageDelegate.getRect(), (int) motionEvent.getX(), (int) motionEvent.getY())) {
                    cu cuVar = (cu) iOverlayImageDelegate;
                    this.l = cuVar;
                    return cuVar;
                }
            }
            return null;
        }
    }

    public void a(x xVar) {
        synchronized (this.g) {
            if (xVar != null) {
                this.g.add(xVar);
            }
        }
    }
}
