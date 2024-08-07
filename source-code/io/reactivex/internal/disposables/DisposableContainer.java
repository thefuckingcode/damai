package io.reactivex.internal.disposables;

import io.reactivex.disposables.Disposable;

/* compiled from: Taobao */
public interface DisposableContainer {
    boolean add(Disposable disposable);

    boolean delete(Disposable disposable);

    boolean remove(Disposable disposable);
}
