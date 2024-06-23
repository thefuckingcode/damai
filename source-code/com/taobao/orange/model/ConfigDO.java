package com.taobao.orange.model;

import android.text.TextUtils;
import com.taobao.orange.GlobalOrange;
import com.taobao.orange.util.OLog;
import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Map;
import tb.jl1;

/* compiled from: Taobao */
public class ConfigDO implements CheckDO, Serializable {
    protected static final String TAG = "ConfigDO";
    private static final long serialVersionUID = 6057693726984967889L;
    public String appKey;
    public String appVersion;
    public CandidateDO candidate;
    private String changeVersion;
    private int configStatus = 0;
    public Map<String, String> content;
    public String createTime;
    public String id;
    public String loadLevel;
    public volatile transient boolean monitored = false;
    public String name;
    public transient boolean persisted = true;
    public String resourceId;
    public String type;
    public String version;

    /* compiled from: Taobao */
    public interface ConfigStatus {
        public static final int DEFAULT = 0;
        public static final int NEED_UPDATE = 2;

        @Retention(RetentionPolicy.CLASS)
        /* compiled from: Taobao */
        public @interface Definition {
        }
    }

    @Override // com.taobao.orange.model.CheckDO
    public boolean checkValid() {
        Map<String, String> map;
        if (TextUtils.isEmpty(this.appKey) || TextUtils.isEmpty(this.appVersion) || TextUtils.isEmpty(this.id) || TextUtils.isEmpty(this.name) || TextUtils.isEmpty(this.resourceId) || TextUtils.isEmpty(this.type) || TextUtils.isEmpty(this.loadLevel) || TextUtils.isEmpty(this.version) || (map = this.content) == null || map.isEmpty()) {
            OLog.w(TAG, "lack param", new Object[0]);
            return false;
        }
        boolean z = (jl1.MUL.equals(this.appVersion) || GlobalOrange.appVersion.equals(this.appVersion)) && GlobalOrange.appKey.equals(this.appKey);
        if (!z) {
            OLog.w(TAG, "invaild", new Object[0]);
        }
        return z;
    }

    public String getChangeVersion() {
        return this.changeVersion;
    }

    public int getConfigStatus() {
        return this.configStatus;
    }

    public String getCurVersion() {
        CandidateDO candidateDO = this.candidate;
        return candidateDO == null ? this.version : candidateDO.version;
    }

    public void setChangeVersion(String str) {
        this.changeVersion = str;
    }

    public void setConfigStatus(int i) {
        this.configStatus = i;
    }

    public String toString() {
        return String.format("ConfigDO{name:'%s', appVersion:'%s', verison:'%s', type:'%s'}", this.name, this.appVersion, this.version, this.type);
    }
}
