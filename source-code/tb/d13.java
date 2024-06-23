package tb;

import android.net.NetworkInfo;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.efs.sdk.base.IConfigRefreshAction;
import com.efs.sdk.base.a.c.a.c;
import com.efs.sdk.base.a.h.b.b;
import java.util.HashMap;

/* compiled from: Taobao */
public final class d13 implements IConfigRefreshAction {

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class a {
        private static final d13 a = new d13();
    }

    public static d13 a() {
        return a.a;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00b3, code lost:
        r0 = "config request succ, config is:\n ".concat(java.lang.String.valueOf(r4));
     */
    @Override // com.efs.sdk.base.IConfigRefreshAction
    @NonNull
    public final String refresh() {
        String concat;
        NetworkInfo a2 = j53.a(com.efs.sdk.base.a.d.a.a().c);
        int i = 0;
        String str = "";
        if (!(a2 != null && a2.isConnected() && a2.getState() == NetworkInfo.State.CONNECTED)) {
            concat = "Config refresh fail, network is disconnected.";
        } else {
            String b = c.a().b(true);
            b33 a3 = b33.a();
            while (true) {
                if (i >= 3) {
                    break;
                }
                r03 c = r03.c();
                String b2 = a3.b();
                String str2 = b + "/api/v1/config";
                if (c.a) {
                    t43.a("efs.px.api", "get config from server, url is ".concat(String.valueOf(str2)));
                }
                HashMap hashMap = new HashMap(1);
                hashMap.put("wpk-header", b2);
                com.efs.sdk.base.a.h.b.c a4 = new b(str2).c(hashMap).d(z13.d()).a();
                a4.a.e = gl1.TYPE_OPEN_URL_METHOD_GET;
                vy0 vy0 = (vy0) a4.a();
                if (vy0.a) {
                    str = vy0.c;
                    break;
                } else if (TextUtils.isEmpty(vy0.a()) || !"1000".equals(vy0.a())) {
                    return str;
                } else {
                    i++;
                }
            }
            return str;
        }
        t43.a("efs.config", concat);
        return str;
    }
}
