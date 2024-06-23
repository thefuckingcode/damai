package com.youku.live.widgets.render;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class RenderMananger {
    private static transient /* synthetic */ IpChange $ipChange;
    private RenderHandler mRenderHandler = new RenderHandler();
    private WorkerThread mWorkHandler = new WorkerThread("LiveWidgetKit::WorkThread");

    public void postOnUiThread(Runnable runnable, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2093641663")) {
            ipChange.ipc$dispatch("-2093641663", new Object[]{this, runnable, Long.valueOf(j)});
            return;
        }
        this.mRenderHandler.postDelayed(WorkerThread.secure(runnable), j);
    }

    public void postOnWorkerThread(Runnable runnable, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "140846763")) {
            ipChange.ipc$dispatch("140846763", new Object[]{this, runnable, Long.valueOf(j)});
            return;
        }
        this.mWorkHandler.getHandler().postDelayed(WorkerThread.secure(runnable), j);
    }

    public void postOnUiThread(Runnable runnable, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1786812909")) {
            ipChange.ipc$dispatch("1786812909", new Object[]{this, runnable, str});
            return;
        }
        this.mRenderHandler.post(str, WorkerThread.secure(runnable));
    }

    public void postOnWorkerThread(Runnable runnable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1944205113")) {
            ipChange.ipc$dispatch("1944205113", new Object[]{this, runnable});
            return;
        }
        this.mWorkHandler.getHandler().post(WorkerThread.secure(runnable));
    }

    public void postOnUiThread(Runnable runnable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-483179805")) {
            ipChange.ipc$dispatch("-483179805", new Object[]{this, runnable});
            return;
        }
        this.mRenderHandler.post(WorkerThread.secure(runnable));
    }
}
