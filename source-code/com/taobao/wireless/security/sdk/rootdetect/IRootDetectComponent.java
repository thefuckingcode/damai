package com.taobao.wireless.security.sdk.rootdetect;

import com.alibaba.wireless.security.framework.InterfacePluginInfo;
import com.taobao.wireless.security.sdk.IComponent;

@InterfacePluginInfo(pluginName = "securitybody")
/* compiled from: Taobao */
public interface IRootDetectComponent extends IComponent {
    boolean isRoot();
}
