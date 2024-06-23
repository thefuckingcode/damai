package com.taobao.weex.ui.component;

import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.annotation.Component;
import com.taobao.weex.ui.action.BasicComponentData;
import com.taobao.weex.ui.view.WXEditText;

@Component(lazyload = false)
/* compiled from: Taobao */
public class WXInput extends AbstractEditComponent {
    @Deprecated
    public WXInput(WXSDKInstance wXSDKInstance, WXVContainer wXVContainer, String str, boolean z, BasicComponentData basicComponentData) {
        this(wXSDKInstance, wXVContainer, z, basicComponentData);
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.weex.ui.component.AbstractEditComponent
    public void appleStyleAfterCreated(WXEditText wXEditText) {
        super.appleStyleAfterCreated(wXEditText);
        wXEditText.setSingleLine();
    }

    public WXInput(WXSDKInstance wXSDKInstance, WXVContainer wXVContainer, boolean z, BasicComponentData basicComponentData) {
        super(wXSDKInstance, wXVContainer, z, basicComponentData);
    }
}
