package tb;

import android.os.Build;
import androidx.annotation.NonNull;
import java.lang.Comparable;
import java.util.Arrays;
import java.util.Objects;

/* compiled from: Taobao */
public final class sw1<T extends Comparable<? super T>> {
    private final T a;
    private final T b;

    public sw1(@NonNull T t, @NonNull T t2) {
        if (t == null) {
            throw new IllegalArgumentException("lower must not be null");
        } else if (t2 != null) {
            this.a = t;
            this.b = t2;
            if (t.compareTo(t2) > 0) {
                throw new IllegalArgumentException("lower must be less than or equal to upper");
            }
        } else {
            throw new IllegalArgumentException("upper must not be null");
        }
    }

    public static <T extends Comparable<? super T>> sw1<T> c(T t, T t2) {
        return new sw1<>(t, t2);
    }

    public boolean a(@NonNull T t) {
        if (t != null) {
            boolean z = t.compareTo(this.a) >= 0;
            boolean z2 = t.compareTo(this.b) <= 0;
            if (!z || !z2) {
                return false;
            }
            return true;
        }
        throw new IllegalArgumentException("value must not be null");
    }

    public boolean b(@NonNull sw1<T> sw1) {
        if (sw1 != null) {
            boolean z = sw1.a.compareTo(this.a) >= 0;
            boolean z2 = sw1.b.compareTo(this.b) <= 0;
            if (!z || !z2) {
                return false;
            }
            return true;
        }
        throw new IllegalArgumentException("value must not be null");
    }

    public T d() {
        return this.a;
    }

    public T e() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof sw1)) {
            return false;
        }
        sw1 sw1 = (sw1) obj;
        if (!this.a.equals(sw1.a) || !this.b.equals(sw1.b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        if (Build.VERSION.SDK_INT >= 19) {
            return Objects.hash(this.a, this.b);
        }
        return Arrays.hashCode(new Object[]{this.a, this.b});
    }

    public String toString() {
        return String.format("[%s, %s]", this.a, this.b);
    }
}
