package com.amap.api.mapcore.util;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.os.RemoteException;
import android.util.Log;
import com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point;
import com.amap.api.mapcore.util.de;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.interfaces.IOverlay;
import com.autonavi.base.ae.gmap.GLMapState;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.api.mapcore.overlays.IGroundOverlayDelegate;
import com.autonavi.base.amap.mapcore.MapConfig;
import com.taobao.weex.common.Constants;
import java.nio.Buffer;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
public class cs implements IGroundOverlayDelegate {
    float[] a;
    de.c b;
    private IAMapDelegate c;
    private BitmapDescriptor d;
    private LatLng e;
    private float f;
    private float g;
    private LatLngBounds h;
    private float i;
    private float j;
    private boolean k;
    private float l;
    private float m;
    private float n;
    private float o;
    private String p;
    private FloatBuffer q;
    private FloatBuffer r;
    private int s;
    private boolean t;
    private boolean u;
    private List<x> v;
    private r w;

    public cs(IAMapDelegate iAMapDelegate, r rVar) {
        this(iAMapDelegate);
        this.w = rVar;
    }

    private void a() {
        LatLng latLng = this.e;
        if (latLng != null) {
            double cos = ((double) this.f) / ((Math.cos(latLng.latitude * 0.01745329251994329d) * 6371000.79d) * 0.01745329251994329d);
            double d2 = ((double) this.g) / 111194.94043265979d;
            try {
                LatLng latLng2 = this.e;
                LatLng latLng3 = new LatLng(latLng2.latitude - (((double) (1.0f - this.o)) * d2), latLng2.longitude - (((double) this.n) * cos));
                LatLng latLng4 = this.e;
                this.h = new LatLngBounds(latLng3, new LatLng(latLng4.latitude + (((double) this.o) * d2), latLng4.longitude + (((double) (1.0f - this.n)) * cos)));
            } catch (Throwable th) {
                th.printStackTrace();
            }
            c();
        }
    }

    private synchronized void b() {
        LatLngBounds latLngBounds = this.h;
        if (latLngBounds != null) {
            LatLng latLng = latLngBounds.southwest;
            LatLng latLng2 = latLngBounds.northeast;
            double d2 = latLng.latitude;
            double d3 = d2 + (((double) (1.0f - this.o)) * (latLng2.latitude - d2));
            double d4 = latLng.longitude;
            LatLng latLng3 = new LatLng(d3, d4 + (((double) this.n) * (latLng2.longitude - d4)));
            this.e = latLng3;
            this.f = (float) (Math.cos(latLng3.latitude * 0.01745329251994329d) * 6371000.79d * (latLng2.longitude - latLng.longitude) * 0.01745329251994329d);
            this.g = (float) ((latLng2.latitude - latLng.latitude) * 6371000.79d * 0.01745329251994329d);
            c();
        }
    }

    private synchronized void c() {
        if (this.h != null) {
            this.a = new float[16];
            IPoint obtain = IPoint.obtain();
            IPoint obtain2 = IPoint.obtain();
            IPoint obtain3 = IPoint.obtain();
            IPoint obtain4 = IPoint.obtain();
            LatLng latLng = this.h.southwest;
            GLMapState.lonlat2Geo(latLng.longitude, latLng.latitude, obtain);
            LatLngBounds latLngBounds = this.h;
            GLMapState.lonlat2Geo(latLngBounds.northeast.longitude, latLngBounds.southwest.latitude, obtain2);
            LatLng latLng2 = this.h.northeast;
            GLMapState.lonlat2Geo(latLng2.longitude, latLng2.latitude, obtain3);
            LatLngBounds latLngBounds2 = this.h;
            GLMapState.lonlat2Geo(latLngBounds2.southwest.longitude, latLngBounds2.northeast.latitude, obtain4);
            if (this.i != 0.0f) {
                double xVar = (double) (Point.getx(obtain2) - Point.getx(obtain));
                double yVar = (double) (Point.gety(obtain2) - Point.gety(obtain3));
                DPoint obtain5 = DPoint.obtain();
                obtain5.x = ((double) Point.getx(obtain)) + (((double) this.n) * xVar);
                obtain5.y = ((double) Point.gety(obtain)) - (((double) (1.0f - this.o)) * yVar);
                a(obtain5, 0.0d, 0.0d, xVar, yVar, obtain);
                a(obtain5, xVar, 0.0d, xVar, yVar, obtain2);
                a(obtain5, xVar, yVar, xVar, yVar, obtain3);
                a(obtain5, 0.0d, yVar, xVar, yVar, obtain4);
                obtain5.recycle();
            }
            float[] fArr = this.a;
            int xVar2 = Point.getx(obtain);
            fArr[0] = (float) (xVar2 / 10000);
            int yVar2 = Point.gety(obtain);
            fArr[1] = (float) (yVar2 / 10000);
            fArr[2] = (float) (xVar2 % 10000);
            fArr[3] = (float) (yVar2 % 10000);
            int xVar3 = Point.getx(obtain2);
            fArr[4] = (float) (xVar3 / 10000);
            int yVar3 = Point.gety(obtain2);
            fArr[5] = (float) (yVar3 / 10000);
            fArr[6] = (float) (xVar3 % 10000);
            fArr[7] = (float) (yVar3 % 10000);
            int xVar4 = Point.getx(obtain3);
            fArr[8] = (float) (xVar4 / 10000);
            int yVar4 = Point.gety(obtain3);
            fArr[9] = (float) (yVar4 / 10000);
            fArr[10] = (float) (xVar4 % 10000);
            fArr[11] = (float) (yVar4 % 10000);
            int xVar5 = Point.getx(obtain4);
            fArr[12] = (float) (xVar5 / 10000);
            int yVar5 = Point.gety(obtain4);
            fArr[13] = (float) (yVar5 / 10000);
            fArr[14] = (float) (xVar5 % 10000);
            fArr[15] = (float) (yVar5 % 10000);
            FloatBuffer floatBuffer = this.q;
            if (floatBuffer == null) {
                this.q = eq.a(fArr);
            } else {
                this.q = eq.a(fArr, floatBuffer);
            }
            obtain4.recycle();
            obtain.recycle();
            obtain2.recycle();
            obtain3.recycle();
        }
    }

