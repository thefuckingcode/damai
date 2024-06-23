package org.apache.commons.lang3.time;

import androidx.exifinterface.media.ExifInterface;
import com.taobao.weex.common.Constants;
import com.taobao.weex.ui.component.WXComponent;
import com.youku.live.livesdk.monitor.performance.AbsPerformance;
import com.youku.upsplayer.util.YKUpsConvert;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;

/* compiled from: Taobao */
public class DurationFormatUtils {
    static final Object H = "H";
    public static final String ISO_EXTENDED_FORMAT_PATTERN = "'P'yyyy'Y'M'M'd'DT'H'H'm'M's.SSS'S'";
    static final Object M = "M";
    static final Object S = ExifInterface.LATITUDE_SOUTH;
    static final Object d = "d";
    static final Object m = WXComponent.PROP_FS_MATCH_PARENT;
    static final Object s = "s";
    static final Object y = Constants.Name.Y;

    static String format(Token[] tokenArr, long j, long j2, long j3, long j4, long j5, long j6, long j7, boolean z) {
        int i;
        int i2;
        Token[] tokenArr2 = tokenArr;
        StringBuilder sb = new StringBuilder();
        int length = tokenArr2.length;
        int i3 = 0;
        boolean z2 = false;
        while (i3 < length) {
            Token token = tokenArr2[i3];
            Object value = token.getValue();
            int count = token.getCount();
            if (value instanceof StringBuilder) {
                sb.append(value.toString());
                i2 = length;
                i = i3;
            } else {
                if (value.equals(y)) {
                    sb.append(paddedValue(j, z, count));
                    i2 = length;
                    i = i3;
                } else {
                    if (value.equals(M)) {
                        i = i3;
                        sb.append(paddedValue(j2, z, count));
                    } else {
                        i = i3;
                        if (value.equals(d)) {
                            sb.append(paddedValue(j3, z, count));
                        } else if (value.equals(H)) {
                            sb.append(paddedValue(j4, z, count));
                            i2 = length;
                        } else if (value.equals(m)) {
                            sb.append(paddedValue(j5, z, count));
                            i2 = length;
                        } else {
                            if (value.equals(s)) {
                                i2 = length;
                                sb.append(paddedValue(j6, z, count));
                                z2 = true;
                            } else {
                                i2 = length;
                                if (value.equals(S)) {
                                    if (z2) {
                                        int i4 = 3;
                                        if (z) {
                                            i4 = Math.max(3, count);
                                        }
                                        sb.append(paddedValue(j7, true, i4));
                                    } else {
                                        sb.append(paddedValue(j7, z, count));
                                    }
                                    z2 = false;
                                }
                            }
                            i3 = i + 1;
                            length = i2;
                            tokenArr2 = tokenArr;
                        }
                    }
                    i2 = length;
                }
                z2 = false;
            }
            i3 = i + 1;
            length = i2;
            tokenArr2 = tokenArr;
        }
        return sb.toString();
    }

    public static String formatDuration(long j, String str) {
        return formatDuration(j, str, true);
    }

    public static String formatDurationHMS(long j) {
        return formatDuration(j, "HH:mm:ss.SSS");
    }

    public static String formatDurationISO(long j) {
        return formatDuration(j, ISO_EXTENDED_FORMAT_PATTERN, false);
    }

    public static String formatDurationWords(long j, boolean z, boolean z2) {
        String formatDuration = formatDuration(j, "d' days 'H' hours 'm' minutes 's' seconds'");
        if (z) {
            formatDuration = " " + formatDuration;
            String replaceOnce = StringUtils.replaceOnce(formatDuration, " 0 days", "");
            if (replaceOnce.length() != formatDuration.length()) {
                String replaceOnce2 = StringUtils.replaceOnce(replaceOnce, " 0 hours", "");
                if (replaceOnce2.length() != replaceOnce.length()) {
                    formatDuration = StringUtils.replaceOnce(replaceOnce2, " 0 minutes", "");
                    if (formatDuration.length() != formatDuration.length()) {
                        formatDuration = StringUtils.replaceOnce(formatDuration, " 0 seconds", "");
                    }
                } else {
                    formatDuration = replaceOnce;
                }
            }
            if (formatDuration.length() != 0) {
                formatDuration = formatDuration.substring(1);
            }
        }
        if (z2) {
            String replaceOnce3 = StringUtils.replaceOnce(formatDuration, " 0 seconds", "");
            if (replaceOnce3.length() != formatDuration.length()) {
                formatDuration = StringUtils.replaceOnce(replaceOnce3, " 0 minutes", "");
                if (formatDuration.length() != replaceOnce3.length()) {
                    String replaceOnce4 = StringUtils.replaceOnce(formatDuration, " 0 hours", "");
                    if (replaceOnce4.length() != formatDuration.length()) {
                        formatDuration = StringUtils.replaceOnce(replaceOnce4, " 0 days", "");
                    }
                } else {
                    formatDuration = replaceOnce3;
                }
            }
        }
        return StringUtils.replaceOnce(StringUtils.replaceOnce(StringUtils.replaceOnce(StringUtils.replaceOnce(" " + formatDuration, " 1 seconds", " 1 second"), " 1 minutes", " 1 minute"), " 1 hours", " 1 hour"), " 1 days", " 1 day").trim();
    }

