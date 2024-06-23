package tb;

import android.text.TextUtils;
import java.io.File;
import java.net.URL;

/* compiled from: Taobao */
public class lb2 {
    public boolean a;
    public int b;
    public String c;
    public String d;
    public u21 e;
    public io1 f;
    public String g;
    public a h = new a(this);

    /* compiled from: Taobao */
    public class a {
        private int a;
        private int b;

        public a(lb2 lb2) {
        }

        public void a(boolean z) {
            if (z) {
                this.a++;
            } else {
                this.b++;
            }
        }
    }

    public String a() {
        if (!TextUtils.isEmpty(this.e.d)) {
            return this.e.d;
        }
        try {
            return new File(new URL(this.e.a).getFile()).getName();
        } catch (Throwable unused) {
            return this.e.a;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof lb2)) {
            return false;
        }
        lb2 lb2 = (lb2) obj;
        u21 u21 = this.e;
        if (u21 == null ? lb2.e != null : !u21.equals(lb2.e)) {
            return false;
        }
        String str = this.g;
        String str2 = lb2.g;
        if (str != null) {
            if (!str.equals(str2)) {
                return false;
            }
            return true;
        } else if (str2 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        u21 u21 = this.e;
        int i = 0;
        int hashCode = (u21 != null ? u21.hashCode() : 0) * 31;
        String str = this.g;
        if (str != null) {
            i = str.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return super.toString() + "@Task{" + "success=" + this.a + ", errorCode=" + this.b + ", errorMsg='" + this.c + '\'' + ", item=" + this.e + ", storeDir='" + this.g + '\'' + '}';
    }
}
