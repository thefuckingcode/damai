package com.alibaba.fastjson.parser;

import cn.damai.common.util.ACache;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.poplayerconsole.lib.StandOutWindow;
import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import com.taobao.weex.common.Constants;
import com.youku.upsplayer.util.YKUpsConvert;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import org.apache.commons.lang3.CharUtils;
import tb.d80;
import tb.jl1;
import tb.u91;
import tb.v00;

/* compiled from: Taobao */
public final class JSONLexer {
    public static final char[] CA;
    public static final int END = 4;
    public static final char EOI = 26;
    static final int[] IA;
    public static final int NOT_MATCH = -1;
    public static final int NOT_MATCH_NAME = -2;
    public static final int UNKNOWN = 0;
    private static boolean V6 = false;
    public static final int VALUE = 3;
    protected static final int[] digits = new int[103];
    public static final boolean[] firstIdentifierFlags = new boolean[256];
    public static final boolean[] identifierFlags = new boolean[256];
    private static final ThreadLocal<char[]> sbufLocal = new ThreadLocal<>();
    protected int bp;
    public Calendar calendar;
    protected char ch;
    public boolean disableCircularReferenceDetect;
    protected int eofPos;
    protected boolean exp;
    public int features;
    protected long fieldHash;
    protected boolean hasSpecial;
    protected boolean isDouble;
    protected final int len;
    public Locale locale;
    public int matchStat;
    protected int np;
    protected int pos;
    protected char[] sbuf;
    protected int sp;
    protected String stringDefaultValue;
    protected final String text;
    public TimeZone timeZone;
    protected int token;

    static {
        int i;
        try {
            i = Class.forName("android.os.Build$VERSION").getField("SDK_INT").getInt(null);
        } catch (Exception unused) {
            i = -1;
        }
        char c = 0;
        V6 = i >= 23;
        for (int i2 = 48; i2 <= 57; i2++) {
            digits[i2] = i2 - 48;
        }
        for (int i3 = 97; i3 <= 102; i3++) {
            digits[i3] = (i3 - 97) + 10;
        }
        for (int i4 = 65; i4 <= 70; i4++) {
            digits[i4] = (i4 - 65) + 10;
        }
        char[] charArray = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();
        CA = charArray;
        int[] iArr = new int[256];
        IA = iArr;
        Arrays.fill(iArr, -1);
        int length = charArray.length;
        for (int i5 = 0; i5 < length; i5++) {
            IA[CA[i5]] = i5;
        }
        IA[61] = 0;
        char c2 = 0;
        while (true) {
            boolean[] zArr = firstIdentifierFlags;
            if (c2 >= zArr.length) {
                break;
            }
            if (c2 >= 'A' && c2 <= 'Z') {
                zArr[c2] = true;
            } else if (c2 >= 'a' && c2 <= 'z') {
                zArr[c2] = true;
            } else if (c2 == '_') {
                zArr[c2] = true;
            }
            c2 = (char) (c2 + 1);
        }
        while (true) {
            boolean[] zArr2 = identifierFlags;
            if (c < zArr2.length) {
                if (c >= 'A' && c <= 'Z') {
                    zArr2[c] = true;
                } else if (c >= 'a' && c <= 'z') {
                    zArr2[c] = true;
                } else if (c == '_') {
                    zArr2[c] = true;
                } else if (c >= '0' && c <= '9') {
                    zArr2[c] = true;
                }
                c = (char) (c + 1);
            } else {
                return;
            }
        }
    }

    public JSONLexer(String str) {
        this(str, JSON.DEFAULT_PARSER_FEATURE);
    }

    static boolean checkDate(char c, char c2, char c3, char c4, char c5, char c6, int i, int i2) {
        if (c >= '1' && c <= '3' && c2 >= '0' && c2 <= '9' && c3 >= '0' && c3 <= '9' && c4 >= '0' && c4 <= '9') {
            if (c5 == '0') {
                if (c6 < '1' || c6 > '9') {
                    return false;
                }
            } else if (!(c5 == '1' && (c6 == '0' || c6 == '1' || c6 == '2'))) {
                return false;
            }
            return i == 48 ? i2 >= 49 && i2 <= 57 : (i == 49 || i == 50) ? i2 >= 48 && i2 <= 57 : i == 51 && (i2 == 48 || i2 == 49);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001d, code lost:
        if (r5 <= '4') goto L_0x0020;
     */
    static boolean checkTime(char c, char c2, char c3, char c4, char c5, char c6) {
        if (c == '0') {
            if (c2 < '0' || c2 > '9') {
                return false;
            }
        } else if (c != '1') {
            if (c == '2') {
                if (c2 >= '0') {
                }
            }
            return false;
        } else if (c2 < '0' || c2 > '9') {
            return false;
        }
        if (c3 < '0' || c3 > '5') {
            if (!(c3 == '6' && c4 == '0')) {
                return false;
            }
        } else if (c4 < '0' || c4 > '9') {
            return false;
        }
        return (c5 < '0' || c5 > '5') ? c5 == '6' && c6 == '0' : c6 >= '0' && c6 <= '9';
    }

    public static final byte[] decodeFast(String str, int i, int i2) {
        int i3;
        int i4 = 0;
        if (i2 == 0) {
            return new byte[0];
        }
        int i5 = (i + i2) - 1;
        while (i < i5 && IA[str.charAt(i)] < 0) {
            i++;
        }
        while (i5 > 0 && IA[str.charAt(i5)] < 0) {
            i5--;
        }
        int i6 = str.charAt(i5) == '=' ? str.charAt(i5 + -1) == '=' ? 2 : 1 : 0;
        int i7 = (i5 - i) + 1;
        if (i2 > 76) {
            i3 = (str.charAt(76) == '\r' ? i7 / 78 : 0) << 1;
        } else {
            i3 = 0;
        }
        int i8 = (((i7 - i3) * 6) >> 3) - i6;
        byte[] bArr = new byte[i8];
        int i9 = (i8 / 3) * 3;
        int i10 = 0;
        int i11 = 0;
        while (i10 < i9) {
            int[] iArr = IA;
            int i12 = i + 1;
            int i13 = i12 + 1;
            int i14 = (iArr[str.charAt(i)] << 18) | (iArr[str.charAt(i12)] << 12);
            int i15 = i13 + 1;
            int i16 = i14 | (iArr[str.charAt(i13)] << 6);
            int i17 = i15 + 1;
            int i18 = i16 | iArr[str.charAt(i15)];
            int i19 = i10 + 1;
            bArr[i10] = (byte) (i18 >> 16);
            int i20 = i19 + 1;
            bArr[i19] = (byte) (i18 >> 8);
            int i21 = i20 + 1;
            bArr[i20] = (byte) i18;
            if (i3 <= 0 || (i11 = i11 + 1) != 19) {
                i = i17;
            } else {
                i = i17 + 2;
                i11 = 0;
            }
            i10 = i21;
        }
        if (i10 < i8) {
            int i22 = 0;
            while (i <= i5 - i6) {
                i4 |= IA[str.charAt(i)] << (18 - (i22 * 6));
                i22++;
                i++;
            }
            int i23 = 16;
            while (i10 < i8) {
                bArr[i10] = (byte) (i4 >> i23);
                i23 -= 8;
                i10++;
            }
        }
        return bArr;
    }

    private int matchFieldHash(long j) {
        char c;
        char c2 = this.ch;
        int i = 1;
        while (c2 != '\"' && c2 != '\'') {
            if (c2 == ' ' || c2 == '\n' || c2 == '\r' || c2 == '\t' || c2 == '\f' || c2 == '\b') {
                int i2 = i + 1;
                int i3 = this.bp + i;
                if (i3 >= this.len) {
                    c2 = EOI;
                } else {
                    c2 = this.text.charAt(i3);
                }
                i = i2;
            } else {
                this.fieldHash = 0;
                this.matchStat = -2;
                return 0;
            }
        }
        long j2 = -3750763034362895579L;
        int i4 = this.bp + i;
        while (true) {
            if (i4 >= this.len) {
                break;
            }
            char charAt = this.text.charAt(i4);
            if (charAt == c2) {
                i += (i4 - this.bp) - i;
                break;
            }
            j2 = 1099511628211L * (((long) charAt) ^ j2);
            i4++;
        }
        if (j2 != j) {
            this.fieldHash = j2;
            this.matchStat = -2;
            return 0;
        }
        int i5 = i + 1;
        int i6 = this.bp + i5;
        if (i6 >= this.len) {
            c = EOI;
        } else {
            c = this.text.charAt(i6);
        }
        while (c != ':') {
            if (c > ' ' || !(c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == '\f' || c == '\b')) {
                throw new JSONException("match feild error expect ':'");
            }
            int i7 = i5 + 1;
            int i8 = this.bp + i5;
            if (i8 >= this.len) {
                c = EOI;
            } else {
                c = this.text.charAt(i8);
            }
            i5 = i7;
        }
        return i5 + 1;
    }

    private static String readString(char[] cArr, int i) {
        int i2;
        char[] cArr2 = new char[i];
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            char c = cArr[i3];
            if (c != '\\') {
                cArr2[i4] = c;
                i4++;
            } else {
                i3++;
                char c2 = cArr[i3];
                if (c2 == '\"') {
                    i2 = i4 + 1;
                    cArr2[i4] = jl1.QUOTE;
                } else if (c2 != '\'') {
                    if (c2 != 'F') {
                        if (c2 == '\\') {
                            i2 = i4 + 1;
                            cArr2[i4] = d80.TokenESC;
                        } else if (c2 == 'b') {
                            i2 = i4 + 1;
                            cArr2[i4] = '\b';
                        } else if (c2 != 'f') {
                            if (c2 == 'n') {
                                i2 = i4 + 1;
                                cArr2[i4] = '\n';
                            } else if (c2 == 'r') {
                                i2 = i4 + 1;
                                cArr2[i4] = CharUtils.CR;
                            } else if (c2 != 'x') {
                                switch (c2) {
                                    case '/':
                                        i2 = i4 + 1;
                                        cArr2[i4] = v00.DIR;
                                        break;
                                    case '0':
                                        i2 = i4 + 1;
                                        cArr2[i4] = 0;
                                        break;
                                    case '1':
                                        i2 = i4 + 1;
                                        cArr2[i4] = 1;
                                        break;
                                    case '2':
                                        i2 = i4 + 1;
                                        cArr2[i4] = 2;
                                        break;
                                    case '3':
                                        i2 = i4 + 1;
                                        cArr2[i4] = 3;
                                        break;
                                    case '4':
                                        i2 = i4 + 1;
                                        cArr2[i4] = 4;
                                        break;
                                    case '5':
                                        i2 = i4 + 1;
                                        cArr2[i4] = 5;
                                        break;
                                    case '6':
                                        i2 = i4 + 1;
                                        cArr2[i4] = 6;
                                        break;
                                    case '7':
                                        i2 = i4 + 1;
                                        cArr2[i4] = 7;
                                        break;
                                    default:
                                        switch (c2) {
                                            case 't':
                                                i2 = i4 + 1;
                                                cArr2[i4] = '\t';
                                                break;
                                            case 'u':
                                                i2 = i4 + 1;
                                                int i5 = i3 + 1;
                                                int i6 = i5 + 1;
                                                int i7 = i6 + 1;
                                                i3 = i7 + 1;
                                                cArr2[i4] = (char) Integer.parseInt(new String(new char[]{cArr[i5], cArr[i6], cArr[i7], cArr[i3]}), 16);
                                                break;
                                            case 'v':
                                                i2 = i4 + 1;
                                                cArr2[i4] = 11;
                                                break;
                                            default:
                                                throw new JSONException("unclosed.str.lit");
                                        }
                                }
                            } else {
                                i2 = i4 + 1;
                                int[] iArr = digits;
                                int i8 = i3 + 1;
                                i3 = i8 + 1;
                                cArr2[i4] = (char) ((iArr[cArr[i8]] * 16) + iArr[cArr[i3]]);
                            }
                        }
                    }
                    i2 = i4 + 1;
                    cArr2[i4] = '\f';
                } else {
                    i2 = i4 + 1;
                    cArr2[i4] = '\'';
                }
                i4 = i2;
            }
            i3++;
        }
        return new String(cArr2, 0, i4);
    }

    private void scanIdent() {
        this.np = this.bp - 1;
        this.hasSpecial = false;
        do {
            this.sp++;
            next();
        } while (Character.isLetterOrDigit(this.ch));
        String stringVal = stringVal();
        if (stringVal.equals("null")) {
            this.token = 8;
        } else if (stringVal.equals("true")) {
            this.token = 6;
        } else if (stringVal.equals("false")) {
            this.token = 7;
        } else if (stringVal.equals("new")) {
            this.token = 9;
        } else if (stringVal.equals(Constants.Name.UNDEFINED)) {
            this.token = 23;
        } else if (stringVal.equals("Set")) {
            this.token = 21;
        } else if (stringVal.equals("TreeSet")) {
            this.token = 22;
        } else {
            this.token = 18;
        }
    }

    private void setCalendar(char c, char c2, char c3, char c4, char c5, char c6, char c7, char c8) {
        Calendar instance = Calendar.getInstance(this.timeZone, this.locale);
        this.calendar = instance;
        instance.set(1, ((c - '0') * 1000) + ((c2 - '0') * 100) + ((c3 - '0') * 10) + (c4 - '0'));
        this.calendar.set(2, (((c5 - '0') * 10) + (c6 - '0')) - 1);
        this.calendar.set(5, ((c7 - '0') * 10) + (c8 - '0'));
    }

    private final String subString(int i, int i2) {
        char[] cArr = this.sbuf;
        if (i2 < cArr.length) {
            this.text.getChars(i, i + i2, cArr, 0);
            return new String(this.sbuf, 0, i2);
        }
        char[] cArr2 = new char[i2];
        this.text.getChars(i, i2 + i, cArr2, 0);
        return new String(cArr2);
    }

    public byte[] bytesValue() {
        return decodeFast(this.text, this.np + 1, this.sp);
    }

    /* access modifiers changed from: protected */
    public char charAt(int i) {
        if (i >= this.len) {
            return EOI;
        }
        return this.text.charAt(i);
    }

    public void close() {
        char[] cArr = this.sbuf;
        if (cArr.length <= 8196) {
            sbufLocal.set(cArr);
        }
        this.sbuf = null;
    }

    public final void config(Feature feature, boolean z) {
        if (z) {
            this.features |= feature.mask;
        } else {
            this.features &= ~feature.mask;
        }
        if (feature == Feature.InitStringFieldAsEmpty) {
            this.stringDefaultValue = z ? "" : null;
        }
        this.disableCircularReferenceDetect = (this.features & Feature.DisableCircularReferenceDetect.mask) != 0;
    }

    public final Number decimalValue(boolean z) {
        char c;
        char[] cArr;
        boolean z2;
        int i = (this.np + this.sp) - 1;
        if (i >= this.len) {
            c = EOI;
        } else {
            c = this.text.charAt(i);
        }
        if (c == 'F') {
            try {
                return Float.valueOf(Float.parseFloat(numberString()));
            } catch (NumberFormatException e) {
                throw new JSONException(e.getMessage() + AVFSCacheConstants.COMMA_SEP + info());
            }
        } else if (c == 'D') {
            return Double.valueOf(Double.parseDouble(numberString()));
        } else {
            if (z) {
                return decimalValue();
            }
            char charAt = this.text.charAt((this.np + this.sp) - 1);
            int i2 = this.sp;
            if (charAt == 'L' || charAt == 'S' || charAt == 'B' || charAt == 'F' || charAt == 'D') {
                i2--;
            }
            int i3 = this.np;
            char[] cArr2 = this.sbuf;
            int i4 = 0;
            if (i2 < cArr2.length) {
                this.text.getChars(i3, i3 + i2, cArr2, 0);
                cArr = this.sbuf;
            } else {
                char[] cArr3 = new char[i2];
                this.text.getChars(i3, i3 + i2, cArr3, 0);
                cArr = cArr3;
            }
            if (i2 > 9 || this.exp) {
                return Double.valueOf(Double.parseDouble(new String(cArr, 0, i2)));
            }
            char c2 = cArr[0];
            int i5 = 2;
            if (c2 == '-') {
                c2 = cArr[1];
                z2 = true;
            } else if (c2 == '+') {
                c2 = cArr[1];
                z2 = false;
            } else {
                z2 = false;
                i5 = 1;
            }
            int i6 = c2 - '0';
            while (i5 < i2) {
                char c3 = cArr[i5];
                if (c3 == '.') {
                    i4 = 1;
                } else {
                    i6 = (i6 * 10) + (c3 - '0');
                    if (i4 != 0) {
                        i4 *= 10;
                    }
                }
                i5++;
            }
            double d = ((double) i6) / ((double) i4);
            if (z2) {
                d = -d;
            }
            return Double.valueOf(d);
        }
    }

    public String info() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("pos ");
        sb.append(this.bp);
        sb.append(", json : ");
        if (this.len < 65536) {
            str = this.text;
        } else {
            str = this.text.substring(0, 65536);
        }
        sb.append(str);
        return sb.toString();
    }

