package tb;

import android.content.Context;
import anet.channel.monitor.INetworkQualityChangeListener;
import anet.channel.monitor.NetworkSpeed;
import anetwork.channel.monitor.Monitor;
import com.taobao.phenix.loader.network.NetworkQualityListener;
import com.taobao.rxm.schedule.SchedulerSupplier;

/* compiled from: Taobao */
public class wh2 {
    private static boolean a;
    private static boolean b;

    /* compiled from: Taobao */
    static class a implements INetworkQualityChangeListener {
        a() {
        }

        @Override // anet.channel.monitor.INetworkQualityChangeListener
        public void onNetworkQualityChanged(NetworkSpeed networkSpeed) {
            boolean z = true;
            vr2.a("Network", "network speed detect: %K/s", Integer.valueOf((int) (Monitor.getNetSpeedValue() * 1024.0d)));
            SchedulerSupplier a = tp1.o().schedulerBuilder().build();
            if (a instanceof NetworkQualityListener) {
                NetworkQualityListener networkQualityListener = (NetworkQualityListener) a;
                if (networkSpeed != NetworkSpeed.Slow) {
                    z = false;
                }
                networkQualityListener.onNetworkQualityChanged(z);
            }
        }
    }

    /* compiled from: Taobao */
    static class b extends gw1 {
        b() {
        }

        @Override // tb.gw1
        public boolean b(double d) {
            return d <= 30.0d;
        }
    }

    public static boolean a() {
        return b;
    }

    public static void b(Context context) {
        try {
            tp1.o().httpLoaderBuilder().with(new rf1(context));
            a = true;
            vr2.f("TBNetwork4Phenix", "http loader setup", new Object[0]);
        } catch (RuntimeException e) {
            vr2.c("TBNetwork4Phenix", "http loader setup error=%s", e);
        }
    }

    public static void c() {
        if (a) {
            Monitor.addListener(new a(), new b());
            vr2.f("TBNetwork4Phenix", "network quality monitor setup", new Object[0]);
        }
    }
}
