package com.meizu.cloud.pushsdk.d.b;

/* compiled from: Taobao */
public enum b {
    Single(1),
    DefaultGroup(3),
    HeavyGroup(25);
    
    private final int d;

    private b(int i) {
        this.d = i;
    }

    public int a() {
        return this.d;
    }
}
