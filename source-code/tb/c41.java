package tb;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.pw2;

/* compiled from: Taobao */
public final class c41 extends qw2 {
    @NotNull
    public static final c41 INSTANCE = new c41();

    private c41() {
        super("package", false);
    }

    @Override // tb.qw2
    @Nullable
    public Integer a(@NotNull qw2 qw2) {
        k21.i(qw2, "visibility");
        if (this == qw2) {
            return 0;
        }
        if (pw2.INSTANCE.b(qw2)) {
            return 1;
        }
        return -1;
    }

    @Override // tb.qw2
    @NotNull
    public String b() {
        return "public/*package*/";
    }

    @Override // tb.qw2
    @NotNull
    public qw2 d() {
        return pw2.g.INSTANCE;
    }
}
