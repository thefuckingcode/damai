package org.apache.commons.lang3.math;

import com.youku.live.livesdk.wkit.component.Constants;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.BigInteger;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.SystemUtils;
import org.apache.commons.lang3.Validate;

/* compiled from: Taobao */
public class NumberUtils {
    public static final Byte BYTE_MINUS_ONE = (byte) -1;
    public static final Byte BYTE_ONE = (byte) 1;
    public static final Byte BYTE_ZERO = (byte) 0;
    public static final Double DOUBLE_MINUS_ONE = Double.valueOf(-1.0d);
    public static final Double DOUBLE_ONE = Double.valueOf(1.0d);
    public static final Double DOUBLE_ZERO = Double.valueOf(0.0d);
    public static final Float FLOAT_MINUS_ONE = Float.valueOf(-1.0f);
    public static final Float FLOAT_ONE = Float.valueOf(1.0f);
    public static final Float FLOAT_ZERO = Float.valueOf(0.0f);
    public static final Integer INTEGER_MINUS_ONE = -1;
    public static final Integer INTEGER_ONE = 1;
    public static final Integer INTEGER_ZERO = 0;
    public static final Long LONG_MINUS_ONE = -1L;
    public static final Long LONG_ONE = 1L;
    public static final Long LONG_ZERO = 0L;
    public static final Short SHORT_MINUS_ONE = -1;
    public static final Short SHORT_ONE = 1;
    public static final Short SHORT_ZERO = 0;

    public static int compare(byte b, byte b2) {
        return b - b2;
    }

    public static int compare(int i, int i2) {
        if (i == i2) {
            return 0;
        }
        return i < i2 ? -1 : 1;
    }

    public static int compare(long j, long j2) {
        int i = (j > j2 ? 1 : (j == j2 ? 0 : -1));
        if (i == 0) {
            return 0;
        }
        return i < 0 ? -1 : 1;
    }

    public static int compare(short s, short s2) {
        if (s == s2) {
            return 0;
        }
        return s < s2 ? -1 : 1;
    }

