package tb;

/* compiled from: Taobao */
public final class mb1 {
    public static int a(vd vdVar) {
        return b(vdVar, true) + b(vdVar, false);
    }

    private static int b(vd vdVar, boolean z) {
        int d = z ? vdVar.d() : vdVar.e();
        int e = z ? vdVar.e() : vdVar.d();
        byte[][] c = vdVar.c();
        byte b = -1;
        int i = 0;
        for (int i2 = 0; i2 < d; i2++) {
            int i3 = 0;
            for (int i4 = 0; i4 < e; i4++) {
                byte b2 = z ? c[i2][i4] : c[i4][i2];
                if (b2 == b) {
                    i3++;
                    if (i3 == 5) {
                        i += 3;
                    } else if (i3 > 5) {
                        i++;
                    }
                } else {
                    b = b2;
                    i3 = 1;
                }
            }
        }
        return i;
    }

    public static int c(vd vdVar) {
        byte[][] c = vdVar.c();
        int e = vdVar.e();
        int d = vdVar.d();
        int i = 0;
        for (int i2 = 0; i2 < d - 1; i2++) {
            int i3 = 0;
            while (i3 < e - 1) {
                byte b = c[i2][i3];
                int i4 = i3 + 1;
                if (b == c[i2][i4]) {
                    int i5 = i2 + 1;
                    if (b == c[i5][i3] && b == c[i5][i4]) {
                        i += 3;
                    }
                }
                i3 = i4;
            }
        }
        return i;
    }

    public static int d(vd vdVar) {
        int i;
        int i2;
        int i3;
        int i4;
        byte[][] c = vdVar.c();
        int e = vdVar.e();
        int d = vdVar.d();
        int i5 = 0;
        for (int i6 = 0; i6 < d; i6++) {
            for (int i7 = 0; i7 < e; i7++) {
                int i8 = i7 + 6;
                if (i8 < e && c[i6][i7] == 1 && c[i6][i7 + 1] == 0 && c[i6][i7 + 2] == 1 && c[i6][i7 + 3] == 1 && c[i6][i7 + 4] == 1 && c[i6][i7 + 5] == 0 && c[i6][i8] == 1 && (((i3 = i7 + 10) < e && c[i6][i7 + 7] == 0 && c[i6][i7 + 8] == 0 && c[i6][i7 + 9] == 0 && c[i6][i3] == 0) || (i7 - 4 >= 0 && c[i6][i7 - 1] == 0 && c[i6][i7 - 2] == 0 && c[i6][i7 - 3] == 0 && c[i6][i4] == 0))) {
                    i5 += 40;
                }
                int i9 = i6 + 6;
                if (i9 < d && c[i6][i7] == 1 && c[i6 + 1][i7] == 0 && c[i6 + 2][i7] == 1 && c[i6 + 3][i7] == 1 && c[i6 + 4][i7] == 1 && c[i6 + 5][i7] == 0 && c[i9][i7] == 1 && (((i = i6 + 10) < d && c[i6 + 7][i7] == 0 && c[i6 + 8][i7] == 0 && c[i6 + 9][i7] == 0 && c[i][i7] == 0) || (i6 - 4 >= 0 && c[i6 - 1][i7] == 0 && c[i6 - 2][i7] == 0 && c[i6 - 3][i7] == 0 && c[i2][i7] == 0))) {
                    i5 += 40;
                }
            }
        }
        return i5;
    }

    public static int e(vd vdVar) {
        byte[][] c = vdVar.c();
        int e = vdVar.e();
        int d = vdVar.d();
        int i = 0;
        for (int i2 = 0; i2 < d; i2++) {
            for (int i3 = 0; i3 < e; i3++) {
                if (c[i2][i3] == 1) {
                    i++;
                }
            }
        }
        return (Math.abs((int) (((((double) i) / ((double) (vdVar.d() * vdVar.e()))) * 100.0d) - 50.0d)) / 5) * 10;
    }

    public static boolean f(int i, int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        if (dw1.j(i)) {
            switch (i) {
                case 0:
                    i3 += i2;
                case 1:
                    i4 = i3 & 1;
                    break;
                case 2:
                    i4 = i2 % 3;
                    break;
                case 3:
                    i4 = (i3 + i2) % 3;
                    break;
                case 4:
                    i7 = i3 >>> 1;
                    i6 = i2 / 3;
                    i5 = i7 + i6;
                    i4 = i5 & 1;
                    break;
                case 5:
                    int i8 = i3 * i2;
                    i4 = (i8 & 1) + (i8 % 3);
                    break;
                case 6:
                    int i9 = i3 * i2;
                    i5 = (i9 & 1) + (i9 % 3);
                    i4 = i5 & 1;
                    break;
                case 7:
                    i7 = (i3 * i2) % 3;
                    i6 = (i3 + i2) & 1;
                    i5 = i7 + i6;
                    i4 = i5 & 1;
                    break;
                default:
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("Invalid mask pattern: ");
                    stringBuffer.append(i);
                    throw new IllegalArgumentException(stringBuffer.toString());
            }
            if (i4 == 0) {
                return true;
            }
            return false;
        }
        throw new IllegalArgumentException("Invalid mask pattern");
    }
}
