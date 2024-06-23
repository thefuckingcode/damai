package com.taobao.wireless.security.sdk.datacollection;

import com.alibaba.wireless.security.framework.InterfacePluginInfo;
import com.taobao.wireless.security.sdk.IComponent;
import tb.js2;

@InterfacePluginInfo(pluginName = js2.MAIN)
/* compiled from: Taobao */
public interface IDataCollectionComponent extends IComponent {
    @Deprecated
    String getEncryptedDevAndEnvInfo(int i, String str);

    String getNick();

    String getNickEx(int i);

    boolean setNick(String str);

    boolean setNickEx(int i, String str);
}
