package com.xiaomi.push;

/* compiled from: Taobao */
public enum hx {
    RegIdExpired(0),
    PackageUnregistered(1),
    Init(2);
    

    /* renamed from: a  reason: collision with other field name */
    private final int f543a;

    private hx(int i) {
        this.f543a = i;
    }

    public static hx a(int i) {
        if (i == 0) {
            return RegIdExpired;
        }
        if (i == 1) {
            return PackageUnregistered;
        }
        if (i != 2) {
            return null;
        }
        return Init;
    }

    public int a() {
        return this.f543a;
    }
}
