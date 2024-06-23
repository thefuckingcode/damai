package com.ta.audid.utils;

/* compiled from: Taobao */
public class ByteUtils {
    public static long getLongByByte4(byte[] bArr) {
        return ((((long) bArr[0]) & 255) << 24) | ((((long) bArr[1]) & 255) << 16) | ((((long) bArr[2]) & 255) << 8) | (255 & ((long) bArr[3]));
    }
}
