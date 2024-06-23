package tb;

import com.alibaba.wireless.security.SecExceptionCode;
import com.google.zxing.WriterException;
import com.youku.uplayer.AliMediaPlayer;

/* compiled from: Taobao */
public final class vb1 {
    private static final int[][] a = {new int[]{1, 1, 1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1, 1, 1}};
    private static final int[][] b = {new int[]{0, 0, 0, 0, 0, 0, 0, 0}};
    private static final int[][] c = {new int[]{0}, new int[]{0}, new int[]{0}, new int[]{0}, new int[]{0}, new int[]{0}, new int[]{0}};
    private static final int[][] d = {new int[]{1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 0, 1, 0, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1}};
    private static final int[][] e = {new int[]{-1, -1, -1, -1, -1, -1, -1}, new int[]{6, 18, -1, -1, -1, -1, -1}, new int[]{6, 22, -1, -1, -1, -1, -1}, new int[]{6, 26, -1, -1, -1, -1, -1}, new int[]{6, 30, -1, -1, -1, -1, -1}, new int[]{6, 34, -1, -1, -1, -1, -1}, new int[]{6, 22, 38, -1, -1, -1, -1}, new int[]{6, 24, 42, -1, -1, -1, -1}, new int[]{6, 26, 46, -1, -1, -1, -1}, new int[]{6, 28, 50, -1, -1, -1, -1}, new int[]{6, 30, 54, -1, -1, -1, -1}, new int[]{6, 32, 58, -1, -1, -1, -1}, new int[]{6, 34, 62, -1, -1, -1, -1}, new int[]{6, 26, 46, 66, -1, -1, -1}, new int[]{6, 26, 48, 70, -1, -1, -1}, new int[]{6, 26, 50, 74, -1, -1, -1}, new int[]{6, 30, 54, 78, -1, -1, -1}, new int[]{6, 30, 56, 82, -1, -1, -1}, new int[]{6, 30, 58, 86, -1, -1, -1}, new int[]{6, 34, 62, 90, -1, -1, -1}, new int[]{6, 28, 50, 72, 94, -1, -1}, new int[]{6, 26, 50, 74, 98, -1, -1}, new int[]{6, 30, 54, 78, 102, -1, -1}, new int[]{6, 28, 54, 80, 106, -1, -1}, new int[]{6, 32, 58, 84, 110, -1, -1}, new int[]{6, 30, 58, 86, 114, -1, -1}, new int[]{6, 34, 62, 90, 118, -1, -1}, new int[]{6, 26, 50, 74, 98, 122, -1}, new int[]{6, 30, 54, 78, 102, 126, -1}, new int[]{6, 26, 52, 78, 104, 130, -1}, new int[]{6, 30, 56, 82, 108, 134, -1}, new int[]{6, 34, 60, 86, 112, SecExceptionCode.SEC_ERROR_INIT_PLUGIN_CLASS_ERROR, -1}, new int[]{6, 30, 58, 86, 114, 142, -1}, new int[]{6, 34, 62, 90, 118, 146, -1}, new int[]{6, 30, 54, 78, 102, 126, 150}, new int[]{6, 24, 50, 76, 102, 128, AliMediaPlayer.UPLAYER_PROPERTY_TYPE_PATTAYA_SD_UP_GEAR_NEED_BUFFER}, new int[]{6, 28, 54, 80, 106, 132, AliMediaPlayer.UPLAYER_PROPERTY_TYPE_PATTAYA_DISALBE_ADAPT_SPEED}, new int[]{6, 32, 58, 84, 110, 136, 162}, new int[]{6, 26, 54, 82, 110, SecExceptionCode.SEC_ERROR_INIT_PLUGIN_CLASS_ERROR, 166}, new int[]{6, 30, 58, 86, 114, 142, AliMediaPlayer.UPLAYER_PROPERTY_TYPE_PATTAYA_NEXT_SEGMENT_SPEED_CALC_COUNT}};
    private static final int[][] f = {new int[]{8, 0}, new int[]{8, 1}, new int[]{8, 2}, new int[]{8, 3}, new int[]{8, 4}, new int[]{8, 5}, new int[]{8, 7}, new int[]{8, 8}, new int[]{7, 8}, new int[]{5, 8}, new int[]{4, 8}, new int[]{3, 8}, new int[]{2, 8}, new int[]{1, 8}, new int[]{0, 8}};

