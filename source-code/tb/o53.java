package tb;

import com.amap.api.location.AMapLocation;
import com.huawei.hms.opendevice.c;
import com.loc.as;
import com.loc.at;

@as(a = c.a)
/* compiled from: Taobao */
public class o53 {
    @at(a = "a2", b = 6)
    private String a;
    @at(a = "a3", b = 5)
    private long b;
    @at(a = "a4", b = 6)
    private String c;
    private AMapLocation d;

    public final AMapLocation a() {
        return this.d;
    }

    public final void b(long j) {
        this.b = j;
    }

    public final void c(AMapLocation aMapLocation) {
        this.d = aMapLocation;
    }

    public final void d(String str) {
        this.c = str;
    }

    public final String e() {
        return this.c;
    }

    public final void f(String str) {
        this.a = str;
    }

    public final String g() {
        return this.a;
    }

    public final long h() {
        return this.b;
    }
}
