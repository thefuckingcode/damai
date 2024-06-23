package kotlin.reflect.jvm.internal.impl.descriptors;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import tb.k21;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class TypeParameterUtilsKt$computeConstructorTypeParameters$parametersFromContainingFunctions$2 extends Lambda implements Function1<DeclarationDescriptor, Boolean> {
    public static final TypeParameterUtilsKt$computeConstructorTypeParameters$parametersFromContainingFunctions$2 INSTANCE = new TypeParameterUtilsKt$computeConstructorTypeParameters$parametersFromContainingFunctions$2();

    TypeParameterUtilsKt$computeConstructorTypeParameters$parametersFromContainingFunctions$2() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(DeclarationDescriptor declarationDescriptor) {
        return Boolean.valueOf(invoke(declarationDescriptor));
    }

    public final boolean invoke(@NotNull DeclarationDescriptor declarationDescriptor) {
        k21.i(declarationDescriptor, AdvanceSetting.NETWORK_TYPE);
        return !(declarationDescriptor instanceof ConstructorDescriptor);
    }
}
