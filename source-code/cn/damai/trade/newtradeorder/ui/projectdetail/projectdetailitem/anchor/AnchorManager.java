package cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.anchor;

import android.view.View;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import tb.a5;
import tb.ln2;
import tb.tw1;
import tb.xf2;

/* compiled from: Taobao */
public class AnchorManager {
    private static transient /* synthetic */ IpChange $ipChange;
    private HashMap<Integer, a5> a = new HashMap<>();
    private HashMap<Integer, a5> b = new HashMap<>();
    private a5 c;
    private OnGetAnchorName d;
    private int e;

    /* compiled from: Taobao */
    public enum AnchorType {
        DETAIL,
        COMMENT,
        NOTICE,
        RECOMMEND
    }

    /* compiled from: Taobao */
    public interface OnGetAnchorName {
        String onAnchorName(AnchorType anchorType);
    }

    /* compiled from: Taobao */
    public class a implements Comparator<a5> {
        private static transient /* synthetic */ IpChange $ipChange;

        a(AnchorManager anchorManager) {
        }

        /* renamed from: a */
        public int compare(a5 a5Var, a5 a5Var2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1773347985")) {
                return ((Integer) ipChange.ipc$dispatch("1773347985", new Object[]{this, a5Var, a5Var2})).intValue();
            } else if (a5Var.b() > a5Var2.b()) {
                return 1;
            } else {
                if (a5Var.b() < a5Var2.b()) {
                    return -1;
                }
                return 0;
            }
        }
    }

    private AnchorManager(OnGetAnchorName onGetAnchorName) {
        this.d = onGetAnchorName;
    }

    private a5 b(AnchorType anchorType) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2089497011")) {
            return (a5) ipChange.ipc$dispatch("2089497011", new Object[]{this, anchorType});
        } else if (anchorType != null) {
            a5 a5Var = new a5();
            a5Var.h(anchorType.ordinal());
            a5Var.g(tw1.a(0, 0));
            a5Var.e(this.d.onAnchorName(anchorType));
            return a5Var;
        } else {
            throw new IllegalArgumentException("anchorType must not be null");
        }
    }

    public static AnchorManager g(OnGetAnchorName onGetAnchorName) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-519451292")) {
            return (AnchorManager) ipChange.ipc$dispatch("-519451292", new Object[]{onGetAnchorName});
        } else if (onGetAnchorName != null) {
            return new AnchorManager(onGetAnchorName);
        } else {
            throw new IllegalArgumentException("OnGetAnchorName must not be null");
        }
    }

    public void a(AnchorType anchorType, int i, int i2, int i3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-316090582")) {
            ipChange.ipc$dispatch("-316090582", new Object[]{this, anchorType, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
        } else if (anchorType != null) {
            a5 a5Var = this.b.get(Integer.valueOf(anchorType.ordinal()));
            if (a5Var == null) {
                a5Var = b(anchorType);
                a5Var.f(i);
                a5Var.g(tw1.a(Integer.valueOf(i2), Integer.valueOf(i3)));
            } else {
                a5Var.f(i);
                a5Var.g(tw1.a(Integer.valueOf(i2), Integer.valueOf(i3)));
            }
            a5 a5Var2 = this.c;
            if (!(a5Var2 == null || a5Var2.d() != a5Var.d() || this.c.b() == a5Var.b())) {
                this.c = a5Var;
                this.e = a5Var.b();
            }
            this.b.put(Integer.valueOf(anchorType.ordinal()), a5Var);
            this.a.put(Integer.valueOf(i), a5Var);
        } else {
            throw new IllegalArgumentException("anchorType must not be null");
        }
    }

    public a5 c(AnchorType anchorType) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "447722023")) {
            return this.b.get(Integer.valueOf(anchorType.ordinal()));
        }
        return (a5) ipChange.ipc$dispatch("447722023", new Object[]{this, anchorType});
    }

    public List<a5> d() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-701120192")) {
            return (List) ipChange.ipc$dispatch("-701120192", new Object[]{this});
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.a.values());
        Collections.sort(arrayList, new a(this));
        return arrayList;
    }

    public a5 e() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "680753332")) {
            return this.c;
        }
        return (a5) ipChange.ipc$dispatch("680753332", new Object[]{this});
    }

    public int f() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1722393307")) {
            return this.e;
        }
        return ((Integer) ipChange.ipc$dispatch("-1722393307", new Object[]{this})).intValue();
    }

    public a5 h() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-601698485")) {
            return this.a.get(Integer.valueOf(this.e + 1));
        }
        return (a5) ipChange.ipc$dispatch("-601698485", new Object[]{this});
    }

    public a5 i() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "361411143")) {
            return this.a.get(Integer.valueOf(this.e - 1));
        }
        return (a5) ipChange.ipc$dispatch("361411143", new Object[]{this});
    }

    public boolean j() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1966903986")) {
            return this.e < this.b.size() - 1;
        }
        return ((Boolean) ipChange.ipc$dispatch("1966903986", new Object[]{this})).booleanValue();
    }

    public boolean k() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1445093038")) {
            return this.e > 0;
        }
        return ((Boolean) ipChange.ipc$dispatch("1445093038", new Object[]{this})).booleanValue();
    }

    public void l(AnchorType anchorType) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1793783918")) {
            ipChange.ipc$dispatch("-1793783918", new Object[]{this, anchorType});
            return;
        }
        this.a.remove(Integer.valueOf(anchorType.ordinal()));
    }

    public void m(List<a5> list, View view, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2108068411")) {
            ipChange.ipc$dispatch("-2108068411", new Object[]{this, list, view, str});
            return;
        }
        int e2 = xf2.e(list);
        for (int i = 0; i < e2; i++) {
            a5 a5Var = list.get(i);
            if (a5Var.d() == AnchorType.DETAIL.ordinal()) {
                ln2.r().L1(view, 0, str);
            } else if (a5Var.d() == AnchorType.COMMENT.ordinal()) {
                ln2.r().L1(view, 1, str);
            } else if (a5Var.d() == AnchorType.NOTICE.ordinal()) {
                ln2.r().L1(view, 2, str);
            } else if (a5Var.d() == AnchorType.RECOMMEND.ordinal()) {
                ln2.r().L1(view, 3, str);
            }
        }
    }

    public void n(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1636331141")) {
            ipChange.ipc$dispatch("1636331141", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.e = i;
        this.c = this.a.get(Integer.valueOf(i));
    }
}
