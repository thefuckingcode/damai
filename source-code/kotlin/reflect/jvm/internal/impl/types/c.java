package kotlin.reflect.jvm.internal.impl.types;

import org.jetbrains.annotations.NotNull;
import tb.ib2;
import tb.k21;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class c extends b {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(@NotNull ib2 ib2) {
        super(ib2);
        k21.i(ib2, "delegate");
    }

    @Override // tb.r50, tb.g61
    public boolean d() {
        return false;
    }

    @NotNull
    /* renamed from: p */
    public c n(@NotNull ib2 ib2) {
        k21.i(ib2, "delegate");
        return new c(ib2);
    }
}
