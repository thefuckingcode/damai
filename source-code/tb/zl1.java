package tb;

import com.alient.oneservice.ut.TrackInfo;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class zl1 {
    private static transient /* synthetic */ IpChange $ipChange;

    @NotNull
    public static final TrackInfo a(@NotNull TrackInfo trackInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-357438605")) {
            return (TrackInfo) ipChange.ipc$dispatch("-357438605", new Object[]{trackInfo});
        }
        k21.i(trackInfo, "<this>");
        TrackInfo trackInfo2 = new TrackInfo();
        trackInfo2.setSpma(trackInfo.getSpma());
        trackInfo2.setSpmb(trackInfo.getSpmb());
        trackInfo2.setArgs(new HashMap<>());
        trackInfo2.getArgs().put("item_id", trackInfo.getArgs().get("item_id"));
        trackInfo2.getArgs().put("orderid", trackInfo.getArgs().get("orderid"));
        return trackInfo2;
    }
}
