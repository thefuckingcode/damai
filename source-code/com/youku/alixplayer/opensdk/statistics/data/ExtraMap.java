package com.youku.alixplayer.opensdk.statistics.data;

import android.text.TextUtils;
import com.youku.alixplayer.opensdk.utils.TLogUtil;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: Taobao */
public class ExtraMap extends LinkedHashMap<String, String> {
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

    public String put(String str, String str2) {
        if (!TextUtils.isEmpty(str2) && (str2.contains(";") || str2.contains("="))) {
            TLogUtil.vpmLog("ExtraMap value is fail:" + str2);
            str2 = null;
        }
        return (String) super.put((Object) str, (Object) str2);
    }
}
