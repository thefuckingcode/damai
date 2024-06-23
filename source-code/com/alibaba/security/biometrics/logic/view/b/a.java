package com.alibaba.security.biometrics.logic.view.b;

import android.content.Context;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import com.alibaba.security.biometrics.camera.c;
import com.alibaba.security.biometrics.service.model.params.ALBiometricsParams;
import com.youku.alixplayer.MsgID;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import org.apache.commons.lang3.StringUtils;

/* compiled from: Taobao */
public final class a implements GLSurfaceView.Renderer {
    private static final String d = "CameraRender";
    private static final float[] e = {1.0f, 1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, -1.0f, -1.0f, 1.0f, -1.0f};
    private static final float[] f = {1.0f, 1.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f};
    private static final String s = "attribute vec4 avVertex;                                              \nattribute vec4 avVertexCoordinate;                                    \nuniform mat4 umTransformMatrix;                                       \nvarying vec2 vvTextureCoordinate;                                     \nvoid main() {                                                         \n    vvTextureCoordinate= (umTransformMatrix * avVertexCoordinate).xy; \n    gl_Position = avVertex;                                           \n}                                                                     \n";
    private static final String t = "#extension GL_OES_EGL_image_external : require                       \nprecision mediump float;                                             \nuniform samplerExternalOES usTextureOes;                             \nvarying vec2 vvTextureCoordinate;                                    \nvoid main() {                                                        \n    vec4 vCameraColor = texture2D(usTextureOes, vvTextureCoordinate);\n    gl_FragColor = vCameraColor;                                     \n}                                                                    \n";
    public int a;
    public com.alibaba.security.common.a.a b;
    public SurfaceTexture c;
    private final Context g;
    private final c h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;
    private int n;
    private int o;
    private float[] p = new float[16];
    private FloatBuffer q;
    private FloatBuffer r;

    public a(Context context, c cVar, ALBiometricsParams aLBiometricsParams) {
        this.g = context;
        this.h = cVar;
        if (aLBiometricsParams.isBeautyOpen) {
            try {
                this.b = (com.alibaba.security.common.a.a) Class.forName("com.alibaba.security.plugin.beauty.BeautyRenderManager").newInstance();
            } catch (Throwable unused) {
            }
        }
    }

