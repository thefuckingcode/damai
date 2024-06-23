package tb;

import android.content.Context;
import android.net.NetworkInfo;
import com.alibaba.wireless.security.aopsdk.replace.android.net.ConnectivityManager;

/* compiled from: Taobao */
public class i13 {
    public static final boolean a(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ConnectivityManager.getActiveNetworkInfo((android.net.ConnectivityManager) context.getSystemService("connectivity"));
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                return false;
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static final NetworkInfo b(Context context) {
        try {
            return ConnectivityManager.getActiveNetworkInfo((android.net.ConnectivityManager) context.getSystemService("connectivity"));
        } catch (Throwable unused) {
            return null;
        }
    }
}
