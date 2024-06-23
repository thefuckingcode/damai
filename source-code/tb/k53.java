package tb;

public final class k53 {
    public x23 a;
    public com.efs.sdk.base.a.d.a b;
    public v33 c;
    public b63 d;

    public static class a {
        private static final k53 a = new k53((byte) 0);
    }

    private k53() {
        this.a = new x23();
        this.c = new v33();
        this.d = new b63();
    }

    /* synthetic */ k53(byte b2) {
        this();
    }

    public final l23 a(String str, int i) {
        l23 l23 = new l23("efs_core", str, this.a.c);
        l23.a("cver", Integer.valueOf(i));
        return l23;
    }

    public final void b(int i) {
        com.efs.sdk.base.a.d.a aVar = this.b;
        if (aVar != null) {
            aVar.b(a("flow_limit", i));
        }
    }

    public final void c(int i, String str) {
        if (this.b != null || com.efs.sdk.base.a.d.a.a().d) {
            l23 a2 = a("flow_limit_type", i);
            a2.a("code", str);
            this.b.b(a2);
        }
    }

    public final void d(String str, String str2, String str3) {
        this.d.b(str, str2, str3);
    }
}
