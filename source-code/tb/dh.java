package tb;

import android.view.View;
import cn.damai.homepage.v2.ChannelPageTabFragment;
import com.alibaba.pictures.bricks.view.DMUpMarqueeView;

/* compiled from: Taobao */
public final /* synthetic */ class dh implements DMUpMarqueeView.OnItemClickListener {
    public final /* synthetic */ ChannelPageTabFragment a;

    public /* synthetic */ dh(ChannelPageTabFragment channelPageTabFragment) {
        this.a = channelPageTabFragment;
    }

    @Override // com.alibaba.pictures.bricks.view.DMUpMarqueeView.OnItemClickListener
    public final void onItemClick(int i, View view) {
        ChannelPageTabFragment.m40initTitleBar$lambda3(this.a, i, view);
    }
}
