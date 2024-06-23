package com.ali.user.mobile.register.presenter;

import android.content.DialogInterface;
import android.text.TextUtils;
import com.ali.user.mobile.app.constant.UTConstant;
import com.ali.user.mobile.app.dataprovider.DataProviderFactory;
import com.ali.user.mobile.base.BasePresenter;
import com.ali.user.mobile.base.helper.BroadCastHelper;
import com.ali.user.mobile.base.ui.BaseFragment;
import com.ali.user.mobile.callback.RpcRequestCallback;
import com.ali.user.mobile.data.DataRepository;
import com.ali.user.mobile.data.RegisterComponent;
import com.ali.user.mobile.data.model.SmsApplyResponse;
import com.ali.user.mobile.log.UserTrackAdapter;
import com.ali.user.mobile.model.AliValidRequest;
import com.ali.user.mobile.model.RegistParam;
import com.ali.user.mobile.register.model.OceanRegisterParam;
import com.ali.user.mobile.register.ui.RegisterFormView;
import com.ali.user.mobile.rpc.RpcResponse;
import com.ali.user.mobile.rpc.register.model.NumAuthFastRegisterResponseData;
import com.ali.user.mobile.rpc.register.model.OceanRegisterResponseData;
import com.ali.user.mobile.ui.R;
import com.ali.user.mobile.utils.UTConstans;
import com.taobao.login4android.broadcast.LoginAction;
import com.taobao.login4android.config.LoginSwitch;
import com.youku.alixplayer.opensdk.statistics.StaticsUtil;
import java.util.HashMap;
import java.util.Properties;
import org.apache.commons.lang3.time.DateUtils;

/* compiled from: Taobao */
public class MobileRegisterPresenter implements BasePresenter {
    private static final String TAG = "MobileRegisterPresenter";
    private String codeLength;
    private String mSessionId;
    private RegisterFormView mViewer;

    public MobileRegisterPresenter(RegisterFormView registerFormView) {
        this.mViewer = registerFormView;
    }

    public void directRegister(OceanRegisterParam oceanRegisterParam, String str) {
        RegisterFormView registerFormView = this.mViewer;
        if (registerFormView != null && registerFormView.isActive()) {
            this.mViewer.showLoading();
            DataRepository.getInstance().directRegister(new RegistParam(), str, new RpcRequestCallback() {
                /* class com.ali.user.mobile.register.presenter.MobileRegisterPresenter.AnonymousClass4 */

                @Override // com.ali.user.mobile.callback.RpcRequestCallback
                public void onError(RpcResponse rpcResponse) {
                    if (MobileRegisterPresenter.this.mViewer != null && MobileRegisterPresenter.this.mViewer.isActive()) {
                        MobileRegisterPresenter.this.mViewer.dismissLoading();
                        if (MobileRegisterPresenter.this.mViewer != null && MobileRegisterPresenter.this.mViewer.isActive()) {
                            MobileRegisterPresenter.this.mViewer.onRegisterFail(rpcResponse == null ? 0 : rpcResponse.code, rpcResponse == null ? "" : rpcResponse.message);
                        }
                    }
                }

                @Override // com.ali.user.mobile.callback.RpcRequestCallback
                public void onSuccess(RpcResponse rpcResponse) {
                    if (MobileRegisterPresenter.this.mViewer != null && MobileRegisterPresenter.this.mViewer.isActive()) {
                        MobileRegisterPresenter.this.mViewer.dismissLoading();
                        OceanRegisterResponseData oceanRegisterResponseData = (OceanRegisterResponseData) rpcResponse;
                        if (oceanRegisterResponseData == null) {
                            return;
                        }
                        if ("SUCCESS".equals(rpcResponse.actionType)) {
                            if (oceanRegisterResponseData.returnValue != null) {
                                BroadCastHelper.sendBroadcast(LoginAction.NOTIFY_REGISTER_SUCCESS, new HashMap());
                                MobileRegisterPresenter.this.mViewer.onRegisterSuccess(oceanRegisterResponseData.returnValue.continueLoginToken);
                            }
                        } else if ("H5".equals(rpcResponse.actionType)) {
                            T t = oceanRegisterResponseData.returnValue;
                            if (t != null) {
                                MobileRegisterPresenter.this.mViewer.onH5(t.h5Url);
                            }
                        } else {
                            onError(rpcResponse);
                        }
                    }
                }

                @Override // com.ali.user.mobile.callback.RpcRequestCallback
                public void onSystemError(RpcResponse rpcResponse) {
                    onError(rpcResponse);
                }
            });
        }
    }

