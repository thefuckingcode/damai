package tb;

import org.jetbrains.annotations.NotNull;
import tb.pw2;

/* compiled from: Taobao */
public final class e41 extends qw2 {
    @NotNull
    public static final e41 INSTANCE = new e41();

    private e41() {
        super("protected_static", true);
    }

    @Override // tb.qw2
    @NotNull
    public String b() {
        return "protected/*protected static*/";
    }

    @Override // tb.qw2
    @NotNull
    public qw2 d() {
        return pw2.g.INSTANCE;
    }
}
