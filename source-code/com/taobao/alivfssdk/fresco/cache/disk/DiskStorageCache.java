package com.taobao.alivfssdk.fresco.cache.disk;

import android.content.Context;
import androidx.annotation.Nullable;
import com.taobao.alivfssdk.fresco.binaryresource.BinaryResource;
import com.taobao.alivfssdk.fresco.cache.common.CacheErrorLogger;
import com.taobao.alivfssdk.fresco.cache.common.CacheEventListener;
import com.taobao.alivfssdk.fresco.cache.common.CacheKey;
import com.taobao.alivfssdk.fresco.cache.common.WriterCallback;
import com.taobao.alivfssdk.fresco.cache.disk.DiskStorage;
import com.taobao.alivfssdk.fresco.common.disk.DiskTrimmable;
import com.taobao.alivfssdk.fresco.common.disk.DiskTrimmableRegistry;
import com.taobao.alivfssdk.fresco.common.internal.VisibleForTesting;
import com.taobao.alivfssdk.fresco.common.statfs.StatFsHelper;
import com.taobao.weex.annotation.JSMethod;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
import tb.g92;
import tb.i0;
import tb.si1;
import tb.xf1;
import tb.z72;

@ThreadSafe
/* compiled from: Taobao */
public class DiskStorageCache implements FileCache, DiskTrimmable {
    public static final int START_OF_VERSIONING = 1;
    private static final long o = TimeUnit.HOURS.toMillis(2);
    private static final long p = TimeUnit.MINUTES.toMillis(30);
    static Pattern q = Pattern.compile("[^a-zA-Z0-9\\.\\-]");
    private final long a;
    private long b;
    private final CountDownLatch c = new CountDownLatch(1);
    private long d;
    private final CacheEventListener e;
    @GuardedBy("mLock")
    @VisibleForTesting
    final Set<String> f;
    @GuardedBy("mLock")
    private long g;
    private final long h;
    private final StatFsHelper i;
    private final DiskStorage j;
    private final EntryEvictionComparatorSupplier k;
    private final CacheErrorLogger l;
    private final a m;
    private final Object n = new Object();

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    /* compiled from: Taobao */
    public static class a {
        private boolean a = false;
        private long b = -1;
        private long c = -1;

        a() {
        }

        public synchronized long a() {
            return this.c;
        }

        public synchronized long b() {
            return this.b;
        }

        public synchronized void c(long j, long j2) {
            if (this.a) {
                this.b += j;
                this.c += j2;
            }
        }

        public synchronized boolean d() {
            return this.a;
        }

        public synchronized void e() {
            this.a = false;
            this.c = -1;
            this.b = -1;
        }

        public synchronized void f(long j, long j2) {
            this.c = j2;
            this.b = j;
            this.a = true;
        }
    }

    /* compiled from: Taobao */
    public static class b {
        public final long a;
        public final long b;
        public final long c;

        public b(long j, long j2, long j3) {
            this.a = j;
            this.b = j2;
            this.c = j3;
        }
    }

    public DiskStorageCache(DiskStorage diskStorage, EntryEvictionComparatorSupplier entryEvictionComparatorSupplier, b bVar, CacheEventListener cacheEventListener, CacheErrorLogger cacheErrorLogger, @Nullable DiskTrimmableRegistry diskTrimmableRegistry, final Context context, ExecutorService executorService) {
        this.a = bVar.b;
        long j2 = bVar.c;
        this.b = j2;
        this.d = j2;
        this.i = StatFsHelper.d();
        this.j = diskStorage;
        this.k = entryEvictionComparatorSupplier;
        this.g = -1;
        this.e = cacheEventListener;
        this.h = bVar.a;
        this.l = cacheErrorLogger;
        this.m = new a();
        if (diskTrimmableRegistry != null) {
            diskTrimmableRegistry.registerDiskTrimmable(this);
        }
        this.f = new HashSet();
        executorService.execute(new Runnable() {
            /* class com.taobao.alivfssdk.fresco.cache.disk.DiskStorageCache.AnonymousClass1 */

            public void run() {
                synchronized (DiskStorageCache.this.n) {
                    DiskStorageCache.this.n();
                    DiskStorageCache.l(context, DiskStorageCache.this.j.getStorageName());
                }
                DiskStorageCache.this.c.countDown();
            }
        });
    }

