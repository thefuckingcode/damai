package tb;

import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.k;
import kotlin.collections.l;
import kotlin.reflect.jvm.internal.impl.builtins.c;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class n51 extends om<b> {
    @NotNull
    public static final a Companion = new a(null);

    /* compiled from: Taobao */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }

        @Nullable
        public final om<?> a(@NotNull g61 g61) {
            k21.i(g61, "argumentType");
            if (h61.a(g61)) {
                return null;
            }
            g61 g612 = g61;
            int i = 0;
            while (kotlin.reflect.jvm.internal.impl.builtins.b.b0(g612)) {
                g612 = ((TypeProjection) k.o0(g612.b())).getType();
                k21.h(g612, "type.arguments.single().type");
                i++;
            }
            ClassifierDescriptor declarationDescriptor = g612.c().getDeclarationDescriptor();
            if (declarationDescriptor instanceof ClassDescriptor) {
                oi h = DescriptorUtilsKt.h(declarationDescriptor);
                if (h == null) {
                    return new n51(new b.a(g61));
                }
                return new n51(h, i);
            } else if (!(declarationDescriptor instanceof TypeParameterDescriptor)) {
                return null;
            } else {
                oi m = oi.m(c.a.any.l());
                k21.h(m, "topLevel(StandardNames.FqNames.any.toSafe())");
                return new n51(m, 0);
            }
        }
    }

    /* compiled from: Taobao */
    public static abstract class b {

        /* compiled from: Taobao */
        public static final class a extends b {
            @NotNull
            private final g61 a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(@NotNull g61 g61) {
                super(null);
                k21.i(g61, "type");
                this.a = g61;
            }

            @NotNull
            public final g61 a() {
                return this.a;
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof a) && k21.d(this.a, ((a) obj).a);
            }

            public int hashCode() {
                return this.a.hashCode();
            }

            @NotNull
            public String toString() {
                return "LocalClass(type=" + this.a + ')';
            }
        }

        /* renamed from: tb.n51$b$b  reason: collision with other inner class name */
        /* compiled from: Taobao */
        public static final class C0307b extends b {
            @NotNull
            private final pi a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0307b(@NotNull pi piVar) {
                super(null);
                k21.i(piVar, "value");
                this.a = piVar;
            }

            public final int a() {
                return this.a.c();
            }

            @NotNull
            public final oi b() {
                return this.a.d();
            }

            @NotNull
            public final pi c() {
                return this.a;
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof C0307b) && k21.d(this.a, ((C0307b) obj).a);
            }

            public int hashCode() {
                return this.a.hashCode();
            }

            @NotNull
            public String toString() {
                return "NormalClass(value=" + this.a + ')';
            }
        }

        private b() {
        }

        public /* synthetic */ b(m40 m40) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public n51(@NotNull b bVar) {
        super(bVar);
        k21.i(bVar, "value");
    }

    @Override // tb.om
    @NotNull
    public g61 a(@NotNull ModuleDescriptor moduleDescriptor) {
        k21.i(moduleDescriptor, "module");
        KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.INSTANCE;
        Annotations b2 = Annotations.Companion.b();
        ClassDescriptor E = moduleDescriptor.getBuiltIns().E();
        k21.h(E, "module.builtIns.kClass");
        return KotlinTypeFactory.g(b2, E, l.e(new vo2(c(moduleDescriptor))));
    }

    @NotNull
    public final g61 c(@NotNull ModuleDescriptor moduleDescriptor) {
        k21.i(moduleDescriptor, "module");
        b bVar = (b) b();
        if (bVar instanceof b.a) {
            return ((b.a) b()).a();
        }
        if (bVar instanceof b.C0307b) {
            pi c = ((b.C0307b) b()).c();
            oi a2 = c.a();
            int b2 = c.b();
            ClassDescriptor a3 = FindClassInModuleKt.a(moduleDescriptor, a2);
            if (a3 == null) {
                ib2 j = me0.j("Unresolved type: " + a2 + " (arrayDimensions=" + b2 + ')');
                k21.h(j, "createErrorType(\"Unresolved type: $classId (arrayDimensions=$arrayDimensions)\")");
                return j;
            }
            ib2 defaultType = a3.getDefaultType();
            k21.h(defaultType, "descriptor.defaultType");
            g61 m = TypeUtilsKt.m(defaultType);
            for (int i = 0; i < b2; i++) {
                m = moduleDescriptor.getBuiltIns().l(Variance.INVARIANT, m);
                k21.h(m, "module.builtIns.getArrayType(Variance.INVARIANT, type)");
            }
            return m;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public n51(@NotNull pi piVar) {
        this(new b.C0307b(piVar));
        k21.i(piVar, "value");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public n51(@NotNull oi oiVar, int i) {
        this(new pi(oiVar, i));
        k21.i(oiVar, "classId");
    }
}
