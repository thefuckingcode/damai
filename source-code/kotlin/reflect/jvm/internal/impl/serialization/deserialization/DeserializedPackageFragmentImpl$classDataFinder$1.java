package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource;
import org.jetbrains.annotations.NotNull;
import tb.k21;
import tb.oi;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class DeserializedPackageFragmentImpl$classDataFinder$1 extends Lambda implements Function1<oi, SourceElement> {
    final /* synthetic */ DeserializedPackageFragmentImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeserializedPackageFragmentImpl$classDataFinder$1(DeserializedPackageFragmentImpl deserializedPackageFragmentImpl) {
        super(1);
        this.this$0 = deserializedPackageFragmentImpl;
    }

    @NotNull
    public final SourceElement invoke(@NotNull oi oiVar) {
        k21.i(oiVar, AdvanceSetting.NETWORK_TYPE);
        DeserializedContainerSource deserializedContainerSource = this.this$0.h;
        if (deserializedContainerSource != null) {
            return deserializedContainerSource;
        }
        SourceElement sourceElement = SourceElement.NO_SOURCE;
        k21.h(sourceElement, "NO_SOURCE");
        return sourceElement;
    }
}
