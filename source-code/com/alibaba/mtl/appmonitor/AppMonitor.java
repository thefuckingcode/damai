package com.alibaba.mtl.appmonitor;

import android.app.Application;
import android.os.RemoteException;
import android.text.TextUtils;
import com.alibaba.analytics.AnalyticsMgr;
import com.alibaba.analytics.IAnalytics;
import com.alibaba.analytics.utils.Logger;
import com.alibaba.appmonitor.event.EventType;
import com.alibaba.mtl.appmonitor.model.DimensionSet;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.MeasureSet;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import java.util.Map;

/* compiled from: Taobao */
public final class AppMonitor {
    private static final String TAG = "AppMonitor";

    @Deprecated
    /* compiled from: Taobao */
    public static class OffLineCounter {
        public static boolean checkSampled(String str, String str2) {
            return false;
        }

        public static void commit(String str, String str2, double d) {
            Counter.commit(str, str2, d);
        }

        public static void setSampling(int i) {
        }

        public static void setStatisticsInterval(int i) {
        }
    }

    /* compiled from: Taobao */
    public static class Stat {
        public static void begin(final String str, final String str2, final String str3) {
            if (AppMonitor.checkInit()) {
                AnalyticsMgr.d.a(new Runnable() {
                    /* class com.alibaba.mtl.appmonitor.AppMonitor.Stat.AnonymousClass3 */

                    public void run() {
                        try {
                            AnalyticsMgr.b.stat_begin(str, str2, str3);
                        } catch (RemoteException e) {
                            AnalyticsMgr.L(e);
                        }
                    }
                });
            }
        }

        public static boolean checkSampled(String str, String str2) {
            IAnalytics iAnalytics = AnalyticsMgr.b;
            if (iAnalytics == null) {
                return false;
            }
            try {
                return iAnalytics.stat_checkSampled(str, str2);
            } catch (RemoteException unused) {
                return false;
            }
        }

        public static void commit(String str, String str2, double d) {
            commit(str, str2, (DimensionValueSet) null, d);
        }

        public static Transaction createTransaction(String str, String str2) {
            return createTransaction(str, str2, null);
        }

        public static void end(final String str, final String str2, final String str3) {
            if (AppMonitor.checkInit()) {
                AnalyticsMgr.d.a(new Runnable() {
                    /* class com.alibaba.mtl.appmonitor.AppMonitor.Stat.AnonymousClass4 */

                    public void run() {
                        try {
                            AnalyticsMgr.b.stat_end(str, str2, str3);
                        } catch (RemoteException e) {
                            AnalyticsMgr.L(e);
                        }
                    }
                });
            }
        }

        public static void setSampling(final int i) {
            if (AppMonitor.checkInit()) {
                AnalyticsMgr.d.a(new Runnable() {
                    /* class com.alibaba.mtl.appmonitor.AppMonitor.Stat.AnonymousClass2 */

                    public void run() {
                        try {
                            AnalyticsMgr.b.stat_setSampling(i);
                        } catch (RemoteException e) {
                            AnalyticsMgr.L(e);
                        }
                    }
                });
            }
        }

        public static void setStatisticsInterval(final int i) {
            if (AppMonitor.checkInit()) {
                AnalyticsMgr.d.a(new Runnable() {
                    /* class com.alibaba.mtl.appmonitor.AppMonitor.Stat.AnonymousClass1 */

                    public void run() {
                        try {
                            AnalyticsMgr.b.stat_setStatisticsInterval(i);
                        } catch (RemoteException e) {
                            AnalyticsMgr.L(e);
                        }
                    }
                });
            }
        }

        public static void commit(final String str, final String str2, final DimensionValueSet dimensionValueSet, final double d) {
            if (AppMonitor.checkInit()) {
                AnalyticsMgr.d.a(new Runnable() {
                    /* class com.alibaba.mtl.appmonitor.AppMonitor.Stat.AnonymousClass5 */

                    public void run() {
                        try {
                            AnalyticsMgr.b.stat_commit2(str, str2, dimensionValueSet, d);
                        } catch (RemoteException e) {
                            AnalyticsMgr.L(e);
                        }
                    }
                });
            }
        }

