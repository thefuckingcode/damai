package com.taobao.wireless.security.sdk.securityDNS;

import com.alibaba.wireless.security.framework.InterfacePluginInfo;
import com.taobao.wireless.security.sdk.IComponent;
import tb.js2;

@InterfacePluginInfo(pluginName = js2.MAIN)
/* compiled from: Taobao */
public interface ISecurityDNSComponent extends IComponent {
    void checkSecurityDNS(String[] strArr);

    boolean initSecurityDNS();
}
