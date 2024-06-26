package com.xiaomi.push;

import android.os.Build;
import com.alibaba.poplayerconsole.lib.StandOutWindow;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.dx;
import com.xiaomi.push.service.bp;
import com.xiaomi.push.service.bv;
import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.Locale;
import java.util.TimeZone;
import java.util.zip.Adler32;

/* compiled from: Taobao */
public class fo {
    private int a;

    /* renamed from: a  reason: collision with other field name */
    private fs f375a;

    /* renamed from: a  reason: collision with other field name */
    private OutputStream f376a;

    /* renamed from: a  reason: collision with other field name */
    ByteBuffer f377a = ByteBuffer.allocate(2048);

    /* renamed from: a  reason: collision with other field name */
    private Adler32 f378a = new Adler32();

    /* renamed from: a  reason: collision with other field name */
    private byte[] f379a;
    private int b;

    /* renamed from: b  reason: collision with other field name */
    private ByteBuffer f380b = ByteBuffer.allocate(4);

    fo(OutputStream outputStream, fs fsVar) {
        this.f376a = new BufferedOutputStream(outputStream);
        this.f375a = fsVar;
        TimeZone timeZone = TimeZone.getDefault();
        this.a = timeZone.getRawOffset() / 3600000;
        this.b = timeZone.useDaylightTime() ? 1 : 0;
    }

    public int a(fl flVar) {
        int c = flVar.c();
        if (c > 32768) {
            b.m182a("Blob size=" + c + " should be less than " + 32768 + " Drop blob chid=" + flVar.a() + " id=" + flVar.e());
            return 0;
        }
        this.f377a.clear();
        int i = c + 8 + 4;
        if (i > this.f377a.capacity() || this.f377a.capacity() > 4096) {
            this.f377a = ByteBuffer.allocate(i);
        }
        this.f377a.putShort(-15618);
        this.f377a.putShort(5);
        this.f377a.putInt(c);
        int position = this.f377a.position();
        this.f377a = flVar.m482a(this.f377a);
        if (!"CONN".equals(flVar.m481a())) {
            if (this.f379a == null) {
                this.f379a = this.f375a.m494a();
            }
            bp.a(this.f379a, this.f377a.array(), true, position, c);
        }
        this.f378a.reset();
        this.f378a.update(this.f377a.array(), 0, this.f377a.position());
        this.f380b.putInt(0, (int) this.f378a.getValue());
        this.f376a.write(this.f377a.array(), 0, this.f377a.position());
        this.f376a.write(this.f380b.array(), 0, 4);
        this.f376a.flush();
        int position2 = this.f377a.position() + 4;
        b.c("[Slim] Wrote {cmd=" + flVar.m481a() + ";chid=" + flVar.a() + ";len=" + position2 + "}");
        return position2;
    }

    public void a() {
        dx.e eVar = new dx.e();
        eVar.a(106);
        String model = Build.getMODEL();
        eVar.a(model);
        eVar.b(v.m880a());
        eVar.c(bv.m837a());
        eVar.b(48);
        eVar.d(this.f375a.m502b());
        eVar.e(this.f375a.a());
        eVar.f(Locale.getDefault().toString());
        int i = Build.VERSION.SDK_INT;
        eVar.c(i);
        byte[] a2 = this.f375a.m498a().m508a();
        if (a2 != null) {
            eVar.a(dx.b.a(a2));
        }
        fl flVar = new fl();
        flVar.a(0);
        flVar.a("CONN", (String) null);
        flVar.a(0, "xiaomi.com", null);
        flVar.a(eVar.m437a(), (String) null);
        a(flVar);
        b.m182a("[slim] open conn: andver=" + i + " sdk=" + 48 + " tz=" + this.a + ":" + this.b + " Model=" + model + " os=" + Build.VERSION.INCREMENTAL);
    }

    public void b() {
        fl flVar = new fl();
        flVar.a(StandOutWindow.ACTION_CLOSE, (String) null);
        a(flVar);
        this.f376a.close();
    }
}
