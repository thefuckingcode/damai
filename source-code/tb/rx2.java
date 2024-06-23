package tb;

import com.taobao.weex.adapter.IWXUserTrackAdapter;
import com.taobao.weex.bridge.WXReactorPage;
import com.taobao.weex.bridge.WXReactorPlugin;

/* compiled from: Taobao */
public class rx2 {
    private static rx2 b;
    private volatile WXReactorPlugin a;

    private rx2() {
    }

    public static rx2 b() {
        if (b == null) {
            synchronized (rx2.class) {
                if (b == null) {
                    b = new rx2();
                }
            }
        }
        return b;
    }

    public WXReactorPage a(long j, String str) {
        if (this.a == null) {
            return null;
        }
        return this.a.createPage(j, str);
    }

    public void c(int i, IWXUserTrackAdapter iWXUserTrackAdapter) {
    }
}
