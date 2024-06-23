package tb;

import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.List;
import java.util.Objects;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class r01 extends xo2 {
    @NotNull
    private final TypeParameterDescriptor[] a;
    @NotNull
    private final TypeProjection[] b;
    private final boolean c;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ r01(TypeParameterDescriptor[] typeParameterDescriptorArr, TypeProjection[] typeProjectionArr, boolean z, int i, m40 m40) {
        this(typeParameterDescriptorArr, typeProjectionArr, (i & 4) != 0 ? false : z);
    }

    @Override // tb.xo2
    public boolean b() {
        return this.c;
    }

    @Override // tb.xo2
    @Nullable
    public TypeProjection e(@NotNull g61 g61) {
        k21.i(g61, "key");
        ClassifierDescriptor declarationDescriptor = g61.c().getDeclarationDescriptor();
        TypeParameterDescriptor typeParameterDescriptor = declarationDescriptor instanceof TypeParameterDescriptor ? (TypeParameterDescriptor) declarationDescriptor : null;
        if (typeParameterDescriptor == null) {
            return null;
        }
        int index = typeParameterDescriptor.getIndex();
        TypeParameterDescriptor[] typeParameterDescriptorArr = this.a;
        if (index >= typeParameterDescriptorArr.length || !k21.d(typeParameterDescriptorArr[index].getTypeConstructor(), typeParameterDescriptor.getTypeConstructor())) {
            return null;
        }
        return this.b[index];
    }

    @Override // tb.xo2
    public boolean f() {
        return this.b.length == 0;
    }

    @NotNull
    public final TypeProjection[] h() {
        return this.b;
    }

    @NotNull
    public final TypeParameterDescriptor[] i() {
        return this.a;
    }

    public r01(@NotNull TypeParameterDescriptor[] typeParameterDescriptorArr, @NotNull TypeProjection[] typeProjectionArr, boolean z) {
        k21.i(typeParameterDescriptorArr, PushConstants.PARAMS);
        k21.i(typeProjectionArr, "arguments");
        this.a = typeParameterDescriptorArr;
        this.b = typeProjectionArr;
        this.c = z;
        int length = typeParameterDescriptorArr.length;
        int length2 = typeProjectionArr.length;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    public r01(@NotNull List<? extends TypeParameterDescriptor> list, @NotNull List<? extends TypeProjection> list2) {
        this(r3, (TypeProjection[]) r9, false, 4, null);
        k21.i(list, PushConstants.PARAMS);
        k21.i(list2, "argumentsList");
        Object[] array = list.toArray(new TypeParameterDescriptor[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        TypeParameterDescriptor[] typeParameterDescriptorArr = (TypeParameterDescriptor[]) array;
        Object[] array2 = list2.toArray(new TypeProjection[0]);
        Objects.requireNonNull(array2, "null cannot be cast to non-null type kotlin.Array<T>");
    }
}
