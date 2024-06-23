package com.xiaomi.push;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class ft extends Thread {
    final /* synthetic */ fs a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ft(fs fsVar, String str) {
        super(str);
        this.a = fsVar;
    }

    public void run() {
        try {
            this.a.a.m490a();
        } catch (Exception e) {
            this.a.c(9, e);
        }
    }
}
