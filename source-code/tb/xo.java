package tb;

import android.text.TextUtils;
import com.alibaba.motu.crashreporter.IUTCrashCaughtListener;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
public class xo implements IUTCrashCaughtListener {
    private ConcurrentHashMap<String, Object> a = new ConcurrentHashMap<>();

    public void a(String str, Object obj) {
        if (!TextUtils.isEmpty(str) && obj != null) {
            this.a.put(str, obj);
        }
    }

    @Override // com.alibaba.motu.crashreporter.IUTCrashCaughtListener
    public Map<String, Object> onCrashCaught(Thread thread, Throwable th) {
        return this.a;
    }
}
