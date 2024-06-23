package tb;

import com.alibaba.mtl.appmonitor.AppMonitor;
import com.alibaba.mtl.appmonitor.model.DimensionSet;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.MeasureSet;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;

/* compiled from: Taobao */
public class d11 {
    public static final int MATCHED = 0;
    public static final int MATCH_PEA_CONTROL = 3;
    public static final int MATCH_POD_CONTROL = 2;
    public static final int NOT_MATCH_CONDITION = 1;
    private static boolean a = true;

    static {
        try {
            DimensionSet create = DimensionSet.create();
            create.addDimension(if1.DIMEN_VERSION);
            create.addDimension(if1.DIMEN_BIZ);
            create.addDimension("errorCode");
            AppMonitor.register(if1.MODULE_NAME, if1.POINT_UPDATE, (MeasureSet) null, create);
            DimensionSet create2 = DimensionSet.create();
            create2.addDimension(if1.DIMEN_VERSION);
            create2.addDimension(if1.DIMEN_POD_VERSION);
            create2.addDimension(if1.DIMEN_BIZ);
            create2.addDimension("etag");
            create2.addDimension("errorCode");
            AppMonitor.register(if1.MODULE_NAME, if1.POINT_MATCH, (MeasureSet) null, create2);
            DimensionSet create3 = DimensionSet.create();
            create3.addDimension(if1.DIMEN_VERSION);
            create3.addDimension(if1.DIMEN_POD_VERSION);
            create3.addDimension(if1.DIMEN_BIZ);
            create3.addDimension("etag");
            create3.addDimension("errorCode");
            AppMonitor.register(if1.MODULE_NAME, if1.POINT_ERROR, (MeasureSet) null, create3);
        } catch (Throwable unused) {
        }
    }

    public static void a(String str, String str2, String str3, int i, String str4) {
        if (a) {
            DimensionValueSet create = DimensionValueSet.create();
            create.setValue(if1.DIMEN_VERSION, str);
            create.setValue(if1.DIMEN_POD_VERSION, str3);
            create.setValue(if1.DIMEN_BIZ, str2);
            create.setValue("errorCode", String.valueOf(i));
            create.setValue("etag", str4);
            AppMonitor.Stat.commit(if1.MODULE_NAME, if1.POINT_ERROR, create, MeasureValueSet.create());
        }
    }

    public static void b(String str, String str2, String str3, int i, String str4) {
        if (a) {
            DimensionValueSet create = DimensionValueSet.create();
            create.setValue(if1.DIMEN_VERSION, str);
            create.setValue(if1.DIMEN_POD_VERSION, str3);
            create.setValue(if1.DIMEN_BIZ, str2);
            create.setValue("errorCode", String.valueOf(i));
            create.setValue("etag", str4);
            AppMonitor.Stat.commit(if1.MODULE_NAME, if1.POINT_MATCH, create, MeasureValueSet.create());
        }
    }

    public static void c(String str, int i) {
        if (a) {
            DimensionValueSet create = DimensionValueSet.create();
            create.setValue(if1.DIMEN_VERSION, str);
            create.setValue(if1.DIMEN_BIZ, "slider");
            create.setValue("errorCode", String.valueOf(i));
            AppMonitor.Stat.commit(if1.MODULE_NAME, if1.POINT_UPDATE, create, MeasureValueSet.create());
        }
    }
}
