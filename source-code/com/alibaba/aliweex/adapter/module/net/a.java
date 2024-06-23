package com.alibaba.aliweex.adapter.module.net;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: Taobao */
public class a {
    @Nullable
    public static IWXConnection a(@NonNull Context context) {
        if (context == null) {
            return null;
        }
        return new DefaultWXConnection(context);
    }
}
