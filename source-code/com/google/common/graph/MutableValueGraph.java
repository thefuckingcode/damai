package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import tb.td0;

@Beta
/* compiled from: Taobao */
public interface MutableValueGraph<N, V> extends ValueGraph<N, V> {
    @CanIgnoreReturnValue
    boolean addNode(N n);

    @CanIgnoreReturnValue
    V putEdgeValue(N n, N n2, V v);

    @CanIgnoreReturnValue
    V putEdgeValue(td0<N> td0, V v);

    @CanIgnoreReturnValue
    V removeEdge(N n, N n2);

    @CanIgnoreReturnValue
    V removeEdge(td0<N> td0);

    @CanIgnoreReturnValue
    boolean removeNode(N n);
}
