package tb;

import android.content.Context;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class aj0 extends rv1 {
    private static transient /* synthetic */ IpChange $ipChange;
    private int n;

    public aj0(int i, Context context) {
        this.n = m42.a(context, (float) i);
    }

    /* access modifiers changed from: protected */
    @Override // tb.rv1
    public void C(float f, float f2, float f3, float f4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1268965078")) {
            ipChange.ipc$dispatch("-1268965078", new Object[]{this, Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)});
            return;
        }
        int d = d();
        if (f4 > 0.0f && d >= this.n) {
            f4 = 0.0f;
        }
        super.C(f, f2, f3, f4);
    }

    /* access modifiers changed from: protected */
    @Override // tb.rv1
    public void F(float f, float f2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1532650868")) {
            ipChange.ipc$dispatch("1532650868", new Object[]{this, Float.valueOf(f), Float.valueOf(f2)});
            return;
        }
        super.F(f, f2);
    }
}
