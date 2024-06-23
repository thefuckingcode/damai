package com.alibaba.security.biometrics.service.listener;

/* compiled from: Taobao */
public interface OnSensorTrackListener {
    void onSensorReset();

    void onSensorStart();

    void onSensorStop();
}
