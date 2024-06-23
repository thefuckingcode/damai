package com.taobao.android.tlog.protocol.model.reply.base;

import java.util.LinkedHashMap;

/* compiled from: Taobao */
public class StorageInfo extends LinkedHashMap<String, String> {
    private static final long serialVersionUID = 1;

    public StorageInfo set(String str, String str2) {
        put(str, str2);
        return this;
    }
}
