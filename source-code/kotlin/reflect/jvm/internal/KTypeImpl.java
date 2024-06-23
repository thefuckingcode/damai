package kotlin.reflect.jvm.internal;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.List;
import kotlin.NotImplementedError;
import kotlin.collections.k;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.KTypeBase;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.az1;
import tb.bp2;
import tb.dz1;
import tb.g61;
import tb.k21;
import tb.m40;
import tb.r51;
import tb.s51;
import tb.wt2;
import tb.z41;

/* compiled from: Taobao */
public final class KTypeImpl implements KTypeBase {
    static final /* synthetic */ KProperty[] e = {dz1.i(new PropertyReference1Impl(dz1.b(KTypeImpl.class), "classifier", "getClassifier()Lkotlin/reflect/KClassifier;")), dz1.i(new PropertyReference1Impl(dz1.b(KTypeImpl.class), "arguments", "getArguments()Ljava/util/List;"))};
    private final az1.a<Type> a;
    @Nullable
    private final az1.a b;
    @NotNull
    private final az1.a c;
    @NotNull
    private final g61 d;

    public KTypeImpl(@NotNull g61 g61, @Nullable Function0<? extends Type> function0) {
        k21.i(g61, "type");
        this.d = g61;
        az1.a<Type> aVar = null;
        az1.a<Type> aVar2 = (az1.a) (!(function0 instanceof az1.a) ? null : function0);
        if (aVar2 != null) {
            aVar = aVar2;
        } else if (function0 != null) {
            aVar = az1.d(function0);
        }
        this.a = aVar;
        this.b = az1.d(new KTypeImpl$classifier$2(this));
        this.c = az1.d(new KTypeImpl$arguments$2(this, function0));
    }

    /* access modifiers changed from: private */
    public final KClassifier b(g61 g61) {
        g61 type;
        ClassifierDescriptor declarationDescriptor = g61.c().getDeclarationDescriptor();
        if (declarationDescriptor instanceof ClassDescriptor) {
            Class<?> n = wt2.n((ClassDescriptor) declarationDescriptor);
            if (n == null) {
                return null;
            }
            if (n.isArray()) {
                TypeProjection typeProjection = (TypeProjection) k.q0(g61.b());
                if (typeProjection == null || (type = typeProjection.getType()) == null) {
                    return new KClassImpl(n);
                }
                k21.h(type, "type.arguments.singleOrN…return KClassImpl(jClass)");
                KClassifier b2 = b(type);
                if (b2 != null) {
                    return new KClassImpl(ReflectClassUtilKt.a(z41.b(s51.a(b2))));
                }
                throw new KotlinReflectionInternalError("Cannot determine classifier for array element type: " + this);
            } else if (bp2.l(g61)) {
                return new KClassImpl(n);
            } else {
                Class<?> f = ReflectClassUtilKt.f(n);
                if (f != null) {
                    n = f;
                }
                return new KClassImpl(n);
            }
        } else if (declarationDescriptor instanceof TypeParameterDescriptor) {
            return new KTypeParameterImpl(null, (TypeParameterDescriptor) declarationDescriptor);
        } else {
            if (!(declarationDescriptor instanceof TypeAliasDescriptor)) {
                return null;
            }
            throw new NotImplementedError("An operation is not implemented: " + "Type alias classifiers are not yet supported");
        }
    }

    @NotNull
    public final g61 c() {
        return this.d;
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof KTypeImpl) && k21.d(this.d, ((KTypeImpl) obj).d);
    }

    @Override // kotlin.reflect.KAnnotatedElement
    @NotNull
    public List<Annotation> getAnnotations() {
        return wt2.d(this.d);
    }

    @Override // kotlin.reflect.KType
    @NotNull
    public List<r51> getArguments() {
        return (List) this.c.b(this, e[1]);
    }

    @Override // kotlin.reflect.KType
    @Nullable
    public KClassifier getClassifier() {
        return (KClassifier) this.b.b(this, e[0]);
    }

    @Override // kotlin.jvm.internal.KTypeBase
    @Nullable
    public Type getJavaType() {
        az1.a<Type> aVar = this.a;
        if (aVar != null) {
            return aVar.invoke();
        }
        return null;
    }

    public int hashCode() {
        return this.d.hashCode();
    }

    @Override // kotlin.reflect.KType
    public boolean isMarkedNullable() {
        return this.d.d();
    }

    @NotNull
    public String toString() {
        return ReflectionObjectRenderer.INSTANCE.h(this.d);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ KTypeImpl(g61 g61, Function0 function0, int i, m40 m40) {
        this(g61, (i & 2) != 0 ? null : function0);
    }
}
