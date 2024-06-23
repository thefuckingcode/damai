package tb;

/* compiled from: Taobao */
public class u21 {
    public String a;
    public long b;
    public String c;
    public String d;

    public u21() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof u21)) {
            return false;
        }
        u21 u21 = (u21) obj;
        String str = this.a;
        if (str == null ? u21.a != null : !str.equals(u21.a)) {
            return false;
        }
        String str2 = this.d;
        String str3 = u21.d;
        if (str2 != null) {
            if (!str2.equals(str3)) {
                return false;
            }
            return true;
        } else if (str3 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        String str = this.a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.d;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "Item{url='" + this.a + '\'' + ", size=" + this.b + ", md5='" + this.c + '\'' + ", name='" + this.d + '\'' + '}';
    }

    public u21(String str) {
        this.a = str;
    }
}
