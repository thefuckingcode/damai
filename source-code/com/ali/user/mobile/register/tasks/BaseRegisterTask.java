package com.ali.user.mobile.register.tasks;

import android.text.TextUtils;
import com.ali.user.mobile.app.constant.UTConstant;
import com.ali.user.mobile.base.BaseView;
import com.ali.user.mobile.base.UIBaseConstants;
import com.ali.user.mobile.callback.CommonDataCallback;
import com.ali.user.mobile.callback.RpcRequestCallback;
import com.ali.user.mobile.eventbus.Event;
import com.ali.user.mobile.eventbus.EventBus;
import com.ali.user.mobile.eventbus.EventBusEnum;
import com.ali.user.mobile.eventbus.EventListener;
import com.ali.user.mobile.log.TLogAdapter;
import com.ali.user.mobile.model.LoginParam;
import com.ali.user.mobile.model.TrackingModel;
import com.ali.user.mobile.register.RegisterException;
import com.ali.user.mobile.register.model.OceanRegisterParam;
import com.ali.user.mobile.rpc.RpcResponse;
import com.ali.user.mobile.rpc.register.model.OceanRegisterResult;
import com.ali.user.mobile.service.NavigatorService;
import com.ali.user.mobile.service.ServiceFactory;
import com.ali.user.mobile.utils.MainThreadExecutor;
import com.alibaba.fastjson.JSON;
import java.lang.ref.WeakReference;
import java.util.Map;

/* compiled from: Taobao */
public abstract class BaseRegisterTask {
    protected static final String TAG = "BaseRegisterTask";
    protected WeakReference<BaseView> baseView;
    protected OceanRegisterParam registerParam;
    protected TrackingModel trackingModel;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class RegisterRpcRequestCallback implements RpcRequestCallback<OceanRegisterResult> {
        private final OceanRegisterParam registerParam;
        private final RegisterTasksCallback<OceanRegisterResult> registerResultCallback;

        public RegisterRpcRequestCallback(OceanRegisterParam oceanRegisterParam, RegisterTasksCallback<OceanRegisterResult> registerTasksCallback) {
            this.registerParam = oceanRegisterParam;
            this.registerResultCallback = registerTasksCallback;
        }

        @Override // com.ali.user.mobile.callback.RpcRequestCallback
        public void onError(RpcResponse<OceanRegisterResult> rpcResponse) {
            BaseRegisterTask.this.dismissLoading();
            BaseRegisterTask.this.processRegisterResult(this.registerParam, rpcResponse, this.registerResultCallback);
        }

        @Override // com.ali.user.mobile.callback.RpcRequestCallback
        public void onSuccess(RpcResponse<OceanRegisterResult> rpcResponse) {
            BaseRegisterTask.this.dismissLoading();
            BaseRegisterTask.this.processRegisterResult(this.registerParam, rpcResponse, this.registerResultCallback);
        }

        @Override // com.ali.user.mobile.callback.RpcRequestCallback
        public void onSystemError(RpcResponse<OceanRegisterResult> rpcResponse) {
            BaseRegisterTask.this.dismissLoading();
            RegisterTasksCallback<OceanRegisterResult> registerTasksCallback = this.registerResultCallback;
            if (registerTasksCallback != null) {
                registerTasksCallback.onFail(new RegisterException<>(rpcResponse.code, rpcResponse.message, rpcResponse));
            }
        }
    }

    /* compiled from: Taobao */
    public interface RegisterTasksCallback<T> {
        void onCancel();

        void onFail(RegisterException<T> registerException);

        void onSuccess(RpcResponse<T> rpcResponse);
    }

    private RpcRequestCallback<OceanRegisterResult> createRegisterRpcCallback(OceanRegisterParam oceanRegisterParam, RegisterTasksCallback<OceanRegisterResult> registerTasksCallback) {
        return new RegisterRpcRequestCallback(oceanRegisterParam, registerTasksCallback);
    }

    /* access modifiers changed from: protected */
    public void buildRegisterParam(final CommonDataCallback commonDataCallback) {
        MainThreadExecutor.execute(new Runnable() {
            /* class com.ali.user.mobile.register.tasks.BaseRegisterTask.AnonymousClass2 */

            public void run() {
                commonDataCallback.onSuccess(null);
            }
        });
    }

    /* access modifiers changed from: protected */
    public void dismissLoading() {
        WeakReference<BaseView> weakReference = this.baseView;
        if (weakReference != null && weakReference.get() != null) {
            this.baseView.get().dismissLoading();
        }
    }

    /* access modifiers changed from: protected */
    public abstract void invokeRegisterRpc(OceanRegisterParam oceanRegisterParam, RpcRequestCallback<OceanRegisterResult> rpcRequestCallback);

