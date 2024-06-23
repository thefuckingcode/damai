package android.taobao.windvane.jsbridge;

import android.content.Context;
import android.taobao.windvane.monitor.WVJSBrdigeMonitorInterface;
import android.taobao.windvane.monitor.WVMonitorService;
import android.taobao.windvane.util.TaoLog;
import android.taobao.windvane.webview.IWVWebView;
import android.taobao.windvane.webview.WVWebView;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import tb.jl1;

/* compiled from: Taobao */
public class WVPluginManager {
    public static final String KEY_METHOD = "method";
    public static final String KEY_NAME = "name";
    private static final String SEPARATOR = "::";
    private static final String TAG = "WVPluginManager";
    private static final Map<String, String> aliasPlugins = new ConcurrentHashMap();
    private static IJsBridgeService jsBridgeService = null;
    private static final Map<IWVWebView, Map<String, WVPluginInfo>> localPlugins = new ConcurrentHashMap();
    private static final Map<String, WVApiPlugin> objPlugins = new ConcurrentHashMap();
    private static final Map<String, WVPluginInfo> plugins = new ConcurrentHashMap();
    private static boolean skipMonitor;

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x006e, code lost:
        if (android.text.TextUtils.isEmpty(r3) != false) goto L_0x0070;
     */
    public static WVApiPlugin createPlugin(String str, Context context, IWVWebView iWVWebView) {
        WVPluginInfo wVPluginInfo;
        String str2;
        Class<?> cls;
        Class<? extends WVApiPlugin> bridgeClass;
        Map<String, WVPluginInfo> concurrentHashMap = new ConcurrentHashMap<>();
        if (iWVWebView != null) {
            concurrentHashMap = localPlugins.get(iWVWebView);
        }
        Map<String, WVApiPlugin> map = objPlugins;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        if (concurrentHashMap == null || !concurrentHashMap.containsKey(str)) {
            IJsBridgeService iJsBridgeService = jsBridgeService;
            if (iJsBridgeService == null || (bridgeClass = iJsBridgeService.getBridgeClass(str)) == null) {
                wVPluginInfo = null;
            } else {
                registerPlugin(str, bridgeClass, true);
                wVPluginInfo = plugins.get(str);
                if (wVPluginInfo == null || wVPluginInfo.getClassName() == null) {
                    return null;
                }
                wVPluginInfo.getClassName();
            }
        } else {
            wVPluginInfo = concurrentHashMap.get(str);
            if (wVPluginInfo == null) {
                TaoLog.i(TAG, "无局部API，尝试从全局API获取");
            } else {
                TaoLog.i(TAG, "使用局部API");
            }
        }
        if (wVPluginInfo != null) {
            str2 = wVPluginInfo.getClassName();
        }
        wVPluginInfo = plugins.get(str);
        if (wVPluginInfo == null || wVPluginInfo.getClassName() == null) {
            if (TaoLog.getLogStatus()) {
                TaoLog.w(TAG, "create plugin failed, plugin not register or empty, " + str);
            }
            return null;
        }
        str2 = wVPluginInfo.getClassName();
        try {
            ClassLoader classLoader = wVPluginInfo.getClassLoader();
            if (classLoader == null) {
                cls = Class.forName(str2);
            } else {
                cls = classLoader.loadClass(str2);
            }
            if (cls != null && WVApiPlugin.class.isAssignableFrom(cls)) {
                WVApiPlugin wVApiPlugin = (WVApiPlugin) cls.newInstance();
                if (wVPluginInfo.paramObj != null) {
                    wVApiPlugin.initialize(context, iWVWebView, wVPluginInfo.paramObj, str);
                } else if (iWVWebView instanceof WVWebView) {
                    wVApiPlugin.initialize(context, (WVWebView) iWVWebView, null, str);
                } else {
                    wVApiPlugin.initialize(context, iWVWebView, null, str);
                }
                return wVApiPlugin;
            }
        } catch (Exception e) {
            TaoLog.e(TAG, "create plugin error: " + str + ". " + e.getMessage());
        }
        if (TaoLog.getLogStatus()) {
            TaoLog.w(TAG, "create plugin failed: " + str);
        }
        return null;
    }

