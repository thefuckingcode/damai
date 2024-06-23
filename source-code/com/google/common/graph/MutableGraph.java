package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import tb.td0;

@Beta
/* compiled from: Taobao */
public interface MutableGraph<N> extends Graph<N> {
    @CanIgnoreReturnValue
    boolean addNode(N n);

    @CanIgnoreReturnValue
    boolean putEdge(N n, N n2);

    @CanIgnoreReturnValue
    boolean putEdge(td0<N> td0);

    @CanIgnoreReturnValue
    boolean removeEdge(N n, N n2);

    @CanIgnoreReturnValue
    boolean removeEdge(td0<N> td0);

    @CanIgnoreReturnValue
    boolean removeNode(N n);
}
