package tb;

import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.airbnb.lottie.model.KeyPathElement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: Taobao */
public class z51 {
    public static final z51 COMPOSITION = new z51("COMPOSITION");
    private final List<String> a;
    @Nullable
    private KeyPathElement b;

    public z51(String... strArr) {
        this.a = Arrays.asList(strArr);
    }

    private boolean b() {
        List<String> list = this.a;
        return list.get(list.size() - 1).equals("**");
    }

    private boolean f(String str) {
        return "__container".equals(str);
    }

    @CheckResult
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public z51 a(String str) {
        z51 z51 = new z51(this);
        z51.a.add(str);
        return z51;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean c(String str, int i) {
        if (i >= this.a.size()) {
            return false;
        }
        boolean z = i == this.a.size() - 1;
        String str2 = this.a.get(i);
        if (!str2.equals("**")) {
            boolean z2 = str2.equals(str) || str2.equals(jl1.MUL);
            if ((z || (i == this.a.size() - 2 && b())) && z2) {
                return true;
            }
            return false;
        }
        if (!z && this.a.get(i + 1).equals(str)) {
            if (i == this.a.size() - 2 || (i == this.a.size() - 3 && b())) {
                return true;
            }
            return false;
        } else if (z) {
            return true;
        } else {
            int i2 = i + 1;
            if (i2 < this.a.size() - 1) {
                return false;
            }
            return this.a.get(i2).equals(str);
        }
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public KeyPathElement d() {
        return this.b;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public int e(String str, int i) {
        if (f(str)) {
            return 0;
        }
        if (!this.a.get(i).equals("**")) {
            return 1;
        }
        if (i != this.a.size() - 1 && this.a.get(i + 1).equals(str)) {
            return 2;
        }
        return 0;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean g(String str, int i) {
        if (f(str)) {
            return true;
        }
        if (i >= this.a.size()) {
            return false;
        }
        if (this.a.get(i).equals(str) || this.a.get(i).equals("**") || this.a.get(i).equals(jl1.MUL)) {
            return true;
        }
        return false;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean h(String str, int i) {
        if (!"__container".equals(str) && i >= this.a.size() - 1 && !this.a.get(i).equals("**")) {
            return false;
        }
        return true;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public z51 i(KeyPathElement keyPathElement) {
        z51 z51 = new z51(this);
        z51.b = keyPathElement;
        return z51;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("KeyPath{keys=");
        sb.append(this.a);
        sb.append(",resolved=");
        sb.append(this.b != null);
        sb.append('}');
        return sb.toString();
    }

    private z51(z51 z51) {
        this.a = new ArrayList(z51.a);
        this.b = z51.b;
    }
}
