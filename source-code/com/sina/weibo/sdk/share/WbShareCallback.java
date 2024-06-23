package com.sina.weibo.sdk.share;

import com.sina.weibo.sdk.common.UiError;

/* compiled from: Taobao */
public interface WbShareCallback {
    void onCancel();

    void onComplete();

    void onError(UiError uiError);
}
