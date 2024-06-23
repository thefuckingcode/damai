package com.ali.user.open.ucc.biz;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.ali.user.open.core.AliMemberSDK;
import com.ali.user.open.core.Site;
import com.ali.user.open.core.callback.CallbackManager;
import com.ali.user.open.core.context.KernelContext;
import com.ali.user.open.core.model.ResultCode;
import com.ali.user.open.core.model.RpcRequestCallbackWithCode;
import com.ali.user.open.core.model.RpcResponse;
import com.ali.user.open.core.util.DialogHelper;
import com.ali.user.open.core.util.ParamsConstants;
import com.ali.user.open.ucc.R;
import com.ali.user.open.ucc.UccCallback;
import com.ali.user.open.ucc.UccServiceImpl;
import com.ali.user.open.ucc.UccServiceProviderFactory;
import com.ali.user.open.ucc.context.UccContext;
import com.ali.user.open.ucc.data.DataRepository;
import com.ali.user.open.ucc.model.UccParams;
import com.ali.user.open.ucc.remote.broadcast.UccBroadcastHelper;
import com.ali.user.open.ucc.remote.broadcast.UccResultAction;
import com.ali.user.open.ucc.util.UTHitConstants;
import com.ali.user.open.ucc.util.UTHitUtils;
import com.ali.user.open.ucc.util.UccConstants;
import com.ali.user.open.ucc.util.Utils;
import com.ali.user.open.ucc.webview.UccWebViewActivity;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.taobao.android.sns4android.jsbridge.SNSJsbridge;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
public class UccTrustLoginPresenter {
    private static volatile UccTrustLoginPresenter instance;

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void finishActivity(Context context) {
        if (context != null && (context instanceof UccWebViewActivity)) {
            ((Activity) context).finish();
            CallbackManager.unregisterCallback(UccConstants.UCC_H5_CALLBACK_TYPE);
        }
    }

    public static UccTrustLoginPresenter getInstance() {
        if (instance == null) {
            synchronized (UccTrustLoginPresenter.class) {
                if (instance == null) {
                    instance = new UccTrustLoginPresenter();
                }
            }
        }
        return instance;
    }

    public static void loginByIVToken(final Activity activity, final UccParams uccParams, Map<String, String> map, final String str, String str2, String str3, final UccCallback uccCallback) {
        int havanaSite = Site.getHavanaSite(uccParams.bindSite);
        final boolean isCookieOnly = UccOauthLoginPresenter.isCookieOnly(map);
        DataRepository.loginByIVToken(havanaSite, str, str2, str3, new RpcRequestCallbackWithCode() {
            /* class com.ali.user.open.ucc.biz.UccTrustLoginPresenter.AnonymousClass3 */

            private void rpcResultHit(String str) {
                HashMap hashMap = new HashMap();
                hashMap.put("code", "" + str);
                hashMap.put("token", str);
                UTHitUtils.send(UTHitConstants.PageUccLogin, "UccLogin_TokenLoginResult", uccParams, hashMap);
            }

            @Override // com.ali.user.open.core.model.RpcRequestCallbackWithCode
            public void onError(String str, RpcResponse rpcResponse) {
                T t;
                rpcResultHit(str + "");
                if (!TextUtils.equals("H5", rpcResponse.actionType) || (t = rpcResponse.returnValue) == null) {
                    Activity activity = activity;
                    if (activity != null && (activity instanceof UccWebViewActivity)) {
                        activity.finish();
                    }
                    uccCallback.onFail(uccParams.bindSite, rpcResponse.code, rpcResponse.message);
                    return;
                }
                JSONObject parseObject = JSON.parseObject(t);
                if (parseObject == null || activity == null) {
                    Activity activity2 = activity;
                    if (activity2 != null && (activity2 instanceof UccWebViewActivity)) {
                        activity2.finish();
                    }
                    uccCallback.onFail(uccParams.bindSite, rpcResponse.code, rpcResponse.message);
                    return;
                }
                String string = parseObject.getString(ParamsConstants.Key.PARAM_H5URL);
                Bundle bundle = new Bundle();
                bundle.putString("url", string);
                bundle.putString("token", parseObject.getString("token"));
                bundle.putString("scene", parseObject.getString("scene"));
                bundle.putString(UccConstants.PARAM_UCC_PARAMS, JSON.toJSONString(uccParams));
                bundle.putString("needSession", "1");
                UccH5Presenter.openUrl(activity, bundle, uccCallback);
            }

            @Override // com.ali.user.open.core.model.RpcRequestCallbackWithCode
            public void onSuccess(RpcResponse rpcResponse) {
                if (rpcResponse == null || rpcResponse.returnValue == null) {
                    UccCallback uccCallback = uccCallback;
                    String str = uccParams.bindSite;
                    ResultCode resultCode = ResultCode.SYSTEM_EXCEPTION;
                    uccCallback.onFail(str, resultCode.code, resultCode.message);
                }
                int i = rpcResponse.code;
                if (i == 3000) {
                    rpcResultHit("3000");
                    Activity activity = activity;
                    if (activity != null && (activity instanceof UccWebViewActivity)) {
                        activity.finish();
                    }
                    T t = rpcResponse.returnValue;
                    UccServiceProviderFactory.getInstance().getUccServiceProvider(uccParams.bindSite).refreshWhenLogin(uccParams.bindSite, t, isCookieOnly);
                    HashMap hashMap = new HashMap();
                    hashMap.put(UccConstants.PARAM_LOGIN_DATA, t);
                    uccCallback.onSuccess(uccParams.bindSite, hashMap);
                    return;
                }
                uccCallback.onFail(uccParams.bindSite, i, rpcResponse.message);
            }

            @Override // com.ali.user.open.core.model.RpcRequestCallbackWithCode
            public void onSystemError(String str, RpcResponse rpcResponse) {
                rpcResultHit(str + "");
                uccCallback.onFail(uccParams.bindSite, rpcResponse.code, rpcResponse.message);
                Activity activity = activity;
                if (activity != null && (activity instanceof UccWebViewActivity)) {
                    activity.finish();
                }
            }
        });
    }

