package com.taobao.downloader.download.protocol;

/* compiled from: Taobao */
public interface DLInputStream {
    void close() throws Exception;

    int read(byte[] bArr) throws Exception;
}
