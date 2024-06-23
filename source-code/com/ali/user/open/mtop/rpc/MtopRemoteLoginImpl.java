package com.ali.user.open.mtop.rpc;

import com.ali.user.open.callback.LoginCallback;
import com.ali.user.open.service.impl.SessionManager;
import com.ali.user.open.session.Session;
import com.ali.user.open.ucc.util.MtopRemoteLogin;
import com.taobao.tao.remotebusiness.login.IRemoteLogin;
import com.taobao.tao.remotebusiness.login.LoginContext;
import com.taobao.tao.remotebusiness.login.onLoginListener;

/* compiled from: Taobao */
public class MtopRemoteLoginImpl implements IRemoteLogin {
    @Override // com.taobao.tao.remotebusiness.login.IRemoteLogin
    public LoginContext getLoginContext() {
        LoginContext loginContext = new LoginContext();
        try {
            loginContext.nickname = SessionManager.INSTANCE.getSession().nick;
        } catch (Exception unused) {
        }
        return loginContext;
    }

    @Override // com.taobao.tao.remotebusiness.login.IRemoteLogin
    public boolean isLogining() {
        return false;
    }

    @Override // com.taobao.tao.remotebusiness.login.IRemoteLogin
    public boolean isSessionValid() {
        return SessionManager.INSTANCE.isSessionValid();
    }

    @Override // com.taobao.tao.remotebusiness.login.IRemoteLogin
    public void login(final onLoginListener onloginlistener, boolean z) {
        AnonymousClass1 r7 = new LoginCallback() {
            /* class com.ali.user.open.mtop.rpc.MtopRemoteLoginImpl.AnonymousClass1 */

            @Override // com.ali.user.open.core.callback.FailureCallback
            public void onFailure(int i, String str) {
                onLoginListener onloginlistener = onloginlistener;
                if (onloginlistener == null) {
                    return;
                }
                if (i == 10003) {
                    onloginlistener.onLoginCancel();
                } else {
                    onloginlistener.onLoginFail();
                }
            }

            @Override // com.ali.user.open.callback.LoginCallback
            public void onSuccess(Session session) {
                onLoginListener onloginlistener = onloginlistener;
                if (onloginlistener != null) {
                    onloginlistener.onLoginSuccess();
                }
            }
        };
        try {
            MtopRemoteLogin.class.getMethod("login", LoginCallback.class).invoke(null, r7);
        } catch (Throwable unused) {
        }
    }
}
