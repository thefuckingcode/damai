package android.taobao.windvane.extra.uc;

import android.taobao.windvane.cache.WVCacheManager;
import android.taobao.windvane.cache.WVMemoryCache;
import android.taobao.windvane.cache.WVMemoryCacheInfo;
import android.taobao.windvane.config.WVServerConfig;
import android.taobao.windvane.monitor.WVMonitorService;
import android.taobao.windvane.service.WVEventResult;
import android.taobao.windvane.service.WVEventService;
import android.taobao.windvane.util.DigestUtils;
import android.taobao.windvane.util.MimeTypeEnum;
import android.taobao.windvane.util.TaoLog;
import android.taobao.windvane.util.WVUrlUtil;
import android.taobao.windvane.webview.WVWrapWebResourceResponse;
import com.uc.webview.export.ServiceWorkerClient;
import com.uc.webview.export.WebResourceRequest;
import com.uc.webview.export.WebResourceResponse;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import tb.jl1;

/* compiled from: Taobao */
public class WVUCServiceWorkerClient extends ServiceWorkerClient {
    private static final String TAG = "WVUCServiceWorkerClient";

    /* JADX WARNING: Removed duplicated region for block: B:43:0x0102 A[SYNTHETIC, Splitter:B:43:0x0102] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0111  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x014c  */
    @Override // com.uc.webview.export.ServiceWorkerClient
    public WebResourceResponse shouldInterceptRequest(WebResourceRequest webResourceRequest) {
        WVMemoryCacheInfo memoryCacheByUrl;
        FileInputStream fileInputStream;
        Object obj;
        String uri = webResourceRequest.getUrl().toString();
        WebResourceResponse webResourceResponse = null;
        WVEventResult onEvent = WVEventService.getInstance().onEvent(1004, null, uri, new Object[0]);
        if (!onEvent.isSuccess || (obj = onEvent.resultObj) == null || !(obj instanceof WVWrapWebResourceResponse)) {
            if (WVMonitorService.getPerformanceMonitor() != null) {
                WVMonitorService.getPerformanceMonitor().didGetResourceStatusCode(uri, 0, WVUCWebView.getFromType(), null, null);
            }
            if (WVCacheManager.getInstance().isCacheEnabled(uri)) {
                String removeScheme = WVUrlUtil.removeScheme(uri);
                try {
                    fileInputStream = new FileInputStream(new File(WVCacheManager.getInstance().getCacheDir(true) + File.separator + DigestUtils.md5ToHex(removeScheme)));
                    try {
                        WebResourceResponse webResourceResponse2 = new WebResourceResponse("image/png", "UTF-8", fileInputStream);
                        HashMap hashMap = new HashMap();
                        hashMap.put("Access-Control-Allow-Origin", jl1.MUL);
                        webResourceResponse2.setResponseHeaders(hashMap);
                        return webResourceResponse2;
                    } catch (Exception unused) {
                        if (fileInputStream != null) {
                        }
                        memoryCacheByUrl = WVMemoryCache.getInstance().getMemoryCacheByUrl(uri);
                        if (memoryCacheByUrl != null) {
                        }
                    }
                } catch (Exception unused2) {
                    fileInputStream = null;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException unused3) {
                        }
                    }
                    memoryCacheByUrl = WVMemoryCache.getInstance().getMemoryCacheByUrl(uri);
                    if (memoryCacheByUrl != null) {
                    }
                }
            }
            memoryCacheByUrl = WVMemoryCache.getInstance().getMemoryCacheByUrl(uri);
            if (memoryCacheByUrl != null) {
                if (System.currentTimeMillis() - memoryCacheByUrl.cachedTime < 2000) {
                    webResourceResponse = new WebResourceResponse(MimeTypeEnum.HTML.getMimeType(), "UTF-8", new ByteArrayInputStream(memoryCacheByUrl.mCachedDatas));
                }
                WVMemoryCache.getInstance().clearCacheByUrl(uri);
                TaoLog.i(TAG, "WVMemoryCacheInfo 命中 : " + uri);
                return webResourceResponse;
            }
            if (TaoLog.getLogStatus()) {
                TaoLog.d(TAG, "shouldInterceptRequest : " + uri);
            }
            return super.shouldInterceptRequest(webResourceRequest);
        }
        WVWrapWebResourceResponse wVWrapWebResourceResponse = (WVWrapWebResourceResponse) obj;
        if (TaoLog.getLogStatus()) {
            TaoLog.d(TAG, "预加载命中 : " + uri);
        }
        WebResourceResponse webResourceResponse3 = new WebResourceResponse(wVWrapWebResourceResponse.mMimeType, wVWrapWebResourceResponse.mEncoding, wVWrapWebResourceResponse.mInputStream);
        try {
            if (wVWrapWebResourceResponse.mHeaders != null) {
                try {
                    if (!WVServerConfig.isAllowAccess(uri) || wVWrapWebResourceResponse.mHeaders.containsKey("Access-Control-Allow-Origin")) {
                        webResourceResponse3.setResponseHeaders(wVWrapWebResourceResponse.mHeaders);
                    } else {
                        HashMap hashMap2 = new HashMap();
                        hashMap2.putAll(wVWrapWebResourceResponse.mHeaders);
                        hashMap2.put("Access-Control-Allow-Origin", jl1.MUL);
                        webResourceResponse3.setResponseHeaders(hashMap2);
                        TaoLog.w(TAG, "add cross origin header");
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            } else if (WVServerConfig.isAllowAccess(uri)) {
                HashMap hashMap3 = new HashMap();
                hashMap3.put("Access-Control-Allow-Origin", jl1.MUL);
                webResourceResponse3.setResponseHeaders(hashMap3);
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        return webResourceResponse3;
    }
}