    public void doTrustLogin(final Activity activity, final UccParams uccParams, final String str, final Map<String, String> map, final UccCallback uccCallback) {
        UccContext.startTrustLoginTime = System.currentTimeMillis();
        DataRepository.trustLogin(uccParams, map, new RpcRequestCallbackWithCode() {
            /* class com.ali.user.open.ucc.biz.UccTrustLoginPresenter.AnonymousClass1 */

            private void rpcResultHit(String str, String str2, String str3) {
                HashMap hashMap = new HashMap();
                hashMap.put("code", str);
                hashMap.put("actionType", str2);
                hashMap.put("h5Type", str3);
                UTHitUtils.send(UTHitConstants.PageUccLogin, "UccLogin_Result", uccParams, hashMap);
            }

            @Override // com.ali.user.open.core.model.RpcRequestCallbackWithCode
            public void onError(String str, RpcResponse rpcResponse) {
                T t;
                String str2;
                Map map = map;
                boolean z = false;
                boolean z2 = map == null || !TextUtils.equals((CharSequence) map.get(ParamsConstants.Key.PARAM_NEED_UI), "0");
                int buidErrorCode = Utils.buidErrorCode(rpcResponse, 1005);
                String str3 = "1";
                String str4 = "";
                if (z2 && TextUtils.equals("NEED_BIND", rpcResponse.actionType)) {
                    rpcResultHit(buidErrorCode + str4, rpcResponse.actionType, str4);
                    T t2 = rpcResponse.returnValue;
                    Map map2 = map;
                    if (map2 != null && "0".equals(map2.get(ParamsConstants.Key.PARAM_NEED_BIND))) {
                        z = true;
                    }
                    if ((!Site.ICBU.equals(str) || !Site.DING.equals(AliMemberSDK.getMasterSite())) && !z) {
                        JSONObject parseObject = JSON.parseObject(t2);
                        if (parseObject != null) {
                            str4 = parseObject.getString(ParamsConstants.Key.PARAM_H5URL);
                            str2 = parseObject.getString("h5Type");
                        } else {
                            str2 = str4;
                        }
                        Map<String, String> map3 = map;
                        if (map3 == null) {
                            map3 = new HashMap<>();
                        }
                        if (!TextUtils.isEmpty(str4)) {
                            map3.put(UccConstants.PARAM_BIND_URL, str4);
                        }
                        map3.put("needSession", str3);
                        if (!UccOauthLoginPresenter.isCookieOnly(map)) {
                            str3 = "0";
                        }
                        map3.put(ParamsConstants.Key.PARAM_NEED_LOCAL_COOKIE_ONLY, str3);
                        map3.put(ParamsConstants.Key.PARAM_NEED_TOAST, "0");
                        map3.put("h5Type", str2);
                        UccServiceImpl.getInstance().bind(activity, uccParams.userToken, str, map3, uccCallback);
                        return;
                    }
                    UccCallback uccCallback = uccCallback;
                    if (uccCallback != null) {
                        uccCallback.onFail(str, rpcResponse.code, rpcResponse.message);
                    }
                } else if (!z2 || !TextUtils.equals("H5", rpcResponse.actionType) || (t = rpcResponse.returnValue) == null) {
                    rpcResultHit(buidErrorCode + str4, rpcResponse == null ? str4 : rpcResponse.actionType, str4);
                    UccCallback uccCallback2 = uccCallback;
                    if (uccCallback2 != null) {
                        uccCallback2.onFail(str, buidErrorCode, Utils.buidErrorMessage(rpcResponse, SNSJsbridge.TAOBAO_ERROR_MESSAGE));
                    }
                } else {
                    JSONObject parseObject2 = JSON.parseObject(t);
                    if (parseObject2 != null) {
                        String string = parseObject2.getString(ParamsConstants.Key.PARAM_H5URL);
                        String string2 = parseObject2.getString("token");
                        String string3 = parseObject2.getString("scene");
                        String string4 = parseObject2.getString("h5Type");
                        Bundle bundle = new Bundle();
                        bundle.putString("url", string);
                        bundle.putString(UccConstants.PARAM_UCC_PARAMS, JSON.toJSONString(uccParams));
                        bundle.putString("needSession", str3);
                        bundle.putString("token", string2);
                        bundle.putString("scene", string3);
                        bundle.putString("params", Utils.convertMapToJsonStr(map));
                        UccH5Presenter.openUrl(activity, bundle, uccCallback);
                        rpcResultHit(buidErrorCode + str4, rpcResponse.actionType, string4);
                        return;
                    }
                    rpcResultHit(buidErrorCode + str4, rpcResponse.actionType, str4);
                    UccCallback uccCallback3 = uccCallback;
                    if (uccCallback3 != null) {
                        uccCallback3.onFail(str, buidErrorCode, Utils.buidErrorMessage(rpcResponse, SNSJsbridge.TAOBAO_ERROR_MESSAGE));
                    }
                }
            }

            @Override // com.ali.user.open.core.model.RpcRequestCallbackWithCode
            public void onSuccess(RpcResponse rpcResponse) {
                if (rpcResponse != null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(rpcResponse.code);
                    String str = "";
                    sb.append(str);
                    rpcResultHit(sb.toString(), rpcResponse.actionType, str);
                    if (rpcResponse.code == 3000 || TextUtils.equals("SUCCESS", rpcResponse.actionType)) {
                        UccBizContants.mBusyControlMap.put(str, Long.valueOf(System.currentTimeMillis()));
                        boolean isCookieOnly = UccOauthLoginPresenter.isCookieOnly(map);
                        T t = rpcResponse.returnValue;
                        String string = JSON.parseObject(t).getString("authorizationResponse");
                        if (!TextUtils.isEmpty(string)) {
                            UccServiceProviderFactory.getInstance().getUccServiceProvider(str).refreshWhenLogin(str, string, isCookieOnly);
                        } else {
                            UccServiceProviderFactory.getInstance().getUccServiceProvider(str).refreshWhenLogin(str, t, isCookieOnly);
                        }
                        Intent intent = new Intent();
                        intent.setAction(UccResultAction.NOTIFY_UCC_LOGIN_SUCCESS.name());
                        intent.setPackage(KernelContext.getApplicationContext().getPackageName());
                        Map map = map;
                        if (map != null) {
                            str = (String) map.get("process");
                        }
                        intent.putExtra("process", str);
                        intent.putExtra("site", str);
                        UccBroadcastHelper.sendBroadcast(intent);
                        if (uccCallback != null) {
                            HashMap hashMap = new HashMap();
                            if (!TextUtils.isEmpty(string)) {
                                hashMap.put(UccConstants.PARAM_LOGIN_DATA, string);
                            } else {
                                hashMap.put(UccConstants.PARAM_LOGIN_DATA, t);
                            }
                            uccCallback.onSuccess(str, hashMap);
                            return;
                        }
                        return;
                    }
                    rpcResultHit(rpcResponse.code + str, str, str);
                    UccCallback uccCallback = uccCallback;
                    if (uccCallback != null) {
                        uccCallback.onFail(str, rpcResponse.code, Utils.buidErrorMessage(rpcResponse, "免登response为空"));
                    }
                }
            }

            @Override // com.ali.user.open.core.model.RpcRequestCallbackWithCode
            public void onSystemError(String str, RpcResponse rpcResponse) {
                int buidErrorCode = Utils.buidErrorCode(rpcResponse, 1005);
                rpcResultHit(buidErrorCode + "", rpcResponse == null ? "" : rpcResponse.actionType, "");
                Integer num = UccBizContants.mTrustLoginErrorTime.get(str);
                if (num == null) {
                    num = 0;
                }
                UccBizContants.mTrustLoginErrorTime.put(str, Integer.valueOf(num.intValue() + 1));
                UccCallback uccCallback = uccCallback;
                if (uccCallback != null) {
                    uccCallback.onFail(str, buidErrorCode, Utils.buidErrorMessage(rpcResponse, SNSJsbridge.TAOBAO_ERROR_MESSAGE));
                }
            }
        });
    }

