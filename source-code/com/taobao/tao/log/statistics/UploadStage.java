package com.taobao.tao.log.statistics;

/* compiled from: Taobao */
public enum UploadStage {
    UNKNOWN(0),
    STAGE_REQ(1),
    STAGE_REQ_TOKEN(2),
    STAGE_RES_TOKEN(3),
    STAGE_UPLOAD(4),
    STAGE_DONE(5);
    
    private int value;

    private UploadStage(int i) {
        this.value = i;
    }

    public String getValue() {
        return String.valueOf(this.value);
    }
}
