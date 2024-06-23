package com.uc.webview.export.cyclone.update;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.taobao.weex.annotation.JSMethod;
import com.uc.webview.export.cyclone.update.IUrlDownloader;
import com.uc.webview.export.cyclone.update.UrlRequest;
import com.uc.webview.export.cyclone.update.Utils;
import com.youku.gaiax.js.core.GaiaXContext;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: Taobao */
class UrlDownloader implements IUrlDownloader, UrlRequest.BodyHandler, Runnable {
    private static final String TAG = "UrlDownloader";
    private static final String THREAD_NAME_PREFIX = "UCDown-";
    private static final AtomicInteger sThreadCount = new AtomicInteger(0);
    private Boolean mCheckLastModifed;
    private Client mClient;
    private Integer mConnectTimeOut;
    private Context mContext;
    private long mCurrentSize;
    private File mDownloadDir;
    private File mDownloadFile;
    private Throwable mException;
    private long mLastModified;
    private int mLastPercent = 0;
    private Utils.LogHelper mLog;
    private Integer mReadTimeOut;
    private volatile Thread mRunningThread;
    private long mTotalSize;
    private String mUrl;

    /* compiled from: Taobao */
    public interface Client extends IUrlDownloader.Client {
        void onCheck();

        void onException(Throwable th);

        void onFileDeleted();

        void onFileExists(File file);

        boolean onHeaderReceived(Throwable th);

        void onRecovered();
    }

    public UrlDownloader(Context context, String str, Utils.LogHelper logHelper) {
        this.mContext = context;
        this.mUrl = str;
        this.mDownloadDir = Utils.getDownloadDir(context, str);
        this.mLog = logHelper;
    }

    private void continueDownload(long j) {
        try {
            if (!isRunningInCurrentThread()) {
                printLog("continueDownload stopped, thread reset");
                return;
            }
            if (!this.mDownloadDir.exists()) {
                this.mDownloadDir.mkdirs();
            }
            String name = this.mDownloadFile.getName();
            File[] listFiles = this.mDownloadDir.listFiles();
            for (File file : listFiles) {
                if (!file.getName().equals(name)) {
                    Utils.deleteAll(file, this.mLog);
                }
            }
            if (!this.mDownloadFile.exists()) {
                this.mDownloadFile.createNewFile();
            }
            if (j < this.mTotalSize) {
                printLog("continueDownload recoverSize:" + j + ", totalSize:" + this.mTotalSize);
                this.mClient.onStart();
                UrlRequest createRequest = createRequest(this);
                if (j > 0) {
                    createRequest.setHeader("Range", "bytes=" + j + "-" + this.mTotalSize);
                    this.mClient.onRecovered();
                }
                createRequest.start();
            }
            printLog("continueDownload file:" + this.mDownloadFile.getAbsolutePath() + ", size:" + this.mDownloadFile.length() + ", lastModified:" + this.mDownloadFile.lastModified() + ", totalSize:" + this.mTotalSize);
            if (this.mDownloadFile.length() != this.mTotalSize) {
                RuntimeException runtimeException = new RuntimeException("Size mismatch: " + this.mDownloadFile.length() + "/" + this.mTotalSize);
                this.mException = runtimeException;
                this.mClient.onFailed(null, runtimeException);
                return;
            }
            this.mClient.onSuccess(this.mDownloadFile.getAbsolutePath(), getTotalSize(), getLastModified());
        } catch (Throwable th) {
            printLog("continueDownload failed", th);
        }
    }

    private UrlRequest createRequest(UrlRequest.BodyHandler bodyHandler) {
        UrlRequest urlRequest = new UrlRequest(this.mUrl, bodyHandler, this.mLog);
        Boolean bool = this.mCheckLastModifed;
        if (bool != null) {
            urlRequest.setCheckLastModified(bool.booleanValue());
        }
        Integer num = this.mConnectTimeOut;
        if (num != null) {
            urlRequest.setConnectTimeOut(num.intValue());
        }
        Integer num2 = this.mReadTimeOut;
        if (num2 != null) {
            urlRequest.setReadTimeOut(num2.intValue());
        }
        return urlRequest;
    }

    private boolean isRunningInCurrentThread() {
        return Thread.currentThread() == this.mRunningThread;
    }