    public static void a(tb tbVar, ge0 ge0, int i, int i2, vd vdVar) throws WriterException {
        c(vdVar);
        d(i, vdVar);
        l(ge0, i2, vdVar);
        t(i, vdVar);
        f(tbVar, i2, vdVar);
    }

    public static int b(int i, int i2) {
        int n = n(i2);
        int i3 = i << (n - 1);
        while (n(i3) >= n) {
            i3 ^= i2 << (n(i3) - n);
        }
        return i3;
    }

    public static void c(vd vdVar) {
        vdVar.a((byte) -1);
    }

    public static void d(int i, vd vdVar) throws WriterException {
        j(vdVar);
        e(vdVar);
        s(i, vdVar);
        k(vdVar);
    }

    private static void e(vd vdVar) throws WriterException {
        if (vdVar.b(8, vdVar.d() - 8) != 0) {
            vdVar.f(8, vdVar.d() - 8, 1);
            return;
        }
        throw new WriterException();
    }

    public static void f(tb tbVar, int i, vd vdVar) throws WriterException {
        boolean z;
        int e2 = vdVar.e() - 1;
        int d2 = vdVar.d() - 1;
        int i2 = 0;
        int i3 = -1;
        while (e2 > 0) {
            if (e2 == 6) {
                e2--;
            }
            while (d2 >= 0 && d2 < vdVar.d()) {
                for (int i4 = 0; i4 < 2; i4++) {
                    int i5 = e2 - i4;
                    if (o(vdVar.b(i5, d2))) {
                        if (i2 < tbVar.f()) {
                            z = tbVar.e(i2);
                            i2++;
                        } else {
                            z = false;
                        }
                        if (i != -1 && mb1.f(i, i5, d2)) {
                            z = !z;
                        }
                        vdVar.g(i5, d2, z);
                    }
                }
                d2 += i3;
            }
            i3 = -i3;
            d2 += i3;
            e2 -= 2;
        }
        if (i2 != tbVar.f()) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Not all bits consumed: ");
            stringBuffer.append(i2);
            stringBuffer.append(v00.DIR);
            stringBuffer.append(tbVar.f());
            throw new WriterException(stringBuffer.toString());
        }
    }

    private static void g(int i, int i2, vd vdVar) throws WriterException {
        int[][] iArr = b;
        if (iArr[0].length == 8 && iArr.length == 1) {
            for (int i3 = 0; i3 < 8; i3++) {
                int i4 = i + i3;
                if (o(vdVar.b(i4, i2))) {
                    vdVar.f(i4, i2, b[0][i3]);
                } else {
                    throw new WriterException();
                }
            }
            return;
        }
        throw new WriterException("Bad horizontal separation pattern");
    }

    private static void h(int i, int i2, vd vdVar) throws WriterException {
        int[][] iArr = d;
        if (iArr[0].length == 5 && iArr.length == 5) {
            for (int i3 = 0; i3 < 5; i3++) {
                for (int i4 = 0; i4 < 5; i4++) {
                    int i5 = i + i4;
                    int i6 = i2 + i3;
                    if (o(vdVar.b(i5, i6))) {
                        vdVar.f(i5, i6, d[i3][i4]);
                    } else {
                        throw new WriterException();
                    }
                }
            }
            return;
        }
        throw new WriterException("Bad position adjustment");
    }

    private static void i(int i, int i2, vd vdVar) throws WriterException {
        int[][] iArr = a;
        if (iArr[0].length == 7 && iArr.length == 7) {
            for (int i3 = 0; i3 < 7; i3++) {
                for (int i4 = 0; i4 < 7; i4++) {
                    int i5 = i + i4;
                    int i6 = i2 + i3;
                    if (o(vdVar.b(i5, i6))) {
                        vdVar.f(i5, i6, a[i3][i4]);
                    } else {
                        throw new WriterException();
                    }
                }
            }
            return;
        }
        throw new WriterException("Bad position detection pattern");
    }

    private static void j(vd vdVar) throws WriterException {
        int length = a[0].length;
        i(0, 0, vdVar);
        i(vdVar.e() - length, 0, vdVar);
        i(0, vdVar.e() - length, vdVar);
        int length2 = b[0].length;
        int i = length2 - 1;
        g(0, i, vdVar);
        g(vdVar.e() - length2, i, vdVar);
        g(0, vdVar.e() - length2, vdVar);
        int length3 = c.length;
        m(length3, 0, vdVar);
        m((vdVar.d() - length3) - 1, 0, vdVar);
        m(length3, vdVar.d() - length3, vdVar);
    }

    private static void k(vd vdVar) throws WriterException {
        int i = 8;
        while (i < vdVar.e() - 8) {
            int i2 = i + 1;
            int i3 = i2 % 2;
            if (p(vdVar.b(i, 6))) {
                if (o(vdVar.b(i, 6))) {
                    vdVar.f(i, 6, i3);
                }
                if (p(vdVar.b(6, i))) {
                    if (o(vdVar.b(6, i))) {
                        vdVar.f(6, i, i3);
                    }
                    i = i2;
                } else {
                    throw new WriterException();
                }
            } else {
                throw new WriterException();
            }
        }
    }

    public static void l(ge0 ge0, int i, vd vdVar) throws WriterException {
        tb tbVar = new tb();
        q(ge0, i, tbVar);
        for (int i2 = 0; i2 < tbVar.f(); i2++) {
            boolean e2 = tbVar.e((tbVar.f() - 1) - i2);
            int[][] iArr = f;
            vdVar.g(iArr[i2][0], iArr[i2][1], e2);
            if (i2 < 8) {
                vdVar.g((vdVar.e() - i2) - 1, 8, e2);
            } else {
                vdVar.g(8, (vdVar.d() - 7) + (i2 - 8), e2);
            }
        }
    }

    private static void m(int i, int i2, vd vdVar) throws WriterException {
        int[][] iArr = c;
        if (iArr[0].length == 1 && iArr.length == 7) {
            for (int i3 = 0; i3 < 7; i3++) {
                int i4 = i2 + i3;
                if (o(vdVar.b(i, i4))) {
                    vdVar.f(i, i4, c[i3][0]);
                } else {
                    throw new WriterException();
                }
            }
            return;
        }
        throw new WriterException("Bad vertical separation pattern");
    }

    public static int n(int i) {
        int i2 = 0;
        while (i != 0) {
            i >>>= 1;
            i2++;
        }
        return i2;
    }

    private static boolean o(int i) {
        return i == -1;
    }

    private static boolean p(int i) {
        return i == -1 || i == 0 || i == 1;
    }

    public static void q(ge0 ge0, int i, tb tbVar) throws WriterException {
        if (dw1.j(i)) {
            int a2 = (ge0.a() << 3) | i;
            tbVar.c(a2, 5);
            tbVar.c(b(a2, 1335), 10);
            tb tbVar2 = new tb();
            tbVar2.c(21522, 15);
            tbVar.j(tbVar2);
            if (tbVar.f() != 15) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("should not happen but we got: ");
                stringBuffer.append(tbVar.f());
                throw new WriterException(stringBuffer.toString());
            }
            return;
        }
        throw new WriterException("Invalid mask pattern");
    }

    public static void r(int i, tb tbVar) throws WriterException {
        tbVar.c(i, 6);
        tbVar.c(b(i, 7973), 12);
        if (tbVar.f() != 18) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("should not happen but we got: ");
            stringBuffer.append(tbVar.f());
            throw new WriterException(stringBuffer.toString());
        }
    }

    private static void s(int i, vd vdVar) throws WriterException {
        if (i >= 2) {
            int i2 = i - 1;
            int[][] iArr = e;
            int[] iArr2 = iArr[i2];
            int length = iArr[i2].length;
            for (int i3 = 0; i3 < length; i3++) {
                for (int i4 = 0; i4 < length; i4++) {
                    int i5 = iArr2[i3];
                    int i6 = iArr2[i4];
                    if (!(i6 == -1 || i5 == -1 || !o(vdVar.b(i6, i5)))) {
                        h(i6 - 2, i5 - 2, vdVar);
                    }
                }
            }
        }
    }

    public static void t(int i, vd vdVar) throws WriterException {
        if (i >= 7) {
            tb tbVar = new tb();
            r(i, tbVar);
            int i2 = 17;
            for (int i3 = 0; i3 < 6; i3++) {
                for (int i4 = 0; i4 < 3; i4++) {
                    boolean e2 = tbVar.e(i2);
                    i2--;
                    vdVar.g(i3, (vdVar.d() - 11) + i4, e2);
                    vdVar.g((vdVar.d() - 11) + i4, i3, e2);
                }
            }
        }
    }
}
