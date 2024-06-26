package com.taobao.weex.dom;

import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.ui.component.WXComponent;

/* compiled from: Taobao */
public interface RenderContext {
    WXComponent getComponent(String str);

    WXSDKInstance getInstance();

    WXComponent unregisterComponent(String str);
}
