package com.alibaba.pictures.bricks.fragment;

import com.alibaba.pictures.bricks.util.toast.BricksToastUtil;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.io.IResponse;
import com.youku.arch.v3.page.state.State;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import tb.ph1;
import tb.ur2;

/* compiled from: Taobao */
public final class ScriptDetailFragment$ScriptDetailLoader$handleLoadFailure$1$1 extends Lambda implements Function0<ur2> {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ IResponse $response;
    final /* synthetic */ ScriptDetailFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ScriptDetailFragment$ScriptDetailLoader$handleLoadFailure$1$1(ScriptDetailFragment scriptDetailFragment, IResponse iResponse) {
        super(0);
        this.this$0 = scriptDetailFragment;
        this.$response = iResponse;
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1912054693")) {
            ipChange.ipc$dispatch("-1912054693", new Object[]{this});
            return;
        }
        ScriptDetailFragment scriptDetailFragment = this.this$0;
        scriptDetailFragment.hideLoadingDialog(scriptDetailFragment.getActivity());
        String a = ph1.a(this.$response.getRetCode(), this.$response.getRetMessage());
        if (this.this$0.getPageLoader().getRealItemCount() > 0) {
            BricksToastUtil.INSTANCE.b(a);
        } else {
            this.this$0.getPageStateManager().setState(State.FAILED);
        }
    }
}