    public final int intValue() {
        char c;
        boolean z;
        int i;
        char c2;
        char c3;
        int i2 = this.np;
        int i3 = this.sp + i2;
        if (i2 >= this.len) {
            c = EOI;
        } else {
            c = this.text.charAt(i2);
        }
        int i4 = 0;
        if (c == '-') {
            i = Integer.MIN_VALUE;
            i2++;
            z = true;
        } else {
            i = StandOutWindow.StandOutLayoutParams.AUTO_POSITION;
            z = false;
        }
        if (i2 < i3) {
            int i5 = i2 + 1;
            if (i2 >= this.len) {
                c3 = EOI;
            } else {
                c3 = this.text.charAt(i2);
            }
            i4 = -(c3 - '0');
            i2 = i5;
        }
        while (true) {
            if (i2 >= i3) {
                break;
            }
            int i6 = i2 + 1;
            if (i2 >= this.len) {
                c2 = EOI;
            } else {
                c2 = this.text.charAt(i2);
            }
            if (c2 == 'L' || c2 == 'S' || c2 == 'B') {
                i2 = i6;
            } else {
                int i7 = c2 - '0';
                if (i4 >= -214748364) {
                    int i8 = i4 * 10;
                    if (i8 >= i + i7) {
                        i4 = i8 - i7;
                        i2 = i6;
                    } else {
                        throw new NumberFormatException(numberString());
                    }
                } else {
                    throw new NumberFormatException(numberString());
                }
            }
        }
        if (!z) {
            return -i4;
        }
        if (i2 > this.np + 1) {
            return i4;
        }
        throw new NumberFormatException(numberString());
    }

    public final Number integerValue() throws NumberFormatException {
        char c;
        char c2;
        char c3;
        boolean z;
        long j;
        long j2;
        char c4;
        char c5;
        int i = this.np;
        int i2 = this.sp + i;
        int i3 = i2 - 1;
        if (i3 >= this.len) {
            c = EOI;
        } else {
            c = this.text.charAt(i3);
        }
        if (c == 'B') {
            i2--;
            c2 = 'B';
        } else if (c == 'L') {
            i2--;
            c2 = u91.LEVEL_L;
        } else if (c != 'S') {
            c2 = ' ';
        } else {
            i2--;
            c2 = 'S';
        }
        int i4 = this.np;
        if (i4 >= this.len) {
            c3 = EOI;
        } else {
            c3 = this.text.charAt(i4);
        }
        if (c3 == '-') {
            j = Long.MIN_VALUE;
            i++;
            z = true;
        } else {
            j = -9223372036854775807L;
            z = false;
        }
        if (i < i2) {
            int i5 = i + 1;
            if (i >= this.len) {
                c5 = EOI;
            } else {
                c5 = this.text.charAt(i);
            }
            j2 = (long) (-(c5 - '0'));
            i = i5;
        } else {
            j2 = 0;
        }
        while (i < i2) {
            int i6 = i + 1;
            if (i >= this.len) {
                c4 = EOI;
            } else {
                c4 = this.text.charAt(i);
            }
            int i7 = c4 - '0';
            if (j2 < -922337203685477580L) {
                return new BigInteger(numberString());
            }
            long j3 = j2 * 10;
            long j4 = (long) i7;
            if (j3 < j + j4) {
                return new BigInteger(numberString());
            }
            j2 = j3 - j4;
            i = i6;
        }
        if (!z) {
            long j5 = -j2;
            if (j5 > 2147483647L || c2 == 'L') {
                return Long.valueOf(j5);
            }
            if (c2 == 'S') {
                return Short.valueOf((short) ((int) j5));
            }
            if (c2 == 'B') {
                return Byte.valueOf((byte) ((int) j5));
            }
            return Integer.valueOf((int) j5);
        } else if (i <= this.np + 1) {
            throw new NumberFormatException(numberString());
        } else if (j2 < -2147483648L || c2 == 'L') {
            return Long.valueOf(j2);
        } else {
            if (c2 == 'S') {
                return Short.valueOf((short) ((int) j2));
            }
            if (c2 == 'B') {
                return Byte.valueOf((byte) ((int) j2));
            }
            return Integer.valueOf((int) j2);
        }
    }

    public final boolean isBlankInput() {
        int i = 0;
        while (true) {
            char charAt = charAt(i);
            boolean z = true;
            if (charAt == 26) {
                return true;
            }
            if (charAt > ' ' || !(charAt == ' ' || charAt == '\n' || charAt == '\r' || charAt == '\t' || charAt == '\f' || charAt == '\b')) {
                z = false;
            }
            if (!z) {
                return false;
            }
            i++;
        }
    }

