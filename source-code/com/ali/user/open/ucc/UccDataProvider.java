package com.ali.user.open.ucc;

import com.ali.user.open.core.callback.MemberCallback;

/* compiled from: Taobao */
public interface UccDataProvider {
    void getUserToken(String str, MemberCallback<String> memberCallback);
}
