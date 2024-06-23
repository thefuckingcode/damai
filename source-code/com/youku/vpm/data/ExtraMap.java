package com.youku.vpm.data;

import android.text.TextUtils;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: Taobao */
public class ExtraMap extends LinkedHashMap<String, String> {
    private String mMonitorPoint;

    public ExtraMap(String str) {
        this.mMonitorPoint = str;
    }

    public boolean contains(String... strArr) {
        for (String str : strArr) {
            if (str.equals(this.mMonitorPoint)) {
                return true;
            }
        }
        return false;
    }

    public String put(String str, String str2) {
        if (TextUtils.isEmpty(str2) || str2.contains(";") || str2.contains("=")) {
            return null;
        }
        return (String) super.put((Object) str, (Object) str2);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        for (Map.Entry entry : entrySet()) {
            String str = (String) entry.getValue();
            if (!TextUtils.isEmpty((String) entry.getKey()) && !TextUtils.isEmpty(str)) {
                stringBuffer.append((String) entry.getKey());
                stringBuffer.append("=");
                stringBuffer.append((String) entry.getValue());
                stringBuffer.append(";");
            }
        }
        return stringBuffer.toString();
    }
}
