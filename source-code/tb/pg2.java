package tb;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.d;

/* compiled from: Taobao */
public abstract class pg2<T> extends d<T> implements Observer<T> {
    @NonNull
    public final pg2<T> a() {
        if (this instanceof w82) {
            return this;
        }
        return new w82(this);
    }
}
