package tb;

import android.graphics.Matrix;
import android.graphics.Path;
import android.os.Build;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class zo1 {

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class b {
        int a;
        boolean b;

        private b() {
        }
    }

    /* compiled from: Taobao */
    public static class c {
        char a;
        float[] b;

        c(char c, float[] fArr) {
            this.a = c;
            this.b = fArr;
        }

        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        private static void a(Path path, float[] fArr, char c, char c2, float[] fArr2) {
            int i;
            int i2;
            float f;
            float f2;
            float f3;
            float f4;
            float f5;
            float f6;
            float f7;
            float f8;
            char c3 = c2;
            float f9 = fArr[0];
            float f10 = fArr[1];
            float f11 = fArr[2];
            float f12 = fArr[3];
            float f13 = fArr[4];
            float f14 = fArr[5];
            switch (c3) {
                case 'A':
                case 'a':
                    i = 7;
                    break;
                case 'C':
                case 'c':
                    i = 6;
                    break;
                case 'H':
                case 'V':
                case 'h':
                case 'v':
                    i = 1;
                    break;
                case 'L':
                case 'M':
                case 'T':
                case 'l':
                case 'm':
                case 't':
                default:
                    i = 2;
                    break;
                case 'Q':
                case 'S':
                case 'q':
                case 's':
                    i = 4;
                    break;
                case 'Z':
                case 'z':
                    path.close();
                    path.moveTo(f13, f14);
                    f9 = f13;
                    f11 = f9;
                    f10 = f14;
                    f12 = f10;
                    i = 2;
                    break;
            }
            float f15 = f9;
            float f16 = f10;
            float f17 = f13;
            float f18 = f14;
            int i3 = 0;
            char c4 = c;
            while (i3 < fArr2.length) {
                if (c3 != 'A') {
                    if (c3 == 'C') {
                        i2 = i3;
                        int i4 = i2 + 2;
                        int i5 = i2 + 3;
                        int i6 = i2 + 4;
                        int i7 = i2 + 5;
                        path.cubicTo(fArr2[i2 + 0], fArr2[i2 + 1], fArr2[i4], fArr2[i5], fArr2[i6], fArr2[i7]);
                        f15 = fArr2[i6];
                        float f19 = fArr2[i7];
                        float f20 = fArr2[i4];
                        float f21 = fArr2[i5];
                        f16 = f19;
                        f12 = f21;
                        f11 = f20;
                    } else if (c3 == 'H') {
                        i2 = i3;
                        int i8 = i2 + 0;
                        path.lineTo(fArr2[i8], f16);
                        f15 = fArr2[i8];
                    } else if (c3 == 'Q') {
                        i2 = i3;
                        int i9 = i2 + 0;
                        int i10 = i2 + 1;
                        int i11 = i2 + 2;
                        int i12 = i2 + 3;
                        path.quadTo(fArr2[i9], fArr2[i10], fArr2[i11], fArr2[i12]);
                        float f22 = fArr2[i9];
                        float f23 = fArr2[i10];
                        f15 = fArr2[i11];
                        f16 = fArr2[i12];
                        f11 = f22;
                        f12 = f23;
                    } else if (c3 == 'V') {
                        i2 = i3;
                        int i13 = i2 + 0;
                        path.lineTo(f15, fArr2[i13]);
                        f16 = fArr2[i13];
                    } else if (c3 != 'a') {
                        if (c3 == 'c') {
                            int i14 = i3 + 2;
                            int i15 = i3 + 3;
                            int i16 = i3 + 4;
                            int i17 = i3 + 5;
                            path.rCubicTo(fArr2[i3 + 0], fArr2[i3 + 1], fArr2[i14], fArr2[i15], fArr2[i16], fArr2[i17]);
                            f2 = fArr2[i14] + f15;
                            f = fArr2[i15] + f16;
                            f15 += fArr2[i16];
                            f3 = fArr2[i17];
                            f16 += f3;
                            f11 = f2;
                            f12 = f;
                        } else if (c3 != 'h') {
                            if (c3 != 'q') {
                                if (c3 == 'v') {
                                    int i18 = i3 + 0;
                                    path.rLineTo(0.0f, fArr2[i18]);
                                    f4 = fArr2[i18];
                                } else if (c3 != 'L') {
                                    if (c3 == 'M') {
                                        int i19 = i3 + 0;
                                        f15 = fArr2[i19];
                                        int i20 = i3 + 1;
                                        f16 = fArr2[i20];
                                        if (i3 > 0) {
                                            path.lineTo(fArr2[i19], fArr2[i20]);
                                        } else {
                                            path.moveTo(fArr2[i19], fArr2[i20]);
                                        }
                                    } else if (c3 == 'S') {
                                        if (c4 == 'c' || c4 == 's' || c4 == 'C' || c4 == 'S') {
                                            f15 = (f15 * 2.0f) - f11;
                                            f16 = (f16 * 2.0f) - f12;
                                        }
                                        int i21 = i3 + 0;
                                        int i22 = i3 + 1;
                                        int i23 = i3 + 2;
                                        int i24 = i3 + 3;
                                        path.cubicTo(f15, f16, fArr2[i21], fArr2[i22], fArr2[i23], fArr2[i24]);
                                        f2 = fArr2[i21];
                                        f = fArr2[i22];
                                        f15 = fArr2[i23];
                                        f16 = fArr2[i24];
                                        f11 = f2;
                                        f12 = f;
                                    } else if (c3 == 'T') {
                                        if (c4 == 'q' || c4 == 't' || c4 == 'Q' || c4 == 'T') {
                                            f15 = (f15 * 2.0f) - f11;
                                            f16 = (f16 * 2.0f) - f12;
                                        }
                                        int i25 = i3 + 0;
                                        int i26 = i3 + 1;
                                        path.quadTo(f15, f16, fArr2[i25], fArr2[i26]);
                                        float f24 = fArr2[i25];
                                        float f25 = fArr2[i26];
                                        i2 = i3;
                                        f12 = f16;
                                        f11 = f15;
                                        f15 = f24;
                                        f16 = f25;
                                    } else if (c3 == 'l') {
                                        int i27 = i3 + 0;
                                        int i28 = i3 + 1;
                                        path.rLineTo(fArr2[i27], fArr2[i28]);
                                        f15 += fArr2[i27];
                                        f4 = fArr2[i28];
                                    } else if (c3 == 'm') {
                                        int i29 = i3 + 0;
                                        f15 += fArr2[i29];
                                        int i30 = i3 + 1;
                                        f16 += fArr2[i30];
                                        if (i3 > 0) {
                                            path.rLineTo(fArr2[i29], fArr2[i30]);
                                        } else {
                                            path.rMoveTo(fArr2[i29], fArr2[i30]);
                                        }
                                    } else if (c3 == 's') {
                                        if (c4 == 'c' || c4 == 's' || c4 == 'C' || c4 == 'S') {
                                            float f26 = f15 - f11;
                                            f5 = f16 - f12;
                                            f6 = f26;
                                        } else {
                                            f6 = 0.0f;
                                            f5 = 0.0f;
                                        }
                                        int i31 = i3 + 0;
                                        int i32 = i3 + 1;
                                        int i33 = i3 + 2;
                                        int i34 = i3 + 3;
                                        path.rCubicTo(f6, f5, fArr2[i31], fArr2[i32], fArr2[i33], fArr2[i34]);
                                        f2 = fArr2[i31] + f15;
                                        f = fArr2[i32] + f16;
                                        f15 += fArr2[i33];
                                        f3 = fArr2[i34];
                                    } else if (c3 == 't') {
                                        if (c4 == 'q' || c4 == 't' || c4 == 'Q' || c4 == 'T') {
                                            f7 = f15 - f11;
                                            f8 = f16 - f12;
                                        } else {
                                            f8 = 0.0f;
                                            f7 = 0.0f;
                                        }
                                        int i35 = i3 + 0;
                                        int i36 = i3 + 1;
                                        path.rQuadTo(f7, f8, fArr2[i35], fArr2[i36]);
                                        float f27 = f7 + f15;
                                        float f28 = f8 + f16;
                                        f15 += fArr2[i35];
                                        f16 += fArr2[i36];
                                        f12 = f28;
                                        f11 = f27;
                                    }
                                    i2 = i3;
                                    f18 = f16;
                                    f17 = f15;
                                } else {
                                    int i37 = i3 + 0;
                                    int i38 = i3 + 1;
                                    path.lineTo(fArr2[i37], fArr2[i38]);
                                    f15 = fArr2[i37];
                                    f16 = fArr2[i38];
                                }
                                f16 += f4;
                            } else {
                                int i39 = i3 + 0;
                                int i40 = i3 + 1;
                                int i41 = i3 + 2;
                                int i42 = i3 + 3;
                                path.rQuadTo(fArr2[i39], fArr2[i40], fArr2[i41], fArr2[i42]);
                                f2 = fArr2[i39] + f15;
                                f = fArr2[i40] + f16;
                                f15 += fArr2[i41];
                                f3 = fArr2[i42];
                            }
                            f16 += f3;
                            f11 = f2;
                            f12 = f;
                        } else {
                            int i43 = i3 + 0;
                            path.rLineTo(fArr2[i43], 0.0f);
                            f15 += fArr2[i43];
                        }
                        i2 = i3;
                    } else {
                        int i44 = i3 + 5;
                        int i45 = i3 + 6;
                        i2 = i3;
                        c(path, f15, f16, fArr2[i44] + f15, fArr2[i45] + f16, fArr2[i3 + 0], fArr2[i3 + 1], fArr2[i3 + 2], fArr2[i3 + 3] != 0.0f, fArr2[i3 + 4] != 0.0f);
                        f15 += fArr2[i44];
                        f16 += fArr2[i45];
                    }
                    i3 = i2 + i;
                    c4 = c2;
                    c3 = c4;
                } else {
                    i2 = i3;
                    int i46 = i2 + 5;
                    int i47 = i2 + 6;
                    c(path, f15, f16, fArr2[i46], fArr2[i47], fArr2[i2 + 0], fArr2[i2 + 1], fArr2[i2 + 2], fArr2[i2 + 3] != 0.0f, fArr2[i2 + 4] != 0.0f);
                    f15 = fArr2[i46];
                    f16 = fArr2[i47];
                }
                f12 = f16;
                f11 = f15;
                i3 = i2 + i;
                c4 = c2;
                c3 = c4;
            }
            fArr[0] = f15;
            fArr[1] = f16;
            fArr[2] = f11;
            fArr[3] = f12;
            fArr[4] = f17;
            fArr[5] = f18;
        }

        private static void b(Path path, double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9) {
            double d10 = d3;
            int ceil = (int) Math.ceil(Math.abs((d9 * 4.0d) / 3.141592653589793d));
            double cos = Math.cos(d7);
            double sin = Math.sin(d7);
            double cos2 = Math.cos(d8);
            double sin2 = Math.sin(d8);
            double d11 = -d10;
            double d12 = d11 * cos;
            double d13 = d4 * sin;
            double d14 = (d12 * sin2) - (d13 * cos2);
            double d15 = d11 * sin;
            double d16 = d4 * cos;
            double d17 = (sin2 * d15) + (cos2 * d16);
            double d18 = d9 / ((double) ceil);
            double d19 = d8;
            double d20 = d17;
            double d21 = d14;
            int i = 0;
            double d22 = d5;
            double d23 = d6;
            while (i < ceil) {
                double d24 = d19 + d18;
                double sin3 = Math.sin(d24);
                double cos3 = Math.cos(d24);
                double d25 = (d + ((d10 * cos) * cos3)) - (d13 * sin3);
                double d26 = d2 + (d10 * sin * cos3) + (d16 * sin3);
                double d27 = (d12 * sin3) - (d13 * cos3);
                double d28 = (sin3 * d15) + (cos3 * d16);
                double d29 = d24 - d19;
                double tan = Math.tan(d29 / 2.0d);
                double sin4 = (Math.sin(d29) * (Math.sqrt(((tan * 3.0d) * tan) + 4.0d) - 1.0d)) / 3.0d;
                path.rLineTo(0.0f, 0.0f);
                path.cubicTo((float) (d22 + (d21 * sin4)), (float) (d23 + (d20 * sin4)), (float) (d25 - (sin4 * d27)), (float) (d26 - (sin4 * d28)), (float) d25, (float) d26);
                i++;
                d18 = d18;
                sin = sin;
                d22 = d25;
                d15 = d15;
                cos = cos;
                d19 = d24;
                d20 = d28;
                d21 = d27;
                ceil = ceil;
                d23 = d26;
                d10 = d3;
            }
        }

        private static void c(Path path, float f, float f2, float f3, float f4, float f5, float f6, float f7, boolean z, boolean z2) {
            double d;
            double d2;
            double radians = Math.toRadians((double) f7);
            double cos = Math.cos(radians);
            double sin = Math.sin(radians);
            double d3 = (double) f;
            double d4 = d3 * cos;
            double d5 = (double) f2;
            double d6 = (double) f5;
            double d7 = (d4 + (d5 * sin)) / d6;
            double d8 = (double) f6;
            double d9 = ((((double) (-f)) * sin) + (d5 * cos)) / d8;
            double d10 = (double) f4;
            double d11 = ((((double) f3) * cos) + (d10 * sin)) / d6;
            double d12 = ((((double) (-f3)) * sin) + (d10 * cos)) / d8;
            double d13 = d7 - d11;
            double d14 = d9 - d12;
            double d15 = (d7 + d11) / 2.0d;
            double d16 = (d9 + d12) / 2.0d;
            double d17 = (d13 * d13) + (d14 * d14);
            if (d17 != 0.0d) {
                double d18 = (1.0d / d17) - 0.25d;
                if (d18 < 0.0d) {
                    float sqrt = (float) (Math.sqrt(d17) / 1.99999d);
                    c(path, f, f2, f3, f4, f5 * sqrt, f6 * sqrt, f7, z, z2);
                    return;
                }
                double sqrt2 = Math.sqrt(d18);
                double d19 = d13 * sqrt2;
                double d20 = sqrt2 * d14;
                if (z == z2) {
                    d2 = d15 - d20;
                    d = d16 + d19;
                } else {
                    d2 = d15 + d20;
                    d = d16 - d19;
                }
                double atan2 = Math.atan2(d9 - d, d7 - d2);
                double atan22 = Math.atan2(d12 - d, d11 - d2) - atan2;
                int i = (atan22 > 0.0d ? 1 : (atan22 == 0.0d ? 0 : -1));
                if (z2 != (i >= 0)) {
                    atan22 = i > 0 ? atan22 - 6.283185307179586d : atan22 + 6.283185307179586d;
                }
                double d21 = d2 * d6;
                double d22 = d * d8;
                b(path, (d21 * cos) - (d22 * sin), (d21 * sin) + (d22 * cos), d6, d8, d3, d5, radians, atan2, atan22);
            }
        }

        public static void d(c[] cVarArr, Path path) {
            float[] fArr = new float[6];
            char c = 'm';
            for (c cVar : cVarArr) {
                a(path, fArr, c, cVar.a, cVar.b);
                c = cVar.a;
            }
        }
    }

    private static void a(List<c> list, char c2, float[] fArr) {
        list.add(new c(c2, fArr));
    }

    static float[] b(@NonNull float[] fArr, int i, int i2) {
        int i3 = i2 - i;
        int min = Math.min(i3, fArr.length - i);
        float[] fArr2 = new float[i3];
        System.arraycopy(fArr, i, fArr2, 0, min);
        return fArr2;
    }

    public static c[] c(String str) {
        if (str == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i = 1;
        int i2 = 0;
        while (i < str.length()) {
            int g = g(str, i);
            String trim = str.substring(i2, g).trim();
            if (trim.length() > 0) {
                a(arrayList, trim.charAt(0), f(trim));
            }
            i2 = g;
            i = g + 1;
        }
        if (i - i2 == 1 && i2 < str.length()) {
            a(arrayList, str.charAt(i2), new float[0]);
        }
        return (c[]) arrayList.toArray(new c[arrayList.size()]);
    }

    public static Path d(String str) {
        Path path = new Path();
        c[] c2 = c(str);
        if (c2 == null) {
            return null;
        }
        try {
            c.d(c2, path);
            return path;
        } catch (RuntimeException e) {
            throw new RuntimeException("Error in parsing " + str, e);
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x003a A[LOOP:0: B:1:0x0007->B:20:0x003a, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x003d A[SYNTHETIC] */
    private static void e(String str, int i, b bVar) {
        bVar.b = false;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        for (int i2 = i; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            if (charAt != ' ') {
                if (charAt == 'E' || charAt == 'e') {
                    z = true;
                    if (z3) {
                        bVar.a = i2;
                    }
                } else {
                    switch (charAt) {
                        case ',':
                            break;
                        case '-':
                            if (i2 != i && !z) {
                                bVar.b = true;
                                break;
                            }
                            z = false;
                            break;
                        case '.':
                            if (!z2) {
                                z = false;
                                z2 = true;
                                break;
                            } else {
                                bVar.b = true;
                                break;
                            }
                        default:
                            z = false;
                            break;
                    }
                    if (z3) {
                    }
                }
            }
            z = false;
            z3 = true;
            if (z3) {
            }
        }
        bVar.a = i2;
    }

    private static float[] f(String str) {
        int i = 1;
        if ((str.charAt(0) == 'z') || (str.charAt(0) == 'Z')) {
            return new float[0];
        }
        try {
            float[] fArr = new float[str.length()];
            b bVar = new b();
            int length = str.length();
            int i2 = 0;
            while (i < length) {
                e(str, i, bVar);
                int i3 = bVar.a;
                if (i < i3) {
                    fArr[i2] = Float.parseFloat(str.substring(i, i3));
                    i2++;
                }
                i = bVar.b ? i3 : i3 + 1;
            }
            return b(fArr, 0, i2);
        } catch (NumberFormatException e) {
            throw new RuntimeException("error in parsing \"" + str + "\"", e);
        }
    }

    private static int g(String str, int i) {
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (((charAt - 'A') * (charAt - 'Z') <= 0 || (charAt - 'a') * (charAt - 'z') <= 0) && charAt != 'e' && charAt != 'E') {
                return i;
            }
            i++;
        }
        return i;
    }

    public static List<Path> h(float f, float f2, List<Path> list, List<String> list2) {
        Matrix matrix = new Matrix();
        matrix.setScale(f, f2);
        ArrayList arrayList = new ArrayList();
        if (Build.VERSION.SDK_INT > 16) {
            for (Path path : list) {
                Path path2 = new Path();
                path.transform(matrix, path2);
                arrayList.add(path2);
            }
        } else {
            for (String str : list2) {
                Path path3 = new Path();
                c[] c2 = c(str);
                j(f, f2, c2);
                c.d(c2, path3);
                arrayList.add(path3);
            }
        }
        return arrayList;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0048, code lost:
        if (r20 == 's') goto L_0x004b;
     */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x005a  */
    private static void i(float f, float f2, char c2, float[] fArr) {
        int i;
        char c3 = 'H';
        int i2 = 2;
        if (c2 != 'A') {
            if (c2 != 'C') {
                if (c2 != 'H') {
                    if (c2 != 'Q') {
                        if (c2 != 'V') {
                            if (c2 != 'a') {
                                if (c2 != 'c') {
                                    if (c2 != 'h') {
                                        if (c2 != 'q') {
                                            if (c2 != 'v') {
                                                if (c2 != 'L') {
                                                    if (c2 != 'M') {
                                                        if (c2 != 'S') {
                                                            if (c2 != 'T') {
                                                                if (c2 != 'l') {
                                                                    if (c2 != 'm') {
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                                i = 0;
                                                while (i < fArr.length) {
                                                    if (c2 != 'A') {
                                                        if (c2 != 'C') {
                                                            if (c2 != c3) {
                                                                if (c2 != 'Q') {
                                                                    if (c2 != 'V') {
                                                                        if (c2 != 'a') {
                                                                            if (c2 != 'c') {
                                                                                if (c2 != 'h') {
                                                                                    if (c2 != 'q') {
                                                                                        if (c2 != 'v') {
                                                                                            if (c2 != 'L' && c2 != 'M') {
                                                                                                if (c2 != 'S') {
                                                                                                    if (!(c2 == 'T' || c2 == 'l' || c2 == 'm')) {
                                                                                                        if (c2 != 's') {
                                                                                                            if (c2 != 't') {
                                                                                                                i += i2;
                                                                                                                c3 = 'H';
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                                fArr[i] = fArr[i] * f;
                                                                                                int i3 = i + 1;
                                                                                                fArr[i3] = fArr[i3] * f2;
                                                                                                int i4 = i + 2;
                                                                                                fArr[i4] = fArr[i4] * f;
                                                                                                int i5 = i + 3;
                                                                                                fArr[i5] = fArr[i5] * f2;
                                                                                                fArr[i] = fArr[i] * f;
                                                                                                int i6 = i + 1;
                                                                                                fArr[i6] = fArr[i6] * f2;
                                                                                                int i7 = i + 5;
                                                                                                fArr[i7] = fArr[i7] * f;
                                                                                                int i8 = i + 6;
                                                                                                fArr[i8] = fArr[i8] * f2;
                                                                                                i += i2;
                                                                                                c3 = 'H';
                                                                                            }
                                                                                            fArr[i] = fArr[i] * f;
                                                                                            int i9 = i + 1;
                                                                                            fArr[i9] = fArr[i9] * f2;
                                                                                            i += i2;
                                                                                            c3 = 'H';
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                    fArr[i] = fArr[i] * f2;
                                                                    i += i2;
                                                                    c3 = 'H';
                                                                }
                                                                fArr[i] = fArr[i] * f;
                                                                int i32 = i + 1;
                                                                fArr[i32] = fArr[i32] * f2;
                                                                int i42 = i + 2;
                                                                fArr[i42] = fArr[i42] * f;
                                                                int i52 = i + 3;
                                                                fArr[i52] = fArr[i52] * f2;
                                                                fArr[i] = fArr[i] * f;
                                                                int i62 = i + 1;
                                                                fArr[i62] = fArr[i62] * f2;
                                                                int i72 = i + 5;
                                                                fArr[i72] = fArr[i72] * f;
                                                                int i82 = i + 6;
                                                                fArr[i82] = fArr[i82] * f2;
                                                                i += i2;
                                                                c3 = 'H';
                                                            }
                                                            fArr[i] = fArr[i] * f;
                                                            i += i2;
                                                            c3 = 'H';
                                                        }
                                                        fArr[i] = fArr[i] * f;
                                                        int i10 = i + 1;
                                                        fArr[i10] = fArr[i10] * f2;
                                                        int i11 = i + 2;
                                                        fArr[i11] = fArr[i11] * f;
                                                        int i12 = i + 3;
                                                        fArr[i12] = fArr[i12] * f2;
                                                        int i13 = i + 4;
                                                        fArr[i13] = fArr[i13] * f;
                                                        int i14 = i + 5;
                                                        fArr[i14] = fArr[i14] * f2;
                                                        i += i2;
                                                        c3 = 'H';
                                                    }
                                                    fArr[i] = fArr[i] * f;
                                                    int i622 = i + 1;
                                                    fArr[i622] = fArr[i622] * f2;
                                                    int i722 = i + 5;
                                                    fArr[i722] = fArr[i722] * f;
                                                    int i822 = i + 6;
                                                    fArr[i822] = fArr[i822] * f2;
                                                    i += i2;
                                                    c3 = 'H';
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    i2 = 4;
                    i = 0;
                    while (i < fArr.length) {
                    }
                }
                i2 = 1;
                i = 0;
                while (i < fArr.length) {
                }
            }
            i2 = 6;
            i = 0;
            while (i < fArr.length) {
            }
        }
        i2 = 7;
        i = 0;
        while (i < fArr.length) {
        }
    }

    private static void j(float f, float f2, c[] cVarArr) {
        for (c cVar : cVarArr) {
            i(f, f2, cVar.a, cVar.b);
        }
    }
}
