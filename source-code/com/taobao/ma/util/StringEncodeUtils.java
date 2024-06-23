package com.taobao.ma.util;

import android.text.TextUtils;

/* compiled from: Taobao */
public final class StringEncodeUtils {
    private static final boolean ASSUME_SHIFT_JIS;
    private static final String EUC_JP = "EUC_JP";
    public static final String GB2312 = "GB2312";
    private static final String ISO88591 = "ISO8859_1";
    private static final String PLATFORM_DEFAULT_ENCODING;
    public static final String SHIFT_JIS = "SJIS";
    private static final String UTF8 = "UTF8";

    static {
        String property = System.getProperty("file.encoding");
        PLATFORM_DEFAULT_ENCODING = property;
        ASSUME_SHIFT_JIS = "SJIS".equalsIgnoreCase(property) || "EUC_JP".equalsIgnoreCase(property);
    }

    private StringEncodeUtils() {
    }

    public static String getStringEncode(byte[] bArr) {
        String str = null;
        if (bArr != null) {
            try {
                if (bArr.length > 0) {
                    str = guessEncoding(bArr);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return TextUtils.isEmpty(str) ? "" : str;
    }

    public static String guessEncoding(byte[] bArr) {
        int i;
        byte[] bArr2 = bArr;
        int length = bArr2.length;
        boolean z = true;
        boolean z2 = bArr2.length > 3 && bArr2[0] == -17 && bArr2[1] == -69 && bArr2[2] == -65;
        boolean z3 = true;
        boolean z4 = true;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        while (i2 < length) {
            int i12 = bArr2[i2] & 255;
            if (z4) {
                if (i3 > 0) {
                    if ((i12 & 128) != 0) {
                        i3--;
                    }
                } else if ((i12 & 128) != 0) {
                    if ((i12 & 64) != 0) {
                        i3++;
                        if ((i12 & 32) == 0) {
                            i4++;
                        } else {
                            i3++;
                            if ((i12 & 16) == 0) {
                                i5++;
                            } else {
                                i3++;
                                if ((i12 & 8) == 0) {
                                    i6++;
                                }
                            }
                        }
                    }
                }
                z4 = false;
            }
            if (i12 > 127 && i12 > 176 && i12 <= 247 && (i = i2 + 1) < length && (bArr2[i] & 255) > 160) {
            }
            if (z) {
                if (i12 > 127 && i12 < 160) {
                    z = false;
                } else if (i12 > 159 && i12 >= 192) {
                }
            }
            if (z3) {
                if (i7 > 0) {
                    if (i12 >= 64 && i12 != 127 && i12 <= 252) {
                        i7--;
                    }
                } else if (!(i12 == 128 || i12 == 160 || i12 > 239)) {
                    if (i12 <= 160 || i12 >= 224) {
                        if (i12 > 127) {
                            i7++;
                            int i13 = i10 + 1;
                            if (i13 > i9) {
                                i9 = i13;
                                i10 = i9;
                            } else {
                                i10 = i13;
                            }
                        } else {
                            i10 = 0;
                        }
                        i11 = 0;
                    } else {
                        int i14 = i11 + 1;
                        if (i14 > i8) {
                            i8 = i14;
                            i11 = i8;
                        } else {
                            i11 = i14;
                        }
                        i10 = 0;
                    }
                }
                z3 = false;
            }
            i2++;
            bArr2 = bArr;
        }
        if (z4 && i3 > 0) {
            z4 = false;
        }
        boolean z5 = (!z3 || i7 <= 0) ? z3 : false;
        if (z4 && (z2 || i4 + i5 + i6 > 0)) {
            return "UTF8";
        }
        if (z5) {
            return (ASSUME_SHIFT_JIS || i8 >= 3 || i9 >= 3) ? "SJIS" : "GB2312";
        }
        return "GB2312";
    }
}
