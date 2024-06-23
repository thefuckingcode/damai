package com.ali.user.open.ucc.biz;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.ali.user.open.core.AliMemberSDK;
import com.ali.user.open.core.callback.CallbackManager;
import com.ali.user.open.core.config.WebViewOption;
import com.ali.user.open.core.context.KernelContext;
import com.ali.user.open.core.model.RpcRequestCallbackWithCode;
import com.ali.user.open.core.model.RpcResponse;
import com.ali.user.open.core.util.CommonUtils;
import com.ali.user.open.core.util.ParamsConstants;
import com.ali.user.open.oauth.AppCredential;
import com.ali.user.open.oauth.OauthPlatformConfig;
import com.ali.user.open.oauth.OauthService;
import com.ali.user.open.ucc.UccCallback;
import com.ali.user.open.ucc.UccServiceProviderFactory;
import com.ali.user.open.ucc.data.DataRepository;
import com.ali.user.open.ucc.model.UccParams;
import com.ali.user.open.ucc.util.UTHitConstants;
import com.ali.user.open.ucc.util.UTHitUtils;
import com.ali.user.open.ucc.util.UccConstants;
import com.ali.user.open.ucc.util.Utils;
import com.ali.user.open.ucc.webview.UccWebViewActivity;
import com.ali.user.open.ucc.webview.WebViewDialogActivity;
import com.ali.user.open.ucc.webview.WebViewTransparentActivity;
import com.alibaba.fastjson.JSON;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
public class UccH5Presenter {
    /* access modifiers changed from: private */
    public static void dismissProgressContext(Context context) {
        if (context instanceof Activity) {
            UccBindPresenter.dismissProgress((Activity) context);
        }
    }

