package com.youku.opengl.widget;

import android.opengl.GLES20;
import com.youku.opengl.a.e;
import java.util.concurrent.LinkedBlockingQueue;

/* compiled from: Taobao */
public class j {
    private final LinkedBlockingQueue<b> a;
    private final LinkedBlockingQueue<b> b;
    private int c = -1;
    private b d;
    private a e;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public interface a {
        void a(long j);
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class b {
        int a;
        long b;

        b() {
        }
    }

    public j(int i) {
        int i2 = i + 3;
        this.a = new LinkedBlockingQueue<>(i2);
        this.b = new LinkedBlockingQueue<>(i2);
    }

    private void a(int i) {
        GLES20.glActiveTexture(33984);
        GLES20.glDeleteTextures(1, new int[]{i}, 0);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0026  */
    /* JADX WARNING: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    private void g() {
        b bVar;
        InterruptedException e2;
        try {
            if (this.a.peek() != null) {
                bVar = this.a.take();
                try {
                    a aVar = this.e;
                    if (aVar != null) {
                        aVar.a(bVar.b);
                    }
                } catch (InterruptedException e3) {
                    e2 = e3;
                    e2.printStackTrace();
                    if (bVar != null) {
                    }
                }
            } else {
                bVar = null;
            }
        } catch (InterruptedException e4) {
            e2 = e4;
            bVar = null;
            e2.printStackTrace();
            if (bVar != null) {
            }
        }
        if (bVar != null) {
            b bVar2 = this.d;
            if (bVar2 != null) {
                if (bVar2.a != -1) {
                    b(bVar2);
                }
                this.d = null;
            }
            this.d = bVar;
        }
    }

    private void h() {
        com.youku.opengl.a.a.a("YkGLVideoFrameQueue", "clearFrameQueue");
        if (this.a.size() > 0) {
            while (true) {
                b poll = this.a.poll();
                if (poll == null) {
                    break;
                }
                a(poll.a);
            }
        }
        if (this.b.size() > 0) {
            while (true) {
                b poll2 = this.b.poll();
                if (poll2 != null) {
                    a(poll2.a);
                } else {
                    return;
                }
            }
        }
    }

    private void i() {
        if (this.c == -1) {
            int[] iArr = {0};
            GLES20.glGenFramebuffers(1, iArr, 0);
            this.c = iArr[0];
        }
    }

    private void j() {
        com.youku.opengl.a.a.a("YkGLVideoFrameQueue", "releaseFrameBuffer");
        int i = this.c;
        if (i != -1) {
            GLES20.glDeleteFramebuffers(1, new int[]{i}, 0);
            this.c = -1;
        }
    }

    public b a(long j) {
        if (this.d == null) {
            g();
        }
        b bVar = this.d;
        if (bVar != null && Math.abs(bVar.b - j) < 5) {
            return this.d;
        }
        while (true) {
            b peek = this.a.peek();
            if (peek == null) {
                break;
            } else if (Math.abs(peek.b - j) < 5) {
                g();
                break;
            } else if (peek.b > j) {
                break;
            } else {
                g();
            }
        }
        return this.d;
    }

    public void a() {
        i();
    }

    public void a(a aVar) {
        this.e = aVar;
    }

    public void a(b bVar) {
        if (bVar != null) {
            try {
                this.a.put(bVar);
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void b() {
        com.youku.opengl.a.a.a("YkGLVideoFrameQueue", "onDestroy begin");
        h();
        j();
        com.youku.opengl.a.a.a("YkGLVideoFrameQueue", "onDestroy end");
    }

    public void b(b bVar) {
        if (bVar != null) {
            try {
                this.b.put(bVar);
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
        }
    }

    public int c() {
        return this.c;
    }

    public int d() {
        return this.a.size();
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x0018  */
    public b e() {
        b bVar;
        if (this.b.peek() != null) {
            try {
                bVar = this.b.take();
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
            if (bVar == null) {
                bVar = new b();
                bVar.a = e.a(3553);
            }
            bVar.b = -1;
            return bVar;
        }
        bVar = null;
        if (bVar == null) {
        }
        bVar.b = -1;
        return bVar;
    }

    public b f() {
        return this.d;
    }
}
