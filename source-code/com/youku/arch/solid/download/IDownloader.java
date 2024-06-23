package com.youku.arch.solid.download;

/* compiled from: Taobao */
public interface IDownloader {
    void download(DownloadTask downloadTask, IDownloadListener iDownloadListener);

    void init();
}
