package tb;

import android.util.Log;
import com.alibaba.mtl.appmonitor.AppMonitor;
import com.alibaba.mtl.appmonitor.AppMonitorStatTable;
import com.alibaba.mtl.appmonitor.model.DimensionSet;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.MeasureSet;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import com.taobao.alivfsadapter.AVFSSDKAppMonitor;

/* compiled from: Taobao */
public class l0 implements AVFSSDKAppMonitor {
    private final AppMonitorStatTable a;

    public l0() {
        AppMonitorStatTable appMonitorStatTable = new AppMonitorStatTable("AliVfsSDK", "Cache");
        this.a = appMonitorStatTable;
        MeasureSet create = MeasureSet.create();
        create.addMeasure("DiskCost");
        DimensionSet create2 = DimensionSet.create();
        create2.addDimension("Cache");
        create2.addDimension("Module");
        create2.addDimension("Operation");
        create2.addDimension("HitMemory");
        create2.addDimension("MemoryCache");
        appMonitorStatTable.registerRowAndColumn(create2, create, false);
    }

    public static String a(String str) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case 114126:
                if (str.equals(lf1.CACHE_SQL)) {
                    c = 0;
                    break;
                }
                break;
            case 3143036:
                if (str.equals("file")) {
                    c = 1;
                    break;
                }
                break;
            case 3355087:
                if (str.equals(lf1.CACHE_MMAP)) {
                    c = 2;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return "SQLiteCache";
            case 1:
                return "FileCache";
            case 2:
                return "MmapCache";
            default:
                throw new IllegalArgumentException("Unknown URL: " + str);
        }
    }

    public static String b(String str, String str2) {
        return a(str) + c(str2);
    }

    public static String c(String str) {
        str.hashCode();
        if (str.equals(lf1.OPERATION_READ)) {
            return "Read";
        }
        if (str.equals(lf1.OPERATION_WRITE)) {
            return "Write";
        }
        throw new IllegalArgumentException("Unknown URL: " + str);
    }

    @Override // com.taobao.alivfsadapter.AVFSSDKAppMonitor
    public void hitMemoryCacheForModule(String str, boolean z) {
        if (z) {
            AppMonitor.Alarm.commitSuccess("AliVfsSDK", "MemoryCacheHitRate", str);
        } else {
            AppMonitor.Alarm.commitFail("AliVfsSDK", "MemoryCacheHitRate", str, null, null);
        }
    }

    @Override // com.taobao.alivfsadapter.AVFSSDKAppMonitor
    public void writeEvent(lf1 lf1) {
        try {
            String b = b(lf1.b, lf1.e);
            int i = lf1.d;
            if (i == 0) {
                AppMonitor.Alarm.commitSuccess("AliVfsSDK", b, lf1.a);
                DimensionValueSet create = DimensionValueSet.create();
                create.setValue("Cache", lf1.b);
                create.setValue("Module", lf1.a);
                create.setValue("Operation", lf1.e);
                create.setValue("HitMemory", String.valueOf(lf1.g));
                create.setValue("MemoryCache", String.valueOf(lf1.f));
                MeasureValueSet create2 = MeasureValueSet.create();
                create2.setValue("DiskCost", (double) lf1.h);
                this.a.update(create, create2);
                AppMonitor.Stat.commit("AliVfsSDK", "Cache", create, create2);
                return;
            }
            AppMonitor.Alarm.commitFail("AliVfsSDK", b, lf1.a, String.valueOf(i), lf1.c);
        } catch (Exception e) {
            Log.e("AVFSSDKAppMonitorImpl", e.getMessage(), e);
        }
    }
}