    private BinaryResource f(DiskStorage.Inserter inserter, CacheKey cacheKey, String str) throws IOException {
        BinaryResource commit;
        synchronized (this.n) {
            commit = inserter.commit(cacheKey, cacheKey);
            this.f.add(str);
            this.m.c(commit.size(), 1);
        }
        return commit;
    }

    private static String g(String str) {
        return q.matcher(str).replaceAll(JSMethod.NOT_SET);
    }

    @GuardedBy("mLock")
    private void h(long j2, CacheEventListener.EvictionReason evictionReason) throws IOException {
        try {
            Collection<DiskStorage.Entry> k2 = k(this.j.getEntries());
            long b2 = this.m.b();
            long j3 = b2 - j2;
            int i2 = 0;
            long j4 = 0;
            for (DiskStorage.Entry entry : k2) {
                if (j4 > j3) {
                    break;
                }
                long remove = this.j.remove(entry);
                this.f.remove(entry.getId());
                if (remove > 0) {
                    i2++;
                    j4 += remove;
                    CacheEventListener cacheEventListener = this.e;
                    if (cacheEventListener != null) {
                        cacheEventListener.onEviction(new g92().h(entry.getId()).e(evictionReason).g(remove).c(b2 - j4).b(j2));
                    }
                }
            }
            this.m.c(-j4, (long) (-i2));
            this.j.purgeUnexpectedResources();
        } catch (IOException e2) {
            CacheErrorLogger cacheErrorLogger = this.l;
            CacheErrorLogger.CacheErrorCategory cacheErrorCategory = CacheErrorLogger.CacheErrorCategory.EVICTION;
            cacheErrorLogger.logError(cacheErrorCategory, "DiskStorageCache", "evictAboveSize: " + e2.getMessage(), e2);
            throw e2;
        }
    }

    @VisibleForTesting
    public static String i(CacheKey cacheKey) {
        try {
            if (cacheKey instanceof xf1) {
                return p(((xf1) cacheKey).a().get(0));
            }
            if (cacheKey instanceof si1) {
                return cacheKey.toString();
            }
            return p(cacheKey);
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException(e2);
        }
    }

    private static List<String> j(CacheKey cacheKey) {
        try {
            ArrayList arrayList = new ArrayList();
            if (cacheKey instanceof xf1) {
                List<CacheKey> a2 = ((xf1) cacheKey).a();
                for (int i2 = 0; i2 < a2.size(); i2++) {
                    arrayList.add(p(a2.get(i2)));
                }
            } else if (cacheKey instanceof si1) {
                arrayList.add(g(cacheKey.toString()));
            } else {
                arrayList.add(p(cacheKey));
            }
            return arrayList;
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException(e2);
        }
    }

    private Collection<DiskStorage.Entry> k(Collection<DiskStorage.Entry> collection) {
        if (this.k == null) {
            return collection;
        }
        long currentTimeMillis = System.currentTimeMillis() + o;
        ArrayList arrayList = new ArrayList(collection.size());
        ArrayList arrayList2 = new ArrayList(collection.size());
        for (DiskStorage.Entry entry : collection) {
            if (entry.getTimestamp() > currentTimeMillis) {
                arrayList.add(entry);
            } else {
                arrayList2.add(entry);
            }
        }
        Collections.sort(arrayList2, this.k.get());
        arrayList.addAll(arrayList2);
        return arrayList;
    }

