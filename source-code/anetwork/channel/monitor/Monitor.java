package anetwork.channel.monitor;

import android.content.Context;
import anet.channel.monitor.BandWidthSampler;
import anet.channel.monitor.INetworkQualityChangeListener;
import anet.channel.monitor.NetworkSpeed;
import anet.channel.util.ALog;
import java.util.concurrent.atomic.AtomicBoolean;
import tb.gw1;
import tb.s9;

/* compiled from: Taobao */
public class Monitor {
    private static final String TAG = "anet.Monitor";
    static AtomicBoolean isInit = new AtomicBoolean(false);

    public static void addListener(INetworkQualityChangeListener iNetworkQualityChangeListener) {
        addListener(iNetworkQualityChangeListener, null);
    }

    public static NetworkSpeed getNetSpeed() {
        NetworkSpeed networkSpeed = NetworkSpeed.Fast;
        try {
            return NetworkSpeed.valueOfCode(BandWidthSampler.f().h());
        } catch (Throwable th) {
            ALog.d(TAG, "getNetworkSpeed failed", null, th, new Object[0]);
            return networkSpeed;
        }
    }

    public static double getNetSpeedValue() {
        return BandWidthSampler.f().g();
    }

    @Deprecated
    public static anetwork.channel.monitor.speed.NetworkSpeed getNetworkSpeed() {
        return anetwork.channel.monitor.speed.NetworkSpeed.valueOfCode(getNetSpeed().getCode());
    }

    public static synchronized void init() {
        synchronized (Monitor.class) {
            if (isInit.compareAndSet(false, true)) {
                BandWidthSampler.f().j();
            }
        }
    }

    public static void removeListener(INetworkQualityChangeListener iNetworkQualityChangeListener) {
        s9.b().d(iNetworkQualityChangeListener);
    }

    public static void start() {
        try {
            BandWidthSampler.f().j();
        } catch (Throwable th) {
            ALog.d(TAG, "start failed", null, th, new Object[0]);
        }
    }

    public static void stop() {
        try {
            BandWidthSampler.f().k();
        } catch (Throwable th) {
            ALog.d(TAG, "stop failed", null, th, new Object[0]);
        }
    }

    public static void addListener(INetworkQualityChangeListener iNetworkQualityChangeListener, gw1 gw1) {
        s9.b().a(iNetworkQualityChangeListener, gw1);
    }

    @Deprecated
    public static synchronized void init(Context context) {
        synchronized (Monitor.class) {
            init();
        }
    }
}
