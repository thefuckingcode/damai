package com.ali.ha.fulltrace.upload;

import android.app.Application;
import android.content.SharedPreferences;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.util.Base64;
import com.ali.ha.fulltrace.dump.DumpManager;
import com.alibaba.wireless.security.aopsdk.replace.android.net.ConnectivityManager;
import com.youku.live.livesdk.wkit.component.Constants;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.zip.GZIPOutputStream;
import me.ele.altriax.launcher.common.AltriaXLaunchTime;
import tb.lg0;
import tb.mn0;
import tb.n82;
import tb.p91;
import tb.ts2;

/* compiled from: Taobao */
public class UploadManager {
    public static final String HOTDATA = "hotdata";
    private Application a;
    private SharedPreferences b;
    private long c;
    private volatile boolean d;
    private volatile boolean e;
    private volatile boolean f;
    private int g;
    private long h;
    private long i;
    private long j;
    private long k;
    private long l;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class a implements FileFilter {
        a() {
        }

        public boolean accept(File file) {
            if (!file.isFile() || UploadManager.this.e(file, ".trace") <= 0) {
                return false;
            }
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class b implements Comparator<File> {
        b() {
        }

        /* renamed from: a */
        public int compare(File file, File file2) {
            int i = ((UploadManager.this.e(file, ".trace") - UploadManager.this.e(file2, ".trace")) > 0 ? 1 : ((UploadManager.this.e(file, ".trace") - UploadManager.this.e(file2, ".trace")) == 0 ? 0 : -1));
            if (i == 0) {
                return 0;
            }
            return i > 0 ? 1 : -1;
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class c implements FileFilter {
        c(UploadManager uploadManager) {
        }

        public boolean accept(File file) {
            return file.getName().endsWith(".trace");
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class d implements FileFilter {
        d(UploadManager uploadManager) {
        }

        public boolean accept(File file) {
            return file.getName().endsWith(".trace");
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class e implements FileFilter {
        e() {
        }

        public boolean accept(File file) {
            if (!file.isDirectory() || UploadManager.this.g(file.getName()) <= 0) {
                return false;
            }
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class f implements Comparator<File> {
        f() {
        }

        /* renamed from: a */
        public int compare(File file, File file2) {
            int i = ((UploadManager.this.g(file2.getName()) - UploadManager.this.g(file.getName())) > 0 ? 1 : ((UploadManager.this.g(file2.getName()) - UploadManager.this.g(file.getName())) == 0 ? 0 : -1));
            if (i == 0) {
                return 0;
            }
            return i > 0 ? 1 : -1;
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class g implements FileFilter {
        g() {
        }

        public boolean accept(File file) {
            if (!file.isDirectory() || UploadManager.this.g(file.getName()) <= 0 || file.getName().equals(String.valueOf(DumpManager.c))) {
                return false;
            }
            return true;
        }
    }

    /* compiled from: Taobao */
    private static final class h {
        private static final UploadManager a = new UploadManager();
    }

    private void d(List<File> list, long j2) {
        File[] listFiles;
        long j3 = j2;
        int size = list.size();
        long j4 = j3 - this.l;
        long currentTimeMillis = System.currentTimeMillis();
        int i2 = 1;
        int i3 = size - 1;
        while (i3 > -1) {
            File file = list.get(i3);
            if (file.isDirectory() && (listFiles = file.listFiles(new c(this))) != null) {
                int length = listFiles.length;
                int i4 = 0;
                while (i4 < length) {
                    File file2 = listFiles[i4];
                    if (file2.isFile()) {
                        if (j4 > 0) {
                            Object[] objArr = new Object[i2];
                            objArr[0] = "total size large than MAX_CACHE_SIZE! " + j3 + " remove=" + file2.getAbsolutePath() + AltriaXLaunchTime.SPACE + file2.length() + " outSize=" + j4;
                            p91.d("UploadManager", objArr);
                            j4 -= file2.length();
                            file2.delete();
                        } else if (file2.length() >= this.k) {
                            p91.b("UploadManager", "file size is to large! " + file2.getAbsolutePath() + " " + file2.length());
                            file2.delete();
                        } else {
                            long e2 = e(file2, ".trace");
                            if (e2 > 0 && currentTimeMillis - e2 > this.i) {
                                p91.d("UploadManager", "file date is expired! " + file2.getAbsolutePath());
                                file2.delete();
                                i4++;
                                j3 = j2;
                                i2 = 1;
                            }
                        }
                    }
                    i4++;
                    j3 = j2;
                    i2 = 1;
                }
            }
            i3--;
            j3 = j2;
            i2 = 1;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private long e(File file, String str) {
        String name = file.getName();
        if (TextUtils.isEmpty(str)) {
            return g(name);
        }
        int indexOf = name.indexOf(str);
        if (indexOf > 0) {
            return g(name.substring(0, indexOf));
        }
        return -1;
    }

    public static final UploadManager f() {
        return h.a;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private long g(String str) {
        try {
            return Long.parseLong(str);
        } catch (Throwable th) {
            th.printStackTrace();
            return -1;
        }
    }

    private List<File> h() {
        File[] listFiles;
        File file = new File(DumpManager.e(this.a));
        if (!file.exists() || (listFiles = file.listFiles(new e())) == null || listFiles.length <= 1) {
            return null;
        }
        List asList = Arrays.asList(listFiles);
        if (asList.size() > 1) {
            Collections.sort(asList, new f());
        }
        ArrayList arrayList = new ArrayList(asList);
        arrayList.remove(0);
        return arrayList;
    }

    private void k() {
        SharedPreferences a2 = ts2.b().a(this.a, "com.ali.fulltrace");
        this.b = a2;
        long j2 = a2.getLong("date", 0);
        this.c = this.b.getLong("size", 0);
        long currentTimeMillis = System.currentTimeMillis() / 86400000;
        if (currentTimeMillis != j2) {
            this.b.edit().putLong("date", currentTimeMillis).putLong("size", 0).apply();
            this.c = 0;
        }
        this.g = 30000;
        this.h = 1048576;
        this.i = 604800000;
        this.j = 300000;
        this.k = 256000;
        this.l = 52428800;
    }

    private void l() {
        File[] listFiles;
        String d2 = DumpManager.d(this.a);
        String e2 = DumpManager.e(this.a);
        File file = new File(d2);
        if (file.exists() && (listFiles = file.listFiles(new g())) != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                StringBuilder sb = new StringBuilder();
                sb.append(file2.getAbsolutePath());
                String str = File.separator;
                sb.append(str);
                sb.append(HOTDATA);
                String str2 = e2 + str + file2.getName();
                if (new File(sb.toString()).exists()) {
                    DumpManager.c().g(file2.getAbsolutePath(), str2);
                }
                com.ali.ha.fulltrace.a.a(file2);
            }
        }
    }

    private long m(List<File> list) {
        File[] listFiles;
        long j2 = 0;
        for (File file : list) {
            if (file.isDirectory() && (listFiles = file.listFiles(new d(this))) != null) {
                for (File file2 : listFiles) {
                    if (file2.isFile()) {
                        j2 += file2.length();
                    }
                }
            }
        }
        return j2;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void n() {
        if (!this.f && !this.e) {
            this.f = true;
            l();
            List<File> h2 = h();
            if (h2 == null || h2.size() <= 0) {
                p91.d("UploadManager", "upload dir is empty !");
                this.e = true;
                this.f = false;
                return;
            }
            d(h2, m(h2));
            p91.a("start upload", new Object[0]);
            this.e = p(h2);
            if (!this.e && this.d) {
                mn0.a().b().postDelayed(new Runnable() {
                    /* class com.ali.ha.fulltrace.upload.UploadManager.AnonymousClass2 */

                    public void run() {
                        try {
                            UploadManager.this.n();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }, this.j);
            }
            this.f = false;
            p91.a("finish upload", new Object[0]);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:58:0x010d A[SYNTHETIC, Splitter:B:58:0x010d] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x011c A[SYNTHETIC, Splitter:B:63:0x011c] */
    private boolean o(File file, String str) {
        byte[] bArr;
        GZIPOutputStream gZIPOutputStream;
        byte[] bArr2;
        long j2 = 0;
        if (file.length() == 0) {
            return true;
        }
        try {
            boolean j3 = j();
            if (j3) {
                j2 = this.c + ((long) (((double) file.length()) * 0.4d));
                if (j2 >= this.h) {
                    p91.g("UploadManager", "upload size larger than MAX_MOBILE_TRAFFIC! " + file.getAbsolutePath() + " " + file.length() + " " + j2);
                    return false;
                }
            }
            byte[] e2 = com.ali.ha.fulltrace.a.e(file);
            if (e2 == null) {
                p91.b("UploadManager", "read file failed! " + file.getAbsolutePath() + " " + file.length());
                return true;
            }
            ByteArrayOutputStream byteArrayOutputStream = null;
            try {
                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                try {
                    gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream2);
                    try {
                        gZIPOutputStream.write(e2);
                        gZIPOutputStream.flush();
                        gZIPOutputStream.close();
                        byte[] byteArray = byteArrayOutputStream2.toByteArray();
                        if (byteArray == null || byteArray.length == 0) {
                            p91.b("UploadManager", "gzip failed!");
                            try {
                                byteArrayOutputStream2.close();
                            } catch (IOException e3) {
                                p91.b("baOS close failed", e3);
                            }
                            return true;
                        }
                        bArr = Base64.encode(byteArray, 2);
                        if (bArr != null) {
                            try {
                                if (bArr.length != 0) {
                                    try {
                                        byteArrayOutputStream2.close();
                                    } catch (IOException e4) {
                                        p91.b("baOS close failed", e4);
                                    }
                                    boolean a2 = n82.a(str, new String(bArr));
                                    if (a2 && j3) {
                                        this.c = j2;
                                        this.b.edit().putLong("size", this.c).apply();
                                    }
                                    return a2;
                                }
                            } catch (Throwable unused) {
                                gZIPOutputStream = null;
                                byteArrayOutputStream = byteArrayOutputStream2;
                                bArr2 = bArr;
                                try {
                                    p91.b("UploadManager", "gzip and base64 error!");
                                    if (byteArrayOutputStream != null) {
                                    }
                                    if (gZIPOutputStream != null) {
                                    }
                                    bArr = bArr2;
                                    boolean a22 = n82.a(str, new String(bArr));
                                    this.c = j2;
                                    this.b.edit().putLong("size", this.c).apply();
                                    return a22;
                                } catch (Throwable th) {
                                    if (byteArrayOutputStream != null) {
                                        try {
                                            byteArrayOutputStream.close();
                                        } catch (IOException e5) {
                                            p91.b("baOS close failed", e5);
                                        }
                                    }
                                    if (gZIPOutputStream != null) {
                                        try {
                                            gZIPOutputStream.close();
                                        } catch (IOException e6) {
                                            p91.b("gzipOS close failed", e6);
                                        }
                                    }
                                    throw th;
                                }
                            }
                        }
                        p91.b("UploadManager", "base64 failed!");
                        try {
                            byteArrayOutputStream2.close();
                        } catch (IOException e7) {
                            p91.b("baOS close failed", e7);
                        }
                        return true;
                    } catch (Throwable unused2) {
                        bArr2 = null;
                        byteArrayOutputStream = byteArrayOutputStream2;
                        p91.b("UploadManager", "gzip and base64 error!");
                        if (byteArrayOutputStream != null) {
                        }
                        if (gZIPOutputStream != null) {
                        }
                        bArr = bArr2;
                        boolean a222 = n82.a(str, new String(bArr));
                        this.c = j2;
                        this.b.edit().putLong("size", this.c).apply();
                        return a222;
                    }
                } catch (Throwable unused3) {
                    gZIPOutputStream = null;
                    byteArrayOutputStream = byteArrayOutputStream2;
                    bArr2 = null;
                    p91.b("UploadManager", "gzip and base64 error!");
                    if (byteArrayOutputStream != null) {
                    }
                    if (gZIPOutputStream != null) {
                    }
                    bArr = bArr2;
                    boolean a2222 = n82.a(str, new String(bArr));
                    this.c = j2;
                    this.b.edit().putLong("size", this.c).apply();
                    return a2222;
                }
            } catch (Throwable unused4) {
                bArr2 = null;
                gZIPOutputStream = null;
                p91.b("UploadManager", "gzip and base64 error!");
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e8) {
                        p91.b("baOS close failed", e8);
                    }
                }
                if (gZIPOutputStream != null) {
                    try {
                        gZIPOutputStream.close();
                    } catch (IOException e9) {
                        p91.b("gzipOS close failed", e9);
                    }
                }
                bArr = bArr2;
                boolean a22222 = n82.a(str, new String(bArr));
                this.c = j2;
                this.b.edit().putLong("size", this.c).apply();
                return a22222;
            }
        } catch (OutOfMemoryError unused5) {
            file.delete();
            p91.b("UploadManager", "read file oom! " + file.getAbsolutePath() + " " + file.length());
            return false;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return false;
        }
    }

    private boolean p(List<File> list) {
        for (File file : list) {
            if (file.isDirectory()) {
                File[] listFiles = file.listFiles(new a());
                if (listFiles == null || listFiles.length <= 0) {
                    p91.d("UploadManager", "upload dir is empty=" + file.getAbsolutePath());
                    com.ali.ha.fulltrace.a.a(file);
                } else {
                    List asList = Arrays.asList(listFiles);
                    if (asList.size() > 1) {
                        Collections.sort(asList, new b());
                    }
                    String substring = file.getAbsolutePath().substring(file.getAbsolutePath().lastIndexOf("/") + 1);
                    String num = Integer.toString((substring + lg0.g).hashCode());
                    int size = asList.size();
                    int i2 = 0;
                    boolean z = false;
                    while (true) {
                        if (i2 >= size) {
                            break;
                        }
                        File file2 = (File) asList.get(i2);
                        StringBuilder sb = new StringBuilder();
                        sb.append(num);
                        sb.append(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX);
                        i2++;
                        sb.append(i2);
                        sb.append(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX);
                        sb.append(size);
                        boolean o = o(file2, sb.toString());
                        p91.d("UploadManager", "upload file=" + file2.getAbsolutePath() + " " + o + " " + file2.length());
                        if (!o) {
                            z = o;
                            break;
                        }
                        file2.delete();
                        z = o;
                    }
                    if (!z) {
                        return false;
                    }
                    com.ali.ha.fulltrace.a.a(file);
                }
            }
        }
        return true;
    }

    public void i(Application application) {
        this.a = application;
        k();
        mn0.a().b().postDelayed(new Runnable() {
            /* class com.ali.ha.fulltrace.upload.UploadManager.AnonymousClass1 */

            public void run() {
                try {
                    UploadManager.this.n();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, (long) this.g);
    }

    public boolean j() {
        try {
            NetworkInfo activeNetworkInfo = ConnectivityManager.getActiveNetworkInfo((android.net.ConnectivityManager) this.a.getSystemService("connectivity"));
            if (activeNetworkInfo == null || activeNetworkInfo.getType() != 0) {
                return false;
            }
            return activeNetworkInfo.isAvailable();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    private UploadManager() {
        this.c = 0;
        this.d = true;
        this.e = false;
        this.f = false;
        this.g = 20000;
        this.h = 1048576;
        this.i = 604800000;
        this.j = 300000;
        this.k = 256000;
        this.l = 52428800;
    }
}
