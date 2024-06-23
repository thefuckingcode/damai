package com.taobao.android.sso.v2.launch;

import android.content.Intent;
import com.taobao.android.sso.v2.launch.exception.SSOException;

/* compiled from: Taobao */
public interface ILoginListener {
    void onFail(SSOException sSOException);

    void onSuccess(Intent intent);
}
