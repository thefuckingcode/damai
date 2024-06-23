package kotlin.sequences;

import java.util.List;
import kotlin.collections.k;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.random.Random;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k12;
import tb.s82;
import tb.ur2;

@DebugMetadata(c = "kotlin.sequences.SequencesKt__SequencesKt$shuffled$1", f = "Sequences.kt", i = {0, 0}, l = {145}, m = "invokeSuspend", n = {"$this$sequence", "buffer"}, s = {"L$0", "L$1"})
/* compiled from: Taobao */
final class SequencesKt__SequencesKt$shuffled$1 extends RestrictedSuspendLambda implements Function2<s82<Object>, Continuation<? super ur2>, Object> {
    final /* synthetic */ Random $random;
    final /* synthetic */ Sequence<Object> $this_shuffled;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SequencesKt__SequencesKt$shuffled$1(Sequence<Object> sequence, Random random, Continuation<? super SequencesKt__SequencesKt$shuffled$1> continuation) {
        super(2, continuation);
        this.$this_shuffled = sequence;
        this.$random = random;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<ur2> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        SequencesKt__SequencesKt$shuffled$1 sequencesKt__SequencesKt$shuffled$1 = new SequencesKt__SequencesKt$shuffled$1(this.$this_shuffled, this.$random, continuation);
        sequencesKt__SequencesKt$shuffled$1.L$0 = obj;
        return sequencesKt__SequencesKt$shuffled$1;
    }

    @Nullable
    public final Object invoke(@NotNull s82<Object> s82, @Nullable Continuation<? super ur2> continuation) {
        return ((SequencesKt__SequencesKt$shuffled$1) create(s82, continuation)).invokeSuspend(ur2.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        s82 s82;
        List list;
        Object obj2 = b.d();
        int i = this.label;
        if (i == 0) {
            k12.b(obj);
            list = SequencesKt___SequencesKt.C(this.$this_shuffled);
            s82 = (s82) this.L$0;
        } else if (i == 1) {
            list = (List) this.L$1;
            s82 = (s82) this.L$0;
            k12.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        while (!list.isEmpty()) {
            int nextInt = this.$random.nextInt(list.size());
            Object y = k.y(list);
            if (nextInt < list.size()) {
                y = list.set(nextInt, y);
            }
            this.L$0 = s82;
            this.L$1 = list;
            this.label = 1;
            if (s82.a(y, this) == obj2) {
                return obj2;
            }
        }
        return ur2.INSTANCE;
    }
}