    public static String formatPeriod(long j, long j2, String str) {
        return formatPeriod(j, j2, str, true, TimeZone.getDefault());
    }

    public static String formatPeriodISO(long j, long j2) {
        return formatPeriod(j, j2, ISO_EXTENDED_FORMAT_PATTERN, false, TimeZone.getDefault());
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x009b A[SYNTHETIC] */
    static Token[] lexx(String str) {
        Object obj;
        ArrayList arrayList = new ArrayList(str.length());
        StringBuilder sb = null;
        Token token = null;
        boolean z = false;
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (!z || charAt == '\'') {
                if (charAt != '\'') {
                    if (charAt == 'H') {
                        obj = H;
                    } else if (charAt == 'M') {
                        obj = M;
                    } else if (charAt == 'S') {
                        obj = S;
                    } else if (charAt == 'd') {
                        obj = d;
                    } else if (charAt == 'm') {
                        obj = m;
                    } else if (charAt == 's') {
                        obj = s;
                    } else if (charAt != 'y') {
                        if (sb == null) {
                            sb = new StringBuilder();
                            arrayList.add(new Token(sb));
                        }
                        sb.append(charAt);
                    } else {
                        obj = y;
                    }
                    if (obj != null) {
                        if (token == null || !token.getValue().equals(obj)) {
                            Token token2 = new Token(obj);
                            arrayList.add(token2);
                            token = token2;
                        } else {
                            token.increment();
                        }
                        sb = null;
                    }
                } else if (z) {
                    sb = null;
                    obj = null;
                    z = false;
                    if (obj != null) {
                    }
                } else {
                    sb = new StringBuilder();
                    arrayList.add(new Token(sb));
                    z = true;
                }
                obj = null;
                if (obj != null) {
                }
            } else {
                sb.append(charAt);
            }
        }
        if (!z) {
            return (Token[]) arrayList.toArray(new Token[arrayList.size()]);
        }
        throw new IllegalArgumentException("Unmatched quote in format: " + str);
    }

    private static String paddedValue(long j, boolean z, int i) {
        String l = Long.toString(j);
        return z ? StringUtils.leftPad(l, i, (char) YKUpsConvert.CHAR_ZERO) : l;
    }

    public static String formatDuration(long j, String str, boolean z) {
        long j2;
        long j3;
        long j4;
        long j5;
        long j6;
        long j7;
        Validate.inclusiveBetween(0L, (long) AbsPerformance.LONG_NIL, j, "durationMillis must not be negative");
        Token[] lexx = lexx(str);
        if (Token.containsTokenWithValue(lexx, d)) {
            long j8 = j / 86400000;
            j3 = j - (86400000 * j8);
            j2 = j8;
        } else {
            j3 = j;
            j2 = 0;
        }
        if (Token.containsTokenWithValue(lexx, H)) {
            long j9 = j3 / DateUtils.MILLIS_PER_HOUR;
            j3 -= DateUtils.MILLIS_PER_HOUR * j9;
            j4 = j9;
        } else {
            j4 = 0;
        }
        if (Token.containsTokenWithValue(lexx, m)) {
            long j10 = j3 / DateUtils.MILLIS_PER_MINUTE;
            j3 -= DateUtils.MILLIS_PER_MINUTE * j10;
            j5 = j10;
        } else {
            j5 = 0;
        }
        if (Token.containsTokenWithValue(lexx, s)) {
            long j11 = j3 / 1000;
            j6 = j3 - (1000 * j11);
            j7 = j11;
        } else {
            j7 = 0;
            j6 = j3;
        }
        return format(lexx, 0, 0, j2, j4, j5, j7, j6, z);
    }