    /* access modifiers changed from: private */
    public static void l(Context context, String str) {
        Context applicationContext = context.getApplicationContext();
        StringBuilder sb = new StringBuilder();
        sb.append(applicationContext.getFilesDir().getParent());
        String str2 = File.separator;
        sb.append(str2);
        sb.append("shared_prefs");
        sb.append(str2);
        sb.append("disk_entries_list");
        sb.append(str);
        String sb2 = sb.toString();
        File file = new File(sb2 + ".xml");
        try {
            if (file.exists()) {
                file.delete();
            }
        } catch (Exception unused) {
            i0.e("DiskStorageCache", "Fail to delete SharedPreference from file system. ");
        }
    }

    private void m() throws IOException {
        synchronized (this.n) {
            boolean n2 = n();
            s();
            long b2 = this.m.b();
            if (b2 > this.d && !n2) {
                this.m.e();
                n();
            }
            if (b2 > this.d) {
                long currentTimeMillis = System.currentTimeMillis();
                long j2 = (this.d * 9) / 10;
                h(j2, CacheEventListener.EvictionReason.CACHE_FULL);
                i0.c("DiskStorageCache", "- evictAboveSize: desiredSize=" + j2 + ", elapsed=" + (System.currentTimeMillis() - currentTimeMillis) + "ms");
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    @GuardedBy("mLock")
    private boolean n() {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.m.d()) {
            long j2 = this.g;
            if (j2 != -1 && currentTimeMillis - j2 <= p) {
                return false;
            }
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        o();
        long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis2;
        i0.c("DiskStorageCache", "- maybeUpdateFileCacheSizeAndIndex: now=" + currentTimeMillis + ", elapsed=" + currentTimeMillis3 + "ms" + ", thread=" + Thread.currentThread());
        this.g = currentTimeMillis;
        return true;
    }

    @GuardedBy("mLock")
    private void o() {
        Set<String> set;
        long j2;
        long currentTimeMillis = System.currentTimeMillis();
        long j3 = o + currentTimeMillis;
        if (this.f.isEmpty()) {
            set = this.f;
        } else {
            set = new HashSet<>();
        }
        try {
            boolean z = false;
            long j4 = -1;
            int i2 = 0;
            long j5 = 0;
            int i3 = 0;
            int i4 = 0;
            for (DiskStorage.Entry entry : this.j.getEntries()) {
                i3++;
                j5 += entry.getSize();
                if (entry.getTimestamp() > j3) {
                    i4++;
                    j2 = j3;
                    int size = (int) (((long) i2) + entry.getSize());
                    j4 = Math.max(entry.getTimestamp() - currentTimeMillis, j4);
                    i2 = size;
                    z = true;
                } else {
                    j2 = j3;
                    set.add(entry.getId());
                }
                j3 = j2;
            }
            if (z) {
                this.l.logError(CacheErrorLogger.CacheErrorCategory.READ_INVALID_ENTRY, "DiskStorageCache", "Future timestamp found in " + i4 + " files , with a total size of " + i2 + " bytes, and a maximum time delta of " + j4 + "ms", null);
            }
            long j6 = (long) i3;
            if (!(this.m.a() == j6 && this.m.b() == j5)) {
                Set<String> set2 = this.f;
                if (set2 != set) {
                    set2.clear();
                    this.f.addAll(set);
                }
                this.m.f(j5, j6);
            }
        } catch (IOException e2) {
            this.l.logError(CacheErrorLogger.CacheErrorCategory.GENERIC_IO, "DiskStorageCache", "calcFileCacheSize: " + e2.getMessage(), e2);
        }
    }

    private static String p(CacheKey cacheKey) throws UnsupportedEncodingException {
        return z72.a(cacheKey.toString().getBytes("UTF-8"));
    }

    private DiskStorage.Inserter q(String str, CacheKey cacheKey) throws IOException {
        m();
        return this.j.insert(str, cacheKey, cacheKey);
    }

    private void r(double d2) {
        synchronized (this.n) {
            try {
                this.m.e();
                n();
                long b2 = this.m.b();
                h(b2 - ((long) (d2 * ((double) b2))), CacheEventListener.EvictionReason.CACHE_MANAGER_TRIMMED);
            } catch (IOException e2) {
                CacheErrorLogger cacheErrorLogger = this.l;
                CacheErrorLogger.CacheErrorCategory cacheErrorCategory = CacheErrorLogger.CacheErrorCategory.EVICTION;
                cacheErrorLogger.logError(cacheErrorCategory, "DiskStorageCache", "trimBy: " + e2.getMessage(), e2);
            }
        }
    }

    @GuardedBy("mLock")
    private void s() {
        if (this.i.f(this.j.isExternal() ? StatFsHelper.StorageType.EXTERNAL : StatFsHelper.StorageType.INTERNAL, this.b - this.m.b())) {
            this.d = this.a;
        } else {
            this.d = this.b;
        }
    }

    @Override // com.taobao.alivfssdk.fresco.cache.disk.FileCache
    public void clearAll() {
        synchronized (this.n) {
            try {
                this.j.clearAll();
                this.f.clear();
            } catch (IOException e2) {
                CacheErrorLogger cacheErrorLogger = this.l;
                CacheErrorLogger.CacheErrorCategory cacheErrorCategory = CacheErrorLogger.CacheErrorCategory.EVICTION;
                cacheErrorLogger.logError(cacheErrorCategory, "DiskStorageCache", "clearAll: " + e2.getMessage(), e2);
            }
            this.m.e();
        }
    }

    @Override // com.taobao.alivfssdk.fresco.cache.disk.FileCache
    public long clearOldEntries(long j2) {
        long j3;
        long j4;
        IOException e2;
        synchronized (this.n) {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                Collection<DiskStorage.Entry> entries = this.j.getEntries();
                long b2 = this.m.b();
                int i2 = 0;
                long j5 = 0;
                j3 = 0;
                for (DiskStorage.Entry entry : entries) {
                    try {
                        long max = Math.max(1L, Math.abs(currentTimeMillis - entry.getTimestamp()));
                        if (max >= j2) {
                            long remove = this.j.remove(entry);
                            this.f.remove(entry.getId());
                            if (remove > 0) {
                                i2++;
                                j5 += remove;
                                CacheEventListener cacheEventListener = this.e;
                                if (cacheEventListener != null) {
                                    cacheEventListener.onEviction(new g92().h(entry.getId()).e(CacheEventListener.EvictionReason.CONTENT_STALE).g(remove).c(b2 - j5));
                                }
                            }
                        } else {
                            j3 = Math.max(j3, max);
                        }
                        currentTimeMillis = currentTimeMillis;
                    } catch (IOException e3) {
                        e2 = e3;
                        j4 = j3;
                        CacheErrorLogger cacheErrorLogger = this.l;
                        CacheErrorLogger.CacheErrorCategory cacheErrorCategory = CacheErrorLogger.CacheErrorCategory.EVICTION;
                        cacheErrorLogger.logError(cacheErrorCategory, "DiskStorageCache", "clearOldEntries: " + e2.getMessage(), e2);
                        j3 = j4;
                        return j3;
                    }
                }
                this.j.purgeUnexpectedResources();
                if (i2 > 0) {
                    n();
                    this.m.c(-j5, (long) (-i2));
                }
            } catch (IOException e4) {
                e2 = e4;
                j4 = 0;
                CacheErrorLogger cacheErrorLogger2 = this.l;
                CacheErrorLogger.CacheErrorCategory cacheErrorCategory2 = CacheErrorLogger.CacheErrorCategory.EVICTION;
                cacheErrorLogger2.logError(cacheErrorCategory2, "DiskStorageCache", "clearOldEntries: " + e2.getMessage(), e2);
                j3 = j4;
                return j3;
            }
        }
        return j3;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.j.close();
    }

    @Override // com.taobao.alivfssdk.fresco.cache.disk.FileCache
    public List<String> getCatalogs(CacheKey cacheKey) {
        synchronized (this.n) {
            List<String> j2 = j(cacheKey);
            if (j2.size() <= 0) {
                return null;
            }
            return this.j.getCatalogs(j2.get(0));
        }
    }

    @Override // com.taobao.alivfssdk.fresco.cache.disk.FileCache
    public long getCount() {
        return this.m.a();
    }

    @Override // com.taobao.alivfssdk.fresco.cache.disk.FileCache
    public DiskStorage.a getDumpInfo() throws IOException {
        return this.j.getDumpInfo();
    }

    @Override // com.taobao.alivfssdk.fresco.cache.disk.FileCache
    public Collection<DiskStorage.Entry> getEntries() throws IOException {
        return this.j.getEntries();
    }

    @Override // com.taobao.alivfssdk.fresco.cache.disk.FileCache
    public BinaryResource getResource(CacheKey cacheKey) {
        BinaryResource binaryResource;
        int i2 = 0;
        i0.c("DiskStorageCache", "- getResource: key=" + cacheKey + ", thread=" + Thread.currentThread());
        g92 a2 = new g92().a(cacheKey);
        try {
            synchronized (this.n) {
                List<String> j2 = j(cacheKey);
                String str = null;
                binaryResource = null;
                while (true) {
                    if (i2 >= j2.size()) {
                        break;
                    }
                    str = j2.get(i2);
                    a2.h(str);
                    binaryResource = this.j.getResource(str, cacheKey, cacheKey);
                    if (binaryResource != null) {
                        break;
                    }
                    i2++;
                }
                if (binaryResource == null) {
                    CacheEventListener cacheEventListener = this.e;
                    if (cacheEventListener != null) {
                        cacheEventListener.onMiss(a2);
                    }
                    this.f.remove(str);
                } else {
                    CacheEventListener cacheEventListener2 = this.e;
                    if (cacheEventListener2 != null) {
                        cacheEventListener2.onHit(a2);
                    }
                    this.f.add(str);
                }
            }
            return binaryResource;
        } catch (IOException e2) {
            this.l.logError(CacheErrorLogger.CacheErrorCategory.GENERIC_IO, "DiskStorageCache", "getResource", e2);
            a2.f(e2);
            CacheEventListener cacheEventListener3 = this.e;
            if (cacheEventListener3 != null) {
                cacheEventListener3.onReadException(a2);
            }
            return null;
        }
    }

    @Override // com.taobao.alivfssdk.fresco.cache.disk.FileCache
    public long getSize() {
        return this.m.b();
    }

    @Override // com.taobao.alivfssdk.fresco.cache.disk.FileCache
    public boolean hasKey(CacheKey cacheKey) {
        synchronized (this.n) {
            if (hasKeySync(cacheKey)) {
                return true;
            }
            try {
                List<String> j2 = j(cacheKey);
                for (int i2 = 0; i2 < j2.size(); i2++) {
                    String str = j2.get(i2);
                    if (this.j.contains(str, cacheKey, cacheKey)) {
                        this.f.add(str);
                        return true;
                    }
                }
                return false;
            } catch (IOException unused) {
                return false;
            }
        }
    }

    @Override // com.taobao.alivfssdk.fresco.cache.disk.FileCache
    public boolean hasKeySync(CacheKey cacheKey) {
        synchronized (this.n) {
            List<String> j2 = j(cacheKey);
            for (int i2 = 0; i2 < j2.size(); i2++) {
                if (this.f.contains(j2.get(i2))) {
                    return true;
                }
            }
            return false;
        }
    }

    @Override // com.taobao.alivfssdk.fresco.cache.disk.FileCache
    public BinaryResource insert(CacheKey cacheKey, WriterCallback writerCallback) throws IOException {
        String i2;
        long currentTimeMillis = System.currentTimeMillis();
        g92 a2 = new g92().a(cacheKey);
        CacheEventListener cacheEventListener = this.e;
        if (cacheEventListener != null) {
            cacheEventListener.onWriteAttempt(a2);
        }
        synchronized (this.n) {
            i2 = i(cacheKey);
        }
        a2.h(i2);
        try {
            DiskStorage.Inserter q2 = q(i2, cacheKey);
            try {
                q2.writeData(writerCallback, cacheKey, cacheKey);
                BinaryResource f2 = f(q2, cacheKey, i2);
                a2.g(f2.size()).c(this.m.b()).d(System.currentTimeMillis() - currentTimeMillis);
                CacheEventListener cacheEventListener2 = this.e;
                if (cacheEventListener2 != null) {
                    cacheEventListener2.onWriteSuccess(a2);
                }
                if (!q2.cleanUp()) {
                    i0.e("DiskStorageCache", "Failed to delete temp file");
                }
                return f2;
            } catch (Throwable th) {
                if (!q2.cleanUp()) {
                    i0.e("DiskStorageCache", "Failed to delete temp file");
                }
                throw th;
            }
        } catch (IOException e2) {
            a2.f(e2);
            CacheEventListener cacheEventListener3 = this.e;
            if (cacheEventListener3 != null) {
                cacheEventListener3.onWriteException(a2);
            }
            i0.e("DiskStorageCache", "Failed inserting a file into the cache", e2);
            throw e2;
        }
    }

    @Override // com.taobao.alivfssdk.fresco.cache.disk.FileCache
    public boolean isEnabled() {
        return this.j.isEnabled();
    }

    @Override // com.taobao.alivfssdk.fresco.cache.disk.FileCache
    public boolean probe(CacheKey cacheKey) {
        String str;
        IOException e2;
        Throwable th;
        try {
            synchronized (this.n) {
                try {
                    List<String> j2 = j(cacheKey);
                    for (int i2 = 0; i2 < j2.size(); i2++) {
                        str = j2.get(i2);
                        try {
                            if (this.j.touch(str, cacheKey, cacheKey)) {
                                this.f.add(str);
                                return true;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            try {
                                throw th;
                            } catch (IOException e3) {
                                e2 = e3;
                            }
                        }
                    }
                    return false;
                } catch (Throwable th3) {
                    str = null;
                    th = th3;
                    throw th;
                }
            }
        } catch (IOException e4) {
            str = null;
            e2 = e4;
            CacheEventListener cacheEventListener = this.e;
            if (cacheEventListener != null) {
                cacheEventListener.onReadException(new g92().a(cacheKey).h(str).f(e2));
            }
            return false;
        }
    }

    @Override // com.taobao.alivfssdk.fresco.cache.disk.FileCache
    public boolean remove(CacheKey cacheKey) {
        synchronized (this.n) {
            boolean z = false;
            try {
                List<String> j2 = j(cacheKey);
                if (j2.size() > 0) {
                    String str = j2.get(0);
                    g92 a2 = new g92().a(cacheKey);
                    a2.h(str);
                    long remove = this.j.remove(str, cacheKey);
                    this.f.remove(str);
                    a2.g(remove).c(this.m.b());
                    CacheEventListener cacheEventListener = this.e;
                    if (cacheEventListener != null) {
                        cacheEventListener.onRemoveSuccess(a2);
                    }
                    if (remove >= 0) {
                        z = true;
                    }
                    return z;
                }
            } catch (IOException e2) {
                CacheErrorLogger cacheErrorLogger = this.l;
                CacheErrorLogger.CacheErrorCategory cacheErrorCategory = CacheErrorLogger.CacheErrorCategory.DELETE_FILE;
                cacheErrorLogger.logError(cacheErrorCategory, "DiskStorageCache", "delete: " + e2.getMessage(), e2);
            } catch (Throwable th) {
                throw th;
            }
            return false;
        }
    }

    @Override // com.taobao.alivfssdk.fresco.common.disk.DiskTrimmable
    public void trimToMinimum() {
        synchronized (this.n) {
            n();
            long b2 = this.m.b();
            long j2 = this.h;
            if (j2 > 0 && b2 > 0) {
                if (b2 >= j2) {
                    double d2 = 1.0d - (((double) j2) / ((double) b2));
                    if (d2 > 0.02d) {
                        r(d2);
                    }
                }
            }
        }
    }

    @Override // com.taobao.alivfssdk.fresco.common.disk.DiskTrimmable
    public void trimToNothing() {
        clearAll();
    }
}
