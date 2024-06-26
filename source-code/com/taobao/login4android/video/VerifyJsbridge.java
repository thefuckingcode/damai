package com.taobao.login4android.video;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.CountDownTimer;
import android.taobao.windvane.jsbridge.WVApiPlugin;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.taobao.windvane.jsbridge.WVResult;
import android.taobao.windvane.runtimepermission.PermissionProposer;
import android.taobao.windvane.webview.IWVWebView;
import android.text.TextUtils;
import com.ali.user.mobile.app.constant.UTConstant;
import com.ali.user.mobile.app.dataprovider.DataProviderFactory;
import com.ali.user.mobile.helper.DialogHelper;
import com.ali.user.mobile.log.TLogAdapter;
import com.ali.user.mobile.log.UserTrackAdapter;
import com.ali.user.mobile.model.CommonCallback;
import com.ali.user.mobile.security.SecurityGuardManagerWraper;
import com.ali.user.mobile.service.FingerprintService;
import com.ali.user.mobile.service.NavigatorService;
import com.ali.user.mobile.service.ServiceFactory;
import com.ali.user.mobile.utils.NetworkUtil;
import com.ali.user.mobile.verify.VerifyApi;
import com.ali.user.mobile.verify.model.VerifyParam;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.taobao.login4android.broadcast.LoginAction;
import com.taobao.login4android.broadcast.LoginBroadcastHelper;
import com.taobao.login4android.constants.LoginEnvType;
import com.taobao.login4android.login.LoginController;
import com.taobao.login4android.sdk.R;
import com.taobao.login4android.session.constants.SessionConstants;
import com.taobao.login4android.video.UploadTask;
import com.taobao.weex.devtools.debug.WXDebugConstants;
import java.util.Properties;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
public class VerifyJsbridge extends WVApiPlugin {
    private String TAG = "loginsdk.JSBridgeService";
    private WVCallBackContext mCallback = null;
    private BroadcastReceiver mLoginReceiver;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class a implements UploadTask.ResultCallback {
        final /* synthetic */ WVResult a;
        final /* synthetic */ WVCallBackContext b;
        final /* synthetic */ long c;

        a(WVResult wVResult, WVCallBackContext wVCallBackContext, long j) {
            this.a = wVResult;
            this.b = wVCallBackContext;
            this.c = j;
        }

        @Override // com.taobao.login4android.video.UploadTask.ResultCallback
        public void onFail(String str) {
            String str2 = VerifyJsbridge.this.TAG;
            TLogAdapter.e(str2, "msg=" + str);
            VerifyJsbridge.this.errorCallback(this.b, UTConstant.Args.UT_VERIFY_STOPRECORD, RecordErrorCode.E_UPLOAD_FAIL);
        }

        @Override // com.taobao.login4android.video.UploadTask.ResultCallback
        public void onSuccess(String str) {
            this.a.setResult(WVResult.SUCCESS);
            this.a.addData("voiceUrl", str);
            this.a.addData(WXDebugConstants.ENV_DEVICE_MODEL, Build.getMODEL());
            this.b.success(this.a);
            long currentTimeMillis = System.currentTimeMillis();
            String str2 = VerifyJsbridge.this.TAG;
            TLogAdapter.e(str2, "upload time=" + (currentTimeMillis - this.c));
        }
    }