    private void onProgressChanged() {
        int currentPercent = getCurrentPercent();
        try {
            int i = this.mLastPercent;
            if (currentPercent > i || currentPercent == 100) {
                this.mLastPercent = i + 10;
                this.mDownloadFile.getTotalSpace();
                this.mDownloadFile.getFreeSpace();
            }
        } catch (Throwable unused) {
        }
        this.mClient.onProgressChanged(currentPercent);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void postTask(String str, Runnable runnable) {
        this.mRunningThread = new Thread(runnable, String.format("%s%s%d", THREAD_NAME_PREFIX, str, Integer.valueOf(sThreadCount.getAndIncrement())));
        printLog("postTask threadName:" + this.mRunningThread.getName());
        this.mRunningThread.start();
    }

    private void printLog(String str) {
        printLog(str, null);
    }

    @Override // com.uc.webview.export.cyclone.update.IUrlDownloader
    public void delete() {
        printLog("delete");
        postTask("del", new Runnable() {
            /* class com.uc.webview.export.cyclone.update.UrlDownloader.AnonymousClass1 */

            public void run() {
                try {
                    synchronized (UrlDownloader.this) {
                        Utils.deleteAll(UrlDownloader.this.mDownloadDir, UrlDownloader.this.mLog);
                        UrlDownloader.this.mClient.onFileDeleted();
                    }
                } catch (Throwable th) {
                    UrlDownloader.this.printLog("delete failed", th);
                }
            }
        });
    }

    public int getCurrentPercent() {
        long j = this.mTotalSize;
        long j2 = 0 == j ? 0 : ((this.mCurrentSize * 10) / j) * 10;
        if (j2 > 100 || j2 < 0) {
            return -1;
        }
        return (int) j2;
    }

    public Throwable getException() {
        return this.mException;
    }

    public File getFilePath() {
        return this.mDownloadFile;
    }

    public long getLastModified() {
        return this.mLastModified;
    }

    public long getTotalSize() {
        return this.mTotalSize;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(8:4|5|(8:6|(1:8)|(2:10|11)|13|14|15|16|35)|13|14|15|16|35) */
    /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x003e */
    @Override // com.uc.webview.export.cyclone.update.UrlRequest.BodyHandler
    public void onBodyReceived(InputStream inputStream) {
        printLog("onBodyReceived stream:" + inputStream);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(this.mDownloadFile, true);
            try {
                byte[] bArr = new byte[51200];
                do {
                    int read = inputStream.read(bArr);
                    if (read > 0) {
                        fileOutputStream.write(bArr, 0, read);
                        this.mCurrentSize += (long) read;
                        onProgressChanged();
                    }
                    if (read > 0) {
                    }
                    fileOutputStream.close();
                    inputStream.close();
                    return;
                } while (this.mCurrentSize < this.mTotalSize);
                fileOutputStream.close();
                inputStream.close();
                return;
            } catch (Throwable unused) {
            }
            throw th;
        } catch (Throwable unused2) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x00e5 A[DONT_GENERATE] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00ea A[DONT_GENERATE] */
    public synchronized void run() {
        FileLocker fileLocker;
        Throwable th;
        if (!Utils.isOnMainThread()) {
            this.mException = null;
            try {
                fileLocker = new FileLocker(this.mContext.getCacheDir(), Utils.getUrlHash(this.mUrl), this.mLog);
                try {
                    fileLocker.lock();
                    this.mClient.onCheck();
                    UrlRequest createRequest = createRequest(null);
                    if (!createRequest.start() || !createRequest.isResponseOk() || createRequest.getContentLength() <= 0) {
                        RuntimeException runtimeException = new RuntimeException("Get url file info failed");
                        this.mException = runtimeException;
                        this.mClient.onHeaderReceived(runtimeException);
                        throw this.mException;
                    }
                    this.mTotalSize = createRequest.getContentLength();
                    this.mLastModified = createRequest.getLastModified();
                    this.mDownloadFile = new File(this.mDownloadDir, this.mTotalSize + JSMethod.NOT_SET + this.mLastModified);
                    printLog("startDownload url:" + this.mUrl + ", downloadFile:" + this.mDownloadFile.getAbsolutePath());
                    long length = this.mDownloadFile.length();
                    this.mCurrentSize = length;
                    boolean z = length != this.mTotalSize;
                    if (this.mClient.onHeaderReceived(null)) {
                        if (z) {
                            continueDownload(length);
                        } else {
                            this.mClient.onFileExists(this.mDownloadFile);
                        }
                    }
                    printLog("startDownload finish");
                    fileLocker.unlock();
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        this.mException = th;
                        this.mClient.onException(th);
                    } finally {
                        printLog("startDownload finish");
                        if (fileLocker != null) {
                            fileLocker.unlock();
                        }
                    }
                }
            } catch (Throwable th3) {
                fileLocker = null;
                th = th3;
                this.mException = th;
                this.mClient.onException(th);
            }
        } else {
            throw new RuntimeException("Download should not run in UI thread.");
        }
    }

    public UrlDownloader setCheckLastModified(Boolean bool) {
        this.mCheckLastModifed = bool;
        return this;
    }

    public UrlDownloader setClient(Client client) {
        this.mClient = client;
        return this;
    }

    public UrlDownloader setConnectTimeOut(Integer num) {
        this.mConnectTimeOut = num;
        return this;
    }

    public UrlDownloader setReadTimeOut(Integer num) {
        this.mReadTimeOut = num;
        return this;
    }

    @Override // com.uc.webview.export.cyclone.update.IUrlDownloader
    public boolean start(String str, String str2, IUrlDownloader.Client client) {
        printLog("start not implements for IUrlDownloader.start");
        return false;
    }

    @Override // com.uc.webview.export.cyclone.update.IUrlDownloader
    public void stop() {
        printLog("stop");
        this.mRunningThread = null;
    }

    public void stopWith(final Runnable runnable) {
        printLog("stopWith");
        postTask("stpW", new Runnable() {
            /* class com.uc.webview.export.cyclone.update.UrlDownloader.AnonymousClass3 */

            public void run() {
                try {
                    synchronized (UrlDownloader.this) {
                        runnable.run();
                    }
                } catch (Throwable th) {
                    UrlDownloader.this.printLog("stopWith failed", th);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void printLog(String str, Throwable th) {
        Utils.LogHelper logHelper = this.mLog;
        if (logHelper != null) {
            logHelper.print(TAG, str, th);
        }
    }

    public void start(long j) {
        if (j == 0) {
            postTask("str", this);
        } else {
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                /* class com.uc.webview.export.cyclone.update.UrlDownloader.AnonymousClass2 */

                public void run() {
                    UrlDownloader urlDownloader = UrlDownloader.this;
                    urlDownloader.postTask(GaiaXContext.MODULE_STD, urlDownloader);
                }
            }, j);
        }
    }
}
