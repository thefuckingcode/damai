package com.taobao.phenix.animate;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import com.taobao.pexode.animate.AnimatedDrawableFrameInfo;
import com.taobao.pexode.animate.AnimatedImage;
import com.taobao.pexode.animate.AnimatedImageFrame;
import com.taobao.phenix.bitmap.b;

/* compiled from: Taobao */
public class AnimatedFrameCompositor {
    private final AnimatedImage a;
    private final int b;
    private final int c;
    private final AnimatedFramesBuffer d;
    private final Paint e;
    private final AnimatedDrawableFrameInfo[] f;
    private Bitmap g;
    private String h;

    /* compiled from: Taobao */
    public interface Callback {
        Bitmap getCachedBitmap(int i);

        void onIntermediateResult(int i, Bitmap bitmap);
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public enum CompositedFrameRenderingType {
        REQUIRED,
        NOT_REQUIRED,
        SKIP,
        ABORT
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            int[] iArr = new int[CompositedFrameRenderingType.values().length];
            a = iArr;
            iArr[CompositedFrameRenderingType.REQUIRED.ordinal()] = 1;
            a[CompositedFrameRenderingType.NOT_REQUIRED.ordinal()] = 2;
            a[CompositedFrameRenderingType.ABORT.ordinal()] = 3;
            try {
                a[CompositedFrameRenderingType.SKIP.ordinal()] = 4;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* JADX INFO: finally extract failed */
    public AnimatedFrameCompositor(AnimatedImage animatedImage, AnimatedFramesBuffer animatedFramesBuffer, String str) {
        this.a = animatedImage;
        this.h = str;
        this.b = animatedImage.getWidth();
        this.c = animatedImage.getHeight();
        this.d = animatedFramesBuffer;
        Paint paint = new Paint();
        this.e = paint;
        paint.setColor(0);
        paint.setStyle(Paint.Style.FILL);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        this.f = new AnimatedDrawableFrameInfo[animatedImage.getFrameCount()];
        for (int i = 0; i < this.a.getFrameCount(); i++) {
            AnimatedImageFrame frame = this.a.getFrame(i);
            try {
                this.f[i] = frame.getFrameInfo();
                frame.dispose();
            } catch (Throwable th) {
                frame.dispose();
                throw th;
            }
        }
    }

    private void a(Canvas canvas, AnimatedDrawableFrameInfo animatedDrawableFrameInfo) {
        int i = animatedDrawableFrameInfo.a;
        int i2 = animatedDrawableFrameInfo.b;
        canvas.drawRect((float) i, (float) i2, (float) (i + animatedDrawableFrameInfo.c), (float) (i2 + animatedDrawableFrameInfo.d), this.e);
    }

    private void c() {
        Bitmap bitmap = this.g;
        if (bitmap == null) {
            this.g = b.a().get(this.b, this.c, Bitmap.Config.ARGB_8888);
        } else {
            bitmap.eraseColor(0);
        }
    }

    private CompositedFrameRenderingType d(int i) {
        AnimatedDrawableFrameInfo animatedDrawableFrameInfo = this.f[i];
        AnimatedDrawableFrameInfo.DisposalMode disposalMode = animatedDrawableFrameInfo.e;
        if (disposalMode == AnimatedDrawableFrameInfo.DisposalMode.DISPOSE_DO_NOT) {
            return CompositedFrameRenderingType.REQUIRED;
        }
        if (disposalMode == AnimatedDrawableFrameInfo.DisposalMode.DISPOSE_TO_BACKGROUND) {
            if (f(animatedDrawableFrameInfo)) {
                return CompositedFrameRenderingType.NOT_REQUIRED;
            }
            return CompositedFrameRenderingType.REQUIRED;
        } else if (disposalMode == AnimatedDrawableFrameInfo.DisposalMode.DISPOSE_TO_PREVIOUS) {
            return CompositedFrameRenderingType.SKIP;
        } else {
            return CompositedFrameRenderingType.ABORT;
        }
    }

    private boolean f(AnimatedDrawableFrameInfo animatedDrawableFrameInfo) {
        return animatedDrawableFrameInfo.a == 0 && animatedDrawableFrameInfo.b == 0 && animatedDrawableFrameInfo.c == this.b && animatedDrawableFrameInfo.d == this.c;
    }

    private boolean g(int i) {
        if (i == 0) {
            return true;
        }
        AnimatedDrawableFrameInfo[] animatedDrawableFrameInfoArr = this.f;
        AnimatedDrawableFrameInfo animatedDrawableFrameInfo = animatedDrawableFrameInfoArr[i];
        AnimatedDrawableFrameInfo animatedDrawableFrameInfo2 = animatedDrawableFrameInfoArr[i - 1];
        if (animatedDrawableFrameInfo.f == AnimatedDrawableFrameInfo.BlendMode.NO_BLEND && f(animatedDrawableFrameInfo)) {
            return true;
        }
        if (animatedDrawableFrameInfo2.e != AnimatedDrawableFrameInfo.DisposalMode.DISPOSE_TO_BACKGROUND || !f(animatedDrawableFrameInfo2)) {
            return false;
        }
        return true;
    }

    private int h(int i, Canvas canvas) {
        while (i >= 0) {
            int i2 = a.a[d(i).ordinal()];
            if (i2 == 1) {
                AnimatedDrawableFrameInfo animatedDrawableFrameInfo = this.f[i];
                Bitmap d2 = this.d.d(i);
                if (d2 != null) {
                    canvas.drawBitmap(d2, 0.0f, 0.0f, (Paint) null);
                    this.d.c(d2);
                    if (animatedDrawableFrameInfo.e == AnimatedDrawableFrameInfo.DisposalMode.DISPOSE_TO_BACKGROUND) {
                        a(canvas, animatedDrawableFrameInfo);
                    }
                    return i + 1;
                } else if (g(i)) {
                    return i;
                }
            } else if (i2 == 2) {
                return i + 1;
            } else {
                if (i2 == 3) {
                    return i;
                }
            }
            i--;
        }
        return 0;
    }

    private void j(int i, Canvas canvas) {
        AnimatedImageFrame frame = this.a.getFrame(i);
        try {
            synchronized (this) {
                c();
                frame.renderFrame(frame.getWidth(), frame.getHeight(), this.g);
                canvas.save();
                canvas.translate((float) frame.getXOffset(), (float) frame.getYOffset());
                canvas.drawBitmap(this.g, 0.0f, 0.0f, (Paint) null);
                canvas.restore();
            }
        } catch (Throwable th) {
            frame.dispose();
            throw th;
        }
        frame.dispose();
    }

    public synchronized void b() {
        this.g = null;
    }

    public AnimatedDrawableFrameInfo e(int i) {
        return this.f[i];
    }

    public void i(int i, Bitmap bitmap) {
        int i2;
        Canvas canvas = new Canvas(bitmap);
        canvas.drawColor(0, PorterDuff.Mode.SRC);
        if (g(i)) {
            i2 = i;
        } else {
            i2 = h(i - 1, canvas);
        }
        while (i2 < i) {
            AnimatedDrawableFrameInfo animatedDrawableFrameInfo = this.f[i2];
            AnimatedDrawableFrameInfo.DisposalMode disposalMode = animatedDrawableFrameInfo.e;
            if (disposalMode != AnimatedDrawableFrameInfo.DisposalMode.DISPOSE_TO_PREVIOUS) {
                if (animatedDrawableFrameInfo.f == AnimatedDrawableFrameInfo.BlendMode.NO_BLEND) {
                    a(canvas, animatedDrawableFrameInfo);
                }
                j(i2, canvas);
                if (disposalMode == AnimatedDrawableFrameInfo.DisposalMode.DISPOSE_TO_BACKGROUND) {
                    a(canvas, animatedDrawableFrameInfo);
                }
            }
            i2++;
        }
        AnimatedDrawableFrameInfo animatedDrawableFrameInfo2 = this.f[i];
        if (animatedDrawableFrameInfo2.f == AnimatedDrawableFrameInfo.BlendMode.NO_BLEND) {
            a(canvas, animatedDrawableFrameInfo2);
        }
        j(i, canvas);
    }
}
