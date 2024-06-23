package tb;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.k;
import kotlin.collections.n;
import kotlin.collections.x;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class ko2 extends xo2 {
    public static final a Companion = new a(null);

    public static final class a {

        /* renamed from: tb.ko2$a$a */
        public static final class C0305a extends ko2 {
            final /* synthetic */ Map<TypeConstructor, TypeProjection> a;
            final /* synthetic */ boolean b;

            /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.util.Map<kotlin.reflect.jvm.internal.impl.types.TypeConstructor, ? extends kotlin.reflect.jvm.internal.impl.types.TypeProjection> */
            /* JADX WARN: Multi-variable type inference failed */
            C0305a(Map<TypeConstructor, ? extends TypeProjection> map, boolean z) {
                this.a = map;
                this.b = z;
            }

            @Override // tb.xo2
            public boolean a() {
                return this.b;
            }

            @Override // tb.xo2
            public boolean f() {
                return this.a.isEmpty();
            }

            @Override // tb.ko2
            public TypeProjection j(TypeConstructor typeConstructor) {
                k21.i(typeConstructor, "key");
                return this.a.get(typeConstructor);
            }
        }

        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }

        public static /* synthetic */ ko2 e(a aVar, Map map, boolean z, int i, Object obj) {
            if ((i & 2) != 0) {
                z = false;
            }
            return aVar.d(map, z);
        }

        public final xo2 a(TypeConstructor typeConstructor, List<? extends TypeProjection> list) {
            k21.i(typeConstructor, "typeConstructor");
            k21.i(list, "arguments");
            List<TypeParameterDescriptor> parameters = typeConstructor.getParameters();
            k21.h(parameters, "typeConstructor.parameters");
            TypeParameterDescriptor typeParameterDescriptor = (TypeParameterDescriptor) k.d0(parameters);
            if (!k21.d(typeParameterDescriptor == null ? null : Boolean.valueOf(typeParameterDescriptor.isCapturedFromOuterDeclaration()), Boolean.TRUE)) {
                return new r01(parameters, list);
            }
            List<TypeParameterDescriptor> parameters2 = typeConstructor.getParameters();
            k21.h(parameters2, "typeConstructor.parameters");
            ArrayList arrayList = new ArrayList(n.q(parameters2, 10));
            Iterator<T> it = parameters2.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().getTypeConstructor());
            }
            return e(this, x.r(CollectionsKt___CollectionsKt.F0(arrayList, list)), false, 2, null);
        }

        public final xo2 b(g61 g61) {
            k21.i(g61, "kotlinType");
            return a(g61.c(), g61.b());
        }

        public final ko2 c(Map<TypeConstructor, ? extends TypeProjection> map) {
            k21.i(map, "map");
            return e(this, map, false, 2, null);
        }

        public final ko2 d(Map<TypeConstructor, ? extends TypeProjection> map, boolean z) {
            k21.i(map, "map");
            return new C0305a(map, z);
        }
    }

    public static final xo2 h(TypeConstructor typeConstructor, List<? extends TypeProjection> list) {
        return Companion.a(typeConstructor, list);
    }

    public static final ko2 i(Map<TypeConstructor, ? extends TypeProjection> map) {
        return Companion.c(map);
    }

    @Override // tb.xo2
    public TypeProjection e(g61 g61) {
        k21.i(g61, "key");
        return j(g61.c());
    }

    @Nullable
    public abstract TypeProjection j(@NotNull TypeConstructor typeConstructor);
}
