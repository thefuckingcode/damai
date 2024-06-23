package kotlin.jvm.internal;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import tb.k21;
import tb.r51;

/* compiled from: Taobao */
final class TypeReference$asString$args$1 extends Lambda implements Function1<r51, CharSequence> {
    final /* synthetic */ TypeReference this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TypeReference$asString$args$1(TypeReference typeReference) {
        super(1);
        this.this$0 = typeReference;
    }

    @NotNull
    public final CharSequence invoke(@NotNull r51 r51) {
        k21.i(r51, AdvanceSetting.NETWORK_TYPE);
        return TypeReference.a(this.this$0, r51);
    }
}
