package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import tb.td0;

@Beta
/* compiled from: Taobao */
public interface MutableNetwork<N, E> extends Network<N, E> {
    @CanIgnoreReturnValue
    boolean addEdge(N n, N n2, E e);

    @CanIgnoreReturnValue
    boolean addEdge(td0<N> td0, E e);

    @CanIgnoreReturnValue
    boolean addNode(N n);

    @CanIgnoreReturnValue
    boolean removeEdge(E e);

    @CanIgnoreReturnValue
    boolean removeNode(N n);
}
