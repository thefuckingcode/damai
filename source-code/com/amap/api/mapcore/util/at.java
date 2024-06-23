package com.amap.api.mapcore.util;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.util.Log;
import com.amap.api.mapcore.util.de;
import com.amap.api.maps.model.BitmapDescriptor;
import com.youku.alixplayer.MsgID;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

/* compiled from: Taobao */
public class at {
    public static int a = 200;
    float[] b = null;
    int c = 0;
    int d = 0;
    private boolean e = false;
    private boolean f = false;
    private BitmapDescriptor g;
    private FloatBuffer h;
    private ShortBuffer i;
    private int j = 0;
    private de.a k;
    private de l;

    public at(float[] fArr, aw awVar) {
        this.b = fArr;
    }

    private void a(float[] fArr) {
        if (fArr != null) {
            if (this.h == null) {
                ByteBuffer allocateDirect = ByteBuffer.allocateDirect(fArr.length * a * 4);
                allocateDirect.order(ByteOrder.nativeOrder());
                this.h = allocateDirect.asFloatBuffer();
            }
            this.h.clear();
            for (int i2 = 0; i2 < a; i2++) {
                int i3 = 0;
                for (float f2 : fArr) {
                    if (i3 % 6 == 3) {
                        this.h.put((float) i2);
                    } else {
                        this.h.put(f2);
                    }
                    i3++;
                }
            }
            this.h.position(0);
            if (this.i == null) {
                ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(a * 6 * 2);
                allocateDirect2.order(ByteOrder.nativeOrder());
                this.i = allocateDirect2.asShortBuffer();
                short[] sArr = new short[(a * 6)];
                for (int i4 = 0; i4 < a; i4++) {
                    int i5 = i4 * 6;
                    int i6 = i4 * 4;
                    short s = (short) (i6 + 0);
                    sArr[i5 + 0] = s;
                    sArr[i5 + 1] = (short) (i6 + 1);
                    short s2 = (short) (i6 + 2);
                    sArr[i5 + 2] = s2;
                    sArr[i5 + 3] = s;
                    sArr[i5 + 4] = s2;
                    sArr[i5 + 5] = (short) (i6 + 3);
                }
                this.i.put(sArr);
                this.i.flip();
            }
            this.e = true;
        }
    }

    private void e() {
        if (this.c == 0) {
            int[] iArr = new int[2];
            GLES20.glGenBuffers(2, iArr, 0);
            int i2 = iArr[0];
            this.c = i2;
            this.d = iArr[1];
            GLES20.glBindBuffer(34962, i2);
            GLES20.glBufferData(34962, this.h.limit() * 4, this.h, 35044);
            GLES20.glBindBuffer(34963, this.d);
            GLES20.glBufferData(34963, a * 6 * 2, this.i, 35044);
            a("bindVbo");
            this.h.clear();
            this.h = null;
        }
    }

    private void f() {
        try {
            de deVar = this.l;
            if (deVar != null) {
                this.k = (de.a) deVar.a(4);
            }
        } catch (Throwable unused) {
            a = 1;
            de deVar2 = this.l;
            if (deVar2 != null) {
                this.k = (de.a) deVar2.a(4);
            }
        }
    }

    public boolean b() {
        return this.e;
    }

    public void c() {
        FloatBuffer floatBuffer = this.h;
        if (floatBuffer != null) {
            floatBuffer.clear();
        }
        ShortBuffer shortBuffer = this.i;
        if (shortBuffer != null) {
            shortBuffer.clear();
        }
        if (this.g != null) {
            this.g = null;
        }
        GLES20.glDeleteBuffers(2, new int[]{this.c, this.d}, 0);
        int i2 = this.j;
        if (i2 != 0) {
            GLES20.glDeleteTextures(1, new int[]{i2}, 0);
        }
        this.c = 0;
        this.d = 0;
        this.b = null;
        this.e = false;
        this.f = false;
        this.c = 0;
        this.d = 0;
        this.l = null;
    }

    public boolean d() {
        return this.l != null;
    }

    public void a() {
        float[] fArr = this.b;
        if (fArr != null && !this.e) {
            a(fArr);
        }
    }

    public void a(BitmapDescriptor bitmapDescriptor) {
        this.g = bitmapDescriptor;
    }

    private void a(Bitmap bitmap) {
        if (bitmap != null) {
            if (this.j == 0) {
                int[] iArr = new int[1];
                GLES20.glGenTextures(1, iArr, 0);
                this.j = iArr[0];
            }
            if (this.j != 0) {
                GLES20.glActiveTexture(33984);
                GLES20.glBindTexture(3553, this.j);
                GLES20.glTexParameterf(3553, 10241, 9728.0f);
                GLES20.glTexParameterf(3553, MsgID.MEDIA_INFO_VIDEO_START_RECOVER, 9729.0f);
                GLES20.glTexParameterf(3553, 10242, 33071.0f);
                GLES20.glTexParameterf(3553, 10243, 33071.0f);
                GLUtils.texImage2D(3553, 0, bitmap, 0);
                if (this.j != 0) {
                    this.f = true;
                }
            }
        }
    }

    public void a(float[] fArr, float[] fArr2, float[] fArr3, float f2, float f3, float f4, float f5, int i2) {
        BitmapDescriptor bitmapDescriptor;
        if (!this.f && (bitmapDescriptor = this.g) != null) {
            a(bitmapDescriptor.getBitmap());
        }
        if (this.j != 0) {
            de.a aVar = this.k;
            if (aVar == null || aVar.c()) {
                f();
            }
            e();
            GLES20.glUseProgram(this.k.d);
            GLES20.glUniform4f(this.k.j, f2, f3, f4, f5);
            GLES20.glUniform3fv(this.k.i, i2, fArr3, 0);
            GLES20.glDisable(2929);
            GLES20.glEnable(3042);
            GLES20.glBlendFunc(770, 771);
            GLES20.glBlendColor(1.0f, 1.0f, 1.0f, 1.0f);
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, this.j);
            GLES20.glEnableVertexAttribArray(this.k.c);
            GLES20.glBindBuffer(34962, this.c);
            GLES20.glVertexAttribPointer(this.k.c, 4, 5126, false, 24, 0);
            GLES20.glEnableVertexAttribArray(this.k.h);
            GLES20.glVertexAttribPointer(this.k.h, 2, 5126, false, 24, 16);
            GLES20.glUniformMatrix4fv(this.k.g, 1, false, fArr, 0);
            GLES20.glUniformMatrix4fv(this.k.k, 1, false, fArr2, 0);
            GLES20.glBindBuffer(34963, this.d);
            GLES20.glDrawElements(4, i2 * 6, 5123, 0);
            GLES20.glBindTexture(3553, 0);
            GLES20.glBindBuffer(34962, 0);
            GLES20.glDisableVertexAttribArray(this.k.c);
            GLES20.glDisableVertexAttribArray(this.k.h);
            GLES20.glUseProgram(0);
        }
    }

    public void a(de deVar) {
        this.l = deVar;
    }

    public static synchronized void a(String str) {
        synchronized (at.class) {
            int glGetError = GLES20.glGetError();
            if (glGetError != 0) {
                Log.e("amap", str + ": glError " + glGetError);
                throw new RuntimeException(str + ": glError " + glGetError);
            }
        }
    }
}
