package okio.internal;

import com.lzy.okgo.cache.CacheEntity;
import java.util.Arrays;
import kotlin.TypeCastException;
import kotlin.UByte;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.ByteCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okio.Base64;
import okio.Buffer;
import okio.ByteString;
import okio.Platform;
import okio.Util;

public final class ByteStringKt {
    private static final char[] HEX_DIGIT_CHARS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static final String commonUtf8(ByteString byteString) {
        Intrinsics.checkParameterIsNotNull(byteString, "$this$commonUtf8");
        String utf8$okio = byteString.getUtf8$okio();
        if (utf8$okio != null) {
            return utf8$okio;
        }
        String utf8String = Platform.toUtf8String(byteString.internalArray$okio());
        byteString.setUtf8$okio(utf8String);
        return utf8String;
    }

    public static final String commonBase64(ByteString byteString) {
        Intrinsics.checkParameterIsNotNull(byteString, "$this$commonBase64");
        return Base64.encodeBase64$default(byteString.getData$okio(), null, 1, null);
    }

    public static final String commonBase64Url(ByteString byteString) {
        Intrinsics.checkParameterIsNotNull(byteString, "$this$commonBase64Url");
        return Base64.encodeBase64(byteString.getData$okio(), Base64.getBASE64_URL_SAFE());
    }

    public static final char[] getHEX_DIGIT_CHARS() {
        return HEX_DIGIT_CHARS;
    }

    public static final String commonHex(ByteString byteString) {
        Intrinsics.checkParameterIsNotNull(byteString, "$this$commonHex");
        char[] cArr = new char[(byteString.getData$okio().length * 2)];
        byte[] data$okio = byteString.getData$okio();
        int i = 0;
        for (byte b : data$okio) {
            int i2 = i + 1;
            cArr[i] = getHEX_DIGIT_CHARS()[(b >> 4) & 15];
            i = i2 + 1;
            cArr[i2] = getHEX_DIGIT_CHARS()[b & 15];
        }
        return new String(cArr);
    }

    public static final ByteString commonToAsciiLowercase(ByteString byteString) {
        byte b;
        Intrinsics.checkParameterIsNotNull(byteString, "$this$commonToAsciiLowercase");
        for (int i = 0; i < byteString.getData$okio().length; i++) {
            byte b2 = byteString.getData$okio()[i];
            byte b3 = (byte) 65;
            if (b2 >= b3 && b2 <= (b = (byte) 90)) {
                byte[] data$okio = byteString.getData$okio();
                byte[] copyOf = Arrays.copyOf(data$okio, data$okio.length);
                Intrinsics.checkExpressionValueIsNotNull(copyOf, "java.util.Arrays.copyOf(this, size)");
                copyOf[i] = (byte) (b2 + 32);
                for (int i2 = i + 1; i2 < copyOf.length; i2++) {
                    byte b4 = copyOf[i2];
                    if (b4 >= b3 && b4 <= b) {
                        copyOf[i2] = (byte) (b4 + 32);
                    }
                }
                return new ByteString(copyOf);
            }
        }
        return byteString;
    }

    public static final ByteString commonToAsciiUppercase(ByteString byteString) {
        byte b;
        Intrinsics.checkParameterIsNotNull(byteString, "$this$commonToAsciiUppercase");
        for (int i = 0; i < byteString.getData$okio().length; i++) {
            byte b2 = byteString.getData$okio()[i];
            byte b3 = (byte) 97;
            if (b2 >= b3 && b2 <= (b = (byte) 122)) {
                byte[] data$okio = byteString.getData$okio();
                byte[] copyOf = Arrays.copyOf(data$okio, data$okio.length);
                Intrinsics.checkExpressionValueIsNotNull(copyOf, "java.util.Arrays.copyOf(this, size)");
                copyOf[i] = (byte) (b2 - 32);
                for (int i2 = i + 1; i2 < copyOf.length; i2++) {
                    byte b4 = copyOf[i2];
                    if (b4 >= b3 && b4 <= b) {
                        copyOf[i2] = (byte) (b4 - 32);
                    }
                }
                return new ByteString(copyOf);
            }
        }
        return byteString;
    }

