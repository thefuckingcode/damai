package org.conscrypt;

/* access modifiers changed from: package-private */
public final class Preconditions {
    private Preconditions() {
    }

    static <T> T checkNotNull(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    static void checkArgument(boolean z, String str) {
        if (!z) {
            throw new IllegalArgumentException(str);
        }
    }

    static void checkArgument(boolean z, String str, Object obj) {
        if (!z) {
            throw new IllegalArgumentException(String.format(str, obj));
        }
    }

    static void checkPositionIndexes(int i, int i2, int i3) {
        if (i < 0 || i2 < i || i2 > i3) {
            throw new IndexOutOfBoundsException(badPositionIndexes(i, i2, i3));
        }
    }

    private static String badPositionIndexes(int i, int i2, int i3) {
        if (i < 0 || i > i3) {
            return badPositionIndex(i, i3, "start index");
        }
        if (i2 < 0 || i2 > i3) {
            return badPositionIndex(i2, i3, "end index");
        }
        return String.format("end index (%s) must not be less than start index (%s)", Integer.valueOf(i2), Integer.valueOf(i));
    }

    private static String badPositionIndex(int i, int i2, String str) {
        if (i < 0) {
            return String.format("%s (%s) must not be negative", str, Integer.valueOf(i));
        } else if (i2 >= 0) {
            return String.format("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i), Integer.valueOf(i2));
        } else {
            throw new IllegalArgumentException("negative size: " + i2);
        }
    }
}
