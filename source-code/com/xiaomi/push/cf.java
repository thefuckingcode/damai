package com.xiaomi.push;

import com.xiaomi.push.cj;

/* compiled from: Taobao */
public class cf extends cj.d {
    protected String a = "MessageDeleteJob";

    public cf(String str, String str2, String[] strArr, String str3) {
        super(str, str2, strArr);
        this.a = str3;
    }

    public static cf a(String str) {
        return new cf(str, "status = ?", new String[]{String.valueOf(2)}, "a job build to delete uploaded job");
    }
}
