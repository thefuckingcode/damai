package com.ali.user.open.tbauth.handler;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.webkit.WebView;
import com.ali.user.mobile.app.constant.UTConstant;
import com.ali.user.open.callback.LoginCallback;
import com.ali.user.open.core.AliMemberSDK;
import com.ali.user.open.core.Site;
import com.ali.user.open.core.message.Message;
import com.ali.user.open.core.message.MessageUtils;
import com.ali.user.open.core.model.ResultCode;
import com.ali.user.open.core.model.SystemMessageConstants;
import com.ali.user.open.core.service.MemberExecutorService;
import com.ali.user.open.core.service.UserTrackerService;
import com.ali.user.open.core.trace.SDKLogger;
import com.ali.user.open.service.SessionService;
import com.ali.user.open.session.Session;
import com.ali.user.open.tbauth.RequestCode;
import com.ali.user.open.tbauth.UTConstants;
import com.ali.user.open.tbauth.context.TbAuthContext;
import com.ali.user.open.tbauth.task.RpcPresenter;
import com.ali.user.open.tbauth.ui.TbAuthActivity;
import com.ali.user.open.tbauth.ui.context.CallbackContext;
import com.ali.user.open.tbauth.ui.support.BaseActivityResultHandler;
import com.ut.mini.UTHitBuilders;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import tb.gl1;

/* compiled from: Taobao */
public class TbAuthActivityResultHandler extends BaseActivityResultHandler {
    private static final String TAG = "login";

