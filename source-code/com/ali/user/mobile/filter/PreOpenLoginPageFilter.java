package com.ali.user.mobile.filter;

import android.content.Context;
import android.content.Intent;
import com.ali.user.mobile.callback.DataCallback;

/* compiled from: Taobao */
public interface PreOpenLoginPageFilter {
    void handleIntent(Context context, Intent intent, DataCallback<Intent> dataCallback);
}
