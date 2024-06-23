package tb;

import com.taobao.update.datasource.logger.Log;
import java.util.ArrayList;

/* compiled from: Taobao */
public class zc0 extends dd0 {
    private Log b;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class b {
        private static zc0 a = new zc0();
    }

    public static zc0 INSTANCE() {
        return b.a;
    }

    @Override // tb.dd0
    public String apiName() {
        return "mtop.alibaba.emas.publish.update.get";
    }

    @Override // tb.dd0
    public String biz() {
        return js2.MAIN;
    }

    @Override // tb.dd0
    public String requestVersion() {
        return ns2.getVersionName();
    }

    private zc0() {
        this.b = y91.getLog(zc0.class, (Log) null);
        new ArrayList();
    }
}
