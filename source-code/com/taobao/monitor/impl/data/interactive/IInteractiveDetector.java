package com.taobao.monitor.impl.data.interactive;

import com.taobao.monitor.impl.data.IExecutor;

/* compiled from: Taobao */
public interface IInteractiveDetector extends IExecutor {

    /* compiled from: Taobao */
    public interface IDetectorCallback {
        void onCompleted(long j);
    }
}
