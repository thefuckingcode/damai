package com.taobao.alivfssdk.cache;

import android.app.Application;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.LruCache;
import com.taobao.alivfsadapter.AVFSAdapterManager;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import tb.g0;
import tb.i0;

/* compiled from: Taobao */
public class b {
    private static volatile b d;
    private final LruCache<String, a> a;
    private final ConcurrentHashMap<String, g0> b = new ConcurrentHashMap<>();
    private final Context c;

    /* compiled from: Taobao */
    class a extends LruCache<String, a> {
        a(b bVar, int i) {
            super(i);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void entryRemoved(boolean z, String str, a aVar, a aVar2) {
        }
    }

    b() {
        Application e = AVFSAdapterManager.g().e();
        Context applicationContext = e.getApplicationContext();
        if (applicationContext == null) {
            this.c = e;
        } else {
            this.c = applicationContext;
        }
        this.a = new a(this, 5);
    }

    @NonNull
    private a b(File file, String str) {
        a aVar;
        File file2;
        synchronized (this.a) {
            aVar = this.a.get(str);
            if (aVar == null) {
                if (file == null) {
                    file2 = null;
                } else {
                    file2 = new File(file, str);
                }
                aVar = new a(str, file2);
                g0 g0Var = this.b.get(str);
                if (g0Var != null) {
                    aVar.f(g0Var);
                }
                this.a.put(str, aVar);
            }
        }
        return aVar;
    }

    public static b d() {
        if (d == null) {
            synchronized (b.class) {
                if (d == null) {
                    d = new b();
                }
            }
        }
        return d;
    }

    @Nullable
    public a a(@NonNull String str) {
        File file;
        if (str != null) {
            try {
                file = e();
            } catch (IOException e) {
                i0.d("AVFSCacheManager", e, new Object[0]);
                file = null;
            }
            return b(file, str);
        }
        throw new IllegalArgumentException("moduleName cannot be null");
    }

    public Context c() {
        return this.c;
    }

    public File e() throws IOException {
        try {
            return f(true);
        } catch (IOException e) {
            i0.d("AVFSCacheManager", e, new Object[0]);
            return f(false);
        }
    }

    public File f(boolean z) throws IOException {
        if (z) {
            try {
                File externalFilesDir = this.c.getExternalFilesDir("AVFSCache");
                if (externalFilesDir != null) {
                    return externalFilesDir;
                }
                throw new IOException("Couldn't create directory AVFSCache");
            } catch (Exception e) {
                throw new IOException(e);
            }
        } else {
            File file = new File(this.c.getFilesDir(), "AVFSCache");
            com.taobao.alivfssdk.utils.a.a(file);
            return file;
        }
    }

    public void g(@NonNull String str) {
        if (str != null) {
            synchronized (this.a) {
                a remove = this.a.remove(str);
                if (remove != null) {
                    remove.clearAll();
                    return;
                }
                return;
            }
        }
        throw new IllegalArgumentException("moduleName cannot be null");
    }
}
