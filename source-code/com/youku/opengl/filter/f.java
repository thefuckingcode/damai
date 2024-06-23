package com.youku.opengl.filter;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.text.TextUtils;
import com.youku.opengl.a.a;
import com.youku.opengl.a.c;
import com.youku.opengl.a.d;
import com.youku.opengl.a.e;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* compiled from: Taobao */
public class f extends b {
    private static final float[] d = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
    private static final float[] e = c.a;
    private int f = -1;
    private Bitmap g;
    private String h;
    private String i;
    private b j;
    private float[] k;
    private FloatBuffer l;
    private final FloatBuffer m;
    private int n;
    private int o;
    private float p;
    private float q;

    public f() {
        float[] fArr = d;
        this.k = fArr;
        this.n = -16776961;
        this.o = 10;
        this.j = new b();
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(fArr.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.l = asFloatBuffer;
        asFloatBuffer.put(fArr).position(0);
        float[] fArr2 = e;
        FloatBuffer asFloatBuffer2 = ByteBuffer.allocateDirect(fArr2.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.m = asFloatBuffer2;
        asFloatBuffer2.put(fArr2).position(0);
    }

    private void a(float f2, float f3, float f4, float f5) {
        if (a.b) {
            String str = this.a;
            a.a(str, "setRenderArea() - x:" + f2 + " y:" + f3 + " width:" + f4 + " height:" + f5);
        }
        this.k = e.a(f2, f3, f4, f5);
        if (a.b) {
            String str2 = this.a;
            a.a(str2, "setRenderArea() - new cube:" + e.a("cube:", this.k, 2));
        }
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(this.k.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.l = asFloatBuffer;
        asFloatBuffer.put(this.k).position(0);
    }

    private String m() {
        return this.h;
    }

    public void a(float f2, float f3) {
        if (a.b) {
            String str = this.a;
            a.a(str, "setStartPoint() - x:" + f2 + " y:" + f3);
        }
        this.p = f2;
        this.q = f3;
    }

    @Override // com.youku.opengl.filter.b
    public void a(int i2, int i3) {
        super.a(i2, i3);
        this.j.a(i2, i3);
    }

    @Override // com.youku.opengl.filter.b
    public void a(int i2, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        super.a(i2, floatBuffer, floatBuffer2);
        a.a(this.a, "onDraw() - begin");
        String m2 = m();
        if (TextUtils.isEmpty(m2)) {
            a.b(this.a, "onDraw() - no text");
            return;
        }
        if (TextUtils.isEmpty(this.i) || !this.i.equals(m2)) {
            Bitmap a = d.a(this.g, m2, this.n, this.o);
            this.g = a;
            this.f = e.a(a, this.f, false);
            a(this.p, this.q, ((float) this.g.getWidth()) / ((float) j()), ((float) this.g.getHeight()) / ((float) k()));
            this.i = m2;
        }
        GLES20.glBlendEquationSeparate(32774, 32774);
        GLES20.glBlendFuncSeparate(1, 771, 1, 1);
        GLES20.glEnable(3042);
        GLES20.glDisable(2929);
        GLES20.glDisable(2884);
        this.j.a(this.f, this.l, this.m);
        GLES20.glDisable(3042);
        a.a(this.a, "onDraw() - end");
    }

    public void a(String str) {
        this.h = str;
    }

    public void b(int i2) {
        this.o = i2;
    }

    @Override // com.youku.opengl.filter.b
    public void c() {
        super.c();
        this.j.d();
    }

    public void c(int i2) {
        this.n = i2;
    }

    @Override // com.youku.opengl.filter.b
    public void f() {
        super.f();
        this.j.f();
    }
}
