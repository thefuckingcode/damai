package kotlin.text;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import tb.k21;

/* compiled from: Taobao */
final class StringsKt__IndentKt$prependIndent$1 extends Lambda implements Function1<String, String> {
    final /* synthetic */ String $indent;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    StringsKt__IndentKt$prependIndent$1(String str) {
        super(1);
        this.$indent = str;
    }

    @NotNull
    public final String invoke(@NotNull String str) {
        k21.i(str, AdvanceSetting.NETWORK_TYPE);
        if (!(o.y(str))) {
            return this.$indent + str;
        } else if (str.length() < this.$indent.length()) {
            return this.$indent;
        } else {
            return str;
        }
    }
}
