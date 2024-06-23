package com.taobao.monitor.adapter.network;

import java.util.List;

/* compiled from: Taobao */
public interface ILiteDb {
    void delete();

    void insert(String str);

    List<String> select();
}
