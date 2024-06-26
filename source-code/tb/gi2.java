package tb;

import anet.channel.util.ALog;
import com.taobao.tlog.adapter.AdapterForTLog;

/* compiled from: Taobao */
public class gi2 implements ALog.ILog {
    private int a(char c) {
        if (c == 'D') {
            return 1;
        }
        if (c == 'E') {
            return 4;
        }
        if (c == 'I') {
            return 2;
        }
        if (c != 'V') {
            return c != 'W' ? 5 : 3;
        }
        return 0;
    }

    @Override // anet.channel.util.ALog.ILog
    public void d(String str, String str2) {
        AdapterForTLog.logd(str, str2);
    }

    @Override // anet.channel.util.ALog.ILog
    public void e(String str, String str2) {
        AdapterForTLog.loge(str, str2);
    }

    @Override // anet.channel.util.ALog.ILog
    public void i(String str, String str2) {
        AdapterForTLog.logi(str, str2);
    }

    @Override // anet.channel.util.ALog.ILog
    public boolean isPrintLog(int i) {
        return i >= a(AdapterForTLog.getLogLevel().charAt(0));
    }

    @Override // anet.channel.util.ALog.ILog
    public boolean isValid() {
        return AdapterForTLog.isValid();
    }

    @Override // anet.channel.util.ALog.ILog
    public void setLogLevel(int i) {
    }

    @Override // anet.channel.util.ALog.ILog
    public void w(String str, String str2) {
        AdapterForTLog.logw(str, str2);
    }

    @Override // anet.channel.util.ALog.ILog
    public void e(String str, String str2, Throwable th) {
        AdapterForTLog.loge(str, str2, th);
    }

    @Override // anet.channel.util.ALog.ILog
    public void w(String str, String str2, Throwable th) {
        AdapterForTLog.logw(str, str2, th);
    }
}
