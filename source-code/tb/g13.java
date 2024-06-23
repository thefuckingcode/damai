package tb;

import com.uploader.implement.b.e;
import com.uploader.implement.c;

/* compiled from: Taobao */
public abstract class g13 {
    public final String a;
    public final int b;
    public final String c;
    public final int d;
    public final boolean e;

    public g13(String str, int i, String str2, int i2, boolean z) {
        this.a = str;
        this.b = i;
        this.c = str2;
        this.d = i2;
        this.e = z;
    }

    public abstract e a(c cVar);

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g13)) {
            return false;
        }
        g13 g13 = (g13) obj;
        if (this.b != g13.b || this.d != g13.d || this.e != g13.e) {
            return false;
        }
        String str = this.a;
        if (str == null ? g13.a != null : !str.equals(g13.a)) {
            return false;
        }
        String str2 = this.c;
        String str3 = g13.c;
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

    public String toString() {
        return "ConnectionTarget{address='" + this.a + '\'' + ", port=" + this.b + ", proxyIp='" + this.c + '\'' + ", proxyPort=" + this.d + ", isLongLived=" + this.e + '}';
    }
}
