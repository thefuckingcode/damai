package com.huawei.hms.framework.network.grs.f;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.framework.network.grs.GrsApp;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.h.c;
import com.huawei.hms.framework.network.grs.local.model.b;
import com.huawei.hms.framework.network.grs.local.model.d;
import com.tencent.open.SocialConstants;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
public abstract class a {
    protected com.huawei.hms.framework.network.grs.local.model.a a;
    protected List<b> b;
    protected Map<String, String> c = new ConcurrentHashMap(16);
    protected boolean d = false;
    protected boolean e = false;
    protected boolean f = false;
    protected Set<String> g = new HashSet(16);

    private Map<String, String> a(List<b> list, GrsBaseInfo grsBaseInfo, String str) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(16);
        concurrentHashMap.put("no_route_country", "no-country");
        for (b bVar : list) {
            if (bVar.a().contains(grsBaseInfo.getIssueCountry())) {
                concurrentHashMap.put(grsBaseInfo.getIssueCountry(), bVar.b());
            }
            if (bVar.a().contains(grsBaseInfo.getRegCountry())) {
                concurrentHashMap.put(grsBaseInfo.getRegCountry(), bVar.b());
            }
            if (bVar.a().contains(grsBaseInfo.getSerCountry())) {
                concurrentHashMap.put(grsBaseInfo.getSerCountry(), bVar.b());
            }
            if (bVar.a().contains(str)) {
                Logger.v("AbstractLocalManager", "get countryGroupID from geoIp");
                concurrentHashMap.put(str, bVar.b());
            }
        }
        return concurrentHashMap;
    }

    private int b(String str, Context context) {
        if (f(c.a(str, context)) != 0) {
            return -1;
        }
        Logger.i("AbstractLocalManager", "load APP_CONFIG_FILE success{%s}.", str);
        return 0;
    }

    private int f(String str) {
        int b2;
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (this.e && (b2 = b(str)) != 0) {
            return b2;
        }
        int a2 = a(str);
        return a2 != 0 ? a2 : e(str);
    }

    private int g(String str) {
        List<b> list;
        int c2;
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        return (!this.e || ((list = this.b) != null && !list.isEmpty()) || (c2 = c(str)) == 0) ? d(str) : c2;
    }

    public abstract int a(String str);

    /* access modifiers changed from: package-private */
    public int a(String str, Context context) {
        StringBuilder sb = new StringBuilder();
        sb.append(GrsApp.getInstance().getBrand("/"));
        sb.append(str);
        return b(sb.toString(), context) != 0 ? -1 : 0;
    }

    public String a(Context context, com.huawei.hms.framework.network.grs.e.a aVar, GrsBaseInfo grsBaseInfo, String str, String str2, boolean z) {
        Map<String, String> a2 = a(context, aVar, grsBaseInfo, str, z);
        if (a2 != null) {
            return a2.get(str2);
        }
        Logger.w("AbstractLocalManager", "addresses not found by routeby in local config{%s}", str);
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0067 A[Catch:{ JSONException -> 0x0091 }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x008a A[SYNTHETIC] */
    public List<b> a(JSONArray jSONArray) {
        JSONArray jSONArray2;
        if (jSONArray == null || jSONArray.length() == 0) {
            return new ArrayList();
        }
        try {
            ArrayList arrayList = new ArrayList(16);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                b bVar = new b();
                bVar.b(jSONObject.getString("id"));
                bVar.c(jSONObject.getString("name"));
                bVar.a(jSONObject.getString(SocialConstants.PARAM_COMMENT));
                JSONArray jSONArray3 = null;
                if (jSONObject.has("countriesOrAreas")) {
                    jSONArray2 = jSONObject.getJSONArray("countriesOrAreas");
                } else if (jSONObject.has("countries")) {
                    jSONArray2 = jSONObject.getJSONArray("countries");
                } else {
                    Logger.w("AbstractLocalManager", "current country or area group has not config countries or areas.");
                    HashSet hashSet = new HashSet(16);
                    if (jSONArray3 != null) {
                        if (jSONArray3.length() != 0) {
                            for (int i2 = 0; i2 < jSONArray3.length(); i2++) {
                                hashSet.add((String) jSONArray3.get(i2));
                            }
                            bVar.a(hashSet);
                            arrayList.add(bVar);
                        }
                    }
                    return new ArrayList();
                }
                jSONArray3 = jSONArray2;
                HashSet hashSet2 = new HashSet(16);
                if (jSONArray3 != null) {
                }
                return new ArrayList();
            }
            return arrayList;
        } catch (JSONException e2) {
            Logger.w("AbstractLocalManager", "parse countrygroup failed maybe json style is wrong. %s", StringUtils.anonymizeMessage(e2.getMessage()));
            return new ArrayList();
        }
    }

    public Map<String, String> a(Context context, com.huawei.hms.framework.network.grs.e.a aVar, GrsBaseInfo grsBaseInfo, String str, boolean z) {
        com.huawei.hms.framework.network.grs.local.model.a aVar2 = this.a;
        if (aVar2 == null) {
            Logger.w("AbstractLocalManager", "application data is null.");
            return null;
        }
        com.huawei.hms.framework.network.grs.local.model.c a2 = aVar2.a(str);
        if (a2 == null) {
            Logger.w("AbstractLocalManager", "service not found in local config{%s}", str);
            return null;
        }
        String b2 = e.b(context, aVar, a2.b(), grsBaseInfo, z);
        if (b2 == null) {
            Logger.w("AbstractLocalManager", "country not found by routeby in local config{%s}", a2.b());
            return null;
        }
        List<b> a3 = a2.a();
        d a4 = a2.a(((a3 == null || a3.size() == 0) ? this.c : a(a3, grsBaseInfo, b2)).get(b2));
        if (a4 == null) {
            return null;
        }
        return a4.a();
    }

    public void a() {
        com.huawei.hms.framework.network.grs.local.model.a aVar = this.a;
        if (aVar != null) {
            aVar.a();
            this.f = true;
        }
    }

    public void a(Context context, List<String> list) {
        if (list != null && list.size() > 0) {
            for (String str : list) {
                if (Pattern.matches("^grs_sdk_global_route_config_[a-zA-Z]+\\.json$", str)) {
                    if (g(c.a(GrsApp.getInstance().getBrand("/") + str, context)) == 0) {
                        Logger.i("AbstractLocalManager", "load SDK_CONFIG_FILE: %s, sucess.", str);
                    } else {
                        Logger.i("AbstractLocalManager", "load SDK_CONFIG_FILE: %s, failure.", str);
                    }
                }
            }
        }
    }

    public void a(GrsBaseInfo grsBaseInfo) {
        this.c.put("no_route_country", "no-country");
        List<b> list = this.b;
        if (!(list == null || list.isEmpty())) {
            for (b bVar : this.b) {
                if (bVar.a().contains(grsBaseInfo.getIssueCountry())) {
                    this.c.put(grsBaseInfo.getIssueCountry(), bVar.b());
                }
                if (bVar.a().contains(grsBaseInfo.getRegCountry())) {
                    this.c.put(grsBaseInfo.getRegCountry(), bVar.b());
                }
                if (bVar.a().contains(grsBaseInfo.getSerCountry())) {
                    this.c.put(grsBaseInfo.getSerCountry(), bVar.b());
                }
            }
            this.b = null;
        }
    }

    public abstract int b(String str);

    public com.huawei.hms.framework.network.grs.local.model.a b() {
        return this.a;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00e6  */
    public void b(JSONArray jSONArray) {
        String str;
        Iterator<String> keys;
        if (!(jSONArray == null || jSONArray.length() == 0)) {
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                com.huawei.hms.framework.network.grs.local.model.c cVar = new com.huawei.hms.framework.network.grs.local.model.c();
                String string = jSONObject.getString("name");
                cVar.b(string);
                if (!this.g.contains(string)) {
                    this.g.add(string);
                    if (this.e) {
                        cVar.c(jSONObject.getString("routeBy"));
                        JSONArray jSONArray2 = jSONObject.getJSONArray("servings");
                        for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                            JSONObject jSONObject2 = (JSONObject) jSONArray2.get(i2);
                            d dVar = new d();
                            String str2 = "countryOrAreaGroup";
                            if (!jSONObject2.has(str2)) {
                                str2 = "countryGroup";
                                if (!jSONObject2.has(str2)) {
                                    Logger.v("AbstractLocalManager", "maybe this service{%s} routeBy is unconditional.", string);
                                    str = "no-country";
                                    dVar.a(str);
                                    JSONObject jSONObject3 = jSONObject2.getJSONObject("addresses");
                                    ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(16);
                                    keys = jSONObject3.keys();
                                    while (keys.hasNext()) {
                                        String next = keys.next();
                                        String string2 = jSONObject3.getString(next);
                                        if (!TextUtils.isEmpty(next) && !TextUtils.isEmpty(string2)) {
                                            concurrentHashMap.put(next, jSONObject3.getString(next));
                                        }
                                    }
                                    dVar.a(concurrentHashMap);
                                    cVar.a(dVar.b(), dVar);
                                }
                            }
                            str = jSONObject2.getString(str2);
                            dVar.a(str);
                            JSONObject jSONObject32 = jSONObject2.getJSONObject("addresses");
                            ConcurrentHashMap concurrentHashMap2 = new ConcurrentHashMap(16);
                            keys = jSONObject32.keys();
                            while (keys.hasNext()) {
                            }
                            dVar.a(concurrentHashMap2);
                            cVar.a(dVar.b(), dVar);
                        }
                        List<b> list = null;
                        String str3 = "countryOrAreaGroups";
                        if (!jSONObject.has(str3)) {
                            str3 = "countryGroups";
                            if (!jSONObject.has(str3)) {
                                Logger.i("AbstractLocalManager", "service use default countryOrAreaGroup");
                                cVar.a(list);
                                if (this.a == null) {
                                    this.a = new com.huawei.hms.framework.network.grs.local.model.a();
                                }
                                this.a.a(string, cVar);
                            }
                        }
                        list = a(jSONObject.getJSONArray(str3));
                        cVar.a(list);
                        if (this.a == null) {
                        }
                        this.a.a(string, cVar);
                    }
                }
            }
        }
    }

    public int c(String str) {
        this.b = new ArrayList(16);
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONArray jSONArray = null;
            if (jSONObject.has("countryOrAreaGroups")) {
                jSONArray = jSONObject.getJSONArray("countryOrAreaGroups");
            } else if (jSONObject.has("countryGroups")) {
                jSONArray = jSONObject.getJSONArray("countryGroups");
            } else {
                Logger.e("AbstractLocalManager", "maybe local config json is wrong because the default countryOrAreaGroups isn't config.");
            }
            if (jSONArray == null) {
                return -1;
            }
            this.b.addAll(a(jSONArray));
            return 0;
        } catch (JSONException e2) {
            Logger.w("AbstractLocalManager", "parse countrygroup failed maybe json style is wrong. %s", StringUtils.anonymizeMessage(e2.getMessage()));
            return -1;
        }
    }

    public Set<String> c() {
        return this.g;
    }

    public int d(String str) {
        try {
            b(new JSONObject(str).getJSONArray("services"));
            return 0;
        } catch (JSONException e2) {
            Logger.w("AbstractLocalManager", "parse 2.0 services failed maybe because of json style.please check! %s", StringUtils.anonymizeMessage(e2.getMessage()));
            return -1;
        }
    }

    public boolean d() {
        return this.f;
    }

    public abstract int e(String str);

    public boolean e() {
        return this.d;
    }
}
