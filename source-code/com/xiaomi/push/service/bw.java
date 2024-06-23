package com.xiaomi.push.service;

import android.text.TextUtils;
import android.util.Base64;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.ao;
import com.xiaomi.push.bi;
import com.xiaomi.push.cz;
import com.xiaomi.push.dw;
import com.xiaomi.push.q;
import com.xiaomi.push.service.bv;
import com.xiaomi.push.v;
import java.util.List;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class bw extends ao.b {
    final /* synthetic */ bv a;

    /* renamed from: a  reason: collision with other field name */
    boolean f946a = false;

    bw(bv bvVar) {
        this.a = bvVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0039 A[Catch:{ Exception -> 0x0047 }] */
    /* JADX WARNING: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    @Override // com.xiaomi.push.ao.b
    public void b() {
        String str;
        dw.a a2;
        try {
            String a3 = a.a(v.m879a()).a();
            if (!TextUtils.isEmpty(a3)) {
                if (!q.China.name().equals(a3)) {
                    str = "https://resolver.msg.global.xiaomi.net/psc/?t=a";
                    a2 = dw.a.a(Base64.decode(cz.a(v.m879a(), str, (List<bi>) null), 10));
                    if (a2 == null) {
                        this.a.f944a = a2;
                        this.f946a = true;
                        bv.a(this.a);
                        return;
                    }
                    return;
                }
            }
            str = "https://resolver.msg.xiaomi.net/psc/?t=a";
            a2 = dw.a.a(Base64.decode(cz.a(v.m879a(), str, (List<bi>) null), 10));
            if (a2 == null) {
            }
        } catch (Exception e) {
            b.m182a("fetch config failure: " + e.getMessage());
        }
    }

    @Override // com.xiaomi.push.ao.b
    public void c() {
        bv.a[] aVarArr;
        this.a.f943a = null;
        if (this.f946a) {
            synchronized (this.a) {
                aVarArr = (bv.a[]) bv.a(this.a).toArray(new bv.a[bv.a(this.a).size()]);
            }
            for (bv.a aVar : aVarArr) {
                aVar.a(bv.a(this.a));
            }
        }
    }
}
