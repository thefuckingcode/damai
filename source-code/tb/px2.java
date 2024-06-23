package tb;

import android.content.Context;
import com.taobao.weex.WXSDKInstance;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
public class px2 {
    private Map<String, WXSDKInstance> a;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class b {
        private static final px2 a = new px2();
    }

    public static px2 a() {
        return b.a;
    }

    public WXSDKInstance b(String str, Context context) {
        WXSDKInstance remove = this.a.remove(str);
        if (remove != null) {
            remove.init(context);
        }
        return remove;
    }

    private px2() {
        this.a = new ConcurrentHashMap();
    }
}
