package com.taobao.tao.log.statistics;

/* compiled from: Taobao */
public enum UploadFileType {
    UNKNOWN(0),
    LOG(1),
    UDF(2),
    METHOD_TRACE(3),
    HEAP_DUMP(4);
    
    private int value;

    private UploadFileType(int i) {
        this.value = i;
    }

    public String getValue() {
        return String.valueOf(this.value);
    }
}
