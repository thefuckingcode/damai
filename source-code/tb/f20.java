package tb;

import com.ali.ha.datahub.BizSubscriber;
import java.util.HashMap;

/* compiled from: Taobao */
public class f20 {
    private BizSubscriber a;

    /* compiled from: Taobao */
    private static final class b {
        public static final f20 sInstance = new f20();
    }

    /* compiled from: Taobao */
    private static class c {
        private BizSubscriber a;

        private c(BizSubscriber bizSubscriber) {
            this.a = bizSubscriber;
        }
    }

    public static final f20 a() {
        return b.sInstance;
    }

    private HashMap<String, String> d(HashMap<String, String> hashMap) {
        if (!g20.a) {
            return hashMap;
        }
        if (hashMap == null) {
            return null;
        }
        try {
            return new HashMap<>(hashMap);
        } catch (Exception unused) {
            return new HashMap<>();
        }
    }

    public void b(BizSubscriber bizSubscriber) {
        if (this.a == null) {
            this.a = bizSubscriber;
            new c(bizSubscriber);
        }
    }

    public void c(String str, HashMap<String, String> hashMap) {
        BizSubscriber bizSubscriber = this.a;
        if (bizSubscriber != null) {
            bizSubscriber.pub(str, d(hashMap));
        }
    }

    private f20() {
    }
}