    public static void leadNewUserH5Page(final Context context, final UccParams uccParams, final Map<String, String> map, final UccCallback uccCallback) {
        final String str;
        final String str2;
        String str3 = "0";
        if (map != null) {
            String str4 = TextUtils.isEmpty(map.get("needSession")) ? str3 : map.get("needSession");
            if (!TextUtils.isEmpty(map.get(ParamsConstants.Key.PARAM_NEED_TOAST))) {
                str3 = map.get(ParamsConstants.Key.PARAM_NEED_TOAST);
            }
            uccParams.targetPackageName = map.get(ParamsConstants.Key.PARAM_TARGET_PACKAGE_NAME);
            str = str3;
            str2 = str4;
        } else {
            str2 = str3;
            str = str2;
        }
        if (map == null || TextUtils.isEmpty(map.get("site"))) {
            uccParams.site = AliMemberSDK.getMasterSite();
        } else {
            uccParams.site = map.get("site");
        }
        if (map != null && !TextUtils.isEmpty(map.get("scene"))) {
            uccParams.scene = map.get("scene");
        }
        UTHitUtils.send(UTHitConstants.PageUccBind, "UccBind_GetLocalSiteUrl", uccParams, null);
        if (context instanceof Activity) {
            UccBindPresenter.showProgress((Activity) context);
        }
        DataRepository.fetchNewUser(uccParams, new RpcRequestCallbackWithCode() {
            /* class com.ali.user.open.ucc.biz.UccH5Presenter.AnonymousClass1 */

            private void rpcResultHit(String str, String str2) {
                HashMap hashMap = new HashMap();
                hashMap.put("code", str);
                hashMap.put("h5Type", str2);
                UTHitUtils.send(UTHitConstants.PageUccBind, "UccBind_GetLocalSiteUrlResult", uccParams, hashMap);
            }

            @Override // com.ali.user.open.core.model.RpcRequestCallbackWithCode
            public void onError(String str, RpcResponse rpcResponse) {
                UccH5Presenter.dismissProgressContext(context);
                int buidErrorCode = Utils.buidErrorCode(rpcResponse, 1402);
                rpcResultHit(buidErrorCode + "", "");
                UccCallback uccCallback = uccCallback;
                if (uccCallback != null) {
                    uccCallback.onFail(uccParams.bindSite, buidErrorCode, Utils.buidErrorMessage(rpcResponse, "fetchBindPageUrl fail"));
                }
            }

            @Override // com.ali.user.open.core.model.RpcRequestCallbackWithCode
            public void onSuccess(RpcResponse rpcResponse) {
                UccH5Presenter.dismissProgressContext(context);
                T t = rpcResponse.returnValue;
                if (t == null || TextUtils.isEmpty(t.returnUrl)) {
                    UccCallback uccCallback = uccCallback;
                    if (uccCallback != null) {
                        uccCallback.onFail(uccParams.bindSite, 1401, Utils.buidErrorMessage(rpcResponse, "url 为空"));
                        return;
                    }
                    return;
                }
                rpcResultHit(rpcResponse.code + "", t.h5Type);
                HashMap hashMap = new HashMap();
                hashMap.put("h5Type", t.h5Type);
                UTHitUtils.send(UTHitConstants.PageUccBind, "UccBind_GoH5BindAction", uccParams, hashMap);
                Bundle bundle = new Bundle();
                bundle.putString("url", t.returnUrl);
                bundle.putString(UccConstants.PARAM_UCC_PARAMS, JSON.toJSONString(uccParams));
                bundle.putString("needSession", str2);
                bundle.putString(ParamsConstants.Key.PARAM_NEED_TOAST, str);
                bundle.putString("params", Utils.convertMapToJsonStr(map));
                bundle.putString(ParamsConstants.Key.PARAM_HALF_H5, (String) map.get(ParamsConstants.Key.PARAM_HALF_H5));
                if (!"default".equals(t.urlType)) {
                    bundle.putString(ParamsConstants.Key.PRAMA_TRANSPARENT_H5, (String) map.get(ParamsConstants.Key.PRAMA_TRANSPARENT_H5));
                }
                Map map = map;
                if (map == null || !TextUtils.equals((CharSequence) map.get("callbackType"), "pageClose")) {
                    UccH5Presenter.openUrl(context, bundle, null);
                    uccCallback.onSuccess(uccParams.bindSite, new HashMap());
                    return;
                }
                UccH5Presenter.openUrl(context, bundle, uccCallback);
            }

            @Override // com.ali.user.open.core.model.RpcRequestCallbackWithCode
            public void onSystemError(String str, RpcResponse rpcResponse) {
                UccH5Presenter.dismissProgressContext(context);
                int buidErrorCode = Utils.buidErrorCode(rpcResponse, 1402);
                rpcResultHit(buidErrorCode + "", "");
                UccCallback uccCallback = uccCallback;
                if (uccCallback != null) {
                    uccCallback.onFail(uccParams.bindSite, buidErrorCode, Utils.buidErrorMessage(rpcResponse, "获取页面失败"));
                }
            }
        });
    }

