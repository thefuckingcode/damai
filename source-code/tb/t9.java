package tb;

import java.util.Hashtable;

/* compiled from: Taobao */
public final class t9 {
    public static final t9 CODABAR = new t9("CODABAR");
    public static final t9 CODE_128 = new t9("CODE_128");
    public static final t9 CODE_39 = new t9("CODE_39");
    public static final t9 CODE_93 = new t9("CODE_93");
    public static final t9 DATA_MATRIX = new t9("DATA_MATRIX");
    public static final t9 EAN_13 = new t9("EAN_13");
    public static final t9 EAN_8 = new t9("EAN_8");
    public static final t9 ITF = new t9("ITF");
    public static final t9 PDF417 = new t9("PDF417");
    public static final t9 QR_CODE = new t9("QR_CODE");
    public static final t9 RSS14 = new t9("RSS14");
    public static final t9 RSS_EXPANDED = new t9("RSS_EXPANDED");
    public static final t9 UPC_A = new t9("UPC_A");
    public static final t9 UPC_E = new t9("UPC_E");
    public static final t9 UPC_EAN_EXTENSION = new t9("UPC_EAN_EXTENSION");
    private static final Hashtable b = new Hashtable();
    private final String a;

    private t9(String str) {
        this.a = str;
        b.put(str, this);
    }

    public static t9 valueOf(String str) {
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException();
        }
        t9 t9Var = (t9) b.get(str);
        if (t9Var != null) {
            return t9Var;
        }
        throw new IllegalArgumentException();
    }

    public String toString() {
        return this.a;
    }
}
