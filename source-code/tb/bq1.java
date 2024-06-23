package tb;

import android.app.Application;
import android.os.Build;
import com.alibaba.youku.webp4pexode.WebpDecoder;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.pexode.Pexode;
import com.taobao.pexode.decoder.a;
import com.taobao.pexode.decoder.d;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class bq1 {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final bq1 INSTANCE = new bq1();

    private bq1() {
    }

    public final void a(@NotNull Application application) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1986182549")) {
            ipChange.ipc$dispatch("-1986182549", new Object[]{this, application});
            return;
        }
        k21.i(application, "application");
        if (Build.VERSION.SDK_INT == 28) {
            tp1.w = true;
            Pexode.g = true;
        }
        tp1.o().z(application);
        if (ne1.INSTANCE.g()) {
            tp1.o().httpLoaderBuilder().with(new b03(application));
            me1.INSTANCE.a("setupHttpLoader-use-xcdn");
        } else {
            wh2.b(application);
            me1.INSTANCE.a("setupHttpLoader-use-default-httplaoder");
        }
        u4.a();
        zh2.a(true, true);
        tp1.o().b();
        Pexode.i(new d());
        Pexode.i(new a());
        Pexode.i(new WebpDecoder());
        Pexode.q(tp1.o().c().build());
        Pexode.n(application);
        ge2.d(application, new se1(), 20, 204800);
        wh2.c();
        tp1.o().w(new re1());
    }
}
