package com.google.common.graph;

import com.google.common.annotations.Beta;

@Beta
/* compiled from: Taobao */
public interface PredecessorsFunction<N> {
    Iterable<? extends N> predecessors(N n);
}
