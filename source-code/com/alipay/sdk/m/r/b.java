package com.alipay.sdk.m.r;

import android.text.TextUtils;
import com.alipay.sdk.m.t.a;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* compiled from: Taobao */
public class b {
    public a a;
    public String b;
    public String[] c;

    public b(String str) {
        this.b = str;
    }

    public static void a(b bVar) {
        String[] c2 = bVar.c();
        if (c2.length == 3 && TextUtils.equals("tid", c2[0])) {
            a a2 = a.a(com.alipay.sdk.m.s.b.d().b());
            if (!TextUtils.isEmpty(c2[1]) && !TextUtils.isEmpty(c2[2])) {
                a2.a(c2[1], c2[2]);
            }
        }
    }

    public static String[] b(String str) {
        ArrayList arrayList = new ArrayList();
        int indexOf = str.indexOf(40);
        int lastIndexOf = str.lastIndexOf(41);
        if (indexOf == -1 || lastIndexOf == -1 || lastIndexOf <= indexOf) {
            return null;
        }
        for (String str2 : str.substring(indexOf + 1, lastIndexOf).split("' *, *'", -1)) {
            arrayList.add(str2.trim().replaceAll("'", "").replaceAll("\"", ""));
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    public String[] c() {
        return this.c;
    }

    public b(String str, a aVar) {
        this.b = str;
        this.a = aVar;
    }

    public static List<b> a(JSONObject jSONObject) {
        ArrayList arrayList = new ArrayList();
        if (jSONObject == null) {
            return arrayList;
        }
        String[] a2 = a(jSONObject.optString("name", ""));
        for (int i = 0; i < a2.length; i++) {
            a a3 = a.a(a2[i]);
            if (a3 != a.None) {
                b bVar = new b(a2[i], a3);
                bVar.c = b(a2[i]);
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    public String b() {
        return this.b;
    }

    public static String[] a(String str) {
        if (!TextUtils.isEmpty(str)) {
            return str.split(";");
        }
        return null;
    }

    public a a() {
        return this.a;
    }
}
