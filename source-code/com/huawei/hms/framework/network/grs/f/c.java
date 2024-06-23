package com.huawei.hms.framework.network.grs.f;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.framework.network.grs.local.model.a;
import com.huawei.hms.framework.network.grs.local.model.b;
import com.huawei.hms.framework.network.grs.local.model.d;
import com.tencent.open.SocialConstants;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
public class c extends a {
    public c(Context context, boolean z) {
        this.e = z;
        if (a("grs_sdk_global_route_config.json", context) == 0) {
            this.d = true;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0060 A[Catch:{ JSONException -> 0x0088 }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0081 A[SYNTHETIC] */
    private List<b> a(JSONObject jSONObject) {
        JSONArray jSONArray;
        try {
            ArrayList arrayList = new ArrayList(16);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                b bVar = new b();
                bVar.b(next);
                JSONObject jSONObject2 = jSONObject.getJSONObject(next);
                bVar.c(jSONObject2.getString("name"));
                bVar.a(jSONObject2.getString(SocialConstants.PARAM_COMMENT));
                JSONArray jSONArray2 = null;
                if (jSONObject2.has("countriesOrAreas")) {
                    jSONArray = jSONObject2.getJSONArray("countriesOrAreas");
                } else if (jSONObject2.has("countries")) {
                    jSONArray = jSONObject2.getJSONArray("countries");
                } else {
                    Logger.w("LocalManagerV1", "current country or area group has not config countries or areas.");
                    HashSet hashSet = new HashSet(16);
                    if (jSONArray2 != null) {
                        if (jSONArray2.length() != 0) {
                            for (int i = 0; i < jSONArray2.length(); i++) {
                                hashSet.add((String) jSONArray2.get(i));
                            }
                            bVar.a(hashSet);
                            arrayList.add(bVar);
                        }
                    }
                    return new ArrayList();
                }
                jSONArray2 = jSONArray;
                HashSet hashSet2 = new HashSet(16);
                if (jSONArray2 != null) {
                }
                return new ArrayList();
            }
            return arrayList;
        } catch (JSONException e) {
            Logger.w("LocalManagerV1", "parse countryGroups failed maybe json style is wrong. %s", StringUtils.anonymizeMessage(e.getMessage()));
            return new ArrayList();
        }
    }

    @Override // com.huawei.hms.framework.network.grs.f.a
    public int a(String str) {
        this.a = new a();
        try {
            JSONObject jSONObject = new JSONObject(str).getJSONObject("application");
            String string = jSONObject.getString("name");
            long j = jSONObject.getLong("cacheControl");
            JSONArray jSONArray = jSONObject.getJSONArray("services");
            this.a.b(string);
            this.a.a(j);
            return (jSONArray == null || jSONArray.length() == 0) ? -1 : 0;
        } catch (JSONException e) {
            Logger.w("LocalManagerV1", "parse appbean failed maybe json style is wrong. %s", StringUtils.anonymizeMessage(e.getMessage()));
            return -1;
        }
    }

    public List<b> a(JSONArray jSONArray, JSONObject jSONObject) {
        return (jSONObject == null || jSONObject.length() == 0) ? new ArrayList() : a(jSONObject);
    }

    @Override // com.huawei.hms.framework.network.grs.f.a
    public int b(String str) {
        this.b = new ArrayList(16);
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObject2 = null;
            if (jSONObject.has("countryOrAreaGroups")) {
                jSONObject2 = jSONObject.getJSONObject("countryOrAreaGroups");
            } else if (jSONObject.has("countryGroups")) {
                jSONObject2 = jSONObject.getJSONObject("countryGroups");
            } else {
                Logger.e("LocalManagerV1", "maybe local config json is wrong because the default countryOrAreaGroups isn't config.");
            }
            if (jSONObject2 == null) {
                return -1;
            }
            if (jSONObject2.length() != 0) {
                this.b.addAll(a(jSONObject2));
            }
            return 0;
        } catch (JSONException e) {
            Logger.w("LocalManagerV1", "parse countrygroup failed maybe json style is wrong. %s", StringUtils.anonymizeMessage(e.getMessage()));
            return -1;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x010c  */
    @Override // com.huawei.hms.framework.network.grs.f.a
    public int e(String str) {
        JSONObject jSONObject;
        String str2;
        Iterator<String> keys;
        String str3;
        String str4 = "countryGroup";
        String str5 = "countryOrAreaGroup";
        try {
            JSONObject jSONObject2 = new JSONObject(str).getJSONObject("services");
            Iterator<String> keys2 = jSONObject2.keys();
            while (keys2.hasNext()) {
                String next = keys2.next();
                com.huawei.hms.framework.network.grs.local.model.c cVar = new com.huawei.hms.framework.network.grs.local.model.c();
                cVar.b(next);
                if (!this.g.contains(next)) {
                    this.g.add(next);
                    if (this.e) {
                        JSONObject jSONObject3 = jSONObject2.getJSONObject(next);
                        cVar.c(jSONObject3.getString("routeBy"));
                        JSONArray jSONArray = jSONObject3.getJSONArray("servings");
                        int i = 0;
                        while (i < jSONArray.length()) {
                            JSONObject jSONObject4 = (JSONObject) jSONArray.get(i);
                            d dVar = new d();
                            if (jSONObject4.has(str5)) {
                                str3 = jSONObject4.getString(str5);
                            } else if (jSONObject4.has(str4)) {
                                str3 = jSONObject4.getString(str4);
                            } else {
                                Logger.v("LocalManagerV1", "maybe this service routeBy is unconditional.");
                                str2 = "no-country";
                                dVar.a(str2);
                                JSONObject jSONObject5 = jSONObject4.getJSONObject("addresses");
                                ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(16);
                                keys = jSONObject5.keys();
                                while (keys.hasNext()) {
                                    String next2 = keys.next();
                                    String string = jSONObject5.getString(next2);
                                    if (TextUtils.isEmpty(next2) || TextUtils.isEmpty(string)) {
                                        keys = keys;
                                    } else {
                                        concurrentHashMap.put(next2, jSONObject5.getString(next2));
                                        keys = keys;
                                        str5 = str5;
                                    }
                                }
                                dVar.a(concurrentHashMap);
                                cVar.a(dVar.b(), dVar);
                                i++;
                                str4 = str4;
                                str5 = str5;
                            }
                            str2 = str3;
                            dVar.a(str2);
                            JSONObject jSONObject52 = jSONObject4.getJSONObject("addresses");
                            ConcurrentHashMap concurrentHashMap2 = new ConcurrentHashMap(16);
                            keys = jSONObject52.keys();
                            while (keys.hasNext()) {
                            }
                            dVar.a(concurrentHashMap2);
                            cVar.a(dVar.b(), dVar);
                            i++;
                            str4 = str4;
                            str5 = str5;
                        }
                        List<b> list = null;
                        if (jSONObject3.has("countryOrAreaGroups")) {
                            jSONObject = jSONObject3.getJSONObject("countryOrAreaGroups");
                        } else if (jSONObject3.has("countryGroups")) {
                            jSONObject = jSONObject3.getJSONObject("countryGroups");
                        } else {
                            Logger.v("LocalManagerV1", "service use default countryOrAreaGroup");
                            cVar.a(list);
                            if (this.a == null) {
                                this.a = new a();
                            }
                            this.a.a(next, cVar);
                            str4 = str4;
                            str5 = str5;
                        }
                        list = a((JSONArray) null, jSONObject);
                        cVar.a(list);
                        if (this.a == null) {
                        }
                        this.a.a(next, cVar);
                        str4 = str4;
                        str5 = str5;
                    }
                }
            }
            return 0;
        } catch (JSONException e) {
            Logger.w("LocalManagerV1", "parse 1.0 services failed maybe because of json style.please check! %s", StringUtils.anonymizeMessage(e.getMessage()));
            return -1;
        }
    }
}
