package com.youku.live.dago.widgetlib.ailpchat;

import com.taobao.weex.annotation.JSMethod;

/* compiled from: Taobao */
public enum ConnectState {
    CONNECTED("connected", 1),
    DISCONNECTED("disconnected", 2),
    UNKONW("unkown", 3);
    
    private int index;
    private String name;

    private ConnectState(String str, int i) {
        this.name = str;
        this.index = i;
    }

    public String toString() {
        return this.index + JSMethod.NOT_SET + this.name;
    }
}
