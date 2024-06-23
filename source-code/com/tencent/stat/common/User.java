package com.tencent.stat.common;

/* compiled from: Taobao */
public class User {
    private String mac = null;
    private int type;
    private String uid = null;

    public User(String str, String str2, int i) {
        this.uid = str;
        this.mac = str2;
        this.type = i;
    }

    public String getMac() {
        return this.mac;
    }

    public int getType() {
        return this.type;
    }

    public String getUid() {
        return this.uid;
    }

    public void setType(int i) {
        this.type = i;
    }
}
