package mtopsdk.mtop.stat;

import com.alibaba.mtl.appmonitor.AppMonitor;
import com.alibaba.mtl.appmonitor.model.DimensionSet;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.MeasureSet;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import java.util.Map;
import java.util.Set;
import mtopsdk.common.util.TBSdkLog;

/* compiled from: Taobao */
public class UploadStatAppMonitorImpl implements IUploadStats {
    private static final String TAG = "mtopsdk.UploadStatImpl";
    private static boolean mAppMonitorValid;

    public UploadStatAppMonitorImpl() {
        try {
            mAppMonitorValid = true;
        } catch (Throwable unused) {
            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.ErrorEnable)) {
                TBSdkLog.e(TAG, "didn't find app-monitor-sdk or ut-analytics sdk.");
            }
        }
    }

    @Override // mtopsdk.mtop.stat.IUploadStats
    public void onCommit(String str, String str2, Map<String, String> map, Map<String, Double> map2) {
        DimensionValueSet dimensionValueSet;
        if (mAppMonitorValid) {
            MeasureValueSet measureValueSet = null;
            if (map != null) {
                try {
                    dimensionValueSet = DimensionValueSet.create();
                    dimensionValueSet.setMap(map);
                } catch (Throwable th) {
                    if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.ErrorEnable)) {
                        TBSdkLog.e(TAG, "call AppMonitor.onCommit error.", th);
                        return;
                    }
                    return;
                }
            } else {
                dimensionValueSet = null;
            }
            if (map2 != null) {
                measureValueSet = MeasureValueSet.create();
                for (Map.Entry<String, Double> entry : map2.entrySet()) {
                    measureValueSet.setValue(entry.getKey(), entry.getValue().doubleValue());
                }
            }
            AppMonitor.Stat.commit(str, str2, dimensionValueSet, measureValueSet);
        }
    }

    @Override // mtopsdk.mtop.stat.IUploadStats
    public void onRegister(String str, String str2, Set<String> set, Set<String> set2, boolean z) {
        DimensionSet dimensionSet;
        if (mAppMonitorValid) {
            MeasureSet measureSet = null;
            if (set != null) {
                try {
                    dimensionSet = DimensionSet.create(set);
                } catch (Throwable th) {
                    if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.ErrorEnable)) {
                        TBSdkLog.e(TAG, "call AppMonitor.register error.", th);
                        return;
                    }
                    return;
                }
            } else {
                dimensionSet = null;
            }
            if (set2 != null) {
                measureSet = MeasureSet.create(set2);
            }
            AppMonitor.register(str, str2, measureSet, dimensionSet, z);
        }
    }
}
