package com.taobao.android.sopatch.download;

import java.io.File;

/* compiled from: Taobao */
public interface FileDownloader {

    /* compiled from: Taobao */
    public interface Callback {
        void onFail();

        void onSuccess();
    }

    void download(String str, File file, Callback callback);
}
