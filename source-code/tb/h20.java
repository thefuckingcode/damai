package tb;

import android.annotation.SuppressLint;
import com.alibaba.emas.datalab.metrics.listener.DatalabMetricListener;
import com.alibaba.mtl.appmonitor.AppMonitor;
import com.alibaba.mtl.appmonitor.model.DimensionSet;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.MeasureSet;
import com.alibaba.mtl.appmonitor.model.MeasureValue;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import tb.h20;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public abstract class h20<T extends h20> {
    protected static final Double f = Double.valueOf(-1.0d);
    protected static String g = "yyyy-MM-dd HH:mm:ss";
    @SuppressLint({"SimpleDateFormat"})
    protected SimpleDateFormat a = new SimpleDateFormat(g);
    protected String b;
    protected String c;
    protected Map<String, String> d;
    protected Map<String, Double> e;

    protected h20(String str, String str2) {
        if (str == null || str2 == null) {
            throw new IllegalArgumentException();
        }
        this.c = str2;
        this.b = c(str);
    }

    private static String c(String str) {
        return "DataLab-" + str;
    }

    /* access modifiers changed from: protected */
    public void a(Set<String> set, Set<String> set2) {
        MeasureSet measureSet;
        if (set2 == null || set2.isEmpty()) {
            throw new IllegalArgumentException("data lab doRegister fail. values is empty");
        }
        if (!set2.isEmpty()) {
            measureSet = MeasureSet.create(set2);
        } else {
            measureSet = MeasureSet.create().addMeasure("_v");
        }
        if (set == null || set.isEmpty()) {
            AppMonitor.register(this.b, this.c, measureSet, true);
            return;
        }
        set.add("uploadTime");
        AppMonitor.register(this.b, this.c, measureSet, DimensionSet.create(set), true);
    }

    /* access modifiers changed from: protected */
    public void b(DimensionValueSet dimensionValueSet, MeasureValueSet measureValueSet) {
        Map<String, String> map = this.d;
        if (map != null && !map.isEmpty()) {
            if (dimensionValueSet == null) {
                dimensionValueSet = DimensionValueSet.create();
            }
            for (Map.Entry<String, String> entry : this.d.entrySet()) {
                dimensionValueSet.setValue(entry.getKey(), entry.getValue());
            }
        }
        if (measureValueSet == null) {
            measureValueSet = MeasureValueSet.create();
        }
        Map<String, Double> map2 = this.e;
        if (map2 != null && !map2.isEmpty()) {
            for (Map.Entry<String, Double> entry2 : this.e.entrySet()) {
                measureValueSet.setValue(entry2.getKey(), entry2.getValue().doubleValue());
            }
        }
        if (measureValueSet.isEmpty()) {
            measureValueSet.setValue("_v", 0.0d);
        }
        if (dimensionValueSet != null) {
            String str = null;
            try {
                str = this.a.format(new Date());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (str == null || str.length() <= 0) {
                dimensionValueSet.setValue("uploadTime", "-");
            } else {
                dimensionValueSet.setValue("uploadTime", str);
            }
        }
        AppMonitor.Stat.commit(this.b, this.c, dimensionValueSet, measureValueSet);
        try {
            Map<String, MeasureValue> map3 = measureValueSet.getMap();
            if (map3 != null) {
                ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
                HashSet<String> hashSet = new HashSet();
                hashSet.addAll(map3.keySet());
                for (String str2 : hashSet) {
                    MeasureValue measureValue = map3.get(str2);
                    if (measureValue != null) {
                        concurrentHashMap.put(str2, Double.valueOf(measureValue.getValue()));
                    }
                }
                List<DatalabMetricListener> b2 = s20.a().b();
                if (b2 != null && b2.size() > 0) {
                    for (DatalabMetricListener datalabMetricListener : b2) {
                        try {
                            datalabMetricListener.dataCommit(this.b, this.c, dimensionValueSet.getMap(), concurrentHashMap);
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                    }
                }
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public T d(String str, String str2) {
        if (!(str == null || str2 == null)) {
            if (this.d == null) {
                this.d = new HashMap();
            }
            this.d.put(str, str2);
        }
        return this;
    }

    public T e(String str, Double d2) {
        if (!(str == null || d2 == null)) {
            if (this.e == null) {
                this.e = new HashMap();
            }
            this.e.put(str, d2);
        }
        return this;
    }
}
