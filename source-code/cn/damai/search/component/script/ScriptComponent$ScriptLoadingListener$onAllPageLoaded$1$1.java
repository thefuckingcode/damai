package cn.damai.search.component.script;

import cn.damai.onearch.errpage.ErrorControlView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.youku.arch.v3.page.GenericFragment;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class ScriptComponent$ScriptLoadingListener$onAllPageLoaded$1$1 extends Lambda implements Function0<RefreshLayout> {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ ScriptComponent this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ScriptComponent$ScriptLoadingListener$onAllPageLoaded$1$1(ScriptComponent scriptComponent) {
        super(0);
        this.this$0 = scriptComponent;
    }

    @Override // kotlin.jvm.functions.Function0
    @Nullable
    public final RefreshLayout invoke() {
        RefreshLayout refreshLayout;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1404950901")) {
            return (RefreshLayout) ipChange.ipc$dispatch("1404950901", new Object[]{this});
        }
        GenericFragment fragment = this.this$0.getContext().getFragment();
        ErrorControlView errorControlView = fragment instanceof ErrorControlView ? (ErrorControlView) fragment : null;
        if (errorControlView != null) {
            errorControlView.showDialogLoading(false);
        }
        GenericFragment fragment2 = this.this$0.getContext().getFragment();
        if (fragment2 == null || (refreshLayout = fragment2.getRefreshLayout()) == null) {
            return null;
        }
        return refreshLayout.setEnableLoadMore(false);
    }
}
