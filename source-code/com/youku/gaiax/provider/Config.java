package com.youku.gaiax.provider;

import com.alibaba.fastjson.JSONObject;
import com.youku.gaiax.EnvConfig;
import com.youku.gaiax.IEnvConfig;
import com.youku.gaiax.provider.module.GaiaXProxyApp;
import com.youku.gaiax.provider.module.GaiaXProxyDesignToken;
import com.youku.gaiax.provider.module.GaiaXProxyFeatures;
import com.youku.gaiax.provider.module.GaiaXProxyMonitor;
import com.youku.gaiax.provider.module.GaiaXProxyNet;
import com.youku.gaiax.provider.module.GaiaXProxyPrefs;
import com.youku.gaiax.provider.module.GaiaXProxySource;
import com.youku.gaiax.provider.module.GaiaXProxyTask;
import com.youku.gaiax.provider.module.GaiaXProxyViews;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, d2 = {"Lcom/youku/gaiax/provider/Config;", "Lcom/youku/gaiax/IEnvConfig;", "Lcom/alibaba/fastjson/JSONObject;", "getConfigs", "<init>", "()V", "GaiaX-Provider-DM"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class Config implements IEnvConfig {
    @Override // com.youku.gaiax.IEnvConfig
    @NotNull
    public JSONObject getConfigs() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put((Object) EnvConfig.CONFIG_MODULE_APP_KEY, (Object) GaiaXProxyApp.class.getName());
        jSONObject.put((Object) EnvConfig.CONFIG_MODULE_VIEWS_KEY, (Object) GaiaXProxyViews.class.getName());
        jSONObject.put((Object) EnvConfig.CONFIG_MODULE_TASK_KEY, (Object) GaiaXProxyTask.class.getName());
        jSONObject.put((Object) EnvConfig.CONFIG_MODULE_PREFS_KEY, (Object) GaiaXProxyPrefs.class.getName());
        jSONObject.put((Object) EnvConfig.CONFIG_MODULE_SOURCE_CLASS_KEY, (Object) GaiaXProxySource.class.getName());
        jSONObject.put((Object) EnvConfig.CONFIG_MODULE_DESIGN_TOKEN_KEY, (Object) GaiaXProxyDesignToken.class.getName());
        jSONObject.put((Object) EnvConfig.CONFIG_MODULE_NET_KEY, (Object) GaiaXProxyNet.class.getName());
        jSONObject.put((Object) EnvConfig.CONFIG_MODULE_FEATURES_KEY, (Object) GaiaXProxyFeatures.class.getName());
        jSONObject.put((Object) EnvConfig.CONFIG_MODULE_MONITOR_KEY, (Object) GaiaXProxyMonitor.class.getName());
        return jSONObject;
    }
}
