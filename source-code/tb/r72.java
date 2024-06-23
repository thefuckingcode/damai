package tb;

import android.text.TextUtils;
import androidx.collection.ArrayMap;
import cn.damai.common.user.a;
import cn.damai.common.user.b;
import cn.damai.common.user.c;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class r72 extends b {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String PAGE_AREA = "areaselect";
    public static final String PAGE_SEAT = "seatselect";
    private static r72 b;

    private r72() {
    }

    public static a.b f(long j) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1023110038")) {
            return new a.b().d(String.valueOf(j)).i(PAGE_AREA);
        }
        return (a.b) ipChange.ipc$dispatch("1023110038", new Object[]{Long.valueOf(j)});
    }

    public static r72 n() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1819351657")) {
            return (r72) ipChange.ipc$dispatch("1819351657", new Object[0]);
        }
        if (b == null) {
            b = new r72();
        }
        return b;
    }

    public static a.b o(long j) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1667000597")) {
            return new a.b().d(String.valueOf(j)).i("seatselect");
        }
        return (a.b) ipChange.ipc$dispatch("-1667000597", new Object[]{Long.valueOf(j)});
    }

    public void g(long j, long j2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-154612973")) {
            ipChange.ipc$dispatch("-154612973", new Object[]{this, Long.valueOf(j), Long.valueOf(j2)});
            return;
        }
        ArrayMap arrayMap = new ArrayMap(2);
        arrayMap.put("item_id", j + "");
        arrayMap.put("titlelabel", j2 + "");
        c.e().x(e("seatselect", "bottom", "confirm", arrayMap, Boolean.TRUE));
    }

    public void h(String str, long j, long j2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-237813805")) {
            ipChange.ipc$dispatch("-237813805", new Object[]{this, str, Long.valueOf(j), Long.valueOf(j2)});
            return;
        }
        ArrayMap arrayMap = new ArrayMap(2);
        arrayMap.put("item_id", j + "");
        arrayMap.put("titlelabel", j2 + "");
        c.e().x(e(str, "top", "discountexplainbtn", arrayMap, Boolean.TRUE));
    }

    public void i(String str, long j, int i, float f, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1109553536")) {
            ipChange.ipc$dispatch("-1109553536", new Object[]{this, str, Long.valueOf(j), Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)});
            return;
        }
        ArrayMap arrayMap = new ArrayMap(3);
        arrayMap.put("item_id", j + "");
        arrayMap.put("titlelabel", f + "");
        arrayMap.put("price_type", i2 + "");
        c.e().x(e(str, "pricelist", "imgprice_" + i, arrayMap, Boolean.FALSE));
    }

    public void j(long j, String str, long j2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-821847215")) {
            ipChange.ipc$dispatch("-821847215", new Object[]{this, Long.valueOf(j), str, Long.valueOf(j2)});
            return;
        }
        ArrayMap arrayMap = new ArrayMap(2);
        arrayMap.put("item_id", j + "");
        arrayMap.put("contentlabel", str);
        c.e().x(e(PAGE_AREA, "list", "item_" + j2, arrayMap, Boolean.TRUE));
    }

    public void k(long j, long j2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2769893")) {
            ipChange.ipc$dispatch("-2769893", new Object[]{this, Long.valueOf(j), Long.valueOf(j2)});
            return;
        }
        ArrayMap arrayMap = new ArrayMap(2);
        arrayMap.put("item_id", j + "");
        arrayMap.put("titlelabel", j2 + "");
        c.e().x(e("seatselect", "bottom", "openselectedlistbtn", arrayMap, Boolean.FALSE));
    }

    public void l(long j, long j2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1974396786")) {
            ipChange.ipc$dispatch("-1974396786", new Object[]{this, Long.valueOf(j), Long.valueOf(j2)});
            return;
        }
        ArrayMap arrayMap = new ArrayMap(2);
        arrayMap.put("item_id", j + "");
        arrayMap.put("contentlabel", j2 + "");
        c.e().x(e("seatselect", "seat", "item_" + j2, arrayMap, Boolean.FALSE));
    }

    public void m(String str, long j, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "747398247")) {
            ipChange.ipc$dispatch("747398247", new Object[]{this, str, Long.valueOf(j), str2});
        } else if (!TextUtils.isEmpty(str2)) {
            ArrayMap arrayMap = new ArrayMap(2);
            arrayMap.put("item_id", j + "");
            arrayMap.put("discountinfo", str2);
            c.e().A(arrayMap, "yhtc_seatselect_discountinfo", str);
        }
    }
}
