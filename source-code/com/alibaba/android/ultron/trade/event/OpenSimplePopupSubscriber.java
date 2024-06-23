package com.alibaba.android.ultron.trade.event;

import android.text.TextUtils;
import com.alibaba.android.ultron.trade.event.model.OpenPopupWindowEventModel;
import com.alibaba.android.ultron.trade.event.model.SimplePopupModel;
import com.alibaba.android.ultron.vfw.popupwindow.PopupWindowManager;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.taobao.android.ultron.common.model.IDMComponent;
import com.taobao.android.ultron.datamodel.imp.DMComponent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tb.f50;
import tb.jn2;
import tb.l20;
import tb.tr2;
import tb.va;

/* compiled from: Taobao */
public class OpenSimplePopupSubscriber extends va {
    public static final String DEFAULT_BODY_TEMPLATE_NAME = "buy_popup_check_box_simple";
    public static final String DEFAULT_FOOTER_TEMPLATE_NAME = "buy_dialog_bottom_simple";
    public static final String DEFAULT_HEADER_TEMPLATE_NAME = "buy_dialog_title_simple";
    public static final String KEY_COMPONENT_TYPE = "componentType";
    public static final String KEY_FOOTER_TYPE = "footerType";
    public static final String KEY_HEADER_TYPE = "headerType";
    public static final String KEY_ID = "id";
    public static final String KEY_SIMPLE_POPUP_FIELDS = "simplePopupFields";
    public static final String KEY_SIMPLE_POPUP_MODEL = "simplePopupModel";
    protected String j = DEFAULT_FOOTER_TEMPLATE_NAME;
    protected String k = DEFAULT_HEADER_TEMPLATE_NAME;
    protected String l = DEFAULT_BODY_TEMPLATE_NAME;

    /* compiled from: Taobao */
    class a implements PopupWindowManager.OnCancelListener {
        final /* synthetic */ jn2 a;

        a(OpenSimplePopupSubscriber openSimplePopupSubscriber, jn2 jn2) {
            this.a = jn2;
        }

        @Override // com.alibaba.android.ultron.vfw.popupwindow.PopupWindowManager.OnCancelListener
        public void onCancel() {
            this.a.h();
        }
    }

    /* access modifiers changed from: protected */
    @Override // tb.va
    public void h(jn2 jn2) {
        JSONObject fields = this.e.getFields();
        if (fields != null) {
            jn2.o(new f50(this.e, this.c));
            List<IDMComponent> r = r(fields);
            List<IDMComponent> p = p(fields);
            List<IDMComponent> q = q(fields);
            l20 l20 = new l20();
            l20.h(r);
            l20.e(p);
            l20.g(q);
            this.c.getViewManager().showPopup(l20, (OpenPopupWindowEventModel) null, new a(this, jn2));
            this.c.getTradeEventHandler().n(jn2);
        }
    }

    /* access modifiers changed from: protected */
    public DMComponent m(JSONObject jSONObject, com.taobao.android.ultron.datamodel.imp.a aVar, String str) {
        JSONObject jSONObject2;
        String str2;
        if (aVar == null || TextUtils.isEmpty(str)) {
            return null;
        }
        Iterator<JSONObject> it = aVar.o().values().iterator();
        while (true) {
            if (!it.hasNext()) {
                jSONObject2 = null;
                break;
            }
            jSONObject2 = it.next();
            if (jSONObject2 != null && str.equals(jSONObject2.getString("name"))) {
                break;
            }
        }
        if (jSONObject2 == null) {
            tr2.b("OpenSimplePopupSubscriber", "通过type，component container信息未匹配到： " + str);
        }
        String str3 = "";
        if (jSONObject2 != null) {
            str2 = jSONObject2.getString("containerType");
            JSONArray jSONArray = jSONObject2.getJSONArray("type");
            if (jSONArray != null && jSONArray.size() > 0) {
                str3 = (String) jSONArray.get(0);
            }
        } else {
            str2 = "native";
        }
        jSONObject.put("type", (Object) str3);
        return new DMComponent(jSONObject, str2, jSONObject2, null);
    }

    /* access modifiers changed from: protected */
    public DMComponent n(JSONObject jSONObject, com.taobao.android.ultron.datamodel.imp.a aVar, String str) {
        String str2;
        if (aVar == null) {
            return null;
        }
        JSONObject jSONObject2 = aVar.o().get(str);
        if (jSONObject2 != null) {
            str2 = jSONObject2.getString("containerType");
        } else {
            tr2.b("OpenSimplePopupSubscriber", "通过type，component container信息未匹配到： " + str);
            str2 = "native";
        }
        return new DMComponent(jSONObject, str2, jSONObject2, null);
    }

