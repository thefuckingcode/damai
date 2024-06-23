package com.taobao.downloader.adpater;

import com.taobao.downloader.download.IDownloader;
import tb.io1;

/* compiled from: Taobao */
public interface DownloadFactory {
    IDownloader getDownloader(io1 io1);
}