    public static final ByteString commonSubstring(ByteString byteString, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(byteString, "$this$commonSubstring");
        boolean z = true;
        if (i >= 0) {
            if (i2 <= byteString.getData$okio().length) {
                if (i2 - i < 0) {
                    z = false;
                }
                if (!z) {
                    throw new IllegalArgumentException("endIndex < beginIndex".toString());
                } else if (i == 0 && i2 == byteString.getData$okio().length) {
                    return byteString;
                } else {
                    return new ByteString(ArraysKt.copyOfRange(byteString.getData$okio(), i, i2));
                }
            } else {
                throw new IllegalArgumentException(("endIndex > length(" + byteString.getData$okio().length + ')').toString());
            }
        } else {
            throw new IllegalArgumentException("beginIndex < 0".toString());
        }
    }

    public static final byte commonGetByte(ByteString byteString, int i) {
        Intrinsics.checkParameterIsNotNull(byteString, "$this$commonGetByte");
        return byteString.getData$okio()[i];
    }

    public static final int commonGetSize(ByteString byteString) {
        Intrinsics.checkParameterIsNotNull(byteString, "$this$commonGetSize");
        return byteString.getData$okio().length;
    }

    public static final byte[] commonToByteArray(ByteString byteString) {
        Intrinsics.checkParameterIsNotNull(byteString, "$this$commonToByteArray");
        byte[] data$okio = byteString.getData$okio();
        byte[] copyOf = Arrays.copyOf(data$okio, data$okio.length);
        Intrinsics.checkExpressionValueIsNotNull(copyOf, "java.util.Arrays.copyOf(this, size)");
        return copyOf;
    }

    public static final byte[] commonInternalArray(ByteString byteString) {
        Intrinsics.checkParameterIsNotNull(byteString, "$this$commonInternalArray");
        return byteString.getData$okio();
    }

    public static final boolean commonRangeEquals(ByteString byteString, int i, ByteString byteString2, int i2, int i3) {
        Intrinsics.checkParameterIsNotNull(byteString, "$this$commonRangeEquals");
        Intrinsics.checkParameterIsNotNull(byteString2, "other");
        return byteString2.rangeEquals(i2, byteString.getData$okio(), i, i3);
    }

    public static final boolean commonRangeEquals(ByteString byteString, int i, byte[] bArr, int i2, int i3) {
        Intrinsics.checkParameterIsNotNull(byteString, "$this$commonRangeEquals");
        Intrinsics.checkParameterIsNotNull(bArr, "other");
        return i >= 0 && i <= byteString.getData$okio().length - i3 && i2 >= 0 && i2 <= bArr.length - i3 && Util.arrayRangeEquals(byteString.getData$okio(), i, bArr, i2, i3);
    }

    public static final boolean commonStartsWith(ByteString byteString, ByteString byteString2) {
        Intrinsics.checkParameterIsNotNull(byteString, "$this$commonStartsWith");
        Intrinsics.checkParameterIsNotNull(byteString2, "prefix");
        return byteString.rangeEquals(0, byteString2, 0, byteString2.size());
    }

    public static final boolean commonStartsWith(ByteString byteString, byte[] bArr) {
        Intrinsics.checkParameterIsNotNull(byteString, "$this$commonStartsWith");
        Intrinsics.checkParameterIsNotNull(bArr, "prefix");
        return byteString.rangeEquals(0, bArr, 0, bArr.length);
    }

    public static final boolean commonEndsWith(ByteString byteString, ByteString byteString2) {
        Intrinsics.checkParameterIsNotNull(byteString, "$this$commonEndsWith");
        Intrinsics.checkParameterIsNotNull(byteString2, "suffix");
        return byteString.rangeEquals(byteString.size() - byteString2.size(), byteString2, 0, byteString2.size());
    }

    public static final boolean commonEndsWith(ByteString byteString, byte[] bArr) {
        Intrinsics.checkParameterIsNotNull(byteString, "$this$commonEndsWith");
        Intrinsics.checkParameterIsNotNull(bArr, "suffix");
        return byteString.rangeEquals(byteString.size() - bArr.length, bArr, 0, bArr.length);
    }

    public static final int commonIndexOf(ByteString byteString, byte[] bArr, int i) {
        Intrinsics.checkParameterIsNotNull(byteString, "$this$commonIndexOf");
        Intrinsics.checkParameterIsNotNull(bArr, "other");
        int length = byteString.getData$okio().length - bArr.length;
        int max = Math.max(i, 0);
        if (max > length) {
            return -1;
        }
        while (!Util.arrayRangeEquals(byteString.getData$okio(), max, bArr, 0, bArr.length)) {
            if (max == length) {
                return -1;
            }
            max++;
        }
        return max;
    }

