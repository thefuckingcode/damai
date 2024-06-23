package org.jetbrains.anko.sdk27.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.experimental.Continuation;
import kotlin.coroutines.experimental.intrinsics.IntrinsicsKt;
import kotlin.coroutines.experimental.jvm.internal.CoroutineImpl;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.experimental.CoroutineScope;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/experimental/CoroutineScope;", "invoke", "(Lkotlinx/coroutines/experimental/CoroutineScope;Lkotlin/coroutines/experimental/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 11})
/* compiled from: ListenersWithCoroutines.kt */
final class __TextWatcher$onTextChanged$1 extends CoroutineImpl implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $before;
    final /* synthetic */ int $count;
    final /* synthetic */ Function6 $handler;
    final /* synthetic */ CharSequence $s;
    final /* synthetic */ int $start;
    private CoroutineScope p$;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    __TextWatcher$onTextChanged$1(Function6 function6, CharSequence charSequence, int i, int i2, int i3, Continuation continuation) {
        super(2, continuation);
        this.$handler = function6;
        this.$s = charSequence;
        this.$start = i;
        this.$before = i2;
        this.$count = i3;
    }

    public final Continuation<Unit> create(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        Intrinsics.checkParameterIsNotNull(coroutineScope, "$receiver");
        Intrinsics.checkParameterIsNotNull(continuation, "continuation");
        __TextWatcher$onTextChanged$1 __textwatcher_ontextchanged_1 = new __TextWatcher$onTextChanged$1(this.$handler, this.$s, this.$start, this.$before, this.$count, continuation);
        __textwatcher_ontextchanged_1.p$ = coroutineScope;
        return __textwatcher_ontextchanged_1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((__TextWatcher$onTextChanged$1) create(coroutineScope, continuation)).doResume(Unit.INSTANCE, null);
    }

    @Override // kotlin.coroutines.experimental.jvm.internal.CoroutineImpl
    public /* bridge */ /* synthetic */ Continuation create(Object obj, Continuation continuation) {
        return create((CoroutineScope) obj, (Continuation<? super Unit>) continuation);
    }

    @Override // kotlin.coroutines.experimental.jvm.internal.CoroutineImpl
    public final Object doResume(Object obj, Throwable th) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else if (th != null) {
                throw th;
            }
        } else if (th == null) {
            CoroutineScope coroutineScope = this.p$;
            Function6 function6 = this.$handler;
            CharSequence charSequence = this.$s;
            Integer valueOf = Integer.valueOf(this.$start);
            Integer valueOf2 = Integer.valueOf(this.$before);
            Integer valueOf3 = Integer.valueOf(this.$count);
            this.label = 1;
            if (function6.invoke(coroutineScope, charSequence, valueOf, valueOf2, valueOf3, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            throw th;
        }
        return Unit.INSTANCE;
    }
}
