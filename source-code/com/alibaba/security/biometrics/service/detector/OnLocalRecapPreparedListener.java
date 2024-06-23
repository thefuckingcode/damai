package com.alibaba.security.biometrics.service.detector;

/* compiled from: Taobao */
public interface OnLocalRecapPreparedListener {
    void onFailed(int i, Throwable th);

    void onProgressUpdate(int i);

    void onSucceeded(ILocalFaceRecap iLocalFaceRecap);
}
