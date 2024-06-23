package android.taobao.windvane.packageapp.zipapp.utils;

import com.taobao.zcache.ResourceResponse;
import com.taobao.zcache.model.ZCacheResourceResponse;
import java.io.ByteArrayInputStream;
import java.util.Map;

/* compiled from: Taobao */
public class ZCacheResourceWrapper {
    public ZCacheResourceResponse zCacheResourceResponse = null;

    public ZCacheResourceResponse wrapZCacheResourceResponse(ResourceResponse resourceResponse) {
        ZCacheResourceResponse zCacheResourceResponse2 = new ZCacheResourceResponse();
        this.zCacheResourceResponse = zCacheResourceResponse2;
        if (resourceResponse == null) {
            zCacheResourceResponse2.isSuccess = false;
            zCacheResourceResponse2.status = 0;
            zCacheResourceResponse2.zcacheInfo = ZCacheResourceResponse.ZCACHE_NO_RESPONSE;
        } else {
            zCacheResourceResponse2.headers = resourceResponse.getHeader();
            Map<String, String> map = this.zCacheResourceResponse.headers;
            if (map == null || !map.containsKey("X-ZCache-Info")) {
                this.zCacheResourceResponse.zcacheInfo = ZCacheResourceResponse.ZCACHE_NO_HEADER;
            } else {
                ZCacheResourceResponse zCacheResourceResponse3 = this.zCacheResourceResponse;
                zCacheResourceResponse3.zcacheInfo = zCacheResourceResponse3.headers.get("X-ZCache-Info");
            }
            if (resourceResponse.getError() != null || resourceResponse.getData() == null) {
                ZCacheResourceResponse zCacheResourceResponse4 = this.zCacheResourceResponse;
                zCacheResourceResponse4.isSuccess = false;
                zCacheResourceResponse4.status = 1;
            } else {
                this.zCacheResourceResponse.inputStream = new ByteArrayInputStream(resourceResponse.getData());
                ZCacheResourceResponse zCacheResourceResponse5 = this.zCacheResourceResponse;
                zCacheResourceResponse5.isSuccess = true;
                zCacheResourceResponse5.status = 2;
            }
        }
        return this.zCacheResourceResponse;
    }
}
