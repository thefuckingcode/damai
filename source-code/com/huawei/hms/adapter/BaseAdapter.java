package com.huawei.hms.adapter;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.huawei.hms.activity.BridgeActivity;
import com.huawei.hms.adapter.AvailableAdapter;
import com.huawei.hms.adapter.internal.CommonCode;
import com.huawei.hms.adapter.sysobs.SystemManager;
import com.huawei.hms.adapter.sysobs.SystemObserver;
import com.huawei.hms.adapter.ui.BaseResolutionAdapter;
import com.huawei.hms.common.internal.RequestHeader;
import com.huawei.hms.common.internal.ResponseHeader;
import com.huawei.hms.common.internal.ResponseWrap;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.framework.common.ExceptionCode;
import com.huawei.hms.support.api.PendingResultImpl;
import com.huawei.hms.support.api.ResolveResult;
import com.huawei.hms.support.api.client.ApiClient;
import com.huawei.hms.support.api.client.PendingResult;
import com.huawei.hms.support.api.client.ResultCallback;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huawei.hms.support.hianalytics.HiAnalyticsUtil;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.update.kpms.KpmsConstant;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.JsonUtil;
import com.huawei.hms.utils.Util;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
public class BaseAdapter {
    private static final String HMS_SESSION_INVALID = "com.huawei.hms.core.action.SESSION_INVALID";
    private static final String TAG = "BaseAdapter";
    private WeakReference<Activity> activityWeakReference;
    private WeakReference<ApiClient> api;
    private Context appContext;
    private BaseCallBack baseCallBackReplay;
    private BaseCallBack callback;
    private String jsonHeaderReplay;
    private String jsonObjectReplay;
    private SystemObserver observer;
    private Parcelable parcelableReplay;
    private RequestHeader requestHeader = new RequestHeader();
    private ResponseHeader responseHeader = new ResponseHeader();
    private String transactionId;

    /* compiled from: Taobao */
    public interface BaseCallBack {
        void onComplete(String str, String str2, Parcelable parcelable);

        void onError(String str);
    }

    /* compiled from: Taobao */
    public class BaseRequestResultCallback implements ResultCallback<ResolveResult<CoreBaseResponse>> {
        private AtomicBoolean isFirstRsp = new AtomicBoolean(true);

        public BaseRequestResultCallback() {
        }

        private void handleSolutionForHms(final BaseCallBack baseCallBack) {
            if (!Util.isAvailableLibExist(BaseAdapter.this.appContext)) {
                HMSLog.i(BaseAdapter.TAG, "handleSolutionForHms: no Available lib exist");
                baseCallBack.onError(BaseAdapter.this.getResponseHeaderForError(-9));
                return;
            }
            Activity cpActivity = BaseAdapter.this.getCpActivity();
            if (cpActivity == null || cpActivity.isFinishing()) {
                HMSLog.e(BaseAdapter.TAG, "activity is null");
                BaseAdapter baseAdapter = BaseAdapter.this;
                baseCallBack.onError(baseAdapter.buildResponseWrap(-3, baseAdapter.buildBodyStr(-3)).toJson());
                return;
            }
            HMSLog.i(BaseAdapter.TAG, "start handleSolutionForHMS");
            AvailableAdapter availableAdapter = new AvailableAdapter(ExceptionCode.CRASH_EXCEPTION);
            availableAdapter.setCalledBySolutionInstallHms(true);
            availableAdapter.startResolution(cpActivity, new AvailableAdapter.AvailableCallBack() {
                /* class com.huawei.hms.adapter.BaseAdapter.BaseRequestResultCallback.AnonymousClass1 */

                @Override // com.huawei.hms.adapter.AvailableAdapter.AvailableCallBack
                public void onComplete(int i) {
                    HMSLog.i(BaseAdapter.TAG, "complete handleSolutionForHMS, result: " + i);
                    if (i == 0) {
                        HMSPackageManager.getInstance(BaseAdapter.this.appContext).resetMultiServiceState();
                        BaseAdapter baseAdapter = BaseAdapter.this;
                        baseCallBack.onError(baseAdapter.buildResponseWrap(11, baseAdapter.buildBodyStr(11)).toJson());
                        BaseAdapter.this.sendBroadcastAfterResolutionHms();
                        return;
                    }
                    BaseAdapter baseAdapter2 = BaseAdapter.this;
                    baseCallBack.onError(baseAdapter2.buildResponseWrap(i, baseAdapter2.buildBodyStr(i)).toJson());
                }
            });
        }

