package com.youku.arch.analysis.net;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class d {
    private static transient /* synthetic */ IpChange $ipChange;
    private String a = "";
    private double b = -1.0d;

    /* compiled from: Taobao */
    private static class a {
        private static final d a = new d();
    }

    public static d a() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1293787797") ? (d) ipChange.ipc$dispatch("1293787797", new Object[0]) : a.a;
    }

    public double a(double d, double d2, double d3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-736625916")) {
            return ((Double) ipChange.ipc$dispatch("-736625916", new Object[]{this, Double.valueOf(d), Double.valueOf(d2), Double.valueOf(d3)})).doubleValue();
        } else if (b.a().c() != 1) {
            return d;
        } else {
            if (d2 > 0.0d && d2 < d) {
                d = d2;
            }
            return (d3 <= 0.0d || d3 >= d) ? d : d3;
        }
    }
}
