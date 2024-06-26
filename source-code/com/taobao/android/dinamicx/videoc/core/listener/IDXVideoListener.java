package com.taobao.android.dinamicx.videoc.core.listener;

import androidx.annotation.NonNull;
import com.taobao.android.dinamicx.videoc.core.IDXVideoController;

/* compiled from: Taobao */
public interface IDXVideoListener {
    void onCanPlay(@NonNull IDXVideoController<?, IDXVideoListener> iDXVideoController, @NonNull String str);

    void onShouldStop(@NonNull IDXVideoController<?, IDXVideoListener> iDXVideoController, @NonNull String str);
}
