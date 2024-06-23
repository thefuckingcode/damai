package me.ele.altriax.launcher.real.time.data.core;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.List;
import java.util.Map;
import tb.td2;
import tb.te0;

/* compiled from: Taobao */
public interface IUniversalRealTime {
    void setApmEvents(@Nullable List<te0> list);

    void setApmProperties(@Nullable Map<String, Object> map);

    void setApmStages(@Nullable List<td2> list);

    void setApmStart();

    void setApmStats(@Nullable Map<String, Object> map);

    void setBizEvent(@NonNull String str, @NonNull String str2);

    void setBizTime(@NonNull String str, long j);

    void setDagEnd();

    void setDagStart();

    void setFirstInstall(boolean z);

    void setFirstLaunch(boolean z);

    void setHomeStart();

    void setLaunchType(@Nullable String str);

    void setLauncherResumeTime();

    void setLauncherStartTime();

    void setMAC(long j);

    void setMAHead(long j);

    void setMATail(long j);

    void setMFront(long j);

    void setMLaunch(long j);

    void setRenderComplete(long j);

    void setRenderComplete(long j, long j2);
}
