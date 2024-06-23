package tb;

import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class ho0 extends mq0 {
    @NotNull
    private final Paint e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ho0(@NotNull Path path) {
        super(path);
        k21.i(path, "shadowPath");
        Paint paint = new Paint();
        paint.setDither(true);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        ur2 ur2 = ur2.INSTANCE;
        this.e = paint;
    }

    public void draw(@NotNull Canvas canvas) {
        k21.i(canvas, "canvas");
        canvas.drawPath(c(), this.e);
    }

    @Override // tb.mq0
    public void e(float f, int i, boolean z) {
        BlurMaskFilter.Blur blur;
        if (b()) {
            blur = BlurMaskFilter.Blur.INNER;
        } else {
            blur = BlurMaskFilter.Blur.NORMAL;
        }
        this.e.setMaskFilter((a() > 0.0f ? 1 : (a() == 0.0f ? 0 : -1)) == 0 ? null : new BlurMaskFilter(a(), blur));
        this.e.setColor(i);
    }
}