        public static Transaction createTransaction(String str, String str2, DimensionValueSet dimensionValueSet) {
            return new Transaction(Integer.valueOf(EventType.STAT.getEventId()), str, str2, dimensionValueSet);
        }

        public static void commit(final String str, final String str2, final DimensionValueSet dimensionValueSet, final MeasureValueSet measureValueSet) {
            if (AppMonitor.checkInit()) {
                AnalyticsMgr.d.a(new Runnable() {
                    /* class com.alibaba.mtl.appmonitor.AppMonitor.Stat.AnonymousClass6 */

                    public void run() {
                        try {
                            AnalyticsMgr.b.stat_commit3(str, str2, dimensionValueSet, measureValueSet);
                        } catch (RemoteException e) {
                            AnalyticsMgr.L(e);
                        }
                    }
                });
            }
        }

        public static void commit(String str, String str2, String[] strArr, String[] strArr2, String[] strArr3, String[] strArr4) {
            DimensionValueSet dimensionValueSet;
            Logger.f("[commit from jni]", new Object[0]);
            MeasureValueSet measureValueSet = null;
            if (strArr == null || strArr2 == null || strArr.length != strArr2.length) {
                dimensionValueSet = null;
            } else {
                dimensionValueSet = DimensionValueSet.create();
                for (int i = 0; i < strArr2.length; i++) {
                    dimensionValueSet.setValue(strArr[i], strArr2[i]);
                }
            }
            if (strArr3 == null || strArr4 == null || strArr3.length != strArr4.length) {
                Logger.f("measure is null ,or lenght not match", new Object[0]);
            } else {
                measureValueSet = MeasureValueSet.create();
                for (int i2 = 0; i2 < strArr4.length; i2++) {
                    double d = 0.0d;
                    if (!TextUtils.isEmpty(strArr4[i2])) {
                        try {
                            d = Double.valueOf(strArr4[i2]).doubleValue();
                        } catch (Exception unused) {
                            Logger.f("measure's value cannot convert to double. measurevalue:" + strArr4[i2], new Object[0]);
                        }
                    }
                    measureValueSet.setValue(strArr3[i2], d);
                }
            }
            commit(str, str2, dimensionValueSet, measureValueSet);
        }
    }

    private static void addRegisterEntity(String str, String str2, MeasureSet measureSet, DimensionSet dimensionSet, boolean z) {
        try {
            AnalyticsMgr.b bVar = new AnalyticsMgr.b();
            bVar.a = str;
            bVar.b = str2;
            bVar.c = measureSet;
            bVar.d = dimensionSet;
            bVar.e = z;
            AnalyticsMgr.mRegisterList.add(bVar);
        } catch (Throwable unused) {
        }
    }

    /* access modifiers changed from: private */
    public static boolean checkInit() {
        if (!AnalyticsMgr.g) {
            Logger.f("AppMonitor", "Please call init() before call other method");
        }
        return AnalyticsMgr.g;
    }

    private static Runnable createRegisterTask(final String str, final String str2, final MeasureSet measureSet, final DimensionSet dimensionSet, final boolean z) {
        return new Runnable() {
            /* class com.alibaba.mtl.appmonitor.AppMonitor.AnonymousClass9 */

            public void run() {
                try {
                    Logger.f("AppMonitor", "register stat event. module: ", str, " monitorPoint: ", str2);
                    AnalyticsMgr.b.register4(str, str2, measureSet, dimensionSet, z);
                } catch (RemoteException e) {
                    AnalyticsMgr.L(e);
                }
            }
        };
    }

    @Deprecated
    public static synchronized void destroy() {
        synchronized (AppMonitor.class) {
        }
    }

    public static void enableLog(final boolean z) {
        if (checkInit()) {
            AnalyticsMgr.d.a(new Runnable() {
                /* class com.alibaba.mtl.appmonitor.AppMonitor.AnonymousClass3 */

                public void run() {
                    try {
                        AnalyticsMgr.b.enableLog(z);
                    } catch (RemoteException e) {
                        AnalyticsMgr.L(e);
                    }
                }
            });
        }
    }

    private static int getEvent(EventType eventType) {
        return eventType.getEventId();
    }

