package tb;

import android.taobao.windvane.service.WVEventContext;
import android.taobao.windvane.service.WVEventListener;
import android.taobao.windvane.service.WVEventResult;
import android.taobao.windvane.service.WVEventService;
import android.taobao.windvane.util.TaoLog;
import android.taobao.windvane.util.WVUrlUtil;
import android.text.TextUtils;
import com.alibaba.motu.crashreporter.IUTCrashCaughtListener;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/* compiled from: Taobao */
public class pq2 implements IUTCrashCaughtListener {
    public static String c = "0";
    private LinkedList a = null;
    private String b = "";

    /* compiled from: Taobao */
    public class a implements WVEventListener {
        public a() {
        }

        @Override // android.taobao.windvane.service.WVEventListener
        public WVEventResult onEvent(int i, WVEventContext wVEventContext, Object... objArr) {
            String str;
            if (i != 1001) {
                switch (i) {
                    case 3001:
                    case 3003:
                        pq2.c = "1";
                        return null;
                    case 3002:
                        pq2.c = "0";
                        return null;
                    default:
                        return null;
                }
            } else {
                if (!(wVEventContext == null || (str = wVEventContext.url) == null)) {
                    if (pq2.this.a != null) {
                        if (pq2.this.a.size() > 9) {
                            pq2.this.a.removeFirst();
                        }
                        pq2.this.a.addLast(str);
                    }
                    pq2.this.b = str;
                    TaoLog.v("WV_URL_CHANGE", "current Url : " + str);
                }
                pq2.c = "2";
                return null;
            }
        }
    }

    public pq2() {
        c();
    }

    private void c() {
        this.a = new LinkedList();
        WVEventService.getInstance().addEventListener(new a());
    }

    @Override // com.alibaba.motu.crashreporter.IUTCrashCaughtListener
    public Map<String, Object> onCrashCaught(Thread thread, Throwable th) {
        int size = this.a.size();
        if (this.a == null || size < 1) {
            return null;
        }
        for (int i = 3; i < size; i++) {
            String str = (String) this.a.get(i);
            if (!TextUtils.isEmpty(str)) {
                this.a.set(i, WVUrlUtil.removeQueryParam(str));
            }
        }
        HashMap hashMap = new HashMap();
        hashMap.put("crash_url_list", this.a.toString());
        hashMap.put("wv_currentUrl", this.b);
        hashMap.put("wv_currentStatus", c);
        return hashMap;
    }
}
