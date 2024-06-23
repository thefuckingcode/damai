package com.youku.usercenter.passport.callback;

import com.youku.passport.result.AbsResult;

/* compiled from: Taobao */
public interface ICallback<T extends AbsResult> {
    void onFailure(T t);

    void onSuccess(T t);
}
