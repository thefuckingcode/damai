package com.taobao.wireless.security.sdk.dynamicdataencrypt;

import com.alibaba.wireless.security.framework.InterfacePluginInfo;
import com.taobao.wireless.security.sdk.IComponent;
import tb.js2;

@InterfacePluginInfo(pluginName = js2.MAIN)
/* compiled from: Taobao */
public interface IDynamicDataEncryptComponent extends IComponent {
    @Deprecated
    String dynamicDecrypt(String str);

    String dynamicDecryptDDp(String str);

    @Deprecated
    String dynamicEncrypt(String str);

    String dynamicEncryptDDp(String str);
}