    public static void leadNoLoginNewUserH5Page(final Context context, final UccParams uccParams, final Map<String, String> map, final UccCallback uccCallback) {
        final String str;
        final String str2;
        String str3 = "0";
        if (map != null) {
            String str4 = TextUtils.isEmpty(map.get("needSession")) ? str3 : map.get("needSession");
            if (!TextUtils.isEmpty(map.get(ParamsConstants.Key.PARAM_NEED_TOAST))) {
                str3 = map.get(ParamsConstants.Key.PARAM_NEED_TOAST);
            }
            str = str3;
            str2 = str4;
        } else {
            str2 = str3;
            str = str2;
        }
        if (map == null || TextUtils.isEmpty(map.get("site"))) {
            uccParams.site = AliMemberSDK.getMasterSite();
        } else {
            uccParams.site = map.get("site");
        }
        if (map != null && !TextUtils.isEmpty(map.get("scene"))) {
            uccParams.scene = map.get("scene");
        }
        if (map != null && !TextUtils.isEmpty(map.get("mobile"))) {
            uccParams.maskMobile = map.get("mobile");
        }
        UTHitUtils.send(UTHitConstants.PageUccBind, "UccBind_GetLocalSiteUrl", uccParams, null);
        if (context instanceof Activity) {
            UccBindPresenter.showProgress((Activity) context);
        }
        DataRepository.fetchNoLoginNewUserUrl(uccParams, new RpcRequestCallbackWithCode() {
            /* class com.ali.user.open.ucc.biz.UccH5Presenter.AnonymousClass2 */

            private void rpcResultHit(String str, String str2) {
                HashMap hashMap = new HashMap();
                hashMap.put("code", str);
                hashMap.put("h5Type", str2);
                UTHitUtils.send(UTHitConstants.PageUccBind, "UccBind_GetLocalSiteUrlResult", uccParams, hashMap);
            }

            @Override // com.ali.user.open.core.model.RpcRequestCallbackWithCode
            public void onError(String str, RpcResponse rpcResponse) {
                UccH5Presenter.dismissProgressContext(context);
                int buidErrorCode = Utils.buidErrorCode(rpcResponse, 1402);
                rpcResultHit(buidErrorCode + "", "");
                UccCallback uccCallback = uccCallback;
                if (uccCallback != null) {
                    uccCallback.onFail(uccParams.bindSite, buidErrorCode, Utils.buidErrorMessage(rpcResponse, "fetchBindPageUrl fail"));
                }
            }

            @Override // com.ali.user.open.core.model.RpcRequestCallbackWithCode
            public void onSuccess(RpcResponse rpcResponse) {
                UccH5Presenter.dismissProgressContext(context);
                T t = rpcResponse.returnValue;
                if (t == null || TextUtils.isEmpty(t.returnUrl)) {
                    UccCallback uccCallback = uccCallback;
                    if (uccCallback != null) {
                        uccCallback.onFail(uccParams.bindSite, 1401, Utils.buidErrorMessage(rpcResponse, "url 为空"));
                        return;
                    }
                    return;
                }
                rpcResultHit(rpcResponse.code + "", t.h5Type);
                HashMap hashMap = new HashMap();
                hashMap.put("h5Type", t.h5Type);
                UTHitUtils.send(UTHitConstants.PageUccBind, "UccBind_GoH5BindAction", uccParams, hashMap);
                Bundle bundle = new Bundle();
                bundle.putString("url", t.returnUrl);
                bundle.putString(UccConstants.PARAM_UCC_PARAMS, JSON.toJSONString(uccParams));
                bundle.putString("needSession", str2);
                bundle.putString(ParamsConstants.Key.PARAM_NEED_TOAST, str);
                bundle.putString("params", Utils.convertMapToJsonStr(map));
                bundle.putString(ParamsConstants.Key.PARAM_HALF_H5, (String) map.get(ParamsConstants.Key.PARAM_HALF_H5));
                if (!"default".equals(t.urlType)) {
                    bundle.putString(ParamsConstants.Key.PRAMA_TRANSPARENT_H5, (String) map.get(ParamsConstants.Key.PRAMA_TRANSPARENT_H5));
                }
                bundle.putString("webviewOption", WebViewOption.UC.name());
                UccH5Presenter.openUrl(context, bundle, null);
                uccCallback.onSuccess(uccParams.bindSite, new HashMap());
            }

            @Override // com.ali.user.open.core.model.RpcRequestCallbackWithCode
            public void onSystemError(String str, RpcResponse rpcResponse) {
                UccH5Presenter.dismissProgressContext(context);
                int buidErrorCode = Utils.buidErrorCode(rpcResponse, 1402);
                rpcResultHit(buidErrorCode + "", "");
                UccCallback uccCallback = uccCallback;
                if (uccCallback != null) {
                    uccCallback.onFail(uccParams.bindSite, buidErrorCode, Utils.buidErrorMessage(rpcResponse, "获取页面失败"));
                }
            }
        });
    }

