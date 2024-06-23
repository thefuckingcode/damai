package com.google.common.primitives;

import com.google.common.annotations.GwtCompatible;
import java.util.Comparator;
import tb.ds1;

@GwtCompatible
/* compiled from: Taobao */
public final class SignedBytes {
    public static final byte MAX_POWER_OF_TWO = 64;

    /* compiled from: Taobao */
    private enum LexicographicalComparator implements Comparator<byte[]> {
        INSTANCE;

        public String toString() {
            return "SignedBytes.lexicographicalComparator()";
        }

        public int compare(byte[] bArr, byte[] bArr2) {
            int min = Math.min(bArr.length, bArr2.length);
            for (int i = 0; i < min; i++) {
                int b = SignedBytes.b(bArr[i], bArr2[i]);
                if (b != 0) {
                    return b;
                }
            }
            return bArr.length - bArr2.length;
        }
    }

    public static byte a(long j) {
        byte b = (byte) ((int) j);
        ds1.h(((long) b) == j, "Out of range: %s", j);
        return b;
    }

    public static int b(byte b, byte b2) {
        return b - b2;
    }
}
