package com.amap.api.mapcore.util;

import android.content.Context;
import com.amap.api.maps.offlinemap.OfflineMapCity;
import com.amap.api.maps.offlinemap.OfflineMapProvince;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import org.json.JSONException;
import org.json.JSONObject;

@hh(a = "update_item", b = true)
/* compiled from: Taobao */
public class bk extends bn {
    private String n = "";
    private Context o;

    public bk() {
    }

    /* access modifiers changed from: protected */
    public void a() {
        String c = eq.c(this.o);
        this.d = c + this.m + ".zip.tmp";
    }

    public String b() {
        return this.n;
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x00c1 A[SYNTHETIC, Splitter:B:25:0x00c1] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00c9 A[SYNTHETIC, Splitter:B:29:0x00c9] */
    /* JADX WARNING: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    public void c() {
        Throwable th;
        IOException e;
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("title", this.a);
            jSONObject2.put("code", this.c);
            jSONObject2.put("url", this.b);
            jSONObject2.put("fileName", this.d);
            jSONObject2.put("lLocalLength", this.f);
            jSONObject2.put("lRemoteLength", this.g);
            jSONObject2.put("mState", this.l);
            jSONObject2.put("version", this.e);
            jSONObject2.put("localPath", this.h);
            String str = this.n;
            if (str != null) {
                jSONObject2.put("vMapFileNames", str);
            }
            jSONObject2.put("isSheng", this.i);
            jSONObject2.put("mCompleteCode", this.j);
            jSONObject2.put("mCityCode", this.k);
            jSONObject2.put("pinyin", this.m);
            jSONObject.put("file", jSONObject2);
            File file = new File(this.d + ".dt");
            file.delete();
            OutputStreamWriter outputStreamWriter = null;
            try {
                OutputStreamWriter outputStreamWriter2 = new OutputStreamWriter(new FileOutputStream(file, true), "utf-8");
                try {
                    outputStreamWriter2.write(jSONObject.toString());
                    try {
                        outputStreamWriter2.close();
                        return;
                    } catch (IOException e2) {
                        e = e2;
                    }
                } catch (IOException e3) {
                    e = e3;
                    outputStreamWriter = outputStreamWriter2;
                    try {
                        hd.c(e, "UpdateItem", "saveJSONObjectToFile");
                        e.printStackTrace();
                        if (outputStreamWriter == null) {
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (outputStreamWriter != null) {
                            try {
                                outputStreamWriter.close();
                            } catch (IOException e4) {
                                e4.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    outputStreamWriter = outputStreamWriter2;
                    if (outputStreamWriter != null) {
                    }
                    throw th;
                }
                e.printStackTrace();
            } catch (IOException e5) {
                e = e5;
                hd.c(e, "UpdateItem", "saveJSONObjectToFile");
                e.printStackTrace();
                if (outputStreamWriter == null) {
                    try {
                        outputStreamWriter.close();
                    } catch (IOException e6) {
                        e = e6;
                    }
                }
            }
        } catch (Throwable th4) {
            hd.c(th4, "UpdateItem", "saveJSONObjectToFile parseJson");
            th4.printStackTrace();
        }
    }

    public void b(String str) {
        if (str != null) {
            try {
                if (!"".equals(str)) {
                    JSONObject jSONObject = new JSONObject(str).getJSONObject("file");
                    if (jSONObject != null) {
                        this.a = jSONObject.optString("title");
                        this.c = jSONObject.optString("code");
                        this.b = jSONObject.optString("url");
                        this.d = jSONObject.optString("fileName");
                        this.f = jSONObject.optLong("lLocalLength");
                        this.g = jSONObject.optLong("lRemoteLength");
                        this.l = jSONObject.optInt("mState");
                        this.e = jSONObject.optString("version");
                        this.h = jSONObject.optString("localPath");
                        this.n = jSONObject.optString("vMapFileNames");
                        this.i = jSONObject.optInt("isSheng");
                        this.j = jSONObject.optInt("mCompleteCode");
                        this.k = jSONObject.optString("mCityCode");
                        String a = a(jSONObject, "pinyin");
                        this.m = a;
                        if ("".equals(a)) {
                            String str2 = this.b;
                            String substring = str2.substring(str2.lastIndexOf("/") + 1);
                            this.m = substring.substring(0, substring.lastIndexOf("."));
                        }
                    }
                }
            } catch (Throwable th) {
                hd.c(th, "UpdateItem", "readFileToJSONObject");
                th.printStackTrace();
            }
        }
    }

    public bk(OfflineMapCity offlineMapCity, Context context) {
        this.o = context;
        this.a = offlineMapCity.getCity();
        this.c = offlineMapCity.getAdcode();
        this.b = offlineMapCity.getUrl();
        this.g = offlineMapCity.getSize();
        this.e = offlineMapCity.getVersion();
        this.k = offlineMapCity.getCode();
        this.i = 0;
        this.l = offlineMapCity.getState();
        this.j = offlineMapCity.getcompleteCode();
        this.m = offlineMapCity.getPinyin();
        a();
    }

    public void a(String str) {
        this.n = str;
    }

    public static String a(JSONObject jSONObject, String str) throws JSONException {
        if (jSONObject != null && jSONObject.has(str) && !"[]".equals(jSONObject.getString(str))) {
            return jSONObject.optString(str).trim();
        }
        return "";
    }

    public bk(OfflineMapProvince offlineMapProvince, Context context) {
        this.o = context;
        this.a = offlineMapProvince.getProvinceName();
        this.c = offlineMapProvince.getProvinceCode();
        this.b = offlineMapProvince.getUrl();
        this.g = offlineMapProvince.getSize();
        this.e = offlineMapProvince.getVersion();
        this.i = 1;
        this.l = offlineMapProvince.getState();
        this.j = offlineMapProvince.getcompleteCode();
        this.m = offlineMapProvince.getPinyin();
        a();
    }
}
