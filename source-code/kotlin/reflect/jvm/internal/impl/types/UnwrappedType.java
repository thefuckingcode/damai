package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

/* compiled from: KotlinType.kt */
public abstract class UnwrappedType extends KotlinType {
    public abstract UnwrappedType makeNullableAsSpecified(boolean z);

    @Override // kotlin.reflect.jvm.internal.impl.types.KotlinType
    public abstract UnwrappedType refine(KotlinTypeRefiner kotlinTypeRefiner);

    public abstract UnwrappedType replaceAnnotations(Annotations annotations);

    @Override // kotlin.reflect.jvm.internal.impl.types.KotlinType
    public final UnwrappedType unwrap() {
        return this;
    }

    private UnwrappedType() {
        super(null);
    }

    public /* synthetic */ UnwrappedType(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
