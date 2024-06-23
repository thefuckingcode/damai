package com.taobao.tao.log.uploader.service;

import android.content.Context;

/* compiled from: Taobao */
public interface TLogFileUploader {
    void executeUploadTask(Context context, TLogUploadMsg tLogUploadMsg, TLogFileUploaderCallBack tLogFileUploaderCallBack);

    String getBizCode();

    void onUploadDone(boolean z, String str);
}
