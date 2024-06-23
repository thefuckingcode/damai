package tb;

import android.text.TextUtils;
import com.alibaba.analytics.core.Variables;
import com.alibaba.analytics.core.sync.ITnetHostPortStrategy;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class lm2 implements ITnetHostPortStrategy {
    private mm2 a;
    private int b = 0;

    public lm2() {
        try {
            mm2 mm2 = new mm2();
            this.a = mm2;
            mm2.e("s-adashx.ut.taobao.com");
            this.a.h(2);
            a(t6.f(Variables.n().j(), rm2.TAG_STATIC_TNET_HOST_PORT));
            a(zc2.a(Variables.n().j(), rm2.TAG_STATIC_TNET_HOST_PORT));
        } catch (Throwable unused) {
        }
    }

    private void a(String str) {
        String trim;
        int indexOf;
        if (!TextUtils.isEmpty(str) && (indexOf = (trim = str.trim()).indexOf(":")) != -1) {
            String substring = trim.substring(0, indexOf);
            int parseInt = Integer.parseInt(trim.substring(indexOf + 1, trim.length()));
            if (!TextUtils.isEmpty(substring) && parseInt > 0) {
                this.a.e(substring);
                this.a.f(parseInt);
            }
        }
    }

    @Override // com.alibaba.analytics.core.sync.ITnetHostPortStrategy
    public mm2 getTnetHostPort() {
        if (this.b >= w32.d().e()) {
            return null;
        }
        return this.a;
    }

    @Override // com.alibaba.analytics.core.sync.ITnetHostPortStrategy
    public void response(bc bcVar) {
        if (bcVar.a()) {
            this.b = 0;
        } else {
            this.b++;
        }
    }
}