    public static final int commonLastIndexOf(ByteString byteString, ByteString byteString2, int i) {
        Intrinsics.checkParameterIsNotNull(byteString, "$this$commonLastIndexOf");
        Intrinsics.checkParameterIsNotNull(byteString2, "other");
        return byteString.lastIndexOf(byteString2.internalArray$okio(), i);
    }

    public static final int commonLastIndexOf(ByteString byteString, byte[] bArr, int i) {
        Intrinsics.checkParameterIsNotNull(byteString, "$this$commonLastIndexOf");
        Intrinsics.checkParameterIsNotNull(bArr, "other");
        for (int min = Math.min(i, byteString.getData$okio().length - bArr.length); min >= 0; min--) {
            if (Util.arrayRangeEquals(byteString.getData$okio(), min, bArr, 0, bArr.length)) {
                return min;
            }
        }
        return -1;
    }

    public static final boolean commonEquals(ByteString byteString, Object obj) {
        Intrinsics.checkParameterIsNotNull(byteString, "$this$commonEquals");
        if (obj == byteString) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString2 = (ByteString) obj;
            return byteString2.size() == byteString.getData$okio().length && byteString2.rangeEquals(0, byteString.getData$okio(), 0, byteString.getData$okio().length);
        }
    }

    public static final int commonHashCode(ByteString byteString) {
        Intrinsics.checkParameterIsNotNull(byteString, "$this$commonHashCode");
        int hashCode$okio = byteString.getHashCode$okio();
        if (hashCode$okio != 0) {
            return hashCode$okio;
        }
        int hashCode = Arrays.hashCode(byteString.getData$okio());
        byteString.setHashCode$okio(hashCode);
        return hashCode;
    }

    public static final int commonCompareTo(ByteString byteString, ByteString byteString2) {
        Intrinsics.checkParameterIsNotNull(byteString, "$this$commonCompareTo");
        Intrinsics.checkParameterIsNotNull(byteString2, "other");
        int size = byteString.size();
        int size2 = byteString2.size();
        int min = Math.min(size, size2);
        for (int i = 0; i < min; i++) {
            int i2 = byteString.getByte(i) & UByte.MAX_VALUE;
            int i3 = byteString2.getByte(i) & UByte.MAX_VALUE;
            if (i2 != i3) {
                if (i2 < i3) {
                    return -1;
                } else {
                    return 1;
                }
            }
        }
        if (size == size2) {
            return 0;
        }
        if (size < size2) {
            return -1;
        }
        return 1;
    }

    public static final ByteString commonOf(byte[] bArr) {
        Intrinsics.checkParameterIsNotNull(bArr, CacheEntity.DATA);
        byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
        Intrinsics.checkExpressionValueIsNotNull(copyOf, "java.util.Arrays.copyOf(this, size)");
        return new ByteString(copyOf);
    }

    public static final ByteString commonToByteString(byte[] bArr, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(bArr, "$this$commonToByteString");
        Util.checkOffsetAndCount((long) bArr.length, (long) i, (long) i2);
        return new ByteString(ArraysKt.copyOfRange(bArr, i, i2 + i));
    }

    public static final ByteString commonEncodeUtf8(String str) {
        Intrinsics.checkParameterIsNotNull(str, "$this$commonEncodeUtf8");
        ByteString byteString = new ByteString(Platform.asUtf8ToByteArray(str));
        byteString.setUtf8$okio(str);
        return byteString;
    }

    public static final ByteString commonDecodeBase64(String str) {
        Intrinsics.checkParameterIsNotNull(str, "$this$commonDecodeBase64");
        byte[] decodeBase64ToArray = Base64.decodeBase64ToArray(str);
        if (decodeBase64ToArray != null) {
            return new ByteString(decodeBase64ToArray);
        }
        return null;
    }

    public static final ByteString commonDecodeHex(String str) {
        Intrinsics.checkParameterIsNotNull(str, "$this$commonDecodeHex");
        if (str.length() % 2 == 0) {
            int length = str.length() / 2;
            byte[] bArr = new byte[length];
            for (int i = 0; i < length; i++) {
                int i2 = i * 2;
                bArr[i] = (byte) ((decodeHexDigit(str.charAt(i2)) << 4) + decodeHexDigit(str.charAt(i2 + 1)));
            }
            return new ByteString(bArr);
        }
        throw new IllegalArgumentException(("Unexpected hex string: " + str).toString());
    }

    public static final void commonWrite(ByteString byteString, Buffer buffer, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(byteString, "$this$commonWrite");
        Intrinsics.checkParameterIsNotNull(buffer, "buffer");
        buffer.write(byteString.getData$okio(), i, i2);
    }

    public static final int decodeHexDigit(char c) {
        if ('0' <= c && '9' >= c) {
            return c - '0';
        }
        char c2 = 'a';
        if ('a' > c || 'f' < c) {
            c2 = 'A';
            if ('A' > c || 'F' < c) {
                throw new IllegalArgumentException("Unexpected hex digit: " + c);
            }
        }
        return (c - c2) + 10;
    }

    public static final String commonToString(ByteString byteString) {
        ByteString byteString2 = byteString;
        Intrinsics.checkParameterIsNotNull(byteString2, "$this$commonToString");
        boolean z = true;
        if (byteString.getData$okio().length == 0) {
            return "[size=0]";
        }
        int codePointIndexToCharIndex = codePointIndexToCharIndex(byteString.getData$okio(), 64);
        if (codePointIndexToCharIndex != -1) {
            String utf8 = byteString.utf8();
            if (utf8 != null) {
                String substring = utf8.substring(0, codePointIndexToCharIndex);
                Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                String replace$default = StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(substring, "\\", "\\\\", false, 4, (Object) null), "\n", "\\n", false, 4, (Object) null), "\r", "\\r", false, 4, (Object) null);
                if (codePointIndexToCharIndex < utf8.length()) {
                    return "[size=" + byteString.getData$okio().length + " text=" + replace$default + "…]";
                }
                return "[text=" + replace$default + ']';
            }
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        } else if (byteString.getData$okio().length <= 64) {
            return "[hex=" + byteString.hex() + ']';
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("[size=");
            sb.append(byteString.getData$okio().length);
            sb.append(" hex=");
            if (64 > byteString.getData$okio().length) {
                z = false;
            }
            if (z) {
                if (64 != byteString.getData$okio().length) {
                    byteString2 = new ByteString(ArraysKt.copyOfRange(byteString.getData$okio(), 0, 64));
                }
                sb.append(byteString2.hex());
                sb.append("…]");
                return sb.toString();
            }
            throw new IllegalArgumentException(("endIndex > length(" + byteString.getData$okio().length + ')').toString());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0068, code lost:
        return -1;
     */
    public static final int codePointIndexToCharIndex(byte[] bArr, int i) {
        int i2;
        int length = bArr.length;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        loop0:
        while (i3 < length) {
            byte b = bArr[i3];
            if (b >= 0) {
                int i6 = i5 + 1;
                if (i5 != i) {
                    if (!(b == 10 || b == 13)) {
                        if ((b >= 0 && 31 >= b) || (Byte.MAX_VALUE <= b && 159 >= b)) {
                            return -1;
                        }
                    }
                    if (b != 65533) {
                        i4 += b < 65536 ? 1 : 2;
                        i3++;
                        while (true) {
                            i5 = i6;
                            if (i3 >= length || bArr[i3] < 0) {
                                break;
                            }
                            int i7 = i3 + 1;
                            byte b2 = bArr[i3];
                            i6 = i5 + 1;
                            if (i5 == i) {
                                return i4;
                            }
                            if (!(b2 == 10 || b2 == 13)) {
                                if ((b2 >= 0 && 31 >= b2) || (Byte.MAX_VALUE <= b2 && 159 >= b2)) {
                                    break loop0;
                                }
                            }
                            if (b2 == 65533) {
                                break loop0;
                            }
                            i4 += b2 < 65536 ? 1 : 2;
                            i3 = i7;
                        }
                    } else {
                        return -1;
                    }
                } else {
                    return i4;
                }
            } else {
                if ((b >> 5) == -2) {
                    int i8 = i3 + 1;
                    if (length > i8) {
                        byte b3 = bArr[i3];
                        byte b4 = bArr[i8];
                        if ((b4 & 192) == 128) {
                            int i9 = (b4 ^ ByteCompanionObject.MIN_VALUE) ^ (b3 << 6);
                            if (i9 >= 128) {
                                i2 = i5 + 1;
                                if (i5 == i) {
                                    return i4;
                                }
                                if (!(i9 == 10 || i9 == 13)) {
                                    if ((i9 >= 0 && 31 >= i9) || (127 <= i9 && 159 >= i9)) {
                                        return -1;
                                    }
                                }
                                if (i9 == 65533) {
                                    return -1;
                                }
                                i4 += i9 < 65536 ? 1 : 2;
                                i3 += 2;
                            } else if (i5 == i) {
                                return i4;
                            } else {
                                return -1;
                            }
                        } else if (i5 == i) {
                            return i4;
                        } else {
                            return -1;
                        }
                    } else if (i5 == i) {
                        return i4;
                    } else {
                        return -1;
                    }
                } else if ((b >> 4) == -2) {
                    int i10 = i3 + 2;
                    if (length > i10) {
                        byte b5 = bArr[i3];
                        byte b6 = bArr[i3 + 1];
                        if ((b6 & 192) == 128) {
                            byte b7 = bArr[i10];
                            if ((b7 & 192) == 128) {
                                int i11 = ((b7 ^ ByteCompanionObject.MIN_VALUE) ^ (b6 << 6)) ^ (b5 << 12);
                                if (i11 < 2048) {
                                    if (i5 == i) {
                                        return i4;
                                    }
                                    return -1;
                                } else if (55296 > i11 || 57343 < i11) {
                                    i2 = i5 + 1;
                                    if (i5 == i) {
                                        return i4;
                                    }
                                    if (!(i11 == 10 || i11 == 13)) {
                                        if ((i11 >= 0 && 31 >= i11) || (127 <= i11 && 159 >= i11)) {
                                            return -1;
                                        }
                                    }
                                    if (i11 == 65533) {
                                        return -1;
                                    }
                                    i4 += i11 < 65536 ? 1 : 2;
                                    i3 += 3;
                                } else if (i5 == i) {
                                    return i4;
                                } else {
                                    return -1;
                                }
                            } else if (i5 == i) {
                                return i4;
                            } else {
                                return -1;
                            }
                        } else if (i5 == i) {
                            return i4;
                        } else {
                            return -1;
                        }
                    } else if (i5 == i) {
                        return i4;
                    } else {
                        return -1;
                    }
                } else if ((b >> 3) == -2) {
                    int i12 = i3 + 3;
                    if (length > i12) {
                        byte b8 = bArr[i3];
                        byte b9 = bArr[i3 + 1];
                        if ((b9 & 192) == 128) {
                            byte b10 = bArr[i3 + 2];
                            if ((b10 & 192) == 128) {
                                byte b11 = bArr[i12];
                                if ((b11 & 192) == 128) {
                                    int i13 = (((b11 ^ ByteCompanionObject.MIN_VALUE) ^ (b10 << 6)) ^ (b9 << 12)) ^ (b8 << 18);
                                    if (i13 > 1114111) {
                                        if (i5 == i) {
                                            return i4;
                                        }
                                        return -1;
                                    } else if (55296 <= i13 && 57343 >= i13) {
                                        if (i5 == i) {
                                            return i4;
                                        }
                                        return -1;
                                    } else if (i13 >= 65536) {
                                        i2 = i5 + 1;
                                        if (i5 == i) {
                                            return i4;
                                        }
                                        if (!(i13 == 10 || i13 == 13)) {
                                            if ((i13 >= 0 && 31 >= i13) || (127 <= i13 && 159 >= i13)) {
                                                return -1;
                                            }
                                        }
                                        if (i13 == 65533) {
                                            return -1;
                                        }
                                        i4 += i13 < 65536 ? 1 : 2;
                                        i3 += 4;
                                    } else if (i5 == i) {
                                        return i4;
                                    } else {
                                        return -1;
                                    }
                                } else if (i5 == i) {
                                    return i4;
                                } else {
                                    return -1;
                                }
                            } else if (i5 == i) {
                                return i4;
                            } else {
                                return -1;
                            }
                        } else if (i5 == i) {
                            return i4;
                        } else {
                            return -1;
                        }
                    } else if (i5 == i) {
                        return i4;
                    } else {
                        return -1;
                    }
                } else if (i5 == i) {
                    return i4;
                } else {
                    return -1;
                }
                i5 = i2;
            }
        }
        return i4;
    }
}
