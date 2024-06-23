package cn.damai.homepage.v2;

import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.homepage.bean.HomeTabListBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;

/* compiled from: Taobao */
public final class ChannelPageTabFragment$requestTabData$listener$1 extends DMMtopRequestListener<HomeTabListBean> {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ ChannelPageTabFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChannelPageTabFragment$requestTabData$listener$1(ChannelPageTabFragment channelPageTabFragment, Class<HomeTabListBean> cls) {
        super(cls);
        this.this$0 = channelPageTabFragment;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
    public void onFail(@NotNull String str, @NotNull String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1222278725")) {
            ipChange.ipc$dispatch("1222278725", new Object[]{this, str, str2});
            return;
        }
        k21.i(str, "s");
        k21.i(str2, "s1");
    }

    public void onSuccess(@Nullable HomeTabListBean homeTabListBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-465153284")) {
            ipChange.ipc$dispatch("-465153284", new Object[]{this, homeTabListBean});
            return;
        }
        this.this$0.updateTab(homeTabListBean);
    }
}
