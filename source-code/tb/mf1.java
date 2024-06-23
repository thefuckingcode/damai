package tb;

import androidx.annotation.NonNull;

/* compiled from: Taobao */
public class mf1 {
    private int a;
    private int b;
    private int c;
    private int d;
    private boolean e;

    /* compiled from: Taobao */
    public static class a {
        private int a = 500;
        private int b = 2000;
        private int c = 180000;
        private int d = com.alipay.sdk.m.e0.a.a;
        private boolean e = true;

        @NonNull
        public mf1 f() {
            return new mf1(this);
        }
    }

    mf1(@NonNull a aVar) {
        this.a = aVar.a;
        this.b = aVar.b;
        this.d = aVar.d;
        this.c = aVar.c;
        this.e = aVar.e;
    }

    public int a() {
        return this.a;
    }

    public int b() {
        return this.d;
    }

    public int c() {
        return this.b;
    }

    public int d() {
        return this.c;
    }
}
