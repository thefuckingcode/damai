package com.taobao.update.adapter;

/* compiled from: Taobao */
public interface NativeLibUpdateListener {

    /* compiled from: Taobao */
    public interface DownloadListener {
        void onDownloadAllFinish(boolean z);

        void onDownloadError(String str, int i, String str2);

        void onDownloadFinish(String str, String str2);
    }

    /* compiled from: Taobao */
    public interface InstallListener {
        void onInstallFailed(String str, String str2);

        void onInstallSuccess(String str, String str2);
    }

    DownloadListener getDownloadListener();

    InstallListener getInstallListener();
}
