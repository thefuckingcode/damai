package tb;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import com.alibaba.responsive.IDisableOritationActivity;
import com.alibaba.responsive.page.IResponsivePage;
import com.alibaba.responsive.page.orientation.a;

/* compiled from: Taobao */
public class t02 {
    private IResponsivePage a;
    private int b;
    private int c;
    private a d;

    public t02(IResponsivePage iResponsivePage) {
        this.a = iResponsivePage;
        d();
    }

    private void a(Configuration configuration) {
        if (d70.e(this.a.getPageActivity()) && d70.g(this.a.getPageActivity())) {
            int requestedOrientation = this.a.getPageActivity().getRequestedOrientation();
            if (configuration.orientation == 2 && requestedOrientation == 1) {
                configuration.orientation = 1;
            }
        }
    }

    private void b(Context context, int i, int i2) {
        int i3;
        if (!d70.c() || ((double) i2) * ad2.b() > ((double) i)) {
            i3 = (i < ad2.a() || !((((double) i2) > (((double) i) * ad2.d()) ? 1 : (((double) i2) == (((double) i) * ad2.d()) ? 0 : -1)) <= 0)) ? 1000 : 1001;
        } else {
            i3 = 1002;
        }
        y02.d().i(context, i3);
    }

    private void d() {
        if (f12.i(this.a.getPageActivity())) {
            int h = f12.h(this.a.getPageActivity());
            int f = f12.f(this.a.getPageActivity());
            float f2 = this.a.getPageActivity().getResources().getDisplayMetrics().density;
            int i = (int) (((float) h) / f2);
            int i2 = (int) (((float) f) / f2);
            if (Build.VERSION.SDK_INT >= 24 && this.a.getPageActivity().isInMultiWindowMode()) {
                this.a.getPageActivity().getResources().getConfiguration().screenWidthDp = i;
                this.a.getPageActivity().getResources().getConfiguration().screenHeightDp = i2;
            }
            y02.d().f(this.a.getPageActivity(), this.a.getPageActivity().getResources().getConfiguration().orientation);
            y02.d().h(this.a.getPageActivity(), i);
            y02.d().g(this.a.getPageActivity(), this.a.getPageActivity().getResources().getConfiguration().screenHeightDp);
            b(this.a.getPageActivity(), i, i2);
            this.c = y02.d().e(this.a.getPageActivity());
            if (!d70.e(this.a.getPageActivity())) {
                IDisableOritationActivity b2 = x02.c().b();
                if (b2 == null || !b2.hitDisableOritationActivityClassName(this.a.getPageActivity().getLocalClassName())) {
                    this.d = new a(this.a.getPageActivity());
                    return;
                }
                return;
            }
            return;
        }
        IDisableOritationActivity b3 = x02.c().b();
        if ((b3 == null || !b3.hitDisableOritationActivityClassName(this.a.getPageActivity().getLocalClassName())) && this.a.getPageActivity() != null && this.a.getPageActivity().getRequestedOrientation() != 1) {
            cn1.b(this.a.getPageActivity(), 1);
        }
    }

    private void h() {
        if (this.d != null && d70.g(this.a.getPageActivity())) {
            int requestedOrientation = this.a.getPageActivity().getRequestedOrientation();
            if (requestedOrientation == 0 || requestedOrientation == 8) {
                float b2 = (float) y02.d().b(this.a.getPageActivity());
                if (((float) y02.d().c(this.a.getPageActivity())) > ((float) ad2.c()) && b2 <= ((float) ad2.c())) {
                    cn1.b(this.a.getPageActivity(), 1);
                }
            }
        }
    }

    public void c(Context context, Configuration configuration) {
        y02.d().f(context, configuration.orientation);
        y02.d().h(context, configuration.screenWidthDp);
        y02.d().g(context, configuration.screenHeightDp);
        b(context, configuration.screenWidthDp, configuration.screenHeightDp);
    }

    public void e(Configuration configuration) {
        if (f12.i(this.a.getPageActivity())) {
            a(configuration);
            c(this.a.getPageActivity(), configuration);
            this.b = this.c;
            this.c = y02.d().e(this.a.getPageActivity());
        }
    }

    public void f() {
        y02.d().a(this.a.getPageActivity());
        a aVar = this.d;
        if (aVar != null) {
            aVar.g();
        }
    }

    public void g(Configuration configuration) {
        if (f12.i(this.a.getPageActivity())) {
            h();
            int i = this.b;
            int i2 = this.c;
            this.a.onResponsiveLayout(configuration, i2, i != i2);
        }
    }
}
