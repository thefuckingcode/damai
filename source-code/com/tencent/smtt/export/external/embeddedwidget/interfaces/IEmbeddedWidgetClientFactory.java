package com.tencent.smtt.export.external.embeddedwidget.interfaces;

import java.util.Map;

public interface IEmbeddedWidgetClientFactory {
    IEmbeddedWidgetClient createWidgetClient(String str, Map<String, String> map, IEmbeddedWidget iEmbeddedWidget);
}