    public static BigDecimal createBigDecimal(String str) {
        if (str == null) {
            return null;
        }
        if (StringUtils.isBlank(str)) {
            throw new NumberFormatException("A blank string is not a valid number");
        } else if (!str.trim().startsWith("--")) {
            return new BigDecimal(str);
        } else {
            throw new NumberFormatException(str + " is not a valid number.");
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.lang.String */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [boolean, int] */
    /* JADX WARNING: Unknown variable types count: 1 */
    public static BigInteger createBigInteger(String str) {
        int i;
        int i2;
        if (str == 0) {
            return null;
        }
        ?? startsWith = str.startsWith("-");
        int i3 = 16;
        if (str.startsWith("0x", startsWith == true ? 1 : 0) || str.startsWith("0X", startsWith)) {
            i = startsWith + 2;
        } else if (str.startsWith(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX, startsWith)) {
            i = startsWith + 1;
        } else if (!str.startsWith("0", startsWith) || str.length() <= (i2 = startsWith + 1)) {
            i = startsWith == true ? 1 : 0;
            i3 = 10;
        } else {
            i = i2;
            i3 = 8;
        }
        BigInteger bigInteger = new BigInteger(str.substring(i), i3);
        return startsWith != 0 ? bigInteger.negate() : bigInteger;
    }

    public static Double createDouble(String str) {
        if (str == null) {
            return null;
        }
        return Double.valueOf(str);
    }

    public static Float createFloat(String str) {
        if (str == null) {
            return null;
        }
        return Float.valueOf(str);
    }

    public static Integer createInteger(String str) {
        if (str == null) {
            return null;
        }
        return Integer.decode(str);
    }

    public static Long createLong(String str) {
        if (str == null) {
            return null;
        }
        return Long.decode(str);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:122:0x01ce */
    /* JADX DEBUG: Multi-variable search result rejected for r14v0, resolved type: java.lang.String */
    /* JADX DEBUG: Multi-variable search result rejected for r14v4, resolved type: java.lang.String */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v8, types: [java.lang.Number, java.lang.Integer] */
    /* JADX WARNING: Can't wrap try/catch for region: R(11:(1:59)|60|(1:65)(1:64)|66|(5:68|(3:70|(2:72|(2:74|(1:76)))|(2:92|93)(3:86|87|88))|94|95|(1:101))|102|103|(1:109)|110|111|112) */
    /* JADX WARNING: Can't wrap try/catch for region: R(3:125|126|127) */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x01b7, code lost:
        throw new java.lang.NumberFormatException(r14 + " is not a valid number.");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x01d7, code lost:
        return createLong(r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x01dc, code lost:
        return createBigInteger(r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0136, code lost:
        if (r1 == 'l') goto L_0x0138;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:102:0x0188 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:110:0x019e */
    /* JADX WARNING: Missing exception handler attribute for start block: B:125:0x01d3 */
    public static Number createNumber(String str) throws NumberFormatException {
        int i;
        String str2;
        String str3;
        String str4 = null;
        if (str == 0) {
            return null;
        }
        if (!StringUtils.isBlank(str)) {
            String[] strArr = {"0x", "0X", "-0x", "-0X", Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX, "-#"};
            char c = 0;
            int i2 = 0;
            while (true) {
                if (i2 >= 6) {
                    i = 0;
                    break;
                }
                String str5 = strArr[i2];
                if (str.startsWith(str5)) {
                    i = str5.length() + 0;
                    break;
                }
                i2++;
            }
            if (i > 0) {
                int i3 = i;
                while (i < str.length() && (c = str.charAt(i)) == '0') {
                    i3++;
                    i++;
                }
                int length = str.length() - i3;
                if (length > 16 || (length == 16 && c > '7')) {
                    return createBigInteger(str);
                }
                if (length > 8 || (length == 8 && c > '7')) {
                    return createLong(str);
                }
                return createInteger(str);
            }
            char charAt = str.charAt(str.length() - 1);
            int indexOf = str.indexOf(46);
            int indexOf2 = str.indexOf(101) + str.indexOf(69) + 1;
            if (indexOf > -1) {
                if (indexOf2 <= -1) {
                    str2 = str.substring(indexOf + 1);
                } else if (indexOf2 < indexOf || indexOf2 > str.length()) {
                    throw new NumberFormatException(str + " is not a valid number.");
                } else {
                    str2 = str.substring(indexOf + 1, indexOf2);
                }
                str3 = getMantissa(str, indexOf);
            } else {
                if (indexOf2 <= -1) {
                    str3 = getMantissa(str);
                } else if (indexOf2 <= str.length()) {
                    str3 = getMantissa(str, indexOf2);
                } else {
                    throw new NumberFormatException(str + " is not a valid number.");
                }
                str2 = null;
            }
            if (Character.isDigit(charAt) || charAt == '.') {
                if (indexOf2 > -1 && indexOf2 < str.length() - 1) {
                    str4 = str.substring(indexOf2 + 1, str.length());
                }
                if (str2 == null && str4 == null) {
                    str = createInteger(str);
                    return str;
                }
                if (isAllZeros(str3) && isAllZeros(str4)) {
                    c = 1;
                }
                try {
                    Float createFloat = createFloat(str);
                    Double createDouble = createDouble(str);
                    if (!createFloat.isInfinite() && ((createFloat.floatValue() != 0.0f || c != 0) && createFloat.toString().equals(createDouble.toString()))) {
                        return createFloat;
                    }
                    if (!createDouble.isInfinite() && !(createDouble.doubleValue() == 0.0d && c == 0)) {
                        BigDecimal createBigDecimal = createBigDecimal(str);
                        return createBigDecimal.compareTo(BigDecimal.valueOf(createDouble.doubleValue())) == 0 ? createDouble : createBigDecimal;
                    }
                    return createBigDecimal(str);
                } catch (NumberFormatException unused) {
                }
            } else {
                if (indexOf2 > -1 && indexOf2 < str.length() - 1) {
                    str4 = str.substring(indexOf2 + 1, str.length() - 1);
                }
                String substring = str.substring(0, str.length() - 1);
                boolean z = isAllZeros(str3) && isAllZeros(str4);
                if (charAt != 'D') {
                    if (charAt != 'F') {
                        if (charAt != 'L') {
                            if (charAt != 'd') {
                                if (charAt != 'f') {
                                }
                            }
                        }
                        if (str2 == null && str4 == null && ((substring.charAt(0) == '-' && isDigits(substring.substring(1))) || isDigits(substring))) {
                            try {
                                return createLong(substring);
                            } catch (NumberFormatException unused2) {
                                return createBigInteger(substring);
                            }
                        } else {
                            throw new NumberFormatException(str + " is not a valid number.");
                        }
                    }
                    Float createFloat2 = createFloat(str);
                    if (!createFloat2.isInfinite() && (createFloat2.floatValue() != 0.0f || z)) {
                        return createFloat2;
                    }
                }
                Double createDouble2 = createDouble(str);
                if (!createDouble2.isInfinite() && (((double) createDouble2.floatValue()) != 0.0d || z)) {
                    return createDouble2;
                }
                return createBigDecimal(substring);
            }
        } else {
            throw new NumberFormatException("A blank string is not a valid number");
        }
    }

    private static String getMantissa(String str) {
        return getMantissa(str, str.length());
    }

    private static boolean isAllZeros(String str) {
        if (str == null) {
            return true;
        }
        for (int length = str.length() - 1; length >= 0; length--) {
            if (str.charAt(length) != '0') {
                return false;
            }
        }
        if (str.length() > 0) {
            return true;
        }
        return false;
    }

    public static boolean isCreatable(String str) {
        if (StringUtils.isEmpty(str)) {
            return false;
        }
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        boolean z = true;
        int i = (charArray[0] == '-' || charArray[0] == '+') ? 1 : 0;
        boolean z2 = i == 1 && charArray[0] == '+';
        int i2 = i + 1;
        if (length > i2 && charArray[i] == '0') {
            if (charArray[i2] == 'x' || charArray[i2] == 'X') {
                int i3 = i + 2;
                if (i3 == length) {
                    return false;
                }
                while (i3 < charArray.length) {
                    if ((charArray[i3] < '0' || charArray[i3] > '9') && ((charArray[i3] < 'a' || charArray[i3] > 'f') && (charArray[i3] < 'A' || charArray[i3] > 'F'))) {
                        return false;
                    }
                    i3++;
                }
                return true;
            } else if (Character.isDigit(charArray[i2])) {
                while (i2 < charArray.length) {
                    if (charArray[i2] < '0' || charArray[i2] > '7') {
                        return false;
                    }
                    i2++;
                }
                return true;
            }
        }
        int i4 = length - 1;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        while (true) {
            if (i >= i4) {
                if (i >= i4 + 1 || !z3 || z4) {
                }
            }
            if (charArray[i] >= '0' && charArray[i] <= '9') {
                z3 = false;
                z4 = true;
            } else if (charArray[i] == '.') {
                if (z6 || z5) {
                    return false;
                }
                z6 = true;
            } else if (charArray[i] != 'e' && charArray[i] != 'E') {
                if (charArray[i] != '+') {
                    if (charArray[i] != '-') {
                        return false;
                    }
                }
                if (!z3) {
                    return false;
                }
                z3 = false;
                z4 = false;
            } else if (z5 || !z4) {
                return false;
            } else {
                z3 = true;
                z5 = true;
            }
            i++;
            z = true;
        }
        if (i < charArray.length) {
            if (charArray[i] < '0' || charArray[i] > '9') {
                if (charArray[i] == 'e' || charArray[i] == 'E') {
                    return false;
                }
                if (charArray[i] == '.') {
                    if (z6 || z5) {
                        return false;
                    }
                    return z4;
                } else if (!z3 && (charArray[i] == 'd' || charArray[i] == 'D' || charArray[i] == 'f' || charArray[i] == 'F')) {
                    return z4;
                } else {
                    if ((charArray[i] == 'l' || charArray[i] == 'L') && z4 && !z5 && !z6) {
                        return true;
                    }
                    return false;
                }
            } else if (!SystemUtils.IS_JAVA_1_6 || !z2 || z6) {
                return z;
            } else {
                return false;
            }
        } else if (z3 || !z4) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean isDigits(String str) {
        return StringUtils.isNumeric(str);
    }

    @Deprecated
    public static boolean isNumber(String str) {
        return isCreatable(str);
    }

    public static boolean isParsable(String str) {
        if (StringUtils.isEmpty(str) || str.charAt(str.length() - 1) == '.') {
            return false;
        }
        if (str.charAt(0) != '-') {
            return withDecimalsParsing(str, 0);
        }
        if (str.length() == 1) {
            return false;
        }
        return withDecimalsParsing(str, 1);
    }

    public static byte max(byte b, byte b2, byte b3) {
        if (b2 > b) {
            b = b2;
        }
        return b3 > b ? b3 : b;
    }

    public static int max(int i, int i2, int i3) {
        if (i2 > i) {
            i = i2;
        }
        return i3 > i ? i3 : i;
    }

    public static long max(long j, long j2, long j3) {
        if (j2 > j) {
            j = j2;
        }
        return j3 > j ? j3 : j;
    }

    public static long max(long... jArr) {
        validateArray(jArr);
        long j = jArr[0];
        for (int i = 1; i < jArr.length; i++) {
            if (jArr[i] > j) {
                j = jArr[i];
            }
        }
        return j;
    }

    public static short max(short s, short s2, short s3) {
        if (s2 > s) {
            s = s2;
        }
        return s3 > s ? s3 : s;
    }

    public static byte min(byte b, byte b2, byte b3) {
        if (b2 < b) {
            b = b2;
        }
        return b3 < b ? b3 : b;
    }

    public static int min(int i, int i2, int i3) {
        if (i2 < i) {
            i = i2;
        }
        return i3 < i ? i3 : i;
    }

    public static long min(long j, long j2, long j3) {
        if (j2 < j) {
            j = j2;
        }
        return j3 < j ? j3 : j;
    }

    public static long min(long... jArr) {
        validateArray(jArr);
        long j = jArr[0];
        for (int i = 1; i < jArr.length; i++) {
            if (jArr[i] < j) {
                j = jArr[i];
            }
        }
        return j;
    }

    public static short min(short s, short s2, short s3) {
        if (s2 < s) {
            s = s2;
        }
        return s3 < s ? s3 : s;
    }

    public static byte toByte(String str) {
        return toByte(str, (byte) 0);
    }

    public static double toDouble(String str) {
        return toDouble(str, 0.0d);
    }

    public static float toFloat(String str) {
        return toFloat(str, 0.0f);
    }

    public static int toInt(String str) {
        return toInt(str, 0);
    }

    public static long toLong(String str) {
        return toLong(str, 0);
    }

    public static short toShort(String str) {
        return toShort(str, 0);
    }

    private static void validateArray(Object obj) {
        boolean z = true;
        Validate.isTrue(obj != null, "The Array must not be null", new Object[0]);
        if (Array.getLength(obj) == 0) {
            z = false;
        }
        Validate.isTrue(z, "Array cannot be empty.", new Object[0]);
    }

    private static boolean withDecimalsParsing(String str, int i) {
        int i2 = 0;
        while (i < str.length()) {
            boolean z = str.charAt(i) == '.';
            if (z) {
                i2++;
            }
            if (i2 > 1) {
                return false;
            }
            if (!z && !Character.isDigit(str.charAt(i))) {
                return false;
            }
            i++;
        }
        return true;
    }

    private static String getMantissa(String str, int i) {
        char charAt = str.charAt(0);
        return charAt == '-' || charAt == '+' ? str.substring(1, i) : str.substring(0, i);
    }

    public static byte toByte(String str, byte b) {
        if (str == null) {
            return b;
        }
        try {
            return Byte.parseByte(str);
        } catch (NumberFormatException unused) {
            return b;
        }
    }

    public static double toDouble(String str, double d) {
        if (str == null) {
            return d;
        }
        try {
            return Double.parseDouble(str);
        } catch (NumberFormatException unused) {
            return d;
        }
    }

    public static float toFloat(String str, float f) {
        if (str == null) {
            return f;
        }
        try {
            return Float.parseFloat(str);
        } catch (NumberFormatException unused) {
            return f;
        }
    }

    public static int toInt(String str, int i) {
        if (str == null) {
            return i;
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return i;
        }
    }

    public static long toLong(String str, long j) {
        if (str == null) {
            return j;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return j;
        }
    }

    public static short toShort(String str, short s) {
        if (str == null) {
            return s;
        }
        try {
            return Short.parseShort(str);
        } catch (NumberFormatException unused) {
            return s;
        }
    }

    public static int max(int... iArr) {
        validateArray(iArr);
        int i = iArr[0];
        for (int i2 = 1; i2 < iArr.length; i2++) {
            if (iArr[i2] > i) {
                i = iArr[i2];
            }
        }
        return i;
    }

    public static int min(int... iArr) {
        validateArray(iArr);
        int i = iArr[0];
        for (int i2 = 1; i2 < iArr.length; i2++) {
            if (iArr[i2] < i) {
                i = iArr[i2];
            }
        }
        return i;
    }

    public static short max(short... sArr) {
        validateArray(sArr);
        short s = sArr[0];
        for (int i = 1; i < sArr.length; i++) {
            if (sArr[i] > s) {
                s = sArr[i];
            }
        }
        return s;
    }

    public static short min(short... sArr) {
        validateArray(sArr);
        short s = sArr[0];
        for (int i = 1; i < sArr.length; i++) {
            if (sArr[i] < s) {
                s = sArr[i];
            }
        }
        return s;
    }

    public static byte max(byte... bArr) {
        validateArray(bArr);
        byte b = bArr[0];
        for (int i = 1; i < bArr.length; i++) {
            if (bArr[i] > b) {
                b = bArr[i];
            }
        }
        return b;
    }

    public static byte min(byte... bArr) {
        validateArray(bArr);
        byte b = bArr[0];
        for (int i = 1; i < bArr.length; i++) {
            if (bArr[i] < b) {
                b = bArr[i];
            }
        }
        return b;
    }

    public static double max(double... dArr) {
        validateArray(dArr);
        double d = dArr[0];
        for (int i = 1; i < dArr.length; i++) {
            if (Double.isNaN(dArr[i])) {
                return Double.NaN;
            }
            if (dArr[i] > d) {
                d = dArr[i];
            }
        }
        return d;
    }

    public static double min(double... dArr) {
        validateArray(dArr);
        double d = dArr[0];
        for (int i = 1; i < dArr.length; i++) {
            if (Double.isNaN(dArr[i])) {
                return Double.NaN;
            }
            if (dArr[i] < d) {
                d = dArr[i];
            }
        }
        return d;
    }

    public static float max(float... fArr) {
        validateArray(fArr);
        float f = fArr[0];
        for (int i = 1; i < fArr.length; i++) {
            if (Float.isNaN(fArr[i])) {
                return Float.NaN;
            }
            if (fArr[i] > f) {
                f = fArr[i];
            }
        }
        return f;
    }

    public static float min(float... fArr) {
        validateArray(fArr);
        float f = fArr[0];
        for (int i = 1; i < fArr.length; i++) {
            if (Float.isNaN(fArr[i])) {
                return Float.NaN;
            }
            if (fArr[i] < f) {
                f = fArr[i];
            }
        }
        return f;
    }

    public static double max(double d, double d2, double d3) {
        return Math.max(Math.max(d, d2), d3);
    }

    public static double min(double d, double d2, double d3) {
        return Math.min(Math.min(d, d2), d3);
    }

    public static float max(float f, float f2, float f3) {
        return Math.max(Math.max(f, f2), f3);
    }

    public static float min(float f, float f2, float f3) {
        return Math.min(Math.min(f, f2), f3);
    }
}
