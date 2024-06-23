package com.amap.api.mapcore.util;

import java.util.ArrayList;
import java.util.HashMap;
import org.apache.commons.lang3.time.DateUtils;

/* compiled from: Taobao */
public final class kz {
    private HashMap<Long, la> a = new HashMap<>();
    private long b = 0;

    private static long a(int i, int i2) {
        return (((long) i2) & 65535) | ((((long) i) & 65535) << 32);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x004a  */
    public final long a(la laVar) {
        long j;
        la laVar2;
        int i;
        int i2;
        if (laVar == null || !laVar.p) {
            return 0;
        }
        HashMap<Long, la> hashMap = this.a;
        int i3 = laVar.k;
        if (i3 != 1) {
            if (i3 == 2) {
                i2 = laVar.c();
                i = laVar.d();
                j = a(i2, i);
                laVar2 = hashMap.get(Long.valueOf(j));
                if (laVar2 == null) {
                }
            } else if (!(i3 == 3 || i3 == 4)) {
                j = 0;
                laVar2 = hashMap.get(Long.valueOf(j));
                if (laVar2 == null) {
                    laVar.m = kc.b();
                    hashMap.put(Long.valueOf(j), laVar);
                    return 0;
                } else if (laVar2.e() != laVar.e()) {
                    laVar.m = kc.b();
                    hashMap.put(Long.valueOf(j), laVar);
                    return 0;
                } else {
                    laVar.m = laVar2.m;
                    hashMap.put(Long.valueOf(j), laVar);
                    return (kc.b() - laVar2.m) / 1000;
                }
            }
        }
        i2 = laVar.a();
        i = laVar.b();
        j = a(i2, i);
        laVar2 = hashMap.get(Long.valueOf(j));
        if (laVar2 == null) {
        }
    }

    public final void a() {
        this.a.clear();
        this.b = 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0038, code lost:
        if (r13 != 4) goto L_0x0048;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0083, code lost:
        if (r12 != 4) goto L_0x009b;
     */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0065 A[SYNTHETIC] */
    public final void a(ArrayList<? extends la> arrayList) {
        int i;
        int i2;
        la laVar;
        int i3;
        int i4;
        if (arrayList != null) {
            long b2 = kc.b();
            long j = this.b;
            long j2 = 0;
            if (j <= 0 || b2 - j >= DateUtils.MILLIS_PER_MINUTE) {
                HashMap<Long, la> hashMap = this.a;
                int size = arrayList.size();
                for (int i5 = 0; i5 < size; i5++) {
                    la laVar2 = (la) arrayList.get(i5);
                    if (laVar2.p) {
                        int i6 = laVar2.k;
                        if (i6 != 1) {
                            if (i6 == 2) {
                                i4 = laVar2.h;
                                i3 = laVar2.i;
                                j2 = a(i4, i3);
                                laVar = hashMap.get(Long.valueOf(j2));
                                if (laVar != null) {
                                    if (laVar.e() == laVar2.e()) {
                                        laVar2.m = laVar.m;
                                    } else {
                                        laVar2.m = b2;
                                    }
                                }
                            } else if (i6 != 3) {
                            }
                        }
                        i4 = laVar2.c;
                        i3 = laVar2.d;
                        j2 = a(i4, i3);
                        laVar = hashMap.get(Long.valueOf(j2));
                        if (laVar != null) {
                        }
                    }
                }
                hashMap.clear();
                int size2 = arrayList.size();
                for (int i7 = 0; i7 < size2; i7++) {
                    la laVar3 = (la) arrayList.get(i7);
                    if (laVar3.p) {
                        int i8 = laVar3.k;
                        if (i8 != 1) {
                            if (i8 == 2) {
                                i2 = laVar3.c();
                                i = laVar3.d();
                                j2 = a(i2, i);
                                hashMap.put(Long.valueOf(j2), laVar3);
                            } else if (i8 != 3) {
                            }
                        }
                        i2 = laVar3.a();
                        i = laVar3.b();
                        j2 = a(i2, i);
                        hashMap.put(Long.valueOf(j2), laVar3);
                    }
                }
                this.b = b2;
            }
        }
    }
}
