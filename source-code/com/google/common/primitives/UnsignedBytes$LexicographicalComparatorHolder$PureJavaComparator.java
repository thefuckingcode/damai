package com.google.common.primitives;

import java.util.Comparator;
import tb.as2;

/* compiled from: Taobao */
enum UnsignedBytes$LexicographicalComparatorHolder$PureJavaComparator implements Comparator<byte[]> {
    INSTANCE;

    public String toString() {
        return "UnsignedBytes.lexicographicalComparator() (pure Java version)";
    }

    public int compare(byte[] bArr, byte[] bArr2) {
        int min = Math.min(bArr.length, bArr2.length);
        for (int i = 0; i < min; i++) {
            int b = as2.b(bArr[i], bArr2[i]);
            if (b != 0) {
                return b;
            }
        }
        return bArr.length - bArr2.length;
    }
}
