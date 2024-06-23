package tb;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
public class vy0 extends r33<Map<String, String>> {
    public static final int REQUEST_ERROR_DEFAULT = -1;
    public static final int REQUEST_ERROR_NETWORK_DISCONNECT = -2;
    public static final int REQUEST_ERROR_SOCKET_TIMEOUT = -3;

    public vy0() {
        this.d = (T) new HashMap();
    }

    public String a() {
        return !this.d.containsKey("biz_code") ? "" : (String) this.d.get("biz_code");
    }

    public int b() {
        return this.b;
    }

    public String c() {
        return !this.d.containsKey("req_url") ? "" : (String) this.d.get("req_url");
    }

    public void d(@NonNull String str) {
        this.d.put("biz_code", str);
    }

    public void e(int i) {
        this.a = (i >= 200 && i < 300) || i == 304;
        this.b = i;
    }

    public void f(@NonNull String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        if (str.contains("?")) {
            str = str.substring(0, str.indexOf("?"));
        }
        this.d.put("req_url", str);
    }

    public String toString() {
        return "HttpResponse {succ=" + this.a + ", code=" + this.b + ", data='" + this.c + '\'' + ", extra=" + ((Object) this.d) + '}';
    }
}
