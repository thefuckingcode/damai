package tb;

import com.alibaba.fastjson.JSONObject;
import com.alimm.xadsdk.base.ut.AdUtConstants;

/* compiled from: Taobao */
public class zn extends se0 {
    public int g;
    public double h;

    @Override // tb.se0
    public synchronized JSONObject b() {
        JSONObject b;
        b = super.b();
        b.put(AdUtConstants.XAD_UT_ARG_COUNT, (Object) Integer.valueOf(this.g));
        b.put("value", (Object) Double.valueOf(this.h));
        return b;
    }

    public synchronized void c(double d, Long l) {
        this.h += d;
        this.g++;
        super.a(l);
    }

    @Override // tb.se0, com.alibaba.appmonitor.pool.Reusable
    public synchronized void fill(Object... objArr) {
        super.fill(objArr);
        this.h = 0.0d;
        this.g = 0;
    }
}
