package com.taobao.monitor.network;

import com.taobao.monitor.procedure.ProcedureImpl;
import com.taobao.monitor.procedure.f;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
import tb.t91;
import tb.td2;
import tb.te0;
import tb.uu0;
import tb.wh1;
import tb.zb;

/* compiled from: Taobao */
public class a implements ProcedureImpl.IProcedureLifeCycle {
    public static String a(f fVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("version", uu0.a);
            jSONObject.put("topic", fVar.v());
            jSONObject.put("headers", b(fVar));
            jSONObject.put("value", g(fVar));
        } catch (Exception e) {
            e.printStackTrace();
        }
        String jSONObject2 = jSONObject.toString();
        t91.d("ProcedureLifecycleImpl", jSONObject2);
        return jSONObject2;
    }

    private static JSONObject b(f fVar) throws Exception {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("X-timestamp", fVar.u()).put("X-appId", uu0.b).put("X-appKey", uu0.c).put("X-appBuild", uu0.d).put("X-appPatch", uu0.f).put("X-channel", uu0.g).put("X-utdid", uu0.h).put("X-brand", uu0.i).put("X-deviceModel", uu0.j).put("X-os", uu0.k).put("X-osVersion", uu0.l).put("X-userId", uu0.m).put("X-userNick", uu0.n).put("X-session", uu0.o).put("X-processName", uu0.p).put("X-appVersion", uu0.e).put("X-launcherMode", uu0.r);
        return jSONObject;
    }

    private static void c(JSONObject jSONObject, Map<String, ?> map) throws Exception {
        d(jSONObject, map, 2);
    }

    private static void d(JSONObject jSONObject, Map<String, ?> map, int i) throws Exception {
        if (map != null && i > 0) {
            for (Map.Entry<String, ?> entry : map.entrySet()) {
                f(jSONObject, entry.getKey(), entry.getValue(), i);
            }
        }
    }

    private static void e(JSONObject jSONObject, String str, Object obj) throws Exception {
        f(jSONObject, str, obj, 2);
    }

    private static void f(JSONObject jSONObject, String str, Object obj, int i) throws Exception {
        if (obj instanceof Integer) {
            jSONObject.put(str, ((Integer) obj).intValue());
        } else if (obj instanceof Long) {
            jSONObject.put(str, ((Long) obj).longValue());
        } else if (obj instanceof Float) {
            jSONObject.put(str, (double) ((Float) obj).floatValue());
        } else if (obj instanceof Double) {
            jSONObject.put(str, ((Double) obj).doubleValue());
        } else if (obj instanceof Boolean) {
            jSONObject.put(str, ((Boolean) obj).booleanValue());
        } else if (obj instanceof Character) {
            jSONObject.put(str, ((Character) obj).charValue());
        } else if (obj instanceof Short) {
            jSONObject.put(str, ((Short) obj).shortValue());
        } else if (obj instanceof Map) {
            Map map = (Map) obj;
            if (map.size() != 0) {
                JSONObject jSONObject2 = new JSONObject();
                d(jSONObject2, map, i - 1);
                jSONObject.put(str, jSONObject2);
            }
        } else {
            jSONObject.put(str, obj);
        }
    }

    private static JSONObject g(f fVar) throws Exception {
        boolean z;
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        Map<String, Object> m = fVar.m();
        if (m == null || m.size() == 0) {
            z = false;
        } else {
            for (Map.Entry<String, Object> entry : m.entrySet()) {
                e(jSONObject2, entry.getKey(), entry.getValue());
            }
            z = true;
        }
        List<zb> h = fVar.h();
        if (!(h == null || h.size() == 0)) {
            JSONObject jSONObject3 = new JSONObject();
            for (zb zbVar : h) {
                Map<String, Object> f = zbVar.f();
                JSONObject jSONObject4 = new JSONObject();
                if (!(f == null || f.size() == 0)) {
                    c(jSONObject4, f);
                }
                Map<String, Object> a = zbVar.a();
                if (!(a == null || a.size() == 0)) {
                    JSONObject jSONObject5 = new JSONObject();
                    c(jSONObject5, a);
                    jSONObject4.put("abtest", jSONObject5);
                }
                Map<String, Object> g = zbVar.g();
                if (!(g == null || g.size() == 0)) {
                    JSONObject jSONObject6 = new JSONObject();
                    c(jSONObject6, g);
                    jSONObject4.put("stages", jSONObject6);
                }
                jSONObject3.put(zbVar.e(), jSONObject4);
            }
            jSONObject2.put("bizTags", jSONObject3);
            t91.a("ProcedureLifecycleImpl", "properties", jSONObject2);
            z = true;
        }
        if (z) {
            jSONObject.put("properties", jSONObject2);
        }
        Map<String, Object> r = fVar.r();
        JSONObject jSONObject7 = new JSONObject();
        if (!(r == null || r.size() == 0)) {
            c(jSONObject7, r);
        }
        Map<String, Integer> i = fVar.i();
        if (!(i == null || i.size() == 0)) {
            c(jSONObject7, i);
        }
        if (!(i.size() == 0 && r.size() == 0)) {
            jSONObject.put("stats", jSONObject7);
            t91.a("ProcedureLifecycleImpl", "stats", jSONObject7);
        }
        List<te0> k = fVar.k();
        if (!(k == null || k.size() == 0)) {
            JSONArray jSONArray = new JSONArray();
            for (te0 te0 : k) {
                JSONObject jSONObject8 = new JSONObject();
                jSONObject8.put("timestamp", te0.c());
                jSONObject8.put("name", te0.a());
                c(jSONObject8, te0.b());
                jSONArray.put(jSONObject8);
            }
            jSONObject.put("events", jSONArray);
            t91.a("ProcedureLifecycleImpl", "events", jSONArray);
        }
        List<td2> q = fVar.q();
        if (!(q == null || q.size() == 0)) {
            JSONObject jSONObject9 = new JSONObject();
            for (td2 td2 : q) {
                jSONObject9.put(td2.a(), td2.b());
            }
            jSONObject.put("stages", jSONObject9);
            t91.a("ProcedureLifecycleImpl", "stages", jSONObject9);
        }
        List<f> s = fVar.s();
        if (!(s == null || s.size() == 0)) {
            JSONArray jSONArray2 = new JSONArray();
            for (f fVar2 : s) {
                JSONObject g2 = g(fVar2);
                JSONObject jSONObject10 = new JSONObject();
                jSONObject10.put(fVar2.v(), g2);
                jSONArray2.put(jSONObject10);
            }
            jSONObject.put("subProcedures", jSONArray2);
            t91.a("ProcedureLifecycleImpl", "subProcedures", jSONArray2);
        }
        return jSONObject;
    }

    @Override // com.taobao.monitor.procedure.ProcedureImpl.IProcedureLifeCycle
    public void begin(f fVar) {
    }

    @Override // com.taobao.monitor.procedure.ProcedureImpl.IProcedureLifeCycle
    public void end(f fVar) {
        wh1.b().send(fVar.v(), a(fVar));
    }

    @Override // com.taobao.monitor.procedure.ProcedureImpl.IProcedureLifeCycle
    public void event(f fVar, te0 te0) {
    }

    @Override // com.taobao.monitor.procedure.ProcedureImpl.IProcedureLifeCycle
    public void stage(f fVar, td2 td2) {
    }
}
