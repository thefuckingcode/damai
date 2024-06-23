package tb;

import java.util.Arrays;

/* compiled from: Taobao */
public class kg2 {
    public String[] a;

    public kg2(String[] strArr) {
        this.a = strArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || kg2.class != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.a, ((kg2) obj).a);
    }

    public int hashCode() {
        return Arrays.hashCode(this.a);
    }

    public String toString() {
        return "SubKey{podNames=" + Arrays.toString(this.a) + '}';
    }
}
