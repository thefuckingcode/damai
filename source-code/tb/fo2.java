package tb;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.n;
import kotlin.collections.x;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class fo2 {
    @NotNull
    public static final a Companion = new a(null);
    @Nullable
    private final fo2 a;
    @NotNull
    private final TypeAliasDescriptor b;
    @NotNull
    private final List<TypeProjection> c;
    @NotNull
    private final Map<TypeParameterDescriptor, TypeProjection> d;

    /* compiled from: Taobao */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }

        @NotNull
        public final fo2 a(@Nullable fo2 fo2, @NotNull TypeAliasDescriptor typeAliasDescriptor, @NotNull List<? extends TypeProjection> list) {
            k21.i(typeAliasDescriptor, "typeAliasDescriptor");
            k21.i(list, "arguments");
            List<TypeParameterDescriptor> parameters = typeAliasDescriptor.getTypeConstructor().getParameters();
            k21.h(parameters, "typeAliasDescriptor.typeConstructor.parameters");
            ArrayList arrayList = new ArrayList(n.q(parameters, 10));
            Iterator<T> it = parameters.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().getOriginal());
            }
            return new fo2(fo2, typeAliasDescriptor, list, x.r(CollectionsKt___CollectionsKt.F0(arrayList, list)), null);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.util.List<? extends kotlin.reflect.jvm.internal.impl.types.TypeProjection> */
    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.util.Map<kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor, ? extends kotlin.reflect.jvm.internal.impl.types.TypeProjection> */
    /* JADX WARN: Multi-variable type inference failed */
    private fo2(fo2 fo2, TypeAliasDescriptor typeAliasDescriptor, List<? extends TypeProjection> list, Map<TypeParameterDescriptor, ? extends TypeProjection> map) {
        this.a = fo2;
        this.b = typeAliasDescriptor;
        this.c = list;
        this.d = map;
    }

    public /* synthetic */ fo2(fo2 fo2, TypeAliasDescriptor typeAliasDescriptor, List list, Map map, m40 m40) {
        this(fo2, typeAliasDescriptor, list, map);
    }

    @NotNull
    public final List<TypeProjection> a() {
        return this.c;
    }

    @NotNull
    public final TypeAliasDescriptor b() {
        return this.b;
    }

    @Nullable
    public final TypeProjection c(@NotNull TypeConstructor typeConstructor) {
        k21.i(typeConstructor, "constructor");
        ClassifierDescriptor declarationDescriptor = typeConstructor.getDeclarationDescriptor();
        if (declarationDescriptor instanceof TypeParameterDescriptor) {
            return this.d.get(declarationDescriptor);
        }
        return null;
    }

    public final boolean d(@NotNull TypeAliasDescriptor typeAliasDescriptor) {
        k21.i(typeAliasDescriptor, "descriptor");
        if (!k21.d(this.b, typeAliasDescriptor)) {
            fo2 fo2 = this.a;
            return fo2 == null ? false : fo2.d(typeAliasDescriptor);
        }
    }
}
