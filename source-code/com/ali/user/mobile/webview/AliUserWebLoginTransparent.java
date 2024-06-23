package com.ali.user.mobile.webview;

import com.ali.user.mobile.ui.R;

/* compiled from: Taobao */
public class AliUserWebLoginTransparent extends WebViewActivity {
    /* access modifiers changed from: protected */
    @Override // com.ali.user.mobile.webview.WebViewActivity, com.ali.user.mobile.base.ui.BaseActivity
    public int getLayoutContent() {
        return R.layout.aliuser_login_web_trans;
    }

    /* access modifiers changed from: protected */
    @Override // com.ali.user.mobile.webview.WebViewActivity, com.ali.user.mobile.base.ui.BaseActivity
    public void initViews() {
        super.initViews();
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
    }
}
