package tb;

import java.util.List;
import kotlin.collections.m;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class es1 {
    @Nullable
    private final no2 a;
    @NotNull
    private final List<no2> b;

    public es1() {
        this(null, null, 3, null);
    }

    public es1(@Nullable no2 no2, @NotNull List<no2> list) {
        k21.i(list, "parametersInfo");
        this.a = no2;
        this.b = list;
    }

    @NotNull
    public final List<no2> a() {
        return this.b;
    }

    @Nullable
    public final no2 b() {
        return this.a;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ es1(no2 no2, List list, int i, m40 m40) {
        this((i & 1) != 0 ? null : no2, (i & 2) != 0 ? m.g() : list);
    }
}
