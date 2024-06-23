package com.taobao.android.ultron.datamodel.imp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Keep;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.taobao.android.ultron.common.model.IDMEvent;
import com.youku.arch.v3.data.Constants;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mtopsdk.mtop.domain.MtopResponse;
import tb.am2;
import tb.de;
import tb.er2;
import tb.lv1;
import tb.mc0;
import tb.tr2;

/* compiled from: Taobao */
public class ParseResponseHelper {
    private a a;
    private boolean b = false;
    private Map<String, Object> c = new HashMap();
    private AsyncTask<Void, Void, de> d;
    private volatile de e;

    @Keep
    /* compiled from: Taobao */
    public static class TemplateInfo implements Serializable {
        public String id;
        public String version;

        public TemplateInfo(String str, String str2) {
            this.id = str;
            this.version = str2;
        }
    }

    /* compiled from: Taobao */
    class a extends AsyncTask<Void, Void, de> {
        final /* synthetic */ JSONObject a;
        final /* synthetic */ JSONArray b;
        final /* synthetic */ er2 c;
        final /* synthetic */ String d;

        a(JSONObject jSONObject, JSONArray jSONArray, er2 er2, String str) {
            this.a = jSONObject;
            this.b = jSONArray;
            this.c = er2;
            this.d = str;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public de doInBackground(Void... voidArr) {
            tr2.d("ParseResponseHelper", "parseCacheData async running");
            ParseResponseHelper parseResponseHelper = ParseResponseHelper.this;
            parseResponseHelper.e = parseResponseHelper.j(this.a, this.b);
            if (ParseResponseHelper.this.e != null) {
                this.c.g(this.d, ParseResponseHelper.this.e);
            }
            tr2.d("ParseResponseHelper", " parseCacheData done");
            return ParseResponseHelper.this.e;
        }
    }

    public ParseResponseHelper(a aVar) {
        this.a = aVar;
    }

    private String e(String str, Map<String, JSONObject> map) {
        JSONObject jSONObject = map.get(str);
        return jSONObject != null ? jSONObject.getString("containerType") : "native";
    }

