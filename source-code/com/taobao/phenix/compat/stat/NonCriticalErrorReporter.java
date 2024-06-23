package com.taobao.phenix.compat.stat;

import java.util.Map;

/* compiled from: Taobao */
public interface NonCriticalErrorReporter {
    void onNonCriticalErrorHappen(String str, Throwable th, Map<String, Object> map);
}
