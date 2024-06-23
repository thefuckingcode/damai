package com.xiaomi.push;

/* compiled from: Taobao */
public enum hp {
    MISC_CONFIG(1),
    PLUGIN_CONFIG(2);
    

    /* renamed from: a  reason: collision with other field name */
    private final int f483a;

    private hp(int i) {
        this.f483a = i;
    }

    public static hp a(int i) {
        if (i == 1) {
            return MISC_CONFIG;
        }
        if (i != 2) {
            return null;
        }
        return PLUGIN_CONFIG;
    }

    public int a() {
        return this.f483a;
    }
}
