package com.alibaba.analytics.core.config;

import android.text.TextUtils;
import com.alibaba.analytics.core.Variables;
import com.alibaba.analytics.core.model.LogField;
import com.alibaba.analytics.utils.Logger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
import tb.mq2;
import tb.vq2;
import tb.xd0;

/* compiled from: Taobao */
public class SystemConfigMgr extends vq2 {
    private static SystemConfigMgr e;
    private final Map<String, String> a = Collections.synchronizedMap(new HashMap());
    private final Map<String, List<IKVChangeListener>> b = Collections.synchronizedMap(new HashMap());
    private final String[] c = {"utap_system"};
    private final Map<String, a> d = new HashMap();

    /* compiled from: Taobao */
    public interface IKVChangeListener {
        void onChange(String str, String str2);
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class a {
        private int a = -1;
        private List<String> b = new ArrayList();

        private a() {
        }

        private boolean b(String str) {
            if (!TextUtils.isEmpty(str) && this.b != null) {
                for (int i = 0; i < this.b.size(); i++) {
                    String str2 = this.b.get(i);
                    if (!TextUtils.isEmpty(str2)) {
                        if (str2.length() <= 2 || !str2.startsWith("%") || !str2.endsWith("%")) {
                            if (str.equals(str2)) {
                                return true;
                            }
                        } else if (str.contains(str2.substring(1, str2.length() - 1))) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }

        public static a c(String str) {
            try {
                a aVar = new a();
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("all_d")) {
                    aVar.a = jSONObject.optInt("all_d", -1);
                }
                if (jSONObject.has("arg1")) {
                    ArrayList arrayList = new ArrayList();
                    JSONArray jSONArray = jSONObject.getJSONArray("arg1");
                    if (jSONArray != null) {
                        for (int i = 0; i < jSONArray.length(); i++) {
                            arrayList.add(jSONArray.getString(i));
                        }
                    }
                    aVar.b = arrayList;
                }
                return aVar;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        public boolean a(String str) {
            int i = this.a;
            if (i == 0) {
                return b(str);
            }
            if (1 == i) {
                return !b(str);
            }
            return false;
        }
    }

    private SystemConfigMgr() {
        try {
            if (Variables.n().k() != null) {
                List<? extends xd0> i = Variables.n().k().i(c.class, null, null, -1);
                if (i.size() > 0) {
                    Map<String, String> synchronizedMap = Collections.synchronizedMap(new HashMap(i.size()));
                    for (int i2 = 0; i2 < i.size(); i2++) {
                        synchronizedMap.put(((c) i.get(i2)).a, ((c) i.get(i2)).b);
                    }
                    m(synchronizedMap);
                }
            }
        } catch (Throwable th) {
            Logger.h(null, th, new Object[0]);
        }
    }

    private boolean d(Map<String, String> map, int i) {
        a aVar = this.d.get(String.valueOf(i));
        if (aVar == null) {
            return false;
        }
        String str = null;
        LogField logField = LogField.ARG1;
        if (map.containsKey(logField.toString())) {
            str = map.get(logField.toString());
        }
        return aVar.a(str);
    }

    private void f(String str, String str2) {
        List<IKVChangeListener> list = this.b.get(str);
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                list.get(i).onChange(str, str2);
            }
        }
        mq2.b(str, str2);
    }

    public static synchronized SystemConfigMgr i() {
        SystemConfigMgr systemConfigMgr;
        synchronized (SystemConfigMgr.class) {
            if (e == null) {
                e = new SystemConfigMgr();
            }
            systemConfigMgr = e;
        }
        return systemConfigMgr;
    }

    private List<xd0> k(Map<String, String> map) {
        ArrayList arrayList = new ArrayList(map.size());
        for (String str : map.keySet()) {
            c cVar = new c();
            cVar.a = str;
            cVar.b = map.get(str);
            arrayList.add(cVar);
        }
        return arrayList;
    }

    private void m(Map<String, String> map) {
        n(map);
        HashMap hashMap = new HashMap(this.a.size());
        hashMap.putAll(this.a);
        this.a.clear();
        this.a.putAll(map);
        for (String str : this.a.keySet()) {
            if ((this.a.get(str) == null && hashMap.get(str) != null) || (this.a.get(str) != null && !this.a.get(str).equalsIgnoreCase((String) hashMap.get(str)))) {
                f(str, this.a.get(str));
            }
            hashMap.remove(str);
        }
        for (String str2 : hashMap.keySet()) {
            f(str2, this.a.get(str2));
        }
    }

    private synchronized void n(Map<String, String> map) {
        Map<String, a> map2;
        a c2;
        if (map != null) {
            if (map.containsKey("delay")) {
                if ((this.a.get("delay") == null || !map.get("delay").equals(this.a.get("delay"))) && (map2 = this.d) != null) {
                    map2.clear();
                    try {
                        JSONObject jSONObject = new JSONObject(map.get("delay"));
                        Iterator<String> keys = jSONObject.keys();
                        if (keys != null) {
                            while (keys.hasNext()) {
                                String next = keys.next();
                                String string = jSONObject.getString(next);
                                if (!TextUtils.isEmpty(string) && (c2 = a.c(string)) != null) {
                                    this.d.put(next, c2);
                                }
                            }
                        } else {
                            return;
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }
        Map<String, a> map3 = this.d;
        if (map3 != null) {
            map3.clear();
        }
    }

    @Override // tb.vq2
    public String[] a() {
        return this.c;
    }

    @Override // tb.vq2
    public void c(String str, Map<String, String> map) {
        if ("utap_system".equalsIgnoreCase(str)) {
            m(map);
            Variables.n().k().b(c.class);
            Variables.n().k().q(k(this.a));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0042  */
    public synchronized boolean e(Map<String, String> map) {
        int i;
        Map<String, a> map2 = this.d;
        if (map2 != null) {
            if (map2.size() >= 1) {
                LogField logField = LogField.EVENTID;
                if (map.containsKey(logField.toString())) {
                    try {
                        i = Integer.parseInt(map.get(logField.toString()));
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    if (!this.d.containsKey(String.valueOf(i))) {
                        return d(map, i);
                    }
                    int i2 = i - (i % 10);
                    if (this.d.containsKey(String.valueOf(i2))) {
                        return d(map, i2);
                    }
                    int i3 = i2 - (i2 % 100);
                    if (this.d.containsKey(String.valueOf(i3))) {
                        return d(map, i3);
                    }
                    int i4 = i3 - (i3 % 1000);
                    if (this.d.containsKey(String.valueOf(i4))) {
                        return d(map, i4);
                    } else if (!this.d.containsKey(String.valueOf(-1))) {
                        return false;
                    } else {
                        return d(map, -1);
                    }
                }
                i = -1;
                if (!this.d.containsKey(String.valueOf(i))) {
                }
            }
        }
        return false;
    }

    public synchronized boolean g() {
        Map<String, a> map = this.d;
        if (map == null || map.size() <= 0) {
            return false;
        }
        return true;
    }

    public String h(String str) {
        return this.a.get(str);
    }

    public int j(String str) {
        String h = h(str);
        if (!TextUtils.isEmpty(h)) {
            try {
                return Integer.valueOf(h).intValue();
            } catch (Exception unused) {
            }
        }
        return 0;
    }

    public void l(String str, IKVChangeListener iKVChangeListener) {
        List<IKVChangeListener> list;
        synchronized (this.b) {
            if (this.b.get(str) == null) {
                list = new ArrayList<>();
            } else {
                list = this.b.get(str);
            }
            list.add(iKVChangeListener);
            this.b.put(str, list);
        }
    }
}
