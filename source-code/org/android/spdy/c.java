package org.android.spdy;

import anet.channel.status.NetworkStatusHelper;

/* compiled from: Taobao */
class c {
    static boolean a() {
        try {
            return NetworkStatusHelper.i().isMobile();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    static boolean b() {
        try {
            return NetworkStatusHelper.i().isWifi();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
