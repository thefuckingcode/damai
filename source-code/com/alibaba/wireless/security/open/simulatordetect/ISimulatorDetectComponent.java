package com.alibaba.wireless.security.open.simulatordetect;

import com.alibaba.wireless.security.framework.InterfacePluginInfo;
import com.alibaba.wireless.security.open.IComponent;

@InterfacePluginInfo(pluginName = "securitybody")
/* compiled from: Taobao */
public interface ISimulatorDetectComponent extends IComponent {
    boolean isSimulator();
}
