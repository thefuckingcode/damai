package com.ali.user.open.oauth;

import java.util.Map;

/* compiled from: Taobao */
public interface OauthCallback {
    void onFail(String str, int i, String str2);

    void onSuccess(String str, Map map);
}
