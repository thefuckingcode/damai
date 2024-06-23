package com.xiaomi.push;

/* compiled from: Taobao */
public class ji {
    private static int a = Integer.MAX_VALUE;

    public static void a(jf jfVar, byte b) {
        a(jfVar, b, a);
    }

    public static void a(jf jfVar, byte b, int i) {
        if (i > 0) {
            int i2 = 0;
            switch (b) {
                case 2:
                    jfVar.m720a();
                    return;
                case 3:
                    jfVar.a();
                    return;
                case 4:
                    jfVar.m708a();
                    return;
                case 5:
                case 7:
                case 9:
                default:
                    return;
                case 6:
                    jfVar.m718a();
                    return;
                case 8:
                    jfVar.m709a();
                    return;
                case 10:
                    jfVar.m710a();
                    return;
                case 11:
                    jfVar.m717a();
                    return;
                case 12:
                    jfVar.m715a();
                    while (true) {
                        byte b2 = jfVar.m711a().a;
                        if (b2 == 0) {
                            jfVar.f();
                            return;
                        } else {
                            a(jfVar, b2, i - 1);
                            jfVar.g();
                        }
                    }
                case 13:
                    je a2 = jfVar.m713a();
                    while (i2 < a2.f803a) {
                        int i3 = i - 1;
                        a(jfVar, a2.a, i3);
                        a(jfVar, a2.b, i3);
                        i2++;
                    }
                    jfVar.h();
                    return;
                case 14:
                    jj a3 = jfVar.m714a();
                    while (i2 < a3.f804a) {
                        a(jfVar, a3.a, i - 1);
                        i2++;
                    }
                    jfVar.j();
                    return;
                case 15:
                    jd a4 = jfVar.m712a();
                    while (i2 < a4.f802a) {
                        a(jfVar, a4.a, i - 1);
                        i2++;
                    }
                    jfVar.i();
                    return;
            }
        } else {
            throw new iz("Maximum skip depth exceeded");
        }
    }
}
