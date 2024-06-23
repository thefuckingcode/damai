package android.taobao.windvane.packageapp;

import android.taobao.windvane.config.WVCommonConfig;
import android.taobao.windvane.ha.WVHAManager;
import android.taobao.windvane.monitor.AppMonitorUtil;
import android.taobao.windvane.packageapp.zipapp.utils.ZCacheResourceWrapper;
import android.taobao.windvane.service.WVEventContext;
import android.taobao.windvane.service.WVEventListener;
import android.taobao.windvane.service.WVEventResult;
import android.taobao.windvane.util.TaoLog;
import android.taobao.windvane.util.WVUrlUtil;
import android.taobao.windvane.webview.WVWrapWebResourceResponse;
import android.util.Log;
import com.taobao.zcache.ResourceRequest;
import com.taobao.zcache.ResourceResponse;
import com.taobao.zcache.ResourceResponseCallback;
import com.taobao.zcache.ZCache;
import com.taobao.zcache.ZCacheInitTask;
import com.taobao.zcache.ZCacheManager;
import com.taobao.zcache.model.ZCacheResourceResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import tb.jl1;

/* compiled from: Taobao */
public class WVPackageAppWebViewClientFilter implements WVEventListener {
    static final int CORE_TYPE_ANDROID = 2;
    static final int CORE_TYPE_U3 = 1;
    static final int CORE_TYPE_U4 = 3;
    private static long ZCACHE_REPONSE_TIMEOUT = 20;
    private static WVPackageAppWebViewClientFilter instance;
    private String TAG = WVPackageAppWebViewClientFilter.class.getSimpleName();

