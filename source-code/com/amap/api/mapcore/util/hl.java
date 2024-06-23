package com.amap.api.mapcore.util;

import android.content.Context;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import java.util.List;

/* compiled from: Taobao */
public class hl {
    private hg a;
    private Context b;

    public hl(Context context, boolean z) {
        this.b = context;
        this.a = a(context, z);
    }

    private hg a(Context context, boolean z) {
        try {
            return new hg(context, hg.a((Class<? extends hf>) hk.class));
        } catch (Throwable th) {
            if (!z) {
                hd.c(th, "sd", "gdb");
            }
            return null;
        }
    }

    public void a(gm gmVar) {
        if (gmVar != null) {
            try {
                if (this.a == null) {
                    this.a = a(this.b, false);
                }
                String a2 = gm.a(gmVar.a());
                List<gm> b2 = this.a.b(a2, gm.class);
                if (b2 != null) {
                    if (b2.size() != 0) {
                        if (a(b2, gmVar)) {
                            this.a.a(a2, gmVar);
                            return;
                        }
                        return;
                    }
                }
                this.a.a(gmVar);
            } catch (Throwable th) {
                hd.c(th, "sd", AdvanceSetting.NETWORK_TYPE);
            }
        }
    }

    private boolean a(List<gm> list, gm gmVar) {
        for (gm gmVar2 : list) {
            if (gmVar2.equals(gmVar)) {
                return false;
            }
        }
        return true;
    }

    public List<gm> a() {
        try {
            return this.a.a(gm.h(), gm.class, true);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
