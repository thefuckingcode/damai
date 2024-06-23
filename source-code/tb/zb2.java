package tb;

import androidx.annotation.NonNull;
import cn.damai.commonbusiness.seatbiz.view.svgview.core.helper.parser.model.Shape;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
public class zb2 extends i32 {
    private static transient /* synthetic */ IpChange $ipChange;
    private final List<h32> b;

    /* compiled from: Taobao */
    public class a extends h32 {
        private static transient /* synthetic */ IpChange $ipChange;

        a(zb2 zb2) {
        }

        @Override // tb.h32
        public List<String> d() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1642043386")) {
                return (List) ipChange.ipc$dispatch("1642043386", new Object[]{this});
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add("#dddddd");
            arrayList.add("#ffffff");
            return arrayList;
        }

        @Override // tb.h32
        public String e() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-360094254")) {
                return "#33000000";
            }
            return (String) ipChange.ipc$dispatch("-360094254", new Object[]{this});
        }
    }

    /* compiled from: Taobao */
    public class b extends h32 {
        private static transient /* synthetic */ IpChange $ipChange;

        b(zb2 zb2) {
        }

        @Override // tb.h32
        public List<String> d() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1959822213")) {
                return (List) ipChange.ipc$dispatch("-1959822213", new Object[]{this});
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add("#000000");
            arrayList.add("#333333");
            return arrayList;
        }

        @Override // tb.h32
        public String e() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1590206001")) {
                return "#ffffff";
            }
            return (String) ipChange.ipc$dispatch("1590206001", new Object[]{this});
        }
    }

    public zb2() {
        ArrayList arrayList = new ArrayList();
        this.b = arrayList;
        a aVar = new a(this);
        aVar.c();
        b bVar = new b(this);
        bVar.c();
        arrayList.add(aVar);
        arrayList.add(bVar);
    }

    private int f(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "572548117")) {
            return ((Integer) ipChange.ipc$dispatch("572548117", new Object[]{this, Integer.valueOf(i)})).intValue();
        }
        for (h32 h32 : this.b) {
            if (h32.a(i)) {
                return h32.b();
            }
        }
        return i;
    }

    @Override // tb.i32
    public void d(@NonNull int[] iArr, @NonNull Shape shape) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1405181437")) {
            ipChange.ipc$dispatch("-1405181437", new Object[]{this, iArr, shape});
            return;
        }
        e(shape);
        iArr[0] = f(shape.fillColor);
        iArr[1] = f(shape.strokeColor);
    }
}
