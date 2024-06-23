package com.alibaba.analytics.core.store;

import java.util.List;
import tb.u81;

/* compiled from: Taobao */
public interface ILogStore {
    void clear();

    int clearOldLogByCount(int i);

    int clearOldLogByField(String str, String str2);

    int count();

    int delete(List<u81> list);

    List<u81> get(int i);

    double getDbFileSize();

    boolean insert(List<u81> list);

    void update(List<u81> list);

    void updateLogPriority(List<u81> list);
}
