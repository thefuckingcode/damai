package com.alibaba.aliweex.adapter.component;

import android.text.TextUtils;
import com.alibaba.aliweex.IConfigAdapter;
import com.alibaba.aliweex.a;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.ui.action.BasicComponentData;
import com.taobao.weex.ui.component.WXEmbed;
import com.taobao.weex.ui.component.WXVContainer;
import com.taobao.weex.utils.WXUtils;

/* compiled from: Taobao */
public class AliWXEmbed extends WXEmbed {
    private static final String CONFIG_GROUP = "AliWXEmbed";

    public AliWXEmbed(WXSDKInstance wXSDKInstance, WXVContainer wXVContainer, String str, boolean z, BasicComponentData basicComponentData) {
        super(wXSDKInstance, wXVContainer, str, z, basicComponentData);
        doConfigEmbed(wXSDKInstance);
    }

    private void doConfigEmbed(WXSDKInstance wXSDKInstance) {
        IConfigAdapter c = a.l().c();
        if (c != null) {
            String config = c.getConfig(CONFIG_GROUP, "black_domain", "");
            if (!TextUtils.isEmpty(config)) {
                String bundleUrl = getInstance().getBundleUrl();
                if (!TextUtils.isEmpty(bundleUrl)) {
                    String[] split = config.split(",");
                    for (String str : split) {
                        if (!TextUtils.isEmpty(bundleUrl) && bundleUrl.contains(str)) {
                            setStrategy("none");
                            return;
                        }
                    }
                }
            }
            String config2 = c.getConfig(CONFIG_GROUP, "weex_embed_memory_strategy", "normal");
            if (TextUtils.isEmpty(config2) || "none".equals(config2)) {
                setStrategy("none");
                return;
            }
            String config3 = c.getConfig(CONFIG_GROUP, "weex_embed_count", "5");
            if (TextUtils.isEmpty(config3)) {
                wXSDKInstance.setMaxHiddenEmbedsNum(-1);
            } else {
                wXSDKInstance.setMaxHiddenEmbedsNum(WXUtils.getInteger(config3, -1).intValue());
            }
        }
    }

    @Override // com.taobao.weex.ui.component.WXEmbed, com.taobao.weex.ui.component.NestedContainer
    public void reload() {
        WXSDKInstance wXSDKInstance;
        IConfigAdapter c = a.l().c();
        if ((c == null || !TextUtils.equals(c.getConfig("android_weex_ext_config", "embed_reload_destroy", Boolean.TRUE.toString()), Boolean.FALSE.toString())) && (wXSDKInstance = this.mNestedInstance) != null) {
            wXSDKInstance.destroy();
            this.mNestedInstance = null;
        }
        super.reload();
    }

    public AliWXEmbed(WXSDKInstance wXSDKInstance, WXVContainer wXVContainer, BasicComponentData basicComponentData) {
        super(wXSDKInstance, wXVContainer, basicComponentData);
        doConfigEmbed(wXSDKInstance);
    }
}
