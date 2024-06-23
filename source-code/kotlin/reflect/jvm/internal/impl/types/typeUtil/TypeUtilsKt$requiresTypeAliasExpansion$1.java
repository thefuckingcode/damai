package kotlin.reflect.jvm.internal.impl.types.typeUtil;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import org.jetbrains.annotations.NotNull;
import tb.es2;
import tb.k21;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class TypeUtilsKt$requiresTypeAliasExpansion$1 extends Lambda implements Function1<es2, Boolean> {
    public static final TypeUtilsKt$requiresTypeAliasExpansion$1 INSTANCE = new TypeUtilsKt$requiresTypeAliasExpansion$1();

    TypeUtilsKt$requiresTypeAliasExpansion$1() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(es2 es2) {
        return Boolean.valueOf(invoke(es2));
    }

    public final boolean invoke(@NotNull es2 es2) {
        k21.i(es2, AdvanceSetting.NETWORK_TYPE);
        ClassifierDescriptor declarationDescriptor = es2.c().getDeclarationDescriptor();
        if (declarationDescriptor == null) {
            return false;
        }
        if ((declarationDescriptor instanceof TypeAliasDescriptor) || (declarationDescriptor instanceof TypeParameterDescriptor)) {
            return true;
        }
        return false;
    }
}
