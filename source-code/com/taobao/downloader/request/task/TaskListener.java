package com.taobao.downloader.request.task;

import com.taobao.downloader.download.IListener;
import com.taobao.downloader.request.DownloadListener;
import tb.io1;

/* compiled from: Taobao */
public interface TaskListener extends IListener {
    void onDownloadStateChange(String str, boolean z);

    void onNetworkLimit(int i, io1 io1, DownloadListener.NetworkLimitCallback networkLimitCallback);
}
