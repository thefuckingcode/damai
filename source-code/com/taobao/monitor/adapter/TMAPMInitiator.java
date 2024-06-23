package com.taobao.monitor.adapter;

import android.app.Application;
import java.util.HashMap;
import tb.yn1;

/* compiled from: Taobao */
public class TMAPMInitiator extends AbsAPMInitiator {
    @Override // com.taobao.monitor.adapter.AbsAPMInitiator
    public /* bridge */ /* synthetic */ void init(Application application, HashMap hashMap) {
        super.init(application, hashMap);
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.monitor.adapter.AbsAPMInitiator
    public void initPage(Application application) {
        yn1.a("com.tmall.wireless.splash.TMSplashActivity");
        yn1.a("com.taobao.bootimage.activity.BootImageActivity");
        yn1.a("com.taobao.linkmanager.AlibcEntranceActivity");
        yn1.a("com.taobao.linkmanager.AlibcOpenActivity");
        yn1.a("com.taobao.linkmanager.AlibcTransparentActivity");
        yn1.a("com.taobao.linkmanager.AlibcWindvaneCompatActivity");
        yn1.a("com.taobao.linkmanager.AlibcAuthActivity");
        yn1.d("com.tmall.wireless.homepage.activity.TMHomePageActivity");
        yn1.d("com.tmall.wireless.detail.ui.TMItemDetailsActivity");
        yn1.d("com.tmall.wireless.maintab.module.TMMainTabActivity");
        yn1.d("com.tmall.wireless.mytmall.ui.TMMtmallActivityA");
        yn1.d("com.tmall.wireless.messagebox.activity.TMMsgboxCategoryActivity");
        yn1.d("com.tmall.wireless.shop.TMShopActivity");
        yn1.d("com.tmall.wireless.minidetail.activity.TMMiniDetailActivity");
        yn1.d("com.taobao.message.accounts.activity.AccountActivity");
        yn1.d("com.taobao.android.shop.activity.ShopHomePageActivity");
        yn1.d("com.taobao.weex.WXActivity");
        yn1.d("com.taobao.android.trade.cart.CartActivity");
        yn1.d("com.tmall.wireless.login.TMLoginActivity");
    }
}
