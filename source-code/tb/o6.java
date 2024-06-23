package tb;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.poplayer.norm.IConfigAdapter;
import com.alibaba.poplayer.trigger.BaseConfigItem;
import com.alibaba.poplayer.trigger.Event;
import com.alibaba.poplayer.trigger.a;
import com.alibaba.poplayer.trigger.app.AppConfigItem;
import com.alibaba.poplayer.utils.Monitor;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

/* compiled from: Taobao */
public class o6 extends a<AppConfigItem> {
    public static final String KEY_CONFIG_APP = "poplayer_app_config";
    public static final String KEY_CONFIG_WHITE_LIST = "poplayer_app_white_list";
    @Monitor.TargetField(name = hn1.MONITOR_WHITELIST)
    protected List<String> i = new ArrayList();

    public o6(IConfigAdapter iConfigAdapter) {
        super(iConfigAdapter, KEY_CONFIG_APP, a.KEY_BLACK_LIST);
        cr1.a("AppConfigMgr use " + AppConfigItem.LOG);
    }

    private boolean z(Event event, List<BaseConfigItem.a> list) {
        if (list != null && !list.isEmpty()) {
            for (BaseConfigItem.a aVar : list) {
                if (n(event, aVar) && e(event, aVar)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: A */
    public AppConfigItem r(String str) {
        String[] strArr;
        try {
            AppConfigItem appConfigItem = (AppConfigItem) JSON.parseObject(str, AppConfigItem.class);
            if (appConfigItem.survivalWhiteList == null || appConfigItem.survivalBlackList == null) {
                BaseConfigItem.a t = t(str, appConfigItem.uuid);
                appConfigItem.pageInfo = t;
                if (!TextUtils.isEmpty(t.a) || (((strArr = appConfigItem.pageInfo.b) != null && strArr.length != 0) || appConfigItem.whiteList == null || appConfigItem.blackList == null)) {
                    return appConfigItem;
                }
                cr1.b("App parseConfig error. whitelist and blacklist exist at the same time", new Object[0]);
                return null;
            }
            cr1.b("App parseConfig error. survivalBlackList and survivalWhiteList exist at the same time", new Object[0]);
            return null;
        } catch (JSONException unused) {
            return null;
        }
    }

    /* renamed from: B */
    public AppConfigItem s(Event event) {
        JSONObject u = u(Uri.parse(event.originUri));
        String[] strArr = {"whiteList", "blackList", "survivalWhiteList", "survivalBlackList"};
        for (int i2 = 0; i2 < 4; i2++) {
            try {
                String str = strArr[i2];
                String str2 = (String) u.opt(str);
                if (!TextUtils.isEmpty(str2)) {
                    u.remove(str);
                    u.put("array_" + str, URLDecoder.decode(str2, "utf-8"));
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        AppConfigItem appConfigItem = (AppConfigItem) JSON.parseObject(u.toString(), AppConfigItem.class);
        try {
            if (!TextUtils.isEmpty(u.optString("array_whiteList"))) {
                appConfigItem.whiteList = (ArrayList) JSON.parseArray((String) u.get("array_whiteList"), BaseConfigItem.a.class);
            }
            if (!TextUtils.isEmpty(u.optString("array_blackList"))) {
                appConfigItem.blackList = (ArrayList) JSON.parseArray((String) u.get("array_blackList"), BaseConfigItem.a.class);
            }
            if (!TextUtils.isEmpty(u.optString("array_survivalWhiteList"))) {
                appConfigItem.survivalWhiteList = (ArrayList) JSON.parseArray((String) u.get("array_survivalWhiteList"), BaseConfigItem.a.class);
            }
            if (!TextUtils.isEmpty(u.optString("array_survivalBlackList"))) {
                appConfigItem.survivalBlackList = (ArrayList) JSON.parseArray((String) u.get("array_survivalBlackList"), BaseConfigItem.a.class);
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        ArrayList<BaseConfigItem.a> arrayList = appConfigItem.blackList;
        if ((arrayList == null || arrayList == null) && (appConfigItem.survivalWhiteList == null || appConfigItem.survivalBlackList == null)) {
            appConfigItem.pageInfo = t(u.toString(), appConfigItem.uuid);
            return appConfigItem;
        }
        cr1.b("App parseConfig error. whitelist and blacklist exist at the same time", new Object[0]);
        return null;
    }

    @Override // com.alibaba.poplayer.trigger.a
    public tu2<AppConfigItem> h(Event event) {
        return x(event, "");
    }

    /* access modifiers changed from: protected */
    @Override // com.alibaba.poplayer.trigger.a
    public void p(List<AppConfigItem> list, String str, List<String> list2) {
        c7.A().w();
    }

    /* access modifiers changed from: protected */
    @Override // com.alibaba.poplayer.trigger.a
    public void v(IConfigAdapter iConfigAdapter, Context context) {
        try {
            String configItemByKey = iConfigAdapter.getConfigItemByKey(context, KEY_CONFIG_WHITE_LIST);
            cr1.b("App white List :{%s}.", configItemByKey);
            synchronized (this.i) {
                this.i = a.l(configItemByKey) ? new ArrayList<>() : Arrays.asList(configItemByKey.split(","));
            }
        } catch (Throwable unused) {
        }
    }

    public tu2<AppConfigItem> x(Event event, String... strArr) {
        ArrayList<BaseConfigItem.a> arrayList;
        ArrayList<BaseConfigItem.a> arrayList2;
        if (event == null) {
            return null;
        }
        Event event2 = (event.source == 1 && strArr != null && strArr.length == 2) ? new Event(event.domain, strArr[0], strArr[1], event.attachActivityKeyCode, 1) : event;
        if (q(event)) {
            tu2<AppConfigItem> tu2 = new tu2<>();
            tu2.a.add(s(event));
            return tu2;
        }
        ArrayList arrayList3 = new ArrayList();
        for (ConfigItemType configitemtype : this.b) {
            cr1.b("AppConfigManager.whitelist check.", new Object[0]);
            if (m(this.i) && (event.source != 1 ? ((arrayList = configitemtype.whiteList) == null || z(event2, arrayList)) && ((arrayList2 = configitemtype.blackList) == null || !z(event2, arrayList2)) : n(event, configitemtype.pageInfo) && e(event, configitemtype.pageInfo))) {
                if (!y(configitemtype, event2)) {
                    cr1.b("AppConfigManager.config{%s} can not survival in this page.", new Object[0]);
                } else {
                    arrayList3.add(configitemtype);
                }
            }
        }
        return f(event, arrayList3);
    }

    public boolean y(AppConfigItem appConfigItem, Event event) {
        ArrayList<BaseConfigItem.a> arrayList = appConfigItem.survivalWhiteList;
        if (arrayList != null) {
            return z(event, arrayList);
        }
        return !z(event, appConfigItem.survivalBlackList);
    }
}
