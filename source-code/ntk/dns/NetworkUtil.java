package ntk.dns;

import android.content.Context;
import android.content.pm.PackageManager;
import anet.channel.status.NetworkStatusHelper;
import com.youku.core.context.YoukuContext;

/* compiled from: Taobao */
public class NetworkUtil {
    public static final int CELLULAR = 2;
    public static final int NO_NETWORK = -1;
    public static final int UNKNOWN = 0;
    public static final int WIFI = 1;

    /* compiled from: Taobao */
    public interface RequestCallBack {
        void onFailed(String str, String str2);

        void onSuccess(String str);
    }

    public static String a() {
        try {
            Context applicationContext = YoukuContext.getApplicationContext();
            return applicationContext.getPackageManager().getPackageInfo(applicationContext.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException | NoClassDefFoundError unused) {
            return "invalid_ver";
        }
    }

    static /* synthetic */ boolean b(NetworkUtil networkUtil) {
        throw null;
    }

    public static int c() {
        return -1;
    }

    public static int d() {
        if (!NetworkStatusHelper.n()) {
            return -1;
        }
        if (NetworkStatusHelper.i().isWifi()) {
            return 1;
        }
        return NetworkStatusHelper.i().isMobile() ? 2 : 0;
    }
}
