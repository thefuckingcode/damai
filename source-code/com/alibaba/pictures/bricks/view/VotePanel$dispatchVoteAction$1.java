package com.alibaba.pictures.bricks.view;

import com.alibaba.pictures.bricks.bean.VoteActionRes;
import com.alibaba.pictures.bricks.bean.VoteBean;
import com.alibaba.pictures.bricks.bean.VoteInfoBean;
import com.alibaba.pictures.bricks.util.toast.BricksToastUtil;
import com.alibaba.pictures.bricks.view.VotePanel;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.ur2;

/* compiled from: Taobao */
public final class VotePanel$dispatchVoteAction$1 extends Lambda implements Function1<VoteActionRes, ur2> {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ boolean $isVote;
    final /* synthetic */ VoteBean $outBean;
    final /* synthetic */ int $posInFeedList;
    final /* synthetic */ VotePanel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    VotePanel$dispatchVoteAction$1(VotePanel votePanel, boolean z, VoteBean voteBean, int i) {
        super(1);
        this.this$0 = votePanel;
        this.$isVote = z;
        this.$outBean = voteBean;
        this.$posInFeedList = i;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ ur2 invoke(VoteActionRes voteActionRes) {
        invoke(voteActionRes);
        return ur2.INSTANCE;
    }

    public final void invoke(@Nullable VoteActionRes voteActionRes) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "502689702")) {
            ipChange.ipc$dispatch("502689702", new Object[]{this, voteActionRes});
        } else if (voteActionRes != null) {
            this.this$0.g.showActivityLoading(false);
            if (voteActionRes.isShouldShowToast()) {
                BricksToastUtil.INSTANCE.b(voteActionRes.msg);
            }
            if (voteActionRes.isValid()) {
                VotePanel.VoteActionListener voteActionListener = this.this$0.g;
                VoteInfoBean voteInfoBean = voteActionRes.voteVO;
                k21.h(voteInfoBean, "bean.voteVO");
                voteActionListener.onVoteInfoUpdate(voteInfoBean);
                VotePanel votePanel = this.this$0;
                votePanel.e(voteActionRes.voteVO, true, votePanel.g());
            } else {
                this.this$0.g.showActivityLoading(false);
                BricksToastUtil.INSTANCE.b("数据异常，请点击重试");
            }
            if (this.this$0.e == null) {
                return;
            }
            if (this.$isVote) {
                this.this$0.g.ut4VoteClick(this.this$0.e, this.$outBean, this.$posInFeedList);
            } else {
                this.this$0.g.ut4CancelVoteClick(this.this$0.e);
            }
        }
    }
}