    public String getCodeLength() {
        return this.codeLength;
    }

    public String getSessionId() {
        return this.mSessionId;
    }

    public RegisterFormView getViewer() {
        return this.mViewer;
    }

    public void numAuthRegister(AliValidRequest aliValidRequest, OceanRegisterParam oceanRegisterParam) {
        RegisterFormView registerFormView = this.mViewer;
        if (registerFormView != null && registerFormView.isActive()) {
            this.mViewer.showLoading();
            if (oceanRegisterParam != null) {
                oceanRegisterParam.sessionId = this.mSessionId;
            }
            RegisterComponent.getInstance().numAuthRegister(aliValidRequest, oceanRegisterParam, new RpcRequestCallback() {
                /* class com.ali.user.mobile.register.presenter.MobileRegisterPresenter.AnonymousClass3 */

                @Override // com.ali.user.mobile.callback.RpcRequestCallback
                public void onError(RpcResponse rpcResponse) {
                    if (MobileRegisterPresenter.this.mViewer != null && MobileRegisterPresenter.this.mViewer.isActive()) {
                        MobileRegisterPresenter.this.mViewer.dismissLoading();
                        MobileRegisterPresenter.this.mViewer.onNumAuthRegisterFail(rpcResponse);
                    }
                }

                @Override // com.ali.user.mobile.callback.RpcRequestCallback
                public void onSuccess(RpcResponse rpcResponse) {
                    T t;
                    if (MobileRegisterPresenter.this.mViewer != null && MobileRegisterPresenter.this.mViewer.isActive()) {
                        MobileRegisterPresenter.this.mViewer.dismissLoading();
                        String pageName = TextUtils.isEmpty(MobileRegisterPresenter.this.mViewer.getPageName()) ? UTConstans.PageName.UT_PAGE_ONEKEY_REG_NEW : MobileRegisterPresenter.this.mViewer.getPageName();
                        NumAuthFastRegisterResponseData numAuthFastRegisterResponseData = (NumAuthFastRegisterResponseData) rpcResponse;
                        if (numAuthFastRegisterResponseData != null) {
                            T t2 = numAuthFastRegisterResponseData.returnValue;
                            if (t2 != null) {
                                MobileRegisterPresenter.this.mSessionId = t2.sdkSessionId;
                            }
                            if ("SUCCESS".equals(rpcResponse.actionType)) {
                                Properties properties = new Properties();
                                properties.setProperty("monitor", "T");
                                UserTrackAdapter.sendUT(pageName, UTConstans.CustomEvent.UT_REG_RPC_SUCCESS, "", "oneKeyRegister", properties);
                                if (numAuthFastRegisterResponseData.returnValue != null) {
                                    BroadCastHelper.sendBroadcast(LoginAction.NOTIFY_REGISTER_SUCCESS, new HashMap());
                                    MobileRegisterPresenter.this.mViewer.onRegisterSuccess(numAuthFastRegisterResponseData.returnValue.continueLoginToken);
                                    return;
                                }
                            } else if ("H5".equals(rpcResponse.actionType) && (t = numAuthFastRegisterResponseData.returnValue) != null && !TextUtils.isEmpty(t.h5Url)) {
                                UserTrackAdapter.sendUT(pageName, UTConstans.CustomEvent.UT_REG_TO_H5);
                                MobileRegisterPresenter.this.mViewer.onH5(numAuthFastRegisterResponseData.returnValue.h5Url);
                                return;
                            }
                            MobileRegisterPresenter.this.mViewer.onNumAuthRegisterFail(rpcResponse);
                            return;
                        }
                        MobileRegisterPresenter.this.mViewer.onNumAuthRegisterFail(rpcResponse);
                    }
                }

                @Override // com.ali.user.mobile.callback.RpcRequestCallback
                public void onSystemError(RpcResponse rpcResponse) {
                    onError(rpcResponse);
                }
            });
        }
    }

    @Override // com.ali.user.mobile.base.BasePresenter
    public void onDestory() {
        this.mViewer = null;
    }

    @Override // com.ali.user.mobile.base.BasePresenter
    public void onStart() {
    }

