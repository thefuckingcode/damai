package com.youku.playerservice.axp.item;

/* compiled from: Taobao */
public class CacheBitStream extends BitStream {
    private DownloadType mDownloadType;

    /* compiled from: Taobao */
    public enum DownloadType {
        DOWNLOADING,
        FINISH
    }

    public CacheBitStream(Quality quality, String str, Codec codec, int i) {
        super(quality, str, codec, i);
    }

    public DownloadType getDownloadType() {
        return this.mDownloadType;
    }

    public void setDownloadType(DownloadType downloadType) {
        this.mDownloadType = downloadType;
    }
}
