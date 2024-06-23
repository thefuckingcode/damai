package kotlinx.coroutines.flow;

import com.youku.uplayer.AliMediaPlayer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.nk0;

@Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__LimitKt$takeWhile$lambda-9$$inlined$collectWhile$1", f = "Limit.kt", i = {0, 0, 1}, l = {AliMediaPlayer.UPLAYER_PROPERTY_TYPE_PATTAYA_MAX_GEAR_KEEP, 145}, m = "emit", n = {"this", "value", "this"}, s = {"L$0", "L$1", "L$0"})
/* renamed from: kotlinx.coroutines.flow.FlowKt__LimitKt$takeWhile$lambda-9$$inlined$collectWhile$1$1  reason: invalid class name */
/* compiled from: Taobao */
public final class FlowKt__LimitKt$takeWhile$lambda9$$inlined$collectWhile$1$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ nk0 this$0;

    public FlowKt__LimitKt$takeWhile$lambda9$$inlined$collectWhile$1$1(nk0 nk0, Continuation continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        throw null;
    }
}
