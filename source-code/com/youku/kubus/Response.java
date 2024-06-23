package com.youku.kubus;

@NoProguard
/* compiled from: Taobao */
public class Response {
    public Object body;
    public int code;
    public long id;
    public String mode;

    Response(long j) {
        this.id = j;
    }
}
