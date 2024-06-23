package com.taobao.tao.remotebusiness;

import android.content.Context;
import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.taobao.tao.remotebusiness.listener.MtopListenerProxyFactory;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import mtopsdk.common.util.MtopUtils;
import mtopsdk.common.util.StringUtils;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.common.ApiID;
import mtopsdk.mtop.common.MtopListener;
import mtopsdk.mtop.common.MtopNetworkProp;
import mtopsdk.mtop.domain.ApiTypeEnum;
import mtopsdk.mtop.domain.BaseOutDo;
import mtopsdk.mtop.domain.IMTOPDataObject;
import mtopsdk.mtop.domain.JsonTypeEnum;
import mtopsdk.mtop.domain.MethodEnum;
import mtopsdk.mtop.domain.MtopRequest;
import mtopsdk.mtop.domain.MtopResponse;
import mtopsdk.mtop.domain.ProtocolEnum;
import mtopsdk.mtop.intf.Mtop;
import mtopsdk.mtop.intf.MtopBuilder;
import mtopsdk.mtop.intf.MtopPrefetch;
import mtopsdk.mtop.stat.IMtopMonitor;
import mtopsdk.mtop.stat.MtopMonitor;
import mtopsdk.mtop.util.MtopStatistics;
import org.apache.commons.lang3.time.DateUtils;
import tb.jl1;

/* compiled from: Taobao */
public class MtopBusiness extends MtopBuilder {
    public static final int MAX_RETRY_TIMES = 3;
    private static final String TAG = "mtopsdk.MtopBusiness";
    private static AtomicInteger seqGen = new AtomicInteger(0);
    private ApiID apiID;
    public String authParam = null;
    public Class<?> clazz;
    public boolean isCached = false;
    private boolean isCancelled = false;
    private boolean isErrorNotifyAfterCache = false;
    public MtopListener listener;
    private MtopResponse mtopResponse = null;
    private boolean needAuth = false;
    public long onBgFinishTime = 0;
    public long reqStartTime = 0;
    @Deprecated
    public Object requestContext = null;
    protected int requestType = 0;
    protected int retryTime = 0;
    public long sendStartTime = 0;
    private final String seqNo = genSeqNo();
    public boolean showAuthUI = true;
    private boolean showLoginUI = true;
    private boolean syncRequestFlag = false;

    protected MtopBusiness(@NonNull Mtop mtop, IMTOPDataObject iMTOPDataObject, String str) {
        super(mtop, iMTOPDataObject, str);
    }

