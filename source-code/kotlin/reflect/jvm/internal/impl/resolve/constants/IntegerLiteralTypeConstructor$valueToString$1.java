package kotlin.reflect.jvm.internal.impl.resolve.constants;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import tb.g61;
import tb.k21;

/* compiled from: Taobao */
final class IntegerLiteralTypeConstructor$valueToString$1 extends Lambda implements Function1<g61, CharSequence> {
    public static final IntegerLiteralTypeConstructor$valueToString$1 INSTANCE = new IntegerLiteralTypeConstructor$valueToString$1();

    IntegerLiteralTypeConstructor$valueToString$1() {
        super(1);
    }

    @NotNull
    public final CharSequence invoke(@NotNull g61 g61) {
        k21.i(g61, AdvanceSetting.NETWORK_TYPE);
        return g61.toString();
    }
}
