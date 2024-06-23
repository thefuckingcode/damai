package kotlin.reflect.jvm;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.KFunction;
import kotlin.reflect.KMutableProperty;
import kotlin.reflect.KProperty;
import kotlin.reflect.KProperty1;
import kotlin.reflect.KType;
import kotlin.reflect.full.KClasses;
import kotlin.reflect.jvm.internal.KCallableImpl;
import kotlin.reflect.jvm.internal.KPackageImpl;
import kotlin.reflect.jvm.internal.KPropertyImpl;
import kotlin.reflect.jvm.internal.KTypeImpl;
import kotlin.reflect.jvm.internal.UtilKt;
import kotlin.reflect.jvm.internal.calls.Caller;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectKotlinClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010%\u001a\u0004\u0018\u00010&*\u00020'H\u0002\"/\u0010\u0000\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00038F¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u001b\u0010\b\u001a\u0004\u0018\u00010\t*\u0006\u0012\u0002\b\u00030\n8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f\"\u001b\u0010\r\u001a\u0004\u0018\u00010\u000e*\u0006\u0012\u0002\b\u00030\n8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\"\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u000e*\u0006\u0012\u0002\b\u00030\u00038F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013\"\u001b\u0010\u0014\u001a\u0004\u0018\u00010\u000e*\u0006\u0012\u0002\b\u00030\u00158F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017\"\u0015\u0010\u0018\u001a\u00020\u0019*\u00020\u001a8F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c\"-\u0010\u001d\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0003\"\b\b\u0000\u0010\u0002*\u00020\u001e*\b\u0012\u0004\u0012\u0002H\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\u001f\u0010 \"\u001b\u0010\u001d\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0003*\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\u001f\u0010!\"\u001b\u0010\"\u001a\b\u0012\u0002\b\u0003\u0018\u00010\n*\u00020\t8F¢\u0006\u0006\u001a\u0004\b#\u0010$¨\u0006("}, d2 = {"javaConstructor", "Ljava/lang/reflect/Constructor;", "T", "Lkotlin/reflect/KFunction;", "javaConstructor$annotations", "(Lkotlin/reflect/KFunction;)V", "getJavaConstructor", "(Lkotlin/reflect/KFunction;)Ljava/lang/reflect/Constructor;", "javaField", "Ljava/lang/reflect/Field;", "Lkotlin/reflect/KProperty;", "getJavaField", "(Lkotlin/reflect/KProperty;)Ljava/lang/reflect/Field;", "javaGetter", "Ljava/lang/reflect/Method;", "getJavaGetter", "(Lkotlin/reflect/KProperty;)Ljava/lang/reflect/Method;", "javaMethod", "getJavaMethod", "(Lkotlin/reflect/KFunction;)Ljava/lang/reflect/Method;", "javaSetter", "Lkotlin/reflect/KMutableProperty;", "getJavaSetter", "(Lkotlin/reflect/KMutableProperty;)Ljava/lang/reflect/Method;", "javaType", "Ljava/lang/reflect/Type;", "Lkotlin/reflect/KType;", "getJavaType", "(Lkotlin/reflect/KType;)Ljava/lang/reflect/Type;", "kotlinFunction", "", "getKotlinFunction", "(Ljava/lang/reflect/Constructor;)Lkotlin/reflect/KFunction;", "(Ljava/lang/reflect/Method;)Lkotlin/reflect/KFunction;", "kotlinProperty", "getKotlinProperty", "(Ljava/lang/reflect/Field;)Lkotlin/reflect/KProperty;", "getKPackage", "Lkotlin/reflect/KDeclarationContainer;", "Ljava/lang/reflect/Member;", "kotlin-reflection"}, k = 2, mv = {1, 1, 16})
/* compiled from: ReflectJvmMapping.kt */
public final class ReflectJvmMapping {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[KotlinClassHeader.Kind.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[KotlinClassHeader.Kind.FILE_FACADE.ordinal()] = 1;
            iArr[KotlinClassHeader.Kind.MULTIFILE_CLASS.ordinal()] = 2;
            iArr[KotlinClassHeader.Kind.MULTIFILE_CLASS_PART.ordinal()] = 3;
        }
    }

    public static /* synthetic */ void javaConstructor$annotations(KFunction kFunction) {
    }

    public static final Field getJavaField(KProperty<?> kProperty) {
        Intrinsics.checkParameterIsNotNull(kProperty, "$this$javaField");
        KPropertyImpl<?> asKPropertyImpl = UtilKt.asKPropertyImpl(kProperty);
        if (asKPropertyImpl != null) {
            return asKPropertyImpl.getJavaField();
        }
        return null;
    }

    public static final Method getJavaGetter(KProperty<?> kProperty) {
        Intrinsics.checkParameterIsNotNull(kProperty, "$this$javaGetter");
        return getJavaMethod(kProperty.getGetter());
    }

    public static final Method getJavaSetter(KMutableProperty<?> kMutableProperty) {
        Intrinsics.checkParameterIsNotNull(kMutableProperty, "$this$javaSetter");
        return getJavaMethod(kMutableProperty.getSetter());
    }

    public static final Method getJavaMethod(KFunction<?> kFunction) {
        Caller<?> caller;
        Intrinsics.checkParameterIsNotNull(kFunction, "$this$javaMethod");
        KCallableImpl<?> asKCallableImpl = UtilKt.asKCallableImpl(kFunction);
        Object obj = null;
        Object member = (asKCallableImpl == null || (caller = asKCallableImpl.getCaller()) == null) ? null : caller.getMember();
        if (member instanceof Method) {
            obj = member;
        }
        return (Method) obj;
    }

    public static final <T> Constructor<T> getJavaConstructor(KFunction<? extends T> kFunction) {
        Caller<?> caller;
        Intrinsics.checkParameterIsNotNull(kFunction, "$this$javaConstructor");
        KCallableImpl<?> asKCallableImpl = UtilKt.asKCallableImpl(kFunction);
        Object obj = null;
        Object member = (asKCallableImpl == null || (caller = asKCallableImpl.getCaller()) == null) ? null : caller.getMember();
        if (member instanceof Constructor) {
            obj = member;
        }
        return (Constructor) obj;
    }

    public static final Type getJavaType(KType kType) {
        Intrinsics.checkParameterIsNotNull(kType, "$this$javaType");
        return ((KTypeImpl) kType).getJavaType$kotlin_reflection();
    }

    public static final KProperty<?> getKotlinProperty(Field field) {
        Intrinsics.checkParameterIsNotNull(field, "$this$kotlinProperty");
        Object obj = null;
        if (field.isSynthetic()) {
            return null;
        }
        KDeclarationContainer kPackage = getKPackage(field);
        if (kPackage != null) {
            ArrayList arrayList = new ArrayList();
            for (T t : kPackage.getMembers()) {
                if (t instanceof KProperty) {
                    arrayList.add(t);
                }
            }
            Iterator it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (Intrinsics.areEqual(getJavaField((KProperty) next), field)) {
                    obj = next;
                    break;
                }
            }
            return (KProperty) obj;
        }
        Class<?> declaringClass = field.getDeclaringClass();
        Intrinsics.checkExpressionValueIsNotNull(declaringClass, "declaringClass");
        Iterator it2 = KClasses.getMemberProperties(JvmClassMappingKt.getKotlinClass(declaringClass)).iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            Object next2 = it2.next();
            if (Intrinsics.areEqual(getJavaField((KProperty1) next2), field)) {
                obj = next2;
                break;
            }
        }
        return (KProperty) obj;
    }

    private static final KDeclarationContainer getKPackage(Member member) {
        KotlinClassHeader classHeader;
        ReflectKotlinClass.Factory factory = ReflectKotlinClass.Factory;
        Class<?> declaringClass = member.getDeclaringClass();
        Intrinsics.checkExpressionValueIsNotNull(declaringClass, "declaringClass");
        ReflectKotlinClass create = factory.create(declaringClass);
        KotlinClassHeader.Kind kind = (create == null || (classHeader = create.getClassHeader()) == null) ? null : classHeader.getKind();
        if (kind == null) {
            return null;
        }
        int i = WhenMappings.$EnumSwitchMapping$0[kind.ordinal()];
        if (i != 1 && i != 2 && i != 3) {
            return null;
        }
        Class<?> declaringClass2 = member.getDeclaringClass();
        Intrinsics.checkExpressionValueIsNotNull(declaringClass2, "declaringClass");
        return new KPackageImpl(declaringClass2, null, 2, null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:56:0x00ca A[EDGE_INSN: B:56:0x00ca->B:38:0x00ca ?: BREAK  , SYNTHETIC] */
    public static final KFunction<?> getKotlinFunction(Method method) {
        T t;
        boolean z;
        Intrinsics.checkParameterIsNotNull(method, "$this$kotlinFunction");
        Object obj = null;
        if (Modifier.isStatic(method.getModifiers())) {
            KDeclarationContainer kPackage = getKPackage(method);
            if (kPackage != null) {
                ArrayList arrayList = new ArrayList();
                for (T t2 : kPackage.getMembers()) {
                    if (t2 instanceof KFunction) {
                        arrayList.add(t2);
                    }
                }
                Iterator it = arrayList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next = it.next();
                    if (Intrinsics.areEqual(getJavaMethod((KFunction) next), method)) {
                        obj = next;
                        break;
                    }
                }
                return (KFunction) obj;
            }
            Class<?> declaringClass = method.getDeclaringClass();
            Intrinsics.checkExpressionValueIsNotNull(declaringClass, "declaringClass");
            KClass<?> companionObject = KClasses.getCompanionObject(JvmClassMappingKt.getKotlinClass(declaringClass));
            if (companionObject != null) {
                Iterator<T> it2 = KClasses.getFunctions(companionObject).iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        t = null;
                        break;
                    }
                    t = it2.next();
                    Method javaMethod = getJavaMethod(t);
                    if (javaMethod != null && Intrinsics.areEqual(javaMethod.getName(), method.getName())) {
                        Class<?>[] parameterTypes = javaMethod.getParameterTypes();
                        if (parameterTypes == null) {
                            Intrinsics.throwNpe();
                        }
                        Class<?>[] parameterTypes2 = method.getParameterTypes();
                        Intrinsics.checkExpressionValueIsNotNull(parameterTypes2, "this.parameterTypes");
                        if (Arrays.equals(parameterTypes, parameterTypes2) && Intrinsics.areEqual(javaMethod.getReturnType(), method.getReturnType())) {
                            z = true;
                            continue;
                            if (z) {
                                break;
                            }
                        }
                    }
                    z = false;
                    continue;
                    if (z) {
                    }
                }
                T t3 = t;
                if (t3 != null) {
                    return t3;
                }
            }
        }
        Class<?> declaringClass2 = method.getDeclaringClass();
        Intrinsics.checkExpressionValueIsNotNull(declaringClass2, "declaringClass");
        Iterator<T> it3 = KClasses.getFunctions(JvmClassMappingKt.getKotlinClass(declaringClass2)).iterator();
        while (true) {
            if (!it3.hasNext()) {
                break;
            }
            Object next2 = it3.next();
            if (Intrinsics.areEqual(getJavaMethod((KFunction) next2), method)) {
                obj = next2;
                break;
            }
        }
        return (KFunction) obj;
    }

    public static final <T> KFunction<T> getKotlinFunction(Constructor<T> constructor) {
        T t;
        Intrinsics.checkParameterIsNotNull(constructor, "$this$kotlinFunction");
        Class<T> declaringClass = constructor.getDeclaringClass();
        Intrinsics.checkExpressionValueIsNotNull(declaringClass, "declaringClass");
        Iterator<T> it = JvmClassMappingKt.getKotlinClass(declaringClass).getConstructors().iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            t = it.next();
            if (Intrinsics.areEqual(getJavaConstructor(t), constructor)) {
                break;
            }
        }
        return t;
    }
}