    public static String getGlobalProperty(String str) {
        return AnalyticsMgr.I(str);
    }

    @Deprecated
    public static synchronized void init(Application application) {
        synchronized (AppMonitor.class) {
            AnalyticsMgr.M(application);
        }
    }

    public static void register(final String str, final String str2, final MeasureSet measureSet) {
        if (checkInit()) {
            AnalyticsMgr.d.a(new Runnable() {
                /* class com.alibaba.mtl.appmonitor.AppMonitor.AnonymousClass4 */

                public void run() {
                    try {
                        AnalyticsMgr.b.register1(str, str2, measureSet);
                    } catch (RemoteException e) {
                        AnalyticsMgr.L(e);
                    }
                }
            });
            addRegisterEntity(str, str2, measureSet, null, false);
        }
    }

    private static void registerInternal(String str, String str2, MeasureSet measureSet, DimensionSet dimensionSet, boolean z, boolean z2) {
        if (checkInit()) {
            Logger.f("AppMonitor", "[registerInternal] : module:", str, "monitorPoint:", str2, "measures:", measureSet, "dimensions:", dimensionSet, "isCommitDetail:", Boolean.valueOf(z), "isInternal:", Boolean.valueOf(z2));
            if (!z2) {
                addRegisterEntity(str, str2, measureSet, dimensionSet, z);
            }
            AnalyticsMgr.d.a(createRegisterTask(str, str2, measureSet, dimensionSet, z));
        }
    }

    public static void removeGlobalProperty(String str) {
        AnalyticsMgr.Q(str);
    }

    @Deprecated
    public static void setChannel(String str) {
        AnalyticsMgr.U(str);
    }

    public static void setGlobalProperty(String str, String str2) {
        AnalyticsMgr.W(str, str2);
    }

    @Deprecated
    public static void setRequestAuthInfo(boolean z, String str, String str2) {
        throw new RuntimeException("this interface is deprecated after sdk version 6.3.0，please call Analytics.getInstance().setAppApplicationInstance(Application application,IUTApplication utcallback) ");
    }

    public static void setSampling(final int i) {
        if (checkInit()) {
            AnalyticsMgr.d.a(new Runnable() {
                /* class com.alibaba.mtl.appmonitor.AppMonitor.AnonymousClass2 */

                public void run() {
                    try {
                        AnalyticsMgr.b.setSampling(i);
                    } catch (RemoteException e) {
                        AnalyticsMgr.L(e);
                    }
                }
            });
        }
    }

    public static void setStatisticsInterval(final int i) {
        if (checkInit()) {
            AnalyticsMgr.d.a(new Runnable() {
                /* class com.alibaba.mtl.appmonitor.AppMonitor.AnonymousClass1 */

                public void run() {
                    try {
                        AnalyticsMgr.b.setStatisticsInterval1(i);
                    } catch (RemoteException e) {
                        AnalyticsMgr.L(e);
                    }
                }
            });
        }
    }

    @Deprecated
    public static synchronized void triggerUpload() {
        synchronized (AppMonitor.class) {
        }
    }

    @Deprecated
    public static void turnOffRealTimeDebug() {
        AnalyticsMgr.a0();
    }

    @Deprecated
    public static void turnOnRealTimeDebug(Map<String, String> map) {
        AnalyticsMgr.c0(map);
    }

    public static void updateMeasure(final String str, final String str2, final String str3, final double d, final double d2, final double d3) {
        Logger.f("AppMonitor", "[updateMeasure]");
        if (checkInit()) {
            AnalyticsMgr.d.post(new Runnable() {
                /* class com.alibaba.mtl.appmonitor.AppMonitor.AnonymousClass7 */

                public void run() {
                    try {
                        AnalyticsMgr.b.updateMeasure(str, str2, str3, d, d2, d3);
                    } catch (RemoteException e) {
                        AnalyticsMgr.L(e);
                    }
                }
            });
        }
    }

    /* compiled from: Taobao */
    public static class Alarm {
        @Deprecated
        public static boolean checkSampled(String str, String str2) {
            IAnalytics iAnalytics = AnalyticsMgr.b;
            if (iAnalytics == null) {
                return false;
            }
            try {
                return iAnalytics.alarm_checkSampled(str, str2);
            } catch (RemoteException unused) {
                return false;
            }
        }

