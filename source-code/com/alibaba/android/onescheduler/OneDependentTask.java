package com.alibaba.android.onescheduler;

/* compiled from: Taobao */
public interface OneDependentTask extends OneCommonTask {
    void after(OneDependentTask oneDependentTask);

    void removePredecessor(OneDependentTask oneDependentTask);

    void removeSuccessor(OneDependentTask oneDependentTask);
}
