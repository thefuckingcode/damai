package kotlin.sequences;

import java.util.Iterator;
import kotlin.collections.m;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k12;
import tb.qc;
import tb.s82;
import tb.ur2;

@DebugMetadata(c = "kotlin.sequences.SequencesKt___SequencesKt$runningReduceIndexed$1", f = "_Sequences.kt", i = {0, 0, 0, 1, 1, 1, 1}, l = {2373, 2377}, m = "invokeSuspend", n = {"$this$sequence", "iterator", "accumulator", "$this$sequence", "iterator", "accumulator", "index"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "I$0"})
/* compiled from: Taobao */
final class SequencesKt___SequencesKt$runningReduceIndexed$1 extends RestrictedSuspendLambda implements Function2<s82<Object>, Continuation<? super ur2>, Object> {
    final /* synthetic */ Function3<Integer, Object, Object, Object> $operation;
    final /* synthetic */ Sequence<Object> $this_runningReduceIndexed;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.jvm.functions.Function3<? super java.lang.Integer, java.lang.Object, java.lang.Object, java.lang.Object> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SequencesKt___SequencesKt$runningReduceIndexed$1(Sequence<Object> sequence, Function3<? super Integer, Object, Object, Object> function3, Continuation<? super SequencesKt___SequencesKt$runningReduceIndexed$1> continuation) {
        super(2, continuation);
        this.$this_runningReduceIndexed = sequence;
        this.$operation = function3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<ur2> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        SequencesKt___SequencesKt$runningReduceIndexed$1 sequencesKt___SequencesKt$runningReduceIndexed$1 = new SequencesKt___SequencesKt$runningReduceIndexed$1(this.$this_runningReduceIndexed, this.$operation, continuation);
        sequencesKt___SequencesKt$runningReduceIndexed$1.L$0 = obj;
        return sequencesKt___SequencesKt$runningReduceIndexed$1;
    }

    @Nullable
    public final Object invoke(@NotNull s82<Object> s82, @Nullable Continuation<? super ur2> continuation) {
        return ((SequencesKt___SequencesKt$runningReduceIndexed$1) create(s82, continuation)).invokeSuspend(ur2.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0066  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        SequencesKt___SequencesKt$runningReduceIndexed$1 sequencesKt___SequencesKt$runningReduceIndexed$1;
        s82 s82;
        Iterator<Object> it;
        Object obj2;
        Object obj3 = b.d();
        int i = this.label;
        int i2 = 1;
        if (i == 0) {
            k12.b(obj);
            s82 = (s82) this.L$0;
            it = this.$this_runningReduceIndexed.iterator();
            if (it.hasNext()) {
                obj2 = it.next();
                this.L$0 = s82;
                this.L$1 = it;
                this.L$2 = obj2;
                this.label = 1;
                if (s82.a(obj2, this) == obj3) {
                    return obj3;
                }
            }
            return ur2.INSTANCE;
        } else if (i == 1) {
            obj2 = this.L$2;
            it = (Iterator) this.L$1;
            s82 = (s82) this.L$0;
            k12.b(obj);
        } else if (i == 2) {
            int i3 = this.I$0;
            Object obj4 = this.L$2;
            it = (Iterator) this.L$1;
            s82 = (s82) this.L$0;
            k12.b(obj);
            sequencesKt___SequencesKt$runningReduceIndexed$1 = this;
            i2 = i3;
            obj2 = obj4;
            while (it.hasNext()) {
                Function3<Integer, Object, Object, Object> function3 = sequencesKt___SequencesKt$runningReduceIndexed$1.$operation;
                int i4 = i2 + 1;
                if (i2 < 0) {
                    m.p();
                }
                Object invoke = function3.invoke(qc.b(i2), obj2, it.next());
                sequencesKt___SequencesKt$runningReduceIndexed$1.L$0 = s82;
                sequencesKt___SequencesKt$runningReduceIndexed$1.L$1 = it;
                sequencesKt___SequencesKt$runningReduceIndexed$1.L$2 = invoke;
                sequencesKt___SequencesKt$runningReduceIndexed$1.I$0 = i4;
                sequencesKt___SequencesKt$runningReduceIndexed$1.label = 2;
                if (s82.a(invoke, sequencesKt___SequencesKt$runningReduceIndexed$1) == obj3) {
                    return obj3;
                }
                obj2 = invoke;
                i2 = i4;
            }
            return ur2.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        sequencesKt___SequencesKt$runningReduceIndexed$1 = this;
        while (it.hasNext()) {
        }
        return ur2.INSTANCE;
    }
}
