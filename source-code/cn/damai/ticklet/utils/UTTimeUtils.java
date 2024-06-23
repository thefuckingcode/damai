package cn.damai.ticklet.utils;

import android.view.View;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.g91;
import tb.rc1;

/* compiled from: Taobao */
public class UTTimeUtils {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static int o = 0;
    public static int p = 1;
    public static int q = 3;
    private long a = 0;
    private long b = 0;
    private long c = 0;
    private Boolean d = Boolean.TRUE;
    private Boolean e;
    private Boolean f;
    private Boolean g;
    private rc1 h;
    private String i;
    private String j;
    private String k;
    private String l;
    private String m;
    private String n;

    public UTTimeUtils(int i2) {
        Boolean bool = Boolean.FALSE;
        this.e = bool;
        this.f = bool;
        this.g = bool;
        this.i = "db_query";
        this.j = "net_query";
        this.k = "finish(db)";
        this.l = "finish(net)";
        this.m = "finish(local)";
        this.n = "combin_render";
        this.h = new rc1(i2);
        this.a = System.currentTimeMillis();
    }

    public void k() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-756679861")) {
            ipChange.ipc$dispatch("-756679861", new Object[]{this});
            return;
        }
        this.a = System.currentTimeMillis();
        Boolean bool = Boolean.FALSE;
        this.d = bool;
        this.c = 0;
        this.e = bool;
        this.f = bool;
        this.g = bool;
    }

    public void l() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "676306843")) {
            ipChange.ipc$dispatch("676306843", new Object[]{this});
        } else if (this.c == 0) {
            this.c = System.currentTimeMillis();
        }
    }

    public void m(long j2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2051943444")) {
            ipChange.ipc$dispatch("-2051943444", new Object[]{this, Long.valueOf(j2)});
        } else if (!this.e.booleanValue() && j2 != 0) {
            this.e = Boolean.TRUE;
            if (j2 <= 10000) {
                this.h.a(this.i, j2);
                g91.b("member_activity_time", "dbstr=" + j2);
            }
        }
    }

    public void n() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "173080502")) {
            ipChange.ipc$dispatch("173080502", new Object[]{this});
            return;
        }
        if (this.b == 0) {
            this.b = System.currentTimeMillis() - this.a;
        }
        g91.b("member_activity_time", "init_time=" + this.b);
    }

    public void o(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1868328303")) {
            ipChange.ipc$dispatch("-1868328303", new Object[]{this, view});
        } else if (!this.g.booleanValue() && this.a != 0) {
            this.g = Boolean.TRUE;
            if (view != null) {
                view.post(new Runnable() {
                    /* class cn.damai.ticklet.utils.UTTimeUtils.AnonymousClass2 */
                    private static transient /* synthetic */ IpChange $ipChange;

                    public void run() {
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "1801558721")) {
                            ipChange.ipc$dispatch("1801558721", new Object[]{this});
                            return;
                        }
                        if (UTTimeUtils.this.c != 0) {
                            UTTimeUtils.this.h.a(UTTimeUtils.this.n, System.currentTimeMillis() - UTTimeUtils.this.c);
                        }
                        long currentTimeMillis = System.currentTimeMillis() - UTTimeUtils.this.a;
                        if (!UTTimeUtils.this.d.booleanValue() && UTTimeUtils.this.b < 2000) {
                            currentTimeMillis += UTTimeUtils.this.b;
                        }
                        if (currentTimeMillis <= 300000) {
                            UTTimeUtils.this.h.a(UTTimeUtils.this.m, currentTimeMillis);
                        }
                    }
                });
            }
        }
    }

    public void p(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1470241248")) {
            ipChange.ipc$dispatch("1470241248", new Object[]{this, view});
        } else if (!this.g.booleanValue() && this.a != 0) {
            this.g = Boolean.TRUE;
            if (view != null) {
                view.post(new Runnable() {
                    /* class cn.damai.ticklet.utils.UTTimeUtils.AnonymousClass1 */
                    private static transient /* synthetic */ IpChange $ipChange;

                    public void run() {
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "1998072226")) {
                            ipChange.ipc$dispatch("1998072226", new Object[]{this});
                            return;
                        }
                        if (UTTimeUtils.this.c != 0) {
                            UTTimeUtils.this.h.a(UTTimeUtils.this.n, System.currentTimeMillis() - UTTimeUtils.this.c);
                        }
                        g91.b("member_activity_time", "combin_render =" + (System.currentTimeMillis() - UTTimeUtils.this.c));
                        long currentTimeMillis = System.currentTimeMillis() - UTTimeUtils.this.a;
                        if (!UTTimeUtils.this.d.booleanValue() && UTTimeUtils.this.b < 2000) {
                            currentTimeMillis += UTTimeUtils.this.b;
                        }
                        if (currentTimeMillis <= 300000) {
                            if (UTTimeUtils.this.e.booleanValue()) {
                                UTTimeUtils.this.h.a(UTTimeUtils.this.k, currentTimeMillis);
                            } else {
                                UTTimeUtils.this.h.a(UTTimeUtils.this.l, currentTimeMillis);
                            }
                            g91.b("member_activity_time", "start_time=" + UTTimeUtils.this.a);
                            if (UTTimeUtils.this.e.booleanValue()) {
                                g91.b("member_activity_time", "db_finish=" + currentTimeMillis);
                                return;
                            }
                            g91.b("member_activity_time", "net_finish=" + currentTimeMillis);
                        }
                    }
                });
            }
        }
    }

    public void q(long j2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1649650385")) {
            ipChange.ipc$dispatch("1649650385", new Object[]{this, Long.valueOf(j2)});
        } else if (!this.f.booleanValue() && j2 != 0) {
            this.f = Boolean.TRUE;
            if (j2 <= 30000) {
                this.h.a(this.j, j2);
                g91.b("member_activity_time", "netstr=" + j2);
            }
        }
    }
}
