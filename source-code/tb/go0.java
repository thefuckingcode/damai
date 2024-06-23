package tb;

import android.graphics.Bitmap;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class go0 extends co0 {
    @NotNull
    private final Paint g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public go0(@NotNull Path path) {
        super(path);
        k21.i(path, "shadowPath");
        Paint paint = new Paint();
        paint.setDither(true);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        ur2 ur2 = ur2.INSTANCE;
        this.g = paint;
    }

    @Override // tb.mq0, tb.co0
    public void e(float f, int i, boolean z) {
        BlurMaskFilter.Blur blur;
        BlurMaskFilter blurMaskFilter;
        super.e(f, i, z);
        if (b()) {
            blur = BlurMaskFilter.Blur.INNER;
        } else {
            blur = BlurMaskFilter.Blur.NORMAL;
        }
        Paint paint = this.g;
        if (a() == 0.0f) {
            blurMaskFilter = null;
        } else {
            blurMaskFilter = new BlurMaskFilter(a(), blur);
        }
        paint.setMaskFilter(blurMaskFilter);
        this.g.setColor(i);
    }

    @Override // tb.co0
    public void k(@NotNull Bitmap bitmap) {
        k21.i(bitmap, "bitmap");
        Canvas canvas = new Canvas(bitmap);
        canvas.drawColor(0, PorterDuff.Mode.CLEAR);
        float f = (float) 2;
        canvas.translate(a() * f, a() * f);
        canvas.drawPath(c(), this.g);
    }
}
