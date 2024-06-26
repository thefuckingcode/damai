package com.taobao.ma.common.result;

import tb.jl1;

/* compiled from: Taobao */
public class MaResult {
    private final String text;
    private final MaType type;

    public MaResult(MaType maType, String str) {
        this.type = maType;
        this.text = str;
    }

    public String getText() {
        return this.text;
    }

    public MaType getType() {
        return this.type;
    }

    public String toString() {
        return "MaResult [type=" + this.type + ", text=" + this.text + jl1.ARRAY_END_STR;
    }
}
