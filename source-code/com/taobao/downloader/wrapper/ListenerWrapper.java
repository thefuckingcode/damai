package com.taobao.downloader.wrapper;

import com.taobao.downloader.request.DownloadListener;
import com.taobao.downloader.request.task.TaskListener;
import com.taobao.downloader.util.ThreadUtil;
import tb.ef;
import tb.io1;
import tb.lb2;
import tb.sb0;
import tb.u21;

/* compiled from: Taobao */
public class ListenerWrapper implements TaskListener {
    private sb0 a;
    private DownloadListener b;
    private long c;
    private long d;
    private String e;
    private ef f;

    public ListenerWrapper(sb0 sb0, DownloadListener downloadListener) {
        this.a = sb0;
        this.b = downloadListener;
        String str = sb0.b.a;
        this.e = str;
        this.f = new ef(str, sb0, downloadListener);
    }

    private long b() {
        long j = this.c;
        if (0 != j) {
            return j;
        }
        long j2 = 0;
        for (u21 u21 : this.a.a) {
            long j3 = u21.b;
            if (j3 <= 0) {
                return 0;
            }
            j2 += j3;
        }
        this.c = j2;
        return j2;
    }

    @Override // com.taobao.downloader.request.task.TaskListener
    public void onDownloadStateChange(String str, boolean z) {
        this.b.onDownloadStateChange(str, z);
    }

    @Override // com.taobao.downloader.request.task.TaskListener
    public void onNetworkLimit(int i, io1 io1, DownloadListener.NetworkLimitCallback networkLimitCallback) {
        this.b.onNetworkLimit(i, io1, networkLimitCallback);
    }

    @Override // com.taobao.downloader.download.IListener
    public synchronized void onProgress(long j) {
        b();
        long j2 = this.c;
        if (0 != j2) {
            DownloadListener downloadListener = this.b;
            if (downloadListener != null) {
                int i = (int) (((this.d + j) * 100) / j2);
                if (i > 100) {
                    i = 100;
                }
                downloadListener.onDownloadProgress(i);
            }
        }
    }

    @Override // com.taobao.downloader.download.IListener
    public synchronized void onResult(final lb2 lb2) {
        this.d += lb2.e.b;
        if (this.b != null) {
            ThreadUtil.a(new Runnable() {
                /* class com.taobao.downloader.wrapper.ListenerWrapper.AnonymousClass1 */

                public void run() {
                    ListenerWrapper.this.f.a(lb2);
                }
            }, true);
        }
    }
}
