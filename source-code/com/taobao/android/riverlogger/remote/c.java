package com.taobao.android.riverlogger.remote;

import com.taobao.android.riverlogger.RVLLevel;
import com.taobao.android.riverlogger.RVLLogInterface;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class c implements RVLLogInterface {
    private static final AtomicBoolean a = new AtomicBoolean(true);

    c() {
    }

    @Override // com.taobao.android.riverlogger.RVLLogInterface
    public void log(com.taobao.android.riverlogger.c cVar) {
        String str;
        RemoteChannel c = b.c();
        if (c != null) {
            if (a.compareAndSet(true, false)) {
                c.j(String.format("{\"method\":\"Dev.log\",\"params\":{\"level\":\"Error\",\"module\":\"LOGGER/CLIENT_RESTART_MARK\",\"time\":%d}}", Long.valueOf(System.currentTimeMillis())));
            }
            String a2 = cVar.a();
            if (cVar.j) {
                str = a2.substring(1);
            } else {
                str = String.format("\"time\":%d,\"ext\":%s}", Long.valueOf(System.currentTimeMillis()), JSONObject.quote(a2));
            }
            c.j(String.format("{\"method\":\"Dev.log\",\"params\":{\"level\":\"%s\",\"module\":\"%s\",%s}", cVar.a.toString(), cVar.b, str));
        }
    }

    @Override // com.taobao.android.riverlogger.RVLLogInterface
    public RVLLevel logLevel() {
        if (b.c() != null) {
            return RVLLevel.Verbose;
        }
        return RVLLevel.Off;
    }
}
