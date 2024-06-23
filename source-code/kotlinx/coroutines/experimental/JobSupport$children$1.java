package kotlinx.coroutines.experimental;

import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.coroutines.experimental.Continuation;
import kotlin.coroutines.experimental.SequenceBuilder;
import kotlin.coroutines.experimental.intrinsics.IntrinsicsKt;
import kotlin.coroutines.experimental.jvm.internal.CoroutineImpl;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "Lkotlin/coroutines/experimental/SequenceBuilder;", "Lkotlinx/coroutines/experimental/Job;", "invoke", "(Lkotlin/coroutines/experimental/SequenceBuilder;Lkotlin/coroutines/experimental/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 10})
/* compiled from: JobSupport.kt */
final class JobSupport$children$1 extends CoroutineImpl implements Function2<SequenceBuilder<? super Job>, Continuation<? super Unit>, Object> {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    private SequenceBuilder p$;
    final /* synthetic */ JobSupport this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    JobSupport$children$1(JobSupport jobSupport, Continuation continuation) {
        super(2, continuation);
        this.this$0 = jobSupport;
    }

    public final Continuation<Unit> create(SequenceBuilder<? super Job> sequenceBuilder, Continuation<? super Unit> continuation) {
        Intrinsics.checkParameterIsNotNull(sequenceBuilder, "$receiver");
        Intrinsics.checkParameterIsNotNull(continuation, "continuation");
        JobSupport$children$1 jobSupport$children$1 = new JobSupport$children$1(this.this$0, continuation);
        jobSupport$children$1.p$ = sequenceBuilder;
        return jobSupport$children$1;
    }

    public final Object invoke(SequenceBuilder<? super Job> sequenceBuilder, Continuation<? super Unit> continuation) {
        Intrinsics.checkParameterIsNotNull(sequenceBuilder, "$receiver");
        Intrinsics.checkParameterIsNotNull(continuation, "continuation");
        return ((JobSupport$children$1) create(sequenceBuilder, continuation)).doResume(Unit.INSTANCE, null);
    }

    @Override // kotlin.coroutines.experimental.jvm.internal.CoroutineImpl
    public /* bridge */ /* synthetic */ Continuation create(Object obj, Continuation continuation) {
        return create((SequenceBuilder) obj, (Continuation<? super Unit>) continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0079  */
    @Override // kotlin.coroutines.experimental.jvm.internal.CoroutineImpl
    public final Object doResume(Object obj, Throwable th) {
        JobSupport$children$1 jobSupport$children$1;
        SequenceBuilder sequenceBuilder;
        Object obj2;
        NodeList nodeList;
        NodeList nodeList2;
        LockFreeLinkedListNode lockFreeLinkedListNode;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                if (th != null) {
                    throw th;
                }
                return Unit.INSTANCE;
            } else if (i == 2) {
                ChildJob childJob = (ChildJob) this.L$5;
                lockFreeLinkedListNode = (LockFreeLinkedListNode) this.L$4;
                nodeList2 = (NodeList) this.L$3;
                nodeList = (NodeList) this.L$2;
                obj2 = this.L$1;
                sequenceBuilder = (SequenceBuilder) this.L$0;
                if (th == null) {
                    jobSupport$children$1 = this;
                    lockFreeLinkedListNode = lockFreeLinkedListNode.getNextNode();
                } else {
                    throw th;
                }
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else if (th == null) {
            SequenceBuilder sequenceBuilder2 = this.p$;
            Object state$kotlinx_coroutines_core = this.this$0.getState$kotlinx_coroutines_core();
            if (state$kotlinx_coroutines_core instanceof ChildJob) {
                Job job = ((ChildJob) state$kotlinx_coroutines_core).childJob;
                this.L$0 = state$kotlinx_coroutines_core;
                this.label = 1;
                if (sequenceBuilder2.yield(job, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if ((state$kotlinx_coroutines_core instanceof Incomplete) && (nodeList2 = ((Incomplete) state$kotlinx_coroutines_core).getList()) != null) {
                Object next = nodeList2.getNext();
                if (next != null) {
                    sequenceBuilder = sequenceBuilder2;
                    obj2 = state$kotlinx_coroutines_core;
                    lockFreeLinkedListNode = (LockFreeLinkedListNode) next;
                    jobSupport$children$1 = this;
                    nodeList = nodeList2;
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.experimental.internal.Node /* = kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode */");
                }
            }
            return Unit.INSTANCE;
        } else {
            throw th;
        }
        if (!Intrinsics.areEqual(lockFreeLinkedListNode, nodeList2)) {
            if (lockFreeLinkedListNode instanceof ChildJob) {
                ChildJob childJob2 = (ChildJob) lockFreeLinkedListNode;
                Job job2 = childJob2.childJob;
                jobSupport$children$1.L$0 = sequenceBuilder;
                jobSupport$children$1.L$1 = obj2;
                jobSupport$children$1.L$2 = nodeList;
                jobSupport$children$1.L$3 = nodeList2;
                jobSupport$children$1.L$4 = lockFreeLinkedListNode;
                jobSupport$children$1.L$5 = childJob2;
                jobSupport$children$1.label = 2;
                if (sequenceBuilder.yield(job2, jobSupport$children$1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            lockFreeLinkedListNode = lockFreeLinkedListNode.getNextNode();
            if (!Intrinsics.areEqual(lockFreeLinkedListNode, nodeList2)) {
            }
        }
        return Unit.INSTANCE;
    }
}
