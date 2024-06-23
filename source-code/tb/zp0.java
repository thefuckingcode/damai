package tb;

import com.alibaba.gaiax.GXTemplateEngine;
import com.alibaba.gaiax.template.GXTemplateInfo;
import io.flutter.wpkbridge.WPKFactory;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import tb.xq0;

/* compiled from: Taobao */
public final class zp0 {
    @NotNull
    public static final zp0 INSTANCE = new zp0();

    private zp0() {
    }

    private final up0 b(wq0 wq0, up0 up0, hp0 hp0, xq0 xq0, GXTemplateInfo gXTemplateInfo) {
        up0 up02 = new up0();
        up02.T(up0);
        up02.P(up0, hp0);
        up02.X(xq0.Companion.a(hp0.d(), gXTemplateInfo, xq0));
        up02.W(sq0.Companion.b(wq0, up02.n(), up02.g(), up02.h()));
        for (T t : hp0.e()) {
            if (t.s()) {
                GXTemplateInfo j = gXTemplateInfo.j(t.d());
                if (j != null) {
                    xq0 b = xq0.a.b(xq0.Companion, t.d(), gXTemplateInfo, null, 4, null);
                    hp0 o = j.o();
                    if (!up02.s() || !j.t()) {
                        up0 b2 = INSTANCE.b(wq0, up02, o, b, j);
                        b2.S(true);
                        if (up02.d() == null) {
                            up02.N(new ArrayList());
                        }
                        List<up0> d = up02.d();
                        if (d != null) {
                            d.add(b2);
                        }
                        up02.m().d().addChild(b2.m().d());
                    } else {
                        up02.a(new GXTemplateEngine.h(wq0.c(), wq0.l().a(), o.d()), b);
                    }
                } else {
                    throw new IllegalArgumentException(k21.r("Child template not found, id = ", t.d()));
                }
            } else {
                up0 b3 = INSTANCE.b(wq0, up02, t, null, gXTemplateInfo);
                if (up02.d() == null) {
                    up02.N(new ArrayList());
                }
                List<up0> d2 = up02.d();
                if (d2 != null) {
                    d2.add(b3);
                }
                up02.m().d().addChild(b3.m().d());
            }
        }
        return up02;
    }

    @NotNull
    public final up0 a(@NotNull wq0 wq0) {
        k21.i(wq0, WPKFactory.INIT_KEY_CONTEXT);
        up0 b = b(wq0, null, wq0.k().o(), wq0.m(), wq0.k());
        b.V(true);
        aq0.INSTANCE.k(b, new ob2<>(wq0.i().b(), wq0.i().a()));
        return b;
    }
}