    private void a() {
        float[] fArr = e;
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(fArr.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.q = asFloatBuffer;
        asFloatBuffer.put(fArr).position(0);
        float[] fArr2 = f;
        FloatBuffer put = ByteBuffer.allocateDirect(fArr2.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer().put(fArr2);
        this.r = put;
        put.position(0);
        this.i = GLES20.glCreateProgram();
        int a2 = a(35633, s);
        this.j = a2;
        GLES20.glAttachShader(this.i, a2);
        int a3 = a(35632, t);
        this.k = a3;
        GLES20.glAttachShader(this.i, a3);
        GLES20.glLinkProgram(this.i);
    }

    private void b() {
        SurfaceTexture surfaceTexture = this.c;
        if (surfaceTexture != null) {
            surfaceTexture.updateTexImage();
            this.c.getTransformMatrix(this.p);
        }
        GLES20.glClearColor(1.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glClear(16384);
        GLES20.glUseProgram(this.i);
        this.l = GLES20.glGetAttribLocation(this.i, "avVertex");
        this.o = GLES20.glGetAttribLocation(this.i, "avVertexCoordinate");
        this.m = GLES20.glGetUniformLocation(this.i, "umTransformMatrix");
        this.n = GLES20.glGetUniformLocation(this.i, "usTextureOes");
        GLES20.glVertexAttribPointer(this.l, 2, 5126, false, 8, (Buffer) this.q);
        GLES20.glVertexAttribPointer(this.o, 2, 5126, false, 8, (Buffer) this.r);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, this.a);
        GLES20.glUniform1i(this.n, 0);
        GLES20.glUniformMatrix4fv(this.m, 1, false, this.p, 0);
        GLES20.glEnableVertexAttribArray(this.l);
        GLES20.glEnableVertexAttribArray(this.o);
        GLES20.glDrawArrays(4, 0, 6);
        GLES20.glDisableVertexAttribArray(this.l);
        GLES20.glDisableVertexAttribArray(this.o);
    }

    private void c() {
        SurfaceTexture surfaceTexture = this.c;
        if (surfaceTexture != null) {
            surfaceTexture.release();
            this.c = null;
        }
        this.a = -1;
        com.alibaba.security.common.a.a aVar = this.b;
        if (aVar != null) {
            aVar.a();
        }
    }

    private static int d() {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        GLES20.glBindTexture(36197, iArr[0]);
        GLES20.glTexParameterf(36197, 10241, 9728.0f);
        GLES20.glTexParameterf(36197, MsgID.MEDIA_INFO_VIDEO_START_RECOVER, 9729.0f);
        GLES20.glTexParameterf(36197, 10242, 33071.0f);
        GLES20.glTexParameterf(36197, 10243, 33071.0f);
        GLES20.glBindTexture(36197, 0);
        return iArr[0];
    }

    private SurfaceTexture e() {
        return this.c;
    }

    private void f() {
        com.alibaba.security.common.a.a aVar = this.b;
        if (aVar != null) {
            aVar.a(this.h.h(), this.p);
        }
    }

    public final void onDrawFrame(GL10 gl10) {
        SurfaceTexture surfaceTexture = this.c;
        if (surfaceTexture != null) {
            surfaceTexture.updateTexImage();
            this.c.getTransformMatrix(this.p);
        }
        GLES20.glClearColor(1.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glClear(16384);
        GLES20.glUseProgram(this.i);
        this.l = GLES20.glGetAttribLocation(this.i, "avVertex");
        this.o = GLES20.glGetAttribLocation(this.i, "avVertexCoordinate");
        this.m = GLES20.glGetUniformLocation(this.i, "umTransformMatrix");
        this.n = GLES20.glGetUniformLocation(this.i, "usTextureOes");
        GLES20.glVertexAttribPointer(this.l, 2, 5126, false, 8, (Buffer) this.q);
        GLES20.glVertexAttribPointer(this.o, 2, 5126, false, 8, (Buffer) this.r);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, this.a);
        GLES20.glUniform1i(this.n, 0);
        GLES20.glUniformMatrix4fv(this.m, 1, false, this.p, 0);
        GLES20.glEnableVertexAttribArray(this.l);
        GLES20.glEnableVertexAttribArray(this.o);
        GLES20.glDrawArrays(4, 0, 6);
        GLES20.glDisableVertexAttribArray(this.l);
        GLES20.glDisableVertexAttribArray(this.o);
        com.alibaba.security.common.a.a aVar = this.b;
        if (aVar != null) {
            aVar.a(this.h.h(), this.p);
        }
    }

    public final void onSurfaceChanged(GL10 gl10, int i2, int i3) {
        GLES20.glViewport(0, 0, i2, i3);
        com.alibaba.security.common.a.a aVar = this.b;
        if (aVar != null) {
            aVar.a(i2, i3);
        }
    }

    public final void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        com.alibaba.security.common.a.a aVar;
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        GLES20.glBindTexture(36197, iArr[0]);
        GLES20.glTexParameterf(36197, 10241, 9728.0f);
        GLES20.glTexParameterf(36197, MsgID.MEDIA_INFO_VIDEO_START_RECOVER, 9729.0f);
        GLES20.glTexParameterf(36197, 10242, 33071.0f);
        GLES20.glTexParameterf(36197, 10243, 33071.0f);
        GLES20.glBindTexture(36197, 0);
        this.a = iArr[0];
        this.c = new SurfaceTexture(this.a);
        float[] fArr = e;
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(fArr.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.q = asFloatBuffer;
        asFloatBuffer.put(fArr).position(0);
        float[] fArr2 = f;
        FloatBuffer put = ByteBuffer.allocateDirect(fArr2.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer().put(fArr2);
        this.r = put;
        put.position(0);
        this.i = GLES20.glCreateProgram();
        int a2 = a(35633, s);
        this.j = a2;
        GLES20.glAttachShader(this.i, a2);
        int a3 = a(35632, t);
        this.k = a3;
        GLES20.glAttachShader(this.i, a3);
        GLES20.glLinkProgram(this.i);
        Point g2 = this.h.g();
        if (g2 != null && (aVar = this.b) != null) {
            aVar.a(this.g, com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(g2), com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(g2), this.h.i(), this.a);
        }
    }

    private static int a(int i2, String str) {
        int glCreateShader = GLES20.glCreateShader(i2);
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        return glCreateShader;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:37:0x005f, code lost:
        if (r2 == null) goto L_0x0068;
     */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0070 A[SYNTHETIC, Splitter:B:45:0x0070] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0075 A[Catch:{ IOException -> 0x007e }] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x007a A[Catch:{ IOException -> 0x007e }] */
    private static String a(Context context, int i2) {
        InputStreamReader inputStreamReader;
        BufferedReader bufferedReader;
        Throwable th;
        StringBuilder sb = new StringBuilder();
        InputStream inputStream = null;
        try {
            InputStream openRawResource = context.getResources().openRawResource(i2);
            try {
                inputStreamReader = new InputStreamReader(openRawResource);
            } catch (IOException unused) {
                inputStreamReader = null;
                bufferedReader = null;
                inputStream = openRawResource;
                try {
                    com.alibaba.security.common.c.a.b();
                    if (inputStream != null) {
                    }
                    if (inputStreamReader != null) {
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (inputStream != null) {
                    }
                    if (inputStreamReader != null) {
                    }
                    if (bufferedReader != null) {
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                inputStreamReader = null;
                bufferedReader = null;
                inputStream = openRawResource;
                if (inputStream != null) {
                }
                if (inputStreamReader != null) {
                }
                if (bufferedReader != null) {
                }
                throw th;
            }
            try {
                bufferedReader = new BufferedReader(inputStreamReader);
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        sb.append(readLine + StringUtils.LF);
                    } catch (IOException unused2) {
                        inputStream = openRawResource;
                        com.alibaba.security.common.c.a.b();
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (inputStreamReader != null) {
                            inputStreamReader.close();
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        inputStream = openRawResource;
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException unused3) {
                                com.alibaba.security.common.c.a.b();
                                throw th;
                            }
                        }
                        if (inputStreamReader != null) {
                            inputStreamReader.close();
                        }
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        throw th;
                    }
                }
                if (openRawResource != null) {
                    try {
                        openRawResource.close();
                    } catch (IOException unused4) {
                        com.alibaba.security.common.c.a.b();
                    }
                }
                inputStreamReader.close();
            } catch (IOException unused5) {
                bufferedReader = null;
                inputStream = openRawResource;
                com.alibaba.security.common.c.a.b();
                if (inputStream != null) {
                }
                if (inputStreamReader != null) {
                }
            } catch (Throwable th5) {
                th = th5;
                bufferedReader = null;
                inputStream = openRawResource;
                if (inputStream != null) {
                }
                if (inputStreamReader != null) {
                }
                if (bufferedReader != null) {
                }
                throw th;
            }
        } catch (IOException unused6) {
            inputStreamReader = null;
            bufferedReader = null;
            com.alibaba.security.common.c.a.b();
            if (inputStream != null) {
            }
            if (inputStreamReader != null) {
            }
        } catch (Throwable th6) {
            th = th6;
            inputStreamReader = null;
            bufferedReader = null;
            if (inputStream != null) {
            }
            if (inputStreamReader != null) {
            }
            if (bufferedReader != null) {
            }
            throw th;
        }
        bufferedReader.close();
        return sb.toString();
    }
}
