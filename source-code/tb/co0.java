package tb;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import androidx.annotation.CallSuper;
import com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public abstract class co0 extends mq0 {
    @Nullable
    private Bitmap e;
    private boolean f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public co0(@NotNull Path path) {
        super(path);
        k21.i(path, "shadowPath");
    }

    private final void i() {
        float f2 = (float) 4;
        int width = (int) (((float) Rect.width(getBounds())) + (a() * f2));
        int height = (int) (((float) Rect.height(getBounds())) + (a() * f2));
        Bitmap bitmap = this.e;
        if (bitmap == null || bitmap.getWidth() < width || bitmap.getHeight() < height) {
            if (bitmap != null) {
                bitmap.recycle();
            }
            this.e = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            d();
        }
    }

    private final void j(Bitmap bitmap) {
        if (!this.f) {
            k(bitmap);
            this.f = true;
        }
    }

    @Override // tb.mq0
    public void d() {
        this.f = false;
    }

    public final void draw(@NotNull Canvas canvas) {
        k21.i(canvas, "canvas");
        i();
        Bitmap bitmap = this.e;
        if (bitmap != null) {
            j(bitmap);
            float f2 = (float) 2;
            canvas.drawBitmap(bitmap, (-a()) * f2, (-a()) * f2, (Paint) null);
        }
    }

    @Override // tb.mq0
    @CallSuper
    public void e(float f2, int i, boolean z) {
        d();
    }

    @Override // tb.mq0
    @CallSuper
    public void f(float f2) {
        super.f(f2);
        d();
    }

    public abstract void k(@NotNull Bitmap bitmap);

    /* access modifiers changed from: protected */
    @CallSuper
    public void onBoundsChange(@NotNull android.graphics.Rect rect) {
        k21.i(rect, "bounds");
        super.onBoundsChange(rect);
        d();
    }
}