    private void handleCheck(int i, Intent intent, final LoginCallback loginCallback) {
        SDKLogger.d("login", "handleCheck");
        final WeakReference<Activity> weakReference = CallbackContext.activity;
        if (weakReference == null || weakReference.get() == null || intent == null) {
            ((MemberExecutorService) AliMemberSDK.getService(MemberExecutorService.class)).postUITask(new Runnable() {
                /* class com.ali.user.open.tbauth.handler.TbAuthActivityResultHandler.AnonymousClass3 */

                public void run() {
                    CallbackContext.activity = weakReference;
                    TbAuthActivityResultHandler.this.onLoginFailure((Activity) weakReference.get(), UTConstants.E_H5_OPERATION_BIND_FAILURE, loginCallback, 10003);
                    CallbackContext.activity = null;
                }
            });
        } else if (TextUtils.isEmpty(intent.getStringExtra("token"))) {
            ((MemberExecutorService) AliMemberSDK.getService(MemberExecutorService.class)).postUITask(new Runnable() {
                /* class com.ali.user.open.tbauth.handler.TbAuthActivityResultHandler.AnonymousClass1 */

                public void run() {
                    CallbackContext.activity = weakReference;
                    TbAuthActivityResultHandler.this.onLoginFailure((Activity) weakReference.get(), UTConstants.E_IV_LOGIN_FAILURE, loginCallback, SystemMessageConstants.H5_LOGIN_FAILURE);
                    CallbackContext.activity = null;
                }
            });
        } else {
            RpcPresenter.loginByIVToken(weakReference.get(), i, intent.getStringExtra("token"), intent.getStringExtra("scene"), intent.getStringExtra("aliusersdk_h5querystring"), new LoginCallback() {
                /* class com.ali.user.open.tbauth.handler.TbAuthActivityResultHandler.AnonymousClass2 */

                @Override // com.ali.user.open.core.callback.FailureCallback
                public void onFailure(int i, String str) {
                    ((MemberExecutorService) AliMemberSDK.getService(MemberExecutorService.class)).postUITask(new Runnable() {
                        /* class com.ali.user.open.tbauth.handler.TbAuthActivityResultHandler.AnonymousClass2.AnonymousClass1 */

                        public void run() {
                            CallbackContext.activity = weakReference;
                            AnonymousClass2 r0 = AnonymousClass2.this;
                            TbAuthActivityResultHandler.this.onLoginFailure((Activity) weakReference.get(), UTConstants.E_IV_LOGIN_FAILURE, loginCallback, SystemMessageConstants.H5_LOGIN_FAILURE);
                            CallbackContext.activity = null;
                        }
                    });
                }

                @Override // com.ali.user.open.callback.LoginCallback
                public void onSuccess(Session session) {
                    ((MemberExecutorService) AliMemberSDK.getService(MemberExecutorService.class)).postUITask(new Runnable() {
                        /* class com.ali.user.open.tbauth.handler.TbAuthActivityResultHandler.AnonymousClass2.AnonymousClass2 */

                        public void run() {
                            CallbackContext.activity = weakReference;
                            AnonymousClass2 r0 = AnonymousClass2.this;
                            TbAuthActivityResultHandler.this.onLoginSuccess((Activity) weakReference.get(), UTConstants.E_H5_LOGIN_SUCCESS, loginCallback);
                            CallbackContext.activity = null;
                        }
                    });
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void onLoginFailure(Activity activity, String str, LoginCallback loginCallback, int i) {
        SDKLogger.d("login", "onLoginFailure ");
        if (loginCallback != null) {
            Message createMessage = MessageUtils.createMessage(i, new Object[0]);
            loginCallback.onFailure(createMessage.code, createMessage.message);
            HashMap hashMap = new HashMap();
            hashMap.put("code", i + "");
            hashMap.put(UTConstant.Args.UT_PROPERTY_SUCCESS, UTConstant.Args.UT_SUCCESS_F);
            if (i == 10005 || i == 10004) {
                hashMap.put("type", gl1.TYPE_OPEN_URL_NATIVE);
            } else {
                hashMap.put("type", "H5");
            }
            hashMap.put(UTHitBuilders.UTHitBuilder.FIELD_ARG2, TbAuthContext.traceId);
            ((UserTrackerService) AliMemberSDK.getService(UserTrackerService.class)).send("Page_TaobaoOauth", "Page_TaobaoOauth_authcode", hashMap);
        }
        if (CallbackContext.mGlobalLoginCallback != null) {
            Message createMessage2 = MessageUtils.createMessage(i, new Object[0]);
            CallbackContext.mGlobalLoginCallback.onFailure(createMessage2.code, createMessage2.message);
        }
        if (activity != null && (activity instanceof TbAuthActivity)) {
            CallbackContext.activity = null;
            activity.finish();
            CallbackContext.loginCallback = null;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void onLoginSuccess(Activity activity, String str, LoginCallback loginCallback) {
        SDKLogger.d("login", "onLoginSuccess ");
        if (loginCallback != null) {
            Session session = new Session();
            session.topAuthCode = str;
            loginCallback.onSuccess(session);
        }
        LoginCallback loginCallback2 = CallbackContext.mGlobalLoginCallback;
        if (loginCallback2 != null) {
            loginCallback2.onSuccess(((SessionService) AliMemberSDK.getService(SessionService.class)).getSession());
        }
        if (activity != null && (activity instanceof TbAuthActivity)) {
            CallbackContext.activity = null;
            activity.finish();
            CallbackContext.loginCallback = null;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.ali.user.open.tbauth.ui.support.BaseActivityResultHandler
    public void onCallbackContext(int i, int i2, Intent intent, Activity activity, Map<Class<?>, Object> map, WebView webView) {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("onCallbackContext requestCode=");
        sb.append(i);
        sb.append(" resultCode = ");
        sb.append(i2);
        sb.append(" authCode = ");
        sb.append(intent == null ? "" : intent.getStringExtra("result"));
        SDKLogger.d("login", sb.toString());
        LoginCallback loginCallback = (LoginCallback) CallbackContext.loginCallback;
        if (i != RequestCode.OPEN_H5_LOGIN || loginCallback == null) {
            if (i == RequestCode.OPEN_TAOBAO && loginCallback != null) {
                ((UserTrackerService) AliMemberSDK.getService(UserTrackerService.class)).send("AUTH_TAOBAO", null);
                if (i2 == -1 && intent != null) {
                    String stringExtra = intent.getStringExtra("result");
                    if (TextUtils.isEmpty(stringExtra)) {
                        onLoginFailure(activity, "E_TB_LOGIN_CANCEL", loginCallback, 10004);
                    } else if (TextUtils.equals(stringExtra, "00000000")) {
                        onLoginFailure(activity, "E_TB_LOGIN_SKIPL", loginCallback, 1011);
                    } else {
                        HashMap hashMap = new HashMap();
                        hashMap.put("authcode", stringExtra);
                        hashMap.put(UTConstant.Args.UT_PROPERTY_SUCCESS, "T");
                        hashMap.put("type", gl1.TYPE_OPEN_URL_NATIVE);
                        hashMap.put(UTHitBuilders.UTHitBuilder.FIELD_ARG2, TbAuthContext.traceId);
                        ((UserTrackerService) AliMemberSDK.getService(UserTrackerService.class)).send("Page_TaobaoOauth", "Page_TaobaoOauth_authcode", hashMap);
                        if (TbAuthContext.onlyAuthCode) {
                            onLoginSuccess(activity, stringExtra, loginCallback);
                        } else if (TbAuthContext.needSession) {
                            RpcPresenter.refreshPageAfterOpenTb(CallbackContext.activity.get(), stringExtra, loginCallback);
                        } else {
                            RpcPresenter.getAccessTokenWithAuthCode(CallbackContext.activity.get(), stringExtra, "taobao", loginCallback);
                        }
                    }
                } else if (i2 == 0) {
                    onLoginFailure(activity, "E_TB_LOGIN_CANCEL", loginCallback, 10004);
                } else {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("result from taobao : ");
                    if (intent == null) {
                        str = "";
                    } else {
                        str = intent.getStringExtra("result");
                    }
                    sb2.append(str);
                    SDKLogger.d("login", sb2.toString());
                    onLoginFailure(activity, "E_TB_LOGIN_FAILURE", loginCallback, 10005);
                }
            } else if (i != RequestCode.OPEN_QR_LOGIN || loginCallback == null) {
                if (i != RequestCode.OPEN_QR_LOGIN_CONFIRM || loginCallback == null) {
                    if (i == RequestCode.OPEN_DOUBLE_CHECK) {
                        handleCheck(0, intent, loginCallback);
                    } else if (i == RequestCode.OPEN_H5_UNBIND) {
                        if (i2 == ResultCode.SUCCESS.code) {
                            onLoginSuccess(activity, "E_H5_UNBIND_SUCCESS", loginCallback);
                        } else {
                            onLoginFailure(activity, "E_H5_UNBIND_FAILURE", loginCallback, 10003);
                        }
                        CallbackContext.loginCallback = null;
                    } else if (i == RequestCode.OPEN_ICBU_H5_LOGIN && loginCallback != null) {
                        if (i2 == ResultCode.SUCCESS.code) {
                            if (TbAuthContext.onlyAuthCode) {
                                onLoginSuccess(activity, intent.getStringExtra("result"), loginCallback);
                            } else {
                                RpcPresenter.getAccessTokenWithAuthCode(CallbackContext.activity.get(), intent.getStringExtra("result"), Site.ICBU, loginCallback);
                            }
                        } else if (i2 != ResultCode.IGNORE.code) {
                            if (i2 == ResultCode.CHECK.code) {
                                handleCheck(4, intent, loginCallback);
                            } else {
                                onLoginFailure(activity, "E_H5_CANCEL_FAILURE", loginCallback, 10003);
                            }
                        }
                    }
                } else if (i2 == ResultCode.SUCCESS.code) {
                    onLoginSuccess(activity, "E_QR_LOGIN_CONFIRM_SUCCESS", loginCallback);
                } else {
                    onLoginFailure(activity, "E_QR_LOGIN_CONFIRM_CANCEL", loginCallback, 10003);
                }
            } else if (i2 == ResultCode.SUCCESS.code) {
                onLoginSuccess(activity, "E_QR_LOGIN_SUCCESS", loginCallback);
            } else {
                onLoginFailure(activity, "E_QR_CANCEL_FAILURE", loginCallback, 10003);
            }
        } else if (i2 == ResultCode.SUCCESS.code) {
            HashMap hashMap2 = new HashMap();
            hashMap2.put("authcode", intent.getStringExtra("result"));
            hashMap2.put(UTConstant.Args.UT_PROPERTY_SUCCESS, "T");
            hashMap2.put("type", "H5");
            hashMap2.put(UTHitBuilders.UTHitBuilder.FIELD_ARG2, TbAuthContext.traceId);
            ((UserTrackerService) AliMemberSDK.getService(UserTrackerService.class)).send("Page_TaobaoOauth", "Page_TaobaoOauth_authcode", hashMap2);
            if (TbAuthContext.onlyAuthCode) {
                onLoginSuccess(activity, intent.getStringExtra("result"), loginCallback);
            } else if (TbAuthContext.needSession) {
                RpcPresenter.refreshPageAfterOpenTb(CallbackContext.activity.get(), intent.getStringExtra("result"), loginCallback);
            } else {
                RpcPresenter.getAccessTokenWithAuthCode(CallbackContext.activity.get(), intent.getStringExtra("result"), "taobao", loginCallback);
            }
        } else if (i2 != ResultCode.IGNORE.code) {
            if (i2 == ResultCode.CHECK.code) {
                handleCheck(0, intent, loginCallback);
            } else {
                onLoginFailure(activity, "E_H5_CANCEL_FAILURE", loginCallback, 10003);
            }
        }
    }
}
