package tb;

import com.taobao.weex.ui.component.richtext.node.RichTextNode;
import java.util.ArrayList;
import java.util.List;
import kotlin.Pair;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class r61 {
    @NotNull
    public static final a Companion = new a(null);
    private float a;
    private float b;
    private final float c;
    private final float d;
    @NotNull
    private final List<r61> e;
    @NotNull
    private String f;
    @NotNull
    private String g;

    /* compiled from: Taobao */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }

        @NotNull
        public final Pair<Integer, r61> a(@NotNull float[] fArr, int i) {
            k21.i(fArr, "args");
            int i2 = i + 1;
            float f = fArr[i];
            int i3 = i2 + 1;
            float f2 = fArr[i2];
            int i4 = i3 + 1;
            float f3 = fArr[i3];
            int i5 = i4 + 1;
            float f4 = fArr[i4];
            int i6 = i5 + 1;
            int i7 = (int) fArr[i5];
            ArrayList arrayList = new ArrayList();
            if (i7 > 0) {
                int i8 = 0;
                do {
                    i8++;
                    Pair<Integer, r61> a = r61.Companion.a(fArr, i6);
                    int intValue = a.getFirst().intValue();
                    arrayList.add(a.getSecond());
                    i6 = intValue;
                } while (i8 < i7);
            }
            return new Pair<>(Integer.valueOf(i6), new r61(f, f2, f3, f4, arrayList, null, null, 96, null));
        }
    }

    public r61(float f2, float f3, float f4, float f5, @NotNull List<r61> list, @NotNull String str, @NotNull String str2) {
        k21.i(list, RichTextNode.CHILDREN);
        k21.i(str, "id");
        k21.i(str2, "idPath");
        this.a = f2;
        this.b = f3;
        this.c = f4;
        this.d = f5;
        this.e = list;
        this.f = str;
        this.g = str2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: tb.r61 */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ r61 b(r61 r61, float f2, float f3, float f4, float f5, List list, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            f2 = r61.a;
        }
        if ((i & 2) != 0) {
            f3 = r61.b;
        }
        if ((i & 4) != 0) {
            f4 = r61.c;
        }
        if ((i & 8) != 0) {
            f5 = r61.d;
        }
        if ((i & 16) != 0) {
            list = r61.e;
        }
        if ((i & 32) != 0) {
            str = r61.f;
        }
        if ((i & 64) != 0) {
            str2 = r61.g;
        }
        return r61.a(f2, f3, f4, f5, list, str, str2);
    }

    @NotNull
    public final r61 a(float f2, float f3, float f4, float f5, @NotNull List<r61> list, @NotNull String str, @NotNull String str2) {
        k21.i(list, RichTextNode.CHILDREN);
        k21.i(str, "id");
        k21.i(str2, "idPath");
        return new r61(f2, f3, f4, f5, list, str, str2);
    }

    @NotNull
    public final List<r61> c() {
        return this.e;
    }

    public final float d() {
        return this.d;
    }

    public final float e() {
        return this.c;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof r61)) {
            return false;
        }
        r61 r61 = (r61) obj;
        return k21.d(Float.valueOf(this.a), Float.valueOf(r61.a)) && k21.d(Float.valueOf(this.b), Float.valueOf(r61.b)) && k21.d(Float.valueOf(this.c), Float.valueOf(r61.c)) && k21.d(Float.valueOf(this.d), Float.valueOf(r61.d)) && k21.d(this.e, r61.e) && k21.d(this.f, r61.f) && k21.d(this.g, r61.g);
    }

    public final float f() {
        return this.a;
    }

    public final float g() {
        return this.b;
    }

    public final void h(@NotNull String str) {
        k21.i(str, "<set-?>");
        this.f = str;
    }

    public int hashCode() {
        return (((((((((((Float.floatToIntBits(this.a) * 31) + Float.floatToIntBits(this.b)) * 31) + Float.floatToIntBits(this.c)) * 31) + Float.floatToIntBits(this.d)) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode();
    }

    public final void i(@NotNull String str) {
        k21.i(str, "<set-?>");
        this.g = str;
    }

    public final void j(float f2) {
        this.a = f2;
    }

    public final void k(float f2) {
        this.b = f2;
    }

    @NotNull
    public String toString() {
        return "Layout(x=" + this.a + ", y=" + this.b + ", width=" + this.c + ", height=" + this.d + ", id='" + this.f + "' idPath='" + this.g + "')";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ r61(float f2, float f3, float f4, float f5, List list, String str, String str2, int i, m40 m40) {
        this(f2, f3, f4, f5, list, (i & 32) != 0 ? "" : str, (i & 64) != 0 ? "" : str2);
    }
}
