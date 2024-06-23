package tb;

import com.alibaba.responsive.IConfig;
import com.alibaba.responsive.IDisableOritationActivity;
import com.alibaba.responsive.ISpanCountProcess;

/* compiled from: Taobao */
public class x02 {
    private static volatile x02 d;
    private ISpanCountProcess a;
    private IDisableOritationActivity b;
    private IConfig c;

    public static x02 c() {
        if (d == null) {
            synchronized (x02.class) {
                if (d == null) {
                    d = new x02();
                }
            }
        }
        return d;
    }

    public IConfig a() {
        return this.c;
    }

    public IDisableOritationActivity b() {
        return this.b;
    }

    public ISpanCountProcess d() {
        return this.a;
    }
}
