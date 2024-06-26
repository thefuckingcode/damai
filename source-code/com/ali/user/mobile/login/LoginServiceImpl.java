package com.ali.user.mobile.login;

import android.content.Context;
import android.text.TextUtils;
import com.ali.user.mobile.app.dataprovider.DataProviderFactory;
import com.ali.user.mobile.base.helper.BroadCastHelper;
import com.ali.user.mobile.base.helper.LoginDataHelper;
import com.ali.user.mobile.callback.CommonDataCallback;
import com.ali.user.mobile.callback.RpcRequestCallback;
import com.ali.user.mobile.login.action.LoginResActions;
import com.ali.user.mobile.model.CommonCallback;
import com.ali.user.mobile.model.LoginParam;
import com.ali.user.mobile.model.NumAuthTokenCallback;
import com.ali.user.mobile.model.TokenType;
import com.ali.user.mobile.model.UrlParam;
import com.ali.user.mobile.rpc.ApiConstants;
import com.ali.user.mobile.rpc.RpcResponse;
import com.ali.user.mobile.rpc.login.model.DefaultLoginResponseData;
import com.ali.user.mobile.rpc.login.model.LoginReturnData;
import com.ali.user.mobile.service.LoginService;
import com.ali.user.mobile.service.NumberAuthService;
import com.ali.user.mobile.service.ServiceFactory;
import com.ali.user.mobile.url.service.impl.UrlUtil;
import com.ali.user.open.ucc.util.UccConstants;
import com.alibaba.fastjson.JSON;
import com.taobao.login4android.constants.LoginStatus;
import java.util.Map;