    public static WVPackageAppWebViewClientFilter getInstance() {
        if (instance == null) {
            synchronized (WVPackageAppWebViewClientFilter.class) {
                if (instance == null) {
                    instance = new WVPackageAppWebViewClientFilter();
                }
            }
        }
        return instance;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v24, types: [java.util.Map] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // android.taobao.windvane.service.WVEventListener
    public WVEventResult onEvent(int i, WVEventContext wVEventContext, Object... objArr) {
        ZCacheResourceResponse zCacheResourceResponse;
        String str;
        Map<String, String> map;
        String str2;
        Object obj;
        if (wVEventContext == null) {
            return new WVEventResult(false);
        }
        if (i != 1004 && i != 1008) {
            return new WVEventResult(false);
        }
        int i2 = 2;
        if (i == 1004) {
            try {
                obj = objArr[0];
            } catch (Throwable th) {
                TaoLog.e(this.TAG, "onEvent: 获取内核状态出错");
                th.printStackTrace();
            }
        } else {
            obj = objArr[1];
        }
        i2 = ((Integer) obj).intValue();
        if (i2 == 1 || i2 == 3) {
            ZCACHE_REPONSE_TIMEOUT = WVCommonConfig.commonConfig.zcacheResponseTimeOut;
        } else {
            ZCACHE_REPONSE_TIMEOUT = WVCommonConfig.commonConfig.sysZcacheResponseTimeOut;
        }
        HashMap hashMap = new HashMap(3);
        hashMap.put("apmUrl", wVEventContext.url);
        hashMap.put("msg", "zcache read start: " + System.currentTimeMillis());
        WVHAManager.uploadApmStage("ZCache.Start", hashMap);
        ZCacheInitTask.getInstance().init();
        if (WVCommonConfig.commonConfig.keepFullUrl && (str2 = wVEventContext.url) != null && str2.startsWith("https")) {
            wVEventContext.url = wVEventContext.url.replace("https", "http");
        }
        wVEventContext.url = WVUrlUtil.removeQueryParam(wVEventContext.url);
        HashMap hashMap2 = new HashMap();
        if (i == 1008) {
            try {
                hashMap2 = (Map) objArr[0];
            } catch (Throwable th2) {
                Log.e(this.TAG, "onEvent: ");
                th2.printStackTrace();
            }
        }
        if (!WVCommonConfig.commonConfig.enableZCacheAdpter) {
            try {
                zCacheResourceResponse = ZCacheManager.instance().getZCacheResource(wVEventContext.url, hashMap2);
            } catch (Throwable th3) {
                th3.printStackTrace();
                zCacheResourceResponse = null;
            }
        } else {
            final ZCacheResourceWrapper zCacheResourceWrapper = new ZCacheResourceWrapper();
            ResourceRequest resourceRequest = new ResourceRequest(wVEventContext.url, hashMap2);
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            final long currentTimeMillis = System.currentTimeMillis();
            try {
                ZCache.getResource(resourceRequest, new ResourceResponseCallback() {
                    /* class android.taobao.windvane.packageapp.WVPackageAppWebViewClientFilter.AnonymousClass1 */

                    @Override // com.taobao.zcache.ResourceResponseCallback
                    public void finish(ResourceResponse resourceResponse) {
                        try {
                            zCacheResourceWrapper.wrapZCacheResourceResponse(resourceResponse);
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                        countDownLatch.countDown();
                        long currentTimeMillis = System.currentTimeMillis() - currentTimeMillis;
                        if (zCacheResourceWrapper.zCacheResourceResponse.isSuccess && currentTimeMillis > WVPackageAppWebViewClientFilter.ZCACHE_REPONSE_TIMEOUT) {
                            AppMonitorUtil.commitFail(AppMonitorUtil.MONITOR_POINT_ZCACHE_RESPONSE_TIME_OUT, 0, "ZCache请求超时, 用时：" + currentTimeMillis, null);
                        } else if (zCacheResourceWrapper.zCacheResourceResponse.isSuccess) {
                            AppMonitorUtil.commitSuccess(AppMonitorUtil.MONITOR_POINT_ZCACHE_RESPONSE_TIME_OUT, "ZCache请求在正常时限内返回");
                        }
                    }
                });
                countDownLatch.await(ZCACHE_REPONSE_TIMEOUT, TimeUnit.MILLISECONDS);
            } catch (Throwable th4) {
                Log.e(this.TAG, "onEvent: 异步等待发生错误！");
                th4.printStackTrace();
            }
            zCacheResourceResponse = zCacheResourceWrapper.zCacheResourceResponse;
        }
        if (zCacheResourceResponse == null) {
            TaoLog.i("ZCache", "H5 use ZCache 3.0, url=[" + wVEventContext.url + "], with response:[false]");
            return new WVEventResult(false);
        }
        if (!WVCommonConfig.commonConfig.enableMimeTypeSet || (map = zCacheResourceResponse.headers) == null || !map.containsKey("Content-Type")) {
            str = null;
        } else {
            String str3 = zCacheResourceResponse.headers.get("Content-Type");
            if (str3 == null || !str3.contains("text/html")) {
                str = str3;
            } else {
                str = "text/html";
            }
            TaoLog.e("ZCache", "mimeType= " + str);
        }
        TaoLog.i("ZCache", "H5 use ZCache 3.0, url=[" + wVEventContext.url + "] with response:[" + zCacheResourceResponse.isSuccess + jl1.ARRAY_END_STR);
        if (str == null) {
            str = zCacheResourceResponse.mimeType;
        }
        WVWrapWebResourceResponse wVWrapWebResourceResponse = new WVWrapWebResourceResponse(str, zCacheResourceResponse.encoding, zCacheResourceResponse.inputStream, zCacheResourceResponse.headers);
        wVWrapWebResourceResponse.status = zCacheResourceResponse.status;
        wVWrapWebResourceResponse.zcacheInfo = zCacheResourceResponse.zcacheInfo;
        HashMap hashMap3 = new HashMap(3);
        hashMap3.put("apmUrl", wVEventContext.url);
        hashMap3.put("msg", "zcache read end: " + System.currentTimeMillis());
        WVHAManager.uploadApmStage("ZCache.End", hashMap3);
        return new WVEventResult(zCacheResourceResponse.isSuccess, wVWrapWebResourceResponse);
    }
}
