package cn.damai.commonbusiness.wannasee.view;

import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.wannasee.bean.RecommendProjects;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import tb.fb0;
import tb.k21;
import tb.ur2;

/* compiled from: Taobao */
public final class WantSeeRecommendView$doRefresh$3 extends Lambda implements Function1<fb0<RecommendProjects>, ur2> {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ WantSeeRecommendView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    WantSeeRecommendView$doRefresh$3(WantSeeRecommendView wantSeeRecommendView) {
        super(1);
        this.this$0 = wantSeeRecommendView;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ ur2 invoke(fb0<RecommendProjects> fb0) {
        invoke(fb0);
        return ur2.INSTANCE;
    }

    public final void invoke(@NotNull fb0<RecommendProjects> fb0) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1950027760")) {
            ipChange.ipc$dispatch("1950027760", new Object[]{this, fb0});
            return;
        }
        k21.i(fb0, AdvanceSetting.NETWORK_TYPE);
        this.this$0.hideLoading();
        ToastUtil.i("麦麦很忙，系统很累请稍后重试");
    }
}
