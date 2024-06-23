package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import com.huawei.hms.opendevice.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.n;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.PossiblyExternalAnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolverKt;
import kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElement;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationAsAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassObjectAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaEnumValueAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaLiteralAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValueFactory;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.NullableLazyValue;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.ae0;
import tb.c6;
import tb.c60;
import tb.dz1;
import tb.en0;
import tb.fk1;
import tb.h61;
import tb.ib2;
import tb.k21;
import tb.m40;
import tb.me0;
import tb.n51;
import tb.og1;
import tb.oi;
import tb.om;
import tb.te2;
import tb.u41;
import tb.x61;

/* compiled from: Taobao */
public final class LazyJavaAnnotationDescriptor implements AnnotationDescriptor, PossiblyExternalAnnotationDescriptor {
    static final /* synthetic */ KProperty<Object>[] i = {dz1.i(new PropertyReference1Impl(dz1.b(LazyJavaAnnotationDescriptor.class), "fqName", "getFqName()Lorg/jetbrains/kotlin/name/FqName;")), dz1.i(new PropertyReference1Impl(dz1.b(LazyJavaAnnotationDescriptor.class), "type", "getType()Lorg/jetbrains/kotlin/types/SimpleType;")), dz1.i(new PropertyReference1Impl(dz1.b(LazyJavaAnnotationDescriptor.class), "allValueArguments", "getAllValueArguments()Ljava/util/Map;"))};
    @NotNull
    private final x61 a;
    @NotNull
    private final JavaAnnotation b;
    @NotNull
    private final NullableLazyValue c;
    @NotNull
    private final NotNullLazyValue d;
    @NotNull
    private final JavaSourceElement e;
    @NotNull
    private final NotNullLazyValue f;
    private final boolean g;
    private final boolean h;

    public LazyJavaAnnotationDescriptor(@NotNull x61 x61, @NotNull JavaAnnotation javaAnnotation, boolean z) {
        k21.i(x61, c.a);
        k21.i(javaAnnotation, "javaAnnotation");
        this.a = x61;
        this.b = javaAnnotation;
        this.c = x61.e().createNullableLazyValue(new LazyJavaAnnotationDescriptor$fqName$2(this));
        this.d = x61.e().createLazyValue(new LazyJavaAnnotationDescriptor$type$2(this));
        this.e = x61.a().s().source(javaAnnotation);
        this.f = x61.e().createLazyValue(new LazyJavaAnnotationDescriptor$allValueArguments$2(this));
        this.g = javaAnnotation.isIdeExternalAnnotation();
        this.h = javaAnnotation.isFreshlySupportedTypeUseAnnotation() || z;
    }

    /* access modifiers changed from: private */
    public final ClassDescriptor e(en0 en0) {
        ModuleDescriptor d2 = this.a.d();
        oi m = oi.m(en0);
        k21.h(m, "topLevel(fqName)");
        return FindClassInModuleKt.c(d2, m, this.a.a().b().f().q());
    }

    /* access modifiers changed from: private */
    public final om<?> i(JavaAnnotationArgument javaAnnotationArgument) {
        if (javaAnnotationArgument instanceof JavaLiteralAnnotationArgument) {
            return ConstantValueFactory.INSTANCE.c(((JavaLiteralAnnotationArgument) javaAnnotationArgument).getValue());
        }
        if (javaAnnotationArgument instanceof JavaEnumValueAnnotationArgument) {
            JavaEnumValueAnnotationArgument javaEnumValueAnnotationArgument = (JavaEnumValueAnnotationArgument) javaAnnotationArgument;
            return l(javaEnumValueAnnotationArgument.getEnumClassId(), javaEnumValueAnnotationArgument.getEntryName());
        } else if (javaAnnotationArgument instanceof JavaArrayAnnotationArgument) {
            og1 name = javaAnnotationArgument.getName();
            if (name == null) {
                name = u41.DEFAULT_ANNOTATION_MEMBER_NAME;
            }
            k21.h(name, "argument.name ?: DEFAULT_ANNOTATION_MEMBER_NAME");
            return k(name, ((JavaArrayAnnotationArgument) javaAnnotationArgument).getElements());
        } else if (javaAnnotationArgument instanceof JavaAnnotationAsAnnotationArgument) {
            return j(((JavaAnnotationAsAnnotationArgument) javaAnnotationArgument).getAnnotation());
        } else {
            if (javaAnnotationArgument instanceof JavaClassObjectAnnotationArgument) {
                return m(((JavaClassObjectAnnotationArgument) javaAnnotationArgument).getReferencedType());
            }
            return null;
        }
    }

    private final om<?> j(JavaAnnotation javaAnnotation) {
        return new c6(new LazyJavaAnnotationDescriptor(this.a, javaAnnotation, false, 4, null));
    }

    private final om<?> k(og1 og1, List<? extends JavaAnnotationArgument> list) {
        ib2 g2 = getType();
        k21.h(g2, "type");
        ib2 ib2 = null;
        if (h61.a(g2)) {
            return null;
        }
        ClassDescriptor f2 = DescriptorUtilsKt.f(this);
        k21.f(f2);
        ValueParameterDescriptor b2 = c60.b(og1, f2);
        if (b2 != null) {
            ib2 = b2.getType();
        }
        if (ib2 == null) {
            ib2 = this.a.a().l().getBuiltIns().l(Variance.INVARIANT, me0.j("Unknown array element type"));
        }
        k21.h(ib2, "DescriptorResolverUtils.getAnnotationParameterByName(argumentName, annotationClass!!)?.type\n            // Try to load annotation arguments even if the annotation class is not found\n                ?: c.components.module.builtIns.getArrayType(\n                    Variance.INVARIANT,\n                    ErrorUtils.createErrorType(\"Unknown array element type\")\n                )");
        ArrayList arrayList = new ArrayList(n.q(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            om<?> i2 = i(it.next());
            if (i2 == null) {
                i2 = new fk1();
            }
            arrayList.add(i2);
        }
        return ConstantValueFactory.INSTANCE.b(arrayList, ib2);
    }

    private final om<?> l(oi oiVar, og1 og1) {
        if (oiVar == null || og1 == null) {
            return null;
        }
        return new ae0(oiVar, og1);
    }

    private final om<?> m(JavaType javaType) {
        return n51.Companion.a(this.a.g().n(javaType, JavaTypeResolverKt.f(TypeUsage.COMMON, false, null, 3, null)));
    }

    @NotNull
    /* renamed from: f */
    public JavaSourceElement getSource() {
        return this.e;
    }

    @NotNull
    /* renamed from: g */
    public ib2 getType() {
        return (ib2) te2.a(this.d, this, i[1]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor
    @NotNull
    public Map<og1, om<?>> getAllValueArguments() {
        return (Map) te2.a(this.f, this, i[2]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor
    @Nullable
    public en0 getFqName() {
        return (en0) te2.b(this.c, this, i[0]);
    }

    public final boolean h() {
        return this.h;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.descriptors.PossiblyExternalAnnotationDescriptor
    public boolean isIdeExternalAnnotation() {
        return this.g;
    }

    @NotNull
    public String toString() {
        return DescriptorRenderer.c(DescriptorRenderer.FQ_NAMES_IN_TYPES, this, null, 2, null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LazyJavaAnnotationDescriptor(x61 x61, JavaAnnotation javaAnnotation, boolean z, int i2, m40 m40) {
        this(x61, javaAnnotation, (i2 & 4) != 0 ? false : z);
    }
}
