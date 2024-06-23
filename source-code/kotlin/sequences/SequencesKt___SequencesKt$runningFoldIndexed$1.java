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

@DebugMetadata(c = "kotlin.sequences.SequencesKt___SequencesKt$runningFoldIndexed$1", f = "_Sequences.kt", i = {0, 1, 1, 1}, l = {2314, 2319}, m = "invokeSuspend", n = {"$this$sequence", "$this$sequence", "accumulator", "index"}, s = {"L$0", "L$0", "L$1", "I$0"})
/* compiled from: Taobao */
final class SequencesKt___SequencesKt$runningFoldIndexed$1 extends RestrictedSuspendLambda implements Function2<s82<Object>, Continuation<? super ur2>, Object> {
    final /* synthetic */ Object $initial;
    final /* synthetic */ Function3<Integer, Object, Object, Object> $operation;
    final /* synthetic */ Sequence<Object> $this_runningFoldIndexed;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.jvm.functions.Function3<? super java.lang.Integer, java.lang.Object, java.lang.Object, java.lang.Object> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SequencesKt___SequencesKt$runningFoldIndexed$1(Object obj, Sequence<Object> sequence, Function3<? super Integer, Object, Object, Object> function3, Continuation<? super SequencesKt___SequencesKt$runningFoldIndexed$1> continuation) {
        super(2, continuation);
        this.$initial = obj;
        this.$this_runningFoldIndexed = sequence;
        this.$operation = function3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<ur2> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        SequencesKt___SequencesKt$runningFoldIndexed$1 sequencesKt___SequencesKt$runningFoldIndexed$1 = new SequencesKt___SequencesKt$runningFoldIndexed$1(this.$initial, this.$this_runningFoldIndexed, this.$operation, continuation);
        sequencesKt___SequencesKt$runningFoldIndexed$1.L$0 = obj;
        return sequencesKt___SequencesKt$runningFoldIndexed$1;
    }

    @Nullable
    public final Object invoke(@NotNull s82<Object> s82, @Nullable Continuation<? super ur2> continuation) {
        return ((SequencesKt___SequencesKt$runningFoldIndexed$1) create(s82, continuation)).invokeSuspend(ur2.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0058  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        int i;
        s82 s82;
        Iterator<Object> it;
        Object obj2;
        s82 s822;
        Object obj3 = b.d();
        int i2 = this.label;
        if (i2 == 0) {
            k12.b(obj);
            s822 = (s82) this.L$0;
            Object obj4 = this.$initial;
            this.L$0 = s822;
            this.label = 1;
            if (s822.a(obj4, this) == obj3) {
                return obj3;
            }
        } else if (i2 == 1) {
            s822 = (s82) this.L$0;
            k12.b(obj);
        } else if (i2 == 2) {
            int i3 = this.I$0;
            it = (Iterator) this.L$2;
            Object obj5 = this.L$1;
            s82 = (s82) this.L$0;
            k12.b(obj);
            i = i3;
            obj2 = obj5;
            while (it.hasNext()) {
                Object next = it.next();
                Function3<Integer, Object, Object, Object> function3 = this.$operation;
                int i4 = i + 1;
                if (i < 0) {
                    m.p();
                }
                Object invoke = function3.invoke(qc.b(i), obj2, next);
                this.L$0 = s82;
                this.L$1 = invoke;
                this.L$2 = it;
                this.I$0 = i4;
                this.label = 2;
                if (s82.a(invoke, this) == obj3) {
                    return obj3;
                }
                obj2 = invoke;
                i = i4;
            }
            return ur2.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        i = 0;
        s82 = s822;
        obj2 = this.$initial;
        it = this.$this_runningFoldIndexed.iterator();
        while (it.hasNext()) {
        }
        return ur2.INSTANCE;
    }
}
