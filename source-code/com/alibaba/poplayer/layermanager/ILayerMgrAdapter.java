package com.alibaba.poplayer.layermanager;

/* compiled from: Taobao */
public interface ILayerMgrAdapter {
    void addConfigObserver(e eVar);

    String getConfigByKey(String str);

    void initializeConfigContainer(e eVar);
}
