package android.taobao.windvane.packageapp;

import android.taobao.windvane.packageapp.zipapp.ZCacheResourceResponse;
import android.taobao.windvane.thread.WVThreadPool;
import android.taobao.windvane.util.TaoLog;
import android.taobao.windvane.util.WVUrlUtil;
import com.taobao.zcache.ZCacheInitTask;
import com.taobao.zcache.ZCacheManager;
import tb.jl1;

/* compiled from: Taobao */
public class WVPackageAppRuntime {
    public static final String TAG = "PackageApp-Runtime";

    /* compiled from: Taobao */
    public interface ZCacheResourceCallback {
        void callback(ZCacheResourceResponse zCacheResourceResponse);
    }

    public static void getZCacheResourceResponse(final String str, final ZCacheResourceCallback zCacheResourceCallback) {
        WVThreadPool.getInstance().execute(new Runnable() {
            /* class android.taobao.windvane.packageapp.WVPackageAppRuntime.AnonymousClass1 */

            public void run() {
                zCacheResourceCallback.callback(WVPackageAppRuntime.getZCacheResourceResponse(str));
            }
        });
    }

    public static boolean isLocalVisit(String str) {
        return ZCacheManager.instance().isResourceInstalled(str);
    }

    public static ZCacheResourceResponse getZCacheResourceResponse(String str) {
        String removeQueryParam = WVUrlUtil.removeQueryParam(str);
        ZCacheInitTask.getInstance().init();
        com.taobao.zcache.model.ZCacheResourceResponse zCacheResource = ZCacheManager.instance().getZCacheResource(removeQueryParam);
        ZCacheResourceResponse zCacheResourceResponse = new ZCacheResourceResponse();
        if (zCacheResource != null) {
            TaoLog.i("ZCache", "weex use ZCache 3.0, url=[" + removeQueryParam + "], with response:[" + zCacheResource.isSuccess + jl1.ARRAY_END_STR);
            zCacheResourceResponse.encoding = zCacheResource.encoding;
            zCacheResourceResponse.headers = zCacheResource.headers;
            zCacheResourceResponse.inputStream = zCacheResource.inputStream;
            zCacheResourceResponse.isSuccess = zCacheResource.isSuccess;
            zCacheResourceResponse.mimeType = zCacheResource.mimeType;
        } else {
            TaoLog.i("ZCache", "weex use ZCache 3.0, url=[" + removeQueryParam + "], with response=[null]");
        }
        return zCacheResourceResponse;
    }
}
