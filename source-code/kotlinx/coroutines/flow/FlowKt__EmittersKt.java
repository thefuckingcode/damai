package kotlinx.coroutines.flow;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.b;
import kotlin.jvm.functions.Function3;
import org.jetbrains.annotations.NotNull;
import tb.jf0;
import tb.k12;
import tb.ur2;
import tb.zk2;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final /* synthetic */ class FlowKt__EmittersKt {
    public static final void b(@NotNull FlowCollector<?> flowCollector) {
        if (flowCollector instanceof zk2) {
            throw ((zk2) flowCollector).a;
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    public static final <T> Object c(FlowCollector<? super T> flowCollector, Function3<? super FlowCollector<? super T>, ? super Throwable, ? super Continuation<? super ur2>, ? extends Object> function3, Throwable th, Continuation<? super ur2> continuation) {
        FlowKt__EmittersKt$invokeSafely$1 flowKt__EmittersKt$invokeSafely$1;
        int i;
        if (continuation instanceof FlowKt__EmittersKt$invokeSafely$1) {
            flowKt__EmittersKt$invokeSafely$1 = (FlowKt__EmittersKt$invokeSafely$1) continuation;
            int i2 = flowKt__EmittersKt$invokeSafely$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                flowKt__EmittersKt$invokeSafely$1.label = i2 - Integer.MIN_VALUE;
                Object obj = flowKt__EmittersKt$invokeSafely$1.result;
                Object obj2 = b.d();
                i = flowKt__EmittersKt$invokeSafely$1.label;
                if (i != 0) {
                    k12.b(obj);
                    flowKt__EmittersKt$invokeSafely$1.L$0 = th;
                    flowKt__EmittersKt$invokeSafely$1.label = 1;
                    if (function3.invoke(flowCollector, th, flowKt__EmittersKt$invokeSafely$1) == obj2) {
                        return obj2;
                    }
                } else if (i == 1) {
                    Throwable th2 = (Throwable) flowKt__EmittersKt$invokeSafely$1.L$0;
                    try {
                        k12.b(obj);
                    } catch (Throwable th3) {
                        if (!(th2 == null || th2 == th3)) {
                            jf0.a(th3, th2);
                        }
                        throw th3;
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return ur2.INSTANCE;
            }
        }
        flowKt__EmittersKt$invokeSafely$1 = new FlowKt__EmittersKt$invokeSafely$1(continuation);
        Object obj3 = flowKt__EmittersKt$invokeSafely$1.result;
        Object obj22 = b.d();
        i = flowKt__EmittersKt$invokeSafely$1.label;
        if (i != 0) {
        }
        return ur2.INSTANCE;
    }
}
