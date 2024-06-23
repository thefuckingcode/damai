package tb;

/* compiled from: Taobao */
public class wy {
    public static final int TYPE_ADD = 1;
    public static final int TYPE_DIV = 4;
    public static final int TYPE_MOD = 5;
    public static final int TYPE_MUL = 3;
    public static final int TYPE_SUB = 2;
    public static long a;

    /* JADX WARNING: Removed duplicated region for block: B:110:0x00ec A[ADDED_TO_REGION, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x005e A[Catch:{ all -> 0x0105 }] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x009b A[Catch:{ all -> 0x0105 }] */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x00d3 A[Catch:{ all -> 0x0105 }] */
    public static Object a(Object[] objArr, int i) {
        long j;
        double d;
        if (objArr != null) {
            try {
                if (objArr.length != 0) {
                    int length = objArr.length;
                    long j2 = 0;
                    boolean z = false;
                    double d2 = 0.0d;
                    for (int i2 = 0; i2 < length; i2++) {
                        Object obj = objArr[i2];
                        if (obj instanceof String) {
                            String str = (String) obj;
                            if (!z) {
                                if (!yy.b(str)) {
                                    j = yy.g(str);
                                }
                            }
                            d = yy.e(str);
                            j = 0;
                            z = true;
                            if (z) {
                                if (j2 != 0) {
                                    d2 = (double) j2;
                                    j2 = 0;
                                }
                                if (i2 == 0) {
                                    d2 = d;
                                } else if (i == 1) {
                                    d2 += d;
                                } else if (i == 2) {
                                    d2 -= d;
                                } else if (i == 3) {
                                    d2 *= d;
                                } else if (i != 4) {
                                    if (i == 5) {
                                        if (d == 0.0d) {
                                            return Long.valueOf(a);
                                        }
                                        d2 %= d;
                                    }
                                } else if (d == 0.0d) {
                                    return Long.valueOf(a);
                                } else {
                                    d2 /= d;
                                }
                            } else if (i2 == 0) {
                                j2 = j;
                            } else if (i == 1) {
                                j2 += j;
                            } else if (i == 2) {
                                j2 -= j;
                            } else if (i == 3) {
                                j2 *= j;
                            } else if (i != 4) {
                                if (i == 5) {
                                    if (j == 0) {
                                        return Long.valueOf(a);
                                    }
                                    j2 %= j;
                                }
                            } else if (j == 0) {
                                return Long.valueOf(a);
                            } else {
                                j2 /= j;
                            }
                            if (z && (d2 == Double.POSITIVE_INFINITY || d2 == Double.NEGATIVE_INFINITY || Double.NaN == d2)) {
                                return Double.valueOf(0.0d);
                            }
                        } else {
                            if (!z) {
                                if (!yy.c(obj)) {
                                    if (!(obj instanceof Integer)) {
                                        if (!(obj instanceof Long)) {
                                            j = a;
                                        }
                                    }
                                    j = ((Number) obj).longValue();
                                }
                            }
                            d = ((Number) obj).doubleValue();
                            j = 0;
                            z = true;
                            if (z) {
                            }
                            if (z) {
                            }
                        }
                        d = 0.0d;
                        if (z) {
                        }
                        if (z) {
                        }
                    }
                    if (z) {
                        return Double.valueOf(d2);
                    }
                    return Long.valueOf(j2);
                }
            } catch (Throwable unused) {
                return Long.valueOf(a);
            }
        }
        return Long.valueOf(a);
    }
}
