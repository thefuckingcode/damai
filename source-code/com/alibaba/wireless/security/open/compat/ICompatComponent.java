package com.alibaba.wireless.security.open.compat;

import com.alibaba.wireless.security.framework.InterfacePluginInfo;
import com.alibaba.wireless.security.open.IComponent;
import com.alibaba.wireless.security.open.SecException;
import tb.js2;

@InterfacePluginInfo(pluginName = js2.MAIN)
/* compiled from: Taobao */
public interface ICompatComponent extends IComponent {
    String getCachedSecurityToken(int i) throws SecException;
}
