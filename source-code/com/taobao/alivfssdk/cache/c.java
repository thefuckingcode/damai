package com.taobao.alivfssdk.cache;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.taobao.alivfsadapter.AVFSAdapterManager;
import com.taobao.alivfsadapter.AVFSSDKAppMonitor;
import com.taobao.alivfssdk.fresco.binaryresource.BinaryResource;
import com.taobao.alivfssdk.fresco.cache.common.CacheErrorLogger;
import com.taobao.alivfssdk.fresco.cache.common.CacheEvent;
import com.taobao.alivfssdk.fresco.cache.common.CacheEventListener;
import com.taobao.alivfssdk.fresco.cache.common.CacheKey;
import com.taobao.alivfssdk.fresco.cache.common.WriterCallback;
import com.taobao.alivfssdk.fresco.cache.disk.DiskStorage;
import com.taobao.alivfssdk.fresco.cache.disk.DiskStorageCache;
import com.taobao.alivfssdk.fresco.cache.disk.FileCache;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;
import java.io.OutputStream;
import java.io.StreamCorruptedException;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import tb.ho1;
import tb.i0;
import tb.lf1;
import tb.si1;
import tb.xx0;

/* compiled from: Taobao */
public class c extends AVFSBaseCache implements CacheErrorLogger, CacheEventListener {
    private final String a;
    private final FileCache b;
    private final a c;
    private LruCache<CacheKey, byte[]> d;

