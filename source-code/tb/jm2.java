package tb;

import com.alibaba.analytics.core.sync.ITnetHostPortStrategy;
import com.alibaba.analytics.utils.Logger;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class jm2 implements ITnetHostPortStrategy {
    private nb2 a = null;

    public jm2() {
        try {
            this.a = new nb2();
        } catch (Throwable unused) {
            Logger.g();
            this.a = null;
        }
    }

    /* access modifiers changed from: package-private */
    public int a() {
        nb2 nb2 = this.a;
        if (nb2 != null) {
            return nb2.b();
        }
        return 0;
    }

    @Override // com.alibaba.analytics.core.sync.ITnetHostPortStrategy
    public mm2 getTnetHostPort() {
        nb2 nb2 = this.a;
        if (nb2 != null) {
            return nb2.d();
        }
        return null;
    }

    @Override // com.alibaba.analytics.core.sync.ITnetHostPortStrategy
    public void response(bc bcVar) {
        nb2 nb2 = this.a;
        if (nb2 != null) {
            nb2.g(bcVar.a());
        }
    }
}
