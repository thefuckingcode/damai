package com.alimm.xadsdk.info;

/* compiled from: Taobao */
public interface IRtInfoGetter {
    public static final int APP_START_TYPE_DEEPLINK = 2;
    public static final int APP_START_TYPE_PUSH = 1;
    public static final int APP_START_TYPE_USER = 0;

    String getAToken();

    int getAppStartType();

    String getClientCookie();

    String getPreviewAdAssetId();

    String getStoken();
}
