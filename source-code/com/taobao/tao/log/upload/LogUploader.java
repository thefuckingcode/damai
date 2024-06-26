package com.taobao.tao.log.upload;

import java.util.Map;

/* compiled from: Taobao */
public interface LogUploader {
    void cancel();

    UploaderInfo getUploadInfo();

    void setMetaInfo(Map<String, Object> map);

    void startUpload(UploaderParam uploaderParam, String str, FileUploadListener fileUploadListener);
}
