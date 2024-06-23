package kotlin.sequences;

import com.taobao.weex.ui.component.AbstractEditComponent;
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

@DebugMetadata(c = "kotlin.sequences.SequencesKt___SequencesKt$zipWithNext$2", f = "_Sequences.kt", i = {0, 0, 0}, l = {2864}, m = "invokeSuspend", n = {"$this$result", "iterator", AbstractEditComponent.ReturnTypes.NEXT}, s = {"L$0", "L$1", "L$2"})
/* compiled from: Taobao */
final class SequencesKt___SequencesKt$zipWithNext$2 extends RestrictedSuspendLambda implements Function2<s82<Object>, Continuation<? super ur2>, Object> {
    final /* synthetic */ Sequence<Object> $this_zipWithNext;
    final /* synthetic */ Function2<Object, Object, Object> $transform;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SequencesKt___SequencesKt$zipWithNext$2(Sequence<Object> sequence, Function2<Object, Object, Object> function2, Continuation<? super SequencesKt___SequencesKt$zipWithNext$2> continuation) {
        super(2, continuation);
        this.$this_zipWithNext = sequence;
        this.$transform = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<ur2> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        SequencesKt___SequencesKt$zipWithNext$2 sequencesKt___SequencesKt$zipWithNext$2 = new SequencesKt___SequencesKt$zipWithNext$2(this.$this_zipWithNext, this.$transform, continuation);
        sequencesKt___SequencesKt$zipWithNext$2.L$0 = obj;
        return sequencesKt___SequencesKt$zipWithNext$2;
    }

    @Nullable
    public final Object invoke(@NotNull s82<Object> s82, @Nullable Continuation<? super ur2> continuation) {
        return ((SequencesKt___SequencesKt$zipWithNext$2) create(s82, continuation)).invokeSuspend(ur2.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object obj2;
        s82 s82;
        Iterator<Object> it;
        Object obj3 = b.d();
        int i = this.label;
        if (i == 0) {
            k12.b(obj);
            s82 s822 = (s82) this.L$0;
            Iterator<Object> it2 = this.$this_zipWithNext.iterator();
            if (!it2.hasNext()) {
                return ur2.INSTANCE;
            }
            s82 = s822;
            obj2 = it2.next();
            it = it2;
        } else if (i == 1) {
            Object obj4 = this.L$2;
            it = (Iterator) this.L$1;
            s82 = (s82) this.L$0;
            k12.b(obj);
            obj2 = obj4;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        while (it.hasNext()) {
            Object next = it.next();
            Object invoke = this.$transform.invoke(obj2, next);
            this.L$0 = s82;
            this.L$1 = it;
            this.L$2 = next;
            this.label = 1;
            if (s82.a(invoke, this) == obj3) {
                return obj3;
            }
            obj2 = next;
        }
        return ur2.INSTANCE;
    }
}
