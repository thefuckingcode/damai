package com.ut.mini.scene;

import com.ut.mini.UTAnalytics;
import com.ut.mini.module.plugin.UTPlugin;
import com.ut.mini.module.plugin.UTPluginMgr;
import java.util.Map;

/* compiled from: Taobao */
public class UTSceneMgr {
    public static void init() {
        UTPluginMgr.getInstance().registerPlugin(new UTPlugin() {
            /* class com.ut.mini.scene.UTSceneMgr.AnonymousClass1 */

            @Override // com.ut.mini.module.plugin.UTPlugin
            public int[] getAttentionEventIds() {
                return new int[]{2001};
            }

            @Override // com.ut.mini.module.plugin.UTPlugin
            public String getPluginName() {
                return "UTSceneTracker";
            }

            @Override // com.ut.mini.module.plugin.UTPlugin
            public Map<String, String> onEventDispatch(String str, int i, String str2, String str3, String str4, Map<String, String> map) {
                return UTAnalytics.getInstance().getUTSceneTracker().eventDispatch(map);
            }
        });
    }
}
