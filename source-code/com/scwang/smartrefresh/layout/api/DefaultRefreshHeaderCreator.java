package com.scwang.smartrefresh.layout.api;

import android.content.Context;
import androidx.annotation.NonNull;

/* compiled from: Taobao */
public interface DefaultRefreshHeaderCreator {
    @NonNull
    RefreshHeader createRefreshHeader(@NonNull Context context, @NonNull RefreshLayout refreshLayout);
}