    /* access modifiers changed from: protected */
    public DMComponent o() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("type", "block$null$emptyBlock");
        return n(jSONObject, (com.taobao.android.ultron.datamodel.imp.a) this.d, "block$null$emptyBlock");
    }

    /* access modifiers changed from: protected */
    public List<IDMComponent> p(JSONObject jSONObject) {
        SimplePopupModel simplePopupModel;
        DMComponent dMComponent;
        List<String> selectedIds;
        ArrayList arrayList = new ArrayList();
        String str = null;
        try {
            simplePopupModel = (SimplePopupModel) JSON.parseObject(jSONObject.toJSONString(), SimplePopupModel.class);
        } catch (Exception e) {
            tr2.b(e.getMessage(), new String[0]);
            simplePopupModel = null;
        }
        if (simplePopupModel == null) {
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        if (!(simplePopupModel.getAsSelect() == null || (selectedIds = simplePopupModel.getAsSelect().getSelectedIds()) == null)) {
            arrayList2.addAll(selectedIds);
        }
        JSONArray components = simplePopupModel.getComponents();
        if (components == null) {
            return arrayList;
        }
        if (jSONObject.containsKey(KEY_COMPONENT_TYPE)) {
            str = jSONObject.getString(KEY_COMPONENT_TYPE);
        }
        DMComponent o = o();
        o.getExtMap().put(KEY_SIMPLE_POPUP_MODEL, simplePopupModel);
        o.getExtMap().put(KEY_SIMPLE_POPUP_FIELDS, jSONObject);
        Iterator<Object> it = components.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            if (next instanceof JSONObject) {
                JSONObject jSONObject2 = (JSONObject) next;
                String string = jSONObject2.getString("id");
                if (arrayList2.contains(string)) {
                    jSONObject2.put("isChecked", (Object) "true");
                } else {
                    jSONObject2.put("isChecked", (Object) "false");
                }
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("fields", next);
                String string2 = jSONObject2.containsKey("type") ? jSONObject2.getString("type") : str;
                jSONObject3.put("type", (Object) string2);
                if (!TextUtils.isEmpty(string)) {
                    jSONObject3.put("id", (Object) string);
                }
                if (TextUtils.isEmpty(string2)) {
                    dMComponent = m(jSONObject3, (com.taobao.android.ultron.datamodel.imp.a) this.d, this.l);
                } else {
                    dMComponent = n(jSONObject3, (com.taobao.android.ultron.datamodel.imp.a) this.d, string2);
                }
                dMComponent.setParent(o);
                o.addChild(dMComponent);
                arrayList.add(dMComponent);
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public List<IDMComponent> q(JSONObject jSONObject) {
        DMComponent dMComponent;
        String string = jSONObject.containsKey(KEY_FOOTER_TYPE) ? jSONObject.getString(KEY_FOOTER_TYPE) : null;
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("fields", (Object) jSONObject);
        jSONObject2.put("type", (Object) string);
        if (TextUtils.isEmpty(string)) {
            dMComponent = m(jSONObject2, (com.taobao.android.ultron.datamodel.imp.a) this.d, this.j);
        } else {
            dMComponent = n(jSONObject2, (com.taobao.android.ultron.datamodel.imp.a) this.d, string);
        }
        return new ArrayList<IDMComponent>(dMComponent) {
            /* class com.alibaba.android.ultron.trade.event.OpenSimplePopupSubscriber.AnonymousClass3 */
            final /* synthetic */ DMComponent val$footerComponent;

            {
                this.val$footerComponent = r2;
                add(r2);
            }
        };
    }

    /* access modifiers changed from: protected */
    public List<IDMComponent> r(JSONObject jSONObject) {
        DMComponent dMComponent;
        String string = jSONObject.containsKey(KEY_HEADER_TYPE) ? jSONObject.getString(KEY_HEADER_TYPE) : null;
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("fields", (Object) jSONObject);
        jSONObject2.put("type", (Object) string);
        if (TextUtils.isEmpty(string)) {
            dMComponent = m(jSONObject2, (com.taobao.android.ultron.datamodel.imp.a) this.d, this.k);
        } else {
            dMComponent = n(jSONObject2, (com.taobao.android.ultron.datamodel.imp.a) this.d, string);
        }
        return new ArrayList<IDMComponent>(dMComponent) {
            /* class com.alibaba.android.ultron.trade.event.OpenSimplePopupSubscriber.AnonymousClass2 */
            final /* synthetic */ DMComponent val$headerComponent;

            {
                this.val$headerComponent = r2;
                add(r2);
            }
        };
    }
}
