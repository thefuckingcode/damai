package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.List;
import java.util.Map;
import kotlin.collections.m;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.ContextKt;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.dz1;
import tb.e61;
import tb.en0;
import tb.in1;
import tb.k21;
import tb.te2;
import tb.w61;
import tb.x61;

/* compiled from: Taobao */
public final class LazyJavaPackageFragment extends in1 {
    static final /* synthetic */ KProperty<Object>[] m = {dz1.i(new PropertyReference1Impl(dz1.b(LazyJavaPackageFragment.class), "binaryClasses", "getBinaryClasses$descriptors_jvm()Ljava/util/Map;")), dz1.i(new PropertyReference1Impl(dz1.b(LazyJavaPackageFragment.class), "partToFacade", "getPartToFacade()Ljava/util/HashMap;"))};
    @NotNull
    private final JavaPackage f;
    @NotNull
    private final x61 g;
    @NotNull
    private final NotNullLazyValue h;
    @NotNull
    private final JvmPackageScope i;
    @NotNull
    private final NotNullLazyValue<List<en0>> j;
    @NotNull
    private final Annotations k;
    @NotNull
    private final NotNullLazyValue l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LazyJavaPackageFragment(@NotNull x61 x61, @NotNull JavaPackage javaPackage) {
        super(x61.d(), javaPackage.getFqName());
        Annotations annotations;
        k21.i(x61, "outerContext");
        k21.i(javaPackage, "jPackage");
        this.f = javaPackage;
        x61 d = ContextKt.d(x61, this, null, 0, 6, null);
        this.g = d;
        this.h = d.e().createLazyValue(new LazyJavaPackageFragment$binaryClasses$2(this));
        this.i = new JvmPackageScope(d, javaPackage, this);
        this.j = d.e().createRecursionTolerantLazyValue(new LazyJavaPackageFragment$subPackages$1(this), m.g());
        if (d.a().h().a()) {
            annotations = Annotations.Companion.b();
        } else {
            annotations = w61.a(d, javaPackage);
        }
        this.k = annotations;
        this.l = d.e().createLazyValue(new LazyJavaPackageFragment$partToFacade$2(this));
    }

    @Nullable
    public final ClassDescriptor f(@NotNull JavaClass javaClass) {
        k21.i(javaClass, "jClass");
        return this.i.c().H(javaClass);
    }

    @NotNull
    public final Map<String, KotlinJvmBinaryClass> g() {
        return (Map) te2.a(this.h, this, m[0]);
    }

    @Override // tb.w5, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated
    @NotNull
    public Annotations getAnnotations() {
        return this.k;
    }

    @Override // tb.in1, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithSource, tb.w30
    @NotNull
    public SourceElement getSource() {
        return new e61(this);
    }

    @NotNull
    /* renamed from: h */
    public JvmPackageScope getMemberScope() {
        return this.i;
    }

    @NotNull
    public final List<en0> i() {
        return (List) this.j.invoke();
    }

    @Override // tb.in1, tb.v30
    @NotNull
    public String toString() {
        return k21.r("Lazy Java package fragment: ", getFqName());
    }
}
