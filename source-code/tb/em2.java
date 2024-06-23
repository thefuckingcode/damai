package tb;

import io.reactivex.annotations.NonNull;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.TimeUnit;

/* compiled from: Taobao */
public final class em2<T> {
    final T a;
    final long b;
    final TimeUnit c;

    public em2(@NonNull T t, long j, @NonNull TimeUnit timeUnit) {
        this.a = t;
        this.b = j;
        this.c = (TimeUnit) ObjectHelper.requireNonNull(timeUnit, "unit is null");
    }

    public long a() {
        return this.b;
    }

    @NonNull
    public T b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof em2)) {
            return false;
        }
        em2 em2 = (em2) obj;
        if (!ObjectHelper.equals(this.a, em2.a) || this.b != em2.b || !ObjectHelper.equals(this.c, em2.c)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        T t = this.a;
        int hashCode = t != null ? t.hashCode() : 0;
        long j = this.b;
        return (((hashCode * 31) + ((int) (j ^ (j >>> 31)))) * 31) + this.c.hashCode();
    }

    public String toString() {
        return "Timed[time=" + this.b + ", unit=" + this.c + ", value=" + ((Object) this.a) + jl1.ARRAY_END_STR;
    }
}
