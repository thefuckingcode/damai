package anet.channel.appmonitor;

import android.text.TextUtils;
import anet.channel.statist.Dimension;
import anet.channel.statist.Measure;
import anet.channel.statist.Monitor;
import anet.channel.statist.StatObject;
import anet.channel.thread.ThreadPoolExecutorFactory;
import anet.channel.util.ALog;
import com.alibaba.analytics.AnalyticsMgr;
import com.alibaba.mtl.appmonitor.AppMonitor;
import com.alibaba.mtl.appmonitor.model.DimensionSet;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.MeasureSet;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import tb.ag2;
import tb.ao;
import tb.e4;
import tb.sh1;

/* compiled from: Taobao */
public class DefaultAppMonitor implements IAppMonitor {
    private static boolean a;
    private static Map<Class<?>, List<Field>> b = new ConcurrentHashMap();
    private static Map<Class<?>, List<Field>> c = new ConcurrentHashMap();
    private static Map<Field, String> d = new ConcurrentHashMap();
    private static Random e = new Random();
    private static volatile boolean f = false;
    private static volatile boolean g = false;
    private static List<StatObject> h = new CopyOnWriteArrayList();
    private static List<e4> i = new CopyOnWriteArrayList();
    private static List<ao> j = new CopyOnWriteArrayList();
    private static Set<Class<?>> k = Collections.newSetFromMap(new ConcurrentHashMap());

    public DefaultAppMonitor() {
        try {
            a = true;
        } catch (Exception unused) {
            a = false;
        }
    }

    private boolean e() {
        if (f) {
            return true;
        }
        try {
            f = AnalyticsMgr.l();
            ALog.e("awcn.DefaultAppMonitor", "[checkAppMonitorInit]", null, "status", Boolean.valueOf(f));
        } catch (Throwable unused) {
            f = true;
        }
        return f;
    }

    private void f() {
        if (!g) {
            ThreadPoolExecutorFactory.h(new Runnable() {
                /* class anet.channel.appmonitor.DefaultAppMonitor.AnonymousClass1 */

                public void run() {
                    boolean unused = DefaultAppMonitor.g = true;
                    ALog.e("awcn.DefaultAppMonitor", "[flushWaitingMonitor]", null, new Object[0]);
                    for (StatObject statObject : DefaultAppMonitor.h) {
                        DefaultAppMonitor.this.commitStat(statObject);
                    }
                    for (e4 e4Var : DefaultAppMonitor.i) {
                        DefaultAppMonitor.this.commitAlarm(e4Var);
                    }
                    for (ao aoVar : DefaultAppMonitor.j) {
                        DefaultAppMonitor.this.commitCount(aoVar);
                    }
                }
            });
        }
    }

    @Override // anet.channel.appmonitor.IAppMonitor
    public void commitAlarm(e4 e4Var) {
        if (a && e4Var != null && !TextUtils.isEmpty(e4Var.e) && !TextUtils.isEmpty(e4Var.f)) {
            if (!e()) {
                i.add(e4Var);
                return;
            }
            f();
            if (ALog.g(1)) {
                ALog.c("awcn.DefaultAppMonitor", "commit alarm: " + e4Var, null, new Object[0]);
            }
            if (!e4Var.a) {
                AppMonitor.Alarm.commitFail(e4Var.e, e4Var.f, ag2.j(e4Var.b), ag2.j(e4Var.c), ag2.j(e4Var.d));
            } else {
                AppMonitor.Alarm.commitSuccess(e4Var.e, e4Var.f, ag2.j(e4Var.b));
            }
        }
    }

    @Override // anet.channel.appmonitor.IAppMonitor
    public void commitCount(ao aoVar) {
        if (a && aoVar != null && !TextUtils.isEmpty(aoVar.c) && !TextUtils.isEmpty(aoVar.d)) {
            if (!e()) {
                j.add(aoVar);
                return;
            }
            f();
            if (ALog.g(2)) {
                ALog.f("awcn.DefaultAppMonitor", "commit count: " + aoVar, null, new Object[0]);
            }
            AppMonitor.Counter.commit(aoVar.c, aoVar.d, ag2.j(aoVar.a), aoVar.b);
        }
    }

