package com.alipay.ma.util;

import com.alipay.ma.MaLogger;
import com.autonavi.amap.mapcore.tools.GlMapUtil;

/* compiled from: Taobao */
public final class StringEncodeUtils {
    public static final boolean ASSUME_SHIFT_JIS;
    public static final String EUC_JP = "EUC_JP";
    public static final String GB2312 = "GB2312";
    public static final String ISO88591 = "ISO8859_1";
    public static final String SHIFT_JIS = "SJIS";
    public static final String TAG = "StringEncodeUtil";
    public static final String UTF8 = "UTF8";
    private static final String a;

    static {
        String property = System.getProperty("file.encoding");
        a = property;
        ASSUME_SHIFT_JIS = "SJIS".equalsIgnoreCase(property) || EUC_JP.equalsIgnoreCase(property);
    }

    private StringEncodeUtils() {
    }

    private static boolean a(byte[] bArr) {
        boolean z;
        int i = 0;
        boolean z2 = false;
        int i2 = 0;
        while (true) {
            z = true;
            if (i >= bArr.length) {
                break;
            }
            int i3 = bArr[i] & 255;
            if (z2) {
                int i4 = ((i2 & 255) << 8) | (i3 & 255);
                if (i4 < 41377 || i4 > 65278) {
                    z = false;
                } else {
                    z2 = false;
                    i2 = 0;
                }
            } else if ((i3 & 128) != 0) {
                i2 = i3;
                z2 = true;
            }
            i++;
        }
        if (i2 != 0) {
            return false;
        }
        return z;
    }

    private static boolean b(byte[] bArr) {
        int length = bArr != null ? bArr.length : 0;
        int i = 0;
        boolean z = true;
        while (i < length && z) {
            int i2 = length - i;
            int i3 = bArr[i] & 255;
            int i4 = i2 > 1 ? bArr[i + 1] & 255 : 0;
            int i5 = i2 > 2 ? bArr[i + 2] & 255 : 0;
            int i6 = i2 > 3 ? bArr[i + 3] & 255 : 0;
            if ((i3 & 248) == 240 && (i4 & 192) == 128 && (i5 & 192) == 128 && (i6 & 192) == 128) {
                i += 4;
            } else if ((i3 & GlMapUtil.DEVICE_DISPLAY_DPI_MEDIAN) == 224 && (i4 & 192) == 128 && (i5 & 192) == 128) {
                i += 3;
            } else if ((i3 & 224) == 192 && (i4 & 192) == 128) {
                i += 2;
            } else if ((i3 & 128) == 0) {
                i++;
            } else {
                z = false;
            }
        }
        return z;
    }

    public static String getStringEncode(byte[] bArr, boolean z) {
        if (bArr == null) {
            return null;
        }
        try {
            if (bArr.length > 0) {
                return guessEncoding(bArr, z);
            }
            return null;
        } catch (Exception e) {
            MaLogger.e(TAG, e.getMessage());
            return null;
        }
    }

    public static String guessEncoding(byte[] bArr, boolean z) {
        int i;
        int length = bArr.length;
        boolean b = b(bArr);
        boolean a2 = !z ? a(bArr) : true;
        boolean z2 = true;
        boolean z3 = true;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        for (int i9 = 0; i9 < length && ((z && a2) || z2 || z3); i9++) {
            int i10 = bArr[i9] & 255;
            if (z && a2 && i10 > 127 && i10 > 176 && i10 <= 247 && (i = i9 + 1) < length) {
                int i11 = bArr[i] & 255;
                a2 = i11 > 160 && i11 <= 247;
            }
            if (z2) {
                if (i10 > 127 && i10 < 160) {
                    z2 = false;
                } else if (i10 > 159 && (i10 < 192 || i10 == 215 || i10 == 247)) {
                    i6++;
                }
            }
            if (z3) {
                if (i2 > 0) {
                    if (i10 >= 64 && i10 != 127 && i10 <= 252) {
                        i2--;
                    }
                } else if (!(i10 == 128 || i10 == 160 || i10 > 239)) {
                    if (i10 <= 160 || i10 >= 224) {
                        if (i10 > 127) {
                            i2++;
                            i7++;
                            if (i7 > i4) {
                                i4 = i7;
                            }
                        } else {
                            i7 = 0;
                        }
                        i8 = 0;
                    } else {
                        i5++;
                        i8++;
                        if (i8 > i3) {
                            i3 = i8;
                        }
                        i7 = 0;
                    }
                }
                z3 = false;
            }
        }
        if (b) {
            return UTF8;
        }
        boolean z4 = (!z3 || i2 <= 0) ? z3 : false;
        if (a2) {
            return "GB2312";
        }
        if (z4 && (ASSUME_SHIFT_JIS || i3 >= 3 || i4 >= 3)) {
            return "SJIS";
        }
        if (!z2 || !z4) {
            if (z2) {
                return ISO88591;
            }
            if (z4) {
                return "SJIS";
            }
            return a;
        } else if ((i3 != 2 || i5 != 2) && i6 * 10 < length) {
            return ISO88591;
        } else {
            return "SJIS";
        }
    }
}
