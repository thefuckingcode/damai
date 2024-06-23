package com.alibaba.security.biometrics.jni.listener;

/* compiled from: Taobao */
public interface OnSgProcessListener {
    String getAppKey();

    String sign(String str);
}
