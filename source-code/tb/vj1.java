package tb;

import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.Nullable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.NotificationLite;

/* compiled from: Taobao */
public final class vj1<T> {
    static final vj1<Object> b = new vj1<>(null);
    final Object a;

    private vj1(Object obj) {
        this.a = obj;
    }

    @NonNull
    public static <T> vj1<T> a() {
        return (vj1<T>) b;
    }

    @NonNull
    public static <T> vj1<T> b(@NonNull Throwable th) {
        ObjectHelper.requireNonNull(th, "error is null");
        return new vj1<>(NotificationLite.error(th));
    }

    @NonNull
    public static <T> vj1<T> c(@NonNull T t) {
        ObjectHelper.requireNonNull(t, "value is null");
        return new vj1<>(t);
    }

    @Nullable
    public Throwable d() {
        Object obj = this.a;
        if (NotificationLite.isError(obj)) {
            return NotificationLite.getError(obj);
        }
        return null;
    }

    @Nullable
    public T e() {
        Object obj = this.a;
        if (obj == null || NotificationLite.isError(obj)) {
            return null;
        }
        return (T) this.a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof vj1) {
            return ObjectHelper.equals(this.a, ((vj1) obj).a);
        }
        return false;
    }

    public boolean f() {
        return this.a == null;
    }

    public boolean g() {
        return NotificationLite.isError(this.a);
    }

    public boolean h() {
        Object obj = this.a;
        return obj != null && !NotificationLite.isError(obj);
    }

    public int hashCode() {
        Object obj = this.a;
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    public String toString() {
        Object obj = this.a;
        if (obj == null) {
            return "OnCompleteNotification";
        }
        if (NotificationLite.isError(obj)) {
            return "OnErrorNotification[" + NotificationLite.getError(obj) + jl1.ARRAY_END_STR;
        }
        return "OnNextNotification[" + this.a + jl1.ARRAY_END_STR;
    }
}
