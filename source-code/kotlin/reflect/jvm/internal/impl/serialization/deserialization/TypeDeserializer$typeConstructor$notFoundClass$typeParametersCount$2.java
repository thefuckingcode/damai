package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type;
import org.jetbrains.annotations.NotNull;
import tb.k21;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class TypeDeserializer$typeConstructor$notFoundClass$typeParametersCount$2 extends Lambda implements Function1<ProtoBuf$Type, Integer> {
    public static final TypeDeserializer$typeConstructor$notFoundClass$typeParametersCount$2 INSTANCE = new TypeDeserializer$typeConstructor$notFoundClass$typeParametersCount$2();

    TypeDeserializer$typeConstructor$notFoundClass$typeParametersCount$2() {
        super(1);
    }

    public final int invoke(@NotNull ProtoBuf$Type protoBuf$Type) {
        k21.i(protoBuf$Type, AdvanceSetting.NETWORK_TYPE);
        return protoBuf$Type.getArgumentCount();
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Integer invoke(ProtoBuf$Type protoBuf$Type) {
        return Integer.valueOf(invoke(protoBuf$Type));
    }
}
