package tb;

import com.real.android.nativehtml.common.css.CssEnum;

/* compiled from: Taobao */
public class cg2 {
    private static final String[] a = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    private static final int[] b = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

    /* compiled from: Taobao */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|(3:13|14|16)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|16) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            int[] iArr = new int[CssEnum.values().length];
            a = iArr;
            iArr[CssEnum.DECIMAL.ordinal()] = 1;
            a[CssEnum.LOWER_LATIN.ordinal()] = 2;
            a[CssEnum.LOWER_GREEK.ordinal()] = 3;
            a[CssEnum.LOWER_ROMAN.ordinal()] = 4;
            a[CssEnum.UPPER_LATIN.ordinal()] = 5;
            a[CssEnum.UPPER_ROMAN.ordinal()] = 6;
            try {
                a[CssEnum.SQUARE.ordinal()] = 7;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public static String a(CssEnum cssEnum, int i) {
        switch (a.a[cssEnum.ordinal()]) {
            case 1:
                return String.valueOf(i) + ". ";
            case 2:
                return b(i, 'a', 26) + ". ";
            case 3:
                return b(i, 945, 25) + ". ";
            case 4:
                return c(i) + ". ";
            case 5:
                return b(i, 'a', 26) + ". ";
            case 6:
                return c(i).toUpperCase() + ". ";
            case 7:
                return "▪ ";
            default:
                return "• ";
        }
    }

    static final String b(int i, char c, int i2) {
        StringBuilder sb = new StringBuilder();
        do {
            int i3 = i - 1;
            sb.insert(0, (char) ((i3 % i2) + c));
            i = i3 / i2;
        } while (i != 0);
        return sb.toString();
    }

    static final String c(int i) {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < b.length; i2++) {
            while (true) {
                int[] iArr = b;
                if (i % iArr[i2] >= i) {
                    break;
                }
                sb.append(a[i2]);
                i -= iArr[i2];
            }
        }
        return sb.toString();
    }
}
