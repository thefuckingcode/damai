package com.amap.api.mapcore.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Environment;
import android.os.StatFs;
import android.taobao.windvane.connect.HttpRequest;
import android.text.TextUtils;
import com.amap.api.mapcore.util.hy;
import com.youku.upsplayer.util.YKUpsConvert;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import java.security.MessageDigest;
import java.util.HashMap;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* compiled from: Taobao */
public class eu {
    private static final Bitmap.CompressFormat a = Bitmap.CompressFormat.PNG;
    private hy b;
    private ec<String, Bitmap> c;
    private a d;
    private final Object e = new Object();
    private boolean f = true;
    private HashMap<String, WeakReference<Bitmap>> g;

    /* compiled from: Taobao */
    public static class a {
        public int a = HttpRequest.DEFAULT_MAX_LENGTH;
        public long b = 10485760;
        public File c;
        public Bitmap.CompressFormat d = eu.a;
        public int e = 100;
        public boolean f = true;
        public boolean g = true;
        public boolean h = false;
        public boolean i = true;
        public String j = null;

        public a(Context context, String str) {
            this.j = str;
            this.c = eu.a(context, str, null);
        }

        public void a(int i2) {
            this.a = i2;
        }

        public void b(boolean z) {
            this.g = z;
        }

        public void a(long j2) {
            if (j2 <= 0) {
                this.g = false;
            }
            this.b = j2;
        }

        public void b(String str) {
            this.c = eu.a(t.a, this.j, str);
        }

        public void a(String str) {
            this.c = new File(str);
        }

        public void a(boolean z) {
            this.f = z;
        }

        public a(Context context, String str, String str2) {
            this.j = str;
            this.c = eu.a(context, str, str2);
        }
    }

    private eu(a aVar) {
        b(aVar);
    }

    private void b(a aVar) {
        this.d = aVar;
        if (aVar.f) {
            if (ev.a()) {
                this.g = new HashMap<>(64);
            }
            this.c = new ec<String, Bitmap>(this.d.a) {
                /* class com.amap.api.mapcore.util.eu.AnonymousClass1 */

                /* access modifiers changed from: protected */
                public void a(boolean z, String str, Bitmap bitmap, Bitmap bitmap2) {
                    if (eq.c() && eu.this.g != null && bitmap != null && !bitmap.isRecycled()) {
                        eu.this.g.put(str, new WeakReference(bitmap));
                    }
                }

                /* access modifiers changed from: protected */
                /* renamed from: a */
                public int b(String str, Bitmap bitmap) {
                    int a2 = eu.a(bitmap);
                    if (a2 == 0) {
                        return 1;
                    }
                    return a2;
                }
            };
        }
        if (aVar.h) {
            a();
        }
    }

    public static boolean d() {
        if (eq.b()) {
            return Environment.isExternalStorageRemovable();
        }
        return true;
    }

    public void c() {
        synchronized (this.e) {
            hy hyVar = this.b;
            if (hyVar != null) {
                try {
                    hyVar.e();
                } catch (Throwable unused) {
                }
            }
        }
    }

    public static eu a(a aVar) {
        return new eu(aVar);
    }

    public void a() {
        synchronized (this.e) {
            hy hyVar = this.b;
            if (hyVar == null || hyVar.d()) {
                a aVar = this.d;
                File file = aVar.c;
                if (aVar.g && file != null) {
                    try {
                        if (!file.exists()) {
                            file.mkdirs();
                        } else if (this.d.i) {
                            b(file);
                            file.mkdir();
                        }
                    } catch (Throwable unused) {
                    }
                    long a2 = a(file);
                    long j = this.d.b;
                    if (a2 > j) {
                        try {
                            this.b = hy.a(file, 1, 1, j);
                        } catch (Throwable unused2) {
                            this.d.c = null;
                        }
                    }
                }
            }
            this.f = false;
            this.e.notifyAll();
        }
    }

