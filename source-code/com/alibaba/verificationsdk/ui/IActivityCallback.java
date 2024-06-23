package com.alibaba.verificationsdk.ui;

import java.util.Map;

/* compiled from: Taobao */
public interface IActivityCallback {
    void onNotifyBackPressed();

    void onResult(int i, Map<String, String> map);
}
