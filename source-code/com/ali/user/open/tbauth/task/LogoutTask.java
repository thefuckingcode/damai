package com.ali.user.open.tbauth.task;

import android.text.TextUtils;
import com.ali.user.open.core.AliMemberSDK;
import com.ali.user.open.core.model.ResultCode;
import com.ali.user.open.core.model.RpcRequestCallbackWithCode;
import com.ali.user.open.core.model.RpcResponse;
import com.ali.user.open.core.service.MemberExecutorService;
import com.ali.user.open.core.task.AbsAsyncTask;
import com.ali.user.open.core.trace.SDKLogger;
import com.ali.user.open.core.util.CommonUtils;
import com.ali.user.open.device.DeviceTokenManager;
import com.ali.user.open.history.AccountHistoryManager;
import com.ali.user.open.service.SessionService;
import com.ali.user.open.service.impl.SessionManager;
import com.ali.user.open.tbauth.callback.LogoutCallback;

/* compiled from: Taobao */
public class LogoutTask extends AbsAsyncTask<Void, Void, Void> {
    private LogoutCallback mLogoutCallback;

    public LogoutTask(LogoutCallback logoutCallback) {
        this.mLogoutCallback = logoutCallback;
    }

    /* access modifiers changed from: protected */
    @Override // com.ali.user.open.core.task.AbsAsyncTask
    public void doFinally() {
    }

    /* access modifiers changed from: protected */
    @Override // com.ali.user.open.core.task.AbsAsyncTask
    public void doWhenException(Throwable th) {
        CommonUtils.onFailure(this.mLogoutCallback, ResultCode.create(10010, th.getMessage()));
    }

    /* access modifiers changed from: protected */
    public Void asyncExecute(Void... voidArr) {
        ResultCode logout;
        MemberExecutorService memberExecutorService;
        AnonymousClass2 r0;
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("into logout ");
            SessionManager sessionManager = SessionManager.INSTANCE;
            sb.append(sessionManager.getInternalSession().toString());
            SDKLogger.e("logout task", sb.toString());
            String str = sessionManager.getSession("taobao").hid;
            if (TextUtils.isEmpty(str)) {
                str = sessionManager.getInternalSession().userId;
            }
            if (!TextUtils.isEmpty(str)) {
                RpcRepository.logout(str, new RpcRequestCallbackWithCode() {
                    /* class com.ali.user.open.tbauth.task.LogoutTask.AnonymousClass1 */

                    @Override // com.ali.user.open.core.model.RpcRequestCallbackWithCode
                    public void onError(String str, RpcResponse rpcResponse) {
                    }

                    @Override // com.ali.user.open.core.model.RpcRequestCallbackWithCode
                    public void onSuccess(RpcResponse rpcResponse) {
                    }

                    @Override // com.ali.user.open.core.model.RpcRequestCallbackWithCode
                    public void onSystemError(String str, RpcResponse rpcResponse) {
                    }
                });
            }
            AccountHistoryManager.getInstance().clearHistoryAccount();
            DeviceTokenManager.getInstance().clearDeviceToken();
            logout = ((SessionService) AliMemberSDK.getService(SessionService.class)).logout("taobao");
            if (ResultCode.SUCCESS.equals(logout)) {
                memberExecutorService = (MemberExecutorService) AliMemberSDK.getService(MemberExecutorService.class);
                r0 = new Runnable() {
                    /* class com.ali.user.open.tbauth.task.LogoutTask.AnonymousClass2 */

                    public void run() {
                        if (LogoutTask.this.mLogoutCallback != null) {
                            LogoutTask.this.mLogoutCallback.onSuccess();
                        }
                    }
                };
                memberExecutorService.postUITask(r0);
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            logout = ((SessionService) AliMemberSDK.getService(SessionService.class)).logout("taobao");
            if (ResultCode.SUCCESS.equals(logout)) {
                memberExecutorService = (MemberExecutorService) AliMemberSDK.getService(MemberExecutorService.class);
                r0 = new Runnable() {
                    /* class com.ali.user.open.tbauth.task.LogoutTask.AnonymousClass2 */

                    public void run() {
                        if (LogoutTask.this.mLogoutCallback != null) {
                            LogoutTask.this.mLogoutCallback.onSuccess();
                        }
                    }
                };
            }
        } catch (Throwable th) {
            ResultCode logout2 = ((SessionService) AliMemberSDK.getService(SessionService.class)).logout("taobao");
            if (ResultCode.SUCCESS.equals(logout2)) {
                ((MemberExecutorService) AliMemberSDK.getService(MemberExecutorService.class)).postUITask(new Runnable() {
                    /* class com.ali.user.open.tbauth.task.LogoutTask.AnonymousClass2 */

                    public void run() {
                        if (LogoutTask.this.mLogoutCallback != null) {
                            LogoutTask.this.mLogoutCallback.onSuccess();
                        }
                    }
                });
            } else {
                CommonUtils.onFailure(this.mLogoutCallback, logout2);
            }
            throw th;
        }
        CommonUtils.onFailure(this.mLogoutCallback, logout);
        return null;
    }
}
