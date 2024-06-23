package tb;

/* compiled from: Taobao */
public class xy {
    public static final Object DEFAULT_VALUE = null;
    public static final int TYPE_GREATER = 1;
    public static final int TYPE_GREATER_EQUAL = 3;
    public static final int TYPE_LESS = 2;
    public static final int TYPE_LESS_EQUAL = 4;

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0062 A[Catch:{ all -> 0x0126 }] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00ae A[Catch:{ all -> 0x0126 }] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00b5 A[Catch:{ all -> 0x0126 }] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00bf A[Catch:{ all -> 0x0126 }] */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x00f0  */
    public static Object a(Object[] objArr, int i) {
        double d;
        long j;
        boolean z;
        double e;
        if (objArr != null) {
            try {
                if (objArr.length == 2) {
                    boolean z2 = false;
                    Object obj = objArr[0];
                    Object obj2 = objArr[1];
                    double d2 = 0.0d;
                    long j2 = 0;
                    if (!(obj instanceof Integer)) {
                        if (!(obj instanceof Long)) {
                            if (yy.c(obj)) {
                                e = ((Number) obj).doubleValue();
                            } else if ((obj instanceof String) && !yy.b((String) obj)) {
                                j = yy.g((String) obj);
                                d = 0.0d;
                                z = false;
                                if (!(obj2 instanceof Integer)) {
                                }
                                if (z) {
                                }
                                if (z) {
                                }
                                return DEFAULT_VALUE;
                            } else if (!(obj instanceof String) || !yy.b((String) obj)) {
                                d = 0.0d;
                                j = 0;
                                z = false;
                                if (!(obj2 instanceof Integer)) {
                                    if (!(obj2 instanceof Long)) {
                                        if (yy.c(obj2)) {
                                            if (!z) {
                                                d = (double) j;
                                            }
                                            d2 = ((Number) obj2).doubleValue();
                                        } else if (!(obj2 instanceof String) || yy.b((String) obj2)) {
                                            if ((obj2 instanceof String) && yy.b((String) obj2)) {
                                                if (!z) {
                                                    d = (double) j;
                                                }
                                                d2 = yy.e((String) obj2);
                                            }
                                            if (z) {
                                                if (i == 1) {
                                                    if (d > d2) {
                                                        z2 = true;
                                                    }
                                                    return Boolean.valueOf(z2);
                                                } else if (i == 2) {
                                                    if (d < d2) {
                                                        z2 = true;
                                                    }
                                                    return Boolean.valueOf(z2);
                                                } else if (i == 3) {
                                                    if (d >= d2) {
                                                        z2 = true;
                                                    }
                                                    return Boolean.valueOf(z2);
                                                } else if (i == 4) {
                                                    if (d <= d2) {
                                                        z2 = true;
                                                    }
                                                    return Boolean.valueOf(z2);
                                                }
                                            } else if (i == 1) {
                                                if (j > j2) {
                                                    z2 = true;
                                                }
                                                return Boolean.valueOf(z2);
                                            } else if (i == 2) {
                                                if (j < j2) {
                                                    z2 = true;
                                                }
                                                return Boolean.valueOf(z2);
                                            } else if (i == 3) {
                                                if (j >= j2) {
                                                    z2 = true;
                                                }
                                                return Boolean.valueOf(z2);
                                            } else if (i == 4) {
                                                if (j <= j2) {
                                                    z2 = true;
                                                }
                                                return Boolean.valueOf(z2);
                                            }
                                            return DEFAULT_VALUE;
                                        } else {
                                            if (!z) {
                                                j2 = yy.g((String) obj2);
                                            } else {
                                                d2 = yy.e((String) obj2);
                                            }
                                            if (z) {
                                            }
                                            return DEFAULT_VALUE;
                                        }
                                        z = true;
                                        if (z) {
                                        }
                                        return DEFAULT_VALUE;
                                    }
                                }
                                if (z) {
                                    j2 = ((Number) obj2).longValue();
                                } else {
                                    d2 = ((Number) obj2).doubleValue();
                                }
                                if (z) {
                                }
                                return DEFAULT_VALUE;
                            } else {
                                e = yy.e((String) obj);
                            }
                            d = e;
                            z = true;
                            j = 0;
                            if (!(obj2 instanceof Integer)) {
                            }
                            if (z) {
                            }
                            if (z) {
                            }
                            return DEFAULT_VALUE;
                        }
                    }
                    j = ((Number) obj).longValue();
                    d = 0.0d;
                    z = false;
                    if (!(obj2 instanceof Integer)) {
                    }
                    if (z) {
                    }
                    if (z) {
                    }
                    return DEFAULT_VALUE;
                }
            } catch (Throwable th) {
                vx.b(th);
                return DEFAULT_VALUE;
            }
        }
        return DEFAULT_VALUE;
    }
}