    public static void openUrl(Context context, Bundle bundle, UccCallback uccCallback) {
        Intent intent;
        String str;
        String str2;
        if (context == null) {
            context = KernelContext.getApplicationContext();
        }
        if (uccCallback != null) {
            CallbackManager.registerCallback(UccConstants.UCC_H5_CALLBACK_TYPE, uccCallback);
        }
        if (bundle != null && "1".equals(bundle.get(ParamsConstants.Key.PARAM_HALF_H5))) {
            intent = new Intent(context, WebViewDialogActivity.class);
            if (bundle.getString("url") != null) {
                boolean darkModeStatus = CommonUtils.getDarkModeStatus(context);
                String string = bundle.getString("url");
                if (darkModeStatus && !string.contains("theme=dark")) {
                    if (string.indexOf("?") > -1) {
                        str2 = string + "&theme=dark";
                    } else {
                        str2 = string + "?theme=dark";
                    }
                    bundle.putString("url", str2);
                }
            }
        } else if (bundle == null || !"1".equals(bundle.get(ParamsConstants.Key.PRAMA_TRANSPARENT_H5))) {
            intent = new Intent(context, UccWebViewActivity.class);
        } else {
            intent = new Intent(context, WebViewTransparentActivity.class);
            if (bundle.getString("url") != null) {
                boolean darkModeStatus2 = CommonUtils.getDarkModeStatus(context);
                String string2 = bundle.getString("url");
                if (darkModeStatus2 && !string2.contains("theme=dark")) {
                    if (string2.indexOf("?") > -1) {
                        str = string2 + "&theme=dark";
                    } else {
                        str = string2 + "?theme=dark";
                    }
                    bundle.putString("url", str);
                }
            }
        }
        intent.putExtras(bundle);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
        try {
            if (context instanceof WebViewDialogActivity) {
                ((WebViewDialogActivity) context).finish();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void showH5BindPage(final Activity activity, final UccParams uccParams, final Map<String, String> map, final boolean z, final UccCallback uccCallback) {
        final String str;
        final String str2;
        String str3 = "0";
        if (map != null) {
            String str4 = TextUtils.isEmpty(map.get("needSession")) ? str3 : map.get("needSession");
            if (!TextUtils.isEmpty(map.get(ParamsConstants.Key.PARAM_NEED_TOAST))) {
                str3 = map.get(ParamsConstants.Key.PARAM_NEED_TOAST);
            }
            str = str3;
            str2 = str4;
        } else {
            str2 = str3;
            str = str2;
        }
        if (map == null || TextUtils.isEmpty(map.get(UccConstants.PARAM_BIND_URL))) {
            if (map == null || TextUtils.isEmpty(map.get("site"))) {
                uccParams.site = AliMemberSDK.getMasterSite();
            } else {
                uccParams.site = map.get("site");
            }
            if (map != null && !TextUtils.isEmpty(map.get("scene"))) {
                uccParams.scene = map.get("scene");
            }
            uccParams.createBindSiteSession = TextUtils.equals("1", str2);
            UTHitUtils.send(UTHitConstants.PageUccBind, "UccBind_GetLocalSiteUrl", uccParams, null);
            DataRepository.fetchBindPageUrl(uccParams, new RpcRequestCallbackWithCode() {
                /* class com.ali.user.open.ucc.biz.UccH5Presenter.AnonymousClass3 */

                private void rpcResultHit(String str, String str2) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("code", str);
                    hashMap.put("h5Type", str2);
                    UTHitUtils.send(UTHitConstants.PageUccBind, "UccBind_GetLocalSiteUrlResult", uccParams, hashMap);
                }

                @Override // com.ali.user.open.core.model.RpcRequestCallbackWithCode
                public void onError(String str, RpcResponse rpcResponse) {
                    int buidErrorCode = Utils.buidErrorCode(rpcResponse, 1402);
                    rpcResultHit(buidErrorCode + "", "");
                    UccCallback uccCallback = uccCallback;
                    if (uccCallback != null) {
                        uccCallback.onFail(uccParams.bindSite, buidErrorCode, Utils.buidErrorMessage(rpcResponse, "fetchBindPageUrl fail"));
                    }
                }

                @Override // com.ali.user.open.core.model.RpcRequestCallbackWithCode
                public void onSuccess(RpcResponse rpcResponse) {
                    T t = rpcResponse.returnValue;
                    if (t != null && t.nativeFirst && !z) {
                        AppCredential oauthConfigByPlatform = OauthPlatformConfig.getOauthConfigByPlatform(uccParams.bindSite);
                        Map map = map;
                        if (map != null) {
                            map.remove(ParamsConstants.Key.PARAM_ENABLE_RECOMMEND_BIND);
                        }
                        if (((OauthService) AliMemberSDK.getService(OauthService.class)).isAppAuthSurpport(activity, uccParams.bindSite)) {
                            map.put(ParamsConstants.Key.PARAM_FORCE_NATIVE, "1");
                        }
                        UccServiceProviderFactory.getInstance().getUccServiceProvider(uccParams.bindSite).bind(activity, uccParams, oauthConfigByPlatform, map, uccCallback);
                    } else if (t == null || TextUtils.isEmpty(t.returnUrl)) {
                        UccCallback uccCallback = uccCallback;
                        if (uccCallback != null) {
                            uccCallback.onFail(uccParams.bindSite, 1401, Utils.buidErrorMessage(rpcResponse, "url 为空"));
                        }
                    } else {
                        rpcResultHit(rpcResponse.code + "", t.h5Type);
                        HashMap hashMap = new HashMap();
                        hashMap.put("h5Type", t.h5Type);
                        UTHitUtils.send(UTHitConstants.PageUccBind, "UccBind_GoH5BindAction", uccParams, hashMap);
                        Bundle bundle = new Bundle();
                        bundle.putString("url", t.returnUrl);
                        bundle.putString(UccConstants.PARAM_UCC_PARAMS, JSON.toJSONString(uccParams));
                        bundle.putString("needSession", str2);
                        bundle.putString(ParamsConstants.Key.PARAM_NEED_TOAST, str);
                        bundle.putString("params", Utils.convertMapToJsonStr(map));
                        Map map2 = map;
                        if (map2 != null) {
                            bundle.putString(ParamsConstants.Key.PARAM_HALF_H5, (String) map2.get(ParamsConstants.Key.PARAM_HALF_H5));
                        }
                        UccH5Presenter.openUrl(activity, bundle, uccCallback);
                    }
                }

                @Override // com.ali.user.open.core.model.RpcRequestCallbackWithCode
                public void onSystemError(String str, RpcResponse rpcResponse) {
                    int buidErrorCode = Utils.buidErrorCode(rpcResponse, 1402);
                    rpcResultHit(buidErrorCode + "", "");
                    UccCallback uccCallback = uccCallback;
                    if (uccCallback != null) {
                        uccCallback.onFail(uccParams.bindSite, buidErrorCode, Utils.buidErrorMessage(rpcResponse, "获取页面失败"));
                    }
                }
            });
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("h5Type", map.get("h5Type"));
        UTHitUtils.send(UTHitConstants.PageUccBind, "UccBind_GoH5BindAction", uccParams, hashMap);
        Bundle bundle = new Bundle();
        bundle.putString("url", map.get(UccConstants.PARAM_BIND_URL));
        bundle.putString(UccConstants.PARAM_UCC_PARAMS, JSON.toJSONString(uccParams));
        bundle.putString("needSession", str2);
        bundle.putString(ParamsConstants.Key.PARAM_NEED_TOAST, str);
        bundle.putString("params", Utils.convertMapToJsonStr(map));
        bundle.putString(ParamsConstants.Key.PARAM_HALF_H5, map.get(ParamsConstants.Key.PARAM_HALF_H5));
        bundle.putString("requestToken", map.get("requestToken"));
        openUrl(activity, bundle, uccCallback);
    }

    public static void showH5BindPageFoeNewBind(final Context context, final UccParams uccParams, String str, final Map<String, String> map, final UccCallback uccCallback) {
        final String str2;
        final String str3;
        String str4 = "0";
        if (map != null) {
            String str5 = TextUtils.isEmpty(map.get("needSession")) ? str4 : map.get("needSession");
            if (!TextUtils.isEmpty(map.get(ParamsConstants.Key.PARAM_NEED_TOAST))) {
                str4 = map.get(ParamsConstants.Key.PARAM_NEED_TOAST);
            }
            str2 = str4;
            str3 = str5;
        } else {
            str3 = str4;
            str2 = str3;
        }
        UccParams uccParams2 = new UccParams();
        if (map == null || TextUtils.isEmpty(map.get("site"))) {
            uccParams2.site = AliMemberSDK.getMasterSite();
        } else {
            uccParams2.site = map.get("site");
        }
        uccParams2.bindSite = uccParams.bindSite;
        uccParams2.userToken = uccParams.userToken;
        if (map != null && !TextUtils.isEmpty(map.get("scene"))) {
            uccParams2.scene = map.get("scene");
        }
        uccParams2.createBindSiteSession = TextUtils.equals("1", str3);
        UTHitUtils.send(UTHitConstants.PageUccBind, "UccBindWithIbb_GetLocalSiteUrl", uccParams, null);
        DataRepository.fetchNewBindPageUrl(uccParams2, str, new RpcRequestCallbackWithCode() {
            /* class com.ali.user.open.ucc.biz.UccH5Presenter.AnonymousClass4 */

            private void rpcResultHit(String str, String str2) {
                HashMap hashMap = new HashMap();
                hashMap.put("code", str);
                hashMap.put("h5Type", str2);
                UTHitUtils.send(UTHitConstants.PageUccBind, "UccBindWithIbb_GetLocalSiteUrlResult", uccParams, hashMap);
            }

            @Override // com.ali.user.open.core.model.RpcRequestCallbackWithCode
            public void onError(String str, RpcResponse rpcResponse) {
                int buidErrorCode = Utils.buidErrorCode(rpcResponse, 1402);
                rpcResultHit(buidErrorCode + "", "");
                UccCallback uccCallback = uccCallback;
                if (uccCallback != null) {
                    uccCallback.onFail(uccParams.bindSite, buidErrorCode, Utils.buidErrorMessage(rpcResponse, "fetchBindPageUrl fail"));
                }
            }

            @Override // com.ali.user.open.core.model.RpcRequestCallbackWithCode
            public void onSuccess(RpcResponse rpcResponse) {
                T t = rpcResponse.returnValue;
                if (t == null || TextUtils.isEmpty(t.returnUrl)) {
                    UccCallback uccCallback = uccCallback;
                    if (uccCallback != null) {
                        uccCallback.onFail(uccParams.bindSite, 1401, Utils.buidErrorMessage(rpcResponse, "url 为空"));
                        return;
                    }
                    return;
                }
                rpcResultHit(rpcResponse.code + "", t.h5Type);
                HashMap hashMap = new HashMap();
                hashMap.put("h5Type", t.h5Type);
                UTHitUtils.send(UTHitConstants.PageUccBind, "UccBindWithIbb_GoH5BindAction", uccParams, hashMap);
                Bundle bundle = new Bundle();
                bundle.putString("url", t.returnUrl);
                bundle.putString(UccConstants.PARAM_UCC_PARAMS, JSON.toJSONString(uccParams));
                bundle.putString("needSession", str3);
                bundle.putString(ParamsConstants.Key.PARAM_NEED_TOAST, str2);
                bundle.putString("params", Utils.convertMapToJsonStr(map));
                UccH5Presenter.openUrl(context, bundle, uccCallback);
            }

            @Override // com.ali.user.open.core.model.RpcRequestCallbackWithCode
            public void onSystemError(String str, RpcResponse rpcResponse) {
                int buidErrorCode = Utils.buidErrorCode(rpcResponse, 1402);
                rpcResultHit(buidErrorCode + "", "");
                UccCallback uccCallback = uccCallback;
                if (uccCallback != null) {
                    uccCallback.onFail(uccParams.bindSite, buidErrorCode, Utils.buidErrorMessage(rpcResponse, "获取页面失败"));
                }
            }
        });
    }
}
