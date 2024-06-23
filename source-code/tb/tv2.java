package tb;

import android.net.Uri;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.poplayer.PopLayer;
import com.alibaba.poplayer.norm.IConfigAdapter;
import com.alibaba.poplayer.trigger.BaseConfigItem;
import com.alibaba.poplayer.trigger.Event;
import com.alibaba.poplayer.trigger.a;
import com.alibaba.poplayer.trigger.view.ViewConfigItem;
import com.alibaba.poplayer.trigger.view.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
public class tv2 extends a<ViewConfigItem> {
    public static final String KEY_CONFIG_VIEW = "poplayer_view_config";

    public tv2(PopLayer popLayer, IConfigAdapter iConfigAdapter) {
        super(iConfigAdapter, KEY_CONFIG_VIEW, a.KEY_BLACK_LIST);
        cr1.a("ViewConfigMgr use " + ViewConfigItem.LOG);
    }

    private boolean x(Map<String, String> map, BaseConfigItem.a aVar) {
        JSONObject jSONObject;
        String string;
        String str;
        if (!TextUtils.isEmpty(aVar.c)) {
            try {
                jSONObject = new JSONObject(aVar.c);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (jSONObject != null || jSONObject.length() == 0) {
                return true;
            }
            if (!(map == null || map.size() == 0)) {
                Iterator<String> keys = jSONObject.keys();
                do {
                    try {
                        if (!keys.hasNext()) {
                            return true;
                        }
                        String next = keys.next();
                        string = jSONObject.getString(next);
                        str = map.get(next);
                        if (TextUtils.isEmpty(string) || TextUtils.isEmpty(str)) {
                            return false;
                        }
                    } catch (Throwable unused) {
                    }
                } while (string.equals(str));
                return false;
            }
            return false;
        }
        jSONObject = null;
        if (jSONObject != null) {
        }
        return true;
    }

    /* renamed from: A */
    public ViewConfigItem s(Event event) {
        Uri parse = Uri.parse(event.originUri);
        if (!"directly".equals(parse.getQueryParameter("openType"))) {
            return null;
        }
        String jSONObject = u(parse).toString();
        ViewConfigItem viewConfigItem = (ViewConfigItem) JSON.parseObject(jSONObject, ViewConfigItem.class);
        viewConfigItem.pageInfo = t(jSONObject, viewConfigItem.uuid);
        return viewConfigItem;
    }

    @Override // com.alibaba.poplayer.trigger.a
    public tu2<ViewConfigItem> h(Event event) {
        ArrayList arrayList = new ArrayList();
        for (ConfigItemType configitemtype : this.b) {
            cr1.b("ViewConfigMgr.findValidConfigs.currentUUID:{%s}.", configitemtype.uuid);
            if (!n(event, configitemtype.pageInfo)) {
                cr1.b("ViewConfigMgr.findValidConfigs.currentUUID:{%s}.isMatchUriOrUris fail.", configitemtype.uuid);
            } else if (!e(event, configitemtype.pageInfo)) {
                cr1.b("ViewConfigMgr.findValidConfigs.currentUUID:{%s}.checkParamContains fail.", configitemtype.uuid);
            } else {
                arrayList.add(configitemtype);
            }
        }
        return f(event, arrayList);
    }

    /* access modifiers changed from: protected */
    @Override // com.alibaba.poplayer.trigger.a
    public void p(List<ViewConfigItem> list, String str, List<String> list2) {
        d.M().w();
    }

    public tu2<ViewConfigItem> y(Event event, Map<String, String> map) {
        ArrayList arrayList = new ArrayList();
        for (ConfigItemType configitemtype : this.b) {
            cr1.b("ViewConfigMgr.findValidConfigs.currentUUID:{%s}.", configitemtype.uuid);
            if (!n(event, configitemtype.pageInfo)) {
                cr1.b("ViewConfigMgr.findValidConfigs.currentUUID:{%s}.isMatchUriOrUris fail.", configitemtype.uuid);
            } else if (!x(map, configitemtype.pageInfo)) {
                cr1.b("ViewConfigMgr.findValidConfigs.currentUUID:{%s}.checkParamContainsWithFilter fail.", configitemtype.uuid);
            } else {
                arrayList.add(configitemtype);
            }
        }
        return f(event, arrayList);
    }

    /* renamed from: z */
    public ViewConfigItem r(String str) {
        ViewConfigItem viewConfigItem = (ViewConfigItem) JSON.parseObject(str, ViewConfigItem.class);
        viewConfigItem.pageInfo = t(str, viewConfigItem.uuid);
        return viewConfigItem;
    }
}