    public void tokenLogin(Activity activity, UccParams uccParams, String str, String str2, String str3, Map<String, String> map, UccCallback uccCallback) {
        HashMap hashMap = new HashMap();
        hashMap.put("token", str2);
        UTHitUtils.send(UTHitConstants.PageUccLogin, "UccLogin_TokenLogin", uccParams, hashMap);
        loginByIVToken(activity, uccParams, map, str2, str, str3, uccCallback);
    }

    public void upgradeLogin(final Activity activity, UccParams uccParams, final String str, String str2, String str3, final String str4, final Map<String, String> map, final UccCallback uccCallback) {
        HashMap hashMap = new HashMap();
        hashMap.put("type", str4);
        hashMap.put("scene", str2);
        hashMap.put("requestToken", str3);
        UTHitUtils.send(UTHitConstants.PageUccBind, "UccLogin_UpgradeAccount", uccParams, hashMap);
        DataRepository.upgrade(uccParams, str2, str3, new RpcRequestCallbackWithCode() {
            /* class com.ali.user.open.ucc.biz.UccTrustLoginPresenter.AnonymousClass2 */

            private void rpcResultHit(String str, String str2, String str3) {
                HashMap hashMap = new HashMap();
                hashMap.put("code", str);
                hashMap.put("actionType", str2);
                hashMap.put("h5Type", str3);
                UTHitUtils.send(UTHitConstants.PageUccBind, "UccLogin_UpgradeAccountResult", null, hashMap);
            }

            @Override // com.ali.user.open.core.model.RpcRequestCallbackWithCode
            public void onError(String str, RpcResponse rpcResponse) {
                int buidErrorCode = Utils.buidErrorCode(rpcResponse, 1500);
                StringBuilder sb = new StringBuilder();
                sb.append(buidErrorCode);
                String str2 = "";
                sb.append(str2);
                rpcResultHit(sb.toString(), str2, str2);
                if (TextUtils.equals(str4, "h5")) {
                    if (rpcResponse != null) {
                        str2 = rpcResponse.message;
                    }
                    DialogHelper instance = DialogHelper.getInstance();
                    Activity activity = activity;
                    instance.alert(activity, "", str2, activity.getString(R.string.member_sdk_iknow), new DialogInterface.OnClickListener() {
                        /* class com.ali.user.open.ucc.biz.UccTrustLoginPresenter.AnonymousClass2.AnonymousClass1 */

                        public void onClick(DialogInterface dialogInterface, int i) {
                        }
                    }, "", null);
                    return;
                }
                UccTrustLoginPresenter.this.finishActivity(activity);
                UccCallback uccCallback = uccCallback;
                if (uccCallback != null) {
                    uccCallback.onFail(str, buidErrorCode, Utils.buidErrorMessage(rpcResponse, "OauthLogin接口错误"));
                }
            }

            @Override // com.ali.user.open.core.model.RpcRequestCallbackWithCode
            public void onSuccess(RpcResponse rpcResponse) {
                T t;
                if (rpcResponse != null) {
                    rpcResultHit(rpcResponse.code + "", rpcResponse.actionType, "");
                    if (rpcResponse.code == 3000 || TextUtils.equals("SUCCESS", rpcResponse.actionType)) {
                        UccBizContants.mBusyControlMap.put(str, Long.valueOf(System.currentTimeMillis()));
                        T t2 = rpcResponse.returnValue;
                        boolean z = true;
                        Map map = map;
                        if (map != null && TextUtils.equals((CharSequence) map.get(ParamsConstants.Key.PARAM_NEED_LOCAL_SESSION), "0")) {
                            z = false;
                        }
                        if (!TextUtils.isEmpty(t2) && z) {
                            UccServiceProviderFactory.getInstance().getUccServiceProvider(str).refreshWhenLogin(str, t2, UccOauthLoginPresenter.isCookieOnly(map));
                        }
                        UccTrustLoginPresenter.this.finishActivity(activity);
                        if (uccCallback != null) {
                            Map<String, String> buildSessionInfo = UccBindPresenter.buildSessionInfo(str, t2);
                            String string = JSON.parseObject(t2).getString("authorizationResponse");
                            if (TextUtils.isEmpty(string)) {
                                buildSessionInfo.put(UccConstants.PARAM_LOGIN_DATA, t2);
                            } else {
                                buildSessionInfo.put(UccConstants.PARAM_LOGIN_DATA, string);
                            }
                            uccCallback.onSuccess(str, buildSessionInfo);
                        }
                    } else if (!TextUtils.equals("H5", rpcResponse.actionType) || (t = rpcResponse.returnValue) == null) {
                        rpcResultHit(rpcResponse.code + "", "", "");
                        UccCallback uccCallback = uccCallback;
                        if (uccCallback != null) {
                            uccCallback.onFail(str, rpcResponse.code, Utils.buidErrorMessage(rpcResponse, "免登response为空"));
                        }
                    } else {
                        JSONObject parseObject = JSON.parseObject(t);
                        if (parseObject != null) {
                            String string2 = parseObject.getString(ParamsConstants.Key.PARAM_H5URL);
                            Bundle bundle = new Bundle();
                            bundle.putString("url", string2);
                            bundle.putString("token", parseObject.getString("token"));
                            bundle.putString("scene", parseObject.getString("scene"));
                            bundle.putString(UccConstants.PARAM_UCC_PARAMS, JSON.toJSONString(new UccParams()));
                            bundle.putString("needSession", "1");
                            UccH5Presenter.openUrl(activity, bundle, uccCallback);
                            Activity activity = activity;
                            if (activity != null && !(activity instanceof UccWebViewActivity)) {
                                activity.finish();
                                return;
                            }
                            return;
                        }
                        UccTrustLoginPresenter.this.finishActivity(activity);
                        UccCallback uccCallback2 = uccCallback;
                        if (uccCallback2 != null) {
                            uccCallback2.onFail(str, 1500, Utils.buidErrorMessage(rpcResponse, SNSJsbridge.TAOBAO_ERROR_MESSAGE));
                        }
                    }
                }
            }

            @Override // com.ali.user.open.core.model.RpcRequestCallbackWithCode
            public void onSystemError(String str, RpcResponse rpcResponse) {
                int buidErrorCode = Utils.buidErrorCode(rpcResponse, 1500);
                rpcResultHit(buidErrorCode + "", "", "");
            }
        });
    }

