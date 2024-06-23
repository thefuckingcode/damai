package com.taobao.phenix.animate;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.taobao.pexode.animate.AnimatedImage;
import com.taobao.rxm.schedule.SchedulerSupplier;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import tb.h50;
import tb.jl1;
import tb.so1;
import tb.tp1;
import tb.vr2;

/* compiled from: Taobao */
public class AnimatedImageDrawable extends so1 {
    private static SchedulerSupplier F;
    private boolean A;
    private int[] B;
    private int C;
    private int D;
    private final Handler E = new Handler(Looper.getMainLooper());
    private final int g;
    private final int h;
    private int i;
    private Bitmap j;
    private int[] k;
    private AnimatedLoopListener l;
    private final Runnable m = new WeakFrameTask(this, 0);
    private final Runnable n = new WeakFrameTask(this, 1);
    private final Runnable o = new WeakFrameTask(this, 2);
    private final Runnable p = new WeakFrameTask(this, 3);
    private final int q;
    private final int r;
    private boolean s;
    private boolean t;
    private long u;
    private long v;
    private int w;
    private int x;
    private int y;
    private AnimatedFramesBuffer z;

    /* compiled from: Taobao */
    private static class WeakFrameTask implements Runnable {
        public static final int INVALIDATE_TYPE = 2;
        public static final int NEXT_TYPE = 1;
        public static final int START_TYPE = 0;
        public static final int TIMEOUT_FOR_DRAW_TYPE = 3;
        private WeakReference<AnimatedImageDrawable> drawableRef;
        private int type;

        public WeakFrameTask(AnimatedImageDrawable animatedImageDrawable, int i) {
            this.drawableRef = new WeakReference<>(animatedImageDrawable);
            this.type = i;
        }

        public void run() {
            AnimatedImageDrawable animatedImageDrawable = this.drawableRef.get();
            if (animatedImageDrawable != null) {
                int i = this.type;
                if (i == 0) {
                    animatedImageDrawable.r();
                } else if (i == 1) {
                    animatedImageDrawable.q();
                } else if (i == 2) {
                    animatedImageDrawable.n();
                } else if (i == 3) {
                    animatedImageDrawable.s();
                }
            }
        }
    }

    public AnimatedImageDrawable(String str, String str2, int i2, int i3, AnimatedImage animatedImage) {
        super(str, str2, i2, i3);
        this.g = animatedImage.getWidth();
        this.h = animatedImage.getHeight();
        this.k = animatedImage.getFrameDurations();
        this.i = animatedImage.getLoopCount();
        this.q = animatedImage.getFrameCount();
        this.C = 0;
        this.D = 0;
        this.v = -1;
        this.A = true;
        this.t = true;
        this.r = k();
        SchedulerSupplier n2 = tp1.o().n();
        if (n2 == null) {
            synchronized (AnimatedImageDrawable.class) {
                if (F == null) {
                    F = new h50(null, 0, 3, 8, 5, 1500, 3, 0, 0);
                }
            }
            n2 = F;
        }
        this.z = new AnimatedFramesBuffer(animatedImage, n2.forDecode(), toString());
    }

    private int k() {
        this.B = new int[this.q];
        int i2 = 0;
        for (int i3 = 0; i3 < this.q; i3++) {
            int[] iArr = this.k;
            if (iArr[i3] < 11) {
                iArr[i3] = 100;
            }
            this.B[i3] = i2;
            i2 += iArr[i3];
        }
        return i2;
    }

    private void l(boolean z2, boolean z3) {
        if (this.r != 0) {
            long uptimeMillis = SystemClock.uptimeMillis();
            long j2 = uptimeMillis - this.u;
            int i2 = this.r;
            int i3 = (int) (j2 / ((long) i2));
            int i4 = (int) (j2 % ((long) i2));
            int o2 = o(i4);
            boolean z4 = this.w != o2;
            this.w = o2;
            int i5 = this.q;
            this.x = (i3 * i5) + o2;
            if (z2) {
                if (z4) {
                    vr2.a("AnimatedImage", "%s schedule next frame changed to %d, drawing=%b, now=%d", this, Integer.valueOf(o2), Boolean.valueOf(z3), Long.valueOf(uptimeMillis));
                    n();
                    return;
                }
                int i6 = (o2 + 1) % i5;
                long j3 = ((long) ((this.B[o2] + this.k[o2]) - i4)) + uptimeMillis + 10;
                long j4 = this.v;
                if (j4 == -1 || j4 > j3) {
                    vr2.a("AnimatedImage", "%s schedule next frame=%d at %d[last:%d], drawing=%b, now=%d", this, Integer.valueOf(i6), Long.valueOf(j3), Long.valueOf(this.v), Boolean.valueOf(z3), Long.valueOf(uptimeMillis));
                    unscheduleSelf(this.n);
                    scheduleSelf(this.n, j3);
                    this.v = j3;
                }
            }
        }
    }

