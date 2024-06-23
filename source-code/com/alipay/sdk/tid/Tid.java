package com.alipay.sdk.tid;

import android.text.TextUtils;

/* compiled from: Taobao */
public class Tid {
    public final String key;
    public final String tid;
    public final long time;

    public Tid(String str, String str2, long j) {
        this.tid = str;
        this.key = str2;
        this.time = j;
    }

    public static boolean isEmpty(Tid tid2) {
        return tid2 == null || TextUtils.isEmpty(tid2.tid);
    }

    public String getTid() {
        return this.tid;
    }

    public String getTidSeed() {
        return this.key;
    }

    public long getTimestamp() {
        return this.time;
    }
}
