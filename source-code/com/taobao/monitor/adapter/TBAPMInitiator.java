package com.taobao.monitor.adapter;

import android.app.Application;
import com.taobao.android.ab.api.ABGlobal;
import java.util.HashMap;
import tb.qh2;
import tb.rn1;
import tb.yn1;

/* compiled from: Taobao */
public class TBAPMInitiator extends AbsAPMInitiator {
    @Override // com.taobao.monitor.adapter.AbsAPMInitiator
    public /* bridge */ /* synthetic */ void init(Application application, HashMap hashMap) {
        super.init(application, hashMap);
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.monitor.adapter.AbsAPMInitiator
    public void initExpendLauncher(Application application) {
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.monitor.adapter.AbsAPMInitiator
    public void initPage(Application application) {
        yn1.a("com.taobao.tao.welcome.Welcome");
        yn1.a("com.taobao.bootimage.activity.BootImageActivity");
        yn1.a("com.taobao.linkmanager.afc.TbFlowInActivity");
        yn1.a("com.taobao.tao.detail.activity.DetailActivity");
        yn1.d("com.taobao.tao.homepage.MainActivity3");
        yn1.d("com.taobao.tao.TBMainActivity");
        yn1.d("com.taobao.search.sf.MainSearchResultActivity");
        yn1.d("com.taobao.browser.BrowserActivity");
        yn1.d("com.taobao.android.detail.wrapper.activity.DetailActivity");
        yn1.d("com.taobao.order.detail.ui.OrderDetailActivity");
        yn1.d("com.taobao.message.accounts.activity.AccountActivity");
        yn1.d("com.taobao.android.shop.activity.ShopHomePageActivity");
        yn1.d("com.taobao.weex.WXActivity");
        yn1.d("com.taobao.android.trade.cart.CartActivity");
        yn1.c("com.taobao.android.purchase.TBPurchaseActivity");
        yn1.c("com.taobao.order.detail.ui.OrderDetailActivity");
        yn1.b("com.taobao.android.searchbaseframe.business.srp.viewpager.fragment.SearchNativeFragment", true);
        yn1.b("com.taobao.search.sf.MainSearchResultActivity", true);
        yn1.b("com.taobao.order.list.OrderListActivity", true);
        yn1.b("com.taobao.message.category.MsgCenterCategoryFragment", true);
        yn1.b("com.taobao.android.trade.cart.TabCartFragment", true);
        yn1.b("com.taobao.android.trade.cart.CartActivity", true);
        yn1.b("com.taobao.mytaobao.homepage.MyTaobaoFragment", true);
        yn1.b("TNodeDefaultPageName", true);
        yn1.b("com.taobao.weex.WXActivity", true);
        yn1.b("com.alibaba.aliweex.bundle.WeexPageFragment", true);
        yn1.b("com.taobao.android.detail2.core.framework.NewDetailActivity", true);
        rn1.d("com.taobao.android.purchase.TBPurchaseActivity", 0.28f);
        rn1.d("com.taobao.order.detail.ui.OrderDetailActivity", 0.35f);
        if (ABGlobal.isFeatureOpened(application, "ApmLaunchVisibleCalculateChange") && qh2.j) {
            yn1.b("com.taobao.tao.TBMainActivity", true);
            yn1.b("com.taobao.tao.homepage.HomepageFragment", true);
            rn1.d("com.taobao.tao.TBMainActivity", 0.7f);
            rn1.d("com.taobao.tao.homepage.HomepageFragment", 0.7f);
        }
    }
}
