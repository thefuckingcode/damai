package com.taobao.ma.common.result;

import java.util.Arrays;
import tb.jl1;

/* compiled from: Taobao */
public class MaWapperResult {
    public byte[] decodeBytes;
    public int height;
    public String hiddenData;
    public MaType maType;
    public String strCode;
    public int subType = 0;
    public int type;
    public int width;
    public int x;
    public int[] xCorner;
    public int y;
    public int[] yCorner;

    public String toString() {
        return "MaWapperResult [type=" + this.type + ", subType=" + this.subType + ", strCode=" + this.strCode + ", decodeBytes=" + Arrays.toString(this.decodeBytes) + ", hiddenData=" + this.hiddenData + jl1.ARRAY_END_STR;
    }
}
