package tb;

import java.util.Map;
import kotlin.jvm.JvmOverloads;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class je0 extends lf0 {
    @NotNull
    private final String b;
    @NotNull
    private final String c;
    @Nullable
    private final Map<String, Object> d;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ je0(String str, String str2, Map map, int i, m40 m40) {
        this(str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? null : map);
    }

    @Override // tb.lf0
    @Nullable
    public Map<String, Object> a() {
        return this.d;
    }

    @NotNull
    public final String b() {
        return this.b;
    }

    @NotNull
    public final String c() {
        return this.c;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public je0(@NotNull String str, @NotNull String str2, @Nullable Map<String, ? extends Object> map) {
        super(map, null, 2, null);
        k21.i(str, "code");
        k21.i(str2, "msg");
        this.b = str;
        this.c = str2;
        this.d = map;
    }
}
