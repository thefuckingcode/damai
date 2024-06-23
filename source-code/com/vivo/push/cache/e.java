package com.vivo.push.cache;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.vivo.push.model.a;
import com.vivo.push.util.f;
import com.vivo.push.util.p;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
public final class e extends c<a> {
    public e(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    @Override // com.vivo.push.cache.c
    public final String a() {
        return "com.vivo.pushservice.other";
    }

    @Override // com.vivo.push.cache.c
    public final List<a> a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String str2 : str.trim().split("@#")) {
            String trim = str2.trim();
            String[] split = trim.trim().split(",");
            if (split.length >= 2) {
                try {
                    arrayList.add(new a(split[0], trim.substring(split[0].length() + 1)));
                } catch (Exception e) {
                    p.d("PushConfigSettings", "str2Clients E: ".concat(String.valueOf(e)));
                }
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    @Override // com.vivo.push.cache.c
    public final String b(String str) throws Exception {
        return new String(f.a(f.a(e()), f.a(f()), Base64.decode(str, 2)), "utf-8");
    }

    public final String c(String str) {
        synchronized (c.a) {
            for (T t : this.b) {
                if (!TextUtils.isEmpty(t.a()) && t.a().equals(str)) {
                    return t.b();
                }
            }
            return null;
        }
    }
}
