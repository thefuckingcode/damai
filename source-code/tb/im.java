package tb;

import io.reactivex.annotations.NonNull;
import io.reactivex.b;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.operators.flowable.FlowableAutoConnect;
import io.reactivex.internal.operators.flowable.FlowableRefCount;
import io.reactivex.internal.util.ConnectConsumer;

/* compiled from: Taobao */
public abstract class im<T> extends b<T> {
    @NonNull
    public b<T> autoConnect() {
        return autoConnect(1);
    }

    public final Disposable connect() {
        ConnectConsumer connectConsumer = new ConnectConsumer();
        connect(connectConsumer);
        return connectConsumer.disposable;
    }

    public abstract void connect(@NonNull Consumer<? super Disposable> consumer);

    @NonNull
    public b<T> refCount() {
        return k22.l(new FlowableRefCount(this));
    }

    @NonNull
    public b<T> autoConnect(int i) {
        return autoConnect(i, Functions.emptyConsumer());
    }

    @NonNull
    public b<T> autoConnect(int i, @NonNull Consumer<? super Disposable> consumer) {
        if (i > 0) {
            return k22.l(new FlowableAutoConnect(this, i, consumer));
        }
        connect(consumer);
        return k22.q(this);
    }
}
