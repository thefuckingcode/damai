package com.huawei.agconnect;

import com.huawei.agconnect.core.service.auth.Token;
import com.huawei.hmf.tasks.Task;

/* compiled from: Taobao */
public interface CustomCredentialsProvider {
    Task<Token> getTokens(boolean z);
}
