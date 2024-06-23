package kotlin.sequences;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class SequencesKt__SequencesKt$generateSequence$1 extends Lambda implements Function1<T, T> {
    final /* synthetic */ Function0<T> $nextFunction;

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: kotlin.jvm.functions.Function0<? extends T> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SequencesKt__SequencesKt$generateSequence$1(Function0<? extends T> function0) {
        super(1);
        this.$nextFunction = function0;
    }

    @Override // kotlin.jvm.functions.Function1
    @Nullable
    public final T invoke(@NotNull T t) {
        k21.i(t, AdvanceSetting.NETWORK_TYPE);
        return this.$nextFunction.invoke();
    }
}
