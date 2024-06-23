package com.youku.opengl.widget;

import android.opengl.GLES20;
import android.os.SystemClock;
import com.alipay.mobile.bqcscanservice.BQCCameraParam;
import com.uc.crashsdk.export.LogType;
import com.youku.media.a;
import com.youku.opengl.a.e;
import com.youku.opengl.filter.b;
import com.youku.opengl.widget.j;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.Locale;
import tb.jl1;

/* compiled from: Taobao */
public class m extends b implements j.a {
    private static final float[] d = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
    private static final float[] e = {0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};
    private long A;
    private FloatBuffer f;
    private final FloatBuffer g;
    private a h;
    private com.youku.media.b i;
    private com.youku.media.b j;
    private int k = -1;
    private final int l = 5;
    private final j m;
    private long n;
    private volatile int o;
    private volatile long p;
    private volatile int q;
    private boolean r;
    private boolean s;
    private g t;
    private d u;
    private boolean v;
    private final b w;
    private float[] x;
    private long y;
    private long z;

    m() {
        super(1);
        j jVar = new j(5);
        this.m = jVar;
        this.n = -1;
        this.v = false;
        this.w = new b();
        float[] fArr = d;
        this.x = fArr;
        this.y = -1;
        this.z = -1;
        this.A = -1;
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(fArr.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.f = asFloatBuffer;
        asFloatBuffer.put(this.x).position(0);
        float[] fArr2 = e;
        FloatBuffer asFloatBuffer2 = ByteBuffer.allocateDirect(fArr2.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.g = asFloatBuffer2;
        asFloatBuffer2.put(fArr2).position(0);
        jVar.a(this);
    }

    private void a(int i2, long j2, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        GLES20.glBindFramebuffer(36160, this.m.c());
        int j3 = j();
        int k2 = k();
        j.b e2 = this.m.e();
        int i3 = e2.a;
        GLES20.glBindTexture(3553, i3);
        GLES20.glTexImage2D(3553, 0, 6408, j(), k(), 0, 6408, 5121, null);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, i3, 0);
        GLES20.glViewport(0, 0, j3, k2);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glClear(LogType.UNEXP_RESTART);
        GLES20.glUseProgram(this.w.l());
        this.w.a(i2, floatBuffer, floatBuffer2);
        e2.b = j2;
        if (com.youku.opengl.a.a.b) {
            com.youku.opengl.a.a.a("YkGLVideoSyncFilter", "getNearestFrame cacheTexture() - onAddVideoFrame " + j2);
        }
        this.m.a(e2);
        GLES20.glBindTexture(3553, 0);
        GLES20.glBindFramebuffer(36160, 0);
    }

    private void a(long j2, long j3) {
        long currentTimeMillis = System.currentTimeMillis();
        long j4 = this.y;
        if (j4 >= 0) {
            com.youku.opengl.a.a.a("YkGLVideoSyncFilter", String.format(Locale.getDefault(), "getNearestFrame System:[%d] Master:[%d] Sync:[%d]", Long.valueOf(currentTimeMillis - j4), Long.valueOf(j2 - this.A), Long.valueOf(j3 - this.z)));
        }
        this.y = currentTimeMillis;
        this.A = j2;
        this.z = j3;
    }

    private boolean b(long j2) {
        if (this.h == null) {
            return true;
        }
        if (j2 < 0) {
            j2 = 0;
        }
        j.b f2 = this.m.f();
        if (f2 == null || j2 - f2.b <= 120 || this.m.d() > 0) {
            return false;
        }
        this.h.a();
        this.v = true;
        return false;
    }

    private void m() {
        this.t.a(new f("foreground_rendering_started"));
    }

    private void n() {
        this.t.a(new f("foreground_rendering_stopped"));
    }

    /* access modifiers changed from: package-private */
    public void a(float f2, float f3, float f4, float f5) {
        this.x = e.a(f2, f3, f4, f5);
        if (com.youku.opengl.a.a.b) {
            com.youku.opengl.a.a.a("YkGLVideoSyncFilter", "setRenderArea() - new cube:" + e.a("cube:", this.x, 2));
        }
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(this.x.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.f = asFloatBuffer;
        asFloatBuffer.put(this.x).position(0);
    }

    @Override // com.youku.opengl.filter.b
    public void a(int i2, int i3) {
        super.a(i2, i3);
        this.w.a(i2, i3);
    }

    @Override // com.youku.opengl.filter.b
    public void a(int i2, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        com.youku.media.b bVar;
        long j2;
        if (this.h != null && (bVar = this.j) != null && !this.v) {
            long c = (long) bVar.c();
            int i3 = this.k;
            long j3 = c - ((long) i3);
            if (j3 >= 0 && i3 > 0) {
                j.b a = this.m.a(j3);
                boolean z2 = false;
                if (a != null) {
                    j2 = Math.abs(a.b - j3);
                    if (com.youku.opengl.a.a.b && j2 >= 0) {
                        com.youku.opengl.a.a.a("YkGLVideoSyncFilter", "getNearestFrame mVideoReferencePts:[" + j3 + "] " + "textureFrame.pts:[" + a.b + "] " + "textureFrame.id:[" + a.a + "] " + "queue:[" + this.m.d() + "] " + "diff:[" + (a.b - j3) + jl1.ARRAY_END_STR);
                        a(c, a.b);
                    }
                    GLES20.glBlendEquationSeparate(32774, 32774);
                    GLES20.glBlendFuncSeparate(1, 771, 1, 771);
                    GLES20.glEnable(3042);
                    GLES20.glDisable(2929);
                    GLES20.glDisable(2884);
                    super.a(a.a, floatBuffer, floatBuffer2);
                    GLES20.glDisable(3042);
                    if (!this.r) {
                        this.r = true;
                        m();
                    }
                    if (this.p == 0) {
                        this.p = SystemClock.elapsedRealtime();
                    }
                    this.o++;
                    long elapsedRealtime = SystemClock.elapsedRealtime() - this.p;
                    if (elapsedRealtime > 1000) {
                        this.p = SystemClock.elapsedRealtime();
                        this.q = (int) (((long) (this.o * 1000)) / elapsedRealtime);
                        this.o = 0;
                    }
                } else {
                    if (com.youku.opengl.a.a.b) {
                        com.youku.opengl.a.a.a("YkGLVideoSyncFilter", "no cached frame, mVideoReferencePts:[" + j3 + "] ");
                    }
                    j2 = 0;
                }
                b(j3);
                if (!this.s) {
                    if (a == null || (this.m.d() == 0 && j2 >= 80)) {
                        z2 = true;
                    }
                    com.youku.opengl.a.a.a("YkGLVideoSyncFilter", "onDraw() - videoFrame:" + a + " queue size:" + this.m.d() + " absDiff:" + j2);
                    if (z2) {
                        this.s = true;
                        n();
                    }
                }
            }
            d dVar = this.u;
            if (dVar != null && dVar.d()) {
                long c2 = (long) this.i.c();
                if (this.n != c2 && c2 >= 0) {
                    a(i2, c2, this.f, this.g);
                    this.h.a(c2);
                    this.n = c2;
                } else if (com.youku.opengl.a.a.b) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("onDraw() - decoding pts equals last:");
                    sb.append(c2 == this.n ? BQCCameraParam.VALUE_YES : "no");
                    sb.append(" current decoding pts:");
                    sb.append(c2);
                    sb.append(" last decoding pts:");
                    sb.append(this.n);
                    com.youku.opengl.a.a.a("YkGLVideoSyncFilter", sb.toString());
                }
            }
        }
    }

    @Override // com.youku.opengl.widget.j.a
    public void a(long j2) {
        a aVar = this.h;
        if (aVar != null) {
            aVar.b();
            com.youku.opengl.a.a.a("YkGLVideoSyncFilter", "onFrameDequeue() - notified");
        }
    }

    /* access modifiers changed from: package-private */
    public void a(a aVar) {
        if (com.youku.opengl.a.a.b) {
            com.youku.opengl.a.a.a("YkGLVideoSyncFilter", "setVideoPlayer() - videoPlayer:" + aVar);
        }
        this.h = aVar;
    }

    /* access modifiers changed from: package-private */
    public void a(com.youku.media.b bVar) {
        if (com.youku.opengl.a.a.b) {
            com.youku.opengl.a.a.a("YkGLVideoSyncFilter", "setTexturePtsProvider() - ptsProvider:" + bVar);
        }
        this.i = bVar;
    }

    /* access modifiers changed from: package-private */
    public void a(g gVar) {
        this.t = gVar;
    }

    /* access modifiers changed from: package-private */
    public void b(int i2) {
        if (com.youku.opengl.a.a.b) {
            com.youku.opengl.a.a.a("YkGLVideoSyncFilter", "startRenderAt() - atPrimaryVideoPts:" + i2);
        }
        this.k = i2;
    }

    /* access modifiers changed from: package-private */
    public void b(com.youku.media.b bVar) {
        if (com.youku.opengl.a.a.b) {
            com.youku.opengl.a.a.a("YkGLVideoSyncFilter", "setPrimaryVideoPtsProvider() - provider:" + bVar);
        }
        this.j = bVar;
    }

    @Override // com.youku.opengl.filter.b
    public void c() {
        super.c();
        h hVar = this.c;
        if (hVar != null) {
            this.u = hVar.d();
        }
        this.w.d();
        this.m.a();
    }

    @Override // com.youku.opengl.filter.b
    public void f() {
        super.f();
        this.u = null;
        this.w.e();
        this.m.b();
    }
}
