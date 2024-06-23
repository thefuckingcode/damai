package com.youku.live.dsl.share;

/* compiled from: Taobao */
public interface IShareResult {
    void onFailure(IShareInfo iShareInfo, ShareResult shareResult);

    void onSuccess(IShareInfo iShareInfo);
}
