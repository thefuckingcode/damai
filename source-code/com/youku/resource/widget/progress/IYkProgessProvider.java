package com.youku.resource.widget.progress;

/* compiled from: Taobao */
public interface IYkProgessProvider {

    /* compiled from: Taobao */
    public interface ProgressListener {
        void onComplete();

        void onFailed(String str);

        void updateProgress(int i);
    }

    void start(ProgressListener progressListener);
}
