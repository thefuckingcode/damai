package com.taobao.weex.bridge;

/* compiled from: Taobao */
public interface WXReactorPlugin {
    WXReactorPage createPage(long j, String str);

    String getPluginName();

    String getSoLibName();

    boolean isSkipFrameworkInit();
}
