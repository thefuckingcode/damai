package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;
import tb.k21;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class ReflectClassUtilKt$parameterizedTypeArguments$2 extends Lambda implements Function1<ParameterizedType, Sequence<? extends Type>> {
    public static final ReflectClassUtilKt$parameterizedTypeArguments$2 INSTANCE = new ReflectClassUtilKt$parameterizedTypeArguments$2();

    ReflectClassUtilKt$parameterizedTypeArguments$2() {
        super(1);
    }

    @NotNull
    public final Sequence<Type> invoke(@NotNull ParameterizedType parameterizedType) {
        k21.i(parameterizedType, AdvanceSetting.NETWORK_TYPE);
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        k21.h(actualTypeArguments, "it.actualTypeArguments");
        return ArraysKt___ArraysKt.o(actualTypeArguments);
    }
}