        private void handleSolutionIntent(BaseCallBack baseCallBack, CoreBaseResponse coreBaseResponse) {
            HMSLog.i(BaseAdapter.TAG, "baseCallBack.onComplete");
            PendingIntent pendingIntent = coreBaseResponse.getPendingIntent();
            if (pendingIntent != null) {
                baseCallBack.onComplete(coreBaseResponse.getJsonHeader(), coreBaseResponse.getJsonBody(), pendingIntent);
                return;
            }
            Intent intent = coreBaseResponse.getIntent();
            if (intent != null) {
                baseCallBack.onComplete(coreBaseResponse.getJsonHeader(), coreBaseResponse.getJsonBody(), intent);
            } else {
                baseCallBack.onComplete(coreBaseResponse.getJsonHeader(), coreBaseResponse.getJsonBody(), null);
            }
        }

        private void resolutionResult(String str, BaseCallBack baseCallBack, CoreBaseResponse coreBaseResponse, int i) {
            if (CommonCode.Resolution.HAS_RESOLUTION_FROM_APK.equals(str)) {
                Activity cpActivity = BaseAdapter.this.getCpActivity();
                HMSLog.i(BaseAdapter.TAG, "activity is: " + cpActivity);
                if (cpActivity == null || cpActivity.isFinishing()) {
                    HMSLog.e(BaseAdapter.TAG, "activity null");
                    handleSolutionIntent(baseCallBack, coreBaseResponse);
                    return;
                }
                PendingIntent pendingIntent = coreBaseResponse.getPendingIntent();
                if (pendingIntent == null) {
                    Intent intent = coreBaseResponse.getIntent();
                    if (intent != null) {
                        if (Util.isAvailableLibExist(BaseAdapter.this.appContext)) {
                            BaseAdapter.this.startResolution(cpActivity, intent);
                        } else {
                            baseCallBack.onError(BaseAdapter.this.getResponseHeaderForError(-9));
                        }
                    } else if (i == 2) {
                        BaseAdapter baseAdapter = BaseAdapter.this;
                        baseCallBack.onError(baseAdapter.getResponseHeaderForError(baseAdapter.responseHeader.getErrorCode()));
                    } else {
                        HMSLog.e(BaseAdapter.TAG, "hasResolution is true but NO_SOLUTION");
                        baseCallBack.onError(BaseAdapter.this.getResponseHeaderForError(-4));
                    }
                } else if (Util.isAvailableLibExist(BaseAdapter.this.appContext)) {
                    BaseAdapter.this.startResolution(cpActivity, pendingIntent);
                } else {
                    baseCallBack.onError(BaseAdapter.this.getResponseHeaderForError(-9));
                }
            } else if ("installHMS".equals(str)) {
                HMSLog.i(BaseAdapter.TAG, "has resolutin: installHMS, but base-sdk can't support to install HMS");
                handleSolutionForHms(baseCallBack);
            } else {
                handleSolutionIntent(baseCallBack, coreBaseResponse);
            }
        }

