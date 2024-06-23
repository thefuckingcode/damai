package com.taobao.phenix.animate;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.taobao.windvane.connect.HttpRequest;
import android.util.SparseArray;
import com.taobao.pexode.Pexode;
import com.taobao.pexode.animate.AnimatedDrawableFrameInfo;
import com.taobao.pexode.animate.AnimatedImage;
import com.taobao.rxm.consume.Consumer;
import com.taobao.rxm.schedule.ScheduledAction;
import com.taobao.rxm.schedule.Scheduler;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import tb.a8;
import tb.cs1;
import tb.d42;
import tb.vr2;

/* compiled from: Taobao */
public class AnimatedFramesBuffer {
    private final int a;
    private final int b;
    private final int c;
    private final int d;
    private final int e;
    private final Handler f = new Handler(Looper.getMainLooper());
    private boolean g;
    private final Scheduler h;
    private final SparseArray<a> i;
    private List<Bitmap> j;
    private AnimatedFrameCompositor k;
    private String l;
    private SparseArray<Runnable> m;
    private final ScheduledAction n = new WeakDecodeAction(this);

    /* compiled from: Taobao */
    private static class WeakDecodeAction extends ScheduledAction {
        private WeakReference<AnimatedFramesBuffer> frameBufferRef;

        public WeakDecodeAction(AnimatedFramesBuffer animatedFramesBuffer) {
            super(1, null, null, false);
            this.frameBufferRef = new WeakReference<>(animatedFramesBuffer);
        }

        @Override // com.taobao.rxm.schedule.ScheduledAction
        public void run(Consumer consumer, d42 d42) {
            AnimatedFramesBuffer animatedFramesBuffer = this.frameBufferRef.get();
            if (animatedFramesBuffer != null) {
                animatedFramesBuffer.g();
            }
        }
    }

    /* compiled from: Taobao */
    public static class a {
        private Bitmap a;
        private int b = 0;

        public a(Bitmap bitmap) {
            this.a = bitmap;
        }

        static /* synthetic */ int b(a aVar) {
            int i = aVar.b;
            aVar.b = i + 1;
            return i;
        }

        static /* synthetic */ int c(a aVar) {
            int i = aVar.b;
            aVar.b = i - 1;
            return i;
        }
    }

    public AnimatedFramesBuffer(AnimatedImage animatedImage, Scheduler scheduler, String str) {
        this.l = str;
        int width = animatedImage.getWidth();
        this.a = width;
        int height = animatedImage.getHeight();
        this.b = height;
        this.c = animatedImage.getFrameCount();
        int min = Math.min(6, Math.max(1, HttpRequest.DEFAULT_MAX_LENGTH / ((width * height) * 4)));
        this.d = min;
        int min2 = Math.min(3, Math.max(1, 2097152 / ((width * height) * 4)));
        this.e = min2;
        this.h = scheduler;
        this.i = new SparseArray<>(min);
        this.j = new ArrayList(min2);
        this.m = new SparseArray<>(min);
        this.k = new AnimatedFrameCompositor(animatedImage, this, str);
    }

    private boolean e(int i2, int i3, int i4) {
        return (i3 > i2 && i4 >= i2 && i4 < i3) || (i3 <= i2 && (i4 >= i2 || i4 < i3));
    }

    private a f(int i2) {
        Bitmap remove;
        synchronized (this) {
            remove = this.j.size() > 0 ? this.j.remove(0) : null;
        }
        if (remove == null && Pexode.j()) {
            remove = a8.a().newBitmapWithPin(this.a, this.b, Bitmap.Config.ARGB_8888);
        }
        if (remove == null) {
            remove = Bitmap.createBitmap(this.a, this.b, Bitmap.Config.ARGB_8888);
        }
        this.k.i(i2, remove);
        return new a(remove);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0029, code lost:
        if (r4.i.get(r0) != null) goto L_0x002c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002b, code lost:
        r1 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002c, code lost:
        monitor-exit(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002d, code lost:
        if (r1 == false) goto L_0x003e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002f, code lost:
        r1 = f(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0033, code lost:
        monitor-enter(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        r4.i.put(r0, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0039, code lost:
        monitor-exit(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x003e, code lost:
        if (r2 == null) goto L_0x0000;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0040, code lost:
        r4.f.post(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0022, code lost:
        monitor-enter(r4);
     */
    private void g() {
        while (true) {
            synchronized (this) {
                boolean z = false;
                if (this.m.size() <= 0) {
                    this.g = false;
                    return;
                }
                int keyAt = this.m.keyAt(0);
                Runnable valueAt = this.m.valueAt(0);
                this.m.removeAt(0);
            }
        }
    }

    private void h(Bitmap bitmap) {
        if (this.j.size() < this.e && bitmap != null && bitmap.isMutable() && bitmap.getWidth() == this.a && bitmap.getHeight() == this.b && !this.j.contains(bitmap)) {
            this.j.add(bitmap);
        }
    }

    public synchronized void b() {
        this.k.b();
        this.m.clear();
        this.i.clear();
        this.j.clear();
        vr2.a("AnimatedImage", "%s dropped frame caches", this.l);
    }

    public synchronized void c(Bitmap bitmap) {
        int size = this.i.size();
        int i2 = 0;
        while (true) {
            if (i2 < size) {
                a valueAt = this.i.valueAt(i2);
                if (valueAt != null && valueAt.a == bitmap) {
                    a.c(valueAt);
                    break;
                }
                i2++;
            } else {
                break;
            }
        }
        if (i2 == size) {
            h(bitmap);
        }
    }

    public synchronized Bitmap d(int i2) {
        a aVar = this.i.get(i2);
        if (aVar == null) {
            return null;
        }
        a.b(aVar);
        return aVar.a;
    }

    public synchronized void i(int i2, int i3, Runnable runnable) {
        cs1.a(i2 >= 0);
        cs1.a(i3 > 0);
        int i4 = this.d;
        if (i3 > i4) {
            i3 = i4;
        }
        int max = this.k.e(i2).e == AnimatedDrawableFrameInfo.DisposalMode.DISPOSE_TO_PREVIOUS ? Math.max(0, i2 - 1) : i2;
        int i5 = max;
        while (true) {
            if (i5 < 0) {
                i5 = -1;
                break;
            } else if (this.i.get(i5) != null) {
                break;
            } else {
                i5--;
            }
        }
        int i6 = (max + i3) % this.c;
        int i7 = 0;
        while (i7 < this.i.size()) {
            int keyAt = this.i.keyAt(i7);
            if (keyAt != i5) {
                if (!e(max, i6, keyAt)) {
                    a valueAt = this.i.valueAt(i7);
                    this.i.removeAt(i7);
                    if (valueAt != null && valueAt.b <= 0) {
                        h(valueAt.a);
                    }
                }
            }
            i7++;
        }
        int i8 = 0;
        while (i8 < this.m.size()) {
            if (e(max, i3, this.m.keyAt(i8))) {
                i8++;
            } else {
                this.m.removeAt(i8);
            }
        }
        for (int i9 = 0; i9 < i3; i9++) {
            int i10 = (max + i9) % this.c;
            if (this.i.get(i10) != null) {
                if (i2 == i10) {
                    this.f.post(runnable);
                }
            } else if (i2 == i10) {
                this.m.put(i10, runnable);
            } else {
                this.m.put(i10, null);
            }
        }
        if (!this.g) {
            this.g = true;
            this.h.schedule(this.n);
        }
    }

    public void j(int i2, Runnable runnable) {
        i(i2, this.d, runnable);
    }
}
