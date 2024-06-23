package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.og1;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class DeserializedMemberScope$OptimizedImplementation$typeAliasByName$1 extends Lambda implements Function1<og1, TypeAliasDescriptor> {
    final /* synthetic */ DeserializedMemberScope.OptimizedImplementation this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeserializedMemberScope$OptimizedImplementation$typeAliasByName$1(DeserializedMemberScope.OptimizedImplementation optimizedImplementation) {
        super(1);
        this.this$0 = optimizedImplementation;
    }

    @Nullable
    public final TypeAliasDescriptor invoke(@NotNull og1 og1) {
        k21.i(og1, AdvanceSetting.NETWORK_TYPE);
        return this.this$0.h(og1);
    }
}
