package com.youku.style.vo;

import android.text.TextUtils;
import com.youku.style.StyleVisitor;
import java.io.Serializable;
import java.util.Map;

/* compiled from: Taobao */
public abstract class StyleValue<STYLE extends Map> implements Serializable {
    public static final int DEFAULT_PRIORITY = 0;
    public int priority = 0;
    protected STYLE style;
    protected StyleVisitor<STYLE> visitor;

    public StyleValue(STYLE style2) {
        StyleVisitor<STYLE> styleVisitor = new StyleVisitor<>(style2);
        this.visitor = styleVisitor;
        this.style = compact(styleVisitor);
        if (this.visitor.hasStyleTypedValue("priority", Integer.class)) {
            this.priority = this.visitor.getStyleIntValue("priority");
        }
    }

    /* access modifiers changed from: protected */
    public STYLE compact(StyleVisitor<STYLE> styleVisitor) {
        return styleVisitor.getStyle();
    }

    public boolean equals(Object obj) {
        if (getClass() != obj.getClass()) {
            return false;
        }
        STYLE style2 = ((StyleValue) obj).style;
        STYLE style3 = this.style;
        if (style3 == null && style2 == null) {
            return true;
        }
        if (style3 == null || style2 == null || style2.size() != this.style.size()) {
            return false;
        }
        for (Object obj2 : style2.keySet()) {
            if (!this.style.containsKey(obj2)) {
                return false;
            }
            Object obj3 = style2.get(obj2);
            Object obj4 = this.style.get(obj2);
            if (obj3 != obj4) {
                if (obj3 == null || obj4 == null || obj3.getClass() != obj4.getClass()) {
                    return false;
                }
                if ((!(obj3 instanceof String) || TextUtils.equals((String) obj3, (String) obj4)) && !(obj3 instanceof Integer)) {
                }
                return false;
            }
        }
        return true;
    }

    public STYLE getStyle() {
        return this.style;
    }
}
