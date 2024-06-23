package tb;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.collections.k;
import kotlin.jvm.JvmName;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import org.jetbrains.annotations.NotNull;

@JvmName(name = "KTypesJvm")
/* compiled from: Taobao */
public final class s51 {
    @NotNull
    public static final KClass<?> a(@NotNull KClassifier kClassifier) {
        T t;
        KClass<?> b;
        boolean z;
        k21.i(kClassifier, "$this$jvmErasure");
        if (kClassifier instanceof KClass) {
            return (KClass) kClassifier;
        }
        if (kClassifier instanceof KTypeParameter) {
            List<KType> upperBounds = ((KTypeParameter) kClassifier).getUpperBounds();
            Iterator<T> it = upperBounds.iterator();
            while (true) {
                t = null;
                if (!it.hasNext()) {
                    break;
                }
                T next = it.next();
                T t2 = next;
                Objects.requireNonNull(t2, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.KTypeImpl");
                ClassifierDescriptor declarationDescriptor = t2.c().c().getDeclarationDescriptor();
                if (declarationDescriptor instanceof ClassDescriptor) {
                    t = declarationDescriptor;
                }
                T t3 = t;
                if (t3 == null || t3.getKind() == ClassKind.INTERFACE || t3.getKind() == ClassKind.ANNOTATION_CLASS) {
                    z = false;
                    continue;
                } else {
                    z = true;
                    continue;
                }
                if (z) {
                    t = next;
                    break;
                }
            }
            T t4 = t;
            if (t4 == null) {
                t4 = (KType) k.R(upperBounds);
            }
            return (t4 == null || (b = b(t4)) == null) ? dz1.b(Object.class) : b;
        }
        throw new KotlinReflectionInternalError("Cannot calculate JVM erasure for type: " + kClassifier);
    }

    @NotNull
    public static final KClass<?> b(@NotNull KType kType) {
        KClass<?> a;
        k21.i(kType, "$this$jvmErasure");
        KClassifier classifier = kType.getClassifier();
        if (classifier != null && (a = a(classifier)) != null) {
            return a;
        }
        throw new KotlinReflectionInternalError("Cannot calculate JVM erasure for type: " + kType);
    }
}
