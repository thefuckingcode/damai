package tb;

import io.reactivex.annotations.NonNull;
import io.reactivex.d;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.operators.observable.ObservableAutoConnect;
import io.reactivex.internal.operators.observable.ObservableRefCount;
import io.reactivex.internal.util.ConnectConsumer;

/* compiled from: Taobao */
public abstract class jm<T> extends d<T> {
    @NonNull
    public d<T> autoConnect() {
        return autoConnect(1);
    }

    public final Disposable connect() {
        ConnectConsumer connectConsumer = new ConnectConsumer();
        connect(connectConsumer);
        return connectConsumer.disposable;
    }

    public abstract void connect(@NonNull Consumer<? super Disposable> consumer);

    @NonNull
    public d<T> refCount() {
        return k22.n(new ObservableRefCount(this));
    }

    @NonNull
    public d<T> autoConnect(int i) {
        return autoConnect(i, Functions.emptyConsumer());
    }

    @NonNull
    public d<T> autoConnect(int i, @NonNull Consumer<? super Disposable> consumer) {
        if (i > 0) {
            return k22.n(new ObservableAutoConnect(this, i, consumer));
        }
        connect(consumer);
        return k22.r(this);
    }
}
