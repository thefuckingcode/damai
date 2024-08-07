package com.xiaomi.push.service;

import android.os.SystemClock;
import android.text.TextUtils;
import com.xiaomi.push.bp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.time.DateUtils;

/* compiled from: Taobao */
public class m {
    private static final Map<String, Long> a = new HashMap();

    private static void a() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        Map<String, Long> map = a;
        ArrayList<String> arrayList = new ArrayList(map.size());
        for (Map.Entry<String, Long> entry : map.entrySet()) {
            if (elapsedRealtime - entry.getValue().longValue() > DateUtils.MILLIS_PER_MINUTE) {
                arrayList.add(entry.getKey());
            }
        }
        for (String str : arrayList) {
            a.remove(str);
        }
    }

    public static boolean a(byte[] bArr, String str) {
        boolean z = false;
        if (bArr != null && bArr.length > 0 && !TextUtils.isEmpty(str)) {
            String a2 = bp.a(bArr);
            if (!TextUtils.isEmpty(a2)) {
                Map<String, Long> map = a;
                synchronized (map) {
                    if (map.get(a2 + str) != null) {
                        z = true;
                    } else {
                        map.put(a2 + str, Long.valueOf(SystemClock.elapsedRealtime()));
                    }
                    a();
                }
            }
        }
        return z;
    }
}
