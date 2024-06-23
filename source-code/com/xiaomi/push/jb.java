package com.xiaomi.push;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* compiled from: Taobao */
public class jb extends jf {
    private static final jk a = new jk();

    /* renamed from: a  reason: collision with other field name */
    protected int f794a;

    /* renamed from: a  reason: collision with other field name */
    protected boolean f795a = false;

    /* renamed from: a  reason: collision with other field name */
    private byte[] f796a = new byte[1];
    protected boolean b = true;

    /* renamed from: b  reason: collision with other field name */
    private byte[] f797b = new byte[2];
    protected boolean c = false;

    /* renamed from: c  reason: collision with other field name */
    private byte[] f798c = new byte[4];
    private byte[] d = new byte[8];
    private byte[] e = new byte[1];
    private byte[] f = new byte[2];
    private byte[] g = new byte[4];
    private byte[] h = new byte[8];

    /* compiled from: Taobao */
    public static class a implements jh {
        protected int a;

        /* renamed from: a  reason: collision with other field name */
        protected boolean f799a;
        protected boolean b;

        public a() {
            this(false, true);
        }

        public a(boolean z, boolean z2) {
            this(z, z2, 0);
        }

        public a(boolean z, boolean z2, int i) {
            this.f799a = false;
            this.b = true;
            this.f799a = z;
            this.b = z2;
            this.a = i;
        }

        @Override // com.xiaomi.push.jh
        public jf a(jp jpVar) {
            jb jbVar = new jb(jpVar, this.f799a, this.b);
            int i = this.a;
            if (i != 0) {
                jbVar.b(i);
            }
            return jbVar;
        }
    }

    public jb(jp jpVar, boolean z, boolean z2) {
        super(jpVar);
        this.f795a = z;
        this.b = z2;
    }

    private int a(byte[] bArr, int i, int i2) {
        c(i2);
        return ((jf) this).a.b(bArr, i, i2);
    }

    @Override // com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf
    public byte a() {
        if (((jf) this).a.b() >= 1) {
            byte b2 = ((jf) this).a.m730a()[((jf) this).a.a()];
            ((jf) this).a.a(1);
            return b2;
        }
        a(this.e, 0, 1);
        return this.e[0];
    }

    @Override // com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf
    /* renamed from: a  reason: collision with other method in class */
    public double m694a() {
        return Double.longBitsToDouble(m696a());
    }

