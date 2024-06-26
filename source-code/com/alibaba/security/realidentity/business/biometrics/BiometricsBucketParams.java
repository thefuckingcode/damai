package com.alibaba.security.realidentity.business.biometrics;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.alibaba.security.biometrics.jni.VersionKey;
import com.alibaba.security.biometrics.service.constants.GlobalErrorCode;
import com.alibaba.security.biometrics.service.listener.OnRetryListener;
import com.alibaba.security.biometrics.service.model.params.ALBiometricsKeys;
import com.alibaba.security.biometrics.service.model.result.ALBiometricsResult;
import com.alibaba.security.common.d.h;
import com.alibaba.security.common.track.a.a;
import com.alibaba.security.common.track.model.TrackLog;
import com.alibaba.security.realidentity.RPResult;
import com.alibaba.security.realidentity.a.b;
import com.alibaba.security.realidentity.business.RPBusinessHeadParams;
import com.alibaba.security.realidentity.business.base.chain.BusinessHeadParams;
import com.alibaba.security.realidentity.business.biometrics.AbsBiometricsBucketParams;
import com.alibaba.security.realidentity.business.biometrics.model.RiskActionMaterial;
import com.alibaba.security.realidentity.business.bucket.BucketParams;
import com.alibaba.security.realidentity.business.c;
import com.alibaba.security.realidentity.business.dynamic.model.ScConfig;
import com.alibaba.security.realidentity.business.start.StartHttpParams;
import com.alibaba.security.realidentity.business.start.StartHttpResponse;
import com.alibaba.security.realidentity.business.start.model.StartExtraInfo;
import com.alibaba.security.realidentity.business.start.model.StepItem;
import com.alibaba.security.realidentity.http.RpcInvoker;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import mtopsdk.mtop.domain.MtopResponse;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
public class BiometricsBucketParams extends AbsBiometricsBucketParams {
    private static final String TAG = BiometricsBucketParams.class.getSimpleName();
    private final ThreadPoolExecutor mExecutorService;
    private final a mUiHandler = new a(this);
    private Bundle params = new Bundle();
    private boolean sessionless = false;
    private StartHttpParams startHttpParams = null;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class a extends Handler {
        private final BiometricsBucketParams a;

        public a(BiometricsBucketParams biometricsBucketParams) {
            super(Looper.getMainLooper());
            this.a = biometricsBucketParams;
        }

        public final void dispatchMessage(Message message) {
            super.dispatchMessage(message);
        }
    }

