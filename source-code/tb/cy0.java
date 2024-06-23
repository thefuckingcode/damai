package tb;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.taobao.weex.common.Constants;
import me.ele.altriax.launcher.common.AltriaXLaunchTime;
import org.apache.commons.net.SocketClient;

/* compiled from: Taobao */
public class cy0 {
    private static boolean a;
    private static boolean b;
    private static String[] c = {"SM-N900", "SM-N9002", "SM-N9005", "SM-N9006", "SM-N9008", "SM-N9009", "SM-I9500", "SM-I9502", "SM-I9505", "SM-I9508", "SM-I959", "SM-G9006V", "SM-G9009D", "SM-G9008V", "SM-G9098"};

    public static String a(String str, Throwable th) {
        if (th == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        String message = th.getMessage();
        String name = th.getClass().getName();
        sb.append("\t");
        sb.append(str + "\t");
        sb.append(name);
        sb.append(AltriaXLaunchTime.SPACE);
        sb.append(message);
        sb.append(SocketClient.NETASCII_EOL);
        StackTraceElement[] stackTrace = th.getStackTrace();
        if (message == null || message.length() == 0) {
            return "";
        }
        for (StackTraceElement stackTraceElement : stackTrace) {
            sb.append("\tat  ");
            sb.append(stackTraceElement);
            sb.append(SocketClient.NETASCII_EOL);
        }
        return sb.toString();
    }

    /* JADX INFO: finally extract failed */
    public static synchronized boolean b(Context context) {
        synchronized (cy0.class) {
            try {
                if (a) {
                    boolean z = b;
                    Log.d("hotpatch", "device support is " + b + Constants.Name.CHECKED + a);
                    a = true;
                    return z;
                }
                if (!c()) {
                    b = true;
                } else {
                    b = false;
                }
                Log.d("hotpatch", "device support is " + b + Constants.Name.CHECKED + a);
                a = true;
                return b;
            } catch (Throwable th) {
                Log.d("hotpatch", "device support is " + b + Constants.Name.CHECKED + a);
                a = true;
                throw th;
            }
        }
    }

    private static boolean c() {
        return d();
    }

    private static boolean d() {
        String model = Build.getMODEL();
        if (Build.VERSION.SDK_INT == 21) {
            for (String str : c) {
                if (model.equals(str)) {
                    return true;
                }
            }
        }
        return false;
    }
}
