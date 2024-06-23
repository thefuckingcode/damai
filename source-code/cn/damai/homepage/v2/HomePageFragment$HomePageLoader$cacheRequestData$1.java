package cn.damai.homepage.v2;

import cn.damai.homepage.v2.HomePageFragment;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.data.local.LocalDataSource;
import com.youku.arch.v3.io.IResponse;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import tb.ur2;

/* compiled from: Taobao */
public final class HomePageFragment$HomePageLoader$cacheRequestData$1 extends Lambda implements Function0<ur2> {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ IResponse $response;
    final /* synthetic */ HomePageFragment.HomePageLoader this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HomePageFragment$HomePageLoader$cacheRequestData$1(HomePageFragment.HomePageLoader homePageLoader, IResponse iResponse) {
        super(0);
        this.this$0 = homePageLoader;
        this.$response = iResponse;
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        JSONObject jSONObject;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-307781933")) {
            ipChange.ipc$dispatch("-307781933", new Object[]{this});
            return;
        }
        HomePageFragment.HomePageLoader homePageLoader = this.this$0;
        JSONObject jsonObject = this.$response.getJsonObject();
        String str = null;
        ur2 unused = homePageLoader.filterNeedCacheData((jsonObject == null || (jSONObject = jsonObject.getJSONObject("data")) == null) ? null : jSONObject.getJSONArray("nodes"));
        IResponse iResponse = this.$response;
        JSONObject jsonObject2 = iResponse.getJsonObject();
        if (jsonObject2 != null) {
            str = jsonObject2.toJSONString();
        }
        iResponse.setRawData(str);
        LocalDataSource.put$default(LocalDataSource.Companion.getInstance(), this.$response, 0, 2, null);
    }
}