    public static String formatPeriod(long j, long j2, String str, boolean z, TimeZone timeZone) {
        int i = 0;
        Validate.isTrue(j <= j2, "startMillis must not be greater than endMillis", new Object[0]);
        Token[] lexx = lexx(str);
        Calendar instance = Calendar.getInstance(timeZone);
        instance.setTime(new Date(j));
        Calendar instance2 = Calendar.getInstance(timeZone);
        instance2.setTime(new Date(j2));
        int i2 = instance2.get(14) - instance.get(14);
        int i3 = instance2.get(13) - instance.get(13);
        int i4 = instance2.get(12) - instance.get(12);
        int i5 = instance2.get(11) - instance.get(11);
        int i6 = instance2.get(5) - instance.get(5);
        int i7 = instance2.get(2) - instance.get(2);
        int i8 = instance2.get(1) - instance.get(1);
        while (i2 < 0) {
            i2 += 1000;
            i3--;
        }
        while (i3 < 0) {
            i3 += 60;
            i4--;
        }
        while (i4 < 0) {
            i4 += 60;
            i5--;
        }
        while (i5 < 0) {
            i5 += 24;
            i6--;
        }
        if (Token.containsTokenWithValue(lexx, M)) {
            while (i6 < 0) {
                i6 += instance.getActualMaximum(5);
                i7--;
                instance.add(2, 1);
            }
            while (i7 < 0) {
                i7 += 12;
                i8--;
            }
            if (!Token.containsTokenWithValue(lexx, y) && i8 != 0) {
                while (i8 != 0) {
                    i7 += i8 * 12;
                    i8 = 0;
                }
            }
        } else {
            if (!Token.containsTokenWithValue(lexx, y)) {
                int i9 = instance2.get(1);
                if (i7 < 0) {
                    i9--;
                }
                while (instance.get(1) != i9) {
                    int actualMaximum = i6 + (instance.getActualMaximum(6) - instance.get(6));
                    if ((instance instanceof GregorianCalendar) && instance.get(2) == 1 && instance.get(5) == 29) {
                        actualMaximum++;
                    }
                    instance.add(1, 1);
                    i6 = actualMaximum + instance.get(6);
                }
                i8 = 0;
            }
            while (instance.get(2) != instance2.get(2)) {
                i6 += instance.getActualMaximum(5);
                instance.add(2, 1);
            }
            i7 = 0;
            while (i6 < 0) {
                i6 += instance.getActualMaximum(5);
                i7--;
                instance.add(2, 1);
            }
        }
        if (!Token.containsTokenWithValue(lexx, d)) {
            i5 += i6 * 24;
            i6 = 0;
        }
        if (!Token.containsTokenWithValue(lexx, H)) {
            i4 += i5 * 60;
            i5 = 0;
        }
        if (!Token.containsTokenWithValue(lexx, m)) {
            i3 += i4 * 60;
            i4 = 0;
        }
        if (!Token.containsTokenWithValue(lexx, s)) {
            i2 += i3 * 1000;
        } else {
            i = i3;
        }
        return format(lexx, (long) i8, (long) i7, (long) i6, (long) i5, (long) i4, (long) i, (long) i2, z);
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class Token {
        private int count;
        private final Object value;

        Token(Object obj) {
            this.value = obj;
            this.count = 1;
        }

        static boolean containsTokenWithValue(Token[] tokenArr, Object obj) {
            for (Token token : tokenArr) {
                if (token.getValue() == obj) {
                    return true;
                }
            }
            return false;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Token)) {
                return false;
            }
            Token token = (Token) obj;
            if (this.value.getClass() != token.value.getClass() || this.count != token.count) {
                return false;
            }
            Object obj2 = this.value;
            if (obj2 instanceof StringBuilder) {
                return obj2.toString().equals(token.value.toString());
            }
            if (obj2 instanceof Number) {
                return obj2.equals(token.value);
            }
            if (obj2 == token.value) {
                return true;
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public int getCount() {
            return this.count;
        }

        /* access modifiers changed from: package-private */
        public Object getValue() {
            return this.value;
        }

        public int hashCode() {
            return this.value.hashCode();
        }

        /* access modifiers changed from: package-private */
        public void increment() {
            this.count++;
        }

        public String toString() {
            return StringUtils.repeat(this.value.toString(), this.count);
        }

        Token(Object obj, int i) {
            this.value = obj;
            this.count = i;
        }
    }
}
