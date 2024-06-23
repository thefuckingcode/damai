package com.taobao.android.job.core.graph;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public interface CyclicChecker<T, R> {
    void detect(DependencyGraph<T, R> dependencyGraph) throws GraphCycleDetectedException;
}
