package com.ali.user.open.ucc.biz;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;
import com.ali.user.mobile.app.constant.UTConstant;
import com.ali.user.mobile.rpc.ApiConstants;
import com.ali.user.open.core.AliMemberSDK;
import com.ali.user.open.core.callback.CallbackManager;
import com.ali.user.open.core.context.KernelContext;
import com.ali.user.open.core.model.RpcRequestCallbackWithCode;
import com.ali.user.open.core.model.RpcResponse;
import com.ali.user.open.core.service.MemberExecutorService;
import com.ali.user.open.core.util.DialogHelper;
import com.ali.user.open.core.util.ParamsConstants;
import com.ali.user.open.core.util.ToastUtil;
import com.ali.user.open.ucc.R;
import com.ali.user.open.ucc.UccCallback;
import com.ali.user.open.ucc.UccServiceProvider;
import com.ali.user.open.ucc.UccServiceProviderFactory;
import com.ali.user.open.ucc.data.DataRepository;
import com.ali.user.open.ucc.model.BindResult;
import com.ali.user.open.ucc.model.UccParams;
import com.ali.user.open.ucc.remote.broadcast.UccBroadcastHelper;
import com.ali.user.open.ucc.remote.broadcast.UccResultAction;
import com.ali.user.open.ucc.ui.UccActivity;
import com.ali.user.open.ucc.util.UTHitConstants;
import com.ali.user.open.ucc.util.UTHitUtils;
import com.ali.user.open.ucc.util.UccConstants;
import com.ali.user.open.ucc.util.Utils;
import com.ali.user.open.ucc.webview.UccWebViewActivity;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.taobao.android.sns4android.jsbridge.SNSJsbridge;
import com.taobao.orange.OrangeConfig;
import com.taobao.tao.remotebusiness.js.MtopJSBridge;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
public class UccBindPresenter {
    public static final String TAG = "TaobaoUccServiceProviderImpl";
    private static volatile UccBindPresenter instance;

    /* compiled from: Taobao */
    private class BindRpcRequestCallback implements RpcRequestCallbackWithCode {
        private Map<String, String> bizParams;
        private int bizType;
        private Activity context;
        private String needToast;
        private int type;
        private UccCallback uccCallback;
        private UccParams uccParams;

        public BindRpcRequestCallback(Activity activity, int i, int i2, UccParams uccParams2, String str, Map<String, String> map, UccCallback uccCallback2) {
            this.context = activity;
            this.uccParams = uccParams2;
            this.uccCallback = uccCallback2;
            this.needToast = str;
            this.type = i;
            this.bizType = i2;
            this.bizParams = map;
        }

        private void rpcResultlHit(String str, String str2) {
            HashMap hashMap = new HashMap();
            hashMap.put("code", str);
            hashMap.put("bindUserToken", this.uccParams.bindUserToken);
            hashMap.put("actionType", str2);
            if (this.type == 1) {
                hashMap.put("bizToken", this.uccParams.requestToken);
                UTHitUtils.send(UTHitConstants.PageUccBind, "UccBind_RecommendBindResult", this.uccParams, hashMap);
            } else if (!TextUtils.isEmpty(this.uccParams.ivToken)) {
                hashMap.put("bizToken", this.uccParams.ivToken);
                UTHitUtils.send(UTHitConstants.PageUccBind, "UccBind_BindIdentifyResult_IV", this.uccParams, hashMap);
            } else if (!TextUtils.isEmpty(this.uccParams.requestToken)) {
                hashMap.put("bizToken", this.uccParams.requestToken);
                UTHitUtils.send(UTHitConstants.PageUccBind, "UccBind_BindIdentifyResult_oauthLogin", this.uccParams, hashMap);
            }
        }

        @Override // com.ali.user.open.core.model.RpcRequestCallbackWithCode
        public void onError(String str, final RpcResponse rpcResponse) {
            UccBindPresenter.dismissProgress(this.context);
            final int buidErrorCode = Utils.buidErrorCode(rpcResponse, 1007);
            rpcResultlHit(buidErrorCode + "", "");
            if (TextUtils.equals(this.needToast, "1")) {
                DialogHelper.getInstance().alert(this.context, "", Utils.buidErrorMessage(rpcResponse, "绑定失败"), this.context.getString(R.string.member_sdk_iknow), new DialogInterface.OnClickListener() {
                    /* class com.ali.user.open.ucc.biz.UccBindPresenter.BindRpcRequestCallback.AnonymousClass2 */

                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (BindRpcRequestCallback.this.bizType == 1) {
                            BindRpcRequestCallback bindRpcRequestCallback = BindRpcRequestCallback.this;
                            UccBindPresenter.this.finishActivity(bindRpcRequestCallback.context);
                            if (BindRpcRequestCallback.this.uccCallback != null) {
                                BindRpcRequestCallback.this.uccCallback.onFail(BindRpcRequestCallback.this.uccParams.bindSite, buidErrorCode, Utils.buidErrorMessage(rpcResponse, "绑定失败"));
                            }
                        }
                    }
                }, "", null);
            } else if (this.bizType == 1) {
                UccBindPresenter.this.finishActivity(this.context);
                UccCallback uccCallback2 = this.uccCallback;
                if (uccCallback2 != null) {
                    uccCallback2.onFail(this.uccParams.bindSite, buidErrorCode, Utils.buidErrorMessage(rpcResponse, "绑定失败"));
                }
            } else {
                ((MemberExecutorService) AliMemberSDK.getService(MemberExecutorService.class)).postUITask(new Runnable() {
                    /* class com.ali.user.open.ucc.biz.UccBindPresenter.BindRpcRequestCallback.AnonymousClass3 */

                    public void run() {
                        try {
                            ToastUtil.showToast(BindRpcRequestCallback.this.context.getApplicationContext(), Utils.buidErrorMessage(rpcResponse, "绑定失败"), 0);
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                });
            }
        }

        @Override // com.ali.user.open.core.model.RpcRequestCallbackWithCode
        public void onSuccess(final RpcResponse rpcResponse) {
            UccBindPresenter.dismissProgress(this.context);
            rpcResultlHit(rpcResponse.code + "", rpcResponse.actionType);
            T t = rpcResponse.returnValue;
            if (TextUtils.equals("CHANGEBIND", rpcResponse.actionType)) {
                UccBindPresenter.this.changeBind(this.context, this.uccParams, this.bizType, rpcResponse.message, ((BindResult) JSON.parseObject(t, BindResult.class)).changeBindToken, this.needToast, this.bizParams, this.uccCallback);
            } else if (TextUtils.equals("CONFLICTUPGRADE", rpcResponse.actionType)) {
                UccBindPresenter.this.conflictupgrade(this.context, this.uccParams, 0, rpcResponse.message, ((BindResult) JSON.parseObject(t, BindResult.class)).requestToken, "0", this.bizParams, this.uccCallback);
            } else if (!TextUtils.equals("H5", rpcResponse.actionType) || rpcResponse.returnValue == null) {
                HashMap hashMap = new HashMap();
                hashMap.put(MtopJSBridge.MtopJSParam.NEED_LOGIN, (TextUtils.isEmpty(t) || t.length() < 10) ? UTConstant.Args.UT_SUCCESS_F : "T");
                UTHitUtils.send(UTHitConstants.PageUccBind, "UccBind_Success", this.uccParams, hashMap);
                if (this.context != null && !TextUtils.isEmpty(rpcResponse.message) && TextUtils.equals(this.needToast, "1")) {
                    ((MemberExecutorService) AliMemberSDK.getService(MemberExecutorService.class)).postUITask(new Runnable() {
                        /* class com.ali.user.open.ucc.biz.UccBindPresenter.BindRpcRequestCallback.AnonymousClass1 */

                        public void run() {
                            Toast.makeText(BindRpcRequestCallback.this.context.getApplicationContext(), rpcResponse.message, 0).show();
                        }
                    });
                }
                UccBindPresenter.this.finishActivity(this.context);
                UccBindPresenter.this.onBindSuccess(this.uccParams, this.bizParams, t, this.uccCallback);
            } else {
                JSONObject parseObject = JSON.parseObject(t);
                if (parseObject != null) {
                    String string = parseObject.getString("returnUrl");
                    Bundle bundle = new Bundle();
                    bundle.putString("url", string);
                    bundle.putString("token", parseObject.getString("trustLoginToken"));
                    bundle.putString("scene", parseObject.getString("scene"));
                    bundle.putString(UccConstants.PARAM_UCC_PARAMS, JSON.toJSONString(this.uccParams));
                    bundle.putString("needSession", "1");
                    bundle.putString("params", Utils.convertMapToJsonStr(this.bizParams));
                    UccH5Presenter.openUrl(this.context, bundle, this.uccCallback);
                    Activity activity = this.context;
                    if (activity != null && !(activity instanceof UccWebViewActivity)) {
                        activity.finish();
                        return;
                    }
                    return;
                }
                UccBindPresenter.this.finishActivity(this.context);
                UccCallback uccCallback2 = this.uccCallback;
                if (uccCallback2 != null) {
                    uccCallback2.onFail(this.uccParams.bindSite, 1005, Utils.buidErrorMessage(rpcResponse, SNSJsbridge.TAOBAO_ERROR_MESSAGE));
                }
            }
        }

        @Override // com.ali.user.open.core.model.RpcRequestCallbackWithCode
        public void onSystemError(String str, RpcResponse rpcResponse) {
            onError(str, rpcResponse);
        }
    }

