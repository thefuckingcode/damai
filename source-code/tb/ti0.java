package tb;

import java.util.Map;
import kotlin.jvm.JvmOverloads;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class ti0 extends lf0 {
    @Nullable
    private final Map<String, Object> b;
    @NotNull
    private final String c;

    @JvmOverloads
    public ti0() {
        this(null, null, 3, null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ti0(Map map, String str, int i, m40 m40) {
        this((i & 1) != 0 ? null : map, (i & 2) != 0 ? "result" : str);
    }

    @Override // tb.lf0
    @Nullable
    public Map<String, Object> a() {
        return this.b;
    }

    @NotNull
    public String b() {
        return this.c;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ti0(@Nullable Map<String, ? extends Object> map, @NotNull String str) {
        super(map, str, null);
        k21.i(str, "type");
        this.b = map;
        this.c = str;
    }
}