    /* compiled from: Taobao */
    static /* synthetic */ class b {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            int[] iArr = new int[LoginAction.values().length];
            a = iArr;
            iArr[LoginAction.NOTIFY_IV_SUCCESS.ordinal()] = 1;
            a[LoginAction.NOTIFY_IV_FAIL.ordinal()] = 2;
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class c implements CommonCallback {
        final /* synthetic */ WVResult a;
        final /* synthetic */ String b;
        final /* synthetic */ WVCallBackContext c;

        c(VerifyJsbridge verifyJsbridge, WVResult wVResult, String str, WVCallBackContext wVCallBackContext) {
            this.a = wVResult;
            this.b = str;
            this.c = wVCallBackContext;
        }

        @Override // com.ali.user.mobile.model.CommonCallback
        public void onFail(int i, String str) {
            this.a.addData("code", Integer.valueOf(i));
            WVCallBackContext wVCallBackContext = this.c;
            if (wVCallBackContext != null) {
                wVCallBackContext.error(this.a);
            }
        }

        @Override // com.ali.user.mobile.model.CommonCallback
        public void onSuccess() {
            this.a.addData("biometricKey", this.b);
            WVCallBackContext wVCallBackContext = this.c;
            if (wVCallBackContext != null) {
                wVCallBackContext.success(this.a);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class d implements CommonCallback {
        final /* synthetic */ VerifyParam a;
        final /* synthetic */ WVCallBackContext b;

        /* compiled from: Taobao */
        class a implements DialogInterface.OnClickListener {
            final /* synthetic */ Activity a;

            a(Activity activity) {
                this.a = activity;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                d dVar = d.this;
                VerifyJsbridge.this.errorCallback(dVar.b, "openBiometricGoSetting", 4002);
                NetworkUtil.goSettings(this.a);
            }
        }

        /* compiled from: Taobao */
        class b implements DialogInterface.OnClickListener {
            b() {
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                d dVar = d.this;
                VerifyJsbridge.this.errorCallback(dVar.b, "openBiometricCancelSetting", 4002);
            }
        }

        d(VerifyParam verifyParam, WVCallBackContext wVCallBackContext) {
            this.a = verifyParam;
            this.b = wVCallBackContext;
        }

        @Override // com.ali.user.mobile.model.CommonCallback
        public void onFail(int i, String str) {
            String str2 = this.a.requestScene;
            UserTrackAdapter.sendUT(UTConstant.PageName.UT_PAGE_EXTEND, UTConstant.CustomEvent.OPEN_BIO_F, str2, str2, null);
            if (i != 4004) {
                VerifyJsbridge.this.errorCallback(this.b, "openBiometric", i);
            } else if (((WVApiPlugin) VerifyJsbridge.this).mContext instanceof Activity) {
                Activity activity = (Activity) ((WVApiPlugin) VerifyJsbridge.this).mContext;
                new DialogHelper(activity).alert("", activity.getString(R.string.aliuser_finger_not_roll), activity.getString(R.string.aliuser_finger_go_set), new a(activity), activity.getString(R.string.aliuser_cancel), new b());
            }
        }

        @Override // com.ali.user.mobile.model.CommonCallback
        public void onSuccess() {
            String str = this.a.requestScene;
            UserTrackAdapter.sendUT(UTConstant.PageName.UT_PAGE_EXTEND, UTConstant.CustomEvent.OPEN_BIO_S, str, str, null);
            VerifyJsbridge.this.successCallback(this.b, "openBiometric");
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class e implements CommonCallback {
        final /* synthetic */ VerifyParam a;
        final /* synthetic */ WVCallBackContext b;

        e(VerifyParam verifyParam, WVCallBackContext wVCallBackContext) {
            this.a = verifyParam;
            this.b = wVCallBackContext;
        }

        @Override // com.ali.user.mobile.model.CommonCallback
        public void onFail(int i, String str) {
            String str2 = this.a.requestScene;
            UserTrackAdapter.sendUT(UTConstant.PageName.UT_PAGE_EXTEND, UTConstant.CustomEvent.CLOSE_BIO_F, str2, str2, null);
            VerifyJsbridge.this.errorCallback(this.b, "closeBiometric", i);
        }

        @Override // com.ali.user.mobile.model.CommonCallback
        public void onSuccess() {
            String str = this.a.requestScene;
            UserTrackAdapter.sendUT(UTConstant.PageName.UT_PAGE_EXTEND, UTConstant.CustomEvent.CLOSE_BIO_S, str, str, null);
            VerifyJsbridge.this.successCallback(this.b, "closeBiometric");
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class f extends CountDownTimer {
        final /* synthetic */ int a;
        final /* synthetic */ WVCallBackContext b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(long j, long j2, int i, WVCallBackContext wVCallBackContext) {
            super(j, j2);
            this.a = i;
            this.b = wVCallBackContext;
        }

        public void onFinish() {
            AudioRecordFunc.getInstance().stopRecordAndFile();
            if (AudioRecordFunc.getInstance().getMaxVolume() < ((double) this.a)) {
                VerifyJsbridge.this.successCallback(this.b, UTConstant.Args.UT_VERIFY_CHECKNOISE);
            } else {
                VerifyJsbridge.this.errorCallback(this.b, UTConstant.Args.UT_VERIFY_CHECKNOISE, 13010);
            }
        }

        public void onTick(long j) {
        }
    }

    private synchronized void applyIVToken(String str, final WVCallBackContext wVCallBackContext) {
        this.mCallback = wVCallBackContext;
        try {
            String string = new JSONObject(str).getString("actionType");
            IWVWebView iWVWebView = this.mWebView;
            if (iWVWebView != null) {
                try {
                    String host = Uri.parse(iWVWebView.getUrl()).getHost();
                    if (DataProviderFactory.getDataProvider().getEnvType() == LoginEnvType.ONLINE.getSdkEnvType() && !host.endsWith(".taobao.com") && !host.endsWith(".tmall.com")) {
                        ivErrorCallback(wVCallBackContext, -3, "invalid host");
                        return;
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            if (this.mLoginReceiver == null) {
                this.mLoginReceiver = new BroadcastReceiver() {
                    /* class com.taobao.login4android.video.VerifyJsbridge.AnonymousClass4 */

                    public void onReceive(Context context, Intent intent) {
                        if (intent != null) {
                            int i = b.a[LoginAction.valueOf(intent.getAction()).ordinal()];
                            if (i == 1) {
                                String stringExtra = intent.getStringExtra("token");
                                if (!TextUtils.isEmpty(stringExtra)) {
                                    WVResult wVResult = new WVResult();
                                    wVResult.setResult(WVResult.SUCCESS);
                                    wVResult.addData("token", stringExtra);
                                    if (VerifyJsbridge.this.mCallback != null) {
                                        VerifyJsbridge.this.mCallback.success(wVResult);
                                        return;
                                    }
                                    return;
                                }
                                VerifyJsbridge.this.ivErrorCallback(wVCallBackContext, -2, "empty token");
                            } else if (i == 2) {
                                VerifyJsbridge.this.ivErrorCallback(wVCallBackContext, intent.getIntExtra("errorCode", 1100), intent.getStringExtra("message"));
                            }
                        }
                    }
                };
                LoginBroadcastHelper.registerLoginReceiver(DataProviderFactory.getApplicationContext(), this.mLoginReceiver);
            }
            LoginController.getInstance().navToIVByScene(DataProviderFactory.getApplicationContext(), string, DataProviderFactory.getDataProvider().getSite());
        } catch (Exception unused) {
            ivErrorCallback(wVCallBackContext, -1, "error param");
        }
    }

    private synchronized void biometricIV(String str, WVCallBackContext wVCallBackContext) {
        WVResult wVResult = new WVResult();
        try {
            String optString = new JSONObject(str).optString(SessionConstants.BIOMETRIC);
            if (ServiceFactory.getService(FingerprintService.class) != null) {
                String fingerValue = SecurityGuardManagerWraper.getFingerValue(optString);
                if (!TextUtils.isEmpty(fingerValue)) {
                    ((NavigatorService) ServiceFactory.getService(NavigatorService.class)).fingerIV(this.mContext, new c(this, wVResult, fingerValue, wVCallBackContext));
                    return;
                }
                wVResult.addData("code", Integer.valueOf((int) VerifyApi.FINGER_VERIFY_NO_BIO_KEY));
            }
        } catch (Throwable th) {
            wVResult.addData("code", Integer.valueOf((int) VerifyApi.FINGER_VERIFY_INVALID_PARAM));
            th.printStackTrace();
        }
        if (wVCallBackContext != null) {
            wVCallBackContext.error(wVResult);
        }
    }

    public static VerifyParam buildVerifyParam(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        String optString = jSONObject.optString(SessionConstants.BIOMETRIC);
        String string = jSONObject.getString("requestScene");
        String string2 = jSONObject.getString("biometricType");
        String optString2 = jSONObject.optString("token");
        VerifyParam verifyParam = new VerifyParam();
        verifyParam.biometricId = optString;
        verifyParam.requestScene = string;
        verifyParam.biometricType = string2;
        verifyParam.loginToken = optString2;
        return verifyParam;
    }

    private synchronized void checkBiometricStatus(String str, WVCallBackContext wVCallBackContext) {
        WVResult wVResult = new WVResult();
        try {
            String optString = new JSONObject(str).optString(SessionConstants.BIOMETRIC);
            if (ServiceFactory.getService(FingerprintService.class) != null) {
                if (!TextUtils.isEmpty(SecurityGuardManagerWraper.getFingerValue(optString))) {
                    if (wVCallBackContext != null) {
                        wVResult.addData("supportBiometricType", "fingerprint");
                        wVCallBackContext.success(wVResult);
                    }
                    return;
                }
                wVResult.addData("code", Integer.valueOf((int) VerifyApi.FINGER_VERIFY_NO_BIO_KEY));
            }
        } catch (Throwable th) {
            wVResult.addData("code", Integer.valueOf((int) VerifyApi.FINGER_VERIFY_INVALID_PARAM));
            th.printStackTrace();
        }
        if (wVCallBackContext != null) {
            wVCallBackContext.error(wVResult);
        }
    }

    private synchronized void checkNoise(final String str, final WVCallBackContext wVCallBackContext) {
        try {
            PermissionProposer.buildPermissionTask(wVCallBackContext.getWebview().getContext(), new String[]{"android.permission.RECORD_AUDIO"}).setTaskOnPermissionGranted(new Runnable() {
                /* class com.taobao.login4android.video.VerifyJsbridge.AnonymousClass6 */

                public void run() {
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        VerifyJsbridge.this.testRecordNoise(wVCallBackContext, jSONObject.getInt("checkSeconds"), jSONObject.getInt("maxVolume"));
                    } catch (JSONException e) {
                        e.printStackTrace();
                        VerifyJsbridge.this.errorCallback(wVCallBackContext, UTConstant.Args.UT_VERIFY_CHECKNOISE, RecordErrorCode.E_UNKOWN);
                    }
                }
            }).setTaskOnPermissionDenied(new Runnable() {
                /* class com.taobao.login4android.video.VerifyJsbridge.AnonymousClass5 */

                public void run() {
                    VerifyJsbridge.this.errorCallback(wVCallBackContext, UTConstant.Args.UT_VERIFY_CHECKNOISE, RecordErrorCode.E_NO_PERMISSION);
                }
            }).execute();
        } catch (Exception e2) {
            e2.printStackTrace();
            errorCallback(wVCallBackContext, UTConstant.Args.UT_VERIFY_CHECKNOISE, RecordErrorCode.E_UNKOWN);
        }
        return;
    }

    private synchronized void closeBiometric(String str, WVCallBackContext wVCallBackContext) {
        try {
            VerifyParam buildVerifyParam = buildVerifyParam(str);
            String str2 = buildVerifyParam.requestScene;
            UserTrackAdapter.sendUT(UTConstant.PageName.UT_PAGE_EXTEND, UTConstant.CustomEvent.CLOSE_BIO_C, str2, str2, null);
            VerifyApi.closeBiometric(buildVerifyParam, new e(buildVerifyParam, wVCallBackContext));
        } catch (JSONException e2) {
            e2.printStackTrace();
            errorCallback(wVCallBackContext, "closeBiometric", 4010);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void errorCallback(WVCallBackContext wVCallBackContext, String str, int i) {
        WVResult wVResult = new WVResult();
        wVResult.setResult("HY_FAILED");
        wVResult.addData("code", Integer.valueOf(i));
        wVResult.addData(WXDebugConstants.ENV_DEVICE_MODEL, Build.getMODEL());
        wVCallBackContext.error(wVResult);
        Properties properties = new Properties();
        properties.put(UTConstant.Args.UT_PROPERTY_SUCCESS, UTConstant.Args.UT_SUCCESS_F);
        properties.put("code", Integer.valueOf(i));
        if (!TextUtils.isEmpty(str)) {
            UserTrackAdapter.sendUT(str, properties);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void ivErrorCallback(WVCallBackContext wVCallBackContext, int i, String str) {
        WVResult wVResult = new WVResult();
        wVResult.setResult("HY_FAILED");
        wVResult.addData("code", Integer.valueOf(i));
        wVResult.addData("message", str);
        wVCallBackContext.error(wVResult);
    }

    private synchronized void openBiometric(String str, WVCallBackContext wVCallBackContext) {
        try {
            VerifyParam buildVerifyParam = buildVerifyParam(str);
            String str2 = buildVerifyParam.requestScene;
            UserTrackAdapter.sendUT(UTConstant.PageName.UT_PAGE_EXTEND, UTConstant.CustomEvent.OPEN_BIO_C, str2, str2, null);
            VerifyApi.openBiometric(this.mContext, buildVerifyParam, new d(buildVerifyParam, wVCallBackContext));
        } catch (Exception e2) {
            e2.printStackTrace();
            UserTrackAdapter.sendUT(UTConstant.PageName.UT_PAGE_EXTEND, UTConstant.CustomEvent.OPEN_BIO_S);
            errorCallback(wVCallBackContext, "openBiometric", 4003);
        }
    }

    private synchronized void startRecord(final String str, final WVCallBackContext wVCallBackContext) {
        try {
            PermissionProposer.buildPermissionTask(wVCallBackContext.getWebview().getContext(), new String[]{"android.permission.RECORD_AUDIO"}).setTaskOnPermissionGranted(new Runnable() {
                /* class com.taobao.login4android.video.VerifyJsbridge.AnonymousClass9 */

                public void run() {
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        int i = jSONObject.getInt("maxSeconds");
                        int i2 = jSONObject.getInt("minSeconds");
                        AudioRecordFunc instance = AudioRecordFunc.getInstance();
                        instance.setMaxRecordSeconds(i);
                        instance.setmMinRecordSeconds(i2);
                        instance.startRecordAndFile();
                        VerifyJsbridge.this.successCallback(wVCallBackContext, UTConstant.Args.UT_VERIFY_STARTRECORD);
                    } catch (JSONException e) {
                        e.printStackTrace();
                        VerifyJsbridge.this.errorCallback(wVCallBackContext, UTConstant.Args.UT_VERIFY_STARTRECORD, RecordErrorCode.E_UNKOWN);
                    }
                }
            }).setTaskOnPermissionDenied(new Runnable() {
                /* class com.taobao.login4android.video.VerifyJsbridge.AnonymousClass8 */

                public void run() {
                    VerifyJsbridge.this.errorCallback(wVCallBackContext, UTConstant.Args.UT_VERIFY_STARTRECORD, RecordErrorCode.E_NO_PERMISSION);
                }
            }).execute();
        } catch (Exception unused) {
            errorCallback(wVCallBackContext, UTConstant.Args.UT_VERIFY_STARTRECORD, RecordErrorCode.E_UNKOWN);
        }
        return;
    }

    private synchronized void stopRecord(String str, WVCallBackContext wVCallBackContext) {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            AudioRecordFunc instance = AudioRecordFunc.getInstance();
            if (instance.isClosedForLimit()) {
                errorCallback(wVCallBackContext, UTConstant.Args.UT_VERIFY_STOPRECORD, RecordErrorCode.E_15_SECONDS_LIMMIT);
                AudioRecordFunc.getInstance().stopRecordAndFile();
                return;
            }
            instance.stopRecordAndFile();
            long recordTime = instance.getRecordTime();
            if (recordTime > ((long) instance.getMaxRecordSeconds())) {
                errorCallback(wVCallBackContext, UTConstant.Args.UT_VERIFY_STOPRECORD, RecordErrorCode.E_15_SECONDS_LIMMIT);
                return;
            } else if (recordTime < ((long) instance.getMinRecordSeconds())) {
                errorCallback(wVCallBackContext, UTConstant.Args.UT_VERIFY_STOPRECORD, RecordErrorCode.E_1_SECONDS_LIMIT);
                return;
            } else {
                String audioName = instance.getAudioName();
                if (audioName != null) {
                    UploadTask.getInstance().setResultCallback(new a(new WVResult(), wVCallBackContext, currentTimeMillis));
                    UploadTask.getInstance().uploadAsync(DataProviderFactory.getApplicationContext(), audioName, "a/b");
                } else {
                    errorCallback(wVCallBackContext, UTConstant.Args.UT_VERIFY_STOPRECORD, RecordErrorCode.E_UNKOWN);
                }
                return;
            }
        } catch (Throwable th) {
            th.printStackTrace();
            errorCallback(wVCallBackContext, UTConstant.Args.UT_VERIFY_STOPRECORD, RecordErrorCode.E_UNKOWN);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void successCallback(WVCallBackContext wVCallBackContext, String str) {
        WVResult wVResult = new WVResult();
        wVResult.setResult(WVResult.SUCCESS);
        wVResult.addData(WXDebugConstants.ENV_DEVICE_MODEL, Build.getMODEL());
        wVCallBackContext.success(wVResult);
        Properties properties = new Properties();
        properties.put(UTConstant.Args.UT_PROPERTY_SUCCESS, "T");
        if (!TextUtils.isEmpty(str)) {
            UserTrackAdapter.sendUT(str, properties);
        }
    }

    private synchronized void supportBiometricType(WVCallBackContext wVCallBackContext) {
        WVResult wVResult = new WVResult();
        wVResult.setResult(WVResult.SUCCESS);
        if (ServiceFactory.getService(FingerprintService.class) == null || !((FingerprintService) ServiceFactory.getService(FingerprintService.class)).isFingerprintSetable()) {
            wVResult.addData("supportBiometricType", "");
        } else {
            wVResult.addData("supportBiometricType", "fingerprint");
        }
        if (wVCallBackContext != null) {
            wVCallBackContext.success(wVResult);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void testRecordNoise(WVCallBackContext wVCallBackContext, int i, int i2) {
        int startRecordAndCheckNoise = AudioRecordFunc.getInstance().startRecordAndCheckNoise();
        if (1000 == startRecordAndCheckNoise || 1002 == startRecordAndCheckNoise) {
            new f((long) (i * 1000), 500, i2, wVCallBackContext).start();
        } else {
            errorCallback(wVCallBackContext, UTConstant.Args.UT_VERIFY_CHECKNOISE, startRecordAndCheckNoise);
        }
    }

    @Override // android.taobao.windvane.jsbridge.WVApiPlugin
    public boolean execute(String str, String str2, WVCallBackContext wVCallBackContext) {
        if (!TextUtils.isEmpty(str)) {
            UserTrackAdapter.sendUT(str);
        }
        if ("supportBiometricType".equals(str)) {
            supportBiometricType(wVCallBackContext);
            return true;
        } else if ("openBiometric".equals(str)) {
            openBiometric(str2, wVCallBackContext);
            return true;
        } else if ("closeBiometric".equals(str)) {
            closeBiometric(str2, wVCallBackContext);
            return true;
        } else if ("checkBiometricStatus".equals(str)) {
            checkBiometricStatus(str2, wVCallBackContext);
            return true;
        } else if ("biometricIV".equals(str)) {
            biometricIV(str2, wVCallBackContext);
            return true;
        } else if ("checkNoise".equals(str)) {
            checkNoise(str2, wVCallBackContext);
            return true;
        } else if ("startRecord".equals(str)) {
            startRecord(str2, wVCallBackContext);
            return true;
        } else if ("stopRecord".equals(str)) {
            stopRecord(str2, wVCallBackContext);
            return true;
        } else if ("aluApplyIVToken".equals(str)) {
            applyIVToken(str2, wVCallBackContext);
            return true;
        } else if (!"checkEnv".equals(str)) {
            return false;
        } else {
            if (wVCallBackContext == null) {
                return true;
            }
            wVCallBackContext.success();
            return true;
        }
    }

    @Override // android.taobao.windvane.jsbridge.WVApiPlugin
    public void onDestroy() {
        if (this.mLoginReceiver != null) {
            LoginBroadcastHelper.unregisterLoginReceiver(DataProviderFactory.getApplicationContext(), this.mLoginReceiver);
            this.mLoginReceiver = null;
        }
        this.mCallback = null;
        super.onDestroy();
    }

    @Override // android.taobao.windvane.jsbridge.WVApiPlugin
    public void onPause() {
        super.onPause();
        try {
            AudioRecordFunc.getInstance().stopRecordAndFile();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
