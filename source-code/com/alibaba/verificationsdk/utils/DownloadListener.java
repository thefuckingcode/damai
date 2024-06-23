package com.alibaba.verificationsdk.utils;

import java.io.File;

/* compiled from: Taobao */
public interface DownloadListener {
    void downloadFinished(File file);

    void downloadStart();
}
