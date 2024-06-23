package com.amap.api.mapcore.util;

import android.content.Context;
import com.uc.webview.export.internal.SDKFactory;
import java.util.Hashtable;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: Taobao */
public class j extends fu<String, a> {
    private boolean h = true;
    private int[] i = {10000, 0, 10018, 10019, SDKFactory.getCoreType, SDKFactory.setCoreType, SDKFactory.getGlobalSettings, 10023};

    /* compiled from: Taobao */
    public static class a {
        public int a = -1;
        public String b;
        public String c;
        public boolean d = false;
    }

    public j(Context context, String str) {
        super(context, str);
        this.g = "/feedback";
        this.isPostFlag = false;
        this.h = true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public a b(String str) throws ft {
        String str2;
        try {
            JSONObject jSONObject = new JSONObject(str);
            int i2 = -1;
            String str3 = "";
            if (jSONObject.has("errcode")) {
                i2 = jSONObject.optInt("errcode");
                str3 = jSONObject.optString("errmsg");
                str2 = jSONObject.optString("errdetail");
            } else {
                str2 = str3;
            }
            a aVar = new a();
            aVar.a = i2;
            aVar.b = str3;
            aVar.c = str2;
            int i3 = 0;
            aVar.d = false;
            int[] iArr = this.i;
            int length = iArr.length;
            while (true) {
                if (i3 >= length) {
                    break;
                } else if (iArr[i3] == i2) {
                    aVar.d = true;
                    break;
                } else {
                    i3++;
                }
            }
            return aVar;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.amap.api.mapcore.util.fu
    public String a() {
        return null;
    }

    @Override // com.amap.api.mapcore.util.ii
    public String getIPV6URL() {
        return eq.a(getURL());
    }

    @Override // com.amap.api.mapcore.util.dp, com.amap.api.mapcore.util.ii
    public Map<String, String> getParams() {
        Hashtable hashtable = new Hashtable(16);
        hashtable.put("key", gc.f(this.f));
        if (this.h) {
            hashtable.put("pname", "3dmap");
        }
        String a2 = gf.a();
        String a3 = gf.a(this.f, a2, gn.c(hashtable));
        hashtable.put("ts", a2);
        hashtable.put("scode", a3);
        return hashtable;
    }

    @Override // com.amap.api.mapcore.util.ii
    public String getURL() {
        return "http://restapi.amap.com/v4" + this.g;
    }

    @Override // com.amap.api.mapcore.util.ii
    public boolean isSupportIPV6() {
        return true;
    }
}