    public BiometricsBucketParams() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 10, 10, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactory() {
            /* class com.alibaba.security.realidentity.business.biometrics.BiometricsBucketParams.AnonymousClass1 */

            public final Thread newThread(Runnable runnable) {
                return new Thread(runnable, "tbrpsdk-biometrics");
            }
        });
        this.mExecutorService = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
    }

    private void assemable(RPBusinessHeadParams rPBusinessHeadParams) {
        if (rPBusinessHeadParams != null) {
            Bundle bundle = new Bundle();
            this.params = bundle;
            bundle.putString(ALBiometricsKeys.KEY_SEC_TOKEN, this.mVerifyToken);
            this.params.putBoolean(ALBiometricsKeys.KEY_SESSION_LESS, rPBusinessHeadParams.sessionless);
            this.params.putBoolean(ALBiometricsKeys.KEY_NEED_ORIGINAL_IMAGE, rPBusinessHeadParams.needOriginalImage);
            if (!TextUtils.isEmpty(rPBusinessHeadParams.userName)) {
                this.params.putString(ALBiometricsKeys.KEY_USERNAME, rPBusinessHeadParams.userName);
            }
            List<Integer> list = rPBusinessHeadParams.bioStepsEx;
            if (list != null) {
                this.params.putInt(ALBiometricsKeys.KEY_ACTION_COUNT, list.size());
                if (list.size() > 0) {
                    int[] iArr = new int[list.size()];
                    for (int i = 0; i < list.size(); i++) {
                        iArr[i] = list.get(i).intValue();
                    }
                    this.params.putIntArray("strategy", iArr);
                }
            }
            String str = h.a(rPBusinessHeadParams.livenessConfig) ? rPBusinessHeadParams.livenessConfig : null;
            if (!TextUtils.isEmpty(str)) {
                this.params.putString(ALBiometricsKeys.KEY_BIOMETRICS_CONFIG, str);
            }
            this.params.putString(ALBiometricsKeys.KEY_VERIFY_TOKEN, this.mVerifyToken);
            this.params.putBoolean(ALBiometricsKeys.KEY_STEP_NAV, rPBusinessHeadParams.showNav);
            this.params.putBoolean(ALBiometricsKeys.KEY_LESS_IMAGE_MODE, true);
            this.params.putBoolean(ALBiometricsKeys.KEY_STEP_ADJUST, rPBusinessHeadParams.needGaze);
            this.params.putBoolean(ALBiometricsKeys.KEY_SHOW_CHECK_DIALOG, true);
            this.params.putBoolean("needSuccessVideo", rPBusinessHeadParams.needSuccessVideo);
            this.params.putBoolean("needFailVideo", rPBusinessHeadParams.needFailVideo);
            this.params.putBoolean(ALBiometricsKeys.KEY_CAMERA2_OPEN, parseCamera2Config(rPBusinessHeadParams.verifyConf));
            this.params.putString(ALBiometricsKeys.KEY_BIZ_CONF, parseBioConfig(rPBusinessHeadParams.steps));
            this.params.putBoolean(ALBiometricsKeys.KEY_CAMERA_PREVIEW_SWITCH, parseCameraPreviewConfig(rPBusinessHeadParams.verifyConf));
            this.params.putIntegerArrayList(ALBiometricsKeys.KEY_BIO_STEPS, parseBioSteps(rPBusinessHeadParams));
            this.params.putBoolean(ALBiometricsKeys.KEY_BEAUTY_SWITCH, parseBeautySwitch(rPBusinessHeadParams.verifyConf));
            ScConfig scConfig = rPBusinessHeadParams.getScConfig();
            if (scConfig != null) {
                try {
                    this.params.putBoolean(ALBiometricsKeys.KEY_DATA_COLLECT_SWITCH, Boolean.parseBoolean(scConfig.getNeedCollect()));
                    this.params.putString(ALBiometricsKeys.KEY_DATA_COLLECT_ENABLED_SENSORS, scConfig.getEnableSensors());
                    this.params.putInt(ALBiometricsKeys.KEY_DATA_COLLECT_INTERVAL, Integer.parseInt(scConfig.getInterval()));
                    this.params.putInt(ALBiometricsKeys.KEY_DATA_COLLECT_MAX_CLICK_COUNT, Integer.parseInt(scConfig.getMaxClickCnt()));
                    this.params.putInt(ALBiometricsKeys.KEY_DATA_COLLECT_MAX_SENSOR_COUNT, Integer.parseInt(scConfig.getClickSensorCnt()));
                } catch (Exception unused) {
                    com.alibaba.security.common.c.a.b();
                }
            }
            if (rPBusinessHeadParams.onlyGaze) {
                this.params.putInt(ALBiometricsKeys.KEY_ACTION_COUNT, 0);
                this.params.putBoolean(ALBiometricsKeys.KEY_STEP_ADJUST, true);
            }
        }
    }

    private AbsBiometricsBucketParams.ALBiometricsCallBackBean onLivenessDetectFailed(ALBiometricsResult aLBiometricsResult) {
        AbsBiometricsBucketParams.ALBiometricsCallBackBean aLBiometricsCallBackBean = new AbsBiometricsBucketParams.ALBiometricsCallBackBean();
        if (this.isLimited) {
            aLBiometricsCallBackBean.errorCode = GlobalErrorCode.ERROR_USER_RETRY_LIMITED;
            aLBiometricsCallBackBean.isSuccessful = true;
            return aLBiometricsCallBackBean;
        }
        if (aLBiometricsResult != null) {
            int r = aLBiometricsResult.getR();
            if (r == -1) {
                aLBiometricsCallBackBean.errorCode = 4;
                return aLBiometricsCallBackBean;
            } else if (r == -10405) {
                aLBiometricsCallBackBean.errorCode = 5;
            } else if (r == -10102 || r == -10103) {
                aLBiometricsCallBackBean.errorCode = 6;
            } else {
                aLBiometricsCallBackBean.errorCode = 2;
            }
        } else {
            aLBiometricsCallBackBean.errorCode = 2;
        }
        aLBiometricsCallBackBean.isSuccessful = false;
        return aLBiometricsCallBackBean;
    }

    private AbsBiometricsBucketParams.ALBiometricsCallBackBean onLivenessDetectSuccess(Context context, ALBiometricsResult aLBiometricsResult) {
        if (aLBiometricsResult == null || aLBiometricsResult.getQi() == null) {
            AbsBiometricsBucketParams.ALBiometricsCallBackBean aLBiometricsCallBackBean = new AbsBiometricsBucketParams.ALBiometricsCallBackBean();
            aLBiometricsCallBackBean.errorCode = 2;
            aLBiometricsCallBackBean.errorMsg = "验证不通过，请按提示做动作";
            aLBiometricsCallBackBean.isSuccessful = false;
            HashMap hashMap = new HashMap();
            hashMap.put("errorCode", 2);
            hashMap.put("errorMsg", "验证不通过，请按提示做动作");
            b.a().a(0, com.alibaba.security.realidentity.a.a.F, "livenessFailed", hashMap);
            return aLBiometricsCallBackBean;
        }
        AbsBiometricsBucketParams.ALBiometricsCallBackBean aLBiometricsCallBackBean2 = new AbsBiometricsBucketParams.ALBiometricsCallBackBean();
        aLBiometricsCallBackBean2.errorCode = 0;
        aLBiometricsCallBackBean2.isSuccessful = true;
        return aLBiometricsCallBackBean2;
    }

    private void reportEvent(final Context context, final OnRetryListener onRetryListener, final String str, final String str2, final String str3, final String str4) {
        this.mExecutorService.execute(new Runnable() {
            /* class com.alibaba.security.realidentity.business.biometrics.BiometricsBucketParams.AnonymousClass2 */

            public final void run() {
                HashMap hashMap = new HashMap();
                hashMap.put(com.alibaba.security.realidentity.jsbridge.a.d, BiometricsBucketParams.this.mVerifyToken);
                hashMap.put("eventCode", str4);
                hashMap.put("name", str);
                RiskActionMaterial riskActionMaterial = new RiskActionMaterial();
                riskActionMaterial.flActionLog = str2;
                riskActionMaterial.sensorActionLog = str3;
                hashMap.put("eventData", h.a(riskActionMaterial));
                BiometricsBucketParams.this.trackRiskStart(str2, str3, str4);
                BiometricsBucketParams biometricsBucketParams = BiometricsBucketParams.this;
                biometricsBucketParams.isLimited = biometricsBucketParams.verifyLimitedEvent(context, hashMap);
                BiometricsBucketParams.this.mUiHandler.post(new Runnable() {
                    /* class com.alibaba.security.realidentity.business.biometrics.BiometricsBucketParams.AnonymousClass2.AnonymousClass1 */

                    public final void run() {
                        AnonymousClass2 r0 = AnonymousClass2.this;
                        OnRetryListener onRetryListener = onRetryListener;
                        if (onRetryListener != null) {
                            onRetryListener.onRetry(!BiometricsBucketParams.this.isLimited ? 1 : 0);
                        }
                    }
                });
            }
        });
    }

    private void trackRiskEnd(int i, boolean z, String str, String str2) {
        TrackLog createRiskEndLog = TrackLog.createRiskEndLog(i, z, str, str2);
        createRiskEndLog.setVerifyToken(this.mVerifyToken);
        createRiskEndLog.addTag9(VersionKey.RP_SDK_VERSION + "/3.3.0");
        createRiskEndLog.addTag10("Android");
        a.C0102a.a.a(createRiskEndLog);
        a.C0102a.a.a(false);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void trackRiskStart(String str, String str2, String str3) {
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str)) {
            arrayList.add("flActionLog");
        }
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add("sensorActionLog");
        }
        TrackLog createRiskStartLog = TrackLog.createRiskStartLog(this.sessionless, arrayList, str3);
        createRiskStartLog.setVerifyToken(this.mVerifyToken);
        createRiskStartLog.addTag9(VersionKey.RP_SDK_VERSION + "/3.3.0");
        createRiskStartLog.addTag10("Android");
        a.C0102a.a.a(createRiskStartLog);
        a.C0102a.a.a(false);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private boolean verifyLimitedEvent(Context context, Map<String, String> map) {
        String str = this.sessionless ? com.alibaba.security.realidentity.a.b : com.alibaba.security.realidentity.a.a;
        if (context == null) {
            return false;
        }
        MtopResponse callMtopSync = RpcInvoker.callMtopSync(context, str, "1.0", true, map);
        if (callMtopSync == null) {
            trackRiskEnd(GlobalErrorCode.ERROR_ONLINE_NET_ERROR, true, "-10300", "Null response");
            return false;
        } else if (!callMtopSync.isApiSuccess()) {
            trackRiskEnd(GlobalErrorCode.ERROR_ONLINE_NET_ERROR, true, callMtopSync.getMappingCode(), callMtopSync.getRetMsg());
            return false;
        } else {
            JSONObject dataJsonObject = callMtopSync.getDataJsonObject();
            if (dataJsonObject == null) {
                trackRiskEnd(GlobalErrorCode.ERROR_ONLINE_NET_ERROR, true, callMtopSync.getMappingCode(), callMtopSync.getRetMsg());
                return false;
            }
            try {
                JSONObject jSONObject = dataJsonObject.getJSONObject("result");
                if (jSONObject == null) {
                    trackRiskEnd(GlobalErrorCode.ERROR_ONLINE_NET_ERROR, true, callMtopSync.getMappingCode(), callMtopSync.getRetMsg());
                    return false;
                }
                trackRiskEnd(0, false, callMtopSync.getMappingCode(), callMtopSync.getRetMsg());
                return !jSONObject.optBoolean("verifyLimitedFlag", true);
            } catch (JSONException unused) {
            }
        }
    }

    @Override // com.alibaba.security.realidentity.business.bucket.BucketParams
    public boolean finishTask(Context context, boolean z, BucketParams.a aVar, Object... objArr) {
        if (z) {
            onLivenessDetectSuccess(context, this.biometricsResult);
            return true;
        }
        onLivenessDetectFailed(this.biometricsResult);
        return true;
    }

    @Override // com.alibaba.security.realidentity.business.bucket.BucketParams
    public Bundle getBundle() {
        return this.params;
    }

    public StartHttpParams getStartHttpParams() {
        return this.startHttpParams;
    }

    @Override // com.alibaba.security.realidentity.business.bucket.BucketParams
    public boolean onDelivering(c cVar) {
        StartHttpParams startHttpParams2 = cVar.c;
        if (startHttpParams2 != null) {
            this.startHttpParams = startHttpParams2;
            BusinessHeadParams businessHeadParams = cVar.b;
            assemable(startHttpParams2.mStartHttpResponse, businessHeadParams == null ? -2 : businessHeadParams.getCtidCode(), this.startHttpParams.mShowResult, businessHeadParams.getScConfig());
            return true;
        }
        BusinessHeadParams businessHeadParams2 = cVar.b;
        if (businessHeadParams2 != null) {
            StartHttpParams startHttpParams3 = new StartHttpParams();
            RPBusinessHeadParams rPBusinessHeadParams = (RPBusinessHeadParams) businessHeadParams2;
            this.sessionless = rPBusinessHeadParams.sessionless;
            startHttpParams3.mNeedActionImage = rPBusinessHeadParams.needActionImage;
            startHttpParams3.mNeedGaze = rPBusinessHeadParams.needGaze;
            startHttpParams3.mVerifyDowngradConfig = rPBusinessHeadParams.verifyConf;
            startHttpParams3.mBizConf = rPBusinessHeadParams.bizConf;
            List<Integer> list = rPBusinessHeadParams.bioStepsEx;
            if (list != null) {
                startHttpParams3.mActionCount = list.size();
            }
            startHttpParams3.mLivenessConfig = rPBusinessHeadParams.livenessConfig;
            startHttpParams3.mShowNav = rPBusinessHeadParams.showNav;
            startHttpParams3.mNeedOriginalImage = rPBusinessHeadParams.needOriginalImage;
            new StepItem.JsonAssist().setBioStepsEx(rPBusinessHeadParams.bioStepsEx);
            cVar.c = startHttpParams3;
            assemable(rPBusinessHeadParams);
        }
        return true;
    }

    @Override // com.alibaba.security.realidentity.business.bucket.BucketParams
    public BucketParams.ErrorCode parseErrorCode() {
        if (this.isSuccessful) {
            return new BucketParams.ErrorCode(RPResult.AUDIT_PASS, "0", "bio success", 0);
        }
        AbsBiometricsBucketParams.ALBiometricsCallBackBean aLBiometricsCallBackBean = this.biometricsCallBackBean;
        if (aLBiometricsCallBackBean == null) {
            return new BucketParams.ErrorCode(RPResult.AUDIT_NOT, "-10000", "biometrics bean is null", -10000);
        }
        RPResult rPResult = RPResult.AUDIT_NOT;
        String valueOf = String.valueOf(aLBiometricsCallBackBean.errorCode);
        AbsBiometricsBucketParams.ALBiometricsCallBackBean aLBiometricsCallBackBean2 = this.biometricsCallBackBean;
        return new BucketParams.ErrorCode(rPResult, valueOf, aLBiometricsCallBackBean2.errorMsg, aLBiometricsCallBackBean2.errorCode);
    }

    @Override // com.alibaba.security.realidentity.business.biometrics.AbsBiometricsBucketParams
    public void riskEvent(Context context, OnRetryListener onRetryListener, String str, String str2, String str3, String str4) {
        super.riskEvent(context, onRetryListener, str, str2, str3, str4);
        reportEvent(context, onRetryListener, str3, str, str2, str4);
    }

    private void assemable(StartHttpResponse startHttpResponse, int i, boolean z, ScConfig scConfig) {
        StartExtraInfo.IdentityInfo identityInfo;
        if (startHttpResponse != null) {
            StartExtraInfo extraInfoBean = startHttpResponse.getExtraInfoBean();
            StepItem biometricsStepItem = startHttpResponse.getBiometricsStepItem();
            if (biometricsStepItem != null) {
                this.params = new Bundle();
                if (startHttpResponse.isLimited()) {
                    this.params.putBoolean(ALBiometricsKeys.KEY_REACH_BUSINESS_RETRY_LIMITED, true);
                }
                this.params.putString(ALBiometricsKeys.KEY_SEC_TOKEN, this.mVerifyToken);
                if (!(extraInfoBean == null || (identityInfo = extraInfoBean.identityInfo) == null || TextUtils.isEmpty(identityInfo.name))) {
                    this.params.putString(ALBiometricsKeys.KEY_USERNAME, extraInfoBean.identityInfo.name);
                }
                String str = null;
                this.params.putBoolean(ALBiometricsKeys.KEY_CAMERA2_OPEN, parseCamera2Config(startHttpResponse.getResult() == null ? null : startHttpResponse.getResult().getVerifyConf()));
                this.params.putBoolean(ALBiometricsKeys.KEY_CAMERA_PREVIEW_SWITCH, parseCameraPreviewConfig(startHttpResponse.getResult() == null ? null : startHttpResponse.getResult().getVerifyConf()));
                this.params.putIntegerArrayList(ALBiometricsKeys.KEY_BIO_STEPS, startHttpResponse.obtainBioSteps());
                this.params.putBoolean(ALBiometricsKeys.KEY_BEAUTY_SWITCH, parseBeautySwitch(startHttpResponse.getResult() == null ? null : startHttpResponse.getResult().getVerifyConf()));
                this.params.putString(ALBiometricsKeys.KEY_BIZ_CONF, startHttpResponse.obtainDazzleConfig());
                this.params.putString(ALBiometricsKeys.KEY_VERIFY_TOKEN, this.mVerifyToken);
                this.params.putInt(ALBiometricsKeys.KEY_CTID_RESULT_CODE, i);
                if (scConfig != null) {
                    try {
                        this.params.putBoolean(ALBiometricsKeys.KEY_DATA_COLLECT_SWITCH, Boolean.parseBoolean(scConfig.getNeedCollect()));
                        this.params.putString(ALBiometricsKeys.KEY_DATA_COLLECT_ENABLED_SENSORS, scConfig.getEnableSensors());
                        this.params.putInt(ALBiometricsKeys.KEY_DATA_COLLECT_INTERVAL, Integer.parseInt(scConfig.getInterval()));
                        this.params.putInt(ALBiometricsKeys.KEY_DATA_COLLECT_MAX_CLICK_COUNT, Integer.parseInt(scConfig.getMaxClickCnt()));
                        this.params.putInt(ALBiometricsKeys.KEY_DATA_COLLECT_MAX_SENSOR_COUNT, Integer.parseInt(scConfig.getClickSensorCnt()));
                    } catch (Exception unused) {
                        com.alibaba.security.common.c.a.b();
                    }
                }
                StepItem.JsonAssist jsonAssistBean = biometricsStepItem.getJsonAssistBean();
                List<Integer> bioStepsEx = jsonAssistBean.getBioStepsEx();
                if (bioStepsEx != null) {
                    this.params.putInt(ALBiometricsKeys.KEY_ACTION_COUNT, bioStepsEx.size());
                    if (bioStepsEx.size() > 0) {
                        int[] iArr = new int[bioStepsEx.size()];
                        for (int i2 = 0; i2 < bioStepsEx.size(); i2++) {
                            iArr[i2] = bioStepsEx.get(i2).intValue();
                        }
                        this.params.putIntArray("strategy", iArr);
                    }
                }
                if (h.a(jsonAssistBean.getLivenessConfig())) {
                    str = jsonAssistBean.getLivenessConfig();
                }
                if (!TextUtils.isEmpty(str)) {
                    this.params.putString(ALBiometricsKeys.KEY_BIOMETRICS_CONFIG, str);
                }
                this.params.putBoolean(ALBiometricsKeys.KEY_STEP_NAV, jsonAssistBean.isShowNav());
                this.params.putBoolean(ALBiometricsKeys.KEY_LESS_IMAGE_MODE, true);
                this.params.putBoolean(ALBiometricsKeys.KEY_STEP_ADJUST, jsonAssistBean.isNeedGaze());
                this.params.putBoolean(ALBiometricsKeys.KEY_SHOW_CHECK_DIALOG, true);
                this.params.putBoolean("needSuccessVideo", jsonAssistBean.isNeedSuccessVideo());
                this.params.putBoolean("needFailVideo", jsonAssistBean.isNeedFailVideo());
                this.params.putBoolean(ALBiometricsKeys.KEY_NEED_ORIGINAL_IMAGE, jsonAssistBean.isNeedOriginalImage());
                this.params.putBoolean(ALBiometricsKeys.KEY_STEP_RESULT, z);
                if (jsonAssistBean.isOnlyGaze()) {
                    this.params.putInt(ALBiometricsKeys.KEY_ACTION_COUNT, 0);
                    this.params.putBoolean(ALBiometricsKeys.KEY_STEP_ADJUST, true);
                }
            }
        }
    }
}
