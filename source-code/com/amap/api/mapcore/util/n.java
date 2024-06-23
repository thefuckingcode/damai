package com.amap.api.mapcore.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLDebugHelper;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.TextureView;
import com.amap.api.maps.MapsInitializer;
import com.heytap.mcssdk.constant.MessageConstant$CommandId;
import java.io.Writer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL;
import javax.microedition.khronos.opengles.GL10;

@SuppressLint({"NewApi"})
/* compiled from: Taobao */
public class n extends TextureView implements TextureView.SurfaceTextureListener {
    private static final j a = new j();
    private final WeakReference<n> b = new WeakReference<>(this);
    private i c;
    private GLSurfaceView.Renderer d;
    private boolean e;
    private e f;
    private f g;
    private g h;
    private k i;
    private int j;
    private int k;
    private boolean l;

    /* compiled from: Taobao */
    private abstract class a implements e {
        protected int[] a;

        public a(int[] iArr) {
            this.a = a(iArr);
        }

        private int[] a(int[] iArr) {
            if (n.this.k != 2 && n.this.k != 3) {
                return iArr;
            }
            int length = iArr.length;
            int[] iArr2 = new int[(length + 2)];
            int i = length - 1;
            System.arraycopy(iArr, 0, iArr2, 0, i);
            iArr2[i] = 12352;
            if (n.this.k == 2) {
                iArr2[length] = 4;
            } else {
                iArr2[length] = 64;
            }
            iArr2[length + 1] = 12344;
            return iArr2;
        }

        /* access modifiers changed from: package-private */
        public abstract EGLConfig a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr);

        @Override // com.amap.api.mapcore.util.n.e
        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
            int[] iArr = new int[1];
            if (egl10.eglChooseConfig(eGLDisplay, this.a, null, 0, iArr)) {
                int i = iArr[0];
                if (i > 0) {
                    EGLConfig[] eGLConfigArr = new EGLConfig[i];
                    if (egl10.eglChooseConfig(eGLDisplay, this.a, eGLConfigArr, i, iArr)) {
                        EGLConfig a2 = a(egl10, eGLDisplay, eGLConfigArr);
                        if (a2 != null) {
                            return a2;
                        }
                        throw new IllegalArgumentException("No config chosen");
                    }
                    throw new IllegalArgumentException("eglChooseConfig#2 failed");
                }
                throw new IllegalArgumentException("No configs match configSpec");
            }
            throw new IllegalArgumentException("eglChooseConfig failed");
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public class c implements f {
        private c() {
        }

        @Override // com.amap.api.mapcore.util.n.f
        public EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            int[] iArr = {12440, n.this.k, 12344};
            EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
            if (n.this.k == 0) {
                iArr = null;
            }
            return egl10.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
        }

