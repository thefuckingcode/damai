package cn.damai.commonbusiness.wannasee.view;

import android.view.View;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.search.bean.FollowDataBean;
import com.alibaba.pictures.bricks.component.project.bean.ProjectItemBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import kotlin.jvm.functions.Function4;
import org.jetbrains.annotations.Nullable;
import tb.ur2;

/* compiled from: Taobao */
public final class WantSeeRecommendItemView$requestWantSee$2 extends DMMtopRequestListener<FollowDataBean> {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ int $pos;
    final /* synthetic */ ProjectItemBean $projectMo;
    final /* synthetic */ WantSeeRecommendItemView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    WantSeeRecommendItemView$requestWantSee$2(WantSeeRecommendItemView wantSeeRecommendItemView, ProjectItemBean projectItemBean, int i, Class<FollowDataBean> cls) {
        super(cls);
        this.this$0 = wantSeeRecommendItemView;
        this.$projectMo = projectItemBean;
        this.$pos = i;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
    public void onFail(@Nullable String str, @Nullable String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2054462825")) {
            ipChange.ipc$dispatch("2054462825", new Object[]{this, str, str2});
            return;
        }
        WantSeeRecommendItemView.access$getWantSeeTv$p(this.this$0).setEnabled(true);
        ToastUtil.i("麦麦很忙，系统很累请稍后重试");
    }

    public void onSuccess(@Nullable FollowDataBean followDataBean) {
        Function4<Integer, Object, Integer, View, ur2> onEventListener;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1357740759")) {
            ipChange.ipc$dispatch("1357740759", new Object[]{this, followDataBean});
            return;
        }
        WantSeeRecommendItemView.access$getWantSeeTv$p(this.this$0).setEnabled(true);
        if (followDataBean != null) {
            this.$projectMo.wantSeeStatus = followDataBean.getStatus();
            WantSeeRecommendItemView.access$setWantSeeStatus(this.this$0, this.$projectMo, this.$pos);
            if (followDataBean.getStatus() != 0 && (onEventListener = this.this$0.getOnEventListener()) != null) {
                onEventListener.invoke(4, this.$projectMo, Integer.valueOf(this.$pos), null);
                return;
            }
            return;
        }
        ToastUtil.i("麦麦很忙，系统很累请稍后重试");
    }
}
