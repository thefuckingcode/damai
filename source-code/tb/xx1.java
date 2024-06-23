package tb;

import com.alibaba.android.ultron.trade.event.OpenSimplePopupSubscriber;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;
import kotlin.collections.e;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.builtins.c;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import org.jetbrains.annotations.NotNull;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class xx1 {
    @NotNull
    public static final xx1 INSTANCE = new xx1();

    private xx1() {
    }

    private final pi a(Class<?> cls) {
        int i = 0;
        while (cls.isArray()) {
            i++;
            cls = cls.getComponentType();
            k21.h(cls, "currentClass.componentType");
        }
        if (!cls.isPrimitive()) {
            oi b = ReflectClassUtilKt.b(cls);
            w31 w31 = w31.INSTANCE;
            en0 b2 = b.b();
            k21.h(b2, "javaClassId.asSingleFqName()");
            oi n = w31.n(b2);
            if (n != null) {
                b = n;
            }
            return new pi(b, i);
        } else if (k21.d(cls, Void.TYPE)) {
            oi m = oi.m(c.a.unit.l());
            k21.h(m, "topLevel(StandardNames.FqNames.unit.toSafe())");
            return new pi(m, i);
        } else {
            PrimitiveType primitiveType = JvmPrimitiveType.get(cls.getName()).getPrimitiveType();
            k21.h(primitiveType, "get(currentClass.name).primitiveType");
            if (i > 0) {
                oi m2 = oi.m(primitiveType.getArrayTypeFqName());
                k21.h(m2, "topLevel(primitiveType.arrayTypeFqName)");
                return new pi(m2, i - 1);
            }
            oi m3 = oi.m(primitiveType.getTypeFqName());
            k21.h(m3, "topLevel(primitiveType.typeFqName)");
            return new pi(m3, i);
        }
    }

    private final void c(Class<?> cls, KotlinJvmBinaryClass.MemberVisitor memberVisitor) {
        int i;
        Constructor<?>[] constructorArr;
        int i2;
        Constructor<?>[] declaredConstructors = cls.getDeclaredConstructors();
        k21.h(declaredConstructors, "klass.declaredConstructors");
        int length = declaredConstructors.length;
        int i3 = 0;
        while (i3 < length) {
            Constructor<?> constructor = declaredConstructors[i3];
            int i4 = i3 + 1;
            og1 i5 = og1.i("<init>");
            k21.h(i5, "special(\"<init>\")");
            ua2 ua2 = ua2.INSTANCE;
            k21.h(constructor, "constructor");
            KotlinJvmBinaryClass.MethodAnnotationVisitor visitMethod = memberVisitor.visitMethod(i5, ua2.a(constructor));
            if (visitMethod == null) {
                constructorArr = declaredConstructors;
                i2 = length;
                i = i4;
            } else {
                Annotation[] declaredAnnotations = constructor.getDeclaredAnnotations();
                k21.h(declaredAnnotations, "constructor.declaredAnnotations");
                int length2 = declaredAnnotations.length;
                int i6 = 0;
                while (i6 < length2) {
                    Annotation annotation = declaredAnnotations[i6];
                    i6++;
                    k21.h(annotation, "annotation");
                    f(visitMethod, annotation);
                }
                Annotation[][] parameterAnnotations = constructor.getParameterAnnotations();
                k21.h(parameterAnnotations, "parameterAnnotations");
                if (!(parameterAnnotations.length == 0)) {
                    int length3 = constructor.getParameterTypes().length - parameterAnnotations.length;
                    int length4 = parameterAnnotations.length;
                    int i7 = 0;
                    while (i7 < length4) {
                        Annotation[] annotationArr = parameterAnnotations[i7];
                        int i8 = i7 + 1;
                        k21.h(annotationArr, "annotations");
                        int length5 = annotationArr.length;
                        int i9 = 0;
                        while (i9 < length5) {
                            Annotation annotation2 = annotationArr[i9];
                            i9++;
                            Class<?> b = z41.b(z41.a(annotation2));
                            oi b2 = ReflectClassUtilKt.b(b);
                            k21.h(annotation2, "annotation");
                            KotlinJvmBinaryClass.AnnotationArgumentVisitor visitParameterAnnotation = visitMethod.visitParameterAnnotation(i7 + length3, b2, new wx1(annotation2));
                            if (visitParameterAnnotation != null) {
                                h(visitParameterAnnotation, annotation2, b);
                            }
                            length = length;
                            declaredConstructors = declaredConstructors;
                            i4 = i4;
                            length3 = length3;
                        }
                        i7 = i8;
                    }
                }
                constructorArr = declaredConstructors;
                i2 = length;
                i = i4;
                visitMethod.visitEnd();
            }
            length = i2;
            declaredConstructors = constructorArr;
            i3 = i;
        }
    }

    private final void d(Class<?> cls, KotlinJvmBinaryClass.MemberVisitor memberVisitor) {
        Field[] declaredFields = cls.getDeclaredFields();
        k21.h(declaredFields, "klass.declaredFields");
        int length = declaredFields.length;
        int i = 0;
        while (i < length) {
            Field field = declaredFields[i];
            i++;
            og1 f = og1.f(field.getName());
            k21.h(f, "identifier(field.name)");
            ua2 ua2 = ua2.INSTANCE;
            k21.h(field, "field");
            KotlinJvmBinaryClass.AnnotationVisitor visitField = memberVisitor.visitField(f, ua2.b(field), null);
            if (visitField != null) {
                Annotation[] declaredAnnotations = field.getDeclaredAnnotations();
                k21.h(declaredAnnotations, "field.declaredAnnotations");
                int length2 = declaredAnnotations.length;
                int i2 = 0;
                while (i2 < length2) {
                    Annotation annotation = declaredAnnotations[i2];
                    i2++;
                    k21.h(annotation, "annotation");
                    f(visitField, annotation);
                }
                visitField.visitEnd();
            }
        }
    }

    private final void e(Class<?> cls, KotlinJvmBinaryClass.MemberVisitor memberVisitor) {
        int i;
        Method[] methodArr;
        Method[] declaredMethods = cls.getDeclaredMethods();
        k21.h(declaredMethods, "klass.declaredMethods");
        int length = declaredMethods.length;
        int i2 = 0;
        while (i2 < length) {
            Method method = declaredMethods[i2];
            i2++;
            og1 f = og1.f(method.getName());
            k21.h(f, "identifier(method.name)");
            ua2 ua2 = ua2.INSTANCE;
            k21.h(method, "method");
            KotlinJvmBinaryClass.MethodAnnotationVisitor visitMethod = memberVisitor.visitMethod(f, ua2.c(method));
            if (visitMethod == null) {
                methodArr = declaredMethods;
                i = length;
            } else {
                Annotation[] declaredAnnotations = method.getDeclaredAnnotations();
                k21.h(declaredAnnotations, "method.declaredAnnotations");
                int length2 = declaredAnnotations.length;
                int i3 = 0;
                while (i3 < length2) {
                    Annotation annotation = declaredAnnotations[i3];
                    i3++;
                    k21.h(annotation, "annotation");
                    f(visitMethod, annotation);
                }
                Annotation[][] parameterAnnotations = method.getParameterAnnotations();
                k21.h(parameterAnnotations, "method.parameterAnnotations");
                int length3 = parameterAnnotations.length;
                int i4 = 0;
                while (i4 < length3) {
                    Annotation[] annotationArr = parameterAnnotations[i4];
                    int i5 = i4 + 1;
                    k21.h(annotationArr, "annotations");
                    int length4 = annotationArr.length;
                    int i6 = 0;
                    while (i6 < length4) {
                        Annotation annotation2 = annotationArr[i6];
                        i6++;
                        Class<?> b = z41.b(z41.a(annotation2));
                        oi b2 = ReflectClassUtilKt.b(b);
                        k21.h(annotation2, "annotation");
                        KotlinJvmBinaryClass.AnnotationArgumentVisitor visitParameterAnnotation = visitMethod.visitParameterAnnotation(i4, b2, new wx1(annotation2));
                        if (visitParameterAnnotation != null) {
                            h(visitParameterAnnotation, annotation2, b);
                        }
                        declaredMethods = declaredMethods;
                        length = length;
                    }
                    i4 = i5;
                }
                methodArr = declaredMethods;
                i = length;
                visitMethod.visitEnd();
            }
            declaredMethods = methodArr;
            length = i;
        }
    }

    private final void f(KotlinJvmBinaryClass.AnnotationVisitor annotationVisitor, Annotation annotation) {
        Class<?> b = z41.b(z41.a(annotation));
        KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation = annotationVisitor.visitAnnotation(ReflectClassUtilKt.b(b), new wx1(annotation));
        if (visitAnnotation != null) {
            h(visitAnnotation, annotation, b);
        }
    }

    private final void g(KotlinJvmBinaryClass.AnnotationArgumentVisitor annotationArgumentVisitor, og1 og1, Object obj) {
        Class<?> cls = obj.getClass();
        if (k21.d(cls, Class.class)) {
            annotationArgumentVisitor.visitClassLiteral(og1, a((Class) obj));
        } else if (zy1.a().contains(cls)) {
            annotationArgumentVisitor.visit(og1, obj);
        } else if (ReflectClassUtilKt.i(cls)) {
            if (!cls.isEnum()) {
                cls = cls.getEnclosingClass();
            }
            k21.h(cls, "if (clazz.isEnum) clazz else clazz.enclosingClass");
            oi b = ReflectClassUtilKt.b(cls);
            og1 f = og1.f(((Enum) obj).name());
            k21.h(f, "identifier((value as Enum<*>).name)");
            annotationArgumentVisitor.visitEnum(og1, b, f);
        } else if (Annotation.class.isAssignableFrom(cls)) {
            Class<?>[] interfaces = cls.getInterfaces();
            k21.h(interfaces, "clazz.interfaces");
            Class<?> cls2 = (Class) e.L(interfaces);
            k21.h(cls2, "annotationClass");
            KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation = annotationArgumentVisitor.visitAnnotation(og1, ReflectClassUtilKt.b(cls2));
            if (visitAnnotation != null) {
                h(visitAnnotation, (Annotation) obj, cls2);
            }
        } else if (cls.isArray()) {
            KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor visitArray = annotationArgumentVisitor.visitArray(og1);
            if (visitArray != null) {
                Class<?> componentType = cls.getComponentType();
                int i = 0;
                if (componentType.isEnum()) {
                    k21.h(componentType, OpenSimplePopupSubscriber.KEY_COMPONENT_TYPE);
                    oi b2 = ReflectClassUtilKt.b(componentType);
                    Object[] objArr = (Object[]) obj;
                    int length = objArr.length;
                    while (i < length) {
                        Object obj2 = objArr[i];
                        i++;
                        Objects.requireNonNull(obj2, "null cannot be cast to non-null type kotlin.Enum<*>");
                        og1 f2 = og1.f(((Enum) obj2).name());
                        k21.h(f2, "identifier((element as Enum<*>).name)");
                        visitArray.visitEnum(b2, f2);
                    }
                } else if (k21.d(componentType, Class.class)) {
                    Object[] objArr2 = (Object[]) obj;
                    int length2 = objArr2.length;
                    while (i < length2) {
                        Object obj3 = objArr2[i];
                        i++;
                        Objects.requireNonNull(obj3, "null cannot be cast to non-null type java.lang.Class<*>");
                        visitArray.visitClassLiteral(a((Class) obj3));
                    }
                } else {
                    Object[] objArr3 = (Object[]) obj;
                    int length3 = objArr3.length;
                    while (i < length3) {
                        Object obj4 = objArr3[i];
                        i++;
                        visitArray.visit(obj4);
                    }
                }
                visitArray.visitEnd();
            }
        } else {
            throw new UnsupportedOperationException("Unsupported annotation argument value (" + cls + "): " + obj);
        }
    }

    private final void h(KotlinJvmBinaryClass.AnnotationArgumentVisitor annotationArgumentVisitor, Annotation annotation, Class<?> cls) {
        Method[] declaredMethods = cls.getDeclaredMethods();
        k21.h(declaredMethods, "annotationType.declaredMethods");
        int length = declaredMethods.length;
        int i = 0;
        while (i < length) {
            Method method = declaredMethods[i];
            i++;
            try {
                Object invoke = method.invoke(annotation, new Object[0]);
                k21.f(invoke);
                og1 f = og1.f(method.getName());
                k21.h(f, "identifier(method.name)");
                g(annotationArgumentVisitor, f, invoke);
            } catch (IllegalAccessException unused) {
            }
        }
        annotationArgumentVisitor.visitEnd();
    }

    public final void b(@NotNull Class<?> cls, @NotNull KotlinJvmBinaryClass.AnnotationVisitor annotationVisitor) {
        k21.i(cls, "klass");
        k21.i(annotationVisitor, "visitor");
        Annotation[] declaredAnnotations = cls.getDeclaredAnnotations();
        k21.h(declaredAnnotations, "klass.declaredAnnotations");
        int length = declaredAnnotations.length;
        int i = 0;
        while (i < length) {
            Annotation annotation = declaredAnnotations[i];
            i++;
            k21.h(annotation, "annotation");
            f(annotationVisitor, annotation);
        }
        annotationVisitor.visitEnd();
    }

    public final void i(@NotNull Class<?> cls, @NotNull KotlinJvmBinaryClass.MemberVisitor memberVisitor) {
        k21.i(cls, "klass");
        k21.i(memberVisitor, "memberVisitor");
        e(cls, memberVisitor);
        c(cls, memberVisitor);
        d(cls, memberVisitor);
    }
}
