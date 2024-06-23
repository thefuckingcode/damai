package cn.damai.homepage.v2;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.youku.arch.v3.page.GenericFragment;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class HomePageFragment$PageLoadingListener$onAllPageLoaded$1 extends Lambda implements Function0<RefreshLayout> {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ HomePageFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HomePageFragment$PageLoadingListener$onAllPageLoaded$1(HomePageFragment homePageFragment) {
        super(0);
        this.this$0 = homePageFragment;
    }

    @Override // kotlin.jvm.functions.Function0
    @Nullable
    public final RefreshLayout invoke() {
        RefreshLayout refreshLayout;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "400257279")) {
            return (RefreshLayout) ipChange.ipc$dispatch("400257279", new Object[]{this});
        }
        GenericFragment fragment = this.this$0.getPageContext().getFragment();
        if (fragment == null || (refreshLayout = fragment.getRefreshLayout()) == null) {
            return null;
        }
        return refreshLayout.setEnableLoadMore(false);
    }
}
