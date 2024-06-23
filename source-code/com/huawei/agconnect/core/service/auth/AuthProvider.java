package com.huawei.agconnect.core.service.auth;

import com.huawei.hmf.tasks.Task;

/* compiled from: Taobao */
public interface AuthProvider {
    void addTokenListener(OnTokenListener onTokenListener);

    Task<Token> getTokens();

    Task<Token> getTokens(boolean z);

    String getUid();

    void removeTokenListener(OnTokenListener onTokenListener);
}
