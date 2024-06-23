package tb;

import android.os.Debug;

/* compiled from: Taobao */
public class c70 {
    public static final String TAG = "DeviceRuntimeInfo";
    public long a;
    public long b;
    public String c;

    public static c70 a() {
        c70 c70 = new c70();
        try {
            Runtime runtime = Runtime.getRuntime();
            c70.a = (runtime.totalMemory() >> 20) - (runtime.freeMemory() >> 20);
        } catch (Throwable unused) {
            c70.a = -1;
        }
        try {
            c70.b = Debug.getPss() >> 10;
        } catch (Throwable unused2) {
            c70.b = -1;
        }
        return c70;
    }

    public c70 b(String str) {
        this.c = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(30);
        sb.append("lc=");
        sb.append(this.c);
        sb.append("|java=");
        sb.append(this.a);
        sb.append("|pss=");
        sb.append(this.b);
        return sb.toString();
    }
}
