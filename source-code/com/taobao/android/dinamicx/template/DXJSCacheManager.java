package com.taobao.android.dinamicx.template;

import android.text.TextUtils;
import android.util.LruCache;
import com.alibaba.fastjson.JSON;
import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.template.download.DXTemplateItem;
import com.taobao.android.dinamicx.template.download.DXTemplatePackageInfo;
import com.taobao.weex.annotation.JSMethod;
import java.util.Map;
import tb.hy;
import tb.ry;
import tb.vx;

/* compiled from: Taobao */
public class DXJSCacheManager {
    LruCache<String, byte[]> a = new LruCache<>(500);

    /* compiled from: Taobao */
    public static class DXLoadJSBytesTask implements Runnable {
        DXTemplateItem childTemplateInfo;
        boolean isMainTemplate;
        byte[] jsBytes;
        DXRuntimeContext runtimeContext;

        public DXLoadJSBytesTask(DXRuntimeContext dXRuntimeContext, boolean z) {
            this.runtimeContext = dXRuntimeContext;
            this.isMainTemplate = z;
        }

        public byte[] getJsBytes() {
            return this.jsBytes;
        }

        public void run() {
            String str;
            try {
                DXTemplateItem dxTemplateItem = this.runtimeContext.getDxTemplateItem();
                ry.a("isMainTemplate:" + this.isMainTemplate + ":" + JSON.toJSONString(dxTemplateItem) + " pack " + JSON.toJSONString(dxTemplateItem.packageInfo));
                DXTemplatePackageInfo dXTemplatePackageInfo = dxTemplateItem.packageInfo;
                if (dXTemplatePackageInfo != null) {
                    Map<String, String> map = dXTemplatePackageInfo.subFilePathDict;
                    if (map != null) {
                        if (this.isMainTemplate) {
                            str = map.get("index.dx");
                        } else {
                            str = map.get(dxTemplateItem.name + JSMethod.NOT_SET + dxTemplateItem.version + JSMethod.NOT_SET + "index.dx");
                        }
                        if (!TextUtils.isEmpty(str)) {
                            ry.a(str);
                            byte[] e = hy.c().e(str, this.runtimeContext);
                            this.jsBytes = e;
                            if (e != null) {
                                ry.a("isMainTemplate:" + this.isMainTemplate + ": 设置对应模版的js信息" + str);
                                DXJSCacheManager.c().d(this.childTemplateInfo, this.jsBytes);
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                vx.b(th);
            }
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class a {
        private static final DXJSCacheManager a = new DXJSCacheManager();
    }

    private String a(DXTemplateItem dXTemplateItem) {
        if (dXTemplateItem == null) {
            return null;
        }
        return dXTemplateItem.getIdentifier();
    }

    public static DXJSCacheManager c() {
        return a.a;
    }

    public byte[] b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return c().a.get(str);
    }

    public void d(DXTemplateItem dXTemplateItem, byte[] bArr) {
        e(a(dXTemplateItem), bArr);
    }

    public void e(String str, byte[] bArr) {
        if (!TextUtils.isEmpty(str) && bArr != null) {
            c().a.put(str, bArr);
        }
    }
}
