package com.taobao.downloader.request;

import tb.io1;

/* compiled from: Taobao */
public interface DownloadListener {

    /* compiled from: Taobao */
    public interface NetworkLimitCallback {
        void hasChangeParams(boolean z);
    }

    void onDownloadError(String str, int i, String str2);

    void onDownloadFinish(String str, String str2);

    void onDownloadProgress(int i);

    void onDownloadStateChange(String str, boolean z);

    void onFinish(boolean z);

    void onNetworkLimit(int i, io1 io1, NetworkLimitCallback networkLimitCallback);
}
