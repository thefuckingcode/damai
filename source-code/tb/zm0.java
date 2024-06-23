package tb;

import androidx.annotation.RestrictTo;
import java.util.List;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* compiled from: Taobao */
public class zm0 {
    private final List<o92> a;
    private final char b;
    private final double c;
    private final String d;
    private final String e;

    public zm0(List<o92> list, char c2, double d2, double d3, String str, String str2) {
        this.a = list;
        this.b = c2;
        this.c = d3;
        this.d = str;
        this.e = str2;
    }

    public static int c(char c2, String str, String str2) {
        return ((((0 + c2) * 31) + str.hashCode()) * 31) + str2.hashCode();
    }

    public List<o92> a() {
        return this.a;
    }

    public double b() {
        return this.c;
    }

    public int hashCode() {
        return c(this.b, this.e, this.d);
    }
}
