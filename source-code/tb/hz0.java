package tb;

import com.taobao.tao.log.logger.ILogger;

/* compiled from: Taobao */
public final /* synthetic */ class hz0 implements Runnable {
    public final /* synthetic */ ILogger a;

    public /* synthetic */ hz0(ILogger iLogger) {
        this.a = iLogger;
    }

    public final void run() {
        this.a.log();
    }
}
