package com.alibaba.analytics.core.config;

import com.alibaba.analytics.core.Variables;
import com.alibaba.analytics.core.config.SystemConfigMgr;

@Deprecated
/* compiled from: Taobao */
public class a implements SystemConfigMgr.IKVChangeListener {
    public static final String KEY = "sw_plugin";

    @Override // com.alibaba.analytics.core.config.SystemConfigMgr.IKVChangeListener
    public void onChange(String str, String str2) {
        if (KEY.equalsIgnoreCase(str)) {
            boolean z = false;
            try {
                z = Boolean.parseBoolean(str2);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (z) {
                Variables.n().o0();
            }
        }
    }
}
