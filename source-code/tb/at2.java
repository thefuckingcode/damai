package tb;

import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import com.taobao.tlog.adapter.AdapterForTLog;
import com.uploader.export.IUploaderLog;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
public class at2 implements IUploaderLog {
    private static Map<String, Integer> c;
    private volatile int a = 31;
    private volatile boolean b = true;

    static {
        HashMap hashMap = new HashMap(6);
        c = hashMap;
        hashMap.put("V", 31);
        c.put("D", 30);
        c.put("I", 28);
        c.put(ExifInterface.LONGITUDE_WEST, 24);
        c.put(ExifInterface.LONGITUDE_EAST, 16);
        c.put("L", 0);
    }

    private boolean a(int i) {
        int intValue = c.get(AdapterForTLog.getLogLevel()).intValue();
        if (intValue != this.a) {
            this.a = intValue;
        }
        return (i & this.a) != 0;
    }

    @Override // com.uploader.export.IUploaderLog
    public boolean isEnabled(int i) {
        if (this.b) {
            return a(i);
        }
        return (i & this.a) != 0;
    }

    @Override // com.uploader.export.IUploaderLog
    public int print(int i, String str, String str2, Throwable th) {
        if (i != 1) {
            if (i != 2) {
                if (i != 4) {
                    if (i != 8) {
                        if (i != 16) {
                            return 0;
                        }
                        if (!this.b) {
                            return Log.e(str, str2, th);
                        }
                        AdapterForTLog.loge(str, str2, th);
                        return 0;
                    } else if (!this.b) {
                        return Log.w(str, str2, th);
                    } else {
                        AdapterForTLog.logw(str, str2, th);
                        return 0;
                    }
                } else if (!this.b) {
                    return Log.i(str, str2);
                } else {
                    AdapterForTLog.logi(str, str2);
                    return 0;
                }
            } else if (!this.b) {
                return Log.d(str, str2);
            } else {
                AdapterForTLog.logd(str, str2);
                return 0;
            }
        } else if (!this.b) {
            return Log.v(str, str2);
        } else {
            AdapterForTLog.logv(str, str2);
            return 0;
        }
    }
}
