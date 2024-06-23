package tb;

import com.taobao.update.datasource.logger.Log;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
public class y91 implements Log {
    public static final String ROOT_TAG = "update_";
    private static Map<String, Log> c = new HashMap();
    public static boolean logEnable = true;
    public static int logLevel = 6;
    private String a;
    private Log b;

    private y91(String str, Log log) {
        this.b = log;
        this.a = str;
    }

    public static Log getLog(Class cls, Log log) {
        return getLog(cls.getSimpleName(), log);
    }

    @Override // com.taobao.update.datasource.logger.Log
    public int d(String str) {
        if (logLevel < 3 || !logEnable) {
            return 0;
        }
        Log log = this.b;
        if (log == null) {
            return android.util.Log.d(ROOT_TAG.concat(this.a), str);
        }
        return log.d(str);
    }

    @Override // com.taobao.update.datasource.logger.Log
    public int e(String str) {
        if (logLevel < 6 || !logEnable) {
            return 0;
        }
        Log log = this.b;
        if (log == null) {
            return android.util.Log.e(ROOT_TAG.concat(this.a), str);
        }
        return log.e(str);
    }

    @Override // com.taobao.update.datasource.logger.Log
    public int i(String str) {
        if (logLevel < 4 || !logEnable) {
            return 0;
        }
        Log log = this.b;
        if (log == null) {
            return android.util.Log.i(ROOT_TAG.concat(this.a), str);
        }
        return log.i(str);
    }

    @Override // com.taobao.update.datasource.logger.Log
    public int v(String str) {
        if (logLevel < 2 || !logEnable) {
            return 0;
        }
        Log log = this.b;
        if (log == null) {
            return android.util.Log.v(ROOT_TAG.concat(this.a), str);
        }
        return log.v(str);
    }

    @Override // com.taobao.update.datasource.logger.Log
    public int w(String str) {
        if (logLevel < 5 || !logEnable) {
            return 0;
        }
        Log log = this.b;
        if (log == null) {
            return android.util.Log.i(ROOT_TAG.concat(this.a), str);
        }
        return log.w(str);
    }

    public static Log getLog(String str, Log log) {
        Log log2;
        synchronized (y91.class) {
            log2 = c.get(str);
            if (log2 == null) {
                log2 = new y91(str, log);
                c.put(str, log2);
            }
        }
        return log2;
    }

    @Override // com.taobao.update.datasource.logger.Log
    public int e(String str, Throwable th) {
        if (logLevel < 6 || !logEnable) {
            return 0;
        }
        Log log = this.b;
        if (log == null) {
            return android.util.Log.e(ROOT_TAG.concat(this.a), str, th);
        }
        return log.e(str, th);
    }

    @Override // com.taobao.update.datasource.logger.Log
    public int w(String str, Throwable th) {
        if (logLevel < 5 || !logEnable) {
            return 0;
        }
        Log log = this.b;
        if (log == null) {
            return android.util.Log.w(ROOT_TAG.concat(this.a), str, th);
        }
        return log.w(str, th);
    }
}
