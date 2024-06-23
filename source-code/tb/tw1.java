package tb;

import android.os.Build;
import androidx.annotation.NonNull;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.lang.Comparable;
import java.util.Arrays;
import java.util.Objects;

/* compiled from: Taobao */
public final class tw1<T extends Comparable<? super T>> {
    private static transient /* synthetic */ IpChange $ipChange;
    private final T a;
    private final T b;

    public tw1(@NonNull T t, @NonNull T t2) {
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

    public static <T extends Comparable<? super T>> tw1<T> a(T t, T t2) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-986488266")) {
            return new tw1<>(t, t2);
        }
        return (tw1) ipChange.ipc$dispatch("-986488266", new Object[]{t, t2});
    }

    public T b() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1846022397")) {
            return this.a;
        }
        return (T) ((Comparable) ipChange.ipc$dispatch("-1846022397", new Object[]{this}));
    }

    public boolean equals(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1171354912")) {
            return ((Boolean) ipChange.ipc$dispatch("-1171354912", new Object[]{this, obj})).booleanValue();
        } else if (obj == null) {
            return false;
        } else {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof tw1)) {
                return false;
            }
            tw1 tw1 = (tw1) obj;
            if (!this.a.equals(tw1.a) || !this.b.equals(tw1.b)) {
                return false;
            }
            return true;
        }
    }

    public int hashCode() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1475100311")) {
            return ((Integer) ipChange.ipc$dispatch("1475100311", new Object[]{this})).intValue();
        } else if (Build.VERSION.SDK_INT >= 19) {
            return Objects.hash(this.a, this.b);
        } else {
            return Arrays.hashCode(new Object[]{this.a, this.b});
        }
    }

    public String toString() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-840587699")) {
            return (String) ipChange.ipc$dispatch("-840587699", new Object[]{this});
        }
        return String.format("[%s, %s]", this.a, this.b);
    }
}
