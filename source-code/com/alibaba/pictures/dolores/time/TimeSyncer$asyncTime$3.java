package com.alibaba.pictures.dolores.time;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import tb.fb0;
import tb.k21;
import tb.ur2;
import tb.vp;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Ltb/fb0;", "Lcom/alibaba/pictures/dolores/time/SyncTimeResponse;", AdvanceSetting.NETWORK_TYPE, "Ltb/ur2;", "invoke", "(Ltb/fb0;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* compiled from: Taobao */
public final class TimeSyncer$asyncTime$3 extends Lambda implements Function1<fb0<SyncTimeResponse>, ur2> {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final TimeSyncer$asyncTime$3 INSTANCE = new TimeSyncer$asyncTime$3();

    TimeSyncer$asyncTime$3() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ ur2 invoke(fb0<SyncTimeResponse> fb0) {
        invoke(fb0);
        return ur2.INSTANCE;
    }

    public final void invoke(@NotNull fb0<SyncTimeResponse> fb0) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-92285548")) {
            ipChange.ipc$dispatch("-92285548", new Object[]{this, fb0});
            return;
        }
        k21.i(fb0, AdvanceSetting.NETWORK_TYPE);
        TimeSyncer timeSyncer = TimeSyncer.INSTANCE;
        vp.a(TimeSyncer.a, "sync time return fail");
        TimeSyncer.b.set(false);
    }
}
