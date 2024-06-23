package tb;

import java.lang.reflect.Method;
import kotlin.reflect.jvm.internal.JvmFunctionSignature;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.builtins.c;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.SpecialBuiltinMembers;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElement;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaElement;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Constructor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedCallableMemberDescriptor;
import org.jetbrains.annotations.NotNull;
import tb.d51;
import tb.h51;

/* compiled from: Taobao */
public final class i22 {
    @NotNull
    public static final i22 INSTANCE = new i22();
    private static final oi a;

    static {
        oi m = oi.m(new en0("java.lang.Void"));
        k21.h(m, "ClassId.topLevel(FqName(\"java.lang.Void\"))");
        a = m;
    }

    private i22() {
    }

    private final PrimitiveType a(Class<?> cls) {
        if (!cls.isPrimitive()) {
            return null;
        }
        JvmPrimitiveType jvmPrimitiveType = JvmPrimitiveType.get(cls.getSimpleName());
        k21.h(jvmPrimitiveType, "JvmPrimitiveType.get(simpleName)");
        return jvmPrimitiveType.getPrimitiveType();
    }

    private final boolean b(FunctionDescriptor functionDescriptor) {
        if (z50.m(functionDescriptor) || z50.n(functionDescriptor)) {
            return true;
        }
        if (!k21.d(functionDescriptor.getName(), zi.Companion.a()) || !functionDescriptor.getValueParameters().isEmpty()) {
            return false;
        }
        return true;
    }

    private final JvmFunctionSignature.c d(FunctionDescriptor functionDescriptor) {
        return new JvmFunctionSignature.c(new d51.b(e(functionDescriptor), pd1.c(functionDescriptor, false, false, 1, null)));
    }

    private final String e(CallableMemberDescriptor callableMemberDescriptor) {
        String b = SpecialBuiltinMembers.b(callableMemberDescriptor);
        if (b != null) {
            return b;
        }
        if (callableMemberDescriptor instanceof PropertyGetterDescriptor) {
            String b2 = DescriptorUtilsKt.o(callableMemberDescriptor).getName().b();
            k21.h(b2, "descriptor.propertyIfAccessor.name.asString()");
            return t41.a(b2);
        } else if (callableMemberDescriptor instanceof PropertySetterDescriptor) {
            String b3 = DescriptorUtilsKt.o(callableMemberDescriptor).getName().b();
            k21.h(b3, "descriptor.propertyIfAccessor.name.asString()");
            return t41.d(b3);
        } else {
            String b4 = callableMemberDescriptor.getName().b();
            k21.h(b4, "descriptor.name.asString()");
            return b4;
        }
    }

    @NotNull
    public final oi c(@NotNull Class<?> cls) {
        k21.i(cls, "klass");
        if (cls.isArray()) {
            Class<?> componentType = cls.getComponentType();
            k21.h(componentType, "klass.componentType");
            PrimitiveType a2 = a(componentType);
            if (a2 != null) {
                return new oi(c.BUILT_INS_PACKAGE_FQ_NAME, a2.getArrayTypeName());
            }
            oi m = oi.m(c.a.array.l());
            k21.h(m, "ClassId.topLevel(Standar…s.FqNames.array.toSafe())");
            return m;
        } else if (k21.d(cls, Void.TYPE)) {
            return a;
        } else {
            PrimitiveType a3 = a(cls);
            if (a3 != null) {
                return new oi(c.BUILT_INS_PACKAGE_FQ_NAME, a3.getTypeName());
            }
            oi b = ReflectClassUtilKt.b(cls);
            if (!b.k()) {
                w31 w31 = w31.INSTANCE;
                en0 b2 = b.b();
                k21.h(b2, "classId.asSingleFqName()");
                oi n = w31.n(b2);
                if (n != null) {
                    return n;
                }
            }
            return b;
        }
    }

