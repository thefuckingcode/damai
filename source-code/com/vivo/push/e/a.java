package com.vivo.push.e;

import java.util.ArrayList;

/* compiled from: Taobao */
public final class a {
    private static String[] a = {"com.vivo.pushservice", "com.vivo.pushdemo.test", "com.vivo.sdk.test", "com.vivo.hybrid"};
    private ArrayList<String> b;

    /* renamed from: com.vivo.push.e.a$a  reason: collision with other inner class name */
    /* compiled from: Taobao */
    private static class C0251a {
        private static a a = new a((byte) 0);
    }

    /* synthetic */ a(byte b2) {
        this();
    }

    public static a a() {
        return C0251a.a;
    }

    public final ArrayList<String> b() {
        return new ArrayList<>(this.b);
    }

    public final boolean c() {
        ArrayList<String> arrayList = this.b;
        return (arrayList == null || arrayList.size() == 0) ? false : true;
    }

    private a() {
        this.b = null;
        this.b = new ArrayList<>();
    }
}
