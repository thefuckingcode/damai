package android.taobao.windvane.extra.uc;

import android.taobao.windvane.monitor.WVMonitorService;
import android.taobao.windvane.util.CommonUtils;
import android.taobao.windvane.util.TaoLog;
import android.text.TextUtils;
import anetwork.channel.Request;
import anetwork.channel.Response;
import com.taobao.tao.util.ImageStrategyDecider;
import com.uc.webview.export.internal.interfaces.EventHandler;
import com.uc.webview.export.internal.interfaces.IRequest;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import mtopsdk.common.util.HttpHeaderConstant;
import tb.e02;
import tb.jl1;

/* compiled from: Taobao */
public class AliRequestAdapter implements IRequest {
    public static final String PHASE_ENDDATA = "enddata";
    private static final String PHASE_NORMAL = "normal";
    public static final String PHASE_RELOAD = "reload";
    public static final String PHASE_STOP = "stop";
    public static int connectTimeout = 10000;
    public static int readTimeout = 10000;
    public static int retryTimes = 1;
    String TAG = "alinetwork";
    private String bizCode;
    public String cancelPhase = "normal";
    Request mAliRequest;
    private final Object mClientResource = new Object();
    private EventHandler mEventHandler;
    Future<Response> mFutureResponse;
    private Map<String, String> mHeaders;
    private boolean mIsUCProxy;
    private boolean mIsUseWebP;
    private int mLoadType;
    private String mMethod = "GET";
    private int mRequestType;
    private Map<String, String> mUCHeaders;
    private Map<String, byte[]> mUploadDataMap;
    private Map<String, String> mUploadFileMap;
    private long mUploadFileTotalLen;
    private String mUrl;

    AliRequestAdapter(Request request, EventHandler eventHandler) {
        this.mEventHandler = eventHandler;
    }

    private Request formatAliRequest() {
        return formatAliRequest(this.mUrl, this.mMethod, this.mIsUCProxy, this.mHeaders, this.mUCHeaders, this.mUploadFileMap, this.mUploadDataMap, this.mUploadFileTotalLen, this.mRequestType, this.mLoadType, this.mIsUseWebP);
    }

    @Override // com.uc.webview.export.internal.interfaces.IRequest
    public void cancel() {
        Future<Response> future;
        if (WVUCWebView.isStop) {
            this.cancelPhase = "stop";
        }
        String str = this.TAG;
        TaoLog.e(str, "cancel id= " + this.mEventHandler.hashCode() + ", phase:[" + this.cancelPhase + jl1.ARRAY_END_STR);
        try {
            if (!(!TaoLog.getLogStatus() || (future = this.mFutureResponse) == null || future.get() == null)) {
                String str2 = this.TAG;
                TaoLog.d(str2, "AliRequestAdapter cancel desc url=" + this.mFutureResponse.get().getDesc());
            }
            complete();
        } catch (InterruptedException e) {
            e.printStackTrace();
            String str3 = this.TAG;
            TaoLog.d(str3, "AliRequestAdapter cancel =" + e.getMessage());
        } catch (ExecutionException e2) {
            e2.printStackTrace();
            String str4 = this.TAG;
            TaoLog.d(str4, "AliRequestAdapter cancel =" + e2.getMessage());
        }
        Future<Response> future2 = this.mFutureResponse;
        if (future2 != null) {
            future2.cancel(true);
        }
    }

    /* access modifiers changed from: package-private */
    public void complete() {
        WVUCWebView.isStop = false;
        if (this.mEventHandler.isSynchronous()) {
            synchronized (this.mClientResource) {
                if (TaoLog.getLogStatus()) {
                    TaoLog.d(this.TAG, "AliRequestAdapter complete will notify");
                }
                this.mClientResource.notifyAll();
            }
        }
    }

    public Request getAliRequest() {
        return this.mAliRequest;
    }

    @Override // com.uc.webview.export.internal.interfaces.IRequest
    public EventHandler getEventHandler() {
        return this.mEventHandler;
    }

    @Override // com.uc.webview.export.internal.interfaces.IRequest
    public Map<String, String> getHeaders() {
        return this.mHeaders;
    }

    @Override // com.uc.webview.export.internal.interfaces.IRequest
    public boolean getIsUCProxy() {
        return this.mIsUCProxy;
    }

    @Override // com.uc.webview.export.internal.interfaces.IRequest
    public int getLoadtype() {
        return this.mLoadType;
    }

    @Override // com.uc.webview.export.internal.interfaces.IRequest
    public String getMethod() {
        return this.mMethod;
    }

