package com.xiaomi.push;

import java.net.InetSocketAddress;

/* compiled from: Taobao */
public final class ct {
    private int a;

    /* renamed from: a  reason: collision with other field name */
    private String f177a;

    public ct(String str, int i) {
        this.f177a = str;
        this.a = i;
    }

    public static ct a(String str, int i) {
        int lastIndexOf = str.lastIndexOf(":");
        if (lastIndexOf != -1) {
            String substring = str.substring(0, lastIndexOf);
            try {
                int parseInt = Integer.parseInt(str.substring(lastIndexOf + 1));
                if (parseInt > 0) {
                    i = parseInt;
                }
            } catch (NumberFormatException unused) {
            }
            str = substring;
        }
        return new ct(str, i);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static InetSocketAddress m336a(String str, int i) {
        ct a2 = a(str, i);
        return new InetSocketAddress(a2.m337a(), a2.a());
    }

    public int a() {
        return this.a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m337a() {
        return this.f177a;
    }

    public String toString() {
        if (this.a <= 0) {
            return this.f177a;
        }
        return this.f177a + ":" + this.a;
    }
}
