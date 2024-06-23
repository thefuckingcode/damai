package com.taobao.monitor.adapter.logger;

import com.taobao.monitor.logger.IDataLogger;
import com.taobao.tao.log.TLog;
import java.util.Map;
import org.json.JSONObject;
import tb.uk2;
import tb.xs1;

/* compiled from: Taobao */
public class LoggerAdapter implements IDataLogger {
    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private String b(Object... objArr) {
        String str;
        if (objArr == null || objArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (Object obj : objArr) {
            if (obj != null) {
                if (obj instanceof Map) {
                    str = c((Map) obj);
                } else {
                    str = obj.toString();
                }
                sb.append("->");
                sb.append(str);
            }
        }
        return sb.toString();
    }

    private String c(Map map) {
        return new JSONObject(map).toString();
    }

    @Override // com.taobao.monitor.logger.IDataLogger
    public void log(final String str, final Object... objArr) {
        uk2.d(new Runnable() {
            /* class com.taobao.monitor.adapter.logger.LoggerAdapter.AnonymousClass1 */

            public void run() {
                try {
                    TLog.loge(xs1.DEFAULT_SAVE_DIR, str, LoggerAdapter.this.b(objArr));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
