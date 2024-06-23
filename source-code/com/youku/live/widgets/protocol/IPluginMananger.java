package com.youku.live.widgets.protocol;

/* compiled from: Taobao */
public interface IPluginMananger extends IElementMananger {
    IPlugin createPlugin(String str);

    boolean releaseInstance(IPlugin iPlugin);
}
