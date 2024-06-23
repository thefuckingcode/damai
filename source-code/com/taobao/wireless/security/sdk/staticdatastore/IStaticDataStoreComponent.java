package com.taobao.wireless.security.sdk.staticdatastore;

import com.alibaba.wireless.security.framework.InterfacePluginInfo;
import com.taobao.wireless.security.sdk.IComponent;
import tb.js2;

@InterfacePluginInfo(pluginName = js2.MAIN)
/* compiled from: Taobao */
public interface IStaticDataStoreComponent extends IComponent {
    String getAppKeyByIndex(int i);

    String getExtraData(String str);

    int getKeyType(String str);
}
