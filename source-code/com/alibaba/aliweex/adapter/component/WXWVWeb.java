package com.alibaba.aliweex.adapter.component;

import android.content.Intent;
import android.text.TextUtils;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.ui.action.BasicComponentData;
import com.taobao.weex.ui.component.WXVContainer;
import com.taobao.weex.ui.component.WXWeb;

/* compiled from: Taobao */
public class WXWVWeb extends WXWeb {
    WXSDKInstance.c handler = null;

    /* compiled from: Taobao */
    class a extends WXSDKInstance.c {
        final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(String str, String str2) {
            super(str);
            this.b = str2;
        }

        @Override // com.taobao.weex.WXSDKInstance.c
        public boolean b(int i, int i2, Intent intent, String str) {
            if (!TextUtils.equals(str, this.b) || !(((WXWeb) WXWVWeb.this).mWebView instanceof WXWVWebView)) {
                return super.a(i, i2, intent);
            }
            ((WXWVWebView) ((WXWeb) WXWVWeb.this).mWebView).k(i, i2, intent);
            return true;
        }
    }

    public WXWVWeb(WXSDKInstance wXSDKInstance, WXVContainer wXVContainer, boolean z, BasicComponentData basicComponentData) {
        super(wXSDKInstance, wXVContainer, z, basicComponentData);
        String valueOf = String.valueOf(hashCode());
        a aVar = new a(valueOf, valueOf);
        this.handler = aVar;
        wXSDKInstance.registerOnActivityResultHandler(aVar);
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.weex.ui.component.WXComponent
    public void createViewImpl() {
        super.createViewImpl();
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.weex.ui.component.WXWeb
    public void createWebView() {
        this.mWebView = new WXWVWebView(getInstance(), this);
    }

    @Override // com.taobao.weex.ui.component.WXWeb, com.taobao.weex.ui.component.WXComponent
    public void destroy() {
        if (!(this.handler == null || getInstance() == null)) {
            getInstance().unRegisterOnActivityResultHandler(this.handler);
        }
        super.destroy();
    }
}
