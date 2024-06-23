package com.taobao.android.sopatch.download;

import com.taobao.android.sopatch.download.FileDownloader;
import com.taobao.downloader.request.DownloadListener;
import java.io.File;
import tb.io1;
import tb.s91;
import tb.sb0;
import tb.u21;
import tb.ub0;

/* compiled from: Taobao */
public class a implements FileDownloader {

    /* renamed from: com.taobao.android.sopatch.download.a$a  reason: collision with other inner class name */
    /* compiled from: Taobao */
    class C0215a implements DownloadListener {
        final /* synthetic */ FileDownloader.Callback a;

        C0215a(a aVar, FileDownloader.Callback callback) {
            this.a = callback;
        }

        @Override // com.taobao.downloader.request.DownloadListener
        public void onDownloadError(String str, int i, String str2) {
            s91.d(str, str2);
            this.a.onFail();
        }

        @Override // com.taobao.downloader.request.DownloadListener
        public void onDownloadFinish(String str, String str2) {
            s91.d(str, "succ");
            this.a.onSuccess();
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

    @Override // com.taobao.android.sopatch.download.FileDownloader
    public void download(String str, File file, FileDownloader.Callback callback) {
        sb0 sb0 = new sb0();
        u21 u21 = new u21();
        u21.a = str;
        u21.d = file.getName();
        sb0.a.add(u21);
        io1 io1 = sb0.b;
        io1.a = "soLoader";
        io1.f = file.getParent();
        sb0.b.m = false;
        ub0.c().b(sb0, new C0215a(this, callback));
    }
}
