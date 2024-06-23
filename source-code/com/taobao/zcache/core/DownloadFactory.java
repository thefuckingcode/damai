package com.taobao.zcache.core;

import com.taobao.zcache.network.DownloadFinishedCallback;
import com.taobao.zcache.network.DownloadRequest;
import com.taobao.zcache.network.DownloadTask;

/* compiled from: Taobao */
class DownloadFactory {
    DownloadFactory() {
    }

    public void sendRequest(DownloadRequest downloadRequest, DownloadFinishedCallback downloadFinishedCallback) {
        DownloadTask.sendRequest(downloadRequest, downloadFinishedCallback);
    }
}
