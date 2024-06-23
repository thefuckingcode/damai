package tb;

import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.m;
import kotlin.jvm.JvmOverloads;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public class le0 extends ib2 {
    @NotNull
    private final TypeConstructor b;
    @NotNull
    private final MemberScope c;
    @NotNull
    private final List<TypeProjection> d;
    private final boolean e;
    @NotNull
    private final String f;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public le0(@NotNull TypeConstructor typeConstructor, @NotNull MemberScope memberScope) {
        this(typeConstructor, memberScope, null, false, null, 28, null);
        k21.i(typeConstructor, "constructor");
        k21.i(memberScope, "memberScope");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public le0(@NotNull TypeConstructor typeConstructor, @NotNull MemberScope memberScope, @NotNull List<? extends TypeProjection> list, boolean z) {
        this(typeConstructor, memberScope, list, z, null, 16, null);
        k21.i(typeConstructor, "constructor");
        k21.i(memberScope, "memberScope");
        k21.i(list, "arguments");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ le0(TypeConstructor typeConstructor, MemberScope memberScope, List list, boolean z, String str, int i, m40 m40) {
        this(typeConstructor, memberScope, (i & 4) != 0 ? m.g() : list, (i & 8) != 0 ? false : z, (i & 16) != 0 ? "???" : str);
    }

    @Override // tb.g61
    @NotNull
    public List<TypeProjection> b() {
        return this.d;
    }

    @Override // tb.g61
    @NotNull
    public TypeConstructor c() {
        return this.b;
    }

    @Override // tb.g61
    public boolean d() {
        return this.e;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated
    @NotNull
    public Annotations getAnnotations() {
        return Annotations.Companion.b();
    }

    @Override // tb.g61
    @NotNull
    public MemberScope getMemberScope() {
        return this.c;
    }

    @Override // tb.ib2
    @NotNull
    /* renamed from: j */
    public ib2 g(boolean z) {
        return new le0(c(), getMemberScope(), b(), z, null, 16, null);
    }

    @Override // tb.ib2
    @NotNull
    /* renamed from: k */
    public ib2 i(@NotNull Annotations annotations) {
        k21.i(annotations, "newAnnotations");
        return this;
    }

    @NotNull
    public String l() {
        return this.f;
    }

    @NotNull
    /* renamed from: m */
    public le0 h(@NotNull i61 i61) {
        k21.i(i61, "kotlinTypeRefiner");
        return this;
    }

    @Override // tb.ib2
    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(c());
        sb.append(b().isEmpty() ? "" : CollectionsKt___CollectionsKt.Y(b(), AVFSCacheConstants.COMMA_SEP, jl1.L, jl1.G, -1, "...", null));
        return sb.toString();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.util.List<? extends kotlin.reflect.jvm.internal.impl.types.TypeProjection> */
    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public le0(@NotNull TypeConstructor typeConstructor, @NotNull MemberScope memberScope, @NotNull List<? extends TypeProjection> list, boolean z, @NotNull String str) {
        k21.i(typeConstructor, "constructor");
        k21.i(memberScope, "memberScope");
        k21.i(list, "arguments");
        k21.i(str, "presentableName");
        this.b = typeConstructor;
        this.c = memberScope;
        this.d = list;
        this.e = z;
        this.f = str;
    }
}
