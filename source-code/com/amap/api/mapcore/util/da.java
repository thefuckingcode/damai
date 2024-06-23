package com.amap.api.mapcore.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.amap.api.maps.model.BasePointOverlay;
import com.amap.api.maps.model.GL3DModel;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.animation.Animation;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.animation.GLAnimation;
import com.autonavi.amap.mapcore.animation.GLTransformation;
import com.autonavi.amap.mapcore.interfaces.IInfoWindowManager;
import com.autonavi.amap.mapcore.interfaces.IMarker;
import com.autonavi.amap.mapcore.interfaces.IOverlay;
import com.autonavi.base.ae.gmap.GLMapState;
import com.autonavi.base.amap.api.mapcore.BaseOverlayImp;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction;
import com.autonavi.base.amap.api.mapcore.overlays.IOverlayDelegate;
import com.autonavi.base.amap.mapcore.FPoint;
import com.autonavi.base.amap.mapcore.MapConfig;
import com.youku.live.livesdk.monitor.performance.AbsPerformance;
import java.nio.Buffer;
import java.nio.FloatBuffer;

/* compiled from: Taobao */
public class da implements IInfoWindowManager, IInfoWindowAction, IOverlayDelegate {
    private boolean A = true;
    private Bitmap B = null;
    private Bitmap C = null;
    private Bitmap D = null;
    private Bitmap E = null;
    private boolean F = false;
    private boolean G = false;
    private GLAnimation H;
    private GLAnimation I;
    private boolean J = false;
    private boolean K = true;
    IAMapDelegate a = null;
    float[] b = new float[12];
    a c;
    float[] d = {1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
    long e = 0;
    ar f;
    private Context g;
    private BaseOverlayImp h;
    private boolean i = false;
    private int j = 0;
    private int k = 0;
    private int l = 0;
    private int m = 0;
    private FPoint n;
    private FloatBuffer o = null;
    private String p;
    private boolean q = true;
    private FloatBuffer r;
    private float s = 0.5f;
    private float t = 1.0f;
    private boolean u;
    private Bitmap v;
    private Bitmap w;
    private Rect x = new Rect();
    private float y = 0.0f;
    private int z;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class a extends dd {
        int a;
        int b;
        int c;

        a(String str) {
            if (a(str)) {
                this.a = c("aMVP");
                this.b = b("aVertex");
                this.c = b("aTextureCoord");
            }
        }
    }

    public da(IAMapDelegate iAMapDelegate, Context context) {
        this.g = context;
        this.a = iAMapDelegate;
        this.p = getId();
    }

    private synchronized void c(Bitmap bitmap) {
        if (bitmap != null) {
            if (!bitmap.isRecycled()) {
                eq.b(bitmap);
            }
        }
    }

    private synchronized void d(Bitmap bitmap) {
        if (bitmap != null) {
            if (!bitmap.isRecycled()) {
                c(this.C);
                this.C = bitmap;
            }
        }
    }

    private synchronized void e(Bitmap bitmap) {
        if (bitmap != null) {
            if (!bitmap.isRecycled()) {
                c(this.D);
                this.D = bitmap;
            }
        }
    }

    private synchronized void f(Bitmap bitmap) {
        if (bitmap != null) {
            if (!bitmap.isRecycled()) {
                c(this.E);
                this.E = bitmap;
            }
        }
    }

    private boolean g(Bitmap bitmap) {
        if (this.B != null && bitmap.hashCode() == this.B.hashCode()) {
            return true;
        }
        if (this.D != null && bitmap.hashCode() == this.D.hashCode()) {
            return true;
        }
        if (this.C != null && bitmap.hashCode() == this.C.hashCode()) {
            return true;
        }
        if (this.E == null || bitmap.hashCode() != this.E.hashCode()) {
            return false;
        }
        return true;
    }

    private synchronized Bitmap h() {
        return this.B;
    }

    private synchronized Bitmap i() {
        return this.D;
    }

    private void j() {
        GLAnimation gLAnimation;
        if (this.K || (gLAnimation = this.I) == null || gLAnimation.hasEnded()) {
            GLAnimation gLAnimation2 = this.H;
            if (gLAnimation2 == null || gLAnimation2.hasEnded()) {
                this.y = 1.0f;
                this.J = false;
                return;
            }
            this.K = false;
            this.J = true;
            this.j = this.l;
            this.k = this.m;
            GLTransformation gLTransformation = new GLTransformation();
            this.H.getTransformation(AnimationUtils.currentAnimationTimeMillis(), gLTransformation);
            if (!Double.isNaN(gLTransformation.scaleX) && !Double.isNaN(gLTransformation.scaleY)) {
                this.y = (float) gLTransformation.scaleX;
                return;
            }
            return;
        }
        this.J = true;
        GLTransformation gLTransformation2 = new GLTransformation();
        this.I.getTransformation(AnimationUtils.currentAnimationTimeMillis(), gLTransformation2);
        if (!Double.isNaN(gLTransformation2.scaleX) && !Double.isNaN(gLTransformation2.scaleY)) {
            this.y = (float) gLTransformation2.scaleX;
        }
    }

    private int k() {
        int[] iArr = {0};
        GLES20.glGenTextures(1, iArr, 0);
        return iArr[0];
    }

    private void l() {
        if (!this.A || this.v == null) {
            b(i());
        } else {
            c(false);
        }
        a(false);
    }

    private void m() {
        if (this.A || this.v == null) {
            b(h());
        } else {
            c(true);
        }
        a(true);
    }

    private synchronized void n() {
        Bitmap bitmap = this.v;
        if (!(bitmap == null || bitmap == null)) {
            eq.b(bitmap);
            this.v = null;
        }
        Bitmap bitmap2 = this.w;
        if (bitmap2 != null && !bitmap2.isRecycled()) {
            eq.b(this.w);
            this.w = null;
        }
        Bitmap bitmap3 = this.B;
        if (bitmap3 != null && !bitmap3.isRecycled()) {
            eq.b(this.B);
            this.B = null;
        }
        Bitmap bitmap4 = this.C;
        if (bitmap4 != null && !bitmap4.isRecycled()) {
            eq.b(this.C);
            this.C = null;
        }
        Bitmap bitmap5 = this.D;
        if (bitmap5 != null && !bitmap5.isRecycled()) {
            eq.b(this.D);
            this.D = null;
        }
        Bitmap bitmap6 = this.E;
        if (bitmap6 != null && !bitmap6.isRecycled()) {
            eq.b(this.E);
            this.E = null;
        }
    }

    private void o() {
    }

    private Rect p() {
        Rect rect = this.x;
        int i2 = rect.left;
        int i3 = rect.top;
        return new Rect(i2, i3, rect.right, r() + i3);
    }

    private Rect q() {
        Rect rect = this.x;
        int i2 = rect.left;
        int i3 = rect.top;
        return new Rect(i2, i3, rect.right, s() + i3);
    }

    private int r() {
        Bitmap bitmap = this.B;
        if (bitmap == null || bitmap.isRecycled()) {
            return 0;
        }
        return this.B.getHeight();
    }

    private int s() {
        Bitmap bitmap = this.D;
        if (bitmap == null || bitmap.isRecycled()) {
            return 0;
        }
        return this.D.getHeight();
    }

    @Override // com.autonavi.base.amap.api.mapcore.overlays.IOverlayDelegate
    public boolean calMapFPoint() throws RemoteException {
        return false;
    }

    @Override // com.autonavi.base.amap.api.mapcore.overlays.IOverlayDelegate
    public boolean checkInBounds() {
        return true;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public void destroy() {
        if (this.i) {
            try {
                remove();
                n();
                FloatBuffer floatBuffer = this.r;
                if (floatBuffer != null) {
                    floatBuffer.clear();
                    this.r = null;
                }
                FloatBuffer floatBuffer2 = this.o;
                if (floatBuffer2 != null) {
                    floatBuffer2.clear();
                    this.o = null;
                }
                this.n = null;
                this.z = 0;
            } catch (Throwable th) {
                hd.c(th, "PopupOverlay", "realDestroy");
                th.printStackTrace();
            }
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.overlays.IOverlayDelegate
    public void draw(MapConfig mapConfig) throws RemoteException {
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public boolean equalsRemote(IOverlay iOverlay) throws RemoteException {
        return equals(iOverlay) || iOverlay.getId().equals(getId());
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public String getId() {
        if (this.p == null) {
            this.p = "PopupOverlay";
        }
        return this.p;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public float getZIndex() {
        return 0.0f;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public int hashCodeRemote() {
        return super.hashCode();
    }

    @Override // com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction
    public synchronized void hideInfoWindow() {
        setVisible(false);
        n();
        this.F = false;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public boolean isAboveMaskLayer() {
        return false;
    }

    @Override // com.autonavi.base.amap.api.mapcore.overlays.IOverlayDelegate
    public boolean isDrawFinish() {
        return false;
    }

    @Override // com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction
    public boolean isInfoWindowShown() {
        return false;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public boolean isVisible() {
        return this.q;
    }

    @Override // com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction
    public boolean onInfoWindowTap(MotionEvent motionEvent) {
        if (!this.q || this.h == null || !this.F || !eq.a(this.x, (int) motionEvent.getX(), (int) motionEvent.getY())) {
            return false;
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0039, code lost:
        if ((r10.h instanceof com.amap.api.mapcore.util.cu) == false) goto L_0x00f9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x003b, code lost:
        monitor-enter(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0040, code lost:
        if (f() == false) goto L_0x0051;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0044, code lost:
        if (r10.v != null) goto L_0x004f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0048, code lost:
        if (r10.B != null) goto L_0x0051;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x004c, code lost:
        if (r10.D == null) goto L_0x004f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x004f, code lost:
        r5 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0051, code lost:
        r5 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0052, code lost:
        if (r5 == false) goto L_0x00f4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0054, code lost:
        r5 = ((com.amap.api.mapcore.util.cu) r10.h).getIMarkerAction();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x005c, code lost:
        if (r5 == null) goto L_0x0069;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0062, code lost:
        if (r5.isInfoWindowEnable() != false) goto L_0x0069;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0064, code lost:
        setVisible(false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0067, code lost:
        monitor-exit(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0068, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0069, code lost:
        setVisible(true);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x006c, code lost:
        if (r5 == null) goto L_0x00e5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0072, code lost:
        if (r5.isInfoWindowAutoOverturn() == false) goto L_0x00e5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0074, code lost:
        r6 = p();
        r7 = q();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0080, code lost:
        if (a() == false) goto L_0x0091;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0082, code lost:
        r7.offset(0, (com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(r2) + com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(r6)) + 2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0091, code lost:
        r6.offset(0, -((com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(r2) + com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(r6)) + 2));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00a0, code lost:
        r6 = r10.a.checkMarkerInRect(r5, r6);
        r5 = r10.a.checkMarkerInRect(r5, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00ac, code lost:
        if (r6 <= 0) goto L_0x00b5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00ae, code lost:
        if (r5 == 0) goto L_0x00b4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00b0, code lost:
        if (r5 <= 0) goto L_0x00b5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00b2, code lost:
        if (r6 >= r5) goto L_0x00b5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00b4, code lost:
        r1 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00b5, code lost:
        if (r1 == false) goto L_0x00d5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00b7, code lost:
        r4 = (((r10.h.getRealInfoWindowOffsetY() + r10.h.getInfoWindowOffsetY()) + 2) + com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(r2)) + com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(r7);
        l();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00d5, code lost:
        m();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00d8, code lost:
        a(r10.h.getGeoPosition());
        c(r3, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00e5, code lost:
        a(r10.h.getGeoPosition());
        c(r3, r4);
        m();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00f4, code lost:
        monitor-exit(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00fd, code lost:
        if (f() == false) goto L_0x010b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0101, code lost:
        if (r10.v != null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0105, code lost:
        if (r10.B != null) goto L_0x010b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0109, code lost:
        if (r10.D == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0111, code lost:
        if (r10.h.isInfoWindowEnable() != false) goto L_0x0117;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0113, code lost:
        setVisible(false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0116, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0117, code lost:
        setVisible(true);
        a(r10.h.getGeoPosition());
        c(r3, r4);
        m();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x000f, code lost:
        setVisible(true);
        r2 = r10.h.getRect();
        r3 = r10.h.getRealInfoWindowOffsetX() + r10.h.getInfoWindowOffsetX();
        r4 = (r10.h.getRealInfoWindowOffsetY() + r10.h.getInfoWindowOffsetY()) + 2;
     */
    @Override // com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction
    public void redrawInfoWindow() {
        try {
            synchronized (this) {
                BaseOverlayImp baseOverlayImp = this.h;
                boolean z2 = false;
                if (baseOverlayImp != null) {
                    if (!baseOverlayImp.checkInBounds()) {
                    }
                }
                setVisible(false);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public void remove() throws RemoteException {
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public void setAboveMaskLayer(boolean z2) {
    }

    @Override // com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction
    public void setInfoWindowAdapterManager(ar arVar) {
        synchronized (this) {
            this.f = arVar;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IInfoWindowManager
    public void setInfoWindowAnimation(Animation animation, Animation.AnimationListener animationListener) {
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IInfoWindowManager
    public void setInfoWindowAppearAnimation(Animation animation) {
        GLAnimation gLAnimation = this.I;
        if (gLAnimation == null || !gLAnimation.equals(animation.glAnimation)) {
            this.H = animation.glAnimation;
            return;
        }
        try {
            this.H = animation.glAnimation.clone();
        } catch (Throwable th) {
            hd.c(th, "PopupOverlay", "setInfoWindowDisappearAnimation");
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IInfoWindowManager
    public void setInfoWindowBackColor(int i2) {
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IInfoWindowManager
    public void setInfoWindowBackEnable(boolean z2) {
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IInfoWindowManager
    public void setInfoWindowBackScale(float f2, float f3) {
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IInfoWindowManager
    public void setInfoWindowDisappearAnimation(Animation animation) {
        GLAnimation gLAnimation = this.H;
        if (gLAnimation == null || !gLAnimation.equals(animation.glAnimation)) {
            this.I = animation.glAnimation;
            return;
        }
        try {
            this.I = animation.glAnimation.clone();
        } catch (Throwable th) {
            hd.c(th, "PopupOverlay", "setInfoWindowDisappearAnimation");
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IInfoWindowManager
    public void setInfoWindowMovingAnimation(Animation animation) {
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public void setVisible(boolean z2) {
        if (!this.q && z2) {
            this.u = true;
        }
        this.q = z2;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public void setZIndex(float f2) {
    }

    @Override // com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction
    public synchronized void showInfoWindow(BaseOverlayImp baseOverlayImp) throws RemoteException {
        if (baseOverlayImp != null) {
            if (baseOverlayImp.isInfoWindowEnable()) {
                BaseOverlayImp baseOverlayImp2 = this.h;
                if (baseOverlayImp2 != null && !baseOverlayImp2.getId().equals(baseOverlayImp.getId())) {
                    hideInfoWindow();
                }
                if (this.f != null) {
                    this.h = baseOverlayImp;
                    baseOverlayImp.setInfoWindowShown(true);
                    setVisible(true);
                    g();
                }
                this.F = true;
            }
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IInfoWindowManager
    public void startAnimation() {
    }

    public int b() {
        try {
            synchronized (this) {
                Bitmap bitmap = this.v;
                if (bitmap == null || bitmap.isRecycled()) {
                    return 0;
                }
                return this.v.getWidth();
            }
        } catch (Throwable unused) {
            return 0;
        }
    }

    public boolean a() {
        return this.A;
    }

    public void a(boolean z2) {
        this.A = z2;
    }

    public int c() {
        try {
            Bitmap bitmap = this.v;
            if (bitmap == null || bitmap.isRecycled()) {
                return 0;
            }
            return this.v.getHeight();
        } catch (Throwable unused) {
            return 0;
        }
    }

    public synchronized void a(Bitmap bitmap) {
        if (bitmap != null) {
            if (!bitmap.isRecycled()) {
                this.B = bitmap;
            }
        }
    }

    public void d() {
        this.c = new a("texture.glsl");
    }

    /* access modifiers changed from: protected */
    public void e() {
        long j2;
        long j3;
        synchronized (this) {
            j2 = 100;
            if (this.f != null) {
                BaseOverlayImp baseOverlayImp = this.h;
                if (baseOverlayImp instanceof cu) {
                    j3 = this.f.c((BasePointOverlay) new Marker((IMarker) baseOverlayImp));
                } else {
                    j3 = this.f.c(new GL3DModel((cr) baseOverlayImp));
                }
                if (j3 <= 0) {
                    j2 = AbsPerformance.LONG_NIL;
                } else if (j3 > 100) {
                    j2 = j3;
                }
            } else {
                j2 = 0;
            }
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j4 = this.e;
        if (currentTimeMillis - j4 > j2) {
            if (j4 != 0) {
                try {
                    showInfoWindow(this.h);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            }
            this.e = currentTimeMillis;
        }
    }

    public boolean f() {
        return this.J;
    }

    /* access modifiers changed from: protected */
    public void g() {
        View b2;
        View b3;
        try {
            BaseOverlayImp baseOverlayImp = this.h;
            if (baseOverlayImp instanceof cu) {
                Marker marker = new Marker((IMarker) baseOverlayImp);
                ar arVar = this.f;
                if (arVar != null) {
                    Bitmap a2 = a(arVar.a((BasePointOverlay) marker));
                    if (a2 == null && (b3 = this.f.b((BasePointOverlay) marker)) != null) {
                        if (b3.getBackground() == null) {
                            b3.setBackground(this.f.g());
                        }
                        a2 = a(b3);
                    }
                    a(a2);
                    d(a(this.f.a(marker)));
                    e(a(this.f.b(marker)));
                    f(a(this.f.c(marker)));
                }
            } else if (this.f != null) {
                GL3DModel gL3DModel = new GL3DModel((cr) baseOverlayImp);
                Bitmap a3 = a(this.f.a(gL3DModel));
                if (a3 == null && (b2 = this.f.b(gL3DModel)) != null) {
                    if (b2.getBackground() == null) {
                        b2.setBackground(this.f.g());
                    }
                    a3 = a(b2);
                }
                a(a3);
            }
        } catch (Throwable th) {
            hd.c(th, "PopupOverlay", "getInfoWindow");
            th.printStackTrace();
        }
    }

    public synchronized void b(Bitmap bitmap) {
        if (bitmap != null) {
            try {
                if (!bitmap.isRecycled()) {
                    Bitmap bitmap2 = this.v;
                    if (bitmap2 == null || bitmap2.hashCode() != bitmap.hashCode()) {
                        Bitmap bitmap3 = this.v;
                        if (bitmap3 != null) {
                            if (this.B == null && this.C == null && this.D == null && this.E == null) {
                                c(this.w);
                                this.w = this.v;
                            } else if (!g(bitmap3)) {
                                c(this.w);
                                this.w = this.v;
                            }
                        }
                        this.G = false;
                        this.v = bitmap;
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    public void c(int i2, int i3) throws RemoteException {
        if (this.J) {
            this.l = i2;
            this.m = i3;
            return;
        }
        this.j = i2;
        this.k = i3;
        this.l = i2;
        this.m = i3;
    }

    public boolean a(int i2, int i3) {
        Bitmap bitmap;
        GLMapState mapProjection = this.a.getMapProjection();
        if (!(this.n == null || mapProjection == null)) {
            IPoint obtain = IPoint.obtain();
            if (this.a.getMapConfig() != null) {
                FPoint obtain2 = FPoint.obtain();
                FPoint fPoint = this.n;
                mapProjection.p20ToScreenPoint((int) ((PointF) fPoint).x, (int) ((PointF) fPoint).y, obtain2);
                ((Point) obtain).x = (int) ((PointF) obtain2).x;
                ((Point) obtain).y = (int) ((PointF) obtain2).y;
                obtain2.recycle();
            }
            int b2 = b();
            int c2 = c();
            int xVar = (int) (((float) (com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(obtain) + this.j)) - (((float) b2) * this.s));
            int yVar = (int) (((float) (com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(obtain) + this.k)) + (((float) c2) * (1.0f - this.t)));
            obtain.recycle();
            if (xVar - b2 > i2 || xVar < (-b2) * 2 || yVar < (-c2) * 2 || yVar - c2 > i3 || (bitmap = this.v) == null) {
                return false;
            }
            int width = bitmap.getWidth();
            int height = this.v.getHeight();
            if (this.r == null) {
                this.r = eq.a(new float[]{0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f});
            }
            int i4 = (int) (((double) (1.0f - this.y)) * 0.5d * ((double) width));
            float[] fArr = this.b;
            int i5 = xVar + i4;
            float f2 = (float) i5;
            fArr[0] = f2;
            Rect rect = this.x;
            rect.left = i5;
            int i6 = i3 - yVar;
            float f3 = (float) i6;
            fArr[1] = f3;
            fArr[2] = 0.0f;
            int i7 = xVar + width;
            float f4 = (float) (i7 - i4);
            fArr[3] = f4;
            fArr[4] = f3;
            rect.top = yVar - height;
            fArr[5] = 0.0f;
            fArr[6] = f4;
            rect.right = i7;
            float f5 = (float) (i6 + height);
            fArr[7] = f5;
            rect.bottom = yVar;
            fArr[8] = 0.0f;
            fArr[9] = f2;
            fArr[10] = f5;
            fArr[11] = 0.0f;
            FloatBuffer floatBuffer = this.o;
            if (floatBuffer == null) {
                this.o = eq.a(fArr);
            } else {
                this.o = eq.a(fArr, floatBuffer);
            }
            return true;
        }
        return false;
    }

    private void c(final boolean z2) {
        GLAnimation gLAnimation = this.I;
        if (gLAnimation != null) {
            this.K = false;
            this.J = true;
            gLAnimation.startNow();
            this.I.setAnimationListener(new Animation.AnimationListener() {
                /* class com.amap.api.mapcore.util.da.AnonymousClass1 */

                @Override // com.amap.api.maps.model.animation.Animation.AnimationListener
                public void onAnimationEnd() {
                    if (da.this.H != null) {
                        da.this.J = true;
                        da.this.H.startNow();
                        da.this.b((da) z2);
                    }
                }

                @Override // com.amap.api.maps.model.animation.Animation.AnimationListener
                public void onAnimationStart() {
                }
            });
            return;
        }
        GLAnimation gLAnimation2 = this.H;
        if (gLAnimation2 != null) {
            this.J = true;
            gLAnimation2.startNow();
            b(z2);
            return;
        }
        b(z2);
    }

    public void b(int i2, int i3) {
        if (this.q && this.n != null && this.v != null) {
            e();
            this.v.isRecycled();
            if (!this.G && !this.v.isRecycled()) {
                try {
                    int i4 = this.z;
                    if (i4 != 0) {
                        GLES20.glDeleteTextures(1, new int[]{i4}, 0);
                    } else {
                        this.z = k();
                    }
                    synchronized (this) {
                        Bitmap bitmap = this.v;
                        if (bitmap != null && !bitmap.isRecycled()) {
                            eq.b(this.z, this.v, false);
                            this.G = true;
                        }
                    }
                } catch (Throwable th) {
                    hd.c(th, "PopupOverlay", "drawMarker");
                    th.printStackTrace();
                    return;
                }
            }
            j();
            if (a(i2, i3)) {
                Matrix.setIdentityM(this.d, 0);
                Matrix.orthoM(this.d, 0, 0.0f, (float) i2, 0.0f, (float) i3, 1.0f, -1.0f);
                a(this.z, this.o, this.r);
                if (this.u) {
                    this.u = false;
                    o();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void b(boolean z2) {
        if (z2) {
            b(h());
        } else {
            b(i());
        }
    }

    private void a(int i2, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        if (floatBuffer != null && floatBuffer2 != null && i2 != 0) {
            if (this.c == null) {
                d();
            }
            this.c.a();
            GLES20.glEnable(3042);
            GLES20.glBlendFunc(1, 771);
            GLES20.glBlendColor(1.0f, 1.0f, 1.0f, 1.0f);
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, i2);
            GLES20.glEnableVertexAttribArray(this.c.b);
            GLES20.glVertexAttribPointer(this.c.b, 3, 5126, false, 12, (Buffer) floatBuffer);
            GLES20.glEnableVertexAttribArray(this.c.c);
            GLES20.glVertexAttribPointer(this.c.c, 2, 5126, false, 8, (Buffer) floatBuffer2);
            GLES20.glUniformMatrix4fv(this.c.a, 1, false, this.d, 0);
            GLES20.glDrawArrays(6, 0, 4);
            GLES20.glDisableVertexAttribArray(this.c.b);
            GLES20.glDisableVertexAttribArray(this.c.c);
            GLES20.glBindTexture(3553, 0);
            GLES20.glUseProgram(0);
            GLES20.glDisable(3042);
        }
    }

    public void a(FPoint fPoint) {
        this.n = fPoint;
    }

    private Bitmap a(View view) {
        if (view == null) {
            return null;
        }
        if ((view instanceof RelativeLayout) && this.g != null) {
            LinearLayout linearLayout = new LinearLayout(this.g);
            linearLayout.setOrientation(1);
            linearLayout.addView(view);
            view = linearLayout;
        }
        view.setDrawingCacheEnabled(true);
        view.setDrawingCacheQuality(0);
        return eq.a(view);
    }
}
