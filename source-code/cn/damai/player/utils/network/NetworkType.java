package cn.damai.player.utils.network;

import com.alibaba.analytics.core.network.NetworkUtil;

/* compiled from: Taobao */
public enum NetworkType {
    NETWORK_WIFI("WiFi"),
    NETWORK_4G("4G"),
    NETWORK_2G("2G"),
    NETWORK_3G("3G"),
    NETWORK_UNKNOWN(NetworkUtil.NETWORK_CLASS_UNKNOWN),
    NETWORK_NO("No network"),
    NETWORK_MOBILE("mobile");
    
    private String desc;

    private NetworkType(String str) {
        this.desc = str;
    }

    public String toString() {
        return this.desc;
    }
}
