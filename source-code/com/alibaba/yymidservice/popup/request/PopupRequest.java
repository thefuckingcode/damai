package com.alibaba.yymidservice.popup.request;

import android.app.Activity;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.yymidservice.popup.request.bean.PopupDetailBean;
import com.alibaba.yymidservice.popup.request.requestparam.PopupRequestParam;
import io.flutter.wpkbridge.WPKFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.text.StringsKt__StringsKt;
import tb.k21;
import tb.ta0;
import tb.ur2;

public final class PopupRequest {
    public static final PopupRequest INSTANCE = new PopupRequest();

    private PopupRequest() {
    }

    /* access modifiers changed from: public */
    private final void c(String str, ArrayList<PopupDetailBean> arrayList) {
        PopupDetailBean.PopupItem popupItem;
        JSONObject jSONObject;
        if (!(str == null || str.length() == 0)) {
            List list = str == null ? null : StringsKt__StringsKt.z0(str, new String[]{"."}, false, 0, 6, null);
            if (!(list == null || list.isEmpty()) && list.size() > 1) {
                String str2 = (String) list.get(0);
                String str3 = (String) list.get(1);
                if (arrayList != null && arrayList.size() > 0) {
                    Iterator<PopupDetailBean> it = arrayList.iterator();
                    while (it.hasNext()) {
                        PopupDetailBean next = it.next();
                        Object obj = (next == null || (popupItem = next.item) == null || (jSONObject = popupItem.value) == null) ? null : jSONObject.get("action");
                        Map map = obj instanceof Map ? (Map) obj : null;
                        if (map != null) {
                            for (Map.Entry entry : map.entrySet()) {
                                Object obj2 = ((JSONObject) entry.getValue()).get("trackInfo");
                                JSONObject jSONObject2 = obj2 instanceof JSONObject ? (JSONObject) obj2 : null;
                                if (jSONObject2 != null) {
                                    jSONObject2.put((Object) "spma", (Object) str2);
                                    jSONObject2.put((Object) "spmb", (Object) str3);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public final void b(Activity activity, String str, String str2, String str3, JSONObject jSONObject, PopupListener popupListener) {
        k21.i(activity, WPKFactory.INIT_KEY_CONTEXT);
        k21.i(str, "comboCityId");
        k21.i(str2, "sceneType");
        ta0.a aVar = ta0.Companion;
        PopupRequestParam popupRequestParam = new PopupRequestParam();
        popupRequestParam.setComboCityId(str);
        popupRequestParam.setSceneType(str2);
        popupRequestParam.setEventType(str3);
        popupRequestParam.setArgs(jSONObject);
        ur2 ur2 = ur2.INSTANCE;
        aVar.b(popupRequestParam).c(activity).a().doOnKTSuccess(new PopupRequest$tryPopupRequest$2(str2, activity, popupListener)).doOnKTFail(new PopupRequest$tryPopupRequest$3(str, str2, str3, jSONObject, activity, popupListener)).doOnKTFinish(PopupRequest$tryPopupRequest$4.INSTANCE);
    }
}
