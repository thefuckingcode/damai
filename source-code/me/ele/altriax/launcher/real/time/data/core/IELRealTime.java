package me.ele.altriax.launcher.real.time.data.core;

import androidx.annotation.NonNull;

/* compiled from: Taobao */
public interface IELRealTime extends IELUniversalRealTime, IUniversalRealTime {
    void setH5ActivityStart();

    @Override // me.ele.altriax.launcher.real.time.data.core.IUniversalRealTime
    void setHomeStart();

    void setLoadUrlStart(@NonNull String str);

    void setPageFinished(@NonNull String str);

    void setT1End(@NonNull String str);
}
