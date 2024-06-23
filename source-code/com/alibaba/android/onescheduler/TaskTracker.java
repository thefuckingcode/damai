package com.alibaba.android.onescheduler;

/* compiled from: Taobao */
public interface TaskTracker {
    void onCanceled(OneCommonTask oneCommonTask);

    void onExecute(OneCommonTask oneCommonTask);

    void onFinished(OneCommonTask oneCommonTask);

    void onSchedule(OneCommonTask oneCommonTask);

    void onStart(OneCommonTask oneCommonTask);
}