    private void m() {
        this.D = 0;
        this.z.b();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void n() {
        this.A = true;
        this.E.removeCallbacks(this.p);
        this.E.postDelayed(this.p, 1000);
        invalidateSelf();
    }

    private int o(int i2) {
        int binarySearch = Arrays.binarySearch(this.B, i2);
        return binarySearch < 0 ? ((-binarySearch) - 1) - 1 : binarySearch;
    }

    private boolean y(int i2, int i3) {
        Bitmap d = this.z.d(i2);
        if (d == null) {
            return false;
        }
        Bitmap bitmap = this.j;
        if (bitmap != null) {
            this.z.c(bitmap);
        }
        this.j = d;
        int i4 = this.y;
        if (i3 - i4 > 1) {
            vr2.i("AnimatedImage", "%s dropped %d frames", this, Integer.valueOf((i3 - i4) - 1));
        }
        this.y = i3;
        return true;
    }

    public void draw(Canvas canvas) {
        int i2;
        Runnable runnable;
        int i3;
        AnimatedLoopListener animatedLoopListener;
        vr2.a("AnimatedImage", "%s start to draw, waiting=%b, playing=%b", this, Boolean.valueOf(this.A), Boolean.valueOf(this.t));
        this.E.removeCallbacks(this.p);
        if (this.A && (this.t || this.j == null)) {
            this.A = false;
            try {
                if (this.C >= 0) {
                    this.u = SystemClock.uptimeMillis() - ((long) this.B[this.C]);
                }
                l(false, true);
                int i4 = this.w;
                int i5 = this.x;
                int i6 = this.y;
                boolean y2 = y(i4, i5);
                vr2.a("AnimatedImage", "%s drew frame=%d|%d, success=%B", this, Integer.valueOf(i4), Integer.valueOf(i5), Boolean.valueOf(y2));
                if (y2) {
                    boolean z2 = this.C == i4;
                    if (z2) {
                        this.C = -1;
                    }
                    int i7 = this.D;
                    int i8 = this.q;
                    int i9 = ((i5 + 1) / i8) + i7;
                    boolean z3 = i9 != ((i6 + 1) / i8) + i7;
                    if (((!(z2 && i7 == 0 && i5 == 0) && !z3) || (animatedLoopListener = this.l) == null || animatedLoopListener.onLoopCompleted(i9, this.i)) && (!z3 || (i3 = this.i) == 0 || i9 < i3)) {
                        l(true, true);
                    } else {
                        this.t = false;
                    }
                    if (!this.t) {
                        m();
                    }
                }
                boolean z4 = this.t;
                if (z4 || this.j == null) {
                    if (y2) {
                        runnable = null;
                        i2 = 1;
                    } else {
                        runnable = this.o;
                        i2 = 0;
                    }
                    if (z4) {
                        this.z.j((i4 + i2) % this.q, runnable);
                    } else {
                        this.z.i((i4 + i2) % this.q, 1, runnable);
                    }
                }
            } catch (Throwable th) {
                vr2.c("AnimatedImage", "%s frame render error=%s", this, th);
            }
        }
        Bitmap bitmap = this.j;
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, (Rect) null, getBounds(), (Paint) null);
        }
    }

    public int getIntrinsicHeight() {
        return this.h;
    }

    public int getIntrinsicWidth() {
        return this.g;
    }

    public int getOpacity() {
        return -3;
    }

    public boolean p() {
        return this.t;
    }

    /* access modifiers changed from: package-private */
    public void q() {
        this.v = -1;
        if (this.t && this.r != 0 && this.q > 1) {
            l(true, false);
        }
    }

    /* access modifiers changed from: package-private */
    public void r() {
        if (this.t) {
            if (this.s) {
                this.C = this.w;
            } else {
                this.w = 0;
                this.x = 0;
                this.C = 0;
            }
            n();
        }
    }

    /* access modifiers changed from: package-private */
    public void s() {
        unscheduleSelf(this.n);
        this.v = -1;
        this.C = 0;
        this.y = 0;
        this.j = null;
        m();
        vr2.a("AnimatedImage", "%s timeout for draw, maybe terminate", this);
    }

    public void setAlpha(int i2) {
        invalidateSelf();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        invalidateSelf();
    }

    public void t(boolean z2) {
        this.s = true;
        this.t = false;
        if (z2) {
            this.z.b();
        }
        this.D += (this.x + 1) / this.q;
    }

    @Override // tb.so1
    public String toString() {
        return "AnimatedImageDrawable(" + Integer.toHexString(hashCode()) + ", key@" + e() + jl1.BRACKET_END_STR;
    }

    public void u(AnimatedLoopListener animatedLoopListener) {
        this.l = animatedLoopListener;
    }

    public void v(int i2) {
        this.i = i2;
    }

    public void w() {
        if (this.r != 0 && this.q > 1) {
            this.t = true;
            scheduleSelf(this.m, SystemClock.uptimeMillis());
        }
    }

    public void x() {
        this.s = false;
        this.t = false;
        m();
    }
}
