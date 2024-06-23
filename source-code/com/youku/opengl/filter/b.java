package com.youku.opengl.filter;

import android.opengl.GLES20;
import com.youku.opengl.a.a;
import com.youku.opengl.a.e;
import com.youku.opengl.widget.h;
import java.nio.Buffer;
import java.nio.FloatBuffer;
import java.util.LinkedList;
import java.util.Queue;

/* compiled from: Taobao */
public class b {
    protected String a;
    protected int b;
    protected h c;
    private final Queue<Runnable> d;
    private final String e;
    private final String f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private boolean m;

    public b() {
        this(1, "attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying highp vec2 textureCoordinate;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
    }

    public b(int i2) {
        this(i2, "attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying highp vec2 textureCoordinate;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
    }

    public b(int i2, String str, String str2) {
        this.d = new LinkedList();
        String simpleName = getClass().getSimpleName();
        this.a = simpleName;
        if (a.b) {
            a.a(simpleName, "constructor() - samplerType:" + i2 + "\nvertexShader:\n" + str + "\nfragmentShader:\n" + str2);
        }
        this.b = i2;
        this.e = str;
        StringBuilder sb = new StringBuilder();
        sb.append(this.b == 0 ? "#extension GL_OES_EGL_image_external : require\n\nuniform samplerExternalOES inputImageTexture;\n" : "uniform sampler2D inputImageTexture;\n");
        sb.append(str2);
        this.f = sb.toString();
    }

    private final void m() {
        a();
        c();
    }

    public void a() {
        a.a(this.a, "onInit()");
        int a2 = e.a(this.e, this.f);
        this.g = a2;
        this.h = GLES20.glGetAttribLocation(a2, "position");
        this.j = GLES20.glGetAttribLocation(this.g, "inputTextureCoordinate");
        this.i = GLES20.glGetUniformLocation(this.g, "inputImageTexture");
        this.m = true;
    }

    /* access modifiers changed from: protected */
    public void a(int i2) {
        if (i2 != -1) {
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(g(), i2);
        }
    }

    /* access modifiers changed from: protected */
    public void a(int i2, float f2) {
        a(new YkGLFilter$2(this, i2, f2));
    }

    public void a(int i2, int i3) {
        if (a.b) {
            String str = this.a;
            a.a(str, "onOutputSizeChanged() - width:" + i2 + " height:" + i3);
        }
        this.k = i2;
        this.l = i3;
    }

    public void a(int i2, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        if (i2 == -1) {
            a.a(this.a, "onDraw() - invalid texture, do nothing");
        } else if (!this.m) {
            a.b(this.a, "onDraw() - not initialized, do nothing!!!");
        } else {
            if (a.b) {
                String str = this.a;
                a.a(str, "onDraw() - textureId:" + i2 + " cubeBuffer:" + floatBuffer + " textureBuffer:" + floatBuffer2);
            }
            h();
            a(i2);
            floatBuffer.position(0);
            GLES20.glVertexAttribPointer(this.h, 2, 5126, false, 0, (Buffer) floatBuffer);
            GLES20.glEnableVertexAttribArray(this.h);
            floatBuffer2.position(0);
            GLES20.glVertexAttribPointer(this.j, 2, 5126, false, 0, (Buffer) floatBuffer2);
            GLES20.glEnableVertexAttribArray(this.j);
            GLES20.glUniform1i(this.i, 0);
            b();
            GLES20.glDrawArrays(5, 0, 4);
            GLES20.glDisableVertexAttribArray(this.h);
            GLES20.glDisableVertexAttribArray(this.j);
        }
    }

    public void a(h hVar) {
        this.c = hVar;
    }

    /* access modifiers changed from: protected */
    public void a(Runnable runnable) {
        synchronized (this.d) {
            this.d.add(runnable);
        }
    }

    public void a(float[] fArr) {
    }

    /* access modifiers changed from: protected */
    public void b() {
        a.a(this.a, "onPreGLDraw()");
    }

    public void c() {
    }

    public void d() {
        if (a.b) {
            String str = this.a;
            a.a(str, "initIfNeeded() - mIsInitialized:" + this.m);
        }
        if (!this.m) {
            m();
        }
    }

    public final void e() {
        a.a(this.a, "destroy()");
        this.m = false;
        this.c = null;
        GLES20.glDeleteProgram(this.g);
        f();
    }

    public void f() {
    }

    /* access modifiers changed from: protected */
    public int g() {
        return this.b == 0 ? 36197 : 3553;
    }

    /* access modifiers changed from: protected */
    public void h() {
        synchronized (this.d) {
            while (!this.d.isEmpty()) {
                this.d.poll().run();
            }
        }
    }

    public boolean i() {
        return this.m;
    }

    public int j() {
        return this.k;
    }

    public int k() {
        return this.l;
    }

    public int l() {
        return this.g;
    }
}
