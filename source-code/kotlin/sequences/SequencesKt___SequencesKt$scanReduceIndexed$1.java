package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\b\b\u0001\u0010\u0003*\u0002H\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0004H@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "S", "T", "Lkotlin/sequences/SequenceScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 16})
@DebugMetadata(c = "kotlin.sequences.SequencesKt___SequencesKt$scanReduceIndexed$1", f = "_Sequences.kt", i = {0, 0, 0, 1, 1, 1, 1}, l = {1516, 1520}, m = "invokeSuspend", n = {"$this$sequence", "iterator", "accumulator", "$this$sequence", "iterator", "accumulator", "index"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "I$0"})
/* compiled from: _Sequences.kt */
final class SequencesKt___SequencesKt$scanReduceIndexed$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super S>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function3 $operation;
    final /* synthetic */ Sequence $this_scanReduceIndexed;
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    private SequenceScope p$;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SequencesKt___SequencesKt$scanReduceIndexed$1(Sequence sequence, Function3 function3, Continuation continuation) {
        super(2, continuation);
        this.$this_scanReduceIndexed = sequence;
        this.$operation = function3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkParameterIsNotNull(continuation, "completion");
        SequencesKt___SequencesKt$scanReduceIndexed$1 sequencesKt___SequencesKt$scanReduceIndexed$1 = new SequencesKt___SequencesKt$scanReduceIndexed$1(this.$this_scanReduceIndexed, this.$operation, continuation);
        sequencesKt___SequencesKt$scanReduceIndexed$1.p$ = (SequenceScope) obj;
        return sequencesKt___SequencesKt$scanReduceIndexed$1;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Continuation<? super Unit> continuation) {
        return ((SequencesKt___SequencesKt$scanReduceIndexed$1) create(obj, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0063  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        SequencesKt___SequencesKt$scanReduceIndexed$1 sequencesKt___SequencesKt$scanReduceIndexed$1;
        SequenceScope sequenceScope;
        Iterator it;
        Object obj2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        int i2 = 1;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            sequenceScope = this.p$;
            it = this.$this_scanReduceIndexed.iterator();
            if (it.hasNext()) {
                obj2 = it.next();
                this.L$0 = sequenceScope;
                this.L$1 = it;
                this.L$2 = obj2;
                this.label = 1;
                if (sequenceScope.yield(obj2, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        } else if (i == 1) {
            obj2 = this.L$2;
            it = (Iterator) this.L$1;
            sequenceScope = (SequenceScope) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else if (i == 2) {
            int i3 = this.I$0;
            Object obj3 = this.L$2;
            it = (Iterator) this.L$1;
            sequenceScope = (SequenceScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            sequencesKt___SequencesKt$scanReduceIndexed$1 = this;
            i2 = i3;
            obj2 = obj3;
            while (it.hasNext()) {
                Function3 function3 = sequencesKt___SequencesKt$scanReduceIndexed$1.$operation;
                int i4 = i2 + 1;
                if (i2 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                Object invoke = function3.invoke(Boxing.boxInt(i2), obj2, it.next());
                sequencesKt___SequencesKt$scanReduceIndexed$1.L$0 = sequenceScope;
                sequencesKt___SequencesKt$scanReduceIndexed$1.L$1 = it;
                sequencesKt___SequencesKt$scanReduceIndexed$1.L$2 = invoke;
                sequencesKt___SequencesKt$scanReduceIndexed$1.I$0 = i4;
                sequencesKt___SequencesKt$scanReduceIndexed$1.label = 2;
                if (sequenceScope.yield(invoke, sequencesKt___SequencesKt$scanReduceIndexed$1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                obj2 = invoke;
                i2 = i4;
            }
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        sequencesKt___SequencesKt$scanReduceIndexed$1 = this;
        while (it.hasNext()) {
        }
        return Unit.INSTANCE;
    }
}
