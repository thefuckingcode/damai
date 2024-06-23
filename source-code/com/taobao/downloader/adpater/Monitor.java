package com.taobao.downloader.adpater;

import tb.of1;

/* compiled from: Taobao */
public interface Monitor {
    public static final String POINT_ADD = "add";
    public static final String POINT_ALL_CALLBACK = "allcallback";
    public static final String POINT_URL = "url";

    void monitorCount(String str, String str2, String str3, int i);

    void monitorFail(String str, String str2, String str3, String str4, String str5);

    void monitorSuccess(String str, String str2, String str3);

    void stat(of1.a aVar, String str);
}
