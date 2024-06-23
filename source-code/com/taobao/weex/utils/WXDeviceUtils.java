package com.taobao.weex.utils;

import android.content.Context;
import com.taobao.weex.WXSDKManager;
import com.taobao.weex.adapter.IWXFoldDeviceAdapter;

/* compiled from: Taobao */
public class WXDeviceUtils {
    public static boolean isAutoResize(Context context) {
        IWXFoldDeviceAdapter E = WXSDKManager.v().E();
        if (E == null) {
            return false;
        }
        if (E.isFoldDevice() || E.isMateX() || E.isGalaxyFold()) {
            return true;
        }
        return false;
    }
}
