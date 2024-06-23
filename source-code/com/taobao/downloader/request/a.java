package com.taobao.downloader.request;

import com.taobao.downloader.request.DownloadListener;
import tb.io1;

/* compiled from: Taobao */
public class a implements DownloadListener {
    @Override // com.taobao.downloader.request.DownloadListener
    public void onDownloadError(String str, int i, String str2) {
        throw null;
    }

    @Override // com.taobao.downloader.request.DownloadListener
    public void onDownloadFinish(String str, String str2) {
        throw null;
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
        throw null;
    }
}