    public static String c(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            instance.update(str.getBytes("utf-8"));
            return a(instance.digest());
        } catch (Throwable unused) {
            return String.valueOf(str.hashCode());
        }
    }

    private void b(File file) throws IOException {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    b(file2);
                }
                if (!file2.delete()) {
                    throw new IOException("failed to delete file: " + file2);
                }
            }
            return;
        }
        throw new IOException("not a readable directory: " + file);
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:2:0x0007 */
    /* JADX WARNING: Removed duplicated region for block: B:2:0x0007 A[LOOP:0: B:2:0x0007->B:37:0x0007, LOOP_START, SYNTHETIC] */
    public Bitmap b(String str) {
        Bitmap bitmap;
        InputStream inputStream;
        Bitmap bitmap2;
        String c2 = c(str);
        synchronized (this.e) {
            while (this.f) {
                this.e.wait();
            }
            hy hyVar = this.b;
            bitmap = null;
            InputStream inputStream2 = null;
            bitmap = null;
            bitmap = null;
            bitmap = null;
            if (hyVar != null) {
                try {
                    hy.b a2 = hyVar.a(c2);
                    if (a2 != null) {
                        inputStream = a2.a(0);
                        if (inputStream != null) {
                            try {
                                bitmap2 = es.a(((FileInputStream) inputStream).getFD(), Integer.MAX_VALUE, Integer.MAX_VALUE, this);
                            } catch (Throwable unused) {
                            }
                        } else {
                            bitmap2 = null;
                        }
                        inputStream2 = inputStream;
                    } else {
                        bitmap2 = null;
                    }
                    if (inputStream2 != null) {
                        try {
                            inputStream2.close();
                        } catch (Throwable unused2) {
                        }
                    }
                    bitmap = bitmap2;
                } catch (Throwable unused3) {
                    inputStream = null;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable unused4) {
                        }
                    }
                    return bitmap;
                }
            }
        }
        return bitmap;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x004a, code lost:
        if (r1 != null) goto L_0x004c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0050, code lost:
        if (0 == 0) goto L_0x0053;
     */
    public void a(String str, Bitmap bitmap) {
        if (str != null && bitmap != null && !bitmap.isRecycled()) {
            ec<String, Bitmap> ecVar = this.c;
            if (ecVar != null) {
                ecVar.a(str, bitmap);
            }
            synchronized (this.e) {
                if (this.b != null) {
                    String c2 = c(str);
                    OutputStream outputStream = null;
                    try {
                        hy.b a2 = this.b.a(c2);
                        if (a2 == null) {
                            hy.a b2 = this.b.b(c2);
                            if (b2 != null) {
                                outputStream = b2.a(0);
                                a aVar = this.d;
                                bitmap.compress(aVar.d, aVar.e, outputStream);
                                b2.a();
                                outputStream.close();
                            }
                        } else {
                            a2.a(0).close();
                        }
                    } catch (Throwable unused) {
                    }
                }
            }
        }
    }

    public void b() {
        HashMap<String, WeakReference<Bitmap>> hashMap;
        if (eq.c() && (hashMap = this.g) != null) {
            hashMap.clear();
        }
        ec<String, Bitmap> ecVar = this.c;
        if (ecVar != null) {
            ecVar.a();
        }
        synchronized (this.e) {
            this.f = true;
            hy hyVar = this.b;
            if (hyVar != null && !hyVar.d()) {
                try {
                    this.b.close();
                    b(a(t.a, this.d.j, null));
                } catch (Throwable unused) {
                }
                this.b = null;
                a();
            }
        }
    }

    public Bitmap a(String str) {
        Bitmap bitmap;
        ec<String, Bitmap> ecVar;
        HashMap<String, WeakReference<Bitmap>> hashMap;
        WeakReference<Bitmap> weakReference;
        if (!eq.c() || (hashMap = this.g) == null || (weakReference = hashMap.get(str)) == null) {
            bitmap = null;
        } else {
            bitmap = weakReference.get();
            if (bitmap == null || bitmap.isRecycled()) {
                bitmap = null;
            }
            this.g.remove(str);
        }
        if (bitmap == null && (ecVar = this.c) != null) {
            bitmap = ecVar.a(str);
        }
        if (bitmap == null || bitmap.isRecycled()) {
            return null;
        }
        return bitmap;
    }

    public void a(boolean z) {
        HashMap<String, WeakReference<Bitmap>> hashMap;
        if (eq.c() && (hashMap = this.g) != null) {
            hashMap.clear();
        }
        ec<String, Bitmap> ecVar = this.c;
        if (ecVar != null) {
            ecVar.a();
        }
        synchronized (this.e) {
            hy hyVar = this.b;
            if (hyVar != null) {
                try {
                    if (!hyVar.d()) {
                        if (z) {
                            this.b.f();
                        } else {
                            this.b.close();
                        }
                        this.b = null;
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    public static File a(Context context, String str, String str2) {
        String str3;
        File a2 = a(context);
        if (("mounted".equals(Environment.getExternalStorageState()) || !d()) && a2 != null) {
            str3 = a2.getPath();
        } else {
            str3 = context.getCacheDir().getPath();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str3);
        String str4 = File.separator;
        sb.append(str4);
        sb.append(str);
        if (!TextUtils.isEmpty(str2)) {
            sb.append(str4);
            sb.append(str2);
        }
        return new File(sb.toString());
    }

    private static String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b2 : bArr) {
            String hexString = Integer.toHexString(b2 & 255);
            if (hexString.length() == 1) {
                sb.append(YKUpsConvert.CHAR_ZERO);
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    public static int a(Bitmap bitmap) {
        if (eq.d()) {
            return bitmap.getByteCount();
        }
        return bitmap.getRowBytes() * bitmap.getHeight();
    }

    public static File a(Context context) {
        try {
            if (eq.a()) {
                return context.getExternalCacheDir();
            }
            return new File(Environment.getExternalStorageDirectory().getPath() + ("/Android/data/" + context.getPackageName() + "/cache/"));
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static long a(File file) {
        if (eq.b()) {
            return file.getUsableSpace();
        }
        StatFs statFs = new StatFs(file.getPath());
        return ((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks());
    }
}
