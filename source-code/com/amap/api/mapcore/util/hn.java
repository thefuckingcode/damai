package com.amap.api.mapcore.util;

import android.content.Context;
import com.amap.api.mapcore.util.gm;
import com.amap.api.mapcore.util.hp;

/* compiled from: Taobao */
public class hn {
    private Context a;
    private gm b;
    private boolean c = true;
    private String d = "40C27E38DCAD404B5465362914090908";
    private jl e = new jl("40C27E38DCAD404B5465362914090908");

    public void a(Context context, boolean z, String str, String str2, String str3, String[] strArr) {
        try {
            gm a2 = new gm.a(str, str2, str).a(strArr).a(str3).a();
            if (context == null) {
                return;
            }
            if (a2 != null) {
                Context applicationContext = context.getApplicationContext();
                this.a = applicationContext;
                this.b = a2;
                this.c = z;
                this.e.a(applicationContext, a2);
            }
        } catch (gb unused) {
        }
    }

    public void a(String str, String str2) {
        hp.a.a.a(this.a, str, str2, this.e.a(this.a), this.c, this.b);
    }
}
