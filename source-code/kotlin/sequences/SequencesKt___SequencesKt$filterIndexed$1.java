package kotlin.sequences;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import tb.k21;
import tb.s01;

/* compiled from: Taobao */
final class SequencesKt___SequencesKt$filterIndexed$1 extends Lambda implements Function1<s01<Object>, Boolean> {
    final /* synthetic */ Function2<Integer, Object, Boolean> $predicate;

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: kotlin.jvm.functions.Function2<? super java.lang.Integer, java.lang.Object, java.lang.Boolean> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SequencesKt___SequencesKt$filterIndexed$1(Function2<? super Integer, Object, Boolean> function2) {
        super(1);
        this.$predicate = function2;
    }

    @NotNull
    public final Boolean invoke(@NotNull s01<Object> s01) {
        k21.i(s01, AdvanceSetting.NETWORK_TYPE);
        return this.$predicate.invoke(Integer.valueOf(s01.c()), s01.d());
    }
}
