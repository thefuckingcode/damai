package com.alibaba.pictures.bricks.fragment;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class NewChannelFragment$PageLoadingListener$onAllPageLoaded$1 extends Lambda implements Function0<RefreshLayout> {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ NewChannelFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NewChannelFragment$PageLoadingListener$onAllPageLoaded$1(NewChannelFragment newChannelFragment) {
        super(0);
        this.this$0 = newChannelFragment;
    }

    @Override // kotlin.jvm.functions.Function0
    @Nullable
    public final RefreshLayout invoke() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2092783708")) {
            return (RefreshLayout) ipChange.ipc$dispatch("2092783708", new Object[]{this});
        }
        RefreshLayout refreshLayout = this.this$0.getRefreshLayout();
        if (refreshLayout != null) {
            return refreshLayout.setEnableLoadMore(false);
        }
        return null;
    }
}
