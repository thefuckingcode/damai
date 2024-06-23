package io.reactivex.internal.fuseable;

import io.reactivex.SingleSource;

/* compiled from: Taobao */
public interface HasUpstreamSingleSource<T> {
    SingleSource<T> source();
}
