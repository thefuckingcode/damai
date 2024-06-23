package com.ali.user.mobile.service;

import android.content.Context;
import com.ali.user.mobile.callback.CommonDataCallback;

/* compiled from: Taobao */
public interface HuaweiService {
    void getAuthCode(CommonDataCallback commonDataCallback);

    void init(Context context);

    boolean isSessionValid();

    void launchAuth(Context context, CommonDataCallback commonDataCallback);
}
