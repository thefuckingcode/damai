package com.youku.playerservice.axp.utils;

import com.ali.user.open.core.Site;

/* compiled from: Taobao */
public enum ClientType {
    LAIFENG(Site.LAIFENG_NEW),
    YOUKU("youku"),
    YOUKU_HWBAIPAI("youku_hwbaipai"),
    DAMAI("damai"),
    OTHER("other");
    
    private String value;

    private ClientType(String str) {
        this.value = str;
    }

    public String getValue() {
        return this.value;
    }
}
