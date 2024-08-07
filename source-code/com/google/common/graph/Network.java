package com.google.common.graph;

import com.google.common.annotations.Beta;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import tb.td0;

@Beta
/* compiled from: Taobao */
public interface Network<N, E> extends SuccessorsFunction<N>, PredecessorsFunction<N> {
    Set<E> adjacentEdges(E e);

    Set<N> adjacentNodes(N n);

    boolean allowsParallelEdges();

    boolean allowsSelfLoops();

    Graph<N> asGraph();

    int degree(N n);

    @NullableDecl
    E edgeConnectingOrNull(N n, N n2);

    @NullableDecl
    E edgeConnectingOrNull(td0<N> td0);

    ElementOrder<E> edgeOrder();

    Set<E> edges();

    Set<E> edgesConnecting(N n, N n2);

    Set<E> edgesConnecting(td0<N> td0);

    boolean equals(@NullableDecl Object obj);

    boolean hasEdgeConnecting(N n, N n2);

    boolean hasEdgeConnecting(td0<N> td0);

    int hashCode();

    int inDegree(N n);

    Set<E> inEdges(N n);

    Set<E> incidentEdges(N n);

    td0<N> incidentNodes(E e);

    boolean isDirected();

    ElementOrder<N> nodeOrder();

    Set<N> nodes();

    int outDegree(N n);

    Set<E> outEdges(N n);

    @Override // com.google.common.graph.PredecessorsFunction
    Set<N> predecessors(N n);

    @Override // com.google.common.graph.SuccessorsFunction
    Set<N> successors(N n);
}
