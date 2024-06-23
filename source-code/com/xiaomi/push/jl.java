package com.xiaomi.push;

import com.xiaomi.push.jb;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* compiled from: Taobao */
public class jl extends jb {
    private static int b = 10000;
    private static int c = 10000;
    private static int d = 10000;
    private static int e = 10485760;
    private static int f = 104857600;

    /* compiled from: Taobao */
    public static class a extends jb.a {
        public a() {
            super(false, true);
        }

        public a(boolean z, boolean z2, int i) {
            super(z, z2, i);
        }

        @Override // com.xiaomi.push.jh, com.xiaomi.push.jb.a
        public jf a(jp jpVar) {
            jl jlVar = new jl(jpVar, ((jb.a) this).f799a, this.b);
            int i = ((jb.a) this).a;
            if (i != 0) {
                jlVar.b(i);
            }
            return jlVar;
        }
    }

    public jl(jp jpVar, boolean z, boolean z2) {
        super(jpVar, z, z2);
    }

    @Override // com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jb, com.xiaomi.push.jb, com.xiaomi.push.jb, com.xiaomi.push.jb, com.xiaomi.push.jb, com.xiaomi.push.jb, com.xiaomi.push.jb, com.xiaomi.push.jb, com.xiaomi.push.jb, com.xiaomi.push.jb, com.xiaomi.push.jb, com.xiaomi.push.jb, com.xiaomi.push.jb, com.xiaomi.push.jb
    public jd a() {
        byte a2 = a();
        int a3 = m695a();
        if (a3 <= c) {
            return new jd(a2, a3);
        }
        throw new jg(3, "Thrift list size " + a3 + " out of range!");
    }

    @Override // com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jb, com.xiaomi.push.jb, com.xiaomi.push.jb, com.xiaomi.push.jb, com.xiaomi.push.jb, com.xiaomi.push.jb, com.xiaomi.push.jb, com.xiaomi.push.jb, com.xiaomi.push.jb, com.xiaomi.push.jb, com.xiaomi.push.jb, com.xiaomi.push.jb, com.xiaomi.push.jb, com.xiaomi.push.jb
    /* renamed from: a  reason: collision with other method in class */
    public je m721a() {
        byte a2 = a();
        byte a3 = a();
        int a4 = m695a();
        if (a4 <= b) {
            return new je(a2, a3, a4);
        }
        throw new jg(3, "Thrift map size " + a4 + " out of range!");
    }

    @Override // com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jb, com.xiaomi.push.jb, com.xiaomi.push.jb, com.xiaomi.push.jb, com.xiaomi.push.jb, com.xiaomi.push.jb, com.xiaomi.push.jb, com.xiaomi.push.jb, com.xiaomi.push.jb, com.xiaomi.push.jb, com.xiaomi.push.jb, com.xiaomi.push.jb, com.xiaomi.push.jb, com.xiaomi.push.jb
    /* renamed from: a  reason: collision with other method in class */
    public jj m722a() {
        byte a2 = a();
        int a3 = m695a();
        if (a3 <= d) {
            return new jj(a2, a3);
        }
        throw new jg(3, "Thrift set size " + a3 + " out of range!");
    }

    @Override // com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jb, com.xiaomi.push.jb, com.xiaomi.push.jb, com.xiaomi.push.jb, com.xiaomi.push.jb, com.xiaomi.push.jb, com.xiaomi.push.jb, com.xiaomi.push.jb, com.xiaomi.push.jb, com.xiaomi.push.jb, com.xiaomi.push.jb, com.xiaomi.push.jb, com.xiaomi.push.jb, com.xiaomi.push.jb
    /* renamed from: a  reason: collision with other method in class */
    public String m723a() {
        int a2 = m695a();
        if (a2 > e) {
            throw new jg(3, "Thrift string size " + a2 + " out of range!");
        } else if (((jf) this).a.b() < a2) {
            return a(a2);
        } else {
            try {
                String str = new String(((jf) this).a.m730a(), ((jf) this).a.a(), a2, "UTF-8");
                ((jf) this).a.a(a2);
                return str;
            } catch (UnsupportedEncodingException unused) {
                throw new iz("JVM DOES NOT SUPPORT UTF-8");
            }
        }
    }

    @Override // com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jb, com.xiaomi.push.jb, com.xiaomi.push.jb, com.xiaomi.push.jb, com.xiaomi.push.jb, com.xiaomi.push.jb, com.xiaomi.push.jb, com.xiaomi.push.jb, com.xiaomi.push.jb, com.xiaomi.push.jb, com.xiaomi.push.jb, com.xiaomi.push.jb, com.xiaomi.push.jb, com.xiaomi.push.jb
    /* renamed from: a  reason: collision with other method in class */
    public ByteBuffer m724a() {
        int a2 = m695a();
        if (a2 <= f) {
            c(a2);
            if (((jf) this).a.b() >= a2) {
                ByteBuffer wrap = ByteBuffer.wrap(((jf) this).a.m730a(), ((jf) this).a.a(), a2);
                ((jf) this).a.a(a2);
                return wrap;
            }
            byte[] bArr = new byte[a2];
            ((jf) this).a.b(bArr, 0, a2);
            return ByteBuffer.wrap(bArr);
        }
        throw new jg(3, "Thrift binary size " + a2 + " out of range!");
    }
}
