package com.alibaba.motu.crashreporter;

import java.util.Map;

/* compiled from: Taobao */
public interface ICrashReportDataListener {
    void onCrashCaught(Map<String, Object> map);
}
