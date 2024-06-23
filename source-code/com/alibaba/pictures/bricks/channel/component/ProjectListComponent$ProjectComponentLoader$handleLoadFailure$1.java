package com.alibaba.pictures.bricks.channel.component;

import com.alient.onearch.adapter.BaseFragment;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.page.GenericFragment;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;
import tb.ur2;

/* compiled from: Taobao */
public final class ProjectListComponent$ProjectComponentLoader$handleLoadFailure$1 extends Lambda implements Function0<ur2> {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ ProjectListComponent this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ProjectListComponent$ProjectComponentLoader$handleLoadFailure$1(ProjectListComponent projectListComponent) {
        super(0);
        this.this$0 = projectListComponent;
    }

    @Override // kotlin.jvm.functions.Function0
    @Nullable
    public final ur2 invoke() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-438022276")) {
            return (ur2) ipChange.ipc$dispatch("-438022276", new Object[]{this});
        }
        GenericFragment fragment = this.this$0.getPageContext().getFragment();
        BaseFragment baseFragment = fragment instanceof BaseFragment ? (BaseFragment) fragment : null;
        if (baseFragment == null) {
            return null;
        }
        baseFragment.hideLoadingDialog(this.this$0.getPageContext().getActivity());
        return ur2.INSTANCE;
    }
}
