package com.ali.user.mobile.verify;

import android.content.Context;
import android.text.TextUtils;
import com.ali.user.mobile.app.constant.UTConstant;
import com.ali.user.mobile.app.dataprovider.DataProviderFactory;
import com.ali.user.mobile.callback.RpcRequestCallback;
import com.ali.user.mobile.eventbus.Event;
import com.ali.user.mobile.eventbus.EventBus;
import com.ali.user.mobile.eventbus.EventBusEnum;
import com.ali.user.mobile.eventbus.EventListener;
import com.ali.user.mobile.log.TLogAdapter;
import com.ali.user.mobile.log.UserTrackAdapter;
import com.ali.user.mobile.model.CommonCallback;
import com.ali.user.mobile.model.FingerInfo;
import com.ali.user.mobile.model.UrlParam;
import com.ali.user.mobile.rpc.RpcResponse;
import com.ali.user.mobile.rpc.safe.AES;
import com.ali.user.mobile.security.SecurityGuardManagerWraper;
import com.ali.user.mobile.service.FingerprintService;
import com.ali.user.mobile.service.NavigatorService;
import com.ali.user.mobile.service.ServiceFactory;
import com.ali.user.mobile.utils.BackgroundExecutor;
import com.ali.user.mobile.verify.impl.VerifyServiceImpl;
import com.ali.user.mobile.verify.model.OpenBiometricData;
import com.ali.user.mobile.verify.model.VerifyParam;
import com.taobao.login4android.config.LoginSwitch;
import com.taobao.login4android.session.SessionManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
public class VerifyApi {
    public static final int CLOSE_FINGER_ERROR = 4010;
    public static final int CLOSE_FINGER_ILLEGAL = 4010;
    public static final int FINGER_VERIFY_INVALID_PARAM = 4020;
    public static final int FINGER_VERIFY_NO_BIO_KEY = 4021;
    public static final int OPEN_FINGER_CANCEL = 4002;
    public static final int OPEN_FINGER_ERROR = 4001;
    public static final int OPEN_FINGER_ILLEGAL = 4003;
    public static final int OPEN_FINGER_UNROLL = 4004;
    private static String TAG = "login.verify";

    protected static void afterOpenRpcSuccess(Context context, final CommonCallback commonCallback, final RpcResponse<OpenBiometricData> rpcResponse) {
        T t;
        if (rpcResponse == null || (t = rpcResponse.returnValue) == null || TextUtils.isEmpty(t.biometricKey) || TextUtils.isEmpty(rpcResponse.returnValue.biometricId)) {
            commonCallback.onFail(4001, "指纹开启失败");
        } else if (ServiceFactory.getService(FingerprintService.class) != null) {
            ((NavigatorService) ServiceFactory.getService(NavigatorService.class)).fingerSet(context, new CommonCallback() {
                /* class com.ali.user.mobile.verify.VerifyApi.AnonymousClass5 */

                @Override // com.ali.user.mobile.model.CommonCallback
                public void onFail(int i, String str) {
                    commonCallback.onFail(i, str);
                }

                @Override // com.ali.user.mobile.model.CommonCallback
                public void onSuccess() {
                    VerifyApi.handleResponse(rpcResponse);
                    commonCallback.onSuccess();
                }
            });
        } else {
            commonCallback.onFail(4001, "未引入指纹模块");
        }
    }

