package cn.damai.homepage.v2;

import cn.damai.common.net.mtop.Util;
import cn.damai.common.util.toastutil.a;
import cn.damai.homepage.util.HomeHeadUiBinder;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.io.IResponse;
import com.youku.arch.v3.page.state.State;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import tb.dr;
import tb.hx0;
import tb.k21;
import tb.ur2;

/* compiled from: Taobao */
public final class HomePageFragment$HomePageLoader$handleLoadFailure$1 extends Lambda implements Function0<ur2> {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ IResponse $response;
    final /* synthetic */ HomePageFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HomePageFragment$HomePageLoader$handleLoadFailure$1(HomePageFragment homePageFragment, IResponse iResponse) {
        super(0);
        this.this$0 = homePageFragment;
        this.$response = iResponse;
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1605838116")) {
            ipChange.ipc$dispatch("-1605838116", new Object[]{this});
            return;
        }
        HomePageFragment homePageFragment = this.this$0;
        homePageFragment.hideLoadingDialog(homePageFragment.getActivity());
        String errorMsg = Util.getErrorMsg(this.$response.getRetCode(), this.$response.getRetMessage());
        if (this.this$0.getPageLoader().getRealItemCount() <= 0 || !k21.d(this.$response.getSource(), "remote")) {
            HomeHeadUiBinder homeHeadUiBinder = this.this$0.mHomeHeadUiBinder;
            if (homeHeadUiBinder != null) {
                homeHeadUiBinder.d();
            }
            dr.INSTANCE.a().a("mtop.damai.mec.aristotle.get").h(hx0.patternName).i(hx0.patternVersion).c(this.$response.getRetCode()).d(this.$response.getRetMessage()).g("大麦oneArch新首页").f(false).b();
            this.this$0.getPageStateManager().setState(State.FAILED);
            return;
        }
        a.i(this.this$0.requireContext(), errorMsg);
    }
}
