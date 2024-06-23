package com.alibaba.pictures.bricks.channel.component;

import android.app.Activity;
import com.alient.onearch.adapter.BaseFragment;
import com.alient.onearch.adapter.state.StateViewManager;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.page.GenericFragment;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;
import tb.k21;

/* compiled from: Taobao */
public final class ProjectListComponent$ProjectComponentLoader$load$1 extends Lambda implements Function0<Activity> {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ Map<String, Object> $config;
    final /* synthetic */ ProjectListComponent this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ProjectListComponent$ProjectComponentLoader$load$1(ProjectListComponent projectListComponent, Map<String, ? extends Object> map) {
        super(0);
        this.this$0 = projectListComponent;
        this.$config = map;
    }

    @Override // kotlin.jvm.functions.Function0
    @Nullable
    public final Activity invoke() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1597276409")) {
            return (Activity) ipChange.ipc$dispatch("-1597276409", new Object[]{this});
        }
        Activity activity = this.this$0.getPageContext().getActivity();
        if (activity == null) {
            return null;
        }
        Map<String, Object> map = this.$config;
        ProjectListComponent projectListComponent = this.this$0;
        if (!k21.d(map.get("index"), 1)) {
            return activity;
        }
        GenericFragment fragment = projectListComponent.getPageContext().getFragment();
        BaseFragment baseFragment = fragment instanceof BaseFragment ? (BaseFragment) fragment : null;
        if (baseFragment == null) {
            return activity;
        }
        StateViewManager.IStateFeature.DefaultImpls.showLoadingDialog$default(baseFragment, activity, null, false, 6, null);
        return activity;
    }
}
