package com.taobao.phenix.loader.network;

import java.util.Map;
import java.util.concurrent.Future;
import tb.r02;

/* compiled from: Taobao */
public interface HttpLoader {

    /* compiled from: Taobao */
    public interface FinishCallback {
        void onError(Exception exc);

        void onFinished(r02 r02);
    }

    void connectTimeout(int i);

    Future<?> load(String str, Map<String, String> map, FinishCallback finishCallback);

    void readTimeout(int i);
}
