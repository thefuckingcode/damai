package com.xiaomi.push;

import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.dx;
import com.xiaomi.push.service.ao;
import com.xiaomi.push.service.bd;
import com.xiaomi.push.service.bp;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import tb.o70;

/* compiled from: Taobao */
public class fl {
    private static long a = 0;

    /* renamed from: a  reason: collision with other field name */
    private static final byte[] f361a = new byte[0];
    private static String b = (gy.a(5) + "-");

    /* renamed from: a  reason: collision with other field name */
    int f362a;

    /* renamed from: a  reason: collision with other field name */
    private dx.a f363a;

    /* renamed from: a  reason: collision with other field name */
    public ao f364a;

    /* renamed from: a  reason: collision with other field name */
    String f365a;

    /* renamed from: a  reason: collision with other field name */
    private short f366a;

    /* renamed from: b  reason: collision with other field name */
    private byte[] f367b;

    public fl() {
        this.f366a = 2;
        this.f367b = f361a;
        this.f365a = null;
        this.f364a = null;
        this.f363a = new dx.a();
        this.f362a = 1;
    }

    fl(dx.a aVar, short s, byte[] bArr) {
        this.f366a = 2;
        this.f367b = f361a;
        this.f365a = null;
        this.f364a = null;
        this.f363a = aVar;
        this.f366a = s;
        this.f367b = bArr;
        this.f362a = 2;
    }

    @Deprecated
    public static fl a(gn gnVar, String str) {
        int i;
        fl flVar = new fl();
        try {
            i = Integer.parseInt(gnVar.k());
        } catch (Exception e) {
            b.m182a("Blob parse chid err " + e.getMessage());
            i = 1;
        }
        flVar.a(i);
        flVar.a(gnVar.j());
        flVar.c(gnVar.m());
        flVar.b(gnVar.n());
        flVar.a("XMLMSG", (String) null);
        try {
            flVar.a(gnVar.m523a().getBytes("utf8"), str);
            if (TextUtils.isEmpty(str)) {
                flVar.a((short) 3);
            } else {
                flVar.a((short) 2);
                flVar.a("SECMSG", (String) null);
            }
        } catch (UnsupportedEncodingException e2) {
            b.m182a("Blob setPayload err： " + e2.getMessage());
        }
        return flVar;
    }

    static fl a(ByteBuffer byteBuffer) {
        try {
            ByteBuffer slice = byteBuffer.slice();
            short s = slice.getShort(0);
            short s2 = slice.getShort(2);
            int i = slice.getInt(4);
            dx.a aVar = new dx.a();
            aVar.a(slice.array(), slice.arrayOffset() + 8, (int) s2);
            byte[] bArr = new byte[i];
            slice.position(s2 + 8);
            slice.get(bArr, 0, i);
            return new fl(aVar, s, bArr);
        } catch (Exception e) {
            b.m182a("read Blob err :" + e.getMessage());
            throw new IOException("Malformed Input");
        }
    }

    public static synchronized String d() {
        String sb;
        synchronized (fl.class) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(b);
            long j = a;
            a = 1 + j;
            sb2.append(Long.toString(j));
            sb = sb2.toString();
        }
        return sb;
    }

    public int a() {
        return this.f363a.c();
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m481a() {
        return this.f363a.m372c();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a  reason: collision with other method in class */
    public ByteBuffer m482a(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            byteBuffer = ByteBuffer.allocate(c());
        }
        byteBuffer.putShort(this.f366a);
        byteBuffer.putShort((short) this.f363a.a());
        byteBuffer.putInt(this.f367b.length);
        int position = byteBuffer.position();
        this.f363a.m436a(byteBuffer.array(), byteBuffer.arrayOffset() + position, this.f363a.a());
        byteBuffer.position(position + this.f363a.a());
        byteBuffer.put(this.f367b);
        return byteBuffer;
    }

    /* renamed from: a  reason: collision with other method in class */
    public short m483a() {
        return this.f366a;
    }

    public void a(int i) {
        this.f363a.a(i);
    }

    public void a(long j, String str, String str2) {
        if (j != 0) {
            this.f363a.a(j);
        }
        if (!TextUtils.isEmpty(str)) {
            this.f363a.a(str);
        }
        if (!TextUtils.isEmpty(str2)) {
            this.f363a.b(str2);
        }
    }

    public void a(String str) {
        this.f363a.e(str);
    }

    public void a(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            this.f363a.c(str);
            this.f363a.m367a();
            if (!TextUtils.isEmpty(str2)) {
                this.f363a.d(str2);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("command should not be empty");
    }

    public void a(short s) {
        this.f366a = s;
    }

    public void a(byte[] bArr, String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f363a.c(1);
            this.f367b = bp.a(bp.a(str, e()), bArr);
            return;
        }
        this.f363a.c(0);
        this.f367b = bArr;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m484a() {
        return this.f363a.j();
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m485a() {
        return fm.a(this, this.f367b);
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m486a(String str) {
        if (this.f363a.e() == 1) {
            return fm.a(this, bp.a(bp.a(str, e()), this.f367b));
        }
        if (this.f363a.e() == 0) {
            return fm.a(this, this.f367b);
        }
        b.m182a("unknow cipher = " + this.f363a.e());
        return fm.a(this, this.f367b);
    }

    public int b() {
        return this.f363a.f();
    }

    /* renamed from: b  reason: collision with other method in class */
    public String m487b() {
        return this.f363a.m374d();
    }

    public void b(int i) {
        ao aoVar = new ao();
        this.f364a = aoVar;
        aoVar.a = i;
    }

    public void b(String str) {
        this.f365a = str;
    }

    public int c() {
        return this.f363a.b() + 8 + this.f367b.length;
    }

    /* renamed from: c  reason: collision with other method in class */
    public String m488c() {
        return this.f363a.m378f();
    }

    public void c(String str) {
        if (!TextUtils.isEmpty(str)) {
            int indexOf = str.indexOf(o70.DINAMIC_PREFIX_AT);
            try {
                long parseLong = Long.parseLong(str.substring(0, indexOf));
                int indexOf2 = str.indexOf("/", indexOf);
                String substring = str.substring(indexOf + 1, indexOf2);
                String substring2 = str.substring(indexOf2 + 1);
                this.f363a.a(parseLong);
                this.f363a.a(substring);
                this.f363a.b(substring2);
            } catch (Exception e) {
                b.m182a("Blob parse user err " + e.getMessage());
            }
        }
    }

    public String e() {
        String e = this.f363a.m376e();
        if ("ID_NOT_AVAILABLE".equals(e)) {
            return null;
        }
        if (this.f363a.g()) {
            return e;
        }
        String d = d();
        this.f363a.e(d);
        return d;
    }

    public String f() {
        return this.f365a;
    }

    public String g() {
        if (!this.f363a.m371b()) {
            return null;
        }
        return Long.toString(this.f363a.m366a()) + o70.DINAMIC_PREFIX_AT + this.f363a.m368a() + "/" + this.f363a.m370b();
    }

    public String toString() {
        return "Blob [chid=" + a() + "; Id=" + bd.a(e()) + "; cmd=" + m481a() + "; type=" + ((int) m483a()) + "; from=" + g() + " ]";
    }
}
