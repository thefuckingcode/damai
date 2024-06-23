package kotlin.reflect.jvm.internal.impl.resolve.constants;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.b;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.m;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import tb.g61;
import tb.i61;
import tb.ib2;
import tb.jl1;
import tb.k21;
import tb.ks1;
import tb.m40;

public final class IntegerLiteralTypeConstructor implements TypeConstructor {
    public static final Companion Companion = new Companion(null);
    private final long a;
    private final ModuleDescriptor b;
    private final Set<g61> c;
    private final ib2 d;
    private final Lazy e;

    public static final class Companion {

        public enum Mode {
            COMMON_SUPER_TYPE,
            INTERSECTION_TYPE
        }

        public /* synthetic */ class a {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[Mode.values().length];
                iArr[Mode.COMMON_SUPER_TYPE.ordinal()] = 1;
                iArr[Mode.INTERSECTION_TYPE.ordinal()] = 2;
                $EnumSwitchMapping$0 = iArr;
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(m40 m40) {
            this();
        }

        private final ib2 a(Collection<? extends ib2> collection, Mode mode) {
            if (collection.isEmpty()) {
                return null;
            }
            Iterator<T> it = collection.iterator();
            if (it.hasNext()) {
                ib2 next = it.next();
                while (it.hasNext()) {
                    next = e(next, it.next(), mode);
                }
                return next;
            }
            throw new UnsupportedOperationException("Empty collection can't be reduced.");
        }

        private final ib2 c(IntegerLiteralTypeConstructor integerLiteralTypeConstructor, IntegerLiteralTypeConstructor integerLiteralTypeConstructor2, Mode mode) {
            Set set;
            int i = a.$EnumSwitchMapping$0[mode.ordinal()];
            if (i == 1) {
                set = CollectionsKt___CollectionsKt.V(integerLiteralTypeConstructor.f(), integerLiteralTypeConstructor2.f());
            } else if (i == 2) {
                set = CollectionsKt___CollectionsKt.D0(integerLiteralTypeConstructor.f(), integerLiteralTypeConstructor2.f());
            } else {
                throw new NoWhenBranchMatchedException();
            }
            IntegerLiteralTypeConstructor integerLiteralTypeConstructor3 = new IntegerLiteralTypeConstructor(integerLiteralTypeConstructor.a, integerLiteralTypeConstructor.b, set, null);
            KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.INSTANCE;
            return KotlinTypeFactory.e(Annotations.Companion.b(), integerLiteralTypeConstructor3, false);
        }

        private final ib2 d(IntegerLiteralTypeConstructor integerLiteralTypeConstructor, ib2 ib2) {
            if (integerLiteralTypeConstructor.f().contains(ib2)) {
                return ib2;
            }
            return null;
        }

        private final ib2 e(ib2 ib2, ib2 ib22, Mode mode) {
            if (ib2 == null || ib22 == null) {
                return null;
            }
            TypeConstructor c = ib2.c();
            TypeConstructor c2 = ib22.c();
            boolean z = c instanceof IntegerLiteralTypeConstructor;
            if (z && (c2 instanceof IntegerLiteralTypeConstructor)) {
                return c((IntegerLiteralTypeConstructor) c, (IntegerLiteralTypeConstructor) c2, mode);
            }
            if (z) {
                return d((IntegerLiteralTypeConstructor) c, ib22);
            }
            if (c2 instanceof IntegerLiteralTypeConstructor) {
                return d((IntegerLiteralTypeConstructor) c2, ib2);
            }
            return null;
        }

        public final ib2 b(Collection<? extends ib2> collection) {
            k21.i(collection, "types");
            return a(collection, Mode.INTERSECTION_TYPE);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.util.Set<? extends tb.g61> */
    /* JADX WARN: Multi-variable type inference failed */
    private IntegerLiteralTypeConstructor(long j, ModuleDescriptor moduleDescriptor, Set<? extends g61> set) {
        KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.INSTANCE;
        this.d = KotlinTypeFactory.e(Annotations.Companion.b(), this, false);
        this.e = b.b(new IntegerLiteralTypeConstructor$supertypes$2(this));
        this.a = j;
        this.b = moduleDescriptor;
        this.c = set;
    }

    public /* synthetic */ IntegerLiteralTypeConstructor(long j, ModuleDescriptor moduleDescriptor, Set set, m40 m40) {
        this(j, moduleDescriptor, set);
    }

    private final List<g61> g() {
        return (List) this.e.getValue();
    }

    /* access modifiers changed from: public */
    private final boolean h() {
        Collection<g61> a2 = ks1.a(this.b);
        if ((a2 instanceof Collection) && a2.isEmpty()) {
            return true;
        }
        Iterator<T> it = a2.iterator();
        while (it.hasNext()) {
            if (!(!f().contains(it.next()))) {
                return false;
            }
        }
        return true;
    }

    private final String i() {
        return jl1.ARRAY_START + CollectionsKt___CollectionsKt.Z(this.c, ",", null, null, 0, null, IntegerLiteralTypeConstructor$valueToString$1.INSTANCE, 30, null) + jl1.ARRAY_END;
    }

    public final boolean e(TypeConstructor typeConstructor) {
        k21.i(typeConstructor, "constructor");
        Set<g61> set = this.c;
        if ((set instanceof Collection) && set.isEmpty()) {
            return false;
        }
        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
            if (k21.d(it.next().c(), typeConstructor)) {
                return true;
            }
        }
        return false;
    }

    public final Set<g61> f() {
        return this.c;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public kotlin.reflect.jvm.internal.impl.builtins.b getBuiltIns() {
        return this.b.getBuiltIns();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public ClassifierDescriptor getDeclarationDescriptor() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public List<TypeParameterDescriptor> getParameters() {
        return m.g();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public Collection<g61> getSupertypes() {
        return g();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public boolean isDenotable() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public TypeConstructor refine(i61 i61) {
        k21.i(i61, "kotlinTypeRefiner");
        return this;
    }

    public String toString() {
        return k21.r("IntegerLiteralType", i());
    }
}
