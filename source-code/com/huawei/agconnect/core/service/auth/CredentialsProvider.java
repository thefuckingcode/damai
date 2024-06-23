package com.huawei.agconnect.core.service.auth;

import com.huawei.hmf.tasks.Task;

/* compiled from: Taobao */
public interface CredentialsProvider {
    Task<Token> getTokens();

    Task<Token> getTokens(boolean z);
}
