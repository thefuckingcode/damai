package okio;

import com.tencent.smtt.sdk.TbsListener;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.ByteCompanionObject;
import kotlin.jvm.internal.Intrinsics;

public final class Utf8 {
    public static final int HIGH_SURROGATE_HEADER;
    public static final int LOG_SURROGATE_HEADER;
    public static final int MASK_2BYTES;
    public static final int MASK_3BYTES;
    public static final int MASK_4BYTES;
    public static final byte REPLACEMENT_BYTE;
    public static final char REPLACEMENT_CHARACTER;
    public static final int REPLACEMENT_CODE_POINT;

    public static final boolean isIsoControl(int i) {
        return (i >= 0 && 31 >= i) || (127 <= i && 159 >= i);
    }

    public static final boolean isUtf8Continuation(byte b) {
        return (b & 192) == 128;
    }

    public static final long size(String str) {
        return size$default(str, 0, 0, 3, null);
    }

    public static final long size(String str, int i) {
        return size$default(str, i, 0, 2, null);
    }

    public static /* synthetic */ long size$default(String str, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = str.length();
        }
        return size(str, i, i2);
    }

    public static final long size(String str, int i, int i2) {
        int i3;
        char c;
        Intrinsics.checkParameterIsNotNull(str, "$this$utf8Size");
        boolean z = true;
        if (i >= 0) {
            if (i2 >= i) {
                if (i2 > str.length()) {
                    z = false;
                }
                if (z) {
                    long j = 0;
                    while (i < i2) {
                        char charAt = str.charAt(i);
                        if (charAt < 128) {
                            j++;
                        } else {
                            if (charAt < 2048) {
                                i3 = 2;
                            } else if (charAt < 55296 || charAt > 57343) {
                                i3 = 3;
                            } else {
                                int i4 = i + 1;
                                if (i4 < i2) {
                                    c = str.charAt(i4);
                                } else {
                                    c = 0;
                                }
                                if (charAt > 56319 || c < 56320 || c > 57343) {
                                    j++;
                                    i = i4;
                                } else {
                                    j += (long) 4;
                                    i += 2;
                                }
                            }
                            j += (long) i3;
                        }
                        i++;
                    }
                    return j;
                }
                throw new IllegalArgumentException(("endIndex > string.length: " + i2 + " > " + str.length()).toString());
            }
            throw new IllegalArgumentException(("endIndex < beginIndex: " + i2 + " < " + i).toString());
        }
        throw new IllegalArgumentException(("beginIndex < 0: " + i).toString());
    }

    public static final void processUtf8Bytes(String str, int i, int i2, Function1<? super Byte, Unit> function1) {
        int i3;
        char charAt;
        Intrinsics.checkParameterIsNotNull(str, "$this$processUtf8Bytes");
        Intrinsics.checkParameterIsNotNull(function1, "yield");
        while (i < i2) {
            char charAt2 = str.charAt(i);
            if (charAt2 < 128) {
                function1.invoke(Byte.valueOf((byte) charAt2));
                i++;
                while (i < i2 && str.charAt(i) < 128) {
                    function1.invoke(Byte.valueOf((byte) str.charAt(i)));
                    i++;
                }
            } else {
                if (charAt2 < 2048) {
                    function1.invoke(Byte.valueOf((byte) ((charAt2 >> 6) | 192)));
                    function1.invoke(Byte.valueOf((byte) ((charAt2 & '?') | 128)));
                } else if (55296 > charAt2 || 57343 < charAt2) {
                    function1.invoke(Byte.valueOf((byte) ((charAt2 >> '\f') | TbsListener.ErrorCode.EXCEED_INCR_UPDATE)));
                    function1.invoke(Byte.valueOf((byte) (((charAt2 >> 6) & 63) | 128)));
                    function1.invoke(Byte.valueOf((byte) ((charAt2 & '?') | 128)));
                } else if (charAt2 > 56319 || i2 <= (i3 = i + 1) || 56320 > (charAt = str.charAt(i3)) || 57343 < charAt) {
                    function1.invoke(Byte.valueOf((byte) REPLACEMENT_BYTE));
                } else {
                    int charAt3 = ((charAt2 << '\n') + str.charAt(i3)) - 56613888;
                    function1.invoke(Byte.valueOf((byte) ((charAt3 >> 18) | 240)));
                    function1.invoke(Byte.valueOf((byte) (((charAt3 >> 12) & 63) | 128)));
                    function1.invoke(Byte.valueOf((byte) (((charAt3 >> 6) & 63) | 128)));
                    function1.invoke(Byte.valueOf((byte) ((charAt3 & 63) | 128)));
                    i += 2;
                }
                i++;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0090, code lost:
        if (r8 == false) goto L_0x004b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0109, code lost:
        if (r8 == false) goto L_0x006c;
     */
    public static final void processUtf8CodePoints(byte[] bArr, int i, int i2, Function1<? super Integer, Unit> function1) {
        int i3;
        Intrinsics.checkParameterIsNotNull(bArr, "$this$processUtf8CodePoints");
        Intrinsics.checkParameterIsNotNull(function1, "yield");
        int i4 = i;
        while (i4 < i2) {
            byte b = bArr[i4];
            if (b >= 0) {
                function1.invoke(Integer.valueOf(b));
                i4++;
                while (i4 < i2 && bArr[i4] >= 0) {
                    function1.invoke(Integer.valueOf(bArr[i4]));
                    i4++;
                }
            } else {
                boolean z = false;
                if ((b >> 5) == -2) {
                    int i5 = i4 + 1;
                    if (i2 > i5) {
                        byte b2 = bArr[i4];
                        byte b3 = bArr[i5];
                        if ((b3 & 192) == 128) {
                            z = true;
                        }
                        if (z) {
                            int i6 = (b3 ^ ByteCompanionObject.MIN_VALUE) ^ (b2 << 6);
                            function1.invoke(i6 < 128 ? Integer.valueOf((int) REPLACEMENT_CODE_POINT) : Integer.valueOf(i6));
                            i3 = 2;
                            i4 += i3;
                        }
                    }
                    function1.invoke(Integer.valueOf((int) REPLACEMENT_CODE_POINT));
                } else {
                    if ((b >> 4) == -2) {
                        int i7 = i4 + 2;
                        if (i2 <= i7) {
                            function1.invoke(Integer.valueOf((int) REPLACEMENT_CODE_POINT));
                            int i8 = i4 + 1;
                            if (i2 > i8) {
                                if ((bArr[i8] & 192) == 128) {
                                    z = true;
                                }
                            }
                        } else {
                            byte b4 = bArr[i4];
                            byte b5 = bArr[i4 + 1];
                            if (!((b5 & 192) == 128)) {
                                function1.invoke(Integer.valueOf((int) REPLACEMENT_CODE_POINT));
                            } else {
                                byte b6 = bArr[i7];
                                if ((b6 & 192) == 128) {
                                    z = true;
                                }
                                if (!z) {
                                    function1.invoke(Integer.valueOf((int) REPLACEMENT_CODE_POINT));
                                    i3 = 2;
                                    i4 += i3;
                                } else {
                                    int i9 = ((b6 ^ ByteCompanionObject.MIN_VALUE) ^ (b5 << 6)) ^ (b4 << 12);
                                    function1.invoke((i9 >= 2048 && (55296 > i9 || 57343 < i9)) ? Integer.valueOf(i9) : Integer.valueOf((int) REPLACEMENT_CODE_POINT));
                                }
                            }
                        }
                    } else if ((b >> 3) == -2) {
                        int i10 = i4 + 3;
                        if (i2 <= i10) {
                            function1.invoke(Integer.valueOf((int) REPLACEMENT_CODE_POINT));
                            int i11 = i4 + 1;
                            if (i2 > i11) {
                                if ((bArr[i11] & 192) == 128) {
                                    int i12 = i4 + 2;
                                    if (i2 > i12) {
                                        if ((bArr[i12] & 192) == 128) {
                                            z = true;
                                        }
                                    }
                                    i3 = 2;
                                    i4 += i3;
                                }
                            }
                        } else {
                            byte b7 = bArr[i4];
                            byte b8 = bArr[i4 + 1];
                            if (!((b8 & 192) == 128)) {
                                function1.invoke(Integer.valueOf((int) REPLACEMENT_CODE_POINT));
                            } else {
                                byte b9 = bArr[i4 + 2];
                                if (!((b9 & 192) == 128)) {
                                    function1.invoke(Integer.valueOf((int) REPLACEMENT_CODE_POINT));
                                    i3 = 2;
                                    i4 += i3;
                                } else {
                                    byte b10 = bArr[i10];
                                    if ((b10 & 192) == 128) {
                                        z = true;
                                    }
                                    if (!z) {
                                        function1.invoke(Integer.valueOf((int) REPLACEMENT_CODE_POINT));
                                    } else {
                                        int i13 = (((b10 ^ ByteCompanionObject.MIN_VALUE) ^ (b9 << 6)) ^ (b8 << 12)) ^ (b7 << 18);
                                        function1.invoke((i13 <= 1114111 && (55296 > i13 || 57343 < i13) && i13 >= 65536) ? Integer.valueOf(i13) : Integer.valueOf((int) REPLACEMENT_CODE_POINT));
                                        i3 = 4;
                                        i4 += i3;
                                    }
                                }
                            }
                        }
                    } else {
                        function1.invoke(Integer.valueOf((int) REPLACEMENT_CODE_POINT));
                        i4++;
                    }
                    i3 = 3;
                    i4 += i3;
                }
                i3 = 1;
                i4 += i3;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0092, code lost:
        if (r8 == false) goto L_0x004e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x010b, code lost:
        if (r8 == false) goto L_0x006d;
     */
    public static final void processUtf16Chars(byte[] bArr, int i, int i2, Function1<? super Character, Unit> function1) {
        int i3;
        Intrinsics.checkParameterIsNotNull(bArr, "$this$processUtf16Chars");
        Intrinsics.checkParameterIsNotNull(function1, "yield");
        int i4 = i;
        while (i4 < i2) {
            byte b = bArr[i4];
            if (b >= 0) {
                function1.invoke(Character.valueOf((char) b));
                i4++;
                while (i4 < i2 && bArr[i4] >= 0) {
                    function1.invoke(Character.valueOf((char) bArr[i4]));
                    i4++;
                }
            } else {
                boolean z = false;
                if ((b >> 5) == -2) {
                    int i5 = i4 + 1;
                    if (i2 > i5) {
                        byte b2 = bArr[i4];
                        byte b3 = bArr[i5];
                        if ((b3 & 192) == 128) {
                            z = true;
                        }
                        if (z) {
                            int i6 = (b3 ^ ByteCompanionObject.MIN_VALUE) ^ (b2 << 6);
                            function1.invoke(Character.valueOf(i6 < 128 ? (char) REPLACEMENT_CODE_POINT : (char) i6));
                            i3 = 2;
                            i4 += i3;
                        }
                    }
                    function1.invoke(Character.valueOf((char) REPLACEMENT_CODE_POINT));
                } else {
                    if ((b >> 4) == -2) {
                        int i7 = i4 + 2;
                        if (i2 <= i7) {
                            function1.invoke(Character.valueOf((char) REPLACEMENT_CODE_POINT));
                            int i8 = i4 + 1;
                            if (i2 > i8) {
                                if ((bArr[i8] & 192) == 128) {
                                    z = true;
                                }
                            }
                        } else {
                            byte b4 = bArr[i4];
                            byte b5 = bArr[i4 + 1];
                            if (!((b5 & 192) == 128)) {
                                function1.invoke(Character.valueOf((char) REPLACEMENT_CODE_POINT));
                            } else {
                                byte b6 = bArr[i7];
                                if ((b6 & 192) == 128) {
                                    z = true;
                                }
                                if (!z) {
                                    function1.invoke(Character.valueOf((char) REPLACEMENT_CODE_POINT));
                                    i3 = 2;
                                    i4 += i3;
                                } else {
                                    int i9 = ((b6 ^ ByteCompanionObject.MIN_VALUE) ^ (b5 << 6)) ^ (b4 << 12);
                                    function1.invoke(Character.valueOf((i9 >= 2048 && (55296 > i9 || 57343 < i9)) ? (char) i9 : (char) REPLACEMENT_CODE_POINT));
                                }
                            }
                        }
                    } else if ((b >> 3) == -2) {
                        int i10 = i4 + 3;
                        if (i2 <= i10) {
                            function1.invoke(Character.valueOf(REPLACEMENT_CHARACTER));
                            int i11 = i4 + 1;
                            if (i2 > i11) {
                                if ((bArr[i11] & 192) == 128) {
                                    int i12 = i4 + 2;
                                    if (i2 > i12) {
                                        if ((bArr[i12] & 192) == 128) {
                                            z = true;
                                        }
                                    }
                                    i3 = 2;
                                    i4 += i3;
                                }
                            }
                        } else {
                            byte b7 = bArr[i4];
                            byte b8 = bArr[i4 + 1];
                            if (!((b8 & 192) == 128)) {
                                function1.invoke(Character.valueOf(REPLACEMENT_CHARACTER));
                            } else {
                                byte b9 = bArr[i4 + 2];
                                if (!((b9 & 192) == 128)) {
                                    function1.invoke(Character.valueOf(REPLACEMENT_CHARACTER));
                                    i3 = 2;
                                    i4 += i3;
                                } else {
                                    byte b10 = bArr[i10];
                                    if ((b10 & 192) == 128) {
                                        z = true;
                                    }
                                    if (!z) {
                                        function1.invoke(Character.valueOf(REPLACEMENT_CHARACTER));
                                    } else {
                                        int i13 = (((b10 ^ ByteCompanionObject.MIN_VALUE) ^ (b9 << 6)) ^ (b8 << 12)) ^ (b7 << 18);
                                        if (i13 <= 1114111 && ((55296 > i13 || 57343 < i13) && i13 >= 65536 && i13 != 65533)) {
                                            function1.invoke(Character.valueOf((char) ((i13 >>> 10) + HIGH_SURROGATE_HEADER)));
                                            function1.invoke(Character.valueOf((char) ((i13 & 1023) + LOG_SURROGATE_HEADER)));
                                        } else {
                                            function1.invoke(Character.valueOf(REPLACEMENT_CHARACTER));
                                        }
                                        i3 = 4;
                                        i4 += i3;
                                    }
                                }
                            }
                        }
                    } else {
                        function1.invoke(Character.valueOf(REPLACEMENT_CHARACTER));
                        i4++;
                    }
                    i3 = 3;
                    i4 += i3;
                }
                i3 = 1;
                i4 += i3;
            }
        }
    }

    public static final int process2Utf8Bytes(byte[] bArr, int i, int i2, Function1<? super Integer, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(bArr, "$this$process2Utf8Bytes");
        Intrinsics.checkParameterIsNotNull(function1, "yield");
        int i3 = i + 1;
        Integer valueOf = Integer.valueOf((int) REPLACEMENT_CODE_POINT);
        if (i2 <= i3) {
            function1.invoke(valueOf);
            return 1;
        }
        byte b = bArr[i];
        byte b2 = bArr[i3];
        if (!((b2 & 192) == 128)) {
            function1.invoke(valueOf);
            return 1;
        }
        int i4 = (b2 ^ ByteCompanionObject.MIN_VALUE) ^ (b << 6);
        if (i4 < 128) {
            function1.invoke(valueOf);
            return 2;
        }
        function1.invoke(Integer.valueOf(i4));
        return 2;
    }

    public static final int process3Utf8Bytes(byte[] bArr, int i, int i2, Function1<? super Integer, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(bArr, "$this$process3Utf8Bytes");
        Intrinsics.checkParameterIsNotNull(function1, "yield");
        int i3 = i + 2;
        boolean z = false;
        Integer valueOf = Integer.valueOf((int) REPLACEMENT_CODE_POINT);
        if (i2 <= i3) {
            function1.invoke(valueOf);
            int i4 = i + 1;
            if (i2 > i4) {
                if ((bArr[i4] & 192) == 128) {
                    z = true;
                }
                return !z ? 1 : 2;
            }
        }
        byte b = bArr[i];
        byte b2 = bArr[i + 1];
        if (!((b2 & 192) == 128)) {
            function1.invoke(valueOf);
            return 1;
        }
        byte b3 = bArr[i3];
        if ((b3 & 192) == 128) {
            z = true;
        }
        if (!z) {
            function1.invoke(valueOf);
            return 2;
        }
        int i5 = ((b3 ^ ByteCompanionObject.MIN_VALUE) ^ (b2 << 6)) ^ (b << 12);
        if (i5 < 2048) {
            function1.invoke(valueOf);
            return 3;
        } else if (55296 <= i5 && 57343 >= i5) {
            function1.invoke(valueOf);
            return 3;
        } else {
            function1.invoke(Integer.valueOf(i5));
            return 3;
        }
    }

    public static final int process4Utf8Bytes(byte[] bArr, int i, int i2, Function1<? super Integer, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(bArr, "$this$process4Utf8Bytes");
        Intrinsics.checkParameterIsNotNull(function1, "yield");
        int i3 = i + 3;
        boolean z = false;
        Integer valueOf = Integer.valueOf((int) REPLACEMENT_CODE_POINT);
        if (i2 <= i3) {
            function1.invoke(valueOf);
            int i4 = i + 1;
            if (i2 > i4) {
                if ((bArr[i4] & 192) == 128) {
                    int i5 = i + 2;
                    if (i2 > i5) {
                        if ((bArr[i5] & 192) == 128) {
                            z = true;
                        }
                        return !z ? 2 : 3;
                    }
                }
            }
            return 1;
        }
        byte b = bArr[i];
        byte b2 = bArr[i + 1];
        if (!((b2 & 192) == 128)) {
            function1.invoke(valueOf);
            return 1;
        }
        byte b3 = bArr[i + 2];
        if (!((b3 & 192) == 128)) {
            function1.invoke(valueOf);
            return 2;
        }
        byte b4 = bArr[i3];
        if ((b4 & 192) == 128) {
            z = true;
        }
        if (!z) {
            function1.invoke(valueOf);
            return 3;
        }
        int i6 = (((b4 ^ ByteCompanionObject.MIN_VALUE) ^ (b3 << 6)) ^ (b2 << 12)) ^ (b << 18);
        if (i6 > 1114111) {
            function1.invoke(valueOf);
            return 4;
        } else if (55296 <= i6 && 57343 >= i6) {
            function1.invoke(valueOf);
            return 4;
        } else if (i6 < 65536) {
            function1.invoke(valueOf);
            return 4;
        } else {
            function1.invoke(Integer.valueOf(i6));
            return 4;
        }
    }
}