/* compiled from: Taobao */
public class LoginServiceImpl implements LoginService {
    private final int ONEKEY_LOGIN_FAIL_CODE_LOGIN_DATA_NULL = -1;
    private final int ONEKEY_LOGIN_FAIL_CODE_NEED_IV = -3;
    private final int ONEKEY_LOGIN_FAIL_CODE_RESPONSE_NULL = -2;

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void onReceiveUCCH5(Context context, LoginParam loginParam, RpcResponse<LoginReturnData> rpcResponse, final CommonCallback commonCallback) {
        String str = rpcResponse.returnValue.h5Url;
        UrlParam urlParam = new UrlParam();
        urlParam.url = str;
        urlParam.loginType = loginParam.nativeLoginType;
        urlParam.loginParam = loginParam;
        UrlUtil.OpenUCC(context, urlParam, new CommonDataCallback() {
            /* class com.ali.user.mobile.login.LoginServiceImpl.AnonymousClass3 */

            @Override // com.ali.user.mobile.callback.CommonDataCallback
            public void onFail(int i, String str) {
                LoginStatus.resetLoginFlag();
                CommonCallback commonCallback = commonCallback;
                if (commonCallback != null) {
                    commonCallback.onFail(i, str);
                }
            }

            @Override // com.ali.user.mobile.callback.CommonDataCallback
            public void onSuccess(Map<String, String> map) {
                LoginStatus.resetLoginFlag();
                if (map != null) {
                    String str = map.get(UccConstants.PARAM_LOGIN_DATA);
                    if (!TextUtils.isEmpty(str)) {
                        T t = (T) ((LoginReturnData) JSON.parseObject(str, LoginReturnData.class));
                        RpcResponse rpcResponse = new RpcResponse();
                        rpcResponse.returnValue = t;
                        rpcResponse.actionType = "SUCCESS";
                        LoginDataHelper.processLoginReturnData(true, (LoginReturnData) t, LoginStatus.browserRefUrl);
                        CommonCallback commonCallback = commonCallback;
                        if (commonCallback != null) {
                            commonCallback.onSuccess();
                            return;
                        }
                        return;
                    }
                    CommonCallback commonCallback2 = commonCallback;
                    if (commonCallback2 != null) {
                        commonCallback2.onFail(LoginResActions.LoginFailCode.UCC_LOGIN_EXCEPTION, "");
                        return;
                    }
                    return;
                }
                CommonCallback commonCallback3 = commonCallback;
                if (commonCallback3 != null) {
                    commonCallback3.onFail(LoginResActions.LoginFailCode.UCC_LOGIN_EXCEPTION, "");
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void simLogin(final Context context, final LoginParam loginParam, Map<String, String> map, final CommonCallback commonCallback) {
        LoginDataRepository.getInstance().simLogin(loginParam, map, new RpcRequestCallback() {
            /* class com.ali.user.mobile.login.LoginServiceImpl.AnonymousClass2 */

            @Override // com.ali.user.mobile.callback.RpcRequestCallback
            public void onError(RpcResponse rpcResponse) {
                int i;
                CommonCallback commonCallback;
                if (rpcResponse != null) {
                    String str = rpcResponse.actionType;
                    if (TextUtils.isEmpty(str) || !"H5".equals(str)) {
                        if (ApiConstants.ResultActionType.UCC_H5.equals(str)) {
                            LoginServiceImpl.this.onReceiveUCCH5(context, loginParam, rpcResponse, commonCallback);
                        }
                    } else if (!TextUtils.isEmpty(((DefaultLoginResponseData) rpcResponse).returnValue.h5Url) && (commonCallback = commonCallback) != null) {
                        commonCallback.onFail(-3, "need iv");
                        return;
                    } else {
                        return;
                    }
                }
                CommonCallback commonCallback2 = commonCallback;
                if (commonCallback2 != null) {
                    if (rpcResponse == null) {
                        i = -2;
                    } else {
                        i = rpcResponse.code;
                    }
                    commonCallback2.onFail(i, rpcResponse == null ? "response is null" : rpcResponse.message);
                }
            }

            @Override // com.ali.user.mobile.callback.RpcRequestCallback
            public void onSuccess(RpcResponse rpcResponse) {
                if (rpcResponse != null) {
                    String str = rpcResponse.actionType;
                    if (TextUtils.isEmpty(str)) {
                        CommonCallback commonCallback = commonCallback;
                        if (commonCallback != null) {
                            commonCallback.onFail(rpcResponse.code, rpcResponse.message);
                        }
                    } else if ("SUCCESS".equals(str)) {
                        T t = ((DefaultLoginResponseData) rpcResponse).returnValue;
                        if (t != null) {
                            LoginDataHelper.processLoginReturnData(true, (LoginReturnData) t, LoginStatus.browserRefUrl);
                            CommonCallback commonCallback2 = commonCallback;
                            if (commonCallback2 != null) {
                                commonCallback2.onSuccess();
                                return;
                            }
                            return;
                        }
                        CommonCallback commonCallback3 = commonCallback;
                        if (commonCallback3 != null) {
                            commonCallback3.onFail(-1, "login data is null");
                        }
                    } else {
                        CommonCallback commonCallback4 = commonCallback;
                        if (commonCallback4 != null) {
                            commonCallback4.onFail(rpcResponse.code, rpcResponse.message);
                        }
                    }
                } else {
                    CommonCallback commonCallback5 = commonCallback;
                    if (commonCallback5 != null) {
                        commonCallback5.onFail(-2, "response is null");
                    }
                }
            }

            @Override // com.ali.user.mobile.callback.RpcRequestCallback
            public void onSystemError(RpcResponse rpcResponse) {
                onError(rpcResponse);
            }
        });
    }

    @Override // com.ali.user.mobile.service.LoginService
    public void onekeyLogin(final Context context, final Map<String, String> map, final CommonCallback commonCallback) {
        if (ServiceFactory.getService(NumberAuthService.class) != null) {
            ((NumberAuthService) ServiceFactory.getService(NumberAuthService.class)).getLoginToken("openLoginView", new NumAuthTokenCallback() {
                /* class com.ali.user.mobile.login.LoginServiceImpl.AnonymousClass1 */

                @Override // com.ali.user.mobile.model.NumAuthTokenCallback
                public void onGetAuthTokenFail(int i, String str) {
                    CommonCallback commonCallback = commonCallback;
                    if (commonCallback != null) {
                        commonCallback.onFail(i, str);
                    }
                }

                @Override // com.ali.user.mobile.model.NumAuthTokenCallback
                public void onGetAuthTokenSuccess(String str) {
                    LoginParam loginParam = new LoginParam();
                    loginParam.token = str;
                    loginParam.tokenType = TokenType.NUMBER;
                    loginParam.loginSite = DataProviderFactory.getDataProvider().getSite();
                    LoginServiceImpl.this.simLogin(context, loginParam, map, commonCallback);
                }
            });
        }
    }

    @Override // com.ali.user.mobile.service.LoginService
    public void touristLogin(String str, LoginParam loginParam) {
        LoginDataRepository.getInstance().touristLogin(str, loginParam, new RpcRequestCallback() {
            /* class com.ali.user.mobile.login.LoginServiceImpl.AnonymousClass4 */

            @Override // com.ali.user.mobile.callback.RpcRequestCallback
            public void onError(RpcResponse rpcResponse) {
                BroadCastHelper.sendLoginFailBroadcast(-1, "");
            }

            @Override // com.ali.user.mobile.callback.RpcRequestCallback
            public void onSuccess(RpcResponse rpcResponse) {
                int i;
                T t;
                if (rpcResponse != null) {
                    String str = rpcResponse.actionType;
                    if (!TextUtils.isEmpty(str) && "SUCCESS".equals(str) && (t = ((DefaultLoginResponseData) rpcResponse).returnValue) != null) {
                        LoginDataHelper.processLoginReturnData(true, (LoginReturnData) t, LoginStatus.browserRefUrl);
                        return;
                    }
                }
                if (rpcResponse == null) {
                    i = -1;
                } else {
                    i = rpcResponse.code;
                }
                BroadCastHelper.sendLoginFailBroadcast(i, rpcResponse == null ? "" : rpcResponse.message);
            }

            @Override // com.ali.user.mobile.callback.RpcRequestCallback
            public void onSystemError(RpcResponse rpcResponse) {
                onError(rpcResponse);
            }
        });
    }
}
