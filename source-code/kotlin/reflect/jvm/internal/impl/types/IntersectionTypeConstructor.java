package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.m;
import kotlin.collections.n;
import kotlin.reflect.jvm.internal.impl.builtins.b;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.TypeIntersectionScope;
import kotlin.reflect.jvm.internal.impl.types.model.IntersectionTypeConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.bl;
import tb.g61;
import tb.i61;
import tb.ib2;
import tb.jl1;
import tb.k21;

/* compiled from: Taobao */
public final class IntersectionTypeConstructor implements TypeConstructor, IntersectionTypeConstructorMarker {
    @Nullable
    private g61 a;
    @NotNull
    private final LinkedHashSet<g61> b;
    private final int c;

    /* compiled from: Taobao */
    public static final class a<T> implements Comparator<T> {
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            return bl.a(t.toString(), t2.toString());
        }
    }

    public IntersectionTypeConstructor(@NotNull Collection<? extends g61> collection) {
        k21.i(collection, "typesToIntersect");
        collection.isEmpty();
        LinkedHashSet<g61> linkedHashSet = new LinkedHashSet<>(collection);
        this.b = linkedHashSet;
        this.c = linkedHashSet.hashCode();
    }

    private final String d(Iterable<? extends g61> iterable) {
        return CollectionsKt___CollectionsKt.Z(CollectionsKt___CollectionsKt.s0(iterable, new a()), " & ", jl1.BLOCK_START_STR, "}", 0, null, null, 56, null);
    }

    @NotNull
    public final MemberScope a() {
        return TypeIntersectionScope.Companion.a("member scope for intersection type", this.b);
    }

    @NotNull
    public final ib2 b() {
        KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.INSTANCE;
        return KotlinTypeFactory.k(Annotations.Companion.b(), this, m.g(), false, a(), new IntersectionTypeConstructor$createType$1(this));
    }

    @Nullable
    public final g61 c() {
        return this.a;
    }

    @NotNull
    /* renamed from: e */
    public IntersectionTypeConstructor refine(@NotNull i61 i61) {
        k21.i(i61, "kotlinTypeRefiner");
        Collection<g61> supertypes = getSupertypes();
        ArrayList arrayList = new ArrayList(n.q(supertypes, 10));
        Iterator<T> it = supertypes.iterator();
        boolean z = false;
        while (it.hasNext()) {
            arrayList.add(it.next().e(i61));
            z = true;
        }
        IntersectionTypeConstructor intersectionTypeConstructor = null;
        g61 g61 = null;
        if (z) {
            g61 c2 = c();
            if (c2 != null) {
                g61 = c2.e(i61);
            }
            intersectionTypeConstructor = new IntersectionTypeConstructor(arrayList).f(g61);
        }
        return intersectionTypeConstructor == null ? this : intersectionTypeConstructor;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IntersectionTypeConstructor)) {
            return false;
        }
        return k21.d(this.b, ((IntersectionTypeConstructor) obj).b);
    }

    @NotNull
    public final IntersectionTypeConstructor f(@Nullable g61 g61) {
        return new IntersectionTypeConstructor(this.b, g61);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    @NotNull
    public b getBuiltIns() {
        b builtIns = this.b.iterator().next().c().getBuiltIns();
        k21.h(builtIns, "intersectedTypes.iterator().next().constructor.builtIns");
        return builtIns;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    @Nullable
    public ClassifierDescriptor getDeclarationDescriptor() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    @NotNull
    public List<TypeParameterDescriptor> getParameters() {
        return m.g();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    @NotNull
    public Collection<g61> getSupertypes() {
        return this.b;
    }

    public int hashCode() {
        return this.c;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public boolean isDenotable() {
        return false;
    }

    @NotNull
    public String toString() {
        return d(this.b);
    }

    private IntersectionTypeConstructor(Collection<? extends g61> collection, g61 g61) {
        this(collection);
        this.a = g61;
    }
}
