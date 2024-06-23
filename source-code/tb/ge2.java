package tb;

import android.app.Application;
import android.content.Context;
import com.alibaba.motu.crashreporter.IUTCrashCaughtListener;
import com.alibaba.motu.crashreporter.MotuCrashReporter;
import com.taobao.pexode.Pexode;
import com.taobao.phenix.chain.ImageDecodingListener;
import com.taobao.phenix.compat.stat.NetworkAnalyzer;
import com.taobao.phenix.compat.stat.TBImageFlowMonitor;
import com.taobao.phenix.compat.stat.TBImageRetrieveABListener;
import com.taobao.rxm.schedule.PairingThrottlingScheduler;
import com.taobao.rxm.schedule.Scheduler;
import com.taobao.rxm.schedule.SchedulerSupplier;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: Taobao */
public class ge2 {
    public static boolean a;
    public static boolean b;
    public static long c;
    private static boolean d;
    private static final b e = new b(null);

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class a implements IUTCrashCaughtListener {
        a() {
        }

        @Override // com.alibaba.motu.crashreporter.IUTCrashCaughtListener
        public Map<String, Object> onCrashCaught(Thread thread, Throwable th) {
            String a = ge2.e.a();
            if (a == null) {
                vr2.i("StatMonitor4Phenix", "crash happened, collect latest decoding failed", new Object[0]);
                return null;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("PHENIX_LATEST_DECODING", a);
            vr2.f("StatMonitor4Phenix", "crash happened, collect latest decoding urls=%s", a);
            return hashMap;
        }
    }

    private static void b() {
        if (a) {
            ln0.a = "bizReqStart";
            ln0.b = "bizReqProcessStart";
            ln0.c = "bizRspProcessStart";
            ln0.d = "bizRspCbDispatch";
            ln0.e = "bizRspCbStart";
            ln0.f = "bizRspCbEnd";
            ln0.g = "bizFinish";
        }
    }

    public static boolean c() {
        return d;
    }

    public static void d(Context context, NetworkAnalyzer networkAnalyzer, int i, int i2) {
        e(context, networkAnalyzer, i, 100, i2, null);
    }

    public static void e(Context context, NetworkAnalyzer networkAnalyzer, int i, int i2, int i3, TBImageRetrieveABListener tBImageRetrieveABListener) {
        TBImageFlowMonitor tBImageFlowMonitor = new TBImageFlowMonitor(i, i2, networkAnalyzer, tBImageRetrieveABListener);
        c = System.currentTimeMillis();
        tBImageFlowMonitor.B(bh1.a());
        ((Application) context).registerActivityLifecycleCallbacks(bh1.a());
        tBImageFlowMonitor.C(new yh2(context));
        if (i3 > 0) {
            tBImageFlowMonitor.A(i3);
        }
        Pexode.r(tBImageFlowMonitor);
        tp1.o().y(tBImageFlowMonitor);
        SchedulerSupplier a2 = tp1.o().schedulerBuilder().build();
        if (a2 != null) {
            Scheduler forNetwork = a2.forNetwork();
            if (forNetwork instanceof PairingThrottlingScheduler) {
                ((PairingThrottlingScheduler) forNetwork).f(tBImageFlowMonitor);
            }
        }
        tp1.o().x(e);
        MotuCrashReporter.getInstance().setCrashCaughtListener(new a());
        vr2.f("StatMonitor4Phenix", "init stat monitor with sampling=%d", Integer.valueOf(i));
        try {
            Class.forName("com.taobao.analysis.fulltrace.FullTraceAnalysis");
            a = true;
        } catch (Exception unused) {
            a = false;
        }
        b();
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class b implements ImageDecodingListener {
        final Map<Long, String> a;

        private b() {
            this.a = new LinkedHashMap(2);
        }

        public String a() {
            String str;
            synchronized (this) {
                str = null;
                if (this.a.size() > 0) {
                    for (Map.Entry<Long, String> entry : this.a.entrySet()) {
                        str = str == null ? entry.getValue() : str + "," + entry.getValue();
                    }
                }
            }
            return str;
        }

        @Override // com.taobao.phenix.chain.ImageDecodingListener
        public synchronized void onDecodeFinish(long j, String str) {
            this.a.remove(Long.valueOf(j));
        }

        @Override // com.taobao.phenix.chain.ImageDecodingListener
        public void onDecodeStart(long j, String str) {
            synchronized (this) {
                if (this.a.size() > 5) {
                    this.a.clear();
                }
                this.a.put(Long.valueOf(j), str);
            }
            MotuCrashReporter.getInstance().addNativeHeaderInfo("PHENIX_LATEST_DECODING", a());
        }

        /* synthetic */ b(a aVar) {
            this();
        }
    }
}
