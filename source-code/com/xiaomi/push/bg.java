package com.xiaomi.push;

/* compiled from: Taobao */
public class bg implements bi {
    private final String a;
    private final String b;

    public bg(String str, String str2) {
        if (str != null) {
            this.a = str;
            this.b = str2;
            return;
        }
        throw new IllegalArgumentException("Name may not be null");
    }

    @Override // com.xiaomi.push.bi
    public String a() {
        return this.a;
    }

    @Override // com.xiaomi.push.bi
    public String b() {
        return this.b;
    }
}
