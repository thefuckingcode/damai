package cn.damai.homepage.v2;

import cn.damai.homepage.bean.KeyWord;
import cn.damai.homepage.ui.view.HomePageGuideBar;
import com.alient.onearch.adapter.PageInfoBean;
import com.alient.oneservice.nav.Action;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;
import tb.ur2;

/* compiled from: Taobao */
public final class HomePageFragment$HomePageLoader$handlePageBaseInfo$2 extends Lambda implements Function0<ur2> {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ ArrayList<String> $list;
    final /* synthetic */ ArrayList<KeyWord> $orgList;
    final /* synthetic */ HomePageFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HomePageFragment$HomePageLoader$handlePageBaseInfo$2(HomePageFragment homePageFragment, ArrayList<String> arrayList, ArrayList<KeyWord> arrayList2) {
        super(0);
        this.this$0 = homePageFragment;
        this.$list = arrayList;
        this.$orgList = arrayList2;
    }

    @Override // kotlin.jvm.functions.Function0
    @Nullable
    public final ur2 invoke() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "844327346")) {
            return (ur2) ipChange.ipc$dispatch("844327346", new Object[]{this});
        }
        HomePageGuideBar homePageGuideBar = this.this$0.guideBar;
        if (homePageGuideBar != null) {
            homePageGuideBar.setSearchText(this.$list, this.$orgList);
        }
        HomePageGuideBar homePageGuideBar2 = this.this$0.guideBar;
        Map<String, Action> map = null;
        if (homePageGuideBar2 == null) {
            return null;
        }
        PageInfoBean topBasePageInfo = this.this$0.getTopBasePageInfo();
        if (topBasePageInfo != null) {
            map = topBasePageInfo.action;
        }
        homePageGuideBar2.setTrackInfo(map, this.this$0.getUtPageName());
        return ur2.INSTANCE;
    }
}
