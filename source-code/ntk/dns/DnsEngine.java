package ntk.dns;

import android.content.Context;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;

@Keep
/* compiled from: Taobao */
public class DnsEngine {
    private Context mAppContext;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class b {
        private static final DnsEngine a = new DnsEngine();
    }

    static {
        System.loadLibrary("ntkhttp");
        System.loadLibrary("ntk");
    }

    private DnsEngine() {
        dns_init();
    }

    private native void dns_init();

    public static DnsEngine getInstance() {
        return b.a;
    }

    public native String dumpDnsCacheInfo(String str);

    public native String dumpTcpInfo();

    public void init(@NonNull Context context) {
        this.mAppContext = context.getApplicationContext();
    }

    public native String[] lookUp(String str);
}
