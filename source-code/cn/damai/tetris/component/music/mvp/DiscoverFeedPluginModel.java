package cn.damai.tetris.component.music.mvp;

import cn.damai.musicfestival.bean.FeedInfo;
import cn.damai.tetris.component.music.mvp.DiscoverFeedPluginContract;
import cn.damai.tetris.core.AbsModel;
import cn.damai.tetris.core.BaseNode;
import cn.damai.tetris.core.NodeData;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.s41;

/* compiled from: Taobao */
public class DiscoverFeedPluginModel extends AbsModel implements DiscoverFeedPluginContract.Model {
    private static transient /* synthetic */ IpChange $ipChange;
    private FeedInfo mTitle;

    @Override // cn.damai.tetris.component.music.mvp.DiscoverFeedPluginContract.Model
    public FeedInfo getBean() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "927791536")) {
            return this.mTitle;
        }
        return (FeedInfo) ipChange.ipc$dispatch("927791536", new Object[]{this});
    }

    @Override // cn.damai.tetris.core.AbsModel
    public void parseModel(BaseNode baseNode) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1586358718")) {
            ipChange.ipc$dispatch("-1586358718", new Object[]{this, baseNode});
            return;
        }
        NodeData item = baseNode.getItem();
        if (item != null) {
            this.mTitle = (FeedInfo) s41.d(item, FeedInfo.class);
        }
    }
}
