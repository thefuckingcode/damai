package com.sina.weibo.sdk.auth;

import com.sina.weibo.sdk.common.UiError;

/* compiled from: Taobao */
public interface WbAuthListener {
    void onCancel();

    void onComplete(Oauth2AccessToken oauth2AccessToken);

    void onError(UiError uiError);
}
