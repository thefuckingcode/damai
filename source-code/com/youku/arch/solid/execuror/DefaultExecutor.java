package com.youku.arch.solid.execuror;

import android.os.Handler;
import android.os.HandlerThread;
import androidx.annotation.NonNull;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.concurrent.Executor;

/* compiled from: Taobao */
public class DefaultExecutor implements Executor {
    private static transient /* synthetic */ IpChange $ipChange;
    private final Handler mHandler;

    public DefaultExecutor() {
        HandlerThread handlerThread = new HandlerThread("SolidDefaultExecutor");
        handlerThread.start();
        this.mHandler = new Handler(handlerThread.getLooper());
    }

    public void execute(@NonNull Runnable runnable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1134820087")) {
            ipChange.ipc$dispatch("1134820087", new Object[]{this, runnable});
            return;
        }
        this.mHandler.post(runnable);
    }
}
