package com.google.common.hash;

import com.google.common.annotations.Beta;
import java.io.Serializable;

@Beta
/* compiled from: Taobao */
public interface Funnel<T> extends Serializable {
    void funnel(T t, PrimitiveSink primitiveSink);
}
