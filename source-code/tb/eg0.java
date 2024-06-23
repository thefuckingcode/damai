package tb;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import android.net.wifi.WifiManager;
import android.util.Log;
import androidx.annotation.RequiresApi;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import ntk.cellular.a;

/* compiled from: Taobao */
public class eg0 extends a {
    @Override // ntk.cellular.a
    public int h(Context context) {
        int f = f();
        if (f == 0) {
            return f;
        }
        WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
        int i = 0;
        try {
            Method method = WifiManager.class.getMethod("getDualWifiEnabledState", new Class[0]);
            if (method != null) {
                i = ((Integer) method.invoke(wifiManager, new Object[0])).intValue();
            }
            if (i != 1) {
                return -11;
            }
            return f;
        } catch (Exception e) {
            e.printStackTrace();
            return f;
        }
    }

    @Override // ntk.cellular.a
    @RequiresApi(api = 21)
    public synchronized void i(Context context) {
        if (this.a == null) {
            if (a.a(context)) {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                if (connectivityManager != null) {
                    Object obj = null;
                    try {
                        boolean booleanValue = ((Boolean) WifiManager.class.getMethod("supportDualWifi", new Class[0]).invoke((WifiManager) context.getSystemService("wifi"), new Object[0])).booleanValue();
                        if (booleanValue) {
                            Log.i("HTTP_KIT_LOG", "openChannel supportDualWifi:" + booleanValue);
                        }
                        Field declaredField = NetworkCapabilities.class.getDeclaredField("TRANSPORT_EXTWIFI");
                        declaredField.setAccessible(true);
                        obj = declaredField.get(null);
                    } catch (Exception unused) {
                        Log.i("HTTP_KIT_LOG", "openChannel ext_wifi failed open");
                    }
                    Log.i("HTTP_KIT_LOG", "will openChannel ext_wifi!");
                    if (obj != null) {
                        connectivityManager.requestNetwork(new NetworkRequest.Builder().addTransportType(Integer.parseInt(obj.toString())).addCapability(12).build(), this.d);
                    }
                }
            }
        }
    }
}
