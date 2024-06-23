package com.ali.user.open.callback;

import com.ali.user.open.core.callback.FailureCallback;
import com.ali.user.open.session.Session;

/* compiled from: Taobao */
public interface LoginCallback extends FailureCallback {
    void onSuccess(Session session);
}
