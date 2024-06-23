package com.alibaba.android.bindingx.core;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Map;
import tb.ag0;

/* compiled from: Taobao */
public interface IEventInterceptor {
    void performInterceptIfNeeded(@NonNull String str, @NonNull ag0 ag0, @NonNull Map<String, Object> map);

    void setInterceptors(@Nullable Map<String, ag0> map);
}
