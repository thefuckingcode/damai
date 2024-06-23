package kotlinx.coroutines.flow;

import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import org.jetbrains.annotations.NotNull;
import tb.ur2;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final /* synthetic */ class FlowKt__DelayKt {
    @NotNull
    public static final ReceiveChannel<ur2> a(@NotNull CoroutineScope coroutineScope, long j, long j2) {
        boolean z = true;
        if (j >= 0) {
            if (j2 < 0) {
                z = false;
            }
            if (z) {
                return ProduceKt.e(coroutineScope, null, 0, new FlowKt__DelayKt$fixedPeriodTicker$3(j2, j, null), 1, null);
            }
            throw new IllegalArgumentException(("Expected non-negative initial delay, but has " + j2 + " ms").toString());
        }
        throw new IllegalArgumentException(("Expected non-negative delay, but has " + j + " ms").toString());
    }

    public static /* synthetic */ ReceiveChannel b(CoroutineScope coroutineScope, long j, long j2, int i, Object obj) {
        if ((i & 2) != 0) {
            j2 = j;
        }
        return c.p(coroutineScope, j, j2);
    }
}
