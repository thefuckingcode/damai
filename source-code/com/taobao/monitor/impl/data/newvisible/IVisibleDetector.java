package com.taobao.monitor.impl.data.newvisible;

import com.taobao.monitor.impl.data.IExecutor;

/* compiled from: Taobao */
public interface IVisibleDetector extends IExecutor {

    /* compiled from: Taobao */
    public interface IDetectorCallback {
        void onChanged(long j);

        void onCompleted(long j);

        void onLastChangedView(String str);

        void onValidElementChanged(int i);
    }
}
