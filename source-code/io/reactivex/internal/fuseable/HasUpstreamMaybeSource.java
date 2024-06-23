package io.reactivex.internal.fuseable;

import io.reactivex.MaybeSource;

/* compiled from: Taobao */
public interface HasUpstreamMaybeSource<T> {
    MaybeSource<T> source();
}
