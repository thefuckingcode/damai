package com.alibaba.pictures.piclocation;

import com.alibaba.pictures.piclocation.listener.LocateGpsPicListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import kotlin.Metadata;
import tb.k21;
import tb.m81;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Ltb/ur2;", "run", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* compiled from: Taobao */
public final class LocateQueueManager$doLocationListenerCallback$1 implements Runnable {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ m81 $info;
    final /* synthetic */ LocateGpsPicListener $listener;

    LocateQueueManager$doLocationListenerCallback$1(m81 m81, LocateGpsPicListener locateGpsPicListener) {
        this.$info = m81;
        this.$listener = locateGpsPicListener;
    }

    public final void run() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "397206519")) {
            ipChange.ipc$dispatch("397206519", new Object[]{this});
            return;
        }
        m81 m81 = this.$info;
        LocationDataStatus locationDataStatus = m81.g;
        if (locationDataStatus == LocationDataStatus.NOTINIT) {
            LocateGpsPicListener locateGpsPicListener = this.$listener;
            k21.f(locationDataStatus);
            int code = locationDataStatus.getCode();
            LocationDataStatus locationDataStatus2 = this.$info.g;
            k21.f(locationDataStatus2);
            locateGpsPicListener.onFailed(code, locationDataStatus2.getDes());
            return;
        }
        this.$listener.onLocationSuccess(m81);
    }
}
