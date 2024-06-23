package com.alibaba.wireless.security.framework;

import android.content.pm.PackageInfo;
import java.io.File;
import org.json.JSONObject;

/* compiled from: Taobao */
public class a {
    private JSONObject a = null;
    private String b;
    public PackageInfo c = null;

    public a(String str) {
        this.b = str;
    }

    public String a(String str) {
        try {
            JSONObject a2 = a();
            return a2 != null ? a2.getString(str) : "";
        } catch (Exception unused) {
            return "";
        }
    }

    public JSONObject a() {
        JSONObject jSONObject = this.a;
        if (jSONObject != null) {
            return jSONObject;
        }
        JSONObject jSONObject2 = null;
        try {
            String a2 = com.alibaba.wireless.security.framework.utils.a.a(new File(this.b));
            if (a2 != null && a2.length() > 0) {
                jSONObject2 = new JSONObject(a2);
            }
        } catch (Exception unused) {
        }
        this.a = jSONObject2;
        return jSONObject2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0096 A[SYNTHETIC, Splitter:B:18:0x0096] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00a5 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    public boolean a(PackageInfo packageInfo, String str) {
        File file;
        if (packageInfo == null || str == null) {
            return false;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("version", packageInfo.versionName);
            jSONObject.put("hasso", packageInfo.applicationInfo.metaData.getBoolean("hasso", false));
            jSONObject.put("pluginname", packageInfo.applicationInfo.metaData.getString("pluginname"));
            jSONObject.put("pluginclass", packageInfo.applicationInfo.metaData.getString("pluginclass"));
            jSONObject.put("dependencies", packageInfo.applicationInfo.metaData.getString("dependencies"));
            jSONObject.put("weakdependencies", packageInfo.applicationInfo.metaData.getString("weakdependencies"));
            jSONObject.put("reversedependencies", packageInfo.applicationInfo.metaData.getString("reversedependencies"));
            jSONObject.put("thirdpartyso", packageInfo.applicationInfo.metaData.getBoolean("thirdpartyso"));
            jSONObject.put("keepaliveprocs", packageInfo.applicationInfo.metaData.getString("keepaliveprocs"));
            File file2 = null;
            try {
                file = new File(this.b);
                try {
                    if (!file.exists()) {
                        file.createNewFile();
                    }
                } catch (Exception unused) {
                    file2 = file;
                    if (!file2.exists()) {
                    }
                    file = file2;
                    if (com.alibaba.wireless.security.framework.utils.a.a(file, jSONObject.toString())) {
                    }
                }
            } catch (Exception unused2) {
                if (!file2.exists()) {
                    try {
                        file2.createNewFile();
                    } catch (Exception unused3) {
                    }
                }
                file = file2;
                if (com.alibaba.wireless.security.framework.utils.a.a(file, jSONObject.toString())) {
                }
            }
            return com.alibaba.wireless.security.framework.utils.a.a(file, jSONObject.toString());
        } catch (Exception unused4) {
        }
    }

    public boolean b() {
        try {
            return new File(this.b).exists();
        } catch (Exception unused) {
            return false;
        }
    }
}
