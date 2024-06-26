package com.huawei.hms.hatool;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/* compiled from: Taobao */
public class t {
    public List<q> a;
    public String b;
    public String c;
    public String d;

    public t(List<q> list, String str, String str2, String str3) {
        this.a = list;
        this.b = str;
        this.c = str2;
        this.d = str3;
    }

    public void a() {
        if ("_default_config_tag".equals(this.c)) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            ArrayList arrayList4 = new ArrayList();
            for (q qVar : this.a) {
                String c2 = qVar.c();
                if (TextUtils.isEmpty(c2) || "oper".equals(c2)) {
                    arrayList4.add(qVar);
                } else if ("maint".equals(c2)) {
                    arrayList.add(qVar);
                } else if ("preins".equals(c2)) {
                    arrayList2.add(qVar);
                } else if ("diffprivacy".equals(c2)) {
                    arrayList3.add(qVar);
                }
            }
            a(arrayList4, "oper", "_default_config_tag");
            a(arrayList, "maint", "_default_config_tag");
            a(arrayList2, "preins", "_default_config_tag");
            a(arrayList3, "diffprivacy", "_default_config_tag");
            return;
        }
        a(this.a, this.c, this.b);
    }

    public final void a(List<q> list, String str, String str2) {
        if (!list.isEmpty()) {
            int size = (list.size() / 500) + 1;
            for (int i = 0; i < size; i++) {
                int i2 = i * 500;
                List<q> subList = list.subList(i2, Math.min(list.size(), i2 + 500));
                String replace = UUID.randomUUID().toString().replace("-", "");
                long currentTimeMillis = System.currentTimeMillis();
                long b2 = ((long) c.b(str2, str)) * 86400000;
                ArrayList arrayList = new ArrayList();
                for (q qVar : subList) {
                    if (!q0.a(qVar.b(), currentTimeMillis, b2)) {
                        arrayList.add(qVar);
                    }
                }
                if (arrayList.size() > 0) {
                    new u(str2, str, this.d, arrayList, replace).a();
                } else {
                    y.e("hmsSdk", "No data to report handler");
                }
            }
        }
    }
}
