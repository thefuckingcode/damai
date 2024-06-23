package com.alibaba.mobsec.privacydoublelist.e;

import java.util.regex.Matcher;
import tb.jl1;

/* compiled from: Taobao */
public class a extends b {
    public a(String str) {
        this.a = str;
    }

    public String b() {
        return "a";
    }

    public String toString() {
        Matcher matcher;
        String str;
        String str2;
        if (this.a.contains(jl1.BRACKET_START_STR)) {
            matcher = b.f.matcher(this.a);
        } else {
            matcher = b.g.matcher(this.a);
        }
        String str3 = this.a;
        if (matcher.find()) {
            str = matcher.group(1);
            str2 = matcher.group(2);
        } else {
            str2 = str3;
            str = "";
        }
        return "" + str + "|" + str2 + "|" + this.b.get() + "|" + this.c.get() + "|" + a() + "|" + 0 + "|" + a() + "|" + this.e.get();
    }
}
