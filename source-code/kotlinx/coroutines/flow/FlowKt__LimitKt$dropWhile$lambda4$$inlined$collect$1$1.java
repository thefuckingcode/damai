package kotlinx.coroutines.flow;

import com.alibaba.wireless.security.SecExceptionCode;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.kk0;

@Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__LimitKt$dropWhile$lambda-4$$inlined$collect$1", f = "Limit.kt", i = {1, 1}, l = {136, 137, SecExceptionCode.SEC_ERROR_INIT_CLAZZ_NULL_ERROR}, m = "emit", n = {"this", "value"}, s = {"L$0", "L$1"})
/* renamed from: kotlinx.coroutines.flow.FlowKt__LimitKt$dropWhile$lambda-4$$inlined$collect$1$1  reason: invalid class name */
/* compiled from: Taobao */
public final class FlowKt__LimitKt$dropWhile$lambda4$$inlined$collect$1$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ kk0 this$0;

    public FlowKt__LimitKt$dropWhile$lambda4$$inlined$collect$1$1(kk0 kk0, Continuation continuation) {
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
