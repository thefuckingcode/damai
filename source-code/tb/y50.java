package tb;

import kotlin.jvm.functions.Function3;
import kotlin.reflect.jvm.internal.impl.builtins.b;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmTypeFactory;
import kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingConfiguration;
import kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlin.reflect.jvm.internal.impl.utils.FunctionsKt;
import kotlin.text.o;

public final class y50 {
    public static final String a(ClassDescriptor classDescriptor, TypeMappingConfiguration<?> typeMappingConfiguration) {
        k21.i(classDescriptor, "klass");
        k21.i(typeMappingConfiguration, "typeMappingConfiguration");
        String predefinedFullInternalNameForClass = typeMappingConfiguration.getPredefinedFullInternalNameForClass(classDescriptor);
        if (predefinedFullInternalNameForClass != null) {
            return predefinedFullInternalNameForClass;
        }
        DeclarationDescriptor containingDeclaration = classDescriptor.getContainingDeclaration();
        k21.h(containingDeclaration, "klass.containingDeclaration");
        String d = dd2.c(classDescriptor.getName()).d();
        k21.h(d, "safeIdentifier(klass.name).identifier");
        if (containingDeclaration instanceof PackageFragmentDescriptor) {
            en0 fqName = ((PackageFragmentDescriptor) containingDeclaration).getFqName();
            if (fqName.d()) {
                return d;
            }
            StringBuilder sb = new StringBuilder();
            String b = fqName.b();
            k21.h(b, "fqName.asString()");
            sb.append(o.E(b, '.', v00.DIR, false, 4, null));
            sb.append(v00.DIR);
            sb.append(d);
            return sb.toString();
        }
        ClassDescriptor classDescriptor2 = containingDeclaration instanceof ClassDescriptor ? (ClassDescriptor) containingDeclaration : null;
        if (classDescriptor2 != null) {
            String predefinedInternalNameForClass = typeMappingConfiguration.getPredefinedInternalNameForClass(classDescriptor2);
            if (predefinedInternalNameForClass == null) {
                predefinedInternalNameForClass = a(classDescriptor2, typeMappingConfiguration);
            }
            return predefinedInternalNameForClass + '$' + d;
        }
        throw new IllegalArgumentException("Unexpected container: " + containingDeclaration + " for " + classDescriptor);
    }

    public static /* synthetic */ String b(ClassDescriptor classDescriptor, TypeMappingConfiguration typeMappingConfiguration, int i, Object obj) {
        if ((i & 2) != 0) {
            typeMappingConfiguration = qo2.INSTANCE;
        }
        return a(classDescriptor, typeMappingConfiguration);
    }

