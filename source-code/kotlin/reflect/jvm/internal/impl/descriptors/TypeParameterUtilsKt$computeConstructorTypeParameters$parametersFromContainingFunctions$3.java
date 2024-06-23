package kotlin.reflect.jvm.internal.impl.descriptors;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;
import tb.k21;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class TypeParameterUtilsKt$computeConstructorTypeParameters$parametersFromContainingFunctions$3 extends Lambda implements Function1<DeclarationDescriptor, Sequence<? extends TypeParameterDescriptor>> {
    public static final TypeParameterUtilsKt$computeConstructorTypeParameters$parametersFromContainingFunctions$3 INSTANCE = new TypeParameterUtilsKt$computeConstructorTypeParameters$parametersFromContainingFunctions$3();

    TypeParameterUtilsKt$computeConstructorTypeParameters$parametersFromContainingFunctions$3() {
        super(1);
    }

    @NotNull
    public final Sequence<TypeParameterDescriptor> invoke(@NotNull DeclarationDescriptor declarationDescriptor) {
        k21.i(declarationDescriptor, AdvanceSetting.NETWORK_TYPE);
        List<TypeParameterDescriptor> typeParameters = ((CallableDescriptor) declarationDescriptor).getTypeParameters();
        k21.h(typeParameters, "it as CallableDescriptor).typeParameters");
        return CollectionsKt___CollectionsKt.I(typeParameters);
    }
}
