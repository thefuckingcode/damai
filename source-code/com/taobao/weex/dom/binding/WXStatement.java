package com.taobao.weex.dom.binding;

import androidx.collection.ArrayMap;
import androidx.collection.SimpleArrayMap;

/* compiled from: Taobao */
public class WXStatement extends ArrayMap<String, Object> implements Cloneable {
    public static final String WX_FOR = "[[repeat]]";
    public static final String WX_FOR_INDEX = "@index";
    public static final String WX_FOR_ITEM = "@alias";
    public static final String WX_FOR_LIST = "@expression";
    public static final String WX_IF = "[[match]]";
    public static final String WX_ONCE = "[[once]]";

    public WXStatement() {
    }

    public WXStatement(SimpleArrayMap simpleArrayMap) {
        super(simpleArrayMap);
    }

    /* access modifiers changed from: protected */
    @Override // java.lang.Object
    public WXStatement clone() {
        return new WXStatement(this);
    }
}
