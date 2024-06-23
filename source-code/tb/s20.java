package tb;

import android.util.Log;
import com.alibaba.emas.datalab.metrics.listener.DatalabMetricListener;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
public class s20 {
    private static String b = "DatalabMetricService";
    private List<DatalabMetricListener> a;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class b {
        private static s20 a = new s20();
    }

    public static s20 a() {
        return b.a;
    }

    public List<DatalabMetricListener> b() {
        return this.a;
    }

    public Boolean c(DatalabMetricListener datalabMetricListener) {
        if (datalabMetricListener != null) {
            try {
                this.a.add(datalabMetricListener);
            } catch (Exception e) {
                Log.e(b, "regist failure ", e);
            }
        }
        return Boolean.TRUE;
    }

    private s20() {
        this.a = new ArrayList();
    }
}
