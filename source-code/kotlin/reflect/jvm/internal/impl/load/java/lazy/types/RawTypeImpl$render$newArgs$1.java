package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import tb.k21;

/* compiled from: Taobao */
final class RawTypeImpl$render$newArgs$1 extends Lambda implements Function1<String, CharSequence> {
    public static final RawTypeImpl$render$newArgs$1 INSTANCE = new RawTypeImpl$render$newArgs$1();

    RawTypeImpl$render$newArgs$1() {
        super(1);
    }

    @NotNull
    public final CharSequence invoke(@NotNull String str) {
        k21.i(str, AdvanceSetting.NETWORK_TYPE);
        return k21.r("(raw) ", str);
    }
}
