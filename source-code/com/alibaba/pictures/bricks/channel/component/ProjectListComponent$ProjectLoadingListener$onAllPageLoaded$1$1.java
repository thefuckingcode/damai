package com.alibaba.pictures.bricks.channel.component;

import com.alibaba.pictures.bricks.util.toast.BricksToastUtil;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.youku.arch.v3.loader.PagingLoader;
import com.youku.arch.v3.page.GenericFragment;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class ProjectListComponent$ProjectLoadingListener$onAllPageLoaded$1$1 extends Lambda implements Function0<RefreshLayout> {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ PagingLoader $this_apply;
    final /* synthetic */ ProjectListComponent this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ProjectListComponent$ProjectLoadingListener$onAllPageLoaded$1$1(PagingLoader pagingLoader, ProjectListComponent projectListComponent) {
        super(0);
        this.$this_apply = pagingLoader;
        this.this$0 = projectListComponent;
    }

    @Override // kotlin.jvm.functions.Function0
    @Nullable
    public final RefreshLayout invoke() {
        RefreshLayout refreshLayout;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1254702471")) {
            return (RefreshLayout) ipChange.ipc$dispatch("1254702471", new Object[]{this});
        }
        if (this.$this_apply.getLoadingPage() >= 2) {
            BricksToastUtil.INSTANCE.b("都被你看光啦，过会儿再来吧~");
        }
        GenericFragment fragment = this.this$0.getPageContext().getFragment();
        if (fragment == null || (refreshLayout = fragment.getRefreshLayout()) == null) {
            return null;
        }
        return refreshLayout.setEnableLoadMore(false);
    }
}
