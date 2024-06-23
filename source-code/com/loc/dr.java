package com.loc;

import java.io.Serializable;
import tb.y43;

/* compiled from: Taobao */
public abstract class dr implements Serializable {
    public String a = "";
    public String b = "";
    public int c = 99;
    public int d = Integer.MAX_VALUE;
    public long e = 0;
    public long f = 0;
    public int g = 0;
    public boolean h;
    public boolean i = true;

    public dr() {
    }

    public dr(boolean z, boolean z2) {
        this.h = z;
        this.i = z2;
    }

    private static int a(String str) {
        try {
            return Integer.parseInt(str);
        } catch (Exception e2) {
            y43.a(e2);
            return 0;
        }
    }

    /* renamed from: a */
    public abstract dr clone();

    public final void a(dr drVar) {
        this.a = drVar.a;
        this.b = drVar.b;
        this.c = drVar.c;
        this.d = drVar.d;
        this.e = drVar.e;
        this.f = drVar.f;
        this.g = drVar.g;
        this.h = drVar.h;
        this.i = drVar.i;
    }

    public final int b() {
        return a(this.a);
    }

    public final int c() {
        return a(this.b);
    }

    public String toString() {
        return "AmapCell{mcc=" + this.a + ", mnc=" + this.b + ", signalStrength=" + this.c + ", asulevel=" + this.d + ", lastUpdateSystemMills=" + this.e + ", lastUpdateUtcMills=" + this.f + ", age=" + this.g + ", main=" + this.h + ", newapi=" + this.i + '}';
    }
}
