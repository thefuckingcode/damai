package com.xiaomi.push;

import android.content.Context;

/* compiled from: Taobao */
public class du extends dt {
    public du(Context context, int i) {
        super(context, i);
    }

    @Override // com.xiaomi.push.dt, com.xiaomi.push.dt, com.xiaomi.push.al.a
    public hl a() {
        return hl.Storage;
    }

    @Override // com.xiaomi.push.dt, com.xiaomi.push.dt, com.xiaomi.push.al.a
    /* renamed from: a  reason: collision with other method in class */
    public String m357a() {
        return "23";
    }

    @Override // com.xiaomi.push.dt, com.xiaomi.push.dt
    public String b() {
        return "ram:" + j.m686a() + "," + "rom:" + j.m689b() + "|" + "ramOriginal:" + j.m691c() + "," + "romOriginal:" + j.d();
    }
}
