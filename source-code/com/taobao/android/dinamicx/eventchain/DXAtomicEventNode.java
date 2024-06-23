package com.taobao.android.dinamicx.eventchain;

import android.os.Looper;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;
import com.taobao.analysis.v3.FalcoAbilitySpan;
import com.taobao.analysis.v3.FalcoBusinessSpan;
import com.taobao.analysis.v3.FalcoContainerSpan;
import com.taobao.analysis.v3.FalcoStage;
import com.taobao.android.abilitykit.AKBaseAbility;
import com.taobao.android.abilitykit.AKIAbilityCallback;
import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.monitor.DXTraceUtil;
import com.taobao.weex.bridge.WXBridgeManager;
import java.util.HashMap;
import java.util.Map;
import tb.at;
import tb.c00;
import tb.dz;
import tb.h;
import tb.k;
import tb.l;
import tb.m;
import tb.o70;
import tb.ox;
import tb.q;
import tb.ry;
import tb.sx;
import tb.t;
import tb.wz;

/* compiled from: Taobao */
public class DXAtomicEventNode {
    private String a = "";
    private Long b = -1L;
    private String c = "";
    private String d;
    private JSONObject e;
    private String f = "";
    private String g;
    private JSONObject h;
    private JSONObject i;
    private Map<String, String> j;
    private DXAtomicFTData k;
    private AKBaseAbility l;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class a extends TypeReference<Map<String, String>> {
        a(DXAtomicEventNode dXAtomicEventNode) {
        }
    }

    public DXAtomicEventNode(String str, Long l2) {
        this.a = str;
        this.b = l2;
    }

    private void e(JSONArray jSONArray, a aVar) {
        for (int i2 = 0; i2 < jSONArray.size(); i2++) {
            Object obj = jSONArray.get(i2);
            if (obj instanceof JSONObject) {
                f((JSONObject) obj, aVar);
            } else if (obj instanceof JSONArray) {
                e((JSONArray) obj, aVar);
            } else {
                jSONArray.set(i2, g(obj.toString(), aVar));
            }
        }
    }

