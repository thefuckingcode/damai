package tb;

import cn.damai.ticklet.bean.TickletTransferManagerListExtra;
import cn.damai.ticklet.bean.Tips;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;

/* compiled from: Taobao */
public class nn2 {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int TYPE_TRANSFER_ALLOW = 0;
    public static final int TYPE_TRANSFER_MODULE_DIVIDER = 3;
    public static final int TYPE_TRANSFER_OUT = 1;
    public static final int TYPE_TRANSFER_RUNNING = 2;
    public static final int TYPE_TRANSFER_STATE_LIMIT = 5;
    public static final int TYPE_TRANSFER_TOP_TIPS = 4;
    private int a;
    private String b;
    private Tips c;
    private ArrayList<TickletTransferManagerListExtra> d;
    private ArrayList<TickletTransferManagerListExtra> e;
    private ArrayList<TickletTransferManagerListExtra> f;

    public nn2(int i) {
        this.a = i;
    }

    public ArrayList<TickletTransferManagerListExtra> a() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1820304280")) {
            return this.d;
        }
        return (ArrayList) ipChange.ipc$dispatch("-1820304280", new Object[]{this});
    }

    public String b() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "434131916")) {
            return this.b;
        }
        return (String) ipChange.ipc$dispatch("434131916", new Object[]{this});
    }

    public ArrayList<TickletTransferManagerListExtra> c() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2070595331")) {
            return this.e;
        }
        return (ArrayList) ipChange.ipc$dispatch("2070595331", new Object[]{this});
    }

    public ArrayList<TickletTransferManagerListExtra> d() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "789066738")) {
            return this.f;
        }
        return (ArrayList) ipChange.ipc$dispatch("789066738", new Object[]{this});
    }

    public Tips e() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1271216299")) {
            return this.c;
        }
        return (Tips) ipChange.ipc$dispatch("-1271216299", new Object[]{this});
    }

    public int f() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-632163231")) {
            return this.a;
        }
        return ((Integer) ipChange.ipc$dispatch("-632163231", new Object[]{this})).intValue();
    }

    public void g(ArrayList<TickletTransferManagerListExtra> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "453868880")) {
            ipChange.ipc$dispatch("453868880", new Object[]{this, arrayList});
            return;
        }
        this.d = arrayList;
    }

    public void h(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1726763734")) {
            ipChange.ipc$dispatch("-1726763734", new Object[]{this, str});
            return;
        }
        this.b = str;
    }

    public void i(ArrayList<TickletTransferManagerListExtra> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1427606763")) {
            ipChange.ipc$dispatch("-1427606763", new Object[]{this, arrayList});
            return;
        }
        this.e = arrayList;
    }

    public void j(ArrayList<TickletTransferManagerListExtra> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "869779974")) {
            ipChange.ipc$dispatch("869779974", new Object[]{this, arrayList});
            return;
        }
        this.f = arrayList;
    }

    public void k(Tips tips) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "757636189")) {
            ipChange.ipc$dispatch("757636189", new Object[]{this, tips});
            return;
        }
        this.c = tips;
    }
}
