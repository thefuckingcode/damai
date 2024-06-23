package cn.damai.commonbusiness.wannasee.view;

import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.wannasee.bean.RecommendProjects;
import com.alibaba.pictures.bricks.component.project.bean.ProjectItemBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import tb.k21;
import tb.ur2;

/* compiled from: Taobao */
public final class WantSeeRecommendView$doRefresh$2 extends Lambda implements Function1<RecommendProjects, ur2> {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ WantSeeRecommendView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    WantSeeRecommendView$doRefresh$2(WantSeeRecommendView wantSeeRecommendView) {
        super(1);
        this.this$0 = wantSeeRecommendView;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ ur2 invoke(RecommendProjects recommendProjects) {
        invoke(recommendProjects);
        return ur2.INSTANCE;
    }

    public final void invoke(@NotNull RecommendProjects recommendProjects) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-1290612053")) {
            ipChange.ipc$dispatch("-1290612053", new Object[]{this, recommendProjects});
            return;
        }
        k21.i(recommendProjects, AdvanceSetting.NETWORK_TYPE);
        this.this$0.hideLoading();
        List<ProjectItemBean> list = recommendProjects.details;
        if (list != null && !list.isEmpty()) {
            z = false;
        }
        if (z) {
            ToastUtil.i("没有更多相似的演出啦");
            return;
        }
        Function1<RecommendProjects, ur2> onRefreshSuccess = this.this$0.getOnRefreshSuccess();
        if (onRefreshSuccess != null) {
            onRefreshSuccess.invoke(recommendProjects);
        }
    }
}
