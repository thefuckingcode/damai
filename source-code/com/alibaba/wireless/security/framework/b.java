package com.alibaba.wireless.security.framework;

import com.alibaba.wireless.security.framework.utils.a;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

/* compiled from: Taobao */
public class b {
    private static String h = "version";
    private static String i = "lib_dep_version";
    private static String j = "lib_dep_arch";
    private static String k = "target_plugin";
    private static String l = "sg_version";
    private JSONObject a;
    private boolean b = true;
    private int c = 0;
    private boolean d = true;
    private String e = "";
    private boolean f = true;
    private String g = "";

    private b(JSONObject jSONObject) {
        this.a = jSONObject;
    }

    public static b a(File file) {
        if (file == null || !file.exists()) {
            return null;
        }
        try {
            String a2 = a.a(file);
            if (a2 == null || a2.length() <= 0) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(a2);
            if ("1.0".equals(jSONObject.getString(h))) {
                return new b(jSONObject);
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public String a(String str) {
        try {
            return a().getString(str);
        } catch (Exception unused) {
            return "";
        }
    }

    public JSONObject a() {
        return this.a;
    }

    public int b() {
        int i2;
        if (this.b) {
            try {
                i2 = Integer.parseInt(a().getString(i));
            } catch (Exception unused) {
                i2 = 0;
            }
            this.c = i2;
            this.b = false;
        }
        return this.c;
    }

    public String c() {
        String str;
        if (this.d) {
            try {
                str = a().getString(j);
            } catch (Exception unused) {
                str = "";
            }
            this.e = str;
            this.d = false;
        }
        return this.e;
    }

    public HashMap<String, String> d() {
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            JSONObject jSONObject = a().getJSONObject(l);
            if (jSONObject != null) {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    hashMap.put(next, jSONObject.getString(next));
                }
            }
        } catch (Exception unused) {
        }
        return hashMap;
    }

    public String e() {
        String str;
        if (this.f) {
            try {
                str = a().getString(k);
            } catch (Exception unused) {
                str = "";
            }
            this.g = str;
            this.f = false;
        }
        return this.g;
    }
}
