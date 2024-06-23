package com.youku.live.dsl.network;

/* compiled from: Taobao */
public interface INetResponse {
    byte[] getRawData();

    String getRetCode();

    String getRetMessage();

    String getSource();

    boolean isSuccess();
}
