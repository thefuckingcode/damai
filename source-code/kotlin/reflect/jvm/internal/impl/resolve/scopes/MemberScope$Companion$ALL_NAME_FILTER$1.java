package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import tb.k21;
import tb.og1;

/* compiled from: Taobao */
final class MemberScope$Companion$ALL_NAME_FILTER$1 extends Lambda implements Function1<og1, Boolean> {
    public static final MemberScope$Companion$ALL_NAME_FILTER$1 INSTANCE = new MemberScope$Companion$ALL_NAME_FILTER$1();

    MemberScope$Companion$ALL_NAME_FILTER$1() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(og1 og1) {
        return Boolean.valueOf(invoke(og1));
    }

    public final boolean invoke(@NotNull og1 og1) {
        k21.i(og1, AdvanceSetting.NETWORK_TYPE);
        return true;
    }
}
