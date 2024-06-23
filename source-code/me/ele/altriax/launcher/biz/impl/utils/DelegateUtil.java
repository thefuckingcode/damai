package me.ele.altriax.launcher.biz.impl.utils;

import me.ele.altriax.launcher.biz.bridge.delegate.DMNormalInitDelegate;

/* compiled from: Taobao */
public class DelegateUtil {
    public static void init(DMNormalInitDelegate dMNormalInitDelegate) {
        if (dMNormalInitDelegate != null) {
            dMNormalInitDelegate.init();
        }
    }
}