    public void userGrowLogin(final Activity activity, final UccParams uccParams, @Site.SiteName final String str, final Map<String, String> map, final UccCallback uccCallback) {
        DataRepository.userGrowLogin(uccParams.requestToken, new RpcRequestCallbackWithCode() {
            /* class com.ali.user.open.ucc.biz.UccTrustLoginPresenter.AnonymousClass4 */

            private void rpcResultHit(String str, String str2, String str3) {
                HashMap hashMap = new HashMap();
                hashMap.put("code", str);
                hashMap.put("actionType", str2);
                hashMap.put("h5Type", str3);
                UTHitUtils.send(UTHitConstants.PageUccLogin, "UccLogin_Result", uccParams, hashMap);
            }

            @Override // com.ali.user.open.core.model.RpcRequestCallbackWithCode
            public void onError(String str, RpcResponse rpcResponse) {
                T t;
                int buidErrorCode = Utils.buidErrorCode(rpcResponse, 1005);
                if (!TextUtils.equals("H5", rpcResponse.actionType) || (t = rpcResponse.returnValue) == null) {
                    rpcResultHit(buidErrorCode + "", rpcResponse.actionType, "");
                    UccCallback uccCallback = uccCallback;
                    if (uccCallback != null) {
                        uccCallback.onFail(str, buidErrorCode, Utils.buidErrorMessage(rpcResponse, SNSJsbridge.TAOBAO_ERROR_MESSAGE));
                        return;
                    }
                    return;
                }
                T t2 = t;
                JSONObject parseObject = JSON.parseObject(t2);
                if (parseObject != null) {
                    String string = parseObject.getString(ParamsConstants.Key.PARAM_H5URL);
                    if (!TextUtils.isEmpty(string)) {
                        String string2 = parseObject.getString("token");
                        String string3 = parseObject.getString("scene");
                        String string4 = parseObject.getString("h5Type");
                        Bundle bundle = new Bundle();
                        bundle.putString("url", string);
                        bundle.putString(UccConstants.PARAM_UCC_PARAMS, JSON.toJSONString(uccParams));
                        bundle.putString("needSession", "1");
                        bundle.putString("token", string2);
                        bundle.putString("scene", string3);
                        bundle.putString("params", Utils.convertMapToJsonStr(map));
                        UccH5Presenter.openUrl(activity, bundle, uccCallback);
                        rpcResultHit(buidErrorCode + "", rpcResponse.actionType, string4);
                    } else if (!TextUtils.isEmpty(parseObject.getString("returnUrl"))) {
                        UccCallback uccCallback2 = uccCallback;
                        if (uccCallback2 != null) {
                            uccCallback2.onFail(str, 3000, t2);
                        }
                    } else {
                        UccCallback uccCallback3 = uccCallback;
                        if (uccCallback3 != null) {
                            uccCallback3.onFail(str, buidErrorCode, Utils.buidErrorMessage(rpcResponse, SNSJsbridge.TAOBAO_ERROR_MESSAGE));
                        }
                    }
                } else {
                    rpcResultHit(buidErrorCode + "", rpcResponse.actionType, "");
                    UccCallback uccCallback4 = uccCallback;
                    if (uccCallback4 != null) {
                        uccCallback4.onFail(str, buidErrorCode, Utils.buidErrorMessage(rpcResponse, SNSJsbridge.TAOBAO_ERROR_MESSAGE));
                    }
                }
            }

            @Override // com.ali.user.open.core.model.RpcRequestCallbackWithCode
            public void onSuccess(RpcResponse rpcResponse) {
                if (rpcResponse != null) {
                    rpcResultHit(rpcResponse.code + "", rpcResponse.actionType, "");
                    if (rpcResponse.code == 3000 || TextUtils.equals("SUCCESS", rpcResponse.actionType)) {
                        UccBizContants.mBusyControlMap.put(str, Long.valueOf(System.currentTimeMillis()));
                        boolean isCookieOnly = UccOauthLoginPresenter.isCookieOnly(map);
                        T t = rpcResponse.returnValue;
                        JSONObject parseObject = JSON.parseObject(t);
                        String string = parseObject.getString("authorizationResponse");
                        if (!TextUtils.isEmpty(string)) {
                            UccServiceProviderFactory.getInstance().getUccServiceProvider(str).refreshWhenLogin(str, string, isCookieOnly);
                        } else {
                            UccServiceProviderFactory.getInstance().getUccServiceProvider(str).refreshWhenLogin(str, t, isCookieOnly);
                        }
                        if (uccCallback != null) {
                            HashMap hashMap = new HashMap();
                            if (!TextUtils.isEmpty(string)) {
                                hashMap.put(UccConstants.PARAM_LOGIN_DATA, string);
                            } else {
                                hashMap.put(UccConstants.PARAM_LOGIN_DATA, t);
                            }
                            hashMap.put("callbackUrl", parseObject.getString("callbackUrl"));
                            uccCallback.onSuccess(str, hashMap);
                            return;
                        }
                        return;
                    }
                    rpcResultHit(rpcResponse.code + "", "", "");
                    UccCallback uccCallback = uccCallback;
                    if (uccCallback != null) {
                        uccCallback.onFail(str, rpcResponse.code, Utils.buidErrorMessage(rpcResponse, "免登response为空"));
                    }
                }
            }

            @Override // com.ali.user.open.core.model.RpcRequestCallbackWithCode
            public void onSystemError(String str, RpcResponse rpcResponse) {
                int buidErrorCode = Utils.buidErrorCode(rpcResponse, 1005);
                rpcResultHit(buidErrorCode + "", rpcResponse == null ? "" : rpcResponse.actionType, "");
                Integer num = UccBizContants.mTrustLoginErrorTime.get(str);
                if (num == null) {
                    num = 0;
                }
                UccBizContants.mTrustLoginErrorTime.put(str, Integer.valueOf(num.intValue() + 1));
                UccCallback uccCallback = uccCallback;
                if (uccCallback != null) {
                    uccCallback.onFail(str, buidErrorCode, Utils.buidErrorMessage(rpcResponse, SNSJsbridge.TAOBAO_ERROR_MESSAGE));
                }
            }
        });
    }
}
