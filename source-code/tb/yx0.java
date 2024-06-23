package tb;

import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.taobao.updatecenter.query.MudpUpdateRequest;
import java.util.ArrayList;
import mtopsdk.mtop.domain.IMTOPDataObject;
import mtopsdk.mtop.domain.JsonTypeEnum;
import mtopsdk.mtop.domain.MethodEnum;
import mtopsdk.mtop.domain.MtopResponse;
import mtopsdk.mtop.intf.Mtop;
import mtopsdk.mtop.intf.MtopBuilder;

/* compiled from: Taobao */
public class yx0 {
    private static yx0 c;
    private Application a;
    private String b;

    private yx0() {
    }

    public static synchronized yx0 a() {
        yx0 yx0;
        synchronized (yx0.class) {
            if (c == null) {
                c = new yx0();
            }
            yx0 = c;
        }
        return yx0;
    }

    private String b(Context context) {
        NetworkInfo networkInfo;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null || (networkInfo = connectivityManager.getNetworkInfo(1)) == null || NetworkInfo.State.CONNECTED != networkInfo.getState()) {
                return "none";
            }
            return "wifi";
        } catch (Exception unused) {
        }
    }

    public uo1 c(Application application, String str, int i, String str2, String str3, long j) {
        MtopBuilder mtopBuilder;
        this.a = application;
        MudpUpdateRequest mudpUpdateRequest = new MudpUpdateRequest();
        mudpUpdateRequest.appVersion = str;
        mudpUpdateRequest.apiLevel = (long) Build.VERSION.SDK_INT;
        mudpUpdateRequest.patchVersion = (long) i;
        mudpUpdateRequest.dexpatchVersion = j;
        mudpUpdateRequest.group = str2;
        mudpUpdateRequest.identifier = str2;
        mudpUpdateRequest.brand = com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getMANUFACTURER();
        mudpUpdateRequest.model = com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getMODEL();
        mudpUpdateRequest.netStatus = "wifi".equals(b(this.a)) ? 10 : 1;
        ArrayList arrayList = new ArrayList();
        arrayList.add("hotpatch");
        arrayList.add(js2.DEXPATCH);
        mudpUpdateRequest.updateTypes = arrayList;
        if (TextUtils.isEmpty(this.b)) {
            mtopBuilder = Mtop.instance(this.a).build((IMTOPDataObject) mudpUpdateRequest, "600000");
        } else {
            mtopBuilder = Mtop.instance(this.a, this.b).build((IMTOPDataObject) mudpUpdateRequest, this.b).setJsonType(JsonTypeEnum.ORIGINALJSON);
        }
        if (!TextUtils.isEmpty(str3)) {
            mtopBuilder.setCustomDomain(str3);
        }
        mtopBuilder.reqMethod(MethodEnum.GET);
        MtopResponse syncRequest = mtopBuilder.syncRequest();
        if (syncRequest == null || !syncRequest.isApiSuccess()) {
            Log.e("HotPatchBusiness", "response is null or response is failed!");
            return null;
        }
        try {
            String str4 = new String(syncRequest.getBytedata());
            if (!TextUtils.isEmpty(str4)) {
                JSONObject parseObject = JSON.parseObject(str4);
                if (parseObject.containsKey("data")) {
                    JSONObject jSONObject = parseObject.getJSONObject("data");
                    boolean z = false;
                    if (jSONObject.containsKey("hasUpdate")) {
                        z = jSONObject.getBoolean("hasUpdate").booleanValue();
                    }
                    if (z) {
                        return uo1.a(jSONObject.getJSONObject("hotpatch"));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("HotPatchBusiness", "response parse exception : " + e.getMessage());
        }
        return null;
    }

    public void d(String str) {
        this.b = str;
    }
}
