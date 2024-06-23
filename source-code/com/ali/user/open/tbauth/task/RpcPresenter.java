package com.ali.user.open.tbauth.task;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.ali.user.mobile.app.constant.UTConstant;
import com.ali.user.open.callback.LoginCallback;
import com.ali.user.open.core.AliMemberSDK;
import com.ali.user.open.core.model.ResultCode;
import com.ali.user.open.core.model.RpcRequestCallbackWithCode;
import com.ali.user.open.core.model.RpcResponse;
import com.ali.user.open.core.service.MemberExecutorService;
import com.ali.user.open.core.service.UserTrackerService;
import com.ali.user.open.core.trace.SDKLogger;
import com.ali.user.open.core.util.CommonUtils;
import com.ali.user.open.device.DeviceTokenAccount;
import com.ali.user.open.device.DeviceTokenManager;
import com.ali.user.open.service.SessionService;
import com.ali.user.open.session.Session;
import com.ali.user.open.tbauth.RequestCode;
import com.ali.user.open.tbauth.context.TbAuthContext;
import com.ali.user.open.tbauth.ui.TbAuthActivity;
import com.ali.user.open.tbauth.ui.TbAuthWebViewActivity;
import com.ali.user.open.tbauth.ui.context.CallbackContext;
import com.ali.user.open.tbauth.util.SessionConvert;
import com.alibaba.security.biometrics.service.common.ABLogRecorderKeys;
import com.ut.mini.UTHitBuilders;
import java.util.HashMap;
import tb.gl1;

/* compiled from: Taobao */
public class RpcPresenter {
    public static String TAG = "login.tbRpc";

    public static void doWhenResultFail(Activity activity, LoginCallback loginCallback, int i, String str) {
        if (loginCallback != null) {
            loginCallback.onFailure(i, str);
            HashMap hashMap = new HashMap();
            hashMap.put("code", i + "");
            hashMap.put(UTConstant.Args.UT_PROPERTY_SUCCESS, UTConstant.Args.UT_SUCCESS_F);
            hashMap.put(UTHitBuilders.UTHitBuilder.FIELD_ARG2, TbAuthContext.traceId);
            ((UserTrackerService) AliMemberSDK.getService(UserTrackerService.class)).send("Page_TaobaoOauth", "Page_TaobaoOauth_Result", hashMap);
        }
        LoginCallback loginCallback2 = CallbackContext.mGlobalLoginCallback;
        if (loginCallback2 != null) {
            loginCallback2.onFailure(i, str);
        }
        finishTempActivity(activity);
    }