    @Override // com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf
    /* renamed from: a  reason: collision with other method in class */
    public int m695a() {
        byte[] bArr = this.g;
        int i = 0;
        if (((jf) this).a.b() >= 4) {
            bArr = ((jf) this).a.m730a();
            i = ((jf) this).a.a();
            ((jf) this).a.a(4);
        } else {
            a(this.g, 0, 4);
        }
        return (bArr[i + 3] & 255) | ((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8);
    }

    @Override // com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf
    /* renamed from: a  reason: collision with other method in class */
    public long m696a() {
        byte[] bArr = this.h;
        int i = 0;
        if (((jf) this).a.b() >= 8) {
            bArr = ((jf) this).a.m730a();
            i = ((jf) this).a.a();
            ((jf) this).a.a(8);
        } else {
            a(this.h, 0, 8);
        }
        return ((long) (bArr[i + 7] & 255)) | (((long) (bArr[i] & 255)) << 56) | (((long) (bArr[i + 1] & 255)) << 48) | (((long) (bArr[i + 2] & 255)) << 40) | (((long) (bArr[i + 3] & 255)) << 32) | (((long) (bArr[i + 4] & 255)) << 24) | (((long) (bArr[i + 5] & 255)) << 16) | (((long) (bArr[i + 6] & 255)) << 8);
    }

    @Override // com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf
    /* renamed from: a  reason: collision with other method in class */
    public jc m697a() {
        byte a2 = a();
        return new jc("", a2, a2 == 0 ? 0 : m704a());
    }

    @Override // com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf
    /* renamed from: a  reason: collision with other method in class */
    public jd m698a() {
        return new jd(a(), m695a());
    }

    @Override // com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf
    /* renamed from: a  reason: collision with other method in class */
    public je m699a() {
        return new je(a(), a(), m695a());
    }

    @Override // com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf
    /* renamed from: a  reason: collision with other method in class */
    public jj m700a() {
        return new jj(a(), m695a());
    }

    @Override // com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf
    /* renamed from: a  reason: collision with other method in class */
    public jk m701a() {
        return a;
    }

    @Override // com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf
    /* renamed from: a  reason: collision with other method in class */
    public String m702a() {
        int a2 = m695a();
        if (((jf) this).a.b() < a2) {
            return a(a2);
        }
        try {
            String str = new String(((jf) this).a.m730a(), ((jf) this).a.a(), a2, "UTF-8");
            ((jf) this).a.a(a2);
            return str;
        } catch (UnsupportedEncodingException unused) {
            throw new iz("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    @Override // com.xiaomi.push.jf
    public String a(int i) {
        try {
            c(i);
            byte[] bArr = new byte[i];
            ((jf) this).a.b(bArr, 0, i);
            return new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            throw new iz("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    @Override // com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf
    /* renamed from: a  reason: collision with other method in class */
    public ByteBuffer m703a() {
        int a2 = m695a();
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

    @Override // com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf
    /* renamed from: a  reason: collision with other method in class */
    public short m704a() {
        byte[] bArr = this.f;
        int i = 0;
        if (((jf) this).a.b() >= 2) {
            bArr = ((jf) this).a.m730a();
            i = ((jf) this).a.a();
            ((jf) this).a.a(2);
        } else {
            a(this.f, 0, 2);
        }
        return (short) ((bArr[i + 1] & 255) | ((bArr[i] & 255) << 8));
    }

    @Override // com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf
    /* renamed from: a  reason: collision with other method in class */
    public void m705a() {
    }

    @Override // com.xiaomi.push.jf
    public void a(byte b2) {
        byte[] bArr = this.f796a;
        bArr[0] = b2;
        ((jf) this).a.m729a(bArr, 0, 1);
    }

    @Override // com.xiaomi.push.jf
    /* renamed from: a  reason: collision with other method in class */
    public void m706a(int i) {
        byte[] bArr = this.f798c;
        bArr[0] = (byte) ((i >> 24) & 255);
        bArr[1] = (byte) ((i >> 16) & 255);
        bArr[2] = (byte) ((i >> 8) & 255);
        bArr[3] = (byte) (i & 255);
        ((jf) this).a.m729a(bArr, 0, 4);
    }

    @Override // com.xiaomi.push.jf
    public void a(long j) {
        byte[] bArr = this.d;
        bArr[0] = (byte) ((int) ((j >> 56) & 255));
        bArr[1] = (byte) ((int) ((j >> 48) & 255));
        bArr[2] = (byte) ((int) ((j >> 40) & 255));
        bArr[3] = (byte) ((int) ((j >> 32) & 255));
        bArr[4] = (byte) ((int) ((j >> 24) & 255));
        bArr[5] = (byte) ((int) ((j >> 16) & 255));
        bArr[6] = (byte) ((int) ((j >> 8) & 255));
        bArr[7] = (byte) ((int) (j & 255));
        ((jf) this).a.m729a(bArr, 0, 8);
    }

    @Override // com.xiaomi.push.jf
    public void a(jc jcVar) {
        a(jcVar.a);
        a(jcVar.f801a);
    }

    @Override // com.xiaomi.push.jf
    public void a(jd jdVar) {
        a(jdVar.a);
        m706a(jdVar.f802a);
    }

    @Override // com.xiaomi.push.jf
    public void a(je jeVar) {
        a(jeVar.a);
        a(jeVar.b);
        m706a(jeVar.f803a);
    }

    @Override // com.xiaomi.push.jf
    public void a(jk jkVar) {
    }

    @Override // com.xiaomi.push.jf
    public void a(String str) {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            m706a(bytes.length);
            ((jf) this).a.m729a(bytes, 0, bytes.length);
        } catch (UnsupportedEncodingException unused) {
            throw new iz("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    @Override // com.xiaomi.push.jf
    public void a(ByteBuffer byteBuffer) {
        int limit = (byteBuffer.limit() - byteBuffer.position()) - byteBuffer.arrayOffset();
        m706a(limit);
        ((jf) this).a.m729a(byteBuffer.array(), byteBuffer.position() + byteBuffer.arrayOffset(), limit);
    }

    @Override // com.xiaomi.push.jf
    public void a(short s) {
        byte[] bArr = this.f797b;
        bArr[0] = (byte) ((s >> 8) & 255);
        bArr[1] = (byte) (s & 255);
        ((jf) this).a.m729a(bArr, 0, 2);
    }

    @Override // com.xiaomi.push.jf
    public void a(boolean z) {
        a(z ? (byte) 1 : 0);
    }

    @Override // com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf, com.xiaomi.push.jf
    /* renamed from: a  reason: collision with other method in class */
    public boolean m707a() {
        return a() == 1;
    }

    @Override // com.xiaomi.push.jf
    public void b() {
    }

    public void b(int i) {
        this.f794a = i;
        this.c = true;
    }

    @Override // com.xiaomi.push.jf
    public void c() {
        a((byte) 0);
    }

    /* access modifiers changed from: protected */
    public void c(int i) {
        if (i < 0) {
            throw new iz("Negative length: " + i);
        } else if (this.c) {
            int i2 = this.f794a - i;
            this.f794a = i2;
            if (i2 < 0) {
                throw new iz("Message length exceeded: " + i);
            }
        }
    }

    @Override // com.xiaomi.push.jf
    public void d() {
    }

    @Override // com.xiaomi.push.jf
    public void e() {
    }

    @Override // com.xiaomi.push.jf
    public void f() {
    }

    @Override // com.xiaomi.push.jf
    public void g() {
    }

    @Override // com.xiaomi.push.jf
    public void h() {
    }

    @Override // com.xiaomi.push.jf
    public void i() {
    }

    @Override // com.xiaomi.push.jf
    public void j() {
    }
}