    public static Map<String, String> getOriginalPlugin(String str, String str2) {
        int indexOf;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            TaoLog.w(TAG, "getOriginalPlugin failed, alias is empty.");
            return null;
        }
        Map<String, String> map = aliasPlugins;
        String str3 = map.get(str + SEPARATOR + str2);
        if (TextUtils.isEmpty(str3) || (indexOf = str3.indexOf(SEPARATOR)) <= 0) {
            return null;
        }
        String substring = str3.substring(0, indexOf);
        String substring2 = str3.substring(indexOf + 2);
        HashMap hashMap = new HashMap();
        hashMap.put("name", substring);
        hashMap.put("method", substring2);
        return hashMap;
    }

    public static WVPluginInfo getPluginInfo(String str) {
        Map<String, WVPluginInfo> map = plugins;
        if (map == null) {
            return null;
        }
        return map.get(str);
    }

    public static void registerAlias(String str, String str2, String str3, String str4) {
        if (!plugins.containsKey(str3) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            TaoLog.w(TAG, "registerAlias quit, this is no original plugin or alias is invalid.");
        } else if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4)) {
            aliasPlugins.put(str + SEPARATOR + str2, str3 + SEPARATOR + str4);
        }
    }

    public static void registerLocalPlugin(IWVWebView iWVWebView, String str, Class<? extends WVApiPlugin> cls) {
        if (iWVWebView != null) {
            Map<IWVWebView, Map<String, WVPluginInfo>> map = localPlugins;
            Map<String, WVPluginInfo> map2 = map.get(iWVWebView);
            if (map2 == null) {
                map2 = new ConcurrentHashMap<>();
                map.put(iWVWebView, map2);
            }
            registerPlugin(str, cls, true, map2);
            TaoLog.i(TAG, "注册到局部API，使用范围=[" + iWVWebView.getClass().getSimpleName() + "],API=[" + str + SEPARATOR + cls.getSimpleName() + jl1.ARRAY_END_STR);
            return;
        }
        registerPlugin(str, cls);
    }

    public static void registerPlugin(String str, Class<? extends WVApiPlugin> cls) {
        registerPlugin(str, cls, true);
    }

    public static void registerPluginwithParam(String str, Class<? extends WVApiPlugin> cls, Object... objArr) {
        if (!TextUtils.isEmpty(str) && cls != null) {
            WVPluginInfo wVPluginInfo = new WVPluginInfo(cls.getName(), cls.getClassLoader());
            if (objArr != null) {
                wVPluginInfo.setParamObj(objArr);
            }
            plugins.put(str, wVPluginInfo);
            if (WVMonitorService.getJsBridgeMonitor() != null) {
                WVJSBrdigeMonitorInterface jsBridgeMonitor = WVMonitorService.getJsBridgeMonitor();
                jsBridgeMonitor.onJsBridgeReturn("HY_REGISTERPLUGIN", "", "HY_REGISTERPLUGIN", str + SEPARATOR + cls.getName(), "");
            }
        }
    }

    public static void registerWVJsBridgeService(IJsBridgeService iJsBridgeService) {
        jsBridgeService = iJsBridgeService;
    }

    public static void skipMnoitor(boolean z) {
        skipMonitor = z;
    }

    public static void unregisterAlias(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            TaoLog.w(TAG, "unregisterAlias quit, alias is invalid.");
            return;
        }
        Map<String, String> map = aliasPlugins;
        map.remove(str + SEPARATOR + str2);
    }

    public static void unregisterLocalPlugins(IWVWebView iWVWebView) {
        Map<IWVWebView, Map<String, WVPluginInfo>> map = localPlugins;
        if (map.get(iWVWebView) != null) {
            map.remove(iWVWebView);
        }
    }

    public static void unregisterPlugin(String str) {
        Map<String, WVPluginInfo> map = plugins;
        if (map.containsKey(str)) {
            map.remove(str);
            return;
        }
        Map<String, WVApiPlugin> map2 = objPlugins;
        if (map2.containsKey(str)) {
            map2.remove(str);
        }
    }

    /* compiled from: Taobao */
    public static class WVPluginInfo {
        private ClassLoader classLoader;
        private String className;
        private Object paramObj;

        WVPluginInfo(String str) {
            this.className = str;
        }

        public ClassLoader getClassLoader() {
            return this.classLoader;
        }

        public String getClassName() {
            return this.className;
        }

        public Object getParamObj() {
            return this.paramObj;
        }

        public void setClassLoader(ClassLoader classLoader2) {
            this.classLoader = classLoader2;
        }

        public void setClassName(String str) {
            this.className = str;
        }

        public void setParamObj(Object obj) {
            this.paramObj = obj;
        }

        WVPluginInfo(String str, ClassLoader classLoader2) {
            this.className = str;
            this.classLoader = classLoader2;
        }
    }

    public static String getPluginInfo() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, WVPluginInfo> entry : plugins.entrySet()) {
            sb.append(entry.getKey());
            sb.append("-");
            sb.append(entry.getValue().className);
            sb.append(",");
        }
        return sb.toString();
    }

    private static void registerPlugin(String str, Class<? extends WVApiPlugin> cls, boolean z, Map<String, WVPluginInfo> map) {
        if (!TextUtils.isEmpty(str) && cls != null) {
            ClassLoader classLoader = null;
            if (z) {
                classLoader = cls.getClassLoader();
            }
            map.put(str, new WVPluginInfo(cls.getName(), classLoader));
            if (!skipMonitor && WVMonitorService.getJsBridgeMonitor() != null) {
                WVJSBrdigeMonitorInterface jsBridgeMonitor = WVMonitorService.getJsBridgeMonitor();
                jsBridgeMonitor.onJsBridgeReturn("HY_REGISTERPLUGIN", TAG, "HY_REGISTERPLUGIN", str + SEPARATOR + cls.getName(), "");
            }
        }
    }

    public static void registerPlugin(String str, Class<? extends WVApiPlugin> cls, boolean z) {
        registerPlugin(str, cls, z, plugins);
    }

    @Deprecated
    public static void registerPlugin(String str, String str2) {
        registerPlugin(str, str2, (ClassLoader) null);
    }

    public static void registerPlugin(String str, Object obj) {
        try {
            if (obj instanceof WVApiPlugin) {
                objPlugins.put(str, (WVApiPlugin) obj);
            }
        } catch (Throwable th) {
            if (TaoLog.getLogStatus()) {
                TaoLog.e(TAG, "registerPlugin by Object error : " + th.getMessage());
            }
        }
    }

    @Deprecated
    public static void registerPlugin(String str, String str2, ClassLoader classLoader) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            plugins.put(str, new WVPluginInfo(str2, classLoader));
            if (WVMonitorService.getJsBridgeMonitor() != null) {
                WVJSBrdigeMonitorInterface jsBridgeMonitor = WVMonitorService.getJsBridgeMonitor();
                jsBridgeMonitor.onJsBridgeReturn("HY_REGISTERPLUGIN", "", "HY_REGISTERPLUGIN", str + SEPARATOR + str2, "");
            }
        }
    }

    public static void registerPlugin(String str, String str2, ClassLoader classLoader, Object... objArr) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            WVPluginInfo wVPluginInfo = new WVPluginInfo(str2, classLoader);
            wVPluginInfo.setParamObj(objArr);
            plugins.put(str, wVPluginInfo);
            if (WVMonitorService.getJsBridgeMonitor() != null) {
                WVJSBrdigeMonitorInterface jsBridgeMonitor = WVMonitorService.getJsBridgeMonitor();
                jsBridgeMonitor.onJsBridgeReturn("HY_REGISTERPLUGIN", "", "HY_REGISTERPLUGIN", str + SEPARATOR + str2, "");
            }
        }
    }
}
