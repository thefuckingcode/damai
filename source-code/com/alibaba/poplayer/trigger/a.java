package com.alibaba.poplayer.trigger;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.poplayer.PopLayer;
import com.alibaba.poplayer.norm.IConfigAdapter;
import com.alibaba.poplayer.trigger.BaseConfigItem;
import com.alibaba.poplayer.trigger.CommonConfigRule;
import com.alibaba.poplayer.utils.Monitor;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import tb.cr1;
import tb.hn1;
import tb.tu2;

@Monitor.TargetClass
/* compiled from: Taobao */
public abstract class a<ConfigItemType extends BaseConfigItem> {
    public static final String KEY_BLACK_LIST = "poplayer_black_list";
    @Monitor.TargetField(name = hn1.MONITOR_CONFIG_SET)
    protected String a = "";
    @Monitor.TargetField(name = hn1.MONITOR_CONFIG_ITEMS)
    protected List<ConfigItemType> b = new ArrayList();
    @Monitor.TargetField(name = hn1.MONITOR_BLACKLIST)
    protected List<String> c = new ArrayList();
    private a<ConfigItemType>.AsyncTaskC0095a d;
    private IConfigAdapter e;
    private volatile boolean f;
    private final String g;
    private final String h;

    /* access modifiers changed from: private */
    /* renamed from: com.alibaba.poplayer.trigger.a$a  reason: collision with other inner class name */
    /* compiled from: Taobao */
    public class AsyncTaskC0095a extends AsyncTask<Boolean, Void, a<ConfigItemType>.b> {
        private final Context a;

        public AsyncTaskC0095a(Context context) {
            this.a = context;
        }

