package tb;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class tq0 extends br0 {
    @Nullable
    private String a;

    public tq0() {
    }

    @Override // tb.br0
    @Nullable
    public Object a() {
        return this.a;
    }

    @Nullable
    public final String b() {
        return this.a;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public tq0(@NotNull String str) {
        this();
        k21.i(str, "value");
        this.a = str;
    }
}
