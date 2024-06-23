package com.xiaomi.push;

/* compiled from: Taobao */
public class ae {
    private static int a;

    /* renamed from: a  reason: collision with other field name */
    public static final String f84a;

    /* renamed from: a  reason: collision with other field name */
    public static final boolean f85a;
    public static final boolean b;
    public static final boolean c;
    public static final boolean d;
    public static boolean e;
    public static final boolean f;
    public static final boolean g;

    static {
        int i;
        String str = ah.f86a ? "ONEBOX" : "@SHIP.TO.2A2FE0D7@";
        f84a = str;
        boolean contains = str.contains("2A2FE0D7");
        f85a = contains;
        boolean z = false;
        b = contains || "DEBUG".equalsIgnoreCase(str);
        c = "LOGABLE".equalsIgnoreCase(str);
        d = str.contains("YY");
        e = str.equalsIgnoreCase("TEST");
        f = "BETA".equalsIgnoreCase(str);
        if (str.startsWith("RC")) {
            z = true;
        }
        g = z;
        a = 1;
        if (str.equalsIgnoreCase("SANDBOX")) {
            i = 2;
        } else if (str.equalsIgnoreCase("ONEBOX")) {
            i = 3;
        } else {
            a = 1;
            return;
        }
        a = i;
    }

    public static int a() {
        return a;
    }

    public static void a(int i) {
        a = i;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m250a() {
        return a == 2;
    }

    public static boolean b() {
        return a == 3;
    }
}
