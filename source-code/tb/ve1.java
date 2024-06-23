package tb;

/* compiled from: Taobao */
public final class ve1 {
    public static final ve1 ALPHANUMERIC = new ve1(new int[]{9, 11, 13}, 2, "ALPHANUMERIC");
    public static final ve1 BYTE = new ve1(new int[]{8, 16, 16}, 4, "BYTE");
    public static final ve1 ECI = new ve1(null, 7, "ECI");
    public static final ve1 FNC1_FIRST_POSITION = new ve1(null, 5, "FNC1_FIRST_POSITION");
    public static final ve1 FNC1_SECOND_POSITION = new ve1(null, 9, "FNC1_SECOND_POSITION");
    public static final ve1 KANJI = new ve1(new int[]{8, 10, 12}, 8, "KANJI");
    public static final ve1 NUMERIC = new ve1(new int[]{10, 12, 14}, 1, "NUMERIC");
    public static final ve1 STRUCTURED_APPEND = new ve1(new int[]{0, 0, 0}, 3, "STRUCTURED_APPEND");
    public static final ve1 TERMINATOR = new ve1(new int[]{0, 0, 0}, 0, "TERMINATOR");
    private final int[] a;
    private final int b;
    private final String c;

    private ve1(int[] iArr, int i, String str) {
        this.a = iArr;
        this.b = i;
        this.c = str;
    }

    public int a() {
        return this.b;
    }

    public int b(bv2 bv2) {
        if (this.a != null) {
            int f = bv2.f();
            return this.a[f <= 9 ? 0 : f <= 26 ? (char) 1 : 2];
        }
        throw new IllegalArgumentException("Character count doesn't apply to this mode");
    }

    public String toString() {
        return this.c;
    }
}
