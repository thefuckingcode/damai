package com.caverock.androidsvg;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class c {
    private static final float[] b = {1.0f, 10.0f, 100.0f, 1000.0f, 10000.0f, 100000.0f, 1000000.0f, 1.0E7f, 1.0E8f, 1.0E9f, 1.0E10f, 9.9999998E10f, 1.0E12f, 9.9999998E12f, 1.0E14f, 9.9999999E14f, 1.00000003E16f, 9.9999998E16f, 9.9999998E17f, 1.0E19f, 1.0E20f, 1.0E21f, 1.0E22f, 1.0E23f, 1.0E24f, 1.0E25f, 1.0E26f, 1.0E27f, 1.0E28f, 1.0E29f, 1.0E30f, 1.0E31f, 1.0E32f, 1.0E33f, 1.0E34f, 1.0E35f, 1.0E36f, 1.0E37f, 1.0E38f};
    private static final float[] c = {1.0f, 0.1f, 0.01f, 0.001f, 1.0E-4f, 1.0E-5f, 1.0E-6f, 1.0E-7f, 1.0E-8f, 1.0E-9f, 1.0E-10f, 1.0E-11f, 1.0E-12f, 1.0E-13f, 1.0E-14f, 1.0E-15f, 1.0E-16f, 1.0E-17f, 1.0E-18f, 1.0E-19f, 1.0E-20f, 1.0E-21f, 1.0E-22f, 1.0E-23f, 1.0E-24f, 1.0E-25f, 1.0E-26f, 1.0E-27f, 1.0E-28f, 1.0E-29f, 1.0E-30f, 1.0E-31f, 1.0E-32f, 1.0E-33f, 1.0E-34f, 1.0E-35f, 1.0E-36f, 1.0E-37f, 1.0E-38f};
    private int a;

    c() {
    }

    /* access modifiers changed from: package-private */
    public int a() {
        return this.a;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x008a A[EDGE_INSN: B:108:0x008a->B:39:0x008a ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00b6 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00b7  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00db  */
    public float b(String str, int i, int i2) {
        boolean z;
        int i3;
        boolean z2;
        int i4;
        float f;
        char charAt;
        int i5;
        boolean z3;
        boolean z4;
        char charAt2;
        this.a = i;
        if (i >= i2) {
            return Float.NaN;
        }
        char charAt3 = str.charAt(i);
        if (charAt3 == '+') {
            z = false;
        } else if (charAt3 != '-') {
            z = false;
            int i6 = this.a;
            long j = 0;
            i3 = 0;
            int i7 = 0;
            int i8 = 0;
            z2 = false;
            int i9 = 0;
            while (true) {
                i4 = this.a;
                if (i4 >= i2) {
                    break;
                }
                char charAt4 = str.charAt(i4);
                if (charAt4 == '0') {
                    if (i3 == 0) {
                        i8++;
                    } else {
                        i7++;
                    }
                } else if (charAt4 < '1' || charAt4 > '9') {
                    if (charAt4 != '.' || z2) {
                        break;
                    }
                    i9 = this.a - i6;
                    z2 = true;
                } else {
                    int i10 = i3 + i7;
                    while (i7 > 0) {
                        if (j > 922337203685477580L) {
                            return Float.NaN;
                        }
                        j *= 10;
                        i7--;
                    }
                    if (j > 922337203685477580L) {
                        return Float.NaN;
                    }
                    j = (j * 10) + ((long) (charAt4 - '0'));
                    i3 = i10 + 1;
                    if (j < 0) {
                        return Float.NaN;
                    }
                }
                this.a++;
            }
            if (!z2 && this.a == i9 + 1) {
                return Float.NaN;
            }
            if (i3 == 0) {
                if (i8 == 0) {
                    return Float.NaN;
                }
                i3 = 1;
            }
            if (z2) {
                i7 = (i9 - i8) - i3;
            }
            int i11 = this.a;
            if (i11 < i2 && ((charAt = str.charAt(i11)) == 'E' || charAt == 'e')) {
                i5 = this.a + 1;
                this.a = i5;
                if (i5 != i2) {
                    return Float.NaN;
                }
                char charAt5 = str.charAt(i5);
                if (charAt5 == '+') {
                    z4 = false;
                } else if (charAt5 != '-') {
                    switch (charAt5) {
                        case '0':
                        case '1':
                        case '2':
                        case '3':
                        case '4':
                        case '5':
                        case '6':
                        case '7':
                        case '8':
                        case '9':
                            z4 = false;
                            z3 = false;
                            break;
                        default:
                            this.a--;
                            z4 = false;
                            z3 = true;
                            break;
                    }
                    if (!z3) {
                        int i12 = this.a;
                        int i13 = 0;
                        while (true) {
                            int i14 = this.a;
                            if (i14 < i2 && (charAt2 = str.charAt(i14)) >= '0' && charAt2 <= '9') {
                                if (((long) i13) > 922337203685477580L) {
                                    return Float.NaN;
                                }
                                i13 = (i13 * 10) + (charAt2 - '0');
                                this.a++;
                            }
                        }
                        if (this.a == i12) {
                            return Float.NaN;
                        }
                        i7 = z4 ? i7 - i13 : i7 + i13;
                    }
                } else {
                    z4 = true;
                }
                this.a++;
                z3 = false;
                if (!z3) {
                }
            }
            int i15 = i3 + i7;
            if (i15 > 39 || i15 < -44) {
                return Float.NaN;
            }
            float f2 = (float) j;
            if (j != 0) {
                if (i7 > 0) {
                    f = b[i7];
                } else if (i7 < 0) {
                    if (i7 < -38) {
                        f2 = (float) (((double) f2) * 1.0E-20d);
                        i7 += 20;
                    }
                    f = c[-i7];
                }
                f2 *= f;
            }
            return z ? -f2 : f2;
        } else {
            z = true;
        }
        this.a++;
        int i62 = this.a;
        long j2 = 0;
        i3 = 0;
        int i72 = 0;
        int i82 = 0;
        z2 = false;
        int i92 = 0;
        while (true) {
            i4 = this.a;
            if (i4 >= i2) {
            }
            this.a++;
        }
        if (!z2) {
        }
        if (i3 == 0) {
        }
        if (z2) {
        }
        int i112 = this.a;
        i5 = this.a + 1;
        this.a = i5;
        if (i5 != i2) {
        }
    }
}
