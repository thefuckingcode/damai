package com.alibaba.appmonitor.sample;

import com.alibaba.analytics.core.db.annotation.Column;
import com.alibaba.analytics.core.db.annotation.TableName;
import com.alibaba.analytics.utils.Logger;
import java.util.ArrayList;
import java.util.Map;

@TableName("ap_alarm")
/* compiled from: Taobao */
public class AlarmConfig extends AMConifg {
    @Column("fcp")
    protected int failSampling = 0;
    @Column("scp")
    protected int successSampling = 0;

    private boolean checkSelfSampling(int i, boolean z) {
        if (z) {
            Logger.r("AlarmConfig", "samplingSeed", Integer.valueOf(i), "sampling", Integer.valueOf(this.successSampling));
            if (i < this.successSampling) {
                return true;
            }
            return false;
        }
        Logger.r("AlarmConfig", "samplingSeed", Integer.valueOf(i), "sampling", Integer.valueOf(this.failSampling));
        if (i < this.failSampling) {
            return true;
        }
        return false;
    }

    private boolean sampling(int i, ArrayList<String> arrayList, boolean z) {
        if (arrayList == null || arrayList.size() == 0) {
            return checkSelfSampling(i, z);
        }
        String remove = arrayList.remove(0);
        if (isContains(remove)) {
            return ((AlarmConfig) getNext(remove)).sampling(i, arrayList, z);
        }
        return checkSelfSampling(i, z);
    }

    public boolean isSampled(int i, String str, String str2, Boolean bool, Map<String, String> map) {
        ArrayList<String> arrayList = new ArrayList<>(2);
        arrayList.add(str);
        arrayList.add(str2);
        return sampling(i, arrayList, bool.booleanValue());
    }

    @Override // com.alibaba.appmonitor.sample.AMConifg
    public void setSampling(int i) {
        this.successSampling = i;
        this.failSampling = i;
    }

    public String toString() {
        return "AlarmConfig{" + "module=" + this.module + ", monitorPoint=" + this.monitorPoint + ", offline=" + this.offline + ", failSampling=" + this.failSampling + ", successSampling=" + this.successSampling + '}';
    }

    @Deprecated
    public boolean isSampled(int i, String str, String str2, Boolean bool) {
        return isSampled(i, str, str2, bool, null);
    }
}
