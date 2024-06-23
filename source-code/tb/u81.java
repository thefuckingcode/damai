package tb;

import android.text.TextUtils;
import com.ali.ha.fulltrace.dump.DumpManager;
import com.alibaba.analytics.core.db.annotation.Column;
import com.alibaba.analytics.core.db.annotation.Ingore;
import com.alibaba.analytics.core.db.annotation.TableName;
import com.alibaba.analytics.core.logbuilder.a;
import com.alibaba.analytics.core.model.LogField;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@TableName(DumpManager.LOG_PATH)
/* compiled from: Taobao */
public class u81 extends xd0 {
    @Ingore
    public static final String DEFAULT_PRIORITY = "3";
    @Ingore
    public static final String FIELD_NAME_PRIORITY = "priority";
    @Ingore
    public static final String FIELD_NAME_TIME = "time";
    @Column("eventId")
    public String a;
    @Column("priority")
    public String b = "3";
    @Column("content")
    private String c;
    @Column("time")
    public String d = null;
    @Column("_index")
    public String e = "";
    @Ingore
    private Map<String, String> f;
    @Ingore
    private int g = 0;

    public u81() {
    }

    private String a(List<String> list) {
        if (list == null) {
            return "";
        }
        if (list.size() == 1) {
            return list.get(0);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            if (i > 0) {
                sb.append(",");
            }
            sb.append(list.get(i));
        }
        return sb.toString();
    }

    public String b() {
        try {
            byte[] a2 = u9.a(this.c.getBytes("UTF-8"), 2);
            if (a2 != null) {
                return new String(ow1.c(a2));
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public int c() {
        return this.g;
    }

    public void d(String str) {
        if (str != null) {
            try {
                this.c = new String(u9.c(ow1.c(str.getBytes()), 2), "UTF-8");
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void e(int i) {
        this.g = i;
    }

    public String toString() {
        return "Log [eventId=" + this.a + ", index=" + this.e + jl1.ARRAY_END_STR;
    }

    public u81(String str, List<String> list, String str2, Map<String, String> map) {
        this.b = str;
        a(list);
        this.a = str2;
        this.d = String.valueOf(System.currentTimeMillis());
        c92.a().d(str2, map);
        this.e = map.get(LogField.RESERVE3.toString());
        d(a.a(map));
    }

    public u81(String str, String str2, String str3, String str4, String str5, Map<String, String> map) {
        this.a = str2;
        this.f = map;
        this.d = String.valueOf(System.currentTimeMillis());
        this.b = c91.b().c(str2);
        HashMap hashMap = new HashMap();
        if (map != null) {
            hashMap.putAll(map);
        }
        if (!TextUtils.isEmpty(str)) {
            hashMap.put(LogField.PAGE.toString(), str);
        }
        hashMap.put(LogField.EVENTID.toString(), str2);
        if (!TextUtils.isEmpty(str3)) {
            hashMap.put(LogField.ARG1.toString(), str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            hashMap.put(LogField.ARG2.toString(), str4);
        }
        if (!TextUtils.isEmpty(str5)) {
            hashMap.put(LogField.ARG3.toString(), str5);
        }
        if (!TextUtils.isEmpty(this.d)) {
            hashMap.put(LogField.RECORD_TIMESTAMP.toString(), this.d);
        }
        c92.a().d(str2, hashMap);
        this.e = (String) hashMap.get(LogField.RESERVE3.toString());
        d(a.a(hashMap));
    }
}
