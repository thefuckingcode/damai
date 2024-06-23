package com.alipay.sdk.m.h;

import com.alipay.sdk.m.g.c;

/* compiled from: Taobao */
public class a extends com.alipay.sdk.m.g.a {
    public static final /* synthetic */ boolean d = true;

    public a(byte[] bArr) {
        super(bArr);
    }

    public static a a(String str, long j, b bVar, short s, e eVar) throws Exception {
        byte[] a = c.a((byte) 1);
        boolean z = d;
        if (z || a.length == 1) {
            byte[] a2 = c.a(str.charAt(0), str.charAt(1));
            if (z || a2.length == 2) {
                byte[] a3 = c.a(j);
                if (z || a3.length == 8) {
                    byte[] b = c.b();
                    if (z || b.length == 2) {
                        bVar.a();
                        byte[] a4 = c.a(bVar.a);
                        if (z || a4.length == 1) {
                            byte[] a5 = c.a(bVar.b);
                            if (z || a5.length == 1) {
                                byte[] bArr = (byte[]) bVar.c.clone();
                                if (z || bArr.length == (bVar.b & 255)) {
                                    byte[] a6 = c.a(s);
                                    if (z || a6.length == 2) {
                                        byte[] b2 = c.b();
                                        if (z || b2.length == 2) {
                                            eVar.a();
                                            byte[] a7 = c.a(eVar.a);
                                            if (z || a7.length == 1) {
                                                byte[] bArr2 = (byte[]) eVar.b.clone();
                                                if (z || bArr2.length == (eVar.a & 255)) {
                                                    byte[] c = c.c();
                                                    if (z || c.length == 4) {
                                                        return new a(c.a(a, a2, a3, b, a4, a5, bArr, a6, b2, a7, bArr2, c));
                                                    }
                                                    throw new AssertionError();
                                                }
                                                throw new AssertionError();
                                            }
                                            throw new AssertionError();
                                        }
                                        throw new AssertionError();
                                    }
                                    throw new AssertionError();
                                }
                                throw new AssertionError();
                            }
                            throw new AssertionError();
                        }
                        throw new AssertionError();
                    }
                    throw new AssertionError();
                }
                throw new AssertionError();
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static a c() {
        try {
            return a(com.alipay.sdk.m.g.a.c, 0, new c(""), 0, new f());
        } catch (Exception unused) {
            return null;
        }
    }
}
