package com.youku.style;

import java.util.Map;

/* compiled from: Taobao */
public interface IStyleManager<STYLE extends Map> {
    STYLE getCurrentStyle();

    void registerStyleSupports(IStyle<STYLE> iStyle);

    void resetStyleManager();

    void setStyle(STYLE style);

    void unregisterStyleSupports(IStyle<STYLE> iStyle);
}
