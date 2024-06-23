package com.taobao.wireless.security.sdk.securesignature;

import com.alibaba.wireless.security.framework.InterfacePluginInfo;
import com.taobao.wireless.security.sdk.IComponent;
import com.taobao.wireless.security.sdk.SecurityGuardParamContext;
import tb.js2;

@InterfacePluginInfo(pluginName = js2.MAIN)
/* compiled from: Taobao */
public interface ISecureSignatureComponent extends IComponent {
    String signRequest(SecurityGuardParamContext securityGuardParamContext);
}
