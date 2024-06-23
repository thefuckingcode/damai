package com.youku.live.dago.widgetlib.protocol;

import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.bridge.JSCallback;

/* compiled from: Taobao */
public interface YKLNetProtocol {
    void enableNetEvent(boolean z, WXSDKInstance wXSDKInstance);

    void netStatus(JSCallback jSCallback);

    void onDestroy();
}
