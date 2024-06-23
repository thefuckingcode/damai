package org.conscrypt;

final class ArrayUtils {
    private ArrayUtils() {
    }

    static void checkOffsetAndCount(int i, int i2, int i3) {
        if ((i2 | i3) < 0 || i2 > i || i - i2 < i3) {
            throw new ArrayIndexOutOfBoundsException("length=" + i + "; regionStart=" + i2 + "; regionLength=" + i3);
        }
    }
}