    public void register(RegistParam registParam, final OceanRegisterParam oceanRegisterParam) {
        if (oceanRegisterParam != null) {
            oceanRegisterParam.sessionId = this.mSessionId;
        }
        this.mViewer.showLoading();
        final String pageName = TextUtils.isEmpty(this.mViewer.getPageName()) ? UTConstans.PageName.UT_PAGE_REG : this.mViewer.getPageName();
        final String str = TextUtils.equals(UTConstans.PageName.UT_PAGE_REG, pageName) ? UTConstant.Args.UT_SMS_REG : UTConstant.Args.UT_MOBILE_REG;
        final Properties properties = new Properties();
        properties.setProperty("monitor", "T");
        DataRepository.getInstance().register(registParam, oceanRegisterParam, new RpcRequestCallback() {
            /* class com.ali.user.mobile.register.presenter.MobileRegisterPresenter.AnonymousClass1 */

            @Override // com.ali.user.mobile.callback.RpcRequestCallback
            public void onError(RpcResponse rpcResponse) {
                String str;
                if (MobileRegisterPresenter.this.mViewer != null && MobileRegisterPresenter.this.mViewer.isActive()) {
                    MobileRegisterPresenter.this.mViewer.dismissLoading();
                    if (MobileRegisterPresenter.this.mViewer != null && MobileRegisterPresenter.this.mViewer.isActive()) {
                        String str2 = pageName;
                        String str3 = "";
                        if (rpcResponse == null) {
                            str = StaticsUtil.PLAY_CODE_100;
                        } else {
                            str = rpcResponse.code + str3;
                        }
                        UserTrackAdapter.sendUT(str2, UTConstans.CustomEvent.UT_REG_RPC_FAILURE, str, str, properties);
                        RegisterFormView registerFormView = MobileRegisterPresenter.this.mViewer;
                        int i = rpcResponse == null ? 0 : rpcResponse.code;
                        if (rpcResponse != null) {
                            str3 = rpcResponse.message;
                        }
                        registerFormView.onRegisterFail(i, str3);
                    }
                }
            }

            @Override // com.ali.user.mobile.callback.RpcRequestCallback
            public void onSuccess(RpcResponse rpcResponse) {
                if (MobileRegisterPresenter.this.mViewer != null && MobileRegisterPresenter.this.mViewer.isActive()) {
                    MobileRegisterPresenter.this.mViewer.dismissLoading();
                    if (MobileRegisterPresenter.this.mViewer != null && MobileRegisterPresenter.this.mViewer.isActive()) {
                        if (!TextUtils.isEmpty(oceanRegisterParam.thirdType)) {
                            String str = oceanRegisterParam.thirdType;
                        }
                        OceanRegisterResponseData oceanRegisterResponseData = (OceanRegisterResponseData) rpcResponse;
                        String str2 = "";
                        if (oceanRegisterResponseData != null) {
                            if ("SUCCESS".equals(rpcResponse.actionType)) {
                                UserTrackAdapter.sendUT(pageName, UTConstans.CustomEvent.UT_REG_RPC_SUCCESS, str2, str, properties);
                                if (oceanRegisterResponseData.returnValue != null) {
                                    BroadCastHelper.sendBroadcast(LoginAction.NOTIFY_REGISTER_SUCCESS, new HashMap());
                                    MobileRegisterPresenter.this.mViewer.onRegisterSuccess(oceanRegisterResponseData.returnValue.continueLoginToken);
                                    return;
                                }
                            } else if ("H5".equals(rpcResponse.actionType)) {
                                UserTrackAdapter.sendUT(pageName, UTConstans.CustomEvent.UT_REG_TO_H5);
                                MobileRegisterPresenter.this.mViewer.onH5(oceanRegisterResponseData.returnValue.h5Url);
                                return;
                            }
                        }
                        RegisterFormView registerFormView = MobileRegisterPresenter.this.mViewer;
                        int i = rpcResponse == null ? 0 : rpcResponse.code;
                        if (rpcResponse != null) {
                            str2 = rpcResponse.message;
                        }
                        registerFormView.onRegisterFail(i, str2);
                    }
                }
            }

            @Override // com.ali.user.mobile.callback.RpcRequestCallback
            public void onSystemError(RpcResponse rpcResponse) {
                onError(rpcResponse);
            }
        });
    }

