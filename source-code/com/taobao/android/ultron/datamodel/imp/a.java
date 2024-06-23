package com.taobao.android.ultron.datamodel.imp;

import android.content.Context;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.taobao.android.ultron.common.model.IDMComponent;
import com.taobao.android.ultron.datamodel.IDMContext;
import com.taobao.android.ultron.datamodel.ISubmitModule;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import tb.mc0;
import tb.uu2;
import tb.vu2;

/* compiled from: Taobao */
public class a implements IDMContext {
    public static final String LOG_TAG = "ultron-sdk";
    private b a;
    private JSONObject b;
    private JSONObject c;
    private JSONObject d;
    private JSONObject e;
    private JSONObject f;
    private JSONObject g;
    private String h = "";
    List<IDMComponent> i;
    List<mc0> j;
    Map<String, DMComponent> k = new ConcurrentHashMap();
    Map<String, DMComponent> l = new ConcurrentHashMap();
    private Map<String, ExtendBlock> m = new HashMap();
    private ConcurrentHashMap<String, JSONObject> n = new ConcurrentHashMap<>();
    boolean o;
    private uu2 p;
    private boolean q = false;
    private String r;
    private Context s;
    private String t;
    private Set<String> u = new HashSet();

    public a(boolean z) {
        this.a = new b(z);
        this.o = z;
    }

