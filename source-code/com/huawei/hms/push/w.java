package com.huawei.hms.push;

import com.youku.upsplayer.util.YKUpsConvert;
import tb.u91;

/* compiled from: Taobao */
public abstract class w {
    public static final char[] a = {YKUpsConvert.CHAR_ZERO, '1', '2', '3', '4', '5', '6', '7', '8', YKUpsConvert.CHAR_NINE, YKUpsConvert.CHAR_A, 'B', 'C', u91.LEVEL_D, u91.LEVEL_E, YKUpsConvert.CHAR_F};

    public static String a(byte[] bArr) {
        return bArr == null ? "" : new String(bArr, x.a);
    }
}
