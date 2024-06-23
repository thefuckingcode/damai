package tb;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.pw2;

/* compiled from: Taobao */
public final class d41 extends qw2 {
    @NotNull
    public static final d41 INSTANCE = new d41();

    private d41() {
        super("protected_and_package", true);
    }

    @Override // tb.qw2
    @Nullable
    public Integer a(@NotNull qw2 qw2) {
        k21.i(qw2, "visibility");
        if (k21.d(this, qw2)) {
            return 0;
        }
        if (qw2 == pw2.b.INSTANCE) {
            return null;
        }
        return Integer.valueOf(pw2.INSTANCE.b(qw2) ? 1 : -1);
    }

    @Override // tb.qw2
    @NotNull
    public String b() {
        return "protected/*protected and package*/";
    }

    @Override // tb.qw2
    @NotNull
    public qw2 d() {
        return pw2.g.INSTANCE;
    }
}