    private void r(Object obj, Object obj2) {
        if ((obj instanceof JSONArray) && (obj2 instanceof JSONArray)) {
            int i2 = 0;
            while (true) {
                JSONArray jSONArray = (JSONArray) obj;
                if (i2 < jSONArray.size()) {
                    Object obj3 = jSONArray.get(i2);
                    JSONArray jSONArray2 = (JSONArray) obj2;
                    if (!jSONArray2.contains(obj3)) {
                        jSONArray2.add(obj3);
                    }
                    i2++;
                } else {
                    return;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void A(b bVar) {
        this.a = bVar;
    }

    /* access modifiers changed from: package-private */
    public void B(JSONObject jSONObject) {
        this.d = jSONObject;
    }

    /* access modifiers changed from: package-private */
    public void C(JSONObject jSONObject) {
    }

    /* access modifiers changed from: package-private */
    public void D(JSONObject jSONObject) {
        this.e = jSONObject;
    }

    public void E(String str) {
        this.t = str;
    }

    public void F(String str) {
        this.h = str;
    }

    public void G(JSONObject jSONObject) {
        this.b = jSONObject;
    }

    /* access modifiers changed from: package-private */
    public void H(List<mc0> list) {
        this.j = list;
    }

    public void I(Map<String, JSONObject> map) {
        if (map != null) {
            this.n.clear();
            this.n.putAll(map);
        }
    }

    public void J(String... strArr) {
        if (strArr != null) {
            this.u.addAll(Arrays.asList(strArr));
        } else {
            this.u.clear();
        }
    }

    public String a() {
        return this.r;
    }

    public JSONObject b() {
        return this.g;
    }

    public Map<String, DMComponent> c() {
        return this.k;
    }

    public Context d() {
        return this.s;
    }

    public JSONObject e() {
        return this.c;
    }

    public JSONObject f() {
        return this.f;
    }

    public b g() {
        return this.a;
    }

    @Override // com.taobao.android.ultron.datamodel.IDMContext
    public IDMComponent getComponentByName(String str) {
        return this.k.get(str);
    }

    @Override // com.taobao.android.ultron.datamodel.IDMContext
    public List<IDMComponent> getComponents() {
        return this.i;
    }

    @Override // com.taobao.android.ultron.datamodel.IDMContext
    public List<IDMComponent> getComponentsByRoot(String str) {
        return this.a.c(this, str);
    }

    @Override // com.taobao.android.ultron.datamodel.IDMContext
    public List<mc0> getDynamicTemplateList() {
        return this.j;
    }

    @Override // com.taobao.android.ultron.datamodel.IDMContext
    public JSONObject getGlobal() {
        return this.d;
    }

    @Override // com.taobao.android.ultron.datamodel.IDMContext
    public String getProtocolVersion() {
        return this.h;
    }

    @Override // com.taobao.android.ultron.datamodel.IDMContext
    public IDMComponent getRootComponent() {
        return this.a.d();
    }

    public Map<String, ExtendBlock> h() {
        return this.m;
    }

    public JSONArray i() {
        JSONObject jSONObject = this.e;
        if (jSONObject == null) {
            return null;
        }
        return jSONObject.getJSONArray("input");
    }

    @Override // com.taobao.android.ultron.datamodel.IDMContext
    public boolean isCacheData() {
        return this.q;
    }

    public JSONObject j() {
        return this.e;
    }

    public String k() {
        return this.t;
    }

    public Map<String, DMComponent> l() {
        return this.l;
    }

    public JSONArray m() {
        JSONObject jSONObject = this.e;
        if (jSONObject == null) {
            return null;
        }
        return jSONObject.getJSONArray("request");
    }

    public JSONObject n() {
        return this.b;
    }

    public ConcurrentHashMap<String, JSONObject> o() {
        return this.n;
    }

    public boolean p(String str) {
        return this.u.contains(str);
    }

    /* access modifiers changed from: package-private */
    public JSONObject q(JSONObject jSONObject) {
        JSONObject jSONObject2 = this.c;
        if (jSONObject2 == null) {
            this.c = jSONObject;
        } else {
            jSONObject2.putAll(jSONObject);
        }
        return this.c;
    }

    /* access modifiers changed from: package-private */
    public JSONObject s(JSONObject jSONObject) {
        Set<String> keySet = this.m.keySet();
        if (keySet == null || keySet.isEmpty()) {
            this.b = jSONObject;
            return jSONObject;
        }
        for (Map.Entry<String, Object> entry : jSONObject.entrySet()) {
            if (entry != null) {
                String key = entry.getKey();
                if (keySet.contains(key)) {
                    Object value = entry.getValue();
                    Object obj = this.b.get(key);
                    if (obj == null) {
                        this.b.put(key, value);
                    }
                    r(value, obj);
                } else {
                    this.b.put(entry.getKey(), entry.getValue());
                }
            }
        }
        return this.b;
    }

    @Override // com.taobao.android.ultron.datamodel.IDMContext
    public void setBizName(String str) {
        this.r = str;
    }

    @Override // com.taobao.android.ultron.datamodel.IDMContext
    public void setComponents(List<IDMComponent> list) {
        this.i = list;
    }

    @Override // com.taobao.android.ultron.datamodel.IDMContext
    public void setSubmitModule(ISubmitModule iSubmitModule) {
        this.a.f(iSubmitModule);
    }

    public void t() {
        this.f = null;
        this.b = null;
        this.d = null;
        this.e = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.c = null;
        if (!p("data")) {
            this.k.clear();
        }
        this.n.clear();
        this.l.clear();
        this.m.clear();
    }

    public void u(boolean z) {
        this.q = z;
    }

    /* access modifiers changed from: package-private */
    public void v(JSONObject jSONObject) {
        this.g = jSONObject;
    }

    @Override // com.taobao.android.ultron.datamodel.IDMContext
    public vu2 validate() {
        if (this.p == null) {
            this.p = new uu2(this);
        }
        return this.p.a();
    }

    /* access modifiers changed from: package-private */
    public void w(List<IDMComponent> list) {
        this.i = list;
    }

    public void x(Context context) {
        if (context != null) {
            this.s = context.getApplicationContext();
        }
    }

    /* access modifiers changed from: package-private */
    public void y(JSONObject jSONObject) {
        this.c = jSONObject;
    }

    public void z(JSONObject jSONObject) {
        this.f = jSONObject;
    }
}
