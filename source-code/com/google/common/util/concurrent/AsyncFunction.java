package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

@GwtCompatible
/* compiled from: Taobao */
public interface AsyncFunction<I, O> {
    ListenableFuture<O> apply(@NullableDecl I i) throws Exception;
}
