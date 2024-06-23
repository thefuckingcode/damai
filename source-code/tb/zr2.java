package tb;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class zr2 extends le0 {
    @NotNull
    private final String g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zr2(@NotNull String str, @NotNull TypeConstructor typeConstructor, @NotNull MemberScope memberScope, @NotNull List<? extends TypeProjection> list, boolean z) {
        super(typeConstructor, memberScope, list, z, null, 16, null);
        k21.i(str, "presentableName");
        k21.i(typeConstructor, "constructor");
        k21.i(memberScope, "memberScope");
        k21.i(list, "arguments");
        this.g = str;
    }

    @Override // tb.ib2, tb.le0
    @NotNull
    /* renamed from: j */
    public ib2 g(boolean z) {
        return new zr2(l(), c(), getMemberScope(), b(), z);
    }

    @Override // tb.le0
    @NotNull
    public String l() {
        return this.g;
    }

    @NotNull
    /* renamed from: n */
    public zr2 m(@NotNull i61 i61) {
        k21.i(i61, "kotlinTypeRefiner");
        return this;
    }
}
