package tb;

import anet.channel.detect.HttpStrategyDetector;
import anet.channel.detect.Ipv6Detector;
import anet.channel.quic.Http3ConnectionDetector;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: Taobao */
public class y60 {
    private static AtomicBoolean a = new AtomicBoolean(false);

    public static void a() {
        if (a.compareAndSet(false, true)) {
            if (ss0.j()) {
                if (h9.r()) {
                    Http3ConnectionDetector.l();
                }
                if (h9.v()) {
                    HttpStrategyDetector.g();
                }
            }
            Ipv6Detector.e();
        }
    }
}
