package com.alibaba.pictures.bricks.fragment;

import androidx.fragment.app.FragmentActivity;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.page.state.State;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;
import tb.um2;

/* compiled from: Taobao */
public final class NewChannelFragment$ChannelPageLoader$handleLoadFailure$1 extends Lambda implements Function0<FragmentActivity> {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ NewChannelFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NewChannelFragment$ChannelPageLoader$handleLoadFailure$1(NewChannelFragment newChannelFragment) {
        super(0);
        this.this$0 = newChannelFragment;
    }

    @Override // kotlin.jvm.functions.Function0
    @Nullable
    public final FragmentActivity invoke() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1368878458")) {
            return (FragmentActivity) ipChange.ipc$dispatch("-1368878458", new Object[]{this});
        }
        FragmentActivity activity = this.this$0.getActivity();
        if (activity == null) {
            return null;
        }
        NewChannelFragment newChannelFragment = this.this$0;
        newChannelFragment.hideLoadingDialog(activity);
        if (newChannelFragment.getPageLoader().getRealItemCount() > 0) {
            um2.INSTANCE.i(activity, "小二很忙，系统很累，稍后再试吧");
            return activity;
        }
        newChannelFragment.getPageStateManager().setState(State.FAILED);
        return activity;
    }
}
