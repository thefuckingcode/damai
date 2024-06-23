package com.taobao.zcache.network;

import androidx.annotation.NonNull;
import com.taobao.zcache.Error;
import com.taobao.zcache.ZCache;
import com.youku.upsplayer.util.YKUpsConvert;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* compiled from: Taobao */
public class DownloadTask implements Runnable, Comparable<DownloadTask> {
    private static boolean supportNetworkSDK = true;
    private static final ExecutorService taskQueue = new ThreadPoolExecutor(1, 5, 3, TimeUnit.SECONDS, new SynchronousQueue(), new ThreadFactory() {
        /* class com.taobao.zcache.network.DownloadTask.AnonymousClass1 */

        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "ZCache.Download_" + runnable.hashCode());
        }
    }, new RejectedExecutionHandler() {
        /* class com.taobao.zcache.network.DownloadTask.AnonymousClass2 */

        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            DownloadTask.waitingTasks.put((DownloadTask) runnable);
        }
    });
    private static final PriorityBlockingQueue<DownloadTask> waitingTasks = new PriorityBlockingQueue<>();
    private final DownloadFinishedCallback callback;
    private File fileCache;
    private RandomAccessFile fileCacheAccess;
    private ByteArrayOutputStream memoryCache;
    private final DownloadRequest request;
    private int retryCount = 0;

    DownloadTask(DownloadRequest downloadRequest, DownloadFinishedCallback downloadFinishedCallback) {
        this.request = downloadRequest;
        this.callback = downloadFinishedCallback;
    }

    private void adjustContentRange(String str) {
        if (str != null && str.startsWith("bytes")) {
            String[] split = str.split("[ -/]]");
            if (split.length == 4) {
                try {
                    this.fileCacheAccess.seek(Long.parseLong(split[1]));
                } catch (IOException unused) {
                }
            }
        }
    }

    private void closeFileCache() {
        RandomAccessFile randomAccessFile = this.fileCacheAccess;
        if (randomAccessFile != null) {
            try {
                randomAccessFile.close();
            } catch (IOException unused) {
            }
            this.fileCacheAccess = null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0023, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        r4.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0028, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0029, code lost:
        r5.addSuppressed(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x002c, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x002f, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0034, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0035, code lost:
        r4.addSuppressed(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0038, code lost:
        throw r5;
     */
    private void copyFile(File file, File file2) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        FileOutputStream fileOutputStream = new FileOutputStream(file2);
        byte[] bArr = new byte[8192];
        while (true) {
            int read = fileInputStream.read(bArr);
            if (read != -1) {
                fileOutputStream.write(bArr, 0, read);
            } else {
                fileOutputStream.close();
                fileInputStream.close();
                return;
            }
        }
    }

    public static String getCacheFile(@NonNull String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(ZCache.getContext().getCacheDir().getAbsolutePath());
        String str2 = File.separator;
        sb.append(str2);
        sb.append("ZCache");
        File file = new File(sb.toString());
        if (!file.exists()) {
            file.mkdirs();
        }
        String md5 = md5(str.getBytes());
        if (md5 == null) {
            md5 = "TEMP_FILE_" + System.currentTimeMillis();
        }
        return file + str2 + md5;
    }

    public static String md5(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            byte[] digest = MessageDigest.getInstance(MessageDigestAlgorithms.MD5).digest(bArr);
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                int i = b & 255;
                if (i < 16) {
                    sb.append(YKUpsConvert.CHAR_ZERO);
                }
                sb.append(Integer.toHexString(i));
            }
            return sb.toString();
        } catch (Exception unused) {
            return null;
        }
    }

    private void prepareFileCache() throws IOException {
        File file = new File(getCacheFile(this.request.url));
        this.fileCache = file;
        if (file.isDirectory()) {
            this.fileCache.delete();
        }
        if (!this.fileCache.exists()) {
            this.fileCache.createNewFile();
        }
        RandomAccessFile randomAccessFile = new RandomAccessFile(this.fileCache, "rwd");
        this.fileCacheAccess = randomAccessFile;
        long length = randomAccessFile.length();
        if (length > 0) {
            this.fileCacheAccess.seek(length);
            DownloadRequest downloadRequest = this.request;
            if (downloadRequest.header == null) {
                downloadRequest.header = new HashMap<>();
            }
            HashMap<String, String> hashMap = this.request.header;
            hashMap.put("Range", "bytes=" + length + "-");
        }
    }

    private void requestFinished(int i, Map<String, String> map, Error error, String str) {
        closeFileCache();
        this.callback.onDownloadFinished(i, map, error, str);
        DownloadTask poll = waitingTasks.poll();
        if (poll != null) {
            poll.run();
        }
    }

    public static void sendRequest(DownloadRequest downloadRequest, DownloadFinishedCallback downloadFinishedCallback) {
        if (downloadFinishedCallback != null) {
            if (downloadRequest == null || downloadRequest.url == null) {
                downloadFinishedCallback.onDownloadFinished(0, null, new Error(-1, "request \"null\" invalid URL"), null);
            } else {
                taskQueue.execute(new DownloadTask(downloadRequest, downloadFinishedCallback));
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0134, code lost:
        if (r1 == null) goto L_0x0146;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0141, code lost:
        if (r1 == null) goto L_0x0146;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0143, code lost:
        r1.close();
     */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0150  */
    public void run() {
        String str;
        ByteArrayOutputStream byteArrayOutputStream;
        Map<String, String> map = null;
        if (this.request.tempFilePath != null) {
            try {
                prepareFileCache();
            } catch (IOException e) {
                requestFinished(0, null, new Error(-2, e.toString()), "");
                return;
            }
        } else {
            this.memoryCache = new ByteArrayOutputStream(8192);
        }
        NetworkAdaptor aNetwork = supportNetworkSDK ? new ANetwork(this.request) : new StandardNetwork(this.request);
        int statusCode = aNetwork.getStatusCode();
        Error error = aNetwork.error;
        if (error != null) {
            requestFinished(0, null, error, "");
            return;
        }
        if (statusCode == 206 && this.fileCacheAccess != null) {
            adjustContentRange(aNetwork.getHeaderField("Content-Range"));
        } else if (statusCode == 416) {
            closeFileCache();
            File file = this.fileCache;
            if (file != null) {
                file.delete();
            }
            int i = this.retryCount + 1;
            this.retryCount = i;
            if (i < 3) {
                run();
                return;
            }
        } else if (statusCode != 200) {
            requestFinished(statusCode, null, null, "");
            return;
        }
        InputStream inputStream = aNetwork.getInputStream();
        if (inputStream == null) {
            requestFinished(statusCode, null, new Error(-5, "Input stream null"), "");
            return;
        }
        byte[] bArr = new byte[8192];
        while (true) {
            try {
                int read = inputStream.read(bArr, 0, 8192);
                if (read == -1) {
                    break;
                }
                ByteArrayOutputStream byteArrayOutputStream2 = this.memoryCache;
                if (byteArrayOutputStream2 == null) {
                    this.fileCacheAccess.write(bArr, 0, read);
                } else {
                    byteArrayOutputStream2.write(bArr, 0, read);
                }
            } catch (Exception e2) {
                aNetwork.setExceptionError(-7, e2);
                inputStream.close();
                byteArrayOutputStream = this.memoryCache;
            } catch (OutOfMemoryError e3) {
                aNetwork.setExceptionError(-9, e3);
                try {
                    inputStream.close();
                    byteArrayOutputStream = this.memoryCache;
                } catch (Exception unused) {
                }
            } catch (Throwable th) {
                try {
                    inputStream.close();
                    ByteArrayOutputStream byteArrayOutputStream3 = this.memoryCache;
                    if (byteArrayOutputStream3 != null) {
                        byteArrayOutputStream3.close();
                    }
                } catch (Exception unused2) {
                }
                aNetwork.close();
                throw th;
            }
        }
        ByteArrayOutputStream byteArrayOutputStream4 = this.memoryCache;
        if (byteArrayOutputStream4 == null) {
            closeFileCache();
            File file2 = new File(this.request.tempFilePath);
            file2.delete();
            file2.getParentFile().mkdirs();
            if (!this.fileCache.renameTo(file2)) {
                try {
                    file2.createNewFile();
                    copyFile(this.fileCache, file2);
                } catch (IOException e4) {
                    aNetwork.error = new Error(-8, "Rename \"" + this.fileCache.getPath() + "\" to \"" + this.request.tempFilePath + "\" failed: " + e4.toString());
                }
                this.fileCache.delete();
            }
            str = null;
        } else {
            str = new String(byteArrayOutputStream4.toByteArray(), "utf-8");
        }
        try {
            inputStream.close();
            ByteArrayOutputStream byteArrayOutputStream5 = this.memoryCache;
            if (byteArrayOutputStream5 != null) {
                byteArrayOutputStream5.close();
            }
        } catch (Exception unused3) {
        }
        aNetwork.close();
        if (this.request.fetchResponseHeader) {
            map = aNetwork.getHeaderFields();
        }
        requestFinished(statusCode, map, aNetwork.error, str);
        aNetwork.close();
        str = null;
        if (this.request.fetchResponseHeader) {
        }
        requestFinished(statusCode, map, aNetwork.error, str);
    }

    public int compareTo(DownloadTask downloadTask) {
        int i = 0;
        int i2 = this.request.tempFilePath == null ? 0 : 1;
        if (downloadTask.request.tempFilePath != null) {
            i = 1;
        }
        return i2 - i;
    }
}
