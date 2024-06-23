package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.ba;
import com.xiaomi.push.service.ca;
import java.io.File;

/* compiled from: Taobao */
public class hd implements XMPushService.n {
    private static boolean a;

    /* renamed from: a  reason: collision with other field name */
    private int f454a;

    /* renamed from: a  reason: collision with other field name */
    private Context f455a;
    private boolean b;

    public hd(Context context) {
        this.f455a = context;
    }

    private String a(String str) {
        return "com.xiaomi.xmsf".equals(str) ? "1000271" : this.f455a.getSharedPreferences("pref_registered_pkg_names", 0).getString(str, null);
    }

    private void a(Context context) {
        this.b = ba.a(context).a(ho.TinyDataUploadSwitch.a(), true);
        int a2 = ba.a(context).a(ho.TinyDataUploadFrequency.a(), 7200);
        this.f454a = a2;
        this.f454a = Math.max(60, a2);
    }

    public static void a(boolean z) {
        a = z;
    }

    @Override // com.xiaomi.push.service.XMPushService.n
    private boolean a() {
        return Math.abs((System.currentTimeMillis() / 1000) - this.f455a.getSharedPreferences("mipush_extra", 4).getLong("last_tiny_data_upload_timestamp", -1)) > ((long) this.f454a);
    }

    private boolean a(hh hhVar) {
        if (bj.b(this.f455a) && hhVar != null && !TextUtils.isEmpty(a(this.f455a.getPackageName())) && new File(this.f455a.getFilesDir(), "tiny_data.data").exists() && !a) {
            return !ba.a(this.f455a).a(ho.ScreenOnOrChargingTinyDataUploadSwitch.a(), false) || j.m688a(this.f455a) || j.m690b(this.f455a);
        }
        return false;
    }

    @Override // com.xiaomi.push.service.XMPushService.n
    /* renamed from: a  reason: collision with other method in class */
    public void m546a() {
        hh a2 = hg.a(this.f455a).a();
        if (hi.a(this.f455a) && a2 != null) {
            hf.a(this.f455a, a2, ca.f956a);
            ca.a();
            b.c("coord data upload");
        }
        a(this.f455a);
        if (this.b && a()) {
            b.m182a("TinyData TinyDataCacheProcessor.pingFollowUpAction ts:" + System.currentTimeMillis());
            if (!a(a2)) {
                b.m182a("TinyData TinyDataCacheProcessor.pingFollowUpAction !canUpload(uploader) ts:" + System.currentTimeMillis());
                return;
            }
            a = true;
            he.a(this.f455a, a2);
        }
    }
}
