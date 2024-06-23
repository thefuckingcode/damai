package com.taobao.weex.bridge;

import android.util.SparseArray;

/* compiled from: Taobao */
class ResultCallbackManager {
    private static SparseArray<ResultCallback> mResultCallbacks = new SparseArray<>();
    private static long sCallbackId;

    ResultCallbackManager() {
    }

    static long generateCallbackId(ResultCallback resultCallback) {
        if (sCallbackId >= 2147483647L) {
            sCallbackId = 0;
        }
        long j = sCallbackId;
        sCallbackId = 1 + j;
        int i = (int) j;
        mResultCallbacks.put(i, resultCallback);
        return (long) i;
    }

    static ResultCallback removeCallbackById(long j) {
        int i = (int) j;
        ResultCallback resultCallback = mResultCallbacks.get(i);
        mResultCallbacks.remove(i);
        return resultCallback;
    }
}
