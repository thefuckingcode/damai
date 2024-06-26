package mtopsdk.mtop.stat;

import androidx.annotation.NonNull;
import java.util.HashMap;

/* compiled from: Taobao */
public class MtopMonitor {
    private static volatile IMtopMonitor headerMonitor;
    private static volatile IMtopMonitor monitor;

    /* compiled from: Taobao */
    static class Proxy implements IMtopMonitor {
        IMtopMonitor mtopMonitor = null;

        public Proxy(IMtopMonitor iMtopMonitor) {
            this.mtopMonitor = iMtopMonitor;
        }

        @Override // mtopsdk.mtop.stat.IMtopMonitor
        public void onCommit(String str, HashMap<String, String> hashMap) {
            IMtopMonitor iMtopMonitor = this.mtopMonitor;
            if (iMtopMonitor != null) {
                iMtopMonitor.onCommit(str, hashMap);
            }
        }
    }

    public static void addHeaderMonitor(@NonNull IMtopMonitor iMtopMonitor) {
        headerMonitor = new Proxy(iMtopMonitor);
    }

    public static void addMtopMonitor(@NonNull IMtopMonitor iMtopMonitor) {
        monitor = new Proxy(iMtopMonitor);
    }

    public static IMtopMonitor getHeaderMonitor() {
        return headerMonitor;
    }

    public static IMtopMonitor getInstance() {
        return monitor;
    }
}
