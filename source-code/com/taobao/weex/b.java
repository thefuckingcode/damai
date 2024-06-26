package com.taobao.weex;

import android.util.Pair;
import com.taobao.weex.adapter.IWXUserTrackAdapter;
import com.taobao.weex.bridge.ModuleFactory;
import com.taobao.weex.bridge.WXEaglePlugin;
import com.taobao.weex.common.WXRenderStrategy;
import com.taobao.weex.ui.IFComponentHolder;
import com.taobao.weex.utils.WXSoInstallMgrSdk;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
public class b {
    private Map<String, WXEaglePlugin> a;
    private Map<String, Pair<IFComponentHolder, Map<String, Object>>> b;
    private Map<String, Pair<ModuleFactory, Boolean>> c;

    /* access modifiers changed from: private */
    /* renamed from: com.taobao.weex.b$b  reason: collision with other inner class name */
    /* compiled from: Taobao */
    public static class C0232b {
        private static final b a = new b();
    }

    public static b b() {
        return C0232b.a;
    }

    static String d(WXRenderStrategy wXRenderStrategy) {
        if (wXRenderStrategy == WXRenderStrategy.DATA_RENDER) {
            return "EagleVue";
        }
        if (wXRenderStrategy == WXRenderStrategy.DATA_RENDER_BINARY) {
            return "EagleRax";
        }
        return null;
    }

    static WXRenderStrategy e(String str) {
        str.hashCode();
        if (str.equals("EagleRax")) {
            return WXRenderStrategy.DATA_RENDER_BINARY;
        }
        if (!str.equals("EagleVue")) {
            return null;
        }
        return WXRenderStrategy.DATA_RENDER;
    }

    public Pair<String, WXEaglePlugin> a(String str) {
        for (Map.Entry<String, WXEaglePlugin> entry : this.a.entrySet()) {
            String isSupportedUrl = entry.getValue().isSupportedUrl(str);
            if (isSupportedUrl != null) {
                return Pair.create(isSupportedUrl, entry.getValue());
            }
        }
        return null;
    }

    public WXEaglePlugin c(String str) {
        if (str == null) {
            return null;
        }
        return this.a.get(str);
    }

    /* access modifiers changed from: package-private */
    public void f(int i, IWXUserTrackAdapter iWXUserTrackAdapter) {
        for (WXEaglePlugin wXEaglePlugin : this.a.values()) {
            WXSoInstallMgrSdk.initSo(wXEaglePlugin.getSoLibName(), i, iWXUserTrackAdapter);
        }
    }

    public void g(String str, IFComponentHolder iFComponentHolder, Map<String, Object> map) {
        this.b.put(str, Pair.create(iFComponentHolder, map));
        for (WXEaglePlugin wXEaglePlugin : this.a.values()) {
            wXEaglePlugin.registerComponent(str, iFComponentHolder, map);
        }
    }

    public void h(String str, ModuleFactory moduleFactory, boolean z) {
        this.c.put(str, Pair.create(moduleFactory, Boolean.valueOf(z)));
        for (WXEaglePlugin wXEaglePlugin : this.a.values()) {
            wXEaglePlugin.registerModules(str, moduleFactory, z);
        }
    }

    private b() {
        this.a = new ConcurrentHashMap();
        this.b = new ConcurrentHashMap();
        this.c = new ConcurrentHashMap();
    }
}
