package com.alibaba.aliweex.adapter.component;

import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.ui.action.BasicComponentData;
import com.taobao.weex.ui.component.WXA;
import com.taobao.weex.ui.component.WXComponent;
import com.taobao.weex.ui.component.WXVContainer;
import com.taobao.weex.ui.view.WXFrameLayout;
import tb.jd2;

/* compiled from: Taobao */
public class WXExtA extends WXA {

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class a implements WXComponent.OnClickListener {
        a() {
        }

        @Override // com.taobao.weex.ui.component.WXComponent.OnClickListener
        public void onHostViewClick() {
            new jd2(WXExtA.this.getInstance().getRootComponent()).a(WXExtA.this);
        }
    }

    public WXExtA(WXSDKInstance wXSDKInstance, WXVContainer wXVContainer, BasicComponentData basicComponentData) {
        super(wXSDKInstance, wXVContainer, basicComponentData);
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.weex.ui.component.WXA
    public void onHostViewInitialized(WXFrameLayout wXFrameLayout) {
        addClickListener(new a());
        super.onHostViewInitialized(wXFrameLayout);
    }
}
