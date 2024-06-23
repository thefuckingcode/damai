package kotlin.text;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import tb.k21;
import tb.w11;

/* compiled from: Taobao */
final class StringsKt__StringsKt$splitToSequence$1 extends Lambda implements Function1<w11, String> {
    final /* synthetic */ CharSequence $this_splitToSequence;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    StringsKt__StringsKt$splitToSequence$1(CharSequence charSequence) {
        super(1);
        this.$this_splitToSequence = charSequence;
    }

    @NotNull
    public final String invoke(@NotNull w11 w11) {
        k21.i(w11, AdvanceSetting.NETWORK_TYPE);
        return StringsKt__StringsKt.G0(this.$this_splitToSequence, w11);
    }
}
