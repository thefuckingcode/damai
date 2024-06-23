package kotlin.reflect.jvm.internal.impl.load.kotlin;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import tb.k21;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class SignatureBuildingComponents$jvmDescriptor$1 extends Lambda implements Function1<String, CharSequence> {
    final /* synthetic */ SignatureBuildingComponents this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SignatureBuildingComponents$jvmDescriptor$1(SignatureBuildingComponents signatureBuildingComponents) {
        super(1);
        this.this$0 = signatureBuildingComponents;
    }

    @NotNull
    public final CharSequence invoke(@NotNull String str) {
        k21.i(str, AdvanceSetting.NETWORK_TYPE);
        return this.this$0.c(str);
    }
}
