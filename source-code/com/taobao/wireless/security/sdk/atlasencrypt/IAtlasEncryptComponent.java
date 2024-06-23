package com.taobao.wireless.security.sdk.atlasencrypt;

import com.alibaba.wireless.security.framework.InterfacePluginInfo;
import com.taobao.wireless.security.sdk.IComponent;
import tb.js2;

@InterfacePluginInfo(pluginName = js2.MAIN)
/* compiled from: Taobao */
public interface IAtlasEncryptComponent extends IComponent {
    String atlasSafeEncrypt(String str);
}
