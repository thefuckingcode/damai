package com.taobao.android.job.core.graph;

/* compiled from: Taobao */
public interface DependencyAware<T> {
    void addAsDependencyToAllInitialNodes(T t);

    void addAsDependentOnAllLeafNodes(T t);

    void addDependency(T t, T t2);

    void addIndependent(T t);
}
