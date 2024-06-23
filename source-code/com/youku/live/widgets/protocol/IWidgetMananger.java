package com.youku.live.widgets.protocol;

/* compiled from: Taobao */
public interface IWidgetMananger extends IElementMananger {
    IWidget createWidget(String str);

    boolean releaseInstance(IWidget iWidget);
}
