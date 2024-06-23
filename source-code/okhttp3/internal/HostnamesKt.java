package okhttp3.internal;

import java.net.IDN;
import java.net.InetAddress;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okio.Buffer;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a0\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005H\u0002\u001a\"\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0002\u001a\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0002\u001a\f\u0010\r\u001a\u00020\u0001*\u00020\u0003H\u0002\u001a\f\u0010\u000e\u001a\u0004\u0018\u00010\u0003*\u00020\u0003¨\u0006\u000f"}, d2 = {"decodeIpv4Suffix", "", "input", "", "pos", "", "limit", "address", "", "addressOffset", "decodeIpv6", "Ljava/net/InetAddress;", "inet6AddressToAscii", "containsInvalidHostnameAsciiCodes", "toCanonicalHost", "okhttp"}, k = 2, mv = {1, 1, 16})
/* compiled from: hostnames.kt */
public final class HostnamesKt {
    public static final String toCanonicalHost(String str) {
        InetAddress inetAddress;
        Intrinsics.checkParameterIsNotNull(str, "$this$toCanonicalHost");
        boolean z = false;
        if (StringsKt.contains$default((CharSequence) str, (CharSequence) ":", false, 2, (Object) null)) {
            if (!StringsKt.startsWith$default(str, "[", false, 2, (Object) null) || !StringsKt.endsWith$default(str, "]", false, 2, (Object) null)) {
                inetAddress = decodeIpv6(str, 0, str.length());
            } else {
                inetAddress = decodeIpv6(str, 1, str.length() - 1);
            }
            if (inetAddress == null) {
                return null;
            }
            byte[] address = inetAddress.getAddress();
            if (address.length == 16) {
                Intrinsics.checkExpressionValueIsNotNull(address, "address");
                return inet6AddressToAscii(address);
            } else if (address.length == 4) {
                return inetAddress.getHostAddress();
            } else {
                throw new AssertionError("Invalid IPv6 address: '" + str + '\'');
            }
        } else {
            try {
                String ascii = IDN.toASCII(str);
                Intrinsics.checkExpressionValueIsNotNull(ascii, "IDN.toASCII(host)");
                Locale locale = Locale.US;
                Intrinsics.checkExpressionValueIsNotNull(locale, "Locale.US");
                if (ascii != null) {
                    String lowerCase = ascii.toLowerCase(locale);
                    Intrinsics.checkExpressionValueIsNotNull(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                    if (lowerCase.length() == 0) {
                        z = true;
                    }
                    if (z) {
                        return null;
                    }
                    if (containsInvalidHostnameAsciiCodes(lowerCase)) {
                        return null;
                    }
                    return lowerCase;
                }
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }
    }

    private static final boolean containsInvalidHostnameAsciiCodes(String str) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt <= 31 || charAt >= 127 || StringsKt.indexOf$default((CharSequence) " #%/:?@[\\]", charAt, 0, false, 6, (Object) null) != -1) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0097, code lost:
        if (r13 == 16) goto L_0x00aa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0099, code lost:
        if (r14 != -1) goto L_0x009c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x009b, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x009c, code lost:
        r0 = r13 - r14;
        java.lang.System.arraycopy(r9, r14, r9, 16 - r0, r0);
        java.util.Arrays.fill(r9, r14, (16 - r13) + r14, (byte) 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00ae, code lost:
        return java.net.InetAddress.getByAddress(r9);
     */
    private static final InetAddress decodeIpv6(String str, int i, int i2) {
        byte[] bArr = new byte[16];
        int i3 = i;
        int i4 = 0;
        int i5 = -1;
        int i6 = -1;
        while (true) {
            if (i3 >= i2) {
                break;
            } else if (i4 == 16) {
                return null;
            } else {
                int i7 = i3 + 2;
                if (i7 > i2 || !StringsKt.startsWith$default(str, "::", i3, false, 4, (Object) null)) {
                    if (i4 != 0) {
                        if (StringsKt.startsWith$default(str, ":", i3, false, 4, (Object) null)) {
                            i3++;
                        } else if (!StringsKt.startsWith$default(str, ".", i3, false, 4, (Object) null) || !decodeIpv4Suffix(str, i6, i2, bArr, i4 - 2)) {
                            return null;
                        } else {
                            i4 += 2;
                        }
                    }
                    i6 = i3;
                } else if (i5 != -1) {
                    return null;
                } else {
                    i4 += 2;
                    if (i7 == i2) {
                        i5 = i4;
                        break;
                    }
                    i6 = i7;
                    i5 = i4;
                }
                i3 = i6;
                int i8 = 0;
                while (i3 < i2) {
                    int parseHexDigit = Util.parseHexDigit(str.charAt(i3));
                    if (parseHexDigit == -1) {
                        break;
                    }
                    i8 = (i8 << 4) + parseHexDigit;
                    i3++;
                }
                int i9 = i3 - i6;
                if (i9 == 0 || i9 > 4) {
                    return null;
                }
                int i10 = i4 + 1;
                bArr[i4] = (byte) ((i8 >>> 8) & 255);
                i4 = i10 + 1;
                bArr[i10] = (byte) (i8 & 255);
            }
        }
        return null;
    }

    private static final boolean decodeIpv4Suffix(String str, int i, int i2, byte[] bArr, int i3) {
        int i4 = i3;
        while (i < i2) {
            if (i4 == bArr.length) {
                return false;
            }
            if (i4 != i3) {
                if (str.charAt(i) != '.') {
                    return false;
                }
                i++;
            }
            int i5 = i;
            int i6 = 0;
            while (i5 < i2) {
                char charAt = str.charAt(i5);
                if (charAt < '0' || charAt > '9') {
                    break;
                } else if ((i6 == 0 && i != i5) || (i6 = ((i6 * 10) + charAt) - 48) > 255) {
                    return false;
                } else {
                    i5++;
                }
            }
            if (i5 - i == 0) {
                return false;
            }
            bArr[i4] = (byte) i6;
            i4++;
            i = i5;
        }
        if (i4 == i3 + 4) {
            return true;
        }
        return false;
    }

    private static final String inet6AddressToAscii(byte[] bArr) {
        int i = 0;
        int i2 = -1;
        int i3 = 0;
        int i4 = 0;
        while (i3 < bArr.length) {
            int i5 = i3;
            while (i5 < 16 && bArr[i5] == 0 && bArr[i5 + 1] == 0) {
                i5 += 2;
            }
            int i6 = i5 - i3;
            if (i6 > i4 && i6 >= 4) {
                i2 = i3;
                i4 = i6;
            }
            i3 = i5 + 2;
        }
        Buffer buffer = new Buffer();
        while (i < bArr.length) {
            if (i == i2) {
                buffer.writeByte(58);
                i += i4;
                if (i == 16) {
                    buffer.writeByte(58);
                }
            } else {
                if (i > 0) {
                    buffer.writeByte(58);
                }
                buffer.writeHexadecimalUnsignedLong((long) ((Util.and(bArr[i], 255) << 8) | Util.and(bArr[i + 1], 255)));
                i += 2;
            }
        }
        return buffer.readUtf8();
    }
}
