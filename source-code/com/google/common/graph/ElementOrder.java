package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.errorprone.annotations.Immutable;

@Immutable
@Beta
/* compiled from: Taobao */
public final class ElementOrder<T> {

    /* compiled from: Taobao */
    public enum Type {
        UNORDERED,
        INSERTION,
        SORTED
    }
}
