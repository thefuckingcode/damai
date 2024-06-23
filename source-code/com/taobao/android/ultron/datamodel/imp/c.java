package com.taobao.android.ultron.datamodel.imp;

import android.text.TextUtils;
import com.alibaba.android.umbrella.trace.UmbrellaTracker;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.taobao.android.ultron.common.model.IDMComponent;
import com.taobao.android.ultron.common.model.IDMEvent;
import com.taobao.android.ultron.common.model.LinkageType;
import com.taobao.weex.annotation.JSMethod;
import com.youku.arch.v3.view.render.RenderConstant;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import tb.lv1;
import tb.mc0;
import tb.tr2;

/* compiled from: Taobao */
public class c {
    private static String c = "CardGroupTag";
    private static String d = "PositionTag";
    private IDMComponent a;
    boolean b = false;

    private DMComponent a(a aVar, JSONObject jSONObject, String str) {
        String[] d2;
        if (jSONObject == null) {
            return null;
        }
        if (str != null && this.b && (d2 = d(str)) != null && d2.length == 2) {
            jSONObject.put("tag", (Object) d2[0]);
            jSONObject.put("id", (Object) d2[1]);
        }
        String string = jSONObject.getString("type");
        String string2 = jSONObject.getString("tag");
        String h = h(aVar, string);
        JSONObject g = g(aVar, string);
        if (g != null) {
            tr2.b("ParseModule", "createDMComponent", "type", string, "tag", string2);
        }
        return new DMComponent(jSONObject, h, g, q(aVar, jSONObject.getJSONObject("events")));
    }

    private void b(a aVar) {
        Map<String, DMComponent> c2 = aVar.c();
        JSONArray m = aVar.m();
        if (m == null) {
            m = new JSONArray();
            aVar.j().put("request", (Object) m);
        }
        Iterator<Object> it = m.iterator();
        while (it.hasNext()) {
            DMComponent dMComponent = c2.get((String) it.next());
            if (dMComponent != null) {
                dMComponent.setLinkageType(LinkageType.REQUEST);
            }
        }
    }

    private String c(IDMComponent iDMComponent, IDMComponent iDMComponent2) {
        String key = (iDMComponent == null || iDMComponent.getFields() == null || !"true".equals(iDMComponent.getCardGroup())) ? null : iDMComponent.getKey();
        return (iDMComponent2 == null || iDMComponent2.getExtMap() == null || iDMComponent2.getExtMap().get(c) == null || TextUtils.isEmpty(String.valueOf(iDMComponent2.getExtMap().get(c)))) ? key : (String) iDMComponent2.getExtMap().get(c);
    }

    public static String[] d(String str) {
        int indexOf;
        if (!TextUtils.isEmpty(str) && (indexOf = str.indexOf(JSMethod.NOT_SET)) > 0 && indexOf < str.length() - 1) {
            return new String[]{str.substring(0, indexOf), str.substring(indexOf + 1, str.length())};
        }
        return null;
    }

    public static String e(IDMComponent iDMComponent) {
        Object obj;
        if (iDMComponent == null || iDMComponent.getExtMap() == null || (obj = iDMComponent.getExtMap().get(d)) == null) {
            return null;
        }
        return String.valueOf(obj);
    }

    private JSONObject g(a aVar, String str) {
        return aVar.o().get(str);
    }

    private String h(a aVar, String str) {
        JSONObject jSONObject = aVar.o().get(str);
        return jSONObject != null ? jSONObject.getString("containerType") : "native";
    }

    private List<IDMComponent> i(List<IDMComponent> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (IDMComponent iDMComponent : list) {
            if (l(iDMComponent)) {
                arrayList.add(iDMComponent);
            }
        }
        return arrayList;
    }

    private String j(IDMComponent iDMComponent, IDMComponent iDMComponent2) {
        String position = (iDMComponent == null || iDMComponent.getFields() == null || iDMComponent.getPosition() == null) ? null : iDMComponent.getPosition();
        return (iDMComponent2 == null || iDMComponent2.getExtMap() == null || iDMComponent2.getExtMap().get(d) == null || TextUtils.isEmpty(String.valueOf(iDMComponent2.getExtMap().get(d)))) ? position : (String) iDMComponent2.getExtMap().get(d);
    }

    private boolean l(IDMComponent iDMComponent) {
        return (iDMComponent == null || iDMComponent.getStatus() == 0 || iDMComponent.getFields() == null || iDMComponent.getFields().isEmpty()) ? false : true;
    }

