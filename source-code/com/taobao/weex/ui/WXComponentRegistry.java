package com.taobao.weex.ui;

import android.text.TextUtils;
import com.taobao.weex.WXSDKManager;
import com.taobao.weex.b;
import com.taobao.weex.bridge.WXBridgeManager;
import com.taobao.weex.common.WXException;
import com.taobao.weex.utils.WXLogUtils;
import com.taobao.weex.utils.cache.RegisterCache;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
public class WXComponentRegistry {
    private static ArrayList<Map<String, Object>> sComponentInfos = new ArrayList<>();
    private static Map<String, IFComponentHolder> sTypeComponentMap = new ConcurrentHashMap();

    public static IFComponentHolder getComponent(String str) {
        return sTypeComponentMap.get(str);
    }

    public static synchronized boolean registerComponent(Map<String, RegisterCache.ComponentCache> map) {
        synchronized (WXComponentRegistry.class) {
            if (map.isEmpty()) {
                return true;
            }
            final Iterator<Map.Entry<String, RegisterCache.ComponentCache>> it = map.entrySet().iterator();
            WXBridgeManager.getInstance().post(new Runnable() {
                /* class com.taobao.weex.ui.WXComponentRegistry.AnonymousClass1 */

                public void run() {
                    ArrayList arrayList = new ArrayList();
                    while (it.hasNext()) {
                        try {
                            RegisterCache.ComponentCache componentCache = (RegisterCache.ComponentCache) ((Map.Entry) it.next()).getValue();
                            Map map = componentCache.componentInfo;
                            if (map == null) {
                                map = new HashMap();
                            }
                            map.put("type", componentCache.type);
                            map.put("methods", componentCache.holder.getMethods());
                            WXComponentRegistry.registerNativeComponent(componentCache.type, componentCache.holder);
                            WXComponentRegistry.sComponentInfos.add(map);
                            arrayList.add(map);
                        } catch (WXException e) {
                            e.printStackTrace();
                        }
                    }
                    WXSDKManager.v().P(arrayList);
                }
            });
            return true;
        }
    }

    /* access modifiers changed from: private */
    public static boolean registerJSComponent(Map<String, Object> map) throws WXException {
        ArrayList arrayList = new ArrayList();
        arrayList.add(map);
        WXSDKManager.v().P(arrayList);
        return true;
    }

    static boolean registerNativeComponent(String str, IFComponentHolder iFComponentHolder) throws WXException {
        try {
            iFComponentHolder.loadIfNonLazy();
            sTypeComponentMap.put(str, iFComponentHolder);
            return true;
        } catch (ArrayStoreException e) {
            e.printStackTrace();
            return true;
        }
    }

    public static void reload() {
        WXBridgeManager.getInstance().post(new Runnable() {
            /* class com.taobao.weex.ui.WXComponentRegistry.AnonymousClass3 */

            public void run() {
                try {
                    Iterator it = WXComponentRegistry.sComponentInfos.iterator();
                    while (it.hasNext()) {
                        WXComponentRegistry.registerJSComponent((Map) it.next());
                    }
                } catch (WXException e) {
                    WXLogUtils.e("", e);
                }
            }
        });
    }

    public static synchronized boolean registerComponent(final String str, final IFComponentHolder iFComponentHolder, final Map<String, Object> map) throws WXException {
        synchronized (WXComponentRegistry.class) {
            if (iFComponentHolder != null) {
                if (!TextUtils.isEmpty(str)) {
                    b.b().g(str, iFComponentHolder, map);
                    if (RegisterCache.getInstance().cacheComponent(str, iFComponentHolder, map)) {
                        return true;
                    }
                    WXBridgeManager.getInstance().post(new Runnable() {
                        /* class com.taobao.weex.ui.WXComponentRegistry.AnonymousClass2 */

                        public void run() {
                            try {
                                Map map = map;
                                if (map == null) {
                                    map = new HashMap();
                                }
                                map.put("type", str);
                                map.put("methods", iFComponentHolder.getMethods());
                                WXComponentRegistry.registerNativeComponent(str, iFComponentHolder);
                                WXComponentRegistry.registerJSComponent(map);
                                WXComponentRegistry.sComponentInfos.add(map);
                            } catch (WXException e) {
                                WXLogUtils.e("register component error:", e);
                            }
                        }
                    });
                    return true;
                }
            }
            return false;
        }
    }
}
