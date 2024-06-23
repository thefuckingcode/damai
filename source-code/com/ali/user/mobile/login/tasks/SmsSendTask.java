package com.ali.user.mobile.login.tasks;

import com.ali.user.mobile.app.constant.UTConstant;
import com.ali.user.mobile.app.dataprovider.DataProviderFactory;
import com.ali.user.mobile.callback.CommonDataCallback;
import com.ali.user.mobile.callback.LoginTasksCallback;
import com.ali.user.mobile.callback.RpcRequestCallback;
import com.ali.user.mobile.data.LoginComponent;
import com.ali.user.mobile.log.ApiReferer;
import com.ali.user.mobile.model.LoginParam;
import com.ali.user.mobile.model.LoginType;
import com.ali.user.mobile.model.TrackingModel;
import com.ali.user.mobile.rpc.RpcResponse;
import com.ali.user.mobile.rpc.login.model.LoginReturnData;
import com.ali.user.mobile.utils.BackgroundExecutor;
import com.ali.user.mobile.utils.MainThreadExecutor;
import java.util.HashMap;

/* compiled from: Taobao */
public class SmsSendTask extends BaseLoginTask {
    /* access modifiers changed from: protected */
    @Override // com.ali.user.mobile.login.tasks.BaseLoginTask
    public void buildLoginParam(final CommonDataCallback commonDataCallback) {
        BackgroundExecutor.execute(new Runnable() {
            /* class com.ali.user.mobile.login.tasks.SmsSendTask.AnonymousClass1 */

            public void run() {
                SmsSendTask smsSendTask = SmsSendTask.this;
                if (smsSendTask.loginParam == null) {
                    smsSendTask.loginParam = new LoginParam();
                    SmsSendTask.this.loginParam.loginSite = DataProviderFactory.getDataProvider().getSite();
                }
                SmsSendTask smsSendTask2 = SmsSendTask.this;
                TrackingModel trackingModel = smsSendTask2.trackingModel;
                String str = trackingModel == null ? UTConstant.PageName.UT_PAGE_EXTEND : trackingModel.pageName;
                smsSendTask2.loginParam.nativeLoginType = smsSendTask2.getLoginType();
                SmsSendTask.this.loginParam.loginSite = DataProviderFactory.getDataProvider().getSite();
                LoginParam loginParam = SmsSendTask.this.loginParam;
                if (loginParam.externParams == null) {
                    loginParam.externParams = new HashMap();
                }
                SmsSendTask.this.loginParam.externParams.put("apiReferer", ApiReferer.generateApiReferer());
                SmsSendTask smsSendTask3 = SmsSendTask.this;
                LoginParam loginParam2 = smsSendTask3.loginParam;
                String str2 = "";
                loginParam2.deviceTokenKey = str2;
                loginParam2.havanaId = 0;
                smsSendTask3.matchHistoryAccount();
                SmsSendTask smsSendTask4 = SmsSendTask.this;
                LoginParam loginParam3 = smsSendTask4.loginParam;
                TrackingModel trackingModel2 = smsSendTask4.trackingModel;
                loginParam3.traceId = trackingModel2 != null ? trackingModel2.traceId : ApiReferer.generateTraceId(LoginType.LocalLoginType.SMS_LOGIN, str);
                SmsSendTask smsSendTask5 = SmsSendTask.this;
                LoginParam loginParam4 = smsSendTask5.loginParam;
                loginParam4.loginSourceType = LoginType.LocalLoginType.SMS_LOGIN;
                loginParam4.loginSourcePage = str;
                TrackingModel trackingModel3 = smsSendTask5.trackingModel;
                if (trackingModel3 != null) {
                    str2 = trackingModel3.pageSpm;
                }
                loginParam4.loginSourceSpm = str2;
                MainThreadExecutor.execute(new Runnable() {
                    /* class com.ali.user.mobile.login.tasks.SmsSendTask.AnonymousClass1.AnonymousClass1 */

                    public void run() {
                        commonDataCallback.onSuccess(null);
                    }
                });
            }
        });
    }

    /* access modifiers changed from: protected */
    @Override // com.ali.user.mobile.login.tasks.BaseLoginTask
    public String getLoginType() {
        return LoginType.ServerLoginType.SMSLogin.getType();
    }

    /* access modifiers changed from: protected */
    @Override // com.ali.user.mobile.login.tasks.BaseLoginTask
    public void invokeLoginRpc(LoginParam loginParam, RpcRequestCallback<LoginReturnData> rpcRequestCallback) {
        LoginComponent.getInstance().sendSmsByLogin(loginParam, rpcRequestCallback);
    }

    /* access modifiers changed from: protected */
    @Override // com.ali.user.mobile.login.tasks.BaseLoginTask
    public void onReceiveSuccess(LoginParam loginParam, RpcResponse<LoginReturnData> rpcResponse, LoginTasksCallback<LoginReturnData> loginTasksCallback) {
        super.onReceiveSuccess(loginParam, rpcResponse, loginTasksCallback);
    }
}