        @Override // com.amap.api.mapcore.util.n.f
        public void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            if (!egl10.eglDestroyContext(eGLDisplay, eGLContext)) {
                Log.e("DefaultContextFactory", "display:" + eGLDisplay + " context: " + eGLContext);
                h.a("eglDestroyContex", egl10.eglGetError());
            }
        }
    }

    /* compiled from: Taobao */
    public interface e {
        EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay);
    }

    /* compiled from: Taobao */
    public interface f {
        EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig);

        void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext);
    }

    /* compiled from: Taobao */
    public interface g {
        EGLSurface a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj);

        void a(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface);
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class i extends Thread {
        private boolean a;
        private boolean b;
        private boolean c;
        private boolean d;
        private boolean e;
        private boolean f;
        private boolean g;
        private boolean h;
        private boolean i;
        private boolean j;
        private boolean k;
        private int l = 0;
        private int m = 0;
        private int n = 1;
        private boolean o = true;
        private boolean p;
        private ArrayList<Runnable> q = new ArrayList<>();
        private boolean r = true;
        private h s;
        private WeakReference<n> t;

        i(WeakReference<n> weakReference) {
            this.t = weakReference;
        }

        private void l() {
            if (this.i) {
                this.i = false;
                this.s.e();
            }
        }

        private void m() {
            if (this.h) {
                this.s.f();
                this.h = false;
                n.a.c(this);
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:100:?, code lost:
            r16.j = true;
            com.amap.api.mapcore.util.n.a.notifyAll();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:101:0x016f, code lost:
            monitor-exit(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:102:0x0170, code lost:
            r8 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:106:0x0175, code lost:
            r2 = com.amap.api.mapcore.util.n.a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:107:0x0179, code lost:
            monitor-enter(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:110:?, code lost:
            r16.j = true;
            r16.f = true;
            com.amap.api.mapcore.util.n.a.notifyAll();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:111:0x0186, code lost:
            monitor-exit(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:116:0x018c, code lost:
            if (r9 == false) goto L_0x019f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:117:0x018e, code lost:
            r6 = (javax.microedition.khronos.opengles.GL10) r16.s.c();
            com.amap.api.mapcore.util.n.a.a(r6);
            r9 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:118:0x019f, code lost:
            if (r7 == false) goto L_0x01b7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:119:0x01a1, code lost:
            r2 = r16.t.get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:120:0x01a9, code lost:
            if (r2 == null) goto L_0x01b6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:121:0x01ab, code lost:
            r2.d.onSurfaceCreated(r6, r16.s.d);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:122:0x01b6, code lost:
            r7 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:123:0x01b7, code lost:
            if (r10 == false) goto L_0x01cb;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:124:0x01b9, code lost:
            r2 = r16.t.get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:125:0x01c1, code lost:
            if (r2 == null) goto L_0x01ca;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:126:0x01c3, code lost:
            r2.d.onSurfaceChanged(r6, r11, r12);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:127:0x01ca, code lost:
            r10 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:128:0x01cb, code lost:
            r2 = r16.t.get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:129:0x01d3, code lost:
            if (r2 == null) goto L_0x01dc;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:130:0x01d5, code lost:
            r2.d.onDrawFrame(r6);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:131:0x01dc, code lost:
            r2 = r16.s.d();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:132:0x01e4, code lost:
            if (r2 == 12288) goto L_0x0208;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:134:0x01e8, code lost:
            if (r2 == 12302) goto L_0x0205;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:135:0x01ea, code lost:
            com.amap.api.mapcore.util.n.h.a("GLThread", "eglSwapBuffers", r2);
            r2 = com.amap.api.mapcore.util.n.a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:136:0x01f5, code lost:
            monitor-enter(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:139:?, code lost:
            r16.f = true;
            com.amap.api.mapcore.util.n.a.notifyAll();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:140:0x0200, code lost:
            monitor-exit(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:145:0x0205, code lost:
            r3 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:147:0x0209, code lost:
            if (r13 == false) goto L_0x020c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:148:0x020b, code lost:
            r4 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:91:0x014f, code lost:
            if (r14 == null) goto L_0x0156;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:93:0x0156, code lost:
            if (r8 == false) goto L_0x018c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:95:0x015e, code lost:
            if (r16.s.b() == false) goto L_0x0175;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:96:0x0160, code lost:
            r2 = com.amap.api.mapcore.util.n.a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:97:0x0164, code lost:
            monitor-enter(r2);
         */
        private void n() throws InterruptedException {
            boolean z;
            boolean z2;
            this.s = new h(this.t);
            this.h = false;
            this.i = false;
            boolean z3 = false;
            boolean z4 = false;
            boolean z5 = false;
            GL10 gl10 = null;
            boolean z6 = false;
            boolean z7 = false;
            boolean z8 = false;
            boolean z9 = false;
            int i2 = 0;
            int i3 = 0;
            boolean z10 = false;
            while (true) {
                Runnable runnable = null;
                while (true) {
                    try {
                        synchronized (n.a) {
                            while (!this.a) {
                                if (!this.q.isEmpty()) {
                                    runnable = this.q.remove(0);
                                } else {
                                    boolean z11 = this.d;
                                    boolean z12 = this.c;
                                    if (z11 != z12) {
                                        this.d = z12;
                                        n.a.notifyAll();
                                    } else {
                                        z12 = false;
                                    }
                                    if (this.k) {
                                        l();
                                        m();
                                        this.k = false;
                                        z5 = true;
                                    }
                                    if (z3) {
                                        l();
                                        m();
                                        z3 = false;
                                    }
                                    if (z12 && this.i) {
                                        l();
                                    }
                                    if (z12 && this.h) {
                                        n nVar = this.t.get();
                                        if (nVar == null) {
                                            z2 = false;
                                        } else {
                                            z2 = nVar.l;
                                        }
                                        if (!z2 || n.a.a()) {
                                            m();
                                        }
                                    }
                                    if (z12 && n.a.b()) {
                                        this.s.f();
                                    }
                                    if (!this.e && !this.g) {
                                        if (this.i) {
                                            l();
                                        }
                                        this.g = true;
                                        this.f = false;
                                        n.a.notifyAll();
                                    }
                                    if (this.e && this.g) {
                                        this.g = false;
                                        n.a.notifyAll();
                                    }
                                    if (z4) {
                                        this.p = true;
                                        n.a.notifyAll();
                                        z4 = false;
                                        z10 = false;
                                    }
                                    if (o()) {
                                        if (!this.h) {
                                            if (z5) {
                                                z5 = false;
                                            } else if (n.a.b(this)) {
                                                try {
                                                    this.s.a();
                                                    this.h = true;
                                                    n.a.notifyAll();
                                                    z6 = true;
                                                } catch (RuntimeException e2) {
                                                    n.a.c(this);
                                                    throw e2;
                                                }
                                            }
                                        }
                                        if (this.h && !this.i) {
                                            this.i = true;
                                            z7 = true;
                                            z8 = true;
                                            z9 = true;
                                        }
                                        if (this.i) {
                                            if (this.r) {
                                                int i4 = this.l;
                                                int i5 = this.m;
                                                this.r = false;
                                                i2 = i4;
                                                i3 = i5;
                                                z = false;
                                                z7 = true;
                                                z9 = true;
                                                z10 = true;
                                            } else {
                                                z = false;
                                            }
                                            this.o = z;
                                            n.a.notifyAll();
                                        }
                                    }
                                    n.a.wait();
                                }
                            }
                            synchronized (n.a) {
                                l();
                                m();
                            }
                            return;
                        }
                    } catch (Throwable th) {
                        synchronized (n.a) {
                            l();
                            m();
                            throw th;
                        }
                    }
                }
                runnable.run();
            }
        }

        private boolean o() {
            return !this.d && this.e && !this.f && this.l > 0 && this.m > 0 && (this.o || this.n == 1);
        }

        public int b() {
            int i2;
            synchronized (n.a) {
                i2 = this.n;
            }
            return i2;
        }

        public void c() {
            synchronized (n.a) {
                this.o = true;
                n.a.notifyAll();
            }
        }

        public void d() {
            synchronized (n.a) {
                this.e = true;
                this.j = false;
                n.a.notifyAll();
                while (this.g && !this.j && !this.b) {
                    try {
                        n.a.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void e() {
            synchronized (n.a) {
                this.e = false;
                n.a.notifyAll();
                while (!this.g && !this.b) {
                    try {
                        if (MapsInitializer.getTextureViewDestorySync()) {
                            n.a.wait();
                        } else {
                            n.a.wait(2000);
                        }
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void f() {
            synchronized (n.a) {
                this.c = true;
                n.a.notifyAll();
                while (!this.b && !this.d) {
                    try {
                        if (MapsInitializer.getTextureViewDestorySync()) {
                            n.a.wait();
                        } else {
                            n.a.wait(2000);
                        }
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void g() {
            synchronized (n.a) {
                this.c = false;
                this.o = true;
                this.p = false;
                n.a.notifyAll();
                while (!this.b && this.d && !this.p) {
                    try {
                        n.a.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void h() {
            synchronized (n.a) {
                this.a = true;
                n.a.notifyAll();
                while (!this.b) {
                    try {
                        n.a.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void i() {
            this.k = true;
            n.a.notifyAll();
        }

        public int j() {
            int i2;
            synchronized (n.a) {
                i2 = this.l;
            }
            return i2;
        }

        public int k() {
            int i2;
            synchronized (n.a) {
                i2 = this.m;
            }
            return i2;
        }

        public void run() {
            setName("GLThread " + getId());
            try {
                n();
            } catch (InterruptedException unused) {
            } catch (Throwable th) {
                n.a.a(this);
                throw th;
            }
            n.a.a(this);
        }

        public boolean a() {
            return this.h && this.i && o();
        }

        public void a(int i2) {
            if (i2 < 0 || i2 > 1) {
                throw new IllegalArgumentException("renderMode");
            }
            synchronized (n.a) {
                this.n = i2;
                n.a.notifyAll();
            }
        }

        public void a(int i2, int i3) {
            synchronized (n.a) {
                this.l = i2;
                this.m = i3;
                this.r = true;
                this.o = true;
                this.p = false;
                n.a.notifyAll();
                while (!this.b && !this.d && !this.p && a()) {
                    try {
                        n.a.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void a(Runnable runnable) {
            if (runnable != null) {
                synchronized (n.a) {
                    this.q.add(runnable);
                    n.a.notifyAll();
                }
                return;
            }
            throw new IllegalArgumentException("r must not be null");
        }
    }

    /* compiled from: Taobao */
    public interface k {
        GL a(GL gl);
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class l extends Writer {
        private StringBuilder a = new StringBuilder();

        l() {
        }

        private void a() {
            if (this.a.length() > 0) {
                Log.v("GLSurfaceView", this.a.toString());
                StringBuilder sb = this.a;
                sb.delete(0, sb.length());
            }
        }

        @Override // java.io.Closeable, java.io.Writer, java.lang.AutoCloseable
        public void close() {
            a();
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
            a();
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i, int i2) {
            for (int i3 = 0; i3 < i2; i3++) {
                char c = cArr[i + i3];
                if (c == '\n') {
                    a();
                } else {
                    this.a.append(c);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public class m extends b {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public m(boolean z) {
            super(8, 8, 8, 0, z ? 16 : 0, 0);
        }
    }

    public n(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    /* access modifiers changed from: protected */
    @Override // java.lang.Object
    public void finalize() throws Throwable {
        try {
            i iVar = this.c;
            if (iVar != null) {
                iVar.h();
            }
        } finally {
            super.finalize();
        }
    }

    public int getRenderMode() {
        return this.c.b();
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.e && this.d != null) {
            i iVar = this.c;
            int b2 = iVar != null ? iVar.b() : 1;
            i iVar2 = new i(this.b);
            this.c = iVar2;
            if (b2 != 1) {
                iVar2.a(b2);
            }
            this.c.start();
        }
        this.e = false;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        i iVar = this.c;
        if (iVar != null) {
            iVar.h();
        }
        this.e = true;
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        onSurfaceTextureSizeChanged(getSurfaceTexture(), i4 - i2, i5 - i3);
        super.onLayout(z, i2, i3, i4, i5);
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
        this.c.d();
        if (MapsInitializer.getTextureSizeChangedInvoked()) {
            onSurfaceTextureSizeChanged(surfaceTexture, i2, i3);
        } else if (this.c.j() != i2 || this.c.k() != i3) {
            onSurfaceTextureSizeChanged(surfaceTexture, i2, i3);
        }
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.c.e();
        return true;
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
        this.c.a(i2, i3);
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public void queueEvent(Runnable runnable) {
        this.c.a(runnable);
    }

    public void requestRender() {
        this.c.c();
    }

    public void setRenderMode(int i2) {
        this.c.a(i2);
    }

    public void setRenderer(GLSurfaceView.Renderer renderer) {
        e();
        if (this.f == null) {
            this.f = new m(true);
        }
        if (this.g == null) {
            this.g = new c();
        }
        if (this.h == null) {
            this.h = new d();
        }
        this.d = renderer;
        i iVar = new i(this.b);
        this.c = iVar;
        iVar.start();
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class d implements g {
        private d() {
        }

        @Override // com.amap.api.mapcore.util.n.g
        public EGLSurface a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj) {
            try {
                return egl10.eglCreateWindowSurface(eGLDisplay, eGLConfig, obj, null);
            } catch (IllegalArgumentException e) {
                Log.e("GLSurfaceView", "eglCreateWindowSurface", e);
                return null;
            }
        }

        @Override // com.amap.api.mapcore.util.n.g
        public void a(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
            egl10.eglDestroySurface(eGLDisplay, eGLSurface);
        }
    }

    private void a() {
        setSurfaceTextureListener(this);
    }

    private void e() {
        if (this.c != null) {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        }
    }

    public void b() {
        this.c.f();
    }

    public void c() {
        this.c.g();
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class j {
        private static String a = "GLThreadManager";
        private boolean b;
        private int c;
        private boolean d;
        private boolean e;
        private boolean f;
        private i g;

        private j() {
        }

        public synchronized void a(i iVar) {
            iVar.b = true;
            if (this.g == iVar) {
                this.g = null;
            }
            notifyAll();
        }

        public boolean b(i iVar) {
            i iVar2 = this.g;
            if (iVar2 == iVar || iVar2 == null) {
                this.g = iVar;
                notifyAll();
                return true;
            }
            c();
            if (this.e) {
                return true;
            }
            i iVar3 = this.g;
            if (iVar3 == null) {
                return false;
            }
            iVar3.i();
            return false;
        }

        public void c(i iVar) {
            if (this.g == iVar) {
                this.g = null;
            }
            notifyAll();
        }

        private void c() {
            if (!this.b) {
                this.c = 131072;
                this.e = true;
                this.b = true;
            }
        }

        public synchronized boolean a() {
            return this.f;
        }

        public synchronized void a(GL10 gl10) {
            if (!this.d && gl10 != null) {
                c();
                String glGetString = gl10.glGetString(7937);
                boolean z = false;
                if (this.c < 131072) {
                    this.e = !glGetString.startsWith("Q3Dimension MSM7500 ");
                    notifyAll();
                }
                if (!this.e) {
                    z = true;
                }
                this.f = z;
                this.d = true;
            }
        }

        public synchronized boolean b() {
            c();
            return !this.e;
        }
    }

    public void a(f fVar) {
        e();
        this.g = fVar;
    }

    public void a(e eVar) {
        e();
        this.f = eVar;
    }

    /* compiled from: Taobao */
    private class b extends a {
        protected int c;
        protected int d;
        protected int e;
        protected int f;
        protected int g;
        protected int h;
        private int[] j = new int[1];

        public b(int i2, int i3, int i4, int i5, int i6, int i7) {
            super(new int[]{12324, i2, 12323, i3, 12322, i4, 12321, i5, 12325, i6, 12326, i7, 12344});
            this.c = i2;
            this.d = i3;
            this.e = i4;
            this.f = i5;
            this.g = i6;
            this.h = i7;
        }

        @Override // com.amap.api.mapcore.util.n.a
        public EGLConfig a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr) {
            for (EGLConfig eGLConfig : eGLConfigArr) {
                int a = a(egl10, eGLDisplay, eGLConfig, 12325, 0);
                int a2 = a(egl10, eGLDisplay, eGLConfig, 12326, 0);
                if (a >= this.g && a2 >= this.h) {
                    int a3 = a(egl10, eGLDisplay, eGLConfig, 12324, 0);
                    int a4 = a(egl10, eGLDisplay, eGLConfig, 12323, 0);
                    int a5 = a(egl10, eGLDisplay, eGLConfig, 12322, 0);
                    int a6 = a(egl10, eGLDisplay, eGLConfig, 12321, 0);
                    if (a3 == this.c && a4 == this.d && a5 == this.e && a6 == this.f) {
                        return eGLConfig;
                    }
                }
            }
            return null;
        }

        private int a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i2, int i3) {
            return egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i2, this.j) ? this.j[0] : i3;
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class h {
        EGL10 a;
        EGLDisplay b;
        EGLSurface c;
        EGLConfig d;
        EGLContext e;
        private WeakReference<n> f;

        public h(WeakReference<n> weakReference) {
            this.f = weakReference;
        }

        private void g() {
            EGLSurface eGLSurface;
            EGLSurface eGLSurface2 = this.c;
            if (eGLSurface2 != null && eGLSurface2 != (eGLSurface = EGL10.EGL_NO_SURFACE)) {
                this.a.eglMakeCurrent(this.b, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
                n nVar = this.f.get();
                if (nVar != null) {
                    nVar.h.a(this.a, this.b, this.c);
                }
                this.c = null;
            }
        }

        public void a() {
            EGL10 egl10 = (EGL10) EGLContext.getEGL();
            this.a = egl10;
            EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            this.b = eglGetDisplay;
            if (eglGetDisplay != EGL10.EGL_NO_DISPLAY) {
                if (this.a.eglInitialize(eglGetDisplay, new int[2])) {
                    n nVar = this.f.get();
                    if (nVar == null) {
                        this.d = null;
                        this.e = null;
                    } else {
                        this.d = nVar.f.chooseConfig(this.a, this.b);
                        this.e = nVar.g.createContext(this.a, this.b, this.d);
                    }
                    EGLContext eGLContext = this.e;
                    if (eGLContext == null || eGLContext == EGL10.EGL_NO_CONTEXT) {
                        this.e = null;
                        a("createContext");
                    }
                    this.c = null;
                    return;
                }
                throw new RuntimeException("eglInitialize failed");
            }
            throw new RuntimeException("eglGetDisplay failed");
        }

        public boolean b() {
            if (this.a == null) {
                throw new RuntimeException("egl not initialized");
            } else if (this.b == null) {
                throw new RuntimeException("eglDisplay not initialized");
            } else if (this.d != null) {
                g();
                n nVar = this.f.get();
                if (nVar != null) {
                    this.c = nVar.h.a(this.a, this.b, this.d, nVar.getSurfaceTexture());
                } else {
                    this.c = null;
                }
                EGLSurface eGLSurface = this.c;
                if (eGLSurface == null || eGLSurface == EGL10.EGL_NO_SURFACE) {
                    if (this.a.eglGetError() == 12299) {
                        Log.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                    }
                    return false;
                } else if (this.a.eglMakeCurrent(this.b, eGLSurface, eGLSurface, this.e)) {
                    return true;
                } else {
                    a("EGLHelper", "eglMakeCurrent", this.a.eglGetError());
                    return false;
                }
            } else {
                throw new RuntimeException("mEglConfig not initialized");
            }
        }

        /* access modifiers changed from: package-private */
        public GL c() {
            GL gl = this.e.getGL();
            n nVar = this.f.get();
            if (nVar == null) {
                return gl;
            }
            if (nVar.i != null) {
                gl = nVar.i.a(gl);
            }
            if ((nVar.j & 3) == 0) {
                return gl;
            }
            int i = 0;
            l lVar = null;
            if ((nVar.j & 1) != 0) {
                i = 1;
            }
            if ((nVar.j & 2) != 0) {
                lVar = new l();
            }
            return GLDebugHelper.wrap(gl, i, lVar);
        }

        public int d() {
            return !this.a.eglSwapBuffers(this.b, this.c) ? this.a.eglGetError() : MessageConstant$CommandId.COMMAND_BASE;
        }

        public void e() {
            g();
        }

        public void f() {
            if (this.e != null) {
                n nVar = this.f.get();
                if (nVar != null) {
                    nVar.g.destroyContext(this.a, this.b, this.e);
                }
                this.e = null;
            }
            EGLDisplay eGLDisplay = this.b;
            if (eGLDisplay != null) {
                this.a.eglTerminate(eGLDisplay);
                this.b = null;
            }
        }

        private void a(String str) {
            a(str, this.a.eglGetError());
        }

        public static void a(String str, int i) {
            throw new RuntimeException(b(str, i));
        }

        public static void a(String str, String str2, int i) {
            Log.w(str, b(str2, i));
        }

        public static String b(String str, int i) {
            return str + " failed: " + i;
        }
    }
}
