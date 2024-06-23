package cn.damai.tetris.component.music.mvp;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import cn.damai.commonbusiness.R$id;
import cn.damai.musicfestival.bean.FeedInfo;
import cn.damai.tetris.component.music.mvp.DiscoverFeedPluginContract;
import cn.damai.tetris.core.AbsView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.v50;

/* compiled from: Taobao */
public class DiscoverFeedPluginView extends AbsView<DiscoverFeedPluginContract.Presenter> implements DiscoverFeedPluginContract.View<DiscoverFeedPluginContract.Presenter> {
    private static transient /* synthetic */ IpChange $ipChange;
    private TextView mTitleTv;

    public DiscoverFeedPluginView(View view) {
        super(view);
        this.mTitleTv = (TextView) view.findViewById(R$id.item_feed_title);
    }

    private void updateTitleView(FeedInfo feedInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "296197332")) {
            ipChange.ipc$dispatch("296197332", new Object[]{this, feedInfo});
        } else if (feedInfo == null || TextUtils.isEmpty(feedInfo.feedTitle) || getContext() == null || getContext().getActivity() == null) {
            getView().getLayoutParams().height = v50.a(getContext().getActivity(), 0.0f);
        } else {
            getView().getLayoutParams().height = v50.a(getContext().getActivity(), 51.0f);
        }
    }

    @Override // cn.damai.tetris.component.music.mvp.DiscoverFeedPluginContract.View
    public void setData(FeedInfo feedInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1243738364")) {
            ipChange.ipc$dispatch("1243738364", new Object[]{this, feedInfo});
            return;
        }
        if (feedInfo != null) {
            this.mTitleTv.setText(feedInfo.feedTitle);
        }
        updateTitleView(feedInfo);
    }
}
