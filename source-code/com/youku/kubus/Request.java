package com.youku.kubus;

@NoProguard
/* compiled from: Taobao */
public class Request {
    public long id;
    public String mode;
    public Object params;

    Request(long j) {
        this(j, null);
    }

    public Request(long j, Object obj) {
        this.id = j;
        this.mode = "sync";
        this.params = obj;
    }

    public Request(long j, Object obj, String str) {
        this.id = j;
        this.mode = str;
        this.params = obj;
    }
}
