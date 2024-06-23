package me.ele.altriax.launcher.real.time.data;

import android.app.Application;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.taobao.monitor.adapter.TBAPMAdapterSubTaskManager;
import me.ele.altriax.launcher.common.AltriaXLaunchTime;
import me.ele.altriax.launcher.common.AltriaXTrace;

@Deprecated
/* compiled from: Taobao */
public abstract class AltriaXMonitorX {
    private final AltriaXRealTime altriaXRealTime = AltriaXRealTime.getInstance();
    protected final Application application;
    private final String taskName;

    public AltriaXMonitorX(@NonNull Application application2, @NonNull String str) {
        this.taskName = str;
        this.application = application2;
    }

    public void end() {
        TBAPMAdapterSubTaskManager.f(this.taskName);
    }

    public abstract void innerRun();

    public void run() {
        start();
        AltriaXTrace.beginSection(this.taskName);
        long uptimeMillis = SystemClock.uptimeMillis();
        try {
            innerRun();
        } catch (Throwable th) {
            AltriaXLaunchTime.v(th.getMessage());
        }
        this.altriaXRealTime.setBizTime(this.taskName, SystemClock.uptimeMillis() - uptimeMillis);
        AltriaXTrace.endSection();
        end();
    }

    public void start() {
        TBAPMAdapterSubTaskManager.g(this.taskName);
    }
}
