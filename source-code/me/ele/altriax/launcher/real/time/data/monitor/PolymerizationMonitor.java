package me.ele.altriax.launcher.real.time.data.monitor;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alibaba.mtl.appmonitor.AppMonitor;
import com.alibaba.mtl.appmonitor.model.DimensionSet;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.MeasureSet;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import me.ele.altriax.launcher.real.time.data.ColdLaunchRealTime;
import me.ele.altriax.launcher.real.time.data.ExternalLinkH5RealTime;
import me.ele.altriax.launcher.real.time.data.ExternalLinkHomeRealTime;

/* compiled from: Taobao */
public class PolymerizationMonitor {
    public static final String COLD = "cold";
    public static final String DIMENSION_LAUNCH_STYLE = "launchStyle";
    public static final String LINK_H5 = "linkH5";
    public static final String LINK_HOME = "linkHome";
    private static final String MODULE_NAME = "LaunchModule";
    private static final String POINT = "Cold";
    private static final String TAG = "PolymerizationMonitor";

    /* compiled from: Taobao */
    public static class IoDHHolder {
        private static final PolymerizationMonitor instance = new PolymerizationMonitor();
    }

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: Taobao */
    public @interface LaunchStyle {
    }

    public static PolymerizationMonitor getInstance() {
        return IoDHHolder.instance;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0075  */
    private void innerReport(@NonNull String str) {
        char c;
        Pair<DimensionValueSet, MeasureValueSet> pair;
        int hashCode = str.hashCode();
        if (hashCode != -1102667161) {
            if (hashCode != 3059428) {
                if (hashCode == 1193839609 && str.equals(LINK_HOME)) {
                    c = 3;
                    if (c != 2) {
                        ExternalLinkH5RealTime instance = ExternalLinkH5RealTime.getInstance();
                        if (instance != null && instance.getPageFinished() > 0) {
                            ExternalLinkH5Monitor instance2 = ExternalLinkH5Monitor.getInstance();
                            pair = instance2.getDimensionAndMeasure();
                            instance2.log(TAG);
                        } else {
                            return;
                        }
                    } else if (c != 3) {
                        ColdLaunchRealTime instance3 = ColdLaunchRealTime.getInstance();
                        if (instance3 != null && instance3.getRenderComplete() > 0) {
                            ColdLaunchMonitor instance4 = ColdLaunchMonitor.getInstance();
                            pair = instance4.getDimensionAndMeasure();
                            instance4.log(TAG);
                        } else {
                            return;
                        }
                    } else {
                        ExternalLinkHomeRealTime instance5 = ExternalLinkHomeRealTime.getInstance();
                        if (instance5 != null && instance5.getRenderComplete() > 0) {
                            ExternalLinkHomeMonitor instance6 = ExternalLinkHomeMonitor.getInstance();
                            pair = instance6.getDimensionAndMeasure();
                            instance6.log(TAG);
                        } else {
                            return;
                        }
                    }
                    DimensionValueSet dimensionValueSet = (DimensionValueSet) pair.first;
                    dimensionValueSet.setValue(DIMENSION_LAUNCH_STYLE, str);
                    AppMonitor.Stat.commit(MODULE_NAME, POINT, dimensionValueSet, (MeasureValueSet) pair.second);
                }
            } else if (str.equals(COLD)) {
                c = 1;
                if (c != 2) {
                }
                DimensionValueSet dimensionValueSet2 = (DimensionValueSet) pair.first;
                dimensionValueSet2.setValue(DIMENSION_LAUNCH_STYLE, str);
                AppMonitor.Stat.commit(MODULE_NAME, POINT, dimensionValueSet2, (MeasureValueSet) pair.second);
            }
        } else if (str.equals(LINK_H5)) {
            c = 2;
            if (c != 2) {
            }
            DimensionValueSet dimensionValueSet22 = (DimensionValueSet) pair.first;
            dimensionValueSet22.setValue(DIMENSION_LAUNCH_STYLE, str);
            AppMonitor.Stat.commit(MODULE_NAME, POINT, dimensionValueSet22, (MeasureValueSet) pair.second);
        }
        c = 65535;
        if (c != 2) {
        }
        DimensionValueSet dimensionValueSet222 = (DimensionValueSet) pair.first;
        dimensionValueSet222.setValue(DIMENSION_LAUNCH_STYLE, str);
        AppMonitor.Stat.commit(MODULE_NAME, POINT, dimensionValueSet222, (MeasureValueSet) pair.second);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x004b  */
    private static void registerExternalLink(@NonNull String str) {
        char c;
        MeasureSet measureSet;
        DimensionSet dimensionSet;
        int hashCode = str.hashCode();
        if (hashCode != -1102667161) {
            if (hashCode != 3059428) {
                if (hashCode == 1193839609 && str.equals(LINK_HOME)) {
                    c = 3;
                    if (c != 2) {
                        measureSet = ExternalLinkH5Monitor.getMeasureSet();
                        dimensionSet = ExternalLinkH5Monitor.getDimensionSet();
                    } else if (c != 3) {
                        measureSet = ColdLaunchMonitor.getMeasureSet();
                        dimensionSet = ColdLaunchMonitor.getDimensionSet();
                    } else {
                        measureSet = ExternalLinkHomeMonitor.getMeasureSet();
                        dimensionSet = ExternalLinkHomeMonitor.getDimensionSet();
                    }
                    dimensionSet.addDimension(DIMENSION_LAUNCH_STYLE);
                    AppMonitor.register(MODULE_NAME, POINT, measureSet, dimensionSet);
                }
            } else if (str.equals(COLD)) {
                c = 1;
                if (c != 2) {
                }
                dimensionSet.addDimension(DIMENSION_LAUNCH_STYLE);
                AppMonitor.register(MODULE_NAME, POINT, measureSet, dimensionSet);
            }
        } else if (str.equals(LINK_H5)) {
            c = 2;
            if (c != 2) {
            }
            dimensionSet.addDimension(DIMENSION_LAUNCH_STYLE);
            AppMonitor.register(MODULE_NAME, POINT, measureSet, dimensionSet);
        }
        c = 65535;
        if (c != 2) {
        }
        dimensionSet.addDimension(DIMENSION_LAUNCH_STYLE);
        AppMonitor.register(MODULE_NAME, POINT, measureSet, dimensionSet);
    }

    public void report(@Nullable String str) {
        if (!TextUtils.isEmpty(str)) {
            registerExternalLink(str);
            innerReport(str);
        }
    }

    private PolymerizationMonitor() {
    }
}
