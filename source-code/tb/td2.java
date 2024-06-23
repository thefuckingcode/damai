package tb;

/* compiled from: Taobao */
public class td2 {
    private final String a;
    private final long b;

    public td2(String str, long j) {
        this.a = str;
        this.b = j;
    }

    public String a() {
        return this.a;
    }

    public long b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || td2.class != obj.getClass()) {
            return false;
        }
        td2 td2 = (td2) obj;
        String str = this.a;
        if (str == null || !str.equals(td2.a)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.a;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return this.a;
    }
}
