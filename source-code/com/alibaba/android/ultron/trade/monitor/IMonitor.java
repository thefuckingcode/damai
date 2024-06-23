package com.alibaba.android.ultron.trade.monitor;

/* compiled from: Taobao */
public interface IMonitor {
    String getCurrentPage();

    long getMaxThreshold();

    long getStartMonitorTime();

    boolean isMonitorStart();

    void setMonitorStart(boolean z);
}
