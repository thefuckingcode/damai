package com.ut.mini.behavior.config;

import com.alibaba.analytics.core.config.UTClientConfigMgr;
import com.alibaba.analytics.utils.Logger;
import com.alibaba.fastjson.JSON;
import java.util.Map;
import tb.zf2;

/* compiled from: Taobao */
public class UTBehaviorConfigListener implements UTClientConfigMgr.IConfigChangeListener {
    private static final String KEY = "ut_event";
    private static final String KEY_CONFIG_DIR = "config_dir";

    private UTBehaviorConfigListener() {
    }

    static void init() {
        UTClientConfigMgr.d().f(new UTBehaviorConfigListener());
    }

    private void parseConfig(String str) {
        String str2;
        Logger.f("UTBehaviorConfigListener", "parseConfig value", str);
        long j = 0;
        String str3 = "";
        if (!zf2.f(str)) {
            try {
                Map map = (Map) JSON.parseObject(str, Map.class);
                if (map == null || map.size() <= 0) {
                    str2 = str3;
                } else {
                    str2 = str3 + map.get(KEY_CONFIG_DIR);
                }
                if (!zf2.f(str2)) {
                    j = Long.parseLong(str2.substring(str2.lastIndexOf("/") + 1));
                }
                str3 = str2;
            } catch (Exception unused) {
            }
        }
        UTBehaviorConfigMgr.updateConfig(str3, j);
    }

    @Override // com.alibaba.analytics.core.config.UTClientConfigMgr.IConfigChangeListener
    public String getKey() {
        return KEY;
    }

    @Override // com.alibaba.analytics.core.config.UTClientConfigMgr.IConfigChangeListener
    public void onChange(String str) {
        parseConfig(str);
    }
}
