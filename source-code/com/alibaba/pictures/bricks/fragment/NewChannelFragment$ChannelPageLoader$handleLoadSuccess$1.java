package com.alibaba.pictures.bricks.fragment;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import tb.ur2;

/* compiled from: Taobao */
public final class NewChannelFragment$ChannelPageLoader$handleLoadSuccess$1 extends Lambda implements Function0<ur2> {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ NewChannelFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NewChannelFragment$ChannelPageLoader$handleLoadSuccess$1(NewChannelFragment newChannelFragment) {
        super(0);
        this.this$0 = newChannelFragment;
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1950664658")) {
            ipChange.ipc$dispatch("1950664658", new Object[]{this});
            return;
        }
        NewChannelFragment newChannelFragment = this.this$0;
        newChannelFragment.hideLoadingDialog(newChannelFragment.getActivity());
    }
}
