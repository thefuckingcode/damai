package com.youku.opengl.filter;

import android.opengl.GLES20;
import com.youku.alixplayer.MsgID;
import com.youku.opengl.a.a;
import com.youku.opengl.widget.h;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
public class c extends b {
    private List<b> d;
    private List<b> e;
    private int[] f;
    private int[] g;
    private final FloatBuffer h;
    private final FloatBuffer i;
    private final FloatBuffer j;

    public c() {
        this(null);
    }

    public c(List<b> list) {
        String simpleName = getClass().getSimpleName();
        this.a = simpleName;
        a.a(simpleName, "YkGLFilterGroup()");
        this.d = list;
        if (list == null) {
            this.d = new ArrayList();
        } else {
            o();
        }
        float[] fArr = h.e;
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(fArr.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.h = asFloatBuffer;
        asFloatBuffer.put(fArr).position(0);
        float[] fArr2 = com.youku.opengl.a.c.a;
        FloatBuffer asFloatBuffer2 = ByteBuffer.allocateDirect(fArr2.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.i = asFloatBuffer2;
        asFloatBuffer2.put(fArr2).position(0);
        float[] a = com.youku.opengl.a.c.a(0, false, true);
        FloatBuffer asFloatBuffer3 = ByteBuffer.allocateDirect(a.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.j = asFloatBuffer3;
        asFloatBuffer3.put(a).position(0);
    }

    private void p() {
        int[] iArr = this.g;
        if (iArr != null) {
            GLES20.glDeleteTextures(iArr.length, iArr, 0);
            this.g = null;
        }
        int[] iArr2 = this.f;
        if (iArr2 != null) {
            GLES20.glDeleteFramebuffers(iArr2.length, iArr2, 0);
            this.f = null;
        }
    }

    @Override // com.youku.opengl.filter.b
    public void a() {
        super.a();
        for (b bVar : this.d) {
            bVar.d();
        }
    }

    @Override // com.youku.opengl.filter.b
    public void a(int i2, int i3) {
        super.a(i2, i3);
        if (this.f != null) {
            p();
        }
        int size = this.d.size();
        for (int i4 = 0; i4 < size; i4++) {
            this.d.get(i4).a(i2, i3);
        }
        List<b> list = this.e;
        if (list != null && list.size() > 0) {
            int i5 = 1;
            int size2 = this.e.size() - 1;
            this.f = new int[size2];
            this.g = new int[size2];
            int i6 = 0;
            while (i6 < size2) {
                GLES20.glGenFramebuffers(i5, this.f, i6);
                if (a.b) {
                    String str = this.a;
                    a.a(str, "onOutputSizeChanged() - mFrameBuffers[" + i6 + "]:" + this.f[i6]);
                }
                GLES20.glGenTextures(i5, this.g, i6);
                if (a.b) {
                    String str2 = this.a;
                    a.a(str2, "onOutputSizeChanged() - mFrameBufferTextures[" + i6 + "]:" + this.g[i6]);
                }
                GLES20.glBindTexture(3553, this.g[i6]);
                GLES20.glTexImage2D(3553, 0, 6408, i2, i3, 0, 6408, 5121, null);
                GLES20.glTexParameterf(3553, MsgID.MEDIA_INFO_VIDEO_START_RECOVER, 9729.0f);
                GLES20.glTexParameterf(3553, 10241, 9729.0f);
                GLES20.glTexParameterf(3553, 10242, 33071.0f);
                GLES20.glTexParameterf(3553, 10243, 33071.0f);
                GLES20.glBindFramebuffer(36160, this.f[i6]);
                GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.g[i6], 0);
                GLES20.glBindTexture(3553, 0);
                GLES20.glBindFramebuffer(36160, 0);
                i6++;
                i5 = 1;
            }
        }
    }

    @Override // com.youku.opengl.filter.b
    public void a(int i2, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        List<b> list;
        FloatBuffer floatBuffer3;
        FloatBuffer floatBuffer4;
        h();
        if (i() && this.f != null && this.g != null && (list = this.e) != null) {
            int size = list.size();
            int i3 = 0;
            while (i3 < size) {
                b bVar = this.e.get(i3);
                int i4 = size - 1;
                boolean z = i3 < i4;
                if (z) {
                    GLES20.glBindFramebuffer(36160, this.f[i3]);
                    GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
                }
                GLES20.glUseProgram(bVar.l());
                if (i3 == 0) {
                    bVar.a(i2, floatBuffer, floatBuffer2);
                } else {
                    if (i3 == i4) {
                        floatBuffer4 = this.h;
                        if (size % 2 == 0) {
                            floatBuffer3 = this.j;
                            bVar.a(i2, floatBuffer4, floatBuffer3);
                        }
                    } else {
                        floatBuffer4 = this.h;
                    }
                    floatBuffer3 = this.i;
                    bVar.a(i2, floatBuffer4, floatBuffer3);
                }
                if (z) {
                    GLES20.glBindFramebuffer(36160, 0);
                    i2 = this.g[i3];
                }
                i3++;
            }
        }
    }

    public void a(b bVar) {
        if (a.b) {
            String str = this.a;
            a.a(str, "addFilter() - aFilter:" + bVar);
        }
        if (bVar != null) {
            this.d.add(bVar);
            o();
        }
    }

    @Override // com.youku.opengl.filter.b
    public void a(h hVar) {
        super.a(hVar);
        for (b bVar : this.d) {
            bVar.a(hVar);
        }
    }

    @Override // com.youku.opengl.filter.b
    public void a(float[] fArr) {
        List<b> list = this.e;
        if (list != null) {
            for (b bVar : list) {
                if (bVar != null) {
                    bVar.a(fArr);
                }
            }
        }
    }

    @Override // com.youku.opengl.filter.b
    public void f() {
        a.a(this.a, "onDestroy()");
        p();
        for (b bVar : this.d) {
            bVar.e();
        }
        super.f();
    }

    public List<b> m() {
        return this.d;
    }

    public List<b> n() {
        return this.e;
    }

    public void o() {
        if (this.d != null) {
            List<b> list = this.e;
            if (list == null) {
                this.e = new ArrayList();
            } else {
                list.clear();
            }
            for (b bVar : this.d) {
                if (bVar instanceof c) {
                    c cVar = (c) bVar;
                    cVar.o();
                    List<b> n = cVar.n();
                    if (n != null && !n.isEmpty()) {
                        this.e.addAll(n);
                    }
                } else {
                    this.e.add(bVar);
                }
            }
        }
    }
}