    private List<IDMComponent> m(a aVar, JSONObject jSONObject) {
        String[] d2;
        JSONObject jSONObject2;
        List<IDMComponent> components = aVar.getComponents();
        Map<String, DMComponent> l = aVar.l();
        if (jSONObject == null || l == null || l.size() == 0) {
            return null;
        }
        JSONObject jSONObject3 = jSONObject.getJSONObject("data");
        if (jSONObject3 == null) {
            return components;
        }
        x(aVar, jSONObject3);
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Object> entry : jSONObject3.entrySet()) {
            String key = entry.getKey();
            JSONObject jSONObject4 = (JSONObject) entry.getValue();
            DMComponent dMComponent = l.get(key);
            if (dMComponent != null) {
                try {
                    String string = dMComponent.getFields().getString("cornerType");
                    if (!(TextUtils.isEmpty(string) || jSONObject4 == null || (jSONObject2 = jSONObject4.getJSONObject("fields")) == null)) {
                        jSONObject2.put("cornerType", (Object) string);
                    }
                    if (key != null && this.b && (d2 = d(key)) != null && d2.length == 2) {
                        jSONObject4.put("tag", (Object) d2[0]);
                        jSONObject4.put("id", (Object) d2[1]);
                    }
                    dMComponent.onReload(aVar, jSONObject4);
                    dMComponent.onReloadEvent(q(aVar, jSONObject4.getJSONObject("events")));
                    sb.append("组件reload:");
                    sb.append(key);
                    sb.append(StringUtils.LF);
                } catch (Throwable unused) {
                }
            }
        }
        tr2.b("ParseModule", "parseAdjustResponseJson", sb.toString());
        JSONObject jSONObject5 = jSONObject.getJSONObject("linkage");
        if (jSONObject5 != null) {
            for (Map.Entry<String, Object> entry2 : jSONObject5.entrySet()) {
                if ("common".equals(entry2.getKey())) {
                    JSONObject jSONObject6 = (JSONObject) entry2.getValue();
                    if (jSONObject6 != null) {
                        JSONObject b2 = aVar.b();
                        if (b2 != null) {
                            for (Map.Entry<String, Object> entry3 : jSONObject6.entrySet()) {
                                b2.put(entry3.getKey(), entry3.getValue());
                            }
                        } else {
                            aVar.v(jSONObject6);
                        }
                    }
                } else {
                    aVar.j().put(entry2.getKey(), entry2.getValue());
                }
            }
        }
        b(aVar);
        return components;
    }

    private void o(a aVar, JSONObject jSONObject) {
        JSONArray jSONArray;
        if (!(jSONObject == null || aVar == null)) {
            if ((!aVar.p("container") || aVar.o().isEmpty()) && (jSONArray = jSONObject.getJSONObject("container").getJSONArray("data")) != null) {
                ArrayList arrayList = new ArrayList();
                int size = jSONArray.size();
                StringBuilder sb = new StringBuilder(StringUtils.LF);
                for (int i = 0; i < size; i++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    if (jSONObject2 != null) {
                        mc0 mc0 = new mc0(jSONObject2);
                        arrayList.add(mc0);
                        JSONArray jSONArray2 = jSONObject2.getJSONArray("type");
                        if (jSONArray2 != null) {
                            int size2 = jSONArray2.size();
                            for (int i2 = 0; i2 < size2; i2++) {
                                String string = jSONArray2.getString(i2);
                                sb.append("componentType: ");
                                sb.append(string);
                                sb.append(", containerName: ");
                                sb.append(mc0.c);
                                sb.append(", containerUrl: ");
                                sb.append(mc0.d);
                                sb.append(StringUtils.LF);
                                aVar.o().put(string, jSONObject2);
                            }
                        }
                    }
                }
                tr2.b("ParseModule", "parseContainer", sb.toString());
                aVar.H(arrayList);
            }
        }
    }

    private IDMEvent p(a aVar, JSONObject jSONObject) {
        String str;
        List<IDMComponent> list = null;
        if (jSONObject == null || jSONObject.isEmpty()) {
            return null;
        }
        String string = jSONObject.getString("type");
        JSONObject jSONObject2 = jSONObject.getJSONObject("fields");
        if (jSONObject2 == null) {
            str = "";
        } else {
            str = jSONObject2.getString("nextRenderRoot");
        }
        if (!TextUtils.isEmpty(str)) {
            list = f(aVar, str);
        }
        return new DMEvent(string, jSONObject2, list);
    }

    private Map<String, List<IDMEvent>> q(a aVar, JSONObject jSONObject) {
        IDMEvent p;
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
                    if ((next instanceof JSONObject) && (p = p(aVar, (JSONObject) next)) != null) {
                        arrayList.add(p);
                    }
                }
                hashMap.put(key, arrayList);
            }
        }
        return hashMap;
    }

    private List<IDMComponent> r(a aVar, JSONObject jSONObject) {
        if (!(jSONObject == null || aVar == null)) {
            String str = "data";
            JSONObject jSONObject2 = jSONObject.getJSONObject(str);
            String str2 = "hierarchy";
            JSONObject jSONObject3 = jSONObject.getJSONObject(str2);
            JSONObject jSONObject4 = jSONObject.getJSONObject("linkage");
            JSONObject jSONObject5 = jSONObject.getJSONObject(RenderConstant.GLOBAL);
            JSONObject jSONObject6 = jSONObject.getJSONObject("endpoint");
            JSONObject jSONObject7 = jSONObject3 != null ? jSONObject3.getJSONObject("structure") : null;
            if (jSONObject2 == null || jSONObject3 == null || jSONObject4 == null || jSONObject7 == null) {
                if (jSONObject2 != null) {
                    if (jSONObject3 != null) {
                        str = "default";
                    }
                    String a2 = aVar.a();
                    UmbrellaTracker.commitFailureStability("protocolError", str2, "1.0", a2, null, null, "errorcode", str2 + " is empty");
                }
                str2 = str;
                String a22 = aVar.a();
                UmbrellaTracker.commitFailureStability("protocolError", str2, "1.0", a22, null, null, "errorcode", str2 + " is empty");
            } else {
                if (aVar.e() == null) {
                    aVar.t();
                    aVar.y(jSONObject2);
                    aVar.G(jSONObject7);
                } else {
                    aVar.l().clear();
                    jSONObject2 = aVar.q(jSONObject2);
                    jSONObject3.put("structure", (Object) aVar.s(jSONObject7));
                }
                aVar.C(jSONObject3);
                aVar.B(jSONObject5);
                aVar.D(jSONObject4);
                aVar.z(jSONObject6);
                if (jSONObject6 != null) {
                    aVar.F(jSONObject6.getString("protocolVersion"));
                }
                o(aVar, jSONObject);
                aVar.v(jSONObject4.getJSONObject("common"));
                String string = jSONObject3.getString("root");
                if (TextUtils.isEmpty(string)) {
                    return null;
                }
                this.a = a(aVar, jSONObject2.getJSONObject(string), string);
                return f(aVar, string);
            }
        }
        return null;
    }

    private List<IDMComponent> s(a aVar, String str, DMComponent dMComponent) {
        DMComponent dMComponent2;
        ExtendBlock extendBlock = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        JSONObject e = aVar.e();
        JSONObject n = aVar.n();
        JSONObject jSONObject = e != null ? e.getJSONObject(str) : null;
        Map<String, DMComponent> c2 = aVar.c();
        Map<String, DMComponent> l = aVar.l();
        if (jSONObject == null || aVar.p("data")) {
            dMComponent2 = c2.get(str);
        } else {
            dMComponent2 = null;
        }
        if (dMComponent2 == null) {
            try {
                dMComponent2 = a(aVar, jSONObject, str);
            } catch (Throwable th) {
                tr2.b("ParseModule", "createDMComponent error", th.getMessage());
            }
        } else {
            dMComponent2.getChildren().clear();
        }
        if (dMComponent2 != null) {
            dMComponent2.setParent(dMComponent);
            c2.put(str, dMComponent2);
            l.put(str, dMComponent2);
        }
        String c3 = c(dMComponent2, dMComponent);
        String j = j(dMComponent2, dMComponent);
        if (dMComponent2 != null && dMComponent2.isExtendBlock()) {
            extendBlock = aVar.h().get(str);
            if (extendBlock == null) {
                extendBlock = new ExtendBlock(dMComponent2);
                aVar.h().put(str, extendBlock);
            } else {
                extendBlock.updateExtendBlock(dMComponent2);
            }
        }
        JSONArray jSONArray = n.getJSONArray(str);
        if (jSONArray != null) {
            Iterator<Object> it = jSONArray.iterator();
            while (it.hasNext()) {
                String str2 = (String) it.next();
                t(dMComponent2, c3);
                u(dMComponent2, j);
                List<IDMComponent> s = s(aVar, str2, dMComponent2);
                if (extendBlock != null) {
                    extendBlock.addBlock(str2, s);
                    extendBlock.addHierarchy(str2, aVar);
                } else if (s != null) {
                    arrayList.addAll(s);
                    if (c2 != null) {
                        DMComponent dMComponent3 = c2.get(str2);
                        if (!(dMComponent2 == null || dMComponent3 == null)) {
                            dMComponent2.addChild(dMComponent3);
                        }
                    }
                }
            }
            if (extendBlock != null) {
                arrayList.addAll(extendBlock.getblockComponentList());
            }
        } else if (dMComponent2 == null || dMComponent2.getFields() == null) {
            tr2.b("ParseModule", "resolve", "currentComponent fields error: ", str);
        } else {
            arrayList.add(dMComponent2);
            t(dMComponent2, c3);
            u(dMComponent2, j);
        }
        return arrayList;
    }

    private void t(IDMComponent iDMComponent, String str) {
        if (!TextUtils.isEmpty(str) && iDMComponent.getExtMap() != null) {
            iDMComponent.getExtMap().put(c, str);
        }
    }

    private void u(IDMComponent iDMComponent, String str) {
        if (!TextUtils.isEmpty(str)) {
            iDMComponent.getExtMap().put(d, str);
        }
    }

    private void v(List<IDMComponent> list) {
        int i;
        String str;
        List<IDMComponent> i2 = i(list);
        String str2 = "";
        IDMComponent iDMComponent = null;
        int i3 = 0;
        int i4 = 1;
        while (true) {
            i = 17;
            if (i3 >= i2.size() - 1) {
                break;
            }
            IDMComponent iDMComponent2 = i2.get(i3);
            if (!(iDMComponent2.getExtMap() == null || (str = (String) iDMComponent2.getExtMap().get(c)) == null)) {
                IDMComponent iDMComponent3 = i2.get(i3 + 1);
                String str3 = (String) iDMComponent3.getExtMap().get(c);
                if (str.equals(str3)) {
                    if (1 == i4) {
                        w(iDMComponent2, 1);
                    }
                    i4++;
                } else {
                    if (1 != i4) {
                        i4 = 1;
                        i = 16;
                    }
                    w(iDMComponent2, i);
                }
                iDMComponent = iDMComponent3;
                str2 = str3;
            }
            i3++;
        }
        if (1 != i4) {
            i = 16;
        }
        if (!TextUtils.isEmpty(str2)) {
            w(iDMComponent, i);
        }
    }

    private void w(IDMComponent iDMComponent, int i) {
        if (iDMComponent != null) {
            if (i == 1) {
                iDMComponent.getFields().put("cornerType", "top");
            } else if (i == 16) {
                iDMComponent.getFields().put("cornerType", "bottom");
            } else if (i == 17) {
                iDMComponent.getFields().put("cornerType", "both");
            }
        }
    }

    private void x(a aVar, JSONObject jSONObject) {
        JSONObject e;
        if (aVar != null && jSONObject != null && (e = aVar.e()) != null) {
            e.putAll(jSONObject);
        }
    }

    /* access modifiers changed from: package-private */
    public List<IDMComponent> f(a aVar, String str) {
        List<IDMComponent> list = null;
        try {
            list = s(aVar, str, null);
            if (list == null || list.isEmpty()) {
                tr2.b("ParseModule", "getComponentsByRoot", "output is empty，rootComponentKey:", str);
            } else {
                v(list);
                b(aVar);
            }
        } catch (Throwable unused) {
        }
        return list;
    }

    /* access modifiers changed from: package-private */
    public IDMComponent k() {
        return this.a;
    }

    /* access modifiers changed from: package-private */
    public boolean n(a aVar, JSONObject jSONObject) {
        List<IDMComponent> list;
        if (aVar.k() != null) {
            try {
                this.b = lv1.a(new BigInteger(aVar.k()), lv1.FEATURE_TAG_ID);
            } catch (Exception e) {
                tr2.b("ParseModule", e.getMessage());
            }
        }
        if (jSONObject == null) {
            return false;
        }
        try {
            if (jSONObject.getBooleanValue("reload")) {
                tr2.b("ParseModule", "parseComponents", "parseFullResponseJson");
                list = r(aVar, jSONObject);
            } else {
                tr2.b("ParseModule", "parseComponents", "parseAdjustResponseJson");
                list = m(aVar, jSONObject);
            }
            if (list == null) {
                return false;
            }
            aVar.w(list);
            tr2.b("ParseModule", "parseComponents", "parse success");
            return true;
        } catch (Throwable unused) {
            tr2.b("ParseModule", "parseComponents", "parse failed");
            return false;
        }
    }
}