        public static void commitFail(final String str, final String str2, final String str3, final String str4) {
            if (AppMonitor.checkInit()) {
                AnalyticsMgr.d.a(new Runnable() {
                    /* class com.alibaba.mtl.appmonitor.AppMonitor.Alarm.AnonymousClass5 */

                    public void run() {
                        try {
                            AnalyticsMgr.b.alarm_commitFail1(str, str2, str3, str4);
                        } catch (RemoteException e) {
                            AnalyticsMgr.L(e);
                        }
                    }
                });
            }
        }

        public static void commitSuccess(final String str, final String str2) {
            if (AppMonitor.checkInit()) {
                AnalyticsMgr.d.a(new Runnable() {
                    /* class com.alibaba.mtl.appmonitor.AppMonitor.Alarm.AnonymousClass3 */

                    public void run() {
                        try {
                            AnalyticsMgr.b.alarm_commitSuccess1(str, str2);
                        } catch (RemoteException e) {
                            AnalyticsMgr.L(e);
                        }
                    }
                });
            }
        }

        public static void setSampling(final int i) {
            if (AppMonitor.checkInit()) {
                AnalyticsMgr.d.a(new Runnable() {
                    /* class com.alibaba.mtl.appmonitor.AppMonitor.Alarm.AnonymousClass2 */

                    public void run() {
                        try {
                            AnalyticsMgr.b.alarm_setSampling(i);
                        } catch (RemoteException e) {
                            AnalyticsMgr.L(e);
                        }
                    }
                });
            }
        }

        public static void setStatisticsInterval(final int i) {
            if (AppMonitor.checkInit()) {
                AnalyticsMgr.d.a(new Runnable() {
                    /* class com.alibaba.mtl.appmonitor.AppMonitor.Alarm.AnonymousClass1 */

                    public void run() {
                        try {
                            AnalyticsMgr.b.alarm_setStatisticsInterval(i);
                        } catch (RemoteException e) {
                            AnalyticsMgr.L(e);
                        }
                    }
                });
            }
        }

        public static void commitFail(final String str, final String str2, final String str3, final String str4, final String str5) {
            if (AppMonitor.checkInit()) {
                AnalyticsMgr.d.a(new Runnable() {
                    /* class com.alibaba.mtl.appmonitor.AppMonitor.Alarm.AnonymousClass6 */

                    public void run() {
                        try {
                            AnalyticsMgr.b.alarm_commitFail2(str, str2, str3, str4, str5);
                        } catch (RemoteException e) {
                            AnalyticsMgr.L(e);
                        }
                    }
                });
            }
        }

        public static void commitSuccess(final String str, final String str2, final String str3) {
            if (AppMonitor.checkInit()) {
                AnalyticsMgr.d.a(new Runnable() {
                    /* class com.alibaba.mtl.appmonitor.AppMonitor.Alarm.AnonymousClass4 */

                    public void run() {
                        try {
                            AnalyticsMgr.b.alarm_commitSuccess2(str, str2, str3);
                        } catch (RemoteException e) {
                            AnalyticsMgr.L(e);
                        }
                    }
                });
            }
        }
    }

    /* compiled from: Taobao */
    public static class Counter {
        @Deprecated
        public static boolean checkSampled(String str, String str2) {
            IAnalytics iAnalytics = AnalyticsMgr.b;
            if (iAnalytics == null) {
                return false;
            }
            try {
                return iAnalytics.counter_checkSampled(str, str2);
            } catch (RemoteException unused) {
                return false;
            }
        }

        public static void commit(final String str, final String str2, final double d) {
            if (AppMonitor.checkInit()) {
                AnalyticsMgr.d.a(new Runnable() {
                    /* class com.alibaba.mtl.appmonitor.AppMonitor.Counter.AnonymousClass3 */

                    public void run() {
                        try {
                            AnalyticsMgr.b.counter_commit1(str, str2, d);
                        } catch (RemoteException e) {
                            AnalyticsMgr.L(e);
                        }
                    }
                });
            }
        }

