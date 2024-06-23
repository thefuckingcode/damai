package tb;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlinx.coroutines.InternalCoroutinesApi;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@InternalCoroutinesApi
/* compiled from: Taobao */
public abstract class j8<T> extends cl1 {
    private static final /* synthetic */ AtomicReferenceFieldUpdater a = AtomicReferenceFieldUpdater.newUpdater(j8.class, Object.class, "_consensus");
    @NotNull
    private volatile /* synthetic */ Object _consensus = i8.NO_DECISION;

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: tb.j8<T> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // tb.cl1
    @NotNull
    public j8<?> a() {
        return this;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // tb.cl1
    @Nullable
    public final Object c(@Nullable Object obj) {
        Object obj2 = this._consensus;
        if (obj2 == i8.NO_DECISION) {
            obj2 = e(i(obj));
        }
        d(obj, obj2);
        return obj2;
    }

    public abstract void d(T t, @Nullable Object obj);

    @Nullable
    public final Object e(@Nullable Object obj) {
        if (n30.a()) {
            if (!(obj != i8.NO_DECISION)) {
                throw new AssertionError();
            }
        }
        Object obj2 = this._consensus;
        Object obj3 = i8.NO_DECISION;
        if (obj2 != obj3) {
            return obj2;
        }
        if (a.compareAndSet(this, obj3, obj)) {
            return obj;
        }
        return this._consensus;
    }

    @Nullable
    public final Object f() {
        return this._consensus;
    }

    public long g() {
        return 0;
    }

    public final boolean h() {
        return this._consensus != i8.NO_DECISION;
    }

    @Nullable
    public abstract Object i(T t);
}
