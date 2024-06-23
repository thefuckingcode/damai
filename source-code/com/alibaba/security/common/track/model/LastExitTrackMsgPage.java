package com.alibaba.security.common.track.model;

/* compiled from: Taobao */
public enum LastExitTrackMsgPage {
    H5("h5"),
    BIO("bio"),
    TAKE_PHOTO("takephoto");
    
    private String msg;

    private LastExitTrackMsgPage(String str) {
        this.msg = str;
    }

    public final String getMsg() {
        return this.msg;
    }
}
