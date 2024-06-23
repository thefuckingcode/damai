package cn.damai.tetris.component.star.content.feed;

import android.view.View;
import android.view.ViewGroup;
import cn.damai.tetris.component.star.content.feed.ContentFeedContract;
import cn.damai.tetris.core.AbsView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class ContentFeedView extends AbsView implements ContentFeedContract.View {
    private static transient /* synthetic */ IpChange $ipChange;

    public ContentFeedView(View view) {
        super(view);
    }

    @Override // cn.damai.tetris.component.star.content.feed.ContentFeedContract.View
    public ViewGroup getGridView() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1291713018")) {
            return (ViewGroup) getView();
        }
        return (ViewGroup) ipChange.ipc$dispatch("1291713018", new Object[]{this});
    }
}
