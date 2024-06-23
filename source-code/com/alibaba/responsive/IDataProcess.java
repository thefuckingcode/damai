package com.alibaba.responsive;

/* compiled from: Taobao */
public interface IDataProcess<T> {
    T getMappingConfig(T t);

    boolean isDisplayNumConfig(T t);

    boolean isFilterConfig(T t);

    boolean isMergeConfig(T t);
}
