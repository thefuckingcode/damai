package anet.channel.strategy.dispatch;

import anet.channel.status.NetworkStatusHelper;
import anet.channel.util.ALog;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import tb.h9;
import tb.ss0;
import tb.y4;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class AmdcTaskExecutor {
    public static final String TAG = "awcn.AmdcThreadPoolExecutor";
    private static Random c = new Random();
    private Map<String, Object> a;
    private AtomicBoolean b = new AtomicBoolean(true);

    AmdcTaskExecutor() {
    }

    public void c(Map<String, Object> map) {
        int i;
        try {
            map.put("Env", ss0.e());
            synchronized (this) {
                Map<String, Object> map2 = this.a;
                if (map2 == null) {
                    this.a = map;
                    if (!h9.E() || !this.b.compareAndSet(true, false)) {
                        i = c.nextInt(3000) + 2000;
                    } else {
                        i = 0;
                    }
                    ALog.f(TAG, "merge amdc request", null, "delay", Integer.valueOf(i));
                    y4.c(new AmdcTask(), (long) i);
                } else {
                    Set set = (Set) map2.get("hosts");
                    Set set2 = (Set) map.get("hosts");
                    if (map.get("Env") != this.a.get("Env")) {
                        this.a = map;
                    } else if (set.size() + set2.size() <= 40) {
                        set2.addAll(set);
                        this.a = map;
                    } else {
                        y4.d(new AmdcTask(map));
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public class AmdcTask implements Runnable {
        private Map<String, Object> params;

        AmdcTask(Map<String, Object> map) {
            this.params = map;
        }

        public void run() {
            Map<String, Object> map;
            try {
                Map<String, Object> map2 = this.params;
                if (map2 == null) {
                    synchronized (AmdcTaskExecutor.class) {
                        map = AmdcTaskExecutor.this.a;
                        AmdcTaskExecutor.this.a = null;
                    }
                    map2 = map;
                }
                if (NetworkStatusHelper.n()) {
                    if (ss0.e() != map2.get("Env")) {
                        ALog.k(AmdcTaskExecutor.TAG, "task's env changed", null, new Object[0]);
                    } else {
                        a.g(b.a(map2));
                    }
                }
            } catch (Exception e) {
                ALog.d(AmdcTaskExecutor.TAG, "exec amdc task failed.", null, e, new Object[0]);
            }
        }

        AmdcTask() {
        }
    }
}
