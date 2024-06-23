package org.jetbrains.anko.sdk27.coroutines;

import android.widget.SeekBar;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.experimental.Continuation;
import kotlin.coroutines.experimental.intrinsics.IntrinsicsKt;
import kotlin.coroutines.experimental.jvm.internal.CoroutineImpl;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.experimental.CoroutineScope;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/experimental/CoroutineScope;", "invoke", "(Lkotlinx/coroutines/experimental/CoroutineScope;Lkotlin/coroutines/experimental/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 11})
/* compiled from: ListenersWithCoroutines.kt */
final class __SeekBar_OnSeekBarChangeListener$onProgressChanged$1 extends CoroutineImpl implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $fromUser;
    final /* synthetic */ Function5 $handler;
    final /* synthetic */ int $progress;
    final /* synthetic */ SeekBar $seekBar;
    private CoroutineScope p$;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    __SeekBar_OnSeekBarChangeListener$onProgressChanged$1(Function5 function5, SeekBar seekBar, int i, boolean z, Continuation continuation) {
        super(2, continuation);
        this.$handler = function5;
        this.$seekBar = seekBar;
        this.$progress = i;
        this.$fromUser = z;
    }

    public final Continuation<Unit> create(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        Intrinsics.checkParameterIsNotNull(coroutineScope, "$receiver");
        Intrinsics.checkParameterIsNotNull(continuation, "continuation");
        __SeekBar_OnSeekBarChangeListener$onProgressChanged$1 __seekbar_onseekbarchangelistener_onprogresschanged_1 = new __SeekBar_OnSeekBarChangeListener$onProgressChanged$1(this.$handler, this.$seekBar, this.$progress, this.$fromUser, continuation);
        __seekbar_onseekbarchangelistener_onprogresschanged_1.p$ = coroutineScope;
        return __seekbar_onseekbarchangelistener_onprogresschanged_1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((__SeekBar_OnSeekBarChangeListener$onProgressChanged$1) create(coroutineScope, continuation)).doResume(Unit.INSTANCE, null);
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
            Function5 function5 = this.$handler;
            SeekBar seekBar = this.$seekBar;
            Integer valueOf = Integer.valueOf(this.$progress);
            Boolean valueOf2 = Boolean.valueOf(this.$fromUser);
            this.label = 1;
            if (function5.invoke(coroutineScope, seekBar, valueOf, valueOf2, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            throw th;
        }
        return Unit.INSTANCE;
    }
}
