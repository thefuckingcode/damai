package com.google.common.graph;

import com.google.common.annotations.Beta;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import tb.td0;

@Beta
/* compiled from: Taobao */
public interface Graph<N> extends BaseGraph<N> {
    @Override // com.google.common.graph.BaseGraph
    Set<N> adjacentNodes(N n);

    @Override // com.google.common.graph.BaseGraph
    boolean allowsSelfLoops();

    @Override // com.google.common.graph.BaseGraph
    int degree(N n);

    @Override // com.google.common.graph.BaseGraph
    Set<td0<N>> edges();

    boolean equals(@NullableDecl Object obj);

    @Override // com.google.common.graph.BaseGraph
    boolean hasEdgeConnecting(N n, N n2);

    @Override // com.google.common.graph.BaseGraph
    boolean hasEdgeConnecting(td0<N> td0);

    int hashCode();

    @Override // com.google.common.graph.BaseGraph
    int inDegree(N n);

    @Override // com.google.common.graph.BaseGraph
    Set<td0<N>> incidentEdges(N n);

    @Override // com.google.common.graph.BaseGraph
    boolean isDirected();

    @Override // com.google.common.graph.BaseGraph
    ElementOrder<N> nodeOrder();

    @Override // com.google.common.graph.BaseGraph
    Set<N> nodes();

    @Override // com.google.common.graph.BaseGraph
    int outDegree(N n);

    @Override // com.google.common.graph.BaseGraph, com.google.common.graph.PredecessorsFunction
    Set<N> predecessors(N n);

    @Override // com.google.common.graph.BaseGraph, com.google.common.graph.SuccessorsFunction
    Set<N> successors(N n);
}
