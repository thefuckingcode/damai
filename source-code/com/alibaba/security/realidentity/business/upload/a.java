package com.alibaba.security.realidentity.business.upload;

import android.content.Context;
import android.os.AsyncTask;
import com.alibaba.security.biometrics.service.common.GetCacheDataManager;
import com.alibaba.security.common.d.e;
import com.alibaba.security.realidentity.a.g;
import com.alibaba.security.realidentity.business.start.UploadToken;
import com.alibaba.security.realidentity.upload.UploadFileConfigParams;
import com.alibaba.security.realidentity.upload.UploadFileModel;
import com.alibaba.security.realidentity.upload.b;
import java.io.File;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

/* compiled from: Taobao */
public abstract class a extends AsyncTask<UploadToken, Void, String> {
    private static final String l = e.class.getSimpleName();
    String a;
    protected String b;
    AtomicInteger c;
    AtomicIntegerArray d;
    int e;
    int f;
    AbstractC0106a g;
    protected String h;
    protected com.alibaba.security.realidentity.upload.a.a i;
    protected String j;
    protected String k;
    private ThreadPoolExecutor m;
    private byte[] n;

    /* renamed from: com.alibaba.security.realidentity.business.upload.a$a  reason: collision with other inner class name */
    /* compiled from: Taobao */
    public interface AbstractC0106a {
        void a();

        void b();
    }

    public a(Context context, String str, String str2, String str3, String str4, byte[] bArr) {
        this.n = bArr;
        a(context, str, str2, str3, str4);
    }

    private void a(Context context, String str, String str2, String str3, String str4) {
        this.a = str2;
        this.k = str;
        if (str4 != null && !str4.endsWith("/")) {
            str4 = str4 + "/";
        }
        this.h = str4;
        this.b = str3;
        b unused = b.a.a;
        com.alibaba.security.realidentity.upload.a.a a2 = b.a(context);
        this.i = a2;
        a2.b = str;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 5, 10, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactory() {
            /* class com.alibaba.security.realidentity.business.upload.a.AnonymousClass1 */

            public final Thread newThread(Runnable runnable) {
                return new Thread(runnable, "rpsdk-uploadService");
            }
        });
        this.m = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
    }

    private void b(int i2) {
        this.f = i2;
    }

    private String e() {
        return this.a;
    }

    private boolean f() {
        for (int i2 = 0; i2 < this.f; i2++) {
            if (this.d.get(i2) == 0) {
                return false;
            }
        }
        return true;
    }

    private void g() {
        this.d.addAndGet(this.e, 1);
    }

    private void h() {
        this.d.addAndGet(this.e, 0);
    }

    private static long i() {
        return GetCacheDataManager.getInstance().getUploadTimeOut();
    }

    /* access modifiers changed from: protected */
    public boolean c() {
        return false;
    }

    /* access modifiers changed from: protected */
    public abstract String d();

    /* access modifiers changed from: protected */
    public byte[] b() {
        return this.n;
    }

    public a(Context context, String str, String str2, String str3, String str4) {
        a(context, str, str2, str3, str4);
    }

    private void a(AbstractC0106a aVar) {
        this.g = aVar;
    }

    private void a(AtomicIntegerArray atomicIntegerArray) {
        this.d = atomicIntegerArray;
    }

    private void a(AtomicInteger atomicInteger) {
        this.c = atomicInteger;
    }

    private void a(int i2) {
        this.e = i2;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0082  */
    /* renamed from: a */
    public String doInBackground(UploadToken... uploadTokenArr) {
        byte[] bArr;
        FutureTask futureTask;
        StringBuilder sb = new StringBuilder();
        Context context = g.a.a.c;
        sb.append(context.getFilesDir().getAbsolutePath() + "/realidentity");
        sb.append("/images/");
        sb.append(this.k);
        String sb2 = sb.toString();
        String str = this.b;
        final String str2 = sb2 + File.separator + str;
        try {
            futureTask = new FutureTask(new Callable<byte[]>() {
                /* class com.alibaba.security.realidentity.business.upload.a.AnonymousClass2 */

                private byte[] a() {
                    return a.this.b();
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // java.util.concurrent.Callable
                public final /* synthetic */ byte[] call() throws Exception {
                    return a.this.b();
                }
            });
            try {
                this.m.execute(futureTask);
                bArr = (byte[]) futureTask.get(1, TimeUnit.SECONDS);
            } catch (Exception unused) {
            }
        } catch (Exception unused2) {
            futureTask = null;
            if (futureTask != null) {
                futureTask.cancel(true);
            }
            bArr = null;
            if (bArr != null) {
            }
        }
        if (bArr != null) {
            if (!c()) {
                this.j = null;
            } else {
                this.j = "";
            }
            return this.j;
        } else if (!e.a(sb2, bArr, str)) {
            this.j = "";
            return "";
        } else {
            UploadFileModel uploadFileModel = new UploadFileModel();
            uploadFileModel.setFileType("jpeg");
            uploadFileModel.setLocalFilePath(str2);
            uploadFileModel.setRemoteFileName(null);
            UploadToken uploadToken = uploadTokenArr[0];
            UploadFileConfigParams uploadFileConfigParams = new UploadFileConfigParams();
            uploadFileConfigParams.setContentType("image/jpeg");
            uploadFileConfigParams.setBucket(uploadToken.bucket);
            uploadFileConfigParams.setEndPoint(uploadToken.endPoint);
            uploadFileConfigParams.setExpired(uploadToken.expired);
            uploadFileConfigParams.setKey(uploadToken.key);
            uploadFileConfigParams.setPath(uploadToken.path);
            uploadFileConfigParams.setSecret(uploadToken.secret);
            uploadFileConfigParams.setToken(uploadToken.token);
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            Object a2 = this.i.a(uploadFileModel, new com.alibaba.security.realidentity.upload.b.b() {
                /* class com.alibaba.security.realidentity.business.upload.a.AnonymousClass3 */

                @Override // com.alibaba.security.realidentity.upload.b.b
                public final void a(long j, long j2) {
                }

                @Override // com.alibaba.security.realidentity.upload.b.b
                public final void a(String str) {
                    a.this.j = str;
                    e.b(str2);
                    countDownLatch.countDown();
                }

                @Override // com.alibaba.security.realidentity.upload.b.b
                public final void b(String str) {
                    e.b(str2);
                    countDownLatch.countDown();
                }

                @Override // com.alibaba.security.realidentity.upload.b.b
                public final void a() {
                    e.b(str2);
                    countDownLatch.countDown();
                }
            });
            try {
                countDownLatch.await(GetCacheDataManager.getInstance().getUploadTimeOut(), TimeUnit.SECONDS);
            } catch (InterruptedException unused3) {
                this.i.a(a2);
            }
            return this.j;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void onPostExecute(String str) {
        super.onPostExecute(str);
        boolean z = false;
        if (this.j == null) {
            this.d.addAndGet(this.e, 0);
        } else {
            this.d.addAndGet(this.e, 1);
        }
        if (this.c.decrementAndGet() == 0 && this.g != null) {
            int i2 = 0;
            while (true) {
                if (i2 >= this.f) {
                    z = true;
                    break;
                } else if (this.d.get(i2) == 0) {
                    break;
                } else {
                    i2++;
                }
            }
            if (z) {
                this.g.a();
            } else {
                this.g.b();
            }
        }
    }

    public final String a() {
        return this.j;
    }
}
