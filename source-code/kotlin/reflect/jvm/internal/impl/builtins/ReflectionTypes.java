package kotlin.reflect.jvm.internal.impl.builtins;

import java.util.List;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.collections.k;
import kotlin.collections.l;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.builtins.c;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.StarProjectionImpl;
import kotlin.text.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.dz1;
import tb.g61;
import tb.k21;
import tb.m40;
import tb.og1;
import tb.oi;

/* compiled from: Taobao */
public final class ReflectionTypes {
    @NotNull
    public static final b Companion = new b(null);
    static final /* synthetic */ KProperty<Object>[] d;
    @NotNull
    private final NotFoundClasses a;
    @NotNull
    private final Lazy b;
    @NotNull
    private final a c = new a(1);

    /* compiled from: Taobao */
    private static final class a {
        private final int a;

        public a(int i) {
            this.a = i;
        }

        @NotNull
        public final ClassDescriptor a(@NotNull ReflectionTypes reflectionTypes, @NotNull KProperty<?> kProperty) {
            k21.i(reflectionTypes, "types");
            k21.i(kProperty, "property");
            return reflectionTypes.b(o.p(kProperty.getName()), this.a);
        }
    }

    /* compiled from: Taobao */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(m40 m40) {
            this();
        }

        @Nullable
        public final g61 a(@NotNull ModuleDescriptor moduleDescriptor) {
            k21.i(moduleDescriptor, "module");
            ClassDescriptor a = FindClassInModuleKt.a(moduleDescriptor, c.a.kProperty);
            if (a == null) {
                return null;
            }
            KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.INSTANCE;
            Annotations b = Annotations.Companion.b();
            List<TypeParameterDescriptor> parameters = a.getTypeConstructor().getParameters();
            k21.h(parameters, "kPropertyClass.typeConstructor.parameters");
            Object o0 = k.o0(parameters);
            k21.h(o0, "kPropertyClass.typeConstructor.parameters.single()");
            return KotlinTypeFactory.g(b, a, l.e(new StarProjectionImpl((TypeParameterDescriptor) o0)));
        }
    }

    static {
        KProperty<Object>[] kPropertyArr = new KProperty[9];
        kPropertyArr[1] = dz1.i(new PropertyReference1Impl(dz1.b(ReflectionTypes.class), "kClass", "getKClass()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;"));
        kPropertyArr[2] = dz1.i(new PropertyReference1Impl(dz1.b(ReflectionTypes.class), "kProperty", "getKProperty()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;"));
        kPropertyArr[3] = dz1.i(new PropertyReference1Impl(dz1.b(ReflectionTypes.class), "kProperty0", "getKProperty0()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;"));
        kPropertyArr[4] = dz1.i(new PropertyReference1Impl(dz1.b(ReflectionTypes.class), "kProperty1", "getKProperty1()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;"));
        kPropertyArr[5] = dz1.i(new PropertyReference1Impl(dz1.b(ReflectionTypes.class), "kProperty2", "getKProperty2()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;"));
        kPropertyArr[6] = dz1.i(new PropertyReference1Impl(dz1.b(ReflectionTypes.class), "kMutableProperty0", "getKMutableProperty0()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;"));
        kPropertyArr[7] = dz1.i(new PropertyReference1Impl(dz1.b(ReflectionTypes.class), "kMutableProperty1", "getKMutableProperty1()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;"));
        kPropertyArr[8] = dz1.i(new PropertyReference1Impl(dz1.b(ReflectionTypes.class), "kMutableProperty2", "getKMutableProperty2()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;"));
        d = kPropertyArr;
    }

    public ReflectionTypes(@NotNull ModuleDescriptor moduleDescriptor, @NotNull NotFoundClasses notFoundClasses) {
        k21.i(moduleDescriptor, "module");
        k21.i(notFoundClasses, "notFoundClasses");
        this.a = notFoundClasses;
        this.b = kotlin.b.a(LazyThreadSafetyMode.PUBLICATION, new ReflectionTypes$kotlinReflectScope$2(moduleDescriptor));
        new a(1);
        new a(1);
        new a(2);
        new a(3);
        new a(1);
        new a(2);
        new a(3);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final ClassDescriptor b(String str, int i) {
        og1 f = og1.f(str);
        k21.h(f, "identifier(className)");
        ClassifierDescriptor contributedClassifier = d().getContributedClassifier(f, NoLookupLocation.FROM_REFLECTION);
        ClassDescriptor classDescriptor = contributedClassifier instanceof ClassDescriptor ? (ClassDescriptor) contributedClassifier : null;
        return classDescriptor == null ? this.a.d(new oi(c.KOTLIN_REFLECT_FQ_NAME, f), l.e(Integer.valueOf(i))) : classDescriptor;
    }

    private final MemberScope d() {
        return (MemberScope) this.b.getValue();
    }

    @NotNull
    public final ClassDescriptor c() {
        return this.c.a(this, d[1]);
    }
}
