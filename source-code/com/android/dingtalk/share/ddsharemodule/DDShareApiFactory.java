package com.android.dingtalk.share.ddsharemodule;

import android.content.Context;

/* compiled from: Taobao */
public class DDShareApiFactory {
    public static IDDShareApi createDDShareApi(Context context, String str, boolean z) {
        return new DDShareApiV2(context, str, z);
    }
}
