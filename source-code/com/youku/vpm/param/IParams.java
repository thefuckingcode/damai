package com.youku.vpm.param;

import java.util.Map;

/* compiled from: Taobao */
public interface IParams<K, V> {
    Map<K, V> getData();

    String getString();

    String getValue(String str);

    void putAll(IParams iParams);
}
