package tb;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import com.taobao.android.ultron.datamodel.cache.db.FileCache;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: Taobao */
public class qj2 {
    protected final String a;
    protected final String b;
    protected final long c;
    protected final Context d;
    protected final File e;
    protected FileCache f;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class a extends AsyncTask<Void, Void, Void> {
        final /* synthetic */ String a;
        final /* synthetic */ byte[] b;

        a(String str, byte[] bArr) {
            this.a = str;
            this.b = bArr;
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Code restructure failed: missing block: B:10:0x002b, code lost:
            if (r1.length() <= 0) goto L_0x003f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
            r7.c.f.h(r7.a, r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0037, code lost:
            r8 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0038, code lost:
            android.util.Log.e("TemplateCache", "File cache store exception", r8);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x0021, code lost:
            if (r1.isFile() == false) goto L_0x003f;
         */
        /* renamed from: a */
        public Void doInBackground(Void... voidArr) {
            String str = this.a;
            synchronized (qj2.class) {
                File file = new File(qj2.this.e, str);
                if (file.exists()) {
                    return null;
                }
                qj2.this.j(this.b, file);
            }
            return null;
        }
    }

    /* compiled from: Taobao */
    public static final class b {
        private Context a;
        private String b;
        private String c;
        private int d = 8;
        private long e = 4194304;
        private boolean f = true;

        public qj2 g() {
            if (this.a != null && !TextUtils.isEmpty(this.b) && !TextUtils.isEmpty(this.c)) {
                return new qj2(this, null);
            }
            throw new IllegalArgumentException();
        }

        public b h(Context context) {
            this.a = context;
            return this;
        }

        public b i(String str) {
            this.c = str;
            return this;
        }

        public b j(long j) {
            this.e = j;
            return this;
        }

        public b k(int i) {
            this.d = i;
            return this;
        }

        public b l(String str) {
            this.b = str;
            return this;
        }
    }

    /* synthetic */ qj2(b bVar, a aVar) {
        this(bVar);
    }

    private File b() {
        File e2 = e();
        if (e2 == null) {
            return null;
        }
        File file = new File(e2, this.a);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    private File e() {
        File filesDir = this.d.getFilesDir();
        if (filesDir != null && filesDir.canWrite()) {
            return filesDir;
        }
        File cacheDir = this.d.getCacheDir();
        if (cacheDir != null && cacheDir.canWrite()) {
            return cacheDir;
        }
        if ("mounted".equals(Environment.getExternalStorageState())) {
            try {
                File externalFilesDir = this.d.getExternalFilesDir(null);
                if (externalFilesDir != null && externalFilesDir.canWrite()) {
                    return externalFilesDir;
                }
                File externalCacheDir = this.d.getExternalCacheDir();
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

    private byte[] g(File file) throws IOException {
        int read;
        long length = file.length();
        if (length <= 2147483639) {
            FileInputStream fileInputStream = new FileInputStream(file);
            int i = (int) length;
            byte[] bArr = new byte[i];
            int i2 = 0;
            while (true) {
                int read2 = fileInputStream.read(bArr, i2, i - i2);
                if (read2 > 0) {
                    i2 += read2;
                } else if (read2 < 0 || (read = fileInputStream.read()) < 0) {
                    fileInputStream.close();
                } else {
                    if (i <= 2147483639 - i) {
                        i = Math.max(i << 1, 8192);
                    } else if (i != 2147483639) {
                        i = 2147483639;
                    } else {
                        throw new OutOfMemoryError("Required array size too large");
                    }
                    bArr = Arrays.copyOf(bArr, i);
                    bArr[i2] = (byte) read;
                    i2++;
                }
            }
            fileInputStream.close();
            return i == i2 ? bArr : Arrays.copyOf(bArr, i2);
        }
        throw new OutOfMemoryError("Required array size too large");
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0026, code lost:
        if (r1 == null) goto L_0x0029;
     */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0019 A[SYNTHETIC, Splitter:B:12:0x0019] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0022 A[SYNTHETIC, Splitter:B:18:0x0022] */
    private File j(byte[] bArr, File file) {
        Throwable th;
        BufferedOutputStream bufferedOutputStream;
        BufferedOutputStream bufferedOutputStream2 = null;
        try {
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
            try {
                bufferedOutputStream.write(bArr);
            } catch (Exception unused) {
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
            }
        } catch (Exception unused2) {
            bufferedOutputStream = null;
            if (file != null) {
            }
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

    public synchronized void c(String str) {
        this.f.b(str);
    }

    public byte[] d(String str) {
        FileCache.b f2 = this.f.f(str);
        if (f2 == null) {
            return null;
        }
        byte[] h = h(f2.c);
        if (h == null || h.length <= 0) {
            return h;
        }
        Log.d("TemplateCache", "[getTemplateById #" + str + "] get template from file.");
        return h;
    }

    public List<String> f() {
        ArrayList arrayList = new ArrayList();
        List<FileCache.b> c2 = this.f.c();
        if (!(c2 == null || c2.size() == 0)) {
            for (FileCache.b bVar : c2) {
                arrayList.add(bVar.b);
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public byte[] h(File file) {
        try {
            return g(file);
        } catch (IOException e2) {
            Log.e("TemplateCache", "Read all bytes exception:", e2);
            return null;
        }
    }

    public void i(String str, byte[] bArr) {
        if (bArr == null) {
            Log.d("TemplateCache", "[getTemplateById #" + str + "] template from server is null.");
            return;
        }
        new a(str, bArr).executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, new Void[0]);
    }

    private qj2(b bVar) {
        this.a = bVar.b;
        Context context = bVar.a;
        this.d = context;
        String str = bVar.c;
        this.b = str;
        int unused = bVar.d;
        long j = bVar.e;
        this.c = j;
        boolean unused2 = bVar.f;
        File b2 = b();
        this.e = b2;
        this.f = new FileCache(context, b2, str, j);
    }
}
