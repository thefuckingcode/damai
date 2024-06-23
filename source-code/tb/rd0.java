package tb;

import com.google.zxing.WriterException;
import java.io.UnsupportedEncodingException;
import java.util.Hashtable;
import java.util.Vector;
import tb.bv2;

/* compiled from: Taobao */
public final class rd0 {
    private static final int[] a = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 36, -1, -1, -1, 37, 38, -1, -1, -1, -1, 39, 40, -1, 41, 42, 43, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 44, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, -1, -1, -1, -1, -1};

    static void a(String str, tb tbVar, String str2) throws WriterException {
        try {
            byte[] bytes = str.getBytes(str2);
            for (byte b : bytes) {
                tbVar.c(b, 8);
            }
        } catch (UnsupportedEncodingException e) {
            throw new WriterException(e.toString());
        }
    }

    static void b(String str, tb tbVar) throws WriterException {
        int length = str.length();
        int i = 0;
        while (i < length) {
            int n = n(str.charAt(i));
            if (n != -1) {
                int i2 = i + 1;
                if (i2 < length) {
                    int n2 = n(str.charAt(i2));
                    if (n2 != -1) {
                        tbVar.c((n * 45) + n2, 11);
                        i += 2;
                    } else {
                        throw new WriterException();
                    }
                } else {
                    tbVar.c(n, 6);
                    i = i2;
                }
            } else {
                throw new WriterException();
            }
        }
    }

    static void c(String str, ve1 ve1, tb tbVar, String str2) throws WriterException {
        if (ve1.equals(ve1.NUMERIC)) {
            h(str, tbVar);
        } else if (ve1.equals(ve1.ALPHANUMERIC)) {
            b(str, tbVar);
        } else if (ve1.equals(ve1.BYTE)) {
            a(str, tbVar, str2);
        } else if (ve1.equals(ve1.KANJI)) {
            e(str, tbVar);
        } else {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Invalid mode: ");
            stringBuffer.append(ve1);
            throw new WriterException(stringBuffer.toString());
        }
    }

    private static void d(rc0 rc0, tb tbVar) {
        tbVar.c(ve1.ECI.a(), 4);
        tbVar.c(rc0.a(), 8);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0035 A[LOOP:0: B:4:0x0008->B:17:0x0035, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0044 A[SYNTHETIC] */
    static void e(String str, tb tbVar) throws WriterException {
        int i;
        try {
            byte[] bytes = str.getBytes("Shift_JIS");
            int length = bytes.length;
            for (int i2 = 0; i2 < length; i2 += 2) {
                int i3 = ((bytes[i2] & 255) << 8) | (bytes[i2 + 1] & 255);
                int i4 = 33088;
                if (i3 < 33088 || i3 > 40956) {
                    if (i3 < 57408 || i3 > 60351) {
                        i = -1;
                        if (i == -1) {
                            tbVar.c(((i >> 8) * 192) + (i & 255), 13);
                        } else {
                            throw new WriterException("Invalid byte sequence");
                        }
                    } else {
                        i4 = 49472;
                    }
                }
                i = i3 - i4;
                if (i == -1) {
                }
            }
        } catch (UnsupportedEncodingException e) {
            throw new WriterException(e.toString());
        }
    }

    static void f(int i, int i2, ve1 ve1, tb tbVar) throws WriterException {
        int b = ve1.b(bv2.e(i2));
        int i3 = (1 << b) - 1;
        if (i <= i3) {
            tbVar.c(i, b);
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(i);
        stringBuffer.append("is bigger than");
        stringBuffer.append(i3);
        throw new WriterException(stringBuffer.toString());
    }

    static void g(ve1 ve1, tb tbVar) {
        tbVar.c(ve1.a(), 4);
    }

    static void h(String str, tb tbVar) {
        int length = str.length();
        int i = 0;
        while (i < length) {
            int charAt = str.charAt(i) - '0';
            int i2 = i + 2;
            if (i2 < length) {
                tbVar.c((charAt * 100) + ((str.charAt(i + 1) - '0') * 10) + (str.charAt(i2) - '0'), 10);
                i += 3;
            } else {
                i++;
                if (i < length) {
                    tbVar.c((charAt * 10) + (str.charAt(i) - '0'), 7);
                    i = i2;
                } else {
                    tbVar.c(charAt, 4);
                }
            }
        }
    }

    private static int i(vd vdVar) {
        return mb1.a(vdVar) + 0 + mb1.c(vdVar) + mb1.d(vdVar) + mb1.e(vdVar);
    }

    private static int j(tb tbVar, ge0 ge0, int i, vd vdVar) throws WriterException {
        int i2 = Integer.MAX_VALUE;
        int i3 = -1;
        for (int i4 = 0; i4 < 8; i4++) {
            vb1.a(tbVar, ge0, i, i4, vdVar);
            int i5 = i(vdVar);
            if (i5 < i2) {
                i3 = i4;
                i2 = i5;
            }
        }
        return i3;
    }

    public static ve1 k(String str, String str2) {
        if ("Shift_JIS".equals(str2)) {
            return r(str) ? ve1.KANJI : ve1.BYTE;
        }
        boolean z = false;
        boolean z2 = false;
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt >= '0' && charAt <= '9') {
                z2 = true;
            } else if (n(charAt) == -1) {
                return ve1.BYTE;
            } else {
                z = true;
            }
        }
        if (z) {
            return ve1.ALPHANUMERIC;
        }
        if (z2) {
            return ve1.NUMERIC;
        }
        return ve1.BYTE;
    }

    public static void l(String str, ge0 ge0, Hashtable hashtable, dw1 dw1) throws WriterException {
        oh d;
        String str2 = hashtable == null ? null : (String) hashtable.get(od0.CHARACTER_SET);
        if (str2 == null) {
            str2 = "UTF-8";
        }
        ve1 k = k(str, str2);
        tb tbVar = new tb();
        c(str, k, tbVar, str2);
        p(tbVar.g(), ge0, k, dw1);
        tb tbVar2 = new tb();
        ve1 ve1 = ve1.BYTE;
        if (k == ve1 && !"UTF-8".equals(str2) && (d = oh.d(str2)) != null) {
            d(d, tbVar2);
        }
        g(k, tbVar2);
        f(k.equals(ve1) ? tbVar.g() : str.length(), dw1.h(), k, tbVar2);
        tbVar2.b(tbVar);
        s(dw1.e(), tbVar2);
        tb tbVar3 = new tb();
        q(tbVar2, dw1.g(), dw1.e(), dw1.f(), tbVar3);
        vd vdVar = new vd(dw1.d(), dw1.d());
        dw1.l(j(tbVar3, dw1.a(), dw1.h(), vdVar));
        vb1.a(tbVar3, dw1.a(), dw1.h(), dw1.b(), vdVar);
        dw1.m(vdVar);
        if (!dw1.i()) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Invalid QR code: ");
            stringBuffer.append(dw1.toString());
            throw new WriterException(stringBuffer.toString());
        }
    }

    static byte[] m(byte[] bArr, int i) {
        int length = bArr.length;
        int[] iArr = new int[(length + i)];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = bArr[i2] & 255;
        }
        new ux1(tn0.QR_CODE_FIELD).b(iArr, i);
        byte[] bArr2 = new byte[i];
        for (int i3 = 0; i3 < i; i3++) {
            bArr2[i3] = (byte) iArr[length + i3];
        }
        return bArr2;
    }

    static int n(int i) {
        int[] iArr = a;
        if (i < iArr.length) {
            return iArr[i];
        }
        return -1;
    }

    static void o(int i, int i2, int i3, int i4, int[] iArr, int[] iArr2) throws WriterException {
        if (i4 < i3) {
            int i5 = i % i3;
            int i6 = i3 - i5;
            int i7 = i / i3;
            int i8 = i7 + 1;
            int i9 = i2 / i3;
            int i10 = i9 + 1;
            int i11 = i7 - i9;
            int i12 = i8 - i10;
            if (i11 != i12) {
                throw new WriterException("EC bytes mismatch");
            } else if (i3 != i6 + i5) {
                throw new WriterException("RS blocks mismatch");
            } else if (i != ((i9 + i11) * i6) + ((i10 + i12) * i5)) {
                throw new WriterException("Total bytes mismatch");
            } else if (i4 < i6) {
                iArr[0] = i9;
                iArr2[0] = i11;
            } else {
                iArr[0] = i10;
                iArr2[0] = i12;
            }
        } else {
            throw new WriterException("Block ID too large");
        }
    }

    private static void p(int i, ge0 ge0, ve1 ve1, dw1 dw1) throws WriterException {
        dw1.k(ge0);
        dw1.o(ve1);
        for (int i2 = 1; i2 <= 40; i2++) {
            bv2 e = bv2.e(i2);
            int d = e.d();
            bv2.b c = e.c(ge0);
            int d2 = c.d();
            int c2 = c.c();
            int i3 = d - d2;
            if (i3 >= i + 3) {
                dw1.t(i2);
                dw1.s(d);
                dw1.p(i3);
                dw1.r(c2);
                dw1.q(d2);
                dw1.n(e.b());
                return;
            }
        }
        throw new WriterException("Cannot find proper rs block info (input data too big?)");
    }

    static void q(tb tbVar, int i, int i2, int i3, tb tbVar2) throws WriterException {
        if (tbVar.g() == i2) {
            Vector vector = new Vector(i3);
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            for (int i7 = 0; i7 < i3; i7++) {
                int[] iArr = new int[1];
                int[] iArr2 = new int[1];
                o(i, i2, i3, i7, iArr, iArr2);
                int i8 = iArr[0];
                byte[] bArr = new byte[i8];
                tbVar.i(i4 * 8, bArr, 0, i8);
                byte[] m = m(bArr, iArr2[0]);
                vector.addElement(new fc(bArr, m));
                i5 = Math.max(i5, i8);
                i6 = Math.max(i6, m.length);
                i4 += iArr[0];
            }
            if (i2 == i4) {
                for (int i9 = 0; i9 < i5; i9++) {
                    for (int i10 = 0; i10 < vector.size(); i10++) {
                        byte[] a2 = ((fc) vector.elementAt(i10)).a();
                        if (i9 < a2.length) {
                            tbVar2.c(a2[i9], 8);
                        }
                    }
                }
                for (int i11 = 0; i11 < i6; i11++) {
                    for (int i12 = 0; i12 < vector.size(); i12++) {
                        byte[] b = ((fc) vector.elementAt(i12)).b();
                        if (i11 < b.length) {
                            tbVar2.c(b[i11], 8);
                        }
                    }
                }
                if (i != tbVar2.g()) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("Interleaving error: ");
                    stringBuffer.append(i);
                    stringBuffer.append(" and ");
                    stringBuffer.append(tbVar2.g());
                    stringBuffer.append(" differ.");
                    throw new WriterException(stringBuffer.toString());
                }
                return;
            }
            throw new WriterException("Data bytes does not match offset");
        }
        throw new WriterException("Number of bits and data bytes does not match");
    }

    private static boolean r(String str) {
        try {
            byte[] bytes = str.getBytes("Shift_JIS");
            int length = bytes.length;
            if (length % 2 != 0) {
                return false;
            }
            for (int i = 0; i < length; i += 2) {
                int i2 = bytes[i] & 255;
                if ((i2 < 129 || i2 > 159) && (i2 < 224 || i2 > 235)) {
                    return false;
                }
            }
            return true;
        } catch (UnsupportedEncodingException unused) {
            return false;
        }
    }

    static void s(int i, tb tbVar) throws WriterException {
        int i2 = i << 3;
        if (tbVar.f() <= i2) {
            for (int i3 = 0; i3 < 4 && tbVar.f() < i2; i3++) {
                tbVar.a(false);
            }
            int f = tbVar.f() & 7;
            if (f > 0) {
                while (f < 8) {
                    tbVar.a(false);
                    f++;
                }
            }
            int g = i - tbVar.g();
            for (int i4 = 0; i4 < g; i4++) {
                tbVar.c((i4 & 1) == 0 ? 236 : 17, 8);
            }
            if (tbVar.f() != i2) {
                throw new WriterException("Bits size does not equal capacity");
            }
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("data bits cannot fit in the QR Code");
        stringBuffer.append(tbVar.f());
        stringBuffer.append(" > ");
        stringBuffer.append(i2);
        throw new WriterException(stringBuffer.toString());
    }
}
