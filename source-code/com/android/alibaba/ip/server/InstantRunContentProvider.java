package com.android.alibaba.ip.server;

import tb.p6;

/* compiled from: Taobao */
public final class InstantRunContentProvider extends PreferencesProvider {
    @Override // com.android.alibaba.ip.server.PreferencesProvider
    public String getAuthorities() {
        return p6.a + "." + InstantRunContentProvider.class.getName();
    }

    @Override // com.android.alibaba.ip.server.PreferencesProvider
    public boolean onCreate() {
        super.onCreate();
        InstantPatcher.create(getContext());
        return true;
    }
}
