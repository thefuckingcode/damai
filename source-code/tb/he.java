package tb;

import anet.channel.util.ALog;
import anetwork.channel.cache.Cache;
import anetwork.channel.cache.CachePrediction;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* compiled from: Taobao */
public class he {
    private static List<a> a = new ArrayList();
    private static final ReentrantReadWriteLock b;
    private static final ReentrantReadWriteLock.ReadLock c;
    private static final ReentrantReadWriteLock.WriteLock d;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class a implements Comparable<a> {
        final Cache a;
        final CachePrediction b;
        final int c;

        a(Cache cache, CachePrediction cachePrediction, int i) {
            this.a = cache;
            this.b = cachePrediction;
            this.c = i;
        }

        /* renamed from: a */
        public int compareTo(a aVar) {
            return this.c - aVar.c;
        }
    }

    static {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        b = reentrantReadWriteLock;
        c = reentrantReadWriteLock.readLock();
        d = reentrantReadWriteLock.writeLock();
    }

    public static void a(Cache cache, CachePrediction cachePrediction, int i) {
        if (cache == null) {
            throw new IllegalArgumentException("cache is null");
        } else if (cachePrediction != null) {
            try {
                ReentrantReadWriteLock.WriteLock writeLock = d;
                writeLock.lock();
                a.add(new a(cache, cachePrediction, i));
                Collections.sort(a);
                writeLock.unlock();
            } catch (Throwable th) {
                d.unlock();
                throw th;
            }
        } else {
            throw new IllegalArgumentException("prediction is null");
        }
    }

    public static void b() {
        ALog.k("anet.CacheManager", "clearAllCache", null, new Object[0]);
        for (a aVar : a) {
            try {
                aVar.a.clear();
            } catch (Exception unused) {
            }
        }
    }

    public static Cache c(String str, Map<String, String> map) {
        Cache cache;
        try {
            c.lock();
            Iterator<a> it = a.iterator();
            while (true) {
                if (!it.hasNext()) {
                    cache = null;
                    break;
                }
                a next = it.next();
                if (next.b.handleCache(str, map)) {
                    cache = next.a;
                    break;
                }
            }
            return cache;
        } finally {
            c.unlock();
        }
    }
}
