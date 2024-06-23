package cn.damai.tetris.component.discover.mvp;

import android.app.Activity;
import android.view.View;
import androidx.annotation.NonNull;
import cn.damai.common.app.base.BaseActivity;
import cn.damai.commonbusiness.discover.bean.VoteBean;
import cn.damai.commonbusiness.discover.bean.VoteInfoBean;
import cn.damai.commonbusiness.discover.viewholder.VotePanel;
import cn.damai.commonbusiness.discover.viewholder.VoteViewHolder;
import cn.damai.tetris.component.discover.mvp.VoteContract;
import cn.damai.tetris.core.AbsView;
import cn.damai.tetris.core.IPresenter;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.w9;

/* compiled from: Taobao */
public class VoteView extends AbsView<VoteContract.Presenter> implements VoteContract.View<VoteContract.Presenter> {
    private static transient /* synthetic */ IpChange $ipChange;
    private VoteViewHolder mHolder;

    /* compiled from: Taobao */
    public class a implements VotePanel.VoteActionListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // cn.damai.commonbusiness.discover.viewholder.VotePanel.VoteActionListener
        public Activity getActivity() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1411374499")) {
                return (Activity) ipChange.ipc$dispatch("-1411374499", new Object[]{this});
            }
            w9 context = VoteView.this.getContext();
            if (context != null) {
                return context.getActivity();
            }
            return null;
        }

        @Override // cn.damai.commonbusiness.discover.viewholder.VotePanel.VoteActionListener
        public void onVoteInfoUpdate(@NonNull VoteInfoBean voteInfoBean) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "342988255")) {
                ipChange.ipc$dispatch("342988255", new Object[]{this, voteInfoBean});
            }
        }

        @Override // cn.damai.commonbusiness.discover.viewholder.VotePanel.VoteActionListener
        public void showActivityLoading(boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1278878092")) {
                ipChange.ipc$dispatch("-1278878092", new Object[]{this, Boolean.valueOf(z)});
                return;
            }
            Activity activity = getActivity();
            if (!(activity instanceof BaseActivity)) {
                return;
            }
            if (z) {
                ((BaseActivity) activity).startProgressDialog();
            } else {
                ((BaseActivity) activity).stopProgressDialog();
            }
        }

        @Override // cn.damai.commonbusiness.discover.viewholder.VotePanel.VoteUtListener
        public void ut4CancelVoteClick(VoteInfoBean voteInfoBean) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2104869904")) {
                ipChange.ipc$dispatch("-2104869904", new Object[]{this, voteInfoBean});
                return;
            }
            VoteContract.Presenter presenter = (VoteContract.Presenter) VoteView.this.getPresenter();
            if (presenter != null) {
                presenter.ut4CancelVoteClick(voteInfoBean);
            }
        }

        @Override // cn.damai.commonbusiness.discover.viewholder.VotePanel.VoteUtListener
        public void ut4VoteCardExposure(View view, VoteInfoBean voteInfoBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "498488582")) {
                ipChange.ipc$dispatch("498488582", new Object[]{this, view, voteInfoBean, Integer.valueOf(i)});
                return;
            }
            VoteContract.Presenter presenter = (VoteContract.Presenter) VoteView.this.getPresenter();
            if (presenter != null) {
                presenter.ut4VoteCardExposure(view, voteInfoBean, i);
            }
        }

        @Override // cn.damai.commonbusiness.discover.viewholder.VotePanel.VoteUtListener
        public void ut4VoteClick(VoteInfoBean voteInfoBean, VoteBean voteBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1224975110")) {
                ipChange.ipc$dispatch("-1224975110", new Object[]{this, voteInfoBean, voteBean, Integer.valueOf(i)});
                return;
            }
            VoteContract.Presenter presenter = (VoteContract.Presenter) VoteView.this.getPresenter();
            if (presenter != null) {
                presenter.ut4VoteClick(voteInfoBean, voteBean, i);
            }
        }
    }

    public VoteView(View view) {
        super(view);
        this.mHolder = new VoteViewHolder(view, new a());
    }

    @Override // cn.damai.tetris.component.discover.mvp.VoteContract.View
    public void setData(VoteInfoBean voteInfoBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1682269459")) {
            ipChange.ipc$dispatch("-1682269459", new Object[]{this, voteInfoBean, Integer.valueOf(i)});
            return;
        }
        this.mHolder.a(voteInfoBean, i);
    }

    public void setPresenter(VoteContract.Presenter presenter) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-883255367")) {
            ipChange.ipc$dispatch("-883255367", new Object[]{this, presenter});
            return;
        }
        super.setPresenter((IPresenter) presenter);
    }
}
