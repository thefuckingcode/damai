package com.youku.live.dsl.network;

/* compiled from: Taobao */
public interface IResponse {
    byte[] getRawData();

    String getRetCode();

    String getRetMessage();

    String getSource();

    boolean isRequestSuccess();

    boolean isResponseSuccess();
}
