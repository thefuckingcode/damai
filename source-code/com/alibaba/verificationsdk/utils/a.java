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
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import tb.v81;

/* compiled from: Taobao */
public class a extends AsyncTask<Void, Integer, Long> {
    private URL a;
    private File b;
    private ProgressDialog c;
    private int d = 0;
    private b e;
    private Context f;
    private DownloadListener g;
    private int h = 8192;

    /* renamed from: com.alibaba.verificationsdk.utils.a$a  reason: collision with other inner class name */
    /* compiled from: Taobao */
    class DialogInterface$OnCancelListenerC0112a implements DialogInterface.OnCancelListener {
        DialogInterface$OnCancelListenerC0112a() {
        }

        public void onCancel(DialogInterface dialogInterface) {
            a.this.cancel(true);
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public final class b extends FileOutputStream {
        public b(File file) throws FileNotFoundException {
            super(file);
        }

        @Override // java.io.OutputStream, java.io.FileOutputStream
        public void write(byte[] bArr, int i, int i2) throws IOException {
            super.write(bArr, i, i2);
            a.b(a.this, i2);
            a aVar = a.this;
            aVar.publishProgress(new Integer[]{Integer.valueOf(aVar.d)});
        }
    }

    public a(String str, String str2, Context context, DownloadListener downloadListener) {
        this.f = context;
        this.g = downloadListener;
        if (context != null) {
            this.c = new ProgressDialog(this.f);
        } else {
            this.c = null;
        }
        try {
            this.a = new URL(str);
            String name = new File(this.a.getFile()).getName();
            this.b = new File(str2, name);
            v81.b("DownLoaderTask", "out=" + str2 + ", name=" + name + ",mUrl.getFile()=" + this.a.getFile());
        } catch (MalformedURLException e2) {
            e2.printStackTrace();
        }
    }

    static /* synthetic */ int b(a aVar, int i) {
        int i2 = aVar.d + i;
        aVar.d = i2;
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

    private long f() {
        int i = 0;
        try {
            URLConnection openConnection = this.a.openConnection();
            int contentLength = openConnection.getContentLength();
            if (!this.b.exists() || ((long) contentLength) != this.b.length()) {
                this.e = new b(this.b);
                publishProgress(0, Integer.valueOf(contentLength));
                i = d(openConnection.getInputStream(), this.e);
                if (!(i == contentLength || contentLength == -1)) {
                    v81.a("DownLoaderTask", "Download incomplete bytesCopied=" + i + ", length" + contentLength);
                }
                this.e.close();
                return (long) i;
            }
            v81.b("DownLoaderTask", "file " + this.b.getName() + " already exits!!");
            return 0;
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public Long doInBackground(Void... voidArr) {
        return Long.valueOf(f());
    }

    /* access modifiers changed from: protected */
    /* renamed from: g */
    public void onPostExecute(Long l) {
        ProgressDialog progressDialog = this.c;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.c.dismiss();
        }
        DownloadListener downloadListener = this.g;
        if (downloadListener != null) {
            downloadListener.downloadFinished(this.b);
        }
        isCancelled();
    }

    /* access modifiers changed from: protected */
    /* renamed from: h */
    public void onProgressUpdate(Integer... numArr) {
        ProgressDialog progressDialog = this.c;
        if (progressDialog != null) {
            if (numArr.length > 1) {
                int intValue = numArr[1].intValue();
                if (intValue == -1) {
                    this.c.setIndeterminate(true);
                } else {
                    this.c.setMax(intValue);
                }
            } else {
                progressDialog.setProgress(numArr[0].intValue());
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onPreExecute() {
        ProgressDialog progressDialog = this.c;
        if (progressDialog != null) {
            progressDialog.setTitle("Downloading...");
            this.c.setMessage(this.b.getName());
            this.c.setProgressStyle(1);
            this.c.setOnCancelListener(new DialogInterface$OnCancelListenerC0112a());
            this.c.show();
        }
        DownloadListener downloadListener = this.g;
        if (downloadListener != null) {
            downloadListener.downloadStart();
        }
    }
}
