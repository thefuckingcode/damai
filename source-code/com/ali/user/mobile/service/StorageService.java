package com.ali.user.mobile.service;

import android.content.Context;

/* compiled from: Taobao */
public interface StorageService {
    String get(String str);

    String getAppKey(int i);

    void init(Context context);

    void put(String str, String str2);

    void remove(String str);
}