    public static MtopBusiness build(Mtop mtop, IMTOPDataObject iMTOPDataObject, String str) {
        return new MtopBusiness(mtop, iMTOPDataObject, str);
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x009d A[Catch:{ all -> 0x00ba }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00ca  */
    /* JADX WARNING: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
    private void doErrorCallback(MtopResponse mtopResponse2, IRemoteListener iRemoteListener) {
        boolean z = true;
        if (mtopResponse2 == null) {
            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.ErrorEnable)) {
                String str = this.seqNo;
                TBSdkLog.i(TAG, str, "mtopResponse is null." + this.request);
            }
        } else if (mtopResponse2.isSessionInvalid()) {
            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                String str2 = this.seqNo;
                TBSdkLog.i(TAG, str2, "session invalid error." + this.request);
            }
        } else if (!mtopResponse2.isMtopServerError() && !mtopResponse2.isMtopSdkError()) {
            z = false;
        } else if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
            String str3 = this.seqNo;
            TBSdkLog.i(TAG, str3, "mtopServerError or mtopSdkError." + this.request);
        }
        if (z) {
            try {
                if (iRemoteListener instanceof IRemoteBaseListener) {
                    ((IRemoteBaseListener) iRemoteListener).onSystemError(this.requestType, mtopResponse2, getReqContext());
                    if (MtopMonitor.getInstance() != null) {
                        HashMap<String, String> hashMap = new HashMap<>();
                        hashMap.put(IMtopMonitor.DATA_RESPONSE, mtopResponse2 != null ? mtopResponse2.getApi() : "response null");
                        MtopMonitor.getInstance().onCommit(IMtopMonitor.MtopMonitorType.TYPE_ERROR_CALLBACK, hashMap);
                    }
                    if (!TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                        String str4 = this.seqNo;
                        StringBuilder sb = new StringBuilder();
                        sb.append("listener onError callback, ");
                        sb.append(z ? "sys error" : "biz error");
                        TBSdkLog.i(TAG, str4, sb.toString());
                        return;
                    }
                    return;
                }
            } catch (Throwable th) {
                TBSdkLog.e(TAG, this.seqNo, "listener onError callback error", th);
            }
        }
        iRemoteListener.onError(this.requestType, mtopResponse2, getReqContext());
        if (MtopMonitor.getInstance() != null) {
        }
        if (!TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
        }
    }

    private String genSeqNo() {
        StringBuilder sb = new StringBuilder(16);
        sb.append("MB");
        sb.append(seqGen.incrementAndGet());
        sb.append('.');
        sb.append(this.stat.seqNo);
        return sb.toString();
    }

    private String getRequestLogInfo(String str, MtopBusiness mtopBusiness) {
        StringBuilder sb = new StringBuilder(32);
        sb.append(str);
        sb.append(" [");
        if (mtopBusiness != null) {
            sb.append("apiName=");
            sb.append(mtopBusiness.request.getApiName());
            sb.append(";version=");
            sb.append(mtopBusiness.request.getVersion());
            sb.append(";requestType=");
            sb.append(mtopBusiness.getRequestType());
        }
        sb.append(jl1.ARRAY_END_STR);
        return sb.toString();
    }

    @Override // mtopsdk.mtop.intf.MtopBuilder
    @Deprecated
    public ApiID asyncRequest() {
        startRequest();
        return this.apiID;
    }

    public void cancelRequest() {
        if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
            TBSdkLog.i(TAG, this.seqNo, getRequestLogInfo("cancelRequest.", this));
        }
        this.isCancelled = true;
        ApiID apiID2 = this.apiID;
        if (apiID2 != null) {
            try {
                apiID2.cancelApiCall();
            } catch (Throwable th) {
                TBSdkLog.w(TAG, this.seqNo, getRequestLogInfo("cancelRequest failed.", this), th);
            }
        }
    }

    public void doFinish(MtopResponse mtopResponse2, BaseOutDo baseOutDo) {
        if (this.syncRequestFlag) {
            this.mtopResponse = mtopResponse2;
            synchronized (this.listener) {
                try {
                    this.listener.notify();
                } catch (Exception e) {
                    String str = this.seqNo;
                    StringBuilder sb = new StringBuilder();
                    sb.append("[doFinish]syncRequest do notify Exception. apiKey=");
                    sb.append(mtopResponse2 != null ? mtopResponse2.getFullKey() : "");
                    TBSdkLog.e(TAG, str, sb.toString(), e);
                }
            }
        }
        if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
            StringBuilder sb2 = new StringBuilder(32);
            sb2.append("doFinish request=");
            sb2.append(this.request);
            if (mtopResponse2 != null) {
                sb2.append(", retCode=");
                sb2.append(mtopResponse2.getRetCode());
            }
            TBSdkLog.i(TAG, this.seqNo, sb2.toString());
        }
        if (this.isCancelled) {
            TBSdkLog.w(TAG, this.seqNo, "request is cancelled,don't callback listener.");
            return;
        }
        MtopListener mtopListener = this.listener;
        if (!(mtopListener instanceof IRemoteListener)) {
            String str2 = this.seqNo;
            StringBuilder sb3 = new StringBuilder();
            sb3.append("listener did't implement IRemoteBaseListener.apiKey=");
            sb3.append(mtopResponse2 != null ? mtopResponse2.getFullKey() : "");
            TBSdkLog.e(TAG, str2, sb3.toString());
            return;
        }
        IRemoteListener iRemoteListener = (IRemoteListener) mtopListener;
        if (mtopResponse2 != null && mtopResponse2.isApiSuccess()) {
            long currentTimeMillis = this.stat.currentTimeMillis();
            MtopStatistics mtopStatistics = this.stat;
            mtopStatistics.callbackPocTime = currentTimeMillis - mtopStatistics.netSendEndTime;
            mtopStatistics.allTime = currentTimeMillis - mtopStatistics.startTime;
            mtopStatistics.handler = this.mtopContext.property.handler != null;
            try {
                iRemoteListener.onSuccess(this.requestType, mtopResponse2, baseOutDo, getReqContext());
                if (MtopMonitor.getInstance() != null) {
                    HashMap<String, String> hashMap = new HashMap<>();
                    hashMap.put(IMtopMonitor.DATA_RESPONSE, mtopResponse2.getApi());
                    MtopMonitor.getInstance().onCommit(IMtopMonitor.MtopMonitorType.TYPE_CALLBACK, hashMap);
                }
            } catch (Throwable th) {
                TBSdkLog.e(TAG, this.seqNo, "listener onSuccess callback error", th);
            }
            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                TBSdkLog.i(TAG, this.seqNo, "listener onSuccess callback.");
            }
        } else if (!this.isCached || this.isErrorNotifyAfterCache) {
            doErrorCallback(mtopResponse2, iRemoteListener);
        } else {
            TBSdkLog.i(TAG, this.seqNo, "listener onCached callback,doNothing in doFinish()");
        }
    }

    public int getRequestType() {
        return this.requestType;
    }

    public int getRetryTime() {
        return this.retryTime;
    }

    public String getSeqNo() {
        return this.seqNo;
    }

    public boolean isNeedAuth() {
        return this.needAuth || this.authParam != null;
    }

    public boolean isShowLoginUI() {
        return this.showLoginUI;
    }

    public boolean isTaskCanceled() {
        return this.isCancelled;
    }

    @Deprecated
    public MtopBusiness registerListener(MtopListener mtopListener) {
        this.listener = mtopListener;
        return this;
    }

    /* access modifiers changed from: package-private */
    public void retryRequest() {
        if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
            TBSdkLog.i(TAG, this.seqNo, getRequestLogInfo("retryRequest.", this));
        }
        if (this.retryTime >= 3) {
            this.retryTime = 0;
            doFinish(this.mtopContext.mtopResponse, null);
            return;
        }
        cancelRequest();
        startRequest(this.requestType, this.clazz);
        this.retryTime++;
    }

    public MtopBusiness setErrorNotifyAfterCache(boolean z) {
        this.isErrorNotifyAfterCache = z;
        return this;
    }

    @Deprecated
    public void setErrorNotifyNeedAfterCache(boolean z) {
        setErrorNotifyAfterCache(z);
    }

    public MtopBusiness setNeedAuth(String str, boolean z) {
        this.authParam = str;
        this.showAuthUI = z;
        this.needAuth = true;
        if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.DebugEnable)) {
            StringBuilder sb = new StringBuilder(64);
            sb.append("[setNeedAuth] authParam=");
            sb.append(str);
            sb.append(", showAuthUI=");
            sb.append(z);
            sb.append(", needAuth=");
            sb.append(this.needAuth);
            TBSdkLog.d(TAG, this.seqNo, sb.toString());
        }
        return this;
    }

    public MtopBusiness setPriorityData(Map<String, String> map) {
        this.mtopProp.priorityData = map;
        return this;
    }

    public MtopBusiness setPriorityFlag(boolean z) {
        this.mtopProp.priorityFlag = z;
        return this;
    }

    public MtopBusiness showLoginUI(boolean z) {
        this.showLoginUI = z;
        return this;
    }

    public void startRequest() {
        startRequest(0, null);
    }

    @Override // mtopsdk.mtop.intf.MtopBuilder
    public MtopResponse syncRequest() {
        MtopRequest mtopRequest = this.request;
        String key = mtopRequest != null ? mtopRequest.getKey() : "";
        if (MtopUtils.isMainThread()) {
            TBSdkLog.e(TAG, this.seqNo, "do syncRequest in UI main thread!");
        }
        this.syncRequestFlag = true;
        if (this.listener == null) {
            this.listener = new IRemoteBaseListener() {
                /* class com.taobao.tao.remotebusiness.MtopBusiness.AnonymousClass1 */

                @Override // com.taobao.tao.remotebusiness.IRemoteListener
                public void onError(int i, MtopResponse mtopResponse, Object obj) {
                }

                @Override // com.taobao.tao.remotebusiness.IRemoteListener
                public void onSuccess(int i, MtopResponse mtopResponse, BaseOutDo baseOutDo, Object obj) {
                }

                @Override // com.taobao.tao.remotebusiness.IRemoteBaseListener
                public void onSystemError(int i, MtopResponse mtopResponse, Object obj) {
                }
            };
        }
        startRequest();
        synchronized (this.listener) {
            try {
                if (this.mtopResponse == null) {
                    this.listener.wait(DateUtils.MILLIS_PER_MINUTE);
                }
            } catch (InterruptedException unused) {
                String str = this.seqNo;
                TBSdkLog.e(TAG, str, "syncRequest InterruptedException. apiKey=" + key);
            } catch (Exception unused2) {
                String str2 = this.seqNo;
                TBSdkLog.e(TAG, str2, "syncRequest do wait Exception. apiKey=" + key);
            }
        }
        if (this.mtopResponse == null) {
            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.ErrorEnable)) {
                String str3 = this.seqNo;
                TBSdkLog.w(TAG, str3, "syncRequest timeout. apiKey=" + key);
            }
            cancelRequest();
        }
        MtopResponse mtopResponse2 = this.mtopResponse;
        return mtopResponse2 != null ? mtopResponse2 : handleAsyncTimeoutException();
    }

    public static MtopBusiness build(Mtop mtop, IMTOPDataObject iMTOPDataObject) {
        return build(mtop, iMTOPDataObject, (String) null);
    }

    @Override // mtopsdk.mtop.intf.MtopBuilder
    public MtopBusiness addCacheKeyParamBlackList(List<String> list) {
        return (MtopBusiness) super.addCacheKeyParamBlackList(list);
    }

    @Override // mtopsdk.mtop.intf.MtopBuilder
    public MtopBusiness addHttpQueryParameter(String str, String str2) {
        return (MtopBusiness) super.addHttpQueryParameter(str, str2);
    }

    @Override // mtopsdk.mtop.intf.MtopBuilder
    @Deprecated
    public MtopBusiness addListener(MtopListener mtopListener) {
        this.listener = mtopListener;
        return this;
    }

    @Override // mtopsdk.mtop.intf.MtopBuilder
    public MtopBusiness addMteeUa(String str) {
        return (MtopBusiness) super.addMteeUa(str);
    }

    @Override // mtopsdk.mtop.intf.MtopBuilder
    public MtopBusiness addOpenApiParams(String str, String str2) {
        return (MtopBusiness) super.addOpenApiParams(str, str2);
    }

    @Override // mtopsdk.mtop.intf.MtopBuilder
    public MtopBusiness enableProgressListener() {
        return (MtopBusiness) super.enableProgressListener();
    }

    @Override // mtopsdk.mtop.intf.MtopBuilder
    public MtopBusiness forceRefreshCache() {
        return (MtopBusiness) super.forceRefreshCache();
    }

    @Override // mtopsdk.mtop.intf.MtopBuilder
    public MtopBusiness handler(Handler handler) {
        return (MtopBusiness) super.handler(handler);
    }

    @Override // mtopsdk.mtop.intf.MtopBuilder
    public MtopBusiness headers(Map<String, String> map) {
        return (MtopBusiness) super.headers(map);
    }

    @Override // mtopsdk.mtop.intf.MtopBuilder
    public MtopBusiness prefetchComparator(MtopPrefetch.IPrefetchComparator iPrefetchComparator) {
        return (MtopBusiness) super.prefetchComparator(iPrefetchComparator);
    }

    @Override // mtopsdk.mtop.intf.MtopBuilder
    public MtopBusiness protocol(ProtocolEnum protocolEnum) {
        return (MtopBusiness) super.protocol(protocolEnum);
    }

    public MtopBusiness registerListener(IRemoteListener iRemoteListener) {
        this.listener = iRemoteListener;
        return this;
    }

    @Override // mtopsdk.mtop.intf.MtopBuilder
    public MtopBusiness reqContext(Object obj) {
        return (MtopBusiness) super.reqContext(obj);
    }

    @Override // mtopsdk.mtop.intf.MtopBuilder
    public MtopBusiness reqMethod(MethodEnum methodEnum) {
        return (MtopBusiness) super.reqMethod(methodEnum);
    }

    @Override // mtopsdk.mtop.intf.MtopBuilder
    public MtopBusiness retryTime(int i) {
        return (MtopBusiness) super.retryTime(i);
    }

    @Override // mtopsdk.mtop.intf.MtopBuilder
    public MtopBusiness setCacheControlNoCache() {
        return (MtopBusiness) super.setCacheControlNoCache();
    }

    @Override // mtopsdk.mtop.intf.MtopBuilder
    public MtopBusiness setConnectionTimeoutMilliSecond(int i) {
        return (MtopBusiness) super.setConnectionTimeoutMilliSecond(i);
    }

    @Override // mtopsdk.mtop.intf.MtopBuilder
    public MtopBusiness setJsonType(JsonTypeEnum jsonTypeEnum) {
        return (MtopBusiness) super.setJsonType(jsonTypeEnum);
    }

    @Override // mtopsdk.mtop.intf.MtopBuilder
    public MtopBusiness setNetInfo(int i) {
        return (MtopBusiness) super.setNetInfo(i);
    }

    @Override // mtopsdk.mtop.intf.MtopBuilder
    public MtopBusiness setPageName(String str) {
        return (MtopBusiness) super.setPageName(str);
    }

    @Override // mtopsdk.mtop.intf.MtopBuilder
    public MtopBusiness setPageUrl(String str) {
        return (MtopBusiness) super.setPageUrl(str);
    }

    @Override // mtopsdk.mtop.intf.MtopBuilder
    public MtopBusiness setReqAppKey(String str, String str2) {
        return (MtopBusiness) super.setReqAppKey(str, str2);
    }

    @Override // mtopsdk.mtop.intf.MtopBuilder
    public MtopBusiness setReqBizExt(String str) {
        return (MtopBusiness) super.setReqBizExt(str);
    }

    @Override // mtopsdk.mtop.intf.MtopBuilder
    public MtopBusiness setReqSource(int i) {
        return (MtopBusiness) super.setReqSource(i);
    }

    @Override // mtopsdk.mtop.intf.MtopBuilder
    public MtopBusiness setReqUserId(String str) {
        return (MtopBusiness) super.setReqUserId(str);
    }

    @Override // mtopsdk.mtop.intf.MtopBuilder
    public MtopBusiness setSocketTimeoutMilliSecond(int i) {
        return (MtopBusiness) super.setSocketTimeoutMilliSecond(i);
    }

    @Override // mtopsdk.mtop.intf.MtopBuilder
    public MtopBusiness setUnitStrategy(String str) {
        return (MtopBusiness) super.setUnitStrategy(str);
    }

    @Override // mtopsdk.mtop.intf.MtopBuilder
    public MtopBusiness setUserInfo(@Nullable String str) {
        return (MtopBusiness) super.setUserInfo(str);
    }

    public void startRequest(Class<?> cls) {
        startRequest(0, cls);
    }

    @Override // mtopsdk.mtop.intf.MtopBuilder
    public MtopBusiness ttid(String str) {
        return (MtopBusiness) super.ttid(str);
    }

    @Override // mtopsdk.mtop.intf.MtopBuilder
    public MtopBusiness useCache() {
        return (MtopBusiness) super.useCache();
    }

    @Deprecated
    public static MtopBusiness build(IMTOPDataObject iMTOPDataObject, String str) {
        return build(Mtop.instance((Context) null, str), iMTOPDataObject, str);
    }

    @Override // mtopsdk.mtop.intf.MtopBuilder
    @Deprecated
    public MtopBusiness setBizId(int i) {
        return (MtopBusiness) super.setBizId(i);
    }

    @Override // mtopsdk.mtop.intf.MtopBuilder
    public MtopBusiness setCustomDomain(String str) {
        return (MtopBusiness) super.setCustomDomain(str);
    }

    public void startRequest(int i, Class<?> cls) {
        if (this.request == null) {
            TBSdkLog.e(TAG, this.seqNo, "MtopRequest is null!");
            return;
        }
        if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
            String str = this.seqNo;
            TBSdkLog.i(TAG, str, "startRequest " + this.request);
        }
        this.reqStartTime = System.currentTimeMillis();
        this.isCancelled = false;
        this.isCached = false;
        this.clazz = cls;
        this.requestType = i;
        Object obj = this.requestContext;
        if (obj != null) {
            reqContext(obj);
        }
        MtopListener mtopListener = this.listener;
        if (mtopListener != null && !this.isCancelled) {
            super.addListener(MtopListenerProxyFactory.getMtopListenerProxy(this, mtopListener));
        }
        mtopCommitStatData(false);
        this.sendStartTime = System.currentTimeMillis();
        this.apiID = super.asyncRequest();
    }

    @Override // mtopsdk.mtop.intf.MtopBuilder
    public MtopBusiness useWua() {
        return (MtopBusiness) super.useWua();
    }

    @Deprecated
    public static MtopBusiness build(IMTOPDataObject iMTOPDataObject) {
        return build(Mtop.instance(null), iMTOPDataObject);
    }

    @Override // mtopsdk.mtop.intf.MtopBuilder
    public MtopBusiness prefetch(long j, List<String> list, MtopPrefetch.IPrefetchCallback iPrefetchCallback) {
        return (MtopBusiness) super.prefetch(j, list, iPrefetchCallback);
    }

    @Override // mtopsdk.mtop.intf.MtopBuilder
    public MtopBusiness setBizId(String str) {
        return (MtopBusiness) super.setBizId(str);
    }

    @Override // mtopsdk.mtop.intf.MtopBuilder
    public MtopBusiness setCustomDomain(String str, String str2, String str3) {
        return (MtopBusiness) super.setCustomDomain(str, str2, str3);
    }

    @Override // mtopsdk.mtop.intf.MtopBuilder
    @Deprecated
    public MtopBusiness useWua(int i) {
        return (MtopBusiness) super.useWua(i);
    }

    public static MtopBusiness build(Mtop mtop, MtopRequest mtopRequest, String str) {
        return new MtopBusiness(mtop, mtopRequest, str);
    }

    @Override // mtopsdk.mtop.intf.MtopBuilder
    public MtopBusiness prefetch(long j, MtopPrefetch.IPrefetchCallback iPrefetchCallback) {
        return (MtopBusiness) super.prefetch(j, iPrefetchCallback);
    }

    public static MtopBusiness build(Mtop mtop, MtopRequest mtopRequest) {
        return build(mtop, mtopRequest, (String) null);
    }

    @Override // mtopsdk.mtop.intf.MtopBuilder
    public MtopBusiness prefetch() {
        return (MtopBusiness) super.prefetch(0L, (MtopPrefetch.IPrefetchCallback) null);
    }

    @Deprecated
    public static MtopBusiness build(MtopRequest mtopRequest, String str) {
        return build(Mtop.instance((Context) null, str), mtopRequest, str);
    }

    @Deprecated
    public static MtopBusiness build(MtopRequest mtopRequest) {
        return build(Mtop.instance(null), mtopRequest, (String) null);
    }

    public MtopBusiness setNeedAuth(@NonNull String str, String str2, boolean z) {
        MtopNetworkProp mtopNetworkProp = this.mtopProp;
        mtopNetworkProp.apiType = ApiTypeEnum.ISV_OPEN_API;
        mtopNetworkProp.isInnerOpen = true;
        if (StringUtils.isNotBlank(str)) {
            this.mtopProp.openAppKey = str;
        }
        this.authParam = str2;
        this.showAuthUI = z;
        this.needAuth = true;
        if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.DebugEnable)) {
            StringBuilder sb = new StringBuilder(64);
            sb.append("[setNeedAuth] openAppKey=");
            sb.append(str);
            sb.append(", bizParam=");
            sb.append(str2);
            sb.append(", showAuthUI=");
            sb.append(z);
            sb.append(", needAuth=");
            sb.append(this.needAuth);
            sb.append(", isInnerOpen=true");
            TBSdkLog.d(TAG, this.seqNo, sb.toString());
        }
        return this;
    }

    protected MtopBusiness(@NonNull Mtop mtop, MtopRequest mtopRequest, String str) {
        super(mtop, mtopRequest, str);
    }
}
