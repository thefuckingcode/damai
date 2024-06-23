package com.amap.api.mapcore.util;

/* access modifiers changed from: package-private */
@hh(a = "update_item_download_info")
/* compiled from: Taobao */
public class bl {
    @hi(a = "mAdcode", b = 6)
    private String a = "";
    @hi(a = "fileLength", b = 5)
    private long b = 0;
    @hi(a = "splitter", b = 2)
    private int c = 0;
    @hi(a = "startPos", b = 5)
    private long d = 0;
    @hi(a = "endPos", b = 5)
    private long e = 0;

    public bl() {
    }

    public static String a(String str) {
        return "mAdcode" + "='" + str + "'";
    }

    public bl(String str, long j, int i, long j2, long j3) {
        this.a = str;
        this.b = j;
        this.c = i;
        this.d = j2;
        this.e = j3;
    }
}