    static void doWhenResultFail2(final LoginCallback loginCallback, final int i, final String str) {
        ((MemberExecutorService) AliMemberSDK.getService(MemberExecutorService.class)).postUITask(new Runnable() {
            /* class com.ali.user.open.tbauth.task.RpcPresenter.AnonymousClass5 */

            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put("code", i + "");
                hashMap.put(UTConstant.Args.UT_PROPERTY_SUCCESS, UTConstant.Args.UT_SUCCESS_F);
                hashMap.put(UTHitBuilders.UTHitBuilder.FIELD_ARG2, TbAuthContext.traceId);
                ((UserTrackerService) AliMemberSDK.getService(UserTrackerService.class)).send("Page_TaobaoOauth", "Page_TaobaoOauth_Result", hashMap);
                LoginCallback loginCallback = loginCallback;
                if (loginCallback != null) {
                    loginCallback.onFailure(i, str);
                }
            }
        });
    }

    static void doWhenResultFail3(LoginCallback loginCallback, int i, String str) {
        if (loginCallback != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("code", i + "");
            hashMap.put(UTConstant.Args.UT_PROPERTY_SUCCESS, UTConstant.Args.UT_SUCCESS_F);
            hashMap.put(UTHitBuilders.UTHitBuilder.FIELD_ARG2, TbAuthContext.traceId);
            ((UserTrackerService) AliMemberSDK.getService(UserTrackerService.class)).send("Page_TaobaoOauth", "Page_TaobaoOauth_Result", hashMap);
            loginCallback.onFailure(i, str);
        }
    }

    public static void doWhenResultOk(Activity activity, LoginCallback loginCallback, Session session) {
        if (loginCallback != null) {
            String str = TAG;
            SDKLogger.d(str, "asyncExecute returnValue doWhenResultOk loginCallback not null,session = " + session.toString());
            loginCallback.onSuccess(session);
            HashMap hashMap = new HashMap();
            hashMap.put("type", gl1.TYPE_OPEN_URL_NATIVE);
            hashMap.put(UTConstant.Args.UT_PROPERTY_SUCCESS, "T");
            hashMap.put("authcode", session.topAuthCode);
            hashMap.put("openId", session.openId);
            hashMap.put(UTHitBuilders.UTHitBuilder.FIELD_ARG2, TbAuthContext.traceId);
            ((UserTrackerService) AliMemberSDK.getService(UserTrackerService.class)).send("Page_TaobaoOauth", "Page_TaobaoOauth_Result", hashMap);
        }
        LoginCallback loginCallback2 = CallbackContext.mGlobalLoginCallback;
        if (loginCallback2 != null) {
            loginCallback2.onSuccess(session);
        }
        finishTempActivity(activity);
    }

    /* access modifiers changed from: private */
    public static void doWhenResultOk2(final LoginCallback loginCallback, final Session session) {
        ((MemberExecutorService) AliMemberSDK.getService(MemberExecutorService.class)).postUITask(new Runnable() {
            /* class com.ali.user.open.tbauth.task.RpcPresenter.AnonymousClass6 */

            public void run() {
                LoginCallback loginCallback = loginCallback;
                if (loginCallback != null) {
                    loginCallback.onSuccess(session);
                }
            }
        });
    }

    static void doWhenResultOk3(LoginCallback loginCallback, Session session) {
        if (loginCallback != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("type", gl1.TYPE_OPEN_URL_NATIVE);
            hashMap.put(UTConstant.Args.UT_PROPERTY_SUCCESS, "T");
            hashMap.put("authcode", session.topAuthCode);
            hashMap.put("openId", session.openId);
            hashMap.put(UTHitBuilders.UTHitBuilder.FIELD_ARG2, TbAuthContext.traceId);
            ((UserTrackerService) AliMemberSDK.getService(UserTrackerService.class)).send("Page_TaobaoOauth", "Page_TaobaoOauth_Result", hashMap);
            loginCallback.onSuccess(session);
        }
    }

    /* access modifiers changed from: private */
    public static void finishTempActivity(Activity activity) {
        if (activity != null && (activity instanceof TbAuthActivity)) {
            CallbackContext.activity = null;
            activity.finish();
        }
    }

    public static void getAccessTokenWithAuthCode(final Activity activity, final String str, String str2, final LoginCallback loginCallback) {
        HashMap hashMap = new HashMap();
        hashMap.put("authcode", str);
        hashMap.put(UTHitBuilders.UTHitBuilder.FIELD_ARG2, TbAuthContext.traceId);
        ((UserTrackerService) AliMemberSDK.getService(UserTrackerService.class)).send("Page_TaobaoOauth", "Page_TaobaoOauth_openId", hashMap);
        RpcRepository.getAccessTokenWithAuthCode(str, str2, new RpcRequestCallbackWithCode() {
            /* class com.ali.user.open.tbauth.task.RpcPresenter.AnonymousClass8 */

            private void rpcResultFailHit(String str) {
                HashMap hashMap = new HashMap();
                hashMap.put(UTConstant.Args.UT_PROPERTY_SUCCESS, UTConstant.Args.UT_SUCCESS_F);
                hashMap.put("code", str);
                hashMap.put(UTHitBuilders.UTHitBuilder.FIELD_ARG2, TbAuthContext.traceId);
                ((UserTrackerService) AliMemberSDK.getService(UserTrackerService.class)).send("Page_TaobaoOauth", "Page_TaobaoOauth_openIdResult", hashMap);
            }

            @Override // com.ali.user.open.core.model.RpcRequestCallbackWithCode
            public void onError(String str, RpcResponse rpcResponse) {
                rpcResultFailHit(str);
                RpcPresenter.finishTempActivity(activity);
                if (rpcResponse != null) {
                    CommonUtils.onFailure(loginCallback, rpcResponse.code, rpcResponse.message);
                    return;
                }
                CommonUtils.onFailure(loginCallback, ResultCode.create(10010, ""));
            }

            @Override // com.ali.user.open.core.model.RpcRequestCallbackWithCode
            public void onSuccess(RpcResponse rpcResponse) {
                if (ResultCode.SUCCESS.message.equals(rpcResponse.actionType)) {
                    final T t = rpcResponse.returnValue;
                    if (t != null) {
                        RpcPresenter.saveDeviceToken(t);
                        ((MemberExecutorService) AliMemberSDK.getService(MemberExecutorService.class)).postUITask(new Runnable() {
                            /* class com.ali.user.open.tbauth.task.RpcPresenter.AnonymousClass8.AnonymousClass1 */

                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put("authcode", str);
                                hashMap.put(UTConstant.Args.UT_PROPERTY_SUCCESS, "T");
                                hashMap.put("openId", t.openId);
                                hashMap.put(UTHitBuilders.UTHitBuilder.FIELD_ARG2, TbAuthContext.traceId);
                                ((UserTrackerService) AliMemberSDK.getService(UserTrackerService.class)).send("Page_TaobaoOauth", "Page_TaobaoOauth_openIdResult", hashMap);
                                RpcPresenter.finishTempActivity(activity);
                                Session session = new Session();
                                ConvertAuthCodeToAccessTokenData convertAuthCodeToAccessTokenData = t;
                                session.openId = convertAuthCodeToAccessTokenData.openId;
                                session.bindToken = convertAuthCodeToAccessTokenData.bindToken;
                                session.topAccessToken = convertAuthCodeToAccessTokenData.accessToken;
                                session.topAuthCode = convertAuthCodeToAccessTokenData.authCode;
                                session.openSid = convertAuthCodeToAccessTokenData.openSid;
                                loginCallback.onSuccess(session);
                            }
                        });
                        return;
                    }
                    return;
                }
                rpcResultFailHit(ABLogRecorderKeys.EventIdActFail);
                CommonUtils.onFailure(loginCallback, ResultCode.create(10010, ""));
            }

            @Override // com.ali.user.open.core.model.RpcRequestCallbackWithCode
            public void onSystemError(String str, RpcResponse rpcResponse) {
                rpcResultFailHit(str);
                RpcPresenter.finishTempActivity(activity);
                if (rpcResponse != null) {
                    CommonUtils.onFailure(loginCallback, rpcResponse.code, rpcResponse.message);
                    return;
                }
                CommonUtils.onFailure(loginCallback, ResultCode.create(10010, ""));
            }
        });
    }

    /* access modifiers changed from: private */
    public static void handleSuccess(final RpcResponse rpcResponse, final Activity activity, final LoginCallback loginCallback) {
        T t = rpcResponse.returnValue;
        final int i = rpcResponse.code;
        String str = TAG;
        SDKLogger.d(str, "asyncExecute code = " + i);
        if (i == 3000) {
            final Session session = null;
            try {
                if (rpcResponse.returnValue != null) {
                    SDKLogger.d(TAG, "asyncExecute returnValue not null ");
                    if (!TbAuthContext.needSession || TextUtils.equals(TbAuthContext.sSceneCode, ABLogRecorderKeys.EventIdActFail)) {
                        session = SessionConvert.convertLoginDataToSeesion(t);
                    } else {
                        ((SessionService) AliMemberSDK.getService(SessionService.class)).refreshWhenLogin("taobao", t);
                        session = ((SessionService) AliMemberSDK.getService(SessionService.class)).getSession();
                    }
                }
                ((MemberExecutorService) AliMemberSDK.getService(MemberExecutorService.class)).postUITask(new Runnable() {
                    /* class com.ali.user.open.tbauth.task.RpcPresenter.AnonymousClass2 */

                    public void run() {
                        RpcPresenter.doWhenResultOk(activity, loginCallback, session);
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (i == 13060) {
            String str2 = t.h5Url;
            String str3 = TAG;
            SDKLogger.d(str3, "asyncExecute doubleCheckUrl = " + str2);
            if (!TextUtils.isEmpty(str2) && activity != null) {
                CallbackContext.setActivity(activity);
                Intent intent = new Intent(activity, TbAuthWebViewActivity.class);
                intent.putExtra("url", str2);
                intent.putExtra("token", t.token);
                intent.putExtra("scene", t.scene);
                TbAuthWebViewActivity.token = t.token;
                TbAuthWebViewActivity.scene = t.scene;
                activity.startActivityForResult(intent, RequestCode.OPEN_DOUBLE_CHECK);
            }
        } else {
            ((MemberExecutorService) AliMemberSDK.getService(MemberExecutorService.class)).postUITask(new Runnable() {
                /* class com.ali.user.open.tbauth.task.RpcPresenter.AnonymousClass3 */

                public void run() {
                    String str = RpcPresenter.TAG;
                    SDKLogger.d(str, "15 : " + rpcResponse.message);
                    Activity activity = activity;
                    LoginCallback loginCallback = loginCallback;
                    RpcPresenter.doWhenResultFail(activity, loginCallback, 15, "login:code " + i + " " + rpcResponse.message);
                }
            });
        }
    }

    public static void loginByIVToken(final Activity activity, int i, String str, String str2, String str3, final LoginCallback loginCallback) {
        RpcRepository.loginByIVToken(i, str, str2, str3, new RpcRequestCallbackWithCode() {
            /* class com.ali.user.open.tbauth.task.RpcPresenter.AnonymousClass4 */

            @Override // com.ali.user.open.core.model.RpcRequestCallbackWithCode
            public void onError(String str, RpcResponse rpcResponse) {
                T t;
                if (!TextUtils.equals("H5", rpcResponse.actionType) || (t = rpcResponse.returnValue) == null) {
                    RpcPresenter.doWhenResultFail2(loginCallback, rpcResponse.code, rpcResponse.message);
                    return;
                }
                T t2 = t;
                String str2 = t2.h5Url;
                String str3 = RpcPresenter.TAG;
                SDKLogger.d(str3, "asyncExecute doubleCheckUrl = " + str2);
                if (TextUtils.isEmpty(str2) || activity == null) {
                    RpcPresenter.doWhenResultFail2(loginCallback, rpcResponse.code, rpcResponse.message);
                    return;
                }
                Intent intent = new Intent(activity, TbAuthWebViewActivity.class);
                intent.putExtra("url", str2);
                intent.putExtra("token", t2.token);
                intent.putExtra("scene", t2.scene);
                TbAuthWebViewActivity.token = t2.token;
                TbAuthWebViewActivity.scene = t2.scene;
                activity.startActivityForResult(intent, RequestCode.OPEN_DOUBLE_CHECK);
            }

            @Override // com.ali.user.open.core.model.RpcRequestCallbackWithCode
            public void onSuccess(RpcResponse rpcResponse) {
                if (rpcResponse == null || rpcResponse.returnValue == null) {
                    LoginCallback loginCallback = loginCallback;
                    ResultCode resultCode = ResultCode.SYSTEM_EXCEPTION;
                    RpcPresenter.doWhenResultFail2(loginCallback, resultCode.code, resultCode.message);
                }
                int i = rpcResponse.code;
                if (i == 3000) {
                    Activity activity = activity;
                    if (activity != null && (activity instanceof TbAuthActivity)) {
                        activity.finish();
                    }
                    if (TbAuthContext.needSession) {
                        ((SessionService) AliMemberSDK.getService(SessionService.class)).refreshWhenLogin("taobao", rpcResponse.returnValue);
                        RpcPresenter.doWhenResultOk2(loginCallback, ((SessionService) AliMemberSDK.getService(SessionService.class)).getSession());
                        return;
                    }
                    RpcPresenter.doWhenResultOk2(loginCallback, SessionConvert.convertLoginDataToSeesion(rpcResponse.returnValue));
                    return;
                }
                RpcPresenter.doWhenResultFail2(loginCallback, i, rpcResponse.message);
            }

            @Override // com.ali.user.open.core.model.RpcRequestCallbackWithCode
            public void onSystemError(String str, RpcResponse rpcResponse) {
                RpcPresenter.doWhenResultFail2(loginCallback, rpcResponse.code, rpcResponse.message);
            }
        });
    }

    public static void loginByRefreshToken(final LoginCallback loginCallback) {
        RpcRepository.loginByRefreshToken(new RpcRequestCallbackWithCode() {
            /* class com.ali.user.open.tbauth.task.RpcPresenter.AnonymousClass7 */

            @Override // com.ali.user.open.core.model.RpcRequestCallbackWithCode
            public void onError(String str, RpcResponse rpcResponse) {
                RpcPresenter.doWhenResultFail3(loginCallback, rpcResponse.code, rpcResponse.message);
            }

            @Override // com.ali.user.open.core.model.RpcRequestCallbackWithCode
            public void onSuccess(final RpcResponse rpcResponse) {
                final int i = rpcResponse.code;
                String str = RpcPresenter.TAG;
                SDKLogger.d(str, "asyncExecute code = " + i);
                if (i == 3000) {
                    final Session session = null;
                    try {
                        T t = rpcResponse.returnValue;
                        if (t != null) {
                            if (TbAuthContext.needSession) {
                                ((SessionService) AliMemberSDK.getService(SessionService.class)).refreshWhenLogin("taobao", rpcResponse.returnValue);
                                session = ((SessionService) AliMemberSDK.getService(SessionService.class)).getSession();
                            } else {
                                session = SessionConvert.convertLoginDataToSeesion(t);
                            }
                        }
                        ((MemberExecutorService) AliMemberSDK.getService(MemberExecutorService.class)).postUITask(new Runnable() {
                            /* class com.ali.user.open.tbauth.task.RpcPresenter.AnonymousClass7.AnonymousClass1 */

                            public void run() {
                                RpcPresenter.doWhenResultOk3(loginCallback, session);
                            }
                        });
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    ((MemberExecutorService) AliMemberSDK.getService(MemberExecutorService.class)).postUITask(new Runnable() {
                        /* class com.ali.user.open.tbauth.task.RpcPresenter.AnonymousClass7.AnonymousClass2 */

                        public void run() {
                            String str = RpcPresenter.TAG;
                            SDKLogger.d(str, "15 : " + rpcResponse.message);
                            LoginCallback loginCallback = loginCallback;
                            RpcPresenter.doWhenResultFail3(loginCallback, 15, "login:code " + i + " " + rpcResponse.message);
                        }
                    });
                }
            }

            @Override // com.ali.user.open.core.model.RpcRequestCallbackWithCode
            public void onSystemError(String str, RpcResponse rpcResponse) {
                RpcPresenter.doWhenResultFail3(loginCallback, rpcResponse.code, rpcResponse.message);
            }
        });
    }

    public static void refreshPageAfterOpenTb(final Activity activity, String str, final LoginCallback loginCallback) {
        RpcRepository.refreshPageAfterOpenTb(str, new RpcRequestCallbackWithCode() {
            /* class com.ali.user.open.tbauth.task.RpcPresenter.AnonymousClass1 */

            @Override // com.ali.user.open.core.model.RpcRequestCallbackWithCode
            public void onError(String str, RpcResponse rpcResponse) {
                HashMap hashMap = new HashMap();
                hashMap.put("code", ABLogRecorderKeys.EventIdActFail);
                hashMap.put(UTConstant.Args.UT_PROPERTY_SUCCESS, UTConstant.Args.UT_SUCCESS_F);
                hashMap.put(UTHitBuilders.UTHitBuilder.FIELD_ARG2, TbAuthContext.traceId);
                ((UserTrackerService) AliMemberSDK.getService(UserTrackerService.class)).send("Page_TaobaoOauth", "Page_TaobaoOauth_Result", hashMap);
                CommonUtils.onFailure(loginCallback, ResultCode.create(10010, rpcResponse.message));
            }

            @Override // com.ali.user.open.core.model.RpcRequestCallbackWithCode
            public void onSuccess(RpcResponse rpcResponse) {
                RpcPresenter.handleSuccess(rpcResponse, activity, loginCallback);
            }

            @Override // com.ali.user.open.core.model.RpcRequestCallbackWithCode
            public void onSystemError(String str, RpcResponse rpcResponse) {
                HashMap hashMap = new HashMap();
                hashMap.put("code", ABLogRecorderKeys.EventIdActFail);
                hashMap.put(UTConstant.Args.UT_PROPERTY_SUCCESS, UTConstant.Args.UT_SUCCESS_F);
                hashMap.put(UTHitBuilders.UTHitBuilder.FIELD_ARG2, TbAuthContext.traceId);
                ((UserTrackerService) AliMemberSDK.getService(UserTrackerService.class)).send("Page_TaobaoOauth", "Page_TaobaoOauth_Result", hashMap);
                CommonUtils.onFailure(loginCallback, ResultCode.create(10010, rpcResponse.message));
            }
        });
    }

    static void saveDeviceToken(ConvertAuthCodeToAccessTokenData convertAuthCodeToAccessTokenData) {
        if (convertAuthCodeToAccessTokenData != null && convertAuthCodeToAccessTokenData.deviceToken != null) {
            DeviceTokenAccount deviceTokenAccount = new DeviceTokenAccount();
            deviceTokenAccount.site = "taobao";
            deviceTokenAccount.tokenKey = convertAuthCodeToAccessTokenData.deviceToken.key;
            deviceTokenAccount.openId = convertAuthCodeToAccessTokenData.openId;
            deviceTokenAccount.hid = convertAuthCodeToAccessTokenData.hid;
            DeviceTokenManager.getInstance().putDeviceToken(deviceTokenAccount, convertAuthCodeToAccessTokenData.deviceToken.salt);
        }
    }

    public static void validataAuthCode(String str, String str2, String str3, final LoginCallback loginCallback) {
        RpcRepository.validateAuthCode(str, str2, str3, new RpcRequestCallbackWithCode() {
            /* class com.ali.user.open.tbauth.task.RpcPresenter.AnonymousClass9 */

            @Override // com.ali.user.open.core.model.RpcRequestCallbackWithCode
            public void onError(String str, RpcResponse rpcResponse) {
                CommonUtils.onFailure(loginCallback, rpcResponse.code, rpcResponse.message);
            }

            @Override // com.ali.user.open.core.model.RpcRequestCallbackWithCode
            public void onSuccess(RpcResponse rpcResponse) {
                if (ResultCode.SUCCESS.message.equals(rpcResponse.actionType)) {
                    final T t = rpcResponse.returnValue;
                    if (t != null) {
                        RpcPresenter.saveDeviceToken(t);
                        ((MemberExecutorService) AliMemberSDK.getService(MemberExecutorService.class)).postUITask(new Runnable() {
                            /* class com.ali.user.open.tbauth.task.RpcPresenter.AnonymousClass9.AnonymousClass1 */

                            public void run() {
                                Session session = new Session();
                                ConvertAuthCodeToAccessTokenData convertAuthCodeToAccessTokenData = t;
                                session.openId = convertAuthCodeToAccessTokenData.openId;
                                session.bindToken = convertAuthCodeToAccessTokenData.bindToken;
                                session.topAccessToken = convertAuthCodeToAccessTokenData.accessToken;
                                session.topAuthCode = convertAuthCodeToAccessTokenData.authCode;
                                session.hid = convertAuthCodeToAccessTokenData.hid;
                                loginCallback.onSuccess(session);
                            }
                        });
                        return;
                    }
                    return;
                }
                CommonUtils.onFailure(loginCallback, ResultCode.create(10010, ""));
            }

            @Override // com.ali.user.open.core.model.RpcRequestCallbackWithCode
            public void onSystemError(String str, RpcResponse rpcResponse) {
                CommonUtils.onFailure(loginCallback, rpcResponse.code, rpcResponse.message);
            }
        });
    }
}
