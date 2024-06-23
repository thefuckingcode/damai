package com.taobao.downloader.download;

import tb.lb2;

/* compiled from: Taobao */
public interface IDownloader {
    void cancel();

    void download(lb2 lb2, IListener iListener);

    void pause();
}
