package kotlinx.coroutines.channels;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CancellableContinuation;
import org.jetbrains.annotations.Nullable;
import tb.ur2;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n"}, d2 = {"", AdvanceSetting.NETWORK_TYPE, "Ltb/ur2;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class ProduceKt$awaitClose$4$1 extends Lambda implements Function1<Throwable, ur2> {
    final /* synthetic */ CancellableContinuation<ur2> $cont;

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: kotlinx.coroutines.CancellableContinuation<? super tb.ur2> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ProduceKt$awaitClose$4$1(CancellableContinuation<? super ur2> cancellableContinuation) {
        super(1);
        this.$cont = cancellableContinuation;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ ur2 invoke(Throwable th) {
        invoke(th);
        return ur2.INSTANCE;
    }

    public final void invoke(@Nullable Throwable th) {
        CancellableContinuation<ur2> cancellableContinuation = this.$cont;
        ur2 ur2 = ur2.INSTANCE;
        Result.a aVar = Result.Companion;
        cancellableContinuation.resumeWith(Result.m913constructorimpl(ur2));
    }
}
