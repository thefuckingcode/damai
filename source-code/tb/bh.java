package tb;

import cn.damai.common.user.a;
import cn.damai.commonbusiness.pageut.PageUtExecutor;
import cn.damai.homepage.v2.ChannelPageTabFragment;

/* compiled from: Taobao */
public final /* synthetic */ class bh implements PageUtExecutor.UTKeyBuilderProvider {
    public final /* synthetic */ ChannelPageTabFragment a;

    public /* synthetic */ bh(ChannelPageTabFragment channelPageTabFragment) {
        this.a = channelPageTabFragment;
    }

    @Override // cn.damai.commonbusiness.pageut.PageUtExecutor.UTKeyBuilderProvider
    public final a.b get(int i) {
        return ChannelPageTabFragment.m44updateViewPager$lambda7(this.a, i);
    }
}
