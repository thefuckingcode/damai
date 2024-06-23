package com.taobao.wireless.security.sdk.simulatordetect;

import com.alibaba.wireless.security.framework.InterfacePluginInfo;
import com.taobao.wireless.security.sdk.IComponent;

@InterfacePluginInfo(pluginName = "securitybody")
/* compiled from: Taobao */
public interface ISimulatorDetectComponent extends IComponent {
    boolean isSimulator();
}
