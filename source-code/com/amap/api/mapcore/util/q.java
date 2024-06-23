package com.amap.api.mapcore.util;

import android.opengl.GLES20;
import android.opengl.Matrix;
import com.amap.api.mapcore.util.de;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
public class q {
    List<Float> a = new ArrayList();
    List<Float> b = new ArrayList();
    private FloatBuffer c;
    private FloatBuffer d;
    private int e = 0;
    private float f;
    private float g;
    private float h;

    public q(List<Float> list, List<Float> list2) {
        float f2 = 0.0f;
        this.g = 0.0f;
        this.h = 0.0f;
        this.a = list;
        this.b = list2;
        if (this.c == null) {
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(list.size() * 4);
            allocateDirect.order(ByteOrder.nativeOrder());
            this.c = allocateDirect.asFloatBuffer();
        }
        this.c.clear();
        float f3 = 0.0f;
        float f4 = 0.0f;
        float f5 = 1000000.0f;
        float f6 = 1000000.0f;
        int i = 1;
        for (int i2 = 1; i2 < list.size() + 1; i2++) {
            Float f7 = list.get(i2 - 1);
            this.c.put(f7.floatValue());
            if (i == 1) {
                f2 = Math.max(f7.floatValue(), f2);
                f5 = Math.min(f7.floatValue(), f5);
            }
            if (i == 2) {
                f3 = Math.max(f7.floatValue(), f3);
                f6 = Math.min(f7.floatValue(), f6);
            }
            if (i == 3) {
                f4 = Math.max(f4, f7.floatValue());
                i = 0;
            }
            i++;
        }
        float abs = Math.abs(f2 - f5);
        float abs2 = Math.abs(f3 - f6);
        int i3 = (abs > abs2 ? 1 : (abs == abs2 ? 0 : -1));
        this.g = i3 > 0 ? abs : abs2;
        this.h = i3 > 0 ? abs2 : abs;
        this.c.position(0);
        if (this.d == null) {
            ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(list2.size() * 4);
            allocateDirect2.order(ByteOrder.nativeOrder());
            this.d = allocateDirect2.asFloatBuffer();
        }
        this.d.clear();
        for (Float f8 : list2) {
            this.d.put(f8.floatValue());
        }
        this.d.position(0);
    }

    public float a() {
        return this.g;
    }

    public float b() {
        return this.h;
    }

    public void c() {
        this.a.clear();
        this.d.clear();
    }

    public void a(int i) {
        this.e = i;
    }

    public void a(float f2) {
        this.f = -f2;
    }

    public void a(de.b bVar, float[] fArr) {
        Matrix.rotateM(fArr, 0, this.f, 0.0f, 0.0f, 1.0f);
        GLES20.glUseProgram(bVar.d);
        GLES20.glClear(256);
        GLES20.glEnable(2929);
        GLES20.glDepthMask(true);
        GLES20.glEnable(3042);
        GLES20.glBlendFunc(770, 771);
        GLES20.glBlendColor(1.0f, 1.0f, 1.0f, 1.0f);
        GLES20.glBindTexture(3553, this.e);
        GLES20.glEnableVertexAttribArray(bVar.h);
        GLES20.glVertexAttribPointer(bVar.h, 2, 5126, false, 8, (Buffer) this.d);
        GLES20.glEnableVertexAttribArray(bVar.c);
        GLES20.glVertexAttribPointer(bVar.c, 3, 5126, false, 12, (Buffer) this.c);
        GLES20.glUniformMatrix4fv(bVar.g, 1, false, fArr, 0);
        GLES20.glDrawArrays(4, 0, this.a.size() / 3);
        GLES20.glBindTexture(3553, 0);
        GLES20.glDisable(2929);
        GLES20.glDisableVertexAttribArray(bVar.c);
        GLES20.glDisableVertexAttribArray(bVar.h);
        GLES20.glUseProgram(0);
    }
}
