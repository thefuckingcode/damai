package com.alient.oneservice.userinfo;

import android.content.Context;

/* compiled from: Taobao */
public interface LoginProvider {
    boolean checkSessionValid();

    void notifyLogin(Context context, YYLoginListener yYLoginListener);
}