    protected static void callOpenRpc(final Context context, final VerifyParam verifyParam, final CommonCallback commonCallback) {
        try {
            VerifyServiceImpl.getInstance().openFinger(verifyParam, new RpcRequestCallback<OpenBiometricData>() {
                /* class com.ali.user.mobile.verify.VerifyApi.AnonymousClass4 */

                @Override // com.ali.user.mobile.callback.RpcRequestCallback
                public void onError(final RpcResponse<OpenBiometricData> rpcResponse) {
                    T t;
                    if (rpcResponse == null || (t = rpcResponse.returnValue) == null || TextUtils.isEmpty(t.h5Url) || !"H5".equals(rpcResponse.actionType)) {
                        onSystemError(rpcResponse);
                        return;
                    }
                    EventBus.getDefault().registerEventListener(EventBusEnum.EventName.ACTION_H5, new EventListener() {
                        /* class com.ali.user.mobile.verify.VerifyApi.AnonymousClass4.AnonymousClass1 */

                        @Override // com.ali.user.mobile.eventbus.EventListener
                        public void onEvent(Event event) {
                            Map<String, Object> map;
                            EventBus.getDefault().unregisterEventListener(EventBusEnum.EventName.ACTION_H5, this);
                            if (event == null || (map = event.params) == null) {
                                AnonymousClass4.this.onSystemError(rpcResponse);
                                return;
                            }
                            String str = (String) map.get("token");
                            String str2 = (String) event.params.get("result");
                            if (!TextUtils.isEmpty(str) && TextUtils.equals(str2, "success")) {
                                VerifyParam verifyParam = new VerifyParam();
                                AnonymousClass4 r1 = AnonymousClass4.this;
                                VerifyParam verifyParam2 = verifyParam;
                                verifyParam.biometricId = verifyParam2.biometricId;
                                verifyParam.requestScene = verifyParam2.requestScene;
                                verifyParam.ivToken = str;
                                verifyParam.loginToken = verifyParam2.loginToken;
                                VerifyApi.setAfterLogin(context, verifyParam, commonCallback);
                            } else if (TextUtils.equals(str2, "cancel")) {
                                commonCallback.onFail(4002, "取消指纹开启");
                            } else {
                                AnonymousClass4.this.onSystemError(rpcResponse);
                            }
                        }
                    });
                    UrlParam urlParam = new UrlParam();
                    urlParam.url = rpcResponse.returnValue.h5Url;
                    ((NavigatorService) ServiceFactory.getService(NavigatorService.class)).navToWebViewPage(EventBusEnum.EventName.ACTION_H5, urlParam);
                }

                @Override // com.ali.user.mobile.callback.RpcRequestCallback
                public void onSuccess(RpcResponse<OpenBiometricData> rpcResponse) {
                    VerifyApi.afterOpenRpcSuccess(context, commonCallback, rpcResponse);
                }

                @Override // com.ali.user.mobile.callback.RpcRequestCallback
                public void onSystemError(RpcResponse<OpenBiometricData> rpcResponse) {
                    commonCallback.onFail(4001, "指纹开启失败");
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
            commonCallback.onFail(4001, "指纹开启失败");
        }
    }

    public static void closeBiometric(final VerifyParam verifyParam, final CommonCallback commonCallback) {
        if (commonCallback != null) {
            if (verifyParam == null) {
                commonCallback.onFail(4010, "参数非法");
                return;
            }
            try {
                if (TextUtils.isEmpty(verifyParam.biometricId)) {
                    verifyParam.biometricId = SessionManager.getInstance(DataProviderFactory.getApplicationContext()).getBiometricId();
                }
                VerifyServiceImpl.getInstance().closeFinger(verifyParam, new RpcRequestCallback<Void>() {
                    /* class com.ali.user.mobile.verify.VerifyApi.AnonymousClass6 */

                    @Override // com.ali.user.mobile.callback.RpcRequestCallback
                    public void onError(RpcResponse<Void> rpcResponse) {
                        onSystemError(rpcResponse);
                    }

                    @Override // com.ali.user.mobile.callback.RpcRequestCallback
                    public void onSuccess(RpcResponse<Void> rpcResponse) {
                        if (verifyParam.list != null) {
                            SecurityGuardManagerWraper.removeAllFinger();
                        } else {
                            FingerInfo fingerInfo = new FingerInfo();
                            fingerInfo.key = verifyParam.biometricId;
                            SecurityGuardManagerWraper.removeFinger(fingerInfo);
                        }
                        commonCallback.onSuccess();
                    }

                    @Override // com.ali.user.mobile.callback.RpcRequestCallback
                    public void onSystemError(RpcResponse<Void> rpcResponse) {
                        commonCallback.onFail(4010, "指纹关闭失败");
                    }
                });
            } catch (Throwable unused) {
                commonCallback.onFail(4010, "指纹关闭失败");
            }
        }
    }

    protected static void handleResponse(RpcResponse<OpenBiometricData> rpcResponse) {
        FingerInfo fingerInfo = new FingerInfo();
        T t = rpcResponse.returnValue;
        fingerInfo.key = t.biometricId;
        fingerInfo.value = t.biometricKey;
        fingerInfo.loginTime = t.biometricOpenTime == 0 ? System.currentTimeMillis() : t.biometricOpenTime;
        saveFingerInBackground(fingerInfo, rpcResponse.returnValue.biometricIdList);
    }

    public static void invalidAll() {
        UserTrackAdapter.sendUT("FingerInvalidAll");
        BackgroundExecutor.execute(new Runnable() {
            /* class com.ali.user.mobile.verify.VerifyApi.AnonymousClass7 */

            public void run() {
                List<FingerInfo> fingerList = SecurityGuardManagerWraper.getFingerList();
                if (fingerList != null && fingerList.size() != 0) {
                    VerifyParam verifyParam = new VerifyParam();
                    verifyParam.list = fingerList;
                    verifyParam.requestScene = "biometric_changed";
                    VerifyApi.closeBiometric(verifyParam, new CommonCallback() {
                        /* class com.ali.user.mobile.verify.VerifyApi.AnonymousClass7.AnonymousClass1 */

                        @Override // com.ali.user.mobile.model.CommonCallback
                        public void onFail(int i, String str) {
                            TLogAdapter.e(VerifyApi.TAG, "close biometric failed");
                            SecurityGuardManagerWraper.removeAllFinger();
                        }

                        @Override // com.ali.user.mobile.model.CommonCallback
                        public void onSuccess() {
                            TLogAdapter.e(VerifyApi.TAG, "close biometric success");
                        }
                    });
                }
            }
        });
    }

    public static void openBiometric(final Context context, final VerifyParam verifyParam, final CommonCallback commonCallback) {
        if (commonCallback != null) {
            if (verifyParam != null) {
                try {
                    if (!TextUtils.isEmpty(verifyParam.requestScene)) {
                        if (ServiceFactory.getService(FingerprintService.class) == null) {
                            commonCallback.onFail(4001, "未接入指纹SDK");
                            return;
                        } else if (!((FingerprintService) ServiceFactory.getService(FingerprintService.class)).isFingerprintSetable()) {
                            commonCallback.onFail(4001, "指纹硬件不支持");
                            return;
                        } else if ("account_center".equals(verifyParam.requestScene) || ((FingerprintService) ServiceFactory.getService(FingerprintService.class)).isFingerprintAvailable()) {
                            try {
                                UserTrackAdapter.sendUT("setFingerCheck");
                                new AES().checkValid(new CommonCallback() {
                                    /* class com.ali.user.mobile.verify.VerifyApi.AnonymousClass1 */

                                    @Override // com.ali.user.mobile.model.CommonCallback
                                    public void onFail(int i, String str) {
                                        UserTrackAdapter.sendUT(UTConstant.PageName.UT_PAGE_EXTEND, "setFingerCheck_fail", String.valueOf(i), null);
                                        if ("login_success".equals(verifyParam.requestScene)) {
                                            VerifyApi.setAfterLogin(context, verifyParam, commonCallback);
                                        } else {
                                            VerifyApi.callOpenRpc(context, verifyParam, commonCallback);
                                        }
                                    }

                                    @Override // com.ali.user.mobile.model.CommonCallback
                                    public void onSuccess() {
                                        UserTrackAdapter.sendUT("setFingerCheck_success");
                                        if ("login_success".equals(verifyParam.requestScene)) {
                                            VerifyApi.setAfterLogin(context, verifyParam, commonCallback);
                                        } else {
                                            VerifyApi.callOpenRpc(context, verifyParam, commonCallback);
                                        }
                                    }
                                });
                                return;
                            } catch (Throwable unused) {
                            }
                        } else {
                            commonCallback.onFail(4004, "指纹未录入");
                            return;
                        }
                    }
                } catch (Throwable unused2) {
                }
            }
            commonCallback.onFail(4003, "参数不合法");
            return;
        }
        return;
        commonCallback.onFail(4001, "指纹开启失败");
        th.printStackTrace();
        return;
        th.printStackTrace();
    }

    public static void saveFingerInBackground(final FingerInfo fingerInfo, final ArrayList<String> arrayList) {
        if (LoginSwitch.getSwitch("degradeFingerBackground", "true")) {
            SecurityGuardManagerWraper.saveFinger(fingerInfo, arrayList);
            try {
                if (TextUtils.isEmpty(SecurityGuardManagerWraper.getFingerValue(fingerInfo.key))) {
                    UserTrackAdapter.sendUT("LostFingerToken");
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        } else {
            BackgroundExecutor.execute(new Runnable() {
                /* class com.ali.user.mobile.verify.VerifyApi.AnonymousClass3 */

                public void run() {
                    SecurityGuardManagerWraper.saveFinger(fingerInfo, arrayList);
                    try {
                        if (TextUtils.isEmpty(SecurityGuardManagerWraper.getFingerValue(fingerInfo.key))) {
                            UserTrackAdapter.sendUT("LostFingerToken");
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
        }
    }

    protected static void setAfterLogin(Context context, final VerifyParam verifyParam, final CommonCallback commonCallback) {
        if (ServiceFactory.getService(FingerprintService.class) != null) {
            ((NavigatorService) ServiceFactory.getService(NavigatorService.class)).fingerSet(context, new CommonCallback() {
                /* class com.ali.user.mobile.verify.VerifyApi.AnonymousClass2 */

                @Override // com.ali.user.mobile.model.CommonCallback
                public void onFail(int i, String str) {
                    commonCallback.onFail(i, str);
                }

                @Override // com.ali.user.mobile.model.CommonCallback
                public void onSuccess() {
                    VerifyServiceImpl.getInstance().openFinger(verifyParam, new RpcRequestCallback<OpenBiometricData>() {
                        /* class com.ali.user.mobile.verify.VerifyApi.AnonymousClass2.AnonymousClass1 */

                        @Override // com.ali.user.mobile.callback.RpcRequestCallback
                        public void onError(RpcResponse<OpenBiometricData> rpcResponse) {
                            commonCallback.onFail(4001, "指纹开启失败");
                        }

                        @Override // com.ali.user.mobile.callback.RpcRequestCallback
                        public void onSuccess(RpcResponse<OpenBiometricData> rpcResponse) {
                            VerifyApi.handleResponse(rpcResponse);
                            commonCallback.onSuccess();
                        }

                        @Override // com.ali.user.mobile.callback.RpcRequestCallback
                        public void onSystemError(RpcResponse<OpenBiometricData> rpcResponse) {
                            commonCallback.onFail(4001, "指纹开启失败");
                        }
                    });
                }
            });
        } else {
            commonCallback.onFail(4001, "未引入指纹模块");
        }
    }
}
