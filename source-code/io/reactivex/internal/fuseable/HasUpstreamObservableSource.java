package io.reactivex.internal.fuseable;

import io.reactivex.ObservableSource;

/* compiled from: Taobao */
public interface HasUpstreamObservableSource<T> {
    ObservableSource<T> source();
}
