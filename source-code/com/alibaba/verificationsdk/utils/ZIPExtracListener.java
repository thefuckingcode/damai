package com.alibaba.verificationsdk.utils;

import java.io.File;

/* compiled from: Taobao */
public interface ZIPExtracListener {
    void unzipFinished(File file, File file2);

    void unzipStart();
}
