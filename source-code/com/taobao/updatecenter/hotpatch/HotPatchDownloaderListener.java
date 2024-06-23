package com.taobao.updatecenter.hotpatch;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.taobao.downloader.request.DownloadListener;
import tb.by0;
import tb.io1;
import tb.is2;
import tb.js2;
import tb.uo1;
import tb.zx0;

/* compiled from: Taobao */
public class HotPatchDownloaderListener implements DownloadListener {
    private uo1 a;
    private Context b;
    private String c;
    private boolean d;

    public HotPatchDownloaderListener(uo1 uo1, Context context, String str, boolean z) {
        this.a = uo1;
        this.b = context;
        this.c = str;
        this.d = z;
    }

    @Override // com.taobao.downloader.request.DownloadListener
    public void onDownloadError(String str, int i, String str2) {
        is2.a(zx0.ANDFIX_DOWNLOAD, this.a.f + "", i + "", str2);
        by0.d(false, "download", i + "", str2, HotPatchManager.getInstance().getMainVersion(), this.a.f + "", "");
        zx0.b(false, zx0.ANDFIX_DOWNLOAD, i + "", str2, HotPatchManager.getInstance().getMainVersion(), this.a.f + "", str);
        if (this.c.equalsIgnoreCase("SafeMode")) {
            Intent intent = new Intent(js2.UPDATE_ACTION);
            intent.putExtra("updateType", "hotpatch");
            intent.putExtra("success", false);
            intent.putExtra("errorMsg", str2);
            LocalBroadcastManager.getInstance(this.b).sendBroadcast(intent);
        }
    }

    @Override // com.taobao.downloader.request.DownloadListener
    public void onDownloadFinish(String str, final String str2) {
        is2.b(zx0.ANDFIX_DOWNLOAD, this.a.f + "");
        String mainVersion = HotPatchManager.getInstance().getMainVersion();
        zx0.b(true, zx0.ANDFIX_DOWNLOAD, "0", "", mainVersion, this.a.f + "", str);
        String mainVersion2 = HotPatchManager.getInstance().getMainVersion();
        by0.d(true, "download", "0", "", mainVersion2, this.a.f + "", "");
        if (this.d) {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                /* class com.taobao.updatecenter.hotpatch.HotPatchDownloaderListener.AnonymousClass1 */

                public void run() {
                    Toast.makeText(HotPatchDownloaderListener.this.b, "Patch 包下载完毕，准备加载！", 1).show();
                }
            });
        }
        if (Thread.currentThread().getId() == Looper.getMainLooper().getThread().getId()) {
            new Thread() {
                /* class com.taobao.updatecenter.hotpatch.HotPatchDownloaderListener.AnonymousClass2 */

                public void run() {
                    HotPatchManager.getInstance().loadDownloadedPatch(str2, HotPatchDownloaderListener.this.a);
                    if (HotPatchDownloaderListener.this.c.equalsIgnoreCase("SafeMode")) {
                        Intent intent = new Intent(js2.UPDATE_ACTION);
                        intent.putExtra("updateType", "hotpatch");
                        intent.putExtra("success", true);
                        intent.putExtra("errorMsg", "");
                        LocalBroadcastManager.getInstance(HotPatchDownloaderListener.this.b).sendBroadcast(intent);
                    }
                }
            }.start();
            return;
        }
        HotPatchManager.getInstance().loadDownloadedPatch(str2, this.a);
        if (this.c.equalsIgnoreCase("SafeMode")) {
            Intent intent = new Intent(js2.UPDATE_ACTION);
            intent.putExtra("updateType", "hotpatch");
            intent.putExtra("success", true);
            intent.putExtra("errorMsg", "");
            LocalBroadcastManager.getInstance(this.b).sendBroadcast(intent);
        }
    }

    @Override // com.taobao.downloader.request.DownloadListener
    public void onDownloadProgress(int i) {
    }

    @Override // com.taobao.downloader.request.DownloadListener
    public void onDownloadStateChange(String str, boolean z) {
    }

    @Override // com.taobao.downloader.request.DownloadListener
    public void onFinish(boolean z) {
    }

    @Override // com.taobao.downloader.request.DownloadListener
    public void onNetworkLimit(int i, io1 io1, DownloadListener.NetworkLimitCallback networkLimitCallback) {
    }
}
