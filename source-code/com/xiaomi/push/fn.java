package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.dx;
import com.xiaomi.push.service.bg;
import com.xiaomi.push.service.bp;
import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.zip.Adler32;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class fn {
    private Context a;

    /* renamed from: a  reason: collision with other field name */
    private fq f368a;

    /* renamed from: a  reason: collision with other field name */
    private fs f369a;

    /* renamed from: a  reason: collision with other field name */
    private InputStream f370a;

    /* renamed from: a  reason: collision with other field name */
    private ByteBuffer f371a = ByteBuffer.allocate(2048);

    /* renamed from: a  reason: collision with other field name */
    private Adler32 f372a = new Adler32();

    /* renamed from: a  reason: collision with other field name */
    private volatile boolean f373a;

    /* renamed from: a  reason: collision with other field name */
    private byte[] f374a;
    private ByteBuffer b = ByteBuffer.allocate(4);

    fn(InputStream inputStream, fs fsVar, Context context) {
        this.f370a = new BufferedInputStream(inputStream);
        this.f369a = fsVar;
        this.f368a = new fq();
        this.a = context;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00cf  */
    private ByteBuffer a() {
        int i;
        ByteBuffer allocate;
        this.f371a.clear();
        a(this.f371a, 8);
        short s = this.f371a.getShort(0);
        short s2 = this.f371a.getShort(2);
        if (s == -15618 && s2 == 5) {
            int i2 = this.f371a.getInt(4);
            int position = this.f371a.position();
            if (i2 <= 32768) {
                if (i2 + 4 > this.f371a.remaining()) {
                    allocate = ByteBuffer.allocate(i2 + 2048);
                    allocate.put(this.f371a.array(), 0, this.f371a.arrayOffset() + this.f371a.position());
                } else {
                    if (this.f371a.capacity() > 4096 && i2 < 2048) {
                        allocate = ByteBuffer.allocate(2048);
                        allocate.put(this.f371a.array(), 0, this.f371a.arrayOffset() + this.f371a.position());
                    }
                    a(this.f371a, i2);
                    this.b.clear();
                    a(this.b, 4);
                    this.b.position(0);
                    i = this.b.getInt();
                    this.f372a.reset();
                    this.f372a.update(this.f371a.array(), 0, this.f371a.position());
                    if (i != ((int) this.f372a.getValue())) {
                        byte[] bArr = this.f374a;
                        if (bArr != null) {
                            bp.a(bArr, this.f371a.array(), true, position, i2);
                        }
                        return this.f371a;
                    }
                    b.m182a("CRC = " + ((int) this.f372a.getValue()) + " and " + i);
                    throw new IOException("Corrupted Blob bad CRC");
                }
                this.f371a = allocate;
                a(this.f371a, i2);
                this.b.clear();
                a(this.b, 4);
                this.b.position(0);
                i = this.b.getInt();
                this.f372a.reset();
                this.f372a.update(this.f371a.array(), 0, this.f371a.position());
                if (i != ((int) this.f372a.getValue())) {
                }
            } else {
                throw new IOException("Blob size too large");
            }
        } else {
            throw new IOException("Malformed Input");
        }
    }

    private void a(ByteBuffer byteBuffer, int i) {
        int position = byteBuffer.position();
        do {
            int read = this.f370a.read(byteBuffer.array(), position, i);
            if (read != -1) {
                i -= read;
                position += read;
            } else {
                throw new EOFException();
            }
        } while (i > 0);
        byteBuffer.position(position);
    }

    private void c() {
        fl a2;
        StringBuilder sb;
        String sb2;
        boolean z = false;
        this.f373a = false;
        fl a3 = m489a();
        if ("CONN".equals(a3.m481a())) {
            dx.f a4 = dx.f.a(a3.m485a());
            if (a4.m412a()) {
                this.f369a.a(a4.m411a());
                z = true;
            }
            if (a4.c()) {
                dx.b a5 = a4.m410a();
                fl flVar = new fl();
                flVar.a("SYNC", "CONF");
                flVar.a(a5.m437a(), (String) null);
                this.f369a.a(flVar);
            }
            b.m182a("[Slim] CONN: host = " + a4.m413b());
        }
        if (z) {
            this.f374a = this.f369a.m494a();
            while (!this.f373a) {
                a2 = m489a();
                this.f369a.c();
                short a6 = a2.m483a();
                if (a6 != 1) {
                    if (a6 != 2) {
                        if (a6 != 3) {
                            sb2 = "[Slim] unknow blob type " + ((int) a2.m483a());
                        } else {
                            try {
                                this.f369a.b(this.f368a.a(a2.m485a(), this.f369a));
                            } catch (Exception e) {
                                e = e;
                                sb = new StringBuilder();
                            }
                        }
                    } else if ("SECMSG".equals(a2.m481a()) && ((a2.a() == 2 || a2.a() == 3) && TextUtils.isEmpty(a2.m487b()))) {
                        try {
                            this.f369a.b(this.f368a.a(a2.m486a(bg.a().a(Integer.valueOf(a2.a()).toString(), a2.g()).h), this.f369a));
                        } catch (Exception e2) {
                            e = e2;
                            sb = new StringBuilder();
                        }
                    } else if (a2.a() == 10) {
                        a2.b(10);
                        a2.f364a.f893a = w.a(this.a);
                        a2.f364a.f895b = bj.e(this.a);
                        a2.f364a.f892a = System.currentTimeMillis();
                        b.c("rcv blob from chid 10");
                    }
                    b.m182a(sb2);
                }
                this.f369a.a(a2);
            }
            return;
        }
        b.m182a("[Slim] Invalid CONN");
        throw new IOException("Invalid Connection");
        sb.append("[Slim] Parse packet from Blob chid=");
        sb.append(a2.a());
        sb.append("; Id=");
        sb.append(a2.e());
        sb.append(" failure:");
        sb.append(e.getMessage());
        sb2 = sb.toString();
        b.m182a(sb2);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0074  */
    /* renamed from: a  reason: collision with other method in class */
    public fl m489a() {
        int i;
        IOException e;
        try {
            ByteBuffer a2 = a();
            i = a2.position();
            try {
                a2.flip();
                a2.position(8);
                fl frVar = i == 8 ? new fr() : fl.a(a2.slice());
                b.c("[Slim] Read {cmd=" + frVar.m481a() + ";chid=" + frVar.a() + ";len=" + i + "}");
                return frVar;
            } catch (IOException e2) {
                e = e2;
                if (i == 0) {
                }
                StringBuilder sb = new StringBuilder();
                sb.append("[Slim] read Blob [");
                byte[] array = this.f371a.array();
                if (i > 128) {
                }
                sb.append(ai.a(array, 0, i));
                sb.append("] Err:");
                sb.append(e.getMessage());
                b.m182a(sb.toString());
                throw e;
            }
        } catch (IOException e3) {
            e = e3;
            i = 0;
            if (i == 0) {
                i = this.f371a.position();
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("[Slim] read Blob [");
            byte[] array2 = this.f371a.array();
            if (i > 128) {
                i = 128;
            }
            sb2.append(ai.a(array2, 0, i));
            sb2.append("] Err:");
            sb2.append(e.getMessage());
            b.m182a(sb2.toString());
            throw e;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a  reason: collision with other method in class */
    public void m490a() {
        try {
            c();
        } catch (IOException e) {
            if (!this.f373a) {
                throw e;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void b() {
        this.f373a = true;
    }
}
