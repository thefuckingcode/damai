package tb;

import android.content.res.Configuration;
import com.alibaba.responsive.page.IResponsivePage;

/* compiled from: Taobao */
public class v02 {
    private IResponsivePage a;
    private int b;
    private int c = y02.d().e(this.a.getPageActivity());

    public v02(IResponsivePage iResponsivePage) {
        this.a = iResponsivePage;
    }

    public void a(Configuration configuration) {
        if (f12.i(this.a.getPageActivity())) {
            this.b = this.c;
            this.c = y02.d().e(this.a.getPageActivity());
        }
    }

    public void b(Configuration configuration) {
        if (f12.i(this.a.getPageActivity())) {
            IResponsivePage iResponsivePage = this.a;
            int i = this.c;
            iResponsivePage.onResponsiveLayout(configuration, i, this.b != i);
        }
    }
}