    public static Map<String, String> buildSessionInfo(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return new HashMap();
        }
        String string = JSON.parseObject(str2).getString("authorizationResponse");
        UccServiceProvider uccServiceProvider = UccServiceProviderFactory.getInstance().getUccServiceProvider(str);
        if (!TextUtils.isEmpty(string)) {
            return uccServiceProvider.buildSessionInfo(str, string);
        }
        return uccServiceProvider.buildSessionInfo(str, str2);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void conflictupgrade(final Context context, final UccParams uccParams, int i, String str, final String str2, String str3, final Map<String, String> map, final UccCallback uccCallback) {
        final String str4;
        if (context == null || !(context instanceof Activity)) {
            finishActivity(context);
            if (uccCallback != null) {
                uccCallback.onFail(uccParams.bindSite, 1008, "换绑失败");
                return;
            }
            return;
        }
        final HashMap hashMap = new HashMap();
        hashMap.put("requestToken", str2);
        if (context instanceof UccWebViewActivity) {
            hashMap.put("type", "H5");
            str4 = "H5";
        } else {
            hashMap.put("type", "native");
            str4 = "native";
        }
        DialogHelper.getInstance().alert((Activity) context, "", str, context.getString(R.string.member_sdk_continue_upgrade), new DialogInterface.OnClickListener() {
            /* class com.ali.user.open.ucc.biz.UccBindPresenter.AnonymousClass5 */

            public void onClick(DialogInterface dialogInterface, int i) {
                UTHitUtils.send(UTHitConstants.PageUccBind, "UccBind_ConflictUpgradePositive", uccParams, hashMap);
                UccParams uccParams = uccParams;
                UccTrustLoginPresenter.getInstance().upgradeLogin((Activity) context, uccParams, uccParams.bindSite, uccParams.scene, str2, str4, map, uccCallback);
            }
        }, context.getString(R.string.member_sdk_cancel), new DialogInterface.OnClickListener() {
            /* class com.ali.user.open.ucc.biz.UccBindPresenter.AnonymousClass6 */

            public void onClick(DialogInterface dialogInterface, int i) {
                UTHitUtils.send(UTHitConstants.PageUccBind, "UccBind_ConflictUpgradeNagetive", uccParams, hashMap);
                UccBindPresenter.this.skipUpgrade(context, uccParams, str4, map, uccCallback);
            }
        });
    }

