package com.taobao.update.datasource;

import com.taobao.update.datasource.data.UpdateDataListener;

/* compiled from: Taobao */
public interface IUpdater {
    void dispatchUpdate(String str, boolean z, String str2, String... strArr);

    String from();

    void registerDataListener(UpdateDataListener updateDataListener);

    void unRegisterDataListener(UpdateDataListener updateDataListener);
}
