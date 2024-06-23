package cn.damai.uikit.flowlayout;

import android.view.View;
import cn.damai.uikit.flowlayout.FlowLayout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
public class a {
    private static transient /* synthetic */ IpChange $ipChange;
    private final List<View> a = new ArrayList();
    private final LayoutConfiguration b;
    private final int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h = 0;
    private int i = 0;

    public a(int i2, LayoutConfiguration layoutConfiguration) {
        this.c = i2;
        this.b = layoutConfiguration;
    }

    public void a(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "674066091")) {
            ipChange.ipc$dispatch("674066091", new Object[]{this, Integer.valueOf(i2)});
            return;
        }
        this.i += i2;
    }

    public void b(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1878472619")) {
            ipChange.ipc$dispatch("1878472619", new Object[]{this, Integer.valueOf(i2)});
            return;
        }
        this.h += i2;
    }

    public void c(int i2, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-419185720")) {
            ipChange.ipc$dispatch("-419185720", new Object[]{this, Integer.valueOf(i2), view});
            return;
        }
        FlowLayout.LayoutParams layoutParams = (FlowLayout.LayoutParams) view.getLayoutParams();
        this.a.add(i2, view);
        int f2 = this.f + layoutParams.f();
        this.d = f2;
        this.f = f2 + layoutParams.g();
        this.g = Math.max(this.g, layoutParams.i() + layoutParams.h());
        this.e = Math.max(this.e, layoutParams.i());
    }

    public void d(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "537503449")) {
            ipChange.ipc$dispatch("537503449", new Object[]{this, view});
            return;
        }
        c(this.a.size(), view);
    }

    public boolean e(View view) {
        int i2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "545516204")) {
            return ((Boolean) ipChange.ipc$dispatch("545516204", new Object[]{this, view})).booleanValue();
        }
        if (this.b.c() == 0) {
            i2 = view.getMeasuredWidth();
        } else {
            i2 = view.getMeasuredHeight();
        }
        if (this.f + i2 <= this.c) {
            return true;
        }
        return false;
    }

    public int f() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-683770750")) {
            return this.d;
        }
        return ((Integer) ipChange.ipc$dispatch("-683770750", new Object[]{this})).intValue();
    }

    public int g() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1546739008")) {
            return this.i;
        }
        return ((Integer) ipChange.ipc$dispatch("-1546739008", new Object[]{this})).intValue();
    }

    public int h() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1407230646")) {
            return this.h;
        }
        return ((Integer) ipChange.ipc$dispatch("1407230646", new Object[]{this})).intValue();
    }

    public int i() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "420370868")) {
            return this.g;
        }
        return ((Integer) ipChange.ipc$dispatch("420370868", new Object[]{this})).intValue();
    }

    public List<View> j() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "435972980")) {
            return this.a;
        }
        return (List) ipChange.ipc$dispatch("435972980", new Object[]{this});
    }

    public void k(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2109481292")) {
            ipChange.ipc$dispatch("2109481292", new Object[]{this, Integer.valueOf(i2)});
            return;
        }
        this.d = i2;
        this.f = i2 + (this.f - this.d);
    }

    public void l(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-656640662")) {
            ipChange.ipc$dispatch("-656640662", new Object[]{this, Integer.valueOf(i2)});
            return;
        }
        this.g = i2;
        this.e = i2 - (this.g - this.e);
    }
}
