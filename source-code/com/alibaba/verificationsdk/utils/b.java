package com.alibaba.verificationsdk.utils;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;
import tb.v81;

/* compiled from: Taobao */
public class b extends AsyncTask<Void, Integer, Long> {
    private final File a;
    private final File b;
    private final ProgressDialog c;
    private int d = 0;
    private final Context e;
    private boolean f;
    private ZIPExtracListener g;
    private int h = 8192;

    /* compiled from: Taobao */
    class a implements DialogInterface.OnCancelListener {
        a() {
        }

        public void onCancel(DialogInterface dialogInterface) {
            b.this.cancel(true);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: com.alibaba.verificationsdk.utils.b$b  reason: collision with other inner class name */
    /* compiled from: Taobao */
    public final class C0113b extends FileOutputStream {
        public C0113b(File file) throws FileNotFoundException {
            super(file);
        }

        @Override // java.io.OutputStream, java.io.FileOutputStream
        public void write(byte[] bArr, int i, int i2) throws IOException {
            super.write(bArr, i, i2);
            b.b(b.this, i2);
            b bVar = b.this;
            bVar.publishProgress(new Integer[]{Integer.valueOf(bVar.d)});
        }
    }

    public b(String str, String str2, Context context, boolean z, ZIPExtracListener zIPExtracListener) {
        this.a = new File(str);
        File file = new File(str2);
        this.b = file;
        this.g = zIPExtracListener;
        if (!file.exists() && !file.mkdirs()) {
            v81.a("ZipExtractorTask", "Failed to make directories:" + file.getAbsolutePath());
        }
        this.e = context;
        if (context != null) {
            this.c = new ProgressDialog(context);
        } else {
            this.c = null;
        }
        this.f = z;
    }

    static /* synthetic */ int b(b bVar, int i) {
        int i2 = bVar.d + i;
        bVar.d = i2;
        return i2;
    }

    private int d(InputStream inputStream, OutputStream outputStream) {
        byte[] bArr = new byte[this.h];
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, this.h);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream, this.h);
        int i = 0;
        while (true) {
            try {
                int read = bufferedInputStream.read(bArr, 0, this.h);
                if (read == -1) {
                    break;
                }
                bufferedOutputStream.write(bArr, 0, read);
                i += read;
            } catch (IOException e2) {
                e2.printStackTrace();
                try {
                    bufferedOutputStream.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
                bufferedInputStream.close();
            } catch (Throwable th) {
                try {
                    bufferedOutputStream.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
                try {
                    bufferedInputStream.close();
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
                throw th;
            }
        }
        bufferedOutputStream.flush();
        try {
            bufferedOutputStream.close();
        } catch (IOException e6) {
            e6.printStackTrace();
        }
        try {
            bufferedInputStream.close();
        } catch (IOException e7) {
            e7.printStackTrace();
        }
        return i;
    }

    private long f(ZipFile zipFile) {
        Enumeration<? extends ZipEntry> entries = zipFile.entries();
        long j = 0;
        while (entries.hasMoreElements()) {
            ZipEntry zipEntry = (ZipEntry) entries.nextElement();
            if (zipEntry.getSize() >= 0) {
                j += zipEntry.getSize();
            }
        }
        return j;
    }

    private long i() {
        Throwable th;
        ZipFile zipFile;
        ZipException e2;
        IOException e3;
        long j = 0;
        ZipFile zipFile2 = null;
        try {
            zipFile = new ZipFile(this.a);
            try {
                publishProgress(0, Integer.valueOf((int) f(zipFile)));
                Enumeration<? extends ZipEntry> entries = zipFile.entries();
                while (entries.hasMoreElements()) {
                    ZipEntry zipEntry = (ZipEntry) entries.nextElement();
                    if (!zipEntry.isDirectory()) {
                        File file = new File(this.b, zipEntry.getName());
                        if (!file.getParentFile().exists()) {
                            v81.a("ZipExtractorTask", "make=" + file.getParentFile().getAbsolutePath());
                            file.getParentFile().mkdirs();
                        }
                        if (file.exists()) {
                            Context context = this.e;
                        }
                        C0113b bVar = new C0113b(file);
                        j += (long) d(zipFile.getInputStream(zipEntry), bVar);
                        bVar.close();
                    }
                }
                try {
                    zipFile.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            } catch (ZipException e5) {
                e2 = e5;
                e2.printStackTrace();
                zipFile.close();
                return j;
            } catch (IOException e6) {
                e3 = e6;
                try {
                    e3.printStackTrace();
                    zipFile.close();
                    return j;
                } catch (Throwable th2) {
                    th = th2;
                    zipFile2 = zipFile;
                    try {
                        zipFile2.close();
                    } catch (IOException e7) {
                        e7.printStackTrace();
                    }
                    throw th;
                }
            }
        } catch (ZipException e8) {
            zipFile = null;
            e2 = e8;
            e2.printStackTrace();
            zipFile.close();
            return j;
        } catch (IOException e9) {
            zipFile = null;
            e3 = e9;
            e3.printStackTrace();
            zipFile.close();
            return j;
        } catch (Throwable th3) {
            th = th3;
            zipFile2.close();
            throw th;
        }
        return j;
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public Long doInBackground(Void... voidArr) {
        return Long.valueOf(i());
    }

    /* access modifiers changed from: protected */
    /* renamed from: g */
    public void onPostExecute(Long l) {
        ProgressDialog progressDialog = this.c;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.c.dismiss();
        }
        ZIPExtracListener zIPExtracListener = this.g;
        if (zIPExtracListener != null) {
            zIPExtracListener.unzipFinished(this.a, this.b);
        }
        isCancelled();
    }

    /* access modifiers changed from: protected */
    /* renamed from: h */
    public void onProgressUpdate(Integer... numArr) {
        ProgressDialog progressDialog = this.c;
        if (progressDialog != null) {
            if (numArr.length > 1) {
                this.c.setMax(numArr[1].intValue());
                return;
            }
            progressDialog.setProgress(numArr[0].intValue());
        }
    }

    /* access modifiers changed from: protected */
    public void onPreExecute() {
        ProgressDialog progressDialog = this.c;
        if (progressDialog != null) {
            progressDialog.setTitle("Extracting");
            this.c.setMessage(this.a.getName());
            this.c.setProgressStyle(1);
            this.c.setOnCancelListener(new a());
            this.c.show();
        }
        ZIPExtracListener zIPExtracListener = this.g;
        if (zIPExtracListener != null) {
            zIPExtracListener.unzipStart();
        }
    }
}
