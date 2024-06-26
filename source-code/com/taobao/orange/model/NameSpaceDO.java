package com.taobao.orange.model;

import android.os.Build;
import android.text.TextUtils;
import com.taobao.orange.GlobalOrange;
import com.taobao.orange.util.OLog;
import com.taobao.orange.util.OrangeUtils;
import com.taobao.orange.util.SPUtil;
import com.youku.arch.v3.core.Constants;
import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
public class NameSpaceDO implements Serializable {
    public static final int HIGH_INIT = 0;
    public static final int HIGH_LAZY = 1;
    public static final String LEVEL_DEFAULT = "DEFAULT";
    public static final String LEVEL_HIGH = "HIGH";
    private static final String TAG = "NameSpaceDO";
    public static final String TYPE_CUSTOM = "CUSTOM";
    public static final String TYPE_STANDARD = "STANDARD";
    private static final long serialVersionUID = -4740785816043854483L;
    public List<CandidateDO> candidates;
    private String changeVersion;
    public transient CandidateDO curCandidateDO;
    public transient boolean hasChanged;
    public Integer highLazy = 0;
    public String loadLevel;
    public String md5;
    public String name;
    public String resourceId;
    public String type;
    public String version;

    private boolean skipCheckConfigValid(ConfigDO configDO, boolean z) {
        long j;
        if (!z) {
            String str = (String) SPUtil.getFromSharePreference(GlobalOrange.context, "osVersion", "");
            if ((!TextUtils.equals((String) SPUtil.getFromSharePreference(GlobalOrange.context, "appVersion", ""), GlobalOrange.appVersion) || !TextUtils.equals(str, String.valueOf(Build.VERSION.SDK_INT))) && configDO != null) {
                configDO.setConfigStatus(2);
                OLog.e(TAG, "skipCheckConfigValid localEnvironment changed", new Object[0]);
                z = true;
            }
        }
        OLog.e(TAG, "skipCheckConfigValid", "forceCheckValid", Boolean.valueOf(z));
        if (configDO == null) {
            j = 0;
        } else {
            j = OrangeUtils.parseLong(configDO.getChangeVersion());
        }
        if ((j != 0 || OrangeUtils.parseLong(this.changeVersion) != 0) && j >= OrangeUtils.parseLong(this.changeVersion) && !z) {
            return true;
        }
        return false;
    }

    public boolean checkValid(ConfigDO configDO, boolean z) {
        long j;
        int intValue = ((Integer) SPUtil.getFromSharePreference(GlobalOrange.context, "enableChangeVersion", 0)).intValue();
        if (intValue > 0 && skipCheckConfigValid(configDO, z)) {
            return false;
        }
        long j2 = 0;
        if (configDO == null) {
            j = 0;
        } else {
            j = OrangeUtils.parseLong(configDO.getCurVersion());
        }
        boolean z2 = (configDO == null || configDO.candidate == null) ? false : true;
        if (configDO != null && !z2) {
            j2 = OrangeUtils.parseLong(configDO.version);
        }
        long parseLong = OrangeUtils.parseLong(this.version);
        List<CandidateDO> list = this.candidates;
        if (list != null && !list.isEmpty()) {
            int i = 3;
            if (OLog.isPrintLog(0)) {
                OLog.v(TAG, "checkCandidates start", Constants.CONFIG, this.name, "candidates.size", Integer.valueOf(this.candidates.size()));
            }
            int i2 = 0;
            while (i2 < this.candidates.size()) {
                CandidateDO candidateDO = this.candidates.get(i2);
                if (OLog.isPrintLog(0)) {
                    Object[] objArr = new Object[i];
                    objArr[0] = "index";
                    objArr[1] = Integer.valueOf(i2);
                    objArr[2] = candidateDO;
                    OLog.v(TAG, "checkCandidate start", objArr);
                }
                if (!candidateDO.checkValid() || !candidateDO.checkMatch(this.name)) {
                    i2++;
                    i = 3;
                } else if (!z2 || OrangeUtils.parseLong(candidateDO.version) != j) {
                    if (OLog.isPrintLog(1)) {
                        OLog.d(TAG, "checkCandidate match", "localV", Long.valueOf(j), "remoteV", candidateDO.version);
                    }
                    this.curCandidateDO = candidateDO;
                    return true;
                } else {
                    if (OLog.isPrintLog(1)) {
                        OLog.d(TAG, "checkCandidate match but no version update", new Object[0]);
                    }
                    return false;
                }
            }
            if (OLog.isPrintLog(1)) {
                OLog.d(TAG, "checkCandidates finish", "not any match");
            }
        }
        int i3 = (parseLong > j2 ? 1 : (parseLong == j2 ? 0 : -1));
        boolean z3 = intValue <= 0 ? i3 > 0 : i3 != 0;
        if (!z3 && OLog.isPrintLog(1)) {
            OLog.d(TAG, "checkValid", "no version update");
        }
        return z3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        NameSpaceDO nameSpaceDO = (NameSpaceDO) obj;
        String str = this.loadLevel;
        if (str == null ? nameSpaceDO.loadLevel != null : !str.equals(nameSpaceDO.loadLevel)) {
            return false;
        }
        String str2 = this.md5;
        if (str2 == null ? nameSpaceDO.md5 != null : !str2.equals(nameSpaceDO.md5)) {
            return false;
        }
        String str3 = this.name;
        if (str3 == null ? nameSpaceDO.name != null : !str3.equals(nameSpaceDO.name)) {
            return false;
        }
        String str4 = this.resourceId;
        if (str4 == null ? nameSpaceDO.resourceId != null : !str4.equals(nameSpaceDO.resourceId)) {
            return false;
        }
        String str5 = this.version;
        if (str5 == null ? nameSpaceDO.version != null : !str5.equals(nameSpaceDO.version)) {
            return false;
        }
        if (getChangeVersion() == null ? nameSpaceDO.getChangeVersion() != null : !getChangeVersion().equals(nameSpaceDO.getChangeVersion())) {
            return false;
        }
        List<CandidateDO> list = this.candidates;
        List<CandidateDO> list2 = nameSpaceDO.candidates;
        if (list != null) {
            return list.equals(list2);
        }
        if (list2 == null) {
            return true;
        }
        return false;
    }

    public String getChangeVersion() {
        return this.changeVersion;
    }

    public void setChangeVersion(String str) {
        this.changeVersion = str;
    }

    public String toString() {
        return String.format("NameSpaceDO{level:'%s', name:'%s', verison:'%s'}", this.loadLevel, this.name, this.version);
    }
}