    @Override // anet.channel.appmonitor.IAppMonitor
    public void commitStat(StatObject statObject) {
        if (a && statObject != null) {
            if (!e()) {
                h.add(statObject);
                return;
            }
            f();
            Class<?> cls = statObject.getClass();
            Monitor monitor = (Monitor) cls.getAnnotation(Monitor.class);
            if (monitor != null) {
                if (!k.contains(cls)) {
                    g(cls);
                }
                if (statObject.beforeCommit()) {
                    if (monitor.monitorPoint().equals("network")) {
                        int c2 = sh1.c();
                        if (c2 > 10000 || c2 < 0) {
                            c2 = 10000;
                        }
                        if (c2 != 10000 && e.nextInt(10000) >= c2) {
                            return;
                        }
                    }
                    try {
                        DimensionValueSet create = DimensionValueSet.create();
                        MeasureValueSet create2 = MeasureValueSet.create();
                        List<Field> list = b.get(cls);
                        HashMap hashMap = ALog.g(1) ? new HashMap() : null;
                        if (list != null) {
                            for (Field field : list) {
                                Object obj = field.get(statObject);
                                create.setValue(d.get(field), obj == null ? "" : obj.toString());
                            }
                            for (Field field2 : c.get(cls)) {
                                Double valueOf = Double.valueOf(field2.getDouble(statObject));
                                create2.setValue(d.get(field2), valueOf.doubleValue());
                                if (hashMap != null) {
                                    hashMap.put(d.get(field2), valueOf);
                                }
                            }
                        }
                        AppMonitor.Stat.commit(monitor.module(), monitor.monitorPoint(), create, create2);
                        if (ALog.g(1)) {
                            ALog.c("awcn.DefaultAppMonitor", "commit stat: " + monitor.monitorPoint(), null, "\nDimensions", create.getMap().toString(), "\nMeasures", hashMap.toString());
                        }
                    } catch (Throwable th) {
                        ALog.d("awcn.DefaultAppMonitor", "commit monitor point failed", null, th, new Object[0]);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized void g(Class<?> cls) {
        if (cls != null) {
            if (a) {
                try {
                    if (!k.contains(cls)) {
                        Monitor monitor = (Monitor) cls.getAnnotation(Monitor.class);
                        if (monitor != null) {
                            Field[] fields = cls.getFields();
                            ArrayList arrayList = new ArrayList();
                            ArrayList arrayList2 = new ArrayList();
                            DimensionSet create = DimensionSet.create();
                            MeasureSet create2 = MeasureSet.create();
                            for (Field field : fields) {
                                Dimension dimension = (Dimension) field.getAnnotation(Dimension.class);
                                if (dimension != null) {
                                    field.setAccessible(true);
                                    arrayList.add(field);
                                    String name = dimension.name().equals("") ? field.getName() : dimension.name();
                                    d.put(field, name);
                                    create.addDimension(name);
                                } else {
                                    Measure measure = (Measure) field.getAnnotation(Measure.class);
                                    if (measure != null) {
                                        field.setAccessible(true);
                                        arrayList2.add(field);
                                        String name2 = measure.name().equals("") ? field.getName() : measure.name();
                                        d.put(field, name2);
                                        if (measure.max() != Double.MAX_VALUE) {
                                            create2.addMeasure(new com.alibaba.mtl.appmonitor.model.Measure(name2, Double.valueOf(measure.constantValue()), Double.valueOf(measure.min()), Double.valueOf(measure.max())));
                                        } else {
                                            create2.addMeasure(name2);
                                        }
                                    }
                                }
                            }
                            b.put(cls, arrayList);
                            c.put(cls, arrayList2);
                            AppMonitor.register(monitor.module(), monitor.monitorPoint(), create2, create);
                            k.add(cls);
                        }
                    }
                } catch (Exception e2) {
                    ALog.d("awcn.DefaultAppMonitor", "register fail", null, e2, new Object[0]);
                }
            }
        }
    }

    @Override // anet.channel.appmonitor.IAppMonitor
    @Deprecated
    public void register() {
    }

    @Override // anet.channel.appmonitor.IAppMonitor
    @Deprecated
    public void register(Class<?> cls) {
    }
}
