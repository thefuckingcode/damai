package com.google.protobuf;

import com.autonavi.amap.mapcore.tools.GlMapUtil;
import com.youku.arch.v3.data.Constants;
import java.nio.ByteBuffer;
import tb.jl1;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class Utf8 {
    public static final int COMPLETE = 0;
    public static final int MALFORMED = -1;
    private static final a a = (c.i() ? new c() : new b());

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class UnpairedSurrogateException extends IllegalArgumentException {
        UnpairedSurrogateException(int i, int i2) {
            super("Unpaired surrogate at index " + i + " of " + i2);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static abstract class a {
        a() {
        }

        private static int f(ByteBuffer byteBuffer, int i, int i2) {
            int j = i + Utf8.j(byteBuffer, i, i2);
            while (j < i2) {
                int i3 = j + 1;
                byte b = byteBuffer.get(j);
                if (b < 0) {
                    if (b < -32) {
                        if (i3 >= i2) {
                            return b;
                        }
                        if (b < -62 || byteBuffer.get(i3) > -65) {
                            return -1;
                        }
                        i3++;
                    } else if (b < -16) {
                        if (i3 >= i2 - 1) {
                            return Utf8.n(byteBuffer, b, i3, i2 - i3);
                        }
                        int i4 = i3 + 1;
                        byte b2 = byteBuffer.get(i3);
                        if (b2 > -65 || ((b == -32 && b2 < -96) || ((b == -19 && b2 >= -96) || byteBuffer.get(i4) > -65))) {
                            return -1;
                        }
                        j = i4 + 1;
                    } else if (i3 >= i2 - 2) {
                        return Utf8.n(byteBuffer, b, i3, i2 - i3);
                    } else {
                        int i5 = i3 + 1;
                        byte b3 = byteBuffer.get(i3);
                        if (b3 <= -65 && (((b << 28) + (b3 + 112)) >> 30) == 0) {
                            int i6 = i5 + 1;
                            if (byteBuffer.get(i5) <= -65) {
                                i3 = i6 + 1;
                                if (byteBuffer.get(i6) > -65) {
                                }
                            }
                        }
                        return -1;
                    }
                }
                j = i3;
            }
            return 0;
        }

        /* access modifiers changed from: package-private */
        public abstract int a(CharSequence charSequence, byte[] bArr, int i, int i2);

        /* access modifiers changed from: package-private */
        public final boolean b(ByteBuffer byteBuffer, int i, int i2) {
            return d(0, byteBuffer, i, i2) == 0;
        }

        /* access modifiers changed from: package-private */
        public final boolean c(byte[] bArr, int i, int i2) {
            return e(0, bArr, i, i2) == 0;
        }

        /* access modifiers changed from: package-private */
        public final int d(int i, ByteBuffer byteBuffer, int i2, int i3) {
            if (byteBuffer.hasArray()) {
                int arrayOffset = byteBuffer.arrayOffset();
                return e(i, byteBuffer.array(), i2 + arrayOffset, arrayOffset + i3);
            } else if (byteBuffer.isDirect()) {
                return h(i, byteBuffer, i2, i3);
            } else {
                return g(i, byteBuffer, i2, i3);
            }
        }

        /* access modifiers changed from: package-private */
        public abstract int e(int i, byte[] bArr, int i2, int i3);

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x004b, code lost:
            if (r8.get(r9) > -65) goto L_0x004d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:0x008a, code lost:
            if (r8.get(r9) > -65) goto L_0x008c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x0017, code lost:
            if (r8.get(r9) > -65) goto L_0x001c;
         */
        public final int g(int i, ByteBuffer byteBuffer, int i2, int i3) {
            int i4;
            if (i != 0) {
                if (i2 >= i3) {
                    return i;
                }
                byte b = (byte) i;
                if (b < -32) {
                    if (b >= -62) {
                        i4 = i2 + 1;
                    }
                    return -1;
                } else if (b < -16) {
                    byte b2 = (byte) (~(i >> 8));
                    if (b2 == 0) {
                        int i5 = i2 + 1;
                        byte b3 = byteBuffer.get(i2);
                        if (i5 >= i3) {
                            return Utf8.l(b, b3);
                        }
                        i2 = i5;
                        b2 = b3;
                    }
                    if (b2 <= -65 && ((b != -32 || b2 >= -96) && (b != -19 || b2 < -96))) {
                        i4 = i2 + 1;
                    }
                    return -1;
                } else {
                    byte b4 = (byte) (~(i >> 8));
                    byte b5 = 0;
                    if (b4 == 0) {
                        int i6 = i2 + 1;
                        b4 = byteBuffer.get(i2);
                        if (i6 >= i3) {
                            return Utf8.l(b, b4);
                        }
                        i2 = i6;
                    } else {
                        b5 = (byte) (i >> 16);
                    }
                    if (b5 == 0) {
                        int i7 = i2 + 1;
                        b5 = byteBuffer.get(i2);
                        if (i7 >= i3) {
                            return Utf8.m(b, b4, b5);
                        }
                        i2 = i7;
                    }
                    if (b4 <= -65 && (((b << 28) + (b4 + 112)) >> 30) == 0 && b5 <= -65) {
                        i4 = i2 + 1;
                    }
                    return -1;
                }
                i2 = i4;
            }
            return f(byteBuffer, i2, i3);
        }

        /* access modifiers changed from: package-private */
        public abstract int h(int i, ByteBuffer byteBuffer, int i2, int i3);
    }

    /* compiled from: Taobao */
    static final class b extends a {
        b() {
        }

        private static int i(byte[] bArr, int i, int i2) {
            while (i < i2 && bArr[i] >= 0) {
                i++;
            }
            if (i >= i2) {
                return 0;
            }
            return j(bArr, i, i2);
        }

        private static int j(byte[] bArr, int i, int i2) {
            while (i < i2) {
                int i3 = i + 1;
                byte b = bArr[i];
                if (b < 0) {
                    if (b < -32) {
                        if (i3 >= i2) {
                            return b;
                        }
                        if (b >= -62) {
                            i = i3 + 1;
                            if (bArr[i3] > -65) {
                            }
                        }
                        return -1;
                    } else if (b < -16) {
                        if (i3 >= i2 - 1) {
                            return Utf8.o(bArr, i3, i2);
                        }
                        int i4 = i3 + 1;
                        byte b2 = bArr[i3];
                        if (b2 <= -65 && ((b != -32 || b2 >= -96) && (b != -19 || b2 < -96))) {
                            i = i4 + 1;
                            if (bArr[i4] > -65) {
                            }
                        }
                        return -1;
                    } else if (i3 >= i2 - 2) {
                        return Utf8.o(bArr, i3, i2);
                    } else {
                        int i5 = i3 + 1;
                        byte b3 = bArr[i3];
                        if (b3 <= -65 && (((b << 28) + (b3 + 112)) >> 30) == 0) {
                            int i6 = i5 + 1;
                            if (bArr[i5] <= -65) {
                                i3 = i6 + 1;
                                if (bArr[i6] > -65) {
                                }
                            }
                        }
                        return -1;
                    }
                }
                i = i3;
            }
            return 0;
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.protobuf.Utf8.a
        public int a(CharSequence charSequence, byte[] bArr, int i, int i2) {
            int i3;
            int i4;
            int i5;
            char charAt;
            int length = charSequence.length();
            int i6 = i2 + i;
            int i7 = 0;
            while (i7 < length && (i5 = i7 + i) < i6 && (charAt = charSequence.charAt(i7)) < 128) {
                bArr[i5] = (byte) charAt;
                i7++;
            }
            if (i7 == length) {
                return i + length;
            }
            int i8 = i + i7;
            while (i7 < length) {
                char charAt2 = charSequence.charAt(i7);
                if (charAt2 < 128 && i8 < i6) {
                    i4 = i8 + 1;
                    bArr[i8] = (byte) charAt2;
                } else if (charAt2 < 2048 && i8 <= i6 - 2) {
                    int i9 = i8 + 1;
                    bArr[i8] = (byte) ((charAt2 >>> 6) | 960);
                    i8 = i9 + 1;
                    bArr[i9] = (byte) ((charAt2 & jl1.CONDITION_IF) | 128);
                    i7++;
                } else if ((charAt2 < 55296 || 57343 < charAt2) && i8 <= i6 - 3) {
                    int i10 = i8 + 1;
                    bArr[i8] = (byte) ((charAt2 >>> '\f') | GlMapUtil.DEVICE_DISPLAY_DPI_XHIGH);
                    int i11 = i10 + 1;
                    bArr[i10] = (byte) (((charAt2 >>> 6) & 63) | 128);
                    i4 = i11 + 1;
                    bArr[i11] = (byte) ((charAt2 & jl1.CONDITION_IF) | 128);
                } else if (i8 <= i6 - 4) {
                    int i12 = i7 + 1;
                    if (i12 != charSequence.length()) {
                        char charAt3 = charSequence.charAt(i12);
                        if (Character.isSurrogatePair(charAt2, charAt3)) {
                            int codePoint = Character.toCodePoint(charAt2, charAt3);
                            int i13 = i8 + 1;
                            bArr[i8] = (byte) ((codePoint >>> 18) | GlMapUtil.DEVICE_DISPLAY_DPI_MEDIAN);
                            int i14 = i13 + 1;
                            bArr[i13] = (byte) (((codePoint >>> 12) & 63) | 128);
                            int i15 = i14 + 1;
                            bArr[i14] = (byte) (((codePoint >>> 6) & 63) | 128);
                            i8 = i15 + 1;
                            bArr[i15] = (byte) ((codePoint & 63) | 128);
                            i7 = i12;
                            i7++;
                        } else {
                            i7 = i12;
                        }
                    }
                    throw new UnpairedSurrogateException(i7 - 1, length);
                } else if (55296 > charAt2 || charAt2 > 57343 || ((i3 = i7 + 1) != charSequence.length() && Character.isSurrogatePair(charAt2, charSequence.charAt(i3)))) {
                    throw new ArrayIndexOutOfBoundsException("Failed writing " + charAt2 + " at index " + i8);
                } else {
                    throw new UnpairedSurrogateException(i7, length);
                }
                i8 = i4;
                i7++;
            }
            return i8;
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x0045, code lost:
            if (r8[r9] > -65) goto L_0x0047;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:0x007e, code lost:
            if (r8[r9] > -65) goto L_0x0080;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x0015, code lost:
            if (r8[r9] > -65) goto L_0x001a;
         */
        @Override // com.google.protobuf.Utf8.a
        public int e(int i, byte[] bArr, int i2, int i3) {
            int i4;
            if (i != 0) {
                if (i2 >= i3) {
                    return i;
                }
                byte b = (byte) i;
                if (b < -32) {
                    if (b >= -62) {
                        i4 = i2 + 1;
                    }
                    return -1;
                } else if (b < -16) {
                    byte b2 = (byte) (~(i >> 8));
                    if (b2 == 0) {
                        int i5 = i2 + 1;
                        byte b3 = bArr[i2];
                        if (i5 >= i3) {
                            return Utf8.l(b, b3);
                        }
                        i2 = i5;
                        b2 = b3;
                    }
                    if (b2 <= -65 && ((b != -32 || b2 >= -96) && (b != -19 || b2 < -96))) {
                        i4 = i2 + 1;
                    }
                    return -1;
                } else {
                    byte b4 = (byte) (~(i >> 8));
                    byte b5 = 0;
                    if (b4 == 0) {
                        int i6 = i2 + 1;
                        b4 = bArr[i2];
                        if (i6 >= i3) {
                            return Utf8.l(b, b4);
                        }
                        i2 = i6;
                    } else {
                        b5 = (byte) (i >> 16);
                    }
                    if (b5 == 0) {
                        int i7 = i2 + 1;
                        b5 = bArr[i2];
                        if (i7 >= i3) {
                            return Utf8.m(b, b4, b5);
                        }
                        i2 = i7;
                    }
                    if (b4 <= -65 && (((b << 28) + (b4 + 112)) >> 30) == 0 && b5 <= -65) {
                        i4 = i2 + 1;
                    }
                    return -1;
                }
                i2 = i4;
            }
            return i(bArr, i2, i3);
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.protobuf.Utf8.a
        public int h(int i, ByteBuffer byteBuffer, int i2, int i3) {
            return g(i, byteBuffer, i2, i3);
        }
    }

    /* compiled from: Taobao */
    static final class c extends a {
        c() {
        }

        static boolean i() {
            return n.k() && n.l();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0039, code lost:
            return -1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x0063, code lost:
            return -1;
         */
        private static int j(long j, int i) {
            long j2;
            int l = l(j, i);
            long j3 = j + ((long) l);
            int i2 = i - l;
            while (true) {
                byte b = 0;
                while (true) {
                    if (i2 <= 0) {
                        break;
                    }
                    long j4 = j3 + 1;
                    b = n.f(j3);
                    if (b < 0) {
                        j3 = j4;
                        break;
                    }
                    i2--;
                    j3 = j4;
                }
                if (i2 == 0) {
                    return 0;
                }
                int i3 = i2 - 1;
                if (b >= -32) {
                    if (b >= -16) {
                        if (i3 >= 3) {
                            i2 = i3 - 3;
                            long j5 = j3 + 1;
                            byte f = n.f(j3);
                            if (f > -65 || (((b << 28) + (f + 112)) >> 30) != 0) {
                                break;
                            }
                            long j6 = j5 + 1;
                            if (n.f(j5) > -65) {
                                break;
                            }
                            j2 = 1 + j6;
                            if (n.f(j6) > -65) {
                                break;
                            }
                        } else {
                            return n(j3, b, i3);
                        }
                    } else if (i3 >= 2) {
                        i2 = i3 - 2;
                        long j7 = j3 + 1;
                        byte f2 = n.f(j3);
                        if (f2 > -65 || ((b == -32 && f2 < -96) || (b == -19 && f2 >= -96))) {
                            break;
                        }
                        j2 = 1 + j7;
                        if (n.f(j7) > -65) {
                            break;
                        }
                    } else {
                        return n(j3, b, i3);
                    }
                } else if (i3 != 0) {
                    i2 = i3 - 1;
                    if (b < -62) {
                        break;
                    }
                    j2 = 1 + j3;
                    if (n.f(j3) > -65) {
                        break;
                    }
                } else {
                    return b;
                }
                j3 = j2;
            }
            return -1;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0039, code lost:
            return -1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x0063, code lost:
            return -1;
         */
        private static int k(byte[] bArr, long j, int i) {
            long j2;
            int m = m(bArr, j, i);
            int i2 = i - m;
            long j3 = j + ((long) m);
            while (true) {
                byte b = 0;
                while (true) {
                    if (i2 <= 0) {
                        break;
                    }
                    long j4 = j3 + 1;
                    b = n.g(bArr, j3);
                    if (b < 0) {
                        j3 = j4;
                        break;
                    }
                    i2--;
                    j3 = j4;
                }
                if (i2 == 0) {
                    return 0;
                }
                int i3 = i2 - 1;
                if (b >= -32) {
                    if (b >= -16) {
                        if (i3 >= 3) {
                            i2 = i3 - 3;
                            long j5 = j3 + 1;
                            byte g = n.g(bArr, j3);
                            if (g > -65 || (((b << 28) + (g + 112)) >> 30) != 0) {
                                break;
                            }
                            long j6 = j5 + 1;
                            if (n.g(bArr, j5) > -65) {
                                break;
                            }
                            j2 = 1 + j6;
                            if (n.g(bArr, j6) > -65) {
                                break;
                            }
                        } else {
                            return o(bArr, b, j3, i3);
                        }
                    } else if (i3 >= 2) {
                        i2 = i3 - 2;
                        long j7 = j3 + 1;
                        byte g2 = n.g(bArr, j3);
                        if (g2 > -65 || ((b == -32 && g2 < -96) || (b == -19 && g2 >= -96))) {
                            break;
                        }
                        j2 = 1 + j7;
                        if (n.g(bArr, j7) > -65) {
                            break;
                        }
                    } else {
                        return o(bArr, b, j3, i3);
                    }
                } else if (i3 != 0) {
                    i2 = i3 - 1;
                    if (b < -62) {
                        break;
                    }
                    j2 = 1 + j3;
                    if (n.g(bArr, j3) > -65) {
                        break;
                    }
                } else {
                    return b;
                }
                j3 = j2;
            }
            return -1;
        }

        private static int l(long j, int i) {
            if (i < 16) {
                return 0;
            }
            int i2 = ((int) j) & 7;
            int i3 = i2;
            while (i3 > 0) {
                long j2 = 1 + j;
                if (n.f(j) < 0) {
                    return i2 - i3;
                }
                i3--;
                j = j2;
            }
            int i4 = i - i2;
            while (i4 >= 8 && (n.h(j) & -9187201950435737472L) == 0) {
                j += 8;
                i4 -= 8;
            }
            return i - i4;
        }

        private static int m(byte[] bArr, long j, int i) {
            if (i < 16) {
                return 0;
            }
            int i2 = ((int) j) & 7;
            int i3 = i2;
            while (i3 > 0) {
                long j2 = 1 + j;
                if (n.g(bArr, j) < 0) {
                    return i2 - i3;
                }
                i3--;
                j = j2;
            }
            int i4 = i - i2;
            while (i4 >= 8 && (n.i(bArr, j) & -9187201950435737472L) == 0) {
                j += 8;
                i4 -= 8;
            }
            return i - i4;
        }

        private static int n(long j, int i, int i2) {
            if (i2 == 0) {
                return Utf8.k(i);
            }
            if (i2 == 1) {
                return Utf8.l(i, n.f(j));
            }
            if (i2 == 2) {
                return Utf8.m(i, n.f(j), n.f(j + 1));
            }
            throw new AssertionError();
        }

        private static int o(byte[] bArr, int i, long j, int i2) {
            if (i2 == 0) {
                return Utf8.k(i);
            }
            if (i2 == 1) {
                return Utf8.l(i, n.g(bArr, j));
            }
            if (i2 == 2) {
                return Utf8.m(i, n.g(bArr, j), n.g(bArr, j + 1));
            }
            throw new AssertionError();
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Removed duplicated region for block: B:11:0x0036  */
        /* JADX WARNING: Removed duplicated region for block: B:14:0x003d A[LOOP:1: B:14:0x003d->B:39:0x0105, LOOP_START, PHI: r2 r3 r4 r11 
          PHI: (r2v3 int) = (r2v2 int), (r2v5 int) binds: [B:10:0x0034, B:39:0x0105] A[DONT_GENERATE, DONT_INLINE]
          PHI: (r3v2 char) = (r3v1 char), (r3v3 char) binds: [B:10:0x0034, B:39:0x0105] A[DONT_GENERATE, DONT_INLINE]
          PHI: (r4v4 long) = (r4v3 long), (r4v6 long) binds: [B:10:0x0034, B:39:0x0105] A[DONT_GENERATE, DONT_INLINE]
          PHI: (r11v3 long) = (r11v2 long), (r11v4 long) binds: [B:10:0x0034, B:39:0x0105] A[DONT_GENERATE, DONT_INLINE]] */
        @Override // com.google.protobuf.Utf8.a
        public int a(CharSequence charSequence, byte[] bArr, int i, int i2) {
            long e;
            long j;
            long j2;
            int i3;
            char charAt;
            long e2 = n.e() + ((long) i);
            long j3 = ((long) i2) + e2;
            int length = charSequence.length();
            if (length > i2 || bArr.length - i2 < i) {
                throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(length - 1) + " at index " + (i + i2));
            }
            int i4 = 0;
            while (true) {
                char c = 128;
                long j4 = 1;
                if (i4 < length && (charAt = charSequence.charAt(i4)) < 128) {
                    n.m(bArr, e2, (byte) charAt);
                    i4++;
                    e2 = 1 + e2;
                } else if (i4 != length) {
                    e = n.e();
                } else {
                    while (i4 < length) {
                        char charAt2 = charSequence.charAt(i4);
                        if (charAt2 < c && e2 < j3) {
                            long j5 = e2 + j4;
                            n.m(bArr, e2, (byte) charAt2);
                            j2 = j4;
                            j = j5;
                        } else if (charAt2 < 2048 && e2 <= j3 - 2) {
                            long j6 = e2 + j4;
                            n.m(bArr, e2, (byte) ((charAt2 >>> 6) | 960));
                            n.m(bArr, j6, (byte) ((charAt2 & jl1.CONDITION_IF) | 128));
                            j = j6 + j4;
                            j2 = j4;
                            i4++;
                            c = 128;
                            e2 = j;
                            j4 = j2;
                        } else if ((charAt2 < 55296 || 57343 < charAt2) && e2 <= j3 - 3) {
                            long j7 = e2 + j4;
                            n.m(bArr, e2, (byte) ((charAt2 >>> '\f') | GlMapUtil.DEVICE_DISPLAY_DPI_XHIGH));
                            long j8 = j7 + j4;
                            n.m(bArr, j7, (byte) (((charAt2 >>> 6) & 63) | 128));
                            n.m(bArr, j8, (byte) ((charAt2 & jl1.CONDITION_IF) | 128));
                            j = j8 + 1;
                            j2 = 1;
                        } else if (e2 <= j3 - 4) {
                            int i5 = i4 + 1;
                            if (i5 != length) {
                                char charAt3 = charSequence.charAt(i5);
                                if (Character.isSurrogatePair(charAt2, charAt3)) {
                                    int codePoint = Character.toCodePoint(charAt2, charAt3);
                                    long j9 = e2 + 1;
                                    n.m(bArr, e2, (byte) ((codePoint >>> 18) | GlMapUtil.DEVICE_DISPLAY_DPI_MEDIAN));
                                    long j10 = j9 + 1;
                                    n.m(bArr, j9, (byte) (((codePoint >>> 12) & 63) | 128));
                                    long j11 = j10 + 1;
                                    n.m(bArr, j10, (byte) (((codePoint >>> 6) & 63) | 128));
                                    j2 = 1;
                                    j = j11 + 1;
                                    n.m(bArr, j11, (byte) ((codePoint & 63) | 128));
                                    i4 = i5;
                                    i4++;
                                    c = 128;
                                    e2 = j;
                                    j4 = j2;
                                } else {
                                    i4 = i5;
                                }
                            }
                            throw new UnpairedSurrogateException(i4 - 1, length);
                        } else if (55296 > charAt2 || charAt2 > 57343 || ((i3 = i4 + 1) != length && Character.isSurrogatePair(charAt2, charSequence.charAt(i3)))) {
                            throw new ArrayIndexOutOfBoundsException("Failed writing " + charAt2 + " at index " + e2);
                        } else {
                            throw new UnpairedSurrogateException(i4, length);
                        }
                        i4++;
                        c = 128;
                        e2 = j;
                        j4 = j2;
                    }
                    e = n.e();
                }
            }
            if (i4 != length) {
            }
            return (int) (e2 - e);
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x0063, code lost:
            if (com.google.protobuf.n.g(r13, r2) > -65) goto L_0x0068;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:54:0x00a8, code lost:
            if (com.google.protobuf.n.g(r13, r2) > -65) goto L_0x00aa;
         */
        @Override // com.google.protobuf.Utf8.a
        public int e(int i, byte[] bArr, int i2, int i3) {
            long j;
            byte b = 0;
            if ((i2 | i3 | (bArr.length - i3)) >= 0) {
                long e = n.e() + ((long) i2);
                long e2 = n.e() + ((long) i3);
                if (i != 0) {
                    if (e >= e2) {
                        return i;
                    }
                    byte b2 = (byte) i;
                    if (b2 < -32) {
                        if (b2 >= -62) {
                            long j2 = 1 + e;
                            if (n.g(bArr, e) <= -65) {
                                e = j2;
                            }
                        }
                        return -1;
                    }
                    if (b2 < -16) {
                        byte b3 = (byte) (~(i >> 8));
                        if (b3 == 0) {
                            long j3 = e + 1;
                            b3 = n.g(bArr, e);
                            if (j3 >= e2) {
                                return Utf8.l(b2, b3);
                            }
                            e = j3;
                        }
                        if (b3 <= -65 && ((b2 != -32 || b3 >= -96) && (b2 != -19 || b3 < -96))) {
                            j = e + 1;
                        }
                        return -1;
                    }
                    byte b4 = (byte) (~(i >> 8));
                    if (b4 == 0) {
                        long j4 = e + 1;
                        b4 = n.g(bArr, e);
                        if (j4 >= e2) {
                            return Utf8.l(b2, b4);
                        }
                        e = j4;
                    } else {
                        b = (byte) (i >> 16);
                    }
                    if (b == 0) {
                        long j5 = e + 1;
                        b = n.g(bArr, e);
                        if (j5 >= e2) {
                            return Utf8.m(b2, b4, b);
                        }
                        e = j5;
                    }
                    if (b4 <= -65 && (((b2 << 28) + (b4 + 112)) >> 30) == 0 && b <= -65) {
                        j = e + 1;
                    }
                    return -1;
                    e = j;
                }
                return k(bArr, e, (int) (e2 - e));
            }
            throw new ArrayIndexOutOfBoundsException(String.format("Array length=%d, index=%d, limit=%d", Integer.valueOf(bArr.length), Integer.valueOf(i2), Integer.valueOf(i3)));
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x0063, code lost:
            if (com.google.protobuf.n.f(r2) > -65) goto L_0x0068;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:54:0x00a8, code lost:
            if (com.google.protobuf.n.f(r2) > -65) goto L_0x00aa;
         */
        @Override // com.google.protobuf.Utf8.a
        public int h(int i, ByteBuffer byteBuffer, int i2, int i3) {
            long j;
            byte b = 0;
            if ((i2 | i3 | (byteBuffer.limit() - i3)) >= 0) {
                long a = n.a(byteBuffer) + ((long) i2);
                long j2 = ((long) (i3 - i2)) + a;
                if (i != 0) {
                    if (a >= j2) {
                        return i;
                    }
                    byte b2 = (byte) i;
                    if (b2 < -32) {
                        if (b2 >= -62) {
                            long j3 = 1 + a;
                            if (n.f(a) <= -65) {
                                a = j3;
                            }
                        }
                        return -1;
                    }
                    if (b2 < -16) {
                        byte b3 = (byte) (~(i >> 8));
                        if (b3 == 0) {
                            long j4 = a + 1;
                            b3 = n.f(a);
                            if (j4 >= j2) {
                                return Utf8.l(b2, b3);
                            }
                            a = j4;
                        }
                        if (b3 <= -65 && ((b2 != -32 || b3 >= -96) && (b2 != -19 || b3 < -96))) {
                            j = a + 1;
                        }
                        return -1;
                    }
                    byte b4 = (byte) (~(i >> 8));
                    if (b4 == 0) {
                        long j5 = a + 1;
                        b4 = n.f(a);
                        if (j5 >= j2) {
                            return Utf8.l(b2, b4);
                        }
                        a = j5;
                    } else {
                        b = (byte) (i >> 16);
                    }
                    if (b == 0) {
                        long j6 = a + 1;
                        b = n.f(a);
                        if (j6 >= j2) {
                            return Utf8.m(b2, b4, b);
                        }
                        a = j6;
                    }
                    if (b4 <= -65 && (((b2 << 28) + (b4 + 112)) >> 30) == 0 && b <= -65) {
                        j = a + 1;
                    }
                    return -1;
                    a = j;
                }
                return j(a, (int) (j2 - a));
            }
            throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", Integer.valueOf(byteBuffer.limit()), Integer.valueOf(i2), Integer.valueOf(i3)));
        }
    }

    static int g(CharSequence charSequence, byte[] bArr, int i, int i2) {
        return a.a(charSequence, bArr, i, i2);
    }

    static int h(CharSequence charSequence) {
        int length = charSequence.length();
        int i = 0;
        while (i < length && charSequence.charAt(i) < 128) {
            i++;
        }
        int i2 = length;
        while (true) {
            if (i < length) {
                char charAt = charSequence.charAt(i);
                if (charAt >= 2048) {
                    i2 += i(charSequence, i);
                    break;
                }
                i2 += (127 - charAt) >>> 31;
                i++;
            } else {
                break;
            }
        }
        if (i2 >= length) {
            return i2;
        }
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (((long) i2) + Constants.RequestStrategy.LOCAL_FIRST));
    }

    private static int i(CharSequence charSequence, int i) {
        int length = charSequence.length();
        int i2 = 0;
        while (i < length) {
            char charAt = charSequence.charAt(i);
            if (charAt < 2048) {
                i2 += (127 - charAt) >>> 31;
            } else {
                i2 += 2;
                if (55296 <= charAt && charAt <= 57343) {
                    if (Character.codePointAt(charSequence, i) >= 65536) {
                        i++;
                    } else {
                        throw new UnpairedSurrogateException(i, length);
                    }
                }
            }
            i++;
        }
        return i2;
    }

    /* access modifiers changed from: private */
    public static int j(ByteBuffer byteBuffer, int i, int i2) {
        int i3 = i2 - 7;
        int i4 = i;
        while (i4 < i3 && (byteBuffer.getLong(i4) & -9187201950435737472L) == 0) {
            i4 += 8;
        }
        return i4 - i;
    }

    /* access modifiers changed from: private */
    public static int k(int i) {
        if (i > -12) {
            return -1;
        }
        return i;
    }

    /* access modifiers changed from: private */
    public static int l(int i, int i2) {
        if (i > -12 || i2 > -65) {
            return -1;
        }
        return i ^ (i2 << 8);
    }

    /* access modifiers changed from: private */
    public static int m(int i, int i2, int i3) {
        if (i > -12 || i2 > -65 || i3 > -65) {
            return -1;
        }
        return (i ^ (i2 << 8)) ^ (i3 << 16);
    }

    /* access modifiers changed from: private */
    public static int n(ByteBuffer byteBuffer, int i, int i2, int i3) {
        if (i3 == 0) {
            return k(i);
        }
        if (i3 == 1) {
            return l(i, byteBuffer.get(i2));
        }
        if (i3 == 2) {
            return m(i, byteBuffer.get(i2), byteBuffer.get(i2 + 1));
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: private */
    public static int o(byte[] bArr, int i, int i2) {
        byte b2 = bArr[i - 1];
        int i3 = i2 - i;
        if (i3 == 0) {
            return k(b2);
        }
        if (i3 == 1) {
            return l(b2, bArr[i]);
        }
        if (i3 == 2) {
            return m(b2, bArr[i], bArr[i + 1]);
        }
        throw new AssertionError();
    }

    static boolean p(ByteBuffer byteBuffer) {
        return a.b(byteBuffer, byteBuffer.position(), byteBuffer.remaining());
    }

    public static boolean q(byte[] bArr, int i, int i2) {
        return a.c(bArr, i, i2);
    }

    static int r(int i, ByteBuffer byteBuffer, int i2, int i3) {
        return a.d(i, byteBuffer, i2, i3);
    }

    public static int s(int i, byte[] bArr, int i2, int i3) {
        return a.e(i, bArr, i2, i3);
    }
}
