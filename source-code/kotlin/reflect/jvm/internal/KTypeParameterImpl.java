package kotlin.reflect.jvm.internal;

import java.util.List;
import java.util.Objects;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KClass;
import kotlin.reflect.KProperty;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.KVariance;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.az1;
import tb.dz1;
import tb.g51;
import tb.k21;
import tb.q51;
import tb.to2;
import tb.ur2;
import tb.wt2;
import tb.wy1;
import tb.z41;
import tb.zo;

/* compiled from: Taobao */
public final class KTypeParameterImpl implements KTypeParameter, KClassifierImpl {
    static final /* synthetic */ KProperty[] d = {dz1.i(new PropertyReference1Impl(dz1.b(KTypeParameterImpl.class), "upperBounds", "getUpperBounds()Ljava/util/List;"))};
    @NotNull
    private final az1.a a = az1.d(new KTypeParameterImpl$upperBounds$2(this));
    private final KTypeParameterOwnerImpl b;
    @NotNull
    private final TypeParameterDescriptor c;

    public KTypeParameterImpl(@Nullable KTypeParameterOwnerImpl kTypeParameterOwnerImpl, @NotNull TypeParameterDescriptor typeParameterDescriptor) {
        Object obj;
        KClassImpl<?> kClassImpl;
        k21.i(typeParameterDescriptor, "descriptor");
        this.c = typeParameterDescriptor;
        if (kTypeParameterOwnerImpl == null) {
            DeclarationDescriptor containingDeclaration = getDescriptor().getContainingDeclaration();
            k21.h(containingDeclaration, "descriptor.containingDeclaration");
            if (containingDeclaration instanceof ClassDescriptor) {
                obj = c((ClassDescriptor) containingDeclaration);
            } else if (containingDeclaration instanceof CallableMemberDescriptor) {
                DeclarationDescriptor containingDeclaration2 = ((CallableMemberDescriptor) containingDeclaration).getContainingDeclaration();
                k21.h(containingDeclaration2, "declaration.containingDeclaration");
                if (containingDeclaration2 instanceof ClassDescriptor) {
                    kClassImpl = c((ClassDescriptor) containingDeclaration2);
                } else {
                    DeserializedMemberDescriptor deserializedMemberDescriptor = (DeserializedMemberDescriptor) (!(containingDeclaration instanceof DeserializedMemberDescriptor) ? null : containingDeclaration);
                    if (deserializedMemberDescriptor != null) {
                        KClass e = z41.e(a(deserializedMemberDescriptor));
                        Objects.requireNonNull(e, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.KClassImpl<*>");
                        kClassImpl = (KClassImpl) e;
                    } else {
                        throw new KotlinReflectionInternalError("Non-class callable descriptor must be deserialized: " + containingDeclaration);
                    }
                }
                obj = containingDeclaration.accept(new zo(kClassImpl), ur2.INSTANCE);
            } else {
                throw new KotlinReflectionInternalError("Unknown type parameter container: " + containingDeclaration);
            }
            k21.h(obj, "when (val declaration = … $declaration\")\n        }");
            kTypeParameterOwnerImpl = (KTypeParameterOwnerImpl) obj;
        }
        this.b = kTypeParameterOwnerImpl;
    }

    private final Class<?> a(DeserializedMemberDescriptor deserializedMemberDescriptor) {
        Class<?> a2;
        DeserializedContainerSource containerSource = deserializedMemberDescriptor.getContainerSource();
        wy1 wy1 = null;
        if (!(containerSource instanceof g51)) {
            containerSource = null;
        }
        g51 g51 = (g51) containerSource;
        KotlinJvmBinaryClass c2 = g51 != null ? g51.c() : null;
        if (c2 instanceof wy1) {
            wy1 = c2;
        }
        wy1 wy12 = wy1;
        if (wy12 != null && (a2 = wy12.a()) != null) {
            return a2;
        }
        throw new KotlinReflectionInternalError("Container of deserialized member is not resolved: " + deserializedMemberDescriptor);
    }

    private final KClassImpl<?> c(ClassDescriptor classDescriptor) {
        Class<?> n = wt2.n(classDescriptor);
        KClassImpl<?> kClassImpl = (KClassImpl) (n != null ? z41.e(n) : null);
        if (kClassImpl != null) {
            return kClassImpl;
        }
        throw new KotlinReflectionInternalError("Type parameter container is not resolved: " + classDescriptor.getContainingDeclaration());
    }

    @NotNull
    /* renamed from: b */
    public TypeParameterDescriptor getDescriptor() {
        return this.c;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof KTypeParameterImpl) {
            KTypeParameterImpl kTypeParameterImpl = (KTypeParameterImpl) obj;
            return k21.d(this.b, kTypeParameterImpl.b) && k21.d(getName(), kTypeParameterImpl.getName());
        }
    }

    @Override // kotlin.reflect.KTypeParameter
    @NotNull
    public String getName() {
        String b2 = getDescriptor().getName().b();
        k21.h(b2, "descriptor.name.asString()");
        return b2;
    }

    @Override // kotlin.reflect.KTypeParameter
    @NotNull
    public List<KType> getUpperBounds() {
        return (List) this.a.b(this, d[0]);
    }

    @Override // kotlin.reflect.KTypeParameter
    @NotNull
    public KVariance getVariance() {
        int i = q51.$EnumSwitchMapping$0[getDescriptor().getVariance().ordinal()];
        if (i == 1) {
            return KVariance.INVARIANT;
        }
        if (i == 2) {
            return KVariance.IN;
        }
        if (i == 3) {
            return KVariance.OUT;
        }
        throw new NoWhenBranchMatchedException();
    }

    public int hashCode() {
        return (this.b.hashCode() * 31) + getName().hashCode();
    }

    @Override // kotlin.reflect.KTypeParameter
    public boolean isReified() {
        return getDescriptor().isReified();
    }

    @NotNull
    public String toString() {
        return to2.Companion.a(this);
    }
}
