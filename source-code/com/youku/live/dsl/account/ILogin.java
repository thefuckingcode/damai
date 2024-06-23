package com.youku.live.dsl.account;

import android.content.Context;

/* compiled from: Taobao */
public interface ILogin {
    boolean isLogined();

    void login();

    void login(Context context);

    void logout();

    void registerLoginChangedListener(ILoginChangedListener iLoginChangedListener);

    void unregisterLoginChangedListener(ILoginChangedListener iLoginChangedListener);
}
