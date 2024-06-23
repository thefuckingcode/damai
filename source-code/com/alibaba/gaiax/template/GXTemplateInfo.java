package com.alibaba.gaiax.template;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.gaiax.GXTemplateEngine;
import com.alibaba.poplayer.trigger.view.TrackingService;
import com.youku.arch.v3.core.Constants;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.b;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.ar0;
import tb.hp0;
import tb.k21;
import tb.m40;
import tb.no0;
import tb.oo0;
import tb.po0;
import tb.qo0;
import tb.ur2;
import tb.v;
import tb.vq0;
import tb.wn0;
import tb.xo0;
import tb.yo0;
import tb.zo0;

/* compiled from: Taobao */
public final class GXTemplateInfo {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final hp0 a;
    @NotNull
    private final Map<String, no0> b;
    @Nullable
    private final Map<String, po0> c;
    @Nullable
    private final Map<String, xo0> d;
    @Nullable
    private final Map<String, ar0> e;
    @Nullable
    private final Map<String, wn0> f;
    @Nullable
    private final Map<String, GXIExpression> g;
    @Nullable
    private final String h;
    @Nullable
    private String i;
    @Nullable
    private List<GXTemplateInfo> j;
    public vq0 k;
    public JSONObject l;
    public JSONObject m;
    @NotNull
    private final Lazy n = b.b(new GXTemplateInfo$isJsExist$2(this));

    /* compiled from: Taobao */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(m40 m40) {
            this();
        }

        private final Map<String, wn0> a(String str, JSONObject jSONObject) {
            wn0 a;
            if (jSONObject.isEmpty()) {
                return null;
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry entry : jSONObject.entrySet()) {
                String str2 = (String) entry.getKey();
                Object value = entry.getValue();
                if (!(str2 == null || value == null)) {
                    if ((str2.length() > 0) && (value instanceof JSONObject) && (a = wn0.Companion.a(str, (JSONObject) value)) != null) {
                        linkedHashMap.put(str2, a);
                    }
                }
            }
            return linkedHashMap;
        }

        private final Map<String, GXIExpression> b(String str, JSONObject jSONObject) {
            GXIExpression b;
            if (jSONObject.isEmpty()) {
                return null;
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry entry : jSONObject.entrySet()) {
                String str2 = (String) entry.getKey();
                Object value = entry.getValue();
                if (!(str2 == null || value == null)) {
                    if ((str2.length() > 0) && (b = yo0.INSTANCE.b(str, value)) != null) {
                        linkedHashMap.put(str2, b);
                    }
                }
            }
            return linkedHashMap;
        }

