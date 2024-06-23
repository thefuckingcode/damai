package tb;

import com.alibaba.poplayer.layermanager.PopRequest;

/* compiled from: Taobao */
public class er1 {
    public static void a(PopRequest popRequest, PopRequest.Status status) {
        if (popRequest != null && popRequest.i() != status) {
            popRequest.q(status);
            PopRequest.PopRequestStatusCallBack j = popRequest.j();
            if (j != null) {
                if (status == PopRequest.Status.READY) {
                    j.onReady(popRequest);
                } else if (status == PopRequest.Status.SHOWING) {
                    j.onRecovered(popRequest);
                } else if (status == PopRequest.Status.SUSPENDED) {
                    j.onSuspended(popRequest);
                }
            }
        }
    }
}
