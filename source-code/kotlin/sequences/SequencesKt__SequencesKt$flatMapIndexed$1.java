package kotlin.sequences;

import java.util.Iterator;
import kotlin.collections.m;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k12;
import tb.qc;
import tb.s82;
import tb.ur2;

@DebugMetadata(c = "kotlin.sequences.SequencesKt__SequencesKt$flatMapIndexed$1", f = "Sequences.kt", i = {0, 0}, l = {332}, m = "invokeSuspend", n = {"$this$sequence", "index"}, s = {"L$0", "I$0"})
/* compiled from: Taobao */
final class SequencesKt__SequencesKt$flatMapIndexed$1 extends RestrictedSuspendLambda implements Function2<s82<Object>, Continuation<? super ur2>, Object> {
    final /* synthetic */ Function1<Object, Iterator<Object>> $iterator;
    final /* synthetic */ Sequence<Object> $source;
    final /* synthetic */ Function2<Integer, Object, Object> $transform;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.jvm.functions.Function2<? super java.lang.Integer, java.lang.Object, java.lang.Object> */
    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.jvm.functions.Function1<java.lang.Object, ? extends java.util.Iterator<java.lang.Object>> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SequencesKt__SequencesKt$flatMapIndexed$1(Sequence<Object> sequence, Function2<? super Integer, Object, Object> function2, Function1<Object, ? extends Iterator<Object>> function1, Continuation<? super SequencesKt__SequencesKt$flatMapIndexed$1> continuation) {
        super(2, continuation);
        this.$source = sequence;
        this.$transform = function2;
        this.$iterator = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<ur2> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        SequencesKt__SequencesKt$flatMapIndexed$1 sequencesKt__SequencesKt$flatMapIndexed$1 = new SequencesKt__SequencesKt$flatMapIndexed$1(this.$source, this.$transform, this.$iterator, continuation);
        sequencesKt__SequencesKt$flatMapIndexed$1.L$0 = obj;
        return sequencesKt__SequencesKt$flatMapIndexed$1;
    }

    @Nullable
    public final Object invoke(@NotNull s82<Object> s82, @Nullable Continuation<? super ur2> continuation) {
        return ((SequencesKt__SequencesKt$flatMapIndexed$1) create(s82, continuation)).invokeSuspend(ur2.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        s82 s82;
        Iterator<Object> it;
        int i;
        Object obj2 = b.d();
        int i2 = this.label;
        if (i2 == 0) {
            k12.b(obj);
            i = 0;
            it = this.$source.iterator();
            s82 = (s82) this.L$0;
        } else if (i2 == 1) {
            i = this.I$0;
            it = (Iterator) this.L$1;
            s82 = (s82) this.L$0;
            k12.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        while (it.hasNext()) {
            Object next = it.next();
            Function2<Integer, Object, Object> function2 = this.$transform;
            int i3 = i + 1;
            if (i < 0) {
                m.p();
            }
            Object invoke = function2.invoke(qc.b(i), next);
            this.L$0 = s82;
            this.L$1 = it;
            this.I$0 = i3;
            this.label = 1;
            if (s82.b(this.$iterator.invoke(invoke), this) == obj2) {
                return obj2;
            }
            i = i3;
        }
        return ur2.INSTANCE;
    }
}
