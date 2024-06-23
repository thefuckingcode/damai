package cn.damai.homepage.v2;

import androidx.recyclerview.widget.RecyclerView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.NotNull;
import tb.k21;

/* compiled from: Taobao */
public final class HomePageFragment$onViewCreated$2 extends RecyclerView.OnScrollListener {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ HomePageFragment a;

    HomePageFragment$onViewCreated$2(HomePageFragment homePageFragment) {
        this.a = homePageFragment;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1702048019")) {
            ipChange.ipc$dispatch("1702048019", new Object[]{this, recyclerView, Integer.valueOf(i)});
            return;
        }
        k21.i(recyclerView, "recyclerView");
        if (i == 0) {
            this.a.dispatchTabIconUpdate();
        }
    }
}
