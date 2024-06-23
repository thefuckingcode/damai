package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k03;
import tb.k12;
import tb.s01;
import tb.ur2;

/* compiled from: Taobao */
public final class CombineKt$combineInternal$2$1$invokeSuspend$$inlined$collect$1 implements FlowCollector<T> {
    final /* synthetic */ Channel a;
    final /* synthetic */ int b;

    public CombineKt$combineInternal$2$1$invokeSuspend$$inlined$collect$1(Channel channel, int i) {
        this.a = channel;
        this.b = i;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0055 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    @Override // kotlinx.coroutines.flow.FlowCollector
    @Nullable
    public Object emit(T t, @NotNull Continuation<? super ur2> continuation) {
        AnonymousClass1 r0;
        Object obj;
        int i;
        if (continuation instanceof AnonymousClass1) {
            r0 = (AnonymousClass1) continuation;
            int i2 = r0.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                r0.label = i2 - Integer.MIN_VALUE;
                Object obj2 = r0.result;
                obj = b.d();
                i = r0.label;
                if (i != 0) {
                    k12.b(obj2);
                    Channel channel = this.a;
                    s01 s01 = new s01(this.b, t);
                    r0.label = 1;
                    if (channel.send(s01, r0) == obj) {
                        return obj;
                    }
                } else if (i == 1) {
                    k12.b(obj2);
                } else if (i == 2) {
                    k12.b(obj2);
                    return ur2.INSTANCE;
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                r0.label = 2;
                if (k03.a(r0) == obj) {
                    return obj;
                }
                return ur2.INSTANCE;
            }
        }
        r0 = new ContinuationImpl(this, continuation) {
            /* class kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1$invokeSuspend$$inlined$collect$1.AnonymousClass1 */
            int label;
            /* synthetic */ Object result;
            final /* synthetic */ CombineKt$combineInternal$2$1$invokeSuspend$$inlined$collect$1 this$0;

            {
                this.this$0 = r1;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                this.result = obj;
                this.label |= Integer.MIN_VALUE;
                return this.this$0.emit(null, this);
            }
        };
        Object obj22 = r0.result;
        obj = b.d();
        i = r0.label;
        if (i != 0) {
        }
        r0.label = 2;
        if (k03.a(r0) == obj) {
        }
        return ur2.INSTANCE;
    }
}
