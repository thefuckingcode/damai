package com.taobao.update.monitor;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.mtl.appmonitor.AppMonitor;
import com.taobao.update.adapter.UpdateMonitor;
import com.taobao.update.framework.UpdateRuntime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import tb.gs2;
import tb.ns2;

/* compiled from: Taobao */
public class UpdateMonitorImpl implements UpdateMonitor {
    private final String PERF_KEY = "update_unique_monit";
    private Map<String, Set<gs2>> updateAlarmDatas = new HashMap();
    private a updateStatMonitor = new a();

    private void clear() {
        UpdateRuntime.getContext().getSharedPreferences("update_point", 0).edit().clear().commit();
    }

    private void commitToDisk() {
        if (this.updateAlarmDatas.containsKey("ddefficiency")) {
            SharedPreferences sharedPreferences = UpdateRuntime.getContext().getSharedPreferences("update_point", 0);
            String string = sharedPreferences.getString("dd_update", "");
            if (TextUtils.isEmpty(string)) {
                sharedPreferences.edit().putString("dd_update", JSON.toJSONString(this.updateAlarmDatas.get("ddefficiency"))).commit();
                return;
            }
            List<gs2> parseArray = JSON.parseArray(string, gs2.class);
            if (parseArray != null && parseArray.size() > 0) {
                for (gs2 gs2 : parseArray) {
                    if (!this.updateAlarmDatas.get("ddefficiency").contains(gs2)) {
                        this.updateAlarmDatas.get("ddefficiency").add(gs2);
                    }
                }
            }
            sharedPreferences.edit().putString("dd_update", JSON.toJSONString(this.updateAlarmDatas.get("ddefficiency"))).commit();
        }
    }

    @Override // com.taobao.update.adapter.UpdateMonitor
    public void add(String str, boolean z, String str2, String str3, String str4, String str5, String str6, long j, long j2) {
        gs2 gs2 = new gs2();
        gs2.success = z;
        if (str2 == null) {
            str2 = "";
        }
        gs2.arg = str2;
        if (str3 == null) {
            str3 = "0";
        }
        gs2.errorCode = str3;
        if (str4 == null) {
            str4 = "";
        }
        gs2.errorMsg = str4;
        if (str5 == null) {
            str5 = "";
        }
        gs2.toVersion = str5;
        gs2.fromVersion = "";
        if (str6 == null) {
            str6 = "";
        }
        gs2.url = str6;
        gs2.elapsed_time = j2;
        gs2.disk_size = ns2.getFreeSizeRange(j);
        add(str, gs2);
    }

    @Override // com.taobao.update.adapter.UpdateMonitor
    public synchronized void commit(String str) {
        clear();
        Set<gs2> set = this.updateAlarmDatas.get(str);
        if (set != null) {
            if (!set.isEmpty()) {
                for (gs2 gs2 : set) {
                    this.updateStatMonitor.b(str, gs2);
                }
                this.updateAlarmDatas.remove(str);
            }
        }
    }

    @Override // com.taobao.update.adapter.UpdateMonitor
    public void commitCount(String str, String str2, String str3, double d) {
        AppMonitor.Counter.commit(str, str2, str3, d);
    }

    @Override // com.taobao.update.adapter.UpdateMonitor
    public void commitFail(String str, String str2, String str3, String str4) {
        AppMonitor.Alarm.commitFail(str, str2, str3, str4);
    }

    @Override // com.taobao.update.adapter.UpdateMonitor
    public void commitSuccess(String str, String str2, String str3) {
        AppMonitor.Alarm.commitSuccess(str, str2, str3);
    }

    @Override // com.taobao.update.adapter.UpdateMonitor
    public void add(String str, boolean z, String str2, String str3, String str4, String str5, String str6, String str7) {
        gs2 gs2 = new gs2();
        gs2.success = z;
        if (str2 == null) {
            str2 = "";
        }
        gs2.arg = str2;
        if (str3 == null) {
            str3 = "";
        }
        gs2.errorCode = str3;
        if (str4 == null) {
            str4 = "";
        }
        gs2.errorMsg = str4;
        if (str6 == null) {
            str6 = "";
        }
        gs2.toVersion = str6;
        if (str5 == null) {
            str5 = "";
        }
        gs2.fromVersion = str5;
        if (str7 == null) {
            str7 = "";
        }
        gs2.url = str7;
        add(str, gs2);
    }

    private synchronized void add(String str, gs2 gs2) {
        if (!this.updateAlarmDatas.containsKey(str)) {
            this.updateAlarmDatas.put(str, new HashSet());
        }
        this.updateAlarmDatas.get(str).add(gs2);
        commitToDisk();
    }
}
