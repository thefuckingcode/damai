package tb;

import io.reactivex.FlowableSubscriber;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.NonNull;
import io.reactivex.b;
import org.reactivestreams.Processor;

/* compiled from: Taobao */
public abstract class jl0<T> extends b<T> implements Processor<T, T>, FlowableSubscriber<T> {
    @CheckReturnValue
    @NonNull
    public final jl0<T> a() {
        if (this instanceof v82) {
            return this;
        }
        return new v82(this);
    }
}
