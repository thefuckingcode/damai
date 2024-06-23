package kotlin.reflect.jvm.internal;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import org.jetbrains.annotations.NotNull;
import tb.g61;
import tb.k21;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lkotlin/reflect/jvm/internal/impl/descriptors/ValueParameterDescriptor;", "kotlin.jvm.PlatformType", AdvanceSetting.NETWORK_TYPE, "", "invoke", "(Lkotlin/reflect/jvm/internal/impl/descriptors/ValueParameterDescriptor;)Ljava/lang/CharSequence;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
/* compiled from: Taobao */
public final class ReflectionObjectRenderer$renderFunction$1$1 extends Lambda implements Function1<ValueParameterDescriptor, CharSequence> {
    public static final ReflectionObjectRenderer$renderFunction$1$1 INSTANCE = new ReflectionObjectRenderer$renderFunction$1$1();

    ReflectionObjectRenderer$renderFunction$1$1() {
        super(1);
    }

    @NotNull
    public final CharSequence invoke(ValueParameterDescriptor valueParameterDescriptor) {
        ReflectionObjectRenderer reflectionObjectRenderer = ReflectionObjectRenderer.INSTANCE;
        k21.h(valueParameterDescriptor, AdvanceSetting.NETWORK_TYPE);
        g61 type = valueParameterDescriptor.getType();
        k21.h(type, "it.type");
        return reflectionObjectRenderer.h(type);
    }
}
