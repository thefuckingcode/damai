package com.xiaomi.push;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.huawei.hms.support.api.entity.core.JosStatusCodes;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.o;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.commons.lang3.StringUtils;

/* compiled from: Taobao */
public abstract class gd extends fw {
    protected Exception a = null;

    /* renamed from: a  reason: collision with other field name */
    protected Socket f415a;
    protected XMPushService b;
    private int c;

    /* renamed from: c  reason: collision with other field name */
    String f416c = null;
    private String d;
    protected volatile long e = 0;
    protected volatile long f = 0;
    protected volatile long g = 0;
    private long h = 0;

    public gd(XMPushService xMPushService, fx fxVar) {
        super(xMPushService, fxVar);
        this.b = xMPushService;
    }

    private void a(fx fxVar) {
        a(fxVar.c(), fxVar.m506a());
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x0193  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0195  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x01b0  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x01d2  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0222  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0224  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x023d  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0255  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x02ac  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x02ae  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x02c7  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x02dc  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x02e9  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x02ec  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0305  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x033d  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0262 A[EDGE_INSN: B:92:0x0262->B:60:0x0262 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0262 A[EDGE_INSN: B:94:0x0262->B:60:0x0262 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0266 A[SYNTHETIC] */
    private void a(String str, int i) {
        StringBuilder sb;
        long j;
        int i2;
        String str2;
        boolean z;
        String next;
        int i3;
        cr crVar;
        String str3;
        String str4;
        Throwable th;
        String str5;
        String str6;
        Iterator<String> it;
        String str7;
        Exception e2;
        String str8;
        Throwable th2;
        this.a = null;
        ArrayList<String> arrayList = new ArrayList<>();
        int intValue = b.a("get bucket for host : " + str).intValue();
        cr a2 = a(str);
        b.a(Integer.valueOf(intValue));
        if (a2 != null) {
            arrayList = a2.a(true);
        }
        cr d2 = cv.a().d(str);
        if (d2 != null) {
            Iterator<String> it2 = d2.a(true).iterator();
            while (it2.hasNext()) {
                String next2 = it2.next();
                if (arrayList.indexOf(next2) == -1) {
                    arrayList.add(next2);
                }
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.add(str);
        }
        long j2 = 0;
        this.g = 0;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        String a3 = bj.m282a((Context) this.b);
        StringBuilder sb2 = new StringBuilder();
        Iterator<String> it3 = arrayList.iterator();
        String str9 = "";
        int i4 = 0;
        while (true) {
            if (!it3.hasNext()) {
                sb = sb2;
                j = j2;
                i2 = i4;
                str2 = str9;
                break;
            }
            next = it3.next();
            long currentTimeMillis = System.currentTimeMillis();
            ((fw) this).f396a++;
            i3 = i4 + 1;
            try {
                b.m182a("begin to connect to " + next);
                this.f415a = m511a();
                this.f415a.connect(ct.m336a(next, i), JosStatusCodes.RTN_CODE_COMMON_ERROR);
                b.m182a("tcp connected");
                this.f415a.setTcpNoDelay(true);
                this.d = next;
                m512a();
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                ((fw) this).f397a = currentTimeMillis2;
                ((fw) this).f406b = a3;
                if (a2 == null) {
                    sb = sb2;
                    j = 0;
                    break;
                }
                it = it3;
                sb = sb2;
                str8 = a3;
                j = 0;
                crVar = a2;
                try {
                    a2.b(next, currentTimeMillis2, 0);
                    break;
                } catch (Exception e3) {
                    e2 = e3;
                    str4 = str9;
                    str3 = str8;
                    try {
                        this.a = e2;
                        b.d("SMACK: Could not connect to:" + next);
                        sb.append("SMACK: Could not connect to ");
                        sb.append(next);
                        sb.append(" port:");
                        sb.append(i);
                        sb.append(" err:");
                        sb.append(this.a.getClass().getSimpleName());
                        sb.append(StringUtils.LF);
                        if (!TextUtils.isEmpty(str4)) {
                        }
                        fj.a(next, this.a);
                        if (crVar == null) {
                        }
                        if (TextUtils.equals(str7, bj.m282a((Context) this.b))) {
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        b.d("SMACK: Could not connect to:" + next);
                        sb.append("SMACK: Could not connect to ");
                        sb.append(next);
                        sb.append(" port:");
                        sb.append(i);
                        sb.append(" err:");
                        sb.append(this.a.getClass().getSimpleName());
                        sb.append(StringUtils.LF);
                        if (!TextUtils.isEmpty(str4)) {
                            str5 = next;
                        } else {
                            str5 = str4 + "|" + next;
                        }
                        fj.a(next, this.a);
                        if (crVar == null) {
                            str6 = str3;
                            crVar.b(next, System.currentTimeMillis() - currentTimeMillis, 0, this.a);
                        } else {
                            str6 = str3;
                        }
                        if (TextUtils.equals(str6, bj.m282a((Context) this.b))) {
                            str2 = str5;
                            i2 = i3;
                            z = false;
                            cv.a().m346c();
                            int elapsedRealtime2 = (int) (SystemClock.elapsedRealtime() - elapsedRealtime);
                            if (!z) {
                            }
                        } else {
                            throw th;
                        }
                    }
                } catch (Throwable th4) {
                    th2 = th4;
                    try {
                        this.a = new Exception("abnormal exception", th2);
                        b.a(th2);
                        b.d("SMACK: Could not connect to:" + next);
                        sb.append("SMACK: Could not connect to ");
                        sb.append(next);
                        sb.append(" port:");
                        sb.append(i);
                        sb.append(" err:");
                        sb.append(this.a.getClass().getSimpleName());
                        sb.append(StringUtils.LF);
                        if (!TextUtils.isEmpty(str9)) {
                        }
                        fj.a(next, this.a);
                        if (crVar != null) {
                        }
                        if (TextUtils.equals(str8, bj.m282a((Context) this.b))) {
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        str4 = str9;
                        str3 = str8;
                        b.d("SMACK: Could not connect to:" + next);
                        sb.append("SMACK: Could not connect to ");
                        sb.append(next);
                        sb.append(" port:");
                        sb.append(i);
                        sb.append(" err:");
                        sb.append(this.a.getClass().getSimpleName());
                        sb.append(StringUtils.LF);
                        if (!TextUtils.isEmpty(str4)) {
                        }
                        fj.a(next, this.a);
                        if (crVar == null) {
                        }
                        if (TextUtils.equals(str6, bj.m282a((Context) this.b))) {
                        }
                    }
                }
            } catch (Exception e4) {
                e2 = e4;
                it = it3;
                sb = sb2;
                crVar = a2;
                j = 0;
                str4 = str9;
                str3 = a3;
                this.a = e2;
                b.d("SMACK: Could not connect to:" + next);
                sb.append("SMACK: Could not connect to ");
                sb.append(next);
                sb.append(" port:");
                sb.append(i);
                sb.append(" err:");
                sb.append(this.a.getClass().getSimpleName());
                sb.append(StringUtils.LF);
                if (!TextUtils.isEmpty(str4)) {
                    str2 = next;
                } else {
                    str2 = str4 + "|" + next;
                }
                fj.a(next, this.a);
                if (crVar == null) {
                    str7 = str3;
                    crVar.b(next, System.currentTimeMillis() - currentTimeMillis, 0, this.a);
                } else {
                    str7 = str3;
                }
                if (TextUtils.equals(str7, bj.m282a((Context) this.b))) {
                    i2 = i3;
                    z = false;
                    cv.a().m346c();
                    int elapsedRealtime22 = (int) (SystemClock.elapsedRealtime() - elapsedRealtime);
                    if (!z) {
                    }
                } else {
                    str9 = str2;
                    sb2 = sb;
                    a3 = str7;
                    i4 = i3;
                    it3 = it;
                    j2 = j;
                    a2 = crVar;
                }
            } catch (Throwable th6) {
                th2 = th6;
                it = it3;
                sb = sb2;
                str8 = a3;
                crVar = a2;
                j = 0;
                this.a = new Exception("abnormal exception", th2);
                b.a(th2);
                b.d("SMACK: Could not connect to:" + next);
                sb.append("SMACK: Could not connect to ");
                sb.append(next);
                sb.append(" port:");
                sb.append(i);
                sb.append(" err:");
                sb.append(this.a.getClass().getSimpleName());
                sb.append(StringUtils.LF);
                if (!TextUtils.isEmpty(str9)) {
                    str2 = next;
                } else {
                    str2 = str9 + "|" + next;
                }
                fj.a(next, this.a);
                if (crVar != null) {
                    crVar.b(next, System.currentTimeMillis() - currentTimeMillis, 0, this.a);
                }
                if (TextUtils.equals(str8, bj.m282a((Context) this.b))) {
                    i2 = i3;
                    z = false;
                    cv.a().m346c();
                    int elapsedRealtime222 = (int) (SystemClock.elapsedRealtime() - elapsedRealtime);
                    if (!z) {
                    }
                } else {
                    str7 = str8;
                    str9 = str2;
                    sb2 = sb;
                    a3 = str7;
                    i4 = i3;
                    it3 = it;
                    j2 = j;
                    a2 = crVar;
                }
            }
            cv.a().m346c();
            int elapsedRealtime2222 = (int) (SystemClock.elapsedRealtime() - elapsedRealtime);
            if (!z) {
                if (this.h == j || SystemClock.elapsedRealtime() - this.h > 480000) {
                    this.h = SystemClock.elapsedRealtime();
                    fj.a(0, ez.BATCH_TCP_CONN_FAIL.a(), elapsedRealtime2222, str2, bj.c(this.b.getApplicationContext()) ? 1 : 0);
                }
                throw new gh(sb.toString());
            }
            fj.a(0, ez.BATCH_TCP_CONN_SUCCESS.a(), elapsedRealtime2222, str2, i2);
            return;
            str9 = str2;
            sb2 = sb;
            a3 = str7;
            i4 = i3;
            it3 = it;
            j2 = j;
            a2 = crVar;
        }
        this.g = SystemClock.elapsedRealtime();
        b.m182a("connected to " + next + " in " + ((fw) this).f397a);
        str2 = str9;
        i2 = i3;
        z = true;
        cv.a().m346c();
        int elapsedRealtime22222 = (int) (SystemClock.elapsedRealtime() - elapsedRealtime);
        if (!z) {
        }
    }

    /* access modifiers changed from: package-private */
    @Override // com.xiaomi.push.fw
    public cr a(String str) {
        cr a2 = cv.a().a(str, false);
        if (!a2.b()) {
            gz.a(new gg(this, str));
        }
        return a2;
    }

    @Override // com.xiaomi.push.fw, com.xiaomi.push.fw, com.xiaomi.push.fw, com.xiaomi.push.fw, com.xiaomi.push.fw, com.xiaomi.push.fw
    public String a() {
        return this.d;
    }

    @Override // com.xiaomi.push.fw, com.xiaomi.push.fw, com.xiaomi.push.fw, com.xiaomi.push.fw, com.xiaomi.push.fw, com.xiaomi.push.fw
    /* renamed from: a  reason: collision with other method in class */
    public Socket m511a() {
        return new Socket();
    }

    /* access modifiers changed from: protected */
    @Override // com.xiaomi.push.fw, com.xiaomi.push.fw, com.xiaomi.push.fw, com.xiaomi.push.fw, com.xiaomi.push.fw, com.xiaomi.push.fw
    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m512a() {
    }

    /* access modifiers changed from: protected */
    public synchronized void a(int i, Exception exc) {
        if (b() != 2) {
            a(2, i, exc);
            ((fw) this).f401a = "";
            try {
                this.f415a.close();
            } catch (Throwable unused) {
            }
            this.e = 0;
            this.f = 0;
        }
    }

    /* access modifiers changed from: protected */
    public void a(Exception exc) {
        if (SystemClock.elapsedRealtime() - this.g < 300000) {
            if (bj.b(this.b)) {
                int i = this.c + 1;
                this.c = i;
                if (i >= 2) {
                    String a2 = a();
                    b.m182a("max short conn time reached, sink down current host:" + a2);
                    a(a2, 0, exc);
                } else {
                    return;
                }
            } else {
                return;
            }
        }
        this.c = 0;
    }

    /* access modifiers changed from: protected */
    public void a(String str, long j, Exception exc) {
        cr a2 = cv.a().a(fx.a(), false);
        if (a2 != null) {
            a2.b(str, j, 0, exc);
            cv.a().m346c();
        }
    }

    /* access modifiers changed from: protected */
    public abstract void a(boolean z);

    @Override // com.xiaomi.push.fw
    public void a(fl[] flVarArr) {
        throw new gh("Don't support send Blob");
    }

    @Override // com.xiaomi.push.fw
    public void b(int i, Exception exc) {
        a(i, exc);
        if ((exc != null || i == 18) && this.g != 0) {
            a(exc);
        }
    }

    @Override // com.xiaomi.push.fw
    public void b(boolean z) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long currentTimeMillis = System.currentTimeMillis();
        a(z);
        o.a(this.b).m857c();
        if (!z) {
            this.b.a(new ge(this, 13, elapsedRealtime, currentTimeMillis), 10000);
        }
    }

    @Override // com.xiaomi.push.fw, com.xiaomi.push.fw
    public String c() {
        return ((fw) this).f401a;
    }

    public void c(int i, Exception exc) {
        this.b.a(new gf(this, 2, i, exc));
    }

    public synchronized void e() {
        try {
            if (!m505c()) {
                if (!m504b()) {
                    a(0, 0, (Exception) null);
                    a(((fw) this).f398a);
                    return;
                }
            }
            b.m182a("WARNING: current xmpp has connected");
        } catch (IOException e2) {
            throw new gh(e2);
        }
    }

    public void f() {
        this.e = SystemClock.elapsedRealtime();
    }

    public void g() {
        this.f = SystemClock.elapsedRealtime();
    }
}
