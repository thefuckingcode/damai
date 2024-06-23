package com.youku.opengl.widget;

import android.opengl.GLES20;
import android.opengl.Matrix;
import android.os.SystemClock;
import com.uc.crashsdk.export.LogType;
import com.youku.opengl.a.a;
import com.youku.opengl.a.c;
import com.youku.opengl.a.e;
import com.youku.opengl.filter.b;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* compiled from: Taobao */
public class h extends e {
    public static final float[] e = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
    private final FloatBuffer f;
    private final FloatBuffer g;
    private volatile int h;
    private volatile long i;
    private volatile int j;
    private d k;
    private b l;
    private final ArrayList<c> m;
    private int n = 4096;
    private float o;
    private float p;
    private float q;
    private float r;
    private final float[] s;

    public h(a aVar, d dVar, b bVar) {
        super(aVar);
        ArrayList<c> arrayList = new ArrayList<>();
        this.m = arrayList;
        float[] fArr = new float[16];
        this.s = fArr;
        if (a.b) {
            a.a("YkGLRenderer", "YkGLRenderer() - renderScheduler:" + aVar + " textureHolder:" + dVar + " filter:" + bVar);
        }
        this.k = dVar;
        arrayList.add(dVar);
        this.l = bVar;
        float[] fArr2 = e;
        FloatBuffer put = ByteBuffer.allocateDirect(fArr2.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer().put(fArr2);
        this.f = put;
        put.position(0);
        float[] fArr3 = c.a;
        FloatBuffer put2 = ByteBuffer.allocateDirect(fArr3.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer().put(fArr3);
        this.g = put2;
        put2.position(0);
        Matrix.setIdentityM(fArr, 0);
    }

    private float a(float f2, float f3) {
        return f2 == 0.0f ? f3 : 1.0f - f3;
    }

    private void h() {
        Iterator<c> it = this.m.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    private void i() {
        Iterator<c> it = this.m.iterator();
        while (it.hasNext()) {
            int[] iArr = this.b;
            it.next().a(iArr[0], iArr[1]);
        }
    }

    private void j() {
        int[] iArr = this.b;
        float f2 = (float) iArr[0];
        float f3 = (float) iArr[1];
        int a = com.youku.opengl.a.b.a(this.n);
        if (a == 90 || a == 270) {
            int[] iArr2 = this.b;
            f2 = (float) iArr2[1];
            f3 = (float) iArr2[0];
        }
        if (a.b) {
            a.a("YkGLRenderer", "adjustImageScaling() - rotation:" + a + " outputWidth:" + f2 + " outputHeight:" + f3);
        }
        int[] iArr3 = new int[2];
        this.k.a(iArr3);
        int c = com.youku.opengl.a.b.c(this.n);
        int i2 = iArr3[0];
        int i3 = iArr3[1];
        if (c == 65536 || c == 131072) {
            i2 /= 2;
        }
        if (a.b) {
            a.a("YkGLRenderer", "adjustImageScaling() - imageWidth:" + i2 + " imageHeight:" + i3);
        }
        float f4 = (float) i2;
        float f5 = (float) i3;
        float max = Math.max(f2 / f4, f3 / f5);
        int round = Math.round(f4 * max);
        int round2 = Math.round(f5 * max);
        if (a.b) {
            a.a("YkGLRenderer", "adjustImageScaling() - imageWidthNew:" + round + " imageHeightNew:" + round2);
        }
        float f6 = ((float) round) / f2;
        float f7 = ((float) round2) / f3;
        float[] fArr = e;
        float[] a2 = c.a(this.n, false, false);
        int b = com.youku.opengl.a.b.b(this.n);
        if (b == 8192) {
            float f8 = (1.0f - (1.0f / f6)) / 2.0f;
            float f9 = (1.0f - (1.0f / f7)) / 2.0f;
            a2 = new float[]{a(a2[0], f8), a(a2[1], f9), a(a2[2], f8), a(a2[3], f9), a(a2[4], f8), a(a2[5], f9), a(a2[6], f8), a(a2[7], f9)};
        } else if (b == 4096) {
            if (a.b) {
                a.a("YkGLRenderer", "adjustImageScaling() - " + e.a("CUBE:", fArr, 2));
            }
            fArr = new float[]{fArr[0] / f7, fArr[1] / f6, fArr[2] / f7, fArr[3] / f6, fArr[4] / f7, fArr[5] / f6, fArr[6] / f7, fArr[7] / f6};
        }
        if (a.b) {
            a.a("YkGLRenderer", "adjustImageScaling() - " + e.a("cube:", fArr, 2));
            a.a("YkGLRenderer", "adjustImageScaling() - " + e.a("textureCords:", a2, 2));
        }
        this.f.clear();
        this.f.put(fArr).position(0);
        this.g.clear();
        this.g.put(a2).position(0);
    }

    public void a(float f2, float f3, float f4, float f5) {
        if (a.b) {
            a.a("YkGLRenderer", "setBackgroundColor() - red:" + f2 + " green:" + f3 + " blue:" + f4 + " alpha:" + f5);
        }
        this.o = f2;
        this.p = f3;
        this.q = f4;
        this.r = f5;
    }

    public void a(int i2) {
        if (a.b) {
            a.a("YkGLRenderer", "setRenderType() - renderType:" + i2);
        }
        this.n = i2;
        j();
    }

    public void a(b bVar) {
        if (a.b) {
            a.a("YkGLRenderer", "setFilter() - filter:" + bVar);
        }
        b bVar2 = this.l;
        if (bVar2 != null) {
            bVar2.e();
        }
        this.l = bVar;
        bVar.a(this);
        this.l.d();
        GLES20.glUseProgram(this.l.l());
        e.a("glUseProgram");
        b bVar3 = this.l;
        int[] iArr = this.b;
        bVar3.a(iArr[0], iArr[1]);
    }

    public d d() {
        return this.k;
    }

    public void e() {
        j();
    }

    public int f() {
        return this.j;
    }

    public void g() {
        this.h = 0;
        this.i = 0;
        this.j = 0;
    }

    @Override // com.youku.opengl.widget.e
    public void onDrawFrame(GL10 gl10) {
        int i2;
        super.onDrawFrame(gl10);
        GLES20.glUseProgram(this.l.l());
        e.a("glUseProgram");
        b();
        if (this.a) {
            i2 = this.k.f();
            if (this.k.b()) {
                if (this.i == 0) {
                    this.i = SystemClock.elapsedRealtime();
                }
                this.h++;
                long elapsedRealtime = SystemClock.elapsedRealtime() - this.i;
                if (elapsedRealtime > 1000) {
                    this.i = SystemClock.elapsedRealtime();
                    this.j = (int) (((long) (this.h * 1000)) / elapsedRealtime);
                    this.h = 0;
                }
                GLES20.glClear(LogType.UNEXP_RESTART);
                i2 = this.k.c();
                this.k.a(this.s);
                this.l.a(this.s);
            }
        } else {
            i2 = -1;
            if (this.k.b()) {
                i2 = this.k.c();
                this.k.a(this.s);
                this.l.a(this.s);
            }
        }
        this.l.a(i2, this.f, this.g);
        this.k.e();
        c();
    }

    @Override // com.youku.opengl.widget.e
    public void onSurfaceChanged(GL10 gl10, int i2, int i3) {
        super.onSurfaceChanged(gl10, i2, i3);
        if (a.b) {
            a.a("YkGLRenderer", "onSurfaceChanged() - gl:" + gl10 + " width:" + i2 + " height:" + i3);
        }
        if (this.a) {
            GLES20.glViewport(0, 0, i2, i3);
            e.a("glViewport");
            a.a("YkGLRenderer", "onSurfaceChanged() - set view port");
            this.k.b(new int[]{i2, i3});
            a.a("YkGLRenderer", "onSurfaceChanged() - reset image size to surface size!!!");
        }
        GLES20.glUseProgram(this.l.l());
        e.a("glUseProgram");
        this.l.a(i2, i3);
        j();
        this.k.g();
        i();
    }

    @Override // com.youku.opengl.widget.e
    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        super.onSurfaceCreated(gl10, eGLConfig);
        if (a.b) {
            a.a("YkGLRenderer", "onSurfaceCreated() - gl:" + gl10 + " config:" + eGLConfig);
        }
        if (this.a) {
            GLES20.glClearColor(this.o, this.p, this.q, this.r);
            a.a("YkGLRenderer", "onSurfaceCreated() - set clear color");
        }
        this.l.d();
        g();
        h();
    }
}
