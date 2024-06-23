package tb;

import android.graphics.Canvas;
import android.widget.ImageView;
import com.opensource.svgaplayer.SVGAVideoEntity;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public class n22 {
    @NotNull
    private final z32 a = new z32();
    @NotNull
    private final SVGAVideoEntity b;

    /* compiled from: Taobao */
    public final class a {
        @Nullable
        private final String a;
        @NotNull
        private final g32 b;

        public a(@Nullable n22 n22, @NotNull String str, g32 g32) {
            k21.j(g32, "frameEntity");
            this.a = str;
            this.b = g32;
        }

        @NotNull
        public final g32 a() {
            return this.b;
        }

        @Nullable
        public final String b() {
            return this.a;
        }
    }

    public n22(@NotNull SVGAVideoEntity sVGAVideoEntity) {
        k21.j(sVGAVideoEntity, "videoItem");
        this.b = sVGAVideoEntity;
    }

    public void a(@NotNull Canvas canvas, int i, @NotNull ImageView.ScaleType scaleType) {
        k21.j(canvas, "canvas");
        k21.j(scaleType, "scaleType");
        d(canvas, scaleType);
    }

    @NotNull
    public final z32 b() {
        return this.a;
    }

    @NotNull
    public final SVGAVideoEntity c() {
        return this.b;
    }

    public void d(@NotNull Canvas canvas, @NotNull ImageView.ScaleType scaleType) {
        k21.j(canvas, "canvas");
        k21.j(scaleType, "scaleType");
        this.a.g((float) canvas.getWidth(), (float) canvas.getHeight(), (float) this.b.h().b(), (float) this.b.h().a(), scaleType);
    }

    @NotNull
    public final List<a> e(int i) {
        List<f32> g = this.b.g();
        ArrayList arrayList = new ArrayList();
        for (T t : g) {
            a aVar = null;
            if (i >= 0 && i < t.a().size() && t.a().get(i).a() > 0.0d) {
                aVar = new a(this, t.b(), t.a().get(i));
            }
            if (aVar != null) {
                arrayList.add(aVar);
            }
        }
        return arrayList;
    }
}