    public void sendSMS(RegistParam registParam, OceanRegisterParam oceanRegisterParam) {
        String str;
        this.mViewer.showLoading();
        if (oceanRegisterParam != null) {
            oceanRegisterParam.sessionId = this.mSessionId;
        }
        final String pageName = TextUtils.isEmpty(this.mViewer.getPageName()) ? UTConstans.PageName.UT_PAGE_SMS : this.mViewer.getPageName();
        if (oceanRegisterParam == null) {
            str = "";
        } else {
            str = oceanRegisterParam.traceId + "";
        }
        final String str2 = TextUtils.equals(UTConstans.PageName.UT_PAGE_REG, pageName) ? UTConstant.Args.UT_SMS_REG : UTConstant.Args.UT_MOBILE_REG;
        final Properties properties = new Properties();
        properties.setProperty("sdkTraceId", str);
        properties.setProperty("monitor", "T");
        UserTrackAdapter.sendUT(pageName, UTConstans.CustomEvent.UT_SMS_SEND, "", this.mViewer.getRegType(), properties);
        DataRepository.getInstance().sendSMS(registParam, oceanRegisterParam, new RpcRequestCallback() {
            /* class com.ali.user.mobile.register.presenter.MobileRegisterPresenter.AnonymousClass2 */

            @Override // com.ali.user.mobile.callback.RpcRequestCallback
            public void onError(RpcResponse rpcResponse) {
                int i;
                if (MobileRegisterPresenter.this.mViewer != null && MobileRegisterPresenter.this.mViewer.isActive()) {
                    MobileRegisterPresenter.this.mViewer.dismissLoading();
                    if (rpcResponse != null && (((i = rpcResponse.code) == 458818 || i == 458751) && !TextUtils.isEmpty(MobileRegisterPresenter.this.mSessionId) && !TextUtils.isEmpty(MobileRegisterPresenter.this.codeLength))) {
                        MobileRegisterPresenter.this.mViewer.onSendSMSSuccess(DateUtils.MILLIS_PER_MINUTE, null);
                    } else if (MobileRegisterPresenter.this.mViewer != null && MobileRegisterPresenter.this.mViewer.isActive()) {
                        MobileRegisterPresenter.this.mViewer.onSMSSendFail(rpcResponse);
                    }
                }
            }

            @Override // com.ali.user.mobile.callback.RpcRequestCallback
            public void onSuccess(RpcResponse rpcResponse) {
                T t;
                if (MobileRegisterPresenter.this.mViewer != null && MobileRegisterPresenter.this.mViewer.isActive()) {
                    MobileRegisterPresenter.this.mViewer.dismissLoading();
                    if (MobileRegisterPresenter.this.mViewer != null && MobileRegisterPresenter.this.mViewer.isActive() && (t = ((SmsApplyResponse) rpcResponse).returnValue) != null) {
                        MobileRegisterPresenter.this.mSessionId = t.sdkSessionId;
                        MobileRegisterPresenter.this.codeLength = t.codeLength;
                        if (TextUtils.equals("true", t.sendSmsResult)) {
                            if (!TextUtils.isEmpty(t.sendType)) {
                                properties.setProperty("sendType", t.sendType);
                            }
                            UserTrackAdapter.sendUT(pageName, UTConstans.CustomEvent.UT_SMS_SEND_SUCCESS, "", str2, properties);
                            if ("voice".equals(t.sendType) && !TextUtils.isEmpty(rpcResponse.message)) {
                                MobileRegisterPresenter.this.mViewer.toast(rpcResponse.message, 0);
                            } else if ("smsLink".equals(t.sendType) && !TextUtils.isEmpty(rpcResponse.message)) {
                                if (MobileRegisterPresenter.this.mViewer instanceof BaseFragment) {
                                    final BaseFragment baseFragment = (BaseFragment) MobileRegisterPresenter.this.mViewer;
                                    baseFragment.alert("", rpcResponse.message, DataProviderFactory.getApplicationContext().getString(R.string.aliuser_common_ok), new DialogInterface.OnClickListener() {
                                        /* class com.ali.user.mobile.register.presenter.MobileRegisterPresenter.AnonymousClass2.AnonymousClass1 */

                                        public void onClick(DialogInterface dialogInterface, int i) {
                                            if (LoginSwitch.getSwitch("goSmsList", "true")) {
                                                baseFragment.goSmsList();
                                            }
                                        }
                                    }, "", null);
                                } else {
                                    MobileRegisterPresenter.this.mViewer.toast(rpcResponse.message, 1);
                                }
                            }
                            MobileRegisterPresenter.this.mViewer.onSendSMSSuccess(DateUtils.MILLIS_PER_MINUTE, t);
                            return;
                        }
                        onError(rpcResponse);
                    }
                }
            }

            @Override // com.ali.user.mobile.callback.RpcRequestCallback
            public void onSystemError(RpcResponse rpcResponse) {
                onError(rpcResponse);
            }
        });
    }

    public void setCodeLength(String str) {
        this.codeLength = str;
    }

    public void setSessionId(String str) {
        this.mSessionId = str;
    }

    public void setViewer(RegisterFormView registerFormView) {
        this.mViewer = registerFormView;
    }
}
