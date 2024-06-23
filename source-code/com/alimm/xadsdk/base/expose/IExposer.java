package com.alimm.xadsdk.base.expose;

/* compiled from: Taobao */
public interface IExposer {
    public static final String SDK_DEFAULT = "0";
    public static final String SDK_MMA = "1";

    void onExpose(String str, String str2, ExposeCallback exposeCallback);
}
