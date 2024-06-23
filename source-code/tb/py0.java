package tb;

import com.efs.sdk.base.http.IHttpUtil;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
public class py0 {
    private IHttpUtil a;
    private List<com.efs.sdk.base.a.h.a.b<vy0>> b;

    /* compiled from: Taobao */
    static class b {
        private static final py0 a = new py0();
    }

    private py0() {
        this.a = p13.d();
        this.b = new ArrayList(1);
    }

    public static py0 c() {
        return b.a;
    }

    public List<com.efs.sdk.base.a.h.a.b<vy0>> a() {
        return new ArrayList(this.b);
    }

    public IHttpUtil b() {
        return this.a;
    }
}
