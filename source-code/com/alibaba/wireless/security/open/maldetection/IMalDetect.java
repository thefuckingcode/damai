package com.alibaba.wireless.security.open.maldetection;

import com.alibaba.wireless.security.framework.InterfacePluginInfo;
import com.alibaba.wireless.security.open.IComponent;

@InterfacePluginInfo(pluginName = "securitybody")
/* compiled from: Taobao */
public interface IMalDetect extends IComponent {

    /* compiled from: Taobao */
    public interface ICallBack {
        void onDetection(int i, String str, String str2);
    }

    void registerCallBack(ICallBack iCallBack);

    void unregisterCallBack(ICallBack iCallBack);
}
