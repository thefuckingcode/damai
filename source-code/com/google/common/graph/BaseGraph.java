package com.google.common.graph;

import java.util.Set;
import tb.td0;

/* compiled from: Taobao */
interface BaseGraph<N> extends SuccessorsFunction<N>, PredecessorsFunction<N> {
    Set<N> adjacentNodes(N n);

    boolean allowsSelfLoops();

    int degree(N n);

    Set<td0<N>> edges();

    boolean hasEdgeConnecting(N n, N n2);

    boolean hasEdgeConnecting(td0<N> td0);

    int inDegree(N n);

    Set<td0<N>> incidentEdges(N n);

    boolean isDirected();

    ElementOrder<N> nodeOrder();

    Set<N> nodes();

    int outDegree(N n);

    @Override // com.google.common.graph.PredecessorsFunction
    Set<N> predecessors(N n);

    @Override // com.google.common.graph.SuccessorsFunction
    Set<N> successors(N n);
}
