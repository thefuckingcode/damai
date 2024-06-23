package com.taobao.orange.model;

import android.text.TextUtils;
import com.taobao.orange.OConstant;
import com.taobao.orange.candidate.MultiAnalyze;
import com.taobao.orange.util.OLog;
import com.taobao.orange.util.OrangeMonitor;
import java.io.Serializable;

/* compiled from: Taobao */
public class CandidateDO implements Serializable {
    private static final String TAG = "CandidateDO";
    public String match;
    public String md5;
    public String resourceId;
    public String version;

    /* access modifiers changed from: package-private */
    public boolean checkMatch(String str) {
        try {
            MultiAnalyze complie = MultiAnalyze.complie(this.match, true);
            boolean match2 = complie.match();
            if (complie.unitAnalyzes.size() == 1 && "did_hash".equals(complie.unitAnalyzes.get(0).key)) {
                String format = String.format("%s:%s:%s", str, this.version, this.match);
                if (match2) {
                    OrangeMonitor.commitSuccess(OConstant.MONITOR_MODULE, "did_hash", format);
                } else {
                    OrangeMonitor.commitFail(OConstant.MONITOR_MODULE, "did_hash", format, null, null);
                }
            }
            return match2;
        } catch (Exception e) {
            OLog.e(TAG, "checkMatch", e, new Object[0]);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean checkValid() {
        if (!TextUtils.isEmpty(this.resourceId) && !TextUtils.isEmpty(this.match) && !TextUtils.isEmpty(this.version)) {
            return true;
        }
        OLog.w(TAG, "lack param", new Object[0]);
        return false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        CandidateDO candidateDO = (CandidateDO) obj;
        String str = this.resourceId;
        if (str == null ? candidateDO.resourceId != null : !str.equals(candidateDO.resourceId)) {
            return false;
        }
        String str2 = this.match;
        if (str2 == null ? candidateDO.match != null : !str2.equals(candidateDO.match)) {
            return false;
        }
        String str3 = this.version;
        String str4 = candidateDO.version;
        if (str3 != null) {
            return str3.equals(str4);
        }
        if (str4 == null) {
            return true;
        }
        return false;
    }

    public String toString() {
        return String.format("CandidateDO{match:'%s', verison:'%s'}", this.match, this.version);
    }
}
