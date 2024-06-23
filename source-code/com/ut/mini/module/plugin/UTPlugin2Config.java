package com.ut.mini.module.plugin;

import java.util.List;
import java.util.Map;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class UTPlugin2Config {
    Map<String, Map<String, Object>> plugin2ConfigMap;

    UTPlugin2Config() {
    }

    /* access modifiers changed from: package-private */
    public boolean containPluginName(String str) {
        Map<String, Map<String, Object>> map = this.plugin2ConfigMap;
        if (map == null) {
            return false;
        }
        return map.containsKey(str);
    }

    /* access modifiers changed from: package-private */
    public List<String> getUtparamCntList(String str) {
        Map<String, Object> map;
        if (!containPluginName(str) || (map = this.plugin2ConfigMap.get(str)) == null) {
            return null;
        }
        try {
            return (List) map.get("utparam-cnt");
        } catch (Exception unused) {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public List<String> getWritableKeyList(String str) {
        Map<String, Object> map;
        if (!containPluginName(str) || (map = this.plugin2ConfigMap.get(str)) == null) {
            return null;
        }
        try {
            return (List) map.get("wk");
        } catch (Exception unused) {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean isSync(String str) {
        if (!containPluginName(str)) {
            return true;
        }
        Map<String, Object> map = this.plugin2ConfigMap.get(str);
        if (map == null) {
            return false;
        }
        return "1".equalsIgnoreCase((String) map.get("sync"));
    }
}
