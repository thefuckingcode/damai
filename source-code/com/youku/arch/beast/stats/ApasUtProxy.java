package com.youku.arch.beast.stats;

import android.text.TextUtils;
import com.alibaba.mtl.appmonitor.AppMonitor;
import com.alibaba.mtl.appmonitor.model.DimensionSet;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.MeasureSet;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.orange.OrangeConfig;
import com.youku.arch.beast.apas.Apas;
import com.youku.arch.beast.apas.Config;
import com.youku.middlewareservice.provider.task.Priority;
import com.youku.middlewareservice.provider.task.TaskRunnerProviderProxy;
import com.youku.middlewareservice.provider.task.TaskType;
import com.youku.util.Logger;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

/* compiled from: Taobao */
public class ApasUtProxy {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String TAG = "ApasUtProxy";
    private static boolean mUtForApasIsRegisterd = false;
    private static boolean sIsUseAppMonitor = true;
    private volatile IUtThreadProxy mUtThreadProxy;
    private Pattern pattern;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class Holder {
        private static final ApasUtProxy instance = new ApasUtProxy();

        private Holder() {
        }
    }

    /* compiled from: Taobao */
    public interface IUtThreadProxy {
        void run(Runnable runnable);
    }

    private void asyncReportApsStatus(final String str, final String str2, final Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "204941593")) {
            ipChange.ipc$dispatch("204941593", new Object[]{this, str, str2, map});
            return;
        }
        AnonymousClass1 r0 = new Runnable() {
            /* class com.youku.arch.beast.stats.ApasUtProxy.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void run() {
                Config config;
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1686375636")) {
                    ipChange.ipc$dispatch("1686375636", new Object[]{this});
                    return;
                }
                try {
                    Thread.sleep(1000);
                    HashMap hashMap = new HashMap();
                    HashMap hashMap2 = new HashMap();
                    hashMap.put("type", str);
                    hashMap.put("currentVersion", Apas.getInstance().getCurrentVersion());
                    Apas.getInstance().getAllNamespaces();
                    String[] allNamespaces = Apas.getInstance().getAllNamespaces();
                    if (allNamespaces != null) {
                        StringBuilder sb = new StringBuilder();
                        for (String str : allNamespaces) {
                            if (!(str == null || Apas.getInstance().getNamespace(str) == null || (config = Apas.getInstance().getNamespace(str).getConfig(0)) == null)) {
                                sb.append(str);
                                sb.append(",");
                                sb.append(config.getConfigId());
                                sb.append(",");
                                sb.append(config.getConfigVersion());
                                sb.append(";");
                            }
                        }
                        hashMap.put("detail", sb.toString());
                    }
                    String str2 = str2;
                    if (str2 == null) {
                        hashMap.put("orangeContrast", OrangeConfig.getInstance().getConfig("aps_quality_test", "auto_quality_test", "0"));
                    } else {
                        hashMap.put("orangeContrast", str2);
                    }
                    Map map = map;
                    if (map != null && !map.isEmpty()) {
                        for (String str3 : map.keySet()) {
                            hashMap.put(str3, map.get(str3));
                        }
                    }
                    hashMap2.put("noise", Double.valueOf(0.0d));
                    ApasUtProxy.this.commitApsSuccessRatioStatistics(hashMap, hashMap2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        if (this.mUtThreadProxy != null) {
            this.mUtThreadProxy.run(r0);
            return;
        }
        TaskRunnerProviderProxy.initTaskGroup("ApasUt", 1);
        TaskRunnerProviderProxy.runTask("ApasUt", "aps-ut-report", TaskType.CPU, Priority.IMMEDIATE, r0);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void commitApsSuccessRatioStatistics(Map<String, String> map, Map<String, Double> map2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-719682572")) {
            ipChange.ipc$dispatch("-719682572", new Object[]{this, map, map2});
        } else if (!sIsUseAppMonitor || map == null || map2 == null) {
            Logger.d(TAG, "commitApsSuccessRatioStatistics --> param is null.");
        } else {
            if (!mUtForApasIsRegisterd) {
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                if (map.size() > 0) {
                    linkedHashSet.addAll(map.keySet());
                }
                LinkedHashSet linkedHashSet2 = new LinkedHashSet();
                if (map2.size() > 0) {
                    linkedHashSet2.addAll(map2.keySet());
                }
                register("vpm", "aps_stats", linkedHashSet2, linkedHashSet);
                mUtForApasIsRegisterd = true;
            }
            commit("vpm", "aps_stats", map, map2);
        }
    }

    public static ApasUtProxy getInstance() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-809554821") ? (ApasUtProxy) ipChange.ipc$dispatch("-809554821", new Object[0]) : Holder.instance;
    }

    private boolean isLegalVersion(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1238281629")) {
            return ((Boolean) ipChange.ipc$dispatch("-1238281629", new Object[]{this, str})).booleanValue();
        } else if (!TextUtils.isEmpty(str)) {
            return this.pattern.matcher(str).find();
        } else {
            return false;
        }
    }

    public void commit(String str, String str2, Map<String, String> map, Map<String, Double> map2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1976257349")) {
            ipChange.ipc$dispatch("-1976257349", new Object[]{this, str, str2, map, map2});
        } else if (sIsUseAppMonitor) {
            DimensionValueSet create = DimensionValueSet.create();
            if (map != null) {
                create.setMap(map);
            }
            MeasureValueSet measureValueSet = null;
            if (map2 != null && map2.size() > 0) {
                measureValueSet = MeasureValueSet.create();
                for (String str3 : map2.keySet()) {
                    measureValueSet.setValue(str3, map2.get(str3).doubleValue());
                }
            }
            Logger.d(TAG, "commit " + map.toString() + "," + map2.toString());
            AppMonitor.Stat.commit(str, str2, create, measureValueSet);
        }
    }

    public void register(String str, String str2, Set<String> set, Set<String> set2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "168075599")) {
            ipChange.ipc$dispatch("168075599", new Object[]{this, str, str2, set, set2});
        } else if (sIsUseAppMonitor) {
            AppMonitor.register(str, str2, MeasureSet.create(set), DimensionSet.create(set2));
        }
    }

    public void reportApsStats(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "415452697")) {
            ipChange.ipc$dispatch("415452697", new Object[]{this, str});
            return;
        }
        reportApsStats(str, null);
    }

    public void setUtThread(IUtThreadProxy iUtThreadProxy) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-150894359")) {
            ipChange.ipc$dispatch("-150894359", new Object[]{this, iUtThreadProxy});
            return;
        }
        this.mUtThreadProxy = iUtThreadProxy;
    }

    private ApasUtProxy() {
        this.pattern = Pattern.compile(".{32}-\\d{13}");
    }

    public void reportApsStats(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "271877027")) {
            ipChange.ipc$dispatch("271877027", new Object[]{this, str, str2});
            return;
        }
        asyncReportApsStatus(str, str2, null);
    }

    public void reportApsStats(String str, String str2, Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2114403714")) {
            ipChange.ipc$dispatch("2114403714", new Object[]{this, str, str2, map});
            return;
        }
        asyncReportApsStatus(str, str2, map);
    }
}
