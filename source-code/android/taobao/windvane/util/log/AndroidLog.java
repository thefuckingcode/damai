package android.taobao.windvane.util.log;

import android.util.Log;

/* compiled from: Taobao */
public class AndroidLog implements ILog {
    @Override // android.taobao.windvane.util.log.ILog
    public void d(String str, String str2) {
        if (str != null && str2 != null) {
            Log.d(str, str2);
        }
    }

    @Override // android.taobao.windvane.util.log.ILog
    public void e(String str, String str2) {
        if (str != null && str2 != null) {
            Log.e(str, str2);
        }
    }

    @Override // android.taobao.windvane.util.log.ILog
    public void i(String str, String str2) {
        if (str != null && str2 != null) {
            Log.i(str, str2);
        }
    }

    @Override // android.taobao.windvane.util.log.ILog
    public boolean isLogLevelEnabled(int i) {
        return true;
    }

    @Override // android.taobao.windvane.util.log.ILog
    public void log(int i, String str, String str2) {
        if (i == 2) {
            v(str, str2);
        } else if (i == 3) {
            d(str, str2);
        } else if (i == 4) {
            i(str, str2);
        } else if (i == 5) {
            w(str, str2);
        } else if (i != 6) {
            v(str, str2);
        } else {
            e(str, str2);
        }
    }

    @Override // android.taobao.windvane.util.log.ILog
    public void v(String str, String str2) {
        if (str != null && str2 != null) {
            Log.v(str, str2);
        }
    }

    @Override // android.taobao.windvane.util.log.ILog
    public void w(String str, String str2) {
        if (str != null && str2 != null) {
            Log.w(str, str2);
        }
    }

    @Override // android.taobao.windvane.util.log.ILog
    public void d(String str, String str2, Throwable th) {
        if (str != null && str2 != null && th != null) {
            Log.d(str, str2, th);
        }
    }

    @Override // android.taobao.windvane.util.log.ILog
    public void e(String str, String str2, Throwable th) {
        if (str != null && str2 != null && th != null) {
            Log.e(str, str2, th);
        }
    }

    @Override // android.taobao.windvane.util.log.ILog
    public void i(String str, String str2, Throwable th) {
        if (str != null && str2 != null && th != null) {
            Log.i(str, str2, th);
        }
    }

    @Override // android.taobao.windvane.util.log.ILog
    public void v(String str, String str2, Throwable th) {
        if (str != null && str2 != null && th != null) {
            Log.v(str, str2, th);
        }
    }

    @Override // android.taobao.windvane.util.log.ILog
    public void w(String str, String str2, Throwable th) {
        if (str != null && str2 != null && th != null) {
            Log.w(str, str2, th);
        }
    }
}
