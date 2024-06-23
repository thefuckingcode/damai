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

@DebugMetadata(c = "kotlin.sequences.SequencesKt___SequencesKt$runningFold$1", f = "_Sequences.kt", i = {0, 1, 1}, l = {2286, 2290}, m = "invokeSuspend", n = {"$this$sequence", "$this$sequence", "accumulator"}, s = {"L$0", "L$0", "L$1"})
/* compiled from: Taobao */
final class SequencesKt___SequencesKt$runningFold$1 extends RestrictedSuspendLambda implements Function2<s82<Object>, Continuation<? super ur2>, Object> {
    final /* synthetic */ Object $initial;
    final /* synthetic */ Function2<Object, Object, Object> $operation;
    final /* synthetic */ Sequence<Object> $this_runningFold;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SequencesKt___SequencesKt$runningFold$1(Object obj, Sequence<Object> sequence, Function2<Object, Object, Object> function2, Continuation<? super SequencesKt___SequencesKt$runningFold$1> continuation) {
        super(2, continuation);
        this.$initial = obj;
        this.$this_runningFold = sequence;
        this.$operation = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<ur2> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        SequencesKt___SequencesKt$runningFold$1 sequencesKt___SequencesKt$runningFold$1 = new SequencesKt___SequencesKt$runningFold$1(this.$initial, this.$this_runningFold, this.$operation, continuation);
        sequencesKt___SequencesKt$runningFold$1.L$0 = obj;
        return sequencesKt___SequencesKt$runningFold$1;
    }

    @Nullable
    public final Object invoke(@NotNull s82<Object> s82, @Nullable Continuation<? super ur2> continuation) {
        return ((SequencesKt___SequencesKt$runningFold$1) create(s82, continuation)).invokeSuspend(ur2.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0053  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object obj2;
        s82 s82;
        Iterator<Object> it;
        s82 s822;
        Object obj3 = b.d();
        int i = this.label;
        if (i == 0) {
            k12.b(obj);
            s822 = (s82) this.L$0;
            Object obj4 = this.$initial;
            this.L$0 = s822;
            this.label = 1;
            if (s822.a(obj4, this) == obj3) {
                return obj3;
            }
        } else if (i == 1) {
            s822 = (s82) this.L$0;
            k12.b(obj);
        } else if (i == 2) {
            it = (Iterator) this.L$2;
            Object obj5 = this.L$1;
            s82 = (s82) this.L$0;
            k12.b(obj);
            obj2 = obj5;
            while (it.hasNext()) {
                obj2 = this.$operation.invoke(obj2, it.next());
                this.L$0 = s82;
                this.L$1 = obj2;
                this.L$2 = it;
                this.label = 2;
                if (s82.a(obj2, this) == obj3) {
                    return obj3;
                }
            }
            return ur2.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        obj2 = this.$initial;
        s82 = s822;
        it = this.$this_runningFold.iterator();
        while (it.hasNext()) {
        }
        return ur2.INSTANCE;
    }
}