    public static List<TemplateInfo> g(Context context, String str) {
        List<String> f = er2.d(context, str).f();
        tr2.d("ParseResponseHelper", "getTemplateInfo list:" + f);
        if (f == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(f.size());
        for (String str2 : f) {
            String[] split = str2.split("_\\$_");
            if (split.length >= 1) {
                arrayList.add(new TemplateInfo(split[0], split.length == 2 ? split[1] : null));
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private de j(JSONObject jSONObject, JSONArray jSONArray) {
        String key;
        String[] d2;
        JSONArray jSONArray2;
        de deVar = new de();
        if (!(jSONObject == null || jSONArray == null || jSONArray.isEmpty())) {
            HashMap hashMap = new HashMap();
            ArrayList arrayList = new ArrayList();
            JSONObject jSONObject2 = jSONObject.getJSONObject("container");
            if (!(jSONObject2 == null || (jSONArray2 = jSONObject2.getJSONArray("data")) == null)) {
                int size = jSONArray2.size();
                int i = 0;
                while (i < size) {
                    JSONObject jSONObject3 = jSONArray2.getJSONObject(i);
                    if (jSONObject3 != null) {
                        arrayList.add(new mc0(jSONObject3));
                        JSONArray jSONArray3 = jSONObject3.getJSONArray("type");
                        int size2 = jSONArray3.size();
                        int i2 = 0;
                        while (i2 < size2) {
                            String string = jSONArray3.getString(i2);
                            jSONObject3.toString();
                            hashMap.put(string, jSONObject3);
                            i2++;
                            jSONArray2 = jSONArray2;
                        }
                    }
                    i++;
                    jSONArray2 = jSONArray2;
                }
            }
            if (jSONArray.contains("container")) {
                deVar.f(arrayList);
                deVar.e(hashMap);
            }
            if (jSONArray.contains("data")) {
                HashMap hashMap2 = new HashMap();
                JSONObject jSONObject4 = jSONObject.getJSONObject("data");
                if (jSONObject4 != null) {
                    boolean h = h(lv1.FEATURE_TAG_ID);
                    for (Map.Entry<String, Object> entry : jSONObject4.entrySet()) {
                        if (!(entry == null || (key = entry.getKey()) == null)) {
                            Object value = entry.getValue();
                            if (value instanceof JSONObject) {
                                if (h && (d2 = c.d(key)) != null && d2.length == 2) {
                                    jSONObject.put("tag", (Object) d2[0]);
                                    jSONObject.put("id", (Object) d2[1]);
                                }
                                JSONObject jSONObject5 = (JSONObject) value;
                                String string2 = jSONObject5.getString("type");
                                String string3 = jSONObject5.getString("tag");
                                String e2 = e(string2, hashMap);
                                JSONObject jSONObject6 = hashMap.get(string2);
                                if (jSONObject6 != null) {
                                    tr2.b("ParseResponseHelper", "createDMComponent", "type", string2, "tag", string3);
                                }
                                hashMap2.put(key, new DMComponent(jSONObject5, e2, jSONObject6, m(jSONObject.getJSONObject("events"))));
                            }
                        }
                    }
                }
                deVar.d(hashMap2);
            }
        }
        return deVar;
    }

    private IDMEvent l(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.isEmpty()) {
            return null;
        }
        return new DMEvent(jSONObject.getString("type"), jSONObject.getJSONObject("fields"), null);
    }

    private Map<String, List<IDMEvent>> m(JSONObject jSONObject) {
        IDMEvent l;
        if (jSONObject == null || jSONObject.isEmpty()) {
            return null;
        }
        HashMap hashMap = new HashMap(jSONObject.size());
        for (Map.Entry<String, Object> entry : jSONObject.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (!TextUtils.isEmpty(key) && (value instanceof JSONArray)) {
                JSONArray jSONArray = (JSONArray) value;
                ArrayList arrayList = new ArrayList(jSONArray.size());
                Iterator<Object> it = jSONArray.iterator();
                while (it.hasNext()) {
                    Object next = it.next();
                    if ((next instanceof JSONObject) && (l = l((JSONObject) next)) != null) {
                        arrayList.add(l);
                    }
                }
                hashMap.put(key, arrayList);
            }
        }
        return hashMap;
    }

    public void d(String str, Object obj) {
        this.c.put(str, obj);
    }

    public Map<String, Object> f() {
        return this.c;
    }

    public boolean h(BigInteger bigInteger) {
        if (this.a.k() == null) {
            return false;
        }
        return lv1.a(new BigInteger(this.a.k()), bigInteger);
    }

    public boolean i() {
        return this.b;
    }

    public void k(JSONObject jSONObject, de deVar) {
        tr2.b("ParseResponseHelper", "parseDataWithCache");
        a aVar = this.a;
        if (!(aVar == null || jSONObject == null)) {
            b g = aVar.g();
            if (g == null) {
                g = new b(this.a.o);
                this.a.A(g);
            }
            if (deVar != null) {
                Map<String, DMComponent> a2 = deVar.a();
                List<mc0> c2 = deVar.c();
                Map<String, JSONObject> b2 = deVar.b();
                if (a2 != null) {
                    this.a.c().putAll(a2);
                    this.a.J("data");
                }
                if (c2 != null) {
                    this.a.H(c2);
                    this.a.J("container");
                    StringBuilder sb = new StringBuilder();
                    sb.append("template cache info: \n");
                    for (mc0 mc0 : c2) {
                        if (mc0 != null) {
                            sb.append(mc0.toString());
                            sb.append(";\n");
                        }
                    }
                    tr2.b("ParseResponseHelper", sb.toString());
                }
                if (b2 != null) {
                    this.a.I(b2);
                    this.a.J("container");
                }
            } else {
                this.a.J(null);
            }
            JSONObject jSONObject2 = jSONObject.getJSONObject("data");
            this.b = g.e(this.a, jSONObject2);
            this.c.put("protocolVersion", this.a.getProtocolVersion());
            if (jSONObject2 == null) {
                this.c.put("reload", Boolean.TRUE);
                return;
            }
            this.c.put("reload", Boolean.valueOf(Boolean.TRUE.toString().equalsIgnoreCase(jSONObject2.getString("reload"))));
        }
    }

    public void n(JSONObject jSONObject) {
        JSONObject jSONObject2;
        if (jSONObject != null && jSONObject.containsKey("endpoint") && (jSONObject2 = jSONObject.getJSONObject("endpoint")) != null) {
            String string = jSONObject2.getString("features");
            if (!TextUtils.isEmpty(string)) {
                this.a.E(string);
                tr2.b("ParseResponseHelper", "protocol features: " + string);
            }
        }
    }

    public void o(JSONObject jSONObject) {
        AsyncTask<Void, Void, de> asyncTask;
        long currentTimeMillis = System.currentTimeMillis();
        if (this.e == null && (asyncTask = this.d) != null) {
            try {
                asyncTask.get();
            } catch (Throwable th) {
                tr2.b("ParseResponseHelper", "parseCacheAsyncTask.get()", Log.getStackTraceString(th));
            }
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            tr2.d("ParseResponseHelper", "wait cacheDataResult time:" + currentTimeMillis2 + "ms");
        }
        long currentTimeMillis3 = System.currentTimeMillis();
        if (this.e != null) {
            k(jSONObject, this.e);
            long currentTimeMillis4 = System.currentTimeMillis() - currentTimeMillis3;
            tr2.d("ParseResponseHelper", "parseDataWithCache time:" + currentTimeMillis4 + "ms");
            return;
        }
        r(jSONObject);
        long currentTimeMillis5 = System.currentTimeMillis() - currentTimeMillis3;
        tr2.d("ParseResponseHelper", "parseResponseWithoutCache time:" + currentTimeMillis5 + "ms");
    }

    public void p(MtopResponse mtopResponse) {
        if (mtopResponse != null) {
            q(mtopResponse.getBytedata());
        }
    }

    public void q(byte[] bArr) {
        if (this.a != null && bArr != null) {
            o((JSONObject) JSON.parseObject(bArr, JSONObject.class, new Feature[0]));
        }
    }

    public void r(JSONObject jSONObject) {
        am2.e("ParseResponse", "start");
        a aVar = this.a;
        if (aVar != null && jSONObject != null) {
            b g = aVar.g();
            if (g == null) {
                g = new b(this.a.o);
                this.a.A(g);
            }
            JSONObject jSONObject2 = jSONObject.getJSONObject("data");
            this.b = g.e(this.a, jSONObject2);
            this.c.put("protocolVersion", this.a.getProtocolVersion());
            if (jSONObject2 == null) {
                this.c.put("reload", Boolean.TRUE);
                return;
            }
            this.c.put("reload", Boolean.valueOf(Boolean.TRUE.toString().equalsIgnoreCase(jSONObject2.getString("reload"))));
            am2.a("ParseResponse", "end");
        }
    }

    @SuppressLint({"StaticFieldLeak"})
    public void s(Context context, String str, final JSONObject jSONObject, boolean z, boolean z2) {
        final String str2;
        boolean z3;
        JSONObject jSONObject2;
        tr2.d("ParseResponseHelper", "processCache");
        if (jSONObject != null && z) {
            JSONObject jSONObject3 = null;
            JSONObject jSONObject4 = jSONObject.getJSONObject("endpoint");
            if (!(jSONObject4 == null || jSONObject4.isEmpty() || (jSONObject2 = jSONObject4.getJSONObject("meta")) == null)) {
                jSONObject3 = jSONObject2.getJSONObject(Constants.TEMPLATE);
            }
            if (jSONObject3 != null) {
                final er2 d2 = er2.d(context, str);
                boolean z4 = true;
                tr2.d("ParseResponseHelper", "processCache with cacheConfig:" + jSONObject3);
                final String string = jSONObject3.getString("id");
                final String string2 = jSONObject3.getString("version");
                if (string != null) {
                    if (string2 != null) {
                        str2 = string + "_$_" + string2;
                    } else {
                        str2 = string;
                    }
                    final JSONArray jSONArray = jSONObject3.getJSONArray("cacheFields");
                    tr2.d("ParseResponseHelper", "processCache templateKey:" + str2);
                    if (!TextUtils.isEmpty(str2) && jSONArray != null) {
                        Iterator<Object> it = jSONArray.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                if (!jSONObject.containsKey(it.next())) {
                                    z3 = true;
                                    break;
                                }
                            } else {
                                z3 = false;
                                break;
                            }
                        }
                        if (z3) {
                            JSONObject e2 = d2.e(str2);
                            if (e2 != null) {
                                Iterator<Object> it2 = jSONArray.iterator();
                                boolean z5 = false;
                                while (it2.hasNext()) {
                                    Object next = it2.next();
                                    if (!jSONObject.containsKey(next)) {
                                        Object obj = e2.get(next);
                                        if (obj != null) {
                                            jSONObject.put((String) next, obj);
                                        } else {
                                            z5 = true;
                                        }
                                    }
                                }
                                tr2.d("ParseResponseHelper", "processCache use cache");
                                z4 = z5;
                            }
                            if (z4) {
                                tr2.b("ParseResponseHelper", "processCache dataWrong");
                                d2.b(str2);
                            }
                        } else {
                            AsyncTask.THREAD_POOL_EXECUTOR.execute(new Runnable() {
                                /* class com.taobao.android.ultron.datamodel.imp.ParseResponseHelper.AnonymousClass1 */

                                public void run() {
                                    JSONObject jSONObject = new JSONObject();
                                    Iterator<Object> it = jSONArray.iterator();
                                    while (it.hasNext()) {
                                        Object next = it.next();
                                        jSONObject.put((String) next, jSONObject.get(next));
                                    }
                                    d2.h(str2, jSONObject);
                                    tr2.d("ParseResponseHelper", "processCache save cache");
                                    List<String> f = d2.f();
                                    if (f != null) {
                                        for (String str : new ArrayList(f)) {
                                            String[] split = str.split("_\\$_");
                                            if (split.length == 2 && TextUtils.equals(split[0], string) && !TextUtils.equals(split[1], string2)) {
                                                d2.b(str);
                                                d2.a(str);
                                                tr2.d("ParseResponseHelper", "processCache deleteTemplateById:" + str);
                                            }
                                        }
                                    }
                                }
                            });
                        }
                        if (z2) {
                            this.e = d2.c(str2);
                            if (this.e == null) {
                                a aVar = new a(jSONObject, jSONArray, d2, str2);
                                this.d = aVar;
                                aVar.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                            }
                        }
                    }
                }
            }
        }
    }
}
