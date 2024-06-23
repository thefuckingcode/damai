package anetwork.channel.download;

import android.os.RemoteException;
import android.text.TextUtils;
import anet.channel.util.ALog;
import anetwork.channel.Header;
import anetwork.channel.aidl.Connection;
import java.io.File;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import mtopsdk.network.util.Constants;
import tb.ag2;
import tb.e02;
import tb.ry0;

/* compiled from: Taobao */
public class DownloadManager {
    public static final int ERROR_DOWNLOAD_CANCELLED = -105;
    public static final int ERROR_EXCEPTION_HAPPEN = -104;
    public static final int ERROR_FILE_FOLDER_INVALID = -101;
    public static final int ERROR_FILE_RENAME_FAILED = -106;
    public static final int ERROR_IO_EXCEPTION = -103;
    public static final int ERROR_REQUEST_FAIL = -102;
    public static final int ERROR_URL_INVALID = -100;
    public static final String TAG = "anet.DownloadManager";

    /* compiled from: Taobao */
    public interface DownloadListener {
        void onFail(int i, int i2, String str);

        void onProgress(int i, long j, long j2);

        void onSuccess(int i, String str);
    }

    /* compiled from: Taobao */
    class DownloadTask implements Runnable {
        private volatile Connection conn = null;
        private final String filePath;
        private final AtomicBoolean isCancelled = new AtomicBoolean(false);
        private final AtomicBoolean isFinish = new AtomicBoolean(false);
        private final CopyOnWriteArrayList<DownloadListener> listenerList;
        final int taskId;
        final /* synthetic */ DownloadManager this$0;
        final URL url;
        private boolean useExternalCache = true;

        DownloadTask(DownloadManager downloadManager, URL url2, String str, String str2, DownloadListener downloadListener) {
            throw null;
        }

        private void notifyFail(int i, String str) {
            if (this.isFinish.compareAndSet(false, true)) {
                Iterator<DownloadListener> it = this.listenerList.iterator();
                while (it.hasNext()) {
                    it.next().onFail(this.taskId, i, str);
                }
            }
        }

        private void notifyProgress(long j, long j2) {
            if (!this.isFinish.get()) {
                Iterator<DownloadListener> it = this.listenerList.iterator();
                while (it.hasNext()) {
                    it.next().onProgress(this.taskId, j, j2);
                }
            }
        }

        private void notifySuccess(String str) {
            if (this.isFinish.compareAndSet(false, true)) {
                Iterator<DownloadListener> it = this.listenerList.iterator();
                while (it.hasNext()) {
                    it.next().onSuccess(this.taskId, str);
                }
            }
        }

        private long parseContentLength(int i, Map<String, List<String>> map, long j) {
            int lastIndexOf;
            if (i == 200) {
                try {
                    return Long.parseLong(ry0.d(map, Constants.Protocol.CONTENT_LENGTH));
                } catch (Exception unused) {
                    return 0;
                }
            } else if (i != 206) {
                return 0;
            } else {
                String d = ry0.d(map, "Content-Range");
                long parseLong = (d == null || (lastIndexOf = d.lastIndexOf(47)) == -1) ? 0 : Long.parseLong(d.substring(lastIndexOf + 1));
                if (parseLong == 0) {
                    try {
                        return Long.parseLong(ry0.d(map, Constants.Protocol.CONTENT_LENGTH)) + j;
                    } catch (Exception unused2) {
                    }
                }
                return parseLong;
            }
        }

        private String parseFileNameForURL(URL url2) {
            String path = url2.getPath();
            int lastIndexOf = path.lastIndexOf(47);
            String substring = lastIndexOf != -1 ? path.substring(lastIndexOf + 1, path.length()) : null;
            if (!TextUtils.isEmpty(substring)) {
                return substring;
            }
            String h = ag2.h(url2.toString());
            return h == null ? url2.getFile() : h;
        }

        private void removeRangeHeader(List<Header> list) {
            if (list != null) {
                ListIterator<Header> listIterator = list.listIterator();
                while (listIterator.hasNext()) {
                    if ("Range".equalsIgnoreCase(listIterator.next().getName())) {
                        listIterator.remove();
                        return;
                    }
                }
            }
        }

        public boolean attachListener(DownloadListener downloadListener) {
            if (this.isFinish.get()) {
                return false;
            }
            this.listenerList.add(downloadListener);
            return true;
        }

        public void cancel() {
            this.isCancelled.set(true);
            notifyFail(-105, "download canceled.");
            if (this.conn != null) {
                try {
                    this.conn.cancel();
                } catch (RemoteException unused) {
                }
            }
        }

        public void run() {
            if (!this.isCancelled.get()) {
                try {
                    File a = DownloadManager.a(this.this$0, this.url.toString(), this.useExternalCache);
                    boolean exists = a.exists();
                    e02 e02 = new e02(this.url);
                    e02.setRetryTime(0);
                    e02.setFollowRedirects(true);
                    if (exists) {
                        e02.addHeader("Range", "bytes=" + a.length() + "-");
                    }
                    throw null;
                } catch (Exception e) {
                    ALog.d(DownloadManager.TAG, "file download failed!", null, e, new Object[0]);
                    notifyFail(-104, e.toString());
                    throw null;
                }
            }
        }
    }

    static /* synthetic */ File a(DownloadManager downloadManager, String str, boolean z) {
        throw null;
    }
}
