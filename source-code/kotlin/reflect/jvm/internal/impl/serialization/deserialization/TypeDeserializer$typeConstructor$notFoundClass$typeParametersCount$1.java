package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.jv1;
import tb.k21;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class TypeDeserializer$typeConstructor$notFoundClass$typeParametersCount$1 extends Lambda implements Function1<ProtoBuf$Type, ProtoBuf$Type> {
    final /* synthetic */ TypeDeserializer this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TypeDeserializer$typeConstructor$notFoundClass$typeParametersCount$1(TypeDeserializer typeDeserializer) {
        super(1);
        this.this$0 = typeDeserializer;
    }

    @Nullable
    public final ProtoBuf$Type invoke(@NotNull ProtoBuf$Type protoBuf$Type) {
        k21.i(protoBuf$Type, AdvanceSetting.NETWORK_TYPE);
        return jv1.f(protoBuf$Type, this.this$0.a.j());
    }
}
