package com.google.common.graph;

import com.google.common.annotations.Beta;

@Beta
/* compiled from: Taobao */
public interface SuccessorsFunction<N> {
    Iterable<? extends N> successors(N n);
}