    @NotNull
    public final h51 f(@NotNull PropertyDescriptor propertyDescriptor) {
        k21.i(propertyDescriptor, "possiblyOverriddenProperty");
        CallableMemberDescriptor L = f60.L(propertyDescriptor);
        k21.h(L, "DescriptorUtils.unwrapFa…ssiblyOverriddenProperty)");
        PropertyDescriptor original = ((PropertyDescriptor) L).getOriginal();
        k21.h(original, "DescriptorUtils.unwrapFa…rriddenProperty).original");
        JvmFunctionSignature.c cVar = null;
        Method method = null;
        if (original instanceof r60) {
            r60 r60 = (r60) original;
            ProtoBuf$Property v = r60.getProto();
            GeneratedMessageLite.c<ProtoBuf$Property, JvmProtoBuf.JvmPropertySignature> cVar2 = JvmProtoBuf.propertySignature;
            k21.h(cVar2, "JvmProtoBuf.propertySignature");
            JvmProtoBuf.JvmPropertySignature jvmPropertySignature = (JvmProtoBuf.JvmPropertySignature) fv1.a(v, cVar2);
            if (jvmPropertySignature != null) {
                return new h51.c(original, v, jvmPropertySignature, r60.getNameResolver(), r60.getTypeTable());
            }
        } else if (original instanceof u31) {
            SourceElement source = ((u31) original).getSource();
            if (!(source instanceof JavaSourceElement)) {
                source = null;
            }
            JavaSourceElement javaSourceElement = (JavaSourceElement) source;
            JavaElement javaElement = javaSourceElement != null ? javaSourceElement.getJavaElement() : null;
            if (javaElement instanceof ly1) {
                return new h51.a(((ly1) javaElement).d());
            }
            if (javaElement instanceof oy1) {
                Method f = ((oy1) javaElement).d();
                PropertySetterDescriptor setter = original.getSetter();
                SourceElement source2 = setter != null ? setter.getSource() : null;
                if (!(source2 instanceof JavaSourceElement)) {
                    source2 = null;
                }
                JavaSourceElement javaSourceElement2 = (JavaSourceElement) source2;
                JavaElement javaElement2 = javaSourceElement2 != null ? javaSourceElement2.getJavaElement() : null;
                if (!(javaElement2 instanceof oy1)) {
                    javaElement2 = null;
                }
                oy1 oy1 = (oy1) javaElement2;
                if (oy1 != null) {
                    method = oy1.d();
                }
                return new h51.b(f, method);
            }
            throw new KotlinReflectionInternalError("Incorrect resolution sequence for Java field " + original + " (source = " + javaElement + ')');
        }
        PropertyGetterDescriptor getter = original.getGetter();
        k21.f(getter);
        JvmFunctionSignature.c d = d(getter);
        PropertySetterDescriptor setter2 = original.getSetter();
        if (setter2 != null) {
            cVar = d(setter2);
        }
        return new h51.d(d, cVar);
    }

    @NotNull
    public final JvmFunctionSignature g(@NotNull FunctionDescriptor functionDescriptor) {
        Method f;
        d51.b b;
        d51.b e;
        k21.i(functionDescriptor, "possiblySubstitutedFunction");
        CallableMemberDescriptor L = f60.L(functionDescriptor);
        k21.h(L, "DescriptorUtils.unwrapFa…siblySubstitutedFunction)");
        FunctionDescriptor original = ((FunctionDescriptor) L).getOriginal();
        k21.h(original, "DescriptorUtils.unwrapFa…titutedFunction).original");
        if (original instanceof DeserializedCallableMemberDescriptor) {
            DeserializedCallableMemberDescriptor deserializedCallableMemberDescriptor = (DeserializedCallableMemberDescriptor) original;
            MessageLite proto = deserializedCallableMemberDescriptor.getProto();
            if ((proto instanceof ProtoBuf$Function) && (e = i51.INSTANCE.e((ProtoBuf$Function) proto, deserializedCallableMemberDescriptor.getNameResolver(), deserializedCallableMemberDescriptor.getTypeTable())) != null) {
                return new JvmFunctionSignature.c(e);
            }
            if (!(proto instanceof ProtoBuf$Constructor) || (b = i51.INSTANCE.b((ProtoBuf$Constructor) proto, deserializedCallableMemberDescriptor.getNameResolver(), deserializedCallableMemberDescriptor.getTypeTable())) == null) {
                return d(original);
            }
            DeclarationDescriptor containingDeclaration = functionDescriptor.getContainingDeclaration();
            k21.h(containingDeclaration, "possiblySubstitutedFunction.containingDeclaration");
            if (z01.b(containingDeclaration)) {
                return new JvmFunctionSignature.c(b);
            }
            return new JvmFunctionSignature.b(b);
        }
        JavaElement javaElement = null;
        if (original instanceof JavaMethodDescriptor) {
            SourceElement source = ((JavaMethodDescriptor) original).getSource();
            if (!(source instanceof JavaSourceElement)) {
                source = null;
            }
            JavaSourceElement javaSourceElement = (JavaSourceElement) source;
            JavaElement javaElement2 = javaSourceElement != null ? javaSourceElement.getJavaElement() : null;
            if (javaElement2 instanceof oy1) {
                javaElement = javaElement2;
            }
            oy1 oy1 = (oy1) javaElement;
            if (oy1 != null && (f = oy1.d()) != null) {
                return new JvmFunctionSignature.a(f);
            }
            throw new KotlinReflectionInternalError("Incorrect resolution sequence for Java method " + original);
        } else if (original instanceof j31) {
            SourceElement source2 = ((j31) original).getSource();
            if (!(source2 instanceof JavaSourceElement)) {
                source2 = null;
            }
            JavaSourceElement javaSourceElement2 = (JavaSourceElement) source2;
            if (javaSourceElement2 != null) {
                javaElement = javaSourceElement2.getJavaElement();
            }
            if (javaElement instanceof iy1) {
                return new JvmFunctionSignature.JavaConstructor(((iy1) javaElement).d());
            }
            if (javaElement instanceof ReflectJavaClass) {
                ReflectJavaClass reflectJavaClass = (ReflectJavaClass) javaElement;
                if (reflectJavaClass.isAnnotationType()) {
                    return new JvmFunctionSignature.FakeJavaAnnotationConstructor(reflectJavaClass.getElement());
                }
            }
            throw new KotlinReflectionInternalError("Incorrect resolution sequence for Java constructor " + original + " (" + javaElement + ')');
        } else if (b(original)) {
            return d(original);
        } else {
            throw new KotlinReflectionInternalError("Unknown origin of " + original + " (" + original.getClass() + ')');
        }
    }
}