    private void d() {
        BitmapDescriptor bitmapDescriptor = this.d;
        if (bitmapDescriptor != null || (bitmapDescriptor != null && bitmapDescriptor.getBitmap() != null)) {
            int width = this.d.getWidth();
            int height = this.d.getHeight();
            int height2 = this.d.getBitmap().getHeight();
            float width2 = ((float) width) / ((float) this.d.getBitmap().getWidth());
            float f2 = ((float) height) / ((float) height2);
            this.r = eq.a(new float[]{0.0f, f2, width2, f2, width2, 0.0f, 0.0f, 0.0f});
        }
    }

    private void e() {
        r rVar;
        List<x> list = this.v;
        if (list != null) {
            for (x xVar : list) {
                if (!(xVar == null || (rVar = this.w) == null)) {
                    rVar.a(xVar);
                }
            }
            this.v.clear();
        }
    }

    private int f() {
        int[] iArr = {0};
        GLES20.glGenTextures(1, iArr, 0);
        return iArr[0];
    }

    private void g() {
        IAMapDelegate iAMapDelegate = this.c;
        if (iAMapDelegate != null) {
            this.b = (de.c) iAMapDelegate.getGLShader(2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0015, code lost:
        if (r2.h != null) goto L_0x001b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0017, code lost:
        a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001b, code lost:
        c();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0009, code lost:
        r2.u = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x000d, code lost:
        if (r2.e != null) goto L_0x0013;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x000f, code lost:
        b();
     */
    @Override // com.autonavi.base.amap.api.mapcore.overlays.IOverlayDelegate
    public boolean calMapFPoint() throws RemoteException {
        synchronized (this) {
            if (this.a != null) {
                return false;
            }
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.overlays.IOverlayDelegate
    public boolean checkInBounds() {
        return true;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public void destroy() {
        Bitmap bitmap;
        try {
            remove();
            List<x> list = this.v;
            if (list != null && list.size() > 0) {
                for (int i2 = 0; i2 < this.v.size(); i2++) {
                    x xVar = this.v.get(i2);
                    if (xVar != null) {
                        r rVar = this.w;
                        if (rVar != null) {
                            rVar.a(xVar);
                        }
                        IAMapDelegate iAMapDelegate = this.c;
                        if (iAMapDelegate != null) {
                            iAMapDelegate.removeTextureItem(xVar.p());
                        }
                    }
                }
                this.v.clear();
            }
            BitmapDescriptor bitmapDescriptor = this.d;
            if (!(bitmapDescriptor == null || (bitmap = bitmapDescriptor.getBitmap()) == null)) {
                eq.b(bitmap);
                this.d = null;
            }
            FloatBuffer floatBuffer = this.r;
            if (floatBuffer != null) {
                floatBuffer.clear();
                this.r = null;
            }
            synchronized (this) {
                FloatBuffer floatBuffer2 = this.q;
                if (floatBuffer2 != null) {
                    floatBuffer2.clear();
                    this.q = null;
                }
                this.h = null;
            }
            this.e = null;
        } catch (Throwable th) {
            hd.c(th, "GroundOverlayDelegateImp", Constants.Event.SLOT_LIFECYCLE.DESTORY);
            th.printStackTrace();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x001c, code lost:
        calMapFPoint();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0021, code lost:
        if (r3.t != false) goto L_0x0034;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0027, code lost:
        if (android.os.Build.VERSION.SDK_INT < 12) goto L_0x002a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0029, code lost:
        r0 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x002a, code lost:
        r3.s = a(r0, r3.d);
        r3.t = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0039, code lost:
        if (r3.f != 0.0f) goto L_0x0042;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x003f, code lost:
        if (r3.g != 0.0f) goto L_0x0042;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0041, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0042, code lost:
        monitor-enter(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        a(r3.s, r3.q, r3.r);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x004c, code lost:
        monitor-exit(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x004d, code lost:
        r3.u = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x004f, code lost:
        return;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0019 A[DONT_GENERATE] */
    @Override // com.autonavi.base.amap.api.mapcore.overlays.IOverlayDelegate
    public void draw(MapConfig mapConfig) throws RemoteException {
        boolean z;
        synchronized (this) {
            boolean z2 = false;
            if (this.k && !(this.e == null && this.h == null)) {
                if (this.d != null) {
                    z = false;
                    if (!z) {
                        return;
                    }
                }
            }
            z = true;
            if (!z) {
            }
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public boolean equalsRemote(IOverlay iOverlay) throws RemoteException {
        return equals(iOverlay) || iOverlay.getId().equals(getId());
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IGroundOverlay
    public float getBearing() throws RemoteException {
        return this.i;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IGroundOverlay
    public LatLngBounds getBounds() throws RemoteException {
        return this.h;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IGroundOverlay
    public float getHeight() throws RemoteException {
        return this.g;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public String getId() throws RemoteException {
        if (this.p == null) {
            this.p = this.c.createId("GroundOverlay");
        }
        return this.p;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IGroundOverlay
    public LatLng getPosition() throws RemoteException {
        return this.e;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IGroundOverlay
    public float getTransparency() throws RemoteException {
        return this.l;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IGroundOverlay
    public float getWidth() throws RemoteException {
        return this.f;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public float getZIndex() throws RemoteException {
        return this.j;
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
        return this.u;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public boolean isVisible() throws RemoteException {
        return this.k;
    }

    @Override // com.autonavi.base.amap.api.mapcore.overlays.IGroundOverlayDelegate
    public void reLoadTexture() {
        this.t = false;
        this.s = 0;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public void remove() throws RemoteException {
        this.c.removeGLOverlay(getId());
        this.c.setRunLowFrame(false);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public void setAboveMaskLayer(boolean z) {
    }

    @Override // com.autonavi.base.amap.api.mapcore.overlays.IGroundOverlayDelegate
    public void setAnchor(float f2, float f3) throws RemoteException {
        this.n = f2;
        this.o = f3;
        this.c.setRunLowFrame(false);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IGroundOverlay
    public void setBearing(float f2) throws RemoteException {
        float f3 = ((f2 % 360.0f) + 360.0f) % 360.0f;
        if (((double) Math.abs(this.i - f3)) > 1.0E-7d) {
            this.i = f3;
            c();
        }
        this.c.setRunLowFrame(false);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IGroundOverlay
    public void setDimensions(float f2) throws RemoteException {
        if (f2 <= 0.0f) {
            Log.w("GroundOverlayDelegateImp", "Width must be non-negative");
        }
        if (!this.t || this.f == f2) {
            this.f = f2;
            this.g = f2;
        } else {
            this.f = f2;
            this.g = f2;
            a();
        }
        this.c.setRunLowFrame(false);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IGroundOverlay
    public void setImage(BitmapDescriptor bitmapDescriptor) throws RemoteException {
        if (bitmapDescriptor != null && bitmapDescriptor.getBitmap() != null && !bitmapDescriptor.getBitmap().isRecycled()) {
            this.d = bitmapDescriptor;
            d();
            if (this.t) {
                this.t = false;
            }
            this.c.setRunLowFrame(false);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IGroundOverlay
    public void setPosition(LatLng latLng) throws RemoteException {
        this.e = latLng;
        a();
        this.c.setRunLowFrame(false);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IGroundOverlay
    public void setPositionFromBounds(LatLngBounds latLngBounds) throws RemoteException {
        if (latLngBounds != null) {
            this.h = latLngBounds;
            b();
            this.c.setRunLowFrame(false);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IGroundOverlay
    public void setTransparency(float f2) throws RemoteException {
        this.l = (float) Math.min(1.0d, Math.max(0.0d, (double) f2));
        this.m = 1.0f - f2;
        this.c.setRunLowFrame(false);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public void setVisible(boolean z) throws RemoteException {
        this.k = z;
        this.c.setRunLowFrame(false);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public void setZIndex(float f2) throws RemoteException {
        this.j = f2;
        this.c.changeGLOverlayIndex();
        this.c.setRunLowFrame(false);
    }

    private cs(IAMapDelegate iAMapDelegate) {
        this.k = true;
        this.l = 0.0f;
        this.m = 1.0f;
        this.n = 0.5f;
        this.o = 0.5f;
        this.q = null;
        this.t = false;
        this.u = false;
        this.v = new ArrayList();
        this.a = null;
        this.c = iAMapDelegate;
        try {
            this.p = getId();
        } catch (RemoteException e2) {
            hd.c(e2, "GroundOverlayDelegateImp", "create");
            e2.printStackTrace();
        }
    }

    private void a(DPoint dPoint, double d2, double d3, double d4, double d5, IPoint iPoint) {
        double d6 = d2 - (d4 * ((double) this.n));
        double d7 = (d5 * ((double) (1.0f - this.o))) - d3;
        double d8 = ((double) (-this.i)) * 0.01745329251994329d;
        ((android.graphics.Point) iPoint).x = (int) (dPoint.x + (Math.cos(d8) * d6) + (Math.sin(d8) * d7));
        ((android.graphics.Point) iPoint).y = (int) (dPoint.y + ((d7 * Math.cos(d8)) - (d6 * Math.sin(d8))));
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IGroundOverlay
    public void setDimensions(float f2, float f3) throws RemoteException {
        if (f2 <= 0.0f || f3 <= 0.0f) {
            Log.w("GroundOverlayDelegateImp", "Width and Height must be non-negative");
        }
        if (!this.t || this.f == f2 || this.g == f3) {
            this.f = f2;
            this.g = f3;
        } else {
            this.f = f2;
            this.g = f3;
            a();
        }
        this.c.setRunLowFrame(false);
    }

    private void a(x xVar) {
        if (xVar != null) {
            this.v.add(xVar);
            xVar.m();
        }
    }

    private int a(boolean z, BitmapDescriptor bitmapDescriptor) {
        x xVar;
        e();
        if (z) {
            xVar = this.w.a(bitmapDescriptor);
            if (xVar != null) {
                int k2 = xVar.k();
                a(xVar);
                return k2;
            }
        } else {
            xVar = null;
        }
        int i2 = 0;
        if (xVar == null) {
            xVar = new x(bitmapDescriptor, 0);
        }
        Bitmap bitmap = bitmapDescriptor.getBitmap();
        if (bitmap != null && !bitmap.isRecycled()) {
            i2 = f();
            xVar.a(i2);
            if (z) {
                this.c.addTextureItem(xVar);
            }
            a(xVar);
            eq.b(i2, bitmap, true);
        }
        return i2;
    }

    private void a(int i2, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        if (floatBuffer != null && floatBuffer2 != null) {
            de.c cVar = this.b;
            if (cVar == null || cVar.c()) {
                g();
            }
            this.b.a();
            GLES20.glEnable(3042);
            GLES20.glBlendFunc(1, 771);
            float f2 = this.m;
            GLES20.glBlendColor(f2 * 1.0f, f2 * 1.0f, f2 * 1.0f, f2);
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, i2);
            GLES20.glEnableVertexAttribArray(this.b.b);
            GLES20.glVertexAttribPointer(this.b.b, 4, 5126, false, 16, (Buffer) floatBuffer);
            GLES20.glEnableVertexAttribArray(this.b.c);
            GLES20.glVertexAttribPointer(this.b.c, 2, 5126, false, 8, (Buffer) floatBuffer2);
            GLES20.glUniform4f(this.b.g, (float) (((int) this.c.getMapConfig().getSX()) / 10000), (float) (((int) this.c.getMapConfig().getSY()) / 10000), (float) (((int) this.c.getMapConfig().getSX()) % 10000), (float) (((int) this.c.getMapConfig().getSY()) % 10000));
            int i3 = this.b.h;
            float f3 = this.m;
            GLES20.glUniform4f(i3, f3 * 1.0f, f3 * 1.0f, 1.0f * f3, f3);
            GLES20.glUniformMatrix4fv(this.b.a, 1, false, this.c.getFinalMatrix(), 0);
            GLES20.glDrawArrays(6, 0, 4);
            GLES20.glBindTexture(3553, 0);
            GLES20.glDisableVertexAttribArray(this.b.b);
            GLES20.glDisableVertexAttribArray(this.b.c);
            GLES20.glDisable(3042);
            GLES20.glUseProgram(0);
        }
    }
}