    /* access modifiers changed from: protected */
    public void onReceiveH5(OceanRegisterParam oceanRegisterParam, RpcResponse<OceanRegisterResult> rpcResponse, final RegisterTasksCallback<OceanRegisterResult> registerTasksCallback) {
        TrackingModel trackingModel2 = this.trackingModel;
        String str = trackingModel2 == null ? UTConstant.PageName.UT_PAGE_EXTEND : trackingModel2.pageName;
        String str2 = rpcResponse.returnValue.h5Url;
        LoginParam loginParam = new LoginParam();
        TrackingModel trackingModel3 = this.trackingModel;
        if (trackingModel3 != null) {
            loginParam.loginSourcePage = trackingModel3.pageName;
            loginParam.loginSourceSpm = trackingModel3.pageSpm;
            loginParam.loginSourceType = trackingModel3.loginType;
            loginParam.traceId = trackingModel3.traceId;
        }
        EventBus.getDefault().registerEventListener(EventBusEnum.EventName.REGISTER_H5, new EventListener() {
            /* class com.ali.user.mobile.register.tasks.BaseRegisterTask.AnonymousClass3 */

            @Override // com.ali.user.mobile.eventbus.EventListener
            public void onEvent(Event event) {
                Map<String, Object> map;
                RegisterTasksCallback registerTasksCallback;
                EventBus.getDefault().unregisterEventListener(EventBusEnum.EventName.REGISTER_H5, this);
                if (event == null || (map = event.params) == null) {
                    RegisterTasksCallback registerTasksCallback2 = registerTasksCallback;
                    if (registerTasksCallback2 != null) {
                        registerTasksCallback2.onFail(new RegisterException(605, ""));
                        return;
                    }
                    return;
                }
                String str = (String) map.get(UIBaseConstants.IntentExtrasNamesConstants.PARAM_LOGIN_PARAM);
                String str2 = (String) event.params.get("result");
                if (!TextUtils.isEmpty(str) && TextUtils.equals(str2, "success")) {
                    LoginParam loginParam = (LoginParam) JSON.parseObject(str, LoginParam.class);
                    if (loginParam == null) {
                        loginParam = new LoginParam();
                    }
                    if (registerTasksCallback != null) {
                        RpcResponse rpcResponse = new RpcResponse();
                        T t = (T) new OceanRegisterResult();
                        rpcResponse.returnValue = t;
                        t.continueLoginToken = loginParam.token;
                        registerTasksCallback.onSuccess(rpcResponse);
                    }
                } else if (!TextUtils.equals(str2, "cancel") || (registerTasksCallback = registerTasksCallback) == null) {
                    RegisterTasksCallback registerTasksCallback3 = registerTasksCallback;
                    if (registerTasksCallback3 != null) {
                        registerTasksCallback3.onFail(new RegisterException(604, ""));
                    }
                } else {
                    registerTasksCallback.onCancel();
                }
            }
        });
        ((NavigatorService) ServiceFactory.getService(NavigatorService.class)).openRegWebViewPage(str2, EventBusEnum.EventName.REGISTER_H5, str, loginParam);
    }

    /* access modifiers changed from: protected */
    public void onReceiverOtherError(RpcResponse<OceanRegisterResult> rpcResponse, RegisterTasksCallback<OceanRegisterResult> registerTasksCallback) {
        if (registerTasksCallback != null) {
            registerTasksCallback.onFail(new RegisterException<>(rpcResponse == null ? 1100 : rpcResponse.code, rpcResponse == null ? "" : rpcResponse.message, rpcResponse));
        }
    }

    /* access modifiers changed from: protected */
    public void processRegisterResult(OceanRegisterParam oceanRegisterParam, RpcResponse<OceanRegisterResult> rpcResponse, RegisterTasksCallback<OceanRegisterResult> registerTasksCallback) {
        if (rpcResponse != null) {
            String str = rpcResponse.actionType;
            String str2 = TAG;
            TLogAdapter.d(str2, ",actionType=" + str + ", msg=" + rpcResponse.message);
            if (TextUtils.isEmpty(str)) {
                onReceiverOtherError(rpcResponse, registerTasksCallback);
            } else if ("SUCCESS".equals(str)) {
                if (registerTasksCallback != null) {
                    registerTasksCallback.onSuccess(rpcResponse);
                }
            } else if ("H5".equals(str)) {
                onReceiveH5(oceanRegisterParam, rpcResponse, registerTasksCallback);
            } else {
                onReceiverOtherError(rpcResponse, registerTasksCallback);
            }
        } else {
            onReceiverOtherError(null, registerTasksCallback);
        }
    }

    public void register(final OceanRegisterParam oceanRegisterParam, TrackingModel trackingModel2, BaseView baseView2, final RegisterTasksCallback<OceanRegisterResult> registerTasksCallback) {
        this.registerParam = oceanRegisterParam;
        this.trackingModel = trackingModel2;
        this.baseView = new WeakReference<>(baseView2);
        buildRegisterParam(new CommonDataCallback() {
            /* class com.ali.user.mobile.register.tasks.BaseRegisterTask.AnonymousClass1 */

            @Override // com.ali.user.mobile.callback.CommonDataCallback
            public void onFail(int i, String str) {
                RegisterTasksCallback registerTasksCallback = registerTasksCallback;
                if (registerTasksCallback != null) {
                    registerTasksCallback.onFail(new RegisterException(i, str));
                }
            }

            @Override // com.ali.user.mobile.callback.CommonDataCallback
            public void onSuccess(Map<String, String> map) {
                BaseRegisterTask.this.startRegister(oceanRegisterParam, registerTasksCallback);
            }
        });
    }

    /* access modifiers changed from: protected */
    public void showLoading() {
        WeakReference<BaseView> weakReference = this.baseView;
        if (weakReference != null && weakReference.get() != null) {
            this.baseView.get().showLoading();
        }
    }

    /* access modifiers changed from: protected */
    public void startRegister(OceanRegisterParam oceanRegisterParam, RegisterTasksCallback<OceanRegisterResult> registerTasksCallback) {
        showLoading();
        invokeRegisterRpc(oceanRegisterParam, createRegisterRpcCallback(oceanRegisterParam, registerTasksCallback));
    }
}
