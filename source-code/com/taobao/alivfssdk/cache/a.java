package com.taobao.alivfssdk.cache;

import android.app.Application;
import androidx.annotation.Nullable;
import com.taobao.alivfssdk.fresco.cache.disk.DefaultDiskStorage;
import com.taobao.alivfssdk.fresco.cache.disk.DiskStorageCache;
import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import com.taobao.orange.OConfigListener;
import com.taobao.orange.OrangeConfig;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import tb.f0;
import tb.g0;
import tb.i0;

/* compiled from: Taobao */
public class a implements Closeable {
    private static boolean i;
    private Set<String> a = new HashSet();
    private final String b;
    private IAVFSCache c;
    private IAVFSCache d;
    private IAVFSCache e;
    private final g0 f = g0.a();
    private final File g;
    private ClassLoader h;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class b implements OConfigListener {
        private b() {
        }

        /* JADX WARNING: Removed duplicated region for block: B:22:0x0059  */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x0064 A[SYNTHETIC, Splitter:B:26:0x0064] */
        /* JADX WARNING: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
        @Override // com.taobao.orange.OConfigListener
        public void onConfigUpdate(String str, Map<String, String> map) {
            String config;
            Throwable th;
            IOException e;
            if ("ali_database_es".equals(str) && (config = OrangeConfig.getInstance().getConfig("ali_database_es", "lsm_white_list", "")) != null && config.length() > 0) {
                Application a = f0.a();
                FileWriter fileWriter = null;
                try {
                    FileWriter fileWriter2 = new FileWriter(a.getFilesDir().getAbsolutePath() + File.pathSeparator + "alivfs.cfg");
                    try {
                        fileWriter2.write(config);
                        try {
                            fileWriter2.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    } catch (IOException e3) {
                        e = e3;
                        fileWriter = fileWriter2;
                        try {
                            e.printStackTrace();
                            if (fileWriter == null) {
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            if (fileWriter != null) {
                                try {
                                    fileWriter.close();
                                } catch (IOException e4) {
                                    e4.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        fileWriter = fileWriter2;
                        if (fileWriter != null) {
                        }
                        throw th;
                    }
                } catch (IOException e5) {
                    e = e5;
                    e.printStackTrace();
                    if (fileWriter == null) {
                        fileWriter.close();
                    }
                }
            }
        }
    }

    public a(@Nullable String str, @Nullable File file) {
        this.b = str;
        this.g = file;
        if (file == null) {
            e a2 = e.a();
            this.e = a2;
            this.d = a2;
            this.c = a2;
        }
    }

    public ClassLoader a() {
        return this.h;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0092 A[SYNTHETIC, Splitter:B:29:0x0092] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x009a A[SYNTHETIC, Splitter:B:33:0x009a] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00c1  */
    public IAVFSCache c() {
        Throwable th;
        IOException e2;
        if (this.c == null) {
            if (!i) {
                synchronized (this) {
                    if (!i) {
                        OrangeConfig.getInstance().getConfig("ali_database_es", "lsm_white_list", "false");
                        BufferedReader bufferedReader = null;
                        OrangeConfig.getInstance().registerListener(new String[]{"ali_database_es"}, new b(), false);
                        Application a2 = f0.a();
                        File file = new File(a2.getFilesDir().getAbsolutePath() + File.pathSeparator + "alivfs.cfg");
                        if (file.exists()) {
                            try {
                                BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file));
                                try {
                                    String readLine = bufferedReader2.readLine();
                                    if (readLine != null) {
                                        this.a.addAll(Arrays.asList(readLine.split(",")));
                                    }
                                    try {
                                        bufferedReader2.close();
                                    } catch (IOException e3) {
                                        e = e3;
                                    }
                                } catch (IOException e4) {
                                    e2 = e4;
                                    bufferedReader = bufferedReader2;
                                    try {
                                        e2.printStackTrace();
                                        if (bufferedReader != null) {
                                        }
                                        i = true;
                                        if (!this.a.contains(this.b)) {
                                        }
                                        return this.c;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        if (bufferedReader != null) {
                                            try {
                                                bufferedReader.close();
                                            } catch (IOException e5) {
                                                e5.printStackTrace();
                                            }
                                        }
                                        throw th;
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    bufferedReader = bufferedReader2;
                                    if (bufferedReader != null) {
                                    }
                                    throw th;
                                }
                            } catch (IOException e6) {
                                e2 = e6;
                                e2.printStackTrace();
                                if (bufferedReader != null) {
                                    try {
                                        bufferedReader.close();
                                    } catch (IOException e7) {
                                        e = e7;
                                    }
                                }
                                i = true;
                                if (!this.a.contains(this.b)) {
                                }
                                return this.c;
                            }
                        }
                    }
                    i = true;
                }
            }
            if (!this.a.contains(this.b)) {
                this.c = d.e(this.b, 16777216, 21600);
            } else {
                this.c = new c(this, "file", new DefaultDiskStorage(new File(this.g, AVFSCacheConstants.AVFS_FIlE_PATH_NAME), 1, com.taobao.alivfssdk.fresco.cache.common.a.a()), new DiskStorageCache.b((long) 0, 0, this.f.a.longValue()), (int) this.f.b);
            }
        }
        return this.c;
        e.printStackTrace();
        i = true;
        if (!this.a.contains(this.b)) {
        }
        return this.c;
    }

    public void clearAll() {
        try {
            close();
        } catch (IOException e2) {
            i0.d("AVFSCache", e2, new Object[0]);
        }
        File file = this.g;
        if (file != null) {
            com.taobao.alivfssdk.fresco.common.file.a.a(file);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        IAVFSCache iAVFSCache = this.c;
        if (iAVFSCache != null) {
            iAVFSCache.close();
            this.c = null;
        }
        IAVFSCache iAVFSCache2 = this.d;
        if (iAVFSCache2 != null) {
            iAVFSCache2.close();
            this.d = null;
        }
        IAVFSCache iAVFSCache3 = this.e;
        if (iAVFSCache3 != null) {
            iAVFSCache3.close();
            this.e = null;
        }
    }

    public String e() {
        return this.b;
    }

    public a f(g0 g0Var) {
        this.f.b(g0Var);
        return this;
    }

    /* access modifiers changed from: protected */
    @Override // java.lang.Object
    public void finalize() throws Throwable {
        super.finalize();
    }
}
