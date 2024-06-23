package com.taobao.zcache.api;

import android.taobao.windvane.jsbridge.WVApiPlugin;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.taobao.windvane.jsbridge.WVResult;
import com.taobao.zcache.core.IZCacheCore;
import com.taobao.zcache.core.ZCacheCoreProxy;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
public class ZCacheDev extends WVApiPlugin {
    @Override // android.taobao.windvane.jsbridge.WVApiPlugin
    public boolean execute(String str, String str2, final WVCallBackContext wVCallBackContext) {
        return ZCacheCoreProxy.core().invokeDev(str, str2, new IZCacheCore.DevCallback() {
            /* class com.taobao.zcache.api.ZCacheDev.AnonymousClass1 */

            @Override // com.taobao.zcache.core.IZCacheCore.DevCallback
            public void finish(boolean z, String str) {
                WVResult wVResult = new WVResult();
                try {
                    wVResult.setData(new JSONObject(str));
                } catch (JSONException unused) {
                    wVResult.addData("message", str);
                }
                if (z) {
                    wVCallBackContext.success(wVResult);
                } else {
                    wVCallBackContext.error(wVResult);
                }
            }
        });
    }
}
