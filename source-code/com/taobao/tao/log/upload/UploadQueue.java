package com.taobao.tao.log.upload;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
public class UploadQueue {
    private String TAG;
    private Map<String, FileUploadListener> fileUploadListenerMap;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class CreateInstance {
        private static UploadQueue instance = new UploadQueue();

        private CreateInstance() {
        }
    }

    public static synchronized UploadQueue getInstance() {
        UploadQueue uploadQueue;
        synchronized (UploadQueue.class) {
            uploadQueue = CreateInstance.instance;
        }
        return uploadQueue;
    }

    public FileUploadListener popListener(String str) {
        FileUploadListener fileUploadListener = this.fileUploadListenerMap.get(str);
        if (fileUploadListener == null) {
            return null;
        }
        this.fileUploadListenerMap.remove(str);
        return fileUploadListener;
    }

    public void pushListener(String str, FileUploadListener fileUploadListener) {
        if (str != null && fileUploadListener != null) {
            this.fileUploadListenerMap.put(str, fileUploadListener);
        }
    }

    private UploadQueue() {
        this.TAG = "TLOG.UploadQueue";
        this.fileUploadListenerMap = new ConcurrentHashMap();
    }
}