    /* compiled from: Taobao */
    class a implements ThreadFactory {
        a() {
        }

        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "AVFSDiskCache #" + c.this.c.e());
        }
    }

    /* compiled from: Taobao */
    class b extends xx0<CacheKey, byte[]> {
        b(c cVar, int i, float f) {
            super(i, f);
        }

        /* access modifiers changed from: protected */
        /* renamed from: r */
        public int b(byte[] bArr) {
            return bArr.length;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.taobao.alivfssdk.cache.c$c  reason: collision with other inner class name */
    /* compiled from: Taobao */
    public class C0198c extends BufferedInputStream {
        final /* synthetic */ CacheKey a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C0198c(InputStream inputStream, int i, CacheKey cacheKey) {
            super(inputStream, i);
            this.a = cacheKey;
        }

        @Override // java.io.FilterInputStream, java.io.BufferedInputStream, java.io.Closeable, java.lang.AutoCloseable, java.io.InputStream
        public void close() throws IOException {
            c.this.d.put(this.a, ((BufferedInputStream) this).buf);
            super.close();
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class e extends ObjectInputStream {
        private final ClassLoader a;

        public e(InputStream inputStream, ClassLoader classLoader) throws StreamCorruptedException, IOException {
            super(inputStream);
            this.a = classLoader;
        }

        /* access modifiers changed from: protected */
        @Override // java.io.ObjectInputStream
        public Class<?> resolveClass(ObjectStreamClass objectStreamClass) throws IOException, ClassNotFoundException {
            try {
                return super.resolveClass(objectStreamClass);
            } catch (ClassNotFoundException unused) {
                return Class.forName(objectStreamClass.getName(), false, this.a);
            }
        }
    }

    public c(@NonNull a aVar, String str, DiskStorage diskStorage, DiskStorageCache.b bVar, int i) {
        this.c = aVar;
        this.a = str;
        this.b = new DiskStorageCache(diskStorage, null, bVar, this, this, null, b.d().c(), Executors.newSingleThreadExecutor(new a()));
        if (i > 0) {
            this.d = new b(this, i, 0.2f);
        }
    }

    private void d(@NonNull String str, String str2, boolean z) {
        AVFSSDKAppMonitor f = AVFSAdapterManager.g().f();
        if (f != null) {
            f.hitMemoryCacheForModule(this.c.e(), z);
        }
    }

    /* access modifiers changed from: protected */
    @NonNull
    public lf1.b c(String str) {
        return lf1.a(this.c.e(), this.a, this.d != null).o(str);
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    public void clearMemCache() {
        LruCache<CacheKey, byte[]> lruCache = this.d;
        if (lruCache != null) {
            lruCache.clear();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        clearMemCache();
        FileCache fileCache = this.b;
        if (fileCache != null) {
            fileCache.close();
        }
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    public boolean containObjectForKey(@NonNull String str, int i) {
        return containObjectForKey(str, (String) null, i);
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    public List<String> extendsKeysForKey(@NonNull String str) {
        return extendsKeysForKey(str, 0);
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    public InputStream inputStreamForKey(@NonNull String str, String str2) {
        return inputStreamForKey(str, str2, 0);
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    public Set<String> keySet() {
        try {
            Collection<DiskStorage.Entry> entries = this.b.getEntries();
            HashSet hashSet = new HashSet(entries.size());
            for (DiskStorage.Entry entry : entries) {
                hashSet.add(entry.getId());
            }
            return hashSet;
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    public long lengthForKey(String str, String str2) {
        BinaryResource resource;
        if (str == null || (resource = this.b.getResource(new ho1(str, str2))) == null) {
            return -1;
        }
        return resource.size();
    }

    @Override // com.taobao.alivfssdk.fresco.cache.common.CacheErrorLogger
    public void logError(CacheErrorLogger.CacheErrorCategory cacheErrorCategory, String str, String str2, @Nullable Throwable th) {
        i0.d("AVFSCache", th, new Object[0]);
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    @Nullable
    public <T> T objectForKey(@NonNull String str, String str2) {
        return (T) objectForKey(str, str2, (Class) null);
    }

    @Override // com.taobao.alivfssdk.fresco.cache.common.CacheEventListener
    public boolean onEviction(CacheEvent cacheEvent) {
        return false;
    }

    @Override // com.taobao.alivfssdk.fresco.cache.common.CacheEventListener
    public void onHit(CacheEvent cacheEvent) {
    }

    @Override // com.taobao.alivfssdk.fresco.cache.common.CacheEventListener
    public void onMiss(CacheEvent cacheEvent) {
    }

    @Override // com.taobao.alivfssdk.fresco.cache.common.CacheEventListener
    public void onReadException(CacheEvent cacheEvent) {
        AVFSSDKAppMonitor f = AVFSAdapterManager.g().f();
        if (f != null) {
            f.writeEvent(c(lf1.OPERATION_READ).l(-2).m(cacheEvent.getException().getMessage()).j());
        }
    }

    @Override // com.taobao.alivfssdk.fresco.cache.common.CacheEventListener
    public void onRemoveSuccess(CacheEvent cacheEvent) {
    }

    @Override // com.taobao.alivfssdk.fresco.cache.common.CacheEventListener
    public void onWriteAttempt(CacheEvent cacheEvent) {
    }

    @Override // com.taobao.alivfssdk.fresco.cache.common.CacheEventListener
    public void onWriteException(CacheEvent cacheEvent) {
        AVFSSDKAppMonitor f = AVFSAdapterManager.g().f();
        if (f != null) {
            f.writeEvent(c(lf1.OPERATION_WRITE).l(-2).m(cacheEvent.getException().getMessage()).j());
        }
    }

    @Override // com.taobao.alivfssdk.fresco.cache.common.CacheEventListener
    public void onWriteSuccess(CacheEvent cacheEvent) {
        AVFSSDKAppMonitor f = AVFSAdapterManager.g().f();
        if (f != null) {
            f.writeEvent(c(lf1.OPERATION_WRITE).k(cacheEvent.getElapsed()).j());
        }
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    public boolean removeAllObject() {
        LruCache<CacheKey, byte[]> lruCache = this.d;
        if (lruCache != null) {
            lruCache.clear();
        }
        this.b.clearAll();
        return true;
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    public boolean removeObjectForKey(@NonNull String str, int i) {
        return removeObjectForKey(str, (String) null, i);
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    public boolean setObjectForKey(@NonNull String str, String str2, Object obj, int i) {
        CacheKey cacheKey;
        if (str == null) {
            return false;
        }
        if (obj == null) {
            return removeObjectForKey(str, str2);
        }
        if (i == 268435456) {
            cacheKey = new si1(str, str2);
        } else {
            cacheKey = new ho1(str, str2);
        }
        try {
            this.b.insert(cacheKey, new d(cacheKey, obj));
            return true;
        } catch (Exception e2) {
            i0.d("AVFSCache", e2, new Object[0]);
            return false;
        }
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    public boolean setStreamForKey(@NonNull String str, String str2, @NonNull InputStream inputStream, int i) {
        CacheKey cacheKey;
        if (str == null) {
            return false;
        }
        if (i == 268435456) {
            cacheKey = new si1(str, str2);
        } else {
            cacheKey = new ho1(str, str2);
        }
        try {
            System.currentTimeMillis();
            this.b.insert(cacheKey, com.taobao.alivfssdk.fresco.cache.common.b.a(inputStream));
            System.currentTimeMillis();
            return true;
        } catch (Exception e2) {
            i0.d("AVFSCache", e2, new Object[0]);
            return false;
        }
    }

    /* compiled from: Taobao */
    class d implements WriterCallback {
        final /* synthetic */ CacheKey a;
        final /* synthetic */ Object b;

        d(CacheKey cacheKey, Object obj) {
            this.a = cacheKey;
            this.b = obj;
        }

        @Override // com.taobao.alivfssdk.fresco.cache.common.WriterCallback
        public OutputStream write(OutputStream outputStream) throws IOException {
            ObjectOutputStream objectOutputStream;
            if (c.this.d != null) {
                objectOutputStream = new ObjectOutputStream(new a(outputStream));
            } else {
                objectOutputStream = new ObjectOutputStream(new BufferedOutputStream(outputStream));
            }
            objectOutputStream.writeObject(this.b);
            return objectOutputStream;
        }

        /* compiled from: Taobao */
        class a extends BufferedOutputStream {
            private final ByteArrayOutputStream a = new ByteArrayOutputStream();

            a(OutputStream outputStream) {
                super(outputStream);
            }

            @Override // java.io.OutputStream, java.io.Closeable, java.io.FilterOutputStream, java.lang.AutoCloseable
            public void close() throws IOException {
                c.this.d.put(d.this.a, this.a.toByteArray());
                super.close();
            }

            @Override // java.io.OutputStream, java.io.FilterOutputStream, java.io.BufferedOutputStream
            public synchronized void write(byte[] bArr, int i, int i2) throws IOException {
                this.a.write(bArr, i, i2);
                super.write(bArr, i, i2);
            }

            @Override // java.io.OutputStream, java.io.FilterOutputStream, java.io.BufferedOutputStream
            public synchronized void write(int i) throws IOException {
                this.a.write(i);
                super.write(i);
            }
        }
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    public boolean containObjectForKey(@NonNull String str, String str2) {
        return containObjectForKey(str, str2, 0);
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    public List<String> extendsKeysForKey(@NonNull String str, int i) {
        CacheKey cacheKey;
        if (i == 268435456) {
            cacheKey = new si1(str, null);
        } else {
            cacheKey = new ho1(str, null);
        }
        System.currentTimeMillis();
        try {
            List<String> catalogs = this.b.getCatalogs(cacheKey);
            System.currentTimeMillis();
            return catalogs;
        } catch (Exception e2) {
            i0.d("AVFSCache", e2, new Object[0]);
            return null;
        }
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    public InputStream inputStreamForKey(@NonNull String str, String str2, int i) {
        CacheKey cacheKey;
        if (str == null) {
            return null;
        }
        if (i == 268435456) {
            cacheKey = new si1(str, str2);
        } else {
            cacheKey = new ho1(str, str2);
        }
        System.currentTimeMillis();
        try {
            BinaryResource resource = this.b.getResource(cacheKey);
            System.currentTimeMillis();
            if (resource != null) {
                i0.c("AVFSCache", "- inputStreamForKey: moduleName=" + this.c.e() + ", key1=" + str + ", key2=" + str2);
                return resource.openStream();
            }
        } catch (IOException e2) {
            i0.d("AVFSCache", e2, new Object[0]);
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:71:0x013a A[Catch:{ AVFSException -> 0x015b, Exception -> 0x012e, all -> 0x012b, all -> 0x018f }] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x015a A[Catch:{ AVFSException -> 0x015b, Exception -> 0x012e, all -> 0x012b, all -> 0x018f }] */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0167 A[Catch:{ AVFSException -> 0x015b, Exception -> 0x012e, all -> 0x012b, all -> 0x018f }] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0193 A[SYNTHETIC, Splitter:B:88:0x0193] */
    /* JADX WARNING: Removed duplicated region for block: B:97:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:98:? A[RETURN, SYNTHETIC] */
    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    public <T> T objectForKey(@NonNull String str, String str2, Class<T> cls, int i) {
        Throwable th;
        e eVar;
        AVFSException e2;
        AVFSSDKAppMonitor f;
        Exception e3;
        AVFSSDKAppMonitor f2;
        CacheKey cacheKey;
        BinaryResource resource;
        byte[] bArr;
        e eVar2 = null;
        if (str == null) {
            return null;
        }
        try {
            System.currentTimeMillis();
            if (i == 268435456) {
                try {
                    cacheKey = new si1(str, str2);
                } catch (AVFSException e4) {
                    e2 = e4;
                    eVar = null;
                } catch (Exception e5) {
                    e3 = e5;
                    eVar = null;
                    f2 = AVFSAdapterManager.g().f();
                    if (f2 != null) {
                    }
                    i0.d("AVFSCache", e3, new Object[0]);
                    if (eVar != null) {
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (eVar2 != null) {
                    }
                    throw th;
                }
            } else {
                cacheKey = new ho1(str, str2);
            }
            LruCache<CacheKey, byte[]> lruCache = this.d;
            boolean z = true;
            if (lruCache == null || (bArr = lruCache.get(cacheKey)) == null) {
                eVar = null;
                z = false;
            } else {
                eVar = new e(new ByteArrayInputStream(bArr), this.c.a());
                try {
                    d(str, str2, true);
                } catch (AVFSException e6) {
                    e2 = e6;
                    f = AVFSAdapterManager.g().f();
                    if (f != null) {
                    }
                    i0.d("AVFSCache", e2, new Object[0]);
                    if (eVar == null) {
                    }
                    try {
                        eVar.close();
                        return null;
                    } catch (IOException unused) {
                        return null;
                    }
                } catch (Exception e7) {
                    e3 = e7;
                    f2 = AVFSAdapterManager.g().f();
                    if (f2 != null) {
                    }
                    i0.d("AVFSCache", e3, new Object[0]);
                    if (eVar != null) {
                    }
                }
            }
            if (eVar == null && (resource = this.b.getResource(cacheKey)) != null) {
                InputStream openStream = resource.openStream();
                if (this.d != null) {
                    e eVar3 = new e(new C0198c(openStream, (int) resource.size(), cacheKey), this.c.a());
                    try {
                        d(str, str2, false);
                        eVar = eVar3;
                    } catch (AVFSException e8) {
                        e2 = e8;
                        eVar = eVar3;
                        f = AVFSAdapterManager.g().f();
                        if (f != null) {
                        }
                        i0.d("AVFSCache", e2, new Object[0]);
                        if (eVar == null) {
                        }
                        eVar.close();
                        return null;
                    } catch (Exception e9) {
                        e3 = e9;
                        eVar = eVar3;
                        f2 = AVFSAdapterManager.g().f();
                        if (f2 != null) {
                        }
                        i0.d("AVFSCache", e3, new Object[0]);
                        if (eVar != null) {
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        eVar2 = eVar3;
                        if (eVar2 != null) {
                        }
                        throw th;
                    }
                }
                if (eVar == null) {
                    eVar = new e(new BufferedInputStream(openStream), this.c.a());
                }
            }
            if (eVar != null) {
                long currentTimeMillis = System.currentTimeMillis();
                try {
                    T t = (T) eVar.readObject();
                    long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                    System.currentTimeMillis();
                    AVFSSDKAppMonitor f3 = AVFSAdapterManager.g().f();
                    if (f3 != null) {
                        f3.writeEvent(c(lf1.OPERATION_READ).k(currentTimeMillis2).n(z).j());
                    }
                    try {
                        eVar.close();
                    } catch (IOException unused2) {
                    }
                    return t;
                } catch (IOException e10) {
                    throw new AVFSException(e10.getMessage() + ", key1=" + str + ", key2=" + str2, e10, -2);
                } catch (Exception e11) {
                    throw new AVFSException(e11.getMessage() + ", key1=" + str + ", key2=" + str2, e11, -3);
                }
            } else if (eVar == null) {
                return null;
            } else {
                try {
                    eVar.close();
                    return null;
                } catch (IOException unused3) {
                    return null;
                }
            }
        } catch (AVFSException e12) {
            e2 = e12;
            eVar = null;
            f = AVFSAdapterManager.g().f();
            if (f != null) {
                f.writeEvent(c(lf1.OPERATION_READ).l(e2.getErrorCode()).m(e2.getMessage()).j());
            }
            i0.d("AVFSCache", e2, new Object[0]);
            if (eVar == null) {
                return null;
            }
            eVar.close();
            return null;
        } catch (Exception e13) {
            e3 = e13;
            eVar = null;
            f2 = AVFSAdapterManager.g().f();
            if (f2 != null) {
                f2.writeEvent(c(lf1.OPERATION_READ).l(-1).m(e3.getMessage()).j());
            }
            i0.d("AVFSCache", e3, new Object[0]);
            if (eVar != null) {
                return null;
            }
            eVar.close();
            return null;
        } catch (Throwable th4) {
            th = th4;
            eVar2 = eVar;
            if (eVar2 != null) {
            }
            throw th;
        }
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    public boolean removeObjectForKey(@NonNull String str, String str2) {
        return removeObjectForKey(str, str2, 0);
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    public boolean containObjectForKey(@NonNull String str, String str2, int i) {
        CacheKey cacheKey;
        if (str == null) {
            return false;
        }
        if (i == 268435456) {
            cacheKey = new si1(str, str2);
        } else {
            cacheKey = new ho1(str, str2);
        }
        return this.b.hasKey(cacheKey);
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    public boolean removeObjectForKey(@NonNull String str, String str2, int i) {
        CacheKey cacheKey;
        if (str == null) {
            return false;
        }
        if (i == 268435456) {
            cacheKey = new si1(str, str2);
        } else {
            cacheKey = new ho1(str, str2);
        }
        LruCache<CacheKey, byte[]> lruCache = this.d;
        if (lruCache != null) {
            lruCache.remove(cacheKey);
        }
        return this.b.remove(cacheKey);
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    public long lengthForKey(String str, String str2, int i) {
        CacheKey cacheKey;
        if (str == null) {
            return -1;
        }
        if (i == 268435456) {
            cacheKey = new si1(str, str2);
        } else {
            cacheKey = new ho1(str, str2);
        }
        BinaryResource resource = this.b.getResource(cacheKey);
        if (resource != null) {
            return resource.size();
        }
        return -1;
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    @Nullable
    public <T> T objectForKey(@NonNull String str, String str2, Class<T> cls) {
        return (T) objectForKey(str, str2, cls, 0);
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    @Nullable
    public <T> T objectForKey(@NonNull String str, int i) {
        return (T) objectForKey(str, (String) null, (Class) null, i);
    }
}
