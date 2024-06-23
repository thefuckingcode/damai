package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class ReflectClassUtilKt$parameterizedTypeArguments$1 extends Lambda implements Function1<ParameterizedType, ParameterizedType> {
    public static final ReflectClassUtilKt$parameterizedTypeArguments$1 INSTANCE = new ReflectClassUtilKt$parameterizedTypeArguments$1();

    ReflectClassUtilKt$parameterizedTypeArguments$1() {
        super(1);
    }

    @Nullable
    public final ParameterizedType invoke(@NotNull ParameterizedType parameterizedType) {
        k21.i(parameterizedType, AdvanceSetting.NETWORK_TYPE);
        Type ownerType = parameterizedType.getOwnerType();
        if (ownerType instanceof ParameterizedType) {
            return (ParameterizedType) ownerType;
        }
        return null;
    }
}
