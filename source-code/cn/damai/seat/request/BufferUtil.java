package cn.damai.seat.request;

import androidx.annotation.Nullable;
import cn.damai.seat.bean.biz.CompressSeatStatus;
import cn.damai.seat.bean.biz.SeatDynamic;
import cn.damai.tool2.bufferkit.BufferListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import tb.bd;
import tb.cd;
import tb.nv1;

/* compiled from: Taobao */
public class BufferUtil implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;

    public static nv1<SeatDynamic> loadDynamic(long j, long j2, long j3, @Nullable String str, @Nullable String str2, @Nullable String str3, boolean z, BufferListener<SeatDynamic> bufferListener, cd cdVar) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1148480157")) {
            return bd.i(new MtopSeatDynamicRequest(j, j2, j3, str, str2, str3, z), bufferListener, cdVar);
        }
        return (nv1) ipChange.ipc$dispatch("-1148480157", new Object[]{Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), str, str2, str3, Boolean.valueOf(z), bufferListener, cdVar});
    }

    public static nv1<CompressSeatStatus> loadStatus(long j, long j2, long j3, int i, @Nullable String str, @Nullable String str2, BufferListener<CompressSeatStatus> bufferListener, cd cdVar) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "732962919")) {
            return bd.i(new MtopStatusCompressRequest(j, j2, j3, i, str, str2), bufferListener, cdVar);
        }
        return (nv1) ipChange.ipc$dispatch("732962919", new Object[]{Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i), str, str2, bufferListener, cdVar});
    }
}
