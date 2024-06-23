package tb;

import android.text.TextUtils;
import com.alibaba.analytics.core.model.LogField;
import com.alibaba.analytics.core.store.LogStoreMgr;
import com.alibaba.analytics.core.sync.e;
import com.alibaba.analytics.utils.Logger;
import com.alibaba.motu.tbrest.rest.RestConstants;
import java.util.Map;

/* compiled from: Taobao */
public class d91 {
    public static void a(Map<String, String> map) {
        boolean z;
        Logger.q();
        if (map != null) {
            String str = map.get(LogField.EVENTID.toString());
            if (!map.containsKey(RestConstants.LogContentKeys.PRIORITY) && ("2201".equalsIgnoreCase(str) || "2202".equalsIgnoreCase(str))) {
                map.put(RestConstants.LogContentKeys.PRIORITY, "4");
            }
            String remove = map.containsKey(RestConstants.LogContentKeys.PRIORITY) ? map.remove(RestConstants.LogContentKeys.PRIORITY) : "3";
            String a = c91.b().a(str);
            if (!TextUtils.isEmpty(a)) {
                remove = a;
            }
            if (map.containsKey(RestConstants.PrivateLogFields.SEND_LOG_SYNC)) {
                map.remove(RestConstants.PrivateLogFields.SEND_LOG_SYNC);
                z = true;
            } else {
                z = false;
            }
            int i = xq2.g().k() ? xq2.g().i(map) : 0;
            u81 u81 = new u81(remove, null, str, map);
            if (i > 0) {
                Logger.f("", "topicId", Integer.valueOf(i));
                u81.e(i);
                e.h().f(u81);
            }
            if (z) {
                LogStoreMgr.l().e(u81);
            } else {
                LogStoreMgr.l().d(u81);
            }
        }
    }
}
