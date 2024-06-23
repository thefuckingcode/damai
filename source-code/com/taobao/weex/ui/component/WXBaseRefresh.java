package com.taobao.weex.ui.component;

import android.content.Context;
import androidx.annotation.NonNull;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.annotation.Component;
import com.taobao.weex.ui.action.BasicComponentData;
import com.taobao.weex.ui.view.WXFrameLayout;

@Component(lazyload = false)
/* compiled from: Taobao */
public class WXBaseRefresh extends WXVContainer<WXFrameLayout> {
    private WXLoadingIndicator mLoadingIndicator;

    public WXBaseRefresh(WXSDKInstance wXSDKInstance, WXVContainer wXVContainer, boolean z, BasicComponentData basicComponentData) {
        super(wXSDKInstance, wXVContainer, z, basicComponentData);
    }

    private void checkLoadingIndicator(WXComponent wXComponent) {
        if (wXComponent instanceof WXLoadingIndicator) {
            this.mLoadingIndicator = (WXLoadingIndicator) wXComponent;
        }
    }

    @Override // com.taobao.weex.ui.component.WXVContainer
    public void addChild(WXComponent wXComponent) {
        super.addChild(wXComponent);
        checkLoadingIndicator(wXComponent);
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.weex.ui.component.WXComponent
    public WXFrameLayout initComponentHostView(@NonNull Context context) {
        return new WXFrameLayout(context);
    }

    @Override // com.taobao.weex.ui.component.WXVContainer
    public void addChild(WXComponent wXComponent, int i) {
        super.addChild(wXComponent, i);
        checkLoadingIndicator(wXComponent);
    }
}
