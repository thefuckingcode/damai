package tb;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.efs.sdk.base.a.h.b.b;
import com.youku.usercenter.passport.RefreshTask;
import io.flutter.wpkbridge.WPKFactory;
import java.io.File;
import java.util.HashMap;
import org.json.JSONObject;

/* compiled from: Taobao */
public final class r03 {
    private static volatile long b = -1;
    public boolean a;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class a {
        private static final r03 a = new r03((byte) 0);
    }

    private r03() {
        this.a = true;
    }

    /* synthetic */ r03(byte b2) {
        this();
    }

    public static String a(@NonNull String str, @NonNull b33 b33) {
        byte b2 = b33.g;
        String str2 = "/api/v1/raw/upload";
        if (b2 != 1) {
            if (b2 == 2) {
                str2 = "/api/v1/file/upload";
            } else if (b2 == 3) {
                str2 = "/api/v1/mix/upload";
            }
        }
        return str + str2;
    }

    public static r03 c() {
        return a.a;
    }

    static void d(@Nullable vy0 vy0) {
        if (vy0 != null && vy0.a && !TextUtils.isEmpty(vy0.c)) {
            try {
                JSONObject jSONObject = new JSONObject(vy0.c);
                String optString = jSONObject.optString("code", "-1");
                vy0.d(optString);
                if (!"0".equals(optString)) {
                    vy0.a = false;
                }
                if (jSONObject.has("cver")) {
                    vy0.d.put("cver", jSONObject.getString("cver"));
                }
                long j = jSONObject.getLong(WPKFactory.CONF_SERVER_TIME) * 1000;
                if (Math.abs(j - e()) > RefreshTask.STOKEN_CHECK_INTERVAL) {
                    b = j - SystemClock.elapsedRealtime();
                }
            } catch (Throwable th) {
                t43.c("efs.px.api", "checkPxReturn error", th);
            }
        }
    }

    public static long e() {
        return b == -1 ? System.currentTimeMillis() : SystemClock.elapsedRealtime() + b;
    }

    @NonNull
    public final vy0 b(String str, b33 b33, File file, boolean z) {
        String b2 = b33.b();
        String a2 = a(str, b33);
        if (this.a) {
            t43.a("efs.px.api", "Upload file, url is ".concat(String.valueOf(a2)));
        }
        HashMap hashMap = new HashMap(1);
        hashMap.put("wpk-header", b2);
        b c = new b(a2).c(hashMap);
        c.a.d = file;
        b b3 = c.b("type", b33.h);
        StringBuilder sb = new StringBuilder();
        sb.append(b33.k);
        return b3.b("size", sb.toString()).b("flow_limit", Boolean.toString(z)).d(p33.d()).a().b();
    }
}
