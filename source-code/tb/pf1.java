package tb;

import android.content.Context;
import android.content.ContextWrapper;
import com.alibaba.android.ultron.trade.monitor.IMonitor;

/* compiled from: Taobao */
public class pf1 {
    public static boolean a(Context context) {
        if (context instanceof IMonitor) {
            return true;
        }
        if (!(context instanceof ContextWrapper) || !(((ContextWrapper) context).getBaseContext() instanceof IMonitor)) {
            return false;
        }
        return true;
    }
}
