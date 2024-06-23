package com.alibaba.emas.datalab.decision.make;

import android.util.Log;
import com.alibaba.emas.datalab.DatalabBizType;
import com.alibaba.emas.datalab.DatalabListener;
import com.alibaba.emas.datalab.stage.Stage;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.youku.live.livesdk.monitor.performance.YoukuLivePerformanceConstants;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import tb.n03;
import tb.n20;
import tb.p20;
import tb.q20;
import tb.t20;

/* compiled from: Taobao */
public class a {
    private Map<DatalabBizType, n20> a = null;
    public Boolean b = Boolean.FALSE;

    /* access modifiers changed from: package-private */
    /* renamed from: com.alibaba.emas.datalab.decision.make.a$a  reason: collision with other inner class name */
    /* compiled from: Taobao */
    public static /* synthetic */ class C0083a {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            int[] iArr = new int[DatalabBizType.values().length];
            a = iArr;
            iArr[DatalabBizType.zcache.ordinal()] = 1;
            a[DatalabBizType.update.ordinal()] = 2;
        }
    }

    private void a(DatalabBizType datalabBizType, n20 n20) {
        if (this.a == null) {
            this.a = new ConcurrentHashMap();
        }
        this.a.put(datalabBizType, n20);
    }

    private void c(t20 t20) throws Exception {
        if (com.alibaba.emas.datalab.a.b().a == null) {
            Log.w("Datalab.dmService", "not listener map");
            return;
        }
        int i = C0083a.a[t20.b.ordinal()];
        if (i == 1) {
            String str = t20.c;
            String str2 = t20.d;
            if (str != null && str2 != null) {
                n03 d = d(t20);
                if (d != null) {
                    a(t20.b, d);
                }
                if (d != null && d.b != null) {
                    Log.w("Datalab.dmService", "call back listener " + t20.b.toString());
                    b(t20.b, d);
                }
            }
        } else if (i != 2) {
            Log.w("Datalab.dmService", "not support this type");
        }
    }

    private n03 d(t20 t20) throws Exception {
        String str = t20.c;
        String str2 = t20.d;
        String str3 = t20.a;
        n03 n03 = new n03();
        n03.a = str3;
        if (str.equals("app.start")) {
            try {
                JSONArray parseArray = JSON.parseArray(str2);
                for (int i = 0; i < parseArray.size(); i++) {
                    n03.a(parseArray.getString(i));
                }
            } catch (Exception e) {
                Log.w("Datalab.dmService", str2 + " parse json array failure ", e);
            }
        } else if (!str.equals("app.pageView")) {
            Log.w("Datalab.dmService", "not support this event " + str);
        }
        return n03;
    }

    public void b(DatalabBizType datalabBizType, n20 n20) {
        DatalabListener datalabListener = com.alibaba.emas.datalab.a.b().a.get(datalabBizType);
        if (datalabListener != null) {
            q20 q20 = new q20();
            q20.b = datalabBizType;
            Stage stage = Stage.DOWNLOAD;
            q20.a = "datalab";
            if (datalabBizType.equals(DatalabBizType.zcache)) {
                Set<String> set = ((n03) n20).b;
                q20.c = set;
                if (set == null || set.size() <= 0) {
                    Log.w("Datalab.dmService", "download list is null");
                    return;
                }
                datalabListener.execute(stage, q20);
                p20.c().a(n20.a, datalabBizType, q20.c);
            } else if (!datalabBizType.equals(DatalabBizType.update)) {
                Log.w("Datalab.dmService", "not support this type");
            }
        } else {
            Log.w("Datalab.dmService", "listener is null " + datalabBizType.toString());
        }
    }

    public void e(t20 t20) throws Exception {
        String str = t20.a;
        if (str != null && t20.b != null) {
            str.hashCode();
            char c = 65535;
            switch (str.hashCode()) {
                case -1480388560:
                    if (str.equals(YoukuLivePerformanceConstants.MONITOR_POINT)) {
                        c = 0;
                        break;
                    }
                    break;
                case -1008851410:
                    if (str.equals("orange")) {
                        c = 1;
                        break;
                    }
                    break;
                case -899647263:
                    if (str.equals("slider")) {
                        c = 2;
                        break;
                    }
                    break;
                case 99212:
                    if (str.equals("dai")) {
                        c = 3;
                        break;
                    }
                    break;
                case 2988050:
                    if (str.equals("accs")) {
                        c = 4;
                        break;
                    }
                    break;
                case 94921639:
                    if (str.equals("crash")) {
                        c = 5;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                case 2:
                case 4:
                case 5:
                    return;
                case 1:
                    c(t20);
                    return;
                case 3:
                    c(t20);
                    return;
                default:
                    Log.w("Datalab.dmService", "not support this source");
                    return;
            }
        }
    }
}
