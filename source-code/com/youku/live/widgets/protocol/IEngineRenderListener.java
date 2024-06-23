package com.youku.live.widgets.protocol;

import android.view.View;
import com.youku.live.widgets.WidgetInstance;

/* compiled from: Taobao */
public interface IEngineRenderListener {
    void onException(WidgetInstance widgetInstance, String str, String str2);

    void onHostViewCreated(WidgetInstance widgetInstance, View view);

    void onRefreshSuccess(WidgetInstance widgetInstance);

    void onRenderSuccess(WidgetInstance widgetInstance);
}