    private void f(JSONObject jSONObject, a aVar) {
        for (Map.Entry<String, Object> entry : jSONObject.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof JSONObject) {
                f((JSONObject) value, aVar);
            } else if (value instanceof JSONArray) {
                e((JSONArray) value, aVar);
            } else {
                Object g2 = g(value.toString(), aVar);
                if (g2 == null) {
                    jSONObject.put(key, "");
                } else {
                    jSONObject.put(key, g2);
                }
            }
        }
    }

    private Object g(String str, a aVar) {
        return (!str.startsWith(o70.DINAMIC_PREFIX_AT) || !str.endsWith("}")) ? str : aVar.n().b(str).b(null, aVar.l());
    }

    private void i(JSONObject jSONObject, JSONObject jSONObject2) {
        for (Map.Entry<String, Object> entry : jSONObject.entrySet()) {
            Object value = entry.getValue();
            if (value instanceof JSONObject) {
                JSONObject jSONObject3 = new JSONObject();
                i((JSONObject) value, jSONObject3);
                jSONObject2.put(entry.getKey(), (Object) jSONObject3);
            } else if (value instanceof JSONArray) {
                JSONArray jSONArray = (JSONArray) value;
                JSONArray jSONArray2 = new JSONArray();
                int size = jSONArray.size();
                for (int i2 = 0; i2 < size; i2++) {
                    JSONObject jSONObject4 = new JSONObject();
                    Object obj = jSONArray.get(i2);
                    if (obj instanceof JSONObject) {
                        i((JSONObject) obj, jSONObject4);
                        jSONArray2.add(jSONObject4);
                    } else if ((obj instanceof String) || (obj instanceof Number)) {
                        jSONArray2.add(obj);
                    } else {
                        String jSONString = JSON.toJSONString(obj);
                        jSONArray2.add(JSON.parse(jSONString));
                        wz.b("命中deepClone else逻辑" + jSONString);
                    }
                }
                jSONObject2.put(entry.getKey(), (Object) jSONArray2);
            } else if (entry.getValue() != null) {
                jSONObject2.put(entry.getKey(), entry.getValue());
            }
        }
    }

    private JSONObject k(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        JSONObject jSONObject2 = new JSONObject();
        for (Map.Entry<String, Object> entry : jSONObject.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (!(value instanceof JSONObject) && !(value instanceof JSONArray)) {
                jSONObject2.put(key, value);
            }
        }
        return jSONObject2;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void l(a aVar) {
        ry.g("DXFullTrace", "EventChain finish");
        if (aVar != null) {
            dz.h(aVar.q());
            if (aVar.g() != null) {
                dz.l(aVar.g());
            }
            if (aVar.h() != null) {
                dz.l(aVar.h());
            }
            aVar.x(null);
            aVar.y(null);
        }
        aVar.c();
    }

    private FalcoAbilitySpan r(a aVar) {
        FalcoStage falcoStage;
        ry.f("DXFullTrace", "Atomic ftData is not null ", this.k);
        if (aVar == null || aVar.l() == null) {
            return null;
        }
        if (this.k.b() == "start") {
            FalcoBusinessSpan c2 = dz.c(aVar.l().getBizType(), this.k.d());
            if (c2 == null) {
                return null;
            }
            aVar.x(c2);
            dz.m(c2);
            dz.q(c2, "DXEventChain_ChainName", aVar.o());
            FalcoContainerSpan d2 = dz.d(c2.context(), "DX", this.k.d());
            aVar.y(d2);
            aVar.l().setOpenTracerSpan(d2);
            dz.m(d2);
            if (TextUtils.isEmpty(this.k.e())) {
                falcoStage = dz.f(d2);
            } else {
                falcoStage = dz.g(d2, this.k.c());
            }
            dz.r(falcoStage);
            aVar.F(falcoStage);
            FalcoAbilitySpan a2 = dz.a(d2.context(), "DX", "Atomic");
            dz.q(a2, "DXEventChain_AbilityName", this.a);
            dz.p(a2, "DXEventChain_AbilityType", this.b.longValue());
            return a2;
        } else if (this.k.b() != "finish") {
            return null;
        } else {
            dz.h(aVar.q());
            l(aVar);
            return null;
        }
    }

    private void s() {
        JSONObject jSONObject;
        if (this.j != null || this.i != null || this.k != null) {
            return;
        }
        if (TextUtils.isEmpty(this.d)) {
            ry.g("DXAtomicEventNode", "eventchain parse event info : atom event content is null");
            return;
        }
        JSONObject parseObject = JSON.parseObject(this.d);
        if (parseObject.containsKey(WXBridgeManager.METHOD_CALLBACK)) {
            this.j = (Map) JSON.parseObject(parseObject.getJSONObject(WXBridgeManager.METHOD_CALLBACK).toJSONString(), new a(this), new Feature[0]);
        }
        if (parseObject.containsKey("params")) {
            this.g = parseObject.getJSONObject("params").toJSONString();
        }
        if (parseObject.containsKey("ftData") && (jSONObject = parseObject.getJSONObject("ftData")) != null) {
            this.k = new DXAtomicFTData(jSONObject);
        }
    }

    private void t() {
        JSONObject jSONObject;
        if (TextUtils.isEmpty(this.d)) {
            ry.g("DXAtomicEventNode", "eventchain parse event info : atom event content is null");
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        i(this.e, jSONObject2);
        JSONObject jSONObject3 = jSONObject2.getJSONObject(WXBridgeManager.METHOD_CALLBACK);
        if (jSONObject3 != null) {
            this.j = new HashMap();
            for (Map.Entry<String, Object> entry : jSONObject3.entrySet()) {
                Map<String, String> map = this.j;
                String key = entry.getKey();
                map.put(key, entry.getValue() + "");
            }
        }
        if (jSONObject2.containsKey("params")) {
            this.h = jSONObject2.getJSONObject("params");
            this.g = jSONObject2.getJSONObject("params").toJSONString();
        }
        if (jSONObject2.containsKey("ftData") && (jSONObject = jSONObject2.getJSONObject("ftData")) != null) {
            this.k = new DXAtomicFTData(jSONObject);
        }
    }

    public DXAtomicEventNode h() {
        DXAtomicEventNode dXAtomicEventNode = new DXAtomicEventNode(this.a, this.b);
        dXAtomicEventNode.d = this.d;
        dXAtomicEventNode.c = this.c;
        dXAtomicEventNode.f = this.f;
        dXAtomicEventNode.e = this.e;
        return dXAtomicEventNode;
    }

    /* access modifiers changed from: protected */
    public sx j(final a aVar, final DXEventChainCallback dXEventChainCallback) {
        JSONObject jSONObject;
        t tVar;
        DXRuntimeContext l2;
        JSONObject jSONObject2;
        JSONObject jSONObject3;
        DXAtomicFTData dXAtomicFTData;
        if (aVar == null) {
            return sx.b(ox.EVENT_CHAIN_ERROR_ATOMIC_EXECUTE_CONTEXT_IS_NULL);
        }
        h d2 = aVar.d();
        if (d2 == null) {
            return sx.b(ox.EVENT_CHAIN_ERROR_ATOMIC_EXECUTE_ABILITY_IS_NULL);
        }
        DXTraceUtil.a(2, "DX-AtomicEvent-Start", " : ", this.a);
        ry.f("DXFullTrace", "execute ", this.a, this.g, this.j);
        FalcoAbilitySpan falcoAbilitySpan = null;
        DXTraceUtil.a(2, "DX-AtomicEvent-构造Node");
        if (at.k0()) {
            t();
        } else {
            s();
        }
        DXTraceUtil.d(2);
        if (at.k0()) {
            jSONObject = this.h;
        } else {
            jSONObject = JSON.parseObject(this.g);
        }
        DXTraceUtil.a(2, "DX-AtomicEvent-执行表达式");
        f(jSONObject, aVar);
        this.i = jSONObject;
        DXTraceUtil.d(2);
        if (!(aVar.g() == null || aVar.h() == null || (dXAtomicFTData = this.k) == null || TextUtils.isEmpty(dXAtomicFTData.e()))) {
            dz.h(aVar.q());
            FalcoStage g2 = dz.g(aVar.h(), this.k.c());
            dz.r(g2);
            aVar.F(g2);
        }
        if (!(aVar.g() == null || aVar.h() == null)) {
            falcoAbilitySpan = dz.b(dz.i(aVar.h()), "DX", "Atomic");
            dz.q(falcoAbilitySpan, "DXEventChain_AbilityName", this.a);
            DXAtomicFTData dXAtomicFTData2 = this.k;
            if (!(dXAtomicFTData2 == null || !dXAtomicFTData2.f() || (jSONObject3 = this.i) == null)) {
                dz.n(falcoAbilitySpan, JSON.toJSONString(jSONObject3));
            }
            DXAtomicFTData dXAtomicFTData3 = this.k;
            if (!(dXAtomicFTData3 == null || !dXAtomicFTData3.f() || (jSONObject2 = this.i) == null)) {
                dz.n(falcoAbilitySpan, JSON.toJSONString(jSONObject2));
            }
        }
        DXAtomicFTData dXAtomicFTData4 = this.k;
        if (dXAtomicFTData4 != null && !TextUtils.isEmpty(dXAtomicFTData4.b()) && !"none".equals(this.k.b()) && at.f0() && (l2 = aVar.l()) != null && l2.getEngineContext().b().n()) {
            falcoAbilitySpan = r(aVar);
        }
        ry.f("DXFullTrace", "atomic ", this.a, this.j);
        if (!(aVar.g() == null || aVar.h() == null || this.j == null)) {
            aVar.a();
        }
        JSONObject parseObject = JSON.parseObject(this.d);
        parseObject.put("params", (Object) jSONObject);
        if (falcoAbilitySpan != null) {
            dz.q(falcoAbilitySpan, "DXEventChain_AbilityParams", JSON.toJSONString(k(parseObject.getJSONObject("params"))));
        }
        if (at.k0()) {
            AKBaseAbility<q> c2 = d2.c(String.valueOf(this.b));
            this.l = c2;
            if (c2 == null) {
                DXTraceUtil.d(2);
                return sx.b(ox.EVENT_CHAIN_ERROR_ABILITY_IS_NULL);
            }
        } else if (this.l == null) {
            AKBaseAbility<q> c3 = d2.c(String.valueOf(this.b));
            this.l = c3;
            if (c3 == null) {
                DXTraceUtil.d(2);
                return sx.b(ox.EVENT_CHAIN_ERROR_ABILITY_IS_NULL);
            }
        }
        this.l.d(falcoAbilitySpan);
        dz.q(falcoAbilitySpan, "DXEventChain_AbilityType", this.l.getClass().getSimpleName());
        AKIAbilityCallback a2 = new AKIAbilityCallback() {
            /* class com.taobao.android.dinamicx.eventchain.DXAtomicEventNode.AnonymousClass1 */
            FalcoAbilitySpan a = null;

            public AKIAbilityCallback a(FalcoAbilitySpan falcoAbilitySpan) {
                this.a = falcoAbilitySpan;
                return this;
            }

            @Override // com.taobao.android.abilitykit.AKIAbilityCallback
            public void callback(final String str, final l lVar) {
                FalcoAbilitySpan falcoAbilitySpan;
                if (dXEventChainCallback == null || lVar == null) {
                    ry.g("DXAtomicEventNode", "eventchain callback is null or abilityExecuteResult is null [ " + DXAtomicEventNode.this.a);
                } else if (DXAtomicEventNode.this.j != null) {
                    aVar.J();
                    if (!(aVar.g() == null || aVar.h() == null || (falcoAbilitySpan = this.a) == null)) {
                        if (lVar instanceof k) {
                            dz.q(falcoAbilitySpan, "DXEventChain_AbilityResult", JSON.toJSONString(lVar));
                        }
                        if (DXAtomicEventNode.this.l != null && DXAtomicEventNode.this.l.e()) {
                            dz.l(this.a);
                        }
                    }
                    if (aVar.g() != null && aVar.h() != null && TextUtils.isEmpty(str) && aVar.t() <= 0) {
                        ry.g("DXFullTrace", "EvnetChian finish callback ", " ", DXAtomicEventNode.this.a);
                        DXAtomicEventNode.this.l(aVar);
                    }
                    if (aVar.u()) {
                        ry.b("DXAtomicEventNode", "eventchain callback: event cancle");
                    } else if (Looper.getMainLooper() == Looper.myLooper()) {
                        dXEventChainCallback.callback(new c(str, (String) DXAtomicEventNode.this.j.get(str)), sx.e(lVar));
                    } else {
                        c00.m(new Runnable() {
                            /* class com.taobao.android.dinamicx.eventchain.DXAtomicEventNode.AnonymousClass1.AnonymousClass1 */

                            public void run() {
                                AnonymousClass1 r0 = AnonymousClass1.this;
                                dXEventChainCallback.callback(new c(str, (String) DXAtomicEventNode.this.j.get(str)), sx.e(lVar));
                            }
                        });
                    }
                }
            }
        }.a(falcoAbilitySpan);
        if (!(aVar.g() == null || aVar.h() == null || falcoAbilitySpan == null || !(aVar.e() instanceof t) || (tVar = (t) aVar.e()) == null)) {
            tVar.h(falcoAbilitySpan);
        }
        l a3 = this.l.a(parseObject, aVar.e(), a2);
        if (!(this.j != null || aVar.g() == null || aVar.h() == null || falcoAbilitySpan == null)) {
            if (a3 instanceof k) {
                dz.q(falcoAbilitySpan, "DXEventChain_AbilityResult", JSON.toJSONString(a3));
            }
            if (!(a3 instanceof m)) {
                dz.l(falcoAbilitySpan);
            }
        }
        if (TextUtils.isEmpty(this.c) && aVar.t() <= 0 && aVar.g() != null && aVar.h() != null) {
            ry.g("DXFullTrace", "EvnetChian finish  ", this.a);
            l(aVar);
        }
        DXTraceUtil.d(2);
        return sx.e(a3);
    }

    public Map<String, String> m() {
        return this.j;
    }

    public String n() {
        return this.a;
    }

    public String o() {
        return this.c;
    }

    public JSONObject p() {
        return this.i;
    }

    public Long q() {
        return this.b;
    }

    public void u(String str) {
        this.d = str;
        if (!TextUtils.isEmpty(str)) {
            this.e = JSON.parseObject(this.d);
        }
    }

    public void v(String str) {
        this.f = str;
    }

    public void w(String str) {
        this.c = str;
    }
}