        private final Map<String, no0> c(Map<String, no0> map, JSONObject jSONObject, hp0 hp0) {
            String d = hp0.d();
            JSONObject jSONObject2 = jSONObject.getJSONObject(hp0.a());
            if (jSONObject2 == null) {
                jSONObject2 = new JSONObject();
            }
            JSONObject jSONObject3 = jSONObject.getJSONObject(d);
            if (jSONObject3 == null) {
                jSONObject3 = new JSONObject();
            }
            if ((!jSONObject2.isEmpty()) || (!jSONObject3.isEmpty())) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.putAll(jSONObject2);
                jSONObject4.putAll(jSONObject3);
                map.put(d, no0.Companion.a(jSONObject4));
            }
            Iterator<T> it = hp0.e().iterator();
            while (it.hasNext()) {
                GXTemplateInfo.Companion.c(map, jSONObject, it.next());
            }
            return map;
        }

        private final Map<String, no0> d(hp0 hp0, JSONObject jSONObject) {
            return c(new LinkedHashMap(), jSONObject, hp0);
        }

        private final Map<String, po0> e(String str, JSONObject jSONObject) {
            po0 a;
            if (jSONObject.isEmpty()) {
                return null;
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry entry : jSONObject.entrySet()) {
                String str2 = (String) entry.getKey();
                Object value = entry.getValue();
                if (!(str2 == null || value == null || (a = qo0.INSTANCE.a(str, value)) == null)) {
                    linkedHashMap.put(str2, a);
                }
            }
            return linkedHashMap;
        }

        private final Map<String, xo0> f(String str, JSONObject jSONObject) {
            GXIExpression b;
            if (jSONObject.isEmpty()) {
                return null;
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry entry : jSONObject.entrySet()) {
                String str2 = (String) entry.getKey();
                Object value = entry.getValue();
                if (!(str2 == null || value == null)) {
                    if ((str2.length() > 0) && (b = yo0.INSTANCE.b(str, value)) != null) {
                        linkedHashMap.put(str2, new xo0(b));
                    }
                }
            }
            return linkedHashMap;
        }

        private final GXTemplateInfo h(vq0 vq0) {
            JSONObject k = zo0.k(vq0.f());
            if (!k.isEmpty()) {
                JSONObject e = oo0.Companion.a().e(vq0.b());
                JSONObject k2 = zo0.k(vq0.c());
                String e2 = vq0.e();
                JSONObject jSONObject = k2.getJSONObject("data");
                if (jSONObject == null) {
                    jSONObject = new JSONObject();
                }
                JSONObject jSONObject2 = k2.getJSONObject("event");
                if (jSONObject2 == null) {
                    jSONObject2 = new JSONObject();
                }
                JSONObject jSONObject3 = k2.getJSONObject(TrackingService.OPER_TRACK);
                if (jSONObject3 == null) {
                    jSONObject3 = new JSONObject();
                }
                JSONObject jSONObject4 = k2.getJSONObject(Constants.CONFIG);
                if (jSONObject4 == null) {
                    jSONObject4 = new JSONObject();
                }
                JSONObject jSONObject5 = k2.getJSONObject(v.TAK_ABILITY_SHOW_POP_ANIMATION);
                if (jSONObject5 == null) {
                    jSONObject5 = new JSONObject();
                }
                String string = k.getString("exp-version");
                hp0 a = hp0.Companion.a(k);
                Map<String, no0> d = d(a, e);
                Map<String, po0> e3 = e(string, jSONObject);
                Map<String, xo0> f = f(string, jSONObject2);
                Map<String, ar0> i = i(string, jSONObject3);
                Map<String, GXIExpression> b = b(string, jSONObject4);
                Map<String, wn0> a2 = a(string, jSONObject5);
                if (e2.length() == 0) {
                    e2 = null;
                }
                GXTemplateInfo gXTemplateInfo = new GXTemplateInfo(a, d, e3, f, i, a2, b, e2);
                gXTemplateInfo.A(vq0);
                gXTemplateInfo.x(e);
                gXTemplateInfo.y(k2);
                gXTemplateInfo.z(k);
                gXTemplateInfo.w(jSONObject4);
                gXTemplateInfo.v(string);
                return gXTemplateInfo;
            }
            throw new IllegalArgumentException("Template layer mustn't empty");
        }

        private final Map<String, ar0> i(String str, JSONObject jSONObject) {
            GXIExpression b;
            if (jSONObject.isEmpty()) {
                return null;
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry entry : jSONObject.entrySet()) {
                String str2 = (String) entry.getKey();
                Object value = entry.getValue();
                if (!(str2 == null || value == null)) {
                    if ((str2.length() > 0) && (b = yo0.INSTANCE.b(str, value)) != null) {
                        linkedHashMap.put(str2, new ar0(b));
                    }
                }
            }
            return linkedHashMap;
        }

        private final void j(hp0 hp0, Function1<? super hp0, ur2> function1) {
            for (T t : hp0.e()) {
                if (t.s()) {
                    function1.invoke(t);
                }
                GXTemplateInfo.Companion.j(t, function1);
            }
        }

        private final void k(GXTemplateInfo gXTemplateInfo, GXTemplateEngine.h hVar) {
            j(gXTemplateInfo.o(), new GXTemplateInfo$Companion$initChildren$1(hVar, gXTemplateInfo));
        }

        @NotNull
        public final GXTemplateInfo g(@NotNull GXTemplateEngine.h hVar) {
            k21.i(hVar, "templateItem");
            GXTemplateInfo h = h(GXTemplateEngine.Companion.a().l().d().getTemplate(hVar));
            GXTemplateInfo.Companion.k(h, hVar);
            return h;
        }

        @NotNull
        public final JSONObject l(@NotNull String str) {
            k21.i(str, "value");
            return oo0.Companion.a().e(str);
        }

        @NotNull
        public final JSONObject m(@NotNull String str) {
            k21.i(str, "value");
            return zo0.k(str);
        }

        @NotNull
        public final JSONObject n(@NotNull String str) {
            k21.i(str, "value");
            return zo0.k(str);
        }
    }

    public GXTemplateInfo(@NotNull hp0 hp0, @NotNull Map<String, no0> map, @Nullable Map<String, po0> map2, @Nullable Map<String, xo0> map3, @Nullable Map<String, ar0> map4, @Nullable Map<String, wn0> map5, @Nullable Map<String, GXIExpression> map6, @Nullable String str) {
        k21.i(hp0, "layer");
        k21.i(map, "css");
        this.a = hp0;
        this.b = map;
        this.c = map2;
        this.d = map3;
        this.e = map4;
        this.f = map5;
        this.g = map6;
        this.h = str;
    }

    /* access modifiers changed from: private */
    public final boolean b() {
        Boolean bool;
        String str = this.h;
        if (str == null) {
            bool = null;
        } else {
            bool = Boolean.valueOf(str.length() > 0);
        }
        if (k21.d(bool, Boolean.TRUE)) {
            return true;
        }
        List<GXTemplateInfo> list = this.j;
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (it.next().b()) {
                    return true;
                }
            }
        }
        return false;
    }

    private final hp0 h(String str, hp0 hp0) {
        if (k21.d(str, hp0.d())) {
            return hp0;
        }
        Iterator<T> it = hp0.e().iterator();
        while (it.hasNext()) {
            hp0 h2 = h(str, it.next());
            if (h2 != null) {
                return h2;
            }
        }
        return null;
    }

    public final void A(@NotNull vq0 vq0) {
        k21.i(vq0, "<set-?>");
        this.k = vq0;
    }

    @Nullable
    public final wn0 c(@NotNull String str) {
        k21.i(str, "id");
        Map<String, wn0> map = this.f;
        if (map == null) {
            return null;
        }
        return map.get(str);
    }

    @Nullable
    public final no0 d(@NotNull String str) {
        k21.i(str, "id");
        return this.b.get(str);
    }

    @Nullable
    public final po0 e(@NotNull String str) {
        k21.i(str, "id");
        Map<String, po0> map = this.c;
        if (map == null) {
            return null;
        }
        return map.get(str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GXTemplateInfo)) {
            return false;
        }
        GXTemplateInfo gXTemplateInfo = (GXTemplateInfo) obj;
        return k21.d(this.a, gXTemplateInfo.a) && k21.d(this.b, gXTemplateInfo.b) && k21.d(this.c, gXTemplateInfo.c) && k21.d(this.d, gXTemplateInfo.d) && k21.d(this.e, gXTemplateInfo.e) && k21.d(this.f, gXTemplateInfo.f) && k21.d(this.g, gXTemplateInfo.g) && k21.d(this.h, gXTemplateInfo.h);
    }

    @Nullable
    public final xo0 f(@NotNull String str) {
        k21.i(str, "id");
        Map<String, xo0> map = this.d;
        if (map == null) {
            return null;
        }
        return map.get(str);
    }

    @Nullable
    public final hp0 g(@NotNull String str) {
        k21.i(str, "id");
        return h(str, this.a);
    }

    public int hashCode() {
        int hashCode = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        Map<String, po0> map = this.c;
        int i2 = 0;
        int hashCode2 = (hashCode + (map == null ? 0 : map.hashCode())) * 31;
        Map<String, xo0> map2 = this.d;
        int hashCode3 = (hashCode2 + (map2 == null ? 0 : map2.hashCode())) * 31;
        Map<String, ar0> map3 = this.e;
        int hashCode4 = (hashCode3 + (map3 == null ? 0 : map3.hashCode())) * 31;
        Map<String, wn0> map4 = this.f;
        int hashCode5 = (hashCode4 + (map4 == null ? 0 : map4.hashCode())) * 31;
        Map<String, GXIExpression> map5 = this.g;
        int hashCode6 = (hashCode5 + (map5 == null ? 0 : map5.hashCode())) * 31;
        String str = this.h;
        if (str != null) {
            i2 = str.hashCode();
        }
        return hashCode6 + i2;
    }

    @Nullable
    public final ar0 i(@NotNull String str) {
        k21.i(str, "id");
        Map<String, ar0> map = this.e;
        if (map == null) {
            return null;
        }
        return map.get(str);
    }

    @Nullable
    public final GXTemplateInfo j(@NotNull String str) {
        k21.i(str, "id");
        List<GXTemplateInfo> list = this.j;
        if (list == null) {
            return null;
        }
        for (T t : list) {
            if (k21.d(t.o().d(), str)) {
                return t;
            }
        }
        return null;
    }

    @Nullable
    public final List<GXTemplateInfo> k() {
        return this.j;
    }

    @NotNull
    public final JSONObject l(@Nullable JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        Map<String, GXIExpression> map = this.g;
        if (map != null) {
            for (Map.Entry<String, GXIExpression> entry : map.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue().value(jSONObject);
                if (value == null) {
                    value = "";
                }
                jSONObject2.put((Object) key, value);
            }
        }
        return jSONObject2;
    }

    @Nullable
    public final String m() {
        return this.i;
    }

    @Nullable
    public final String n() {
        return this.h;
    }

    @NotNull
    public final hp0 o() {
        return this.a;
    }

    @NotNull
    public final JSONObject p() {
        JSONObject jSONObject = this.m;
        if (jSONObject != null) {
            return jSONObject;
        }
        k21.A("rawConfigJson");
        return null;
    }

    @NotNull
    public final JSONObject q() {
        JSONObject jSONObject = this.l;
        if (jSONObject != null) {
            return jSONObject;
        }
        k21.A("rawDataBindingJson");
        return null;
    }

    @NotNull
    public final vq0 r() {
        vq0 vq0 = this.k;
        if (vq0 != null) {
            return vq0;
        }
        k21.A(com.youku.arch.v3.data.Constants.TEMPLATE);
        return null;
    }

    public final boolean s() {
        return ((Boolean) this.n.getValue()).booleanValue();
    }

    public final boolean t() {
        return k21.d(this.a.k(), "gaia-template");
    }

    @NotNull
    public String toString() {
        return "GXTemplateInfo(layer=" + this.a + ", css=" + this.b + ", data=" + this.c + ", event=" + this.d + ", track=" + this.e + ", animation=" + this.f + ", config=" + this.g + ", js=" + ((Object) this.h) + ')';
    }

    public final void u(@Nullable List<GXTemplateInfo> list) {
        this.j = list;
    }

    public final void v(@Nullable String str) {
        this.i = str;
    }

    public final void w(@NotNull JSONObject jSONObject) {
        k21.i(jSONObject, "<set-?>");
        this.m = jSONObject;
    }

    public final void x(@NotNull JSONObject jSONObject) {
        k21.i(jSONObject, "<set-?>");
    }

    public final void y(@NotNull JSONObject jSONObject) {
        k21.i(jSONObject, "<set-?>");
        this.l = jSONObject;
    }

    public final void z(@NotNull JSONObject jSONObject) {
        k21.i(jSONObject, "<set-?>");
    }
}