        public void onResult(ResolveResult<CoreBaseResponse> resolveResult) {
            BaseCallBack callBack = BaseAdapter.this.getCallBack();
            if (callBack == null) {
                HMSLog.e(BaseAdapter.TAG, "onResult baseCallBack null");
            } else if (resolveResult == null) {
                HMSLog.e(BaseAdapter.TAG, "result null");
                callBack.onError(BaseAdapter.this.getResponseHeaderForError(-1));
            } else {
                CoreBaseResponse value = resolveResult.getValue();
                if (value == null) {
                    HMSLog.e(BaseAdapter.TAG, "response null");
                    callBack.onError(BaseAdapter.this.getResponseHeaderForError(-1));
                } else if (TextUtils.isEmpty(value.getJsonHeader())) {
                    HMSLog.e(BaseAdapter.TAG, "jsonHeader null");
                    callBack.onError(BaseAdapter.this.getResponseHeaderForError(-1));
                } else {
                    JsonUtil.jsonToEntity(value.getJsonHeader(), BaseAdapter.this.responseHeader);
                    if (this.isFirstRsp.compareAndSet(true, false)) {
                        BaseAdapter baseAdapter = BaseAdapter.this;
                        baseAdapter.biReportRequestReturnIpc(baseAdapter.appContext, BaseAdapter.this.responseHeader);
                    }
                    String resolution = BaseAdapter.this.responseHeader.getResolution();
                    int statusCode = BaseAdapter.this.responseHeader.getStatusCode();
                    HMSLog.i(BaseAdapter.TAG, "api is: " + BaseAdapter.this.responseHeader.getApiName() + ", resolution: " + resolution + ", status_code: " + statusCode);
                    resolutionResult(resolution, callBack, value, statusCode);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class MPendingResultImpl extends PendingResultImpl<ResolveResult<CoreBaseResponse>, CoreBaseResponse> {
        public MPendingResultImpl(ApiClient apiClient, String str, IMessageEntity iMessageEntity) {
            super(apiClient, str, iMessageEntity);
        }

        public ResolveResult<CoreBaseResponse> onComplete(CoreBaseResponse coreBaseResponse) {
            ResolveResult<CoreBaseResponse> resolveResult = new ResolveResult<>(coreBaseResponse);
            resolveResult.setStatus(Status.SUCCESS);
            return resolveResult;
        }
    }

    public BaseAdapter(ApiClient apiClient) {
        this.api = new WeakReference<>(apiClient);
        this.appContext = apiClient.getContext().getApplicationContext();
        HMSLog.i(TAG, "In constructor, WeakReference is " + this.api);
    }

    private void biReportRequestEntryIpc(Context context, RequestHeader requestHeader2) {
        Map<String, String> mapFromRequestHeader = HiAnalyticsUtil.getInstance().getMapFromRequestHeader(requestHeader2);
        mapFromRequestHeader.put("direction", "req");
        mapFromRequestHeader.put("version", HiAnalyticsUtil.versionCodeToName(String.valueOf(requestHeader2.getKitSdkVersion())));
        mapFromRequestHeader.put(HiAnalyticsConstant.HaKey.BI_KEY_PHONETYPE, Util.getSystemProperties("ro.logsystem.usertype", ""));
        HiAnalyticsUtil.getInstance().onNewEvent(context, HiAnalyticsConstant.HMS_SDK_BASE_CALL_AIDL, mapFromRequestHeader);
    }

    private void biReportRequestEntrySolution(Context context, RequestHeader requestHeader2) {
        Map<String, String> mapFromRequestHeader = HiAnalyticsUtil.getInstance().getMapFromRequestHeader(requestHeader2);
        mapFromRequestHeader.put("direction", "req");
        mapFromRequestHeader.put("version", HiAnalyticsUtil.versionCodeToName(String.valueOf(requestHeader2.getKitSdkVersion())));
        mapFromRequestHeader.put(HiAnalyticsConstant.HaKey.BI_KEY_PHONETYPE, Util.getSystemProperties("ro.logsystem.usertype", ""));
        HiAnalyticsUtil.getInstance().onNewEvent(context, HiAnalyticsConstant.HMS_SDK_BASE_START_RESOLUTION, mapFromRequestHeader);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void biReportRequestReturnIpc(Context context, ResponseHeader responseHeader2) {
        HiAnalyticsUtil.getInstance();
        Map<String, String> mapFromRequestHeader = HiAnalyticsUtil.getMapFromRequestHeader(responseHeader2);
        mapFromRequestHeader.put("direction", HiAnalyticsConstant.Direction.RESPONSE);
        mapFromRequestHeader.put("version", HiAnalyticsUtil.versionCodeToName(String.valueOf(this.requestHeader.getKitSdkVersion())));
        mapFromRequestHeader.put(HiAnalyticsConstant.HaKey.BI_KEY_PHONETYPE, Util.getSystemProperties("ro.logsystem.usertype", ""));
        HiAnalyticsUtil.getInstance().onNewEvent(context, HiAnalyticsConstant.HMS_SDK_BASE_CALL_AIDL, mapFromRequestHeader);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void biReportRequestReturnSolution(Context context, ResponseHeader responseHeader2, long j) {
        HiAnalyticsUtil.getInstance();
        Map<String, String> mapFromRequestHeader = HiAnalyticsUtil.getMapFromRequestHeader(responseHeader2);
        mapFromRequestHeader.put("direction", HiAnalyticsConstant.Direction.RESPONSE);
        mapFromRequestHeader.put(HiAnalyticsConstant.HaKey.BI_KEY_WAITTIME, String.valueOf(j));
        mapFromRequestHeader.put("version", HiAnalyticsUtil.versionCodeToName(String.valueOf(this.requestHeader.getKitSdkVersion())));
        mapFromRequestHeader.put(HiAnalyticsConstant.HaKey.BI_KEY_PHONETYPE, Util.getSystemProperties("ro.logsystem.usertype", ""));
        HiAnalyticsUtil.getInstance().onNewEvent(context, HiAnalyticsConstant.HMS_SDK_BASE_START_RESOLUTION, mapFromRequestHeader);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private String buildBodyStr(int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("errorCode", i);
        } catch (JSONException e) {
            HMSLog.e(TAG, "buildBodyStr failed: " + e.getMessage());
        }
        return jSONObject.toString();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private ResponseWrap buildResponseWrap(int i, String str) {
        setResponseHeader(i);
        ResponseWrap responseWrap = new ResponseWrap(this.responseHeader);
        responseWrap.setBody(str);
        return responseWrap;
    }

    private BaseCallBack getBaseCallBackReplay() {
        return this.baseCallBackReplay;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private BaseCallBack getCallBack() {
        BaseCallBack baseCallBack = this.callback;
        if (baseCallBack != null) {
            return baseCallBack;
        }
        HMSLog.e(TAG, "callback null");
        return null;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private Activity getCpActivity() {
        if (this.activityWeakReference == null) {
            HMSLog.i(TAG, "activityWeakReference is " + this.activityWeakReference);
            return null;
        }
        ApiClient apiClient = this.api.get();
        if (apiClient == null) {
            HMSLog.i(TAG, "tmpApi is null");
            return null;
        }
        HMSLog.i(TAG, "activityWeakReference has " + this.activityWeakReference.get());
        return Util.getActiveActivity(this.activityWeakReference.get(), apiClient.getContext());
    }

    private String getJsonHeaderReplay() {
        return this.jsonHeaderReplay;
    }

    private String getJsonObjectReplay() {
        return this.jsonObjectReplay;
    }

    private Parcelable getParcelableReplay() {
        return this.parcelableReplay;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private String getResponseHeaderForError(int i) {
        setResponseHeader(i);
        return this.responseHeader.toJson();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private boolean hasExtraPrivacyResult(Intent intent, BaseCallBack baseCallBack) {
        if (!intent.hasExtra(CommonCode.MapKey.PRIVACY_STATEMENT_CONFIRM_RESULT)) {
            return false;
        }
        if (intent.getIntExtra(CommonCode.MapKey.PRIVACY_STATEMENT_CONFIRM_RESULT, 1001) == 1001) {
            HMSLog.i(TAG, "privacy_statement_confirm_result agreed, replay request");
            replayRequest();
            return true;
        }
        HMSLog.i(TAG, "privacy_statement_confirm_result rejected");
        baseCallBack.onError(buildResponseWrap(CommonCode.BusInterceptor.PRIVACY_CNCEL_ERROR_CODE, buildBodyStr(CommonCode.BusInterceptor.PRIVACY_CNCEL_ERROR_CODE)).toJson());
        return true;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private boolean hasExtraUpdateResult(Intent intent, BaseCallBack baseCallBack) {
        if (!intent.hasExtra(KpmsConstant.KIT_UPDATE_RESULT)) {
            return false;
        }
        int intExtra = intent.getIntExtra(KpmsConstant.KIT_UPDATE_RESULT, 0);
        HMSLog.i(TAG, "kit_update_result is " + intExtra);
        if (intExtra == 1) {
            HMSLog.e(TAG, "kit update success,replay request");
            replayRequest();
        } else {
            HMSLog.e(TAG, "kit update failed");
            baseCallBack.onError(buildResponseWrap(-10, buildBodyStr(intExtra)).toJson());
        }
        return true;
    }

    private void initObserver() {
        this.observer = new SystemObserver() {
            /* class com.huawei.hms.adapter.BaseAdapter.AnonymousClass1 */

            @Override // com.huawei.hms.adapter.sysobs.SystemObserver
            public boolean onNoticeResult(int i) {
                return false;
            }

            @Override // com.huawei.hms.adapter.sysobs.SystemObserver
            public boolean onSolutionResult(Intent intent, String str) {
                if (TextUtils.isEmpty(str)) {
                    HMSLog.e(BaseAdapter.TAG, "onSolutionResult but id is null");
                    BaseCallBack callBack = BaseAdapter.this.getCallBack();
                    if (callBack == null) {
                        HMSLog.e(BaseAdapter.TAG, "onSolutionResult baseCallBack null");
                        return true;
                    }
                    callBack.onError(BaseAdapter.this.getResponseHeaderForError(-6));
                    return true;
                } else if (!str.equals(BaseAdapter.this.transactionId)) {
                    return false;
                } else {
                    HMSLog.i(BaseAdapter.TAG, "onSolutionResult + id is :" + str);
                    BaseCallBack callBack2 = BaseAdapter.this.getCallBack();
                    if (callBack2 == null) {
                        HMSLog.e(BaseAdapter.TAG, "onResult baseCallBack null");
                        return true;
                    } else if (intent == null) {
                        HMSLog.e(BaseAdapter.TAG, "onSolutionResult but data is null");
                        String responseHeaderForError = BaseAdapter.this.getResponseHeaderForError(-7);
                        BaseAdapter baseAdapter = BaseAdapter.this;
                        baseAdapter.biReportRequestReturnSolution(baseAdapter.appContext, BaseAdapter.this.responseHeader, 0);
                        callBack2.onError(responseHeaderForError);
                        return true;
                    } else if (BaseAdapter.this.hasExtraUpdateResult(intent, callBack2) || BaseAdapter.this.hasExtraPrivacyResult(intent, callBack2)) {
                        return true;
                    } else {
                        HMSLog.e(BaseAdapter.TAG, "onComplete for on activity result");
                        BaseAdapter.this.onCompleteResult(intent, callBack2);
                        return true;
                    }
                }
            }

            @Override // com.huawei.hms.adapter.sysobs.SystemObserver
            public boolean onUpdateResult(int i) {
                return false;
            }
        };
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void onCompleteResult(Intent intent, BaseCallBack baseCallBack) {
        long j;
        String stringExtra = intent.getStringExtra(CommonCode.MapKey.JSON_HEADER);
        String stringExtra2 = intent.getStringExtra(CommonCode.MapKey.JSON_BODY);
        Object infoFromJsonobject = JsonUtil.getInfoFromJsonobject(stringExtra, "status_code");
        Object infoFromJsonobject2 = JsonUtil.getInfoFromJsonobject(stringExtra, "error_code");
        if (intent.hasExtra(CommonCode.MapKey.HMS_FOREGROUND_RES_UI)) {
            Object infoFromJsonobject3 = JsonUtil.getInfoFromJsonobject(intent.getStringExtra(CommonCode.MapKey.HMS_FOREGROUND_RES_UI), "uiDuration");
            if (infoFromJsonobject3 instanceof Long) {
                j = ((Long) infoFromJsonobject3).longValue();
                if ((infoFromJsonobject instanceof Integer) || !(infoFromJsonobject2 instanceof Integer)) {
                    getResponseHeaderForError(-8);
                    biReportRequestReturnSolution(this.appContext, this.responseHeader, j);
                } else {
                    int intValue = ((Integer) infoFromJsonobject).intValue();
                    getResponseHeaderForError(((Integer) infoFromJsonobject2).intValue());
                    this.responseHeader.setStatusCode(intValue);
                    biReportRequestReturnSolution(this.appContext, this.responseHeader, j);
                }
                baseCallBack.onComplete(stringExtra, stringExtra2, null);
            }
        }
        j = 0;
        if (infoFromJsonobject instanceof Integer) {
        }
        getResponseHeaderForError(-8);
        biReportRequestReturnSolution(this.appContext, this.responseHeader, j);
        baseCallBack.onComplete(stringExtra, stringExtra2, null);
    }

    private void replayRequest() {
        if (this.jsonHeaderReplay != null && this.baseCallBackReplay != null) {
            this.responseHeader = null;
            this.responseHeader = new ResponseHeader();
            baseRequest(getJsonHeaderReplay(), getJsonObjectReplay(), getParcelableReplay(), getBaseCallBackReplay());
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void sendBroadcastAfterResolutionHms() {
        if (this.appContext == null) {
            HMSLog.e(TAG, "sendBroadcastAfterResolutionHms, context is null");
            return;
        }
        Intent intent = new Intent(HMS_SESSION_INVALID);
        intent.setPackage(this.appContext.getPackageName());
        this.appContext.sendBroadcast(intent);
    }

    private void setBaseCallBackReplay(BaseCallBack baseCallBack) {
        this.baseCallBackReplay = baseCallBack;
    }

    private void setJsonHeaderReplay(String str) {
        this.jsonHeaderReplay = str;
    }

    private void setJsonObjectReplay(String str) {
        this.jsonObjectReplay = str;
    }

    private void setParcelableReplay(Parcelable parcelable) {
        this.parcelableReplay = parcelable;
    }

    private void setReplayData(String str, String str2, Parcelable parcelable, BaseCallBack baseCallBack) {
        setJsonHeaderReplay(str);
        setJsonObjectReplay(str2);
        setParcelableReplay(parcelable);
        setBaseCallBackReplay(baseCallBack);
    }

    private void setResponseHeader(int i) {
        this.responseHeader.setTransactionId(this.requestHeader.getTransactionId());
        this.responseHeader.setAppID(this.requestHeader.getAppID());
        this.responseHeader.setApiName(this.requestHeader.getApiName());
        this.responseHeader.setSrvName(this.requestHeader.getSrvName());
        this.responseHeader.setPkgName(this.requestHeader.getPkgName());
        this.responseHeader.setStatusCode(1);
        this.responseHeader.setErrorCode(i);
        this.responseHeader.setErrorReason("Core error");
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void startResolution(Activity activity, Parcelable parcelable) {
        HMSLog.i(TAG, "startResolution");
        RequestHeader requestHeader2 = this.requestHeader;
        if (requestHeader2 != null) {
            biReportRequestEntrySolution(this.appContext, requestHeader2);
        }
        if (this.observer == null) {
            initObserver();
        }
        SystemManager.getSystemNotifier().registerObserver(this.observer);
        Intent intentStartBridgeActivity = BridgeActivity.getIntentStartBridgeActivity(activity, BaseResolutionAdapter.class.getName());
        Bundle bundle = new Bundle();
        bundle.putParcelable(CommonCode.MapKey.HAS_RESOLUTION, parcelable);
        intentStartBridgeActivity.putExtras(bundle);
        intentStartBridgeActivity.putExtra(CommonCode.MapKey.TRANSACTION_ID, this.transactionId);
        activity.startActivity(intentStartBridgeActivity);
    }

    public void baseRequest(String str, String str2, Parcelable parcelable, BaseCallBack baseCallBack) {
        setReplayData(str, str2, parcelable, baseCallBack);
        if (this.api == null) {
            HMSLog.e(TAG, "client is null");
            baseCallBack.onError(getResponseHeaderForError(-2));
            return;
        }
        this.callback = baseCallBack;
        JsonUtil.jsonToEntity(str, this.requestHeader);
        CoreBaseRequest coreBaseRequest = new CoreBaseRequest();
        coreBaseRequest.setJsonObject(str2);
        coreBaseRequest.setJsonHeader(str);
        coreBaseRequest.setParcelable(parcelable);
        String apiName = this.requestHeader.getApiName();
        if (TextUtils.isEmpty(apiName)) {
            HMSLog.e(TAG, "get uri null");
            baseCallBack.onError(getResponseHeaderForError(-5));
            return;
        }
        String transactionId2 = this.requestHeader.getTransactionId();
        this.transactionId = transactionId2;
        if (TextUtils.isEmpty(transactionId2)) {
            HMSLog.e(TAG, "get transactionId null");
            baseCallBack.onError(getResponseHeaderForError(-6));
            return;
        }
        HMSLog.i(TAG, "in baseRequest + uri is :" + apiName + ", transactionId is : " + this.transactionId);
        biReportRequestEntryIpc(this.appContext, this.requestHeader);
        baseRequest(this.api.get(), apiName, coreBaseRequest).setResultCallback(new BaseRequestResultCallback());
    }

    public BaseAdapter(ApiClient apiClient, Activity activity) {
        this.api = new WeakReference<>(apiClient);
        this.activityWeakReference = new WeakReference<>(activity);
        this.appContext = activity.getApplicationContext();
        HMSLog.i(TAG, "In constructor, activityWeakReference is " + this.activityWeakReference + ", activity is " + this.activityWeakReference.get());
    }

    private PendingResult<ResolveResult<CoreBaseResponse>> baseRequest(ApiClient apiClient, String str, CoreBaseRequest coreBaseRequest) {
        return new MPendingResultImpl(apiClient, str, coreBaseRequest);
    }
}
