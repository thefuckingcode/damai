package tb;

import androidx.annotation.NonNull;
import androidx.collection.LongSparseArray;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.TbParams;
import cn.damai.seat.helper.b;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class cb {
    private static transient /* synthetic */ IpChange $ipChange;
    private static final LongSparseArray<b> a = new LongSparseArray<>();

    @NonNull
    public static b a(long j, TbParams tbParams) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-362090378")) {
            return (b) ipChange.ipc$dispatch("-362090378", new Object[]{Long.valueOf(j), tbParams});
        }
        b bVar = a.get(j);
        return bVar == null ? b(tbParams) : bVar;
    }

    public static b b(TbParams tbParams) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "75841770")) {
            return (b) ipChange.ipc$dispatch("75841770", new Object[]{tbParams});
        }
        b bVar = new b(tbParams);
        a.put(bVar.b, bVar);
        return bVar;
    }
}
