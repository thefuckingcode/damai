package com.alibaba.pictures.dolores.time;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref$LongRef;
import org.jetbrains.annotations.NotNull;
import tb.k21;
import tb.ur2;
import tb.vp;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/alibaba/pictures/dolores/time/SyncTimeResponse;", "bizResponse", "Ltb/ur2;", "invoke", "(Lcom/alibaba/pictures/dolores/time/SyncTimeResponse;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* compiled from: Taobao */
public final class TimeSyncer$asyncTime$2 extends Lambda implements Function1<SyncTimeResponse, ur2> {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ Ref$LongRef $startTime;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TimeSyncer$asyncTime$2(Ref$LongRef ref$LongRef) {
        super(1);
        this.$startTime = ref$LongRef;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ ur2 invoke(SyncTimeResponse syncTimeResponse) {
        invoke(syncTimeResponse);
        return ur2.INSTANCE;
    }

    public final void invoke(@NotNull SyncTimeResponse syncTimeResponse) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-1320046325")) {
            ipChange.ipc$dispatch("-1320046325", new Object[]{this, syncTimeResponse});
            return;
        }
        k21.i(syncTimeResponse, "bizResponse");
        try {
            long currentTimeMillis = (System.currentTimeMillis() - this.$startTime.element) >> 1;
            String t = syncTimeResponse.getT();
            if (t != null) {
                if (t.length() <= 0) {
                    z = false;
                }
                if (!z) {
                    t = null;
                }
                if (t != null) {
                    TimeSyncer timeSyncer = TimeSyncer.INSTANCE;
                    TimeSyncer.c = (Long.parseLong(t) + currentTimeMillis) - System.currentTimeMillis();
                    if (currentTimeMillis > ((long) 500)) {
                        TimeSyncer.b.set(false);
                    }
                    String str = TimeSyncer.a;
                    vp.a(str, "sync time success timeDiff=" + TimeSyncer.c);
                    return;
                }
            }
            TimeSyncer timeSyncer2 = TimeSyncer.INSTANCE;
            vp.a(TimeSyncer.a, "sync time fail resp or resp.t is null");
            TimeSyncer.b.set(false);
            ur2 ur2 = ur2.INSTANCE;
        } catch (Exception e) {
            TimeSyncer timeSyncer3 = TimeSyncer.INSTANCE;
            String str2 = TimeSyncer.a;
            vp.a(str2, "sync time fail " + e.getMessage());
            TimeSyncer.b.set(false);
        }
    }
}
