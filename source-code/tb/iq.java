package tb;

import android.app.DownloadManager;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.text.TextUtils;
import com.taobao.downloader.download.IDownloader;
import com.taobao.downloader.download.IListener;
import java.io.File;
import org.apache.commons.lang3.StringUtils;

/* compiled from: Taobao */
public class iq implements IDownloader {
    public static final Uri CONTENT_URI = Uri.parse("content://downloads/my_downloads");
    private static DownloadManager e = ((DownloadManager) cm.a.getSystemService("download"));
    private long a;
    private ContentObserver b;
    private IListener c;
    private lb2 d;

    /* compiled from: Taobao */
    class a extends ContentObserver {
        a(Handler handler) {
            super(handler);
        }

        public void onChange(boolean z) {
            iq.this.e();
        }
    }

    private void b() {
        if (this.b != null) {
            cm.a.getContentResolver().unregisterContentObserver(this.b);
        }
    }

    private boolean c() {
        return cm.a.checkCallingOrSelfPermission("android.permission.DOWNLOAD_WITHOUT_NOTIFICATION") == 0;
    }

    private boolean d(long j) {
        return Environment.getExternalStorageDirectory().getFreeSpace() >= j;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void e() {
        if (this.a > 0) {
            DownloadManager.Query query = new DownloadManager.Query();
            query.setFilterById(this.a);
            Cursor query2 = e.query(query);
            if (query2 != null && query2.moveToFirst()) {
                int i = query2.getInt(query2.getColumnIndex("status"));
                int columnIndex = query2.getColumnIndex("reason");
                int columnIndex2 = query2.getColumnIndex("title");
                int columnIndex3 = query2.getColumnIndex("total_size");
                int columnIndex4 = query2.getColumnIndex("bytes_so_far");
                String string = query2.getString(columnIndex2);
                int i2 = query2.getInt(columnIndex3);
                int i3 = query2.getInt(columnIndex4);
                query2.getInt(columnIndex);
                this.c.onProgress((long) i3);
                m90.c("DMDownloader", "queryDownloadStatus", "tag", string + StringUtils.LF + "Downloaded " + i3 + " / " + i2);
                if (i != 1) {
                    if (i != 2) {
                        if (i == 4) {
                            m90.c("DMDownloader", "queryDownloadStatus", "STATUS_PAUSED");
                        } else if (i == 8) {
                            String string2 = query2.getString(query2.getColumnIndex("local_filename"));
                            if (!TextUtils.isEmpty(string2)) {
                                this.d.d = string2;
                            }
                            lb2 lb2 = this.d;
                            lb2.a = true;
                            this.c.onResult(lb2);
                            b();
                            return;
                        } else if (i == 16) {
                            m90.c("DMDownloader", "queryDownloadStatus", "STATUS_FAILED");
                            return;
                        } else {
                            return;
                        }
                    }
                    m90.c("DMDownloader", "queryDownloadStatus", "STATUS_RUNNING");
                }
                m90.c("DMDownloader", "queryDownloadStatus", "STATUS_PENDING");
                m90.c("DMDownloader", "queryDownloadStatus", "STATUS_RUNNING");
            }
        }
    }

    @Override // com.taobao.downloader.download.IDownloader
    public void cancel() {
        e.remove(this.a);
        b();
    }

    @Override // com.taobao.downloader.download.IDownloader
    public void download(lb2 lb2, IListener iListener) {
        this.c = iListener;
        this.d = lb2;
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(lb2.e.a));
        int i = lb2.f.c;
        int i2 = (i & 2) == 2 ? 1 : 0;
        if ((i & 1) == 1 || (i & 4) == 4) {
            i2 |= 2;
        }
        request.setAllowedNetworkTypes(i2);
        if ((lb2.f.c & 4) != 4 && Build.VERSION.SDK_INT > 16) {
            request.setAllowedOverMetered(false);
        }
        if (!TextUtils.isEmpty(lb2.f.h)) {
            request.setTitle(lb2.f.h);
            request.setDescription(lb2.f.i);
        }
        String a2 = lb2.a();
        request.setDestinationUri(Uri.fromFile(new File(lb2.g + "/" + a2)));
        lb2 lb22 = this.d;
        lb22.d = lb2.g + "/" + a2;
        if (!lb2.f.j) {
            request.setVisibleInDownloadsUi(false);
            if (c()) {
                request.setNotificationVisibility(2);
            }
        } else {
            request.setNotificationVisibility(this.d.f.k);
        }
        if (!d(lb2.e.b)) {
            lb2.a = false;
            lb2.b = -21;
            lb2.c = "手机剩余空间不足";
            io1 io1 = lb2.f;
            io1.l = 0;
            io1.d = 0;
            this.c.onResult(lb2);
            return;
        }
        this.a = e.enqueue(request);
        this.b = new a(null);
        cm.a.getContentResolver().registerContentObserver(CONTENT_URI, true, this.b);
    }

    @Override // com.taobao.downloader.download.IDownloader
    public void pause() {
        b();
    }
}
