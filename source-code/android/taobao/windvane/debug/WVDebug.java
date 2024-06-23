package android.taobao.windvane.debug;

import android.taobao.windvane.jsbridge.WVApiPlugin;
import android.taobao.windvane.jsbridge.WVPluginManager;
import android.taobao.windvane.jsbridge.api.WVDevelopTool;

/* compiled from: Taobao */
public class WVDebug {
    private static boolean isInited;

    public static synchronized void init() {
        synchronized (WVDebug.class) {
            if (!isInited) {
                WVPluginManager.registerPlugin("WVDevelopTool", (Class<? extends WVApiPlugin>) WVDevelopTool.class);
                isInited = true;
            }
        }
    }
}
