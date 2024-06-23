package cn.damai.homepage.v2;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import tb.ur2;

/* compiled from: Taobao */
public final class HomePageFragment$HomePageLoader$handleLoadSuccess$1 extends Lambda implements Function0<ur2> {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ HomePageFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HomePageFragment$HomePageLoader$handleLoadSuccess$1(HomePageFragment homePageFragment) {
        super(0);
        this.this$0 = homePageFragment;
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1652990357")) {
            ipChange.ipc$dispatch("1652990357", new Object[]{this});
            return;
        }
        HomePageFragment homePageFragment = this.this$0;
        homePageFragment.hideLoadingDialog(homePageFragment.getActivity());
    }
}
