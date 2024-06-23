package com.alibaba.pictures.bricks.view;

import android.view.View;
import com.alibaba.pictures.bricks.view.FlowLayout;
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
        if (AndroidInstantRuntime.support(ipChange, "-1271645204")) {
            ipChange.ipc$dispatch("-1271645204", new Object[]{this, Integer.valueOf(i2)});
            return;
        }
        this.i += i2;
    }

    public void b(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2071910090")) {
            ipChange.ipc$dispatch("2071910090", new Object[]{this, Integer.valueOf(i2)});
            return;
        }
        this.h += i2;
    }

    public void c(int i2, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2135799817")) {
            ipChange.ipc$dispatch("2135799817", new Object[]{this, Integer.valueOf(i2), view});
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
        if (AndroidInstantRuntime.support(ipChange, "-765550984")) {
            ipChange.ipc$dispatch("-765550984", new Object[]{this, view});
            return;
        }
        c(this.a.size(), view);
    }

    public boolean e(View view) {
        int i2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-604896467")) {
            return ((Boolean) ipChange.ipc$dispatch("-604896467", new Object[]{this, view})).booleanValue();
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
        if (!AndroidInstantRuntime.support(ipChange, "-290156925")) {
            return this.d;
        }
        return ((Integer) ipChange.ipc$dispatch("-290156925", new Object[]{this})).intValue();
    }

    public int g() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2131274079")) {
            return this.i;
        }
        return ((Integer) ipChange.ipc$dispatch("2131274079", new Object[]{this})).intValue();
    }

    public int h() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-110550089")) {
            return this.h;
        }
        return ((Integer) ipChange.ipc$dispatch("-110550089", new Object[]{this})).intValue();
    }

    public int i() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1309113363")) {
            return this.g;
        }
        return ((Integer) ipChange.ipc$dispatch("1309113363", new Object[]{this})).intValue();
    }

    public List<View> j() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2137567285")) {
            return this.a;
        }
        return (List) ipChange.ipc$dispatch("2137567285", new Object[]{this});
    }

    public void k(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "593114859")) {
            ipChange.ipc$dispatch("593114859", new Object[]{this, Integer.valueOf(i2)});
            return;
        }
        this.d = i2;
        this.f = i2 + (this.f - this.d);
    }

    public void l(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-263026837")) {
            ipChange.ipc$dispatch("-263026837", new Object[]{this, Integer.valueOf(i2)});
            return;
        }
        this.g = i2;
        this.e = i2 - (this.g - this.e);
    }
}
