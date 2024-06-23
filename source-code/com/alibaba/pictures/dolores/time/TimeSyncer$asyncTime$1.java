package com.alibaba.pictures.dolores.time;

import com.alibaba.pictures.dolores.request.DoloresRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref$LongRef;
import org.jetbrains.annotations.Nullable;
import tb.ur2;
import tb.vp;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/alibaba/pictures/dolores/request/DoloresRequest;", "Lcom/alibaba/pictures/dolores/time/SyncTimeResponse;", AdvanceSetting.NETWORK_TYPE, "Ltb/ur2;", "invoke", "(Lcom/alibaba/pictures/dolores/request/DoloresRequest;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* compiled from: Taobao */
public final class TimeSyncer$asyncTime$1 extends Lambda implements Function1<DoloresRequest<SyncTimeResponse>, ur2> {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ Ref$LongRef $startTime;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TimeSyncer$asyncTime$1(Ref$LongRef ref$LongRef) {
        super(1);
        this.$startTime = ref$LongRef;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ ur2 invoke(DoloresRequest<SyncTimeResponse> doloresRequest) {
        invoke(doloresRequest);
        return ur2.INSTANCE;
    }

    public final void invoke(@Nullable DoloresRequest<SyncTimeResponse> doloresRequest) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-657713570")) {
            ipChange.ipc$dispatch("-657713570", new Object[]{this, doloresRequest});
            return;
        }
        TimeSyncer timeSyncer = TimeSyncer.INSTANCE;
        String str = TimeSyncer.a;
        vp.a(str, "prepareTime=" + (System.currentTimeMillis() - this.$startTime.element));
        this.$startTime.element = System.currentTimeMillis();
    }
}
