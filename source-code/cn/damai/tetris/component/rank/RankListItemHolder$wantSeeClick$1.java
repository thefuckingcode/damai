package cn.damai.tetris.component.rank;

import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.commonbusiness.search.bean.FollowDataBean;
import cn.damai.tetris.component.rank.bean.RankItemBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import org.jetbrains.annotations.NotNull;
import tb.k21;

/* compiled from: Taobao */
public final class RankListItemHolder$wantSeeClick$1 extends DMMtopRequestListener<FollowDataBean> {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ RankItemBean $temp;
    final /* synthetic */ RankListItemHolder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RankListItemHolder$wantSeeClick$1(RankItemBean rankItemBean, RankListItemHolder rankListItemHolder, Class<FollowDataBean> cls) {
        super(cls);
        this.$temp = rankItemBean;
        this.this$0 = rankListItemHolder;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
    public void onFail(@NotNull String str, @NotNull String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-871926525")) {
            ipChange.ipc$dispatch("-871926525", new Object[]{this, str, str2});
            return;
        }
        k21.i(str, "errorCode");
        k21.i(str2, "errorMsg");
        FollowDataBean followDataBean = new FollowDataBean();
        followDataBean.setStatus(0);
        OnItemClickListener onItemClickListener = this.this$0.a;
        if (onItemClickListener != null) {
            onItemClickListener.onWantSeeClick(this.this$0.b, this.$temp.index, followDataBean);
        }
    }

    public void onSuccess(@NotNull FollowDataBean followDataBean) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-461358851")) {
            ipChange.ipc$dispatch("-461358851", new Object[]{this, followDataBean});
            return;
        }
        k21.i(followDataBean, "followDataBean");
        HashMap<Long, Boolean> a = RankListItemHolder.Companion.a();
        Long valueOf = Long.valueOf(this.$temp.id);
        if (followDataBean.getStatus() <= 0) {
            z = false;
        }
        a.put(valueOf, Boolean.valueOf(z));
        this.this$0.updateFollowState(followDataBean);
        OnItemClickListener onItemClickListener = this.this$0.a;
        if (onItemClickListener != null) {
            onItemClickListener.onWantSeeClick(this.this$0.b, this.$temp.index, followDataBean);
        }
    }
}
