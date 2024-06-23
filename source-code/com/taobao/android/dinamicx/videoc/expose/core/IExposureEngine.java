package com.taobao.android.dinamicx.videoc.expose.core;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: Taobao */
public interface IExposureEngine<ExposeKey, ExposeData> extends IExposureZoneRunner<ExposeKey, ExposeData> {
    void clearCache();

    void clearCache(@NonNull String str);

    void exposeCache();

    void exposeCache(@NonNull String str);

    void start();

    void start(@Nullable String str);

    void stop();

    void stop(@Nullable String str);

    void triggerExpose();

    void triggerExpose(@NonNull String str);

    void triggerExposeAtOnce();

    void triggerExposeAtOnce(@NonNull String str);
}
