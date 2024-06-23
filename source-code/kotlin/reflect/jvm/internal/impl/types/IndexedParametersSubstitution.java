package kotlin.reflect.jvm.internal.impl.types;

import com.lzy.okgo.cache.CacheEntity;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;

/* compiled from: TypeSubstitution.kt */
public final class IndexedParametersSubstitution extends TypeSubstitution {
    private final boolean approximateCapturedTypes;
    private final TypeProjection[] arguments;
    private final TypeParameterDescriptor[] parameters;

    public final TypeParameterDescriptor[] getParameters() {
        return this.parameters;
    }

    public final TypeProjection[] getArguments() {
        return this.arguments;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ IndexedParametersSubstitution(TypeParameterDescriptor[] typeParameterDescriptorArr, TypeProjection[] typeProjectionArr, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(typeParameterDescriptorArr, typeProjectionArr, (i & 4) != 0 ? false : z);
    }

    public IndexedParametersSubstitution(TypeParameterDescriptor[] typeParameterDescriptorArr, TypeProjection[] typeProjectionArr, boolean z) {
        Intrinsics.checkParameterIsNotNull(typeParameterDescriptorArr, "parameters");
        Intrinsics.checkParameterIsNotNull(typeProjectionArr, "arguments");
        this.parameters = typeParameterDescriptorArr;
        this.arguments = typeProjectionArr;
        this.approximateCapturedTypes = z;
        int length = typeParameterDescriptorArr.length;
        int length2 = typeProjectionArr.length;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    public IndexedParametersSubstitution(List<? extends TypeParameterDescriptor> list, List<? extends TypeProjection> list2) {
        this(r3, (TypeProjection[]) r9, false, 4, null);
        Intrinsics.checkParameterIsNotNull(list, "parameters");
        Intrinsics.checkParameterIsNotNull(list2, "argumentsList");
        Object[] array = list.toArray(new TypeParameterDescriptor[0]);
        if (array != null) {
            TypeParameterDescriptor[] typeParameterDescriptorArr = (TypeParameterDescriptor[]) array;
            Object[] array2 = list2.toArray(new TypeProjection[0]);
            if (array2 != null) {
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
    public boolean isEmpty() {
        return this.arguments.length == 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
    public boolean approximateContravariantCapturedTypes() {
        return this.approximateCapturedTypes;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
    public TypeProjection get(KotlinType kotlinType) {
        Intrinsics.checkParameterIsNotNull(kotlinType, CacheEntity.KEY);
        ClassifierDescriptor declarationDescriptor = kotlinType.getConstructor().getDeclarationDescriptor();
        if (!(declarationDescriptor instanceof TypeParameterDescriptor)) {
            declarationDescriptor = null;
        }
        TypeParameterDescriptor typeParameterDescriptor = (TypeParameterDescriptor) declarationDescriptor;
        if (typeParameterDescriptor != null) {
            int index = typeParameterDescriptor.getIndex();
            TypeParameterDescriptor[] typeParameterDescriptorArr = this.parameters;
            if (index < typeParameterDescriptorArr.length && Intrinsics.areEqual(typeParameterDescriptorArr[index].getTypeConstructor(), typeParameterDescriptor.getTypeConstructor())) {
                return this.arguments[index];
            }
        }
        return null;
    }
}
