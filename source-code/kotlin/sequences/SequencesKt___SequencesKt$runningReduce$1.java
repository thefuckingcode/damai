package kotlin.sequences;

import java.util.Iterator;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k12;
import tb.s82;
import tb.ur2;

@DebugMetadata(c = "kotlin.sequences.SequencesKt___SequencesKt$runningReduce$1", f = "_Sequences.kt", i = {0, 0, 0, 1, 1, 1}, l = {2344, 2347}, m = "invokeSuspend", n = {"$this$sequence", "iterator", "accumulator", "$this$sequence", "iterator", "accumulator"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2"})
/* compiled from: Taobao */
final class SequencesKt___SequencesKt$runningReduce$1 extends RestrictedSuspendLambda implements Function2<s82<Object>, Continuation<? super ur2>, Object> {
    final /* synthetic */ Function2<Object, Object, Object> $operation;
    final /* synthetic */ Sequence<Object> $this_runningReduce;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SequencesKt___SequencesKt$runningReduce$1(Sequence<Object> sequence, Function2<Object, Object, Object> function2, Continuation<? super SequencesKt___SequencesKt$runningReduce$1> continuation) {
        super(2, continuation);
        this.$this_runningReduce = sequence;
        this.$operation = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<ur2> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        SequencesKt___SequencesKt$runningReduce$1 sequencesKt___SequencesKt$runningReduce$1 = new SequencesKt___SequencesKt$runningReduce$1(this.$this_runningReduce, this.$operation, continuation);
        sequencesKt___SequencesKt$runningReduce$1.L$0 = obj;
        return sequencesKt___SequencesKt$runningReduce$1;
    }

    @Nullable
    public final Object invoke(@NotNull s82<Object> s82, @Nullable Continuation<? super ur2> continuation) {
        return ((SequencesKt___SequencesKt$runningReduce$1) create(s82, continuation)).invokeSuspend(ur2.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        s82 s82;
        Iterator<Object> it;
        Object obj2;
        Object obj3 = b.d();
        int i = this.label;
        if (i == 0) {
            k12.b(obj);
            s82 = (s82) this.L$0;
            Iterator<Object> it2 = this.$this_runningReduce.iterator();
            if (it2.hasNext()) {
                obj2 = it2.next();
                this.L$0 = s82;
                this.L$1 = it2;
                this.L$2 = obj2;
                this.label = 1;
                if (s82.a(obj2, this) == obj3) {
                    return obj3;
                }
                it = it2;
            }
            return ur2.INSTANCE;
        } else if (i == 1 || i == 2) {
            obj2 = this.L$2;
            it = (Iterator) this.L$1;
            s82 = (s82) this.L$0;
            k12.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        while (it.hasNext()) {
            obj2 = this.$operation.invoke(obj2, it.next());
            this.L$0 = s82;
            this.L$1 = it;
            this.L$2 = obj2;
            this.label = 2;
            if (s82.a(obj2, this) == obj3) {
                return obj3;
            }
        }
        return ur2.INSTANCE;
    }
}
