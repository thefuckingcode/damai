package com.ali.user.mobile.login.tasks;

import com.ali.user.mobile.app.constant.UTConstant;
import com.ali.user.mobile.app.dataprovider.DataProviderFactory;
import com.ali.user.mobile.callback.CommonDataCallback;
import com.ali.user.mobile.callback.RpcRequestCallback;
import com.ali.user.mobile.data.LoginComponent;
import com.ali.user.mobile.log.ApiReferer;
import com.ali.user.mobile.log.UserTrackAdapter;
import com.ali.user.mobile.model.LoginParam;
import com.ali.user.mobile.model.LoginType;
import com.ali.user.mobile.model.TrackingModel;
import com.ali.user.mobile.rpc.login.model.LoginReturnData;
import com.ali.user.mobile.utils.BackgroundExecutor;
import com.ali.user.mobile.utils.MainThreadExecutor;
import java.util.HashMap;
import java.util.Properties;

/* compiled from: Taobao */
public class SmsLoginTask extends BaseLoginTask {
    /* access modifiers changed from: protected */
    @Override // com.ali.user.mobile.login.tasks.BaseLoginTask
    public void buildLoginParam(final CommonDataCallback commonDataCallback) {
        BackgroundExecutor.execute(new Runnable() {
            /* class com.ali.user.mobile.login.tasks.SmsLoginTask.AnonymousClass1 */

            public void run() {
                String str;
                SmsLoginTask smsLoginTask = SmsLoginTask.this;
                if (smsLoginTask.loginParam == null) {
                    smsLoginTask.loginParam = new LoginParam();
                    SmsLoginTask.this.loginParam.loginSite = DataProviderFactory.getDataProvider().getSite();
                }
                SmsLoginTask smsLoginTask2 = SmsLoginTask.this;
                TrackingModel trackingModel = smsLoginTask2.trackingModel;
                String str2 = trackingModel == null ? UTConstant.PageName.UT_PAGE_EXTEND : trackingModel.pageName;
                smsLoginTask2.loginParam.nativeLoginType = LoginType.ServerLoginType.SMSLogin.getType();
                LoginParam loginParam = SmsLoginTask.this.loginParam;
                if (loginParam.externParams == null) {
                    loginParam.externParams = new HashMap();
                }
                SmsLoginTask.this.loginParam.externParams.put("apiReferer", ApiReferer.generateApiReferer());
                SmsLoginTask smsLoginTask3 = SmsLoginTask.this;
                LoginParam loginParam2 = smsLoginTask3.loginParam;
                loginParam2.deviceTokenKey = "";
                loginParam2.havanaId = 0;
                smsLoginTask3.matchHistoryAccount();
                SmsLoginTask smsLoginTask4 = SmsLoginTask.this;
                LoginParam loginParam3 = smsLoginTask4.loginParam;
                TrackingModel trackingModel2 = smsLoginTask4.trackingModel;
                loginParam3.traceId = trackingModel2 != null ? trackingModel2.traceId : ApiReferer.generateTraceId(LoginType.LocalLoginType.SMS_LOGIN, str2);
                SmsLoginTask smsLoginTask5 = SmsLoginTask.this;
                LoginParam loginParam4 = smsLoginTask5.loginParam;
                loginParam4.loginSourceType = LoginType.LocalLoginType.SMS_LOGIN;
                loginParam4.loginSourcePage = str2;
                TrackingModel trackingModel3 = smsLoginTask5.trackingModel;
                if (trackingModel3 == null) {
                    str = "";
                } else {
                    str = trackingModel3.pageSpm;
                }
                loginParam4.loginSourceSpm = str;
                loginParam4.nativeLoginType = smsLoginTask5.getLoginType();
                Properties properties = new Properties();
                properties.setProperty("sdkTraceId", SmsLoginTask.this.loginParam.traceId + "");
                properties.setProperty("monitor", "T");
                properties.setProperty("site", DataProviderFactory.getDataProvider().getSite() + "");
                properties.setProperty("loginId", SmsLoginTask.this.loginParam.loginAccount + "");
                UserTrackAdapter.sendUT(str2, UTConstant.CustomEvent.UT_SINGLE_LOGIN_COMMIT, "", LoginType.LocalLoginType.SMS_LOGIN, properties);
                MainThreadExecutor.execute(new Runnable() {
                    /* class com.ali.user.mobile.login.tasks.SmsLoginTask.AnonymousClass1.AnonymousClass1 */

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
        LoginComponent.getInstance().smsLogin(loginParam, rpcRequestCallback);
    }
}
