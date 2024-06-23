package com.taobao.android.dinamic.tempate.manager;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import android.util.LruCache;
import com.taobao.android.dinamic.tempate.DinamicTemplate;
import com.taobao.android.dinamic.tempate.db.FileCache;
import com.youku.alixplayer.ExtraID;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import tb.tj2;

/* compiled from: Taobao */
public class TemplateCache {
    public static HttpLoader k = new b();
    protected final String a;
    protected final String b;
    protected final long c;
    protected final int d;
    protected final Context e;
    protected final File f;
    protected final boolean g;
    protected FileCache h;
    protected LruCache<String, byte[]> i;
    protected HttpLoader j;

    /* compiled from: Taobao */
    public interface HttpLoader {
        byte[] loadUrl(String str);
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class a extends AsyncTask<Void, Void, Void> {
        final /* synthetic */ String a;
        final /* synthetic */ String b;
        final /* synthetic */ byte[] c;
        final /* synthetic */ DinamicTemplate d;
        final /* synthetic */ tj2 e;

        a(String str, String str2, byte[] bArr, DinamicTemplate dinamicTemplate, tj2 tj2) {
            this.a = str;
            this.b = str2;
            this.c = bArr;
            this.d = dinamicTemplate;
            this.e = tj2;
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x003c, code lost:
            if (r1.isFile() == false) goto L_0x005a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0046, code lost:
            if (r1.length() <= 0) goto L_0x005a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
            r7.f.h.g(r7.a, r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0052, code lost:
            r8 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0053, code lost:
            android.util.Log.e("TemplateCache", "File cache store exception", r8);
         */
        /* renamed from: a */
        public Void doInBackground(Void... voidArr) {
            String str;
            if (TemplateCache.this.g) {
                str = this.a;
            } else {
                str = Uri.parse(Uri.decode(this.b)).getLastPathSegment();
            }
            synchronized (TemplateCache.class) {
                File file = new File(TemplateCache.this.f, str);
                if (file.exists()) {
                    return null;
                }
                TemplateCache.this.m(this.c, file, this.d, this.e.c);
            }
            return null;
        }
    }

    /* compiled from: Taobao */
    static class b implements HttpLoader {
        b() {
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:47:? */
        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.io.InputStream */
        /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: java.io.InputStream */
        /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: java.io.InputStream */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARNING: Code restructure failed: missing block: B:54:0x0080, code lost:
            if (r8 == null) goto L_0x0083;
         */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x005f A[SYNTHETIC, Splitter:B:34:0x005f] */
        /* JADX WARNING: Removed duplicated region for block: B:39:0x0067 A[Catch:{ IOException -> 0x0063 }] */
        /* JADX WARNING: Removed duplicated region for block: B:41:0x006c  */
        /* JADX WARNING: Removed duplicated region for block: B:48:0x0075 A[SYNTHETIC, Splitter:B:48:0x0075] */
        /* JADX WARNING: Removed duplicated region for block: B:53:0x007d A[Catch:{ IOException -> 0x0079 }] */
        @Override // com.taobao.android.dinamic.tempate.manager.TemplateCache.HttpLoader
        public byte[] loadUrl(String str) {
            ByteArrayOutputStream byteArrayOutputStream;
            HttpURLConnection httpURLConnection;
            InputStream inputStream;
            Throwable th;
            try {
                httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                try {
                    httpURLConnection.setConnectTimeout(10000);
                    httpURLConnection.setReadTimeout(ExtraID.ERRCODE_PARSER_SEEK_BUFFER_ERR);
                    httpURLConnection.connect();
                    if (httpURLConnection.getResponseCode() != 200) {
                        httpURLConnection.disconnect();
                        return null;
                    }
                    inputStream = httpURLConnection.getInputStream();
                    try {
                        byteArrayOutputStream = new ByteArrayOutputStream(4096);
                    } catch (Exception unused) {
                        byteArrayOutputStream = null;
                        if (byteArrayOutputStream != null) {
                        }
                        if (inputStream != 0) {
                        }
                    } catch (Throwable th2) {
                        byteArrayOutputStream = null;
                        th = th2;
                        if (byteArrayOutputStream != null) {
                        }
                        if (inputStream != null) {
                        }
                        if (httpURLConnection != null) {
                        }
                        throw th;
                    }
                    try {
                        byte[] bArr = new byte[4096];
                        while (true) {
                            int read = inputStream.read(bArr);
                            if (read != -1) {
                                byteArrayOutputStream.write(bArr, 0, read);
                            } else {
                                try {
                                    break;
                                } catch (IOException unused2) {
                                }
                            }
                        }
                        byteArrayOutputStream.close();
                        inputStream.close();
                    } catch (Exception unused3) {
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (IOException unused4) {
                            }
                        }
                        if (inputStream != 0) {
                            inputStream.close();
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (IOException unused5) {
                                if (httpURLConnection != null) {
                                }
                                throw th;
                            }
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        throw th;
                    }
                    httpURLConnection.disconnect();
                    if (byteArrayOutputStream != null) {
                        return byteArrayOutputStream.toByteArray();
                    }
                    return null;
                } catch (Exception unused6) {
                    inputStream = 0;
                    byteArrayOutputStream = inputStream;
                    if (byteArrayOutputStream != null) {
                    }
                    if (inputStream != 0) {
                    }
                } catch (Throwable th4) {
                    byteArrayOutputStream = null;
                    th = th4;
                    inputStream = null;
                    if (byteArrayOutputStream != null) {
                    }
                    if (inputStream != null) {
                    }
                    if (httpURLConnection != null) {
                    }
                    throw th;
                }
            } catch (Exception unused7) {
                httpURLConnection = null;
                inputStream = null;
                byteArrayOutputStream = inputStream;
                if (byteArrayOutputStream != null) {
                }
                if (inputStream != 0) {
                }
            } catch (Throwable th5) {
                inputStream = null;
                byteArrayOutputStream = null;
                th = th5;
                httpURLConnection = null;
                if (byteArrayOutputStream != null) {
                }
                if (inputStream != null) {
                }
                if (httpURLConnection != null) {
                }
                throw th;
            }
        }
    }

    /* compiled from: Taobao */
    public static final class c {
        private Context a;
        private String b;
        private String c;
        private int d = 8;
        private long e = 4194304;
        private boolean f = true;

        public TemplateCache g() {
            if (!TextUtils.isEmpty(this.b) && !TextUtils.isEmpty(this.c)) {
                return new TemplateCache(this, null);
            }
            throw new IllegalArgumentException();
        }

        public c h(Context context) {
            this.a = context;
            return this;
        }

        public c i(String str) {
            this.c = str;
            return this;
        }

        public c j(long j) {
            this.e = j;
            return this;
        }

        public c k(int i) {
            this.d = i;
            return this;
        }

        public c l(String str) {
            this.b = str;
            return this;
        }
    }

    /* synthetic */ TemplateCache(c cVar, a aVar) {
        this(cVar);
    }

    private File b() {
        File f2;
        if (this.e == null || (f2 = f()) == null) {
            return null;
        }
        File file = new File(f2, this.a);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    private byte[] e(DinamicTemplate dinamicTemplate, String str, String str2, tj2 tj2) {
        long nanoTime = System.nanoTime();
        byte[] loadUrl = this.j.loadUrl(str2);
        long nanoTime2 = System.nanoTime();
        tj2.a = 3;
        tj2.b = nanoTime2 - nanoTime;
        i(tj2, dinamicTemplate, loadUrl != null);
        if (loadUrl != null) {
            this.i.put(str, loadUrl);
            Log.d("TemplateCache", "[getTemplateById #" + str + "] get template from server.");
            new a(str, str2, loadUrl, dinamicTemplate, tj2).executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, new Void[0]);
            return loadUrl;
        }
        Log.d("TemplateCache", "[getTemplateById #" + str + "] template from server is null.");
        return null;
    }

    private File f() {
        File filesDir = this.e.getFilesDir();
        if (filesDir != null && filesDir.canWrite()) {
            return filesDir;
        }
        File cacheDir = this.e.getCacheDir();
        if (cacheDir != null && cacheDir.canWrite()) {
            return cacheDir;
        }
        if ("mounted".equals(Environment.getExternalStorageState())) {
            try {
                File externalFilesDir = this.e.getExternalFilesDir(null);
                if (externalFilesDir != null && externalFilesDir.canWrite()) {
                    return externalFilesDir;
                }
                File externalCacheDir = this.e.getExternalCacheDir();
                if (externalCacheDir == null || !externalCacheDir.canWrite()) {
                    return null;
                }
                return externalCacheDir;
            } catch (Exception e2) {
                Log.e("TemplateCache", "get external files dir exception", e2);
            }
        }
        return null;
    }

    private void i(tj2 tj2, DinamicTemplate dinamicTemplate, boolean z) {
        com.taobao.android.dinamic.a.h().d();
    }

    private void j(String str, DinamicTemplate dinamicTemplate, boolean z, long j2) {
        com.taobao.android.dinamic.a.h().d();
    }

    private byte[] k(File file) throws IOException {
        int read;
        long length = file.length();
        if (length <= 2147483639) {
            FileInputStream fileInputStream = new FileInputStream(file);
            int i2 = (int) length;
            byte[] bArr = new byte[i2];
            int i3 = 0;
            while (true) {
                int read2 = fileInputStream.read(bArr, i3, i2 - i3);
                if (read2 > 0) {
                    i3 += read2;
                } else if (read2 < 0 || (read = fileInputStream.read()) < 0) {
                    fileInputStream.close();
                } else {
                    if (i2 <= 2147483639 - i2) {
                        i2 = Math.max(i2 << 1, 8192);
                    } else if (i2 != 2147483639) {
                        i2 = 2147483639;
                    } else {
                        throw new OutOfMemoryError("Required array size too large");
                    }
                    bArr = Arrays.copyOf(bArr, i2);
                    bArr[i3] = (byte) read;
                    i3++;
                }
            }
            fileInputStream.close();
            return i2 == i3 ? bArr : Arrays.copyOf(bArr, i3);
        }
        throw new OutOfMemoryError("Required array size too large");
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003b, code lost:
        if (r3 != null) goto L_0x001f;
     */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x002a A[SYNTHETIC, Splitter:B:12:0x002a] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0043 A[SYNTHETIC, Splitter:B:21:0x0043] */
    private File m(byte[] bArr, File file, DinamicTemplate dinamicTemplate, String str) {
        Throwable th;
        BufferedOutputStream bufferedOutputStream;
        long nanoTime = System.nanoTime();
        BufferedOutputStream bufferedOutputStream2 = null;
        try {
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
            try {
                bufferedOutputStream.write(bArr);
                j(str, dinamicTemplate, true, System.nanoTime() - nanoTime);
            } catch (Exception unused) {
                if (file != null) {
                }
                j(str, dinamicTemplate, false, System.nanoTime() - nanoTime);
            }
        } catch (Exception unused2) {
            bufferedOutputStream = null;
            if (file != null) {
                try {
                    file.delete();
                    file = null;
                } catch (Throwable th2) {
                    th = th2;
                    bufferedOutputStream2 = bufferedOutputStream;
                    if (bufferedOutputStream2 != null) {
                    }
                    throw th;
                }
            }
            j(str, dinamicTemplate, false, System.nanoTime() - nanoTime);
        } catch (Throwable th3) {
            th = th3;
            if (bufferedOutputStream2 != null) {
                try {
                    bufferedOutputStream2.close();
                } catch (IOException unused3) {
                }
            }
            throw th;
        }
        try {
            bufferedOutputStream.close();
        } catch (IOException unused4) {
        }
        return file;
    }

    /* access modifiers changed from: protected */
    public byte[] c(String str, tj2 tj2) throws IOException {
        byte[] bArr;
        System.currentTimeMillis();
        FileCache.b e2 = this.h.e(str);
        if (e2 != null) {
            bArr = l(e2.b);
            if (bArr != null && bArr.length > 0) {
                Log.d("TemplateCache", "[getTemplateById #" + str + "] get template from file.");
                this.i.put(str, bArr);
            }
        } else {
            bArr = null;
        }
        System.currentTimeMillis();
        tj2.a = 2;
        return bArr;
    }

    /* access modifiers changed from: protected */
    public byte[] d(String str, tj2 tj2) {
        System.currentTimeMillis();
        byte[] bArr = this.i.get(str);
        System.currentTimeMillis();
        tj2.a = 1;
        Log.d("TemplateCache", "[getTemplateById #" + str + "] get template from memory.");
        return bArr;
    }

    public File g() {
        return this.f;
    }

    public byte[] h(DinamicTemplate dinamicTemplate, String str, String str2, tj2 tj2) {
        byte[] d2 = d(str, tj2);
        if (d2 != null) {
            return d2;
        }
        try {
            d2 = c(str, tj2);
        } catch (IOException unused) {
        }
        if (d2 != null) {
            return d2;
        }
        return e(dinamicTemplate, str, str2, tj2);
    }

    /* access modifiers changed from: protected */
    public byte[] l(File file) throws IOException {
        return k(file);
    }

    private TemplateCache(c cVar) {
        this.j = k;
        this.a = cVar.b;
        Context context = cVar.a;
        this.e = context;
        String str = cVar.c;
        this.b = str;
        int i2 = cVar.d;
        this.d = i2;
        long j2 = cVar.e;
        this.c = j2;
        this.g = cVar.f;
        File b2 = b();
        this.f = b2;
        this.i = new LruCache<>(i2);
        this.h = new FileCache(context, b2, str, j2);
    }
}
