package com.youku.live.widgets.protocol;

import com.youku.live.widgets.WidgetInstance;

/* compiled from: Taobao */
public interface IWidgetInstanceMananger {
    WidgetInstance createInstance();

    boolean releaseInstance(WidgetInstance widgetInstance);
}
