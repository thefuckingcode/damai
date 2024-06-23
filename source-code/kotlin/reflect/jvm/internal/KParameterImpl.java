package kotlin.reflect.jvm.internal;

import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KParameter;
import kotlin.reflect.KProperty;
import kotlin.reflect.KType;
import kotlin.reflect.jvm.internal.impl.descriptors.ParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.az1;
import tb.dz1;
import tb.g61;
import tb.k21;
import tb.og1;

/* compiled from: Taobao */
public final class KParameterImpl implements KParameter {
    static final /* synthetic */ KProperty[] f = {dz1.i(new PropertyReference1Impl(dz1.b(KParameterImpl.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/ParameterDescriptor;")), dz1.i(new PropertyReference1Impl(dz1.b(KParameterImpl.class), "annotations", "getAnnotations()Ljava/util/List;"))};
    private final az1.a a;
    @NotNull
    private final az1.a b = az1.d(new KParameterImpl$annotations$2(this));
    @NotNull
    private final KCallableImpl<?> c;
    private final int d;
    @NotNull
    private final KParameter.Kind e;

    public KParameterImpl(@NotNull KCallableImpl<?> kCallableImpl, int i, @NotNull KParameter.Kind kind, @NotNull Function0<? extends ParameterDescriptor> function0) {
        k21.i(kCallableImpl, "callable");
        k21.i(kind, "kind");
        k21.i(function0, "computeDescriptor");
        this.c = kCallableImpl;
        this.d = i;
        this.e = kind;
        this.a = az1.d(function0);
    }

    /* access modifiers changed from: private */
    public final ParameterDescriptor c() {
        return (ParameterDescriptor) this.a.b(this, f[0]);
    }

    @NotNull
    public final KCallableImpl<?> b() {
        return this.c;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof KParameterImpl) {
            KParameterImpl kParameterImpl = (KParameterImpl) obj;
            return k21.d(this.c, kParameterImpl.c) && getIndex() == kParameterImpl.getIndex();
        }
    }

    @Override // kotlin.reflect.KAnnotatedElement
    @NotNull
    public List<Annotation> getAnnotations() {
        return (List) this.b.b(this, f[1]);
    }

    @Override // kotlin.reflect.KParameter
    public int getIndex() {
        return this.d;
    }

    @Override // kotlin.reflect.KParameter
    @NotNull
    public KParameter.Kind getKind() {
        return this.e;
    }

    @Override // kotlin.reflect.KParameter
    @Nullable
    public String getName() {
        ParameterDescriptor c2 = c();
        if (!(c2 instanceof ValueParameterDescriptor)) {
            c2 = null;
        }
        ValueParameterDescriptor valueParameterDescriptor = (ValueParameterDescriptor) c2;
        if (valueParameterDescriptor == null || valueParameterDescriptor.getContainingDeclaration().hasSynthesizedParameterNames()) {
            return null;
        }
        og1 name = valueParameterDescriptor.getName();
        k21.h(name, "valueParameter.name");
        if (name.g()) {
            return null;
        }
        return name.b();
    }

    @Override // kotlin.reflect.KParameter
    @NotNull
    public KType getType() {
        g61 type = c().getType();
        k21.h(type, "descriptor.type");
        return new KTypeImpl(type, new KParameterImpl$type$1(this));
    }

    public int hashCode() {
        return (this.c.hashCode() * 31) + Integer.valueOf(getIndex()).hashCode();
    }

    @Override // kotlin.reflect.KParameter
    public boolean isOptional() {
        ParameterDescriptor c2 = c();
        if (!(c2 instanceof ValueParameterDescriptor)) {
            c2 = null;
        }
        ValueParameterDescriptor valueParameterDescriptor = (ValueParameterDescriptor) c2;
        if (valueParameterDescriptor != null) {
            return DescriptorUtilsKt.a(valueParameterDescriptor);
        }
        return false;
    }

    @Override // kotlin.reflect.KParameter
    public boolean isVararg() {
        ParameterDescriptor c2 = c();
        return (c2 instanceof ValueParameterDescriptor) && ((ValueParameterDescriptor) c2).getVarargElementType() != null;
    }

    @NotNull
    public String toString() {
        return ReflectionObjectRenderer.INSTANCE.f(this);
    }
}