        public static void setSampling(final int i) {
            if (AppMonitor.checkInit()) {
                AnalyticsMgr.d.a(new Runnable() {
                    /* class com.alibaba.mtl.appmonitor.AppMonitor.Counter.AnonymousClass2 */

                    public void run() {
                        try {
                            AnalyticsMgr.b.counter_setSampling(i);
                        } catch (RemoteException e) {
                            AnalyticsMgr.L(e);
                        }
                    }
                });
            }
        }

        public static void setStatisticsInterval(final int i) {
            if (AppMonitor.checkInit()) {
                AnalyticsMgr.d.a(new Runnable() {
                    /* class com.alibaba.mtl.appmonitor.AppMonitor.Counter.AnonymousClass1 */

                    public void run() {
                        try {
                            AnalyticsMgr.b.counter_setStatisticsInterval(i);
                        } catch (RemoteException e) {
                            AnalyticsMgr.L(e);
                        }
                    }
                });
            }
        }

        public static void commit(final String str, final String str2, final String str3, final double d) {
            if (AppMonitor.checkInit()) {
                AnalyticsMgr.d.a(new Runnable() {
                    /* class com.alibaba.mtl.appmonitor.AppMonitor.Counter.AnonymousClass4 */

                    public void run() {
                        try {
                            AnalyticsMgr.b.counter_commit2(str, str2, str3, d);
                        } catch (RemoteException e) {
                            AnalyticsMgr.L(e);
                        }
                    }
                });
            }
        }
    }

    public static void setStatisticsInterval(EventType eventType, final int i) {
        if (checkInit()) {
            final int event = getEvent(eventType);
            AnalyticsMgr.d.a(new Runnable() {
                /* class com.alibaba.mtl.appmonitor.AppMonitor.AnonymousClass8 */

                public void run() {
                    try {
                        AnalyticsMgr.b.setStatisticsInterval2(event, i);
                    } catch (RemoteException e) {
                        AnalyticsMgr.L(e);
                    }
                }
            });
        }
    }

    public static void register(final String str, final String str2, final MeasureSet measureSet, final boolean z) {
        if (checkInit()) {
            AnalyticsMgr.d.a(new Runnable() {
                /* class com.alibaba.mtl.appmonitor.AppMonitor.AnonymousClass5 */

                public void run() {
                    try {
                        AnalyticsMgr.b.register2(str, str2, measureSet, z);
                    } catch (RemoteException e) {
                        AnalyticsMgr.L(e);
                    }
                }
            });
            addRegisterEntity(str, str2, measureSet, null, z);
        }
    }

    public static void register(final String str, final String str2, final MeasureSet measureSet, final DimensionSet dimensionSet) {
        Logger.f("外注册任务被业务方调用", "module", str, "monitorPoint", str2);
        if (checkInit()) {
            AnalyticsMgr.d.a(new Runnable() {
                /* class com.alibaba.mtl.appmonitor.AppMonitor.AnonymousClass6 */

                public void run() {
                    try {
                        Logger.f("外注册任务开始执行", "module", str, "monitorPoint", str2);
                        AnalyticsMgr.b.register3(str, str2, measureSet, dimensionSet);
                    } catch (RemoteException e) {
                        AnalyticsMgr.L(e);
                    }
                }
            });
            addRegisterEntity(str, str2, measureSet, dimensionSet, false);
        }
    }

    public static void register(String str, String str2, MeasureSet measureSet, DimensionSet dimensionSet, boolean z) {
        if (checkInit()) {
            registerInternal(str, str2, measureSet, dimensionSet, z, false);
        }
    }

    public static void register(String str, String str2, String[] strArr, String[] strArr2, boolean z) {
        Logger.f("AppMonitor", "[c interface] module", str, "monitorPoint", str2);
        if (strArr != null) {
            MeasureSet create = MeasureSet.create();
            for (String str3 : strArr) {
                create.addMeasure(str3);
            }
            DimensionSet dimensionSet = null;
            if (strArr2 != null) {
                dimensionSet = DimensionSet.create();
                for (String str4 : strArr2) {
                    dimensionSet.addDimension(str4);
                }
            }
            register(str, str2, create, dimensionSet, z);
            return;
        }
        Logger.f("AppMonitor", "register failed:no measure");
    }
}
