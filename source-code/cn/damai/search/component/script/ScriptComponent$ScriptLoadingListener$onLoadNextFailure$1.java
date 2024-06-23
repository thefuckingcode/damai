package cn.damai.search.component.script;

import android.app.Activity;
import cn.damai.common.util.toastutil.a;
import cn.damai.onearch.errpage.ErrorControlView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.youku.arch.v3.page.GenericFragment;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class ScriptComponent$ScriptLoadingListener$onLoadNextFailure$1 extends Lambda implements Function0<Activity> {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ String $message;
    final /* synthetic */ ScriptComponent this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ScriptComponent$ScriptLoadingListener$onLoadNextFailure$1(ScriptComponent scriptComponent, String str) {
        super(0);
        this.this$0 = scriptComponent;
        this.$message = str;
    }

    @Override // kotlin.jvm.functions.Function0
    @Nullable
    public final Activity invoke() {
        RefreshLayout refreshLayout;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1507420701")) {
            return (Activity) ipChange.ipc$dispatch("-1507420701", new Object[]{this});
        }
        Activity activity = this.this$0.getContext().getActivity();
        ErrorControlView errorControlView = null;
        if (activity == null) {
            return null;
        }
        ScriptComponent scriptComponent = this.this$0;
        String str = this.$message;
        GenericFragment fragment = scriptComponent.getContext().getFragment();
        if (fragment instanceof ErrorControlView) {
            errorControlView = (ErrorControlView) fragment;
        }
        if (errorControlView != null) {
            errorControlView.showDialogLoading(false);
        }
        GenericFragment fragment2 = scriptComponent.getContext().getFragment();
        if (!(fragment2 == null || (refreshLayout = fragment2.getRefreshLayout()) == null)) {
            refreshLayout.setEnableLoadMore(false);
        }
        a.i(activity, str);
        return activity;
    }
}
