package tb;

import android.util.Log;
import android.view.View;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.gaiax.GXTemplateEngine;
import com.alibaba.gaiax.render.node.GXINodeEvent;
import com.alibaba.gaiax.template.GXIExpression;
import com.youku.gaiax.api.data.EventParams;
import java.util.Iterator;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class xp0 implements GXINodeEvent {
    /* access modifiers changed from: private */
    public static final void c(wq0 wq0, up0 up0, JSONObject jSONObject, String str, Object obj, View view) {
        GXTemplateEngine.g j;
        GXTemplateEngine.GXITrackListener f;
        GXIExpression a;
        GXTemplateEngine.GXIEventListener c;
        k21.i(wq0, "$gxTemplateContext");
        k21.i(up0, "$gxNode");
        k21.i(jSONObject, "$templateData");
        k21.i(str, "$eventType");
        GXTemplateEngine.g j2 = wq0.j();
        if (!(j2 == null || (c = j2.c()) == null)) {
            GXTemplateEngine.d dVar = new GXTemplateEngine.d();
            dVar.setGestureType(str);
            dVar.setView(up0.p());
            k21.h(obj, "eventData");
            dVar.setEventParams((JSONObject) obj);
            dVar.setNodeId(up0.n().n().d());
            dVar.setTemplateItem(wq0.l());
            dVar.setIndex(-1);
            ur2 ur2 = ur2.INSTANCE;
            c.onGestureEvent(dVar);
        }
        ar0 q = up0.n().q();
        JSONObject jSONObject2 = null;
        Object value = (q == null || (a = q.a()) == null) ? null : a.value(jSONObject);
        if (value instanceof JSONObject) {
            jSONObject2 = (JSONObject) value;
        }
        if (jSONObject2 != null && (j = wq0.j()) != null && (f = j.f()) != null) {
            GXTemplateEngine.j jVar = new GXTemplateEngine.j();
            jVar.i(up0.p());
            jVar.h(jSONObject2);
            jVar.f(up0.n().n().d());
            jVar.g(wq0.l());
            jVar.e(-1);
            ur2 ur22 = ur2.INSTANCE;
            f.onManualClickTrackEvent(jVar);
        }
    }

    /* access modifiers changed from: private */
    public static final boolean d(wq0 wq0, up0 up0, JSONObject jSONObject, String str, Object obj, View view) {
        GXTemplateEngine.g j;
        GXTemplateEngine.GXITrackListener f;
        GXIExpression a;
        GXTemplateEngine.GXIEventListener c;
        k21.i(wq0, "$gxTemplateContext");
        k21.i(up0, "$gxNode");
        k21.i(jSONObject, "$templateData");
        k21.i(str, "$eventType");
        GXTemplateEngine.g j2 = wq0.j();
        if (!(j2 == null || (c = j2.c()) == null)) {
            GXTemplateEngine.d dVar = new GXTemplateEngine.d();
            dVar.setGestureType(str);
            dVar.setView(up0.p());
            k21.h(obj, "eventData");
            dVar.setEventParams((JSONObject) obj);
            dVar.setNodeId(up0.n().n().d());
            dVar.setTemplateItem(wq0.l());
            dVar.setIndex(-1);
            ur2 ur2 = ur2.INSTANCE;
            c.onGestureEvent(dVar);
        }
        ar0 q = up0.n().q();
        JSONObject jSONObject2 = null;
        Object value = (q == null || (a = q.a()) == null) ? null : a.value(jSONObject);
        if (value instanceof JSONObject) {
            jSONObject2 = (JSONObject) value;
        }
        if (jSONObject2 == null || (j = wq0.j()) == null || (f = j.f()) == null) {
            return true;
        }
        GXTemplateEngine.j jVar = new GXTemplateEngine.j();
        jVar.i(up0.p());
        jVar.h(jSONObject2);
        jVar.f(up0.n().n().d());
        jVar.g(wq0.l());
        jVar.e(-1);
        ur2 ur22 = ur2.INSTANCE;
        f.onManualClickTrackEvent(jVar);
        return true;
    }

    @Override // com.alibaba.gaiax.render.node.GXINodeEvent
    public void addDataBindingEvent(@NotNull wq0 wq0, @NotNull up0 up0, @NotNull JSONObject jSONObject) {
        k21.i(wq0, "gxTemplateContext");
        k21.i(up0, "gxNode");
        k21.i(jSONObject, "templateData");
        xo0 g = up0.n().g();
        if (g != null) {
            Object value = g.a().value(jSONObject);
            JSONArray jSONArray = null;
            JSON json = value instanceof JSON ? (JSON) value : null;
            if (json != null) {
                if (json instanceof JSONObject) {
                    jSONArray = new JSONArray();
                    jSONArray.add(json);
                } else if (json instanceof JSONArray) {
                    jSONArray = (JSONArray) json;
                }
                if (jSONArray != null) {
                    Iterator<Object> it = jSONArray.iterator();
                    while (it.hasNext()) {
                        Object next = it.next();
                        if (next instanceof JSONObject) {
                            String string = ((JSONObject) next).getString("type");
                            String str = string == null ? EventParams.CLICK_TYPE_TAP : string;
                            if (k21.d(str, EventParams.CLICK_TYPE_TAP)) {
                                View p = up0.p();
                                if (p != null) {
                                    p.setOnClickListener(new vp0(wq0, up0, jSONObject, str, next));
                                }
                            } else if (k21.d(str, "longpress")) {
                                View p2 = up0.p();
                                if (p2 != null) {
                                    p2.setOnLongClickListener(new wp0(wq0, up0, jSONObject, str, next));
                                }
                            } else {
                                Log.e("[GaiaX]", k21.r("unknown event type ", str));
                            }
                        }
                    }
                }
            }
        }
    }
}
