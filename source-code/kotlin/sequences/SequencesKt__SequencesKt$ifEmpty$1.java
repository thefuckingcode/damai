package kotlin.sequences;

import java.util.Iterator;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k12;
import tb.s82;
import tb.ur2;

@DebugMetadata(c = "kotlin.sequences.SequencesKt__SequencesKt$ifEmpty$1", f = "Sequences.kt", i = {}, l = {69, 71}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: Taobao */
final class SequencesKt__SequencesKt$ifEmpty$1 extends RestrictedSuspendLambda implements Function2<s82<Object>, Continuation<? super ur2>, Object> {
    final /* synthetic */ Function0<Sequence<Object>> $defaultValue;
    final /* synthetic */ Sequence<Object> $this_ifEmpty;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.jvm.functions.Function0<? extends kotlin.sequences.Sequence<java.lang.Object>> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SequencesKt__SequencesKt$ifEmpty$1(Sequence<Object> sequence, Function0<? extends Sequence<Object>> function0, Continuation<? super SequencesKt__SequencesKt$ifEmpty$1> continuation) {
        super(2, continuation);
        this.$this_ifEmpty = sequence;
        this.$defaultValue = function0;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<ur2> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        SequencesKt__SequencesKt$ifEmpty$1 sequencesKt__SequencesKt$ifEmpty$1 = new SequencesKt__SequencesKt$ifEmpty$1(this.$this_ifEmpty, this.$defaultValue, continuation);
        sequencesKt__SequencesKt$ifEmpty$1.L$0 = obj;
        return sequencesKt__SequencesKt$ifEmpty$1;
    }

    @Nullable
    public final Object invoke(@NotNull s82<Object> s82, @Nullable Continuation<? super ur2> continuation) {
        return ((SequencesKt__SequencesKt$ifEmpty$1) create(s82, continuation)).invokeSuspend(ur2.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object obj2 = b.d();
        int i = this.label;
        if (i == 0) {
            k12.b(obj);
            s82 s82 = (s82) this.L$0;
            Iterator<Object> it = this.$this_ifEmpty.iterator();
            if (it.hasNext()) {
                this.label = 1;
                if (s82.b(it, this) == obj2) {
                    return obj2;
                }
            } else {
                this.label = 2;
                if (s82.c(this.$defaultValue.invoke(), this) == obj2) {
                    return obj2;
                }
            }
        } else if (i == 1 || i == 2) {
            k12.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return ur2.INSTANCE;
    }
}
