package com.youku.style.vo;

import com.youku.style.StyleVisitor;
import java.util.Map;

/* compiled from: Taobao */
public class SkinStyle extends StyleValue {
    private static final String HOME_SEARCHFRAME_COLOR_OLD = "homeSeachFrameColor";

    public SkinStyle(Map map) {
        super(map);
    }

    /* access modifiers changed from: protected */
    @Override // com.youku.style.vo.StyleValue
    public Map compact(StyleVisitor styleVisitor) {
        Map style = styleVisitor.getStyle();
        if (style != null && styleVisitor.hasStyleStringValue("homeSeachFrameColor")) {
            style.put("homeSeachFrameColor", styleVisitor.getStyleStringValue("homeSeachFrameColor"));
            style.remove("homeSeachFrameColor");
        }
        return style;
    }
}
