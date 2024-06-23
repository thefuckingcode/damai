package com.taobao.accs.asp;

import com.alibaba.mtl.appmonitor.AppMonitor;
import com.alibaba.mtl.appmonitor.model.DimensionSet;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.MeasureSet;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import com.taobao.accs.utl.ALog;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class StatMonitor {
    private static final String MODULE_NAME = "APreferences";
    private static final String TAG = "StatMonitor";
    private static boolean isAppMonitorValid = true;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class IpcStat {
        private static final String DIMENSION_RESULT = "result";
        private static final String DIMENSION_TYPE = "type";
        private static final String MEASURE_COST_TIME = "costTime";
        private static final String MONITOR_POINT = "ipcStat";
        private static boolean isRegistered;
        long costTime;
        int result;
        final int type;

        IpcStat(int i) {
            this.type = i;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private boolean register() {
            if (!StatMonitor.isAppMonitorValid) {
                return false;
            }
            synchronized (this) {
                if (isRegistered) {
                    return true;
                }
                try {
                    DimensionSet create = DimensionSet.create();
                    create.addDimension("type");
                    create.addDimension("result");
                    MeasureSet create2 = MeasureSet.create();
                    create2.addMeasure("costTime");
                    AppMonitor.register(StatMonitor.MODULE_NAME, MONITOR_POINT, create2, create, true);
                    isRegistered = true;
                } catch (Exception e) {
                    ALog.e(StatMonitor.TAG, "[IpcStat][register]register fail.", e, new Object[0]);
                }
                return isRegistered;
            }
        }

        /* access modifiers changed from: package-private */
        public void commit() {
            if (StatMonitor.isAppMonitorValid) {
                AThreadPool.submitSingleTask(new Runnable() {
                    /* class com.taobao.accs.asp.StatMonitor.IpcStat.AnonymousClass1 */

                    public void run() {
                        if (IpcStat.this.register()) {
                            ALog.i(StatMonitor.TAG, "[commit]", "IpcStat", IpcStat.this.toString());
                            try {
                                DimensionValueSet create = DimensionValueSet.create();
                                create.setValue("type", String.valueOf(IpcStat.this.type));
                                create.setValue("result", String.valueOf(IpcStat.this.result));
                                MeasureValueSet create2 = MeasureValueSet.create();
                                create2.setValue("costTime", (double) IpcStat.this.costTime);
                                AppMonitor.Stat.commit(StatMonitor.MODULE_NAME, IpcStat.MONITOR_POINT, create, create2);
                            } catch (Exception e) {
                                ALog.e(StatMonitor.TAG, "[IpcStat][commit]commit fail.", e, new Object[0]);
                            }
                        }
                    }
                });
            }
        }

        public String toString() {
            return "[IpcStat]" + "type" + "=" + this.type + "," + "result" + "=" + this.result + "," + "costTime" + "=" + this.costTime;
        }
    }

    /* compiled from: Taobao */
    static class Performance {
        private static final String DIMENSION_NAME = "name";
        private static final String DIMENSION_RESULT = "result";
        private static final String DIMENSION_TYPE = "type";
        private static final String MEASURE_COST_TIME = "costTime";
        private static final String MONITOR_POINT = "performance";
        private static boolean isRegistered;
        long costTime;
        String name;
        int result;
        int type;

        Performance(String str, int i) {
            this.name = str;
            this.type = i;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private boolean register() {
            if (!StatMonitor.isAppMonitorValid) {
                return false;
            }
            synchronized (this) {
                if (isRegistered) {
                    return true;
                }
                try {
                    DimensionSet create = DimensionSet.create();
                    create.addDimension("name");
                    create.addDimension("type");
                    create.addDimension("result");
                    MeasureSet create2 = MeasureSet.create();
                    create2.addMeasure("costTime");
                    AppMonitor.register(StatMonitor.MODULE_NAME, "performance", create2, create, true);
                    isRegistered = true;
                } catch (Exception e) {
                    ALog.e(StatMonitor.TAG, "[Performance][register]register fail.", e, new Object[0]);
                }
                return isRegistered;
            }
        }

        /* access modifiers changed from: package-private */
        public void commit() {
            if (StatMonitor.isAppMonitorValid) {
                AThreadPool.submitSingleTask(new Runnable() {
                    /* class com.taobao.accs.asp.StatMonitor.Performance.AnonymousClass1 */

                    public void run() {
                        if (Performance.this.register()) {
                            ALog.i(StatMonitor.TAG, "[commit]", "Performance", Performance.this.toString());
                            try {
                                DimensionValueSet create = DimensionValueSet.create();
                                create.setValue("name", Performance.this.name);
                                create.setValue("type", String.valueOf(Performance.this.type));
                                create.setValue("result", String.valueOf(Performance.this.result));
                                MeasureValueSet create2 = MeasureValueSet.create();
                                create2.setValue("costTime", (double) Performance.this.costTime);
                                AppMonitor.Stat.commit(StatMonitor.MODULE_NAME, "performance", create, create2);
                            } catch (Exception e) {
                                ALog.e(StatMonitor.TAG, "[Performance][commit]commit fail.", e, new Object[0]);
                            }
                        }
                    }
                });
            }
        }

        public String toString() {
            return "[Performance]" + "name" + "=" + this.name + "," + "type" + "=" + this.type + "," + "result" + "=" + this.result + "," + "costTime" + "=" + this.costTime;
        }
    }

    /* compiled from: Taobao */
    static class SizeAlarm {
        static final long ALARM_SIZE = 5120;
        private static final String DIMENSION_KEY = "key";
        private static final String DIMENSION_NAME = "name";
        private static final String DIMENSION_VALUE = "value";
        private static final String MEASURE_KEY_SIZE = "keySize";
        private static final String MEASURE_VALUE_SIZE = "valueSize";
        private static final String MONITOR_POINT = "sizeAlarm";
        private static boolean isRegistered;
        String key;
        long keySize;
        String name;
        String value;
        long valueSize;

        SizeAlarm(String str) {
            this.name = str;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private boolean register() {
            if (!StatMonitor.isAppMonitorValid) {
                return false;
            }
            synchronized (this) {
                if (isRegistered) {
                    return true;
                }
                try {
                    DimensionSet create = DimensionSet.create();
                    create.addDimension("name");
                    create.addDimension("key");
                    create.addDimension("value");
                    MeasureSet create2 = MeasureSet.create();
                    create2.addMeasure(MEASURE_KEY_SIZE);
                    create2.addMeasure(MEASURE_VALUE_SIZE);
                    AppMonitor.register(StatMonitor.MODULE_NAME, MONITOR_POINT, create2, create, true);
                    isRegistered = true;
                } catch (Exception e) {
                    ALog.e(StatMonitor.TAG, "[IpcStat][register]register fail.", e, new Object[0]);
                }
                return isRegistered;
            }
        }

        /* access modifiers changed from: package-private */
        public void commit() {
            if (StatMonitor.isAppMonitorValid) {
                AThreadPool.submitSingleTask(new Runnable() {
                    /* class com.taobao.accs.asp.StatMonitor.SizeAlarm.AnonymousClass1 */

                    public void run() {
                        if (SizeAlarm.this.register()) {
                            ALog.i(StatMonitor.TAG, "[commit]", "SizeAlarm", SizeAlarm.this.toString());
                            try {
                                DimensionValueSet create = DimensionValueSet.create();
                                create.setValue("name", SizeAlarm.this.name);
                                create.setValue("key", SizeAlarm.this.key);
                                create.setValue("value", SizeAlarm.this.value);
                                MeasureValueSet create2 = MeasureValueSet.create();
                                create2.setValue(SizeAlarm.MEASURE_KEY_SIZE, (double) SizeAlarm.this.keySize);
                                create2.setValue(SizeAlarm.MEASURE_VALUE_SIZE, (double) SizeAlarm.this.valueSize);
                                AppMonitor.Stat.commit(StatMonitor.MODULE_NAME, SizeAlarm.MONITOR_POINT, create, create2);
                            } catch (Exception e) {
                                ALog.e(StatMonitor.TAG, "[IpcStat][commit]commit fail.", e, new Object[0]);
                            }
                        }
                    }
                });
            }
        }

        public String toString() {
            return "[SizeAlarm]" + "name" + "=" + this.name + "," + "key" + "=" + this.key + "," + "value" + "=" + this.value + "," + MEASURE_KEY_SIZE + "=" + this.keySize + "," + MEASURE_VALUE_SIZE + "=" + this.valueSize;
        }
    }

    StatMonitor() {
    }
}