    public static void dismissProgress(Activity activity) {
        if ("true".equals(getProgressOrange())) {
            DialogHelper.getInstance().dismissProgressDialog(activity);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void finishActivity(Context context) {
        if (context == null) {
            return;
        }
        if ((context instanceof UccWebViewActivity) || (context instanceof UccActivity)) {
            ((Activity) context).finish();
            CallbackManager.unregisterCallback(UccConstants.UCC_H5_CALLBACK_TYPE);
        }
    }

    public static UccBindPresenter getInstance() {
        if (instance == null) {
            synchronized (UccBindPresenter.class) {
                if (instance == null) {
                    instance = new UccBindPresenter();
                }
            }
        }
        return instance;
    }

    public static String getProgressOrange() {
        try {
            return OrangeConfig.getInstance().getConfig("login4android", "progress", "false");
        } catch (Throwable unused) {
            return "false";
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void onBindSuccess(UccParams uccParams, Map<String, String> map, String str, UccCallback uccCallback) {
        JSONObject parseObject;
        boolean z = map == null || !TextUtils.equals(map.get(ParamsConstants.Key.PARAM_NEED_LOCAL_SESSION), "0");
        boolean isCookieOnly = UccOauthLoginPresenter.isCookieOnly(map);
        if (!TextUtils.isEmpty(str) && z) {
            refreshWhenLogin(uccParams.bindSite, str, isCookieOnly);
        }
        if (uccCallback != null) {
            Map<String, String> buildSessionInfo = buildSessionInfo(uccParams.bindSite, str);
            if (!TextUtils.isEmpty(str) && (parseObject = JSON.parseObject(str)) != null) {
                String string = parseObject.getString("authorizationResponse");
                if (TextUtils.isEmpty(string)) {
                    buildSessionInfo.put(UccConstants.PARAM_LOGIN_DATA, str);
                } else {
                    buildSessionInfo.put(UccConstants.PARAM_LOGIN_DATA, string);
                }
            }
            sendLoginSuccessBroadcast(uccParams.bindSite, map);
            uccCallback.onSuccess(uccParams.bindSite, buildSessionInfo);
        }
    }

    private void refreshWhenLogin(String str, String str2, boolean z) {
        String string = JSON.parseObject(str2).getString("authorizationResponse");
        UccServiceProvider uccServiceProvider = UccServiceProviderFactory.getInstance().getUccServiceProvider(str);
        if (!TextUtils.isEmpty(string)) {
            uccServiceProvider.refreshWhenLogin(str, string, z);
        } else {
            uccServiceProvider.refreshWhenLogin(str, str2, z);
        }
    }

    private void sendLoginSuccessBroadcast(String str, Map<String, String> map) {
        String str2;
        Intent intent = new Intent();
        intent.setAction(UccResultAction.NOTIFY_UCC_LOGIN_SUCCESS.name());
        intent.setPackage(KernelContext.getApplicationContext().getPackageName());
        if (map == null) {
            str2 = "";
        } else {
            str2 = map.get("process");
        }
        intent.putExtra("process", str2);
        intent.putExtra("site", str);
        UccBroadcastHelper.sendBroadcast(intent);
    }

    public static void showProgress(Activity activity) {
        if ("true".equals(getProgressOrange())) {
            DialogHelper.getInstance().showProgressDialog(activity, "", true, null);
        }
    }

    public void applyToken(final UccParams uccParams, String str, Map<String, String> map, final UccCallback uccCallback) {
        DataRepository.applyToken(uccParams.bindSite, map, new RpcRequestCallbackWithCode() {
            /* class com.ali.user.open.ucc.biz.UccBindPresenter.AnonymousClass11 */

            @Override // com.ali.user.open.core.model.RpcRequestCallbackWithCode
            public void onError(String str, RpcResponse rpcResponse) {
                UccCallback uccCallback = uccCallback;
                String str2 = uccParams.bindSite;
                if (TextUtils.isEmpty(str)) {
                    str = "rpc error";
                }
                uccCallback.onFail(str2, 1602, str);
            }

            @Override // com.ali.user.open.core.model.RpcRequestCallbackWithCode
            public void onSuccess(RpcResponse rpcResponse) {
                T t;
                T t2;
                if (rpcResponse == null || (t = rpcResponse.returnValue) == null || (t2 = t) == null || TextUtils.isEmpty(t2.token)) {
                    uccCallback.onFail(uccParams.bindSite, 1602, "parse data error");
                    return;
                }
                HashMap hashMap = new HashMap();
                hashMap.put("token", t2.token);
                uccCallback.onSuccess(uccParams.bindSite, hashMap);
            }

            @Override // com.ali.user.open.core.model.RpcRequestCallbackWithCode
            public void onSystemError(String str, RpcResponse rpcResponse) {
                onError(str, rpcResponse);
            }
        });
    }

    public void bindAfterRecommend(Activity activity, String str, UccParams uccParams, String str2, String str3, Map<String, String> map, UccCallback uccCallback) {
        HashMap hashMap = new HashMap();
        hashMap.put("requestToken", str);
        hashMap.put("bindUserToken", str2);
        UTHitUtils.send(UTHitConstants.PageUccBind, "UccBind_RecommendBind", uccParams, hashMap);
        uccParams.requestToken = str;
        uccParams.bindUserToken = str2;
        showProgress(activity);
        DataRepository.bindAfterRecommend(uccParams, new BindRpcRequestCallback(activity, 1, 0, uccParams, str3, map, uccCallback));
    }

    public void bindByNativeAuth(final Activity activity, final UccParams uccParams, String str, String str2, final Map<String, String> map, final UccCallback uccCallback) {
        HashMap hashMap = new HashMap();
        final String str3 = (activity == null || !(activity instanceof UccWebViewActivity)) ? "native" : "H5";
        hashMap.put("type", str3);
        UTHitUtils.send(UTHitConstants.PageUccBind, "UccBind_NativeAuthBind", uccParams, hashMap);
        if (uccParams == null) {
            uccParams = new UccParams();
        }
        if (map == null || TextUtils.isEmpty(map.get("site"))) {
            uccParams.site = AliMemberSDK.getMasterSite();
        } else {
            uccParams.site = map.get("site");
        }
        uccParams.bindSite = uccParams.bindSite;
        uccParams.userToken = uccParams.userToken;
        uccParams.bindUserToken = str;
        uccParams.bindUserTokenType = str2;
        uccParams.requestToken = map.get("requestToken");
        uccParams.scene = map.get("scene");
        if (TextUtils.equals("1", map.get("needSession"))) {
            uccParams.createBindSiteSession = true;
        } else {
            uccParams.createBindSiteSession = false;
        }
        AnonymousClass1 r12 = new RpcRequestCallbackWithCode() {
            /* class com.ali.user.open.ucc.biz.UccBindPresenter.AnonymousClass1 */

            private void rpcResultlHit(String str, String str2) {
                HashMap hashMap = new HashMap();
                hashMap.put("code", str);
                hashMap.put("type", str3);
                hashMap.put("actionType", str2);
                UTHitUtils.send(UTHitConstants.PageUccBind, "UccBind_NativeAuthBindResult", uccParams, hashMap);
            }

            @Override // com.ali.user.open.core.model.RpcRequestCallbackWithCode
            public void onError(String str, final RpcResponse rpcResponse) {
                UccCallback uccCallback;
                T t;
                UccBindPresenter.dismissProgress(activity);
                final int buidErrorCode = Utils.buidErrorCode(rpcResponse, 1007);
                rpcResultlHit(buidErrorCode + "", "");
                if (TextUtils.equals("H5", rpcResponse.actionType) && (t = rpcResponse.returnValue) != null) {
                    JSONObject parseObject = JSON.parseObject(t);
                    if (parseObject != null) {
                        String string = parseObject.getString("returnUrl");
                        Bundle bundle = new Bundle();
                        bundle.putString("url", string);
                        bundle.putString(UccConstants.PARAM_UCC_PARAMS, JSON.toJSONString(uccParams));
                        bundle.putString("needSession", uccParams.createBindSiteSession ? "1" : "0");
                        bundle.putString("params", Utils.convertMapToJsonStr(map));
                        UccH5Presenter.openUrl(activity, bundle, uccCallback);
                        return;
                    }
                    UccBindPresenter.this.finishActivity(activity);
                    UccCallback uccCallback2 = uccCallback;
                    if (uccCallback2 != null) {
                        uccCallback2.onFail(uccParams.bindSite, buidErrorCode, Utils.buidErrorMessage(rpcResponse, "bindByNativeAuth接口报错"));
                    }
                } else if (TextUtils.equals(ApiConstants.ResultActionType.TOAST, rpcResponse.actionType) && !TextUtils.isEmpty(rpcResponse.message)) {
                    ((MemberExecutorService) AliMemberSDK.getService(MemberExecutorService.class)).postUITask(new Runnable() {
                        /* class com.ali.user.open.ucc.biz.UccBindPresenter.AnonymousClass1.AnonymousClass1 */

                        public void run() {
                            try {
                                ToastUtil.showToast(activity.getApplicationContext(), rpcResponse.message, 0);
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                        }
                    });
                    if (!(activity instanceof UccWebViewActivity) && (uccCallback = uccCallback) != null) {
                        uccCallback.onFail(uccParams.bindSite, buidErrorCode, Utils.buidErrorMessage(rpcResponse, "bindByNativeAuth接口报错"));
                    }
                } else if (!TextUtils.equals(ApiConstants.ResultActionType.ALERT, rpcResponse.actionType) || TextUtils.isEmpty(rpcResponse.message)) {
                    UccBindPresenter.this.finishActivity(activity);
                    UccCallback uccCallback3 = uccCallback;
                    if (uccCallback3 != null) {
                        uccCallback3.onFail(uccParams.bindSite, buidErrorCode, Utils.buidErrorMessage(rpcResponse, "bindByNativeAuth接口报错"));
                    }
                } else {
                    DialogHelper instance = DialogHelper.getInstance();
                    Activity activity = activity;
                    instance.alert(activity, "", rpcResponse.message, activity.getString(R.string.member_sdk_iknow), new DialogInterface.OnClickListener() {
                        /* class com.ali.user.open.ucc.biz.UccBindPresenter.AnonymousClass1.AnonymousClass2 */

                        public void onClick(DialogInterface dialogInterface, int i) {
                            UccCallback uccCallback;
                            AnonymousClass1 r4 = AnonymousClass1.this;
                            Activity activity = activity;
                            if (activity != null && !(activity instanceof UccWebViewActivity) && (uccCallback = uccCallback) != null) {
                                uccCallback.onFail(uccParams.bindSite, buidErrorCode, Utils.buidErrorMessage(rpcResponse, "bindByNativeAuth接口报错"));
                            }
                        }
                    }, "", null);
                }
            }

            @Override // com.ali.user.open.core.model.RpcRequestCallbackWithCode
            public void onSuccess(RpcResponse rpcResponse) {
                UccBindPresenter.dismissProgress(activity);
                rpcResultlHit(rpcResponse.code + "", rpcResponse.actionType);
                T t = rpcResponse.returnValue;
                if (TextUtils.equals("CHANGEBIND", rpcResponse.actionType)) {
                    UccBindPresenter.this.changeBind(activity, uccParams, 0, rpcResponse.message, ((BindResult) JSON.parseObject(t, BindResult.class)).changeBindToken, "0", map, uccCallback);
                } else if (TextUtils.equals("CONFLICTUPGRADE", rpcResponse.actionType)) {
                    UccBindPresenter.this.conflictupgrade(activity, uccParams, 0, rpcResponse.message, ((BindResult) JSON.parseObject(t, BindResult.class)).requestToken, "0", map, uccCallback);
                } else {
                    HashMap hashMap = new HashMap();
                    hashMap.put(MtopJSBridge.MtopJSParam.NEED_LOGIN, uccParams.createBindSiteSession ? "T" : UTConstant.Args.UT_SUCCESS_F);
                    UTHitUtils.send(UTHitConstants.PageUccBind, "UccBind_Success", uccParams, hashMap);
                    UccBindPresenter.this.finishActivity(activity);
                    UccBindPresenter.this.onBindSuccess(uccParams, map, t, uccCallback);
                }
            }

            @Override // com.ali.user.open.core.model.RpcRequestCallbackWithCode
            public void onSystemError(String str, RpcResponse rpcResponse) {
                UccBindPresenter.dismissProgress(activity);
                int buidErrorCode = Utils.buidErrorCode(rpcResponse, 1007);
                rpcResultlHit(buidErrorCode + "", "");
                UccBindPresenter.this.finishActivity(activity);
                UccCallback uccCallback = uccCallback;
                if (uccCallback != null) {
                    uccCallback.onFail(uccParams.bindSite, buidErrorCode, Utils.buidErrorMessage(rpcResponse, "bindByNativeAuth接口报错"));
                }
            }
        };
        if (!TextUtils.isEmpty(uccParams.requestToken)) {
            showProgress(activity);
            DataRepository.bindByRequestToken(uccParams, r12);
            return;
        }
        showProgress(activity);
        DataRepository.bindByNativeAuth(uccParams, r12);
    }

    public void bindByRequestToken(final Activity activity, final UccParams uccParams, String str, String str2, String str3, final Map<String, String> map, final UccCallback uccCallback) {
        final String str4 = (activity == null || !(activity instanceof UccWebViewActivity)) ? "native" : "H5";
        HashMap hashMap = new HashMap();
        hashMap.put("type", str4);
        UTHitUtils.send(UTHitConstants.PageUccBind, "UccBind_BindByRequestToken", uccParams, hashMap);
        if (uccParams == null) {
            uccParams = new UccParams();
        }
        if (map == null || TextUtils.isEmpty(map.get("site"))) {
            uccParams.site = AliMemberSDK.getMasterSite();
        } else {
            uccParams.site = map.get("site");
        }
        uccParams.bindSite = uccParams.bindSite;
        uccParams.userToken = uccParams.userToken;
        if (TextUtils.isEmpty(str2)) {
            str2 = "";
        }
        uccParams.bindUserToken = str2;
        if (TextUtils.isEmpty(str3)) {
            str3 = "";
        }
        uccParams.bindUserTokenType = str3;
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        uccParams.requestToken = str;
        uccParams.scene = map.get("scene");
        if (TextUtils.equals("1", map.get("needSession"))) {
            uccParams.createBindSiteSession = true;
        } else {
            uccParams.createBindSiteSession = false;
        }
        AnonymousClass2 r11 = new RpcRequestCallbackWithCode() {
            /* class com.ali.user.open.ucc.biz.UccBindPresenter.AnonymousClass2 */

            private void rpcResultlHit(String str, String str2) {
                HashMap hashMap = new HashMap();
                hashMap.put("code", str);
                hashMap.put("type", str4);
                hashMap.put("actionType", str2);
                UTHitUtils.send(UTHitConstants.PageUccBind, "UccBind_BindByRequestTokenResult", uccParams, hashMap);
            }

            @Override // com.ali.user.open.core.model.RpcRequestCallbackWithCode
            public void onError(String str, RpcResponse rpcResponse) {
                T t;
                int buidErrorCode = Utils.buidErrorCode(rpcResponse, 1007);
                rpcResultlHit(buidErrorCode + "", "");
                if (!TextUtils.equals("H5", rpcResponse.actionType) || (t = rpcResponse.returnValue) == null) {
                    UccBindPresenter.this.finishActivity(activity);
                    UccCallback uccCallback = uccCallback;
                    if (uccCallback != null) {
                        uccCallback.onFail(uccParams.bindSite, buidErrorCode, Utils.buidErrorMessage(rpcResponse, "bindByNativeAuth接口报错"));
                        return;
                    }
                    return;
                }
                JSONObject parseObject = JSON.parseObject(t);
                if (parseObject != null) {
                    String string = parseObject.getString("returnUrl");
                    Bundle bundle = new Bundle();
                    bundle.putString("url", string);
                    bundle.putString(UccConstants.PARAM_UCC_PARAMS, JSON.toJSONString(uccParams));
                    bundle.putString("needSession", "1");
                    bundle.putString("params", Utils.convertMapToJsonStr(map));
                    UccH5Presenter.openUrl(activity, bundle, uccCallback);
                    Activity activity = activity;
                    if (activity != null && !(activity instanceof UccWebViewActivity)) {
                        activity.finish();
                        return;
                    }
                    return;
                }
                UccBindPresenter.this.finishActivity(activity);
                UccCallback uccCallback2 = uccCallback;
                if (uccCallback2 != null) {
                    uccCallback2.onFail(uccParams.bindSite, buidErrorCode, Utils.buidErrorMessage(rpcResponse, "bindByNativeAuth接口报错"));
                }
            }

            @Override // com.ali.user.open.core.model.RpcRequestCallbackWithCode
            public void onSuccess(RpcResponse rpcResponse) {
                rpcResultlHit(rpcResponse.code + "", rpcResponse.actionType);
                T t = rpcResponse.returnValue;
                if (TextUtils.equals("CHANGEBIND", rpcResponse.actionType)) {
                    UccBindPresenter.this.changeBind(activity, uccParams, 0, rpcResponse.message, ((BindResult) JSON.parseObject(t, BindResult.class)).changeBindToken, "0", map, uccCallback);
                } else if (TextUtils.equals("CONFLICTUPGRADE", rpcResponse.actionType)) {
                    UccBindPresenter.this.conflictupgrade(activity, uccParams, 0, rpcResponse.message, ((BindResult) JSON.parseObject(t, BindResult.class)).requestToken, "0", map, uccCallback);
                } else {
                    HashMap hashMap = new HashMap();
                    hashMap.put(MtopJSBridge.MtopJSParam.NEED_LOGIN, uccParams.createBindSiteSession ? "T" : UTConstant.Args.UT_SUCCESS_F);
                    UTHitUtils.send(UTHitConstants.PageUccBind, "UccBind_Success", uccParams, hashMap);
                    UccBindPresenter.this.finishActivity(activity);
                    UccBindPresenter.this.onBindSuccess(uccParams, map, t, uccCallback);
                }
            }

            @Override // com.ali.user.open.core.model.RpcRequestCallbackWithCode
            public void onSystemError(String str, RpcResponse rpcResponse) {
                int buidErrorCode = Utils.buidErrorCode(rpcResponse, 1007);
                rpcResultlHit(buidErrorCode + "", "");
                UccBindPresenter.this.finishActivity(activity);
                UccCallback uccCallback = uccCallback;
                if (uccCallback != null) {
                    uccCallback.onFail(uccParams.bindSite, buidErrorCode, Utils.buidErrorMessage(rpcResponse, "bindByNativeAuth接口报错"));
                }
            }
        };
        if (!TextUtils.isEmpty(uccParams.requestToken)) {
            DataRepository.bindByRequestToken(uccParams, r11);
        } else {
            uccCallback.onFail(uccParams.bindSite, -1, "token.authcode入参报错");
        }
    }

    public void bindIdentify(Activity activity, String str, UccParams uccParams, String str2, String str3, String str4, Map<String, String> map, UccCallback uccCallback) {
        int i;
        HashMap hashMap = new HashMap();
        hashMap.put("bindUserToken", str3);
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("bizToken", str2);
            UTHitUtils.send(UTHitConstants.PageUccBind, "UccBind_BindIdentify_IV", uccParams, hashMap);
            i = 1;
        } else if (!TextUtils.isEmpty(str)) {
            hashMap.put("bizToken", str);
            UTHitUtils.send(UTHitConstants.PageUccBind, "UccBind_BindIdentify_oauthLogin", uccParams, hashMap);
            i = 2;
        } else {
            i = 0;
        }
        uccParams.requestToken = str;
        uccParams.bindUserToken = str3;
        uccParams.ivToken = str2;
        showProgress(activity);
        DataRepository.bindIdentify(uccParams, new BindRpcRequestCallback(activity, 2, i, uccParams, str4, map, uccCallback));
    }

    public void changeBind(final Activity activity, final UccParams uccParams, final int i, String str, final String str2, final String str3, final Map<String, String> map, final UccCallback uccCallback) {
        if (activity != null) {
            final HashMap hashMap = new HashMap();
            hashMap.put("changeBindToken", str2);
            if (activity instanceof UccWebViewActivity) {
                hashMap.put("type", "H5");
            } else {
                hashMap.put("type", "native");
            }
            DialogHelper.getInstance().alert(activity, "", str, activity.getString(R.string.member_sdk_continue_bind), new DialogInterface.OnClickListener() {
                /* class com.ali.user.open.ucc.biz.UccBindPresenter.AnonymousClass3 */

                public void onClick(DialogInterface dialogInterface, int i) {
                    UTHitUtils.send(UTHitConstants.PageUccBind, "UccBind_ChangeBind", uccParams, hashMap);
                    UccBindPresenter.this.doChangeBind(activity, uccParams, i, str2, str3, map, uccCallback);
                }
            }, activity.getString(R.string.member_sdk_cancel), new DialogInterface.OnClickListener() {
                /* class com.ali.user.open.ucc.biz.UccBindPresenter.AnonymousClass4 */

                public void onClick(DialogInterface dialogInterface, int i) {
                    UccCallback uccCallback;
                    UTHitUtils.send(UTHitConstants.PageUccBind, "UccBind_ChangeBindCancel", uccParams, hashMap);
                    if (i == 1) {
                        Activity activity = activity;
                        if (activity instanceof UccWebViewActivity) {
                            ((UccWebViewActivity) activity).finish();
                            UccCallback uccCallback2 = uccCallback;
                            if (uccCallback2 != null) {
                                uccCallback2.onFail(uccParams.bindSite, 1006, "用户取消换绑");
                                return;
                            }
                            return;
                        }
                    }
                    if (!(activity instanceof UccWebViewActivity) && (uccCallback = uccCallback) != null) {
                        uccCallback.onFail(uccParams.bindSite, 1006, "用户取消换绑");
                    }
                }
            });
            return;
        }
        finishActivity(activity);
        if (uccCallback != null) {
            uccCallback.onFail(uccParams.bindSite, 1008, "换绑失败");
        }
    }

    public void doChangeBind(final Activity activity, final UccParams uccParams, final int i, String str, final String str2, final Map<String, String> map, final UccCallback uccCallback) {
        DataRepository.changeBind(uccParams, str, new RpcRequestCallbackWithCode() {
            /* class com.ali.user.open.ucc.biz.UccBindPresenter.AnonymousClass7 */

            private void rpcResultlHit(String str) {
                HashMap hashMap = new HashMap();
                hashMap.put("code", str);
                Activity activity = activity;
                if (activity == null || !(activity instanceof UccWebViewActivity)) {
                    hashMap.put("type", "native");
                } else {
                    hashMap.put("type", "H5");
                }
                UTHitUtils.send(UTHitConstants.PageUccBind, "UccBind_ChangeBindResult", uccParams, hashMap);
            }

            @Override // com.ali.user.open.core.model.RpcRequestCallbackWithCode
            public void onError(String str, final RpcResponse rpcResponse) {
                final int buidErrorCode = Utils.buidErrorCode(rpcResponse, 1008);
                StringBuilder sb = new StringBuilder();
                sb.append(buidErrorCode);
                final String str2 = "";
                sb.append(str2);
                rpcResultlHit(sb.toString());
                if (rpcResponse != null) {
                    str2 = rpcResponse.message;
                }
                if (i == 1) {
                    DialogHelper instance = DialogHelper.getInstance();
                    Activity activity = activity;
                    instance.alert(activity, "", str2, activity.getString(R.string.member_sdk_iknow), new DialogInterface.OnClickListener() {
                        /* class com.ali.user.open.ucc.biz.UccBindPresenter.AnonymousClass7.AnonymousClass4 */

                        public void onClick(DialogInterface dialogInterface, int i) {
                            AnonymousClass7 r4 = AnonymousClass7.this;
                            UccBindPresenter.this.finishActivity(activity);
                            AnonymousClass7 r42 = AnonymousClass7.this;
                            UccCallback uccCallback = uccCallback;
                            if (uccCallback != null) {
                                uccCallback.onFail(uccParams.bindSite, buidErrorCode, Utils.buidErrorMessage(rpcResponse, "换绑失败"));
                            }
                        }
                    }, "", null);
                    return;
                }
                ((MemberExecutorService) AliMemberSDK.getService(MemberExecutorService.class)).postUITask(new Runnable() {
                    /* class com.ali.user.open.ucc.biz.UccBindPresenter.AnonymousClass7.AnonymousClass5 */

                    public void run() {
                        try {
                            ToastUtil.showToast(activity.getApplicationContext(), str2, 0);
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                        AnonymousClass7 r0 = AnonymousClass7.this;
                        UccBindPresenter.this.finishActivity(activity);
                    }
                });
            }

            @Override // com.ali.user.open.core.model.RpcRequestCallbackWithCode
            public void onSuccess(final RpcResponse rpcResponse) {
                rpcResultlHit(rpcResponse.code + "");
                T t = rpcResponse.returnValue;
                if (TextUtils.equals("CONFLICTUPGRADE", rpcResponse.actionType)) {
                    UccBindPresenter.this.conflictupgrade(activity, uccParams, 0, rpcResponse.message, ((BindResult) JSON.parseObject(t, BindResult.class)).requestToken, "0", map, uccCallback);
                    return;
                }
                String str = "1";
                if (!TextUtils.equals("H5", rpcResponse.actionType) || rpcResponse.returnValue == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(MtopJSBridge.MtopJSParam.NEED_LOGIN, (TextUtils.isEmpty(t) || t.length() < 10) ? UTConstant.Args.UT_SUCCESS_F : "T");
                    UTHitUtils.send(UTHitConstants.PageUccBind, "UccBind_Success", uccParams, hashMap);
                    if (activity != null && !TextUtils.isEmpty(rpcResponse.message) && TextUtils.equals(str2, str)) {
                        ((MemberExecutorService) AliMemberSDK.getService(MemberExecutorService.class)).postUITask(new Runnable() {
                            /* class com.ali.user.open.ucc.biz.UccBindPresenter.AnonymousClass7.AnonymousClass1 */

                            public void run() {
                                try {
                                    ToastUtil.showToast(activity.getApplicationContext(), rpcResponse.message, 0);
                                } catch (Throwable th) {
                                    th.printStackTrace();
                                }
                            }
                        });
                    }
                    UccBindPresenter.this.finishActivity(activity);
                    UccBindPresenter.this.onBindSuccess(uccParams, map, t, uccCallback);
                    return;
                }
                JSONObject parseObject = JSON.parseObject(t);
                if (parseObject != null) {
                    String string = parseObject.getString("returnUrl");
                    Bundle bundle = new Bundle();
                    bundle.putString("url", string);
                    bundle.putString("token", parseObject.getString("trustLoginToken"));
                    bundle.putString("scene", parseObject.getString("scene"));
                    bundle.putString(UccConstants.PARAM_UCC_PARAMS, JSON.toJSONString(uccParams));
                    if (!uccParams.createBindSiteSession) {
                        str = "0";
                    }
                    bundle.putString("needSession", str);
                    bundle.putString("params", Utils.convertMapToJsonStr(map));
                    UccH5Presenter.openUrl(activity, bundle, uccCallback);
                    return;
                }
                UccBindPresenter.this.finishActivity(activity);
                UccCallback uccCallback = uccCallback;
                if (uccCallback != null) {
                    uccCallback.onFail(uccParams.bindSite, 1008, Utils.buidErrorMessage(rpcResponse, "换绑失败"));
                }
            }

            @Override // com.ali.user.open.core.model.RpcRequestCallbackWithCode
            public void onSystemError(String str, final RpcResponse rpcResponse) {
                final int buidErrorCode = Utils.buidErrorCode(rpcResponse, 1008);
                StringBuilder sb = new StringBuilder();
                sb.append(buidErrorCode);
                final String str2 = "";
                sb.append(str2);
                rpcResultlHit(sb.toString());
                if (rpcResponse != null) {
                    str2 = rpcResponse.message;
                }
                if (i == 1) {
                    DialogHelper instance = DialogHelper.getInstance();
                    Activity activity = activity;
                    instance.alert(activity, "", str2, activity.getString(R.string.member_sdk_iknow), new DialogInterface.OnClickListener() {
                        /* class com.ali.user.open.ucc.biz.UccBindPresenter.AnonymousClass7.AnonymousClass2 */

                        public void onClick(DialogInterface dialogInterface, int i) {
                            AnonymousClass7 r4 = AnonymousClass7.this;
                            UccBindPresenter.this.finishActivity(activity);
                            AnonymousClass7 r42 = AnonymousClass7.this;
                            UccCallback uccCallback = uccCallback;
                            if (uccCallback != null) {
                                uccCallback.onFail(uccParams.bindSite, buidErrorCode, Utils.buidErrorMessage(rpcResponse, "换绑失败"));
                            }
                        }
                    }, "", null);
                    return;
                }
                ((MemberExecutorService) AliMemberSDK.getService(MemberExecutorService.class)).postUITask(new Runnable() {
                    /* class com.ali.user.open.ucc.biz.UccBindPresenter.AnonymousClass7.AnonymousClass3 */

                    public void run() {
                        try {
                            ToastUtil.showToast(activity.getApplicationContext(), str2, 0);
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                        AnonymousClass7 r0 = AnonymousClass7.this;
                        UccBindPresenter.this.finishActivity(activity);
                    }
                });
            }
        });
    }

    public void getUserInfo(final Context context, final UccParams uccParams, String str, String str2, final String str3, final Map<String, String> map, final UccCallback uccCallback) {
        HashMap hashMap = new HashMap();
        hashMap.put("type", str3);
        UTHitUtils.send(UTHitConstants.PageUccBind, "UccBind_GetAuthInfo", uccParams, hashMap);
        final UccParams uccParams2 = new UccParams();
        if (map == null || TextUtils.isEmpty(map.get("site"))) {
            uccParams2.site = AliMemberSDK.getMasterSite();
        } else {
            uccParams2.site = map.get("site");
        }
        if (map == null || TextUtils.isEmpty(map.get("bindSite"))) {
            uccParams2.bindSite = uccParams.bindSite;
        } else {
            uccParams2.bindSite = map.get("bindSite");
        }
        uccParams2.userToken = uccParams.userToken;
        uccParams2.bindUserToken = str;
        uccParams2.bindUserTokenType = str2;
        uccParams2.createBindSiteSession = true;
        if (map != null && !TextUtils.isEmpty(map.get("scene"))) {
            uccParams2.scene = map.get("scene");
        }
        DataRepository.getUserInfo(uccParams2, str3, new RpcRequestCallbackWithCode() {
            /* class com.ali.user.open.ucc.biz.UccBindPresenter.AnonymousClass9 */

            private void rpcResultlHit(String str, String str2) {
                HashMap hashMap = new HashMap();
                hashMap.put("code", str);
                hashMap.put("type", TextUtils.isEmpty(str3) ? "" : str3);
                hashMap.put("actionType", str2);
                if (!TextUtils.isEmpty(uccParams2.bindUserToken)) {
                    hashMap.put("bindUserToken", uccParams2.bindUserToken);
                }
                if (!TextUtils.isEmpty(uccParams2.scene)) {
                    hashMap.put("scene", uccParams2.scene);
                }
                UTHitUtils.send(UTHitConstants.PageUccBind, "UccBind_GetAuthInfoResult", uccParams, hashMap);
            }

            @Override // com.ali.user.open.core.model.RpcRequestCallbackWithCode
            public void onError(String str, RpcResponse rpcResponse) {
                int buidErrorCode = Utils.buidErrorCode(rpcResponse, 1007);
                StringBuilder sb = new StringBuilder();
                sb.append(buidErrorCode);
                String str2 = "";
                sb.append(str2);
                rpcResultlHit(sb.toString(), str2);
                if (TextUtils.equals(str3, "h5")) {
                    if (rpcResponse != null) {
                        str2 = rpcResponse.message;
                    }
                    DialogHelper instance = DialogHelper.getInstance();
                    Context context = context;
                    instance.alert((Activity) context, "", str2, context.getString(R.string.member_sdk_iknow), new DialogInterface.OnClickListener() {
                        /* class com.ali.user.open.ucc.biz.UccBindPresenter.AnonymousClass9.AnonymousClass2 */

                        public void onClick(DialogInterface dialogInterface, int i) {
                        }
                    }, "", null);
                    return;
                }
                UccBindPresenter.this.finishActivity(context);
                UccCallback uccCallback = uccCallback;
                if (uccCallback != null) {
                    uccCallback.onFail(uccParams.bindSite, buidErrorCode, Utils.buidErrorMessage(rpcResponse, "OauthLogin接口错误"));
                }
            }

            @Override // com.ali.user.open.core.model.RpcRequestCallbackWithCode
            public void onSuccess(RpcResponse rpcResponse) {
                rpcResultlHit(rpcResponse.code + "", rpcResponse.actionType);
                T t = rpcResponse.returnValue;
                if (t == null) {
                    UccCallback uccCallback = uccCallback;
                    if (uccCallback != null) {
                        uccCallback.onFail(uccParams.bindSite, 1013, Utils.buidErrorMessage(rpcResponse, "GetUserInfo接口错误"));
                        return;
                    }
                    return;
                }
                T t2 = t;
                if (!TextUtils.equals("H5", rpcResponse.actionType) || rpcResponse.returnValue == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(MtopJSBridge.MtopJSParam.NEED_LOGIN, uccParams2.createBindSiteSession ? "T" : UTConstant.Args.UT_SUCCESS_F);
                    UTHitUtils.send(UTHitConstants.PageUccBind, "UccBind_Success", uccParams, hashMap);
                    UccBindPresenter.this.finishActivity(context);
                    UccBindPresenter.this.onBindSuccess(uccParams, map, t2, uccCallback);
                    return;
                }
                JSONObject parseObject = JSON.parseObject(t2);
                if (parseObject != null) {
                    String string = parseObject.getString(ParamsConstants.Key.PARAM_H5URL);
                    Bundle bundle = new Bundle();
                    bundle.putString("url", string);
                    bundle.putString("token", parseObject.getString("token"));
                    bundle.putString("scene", parseObject.getString("scene"));
                    bundle.putString(UccConstants.PARAM_UCC_PARAMS, JSON.toJSONString(uccParams));
                    bundle.putString("needSession", "1");
                    bundle.putString("params", Utils.convertMapToJsonStr(map));
                    UccH5Presenter.openUrl(context, bundle, uccCallback);
                    Context context = context;
                    if (context != null && !(context instanceof UccWebViewActivity)) {
                        ((Activity) context).finish();
                        return;
                    }
                    return;
                }
                UccBindPresenter.this.finishActivity(context);
                UccCallback uccCallback2 = uccCallback;
                if (uccCallback2 != null) {
                    uccCallback2.onFail(uccParams.bindSite, 1005, Utils.buidErrorMessage(rpcResponse, SNSJsbridge.TAOBAO_ERROR_MESSAGE));
                }
            }

            @Override // com.ali.user.open.core.model.RpcRequestCallbackWithCode
            public void onSystemError(String str, RpcResponse rpcResponse) {
                int buidErrorCode = Utils.buidErrorCode(rpcResponse, 1007);
                StringBuilder sb = new StringBuilder();
                sb.append(buidErrorCode);
                String str2 = "";
                sb.append(str2);
                rpcResultlHit(sb.toString(), str2);
                if (TextUtils.equals(str3, "h5")) {
                    if (rpcResponse != null) {
                        str2 = rpcResponse.message;
                    }
                    DialogHelper instance = DialogHelper.getInstance();
                    Context context = context;
                    instance.alert((Activity) context, "", str2, context.getString(R.string.member_sdk_iknow), new DialogInterface.OnClickListener() {
                        /* class com.ali.user.open.ucc.biz.UccBindPresenter.AnonymousClass9.AnonymousClass1 */

                        public void onClick(DialogInterface dialogInterface, int i) {
                        }
                    }, "", null);
                    return;
                }
                UccBindPresenter.this.finishActivity(context);
                UccCallback uccCallback = uccCallback;
                if (uccCallback != null) {
                    uccCallback.onFail(uccParams.bindSite, buidErrorCode, Utils.buidErrorMessage(rpcResponse, "OauthLogin接口错误"));
                }
            }
        });
    }

    public void noActionBind(final UccParams uccParams, final UccCallback uccCallback) {
        DataRepository.noActionBind(uccParams, new RpcRequestCallbackWithCode() {
            /* class com.ali.user.open.ucc.biz.UccBindPresenter.AnonymousClass14 */

            @Override // com.ali.user.open.core.model.RpcRequestCallbackWithCode
            public void onError(String str, RpcResponse rpcResponse) {
                T t;
                if (uccCallback != null) {
                    int buidErrorCode = Utils.buidErrorCode(rpcResponse, 1800);
                    String buidErrorMessage = Utils.buidErrorMessage(rpcResponse, "noActionBind接口失败");
                    if (rpcResponse == null || !"CHANGEBIND".equals(rpcResponse.actionType) || (t = rpcResponse.returnValue) == null) {
                        uccCallback.onFail(uccParams.bindSite, buidErrorCode, buidErrorMessage);
                        return;
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put("data", t);
                    uccCallback.onSuccess(uccParams.bindSite, hashMap);
                }
            }

            @Override // com.ali.user.open.core.model.RpcRequestCallbackWithCode
            public void onSuccess(RpcResponse rpcResponse) {
                HashMap hashMap = new HashMap();
                hashMap.put("data", rpcResponse.returnValue);
                uccCallback.onSuccess(uccParams.bindSite, hashMap);
            }

            @Override // com.ali.user.open.core.model.RpcRequestCallbackWithCode
            public void onSystemError(String str, RpcResponse rpcResponse) {
                onError(str, rpcResponse);
            }
        });
    }

    public void noActionBindWithChangeBind(Activity activity, UccParams uccParams, Map<String, String> map, UccCallback uccCallback) {
        String str = "0";
        if (map != null && !TextUtils.isEmpty(map.get(ParamsConstants.Key.PARAM_NEED_TOAST))) {
            str = map.get(ParamsConstants.Key.PARAM_NEED_TOAST);
        }
        DataRepository.noActionBind(uccParams, new BindRpcRequestCallback(activity, 3, 0, uccParams, str, new HashMap(), uccCallback));
    }

    public void noActionUnbind(final UccParams uccParams, final UccCallback uccCallback) {
        DataRepository.noActionUnbind(uccParams, new RpcRequestCallbackWithCode() {
            /* class com.ali.user.open.ucc.biz.UccBindPresenter.AnonymousClass15 */

            @Override // com.ali.user.open.core.model.RpcRequestCallbackWithCode
            public void onError(String str, RpcResponse rpcResponse) {
                uccCallback.onFail(uccParams.bindSite, Utils.buidErrorCode(rpcResponse, 1800), Utils.buidErrorMessage(rpcResponse, "noActionBind接口失败"));
            }

            @Override // com.ali.user.open.core.model.RpcRequestCallbackWithCode
            public void onSuccess(RpcResponse rpcResponse) {
                HashMap hashMap = new HashMap();
                hashMap.put("data", rpcResponse.returnValue);
                uccCallback.onSuccess(uccParams.bindSite, hashMap);
            }

            @Override // com.ali.user.open.core.model.RpcRequestCallbackWithCode
            public void onSystemError(String str, RpcResponse rpcResponse) {
                onError(str, rpcResponse);
            }
        });
    }

    public void queryBind(final UccParams uccParams, Map<String, String> map, final UccCallback uccCallback) {
        DataRepository.queryBind(uccParams, new RpcRequestCallbackWithCode() {
            /* class com.ali.user.open.ucc.biz.UccBindPresenter.AnonymousClass12 */

            @Override // com.ali.user.open.core.model.RpcRequestCallbackWithCode
            public void onError(String str, RpcResponse rpcResponse) {
                if (uccCallback != null) {
                    uccCallback.onFail(uccParams.bindSite, Utils.buidErrorCode(rpcResponse, 1600), Utils.buidErrorMessage(rpcResponse, "queryBind接口失败"));
                }
            }

            @Override // com.ali.user.open.core.model.RpcRequestCallbackWithCode
            public void onSuccess(RpcResponse rpcResponse) {
                HashMap hashMap = new HashMap();
                hashMap.put("data", rpcResponse.returnValue);
                uccCallback.onSuccess(uccParams.bindSite, hashMap);
            }

            @Override // com.ali.user.open.core.model.RpcRequestCallbackWithCode
            public void onSystemError(String str, RpcResponse rpcResponse) {
                onError(str, rpcResponse);
            }
        });
    }

    public void skipUpgrade(final Context context, final UccParams uccParams, final String str, final Map<String, String> map, final UccCallback uccCallback) {
        HashMap hashMap = new HashMap();
        hashMap.put("type", str);
        UTHitUtils.send(UTHitConstants.PageUccBind, "UccBind_LoginContinue", uccParams, hashMap);
        final UccParams uccParams2 = new UccParams();
        if (map == null || TextUtils.isEmpty(map.get("site"))) {
            uccParams2.site = AliMemberSDK.getMasterSite();
        } else {
            uccParams2.site = map.get("site");
        }
        if (map == null || TextUtils.isEmpty(map.get("bindSite"))) {
            uccParams2.bindSite = uccParams.bindSite;
        } else {
            uccParams2.bindSite = map.get("bindSite");
        }
        uccParams2.userToken = uccParams.userToken;
        uccParams2.requestToken = uccParams.requestToken;
        uccParams2.createBindSiteSession = true;
        if (map != null && !TextUtils.isEmpty(map.get("scene"))) {
            uccParams2.scene = map.get("scene");
        }
        DataRepository.skipUpgrade(uccParams, str, new RpcRequestCallbackWithCode() {
            /* class com.ali.user.open.ucc.biz.UccBindPresenter.AnonymousClass10 */

            private void rpcResultlHit(String str, String str2) {
                HashMap hashMap = new HashMap();
                hashMap.put("code", str);
                hashMap.put("type", TextUtils.isEmpty(str) ? "" : str);
                hashMap.put("actionType", str2);
                hashMap.put("requestToken", uccParams.requestToken);
                if (!TextUtils.isEmpty(uccParams2.scene)) {
                    hashMap.put("scene", uccParams2.scene);
                }
                UTHitUtils.send(UTHitConstants.PageUccBind, "UccBind_LoginContinueResult", uccParams, hashMap);
            }

            @Override // com.ali.user.open.core.model.RpcRequestCallbackWithCode
            public void onError(String str, RpcResponse rpcResponse) {
                onFail(str, rpcResponse);
            }

            /* access modifiers changed from: package-private */
            public void onFail(String str, RpcResponse rpcResponse) {
                int buidErrorCode = Utils.buidErrorCode(rpcResponse, 1012);
                StringBuilder sb = new StringBuilder();
                sb.append(buidErrorCode);
                String str2 = "";
                sb.append(str2);
                rpcResultlHit(sb.toString(), str2);
                if (TextUtils.equals(str, "h5")) {
                    if (rpcResponse != null) {
                        str2 = rpcResponse.message;
                    }
                    DialogHelper instance = DialogHelper.getInstance();
                    Context context = context;
                    instance.alert((Activity) context, "", str2, context.getString(R.string.member_sdk_iknow), new DialogInterface.OnClickListener() {
                        /* class com.ali.user.open.ucc.biz.UccBindPresenter.AnonymousClass10.AnonymousClass1 */

                        public void onClick(DialogInterface dialogInterface, int i) {
                        }
                    }, "", null);
                    return;
                }
                UccBindPresenter.this.finishActivity(context);
                UccCallback uccCallback = uccCallback;
                if (uccCallback != null) {
                    uccCallback.onFail(uccParams.bindSite, buidErrorCode, Utils.buidErrorMessage(rpcResponse, "skipUpgrade接口错误"));
                }
            }

            @Override // com.ali.user.open.core.model.RpcRequestCallbackWithCode
            public void onSuccess(RpcResponse rpcResponse) {
                rpcResultlHit(rpcResponse.code + "", rpcResponse.actionType);
                T t = rpcResponse.returnValue;
                if (t == null) {
                    UccCallback uccCallback = uccCallback;
                    if (uccCallback != null) {
                        uccCallback.onFail(uccParams.bindSite, 1012, Utils.buidErrorMessage(rpcResponse, "skipUpgrade接口错误"));
                        return;
                    }
                    return;
                }
                UccBindPresenter.this.finishActivity(context);
                UccBindPresenter.this.onBindSuccess(uccParams, map, t, uccCallback);
            }

            @Override // com.ali.user.open.core.model.RpcRequestCallbackWithCode
            public void onSystemError(String str, RpcResponse rpcResponse) {
                onFail(str, rpcResponse);
            }
        });
    }

    public void tokenLoginAfterBind(final Context context, final UccParams uccParams, final String str, final String str2, final String str3, final String str4, final Map<String, String> map, final UccCallback uccCallback) {
        HashMap hashMap = new HashMap();
        hashMap.put("trustToken", str);
        hashMap.put("action", str2);
        UTHitUtils.send(UTHitConstants.PageUccBind, "UccBind_OauthLogin", uccParams, hashMap);
        DataRepository.tokenLoginAfterBind(str, new RpcRequestCallbackWithCode() {
            /* class com.ali.user.open.ucc.biz.UccBindPresenter.AnonymousClass8 */

            private void rpcResultlHit(String str) {
                HashMap hashMap = new HashMap();
                hashMap.put("code", str);
                hashMap.put("action", str2);
                hashMap.put("trustToken", str);
                UTHitUtils.send(UTHitConstants.PageUccBind, "UccBind_OauthLoginResult", uccParams, hashMap);
            }

            @Override // com.ali.user.open.core.model.RpcRequestCallbackWithCode
            public void onError(String str, final RpcResponse rpcResponse) {
                final int buidErrorCode = Utils.buidErrorCode(rpcResponse, 1007);
                StringBuilder sb = new StringBuilder();
                sb.append(buidErrorCode);
                String str2 = "";
                sb.append(str2);
                rpcResultlHit(sb.toString());
                if (rpcResponse != null) {
                    str2 = rpcResponse.message;
                }
                DialogHelper instance = DialogHelper.getInstance();
                Context context = context;
                instance.alert((Activity) context, "", str2, context.getString(R.string.member_sdk_iknow), new DialogInterface.OnClickListener() {
                    /* class com.ali.user.open.ucc.biz.UccBindPresenter.AnonymousClass8.AnonymousClass3 */

                    public void onClick(DialogInterface dialogInterface, int i) {
                        AnonymousClass8 r4 = AnonymousClass8.this;
                        UccBindPresenter.this.finishActivity(context);
                        AnonymousClass8 r42 = AnonymousClass8.this;
                        UccCallback uccCallback = uccCallback;
                        if (uccCallback != null) {
                            uccCallback.onFail(uccParams.bindSite, buidErrorCode, Utils.buidErrorMessage(rpcResponse, "OauthLogin接口错误"));
                        }
                    }
                }, "", null);
            }

            @Override // com.ali.user.open.core.model.RpcRequestCallbackWithCode
            public void onSuccess(RpcResponse rpcResponse) {
                rpcResultlHit(rpcResponse.code + "");
                T t = rpcResponse.returnValue;
                if (context != null && !TextUtils.isEmpty(str4) && TextUtils.equals(str3, "1")) {
                    ((MemberExecutorService) AliMemberSDK.getService(MemberExecutorService.class)).postUITask(new Runnable() {
                        /* class com.ali.user.open.ucc.biz.UccBindPresenter.AnonymousClass8.AnonymousClass1 */

                        public void run() {
                            Toast.makeText(context.getApplicationContext(), str4, 0).show();
                        }
                    });
                }
                UccBindPresenter.this.finishActivity(context);
                UccBindPresenter.this.onBindSuccess(uccParams, map, t, uccCallback);
            }

            @Override // com.ali.user.open.core.model.RpcRequestCallbackWithCode
            public void onSystemError(String str, final RpcResponse rpcResponse) {
                final int buidErrorCode = Utils.buidErrorCode(rpcResponse, 1007);
                StringBuilder sb = new StringBuilder();
                sb.append(buidErrorCode);
                String str2 = "";
                sb.append(str2);
                rpcResultlHit(sb.toString());
                if (rpcResponse != null) {
                    str2 = rpcResponse.message;
                }
                DialogHelper instance = DialogHelper.getInstance();
                Context context = context;
                instance.alert((Activity) context, "", str2, context.getString(R.string.member_sdk_iknow), new DialogInterface.OnClickListener() {
                    /* class com.ali.user.open.ucc.biz.UccBindPresenter.AnonymousClass8.AnonymousClass2 */

                    public void onClick(DialogInterface dialogInterface, int i) {
                        AnonymousClass8 r4 = AnonymousClass8.this;
                        UccBindPresenter.this.finishActivity(context);
                        AnonymousClass8 r42 = AnonymousClass8.this;
                        UccCallback uccCallback = uccCallback;
                        if (uccCallback != null) {
                            uccCallback.onFail(uccParams.bindSite, buidErrorCode, Utils.buidErrorMessage(rpcResponse, "OauthLogin接口错误"));
                        }
                    }
                }, "", null);
            }
        });
    }

    public void updateGrantAuthorization(final UccParams uccParams, Map<String, String> map, final UccCallback uccCallback) {
        DataRepository.updateGrantAuthorization(uccParams, new RpcRequestCallbackWithCode() {
            /* class com.ali.user.open.ucc.biz.UccBindPresenter.AnonymousClass13 */

            @Override // com.ali.user.open.core.model.RpcRequestCallbackWithCode
            public void onError(String str, RpcResponse rpcResponse) {
                if (uccCallback != null) {
                    uccCallback.onFail(uccParams.bindSite, Utils.buidErrorCode(rpcResponse, 1700), Utils.buidErrorMessage(rpcResponse, "updateGrantAuthorization接口失败"));
                }
            }

            @Override // com.ali.user.open.core.model.RpcRequestCallbackWithCode
            public void onSuccess(RpcResponse rpcResponse) {
                HashMap hashMap = new HashMap();
                hashMap.put("data", rpcResponse.returnValue);
                uccCallback.onSuccess(uccParams.bindSite, hashMap);
            }

            @Override // com.ali.user.open.core.model.RpcRequestCallbackWithCode
            public void onSystemError(String str, RpcResponse rpcResponse) {
                onError(str, rpcResponse);
            }
        });
    }
}