        private a<ConfigItemType>.b c(boolean z) {
            cr1.b("UpdateCacheConfigTask.updateCacheConfig?init=%s.run.start", Boolean.valueOf(z));
            ArrayList arrayList = new ArrayList();
            String configItemByKey = a.this.e.getConfigItemByKey(this.a, a.this.g);
            if (a.l(configItemByKey)) {
                cr1.b("UpdateCacheConfigTask.configSet.empty.return", new Object[0]);
                return new b(a.this);
            }
            cr1.b("UpdateCacheConfigTask.configSet.%s", configItemByKey);
            String configItemByKey2 = a.this.e.getConfigItemByKey(this.a, a.this.h);
            List arrayList2 = a.l(configItemByKey2) ? new ArrayList() : Arrays.asList(configItemByKey2.split(","));
            cr1.b("UpdateCacheConfigTask.blacklist.%s", configItemByKey2);
            for (String str : configItemByKey.split("\\,")) {
                String trim = str.trim();
                String configItemByKey3 = a.this.e.getConfigItemByKey(this.a, trim);
                cr1.b("UpdateCacheConfigTask.config{%s}", configItemByKey3);
                try {
                    BaseConfigItem r = a.this.r(configItemByKey3);
                    if (r != null) {
                        r.entityId = trim;
                        arrayList.add(r);
                    }
                } catch (Throwable th) {
                    cr1.c("UpdateCacheConfigTask.parse.error.uuid{" + trim + "}.content{" + configItemByKey3 + "}", th);
                }
            }
            a aVar = a.this;
            aVar.v(aVar.e, this.a);
            return new b(a.this, arrayList, configItemByKey, arrayList2);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public a<ConfigItemType>.b doInBackground(Boolean... boolArr) {
            try {
                return c(boolArr[0].booleanValue());
            } catch (Throwable th) {
                cr1.c("UpdateCacheConfigTask.doInBackground.fail." + th.toString(), th);
                return new b(a.this);
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(a<ConfigItemType>.b bVar) {
            try {
                a.this.b = ((b) bVar).a;
                a.this.a = ((b) bVar).b;
                a.this.c = ((b) bVar).c;
                a aVar = a.this;
                aVar.p(aVar.b, aVar.a, aVar.c);
                a.this.f = false;
            } catch (Throwable th) {
                cr1.c("UpdateCacheConfigTask.onPostExecute.error", th);
            }
        }
    }

    public a(IConfigAdapter iConfigAdapter, String str, String str2) {
        this.e = iConfigAdapter;
        this.g = str;
        this.h = str2;
    }

    public static boolean l(String str) {
        return str == null || "".equals(str) || "\"\"".equals(str);
    }

    /* access modifiers changed from: protected */
    public boolean e(Event event, BaseConfigItem.a aVar) {
        String str = aVar == null ? null : aVar.c;
        if (TextUtils.isEmpty(str)) {
            cr1.b("DefaultConfigManager.checkUrlContains.paramContains is empty,check success.", new Object[0]);
            return true;
        }
        String str2 = event.param;
        try {
            str2 = URLDecoder.decode(str2, "utf-8");
        } catch (Throwable unused) {
            cr1.b("DefaultConfigManager.checkUrlContains.currentParam:{%s} decode failed", str2);
        }
        try {
            str = URLDecoder.decode(str, "utf-8");
        } catch (Throwable unused2) {
            cr1.b("DefaultConfigManager.checkUrlContains.paramContains:{%s} decode failed", str);
        }
        cr1.b("DefaultConfigManager.checkUrlContains.after decode:currentParam:{%s},paramContains{%s}.", str2, str);
        if (str2 == null || !str2.contains(str)) {
            cr1.b("DefaultConfigManager.checkUrlContains.miss.currentParam{%s}.notContains.paramContain{%s}", str2, str);
            return false;
        }
        cr1.b("DefaultConfigManager.checkUrlContains.currentParam.contains(paramContains),check success.", new Object[0]);
        return true;
    }

    /* access modifiers changed from: protected */
    public tu2<ConfigItemType> f(Event event, ArrayList<ConfigItemType> arrayList) {
        tu2<ConfigItemType> tu2 = new tu2<>();
        cr1.b("ConfigManager.blackList check.", new Object[0]);
        if (m(this.c)) {
            return tu2;
        }
        Iterator<ConfigItemType> it = arrayList.iterator();
        while (it.hasNext()) {
            ConfigItemType next = it.next();
            CommonConfigRule.ConfigStatus b2 = CommonConfigRule.b(event, next);
            if (CommonConfigRule.ConfigStatus.VALIED == b2) {
                tu2.a.add(next);
            } else if (CommonConfigRule.ConfigStatus.VALIED_BUT_UNSTARTED == b2) {
                tu2.b.add(next);
            }
        }
        return tu2;
    }

    public tu2<ConfigItemType> g(Event event) {
        tu2<ConfigItemType> tu2 = new tu2<>();
        if (!q(event)) {
            return h(event);
        }
        tu2.a.add(s(event));
        return tu2;
    }

    public abstract tu2<ConfigItemType> h(Event event);

    /* access modifiers changed from: protected */
    public String i() {
        return Build.getMODEL();
    }

    /* access modifiers changed from: protected */
    public String j() {
        return Build.VERSION.getRELEASE();
    }

    public IConfigAdapter k() {
        return this.e;
    }

    /* access modifiers changed from: protected */
    public boolean m(List<String> list) {
        if (list == null || list.isEmpty()) {
            cr1.b("ConfigManager.isInList.return.emptyList", new Object[0]);
            return false;
        }
        String i = i();
        boolean contains = list.contains(i);
        if (!contains) {
            Iterator<String> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                String next = it.next();
                if (Pattern.compile(next).matcher(i).matches()) {
                    cr1.b("ConfigManager.list.in regex : %s,buildType: %s ", next, i);
                    contains = true;
                    break;
                }
            }
        }
        cr1.b("ConfigManager.isInList.return?contains-%s=%s", i(), Boolean.valueOf(contains));
        boolean contains2 = list.contains(j());
        cr1.b("ConfigManager.isInList.return?containsVersion-%s=%s", j(), Boolean.valueOf(contains2));
        if (contains || contains2) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean n(Event event, BaseConfigItem.a aVar) {
        if (aVar == null) {
            return false;
        }
        if (event.uri.equals(aVar.a)) {
            return true;
        }
        String[] strArr = aVar.b;
        if (!(strArr == null || strArr.length == 0)) {
            for (String str : strArr) {
                if (event.uri.equals(str)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public final boolean o() {
        return this.f;
    }

    /* access modifiers changed from: protected */
    public abstract void p(List<ConfigItemType> list, String str, List<String> list2);

    /* access modifiers changed from: protected */
    public boolean q(Event event) {
        if (event.originUri.startsWith(PopLayer.SCHEMA) && "directly".equals(Uri.parse(event.originUri).getQueryParameter("openType"))) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public abstract ConfigItemType r(String str);

    public abstract ConfigItemType s(Event event);

    /* access modifiers changed from: protected */
    public BaseConfigItem.a t(String str, String str2) {
        BaseConfigItem.a aVar = new BaseConfigItem.a();
        try {
            JSONObject parseObject = JSON.parseObject(str);
            aVar.a = parseObject.getString("uri");
            String string = parseObject.getString("uris");
            if (!TextUtils.isEmpty(string)) {
                List parseArray = JSON.parseArray(string, String.class);
                aVar.b = (String[]) parseArray.toArray(new String[parseArray.size()]);
            }
            aVar.c = parseObject.getString("paramContains");
        } catch (Throwable unused) {
            cr1.b("PageConfigMgr.parseConfig.error:currentUUID:{%s}.", str2);
        }
        return aVar;
    }

    /* access modifiers changed from: protected */
    public org.json.JSONObject u(Uri uri) {
        org.json.JSONObject jSONObject = null;
        try {
            org.json.JSONObject jSONObject2 = new org.json.JSONObject();
            try {
                for (String str : uri.getQueryParameterNames()) {
                    jSONObject2.put(str, uri.getQueryParameter(str));
                }
                return jSONObject2;
            } catch (Throwable unused) {
                jSONObject = jSONObject2;
                return jSONObject;
            }
        } catch (Throwable unused2) {
            return jSONObject;
        }
    }

    /* access modifiers changed from: protected */
    public void v(IConfigAdapter iConfigAdapter, Context context) {
    }

    public final void w(boolean z, Context context) {
        this.f = true;
        a<ConfigItemType>.AsyncTaskC0095a aVar = this.d;
        if (!(aVar == null || AsyncTask.Status.FINISHED == aVar.getStatus())) {
            this.d.cancel(true);
        }
        a<ConfigItemType>.AsyncTaskC0095a aVar2 = new AsyncTaskC0095a(context);
        this.d = aVar2;
        aVar2.execute(Boolean.valueOf(z));
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public final class b {
        private final List<ConfigItemType> a;
        private final String b;
        private final List<String> c;

        public b(a aVar, List<ConfigItemType> list, String str, List<String> list2) {
            this.a = list;
            this.b = str;
            this.c = list2;
        }

        public b(a aVar) {
            this.a = new ArrayList();
            this.b = "";
            this.c = new ArrayList();
        }
    }
}
