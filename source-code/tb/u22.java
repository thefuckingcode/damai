package tb;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.opensource.svgaplayer.SVGAVideoEntity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class u22 extends Drawable {
    private boolean a;
    private int b;
    @NotNull
    private ImageView.ScaleType c;
    private final t22 d;
    @NotNull
    private final SVGAVideoEntity e;
    @NotNull
    private final v22 f;

    public u22(@NotNull SVGAVideoEntity sVGAVideoEntity, @NotNull v22 v22) {
        k21.j(sVGAVideoEntity, "videoItem");
        k21.j(v22, "dynamicItem");
        this.e = sVGAVideoEntity;
        this.f = v22;
        this.a = true;
        this.c = ImageView.ScaleType.MATRIX;
        this.d = new t22(sVGAVideoEntity, v22);
    }

    public final int a() {
        return this.b;
    }

    @NotNull
    public final SVGAVideoEntity b() {
        return this.e;
    }

    public final void c(boolean z) {
        if (this.a != z) {
            this.a = z;
            invalidateSelf();
        }
    }

    public final void d(int i) {
        if (this.b != i) {
            this.b = i;
            invalidateSelf();
        }
    }

    public void draw(@Nullable Canvas canvas) {
        if (!this.a && canvas != null) {
            this.d.a(canvas, this.b, this.c);
        }
    }

    public final void e(@NotNull ImageView.ScaleType scaleType) {
        k21.j(scaleType, "<set-?>");
        this.c = scaleType;
    }

    public int getOpacity() {
        return -2;
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(@Nullable ColorFilter colorFilter) {
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public u22(@NotNull SVGAVideoEntity sVGAVideoEntity) {
        this(sVGAVideoEntity, new v22());
        k21.j(sVGAVideoEntity, "videoItem");
    }
}
