package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

@GwtCompatible
/* compiled from: Taobao */
public interface FutureCallback<V> {
    void onFailure(Throwable th);

    void onSuccess(@NullableDecl V v);
}
