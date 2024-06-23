package cn.damai.commonbusiness.scriptmurder.shopdetail;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import tb.ur2;

/* compiled from: Taobao */
public final class ShopDetailFragment$ShopDetailLoader$handleLoadSuccess$1 extends Lambda implements Function0<ur2> {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ ShopDetailFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ShopDetailFragment$ShopDetailLoader$handleLoadSuccess$1(ShopDetailFragment shopDetailFragment) {
        super(0);
        this.this$0 = shopDetailFragment;
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1885745654")) {
            ipChange.ipc$dispatch("1885745654", new Object[]{this});
            return;
        }
        ShopDetailFragment shopDetailFragment = this.this$0;
        shopDetailFragment.hideLoadingDialog(shopDetailFragment.getActivity());
    }
}
