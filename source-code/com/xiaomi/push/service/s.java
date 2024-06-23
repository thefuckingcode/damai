package com.xiaomi.push.service;

import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.Cif;
import com.xiaomi.push.hj;
import com.xiaomi.push.hw;
import com.xiaomi.push.ii;
import com.xiaomi.push.it;
import com.xiaomi.push.service.XMPushService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: Taobao */
class s extends XMPushService.j {
    final /* synthetic */ r a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f994a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ List f995a;
    final /* synthetic */ String b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    s(r rVar, int i, String str, List list, String str2) {
        super(i);
        this.a = rVar;
        this.f994a = str;
        this.f995a = list;
        this.b = str2;
    }

    @Override // com.xiaomi.push.service.XMPushService.j, com.xiaomi.push.service.XMPushService.j
    public String a() {
        return "Send tiny data.";
    }

    @Override // com.xiaomi.push.service.XMPushService.j, com.xiaomi.push.service.XMPushService.j
    /* renamed from: a  reason: collision with other method in class */
    public void m868a() {
        String str = this.a.a(this.f994a);
        ArrayList<ii> a2 = bz.a(this.f995a, this.f994a, str, 32768);
        if (a2 != null) {
            Iterator<ii> it = a2.iterator();
            while (it.hasNext()) {
                ii next = it.next();
                next.a("uploadWay", "longXMPushService");
                Cif a3 = ah.a(this.f994a, str, next, hj.Notification);
                if (!TextUtils.isEmpty(this.b) && !TextUtils.equals(this.f994a, this.b)) {
                    if (a3.m617a() == null) {
                        hw hwVar = new hw();
                        hwVar.a("-1");
                        a3.a(hwVar);
                    }
                    a3.m617a().b("ext_traffic_source_pkg", this.b);
                }
                this.a.a.a(this.f994a, it.a(a3), true);
            }
            return;
        }
        b.d("TinyData LongConnUploader.upload Get a null XmPushActionNotification list when TinyDataHelper.pack() in XMPushService.");
    }
}
