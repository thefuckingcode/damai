package com.alibaba.aliweex.adapter;

import java.util.Map;

/* compiled from: Taobao */
public interface IGodEyeStageAdapter {
    void onError(String str, String str2, Map<String, Object> map);

    void onException(String str, String str2, Map<String, Object> map);

    void onStage(String str, Map<String, Object> map);
}
