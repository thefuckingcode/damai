package tb;

import java.util.List;

/* compiled from: Taobao */
public class sc2 {
    private final String a;
    private final int b;
    private final String c;
    private final long d;
    private List<pc2> e;

    public sc2(String str, int i, String str2, long j) {
        this.a = str;
        this.b = i;
        this.c = str2;
        this.d = j;
    }

    public pc2 a(String str) {
        List<pc2> list = this.e;
        if (list == null) {
            return null;
        }
        for (pc2 pc2 : list) {
            if (pc2.b().equals(str)) {
                return pc2;
            }
        }
        return null;
    }

    public List<pc2> b() {
        return this.e;
    }

    public String c() {
        return this.c;
    }

    public int d() {
        return this.b;
    }

    public void e(List<pc2> list) {
        this.e = list;
    }

    public long f() {
        return this.d;
    }

    public String g() {
        return this.a;
    }
}
