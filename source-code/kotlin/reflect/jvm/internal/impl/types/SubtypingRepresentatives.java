package kotlin.reflect.jvm.internal.impl.types;

/* compiled from: TypeCapabilities.kt */
public interface SubtypingRepresentatives {
    KotlinType getSubTypeRepresentative();

    KotlinType getSuperTypeRepresentative();

    boolean sameTypeConstructor(KotlinType kotlinType);
}
