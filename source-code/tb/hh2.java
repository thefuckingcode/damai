package tb;

import android.text.TextUtils;
import com.taobao.downloader.adpater.CloundConfigAdapter;
import com.taobao.downloader.download.protocol.DLConnection;

/* compiled from: Taobao */
public class hh2 {
    private static boolean a(long j, up upVar) {
        CloundConfigAdapter cloundConfigAdapter = cm.j;
        if (cloundConfigAdapter == null) {
            return true;
        }
        boolean equals = "".equals(cloundConfigAdapter.getConfig("dlconnection_anet"));
        String config = cm.j.getConfig("sizeSwitch_anet");
        boolean z = !"".equals(cm.j.getConfig("lastUseHuc_anet"));
        int intValue = (TextUtils.isEmpty(config) || !TextUtils.isDigitsOnly(config)) ? 0 : Integer.valueOf(config).intValue();
        if (equals && (0 == j || j > ((long) intValue))) {
            if (!z) {
                return true;
            }
            if (upVar.d() || upVar.e()) {
                return false;
            }
            return true;
        }
        return false;
    }

    public static DLConnection b(u21 u21, up upVar) {
        if (cm.l == null) {
            return new ut0();
        }
        if (a(u21.b, upVar)) {
            try {
                return (DLConnection) cm.l.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            }
        }
        return new ut0();
    }

    public static int c() {
        CloundConfigAdapter cloundConfigAdapter = cm.j;
        if (cloundConfigAdapter == null) {
            return up.f;
        }
        String config = cloundConfigAdapter.getConfig("dl_buffersize");
        if (TextUtils.isEmpty(config) || !TextUtils.isDigitsOnly(config)) {
            return up.f;
        }
        return Integer.valueOf(config).intValue();
    }
}