    @Override // com.uc.webview.export.internal.interfaces.IRequest
    public int getRequestType() {
        return this.mRequestType;
    }

    @Override // com.uc.webview.export.internal.interfaces.IRequest
    public Map<String, String> getUCHeaders() {
        return this.mUCHeaders;
    }

    @Override // com.uc.webview.export.internal.interfaces.IRequest
    public Map<String, byte[]> getUploadDataMap() {
        return this.mUploadDataMap;
    }

    @Override // com.uc.webview.export.internal.interfaces.IRequest
    public Map<String, String> getUploadFileMap() {
        return this.mUploadFileMap;
    }

    @Override // com.uc.webview.export.internal.interfaces.IRequest
    public long getUploadFileTotalLen() {
        return this.mUploadFileTotalLen;
    }

    @Override // com.uc.webview.export.internal.interfaces.IRequest
    public String getUrl() {
        return this.mUrl;
    }

    @Override // com.uc.webview.export.internal.interfaces.IRequest
    public void handleSslErrorResponse(boolean z) {
    }

    @Override // com.uc.webview.export.internal.interfaces.IRequest
    public void setEventHandler(EventHandler eventHandler) {
        this.mEventHandler = eventHandler;
    }

    public void setFutureResponse(Future<Response> future) {
        this.mFutureResponse = future;
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x003a */
    @Override // com.uc.webview.export.internal.interfaces.IRequest
    public void waitUntilComplete(int i) {
        if (this.mEventHandler.isSynchronous()) {
            synchronized (this.mClientResource) {
                if (TaoLog.getLogStatus()) {
                    String str = this.TAG;
                    TaoLog.d(str, "AliRequestAdapter waitUntilComplete timeout=" + i + ",url=" + this.mUrl);
                }
                this.mClientResource.wait((long) i);
            }
        }
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0032 */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00b8  */
    private Request formatAliRequest(String str, String str2, boolean z, Map<String, String> map, Map<String, String> map2, Map<String, String> map3, Map<String, byte[]> map4, long j, int i, int i2, boolean z2) {
        if (z2) {
            if (CommonUtils.isPicture(str)) {
                String justConvergeAndWebP = ImageStrategyDecider.justConvergeAndWebP(str);
                if (!TextUtils.isEmpty(justConvergeAndWebP) && !justConvergeAndWebP.equals(str)) {
                    String str3 = this.TAG;
                    TaoLog.i(str3, str + " decideUrl to : " + justConvergeAndWebP);
                    str = justConvergeAndWebP;
                }
            }
        }
        try {
            e02 e02 = new e02(str);
            e02.setFollowRedirects(false);
            e02.setBizId(this.bizCode);
            e02.setRetryTime(retryTimes);
            e02.setConnectTimeout(connectTimeout);
            e02.setReadTimeout(readTimeout);
            e02.setCookieEnabled(WVUCWebView.isNeedCookie(str));
            e02.setMethod(str2);
            if (map != null) {
                e02.addHeader(HttpHeaderConstant.F_REFER, "wv_h5");
                UCNetworkDelegate.getInstance().onSendRequest(map, str);
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    String key = entry.getKey();
                    String value = entry.getValue();
                    if (TaoLog.getLogStatus()) {
                        String str4 = this.TAG;
                        TaoLog.d(str4, "AliRequestAdapter from uc header key=" + key + ",value=" + value);
                    }
                    e02.addHeader(key, value);
                }
            }
            if (WVMonitorService.getPerformanceMonitor() != null) {
                WVMonitorService.getPerformanceMonitor().didResourceStartLoadAtTime(this.mUrl, System.currentTimeMillis());
            }
            return e02;
        } catch (Exception e) {
            String str5 = this.TAG;
            TaoLog.e(str5, " AliRequestAdapter formatAliRequest Exception" + e.getMessage());
            return null;
        }
    }

    AliRequestAdapter(EventHandler eventHandler, String str, String str2, boolean z, Map<String, String> map, Map<String, String> map2, Map<String, String> map3, Map<String, byte[]> map4, long j, int i, int i2, boolean z2, String str3) {
        this.mIsUseWebP = z2;
        this.mEventHandler = eventHandler;
        this.mUrl = str;
        this.mMethod = str2;
        this.mIsUCProxy = z;
        this.mHeaders = map;
        this.mUCHeaders = map2;
        this.mUploadFileMap = map3;
        this.mUploadDataMap = map4;
        this.mUploadFileTotalLen = j;
        this.mRequestType = i;
        this.mLoadType = i2;
        this.bizCode = str3;
        this.mAliRequest = formatAliRequest();
    }
}
