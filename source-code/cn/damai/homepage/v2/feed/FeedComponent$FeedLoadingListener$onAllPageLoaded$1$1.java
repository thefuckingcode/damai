package cn.damai.homepage.v2.feed;

import cn.damai.common.util.ToastUtil;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.youku.arch.v3.loader.PagingLoader;
import com.youku.arch.v3.page.GenericFragment;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class FeedComponent$FeedLoadingListener$onAllPageLoaded$1$1 extends Lambda implements Function0<RefreshLayout> {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ PagingLoader $this_apply;
    final /* synthetic */ FeedComponent this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FeedComponent$FeedLoadingListener$onAllPageLoaded$1$1(PagingLoader pagingLoader, FeedComponent feedComponent) {
        super(0);
        this.$this_apply = pagingLoader;
        this.this$0 = feedComponent;
    }

    @Override // kotlin.jvm.functions.Function0
    @Nullable
    public final RefreshLayout invoke() {
        RefreshLayout refreshLayout;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1946477073")) {
            return (RefreshLayout) ipChange.ipc$dispatch("1946477073", new Object[]{this});
        }
        if (this.$this_apply.getLoadingPage() >= 2) {
            ToastUtil.b("都被你看光啦，过会儿再来吧~", 0);
        }
        GenericFragment fragment = this.this$0.getPageContext().getFragment();
        if (fragment == null || (refreshLayout = fragment.getRefreshLayout()) == null) {
            return null;
        }
        return refreshLayout.setEnableLoadMore(false);
    }
}
