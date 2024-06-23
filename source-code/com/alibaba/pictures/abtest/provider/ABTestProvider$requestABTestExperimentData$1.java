package com.alibaba.pictures.abtest.provider;

import com.alibaba.pictures.abtest.model.ABTestScenarioResultList;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import tb.a;
import tb.c;
import tb.d;
import tb.k21;
import tb.ur2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/alibaba/pictures/abtest/model/ABTestScenarioResultList;", AdvanceSetting.NETWORK_TYPE, "Ltb/ur2;", "invoke", "(Lcom/alibaba/pictures/abtest/model/ABTestScenarioResultList;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* compiled from: Taobao */
public final class ABTestProvider$requestABTestExperimentData$1 extends Lambda implements Function1<ABTestScenarioResultList, ur2> {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final ABTestProvider$requestABTestExperimentData$1 INSTANCE = new ABTestProvider$requestABTestExperimentData$1();

    ABTestProvider$requestABTestExperimentData$1() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ ur2 invoke(ABTestScenarioResultList aBTestScenarioResultList) {
        invoke(aBTestScenarioResultList);
        return ur2.INSTANCE;
    }

    public final void invoke(@NotNull ABTestScenarioResultList aBTestScenarioResultList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1380393026")) {
            ipChange.ipc$dispatch("-1380393026", new Object[]{this, aBTestScenarioResultList});
            return;
        }
        k21.i(aBTestScenarioResultList, AdvanceSetting.NETWORK_TYPE);
        c.b(null, "request ABTestExperimentData success", 1, null);
        ABTestProvider aBTestProvider = ABTestProvider.INSTANCE;
        ABTestProvider.a = aBTestScenarioResultList;
        a aVar = a.INSTANCE;
        StringBuilder sb = new StringBuilder();
        sb.append(ABTestProvider.ABTestCacheKey);
        String b = d.Companion.b().b();
        if (b == null) {
            b = "";
        }
        sb.append(b);
        aVar.c(sb.toString(), aBTestScenarioResultList);
    }
}