    public static final boolean c(CallableDescriptor callableDescriptor) {
        k21.i(callableDescriptor, "descriptor");
        if (callableDescriptor instanceof ConstructorDescriptor) {
            return true;
        }
        g61 returnType = callableDescriptor.getReturnType();
        k21.f(returnType);
        if (b.J0(returnType)) {
            g61 returnType2 = callableDescriptor.getReturnType();
            k21.f(returnType2);
            if (bp2.l(returnType2) || (callableDescriptor instanceof PropertyGetterDescriptor)) {
                return false;
            }
            return true;
        }
        return false;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r9v0, resolved type: kotlin.reflect.jvm.internal.impl.load.kotlin.JvmTypeFactory<T> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v1, types: [T, java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    public static final <T> T d(g61 g61, JvmTypeFactory<T> jvmTypeFactory, ro2 ro2, TypeMappingConfiguration<? extends T> typeMappingConfiguration, b51<T> b51, Function3<? super g61, ? super T, ? super ro2, ur2> function3) {
        Object obj;
        g61 g612;
        Object obj2;
        k21.i(g61, "kotlinType");
        k21.i(jvmTypeFactory, "factory");
        k21.i(ro2, "mode");
        k21.i(typeMappingConfiguration, "typeMappingConfiguration");
        k21.i(function3, "writeGenericType");
        g61 preprocessType = typeMappingConfiguration.preprocessType(g61);
        if (preprocessType != null) {
            return (T) d(preprocessType, jvmTypeFactory, ro2, typeMappingConfiguration, b51, function3);
        }
        if (rn0.o(g61)) {
            return (T) d(eh2.b(g61, typeMappingConfiguration.releaseCoroutines()), jvmTypeFactory, ro2, typeMappingConfiguration, b51, function3);
        }
        ab2 ab2 = ab2.INSTANCE;
        Object b = wo2.b(ab2, g61, jvmTypeFactory, ro2);
        if (b == null) {
            TypeConstructor c = g61.c();
            if (c instanceof IntersectionTypeConstructor) {
                IntersectionTypeConstructor intersectionTypeConstructor = (IntersectionTypeConstructor) c;
                g61 c2 = intersectionTypeConstructor.c();
                if (c2 == null) {
                    c2 = typeMappingConfiguration.commonSupertype(intersectionTypeConstructor.getSupertypes());
                }
                return (T) d(TypeUtilsKt.m(c2), jvmTypeFactory, ro2, typeMappingConfiguration, b51, function3);
            }
            ClassifierDescriptor declarationDescriptor = c.getDeclarationDescriptor();
            if (declarationDescriptor == null) {
                throw new UnsupportedOperationException(k21.r("no descriptor for type constructor of ", g61));
            } else if (me0.r(declarationDescriptor)) {
                T t = (T) jvmTypeFactory.createObjectType("error/NonExistentClass");
                typeMappingConfiguration.processErrorType(g61, (ClassDescriptor) declarationDescriptor);
                return t;
            } else {
                boolean z = declarationDescriptor instanceof ClassDescriptor;
                if (!z || !b.b0(g61)) {
                    if (z) {
                        if (z01.b(declarationDescriptor) && !ro2.c() && (g612 = (g61) vf0.a(ab2, g61)) != null) {
                            return (T) d(g612, jvmTypeFactory, ro2.g(), typeMappingConfiguration, b51, function3);
                        }
                        if (!ro2.e() || !b.q0((ClassDescriptor) declarationDescriptor)) {
                            ClassDescriptor classDescriptor = (ClassDescriptor) declarationDescriptor;
                            ClassDescriptor original = classDescriptor.getOriginal();
                            k21.h(original, "descriptor.original");
                            Object predefinedTypeForClass = typeMappingConfiguration.getPredefinedTypeForClass(original);
                            if (predefinedTypeForClass == null) {
                                if (classDescriptor.getKind() == ClassKind.ENUM_ENTRY) {
                                    classDescriptor = (ClassDescriptor) classDescriptor.getContainingDeclaration();
                                }
                                ClassDescriptor original2 = classDescriptor.getOriginal();
                                k21.h(original2, "enumClassIfEnumEntry.original");
                                obj = (Object) jvmTypeFactory.createObjectType(a(original2, typeMappingConfiguration));
                            } else {
                                obj = (Object) predefinedTypeForClass;
                            }
                        } else {
                            obj = (Object) jvmTypeFactory.getJavaLangClassType();
                        }
                        function3.invoke(g61, obj, ro2);
                        return (T) obj;
                    } else if (declarationDescriptor instanceof TypeParameterDescriptor) {
                        return (T) d(TypeUtilsKt.f((TypeParameterDescriptor) declarationDescriptor), jvmTypeFactory, ro2, typeMappingConfiguration, null, FunctionsKt.b());
                    } else {
                        if ((declarationDescriptor instanceof TypeAliasDescriptor) && ro2.b()) {
                            return (T) d(((TypeAliasDescriptor) declarationDescriptor).getExpandedType(), jvmTypeFactory, ro2, typeMappingConfiguration, b51, function3);
                        }
                        throw new UnsupportedOperationException(k21.r("Unknown type ", g61));
                    }
                } else if (g61.b().size() == 1) {
                    TypeProjection typeProjection = g61.b().get(0);
                    g61 type = typeProjection.getType();
                    k21.h(type, "memberProjection.type");
                    if (typeProjection.getProjectionKind() == Variance.IN_VARIANCE) {
                        obj2 = jvmTypeFactory.createObjectType("java/lang/Object");
                    } else {
                        Variance projectionKind = typeProjection.getProjectionKind();
                        k21.h(projectionKind, "memberProjection.projectionKind");
                        obj2 = d(type, jvmTypeFactory, ro2.f(projectionKind, true), typeMappingConfiguration, b51, function3);
                    }
                    return (T) jvmTypeFactory.createFromString(k21.r(jl1.ARRAY_START_STR, jvmTypeFactory.toString(obj2)));
                } else {
                    throw new UnsupportedOperationException("arrays must have one type argument");
                }
            }
        } else {
            ?? r9 = (Object) wo2.a(jvmTypeFactory, b, ro2.d());
            function3.invoke(g61, r9, ro2);
            return r9;
        }
    }

    public static /* synthetic */ Object e(g61 g61, JvmTypeFactory jvmTypeFactory, ro2 ro2, TypeMappingConfiguration typeMappingConfiguration, b51 b51, Function3 function3, int i, Object obj) {
        if ((i & 32) != 0) {
            function3 = FunctionsKt.b();
        }
        return d(g61, jvmTypeFactory, ro2, typeMappingConfiguration, b51, function3);
    }
}
