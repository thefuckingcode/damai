package com.alibaba.wireless.security.open.datacollection;

import com.alibaba.wireless.security.framework.InterfacePluginInfo;
import com.alibaba.wireless.security.open.IComponent;
import tb.js2;

@InterfacePluginInfo(pluginName = js2.MAIN)
/* compiled from: Taobao */
public interface IDataCollectionComponent extends IComponent {
    String getNick();

    boolean setNick(String str);
}
