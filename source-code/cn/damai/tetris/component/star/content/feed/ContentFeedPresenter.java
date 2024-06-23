package cn.damai.tetris.component.star.content.feed;

import android.widget.GridView;
import android.widget.ListAdapter;
import cn.damai.commonbusiness.R$id;
import cn.damai.tetris.component.star.content.feed.ContentFeedContract;
import cn.damai.tetris.core.BasePresenter;
import cn.damai.tetris.core.BaseSection;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.w9;

/* compiled from: Taobao */
public class ContentFeedPresenter extends BasePresenter<ContentFeedContract.Model, ContentFeedView, BaseSection> implements ContentFeedContract.Presenter<ContentFeedContract.Model, ContentFeedView, BaseSection> {
    private static transient /* synthetic */ IpChange $ipChange;

    public ContentFeedPresenter(ContentFeedView contentFeedView, String str, w9 w9Var) {
        super(contentFeedView, str, w9Var);
    }

    @Override // cn.damai.tetris.core.msg.IMessage, cn.damai.tetris.core.BasePresenter
    public void onMessage(int i, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2121403922")) {
            ipChange.ipc$dispatch("-2121403922", new Object[]{this, Integer.valueOf(i), obj});
        }
    }

    public void init(ContentFeedContract.Model model) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1228791005")) {
            ipChange.ipc$dispatch("1228791005", new Object[]{this, model});
            return;
        }
        ((GridView) ((ContentFeedView) getView()).getGridView().findViewById(R$id.tetris_star_grid_layout)).setAdapter((ListAdapter) new ContentFeedAdapter(getContext().getActivity(), model.getData()));
    }
}