    public final boolean isEnabled(Feature feature) {
        return (feature.mask & this.features) != 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x002c  */
    public final long longValue() throws NumberFormatException {
        long j;
        boolean z;
        long j2;
        int i;
        char c;
        int i2 = this.np;
        int i3 = this.sp + i2;
        if (charAt(i2) == '-') {
            j = Long.MIN_VALUE;
            i2++;
            z = true;
        } else {
            j = -9223372036854775807L;
            z = false;
        }
        if (i2 < i3) {
            i = i2 + 1;
            j2 = (long) (-(charAt(i2) - '0'));
        } else {
            j2 = 0;
            if (i2 < i3) {
                i = i2 + 1;
                if (i2 >= this.len) {
                    c = EOI;
                } else {
                    c = this.text.charAt(i2);
                }
                if (c == 'L' || c == 'S' || c == 'B') {
                    i2 = i;
                } else {
                    int i4 = c - '0';
                    if (j2 >= -922337203685477580L) {
                        long j3 = j2 * 10;
                        long j4 = (long) i4;
                        if (j3 >= j + j4) {
                            j2 = j3 - j4;
                        }
                        throw new NumberFormatException(numberString());
                    }
                    throw new NumberFormatException(numberString());
                }
            }
            if (z) {
                return -j2;
            }
            if (i2 > this.np + 1) {
                return j2;
            }
            throw new NumberFormatException(numberString());
        }
        i2 = i;
        if (i2 < i3) {
        }
        if (z) {
        }
    }

    public boolean matchField(long j) {
        char c;
        char c2;
        char c3;
        char c4;
        char c5;
        char c6 = this.ch;
        int i = this.bp + 1;
        int i2 = 1;
        while (c6 != '\"' && c6 != '\'') {
            if (c6 > ' ' || !(c6 == ' ' || c6 == '\n' || c6 == '\r' || c6 == '\t' || c6 == '\f' || c6 == '\b')) {
                this.fieldHash = 0;
                this.matchStat = -2;
                return false;
            }
            int i3 = i2 + 1;
            int i4 = this.bp + i2;
            if (i4 >= this.len) {
                c6 = EOI;
            } else {
                c6 = this.text.charAt(i4);
            }
            i2 = i3;
        }
        int i5 = i;
        long j2 = -3750763034362895579L;
        while (true) {
            if (i5 >= this.len) {
                break;
            }
            char charAt = this.text.charAt(i5);
            if (charAt == c6) {
                i2 += (i5 - i) + 1;
                break;
            }
            j2 = 1099511628211L * (j2 ^ ((long) charAt));
            i5++;
        }
        if (j2 != j) {
            this.matchStat = -2;
            this.fieldHash = j2;
            return false;
        }
        int i6 = i2 + 1;
        int i7 = this.bp + i2;
        if (i7 >= this.len) {
            c = EOI;
        } else {
            c = this.text.charAt(i7);
        }
        while (c != ':') {
            if (c > ' ' || !(c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == '\f' || c == '\b')) {
                throw new JSONException("match feild error expect ':'");
            }
            int i8 = i6 + 1;
            int i9 = this.bp + i6;
            if (i9 >= this.len) {
                c = EOI;
            } else {
                c = this.text.charAt(i9);
            }
            i6 = i8;
        }
        int i10 = this.bp + i6;
        if (i10 >= this.len) {
            c2 = EOI;
        } else {
            c2 = this.text.charAt(i10);
        }
        if (c2 == '{') {
            int i11 = i10 + 1;
            this.bp = i11;
            if (i11 >= this.len) {
                c5 = EOI;
            } else {
                c5 = this.text.charAt(i11);
            }
            this.ch = c5;
            this.token = 12;
        } else if (c2 == '[') {
            int i12 = i10 + 1;
            this.bp = i12;
            if (i12 >= this.len) {
                c4 = EOI;
            } else {
                c4 = this.text.charAt(i12);
            }
            this.ch = c4;
            this.token = 14;
        } else {
            this.bp = i10;
            if (i10 >= this.len) {
                c3 = EOI;
            } else {
                c3 = this.text.charAt(i10);
            }
            this.ch = c3;
            nextToken();
        }
        return true;
    }

    public char next() {
        char c;
        int i = this.bp + 1;
        this.bp = i;
        if (i >= this.len) {
            c = EOI;
        } else {
            c = this.text.charAt(i);
        }
        this.ch = c;
        return c;
    }

    public final void nextIdent() {
        char c;
        while (true) {
            c = this.ch;
            if (!(c <= ' ' && (c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == '\f' || c == '\b'))) {
                break;
            }
            next();
        }
        if (c == '_' || Character.isLetter(c)) {
            scanIdent();
        } else {
            nextToken();
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0027, code lost:
        scanNumber();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002a, code lost:
        return;
     */
    public final void nextToken() {
        int i;
        this.sp = 0;
        while (true) {
            int i2 = this.bp;
            this.pos = i2;
            char c = this.ch;
            if (c == '/') {
                skipComment();
            } else if (c == '\"') {
                scanString();
                return;
            } else if ((c < '0' || c > '9') && c != '-') {
                if (c == ',') {
                    next();
                    this.token = 16;
                    return;
                }
                if (!(c == '\f' || c == '\r' || c == ' ')) {
                    if (c != ':') {
                        char c2 = EOI;
                        if (c == '[') {
                            int i3 = i2 + 1;
                            this.bp = i3;
                            if (i3 < this.len) {
                                c2 = this.text.charAt(i3);
                            }
                            this.ch = c2;
                            this.token = 14;
                            return;
                        } else if (c == ']') {
                            next();
                            this.token = 15;
                            return;
                        } else if (c == 'f') {
                            if (this.text.startsWith("false", i2)) {
                                int i4 = this.bp + 5;
                                this.bp = i4;
                                char charAt = charAt(i4);
                                this.ch = charAt;
                                if (charAt == ' ' || charAt == ',' || charAt == '}' || charAt == ']' || charAt == '\n' || charAt == '\r' || charAt == '\t' || charAt == 26 || charAt == '\f' || charAt == '\b' || charAt == ':') {
                                    this.token = 7;
                                    return;
                                }
                            }
                            throw new JSONException("scan false error");
                        } else if (c == 'n') {
                            if (this.text.startsWith("null", i2)) {
                                this.bp += 4;
                                i = 8;
                            } else if (this.text.startsWith("new", this.bp)) {
                                this.bp += 3;
                                i = 9;
                            } else {
                                i = 0;
                            }
                            if (i != 0) {
                                char charAt2 = charAt(this.bp);
                                this.ch = charAt2;
                                if (charAt2 == ' ' || charAt2 == ',' || charAt2 == '}' || charAt2 == ']' || charAt2 == '\n' || charAt2 == '\r' || charAt2 == '\t' || charAt2 == 26 || charAt2 == '\f' || charAt2 == '\b') {
                                    this.token = i;
                                    return;
                                }
                            }
                            throw new JSONException("scan null/new error");
                        } else if (c == '{') {
                            int i5 = i2 + 1;
                            this.bp = i5;
                            if (i5 < this.len) {
                                c2 = this.text.charAt(i5);
                            }
                            this.ch = c2;
                            this.token = 12;
                            return;
                        } else if (c == '}') {
                            int i6 = i2 + 1;
                            this.bp = i6;
                            if (i6 < this.len) {
                                c2 = this.text.charAt(i6);
                            }
                            this.ch = c2;
                            this.token = 13;
                            return;
                        } else if (!(c == 'S' || c == 'T')) {
                            if (c == 't') {
                                if (this.text.startsWith("true", i2)) {
                                    int i7 = this.bp + 4;
                                    this.bp = i7;
                                    char charAt3 = charAt(i7);
                                    this.ch = charAt3;
                                    if (charAt3 == ' ' || charAt3 == ',' || charAt3 == '}' || charAt3 == ']' || charAt3 == '\n' || charAt3 == '\r' || charAt3 == '\t' || charAt3 == 26 || charAt3 == '\f' || charAt3 == '\b' || charAt3 == ':') {
                                        this.token = 6;
                                        return;
                                    }
                                }
                                throw new JSONException("scan true error");
                            } else if (c != 'u') {
                                switch (c) {
                                    case '\b':
                                    case '\t':
                                    case '\n':
                                        break;
                                    default:
                                        switch (c) {
                                            case '\'':
                                                scanString();
                                                return;
                                            case '(':
                                                next();
                                                this.token = 10;
                                                return;
                                            case ')':
                                                next();
                                                this.token = 11;
                                                return;
                                            default:
                                                int i8 = this.len;
                                                if (i2 == i8 || (c == 26 && i2 + 1 == i8)) {
                                                    if (this.token != 20) {
                                                        this.token = 20;
                                                        int i9 = this.eofPos;
                                                        this.bp = i9;
                                                        this.pos = i9;
                                                        return;
                                                    }
                                                    throw new JSONException("EOF error");
                                                } else if (c <= 31 || c == 127) {
                                                    next();
                                                    break;
                                                } else {
                                                    this.token = 1;
                                                    next();
                                                    return;
                                                }
                                                break;
                                        }
                                }
                            }
                        }
                    } else {
                        next();
                        this.token = 17;
                        return;
                    }
                }
                next();
            }
        }
        scanIdent();
    }

    public final void nextTokenWithChar(char c) {
        char c2;
        this.sp = 0;
        while (true) {
            char c3 = this.ch;
            if (c3 == c) {
                int i = this.bp + 1;
                this.bp = i;
                if (i >= this.len) {
                    c2 = EOI;
                } else {
                    c2 = this.text.charAt(i);
                }
                this.ch = c2;
                nextToken();
                return;
            } else if (c3 == ' ' || c3 == '\n' || c3 == '\r' || c3 == '\t' || c3 == '\f' || c3 == '\b') {
                next();
            } else {
                throw new JSONException("not match " + c + " - " + this.ch);
            }
        }
    }

    public final String numberString() {
        char charAt = this.text.charAt((this.np + this.sp) - 1);
        int i = this.sp;
        if (charAt == 'L' || charAt == 'S' || charAt == 'B' || charAt == 'F' || charAt == 'D') {
            i--;
        }
        return subString(this.np, i);
    }

    public boolean scanBoolean() {
        boolean z = false;
        int i = 1;
        if (this.text.startsWith("false", this.bp)) {
            i = 5;
        } else if (this.text.startsWith("true", this.bp)) {
            z = true;
            i = 4;
        } else {
            char c = this.ch;
            if (c == '1') {
                z = true;
            } else if (c != '0') {
                this.matchStat = -1;
                return false;
            }
        }
        int i2 = this.bp + i;
        this.bp = i2;
        this.ch = charAt(i2);
        return z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x0096  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00c0  */
    public boolean scanFieldBoolean(long j) {
        boolean z;
        int i;
        int i2;
        int i3;
        char c;
        int i4;
        this.matchStat = 0;
        int matchFieldHash = matchFieldHash(j);
        if (matchFieldHash == 0) {
            return false;
        }
        if (this.text.startsWith("false", this.bp + matchFieldHash)) {
            i = matchFieldHash + 5;
        } else {
            if (this.text.startsWith("true", this.bp + matchFieldHash)) {
                i = matchFieldHash + 4;
            } else if (this.text.startsWith("\"false\"", this.bp + matchFieldHash)) {
                i = matchFieldHash + 7;
            } else if (this.text.startsWith("\"true\"", this.bp + matchFieldHash)) {
                i = matchFieldHash + 6;
            } else if (this.text.charAt(this.bp + matchFieldHash) == '1') {
                i = matchFieldHash + 1;
            } else if (this.text.charAt(this.bp + matchFieldHash) == '0') {
                i = matchFieldHash + 1;
            } else if (this.text.startsWith("\"1\"", this.bp + matchFieldHash)) {
                i = matchFieldHash + 3;
            } else if (this.text.startsWith("\"0\"", this.bp + matchFieldHash)) {
                i = matchFieldHash + 3;
            } else {
                this.matchStat = -1;
                return false;
            }
            z = true;
            int i5 = i + 1;
            i2 = this.bp + i;
            i3 = this.len;
            char c2 = EOI;
            if (i2 < i3) {
                c = EOI;
            } else {
                c = this.text.charAt(i2);
            }
            while (c != ',') {
                if (c != '}' && (c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == '\f' || c == '\b')) {
                    int i6 = i5 + 1;
                    int i7 = this.bp + i5;
                    if (i7 >= this.len) {
                        c = EOI;
                    } else {
                        c = this.text.charAt(i7);
                    }
                    i5 = i6;
                } else if (c == '}') {
                    int i8 = i5 + 1;
                    char charAt = charAt(this.bp + i5);
                    if (charAt == ',') {
                        this.token = 16;
                        int i9 = this.bp + (i8 - 1);
                        this.bp = i9;
                        int i10 = i9 + 1;
                        this.bp = i10;
                        if (i10 < this.len) {
                            c2 = this.text.charAt(i10);
                        }
                        this.ch = c2;
                    } else if (charAt == ']') {
                        this.token = 15;
                        int i11 = this.bp + (i8 - 1);
                        this.bp = i11;
                        int i12 = i11 + 1;
                        this.bp = i12;
                        if (i12 < this.len) {
                            c2 = this.text.charAt(i12);
                        }
                        this.ch = c2;
                    } else if (charAt == '}') {
                        this.token = 13;
                        int i13 = this.bp + (i8 - 1);
                        this.bp = i13;
                        int i14 = i13 + 1;
                        this.bp = i14;
                        if (i14 < this.len) {
                            c2 = this.text.charAt(i14);
                        }
                        this.ch = c2;
                    } else if (charAt == 26) {
                        this.token = 20;
                        this.bp += i8 - 1;
                        this.ch = EOI;
                    } else {
                        this.matchStat = -1;
                        return false;
                    }
                    this.matchStat = 4;
                    return z;
                } else {
                    this.matchStat = -1;
                    return false;
                }
            }
            int i15 = this.bp + (i5 - 1);
            this.bp = i15;
            i4 = i15 + 1;
            this.bp = i4;
            if (i4 < this.len) {
                c2 = this.text.charAt(i4);
            }
            this.ch = c2;
            this.matchStat = 3;
            this.token = 16;
            return z;
        }
        z = false;
        int i52 = i + 1;
        i2 = this.bp + i;
        i3 = this.len;
        char c22 = EOI;
        if (i2 < i3) {
        }
        while (c != ',') {
        }
        int i152 = this.bp + (i52 - 1);
        this.bp = i152;
        i4 = i152 + 1;
        this.bp = i4;
        if (i4 < this.len) {
        }
        this.ch = c22;
        this.matchStat = 3;
        this.token = 16;
        return z;
    }

    public Date scanFieldDate(long j) {
        char c;
        int i;
        char c2;
        Date date;
        int i2;
        char c3;
        char c4;
        this.matchStat = 0;
        int matchFieldHash = matchFieldHash(j);
        if (matchFieldHash == 0) {
            return null;
        }
        int i3 = this.bp;
        char c5 = this.ch;
        int i4 = matchFieldHash + 1;
        int i5 = matchFieldHash + i3;
        int i6 = this.len;
        char c6 = EOI;
        if (i5 >= i6) {
            c = EOI;
        } else {
            c = this.text.charAt(i5);
        }
        if (c == '\"') {
            int i7 = this.bp;
            int i8 = i7 + i4;
            int i9 = i4 + 1;
            int i10 = i7 + i4;
            if (i10 < this.len) {
                this.text.charAt(i10);
            }
            int indexOf = this.text.indexOf(34, this.bp + i9);
            if (indexOf != -1) {
                int i11 = indexOf - i8;
                this.bp = i8;
                if (scanISO8601DateIfMatch(false, i11)) {
                    date = this.calendar.getTime();
                    int i12 = i9 + i11;
                    i = i12 + 1;
                    c2 = charAt(i12 + i3);
                    this.bp = i3;
                } else {
                    this.bp = i3;
                    this.matchStat = -1;
                    return null;
                }
            } else {
                throw new JSONException("unclosed str");
            }
        } else if (c < '0' || c > '9') {
            this.matchStat = -1;
            return null;
        } else {
            long j2 = (long) (c - YKUpsConvert.CHAR_ZERO);
            while (true) {
                i2 = i4 + 1;
                int i13 = this.bp + i4;
                if (i13 >= this.len) {
                    c3 = EOI;
                } else {
                    c3 = this.text.charAt(i13);
                }
                if (c3 >= '0' && c3 <= '9') {
                    j2 = (j2 * 10) + ((long) (c3 - '0'));
                    i4 = i2;
                }
            }
            if (c3 == '.') {
                this.matchStat = -1;
                return null;
            }
            if (c3 == '\"') {
                int i14 = i2 + 1;
                int i15 = this.bp + i2;
                if (i15 >= this.len) {
                    c4 = EOI;
                } else {
                    c4 = this.text.charAt(i15);
                }
                c2 = c4;
                i = i14;
            } else {
                c2 = c3;
                i = i2;
            }
            if (j2 < 0) {
                this.matchStat = -1;
                return null;
            }
            date = new Date(j2);
        }
        if (c2 == ',') {
            int i16 = this.bp + (i - 1);
            this.bp = i16;
            int i17 = i16 + 1;
            this.bp = i17;
            if (i17 < this.len) {
                c6 = this.text.charAt(i17);
            }
            this.ch = c6;
            this.matchStat = 3;
            this.token = 16;
            return date;
        } else if (c2 == '}') {
            int i18 = i + 1;
            char charAt = charAt(this.bp + i);
            if (charAt == ',') {
                this.token = 16;
                int i19 = this.bp + (i18 - 1);
                this.bp = i19;
                int i20 = i19 + 1;
                this.bp = i20;
                if (i20 < this.len) {
                    c6 = this.text.charAt(i20);
                }
                this.ch = c6;
            } else if (charAt == ']') {
                this.token = 15;
                int i21 = this.bp + (i18 - 1);
                this.bp = i21;
                int i22 = i21 + 1;
                this.bp = i22;
                if (i22 < this.len) {
                    c6 = this.text.charAt(i22);
                }
                this.ch = c6;
            } else if (charAt == '}') {
                this.token = 13;
                int i23 = this.bp + (i18 - 1);
                this.bp = i23;
                int i24 = i23 + 1;
                this.bp = i24;
                if (i24 < this.len) {
                    c6 = this.text.charAt(i24);
                }
                this.ch = c6;
            } else if (charAt == 26) {
                this.token = 20;
                this.bp += i18 - 1;
                this.ch = EOI;
            } else {
                this.bp = i3;
                this.ch = c5;
                this.matchStat = -1;
                return null;
            }
            this.matchStat = 4;
            return date;
        } else {
            this.bp = i3;
            this.ch = c5;
            this.matchStat = -1;
            return null;
        }
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:57)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:15)
        */
    public final double scanFieldDouble(long r19) {
        /*
        // Method dump skipped, instructions count: 335
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexer.scanFieldDouble(long):double");
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:57)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:15)
        */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0128  */
    public final double[] scanFieldDoubleArray(long r20) {
        /*
        // Method dump skipped, instructions count: 543
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexer.scanFieldDoubleArray(long):double[]");
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:57)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:15)
        */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0139  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x013c  */
    public final double[][] scanFieldDoubleArray2(long r21) {
        /*
        // Method dump skipped, instructions count: 663
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexer.scanFieldDoubleArray2(long):double[][]");
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:57)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:15)
        */
    public final float scanFieldFloat(long r18) {
        /*
        // Method dump skipped, instructions count: 327
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexer.scanFieldFloat(long):float");
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:57)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:15)
        */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0128  */
    public final float[] scanFieldFloatArray(long r20) {
        /*
        // Method dump skipped, instructions count: 543
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexer.scanFieldFloatArray(long):float[]");
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:57)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:15)
        */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0139  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x013c  */
    public final float[][] scanFieldFloatArray2(long r21) {
        /*
        // Method dump skipped, instructions count: 663
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexer.scanFieldFloatArray2(long):float[][]");
    }

    public int scanFieldInt(long j) {
        char c;
        int i;
        char c2;
        char c3;
        char c4;
        this.matchStat = 0;
        int matchFieldHash = matchFieldHash(j);
        if (matchFieldHash == 0) {
            return 0;
        }
        int i2 = matchFieldHash + 1;
        int i3 = this.bp + matchFieldHash;
        int i4 = this.len;
        char c5 = EOI;
        if (i3 >= i4) {
            c = EOI;
        } else {
            c = this.text.charAt(i3);
        }
        boolean z = c == '\"';
        if (z) {
            int i5 = i2 + 1;
            int i6 = this.bp + i2;
            if (i6 >= this.len) {
                c = EOI;
            } else {
                c = this.text.charAt(i6);
            }
            i2 = i5;
            z = true;
        }
        boolean z2 = c == '-';
        if (z2) {
            int i7 = i2 + 1;
            int i8 = this.bp + i2;
            if (i8 >= this.len) {
                c = EOI;
            } else {
                c = this.text.charAt(i8);
            }
            i2 = i7;
        }
        if (c < '0' || c > '9') {
            this.matchStat = -1;
            return 0;
        }
        int i9 = c - YKUpsConvert.CHAR_ZERO;
        while (true) {
            i = i2 + 1;
            int i10 = this.bp + i2;
            if (i10 >= this.len) {
                c2 = EOI;
            } else {
                c2 = this.text.charAt(i10);
            }
            if (c2 >= '0' && c2 <= '9') {
                i9 = (i9 * 10) + (c2 - '0');
                i2 = i;
            }
        }
        if (c2 == '.') {
            this.matchStat = -1;
            return 0;
        }
        if (c2 == '\"') {
            if (!z) {
                this.matchStat = -1;
                return 0;
            }
            int i11 = i + 1;
            int i12 = this.bp + i;
            if (i12 >= this.len) {
                c4 = EOI;
            } else {
                c4 = this.text.charAt(i12);
            }
            i = i11;
            c2 = c4;
        }
        if (i9 < 0) {
            this.matchStat = -1;
            return 0;
        }
        while (c2 != ',') {
            if (c2 <= ' ' && (c2 == ' ' || c2 == '\n' || c2 == '\r' || c2 == '\t' || c2 == '\f' || c2 == '\b')) {
                int i13 = i + 1;
                int i14 = this.bp + i;
                if (i14 >= this.len) {
                    c3 = EOI;
                } else {
                    c3 = this.text.charAt(i14);
                }
                i = i13;
                c2 = c3;
            } else if (c2 == '}') {
                int i15 = i + 1;
                char charAt = charAt(this.bp + i);
                if (charAt == ',') {
                    this.token = 16;
                    int i16 = this.bp + (i15 - 1);
                    this.bp = i16;
                    int i17 = i16 + 1;
                    this.bp = i17;
                    if (i17 < this.len) {
                        c5 = this.text.charAt(i17);
                    }
                    this.ch = c5;
                } else if (charAt == ']') {
                    this.token = 15;
                    int i18 = this.bp + (i15 - 1);
                    this.bp = i18;
                    int i19 = i18 + 1;
                    this.bp = i19;
                    if (i19 < this.len) {
                        c5 = this.text.charAt(i19);
                    }
                    this.ch = c5;
                } else if (charAt == '}') {
                    this.token = 13;
                    int i20 = this.bp + (i15 - 1);
                    this.bp = i20;
                    int i21 = i20 + 1;
                    this.bp = i21;
                    if (i21 < this.len) {
                        c5 = this.text.charAt(i21);
                    }
                    this.ch = c5;
                } else if (charAt == 26) {
                    this.token = 20;
                    this.bp += i15 - 1;
                    this.ch = EOI;
                } else {
                    this.matchStat = -1;
                    return 0;
                }
                this.matchStat = 4;
                return z2 ? -i9 : i9;
            } else {
                this.matchStat = -1;
                return 0;
            }
        }
        int i22 = this.bp + (i - 1);
        this.bp = i22;
        int i23 = i22 + 1;
        this.bp = i23;
        if (i23 < this.len) {
            c5 = this.text.charAt(i23);
        }
        this.ch = c5;
        this.matchStat = 3;
        this.token = 16;
        return z2 ? -i9 : i9;
    }

    public final int[] scanFieldIntArray(long j) {
        char c;
        char c2;
        int i;
        int i2;
        char c3;
        boolean z;
        int[] iArr;
        int i3;
        int i4;
        char c4;
        int[] iArr2;
        char c5;
        this.matchStat = 0;
        int matchFieldHash = matchFieldHash(j);
        int[] iArr3 = null;
        if (matchFieldHash == 0) {
            return null;
        }
        int i5 = matchFieldHash + 1;
        int i6 = this.bp + matchFieldHash;
        if (i6 >= this.len) {
            c = EOI;
        } else {
            c = this.text.charAt(i6);
        }
        if (c != '[') {
            this.matchStat = -1;
            return null;
        }
        int i7 = i5 + 1;
        int i8 = this.bp + i5;
        if (i8 >= this.len) {
            c2 = EOI;
        } else {
            c2 = this.text.charAt(i8);
        }
        int[] iArr4 = new int[16];
        if (c2 == ']') {
            i = i7 + 1;
            int i9 = this.bp + i7;
            if (i9 >= this.len) {
                c3 = EOI;
            } else {
                c3 = this.text.charAt(i9);
            }
            i2 = 0;
        } else {
            int i10 = 0;
            while (true) {
                if (c2 == '-') {
                    int i11 = i7 + 1;
                    int i12 = this.bp + i7;
                    if (i12 >= this.len) {
                        c2 = EOI;
                    } else {
                        c2 = this.text.charAt(i12);
                    }
                    i7 = i11;
                    z = true;
                } else {
                    z = false;
                }
                if (c2 >= '0') {
                    if (c2 > '9') {
                        i3 = -1;
                        iArr = null;
                        break;
                    }
                    int i13 = c2 - '0';
                    while (true) {
                        i4 = i7 + 1;
                        int i14 = this.bp + i7;
                        if (i14 >= this.len) {
                            c4 = EOI;
                        } else {
                            c4 = this.text.charAt(i14);
                        }
                        if (c4 >= '0' && c4 <= '9') {
                            i13 = (i13 * 10) + (c4 - '0');
                            i7 = i4;
                        }
                    }
                    if (i10 >= iArr4.length) {
                        int[] iArr5 = new int[((iArr4.length * 3) / 2)];
                        System.arraycopy(iArr4, 0, iArr5, 0, i10);
                        iArr4 = iArr5;
                    }
                    i2 = i10 + 1;
                    if (z) {
                        i13 = -i13;
                    }
                    iArr4[i10] = i13;
                    if (c4 == ',') {
                        int i15 = i4 + 1;
                        int i16 = this.bp + i4;
                        if (i16 >= this.len) {
                            c5 = EOI;
                        } else {
                            c5 = this.text.charAt(i16);
                        }
                        i4 = i15;
                        iArr2 = null;
                        c4 = c5;
                    } else if (c4 == ']') {
                        i = i4 + 1;
                        int i17 = this.bp + i4;
                        if (i17 >= this.len) {
                            c3 = EOI;
                        } else {
                            c3 = this.text.charAt(i17);
                        }
                    } else {
                        iArr2 = null;
                    }
                    i10 = i2;
                    c2 = c4;
                    iArr3 = iArr2;
                    i7 = i4;
                } else {
                    iArr = iArr3;
                    i3 = -1;
                    break;
                }
            }
            this.matchStat = i3;
            return iArr;
        }
        if (i2 != iArr4.length) {
            int[] iArr6 = new int[i2];
            System.arraycopy(iArr4, 0, iArr6, 0, i2);
            iArr4 = iArr6;
        }
        if (c3 == ',') {
            this.bp += i - 1;
            next();
            this.matchStat = 3;
            this.token = 16;
            return iArr4;
        } else if (c3 == '}') {
            int i18 = i + 1;
            char charAt = charAt(this.bp + i);
            if (charAt == ',') {
                this.token = 16;
                this.bp += i18 - 1;
                next();
            } else if (charAt == ']') {
                this.token = 15;
                this.bp += i18 - 1;
                next();
            } else if (charAt == '}') {
                this.token = 13;
                this.bp += i18 - 1;
                next();
            } else if (charAt == 26) {
                this.bp += i18 - 1;
                this.token = 20;
                this.ch = EOI;
            } else {
                this.matchStat = -1;
                return null;
            }
            this.matchStat = 4;
            return iArr4;
        } else {
            this.matchStat = -1;
            return null;
        }
    }

    public long scanFieldLong(long j) {
        char c;
        int i;
        char c2;
        char c3;
        char c4;
        char c5;
        char c6;
        boolean z = false;
        this.matchStat = 0;
        int matchFieldHash = matchFieldHash(j);
        if (matchFieldHash == 0) {
            return 0;
        }
        int i2 = matchFieldHash + 1;
        int i3 = this.bp + matchFieldHash;
        if (i3 >= this.len) {
            c = EOI;
        } else {
            c = this.text.charAt(i3);
        }
        boolean z2 = c == '\"';
        if (z2) {
            int i4 = i2 + 1;
            int i5 = this.bp + i2;
            if (i5 >= this.len) {
                c = EOI;
            } else {
                c = this.text.charAt(i5);
            }
            i2 = i4;
        }
        if (c == '-') {
            z = true;
        }
        if (z) {
            int i6 = i2 + 1;
            int i7 = this.bp + i2;
            if (i7 >= this.len) {
                c = EOI;
            } else {
                c = this.text.charAt(i7);
            }
            i2 = i6;
        }
        if (c < '0' || c > '9') {
            this.matchStat = -1;
            return 0;
        }
        long j2 = (long) (c - YKUpsConvert.CHAR_ZERO);
        while (true) {
            i = i2 + 1;
            int i8 = this.bp + i2;
            if (i8 >= this.len) {
                c2 = EOI;
            } else {
                c2 = this.text.charAt(i8);
            }
            if (c2 >= '0' && c2 <= '9') {
                j2 = (j2 * 10) + ((long) (c2 - '0'));
                i2 = i;
            }
        }
        if (c2 == '.') {
            this.matchStat = -1;
            return 0;
        }
        if (c2 == '\"') {
            if (!z2) {
                this.matchStat = -1;
                return 0;
            }
            int i9 = i + 1;
            int i10 = this.bp + i;
            if (i10 >= this.len) {
                c2 = EOI;
            } else {
                c2 = this.text.charAt(i10);
            }
            i = i9;
        }
        if (j2 < 0) {
            this.matchStat = -1;
            return 0;
        } else if (c2 == ',') {
            int i11 = this.bp + (i - 1);
            this.bp = i11;
            int i12 = i11 + 1;
            this.bp = i12;
            if (i12 >= this.len) {
                c6 = EOI;
            } else {
                c6 = this.text.charAt(i12);
            }
            this.ch = c6;
            this.matchStat = 3;
            this.token = 16;
            return z ? -j2 : j2;
        } else if (c2 == '}') {
            int i13 = i + 1;
            char charAt = charAt(this.bp + i);
            if (charAt == ',') {
                this.token = 16;
                int i14 = this.bp + (i13 - 1);
                this.bp = i14;
                int i15 = i14 + 1;
                this.bp = i15;
                if (i15 >= this.len) {
                    c5 = EOI;
                } else {
                    c5 = this.text.charAt(i15);
                }
                this.ch = c5;
            } else if (charAt == ']') {
                this.token = 15;
                int i16 = this.bp + (i13 - 1);
                this.bp = i16;
                int i17 = i16 + 1;
                this.bp = i17;
                if (i17 >= this.len) {
                    c4 = EOI;
                } else {
                    c4 = this.text.charAt(i17);
                }
                this.ch = c4;
            } else if (charAt == '}') {
                this.token = 13;
                int i18 = this.bp + (i13 - 1);
                this.bp = i18;
                int i19 = i18 + 1;
                this.bp = i19;
                if (i19 >= this.len) {
                    c3 = EOI;
                } else {
                    c3 = this.text.charAt(i19);
                }
                this.ch = c3;
            } else if (charAt == 26) {
                this.token = 20;
                this.bp += i13 - 1;
                this.ch = EOI;
            } else {
                this.matchStat = -1;
                return 0;
            }
            this.matchStat = 4;
            return z ? -j2 : j2;
        } else {
            this.matchStat = -1;
            return 0;
        }
    }

    public String scanFieldString(long j) {
        String str;
        char c;
        char c2;
        this.matchStat = 0;
        int matchFieldHash = matchFieldHash(j);
        if (matchFieldHash == 0) {
            return null;
        }
        int i = matchFieldHash + 1;
        int i2 = this.bp + matchFieldHash;
        if (i2 >= this.len) {
            throw new JSONException("unclosed str, " + info());
        } else if (this.text.charAt(i2) != '\"') {
            this.matchStat = -1;
            return this.stringDefaultValue;
        } else {
            int i3 = this.bp + i;
            int indexOf = this.text.indexOf(34, i3);
            if (indexOf != -1) {
                if (V6) {
                    str = this.text.substring(i3, indexOf);
                } else {
                    int i4 = indexOf - i3;
                    str = new String(sub_chars(this.bp + i, i4), 0, i4);
                }
                if (str.indexOf(92) != -1) {
                    boolean z = false;
                    while (true) {
                        int i5 = indexOf - 1;
                        int i6 = 0;
                        while (i5 >= 0 && this.text.charAt(i5) == '\\') {
                            i6++;
                            i5--;
                            z = true;
                        }
                        if (i6 % 2 == 0) {
                            break;
                        }
                        indexOf = this.text.indexOf(34, indexOf + 1);
                    }
                    int i7 = indexOf - i3;
                    char[] sub_chars = sub_chars(this.bp + i, i7);
                    if (z) {
                        str = readString(sub_chars, i7);
                    } else {
                        str = new String(sub_chars, 0, i7);
                        if (str.indexOf(92) != -1) {
                            str = readString(sub_chars, i7);
                        }
                    }
                }
                int i8 = indexOf + 1;
                int i9 = this.len;
                char c3 = EOI;
                if (i8 >= i9) {
                    c = EOI;
                } else {
                    c = this.text.charAt(i8);
                }
                if (c == ',') {
                    this.bp = i8;
                    int i10 = i8 + 1;
                    this.bp = i10;
                    if (i10 < this.len) {
                        c3 = this.text.charAt(i10);
                    }
                    this.ch = c3;
                    this.matchStat = 3;
                    this.token = 16;
                    return str;
                } else if (c == '}') {
                    int i11 = i8 + 1;
                    if (i11 >= this.len) {
                        c2 = EOI;
                    } else {
                        c2 = this.text.charAt(i11);
                    }
                    if (c2 == ',') {
                        this.token = 16;
                        this.bp = i11;
                        next();
                    } else if (c2 == ']') {
                        this.token = 15;
                        this.bp = i11;
                        next();
                    } else if (c2 == '}') {
                        this.token = 13;
                        this.bp = i11;
                        next();
                    } else if (c2 == 26) {
                        this.token = 20;
                        this.bp = i11;
                        this.ch = EOI;
                    } else {
                        this.matchStat = -1;
                        return this.stringDefaultValue;
                    }
                    this.matchStat = 4;
                    return str;
                } else {
                    this.matchStat = -1;
                    return this.stringDefaultValue;
                }
            } else {
                throw new JSONException("unclosed str, " + info());
            }
        }
    }

    public long scanFieldSymbol(long j) {
        char c;
        char c2;
        char c3;
        char c4;
        this.matchStat = 0;
        int matchFieldHash = matchFieldHash(j);
        if (matchFieldHash == 0) {
            return 0;
        }
        int i = matchFieldHash + 1;
        int i2 = this.bp + matchFieldHash;
        int i3 = this.len;
        char c5 = EOI;
        if (i2 >= i3) {
            c = EOI;
        } else {
            c = this.text.charAt(i2);
        }
        if (c != '\"') {
            this.matchStat = -1;
            return 0;
        }
        long j2 = -3750763034362895579L;
        while (true) {
            int i4 = i + 1;
            int i5 = this.bp + i;
            if (i5 >= this.len) {
                c2 = EOI;
            } else {
                c2 = this.text.charAt(i5);
            }
            if (c2 == '\"') {
                int i6 = i4 + 1;
                int i7 = this.bp + i4;
                if (i7 >= this.len) {
                    c3 = EOI;
                } else {
                    c3 = this.text.charAt(i7);
                }
                if (c3 == ',') {
                    int i8 = this.bp + (i6 - 1);
                    this.bp = i8;
                    int i9 = i8 + 1;
                    this.bp = i9;
                    if (i9 < this.len) {
                        c5 = this.text.charAt(i9);
                    }
                    this.ch = c5;
                    this.matchStat = 3;
                    return j2;
                } else if (c3 == '}') {
                    int i10 = i6 + 1;
                    int i11 = this.bp + i6;
                    if (i11 >= this.len) {
                        c4 = EOI;
                    } else {
                        c4 = this.text.charAt(i11);
                    }
                    if (c4 == ',') {
                        this.token = 16;
                        this.bp += i10 - 1;
                        next();
                    } else if (c4 == ']') {
                        this.token = 15;
                        this.bp += i10 - 1;
                        next();
                    } else if (c4 == '}') {
                        this.token = 13;
                        this.bp += i10 - 1;
                        next();
                    } else if (c4 == 26) {
                        this.token = 20;
                        this.bp += i10 - 1;
                        this.ch = EOI;
                    } else {
                        this.matchStat = -1;
                        return 0;
                    }
                    this.matchStat = 4;
                    return j2;
                } else {
                    this.matchStat = -1;
                    return 0;
                }
            } else {
                j2 = (j2 ^ ((long) c2)) * 1099511628211L;
                if (c2 == '\\') {
                    this.matchStat = -1;
                    return 0;
                }
                i = i4;
            }
        }
    }

    public boolean scanISO8601DateIfMatch(boolean z) {
        return scanISO8601DateIfMatch(z, this.len - this.bp);
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    public final long scanLongValue() {
        long j;
        char c;
        boolean z = false;
        this.np = 0;
        if (this.ch == '-') {
            this.np = 0 + 1;
            int i = this.bp + 1;
            this.bp = i;
            if (i < this.len) {
                this.ch = this.text.charAt(i);
                j = Long.MIN_VALUE;
                z = true;
            } else {
                throw new JSONException("syntax error, " + info());
            }
        } else {
            j = -9223372036854775807L;
        }
        long j2 = 0;
        while (true) {
            char c2 = this.ch;
            if (c2 < '0' || c2 > '9') {
                return z ? -j2 : j2;
            }
            int i2 = c2 - '0';
            if (j2 >= -922337203685477580L) {
                long j3 = j2 * 10;
                long j4 = (long) i2;
                if (j3 >= j + j4) {
                    j2 = j3 - j4;
                    this.np++;
                    int i3 = this.bp + 1;
                    this.bp = i3;
                    if (i3 >= this.len) {
                        c = EOI;
                    } else {
                        c = this.text.charAt(i3);
                    }
                    this.ch = c;
                } else {
                    throw new JSONException("error long value, " + j3 + AVFSCacheConstants.COMMA_SEP + info());
                }
            } else {
                throw new JSONException("error long value, " + j2 + AVFSCacheConstants.COMMA_SEP + info());
            }
        }
        if (z) {
        }
    }

    public final void scanNumber() {
        char c;
        char c2;
        char c3;
        char c4;
        char c5;
        char c6;
        char c7;
        char c8;
        int i = this.bp;
        this.np = i;
        this.exp = false;
        if (this.ch == '-') {
            this.sp++;
            int i2 = i + 1;
            this.bp = i2;
            if (i2 >= this.len) {
                c8 = EOI;
            } else {
                c8 = this.text.charAt(i2);
            }
            this.ch = c8;
        }
        while (true) {
            c = this.ch;
            if (c < '0' || c > '9') {
                this.isDouble = false;
            } else {
                this.sp++;
                int i3 = this.bp + 1;
                this.bp = i3;
                if (i3 >= this.len) {
                    c7 = EOI;
                } else {
                    c7 = this.text.charAt(i3);
                }
                this.ch = c7;
            }
        }
        this.isDouble = false;
        if (c == '.') {
            this.sp++;
            int i4 = this.bp + 1;
            this.bp = i4;
            if (i4 >= this.len) {
                c5 = EOI;
            } else {
                c5 = this.text.charAt(i4);
            }
            this.ch = c5;
            this.isDouble = true;
            while (true) {
                char c9 = this.ch;
                if (c9 < '0' || c9 > '9') {
                    break;
                }
                this.sp++;
                int i5 = this.bp + 1;
                this.bp = i5;
                if (i5 >= this.len) {
                    c6 = EOI;
                } else {
                    c6 = this.text.charAt(i5);
                }
                this.ch = c6;
            }
        }
        char c10 = this.ch;
        if (c10 == 'L') {
            this.sp++;
            next();
        } else if (c10 == 'S') {
            this.sp++;
            next();
        } else if (c10 == 'B') {
            this.sp++;
            next();
        } else if (c10 == 'F') {
            this.sp++;
            next();
            this.isDouble = true;
        } else if (c10 == 'D') {
            this.sp++;
            next();
            this.isDouble = true;
        } else if (c10 == 'e' || c10 == 'E') {
            this.sp++;
            int i6 = this.bp + 1;
            this.bp = i6;
            if (i6 >= this.len) {
                c2 = EOI;
            } else {
                c2 = this.text.charAt(i6);
            }
            this.ch = c2;
            if (c2 == '+' || c2 == '-') {
                this.sp++;
                int i7 = this.bp + 1;
                this.bp = i7;
                if (i7 >= this.len) {
                    c4 = EOI;
                } else {
                    c4 = this.text.charAt(i7);
                }
                this.ch = c4;
            }
            while (true) {
                char c11 = this.ch;
                if (c11 >= '0' && c11 <= '9') {
                    this.sp++;
                    int i8 = this.bp + 1;
                    this.bp = i8;
                    if (i8 >= this.len) {
                        c3 = EOI;
                    } else {
                        c3 = this.text.charAt(i8);
                    }
                    this.ch = c3;
                } else if (c11 == 'D' || c11 == 'F') {
                    this.sp++;
                    next();
                }
            }
            this.sp++;
            next();
            this.exp = true;
            this.isDouble = true;
        }
        if (this.isDouble) {
            this.token = 3;
        } else {
            this.token = 2;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:145:0x0273 A[Catch:{ NumberFormatException -> 0x02b5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x0289 A[Catch:{ NumberFormatException -> 0x02b5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x0294 A[Catch:{ NumberFormatException -> 0x02b5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00e8  */
    public final Number scanNumberValue() {
        long j;
        boolean z;
        char c;
        int i;
        char c2;
        int i2;
        boolean z2;
        char c3;
        boolean z3;
        char[] cArr;
        int i3;
        int i4;
        int i5;
        char[] cArr2;
        char c4;
        char c5;
        char c6;
        char c7;
        long j2;
        long j3;
        char c8;
        long j4;
        long j5;
        char c9;
        char c10;
        int i6 = this.bp;
        this.np = 0;
        if (this.ch == '-') {
            j = Long.MIN_VALUE;
            this.np = 0 + 1;
            int i7 = i6 + 1;
            this.bp = i7;
            if (i7 >= this.len) {
                c10 = EOI;
            } else {
                c10 = this.text.charAt(i7);
            }
            this.ch = c10;
            z = true;
        } else {
            j = -9223372036854775807L;
            z = false;
        }
        long j6 = 0;
        int i8 = 1;
        boolean z4 = false;
        while (true) {
            c = this.ch;
            i = 18;
            c2 = YKUpsConvert.CHAR_ZERO;
            if (c < '0' || c > '9') {
                BigInteger bigInteger = null;
            } else {
                int i9 = c - '0';
                if (i8 < 18) {
                    j4 = j6 * 10;
                    j5 = (long) i9;
                } else {
                    if (j6 < -922337203685477580L) {
                        z4 = true;
                    }
                    j4 = j6 * 10;
                    j5 = (long) i9;
                    if (j4 < j + j5) {
                        z4 = true;
                    }
                }
                j6 = j4 - j5;
                this.np++;
                int i10 = this.bp + 1;
                this.bp = i10;
                if (i10 >= this.len) {
                    c9 = EOI;
                } else {
                    c9 = this.text.charAt(i10);
                }
                this.ch = c9;
                i8++;
            }
        }
        BigInteger bigInteger2 = null;
        if (c == '.') {
            this.np++;
            int i11 = this.bp + 1;
            this.bp = i11;
            if (i11 >= this.len) {
                c7 = EOI;
            } else {
                c7 = this.text.charAt(i11);
            }
            this.ch = c7;
            i2 = 0;
            while (true) {
                char c11 = this.ch;
                if (c11 >= c2 && c11 <= '9') {
                    i2++;
                    int i12 = c11 - '0';
                    if (i8 < i) {
                        j2 = j6 * 10;
                        j3 = (long) i12;
                    } else {
                        if (j6 < -922337203685477580L) {
                            z4 = true;
                        }
                        j2 = j6 * 10;
                        j3 = (long) i12;
                        if (j2 < j + j3) {
                            z4 = true;
                        }
                    }
                    j6 = j2 - j3;
                    this.np++;
                    int i13 = this.bp + 1;
                    this.bp = i13;
                    if (i13 >= this.len) {
                        c8 = EOI;
                    } else {
                        c8 = this.text.charAt(i13);
                    }
                    this.ch = c8;
                    i8++;
                    c2 = YKUpsConvert.CHAR_ZERO;
                    i = 18;
                } else if (!z) {
                    j6 = -j6;
                }
            }
            if (!z) {
            }
            z2 = true;
        } else {
            if (!z) {
                j6 = -j6;
            }
            if (c == 'L') {
                this.np++;
                next();
                bigInteger2 = Long.valueOf(j6);
            } else if (c == 'S') {
                this.np++;
                next();
                bigInteger2 = Short.valueOf((short) ((int) j6));
            } else if (c == 'B') {
                this.np++;
                next();
                bigInteger2 = Byte.valueOf((byte) ((int) j6));
            } else if (c == 'F') {
                this.np++;
                next();
                bigInteger2 = Float.valueOf((float) j6);
            } else if (c == 'D') {
                this.np++;
                next();
                bigInteger2 = Double.valueOf((double) j6);
            }
            z2 = false;
            i2 = 0;
        }
        char c12 = this.ch;
        if (c12 == 'e' || c12 == 'E') {
            this.np++;
            int i14 = this.bp + 1;
            this.bp = i14;
            if (i14 >= this.len) {
                c4 = EOI;
            } else {
                c4 = this.text.charAt(i14);
            }
            this.ch = c4;
            if (c4 == '+' || c4 == '-') {
                this.np++;
                int i15 = this.bp + 1;
                this.bp = i15;
                if (i15 >= this.len) {
                    c6 = EOI;
                } else {
                    c6 = this.text.charAt(i15);
                }
                this.ch = c6;
            }
            while (true) {
                c3 = this.ch;
                if (c3 >= '0' && c3 <= '9') {
                    this.np++;
                    int i16 = this.bp + 1;
                    this.bp = i16;
                    if (i16 >= this.len) {
                        c5 = EOI;
                    } else {
                        c5 = this.text.charAt(i16);
                    }
                    this.ch = c5;
                }
            }
            if (c3 == 'D' || c3 == 'F') {
                this.np++;
                next();
            } else {
                c3 = 0;
            }
            z3 = true;
        } else {
            z3 = false;
            c3 = 0;
        }
        if (z2 || z3) {
            int i17 = this.bp - i6;
            if (c3 != 0) {
                i17--;
            }
            if (z3 || (this.features & Feature.UseBigDecimal.mask) == 0) {
                char[] cArr3 = this.sbuf;
                if (i17 < cArr3.length) {
                    this.text.getChars(i6, i6 + i17, cArr3, 0);
                    cArr = this.sbuf;
                } else {
                    char[] cArr4 = new char[i17];
                    this.text.getChars(i6, i6 + i17, cArr4, 0);
                    cArr = cArr4;
                }
                if (i17 > 9 || z3) {
                    String str = new String(cArr, 0, i17);
                    if (c3 == 'F') {
                        return Float.valueOf(str);
                    }
                    return Double.valueOf(Double.parseDouble(str));
                }
                try {
                    char c13 = cArr[0];
                    if (c13 != '-') {
                        if (c13 != '+') {
                            i3 = 1;
                            int i18 = c13 - YKUpsConvert.CHAR_ZERO;
                            int i19 = 0;
                            for (i4 = i3; i4 < i17; i4++) {
                                char c14 = cArr[i4];
                                if (c14 == '.') {
                                    i19 = 1;
                                } else {
                                    i18 = (i18 * 10) + (c14 - '0');
                                    if (i19 != 0) {
                                        i19 *= 10;
                                    }
                                }
                            }
                            if (c3 != 'F') {
                                float f = ((float) i18) / ((float) i19);
                                if (z) {
                                    f = -f;
                                }
                                return Float.valueOf(f);
                            }
                            double d = ((double) i18) / ((double) i19);
                            if (z) {
                                d = -d;
                            }
                            return Double.valueOf(d);
                        }
                    }
                    c13 = cArr[1];
                    i3 = 2;
                    int i182 = c13 - YKUpsConvert.CHAR_ZERO;
                    int i192 = 0;
                    while (i4 < i17) {
                    }
                    if (c3 != 'F') {
                    }
                } catch (NumberFormatException e) {
                    throw new JSONException(e.getMessage() + AVFSCacheConstants.COMMA_SEP + info(), e);
                }
            } else if (!z4) {
                return BigDecimal.valueOf(j6, i2);
            } else {
                char[] cArr5 = this.sbuf;
                if (i17 < cArr5.length) {
                    i5 = 0;
                    this.text.getChars(i6, i6 + i17, cArr5, 0);
                    cArr2 = this.sbuf;
                } else {
                    i5 = 0;
                    char[] cArr6 = new char[i17];
                    this.text.getChars(i6, i6 + i17, cArr6, 0);
                    cArr2 = cArr6;
                }
                return new BigDecimal(cArr2, i5, i17);
            }
        } else {
            if (z4) {
                int i20 = this.bp;
                char[] cArr7 = new char[(i20 - i6)];
                this.text.getChars(i6, i20, cArr7, 0);
                bigInteger2 = new BigInteger(new String(cArr7));
            }
            if (bigInteger2 != null) {
                return bigInteger2;
            }
            if (j6 <= -2147483648L || j6 >= 2147483647L) {
                return Long.valueOf(j6);
            }
            return Integer.valueOf((int) j6);
        }
    }

    public final void scanString() {
        char c;
        char c2 = this.ch;
        int i = this.bp + 1;
        int indexOf = this.text.indexOf(c2, i);
        if (indexOf != -1) {
            int i2 = indexOf - i;
            char[] sub_chars = sub_chars(this.bp + 1, i2);
            boolean z = false;
            while (i2 > 0 && sub_chars[i2 - 1] == '\\') {
                int i3 = i2 - 2;
                int i4 = 1;
                while (i3 >= 0 && sub_chars[i3] == '\\') {
                    i4++;
                    i3--;
                }
                if (i4 % 2 == 0) {
                    break;
                }
                int indexOf2 = this.text.indexOf(c2, indexOf + 1);
                int i5 = (indexOf2 - indexOf) + i2;
                if (i5 >= sub_chars.length) {
                    int length = (sub_chars.length * 3) / 2;
                    if (length < i5) {
                        length = i5;
                    }
                    char[] cArr = new char[length];
                    System.arraycopy(sub_chars, 0, cArr, 0, sub_chars.length);
                    sub_chars = cArr;
                }
                this.text.getChars(indexOf, indexOf2, sub_chars, i2);
                indexOf = indexOf2;
                i2 = i5;
                z = true;
            }
            if (!z) {
                for (int i6 = 0; i6 < i2; i6++) {
                    if (sub_chars[i6] == '\\') {
                        z = true;
                    }
                }
            }
            this.sbuf = sub_chars;
            this.sp = i2;
            this.np = this.bp;
            this.hasSpecial = z;
            int i7 = indexOf + 1;
            this.bp = i7;
            if (i7 >= this.len) {
                c = EOI;
            } else {
                c = this.text.charAt(i7);
            }
            this.ch = c;
            this.token = 4;
            return;
        }
        throw new JSONException("unclosed str, " + info());
    }

    public String scanStringValue(char c) {
        String str;
        char c2;
        int i = this.bp + 1;
        int indexOf = this.text.indexOf(c, i);
        if (indexOf != -1) {
            if (V6) {
                str = this.text.substring(i, indexOf);
            } else {
                int i2 = indexOf - i;
                str = new String(sub_chars(this.bp + 1, i2), 0, i2);
            }
            if (str.indexOf(92) != -1) {
                while (true) {
                    int i3 = indexOf - 1;
                    int i4 = 0;
                    while (i3 >= 0 && this.text.charAt(i3) == '\\') {
                        i4++;
                        i3--;
                    }
                    if (i4 % 2 == 0) {
                        break;
                    }
                    indexOf = this.text.indexOf(c, indexOf + 1);
                }
                int i5 = indexOf - i;
                str = readString(sub_chars(this.bp + 1, i5), i5);
            }
            int i6 = indexOf + 1;
            this.bp = i6;
            if (i6 >= this.len) {
                c2 = EOI;
            } else {
                c2 = this.text.charAt(i6);
            }
            this.ch = c2;
            return str;
        }
        throw new JSONException("unclosed str, " + info());
    }

    public final String scanSymbol(SymbolTable symbolTable) {
        char c;
        while (true) {
            c = this.ch;
            if (c != ' ' && c != '\n' && c != '\r' && c != '\t' && c != '\f' && c != '\b') {
                break;
            }
            next();
        }
        if (c == '\"') {
            return scanSymbol(symbolTable, jl1.QUOTE);
        }
        if (c == '\'') {
            return scanSymbol(symbolTable, '\'');
        }
        if (c == '}') {
            next();
            this.token = 13;
            return null;
        } else if (c == ',') {
            next();
            this.token = 16;
            return null;
        } else if (c != 26) {
            return scanSymbolUnQuoted(symbolTable);
        } else {
            this.token = 20;
            return null;
        }
    }

    public final String scanSymbolUnQuoted(SymbolTable symbolTable) {
        int i = this.ch;
        boolean[] zArr = firstIdentifierFlags;
        if (i >= zArr.length || zArr[i]) {
            this.np = this.bp;
            this.sp = 1;
            while (true) {
                char next = next();
                boolean[] zArr2 = identifierFlags;
                if (next < zArr2.length && !zArr2[next]) {
                    break;
                }
                i = (i * 31) + next;
                this.sp++;
            }
            this.ch = charAt(this.bp);
            this.token = 18;
            if (this.sp != 4 || !this.text.startsWith("null", this.np)) {
                return symbolTable.addSymbol(this.text, this.np, this.sp, i);
            }
            return null;
        }
        throw new JSONException("illegal identifier : " + this.ch + AVFSCacheConstants.COMMA_SEP + info());
    }

    /* access modifiers changed from: protected */
    public void setTime(char c, char c2, char c3, char c4, char c5, char c6) {
        this.calendar.set(11, ((c - '0') * 10) + (c2 - '0'));
        this.calendar.set(12, ((c3 - '0') * 10) + (c4 - '0'));
        this.calendar.set(13, ((c5 - '0') * 10) + (c6 - '0'));
    }

    /* access modifiers changed from: protected */
    public void setTimeZone(char c, char c2, char c3) {
        int i = (((c2 - '0') * 10) + (c3 - '0')) * ACache.TIME_HOUR * 1000;
        if (c == '-') {
            i = -i;
        }
        if (this.calendar.getTimeZone().getRawOffset() != i) {
            String[] availableIDs = TimeZone.getAvailableIDs(i);
            if (availableIDs.length > 0) {
                this.calendar.setTimeZone(TimeZone.getTimeZone(availableIDs[0]));
            }
        }
    }

    /* access modifiers changed from: protected */
    public void skipComment() {
        next();
        char c = this.ch;
        if (c == '/') {
            do {
                next();
            } while (this.ch != '\n');
            next();
        } else if (c == '*') {
            next();
            while (true) {
                char c2 = this.ch;
                if (c2 == 26) {
                    return;
                }
                if (c2 == '*') {
                    next();
                    if (this.ch == '/') {
                        next();
                        return;
                    }
                } else {
                    next();
                }
            }
        } else {
            throw new JSONException("invalid comment");
        }
    }

    /* access modifiers changed from: package-private */
    public final void skipWhitespace() {
        while (true) {
            char c = this.ch;
            if (c > '/') {
                return;
            }
            if (c == ' ' || c == '\r' || c == '\n' || c == '\t' || c == '\f' || c == '\b') {
                next();
            } else if (c == '/') {
                skipComment();
            } else {
                return;
            }
        }
    }

    public final String stringVal() {
        if (this.hasSpecial) {
            return readString(this.sbuf, this.sp);
        }
        return subString(this.np + 1, this.sp);
    }

    /* access modifiers changed from: package-private */
    public final char[] sub_chars(int i, int i2) {
        char[] cArr = this.sbuf;
        if (i2 < cArr.length) {
            this.text.getChars(i, i2 + i, cArr, 0);
            return this.sbuf;
        }
        char[] cArr2 = new char[i2];
        this.sbuf = cArr2;
        this.text.getChars(i, i2 + i, cArr2, 0);
        return cArr2;
    }

    public final int token() {
        return this.token;
    }

    public JSONLexer(char[] cArr, int i) {
        this(cArr, i, JSON.DEFAULT_PARSER_FEATURE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:101:0x01f8 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x01fb  */
    public boolean scanISO8601DateIfMatch(boolean z, int i) {
        char c;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        char c2;
        int i7;
        char c3;
        char charAt;
        int i8;
        int i9;
        char charAt2;
        int i10;
        char charAt3;
        char charAt4;
        char charAt5;
        if (!z && i > 13) {
            char charAt6 = charAt(this.bp);
            char charAt7 = charAt(this.bp + 1);
            char charAt8 = charAt(this.bp + 2);
            char charAt9 = charAt(this.bp + 3);
            char charAt10 = charAt(this.bp + 4);
            char charAt11 = charAt(this.bp + 5);
            char charAt12 = charAt((this.bp + i) - 1);
            char charAt13 = charAt((this.bp + i) - 2);
            if (charAt6 == '/' && charAt7 == 'D' && charAt8 == 'a' && charAt9 == 't' && charAt10 == 'e' && charAt11 == '(' && charAt12 == '/' && charAt13 == ')') {
                int i11 = -1;
                for (int i12 = 6; i12 < i; i12++) {
                    char charAt14 = charAt(this.bp + i12);
                    if (charAt14 != '+') {
                        if (charAt14 < '0' || charAt14 > '9') {
                            break;
                        }
                    } else {
                        i11 = i12;
                    }
                }
                if (i11 == -1) {
                    return false;
                }
                int i13 = this.bp + 6;
                long parseLong = Long.parseLong(subString(i13, i11 - i13));
                Calendar instance = Calendar.getInstance(this.timeZone, this.locale);
                this.calendar = instance;
                instance.setTimeInMillis(parseLong);
                this.token = 5;
                return true;
            }
        }
        if (i == 8 || i == 14 || ((i == 16 && ((charAt5 = charAt(this.bp + 10)) == 'T' || charAt5 == ' ')) || (i == 17 && charAt(this.bp + 6) != '-'))) {
            if (z) {
                return false;
            }
            char charAt15 = charAt(this.bp);
            char charAt16 = charAt(this.bp + 1);
            char charAt17 = charAt(this.bp + 2);
            char charAt18 = charAt(this.bp + 3);
            char charAt19 = charAt(this.bp + 4);
            char charAt20 = charAt(this.bp + 5);
            char charAt21 = charAt(this.bp + 6);
            char charAt22 = charAt(this.bp + 7);
            char charAt23 = charAt(this.bp + 8);
            boolean z2 = charAt19 == '-' && charAt22 == '-';
            boolean z3 = z2 && i == 16;
            boolean z4 = z2 && i == 17;
            if (z4 || z3) {
                charAt22 = charAt(this.bp + 9);
                c = charAt23;
            } else {
                c = charAt21;
                charAt21 = charAt20;
                charAt20 = charAt19;
            }
            if (!checkDate(charAt15, charAt16, charAt17, charAt18, charAt20, charAt21, c, charAt22)) {
                return false;
            }
            setCalendar(charAt15, charAt16, charAt17, charAt18, charAt20, charAt21, c, charAt22);
            if (i != 8) {
                char charAt24 = charAt(this.bp + 9);
                char charAt25 = charAt(this.bp + 10);
                char charAt26 = charAt(this.bp + 11);
                char charAt27 = charAt(this.bp + 12);
                char charAt28 = charAt(this.bp + 13);
                if ((z4 && charAt25 == 'T' && charAt28 == ':' && charAt(this.bp + 16) == 'Z') || (z3 && ((charAt25 == ' ' || charAt25 == 'T') && charAt28 == ':'))) {
                    charAt25 = charAt(this.bp + 14);
                    char charAt29 = charAt(this.bp + 15);
                    charAt23 = charAt26;
                    charAt28 = YKUpsConvert.CHAR_ZERO;
                    charAt26 = charAt29;
                    charAt24 = charAt27;
                    charAt27 = YKUpsConvert.CHAR_ZERO;
                }
                if (!checkTime(charAt23, charAt24, charAt25, charAt26, charAt27, charAt28)) {
                    return false;
                }
                if (i != 17 || z4) {
                    c2 = YKUpsConvert.CHAR_ZERO;
                    i6 = 0;
                } else {
                    char charAt30 = charAt(this.bp + 14);
                    char charAt31 = charAt(this.bp + 15);
                    char charAt32 = charAt(this.bp + 16);
                    if (charAt30 < '0' || charAt30 > '9' || charAt31 < '0' || charAt31 > '9' || charAt32 < '0' || charAt32 > '9') {
                        return false;
                    }
                    i6 = ((charAt30 - YKUpsConvert.CHAR_ZERO) * 100) + ((charAt31 - YKUpsConvert.CHAR_ZERO) * 10) + (charAt32 - YKUpsConvert.CHAR_ZERO);
                    c2 = YKUpsConvert.CHAR_ZERO;
                }
                int i14 = charAt24 - c2;
                i5 = ((charAt25 - c2) * 10) + (charAt26 - c2);
                i4 = ((charAt27 - c2) * 10) + (charAt28 - c2);
                i3 = i6;
                i2 = i14 + ((charAt23 - c2) * 10);
            } else {
                i3 = 0;
                i5 = 0;
                i4 = 0;
                i2 = 0;
            }
            this.calendar.set(11, i2);
            this.calendar.set(12, i5);
            this.calendar.set(13, i4);
            this.calendar.set(14, i3);
            this.token = 5;
            return true;
        } else if (i < 9) {
            return false;
        } else {
            char charAt33 = charAt(this.bp);
            char charAt34 = charAt(this.bp + 1);
            char charAt35 = charAt(this.bp + 2);
            char charAt36 = charAt(this.bp + 3);
            char charAt37 = charAt(this.bp + 4);
            char charAt38 = charAt(this.bp + 5);
            char charAt39 = charAt(this.bp + 6);
            char charAt40 = charAt(this.bp + 7);
            char charAt41 = charAt(this.bp + 8);
            char charAt42 = charAt(this.bp + 9);
            if ((charAt37 == '-' && charAt40 == '-') || (charAt37 == '/' && charAt40 == '/')) {
                i7 = 10;
            } else if (charAt37 == '-' && charAt39 == '-') {
                if (charAt41 == ' ') {
                    charAt42 = charAt36;
                    charAt39 = charAt38;
                    charAt41 = charAt40;
                    c3 = YKUpsConvert.CHAR_ZERO;
                    charAt38 = YKUpsConvert.CHAR_ZERO;
                    i7 = 8;
                } else {
                    charAt42 = charAt36;
                    charAt39 = charAt38;
                    c3 = charAt40;
                    charAt38 = YKUpsConvert.CHAR_ZERO;
                    i7 = 9;
                }
                if (checkDate(charAt33, charAt34, charAt35, charAt42, charAt38, charAt39, c3, charAt41)) {
                }
            } else if ((charAt35 == '.' && charAt38 == '.') || (charAt35 == '-' && charAt38 == '-')) {
                charAt38 = charAt36;
                charAt35 = charAt41;
                c3 = charAt33;
                charAt41 = charAt34;
                charAt34 = charAt40;
                charAt33 = charAt39;
                i7 = 10;
                charAt39 = charAt37;
                if (checkDate(charAt33, charAt34, charAt35, charAt42, charAt38, charAt39, c3, charAt41)) {
                }
            } else if (charAt37 != 24180 && charAt37 != 45380) {
                return false;
            } else {
                if (charAt40 == 26376 || charAt40 == 50900) {
                    if (charAt42 == 26085 || charAt42 == 51068) {
                        charAt42 = charAt36;
                        c3 = YKUpsConvert.CHAR_ZERO;
                    } else if (charAt(this.bp + 10) != 26085 && charAt(this.bp + 10) != 51068) {
                        return false;
                    } else {
                        i7 = 11;
                    }
                } else if (charAt39 != 26376 && charAt39 != 50900) {
                    return false;
                } else {
                    if (charAt41 == 26085 || charAt41 == 51068) {
                        charAt42 = charAt36;
                        charAt39 = charAt38;
                        charAt41 = charAt40;
                        c3 = YKUpsConvert.CHAR_ZERO;
                    } else if (charAt42 != 26085 && charAt42 != 51068) {
                        return false;
                    } else {
                        charAt42 = charAt36;
                        charAt39 = charAt38;
                        c3 = charAt40;
                    }
                    charAt38 = YKUpsConvert.CHAR_ZERO;
                }
                i7 = 10;
                if (checkDate(charAt33, charAt34, charAt35, charAt42, charAt38, charAt39, c3, charAt41)) {
                    return false;
                }
                setCalendar(charAt33, charAt34, charAt35, charAt42, charAt38, charAt39, c3, charAt41);
                char charAt43 = charAt(this.bp + i7);
                if (charAt43 == 'T' || (charAt43 == ' ' && !z)) {
                    int i15 = i7 + 9;
                    if (!(i >= i15 && charAt(this.bp + i7 + 3) == ':' && charAt(this.bp + i7 + 6) == ':')) {
                        return false;
                    }
                    char charAt44 = charAt(this.bp + i7 + 1);
                    char charAt45 = charAt(this.bp + i7 + 2);
                    char charAt46 = charAt(this.bp + i7 + 4);
                    char charAt47 = charAt(this.bp + i7 + 5);
                    char charAt48 = charAt(this.bp + i7 + 7);
                    char charAt49 = charAt(this.bp + i7 + 8);
                    if (!checkTime(charAt44, charAt45, charAt46, charAt47, charAt48, charAt49)) {
                        return false;
                    }
                    setTime(charAt44, charAt45, charAt46, charAt47, charAt48, charAt49);
                    char charAt50 = charAt(this.bp + i7 + 9);
                    if (charAt50 == '.') {
                        int i16 = i7 + 11;
                        if (i >= i16 && (charAt = charAt(this.bp + i7 + 10)) >= '0' && charAt <= '9') {
                            int i17 = charAt - YKUpsConvert.CHAR_ZERO;
                            if (i <= i16 || (charAt4 = charAt(this.bp + i7 + 11)) < '0' || charAt4 > '9') {
                                i8 = 1;
                            } else {
                                i17 = (i17 * 10) + (charAt4 - YKUpsConvert.CHAR_ZERO);
                                i8 = 2;
                            }
                            if (i8 == 2 && (charAt3 = charAt(this.bp + i7 + 12)) >= '0' && charAt3 <= '9') {
                                i17 = (i17 * 10) + (charAt3 - YKUpsConvert.CHAR_ZERO);
                                i8 = 3;
                            }
                            this.calendar.set(14, i17);
                            char charAt51 = charAt(this.bp + i7 + 10 + i8);
                            if (charAt51 == '+' || charAt51 == '-') {
                                char charAt52 = charAt(this.bp + i7 + 10 + i8 + 1);
                                if (charAt52 >= '0' && charAt52 <= '1' && (charAt2 = charAt(this.bp + i7 + 10 + i8 + 2)) >= '0' && charAt2 <= '9') {
                                    char charAt53 = charAt(this.bp + i7 + 10 + i8 + 3);
                                    if (charAt53 == ':') {
                                        if (!(charAt(this.bp + i7 + 10 + i8 + 4) == '0' && charAt(this.bp + i7 + 10 + i8 + 5) == '0')) {
                                            return false;
                                        }
                                        i10 = 6;
                                    } else if (charAt53 != '0') {
                                        i10 = 3;
                                    } else if (charAt(this.bp + i7 + 10 + i8 + 4) != '0') {
                                        return false;
                                    } else {
                                        i10 = 5;
                                    }
                                    setTimeZone(charAt51, charAt52, charAt2);
                                    i9 = i10;
                                }
                            } else if (charAt51 == 'Z') {
                                if (this.calendar.getTimeZone().getRawOffset() != 0) {
                                    String[] availableIDs = TimeZone.getAvailableIDs(0);
                                    if (availableIDs.length > 0) {
                                        this.calendar.setTimeZone(TimeZone.getTimeZone(availableIDs[0]));
                                    }
                                }
                                i9 = 1;
                            } else {
                                i9 = 0;
                            }
                            int i18 = i7 + 10 + i8 + i9;
                            char charAt54 = charAt(this.bp + i18);
                            if (!(charAt54 == 26 || charAt54 == '\"')) {
                                return false;
                            }
                            int i19 = this.bp + i18;
                            this.bp = i19;
                            this.ch = charAt(i19);
                            this.token = 5;
                            return true;
                        }
                        return false;
                    }
                    this.calendar.set(14, 0);
                    int i20 = this.bp + i15;
                    this.bp = i20;
                    this.ch = charAt(i20);
                    this.token = 5;
                    if (charAt50 == 'Z' && this.calendar.getTimeZone().getRawOffset() != 0) {
                        String[] availableIDs2 = TimeZone.getAvailableIDs(0);
                        if (availableIDs2.length > 0) {
                            this.calendar.setTimeZone(TimeZone.getTimeZone(availableIDs2[0]));
                        }
                    }
                    return true;
                } else if (charAt43 == '\"' || charAt43 == 26 || charAt43 == 26085 || charAt43 == 51068) {
                    this.calendar.set(11, 0);
                    this.calendar.set(12, 0);
                    this.calendar.set(13, 0);
                    this.calendar.set(14, 0);
                    int i21 = this.bp + i7;
                    this.bp = i21;
                    this.ch = charAt(i21);
                    this.token = 5;
                    return true;
                } else if ((charAt43 != '+' && charAt43 != '-') || this.len != i7 + 6 || charAt(this.bp + i7 + 3) != ':' || charAt(this.bp + i7 + 4) != '0' || charAt(this.bp + i7 + 5) != '0') {
                    return false;
                } else {
                    setTime(YKUpsConvert.CHAR_ZERO, YKUpsConvert.CHAR_ZERO, YKUpsConvert.CHAR_ZERO, YKUpsConvert.CHAR_ZERO, YKUpsConvert.CHAR_ZERO, YKUpsConvert.CHAR_ZERO);
                    this.calendar.set(14, 0);
                    setTimeZone(charAt43, charAt(this.bp + i7 + 1), charAt(this.bp + i7 + 2));
                    return true;
                }
            }
            charAt41 = charAt42;
            charAt42 = charAt36;
            c3 = charAt41;
            if (checkDate(charAt33, charAt34, charAt35, charAt42, charAt38, charAt39, c3, charAt41)) {
            }
        }
    }

    public JSONLexer(char[] cArr, int i, int i2) {
        this(new String(cArr, 0, i), i2);
    }

    public JSONLexer(String str, int i) {
        char c;
        this.features = JSON.DEFAULT_PARSER_FEATURE;
        boolean z = false;
        this.exp = false;
        this.isDouble = false;
        this.timeZone = JSON.defaultTimeZone;
        this.locale = JSON.defaultLocale;
        String str2 = null;
        this.calendar = null;
        this.matchStat = 0;
        char[] cArr = sbufLocal.get();
        this.sbuf = cArr;
        if (cArr == null) {
            this.sbuf = new char[512];
        }
        this.features = i;
        this.text = str;
        int length = str.length();
        this.len = length;
        this.bp = -1;
        int i2 = -1 + 1;
        this.bp = i2;
        if (i2 >= length) {
            c = EOI;
        } else {
            c = str.charAt(i2);
        }
        this.ch = c;
        if (c == 65279) {
            next();
        }
        this.stringDefaultValue = (Feature.InitStringFieldAsEmpty.mask & i) != 0 ? "" : str2;
        this.disableCircularReferenceDetect = (Feature.DisableCircularReferenceDetect.mask & i) != 0 ? true : z;
    }

    public String scanSymbol(SymbolTable symbolTable, char c) {
        String str;
        char c2;
        int i = this.bp + 1;
        int indexOf = this.text.indexOf(c, i);
        if (indexOf != -1) {
            int i2 = indexOf - i;
            char[] sub_chars = sub_chars(this.bp + 1, i2);
            boolean z = false;
            while (i2 > 0 && sub_chars[i2 - 1] == '\\') {
                int i3 = i2 - 2;
                int i4 = 1;
                while (i3 >= 0 && sub_chars[i3] == '\\') {
                    i4++;
                    i3--;
                }
                if (i4 % 2 == 0) {
                    break;
                }
                int indexOf2 = this.text.indexOf(c, indexOf + 1);
                int i5 = (indexOf2 - indexOf) + i2;
                if (i5 >= sub_chars.length) {
                    int length = (sub_chars.length * 3) / 2;
                    if (length < i5) {
                        length = i5;
                    }
                    char[] cArr = new char[length];
                    System.arraycopy(sub_chars, 0, cArr, 0, sub_chars.length);
                    sub_chars = cArr;
                }
                this.text.getChars(indexOf, indexOf2, sub_chars, i2);
                indexOf = indexOf2;
                i2 = i5;
                z = true;
            }
            if (!z) {
                int i6 = 0;
                for (int i7 = 0; i7 < i2; i7++) {
                    char c3 = sub_chars[i7];
                    i6 = (i6 * 31) + c3;
                    if (c3 == '\\') {
                        z = true;
                    }
                }
                if (z) {
                    str = readString(sub_chars, i2);
                } else {
                    str = i2 < 20 ? symbolTable.addSymbol(sub_chars, 0, i2, i6) : new String(sub_chars, 0, i2);
                }
            } else {
                str = readString(sub_chars, i2);
            }
            int i8 = indexOf + 1;
            this.bp = i8;
            if (i8 >= this.len) {
                c2 = EOI;
            } else {
                c2 = this.text.charAt(i8);
            }
            this.ch = c2;
            return str;
        }
        throw new JSONException("unclosed str, " + info());
    }

    public final BigDecimal decimalValue() {
        char charAt = this.text.charAt((this.np + this.sp) - 1);
        int i = this.sp;
        if (charAt == 'L' || charAt == 'S' || charAt == 'B' || charAt == 'F' || charAt == 'D') {
            i--;
        }
        int i2 = this.np;
        char[] cArr = this.sbuf;
        if (i < cArr.length) {
            this.text.getChars(i2, i2 + i, cArr, 0);
            return new BigDecimal(this.sbuf, 0, i);
        }
        char[] cArr2 = new char[i];
        this.text.getChars(i2, i + i2, cArr2, 0);
        return new BigDecimal(cArr2);
    }

    public final void nextToken(int i) {
        this.sp = 0;
        while (true) {
            if (i != 2) {
                char c = EOI;
                if (i == 4) {
                    char c2 = this.ch;
                    if (c2 == '\"') {
                        this.pos = this.bp;
                        scanString();
                        return;
                    } else if (c2 >= '0' && c2 <= '9') {
                        this.pos = this.bp;
                        scanNumber();
                        return;
                    } else if (c2 == '{') {
                        this.token = 12;
                        int i2 = this.bp + 1;
                        this.bp = i2;
                        if (i2 < this.len) {
                            c = this.text.charAt(i2);
                        }
                        this.ch = c;
                        return;
                    }
                } else if (i == 12) {
                    char c3 = this.ch;
                    if (c3 == '{') {
                        this.token = 12;
                        int i3 = this.bp + 1;
                        this.bp = i3;
                        if (i3 < this.len) {
                            c = this.text.charAt(i3);
                        }
                        this.ch = c;
                        return;
                    } else if (c3 == '[') {
                        this.token = 14;
                        int i4 = this.bp + 1;
                        this.bp = i4;
                        if (i4 < this.len) {
                            c = this.text.charAt(i4);
                        }
                        this.ch = c;
                        return;
                    }
                } else if (i != 18) {
                    if (i != 20) {
                        switch (i) {
                            case 14:
                                char c4 = this.ch;
                                if (c4 == '[') {
                                    this.token = 14;
                                    next();
                                    return;
                                } else if (c4 == '{') {
                                    this.token = 12;
                                    next();
                                    return;
                                }
                                break;
                            case 15:
                                if (this.ch == ']') {
                                    this.token = 15;
                                    next();
                                    return;
                                }
                                break;
                            case 16:
                                char c5 = this.ch;
                                if (c5 == ',') {
                                    this.token = 16;
                                    int i5 = this.bp + 1;
                                    this.bp = i5;
                                    if (i5 < this.len) {
                                        c = this.text.charAt(i5);
                                    }
                                    this.ch = c;
                                    return;
                                } else if (c5 == '}') {
                                    this.token = 13;
                                    int i6 = this.bp + 1;
                                    this.bp = i6;
                                    if (i6 < this.len) {
                                        c = this.text.charAt(i6);
                                    }
                                    this.ch = c;
                                    return;
                                } else if (c5 == ']') {
                                    this.token = 15;
                                    int i7 = this.bp + 1;
                                    this.bp = i7;
                                    if (i7 < this.len) {
                                        c = this.text.charAt(i7);
                                    }
                                    this.ch = c;
                                    return;
                                } else if (c5 == 26) {
                                    this.token = 20;
                                    return;
                                }
                                break;
                        }
                    }
                    if (this.ch == 26) {
                        this.token = 20;
                        return;
                    }
                } else {
                    nextIdent();
                    return;
                }
            } else {
                char c6 = this.ch;
                if (c6 >= '0' && c6 <= '9') {
                    this.pos = this.bp;
                    scanNumber();
                    return;
                } else if (c6 == '\"') {
                    this.pos = this.bp;
                    scanString();
                    return;
                } else if (c6 == '[') {
                    this.token = 14;
                    next();
                    return;
                } else if (c6 == '{') {
                    this.token = 12;
                    next();
                    return;
                }
            }
            char c7 = this.ch;
            if (c7 == ' ' || c7 == '\n' || c7 == '\r' || c7 == '\t' || c7 == '\f' || c7 == '\b') {
                next();
            } else {
                nextToken();
                return;
            }
        }
    }
}
