package com.youku.arch.solid;

import com.youku.arch.solid.download.DownloadTask;

/* compiled from: Taobao */
public interface ZipDownloadItem {
    void downloadFail();

    String getZipMd5();

    String getZipName();

    DownloadTask.Priority getZipPriority(boolean z);

    String getZipUrl();

    boolean needDownloadZip();
}
