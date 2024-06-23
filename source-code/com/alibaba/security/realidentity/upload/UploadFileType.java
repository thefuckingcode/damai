package com.alibaba.security.realidentity.upload;

/* compiled from: Taobao */
public enum UploadFileType {
    ARUP(1, "内部arup上传"),
    OSS(2, "外部oss上传");
    
    public String desc;
    public int type;

    private UploadFileType(int i, String str) {
        this.type = i;
        this.desc = str;
    }
}
