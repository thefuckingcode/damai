package tb;

/* compiled from: Taobao */
public class cd0 extends ad0 {

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class b {
        private static cd0 a = new cd0();
    }

    public static cd0 INSTANCE() {
        return b.a;
    }

    @Override // tb.dd0
    public String biz() {
        return js2.SOPATCH;
    }

    @Override // tb.dd0
    public String requestVersion() {
        return "-1";
    }

    private cd0() {
    }
}
