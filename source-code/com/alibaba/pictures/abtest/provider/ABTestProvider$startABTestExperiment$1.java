package com.alibaba.pictures.abtest.provider;

import com.alibaba.pictures.abtest.model.ABTestExperiment;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;
import tb.c;
import tb.ur2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/alibaba/pictures/abtest/model/ABTestExperiment;", AdvanceSetting.NETWORK_TYPE, "Ltb/ur2;", "invoke", "(Lcom/alibaba/pictures/abtest/model/ABTestExperiment;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* compiled from: Taobao */
public final class ABTestProvider$startABTestExperiment$1 extends Lambda implements Function1<ABTestExperiment, ur2> {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final ABTestProvider$startABTestExperiment$1 INSTANCE = new ABTestProvider$startABTestExperiment$1();

    ABTestProvider$startABTestExperiment$1() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ ur2 invoke(ABTestExperiment aBTestExperiment) {
        invoke(aBTestExperiment);
        return ur2.INSTANCE;
    }

    public final void invoke(@Nullable ABTestExperiment aBTestExperiment) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1206188565")) {
            ipChange.ipc$dispatch("1206188565", new Object[]{this, aBTestExperiment});
            return;
        }
        c.b(null, "request ABTest Upload success", 1, null);
    }
}
